package net.colindodd.smsgenerator.messaging;

import net.colindodd.smsgenerator.data.Messages;
import net.colindodd.smsgenerator.data.People;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

public class MessageHandler {
	
	public void generateRandomMessages(int numberToGenerate, ContentResolver contentResolver) {
		for(int i = 0; i < numberToGenerate; i++) {
			generateInboxMessage(People.getRandomPerson(), Messages.getRandomMessage(), contentResolver);
			generateOutboxMessage(People.getRandomPerson(), Messages.getRandomMessage(), contentResolver);
		}
	}
	
	private void generateInboxMessage(String person, String message, ContentResolver contentResolver) {
		generateMessage(person, message, contentResolver, Uri.parse("content://sms/inbox"));
	}

	private void generateOutboxMessage(String person, String message, ContentResolver contentResolver) {
		generateMessage(person, message, contentResolver, Uri.parse("content://sms/sent"));
	}

	private void generateMessage(String sender, String body, ContentResolver contentResolver, Uri uri) {
		ContentValues values = new ContentValues();
	    values.put("address", sender);
	    values.put("body", body);
	    contentResolver.insert(uri, values);
	}
}
