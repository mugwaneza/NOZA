package cs.school.noza;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;

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

import com.rgb2.noza.registerpage;

import cs.school.noza.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class CitizenPage extends Activity implements OnClickListener {
	
	PlacesTask placesTask;
	ParserTask parserTask;

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
	Button send ;
	

	ImageButton button2, btnTimePicker;
	EditText txtDate, txtTime,idea,usertext;
	AutoCompleteTextView auto;
    private Spinner reason,institution;
	private int mYear, mMonth, mDay, mHour, mMinute;
	
	
	HttpPost httppost;
	StringBuffer buffer;
	HttpResponse response;

	HttpClient httpclient;
	List<NameValuePair> nameValuePairs;
	ProgressDialog dialog = null;
    
	
    Button submit;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.citizen_page);
		
		
		reason= (Spinner) findViewById(R.id.reason);
		institution= (Spinner) findViewById(R.id.institution);
		
	    auto= (AutoCompleteTextView) findViewById(R.id.location);
	    auto.setThreshold(1);	
	    
	    
		txtDate = (EditText) findViewById(R.id.txtDate);
		txtTime = (EditText) findViewById(R.id.txtTime);
	    usertext = (EditText) findViewById(R.id.idea);
		
		
		
		
		button2 = (ImageButton) findViewById(R.id.button2);
		btnTimePicker = (ImageButton) findViewById(R.id.time);
		submit = (Button) findViewById(R.id.alert);
	
       
		button2.setOnClickListener(this);
		btnTimePicker.setOnClickListener(this);
		submit.setOnClickListener(this);  
		
		addListenerOnSpinnerItemSelection();
		addItemsOnInstitution();
		
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		

		auto.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {				
				placesTask = new PlacesTask();				
				placesTask.execute(s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub				
			}
		});	
		
		
		
		
		submit.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View view) {
				
				
				
				String locating =auto.getText().toString();
                String textdating =txtDate.getText().toString();
                String texttiming=txtTime.getText().toString();
                String ideology= usertext.getText().toString();
                
				
				
				 // check if any of the fields are vaccant
               if(locating.equals("")||textdating.equals("")||texttiming.equals("")||ideology.equals(""))
               {
                       Toast.makeText(getApplicationContext(), "field can not be empty", Toast.LENGTH_LONG).show();
                       return;
               }
               
               else  if(institution.getSelectedItemPosition()==0){
                   Toast.makeText(getApplicationContext(),"Please select instution",0).show();
                 return;
               }
             
               else  if(reason.getSelectedItemPosition()==0){
               		
                   Toast.makeText(getApplicationContext(),"Please select yr Reason",0).show();
                 return;
               }
               
               else{

				
				
				
				

				dialog = ProgressDialog.show(CitizenPage.this, "", 
		                "please wait sending alert...", true);
				dialog.setCancelable(true);
				 new Thread(new Runnable() {
					    public void run() {
					    	insert();	
					    	
					    }

						
					  }).start();			
               }
              
         		} });
    }
	
			 public void insert(){
				 
				    String text=usertext.getText().toString();	
				    String location=auto.getText().toString();
				    String time = txtTime.getText().toString();
				    String date = txtDate.getText().toString();
				    String why = reason.getSelectedItem().toString();           		
				    String RGBinstitution = institution.getSelectedItem().toString();
				try{			
					 
					httpclient=new DefaultHttpClient();
					httppost= new HttpPost("http://www.ndanoza.com/noza/citizenpage.php"); // make sure the url is correct.
					//add your data
					nameValuePairs = new ArrayList<NameValuePair>(2);
					// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
					
					
					nameValuePairs.add(new BasicNameValuePair("text",text)); // $Edittext_value = $_POST['Edittext_value'];                                                            
					nameValuePairs.add(new BasicNameValuePair("location",location)); 
					nameValuePairs.add(new BasicNameValuePair("time",time)); // $Edittext_value = $_POST['Edittext_value'];                                                            
					nameValuePairs.add(new BasicNameValuePair("date",date)); 
					nameValuePairs.add(new BasicNameValuePair("why",why));
					nameValuePairs.add(new BasicNameValuePair("RGBinstitution",RGBinstitution));
					
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
						    	Toast.makeText(CitizenPage.this,"Thank you !", Toast.LENGTH_SHORT).show();
						    }
						});
						
						startActivity(new Intent(CitizenPage.this, MainActivity.class));
					}else{
						showAlert();				
					}
					
				}catch(Exception e){
					dialog.dismiss();
					System.out.println("Exception : " + e.getMessage());
				}
			}
			public void showAlert(){
				CitizenPage.this.runOnUiThread(new Runnable() {
				    public void run() {
				    	AlertDialog.Builder builder = new AlertDialog.Builder(CitizenPage.this);
				    	builder.setTitle("report error .");
				    	builder.setMessage("system error !.")  
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
		@Override
		public void onClick(View v) {

		if (v == button2) {

		// Process to get Current Date
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// Launch Date Picker Dialog
		DatePickerDialog dpd = new DatePickerDialog(this,
		new DatePickerDialog.OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year,
		int monthOfYear, int dayOfMonth) {
		// Display Selected date in textbox
		txtDate.setText(dayOfMonth + "-"
		+ (monthOfYear + 1) + "-" + year);

		}
		}, mYear, mMonth, mDay);
		dpd.show();
		}
		if (v == btnTimePicker) {

		// Process to get Current Time
		final Calendar c = Calendar.getInstance();
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);

		// Launch Time Picker Dialog
		TimePickerDialog tpd = new TimePickerDialog(this,
		new TimePickerDialog.OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay,
		int minute) {
		// Display Selected time in textbox
		txtTime.setText(hourOfDay + ":" + minute);
		}
		}, mHour, mMinute, false);
		tpd.show();
		}
		
	}
		
		private void addListenerOnSpinnerItemSelection(){
			

			List<String> list= new ArrayList<String>();
			list.add("None selected");
			list.add("Poor service");
			list.add("Corruption");
			list.add("Inquiry");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				     android.R.layout.simple_spinner_item, list);
					
					dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				reason.setAdapter(dataAdapter);
				
		
		}
		
		private void addItemsOnInstitution() {
			
			List<String>list= new ArrayList<String>();
			list.add("None selected");
			list.add("Districts");
			list.add("Ministries");
			list.add("Security ");
			list.add("Education");
			list.add("Health");
			list.add("Lawyers");
			list.add("Gov agencies");
			
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		     android.R.layout.simple_spinner_item, list);
			
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			institution.setAdapter(dataAdapter);
		
		}
		
		
		//google places
		
		/** A method to download json data from url */
	    private String downloadUrl(String strUrl) throws IOException{
	        String data = "";
	        InputStream iStream = null;
	        HttpURLConnection urlConnection = null;
	        try{
	                URL url = new URL(strUrl);                

	                // Creating an http connection to communicate with url 
	                urlConnection = (HttpURLConnection) url.openConnection();

	                // Connecting to url 
	                urlConnection.connect();

	                // Reading data from url 
	                iStream = urlConnection.getInputStream();

	                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

	                StringBuffer sb  = new StringBuffer();

	                String line = "";
	                while( ( line = br.readLine())  != null){
	                        sb.append(line);
	                }
	                
	                data = sb.toString();

	                br.close();

	        }catch(Exception e){
	                Log.d("Exception while downloading url", e.toString());
	        }finally{
	                iStream.close();
	                urlConnection.disconnect();
	        }
	        return data;
	     }	
		
		// Fetches all places from GooglePlaces AutoComplete Web Service
		private class PlacesTask extends AsyncTask<String, Void, String>{

			@Override
			protected String doInBackground(String... place) {
				// For storing data from web service
				String data = "";
				
				// Obtain browser key from https://code.google.com/apis/console
				String key = "key=AIzaSyAdbSkKv62V0DK3w-v2sLOdOX08wv7ZHJo";
				
				String input="2";
				
				try {
					input = "input=" + URLEncoder.encode(place[0], "utf-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}		
				
				
				// place type to be searched
				String types = "types=geocode";
				
				// Sensor enabled
				String sensor = "sensor=false";			
				
				// Building the parameters to the web service
				String parameters = input+"&"+types+"&"+sensor+"&"+key;
				
				// Output format
				String output = "json";
				
				// Building the url to the web service
				String url = "https://maps.googleapis.com/maps/api/place/autocomplete/"+output+"?"+parameters;
		
				try{
					// Fetching the data from web service in background
					data = downloadUrl(url);
				}catch(Exception e){
	                Log.d("Background Task",e.toString());
				}
				return data;		
			}
			
			@Override
			protected void onPostExecute(String result) {			
				super.onPostExecute(result);
				
				// Creating ParserTask
				parserTask = new ParserTask();
				
				// Starting Parsing the JSON string returned by Web Service
				parserTask.execute(result);
			}		
		}
		
		
		/** A class to parse the Google Places in JSON format */
	    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String,String>>>{

	    	JSONObject jObject;
	    	
			@Override
			protected List<HashMap<String, String>> doInBackground(String... jsonData) {			
				
				List<HashMap<String, String>> places = null;
				
	            PlaceJSONParser placeJsonParser = new PlaceJSONParser();
	            
	            try{
	            	jObject = new JSONObject(jsonData[0]);
	            	
	            	// Getting the parsed data as a List construct
	            	places = placeJsonParser.parse(jObject);

	            }catch(Exception e){
	            	Log.d("Exception",e.toString());
	            }
	            return places;
			}
			
			@Override
			protected void onPostExecute(List<HashMap<String, String>> result) {			
				
					String[] from = new String[] { "description"};
					int[] to = new int[] { android.R.id.text1 };
					
					// Creating a SimpleAdapter for the AutoCompleteTextView			
					SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), result, android.R.layout.simple_list_item_1, from, to);				
					
					// Setting the adapter
					auto.setAdapter(adapter);
			}			
	    }    
	    
		
		
			    
		 }
		

