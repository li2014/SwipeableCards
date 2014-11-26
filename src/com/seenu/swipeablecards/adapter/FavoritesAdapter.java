package com.seenu.swipeablecards.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seenu.swipeablecards.R;
import com.seenu.swipeablecards.database.DBAdapter;

public class FavoritesAdapter extends CursorAdapter {

	private Context context;

	public FavoritesAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public void bindView(View view, Context arg1, Cursor cursor) {
		// TODO Auto-generated method stub

		ViewHolder holder = (ViewHolder) view.getTag();

		String pdtText = cursor.getString(cursor
				.getColumnIndex(DBAdapter.COL_PRODUCT_TEXT));
		String desc = cursor.getString(cursor
				.getColumnIndex(DBAdapter.COL_DESCRIPTION));
		String pdtLink = cursor.getString(cursor
				.getColumnIndex(DBAdapter.COL_PRODUCT));
		String upvotes = cursor.getString(cursor
				.getColumnIndex(DBAdapter.COL_UPVOTES));

		// setting text for the item textviews
		holder.pdtTextTv.setText(pdtText);
		holder.descTv.setText(desc);
		holder.pdtLnkTv.setText(pdtLink);
		holder.upvotesTv.setText("upvotes: " + upvotes);

	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.favs_lv_items, null);
		ViewHolder holder = new ViewHolder();

		// initialization
		holder.pdtTextTv = (TextView) view.findViewById(R.id.textView1);
		holder.descTv = (TextView) view.findViewById(R.id.textView2);
		holder.pdtLnkTv = (TextView) view.findViewById(R.id.textView3);
		holder.upvotesTv = (TextView) view.findViewById(R.id.textView4);

		// holder.deleteImg.setVisibility(View.INVISIBLE);

		view.setTag(holder);

		return view;
	}

	private static class ViewHolder {
		private TextView pdtTextTv;
		private TextView descTv;
		private TextView pdtLnkTv;
		private TextView upvotesTv;
	}

}
