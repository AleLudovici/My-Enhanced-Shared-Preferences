package com.aleludovici.myenhancedsharedpreferences;

import java.util.Set;

import org.json.JSONObject;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

public class MyEditor implements SharedPreferences.Editor {
	
	private Editor _editor;
	
	public MyEditor(Editor editor){
		_editor = editor;
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	public void apply() {
		_editor.apply();
	}

	@Override
	public Editor clear() {
		return _editor.clear();
	}

	@Override
	public boolean commit() {
		return _editor.commit();
	}

	@Override
	public Editor putBoolean(String key,
			boolean value) {
		return _editor.putBoolean(key, value);
	}

	@Override
	public Editor putFloat(String key,
			float value) {
		return _editor.putFloat(key, value);
	}

	@Override
	public Editor putInt(String key, int value) {
		return _editor.putInt(key, value);
	}

	@Override
	public Editor putLong(String key,
			long value) {
		return _editor.putLong(key, value);
	}

	@Override
	public Editor putString(String key,
			String value) {
		return _editor.putString(key, value);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public Editor putStringSet(String arg0,
			Set<String> arg1) {
		return _editor.putStringSet(arg0, arg1);
	}

	@Override
	public Editor remove(String key) {
		return _editor.remove(key);
	}
	
	// Extend editor
	public Editor putDouble(String key, double value){
		return _editor.putLong(key, Double.doubleToRawLongBits(value));
	}
	
	public Editor putJson(String key, JSONObject value){
		return _editor.putString(key, value.toString());
	}
}
