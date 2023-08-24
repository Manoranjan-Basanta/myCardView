package com.example.m2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressAdpter extends RecyclerView.Adapter<AddressAdpter.ViewHolder> {
    private JSONArray jsonArray;
    private Context context;
    public AddressAdpter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new AddressAdpter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            JSONObject testJSONObject = jsonArray.getJSONObject(position);
            Toast.makeText(context, testJSONObject.getString("name"), Toast.LENGTH_SHORT).show();
            holder.test_name1.setText(testJSONObject.getString("name"));
            holder.test_postal.setText(testJSONObject.getString("postal_code"));
            holder.test_address.setText(testJSONObject.getString("address"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount(){
        return jsonArray.length();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView test_name1, test_address, test_postal;
        ViewHolder(View itemView) {
            super(itemView);
            test_name1 = itemView.findViewById(R.id. test_name1);
            test_address  = itemView.findViewById(R.id.test_address);
            test_postal=itemView.findViewById(R.id.test_postal);
        }
    }
}
