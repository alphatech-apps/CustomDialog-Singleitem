package com.jakir.customdialogsingleitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class CustomDialogSingleItem {

    private final Context context;

    public interface OnItemSelectedListener {
        void onItemSelected(String selectedValue);
    }

    public CustomDialogSingleItem(Context context) {
        this.context = context;
    }

    public void showCustomDialogSingleItem(String tittle, String defValue, String[] itemsName, String[] itemsValues, OnItemSelectedListener callback) {
        final int[] selectedPosition = {-1};
        for (int i = 0; i < itemsValues.length; i++) {
            if (itemsValues[i].equals(defValue)) {
                selectedPosition[0] = i;
                break;
            }
        }

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setCancelable(true);
        builder.setTitle(tittle);

        ListAdapter adapter = new ArrayAdapter<>(context, R.layout.custom_dialog_item, R.id.item_text, itemsValues) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(R.id.item_text);
                ImageView check = view.findViewById(R.id.check_icon);
                tv.setText(itemsName[position]);
                check.setVisibility(position == selectedPosition[0] ? View.VISIBLE : View.GONE);
                return view;
            }
        };

        builder.setAdapter(adapter, (dialog, which) -> {
            String selectedValue = itemsValues[which];
            callback.onItemSelected(selectedValue);
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
