package net.colindodd.smsgenerator.messaging;

import android.content.ContentResolver;

public class MessageTask {

	private int numMessagesToGenerate;
	private ContentResolver contentResolver;
	
	public MessageTask( int numMessagesToGenerate) {
		this.numMessagesToGenerate = numMessagesToGenerate;
	}
	
	public MessageTask setContentResolver(ContentResolver contentResolver) {
		this.contentResolver = contentResolver;
		return this;
	}
	
	private void checkContentResolverIsSet() {
		if(contentResolver == null) {
			throw new IllegalStateException("ContentResolver has not been set via setContentResolver(ContentResolver)");
		}
	}
	
	public void generateRandomMessages() {
		checkContentResolverIsSet();
		new MessageHandler().generateRandomMessages(numMessagesToGenerate, contentResolver);
	}
}
