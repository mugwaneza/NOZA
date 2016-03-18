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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
public class showalertrgbHome1 extends Activity {

	  //ID for the menu exit option
  private final int ID_MENU_inquiry= 4;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showalertrgb);
		
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	 //the menu option text is defined in resources
     menu.add(R.string.poorservices);
      
     
        //get a SubMenu reference
        SubMenu sm = menu.addSubMenu("Corruptions");
        //add menu items to the submenu
        sm.add("Theme");
        sm.add("Settings");
     
        //it is better to use final variables for IDs than constant values
        //menu.add(Menu.NONE,1,Menu.NONE,"Exit");
     
        //get the MenuItem reference
        MenuItem item = 
        	menu.add(Menu.NONE,ID_MENU_inquiry,Menu.NONE,R.string.inquiry);
        
        //set the shortcut
        item.setShortcut('5', 'x');
     
        //the menu option text is defined as constant String
        menu.add("Histogram");
        
        return true;
    }
	    }
