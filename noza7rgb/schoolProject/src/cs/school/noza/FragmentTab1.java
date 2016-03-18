package cs.school.noza;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentTab1 extends Fragment {
	
	
	Button post,rgb,police ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
        
        
        post =(Button)rootView.findViewById(R.id.alert);
        rgb =(Button)rootView.findViewById(R.id.rgb);
        police =(Button)rootView.findViewById(R.id.police);
        
post.setOnClickListener(new OnClickListener() {
            
            @Override
     		public void onClick(View v) {
     		
     			 Intent intent = new Intent(getActivity(),citizenauthentication.class);
     	    	    startActivity(intent);

     		} });

rgb.setOnClickListener(new OnClickListener() {
    
    @Override
		public void onClick(View v) {
		
			 Intent intent = new Intent(getActivity(),rgbpage.class);
	    	    startActivity(intent);

		} });

police.setOnClickListener(new OnClickListener() {
    
    @Override
		public void onClick(View v) {
		
			 Intent intent = new Intent(getActivity(),   
				     showalertrgbHome1.class);
	    	    startActivity(intent);

		} });


        
        return rootView;
    }
 
}