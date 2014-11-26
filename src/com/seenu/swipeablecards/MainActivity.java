package com.seenu.swipeablecards;

import java.util.ArrayList;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.seenu.swipeablecards.adapter.CardsAdapter;
import com.seenu.swipeablecards.application.SwipeableCards;
import com.seenu.swipeablecards.pojo.Products;
import com.seenu.swipeablecards.pojo.Products.Product;
import com.seenu.swipeablecards.swipecards.CardContainer;

public class MainActivity extends ActionBarActivity {

	private final String url = "https://api.import.io/store/data/c4e9791d-a2cc-4ce7-807d-aced4ee29ecd/_query?input/webpage/url=http://www.producthunt.com/&_user=a31791af-10fa-4234-9e23-508d6c7838e7&_apikey=EHJSRe1mjAgGkREpxEh4nTK385HVh1apflVdRjtwHW/7mIYy0a6meoIXt5MGQHQUFJxRBSORj8SnAWvoelhctw==";

	private final String TAG = getClass().getSimpleName();

	private Products pdtsObj;

	private ArrayList<String> al;

	private CardContainer mCardContainer;
	private CardsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mCardContainer = (CardContainer) findViewById(R.id.layoutview);

		getDataFromServer();

		Product pdt = new Product();

		pdt.setOnClickListener(new Product.OnClickListener() {
			@Override
			public void OnClickListener() {
				Log.i("Swipeable Cards", "I am pressing the card");
			}
		});
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

						adapter = new CardsAdapter(MainActivity.this,
								pdtsObj.getResults());
						mCardContainer.setAdapter(adapter);

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
