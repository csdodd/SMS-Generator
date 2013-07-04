package net.colindodd.smsgenerator.thread;

import net.colindodd.smsgenerator.messaging.MessageTask;
import android.os.AsyncTask;

public class GenerateMessagesTask extends AsyncTask<MessageTask, Void, Void> {
	
	private OnTaskCompleted listener;
	
	public GenerateMessagesTask setOnTaskCompletedListener(OnTaskCompleted listener) {
		this.listener = listener;
		return this;
	}
	
	@Override
	protected Void doInBackground(MessageTask... params) {
	      params[0].generateRandomMessages();
	      return null;
	}
	
	@Override
	protected void onPostExecute(Void nothing){
		if(listener != null) {
			listener.onTaskCompleted();
		}
    }
}

