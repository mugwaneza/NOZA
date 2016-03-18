package cs.school.noza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.os.AsyncTask;
 
public class FetchDataTask extends AsyncTask<String, Void, String>{
    private final FetchDataListener listener;
    private String msg;
     
    public FetchDataTask(FetchDataListener listener) {
        this.listener = listener;
    }
     
    @Override
    protected String doInBackground(String... params) {
        if(params == null) return null;
        String url = params[0];
         
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
             
            // connect
            HttpResponse response = client.execute(httpget);
             
            // get response
            HttpEntity entity = response.getEntity();
             
            if(entity == null) {
                msg = "No response from server";
                return null;        
            }
            InputStream is = entity.getContent();
            return streamToString(is);
        }
        catch(IOException e){
            msg = "No Network Connection";
        }
         
        return null;
    }
     
    @Override
    protected void onPostExecute(String sJson) {
        if(sJson == null) {
            if(listener != null) listener.onFetchFailure(msg);
            return;
        }        
         
        try {
            JSONArray aJson = new JSONArray(sJson);
            List<Application> apps = new ArrayList<Application>();
             
            for(int i=0; i<aJson.length(); i++) {
                JSONObject json = aJson.getJSONObject(i);
                Application app = new Application();
                app.setId(json.getString("id"));
                app.setHead(json.getString("head"));
                app.setWho(json.getString("who"));
                app.setMessage(json.getString("message"));
                
                apps.add(app);
            }
            if(listener != null) listener.onFetchComplete(apps);
        } catch (JSONException e) 
        
        {
            msg = "Invalid response";
            if(listener != null) listener.onFetchFailure(msg);
        return;
        
        }        
    }
    public String streamToString(final InputStream is) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder(); 
        String line = null;
         
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } 
        catch (IOException e) {
            throw e;
        } 
        finally {           
            try {
                is.close();
            } 
            catch (IOException e) {
                throw e;
            }
        }
         
        return sb.toString();
    }
}
