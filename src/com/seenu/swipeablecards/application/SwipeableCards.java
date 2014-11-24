package com.seenu.swipeablecards.application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import android.app.Application;

public class SwipeableCards extends Application {

	public static SwipeableCards swipCrdObj;
	private RequestQueue mRequestQueue;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		swipCrdObj = this;
	}

	public static SwipeableCards getInstance() {
		return swipCrdObj;
	}

	// volley library methods
	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		// set the default tag if tag is empty
		getRequestQueue().add(req);
	}

	public <T> void addToRequestQueue(Request<T> req) {
		// req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

}
