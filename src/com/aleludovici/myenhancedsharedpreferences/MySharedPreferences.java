package com.aleludovici.myenhancedsharedpreferences;

import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

@SuppressLint("CommitPrefEdits")
public class MySharedPreferences implements SharedPreferences {

	private SharedPreferences _sharedPreferences;

	private MySharedPreferences(SharedPreferences prefs){
		_sharedPreferences = prefs;
	}
	
	public static MySharedPreferences getSharedPreferences(String name, int mode){
		return new MySharedPreferences(AppContext.getContext().getSharedPreferences(name, mode));
	}

	@Override
	public boolean contains(String key) {
		return _sharedPreferences.contains(key);
	}

	@Override
	public MyEditor edit() {
		return new MyEditor(_sharedPreferences.edit());
	}

	@Override
	public Map<String, ?> getAll() {
		return _sharedPreferences.getAll();
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		return _sharedPreferences.getBoolean(key, defValue);
	}

	@Override
	public float getFloat(String key, float defValue) {
		return _sharedPreferences.getFloat(key, defValue);
	}

	@Override
	public int getInt(String key, int defValue) {
		return _sharedPreferences.getInt(key, defValue);
	}

	@Override
	public long getLong(String key, long defValue) {
		return _sharedPreferences.getLong(key, defValue);
	}

	@Override
	public String getString(String key, String defValue) {
		return _sharedPreferences.getString(key, defValue);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		return _sharedPreferences.getStringSet(arg0, arg1);
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		_sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		_sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
	}

	// extend
	public double getDouble(String key, double defValue){
		return Double.longBitsToDouble(_sharedPreferences.getLong(key, Double.doubleToRawLongBits(defValue)));
	}

	public JSONObject getJson(String key, JSONObject defValue) throws JSONException{
		return new JSONObject(_sharedPreferences.getString(key, defValue.toString()));
	}
}