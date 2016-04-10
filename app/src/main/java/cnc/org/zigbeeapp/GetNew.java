package cnc.org.zigbeeapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jonas on 31.03.2016.
 */
public class GetNew extends AsyncTask<Void, Void, List<String>> {

    private ArrayAdapter<String> adapter;

    public GetNew(ArrayAdapter<String> adapter) {
        this.adapter = adapter;
    }

    @Override
    protected List<String> doInBackground(Void... params) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return Arrays.asList(restTemplate.getForObject("http://192.168.178.83:8080/v1/poll", String[].class));
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<String> stringList) {
        super.onPostExecute(stringList);

        if(stringList == null){
            Log.w("Error", "Null was returned by http request");
        }else {
            this.adapter.clear();
        }

        for(String s : stringList){
            this.adapter.add(s);
        }

        this.adapter.notifyDataSetChanged();
    }
}
