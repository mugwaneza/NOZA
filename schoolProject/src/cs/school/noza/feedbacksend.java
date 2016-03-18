package cs.school.noza;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class feedbacksend extends Activity{
	
    String head ;
	String who ;
	String message;
	
	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	

	Button send;
	EditText title, tel,secret;
	
   
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedbacksend);
	    
		title= (EditText) findViewById(R.id.head);
		tel = (EditText) findViewById(R.id.who);
	    secret = (EditText) findViewById(R.id.message);
	    
		send = (Button) findViewById(R.id.respond);
		
		
		
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}	
		
		send.setOnClickListener(new OnClickListener() {
				
			
				
			@Override
			public void onClick(View view) {

				 String titling =title.getText().toString();
                String telling =tel.getText().toString();
                String messaging=secret.getText().toString();
               
				
				
				 // check if any of the fields are vaccant
               if(titling.equals("")||telling.equals("")||messaging.equals(""))
               {
                       Toast.makeText(getApplicationContext(), "field can not be empty", Toast.LENGTH_LONG).show();
                       return;
               }
               
               
               
               else{
               	
				// TODO Auto-generated method stub
	                 insert();
               }
        		} });
   }
	
			 public void insert(){
				 

				   head=title.getText().toString();	
					who=tel.getText().toString();
					message = secret.getText().toString();
					

					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					
					nameValuePairs.add(new BasicNameValuePair("head",head));
					nameValuePairs.add(new BasicNameValuePair("who",who));
					nameValuePairs.add(new BasicNameValuePair("message",message));
					
					
					
					
					try
					{
						
						HttpClient httpclient = new DefaultHttpClient();
				        HttpPost httppost = new HttpPost("http://10.0.2.2/noza/feedback_send.php");
				        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				        HttpResponse response = httpclient.execute(httppost); 
				        HttpEntity entity = response.getEntity();
				        is = entity.getContent();
				        Log.e("pass 1", "connection success ");
				       
				        
						
						  
				        
				       
				}
				    catch(Exception e)
				{
				    	Log.e("Fail 1", e.toString());
				    	Toast.makeText(getApplicationContext(), " sent !",
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

			
}