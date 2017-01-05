package com.example.warmachine.historyprovider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.historyprovider_library.WordContract;

public class WordCursorAdapter extends CursorAdapter {

    public WordCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tv = (TextView) view.findViewById(R.id.word);
        int name = cursor.getColumnIndex(WordContract.WordEntry.COLUMN_WORD_NAME);
        String petName = cursor.getString(name);
        tv.setText(petName);

    }
}