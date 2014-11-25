package com.seenu.swipeablecards;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.seenu.swipeablecards.application.SwipeableCards;
import com.seenu.swipeablecards.pojo.Products;
import com.seenu.swipeablecards.swipecards.SwipeFlingAdapterView;

public class MainActivity extends ActionBarActivity {

	private final String url = "https://api.import.io/store/data/c4e9791d-a2cc-4ce7-807d-aced4ee29ecd/_query?input/webpage/url=http://www.producthunt.com/&_user=a31791af-10fa-4234-9e23-508d6c7838e7&_apikey=EHJSRe1mjAgGkREpxEh4nTK385HVh1apflVdRjtwHW/7mIYy0a6meoIXt5MGQHQUFJxRBSORj8SnAWvoelhctw==";

	private final String TAG = getClass().getSimpleName();

	private Products pdtsObj;

	private ArrayAdapter<String> adapter;

	private SwipeFlingAdapterView flingContainer;

	private ArrayList<String> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card_swipe);

		flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

		al = new ArrayList<String>();
		al.add("php");
		al.add("c");
		al.add("python");
		al.add("java");
		al.add("html");
		al.add("c++");
		al.add("css");
		al.add("javascript");

		adapter = new ArrayAdapter<String>(this, R.layout.card_swipe_item,
				R.id.textView1, al);
		flingContainer.setAdapter(adapter);

		flingContainer
				.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
					@Override
					public void removeFirstObjectInAdapter() {
						// this is the simplest way to delete an
						// object from the Adapter
						// (/AdapterView)
						Log.d("LIST", "removed object!");
					}

					@Override
					public void onLeftCardExit(Object dataObject) {
						// Do something on the left!
						// You also have access to the original
						// object.
						// If you want to use it just cast it
						// (String) dataObject
						Toast.makeText(MainActivity.this, "Left!",
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onRightCardExit(Object dataObject) {
						Toast.makeText(MainActivity.this, "Right!",
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onAdapterAboutToEmpty(int itemsInAdapter) {
						// Ask for more data here

						Log.d("LIST", "notified");
					}
				});

		// Optionally add an OnItemClickListener
		flingContainer
				.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
					@Override
					public void onItemClicked(int itemPosition,
							Object dataObject) {

						Toast.makeText(MainActivity.this, "Clicked!",
								Toast.LENGTH_SHORT).show();
					}
				});

		// getDataFromServer();
	}

	static void makeToast(Context ctx, String s) {
		Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
	}

	public void right() {
		/**
		 * Trigger the right event manually.
		 */
		flingContainer.getTopCardListener().selectRight();
	}

	public void left() {
		flingContainer.getTopCardListener().selectLeft();
	}

	private void getDataFromServer() {
		// TODO Auto-generated method stub

		Log.i(TAG, url);
		JsonObjectRequest jObjReq = new JsonObjectRequest(Method.GET, url,
				null, new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						String result = response.toString();
						Log.i(TAG, result);

						Gson gson = new Gson();
						pdtsObj = gson.fromJson(result, Products.class);

						Log.i(TAG, pdtsObj.getResults().get(0).getProductText());
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});

		SwipeableCards.getInstance().addToRequestQueue(jObjReq);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
