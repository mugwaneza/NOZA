package cs.school.noza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;



import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.rgb2.noza.loginpage;
import com.rgb2.noza.registerpage;

import cs.school.noza.R;

public class citizenauthentication extends Activity implements OnClickListener,
ConnectionCallbacks, OnConnectionFailedListener {
	
	
	
	
	private LoginButton loginBtn;
    private UiLifecycleHelper uiHelper;

    private static final int RC_SIGN_IN = 0;
	// Logcat tag
	private static final String TAG = "citizenauthentication";

	// Profile pic image size in pixels
	private static final int PROFILE_PIC_SIZE = 400;

	// Google client to interact with Google API
	private GoogleApiClient mGoogleApiClient;

	/**
	 * A flag indicating that a PendingIntent is in progress and prevents us
	 * from starting further intents.
	 */
	private boolean mIntentInProgress;

	private boolean mSignInClicked;

	private ConnectionResult mConnectionResult;

	private SignInButton btnSignIn;
	private Button btnSignOut, btnRevokeAccess;
	private ImageView imgProfilePic;
	private TextView txtName, txtEmail;
	private LinearLayout llProfileLayout;
   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(this, statusCallback);
		        uiHelper.onCreate(savedInstanceState);
        setContentView(R.layout.citizenauthentication);
		
		
		
        

        Button login =(Button)findViewById(R.id.login2)	;	
        Button register =(Button)findViewById(R.id.signup)	;

		
		 loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
         loginBtn.setReadPermissions(Arrays.asList("email"));
         
        
         
         login.setOnClickListener(new View.OnClickListener() {
        		
        		@Override
        		public void onClick(View arg0) {
        			Intent i =new Intent(getApplication(),loginpage.class);
        			startActivity(i);
        				
        			}
        	}); 
         
         
         register.setOnClickListener(new View.OnClickListener() {
        		
        		@Override
        		public void onClick(View arg0) {
        		
        			// TODO Auto-generated method stub
        			Intent i =new Intent(getApplication(),registerpage.class);
        			startActivity(i);
        			}
        	}); 
         
         
         
         
         loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() { 
        	    @Override
        	    public void onUserInfoFetched(GraphUser user) {
        	if (user != null) {
        		// TODO Auto-generated method stub
        				Intent i =new Intent(getApplication(),MainActivity.class);
        				startActivity(i);    
        	    } 

        	    }

        	});
         
         
         // google plus button declaration
      
         
         
         btnSignIn = (SignInButton) findViewById(R.id.btn_sign_in);
 		btnSignOut = (Button) findViewById(R.id.btn_sign_out);
 		btnRevokeAccess = (Button) findViewById(R.id.btn_revoke_access);
 		imgProfilePic = (ImageView) findViewById(R.id.imgProfilePic);
 		txtName = (TextView) findViewById(R.id.txtName);
 		txtEmail = (TextView) findViewById(R.id.txtEmail);
 		
 		// Button click listeners
 		btnSignIn.setOnClickListener(this);
 		btnSignOut.setOnClickListener(this);
 		btnRevokeAccess.setOnClickListener(this);

 		mGoogleApiClient = new GoogleApiClient.Builder(this)
 				.addConnectionCallbacks(this)
 				.addOnConnectionFailedListener(this).addApi(Plus.API)
 				.addScope(Plus.SCOPE_PLUS_LOGIN).build();
         
       
// ends
		
}
	
	
	

