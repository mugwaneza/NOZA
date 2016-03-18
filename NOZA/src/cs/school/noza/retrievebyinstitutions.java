package cs.school.noza;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;



public class retrievebyinstitutions extends Activity   {
	
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retrievebyinstitutions);
		
		Button comments =(Button)findViewById(R.id.button1);
	        
	        comments.setOnClickListener(new OnClickListener() {
	            
	            @Override
	     		public void onClick(View v) {
	     		
	     			 Intent intent = new Intent(getApplicationContext(),citizencomments.class);
	     	    	    startActivity(intent);

	     		} });

	        
		
		
		
		// get the listview
				expListView = (ExpandableListView) findViewById(R.id.expandableListView);
				// preparing list data
				prepareListData();

				listAdapter = new retrievebyinstitutionAdapter(this, listDataHeader, listDataChild);

				// setting list adapter
				expListView.setAdapter(listAdapter);

				// Listview Group click listener
				expListView.setOnGroupClickListener(new OnGroupClickListener() {

					@Override
					public boolean onGroupClick(ExpandableListView parent, View v,
							int groupPosition, long id) {
						// Toast.makeText(getApplicationContext(),
						// "Group Clicked " + listDataHeader.get(groupPosition),
						// Toast.LENGTH_SHORT).show();
						return false;
					}
				});

				// Listview Group expanded listener
				expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

					@Override
					public void onGroupExpand(int groupPosition) {
						Toast.makeText(getApplicationContext(),
								listDataHeader.get(groupPosition) + " Expanded",
								Toast.LENGTH_SHORT).show();
					}
				});

				// Listview Group collasped listener
				expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

					@Override
					public void onGroupCollapse(int groupPosition) {
						Toast.makeText(getApplicationContext(),
								listDataHeader.get(groupPosition) + " Collapsed",
								Toast.LENGTH_SHORT).show();

					}
				});

				// Listview on child click listener
				expListView.setOnChildClickListener(new OnChildClickListener() {

					@Override
					public boolean onChildClick(ExpandableListView parent, View v,
							int groupPosition, int childPosition, long id) {

						// TODO Auto-generated method stub
						// TODO Auto-generated method stub
						switch(groupPosition) {
				        case 0: 
				            switch (childPosition) {
				            case 0: 

								 Intent a = new Intent(getApplicationContext(),Showalertrgb1A.class);
						    	    startActivity(a);
				                break;              
				            case 1:
				            	Intent b = new Intent(getApplicationContext(),Showalertrgb1B.class);
					    	    startActivity(b);

				                break;
				            case 2:
				            	 Intent c = new Intent(getApplicationContext(),Showalertrgb1C.class);
				 	    	    startActivity(c);
				                break;
				            }
						}
				            switch(groupPosition) {
				            case 1: 
					            switch (childPosition) {
					            case 0: 
					            	Intent a = new Intent(getApplicationContext(),showalertrgb2A.class);
						    	    startActivity(a);
					                break;              
					            case 1:
					            	 Intent b = new Intent(getApplicationContext(),showalertrgb2B.class);
						 	    	    startActivity(b);
					                break;
					            case 2:
					            	Intent c = new Intent(getApplicationContext(),showalertrgb2C.class);
						    	    startActivity(c);
					                break;
					            }
				        }
				            
				            switch(groupPosition) {
				            case 2: 
					            switch (childPosition) {
					            case 0: 
					            	Intent a = new Intent(getApplicationContext(),showalertrgb3A.class);
						    	    startActivity(a);
					                break;              
					            case 1:
					            	 Intent b = new Intent(getApplicationContext(),showalertrgb3B.class);
						   	    	    startActivity(b);

					            case 2:
					            	Intent c = new Intent(getApplicationContext(),showalertrgb3C.class);
						    	    startActivity(c);
					                break;
					            }
				        }
				            switch(groupPosition) {
				            case 3: 
					            switch (childPosition) {
					            case 0: 
					            	 Intent a = new Intent(getApplicationContext(),showalertrgb4A.class);
							    	    startActivity(a);
					                break;              
					            case 1:
					            	 Intent b = new Intent(getApplicationContext(),showalertrgb4B.class);
						 	    	    startActivity(b);
					   			
					                break;
					            case 2:
					            	Intent c = new Intent(getApplicationContext(),showalertrgb4C.class);
					   	    	    startActivity(c);
					                break;
					               
					            }
				        }
				            switch(groupPosition) {
				            case 4: 
					            switch (childPosition) {
					            case 0: 
					            	 Intent a = new Intent(getApplicationContext(),showalertrgb5A.class);
							    	    startActivity(a);
					                break;              
					            case 1:
					            	Intent b = new Intent(getApplicationContext(),showalertrgb5B.class);
						    	    startActivity(b);
					                break;
					            case 2:
					            	 Intent c = new Intent(getApplicationContext(),showalertrgb5C.class);
						 	    	    startActivity(c);
					   			 break;
					            }
				        }
				            switch(groupPosition) {
				            case 5: 
					            switch (childPosition) {
					            case 0: 
					            	Toast.makeText(getApplicationContext(), "hi6.1", Toast.LENGTH_LONG).show();

					                break;              
					            case 1:
					            	Toast.makeText(getApplicationContext(), "hi6.2", Toast.LENGTH_LONG).show();
					                break;
					            case 2:
					            	Toast.makeText(getApplicationContext(), "hi6.3", Toast.LENGTH_LONG).show();
					                break;
					            }
				        }
				            switch(groupPosition) {
				            case 6: 
					            switch (childPosition) {
					            case 0: 
					               Toast.makeText(getApplicationContext(), "hi7.1", Toast.LENGTH_LONG).show();
					                break;              
					            case 1:
					            	 Toast.makeText(getApplicationContext(), "hi7.2", Toast.LENGTH_LONG).show();
					                break;
					            case 2:
					            	 Toast.makeText(getApplicationContext(), "hi8.3", Toast.LENGTH_LONG).show();
					                break;
					               
					            }
				        }
			
						return true;
					}
				});
			}

			/*
			 * Preparing the list data
			 */
			private void prepareListData() {
				listDataHeader = new ArrayList<String>();
				listDataChild = new HashMap<String, List<String>>();

				// Adding child data
				listDataHeader.add("Districts");
				listDataHeader.add("Ministries");
				listDataHeader.add("Security");
				listDataHeader.add("Education");
				listDataHeader.add("Health");
				listDataHeader.add("Lawyers");
				listDataHeader.add("Gov agencies");
				
				// Adding child data
				List<String> Districts = new ArrayList<String>();
				Districts.add("Poor services");
				Districts.add("Corruptions");
				Districts.add("Inquiries");
				

				List<String> Ministries = new ArrayList<String>();
				Ministries.add("Poor services");
				Ministries.add("Corruptions");
				Ministries.add("Inquiries");
				

				List<String> Security = new ArrayList<String>();
				Security.add("Poor services");
				Security.add("Corruptions");
				Security.add("Inquiries");
				
				List<String> Education = new ArrayList<String>();
				Education.add("Poor services");
				Education.add("Corruptions");
				Education.add("Inquiries");
				
				List<String> Health = new ArrayList<String>();
				Health.add("Poor services");
				Health.add("Corruptions");
				Health.add("Inquiries");
				
				List<String> Lawyers = new ArrayList<String>();
				Lawyers.add("Poor services");
				Lawyers.add("Corruptions");
				Lawyers.add("Inquiries");
				
				List<String> Govagencies = new ArrayList<String>();
				Govagencies.add("Poor services");
				Govagencies.add("Corruptions");
				Govagencies.add("Inquiries");
				
				

				listDataChild.put(listDataHeader.get(0), Districts); // Header, Child data
				listDataChild.put(listDataHeader.get(1), Ministries);
				listDataChild.put(listDataHeader.get(2), Security);
				listDataChild.put(listDataHeader.get(3), Education);
				listDataChild.put(listDataHeader.get(4), Health);
				listDataChild.put(listDataHeader.get(5), Lawyers);
				listDataChild.put(listDataHeader.get(6), Govagencies);
				
			}
		
}



		
	        
	