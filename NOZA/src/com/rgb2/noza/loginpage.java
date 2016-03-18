package com.rgb2.noza;



import java.util.ArrayList;
import java.util.Arrays;
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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;

import cs.school.noza.CitizenPage;
import cs.school.noza.MainActivity;
import cs.school.noza.R;

public class loginpage extends Activity {
	


	private EditText b, c ,d;
	
	String  tel;
	String password; 
	String email;
	
	
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse response;

	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	ProgressDialog dialog = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);
		
		 
		  c = (EditText) findViewById(R.id.password);;
		  d = (EditText) findViewById(R.id.tel);
		  b = (EditText) findViewById(R.id.tel);

  
		  
Button login =(Button)findViewById(R.id.login2)	;	




login.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		
		
		String passwording=c.getText().toString();
        String calling= d.getText().toString();
     // check if any of the fields are vaccant
     if(calling.equals("")||passwording.equals(""))
     {
             Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_LONG).show();
             return;
     }
		
     else{
    	 
	
		dialog = ProgressDialog.show(loginpage.this, "", 
                "checking account...", true);
		 new Thread(new Runnable() {
			    public void run() {
			    	
			    	
			    	login();
			    	
			    	
			    }
			  }).start();				
     }
		}
     }); 

	}

	void login(){

			String password= c.getText().toString();
			String tel=   d.getText().toString();
			String email= b.getText().toString();
			
		
		
		
		try{			
			 
			httpclient=new DefaultHttpClient();
			httppost= new HttpPost("http://www.ndanoza.com/noza/check.php"); // make sure the url is correct.
			//add your data
			nameValuePairs = new ArrayList<NameValuePair>(2);
			// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
			nameValuePairs.add(new BasicNameValuePair("password",password)); 
			nameValuePairs.add(new BasicNameValuePair("tel",tel));
			nameValuePairs.add(new BasicNameValuePair("email",email)); // $Edittext_value = $_POST['Edittext_value'];                                                            
			
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
				    	Toast.makeText(loginpage.this,"Login Success", Toast.LENGTH_SHORT).show();
				    }
				});
				
				startActivity(new Intent(loginpage.this, MainActivity.class));
			}else{
				showAlert();				
			}
			
		}catch(Exception e){
			dialog.dismiss();
			System.out.println("Exception : " + e.getMessage());
		}
	}
	public void showAlert(){
		loginpage.this.runOnUiThread(new Runnable() {
		    public void run() {
		    	AlertDialog.Builder builder = new AlertDialog.Builder(loginpage.this);
		    	builder.setTitle("Login Error.");
		    	builder.setMessage("invalid user !.")  
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
	
	
	

