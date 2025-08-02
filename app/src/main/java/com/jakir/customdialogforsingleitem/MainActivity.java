package com.jakir.customdialogforsingleitem;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jakir.customdialogsingleitem.CustomDialogSingleItem;
import com.jakir.pref.Pref;

public class MainActivity extends AppCompatActivity {

    private final String[] items = {"Snooze", "Stop", "Control volume", "Do nothing"};
    private final String[] itemsValues = {"snz", "stp", "cvol", "dono"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String savedValue = Pref.getPref("optionsX", getApplicationContext());
            savedValue = (savedValue == null || savedValue.isEmpty()) ? "snz" : savedValue;

            new CustomDialogSingleItem(this).showCustomDialogSingleItem("Choose Action", savedValue, items, itemsValues, selectedValue -> {
                Pref.setPref(selectedValue, "optionsX", getApplicationContext());
            });
        });
    }
}
