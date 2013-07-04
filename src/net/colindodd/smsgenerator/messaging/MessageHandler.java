package net.colindodd.smsgenerator.messaging;

import net.colindodd.smsgenerator.data.Messages;
import net.colindodd.smsgenerator.data.People;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

public class MessageHandler {
	
	public void generateRandomMessages(int numberToGenerate, ContentResolver contentResolver) {
		for(int i = 0; i < numberToGenerate; i++) {
			generateMessage(People.getRandomPerson(), Messages.getRandomMessage(), contentResolver);
		}
	}
	
	private void generateMessage(String sender, String body, ContentResolver contentResolver) {
		ContentValues values = new ContentValues();
	    values.put("address", sender);
	    values.put("body", body);
	    contentResolver.insert(Uri.parse("content://sms/inbox"), values);
	}
}
