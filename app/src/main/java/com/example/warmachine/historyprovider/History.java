package com.example.warmachine.historyprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.historyprovider_library.WordContract;

public class History extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    WordCursorAdapter mCursorAdapter;
    private static final int WORD_LOADER = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView wordListView = (ListView) findViewById(R.id.list);
        mCursorAdapter = new WordCursorAdapter(this, null);
        wordListView.setAdapter(mCursorAdapter);

        getLoaderManager().initLoader(WORD_LOADER, null,this);
    }


    @Override
    public android.content.Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                WordContract.WordEntry._ID,
                WordContract.WordEntry.COLUMN_WORD_NAME};

        return new android.content.CursorLoader(this,
                WordContract.WordEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
}
