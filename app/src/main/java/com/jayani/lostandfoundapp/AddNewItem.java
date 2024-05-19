package com.jayani.lostandfoundapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class AddNewItem extends AppCompatActivity {
    RadioButton lost, found;
    EditText name,phone,description,date,location;

    int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    Button createItem;
    private Integer postType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_item);

        lost = findViewById(R.id.rlost);
        found = findViewById(R.id.rFound);
        name = findViewById(R.id.itemName);
        phone = findViewById(R.id.phoneNumber);
        description = findViewById(R.id.itemDes);
        date =findViewById(R.id.itemDate);
        location =findViewById(R.id.location);
        createItem =findViewById(R.id.btnSave);
        lost.setChecked(true);
        found.setChecked(false);


        date.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(this,
                        (view1, year, monthOfYear, dayOfMonth) -> {
                            date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            datePickerDialog.dismiss();
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
            return true;
        });

        createItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (validateFields()) {
                if (found.isChecked()){
                    postType = 1;
                }else {
                    postType = 0;
                }
                    dbHelper db = new dbHelper(AddNewItem.this);
                    itemModel itemModel = new itemModel(postType,name.getText().toString(),phone.getText().toString(),description.getText().toString(),date.getText().toString(),location.getText().toString());
                    db.addItem(itemModel);
                    itemAdapter.notifyChange();
                    Toast.makeText(AddNewItem.this, "Add Task Successfully", Toast.LENGTH_SHORT).show();
                    finish();

//                    startActivity(getIntent());
//                }

            }
        });
    }
}