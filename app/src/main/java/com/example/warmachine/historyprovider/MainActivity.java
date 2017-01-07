package com.example.warmachine.historyprovider;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.historyprovider_library.WordContract;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        InputStream ims = null;
//        try {
//            ims = getAssets().open("pic.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Drawable d = Drawable.createFromStream(ims, null);
        RelativeLayout ll = (RelativeLayout) findViewById(R.id.rl);
        ll.setBackgroundResource(R.drawable.pic);
        et = (EditText) findViewById(R.id.et1);
    }

    public void insertWord(View view){
        et = (EditText) findViewById(R.id.et1);
        String name = et.getText().toString().trim();
        ContentValues values = new ContentValues();
        values.put(WordContract.WordEntry.COLUMN_WORD_NAME,name);
        Toast.makeText(this,"New word inserted in the Database",Toast.LENGTH_LONG).show();
        Uri newUri = getContentResolver().insert(WordContract.WordEntry.CONTENT_URI, values);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,History.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