public void showAlert(){
	citizenauthentication.this.runOnUiThread(new Runnable() {
	    public void run() {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(citizenauthentication.this);
	    	builder.setTitle("Login Error.");
	    	builder.setMessage("invalid user !.")  
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
	
	
	
	private Session.StatusCallback statusCallback = new Session.StatusCallback() {
         @Override
         public void call(Session session, SessionState state,
                 Exception exception) {
             if (state.isOpened()) {
                 Log.d("loginpageoffer", "Facebook session opened.");
             } else if (state.isClosed()) {
                 Log.d("loginpageoffer", "Facebook session closed.");
             }

}

};
     

@Override
     public void onResume() {

super.onResume();

uiHelper.onResume();

}
 		 		     @Override
     public void onPause() {
         super.onPause();
 uiHelper.onPause();
 }

     @Override
     public void onDestroy() {

super.onDestroy();
         uiHelper.onDestroy();
     }

 	     @Override

public void onSaveInstanceState(Bundle savedState) {

super.onSaveInstanceState(savedState);

uiHelper.onSaveInstanceState(savedState);

}

 		protected void onStart() {
 			super.onStart();
 			mGoogleApiClient.connect();
 		}

 		protected void onStop() {
 			super.onStop();
 			if (mGoogleApiClient.isConnected()) {
 				mGoogleApiClient.disconnect();
 			}
 		}

 		/**
 		 * Method to resolve any signin errors
 		 * */
 		private void resolveSignInError() {
 			if (mConnectionResult.hasResolution()) {
 				try {
 					mIntentInProgress = true;
 					mConnectionResult.startResolutionForResult(this, RC_SIGN_IN);
 				} catch (SendIntentException e) {
 					mIntentInProgress = false;
 					mGoogleApiClient.connect();
 				}
 			}
 		}

 		@Override
 		public void onConnectionFailed(ConnectionResult result) {
 			if (!result.hasResolution()) {
 				GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this,
 						0).show();
 				return;
 			}

 			if (!mIntentInProgress) {
 				// Store the ConnectionResult for later usage
 				mConnectionResult = result;

 				if (mSignInClicked) {
 					// The user has already clicked 'sign-in' so we attempt to
 					// resolve all
 					// errors until the user is signed in, or they cancel.
 					resolveSignInError();
 				}
 			}

 		}

 		@Override
 		protected void onActivityResult(int requestCode, int responseCode,
 				Intent intent) {
 			
 			
 			// for facebook
 			

 			super.onActivityResult(requestCode, responseCode, intent);

 			uiHelper.onActivityResult(requestCode, responseCode, intent);

 			
 			//end
 			
 			
 			
 			if (requestCode == RC_SIGN_IN) {
 				if (responseCode != RESULT_OK) {
 					mSignInClicked = false;
 				}

 				mIntentInProgress = false;

 				if (!mGoogleApiClient.isConnecting()) {
 					mGoogleApiClient.connect();
 				}
 			}
 		}

 		@Override
 		public void onConnected(Bundle arg0) {
 			mSignInClicked = false;
 			Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();

 			// Get user's information
 			getProfileInformation();

 			// Update the UI after signin
 			updateUI(true);

 		}

 		/**
 		 * Updating the UI, showing/hiding buttons and profile layout
 		 * */
 		private void updateUI(boolean isSignedIn) {
 			if (isSignedIn) {
 				btnSignIn.setVisibility(View.GONE);
 				btnSignOut.setVisibility(View.VISIBLE);
 				btnRevokeAccess.setVisibility(View.VISIBLE);
 				llProfileLayout.setVisibility(View.VISIBLE);
 			} else {
 				btnSignIn.setVisibility(View.VISIBLE);
 				btnSignOut.setVisibility(View.GONE);
 				btnRevokeAccess.setVisibility(View.GONE);
 				llProfileLayout.setVisibility(View.GONE);
 			}
 		}

 		/**
 		 * Fetching user's information name, email, profile pic
 		 * */
 		private void getProfileInformation() {
 			try {
 				if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
 					Person currentPerson = Plus.PeopleApi
 							.getCurrentPerson(mGoogleApiClient);
 					String personName = currentPerson.getDisplayName();
 					String personPhotoUrl = currentPerson.getImage().getUrl();
 					String personGooglePlusProfile = currentPerson.getUrl();
 					String email = Plus.AccountApi.getAccountName(mGoogleApiClient);

 					Log.e(TAG, "Name: " + personName + ", plusProfile: "
 							+ personGooglePlusProfile + ", email: " + email
 							+ ", Image: " + personPhotoUrl);

 					txtName.setText(personName);
 					txtEmail.setText(email);

 					// by default the profile url gives 50x50 px image only
 					// we can replace the value with whatever dimension we want by
 					// replacing sz=X
 					personPhotoUrl = personPhotoUrl.substring(0,
 							personPhotoUrl.length() - 2)
 							+ PROFILE_PIC_SIZE;

 					new LoadProfileImage(imgProfilePic).execute(personPhotoUrl);

 				} else {
 					Toast.makeText(getApplicationContext(),
 							"Person information is null", Toast.LENGTH_LONG).show();
 				}
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}

 		@Override
 		public void onConnectionSuspended(int arg0) {
 			mGoogleApiClient.connect();
 			updateUI(false);
 		}

 		

 		/**
 		 * Button on click listener
 		 * */
 		@Override
 		public void onClick(View v) {
 			switch (v.getId()) {
 			case R.id.btn_sign_in:
 				// Signin button clicked
 				signInWithGplus();
 				Intent i =new Intent(getApplicationContext(),MainActivity.class);
 				startActivity(i);
 				break;
 			case R.id.btn_sign_out:
 				// Signout button clicked
 				signOutFromGplus();
 				break;
 			case R.id.btn_revoke_access:
 				// Revoke access button clicked
 				revokeGplusAccess();
 				break;
 			}
 		}

 		/**
 		 * Sign-in into google
 		 * */
 		private void signInWithGplus() {
 			if (!mGoogleApiClient.isConnecting()) {
 				mSignInClicked = true;
 				resolveSignInError();
 			}
 		}

 		/**
 		 * Sign-out from google
 		 * */
 		private void signOutFromGplus() {
 			if (mGoogleApiClient.isConnected()) {
 				Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
 				mGoogleApiClient.disconnect();
 				mGoogleApiClient.connect();
 				updateUI(false);
 			}
 		}

 		/**
 		 * Revoking access from google
 		 * */
 		private void revokeGplusAccess() {
 			if (mGoogleApiClient.isConnected()) {
 				Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
 				Plus.AccountApi.revokeAccessAndDisconnect(mGoogleApiClient)
 						.setResultCallback(new ResultCallback<Status>() {
 							@Override
 							public void onResult(Status arg0) {
 								Log.e(TAG, "User access revoked!");
 								mGoogleApiClient.connect();
 								updateUI(false);
 							}

 						});
 			}
 		}

 		/**
 		 * Background Async task to load user profile picture from url
 		 * */
 		private class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
 			ImageView bmImage;

 			public LoadProfileImage(ImageView bmImage) {
 				this.bmImage = bmImage;
 			}

 			protected Bitmap doInBackground(String... urls) {
 				String urldisplay = urls[0];
 				Bitmap mIcon11 = null;
 				try {
 					InputStream in = new java.net.URL(urldisplay).openStream();
 					mIcon11 = BitmapFactory.decodeStream(in);
 				} catch (Exception e) {
 					Log.e("Error", e.getMessage());
 					e.printStackTrace();
 				}
 				return mIcon11;
 			}

 			protected void onPostExecute(Bitmap result) {
 				bmImage.setImageBitmap(result);
 			}
 		}

	
}