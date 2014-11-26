package com.seenu.swipeablecards.adapter;

import java.util.ArrayList;

import com.seenu.swipeablecards.R;
import com.seenu.swipeablecards.pojo.Products.Product;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CardsAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Product> results;
	private int size;

	public CardsAdapter(Context context, ArrayList<Product> results) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.results = results;
		size = results.size();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return results.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder = null;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.card_swipe_item, null);
			holder = new ViewHolder();

			holder.upvotesTv = (TextView) convertView
					.findViewById(R.id.textView1);
			holder.pdtTextTv = (TextView) convertView
					.findViewById(R.id.textView2);
			holder.pdtDescTv = (TextView) convertView
					.findViewById(R.id.textView3);
			holder.pdtLinkTv = (TextView) convertView
					.findViewById(R.id.textView4);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		holder.upvotesTv.setText(results.get(position).getUpvotes());
		holder.pdtTextTv.setText(results.get(position).getProductText());
		holder.pdtDescTv.setText(results.get(position).getDescription());
		holder.pdtLinkTv.setText(results.get(position).getProduct());

		return convertView;
	}

	private static class ViewHolder {

		private TextView upvotesTv;
		private TextView pdtTextTv;
		private TextView pdtDescTv;
		private TextView pdtLinkTv;
	}

}
