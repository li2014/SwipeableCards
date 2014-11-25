package com.seenu.swipeablecards.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Products {

	private String offset;
	private ArrayList<Product> results;
	private String connectorVersionGuid;
	private String connectorGuid;
	private String pageUrl;

	public Products() {

		results = new ArrayList<Product>();
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public ArrayList<Product> getResults() {
		return results;
	}

	public void setResults(ArrayList<Product> results) {
		this.results = results;
	}

	public String getConnectorVersionGuid() {
		return connectorVersionGuid;
	}

	public void setConnectorVersionGuid(String connectorVersionGuid) {
		this.connectorVersionGuid = connectorVersionGuid;
	}

	public String getConnectorGuid() {
		return connectorGuid;
	}

	public void setConnectorGuid(String connectorGuid) {
		this.connectorGuid = connectorGuid;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public static class Product {
		private String product;
		private String upvotes;

		@SerializedName("product/_text")
		private String productText;

		@SerializedName("product/_source")
		private String productSource;

		private String description;

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getUpvotes() {
			return upvotes;
		}

		public void setUpvotes(String upvotes) {
			this.upvotes = upvotes;
		}

		public String getProductText() {
			return productText;
		}

		public void setProductText(String productText) {
			this.productText = productText;
		}

		public String getProductSource() {
			return productSource;
		}

		public void setProductSource(String productSource) {
			this.productSource = productSource;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
