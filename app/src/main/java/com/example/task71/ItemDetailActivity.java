package com.example.task71;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {
    int itemIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemIndex = getIntent().getIntExtra("item_index", -1);
        TextView textItemDetails = findViewById(R.id.textItemDetails);
        Button btnRemove = findViewById(R.id.btnRemove);

        if (itemIndex >= 0 && itemIndex < DataHolder.items.size()) {
            LostFoundItem item = DataHolder.items.get(itemIndex);
            String details = (item.type.equals("Lost") ? "Lost " : "Found ") + item.name + "\n"
                    + item.description + "\n"
                    + item.date + "\n"
                    + item.location + "\n"
                    + "Phone: " + item.phone;
            textItemDetails.setText(details);

            btnRemove.setOnClickListener(v -> {
                DataHolder.items.remove(itemIndex);
                finish();
            });
        } else {
            textItemDetails.setText("Item not found.");
            btnRemove.setEnabled(false);
        }
    }
}
