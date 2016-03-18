package cs.school.noza;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class Showalertrgb1C  extends Activity {
	
	String data = "";
    TableLayout tl;
    TableRow tr;
    TextView label;
    ProgressDialog dialog = null;
    private static final String TAG_ID = "identity";
    
	/** Called when the activity is first created. */
	 
	@Override
	 
	public void onCreate(Bundle savedInstanceState) {
	 
	super.onCreate(savedInstanceState);
	 
	setContentView(R.layout.showalertrgb1);
	

	
	
	if (android.os.Build.VERSION.SDK_INT > 9) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
StrictMode.setThreadPolicy(policy);
}
	
	
	 tl = (TableLayout) findViewById(R.id.maintable);
        final GetDataFromDB1C getdb = new GetDataFromDB1C();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDB();
                System.out.println(data);
                 
                runOnUiThread(new Runnable() {
                     
                    @Override
                    public void run() {
                        ArrayList<Users> citizens = parseJSON(data);
                        addData(citizens);                     
                    }
                });
                 
            }
        }).start();
        
        registerForContextMenu(tl);
    }
 
    public ArrayList<Users> parseJSON(String result) {
        ArrayList<Users>citizens = new ArrayList<Users>();
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users user = new Users();
                
                user.setidentity(json_data.getString("identity"));
                user.setlocation(json_data.getString("location"));
                user.setdate(json_data.getString("date"));
                user.settime(json_data.getString("time"));
                user.setwhy(json_data.getString("why"));
                user.setRGBinstitution(json_data.getString("RGBinstitution"));
                user.settext(json_data.getString("text"));
               citizens.add(user);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());  
     
           Showalertrgb1C.this.runOnUiThread(new Runnable() {
    		    public void run() {
    		    	AlertDialog.Builder builder = new AlertDialog.Builder(Showalertrgb1C.this);
    		    	builder.setTitle("finder warning.");
    		    	builder.setMessage("Oops no question!")  
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
        return citizens;
    }
    
    void addHeader(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        
        
       
        /** Creating a TextView to add to the row **/
        label = new TextView(this);
        label.setText("Id");
        label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        label.setPadding(5, 5, 5, 5);
        label.setBackgroundColor(Color.RED);
        LinearLayout Ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(label,params);
        tr.addView((View)Ll); // Adding textView to tablerow.
        
        /** Creating Qty Button **/
        TextView location = new TextView(this);
       location.setText("Location");
       location.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
       location.setPadding(5, 5, 5, 5);
       location.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(location,params);
        tr.addView((View)Ll); // Adding textview to tablerow.
        
        
 
        /** Creating Qty Button **/
        TextView calendar = new TextView(this);
        calendar.setText("Date");
        calendar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        calendar.setPadding(5, 5, 5, 5);
        calendar.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(calendar,params);
        tr.addView((View)Ll); // Adding textview to tablerow.
        
        

        /** Creating Qty Button **/
        TextView hour = new TextView(this);
        hour.setText("Hour");
        hour.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        hour.setPadding(5, 5, 5, 5);
        hour.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(hour,params);
        tr.addView((View)Ll); // Adding textview to tablerow
        
        

        /** Creating Qty Button **/
        TextView reason = new TextView(this);
        reason.setText("Reason");
        reason.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        reason.setPadding(5, 5, 5, 5);
        reason.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(reason,params);
        tr.addView((View)Ll); // Adding textview to tablerow
        
        

        /** Creating Qty Button **/
        TextView institution = new TextView(this);
        institution.setText("Institution");
        institution.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        institution.setPadding(5, 5, 5, 5);
        institution.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(institution,params);
        tr.addView((View)Ll); // Adding textview to tablerow
        
        

        /** Creating Qty Button **/
        TextView description = new TextView(this);
        description.setText("Description");
        description.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        description.setPadding(5, 5, 5, 5);
        description.setBackgroundColor(Color.RED);
        Ll = new LinearLayout(this);
        params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(description,params);
        tr.addView((View)Ll); // Adding textview to tablerow
        
      
        
 
         // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }
     
    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Users> citizens) {
 
        addHeader();
         
        for (Iterator i = citizens.iterator(); i.hasNext();) {
 
            Users p = (Users) i.next();
 
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
 
            /** Creating a TextView to add to the row **/
            label = new TextView(this);
            label.setText(p.getidentity());
            label.setId(p.getId());
            label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            label.setPadding(5, 5, 5, 5);
            label.setBackgroundColor(Color.GRAY);
            LinearLayout Ll = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(label,params);
            tr.addView((View)Ll); // Adding textView to tablerow.
            
            
            /** Creating Qty Button **/
            TextView location = new TextView(this);
            location.setText(p.getlocation());
            location.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            location.setPadding(5, 5, 5, 5);
            location.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(location,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
 
         
 
            /** Creating Qty Button **/
            TextView calendar = new TextView(this);
            calendar.setText(p.getdate());
            calendar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
             calendar.setPadding(5, 5, 5, 5);
             calendar.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(calendar,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
 
            /** Creating Qty Button **/
            TextView hour = new TextView(this);
            hour.setText(p.gettime());
            hour.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            hour.setPadding(5, 5, 5, 5);
            hour.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(hour,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
 
            /** Creating Qty Button **/
            TextView reason = new TextView(this);
            reason.setText(p.getwhy());
            reason.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            reason.setPadding(5, 5, 5, 5);
            reason.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(reason,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
            
            TextView institution = new TextView(this);
            institution.setText(p.getRGBinstitution());
            institution.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            institution.setPadding(5, 5, 5, 5);
            institution.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(institution,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
 
            TextView description = new TextView(this);
            description.setText(p.gettext());
            description.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            description.setPadding(5, 5, 5, 5);
            description.setBackgroundColor(Color.GRAY);
            Ll = new LinearLayout(this);
            params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(description,params);
            tr.addView((View)Ll); // Adding textview to tablerow.
            

             // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
            
            
            
        }
    }
    
    @Override 
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
            super.onCreateContextMenu(menu, v, menuInfo);
            menu.setHeaderTitle("Select The Action");  
            menu.add(0, v.getId(), 0, "Forward");//groupId, itemId, order, title 
           

    } 
    
    @Override  
    public boolean onContextItemSelected(MenuItem item){  
            if(item.getTitle()=="Forward"){
            	
            	
            	// getting values from selected table item
				String identity = (( TableLayout) findViewById(R.id.maintable)).getContext()
						.toString();

				// Starting new intent
				Intent in = new Intent(getApplicationContext(),
						Editdatabase.class);
				// sending identity to next activity
				in.putExtra(TAG_ID, identity);
				
				// starting new activity and expecting some response back
				startActivityForResult(in, 100);
            
            }  
           else{
               return false;
            }  
          return true;  
                            
      }  
 // Response from Edit showalertrgb Activity
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// if result code 100
		if (resultCode == 100) {
			// if result code 100 is received 
			// means user edited/deleted product
			// reload this screen again
			Intent intent = getIntent();
			finish();
			startActivity(intent);
		}
	}
	
	 
    }
