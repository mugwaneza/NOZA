package cs.school.noza;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class retrievebyinstitutions extends Activity implements OnItemClickListener  {
	
	  private ArrayAdapter<String> listAdapter ;
	String[] institutions = new String[] 
    		{
    	"Public service",
        "Hotels & Accomodation",
        "Hotels & Bars ",
        "Tourism & Transport",
        "Banking & insurance",
        "Lawyers & Notaries",
        "Professional Services",
        "Trade Associations ",
        "Health",
        "Education-Public",
        "Education-Private",
        "Beauty & Wellness",
        "Ceremonies & Parties",
        "Shopping & Clothing",
        "Furniture shop & Accessories",
        "Electronics & other ICT",
        "Food and Beverages",
        "Craft Industry",
        "Arts & Culture",
        "Construction & Real Estate",
        "Energy & Environment",
        "Security & Safety ",
        "Hygiene",
        "Sports & Leisure",
        "Cars,Motorbikes & Bikes",
        "Factories & Workshops",
        "Agriculture",
        "Animals & Breeding",
        "Civil Associations  ",
        "Religion & Spirituality ",
        "NGOs (Non-Governmental Organizations) ",
        "Embassies & Cooperation  ",
        "International organizations",
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retrievebyinstitutions);
	

	   
	 
	        ArrayList<String> institutionList = new ArrayList<String>();
		  institutionList.addAll( Arrays.asList(institutions) );
		    
	 
	        // Instantiating an adapter to store each items
	        // R.layout.listview_layout defines the layout of each item
	        
	        
	        listAdapter = new ArrayAdapter<String>(this, R.layout.retrievebyinst2, institutionList);
		    
	        // Getting a reference to listview of main.xml layout file
	        ListView listView = ( ListView )findViewById(R.id.listView);
	 
	        // Setting the adapter to the listView
	        listView.setAdapter(listAdapter);
	      

	        // Setting the adapter to the listView
	       
	        listView .setOnItemClickListener(this);
 
		    
	        
	       
		    
		    
	}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			
		        switch (position) {
		        case 0:
		          Intent i =new Intent (getApplicationContext(),showalertrgbHome1.class);
		          startActivity(i);
		            break;
		        case 1:
		        	 Intent a =new Intent (getApplicationContext(),showalertrgbHome2.class);
			          startActivity(a);
		            break;
		        case 2:
		        	 Intent b =new Intent (getApplicationContext(),showalertrgbHome3.class);
			          startActivity(b);
		    	    
		            break;
		        case 3:
		        	 Intent c=new Intent (getApplicationContext(),showalertrgbHome4.class);
			          startActivity(c);
		    	     
		            break;
		        case 4:
		        	 Intent d =new Intent (getApplicationContext(),showalertrgbHome5.class);
			          startActivity(d);    
		            break;
		        case 5:
		        	 Intent e =new Intent (getApplicationContext(),showalertrgb6.class);
			          startActivity(e);  
		            break;
		        case 6:
		        	 Intent f =new Intent (getApplicationContext(),showalertrgb7.class);
			          startActivity(f); 
		            break;
		        case 7:
		        	 Intent g =new Intent (getApplicationContext(),showalertrgb8.class);
			          startActivity(g);  
		            break;
		        case 8:
		        	 Intent h =new Intent (getApplicationContext(),showalertrgb9.class);
			          startActivity(h); 
		            break;
		        case 9:
		        	 Intent k =new Intent (getApplicationContext(),showalertrgb10.class);
			          startActivity(k);  
		            break;
		        case 10:
		        	 Intent l =new Intent (getApplicationContext(),showalertrgb11.class);
			          startActivity(l);  
		            break;
		        case 11:
		        	 Intent m =new Intent (getApplicationContext(),showalertrgb12.class);
			          startActivity(m);
		            break;
		        case 12:
		        	 Intent n =new Intent (getApplicationContext(),showalertrgb13.class);
			          startActivity(n);
		            break;
		        case 13:
		        	 Intent o =new Intent (getApplicationContext(),showalertrgb14.class);
			          startActivity(o);
		            break;
		        case 14:
		        	 Intent p =new Intent (getApplicationContext(),showalertrgb15.class);
			          startActivity(p);
		            break;
		        case 15:
		        	 Intent t =new Intent (getApplicationContext(),showalertrgb16.class);
			          startActivity(t);
		            break;
		        case 16:
		        	 Intent u =new Intent (getApplicationContext(),showalertrgb17.class);
			          startActivity(u);
		            break;
		        case 17:
		        	 Intent v =new Intent (getApplicationContext(),showalertrgb18.class);
			          startActivity(v);
		            break;
		        case 18:
		        	 Intent q =new Intent (getApplicationContext(),showalertrgb19.class);
			          startActivity(q);
		            break;
		        case 19:
		        	 Intent r =new Intent (getApplicationContext(),showalertrgb20.class);
			          startActivity(r);
		            break;
		        case 20:
		        	 Intent s =new Intent (getApplicationContext(),showalertrgb21.class);
			          startActivity(s);
		            break;
		        case 21:
		        	 Intent w =new Intent (getApplicationContext(),showalertrgb22.class);
			          startActivity(w);
		            break;
		        case 22:
		        	 Intent x =new Intent (getApplicationContext(),showalertrgb23.class);
			          startActivity(x);
		            break;
		        case 23:
		        	 Intent y =new Intent (getApplicationContext(),showalertrgb24.class);
			          startActivity(y);
		            break;
		        case 24:
		        	 Intent z =new Intent (getApplicationContext(),showalertrgb25.class);
			          startActivity(z);
		            break;
		        case 25:
		        	 Intent i1 =new Intent (getApplicationContext(),showalertrgb26.class);
			          startActivity(i1);
		            break;
		        case 26:
		        	 Intent i2 =new Intent (getApplicationContext(),showalertrgb27.class);
			          startActivity(i2);
		            break;
		        case 27:
		        	 Intent i3 =new Intent (getApplicationContext(),showalertrgb28.class);
			          startActivity(i3);
		            break;
		        case 28:
		        	 Intent i4 =new Intent (getApplicationContext(),showalertrgb29.class);
			          startActivity(i4);
		            break;
		        case 29:
		        	 Intent i5 =new Intent (getApplicationContext(),showalertrgb30.class);
			          startActivity(i5);
		            break;
		        case 30:
		        	 Intent i6 =new Intent (getApplicationContext(),showalertrgb31.class);
			          startActivity(i6);
		            break;
		        case 31:
		        	 Intent i8 =new Intent (getApplicationContext(),showalertrgb32.class);
			          startActivity(i8);
		            break;
		       
		       
		        default:
		            break;
		        }
		}
		
		
		 
		    
		    
		    
		    
		
		}

		
	        
	