# CustomDialog-Singleitem
### LATEST-VERSION

[![](https://jitpack.io/v/alphatech-apps/CustomDialog-Singleitem.svg)](https://jitpack.io/#alphatech-apps/CustomDialog-Singleitem)

## Install
Add it in your root `build.gradle` at the end of repositories:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency:
```gradle
dependencies {
	        implementation 'com.github.alphatech-apps:CustomDialog-Singleitem:LATEST-VERSION'
	}
```

## Features
* Day Night

## Usage

Setup JAVA:
 ```java
            new CustomDialogSingleItem(this).showCustomDialogSingleItem("Choose Action", savedValue, items, itemsValues, selectedValue -> {
//                Pref.setPref(selectedValue, "optionsX", getApplicationContext());
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
            });
 ```

.
.
.
.
.
.

## full activity for example
.....................
activity_main:
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
 ```

MainActivity:
```java
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


 ```

## Screenshots
![](https://github.com/alphatech-apps/CustomDialog-Singleitem/blob/master/screenshots/Screenshot_20250802-163302.png)
