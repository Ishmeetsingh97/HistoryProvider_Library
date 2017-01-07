# HistoryProvider_Library
[![API](https://img.shields.io/badge/API-10%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=10)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Fontometrics-green.svg?style=flat)](https://android-arsenal.com/details/1/5042)
[![License](http://img.shields.io/:license-Apache 2.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)<br/>
History Provider is a simple library that stores your typed history inside a Database using the concept of Content providers, making the history database available to any application in the phone.<br/><br/>
![alt tag](https://github.com/Ishmeetsingh97/HistoryProvider_Library/blob/master/HistoryProvider.gif)
##Installation
####Add gradle dependency with command:
```groovy
dependencies {
    compile 'org.ishmeetsingh.androbot:historyprovider:1.0.0'
    }
```
####By using Maven:
```groovy
<dependency>
  <groupId>org.ishmeetsingh.androbot</groupId>
  <artifactId>historyprovider</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
##Implementation
These steps are required to implement HistoryProvider in your Android Project:<br/>
1. Make a new class and `implements` Cursor Loader `android.app.LoaderManager.LoaderCallbacks<Cursor>` and Override all the methods.<br/>
2. Make an `Listview` and make an Adapter for it.<br/>
3. In the MainActivity, Define an EditText by `findViewById()`  and make a method to store words in the Database like this:<br/>
```groovy
String name = EditText_Name.getText().toString().trim();
ContentValues values = new ContentValues();
values.put(WordContract.WordEntry.COLUMN_WORD_NAME,name);
Uri newUri = getContentResolver().insert(WordContract.WordEntry.CONTENT_URI, values);
```
###FULL IMPLEMENTATION FOR ABOVE STEPS IS PROVIDED IN THE SAMPLE APP.
##Additional Important Requirement:
 Define the Content Provider in the Manifest file like this(No Values should be changed here excluding the provider name):
```groovy
<provider
android:name="com.example.historyprovider_library.WordsProvider"
android:authorities="com.example.android.words"
android:enabled="true"
android:exported="true"
android:multiprocess="true" />
```
####For any problems using HistoryProvider, Refer the Sample App or Contact me at `ishmeet.1136@gmail.com`
