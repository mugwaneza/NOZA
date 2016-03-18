package cs.school.noza;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cs.school.noza.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
public class retrieve_feedback extends ArrayAdapter<Application>{
	
	    private List<Application> items;
	     
	    public retrieve_feedback(Context context, List<Application> items) {
	        super(context, R.layout.retrieve_feedback, items);
	        this.items = items;
	    }
	    @Override
	    public int getCount() {
	        return items.size();
	    }
	     
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View v = convertView;
	         
	        if(v == null) 
	        {
	            LayoutInflater li = LayoutInflater.from(getContext());
	            v = li.inflate(R.layout.retrieve_feedback, null);
	        }         
	        Application app = items.get(position);
	        if(app != null) {
	            TextView id = (TextView)v.findViewById(R.id.id);
	            TextView head = (TextView)v.findViewById(R.id.head);
	            TextView who = (TextView)v.findViewById(R.id.who);
	            TextView message = (TextView)v.findViewById(R.id.message);
	            
	          
	            
	            if(id!=null)
	            	id.setText(app.getId());
	            
	           if(head!=null)
	            	head.setText(app.getHead());
	            
	            if(who!=null)
	            	who.setText(app.getWho());
	            
	            if(message != null) 
	            message.setText(app.getMessage());
	            
	            
	           
	            } 
	        
	        return v;
	    }
}