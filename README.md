# Restaurant_Billing_System_Using_Java

## Overview

The Restaurant Billing Counter is a Java application that simulates a billing counter at a fast-food restaurant. This program demonstrates a multithreaded approach where a single counter thread handles customer orders, processes payments, and issues bills.

## Features

- **Menu Display**: Shows a predefined menu with items and their prices.
- **Order Taking**: Allows customers to input their orders and provides feedback on whether the items are on the menu.
- **Order Review**: Lets customers review and modify their order before finalizing it.
- **Payment Processing**: Simulates payment processing with a delay to mimic real-world scenarios.
- **Bill Issuance**: Generates a bill with a random token number for the order.

## Installation

1. Ensure that you have the Java Development Kit (JDK) installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or install it via a package manager on Linux.

2. Save the provided code in a file named `RestaurantBillingCounter.java`.

3. Open a terminal or command prompt.

4. Navigate to the directory containing `RestaurantBillingCounter.java`.

5. Compile the Java program using the following command:

    ```bash
    javac RestaurantBillingCounter.java
    ```

6. Run the compiled Java program using the following command:

    ```bash
    java RestaurantBillingCounter
    ```

## Usage

1. When the program starts, it simulates a customer being served at the billing counter.

2. The menu items and their prices will be displayed.

3. Enter the names of the items you wish to order, one by one. Type `done` when you have finished ordering.

4. Review the current order. You can remove any items by typing their names or proceed by typing `no`.

5. The program will then simulate processing the payment and issue a bill with a random token number.

6. The counter will print a message indicating that the customer should wait for their order.

## Code Explanation

- **Class `RestaurantBillingCounter`**: The main class that contains the application logic.
  
- **Static Menu Items**: A `LinkedHashMap` to store menu items and their prices.

- **Inner Class `Counter`**: Extends `Thread` to handle order processing in a separate thread. This class includes methods to:
  - `showMenu()`: Display the menu items.
  - `takeOrder()`: Collect items ordered by the customer.
  - `reviewOrder()`: Allow the customer to review and modify their order.
  - `processPayment()`: Simulate payment processing.
  - `issueBill()`: Simulate bill issuance with a random token number.

- **Main Method**: Creates and starts a `Counter` thread to simulate serving a customer.
