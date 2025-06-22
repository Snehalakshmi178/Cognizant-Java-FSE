package com.example;

import java.util.*;

public class ProductSearch {

// --- Linear Search Implementation ---
public static Product linearSearch(Product[] products, String searchId) {
   for (int i = 0; i < products.length; i++) {
       // In a real scenario, consider null checks for products[i]
       if (products[i].getProductId().equals(searchId)) {
           return products[i]; // Product found
       }
   }
   return null; // Product not found
}

// --- Binary Search Implementation ---
// Note: For binary search, the array MUST be sorted by the search key (productId)
public static Product binarySearch(Product[] products, String searchId) {
   int low = 0;
   int high = products.length - 1;

   while (low <= high) {
       int mid = low + (high - low) / 2; // To prevent potential integer overflow for very large arrays

       // Compare the middle product's ID with the search ID
       int cmp = products[mid].getProductId().compareTo(searchId);

       if (cmp == 0) {
           return products[mid]; // Product found
       } else if (cmp < 0) {
           low = mid + 1; // Search in the right half
       } else {
           high = mid - 1; // Search in the left half
       }
   }
   return null; // Product not found
}

public static void main(String[] args) {
   // Sample Products (Unsorted for Linear Search initially)
   Product[] products = {
       new Product("P005", "Laptop Pro", "Electronics", 1200.00),
       new Product("P001", "Smartphone X", "Electronics", 800.00),
       new Product("P008", "Desk Chair", "Furniture", 150.00),
       new Product("P003", "Bluetooth Speaker", "Electronics", 75.00),
       new Product("P010", "Coffee Table", "Furniture", 100.00),
       new Product("P002", "Smartwatch 2", "Electronics", 250.00),
       new Product("P007", "Gaming Mouse", "Electronics", 45.00),
       new Product("P004", "Book: Algorithms", "Books", 30.00),
       new Product("P006", "Headphones ANC", "Electronics", 199.00),
       new Product("P009", "Ergonomic Keyboard", "Electronics", 90.00)
   };

   System.out.println("--- Linear Search ---");
   String searchIdLinear1 = "P003";
   Product foundProductLinear1 = linearSearch(products, searchIdLinear1);
   if (foundProductLinear1 != null) {
       System.out.println("Found (Linear, ID " + searchIdLinear1 + "): " + foundProductLinear1);
   } else {
       System.out.println("Product with ID " + searchIdLinear1 + " not found (Linear).");
   }

   String searchIdLinear2 = "P999"; // Not found case
   Product foundProductLinear2 = linearSearch(products, searchIdLinear2);
   if (foundProductLinear2 != null) {
       System.out.println("Found (Linear, ID " + searchIdLinear2 + "): " + foundProductLinear2);
   } else {
       System.out.println("Product with ID " + searchIdLinear2 + " not found (Linear).");
   }

   System.out.println("\n--- Binary Search (Array must be sorted first!) ---");
   // Create a copy and sort it for binary search
   Product[] sortedProducts = Arrays.copyOf(products, products.length);
   Arrays.sort(sortedProducts); // Uses the compareTo method in Product class

   System.out.println("Sorted Products for Binary Search (by Product ID):");
   for (Product p : sortedProducts) {
       System.out.println("  " + p.getProductId() + " - " + p.getProductName());
   }
   System.out.println();

   String searchIdBinary1 = "P006";
   Product foundProductBinary1 = binarySearch(sortedProducts, searchIdBinary1);
   if (foundProductBinary1 != null) {
       System.out.println("Found (Binary, ID " + searchIdBinary1 + "): " + foundProductBinary1);
   } else {
       System.out.println("Product with ID " + searchIdBinary1 + " not found (Binary).");
   }

   String searchIdBinary2 = "P001";
   Product foundProductBinary2 = binarySearch(sortedProducts, searchIdBinary2);
   if (foundProductBinary2 != null) {
       System.out.println("Found (Binary, ID " + searchIdBinary2 + "): " + foundProductBinary2);
   } else {
       System.out.println("Product with ID " + searchIdBinary2 + " not found (Binary).");
   }

   String searchIdBinary3 = "P999"; // Not found case
   Product foundProductBinary3 = binarySearch(sortedProducts, searchIdBinary3);
   if (foundProductBinary3 != null) {
       System.out.println("Found (Binary, ID " + searchIdBinary3 + "): " + foundProductBinary3);
   } else {
       System.out.println("Product with ID " + searchIdBinary3 + " not found (Binary).");
   }
}
}

