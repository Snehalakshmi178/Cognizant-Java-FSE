package com.example;



public class Product implements Comparable<Product> {
	 private String productId;
	 private String productName;
	 private String category;
	 private double price;

	 public Product(String productId, String productName, String category, double price) {
	     this.productId = productId;
	     this.productName = productName;
	     this.category = category;
	     this.price = price;
	 }

	 // Getters
	 public String getProductId() {
	     return productId;
	 }

	 public String getProductName() {
	     return productName;
	 }

	 public String getCategory() {
	     return category;
	 }

	 public double getPrice() {
	     return price;
	 }

	 @Override
	 public String toString() {
	     return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + ", Price=" + price + "]";
	 }

	 // Used for sorting products by productId for binary search
	 @Override
	 public int compareTo(Product other) {
	     return this.productId.compareTo(other.productId);
	 }
}