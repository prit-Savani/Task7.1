package com.example.task71;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowItemsActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list every time the activity is resumed
        ArrayAdapter<LostFoundItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, DataHolder.items);
        ListView listView = findViewById(R.id.listViewItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra("item_index", position);
            startActivity(intent);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);
    }
} 