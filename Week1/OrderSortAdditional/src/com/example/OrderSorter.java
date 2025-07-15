package com.example;

import java.util.Arrays; 

public class OrderSorter {

    
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) { // The largest element will "bubble" to the end in each pass
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }

    
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            
            int pi = partition(orders, low, high);

            
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice(); 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
           
            if (orders[j].getTotalPrice() <= pivot) {
                i++;

                
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1; // Return the partitioning index
    }


    public static void main(String[] args) {
        Order[] orders = {
            new Order("ORD003", "Alice", 150.75),
            new Order("ORD001", "Bob", 250.00),
            new Order("ORD005", "Charlie", 50.20),
            new Order("ORD002", "David", 1200.50),
            new Order("ORD004", "Eve", 75.99),
            new Order("ORD006", "Frank", 300.00)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

       
        Order[] ordersForBubbleSort = Arrays.copyOf(orders, orders.length); 
        System.out.println("\n--- Sorting using Bubble Sort ---");
        bubbleSort(ordersForBubbleSort);
        System.out.println("Orders after Bubble Sort:");
        printOrders(ordersForBubbleSort);

        
        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length); 
        System.out.println("\n--- Sorting using Quick Sort ---");
        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("Orders after Quick Sort:");
        printOrders(ordersForQuickSort);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
