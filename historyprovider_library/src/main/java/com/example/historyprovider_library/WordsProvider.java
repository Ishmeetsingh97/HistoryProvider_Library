package com.example.historyprovider_library;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by WarMachine on 11/6/2016.
 */
public class WordsProvider extends ContentProvider {
    public static final String LOG_TAG = WordsProvider.class.getSimpleName();

    public WordDbHelper mDbHelper;
    Cursor cursor;
    public static final int WORDS = 100;
    public static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        mUriMatcher.addURI(WordContract.CONTENT_AUTHORITY, WordContract.WORDS_PATH, WORDS);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new WordDbHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        int match = mUriMatcher.match(uri);
        switch (match) {
            case WORDS:
                cursor = database.query(WordContract.WordEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = mUriMatcher.match(uri);
        switch (match) {
            case WORDS:
                return insertPet(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }


    private Uri insertPet(Uri uri, ContentValues values) {
        String name = values.getAsString(WordContract.WordEntry.COLUMN_WORD_NAME);
        if (name == null) {
            throw new IllegalArgumentException("No Words entered");
        }


        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        long id = database.insert(WordContract.WordEntry.TABLE_NAME, null, values);
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }
        return ContentUris.withAppendedId(uri, id);
    }


    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
