package com.aleludovici.myenhancedsharedpreferences;

import android.app.Application;
import android.content.Context;

/* 
 * Singleton used to get the Application context from outside an activity
 */
public class AppContext extends Application {

    private static AppContext instance;

    private AppContext() {
    	instance = this;
    }
    
    public static Context getContext() {
    	if (instance  == null) instance = new AppContext();
    	return instance;
    }
}
