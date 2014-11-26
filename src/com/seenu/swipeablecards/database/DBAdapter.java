package com.seenu.swipeablecards.database;

import com.seenu.swipeablecards.pojo.Products.Product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {

	// database name
	public static final String DATABASE_NAME = "SwipeCardsDB";

	// table name
	public static final String TABLE_NAME = "favorites";

	// database version
	public static final int DATABASE_VERSION = 1;

	// defining columns
	public static final String COL_ROWID = "_id";
	public static final String COL_PRODUCT = "product";
	public static final String COL_UPVOTES = "upvotes";
	public static final String COL_PRODUCT_TEXT = "productText";
	public static final String COL_PRODUCT_SOURCE = "productSource";
	public static final String COL_DESCRIPTION = "description";

	private final String CREATE_TABLE = "create table favorites"
			+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "product text not null,upvotes text not null,"
			+ "productText text not null,productSource text not null,"
			+ "description text not null) ";

	private Context context;
	private DBHelper dbHelper;
	private SQLiteDatabase db;

	public DBAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		dbHelper = new DBHelper(context);
	}

	public DBAdapter openDatabase() {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	public long insertRecord(Product pdt) {
		ContentValues con = new ContentValues();

		String product = pdt.getProduct();
		String upvotes = pdt.getUpvotes();
		String productText = pdt.getProductText();
		String productSource = pdt.getProductSource();
		String description = pdt.getDescription();

		con.put(COL_PRODUCT, product);
		con.put(COL_UPVOTES, upvotes);
		con.put(COL_PRODUCT_TEXT, productText);
		con.put(COL_PRODUCT_SOURCE, productSource);
		con.put(COL_DESCRIPTION, description);

		return db.insert(TABLE_NAME, null, con);
	}

	public Cursor getAllRecords() {
		String[] columns = { COL_ROWID, COL_PRODUCT, COL_UPVOTES,
				COL_PRODUCT_TEXT, COL_PRODUCT_SOURCE, COL_DESCRIPTION };
		return db.query(TABLE_NAME, columns, null, null, null, null, null);

	}

	private class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(CREATE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

}
