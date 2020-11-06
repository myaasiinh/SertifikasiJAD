package com.ecomerce.activity;

import android.os.Bundle;

import com.ecomerce.R;
import com.ecomerce.model.Image;import com.ecomerce.adapter.ImageAdapter;import com.ecomerce.database.SharedPref;import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.ecomerce.activity.MainActivity.imageLis;

public class KeranjangActivity extends AppCompatActivity {
    List<Image> data = new ArrayList<>();
    int i;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);
        recyclerView = findViewById(R.id.MiliaderRv);

        try {
            JSONArray jsonArray = new JSONArray(SharedPref.GetId(this));
            for (i = 0 ; i < jsonArray.length(); i++){
                JSONObject a = jsonArray.getJSONObject(i);
                data.add(new Image(
                        Integer.parseInt(a.getString("imageSrc")),
                        Integer.parseInt(a.getString("imageId")),
                        a.getString("imageDesc"),
                        a.getString("imageDesc1")
                ));
                Log.d("TAG", "onCreate: " + a.getString("imageDesc1"));
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(KeranjangActivity.this));
            recyclerView.setHasFixedSize(true);
            ImageAdapter adapter = new ImageAdapter(KeranjangActivity.this, data, null);
            recyclerView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

