package cs.school.noza;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editdatabase extends Activity{
	
	
	EditText Location,Date,Time,Reason,Institution,Description ;
	Button btnSave;
	
	
	    String location ;
		String time ;
		String date;
		String why;
		String RGBinstitution;
		String text;
		InputStream is=null;
		String result=null;
		String line=null;
		int code;
		
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editdatabase);
		
		
		// Permission StrictMode
	
		if (android.os.Build.VERSION.SDK_INT > 9) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);}
	
		// save button
				          btnSave = (Button) findViewById(R.id.forwardbtn);
				            
				          
		                    Location = (EditText) findViewById(R.id.location);
							Date = (EditText) findViewById(R.id.date);
							Time = (EditText) findViewById(R.id.time);
							Reason = (EditText) findViewById(R.id.why);
							Institution = (EditText) findViewById(R.id.RGBinstitution);
							Description = (EditText) findViewById(R.id.text);
							
							
							
							btnSave .setOnClickListener(new OnClickListener() {
									
								@Override
								public void onClick(View view) {
									
									
									 String locating =Location.getText().toString();
					                 String textdating =Date.getText().toString();
					                 String texttiming=Time.getText().toString();
					                 String ideology= Reason.getText().toString();
					                 String institute= Institution.getText().toString();
					                 String describing= Description.getText().toString();
					                 
									
									
									 // check if any of the fields are vaccant
					                if(locating.equals("")||textdating.equals("")||texttiming.equals("")||ideology.equals("")||institute.equals("")||describing.equals(""))
					                {
					                        Toast.makeText(getApplicationContext(), "field can not be empty", Toast.LENGTH_LONG).show();
					                        return;
					                }
					               
					                
					                else{
					                	
									// TODO Auto-generated method stub
						                 insert();
						                 createNotification(view);
					                }
					         		} });}
	
	 public void insert(){
		 

		    text=Description.getText().toString();	
			location=Location.getText().toString();
			time = Time.getText().toString();
			date = Date.getText().toString();
			why = Reason.getText().toString();
			RGBinstitution = Institution.getText().toString();
		 

			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			
			nameValuePairs.add(new BasicNameValuePair("text",text));
			nameValuePairs.add(new BasicNameValuePair("location",location));
			nameValuePairs.add(new BasicNameValuePair("time",time));
			nameValuePairs.add(new BasicNameValuePair("date",date));
			nameValuePairs.add(new BasicNameValuePair("why",why));
			nameValuePairs.add(new BasicNameValuePair("RGBinstitution",RGBinstitution));
			
			
			
			try
			{
				
				HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://10.0.2.2/noza/emergencyAlert.php");
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost); 
		        HttpEntity entity = response.getEntity();
		        is = entity.getContent();
		        Log.e("pass 1", "connection success ");
		       
		        
				
				  
		        
		       
		}
		    catch(Exception e)
		{
		    	Log.e("Fail 1", e.toString());
		    	Toast.makeText(getApplicationContext(), " Thank you !",
				Toast.LENGTH_LONG).show();
		    	Intent i =new Intent(getApplicationContext(),MainActivity.class);
		    	startActivity (i);
		}     

		try
		{

		  
		    
		    BufferedReader reader = new BufferedReader
			(new InputStreamReader(is,"iso-8859-1"),8);
		    StringBuilder sb = new StringBuilder();
		   
		    
		    while ((line = reader.readLine()) != null)
		{
		        sb.append(line + "\n");
		    }
		    is.close();
		   
		Log.e("pass 2", "connection success ");
		}
		
		catch(Exception e)
		{
			
			Log.e("Fail 2", e.toString());
		}     
	
	 }
	 
	//end of google places autocomplete
		
			CreateNotification n=new CreateNotification();
			 public void createNotification(View view) {
				    // Prepare intent which is triggered if the
				    // notification is selected
					  
				    Intent intent = new Intent(this, policepage.class);
				    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

				    // Build notification
				    // Actions are just fake
				    Notification noti = new Notification.Builder(this)
				        .setContentTitle("notif.. alert to police ..")
				        .setContentText("").setSmallIcon(R.drawable.notif)
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
				    
			 }
			

}