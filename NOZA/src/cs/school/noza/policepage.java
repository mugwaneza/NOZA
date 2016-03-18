package cs.school.noza;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cs.school.noza.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class policepage extends Activity  {
private EditText b, c;
	
	
	String  username;
	String password; 
	Button show ;
	
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse response;

	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	ProgressDialog dialog = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.policepage);
	
		
		
		
		  b = (EditText) findViewById(R.id.username);
		  c = (EditText) findViewById(R.id.password);;

		
		show = (Button)findViewById(R.id.show);
		
		
show.setOnClickListener(new OnClickListener() {
            
            @Override
     		public void onClick(View v) {
            	
            	
            	EditText edittext=(EditText)findViewById(R.id.username);
				if(edittext.getText().length()==0 ) 
				{
				edittext.setError(" field couldn't be empty!");
				}
				EditText edittext1=(EditText)findViewById(R.id.password);
				if (edittext1.getText().length()==0) {
				
					edittext1.setError("field coudn't be empty ");	
				}
				else{
     		

        		dialog = ProgressDialog.show(policepage.this, "", 
                        "Identifying user...", true);
        		dialog.setCancelable(true);
        		 new Thread(new Runnable() {
        			    public void run() {
        			    	login();					      
        			    }
        			  }).start();
				}
     		} });	
               }
	

	void login(){
		
		 int success;
			
			String username=b.getText().toString();
			String password=c.getText().toString();
		
		
		
		try{			
			 
			httpclient=new DefaultHttpClient();
			httppost= new HttpPost("http://10.0.2.2/noza/validatepolice.php"); // make sure the url is correct.
			//add your data
			nameValuePairs = new ArrayList<NameValuePair>(2);
			// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
			
			nameValuePairs.add(new BasicNameValuePair("username",username));  // $Edittext_value = $_POST['Edittext_value'];
			nameValuePairs.add(new BasicNameValuePair("password",password)); 
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			//Execute HTTP Post Request
			response=httpclient.execute(httppost);
			// edited by James from coderzheaven.. from here....
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpclient.execute(httppost, responseHandler);
			System.out.println("Response : " + response); 
			runOnUiThread(new Runnable() {
			    public void run() {

					dialog.dismiss();
			    }
			});
			
			if(response.equalsIgnoreCase("User Found")){
				runOnUiThread(new Runnable() {
				    public void run() {
				    	Toast.makeText(policepage.this,"Login Success", Toast.LENGTH_SHORT).show();
				    }
				});
				
				startActivity(new Intent(policepage.this, showalertpolice.class));
			}else{
				showAlert();				
			}
			
		}catch(Exception e){
			dialog.dismiss();
			System.out.println("Exception : " + e.getMessage());
		}
	}
	public void showAlert(){
		policepage.this.runOnUiThread(new Runnable() {
		    public void run() {
		    	AlertDialog.Builder builder = new AlertDialog.Builder(policepage.this);
		    	builder.setTitle("Login Error.");
		    	builder.setMessage("Invalid user.")  
		    	       .setCancelable(false)
		    	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		    	           public void onClick(DialogInterface dialog, int id) {
		    	           }
		    	       });		    	       
		    	AlertDialog alert = builder.create();
		    	alert.show();		    	
		    }
		});
	}
	}
	
	

