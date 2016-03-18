package com.rgb2.noza;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
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
import cs.school.noza.citizenauthentication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class registerpage extends Activity {
	
	String[] districts = {
			"Bugesera Eastern Province",
			"Gatsibo Eastern Province",
			"Kayonza Eastern Province",
			"Kirehe Eastern Province",
			"Ngoma  Eastern Province",
			"Nyagatare Eastern Province",
			"Rwamagana Eastern Province	",
			"Gasabo Kigali, City",
			"Kicukiro Kigali, City",
			"Nyarugenge Kigali, City",
			"Burera Northern Province",
			"Gakenke Northern Province",
			"Gicumbi Northern Province",
			"Musanze Northern Province",
			"Rulindo Northern Province",
			"Gisagara Southern Province",
			"Huye Southern Province",
			"Kamonyi Southern Province",
			"Muhanga Southern Province",
			"Nyamagabe Southern Province",
			"Nyanza Southern Province",
			"Nyaruguru Southern Province",
			"Ruhango Southern Province",
			"Karongi Western Province",
			"Ngororero Western Province",
			"Nyabihu Western Province",
			"Nyamasheke Western Province",
			"Rubavu Western Province",
			"Rusizi Western Province",
			"Rutsiro Western Province",
			"Mukamira Western Province",
			
	};

	
	

	private String names;
	private String  tel;
	private String age;
	private String gender;
	private String gender2;
	private String  email;
	private String password; 
	private String district; 
	
	
	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	Button send ;
	
	private	EditText a ;
	private	EditText b;
	private	EditText c;
	private	AutoCompleteTextView d;

	private	EditText e;
	private	EditText f;
	private	EditText g;
	
	
	private RadioGroup sexes;
    private RadioButton h;
    private RadioButton j;
	
    

	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse response;

	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	ProgressDialog dialog = null;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registerpage);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		
	// Edit Text
	  a = (EditText) findViewById(R.id.firstname);
	  g= (EditText) findViewById(R.id.editText1);
	  b = (EditText) findViewById(R.id.tel);
	  c = (EditText) findViewById(R.id.age);
	  d = (AutoCompleteTextView) findViewById(R.id.district); 
	  e= (EditText) findViewById(R.id.password);
	 f= (EditText) findViewById(R.id.comfirmpass);
	 
	
	  
  
	  sexes = (RadioGroup)findViewById(R.id.radioGroup1);
	  
	// enable autocompletion
	  
	  ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, 
      		android.R.layout.simple_dropdown_item_1line,districts);
	  
	  d.setThreshold(2);
      d.setAdapter(adapter);
	  
	  // radio button
	  
      
      
      
      	
	// Create button
			Button send = (Button)findViewById(R.id.register);
			 send.setOnClickListener(new View.OnClickListener() {
				
			@Override
			public void onClick(View v) {
				
				

				 String naming =a.getText().toString();
                String calling =b.getText().toString();
                String ages= c.getText().toString();
                String region= d.getText().toString();
                  String passwording=e.getText().toString();
                   String comfirmingpassword=f.getText().toString();
               
               
                // check if any of the fields are vaccant
                if(naming.equals("")||calling.equals("")||ages.equals("")||region.equals("")||passwording.equals("")
               		 ||comfirmingpassword.equals(""))
                {
                        Toast.makeText(getApplicationContext(), "field can not be empty", Toast.LENGTH_LONG).show();
                        return;
                }
                
                //validate checkbox
                  
                // check if both password matches
                else if(!passwording.equals(comfirmingpassword))
                    {
                    Toast.makeText(getApplicationContext(), "Password Does Not Matches", Toast.LENGTH_LONG).show();
                    return;
                }
               
                else if(sexes.getCheckedRadioButtonId()==-1) {    
         			 Toast.makeText(getApplicationContext(), "select yr gender", Toast.LENGTH_LONG).show();
                    return ;
         		}
                email =g.getText().toString();
                if (!isValidEmail(email)) {
						g.setError("That Email doesn't exist");
					}
					else{

				
				
				dialog = ProgressDialog.show(registerpage.this, "", 
		                "please wait registration...", true);
				dialog.setCancelable(true);
				 new Thread(new Runnable() {
					    public void run() {
					    	insert();	
					    	
					    }

						
					  }).start();				
					}
				}
		}); 
			 
	}
 void insert()
{ 
	

		String names= a.getText().toString();
		String tel= b.getText().toString();

		String age= c.getText().toString();
		String district= d.getText().toString();
	
	

		String password= e.getText().toString();
		
		String email = g.getText().toString();
		
	
		String gender=  ((RadioButton)this.findViewById(sexes.getCheckedRadioButtonId())).getText().toString();
	
	
	try{			
		 
		httpclient=new DefaultHttpClient();
		httppost= new HttpPost("http://www.ndanoza.com/noza/registerme.php"); // make sure the url is correct.
		//add your data
		nameValuePairs = new ArrayList<NameValuePair>(2);
		// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
		
		
		nameValuePairs.add(new BasicNameValuePair("names",names)); // $Edittext_value = $_POST['Edittext_value'];                                                            
		nameValuePairs.add(new BasicNameValuePair("tel",tel)); 
		nameValuePairs.add(new BasicNameValuePair("email",email)); // $Edittext_value = $_POST['Edittext_value'];                                                            
		nameValuePairs.add(new BasicNameValuePair("age",age)); 
		nameValuePairs.add(new BasicNameValuePair("district",district)); // $Edittext_value = $_POST['Edittext_value'];                                                            
		nameValuePairs.add(new BasicNameValuePair("password",password)); 
		
		nameValuePairs.add(new BasicNameValuePair("email",email)); // $Edittext_value = $_POST['Edittext_value'];                                                            
		nameValuePairs.add(new BasicNameValuePair("password",password)); 
		nameValuePairs.add(new BasicNameValuePair("gender",gender)); // $Edittext_value = $_POST['Edittext_value'];                                                            
		
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
		
		if(response==response){
			runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(registerpage.this,"successfully registered", Toast.LENGTH_SHORT).show();
			    }
			});
			
			startActivity(new Intent(registerpage.this, citizenauthentication.class));
		}else{
			showAlert();				
		}
		
	}catch(Exception e){
		dialog.dismiss();
		System.out.println("Exception : " + e.getMessage());
	}
}
public void showAlert(){
	registerpage.this.runOnUiThread(new Runnable() {
	    public void run() {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(registerpage.this);
	    	builder.setTitle("registration error Error.");
	    	builder.setMessage("the user is already there !.")  
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


//validating email id
		private boolean isValidEmail(String email) {
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}


}

