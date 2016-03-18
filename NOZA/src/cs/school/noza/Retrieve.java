package cs.school.noza;


import java.util.List;

import cs.school.noza.R;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

public class Retrieve extends ListActivity implements FetchDataListener {
	 private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.retrieve);
		 initView(); 
    }
 
    private void initView() {
        // show progress dialog
    	
        dialog = ProgressDialog.show(this, "", "Pease wait while loading...");
         
        String url = "http://10.0.2.2/noza/Retrieve_feedback.php";
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }
     
    @Override
    public void onFetchComplete(List<Application> data) {
        if(dialog != null)  dialog.dismiss();
        retrieve_feedback adapter = new retrieve_feedback(this, data);
        setListAdapter(adapter);        
    }
 
    @Override
    public void onFetchFailure(String msg) {
        if(dialog != null)  dialog.dismiss();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();        
    }
}
