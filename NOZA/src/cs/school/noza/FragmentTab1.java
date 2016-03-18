package cs.school.noza;

import cs.school.noza.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FragmentTab1 extends Fragment {
	
	
	ImageView alert,programs ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
        
        
        alert =(ImageView)rootView.findViewById(R.id.a);
      
        programs =(ImageView)rootView.findViewById(R.id.c);
        
        alert.setOnClickListener(new OnClickListener() {
            
            @Override
     		public void onClick(View v) {
     		
     			 Intent intent = new Intent(getActivity(),CitizenPage.class);
     	    	    startActivity(intent);

     		} });

        
        programs.setOnClickListener(new OnClickListener() {
    
    @Override
		public void onClick(View v) {
		
			 Intent intent = new Intent(getActivity(),   
					 programsofgov.class);
	    	    startActivity(intent);

		} });


        
        return rootView;
    }
 
}