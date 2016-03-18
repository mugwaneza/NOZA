package cs.school.noza;

import cs.school.noza.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateNotification extends Activity  {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_noti);
		
	}

	rgbpage n=new rgbpage();
	  public void createNotification(View view) {
	    // Prepare intent which is triggered if the
	    // notification is selected
		  
	    Intent intent = new Intent(this, rgbpage.class);
	    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

	    // Build notification
	    // Actions are just fake
	    Notification noti = new Notification.Builder(this)
	        .setContentTitle("notif.. Alert to rgb..")
	        .setContentText("").setSmallIcon(R.drawable.ico)
	        .setContentIntent(pIntent)
	        //.addAction(R.drawable.ico, "Call", pIntent)
	        //.addAction(R.drawable.ico, "More", pIntent)
	        //.addAction(R.drawable.ico, "And more", pIntent)
	        .build()
	        ;
	    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	    // hide the notification after its selected
	    noti.flags |= Notification.FLAG_AUTO_CANCEL;

	    notificationManager.notify(0, noti);
	    
	

}}


