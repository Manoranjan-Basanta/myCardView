package com.example.m2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity {
  private   RecyclerView recyclerView;
  private   JSONArray jsonArray;
    private AddressAdpter adpter;
    private String json_data = "{\n" +
            "  \"people\": [\n" +
            "    {\n" +
            "      \"name\": \"John Doe\",\n" +
            "      \"address\": {\n" +
            "        \"street\": \"123 Main Street\",\n" +
            "        \"city\": \"Anytown\",\n" +
            "        \"state\": \"CA\",\n" +
            "        \"postal_code\": \"12345\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Jane Smith\",\n" +
            "      \"address\": {\n" +
            "        \"street\": \"456 Elm Avenue\",\n" +
            "        \"city\": \"Anothercity\",\n" +
            "        \"state\": \"NY\",\n" +
            "        \"postal_code\": \"67890\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Michael Johnson\",\n" +
            "      \"address\": {\n" +
            "        \"street\": \"789 Oak Lane\",\n" +
            "        \"city\": \"Sometown\",\n" +
            "        \"state\": \"TX\",\n" +
            "        \"postal_code\": \"54321\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Emily Brown\",\n" +
            "      \"address\": {\n" +
            "        \"street\": \"321 Pine Street\",\n" +
            "        \"city\": \"Villageville\",\n" +
            "        \"state\": \"IL\",\n" +
            "        \"postal_code\": \"98765\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"William Wilson\",\n" +
            "      \"address\": {\n" +
            "        \"street\": \"567 Maple Avenue\",\n" +
            "        \"city\": \"Townsville\",\n" +
            "        \"state\": \"FL\",\n" +
            "        \"postal_code\": \"13579\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n"
            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       recyclerView=findViewById(R.id.tutu);
       display(json_data);
    }
    private void display(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
             jsonArray = new JSONArray(jsonObject);

            Toast.makeText(this, String.valueOf(jsonArray), Toast.LENGTH_SHORT).show();
            adpter   = new AddressAdpter(jsonArray,getApplicationContext());
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adpter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public  void takeBreathe(){
        Toast.makeText(this, "this is use for testing", Toast.LENGTH_SHORT).show();
    }
    public void takeSleep(){
        Toast.makeText(this, "go to take sleep", Toast.LENGTH_SHORT).show();
    }
}



