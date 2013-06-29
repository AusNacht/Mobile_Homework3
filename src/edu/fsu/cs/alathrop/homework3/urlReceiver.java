package edu.fsu.cs.alathrop.homework3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;



public class urlReceiver extends BroadcastReceiver {

	private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		
		if(intent.getAction().equals(SMS_RECEIVED)){ //code partially taken from http://stackoverflow.com/questions/4117701/android-sms-broadcast-receiver
			Bundle bundle = intent.getExtras();
			if(bundle != null){
				Object[] pdus = (Object[])bundle.get("pdus");
				final SmsMessage[] messages = new SmsMessage[pdus.length];
				for(int i = 0; i < pdus.length; i++){
					messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				}
				if(messages.length > -1){
					/*
					Intent myIntent = new Intent(context, MainActivity.class);
					myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					Bundle extras = new Bundle();
					extras.putString("newUrl", messages[0].getMessageBody());
					myIntent.putExtras(extras);					
					context.startActivity(myIntent);
					*/
					
					Intent local = new Intent();
					local.setAction("ed.fsu.cs.alathrop.broadcast_load");
					Bundle extras = new Bundle();
					extras.putString("newUrl", messages[0].getMessageBody());
					local.putExtras(extras);	
					context.sendBroadcast(local);
				}
			}
		}
	}

}
