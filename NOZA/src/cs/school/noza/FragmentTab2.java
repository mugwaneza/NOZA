package cs.school.noza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cs.school.noza.R;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentTab2 extends Fragment implements OnItemClickListener  {
	
	String[] institutions = new String[] 
    		{
			 "Districts",
			 "Ministries",
		     "Security ",
			 "Education",
			 "Health",
			 "Lawyers",
			"Gov agencies",    
    };
	
	 // Array of integers points to images stored in /res/drawable-ldpi/
    int[] amafoto = new int[]{
        R.drawable.services,
        R.drawable.hotels,
        R.drawable.hotelsbars,
        R.drawable.travel,
        R.drawable.banking,
        R.drawable.lawyers,
        R.drawable.proffessional,
        };
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
       
        

		// Each row in the list stores amazinayabyo and amafoto
		 
		 List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
		 
	        for(int i= 0;i < 7; i++){
	            HashMap<String, String> hm = new HashMap<String,String>();
	            hm.put("textView",  institutions[i]);
	            hm.put("imageView1", Integer.toString(amafoto[i]) );
	            aList.add(hm);
	        }
	

	        // Keys used in Hashmap
	        String[] from = { "imageView1","textView" };
	 
	        // Ids of views in listview_layout
	        int[] to = { R.id.imageView,R.id.textView};
	 
	        // Instantiating an adapter to store each items
	        // R.layout.listview_layout defines the layout of each item
	        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.tab2, from, to);
	        // Getting a reference to listview of main.xml layout file
	        ListView listView = ( ListView )rootView.findViewById(R.id.listView);
	 
	        // Setting the adapter to the listView
	        listView.setAdapter(adapter);
	      

	        // Setting the adapter to the listView
	       
	        listView .setOnItemClickListener(this);
 
		    
	        
	        return rootView;
	        
		    
		    
	}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			
		        switch (position) {
		        case 0:
		          
		    	      Intent a =new Intent  (getActivity().getApplicationContext(),page1.class);
		    	      startActivity(a);
		            break;
		        case 1:

		    		
		    	      Intent b =new Intent  (getActivity().getApplicationContext(),page2.class);
		    	      startActivity(b);
		            break;
		        case 2:

		    	      Intent c =new Intent  (getActivity().getApplicationContext(),page3.class);
		    	      startActivity(c);
		            break;
		        case 3:

		    	      Intent d =new Intent  (getActivity().getApplicationContext(),page4.class);
		    	      startActivity(d);
		            break;
		        case 4:
		    	      Intent e=new Intent  (getActivity().getApplicationContext(),page5.class);
		    	      startActivity(e);
		            break;
		        case 5:
		    	      Intent f =new Intent  (getActivity().getApplicationContext(),page6.class);
		    	      startActivity(f);
		            break;
		        case 6:
		    	      Intent g =new Intent  (getActivity().getApplicationContext(),page7.class);
		    	      startActivity(g);
		            
		        default:
		            break;
		        }
		}
		}

		
	        
	