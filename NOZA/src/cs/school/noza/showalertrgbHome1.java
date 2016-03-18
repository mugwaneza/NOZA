package cs.school.noza;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cs.school.noza.R;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.   graphics.   Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
public class showalertrgbHome1 extends Activity {
   
	ImageView services,corruption,inquiry,ideas;
	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showalertrgb);
		
		services=(ImageView)findViewById(R.id.imageView1);
		corruption=(ImageView)findViewById(R.id.imageView6);
		inquiry=(ImageView)findViewById(R.id.imageView2);
		ideas=(ImageView)findViewById(R.id.imageView3);
		
		
services.setOnClickListener(new OnClickListener() {
		    
		    @Override
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Showalertrgb1A.class);
			    	    startActivity(intent);

				} });

corruption.setOnClickListener(new OnClickListener() {
    
    @Override
		public void onClick(View v) {
		
			 Intent intent = new Intent(getApplicationContext(),Showalertrgb1B.class);
	    	    startActivity(intent);

		} });

inquiry.setOnClickListener(new OnClickListener() {
    
    @Override
		public void onClick(View v) {
		
			 Intent intent = new Intent(getApplicationContext(),Showalertrgb1C.class);
	    	    startActivity(intent);

		} });
		
		
		ideas.setOnClickListener(new OnClickListener() {
		    
		    @Override
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),citizencomments.class);
			    	    startActivity(intent);

				} });
		
	}


    }
    
    
	  