package com.example.warmachine.historyprovider;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.historyprovider_library.WordContract;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et1);
    }

    public void insertWord(View view){
        et = (EditText) findViewById(R.id.et1);
        String name = et.getText().toString().trim();
        ContentValues values = new ContentValues();
        values.put(WordContract.WordEntry.COLUMN_WORD_NAME,name);

        Uri newUri = getContentResolver().insert(WordContract.WordEntry.CONTENT_URI, values);
        Intent intent = new Intent(MainActivity.this,History.class);
        startActivity(intent);
    }
}
