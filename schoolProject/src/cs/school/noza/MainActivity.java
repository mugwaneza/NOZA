package cs.school.noza;



import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

public class MainActivity extends Activity {
	// Declare Tab Variable
	ActionBar.Tab Tab1, Tab2;
	Fragment fragmentTab1 = new FragmentTab1();
	Fragment fragmentTab2 = new FragmentTab2();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();

		// Hide Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(false);

		// Hide Actionbar Title
		actionBar.setDisplayShowTitleEnabled(false);

		// Create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Set Tab Icon and Titles
		Tab1 = actionBar.newTab().setText("alert");
		Tab2 = actionBar.newTab().setText("let me know");
		
	

		// Set Tab Listeners
		Tab1.setTabListener(new TabListener(fragmentTab1));
		Tab2.setTabListener(new TabListener(fragmentTab2));
		
		
		// Add tabs to actionbar
		actionBar.addTab(Tab1);
		actionBar.addTab(Tab2);
		
	}
}
