package com.aleludovici.myenhancedsharedpreferences;

import java.util.Map;
import java.util.Set;

import android.content.SharedPreferences;

public class MySharedPreferences implements SharedPreferences {
		
	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Editor edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getFloat(String key, float defValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(String key, int defValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(String key, long defValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getString(String key, String defValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
