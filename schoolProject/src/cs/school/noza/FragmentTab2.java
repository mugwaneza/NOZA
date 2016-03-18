package cs.school.noza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    	"Public service",
        "Hotels & Accomodation ",
        "Hotels,Bars & Leisure",
        "Travel,Tourism & Transport",
        "Banking insurance and Finance",
        "Lawyers, Legal Exeprts & Notaries ",
        "Professional Services",
        "Trade Associations ",
        "Health",
        "Education - Public",
        "Education - Private ",
        "Beauty & Wellness",
        "Ceremonies, Parties and Events",
        "Shopping, Clothing, Shoes & Jewelry ",
        "Office & Shop Furniture & Equipments",
        " Electronics & other ICT",
        "Food & Beverages",
        "Craft Industry",
        "Arts & Entertainment ",
        "Construction",
        "Energy & Environment ",
        "Security ",
        "Hygiene",
        "Sports & Leisure",
        "Cars,Motorbikes & Bikes",
        "Factories & Workshops",
        "Agriculture",
        "Animals & Breeding",
        "Civil Associations & Society ",
        "Religion & Spirituality ",
        "NGOs (Non-Governmental Organizations) ",
        "Embassies & Cooperation  ",
        "International organizations",
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
        R.drawable.tradeassociations,
        R.drawable.health,
        R.drawable.educationpublic,
        R.drawable.educationprivate,
        R.drawable.beautywellness,
        R.drawable.ceremonies,
        R.drawable.shopping,
        R.drawable.forniture,
        R.drawable.electronics,
        R.drawable.food,
        R.drawable.craft,
        R.drawable.arts,
        R.drawable.construction,
        R.drawable.energy ,
        R.drawable.security,
        R.drawable.hygiene,
        R.drawable.sports,
        R.drawable.cars,
        R.drawable.factories,
        R.drawable.agriculture, 
        R.drawable.animal,
        R.drawable.civil,
        R.drawable.religion,
        R.drawable.ngos,
        R.drawable.embasy,
        R.drawable.international,
        };
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
       
        

		// Each row in the list stores amazinayabyo and amafoto
		 
		 List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
		 
	        for(int i=0;i<32;i++){
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
		            break;
		        case 7:
		    	      Intent l =new Intent  (getActivity().getApplicationContext(),page8.class);
		    	      startActivity(l);
		            break;
		        case 8:
		    	      Intent m =new Intent  (getActivity().getApplicationContext(),page9.class);
		    	      startActivity(m);
		            break;
		        case 9:
		    	      Intent o=new Intent  (getActivity().getApplicationContext(),page10.class);
		    	      startActivity(o);
		            break;
		        case 10:
		    	      Intent p =new Intent  (getActivity().getApplicationContext(),page11.class);
		    	      startActivity(p);
		            break;
		        case 11:
		    	      Intent n=new Intent  (getActivity().getApplicationContext(),page12.class);
		    	      startActivity(n);
		            break;
		
		            
		        case 13:
		    	      Intent i13=new Intent  (getActivity().getApplicationContext(),page13.class);
		    	      startActivity(i13);
		            break;
		        case 14:
		    	      Intent i14=new Intent  (getActivity().getApplicationContext(),page14.class);
		    	      startActivity(i14);
		            break;
		        case 15:
		    	      Intent i15=new Intent  (getActivity().getApplicationContext(),page15.class);
		    	      startActivity(i15);
		            break;
		        case 16:
		    	      Intent i16=new Intent  (getActivity().getApplicationContext(),page16.class);
		    	      startActivity(i16);
		            break;
		        case 17:
		    	      Intent i17=new Intent  (getActivity().getApplicationContext(),page17.class);
		    	      startActivity(i17);
		            break;
		        case 18:
		    	      Intent i18=new Intent  (getActivity().getApplicationContext(),page18.class);
		    	      startActivity(i18);
		            break;
		        case 19:
		    	      Intent i19=new Intent  (getActivity().getApplicationContext(),page19.class);
		    	      startActivity(i19);
		            break;
		        case 20:
		    	      Intent i20=new Intent  (getActivity().getApplicationContext(),page20.class);
		    	      startActivity(i20);
		            break;
		        case 21:
		    	      Intent i21=new Intent  (getActivity().getApplicationContext(),page21.class);
		    	      startActivity(i21);
		            break;
		        case 22:
		    	      Intent i22=new Intent  (getActivity().getApplicationContext(),page22.class);
		    	      startActivity(i22);
		            break;
		        case 23:
		    	      Intent i23=new Intent  (getActivity().getApplicationContext(),page23.class);
		    	      startActivity(i23);
		            break;
		        case 24:
		    	      Intent i24=new Intent  (getActivity().getApplicationContext(),page24.class);
		    	      startActivity(i24);
		            break;
		        case 25:
		    	      Intent i25=new Intent  (getActivity().getApplicationContext(),page25.class);
		    	      startActivity(i25);
		            break;
		        case 26:
		    	      Intent i26=new Intent  (getActivity().getApplicationContext(),page26.class);
		    	      startActivity(i26);
		            break;
		        case 27:
		    	      Intent i27=new Intent  (getActivity().getApplicationContext(),page27.class);
		    	      startActivity(i27);
		            break;
		        case 28:
		    	      Intent i28=new Intent  (getActivity().getApplicationContext(),page28.class);
		    	      startActivity(i28);
		            break;
		        case 29:
		    	      Intent i29=new Intent  (getActivity().getApplicationContext(),page29.class);
		    	      startActivity(i29);
		            break;
		        case 30:
		    	      Intent i30=new Intent  (getActivity().getApplicationContext(),page30.class);
		    	      startActivity(i30);
		            break;
		        case 31:
		    	      Intent i31=new Intent  (getActivity().getApplicationContext(),page31.class);
		    	      startActivity(i31);
		            break;
		        case 32:
		    	      Intent i32=new Intent  (getActivity().getApplicationContext(),page32.class);
		    	      startActivity(i32);
		            break;
		        case 33:
		    	      Intent i33=new Intent  (getActivity().getApplicationContext(),page33.class);
		    	      startActivity(i33);
		        default:
		            break;
		        }
		}
		}

		
	        
	