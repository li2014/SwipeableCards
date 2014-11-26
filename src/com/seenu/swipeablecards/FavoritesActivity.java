package com.seenu.swipeablecards;

import com.seenu.swipeablecards.adapter.FavoritesAdapter;
import com.seenu.swipeablecards.database.DBAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;

public class FavoritesActivity extends ActionBarActivity {

	private DBAdapter db;
	private Cursor c;

	private ListView lv;
	private FavoritesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favorites_activity);

		lv = (ListView) findViewById(R.id.listView1);

		db = new DBAdapter(FavoritesActivity.this);
		db.openDatabase();

		c = db.getAllRecords();
		c.moveToFirst();

		System.out.println(c.getCount());

		adapter = new FavoritesAdapter(FavoritesActivity.this, c, 0);
		lv.setAdapter(adapter);
		lv.setEmptyView((TextView) findViewById(R.id.textView1));
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		db.close();
		c.close();
	}

}
