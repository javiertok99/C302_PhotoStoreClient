package sg.edu.rp.webservices.c302_photostoreclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PhotoDetails extends AppCompatActivity {

    private ListView lvDetails;
    ArrayList<Details> alDetails = new ArrayList<>();
    DetailsAdapter aaDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lvDetails = (ListView) findViewById(R.id.lvDetails);
        aaDetails = new DetailsAdapter(this, R.layout.detail_row, alDetails);
        Intent i = getIntent();
        String cat = i.getStringExtra("category");
        String url = "http://192.168.43.195/C302_P06_PhotoStoreWS/getPhotoStoreByCategory.php?category_id=" + cat;
        // Code for step 1 start 4
        HttpRequest request = new HttpRequest
                (url);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
        lvDetails.setAdapter(aaDetails);
    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int photo_id = jsonObj.getInt("photo_id");
                            String title = jsonObj.getString("title");
                            String description = jsonObj.getString("description");
                            String image = jsonObj.getString("image");
                            int cat_id= jsonObj.getInt("category_id");
                            String author = jsonObj.getString("created_by");

                            Details detail = new Details(photo_id, title, description, image, cat_id, author);
                            alDetails.add(detail);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    aaDetails.notifyDataSetChanged();
                }
            };
    // Code for step 2 end
}
