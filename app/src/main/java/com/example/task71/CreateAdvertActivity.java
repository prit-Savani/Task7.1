package com.example.task71;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class CreateAdvertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        RadioGroup radioGroupType = findViewById(R.id.radioGroupType);
        EditText editName = findViewById(R.id.editName);
        EditText editPhone = findViewById(R.id.editPhone);
        EditText editDescription = findViewById(R.id.editDescription);
        EditText editDate = findViewById(R.id.editDate);
        EditText editLocation = findViewById(R.id.editLocation);
        Button btnSave = findViewById(R.id.btnSave);

        // Set up date picker
        Calendar calendar = Calendar.getInstance();
        editDate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    String selectedDate = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
                    editDate.setText(selectedDate);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });

        btnSave.setOnClickListener(v -> {
            int selectedId = radioGroupType.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Select Lost or Found", Toast.LENGTH_SHORT).show();
                return;
            }
            String type = ((RadioButton) findViewById(selectedId)).getText().toString();
            String name = editName.getText().toString();
            String phone = editPhone.getText().toString();
            String description = editDescription.getText().toString();
            String date = editDate.getText().toString();
            String location = editLocation.getText().toString();

            if (name.isEmpty() || phone.isEmpty() || description.isEmpty() || date.isEmpty() || location.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            LostFoundItem item = new LostFoundItem(type, name, phone, description, date, location);
            DataHolder.items.add(item);
            Toast.makeText(this, "Advert saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}