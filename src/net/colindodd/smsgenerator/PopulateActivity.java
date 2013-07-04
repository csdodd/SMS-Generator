package net.colindodd.smsgenerator;

import net.colindodd.smsgenerator.helper.Helper;
import net.colindodd.smsgenerator.messaging.MessageTask;
import net.colindodd.smsgenerator.thread.GenerateMessagesTask;
import net.colindodd.smsgenerator.thread.OnTaskCompleted;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class PopulateActivity extends Activity implements OnTaskCompleted  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_populate);
		createButtonListener();
	}
	
	private void createButtonListener() {
		Button btnGenerate = (Button)findViewById(R.id.btnGenerate);
		btnGenerate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				handleBtnGenerateClick();
			}
		});
	}
	
	private void handleBtnGenerateClick() {
		blockUi();
		executeMessagingTask();
	}
	
	private void executeMessagingTask() {
		MessageTask messageTask = new MessageTask(getNumberOfMessagesToGenerate()).setContentResolver(getContentResolver());
		new GenerateMessagesTask().setOnTaskCompletedListener(this).execute(messageTask);
	}
	
	private int getNumberOfMessagesToGenerate() {
		TextView tv = (TextView)findViewById(R.id.numToGenerate);
		return Helper.safeParseString(tv.getText().toString());
	}

	@Override
	public void onTaskCompleted() {
		unblockUi();
		displayToast();
	}
	
	private void blockUi() {
		toggleVisibilities(false, ProgressBar.VISIBLE);
	}
	
	private void unblockUi() {
		toggleVisibilities(true, ProgressBar.INVISIBLE);
	}
	
	private void toggleVisibilities(boolean uiElementsEnabled, int spinnerVisibility) {
		findViewById(R.id.btnGenerate).setEnabled(uiElementsEnabled);
		findViewById(R.id.numToGenerate).setEnabled(uiElementsEnabled);
		findViewById(R.id.threadRunning).setVisibility(spinnerVisibility);
	}
	
	private void displayToast() {
		Toast.makeText(this, R.string.success_toast, Toast.LENGTH_SHORT).show();
	}
}
