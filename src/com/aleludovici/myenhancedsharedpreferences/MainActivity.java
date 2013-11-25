package com.aleludovici.myenhancedsharedpreferences;

import java.io.IOException;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private TextView display;
	private final String TAG = MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button set = (Button) findViewById(R.id.button1);
		set.setOnClickListener(this);
		Button get = (Button) findViewById(R.id.button2);
		get.setOnClickListener(this);
		display = (TextView) findViewById(R.id.display);
	}
	
	private MySharedPreferences getPrefs(){
		return MySharedPreferences.getSharedPreferences(
				"test", Context.MODE_PRIVATE);
	} 
	
	private void setLocation(){
		if (Geocoder.isPresent()){
			try {
				Geocoder gc =  new Geocoder(getApplicationContext());
				List<Address> address = gc.getFromLocationName("carrer gran capita, Barcelona, 08034", 1);
				double lat = address.get(0).getLatitude();
				double lng = address.get(0).getLongitude();
				final MySharedPreferences prefs = getPrefs();
				MyEditor editor = prefs.edit();
				editor.putDouble("LATITUDE", lat);
				editor.putDouble("LONGITUDE", lng);
				editor.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Log.d(TAG, "button 1");
			setLocation();
			break;
		case R.id.button2:
			Log.d(TAG, "button 2");
			final MySharedPreferences prefs = getPrefs();	
			double[] data = {prefs.getDouble("LATITUDE", 0.0), 
					prefs.getDouble("LONGITUDE", 0.0)};
			String stringToDisplay = "latitude:" + data[0] + " longitude:" + data[1];
			Log.d(TAG, stringToDisplay);
			display.setText(stringToDisplay);
			break;
		}
	}

}
