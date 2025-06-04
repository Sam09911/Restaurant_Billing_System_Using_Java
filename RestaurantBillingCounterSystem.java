import java.util.*;

class RestaurantBiilingSystem
 {

    // Menu items and their prices
    private static final Map<String, Double> MENU_ITEMS = new LinkedHashMap<>();

    static {
        MENU_ITEMS.put("Burger", 5.99);
        MENU_ITEMS.put("Fries", 2.49);
        MENU_ITEMS.put("Coke", 1.99);
        MENU_ITEMS.put("Chicken Wings", 6.49);
        MENU_ITEMS.put("Ice Cream", 3.99);
    }

    // Counter class to simulate the billing counter
    static class Counter extends Thread {
        private final int counterNumber;
        private final Scanner scanner = new Scanner(System.in);

        public Counter(int counterNumber) {
            this.counterNumber = counterNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Counter " + counterNumber + ": Serving Customer");
                showMenu();
                List<String> orderedItems = takeOrder();
                double totalCost = reviewOrder(orderedItems);
                processPayment(totalCost);
                issueBill(totalCost);
                System.out.println("Counter " + counterNumber + ": Customer, please wait for your order.");
            } catch (InterruptedException e) {
                System.out.println("Counter " + counterNumber + " interrupted.");
            }
        }

        // Show the menu with prices
        private void showMenu() {
            System.out.println("Counter " + counterNumber + ": Menu");
            for (Map.Entry<String, Double> entry : MENU_ITEMS.entrySet()) {
                System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
            }
        }

        // Take user input for the order and return the list of ordered items
        private List<String> takeOrder() {
            List<String> orderedItems = new ArrayList<>();
            System.out.println("Counter " + counterNumber + ": Please enter the items you wish to order (type 'done' to finish):");
            while (true) {
                String item = scanner.nextLine().trim();
                if (item.equalsIgnoreCase("done")) {
                    break;
                } else if (MENU_ITEMS.containsKey(item)) {
                    orderedItems.add(item);
                    System.out.println("Added " + item + " to order.");
                } else {
                    System.out.println("Item not on menu. Please try again.");
                }
            }
            return orderedItems;
        }

        // Allow user to review and modify the order, then calculate the total cost
        private double reviewOrder(List<String> orderedItems) {
            while (true) {
                System.out.println("Counter " + counterNumber + ": Your current order:");
                Map<String, Integer> itemCount = new LinkedHashMap<>();
                for (String item : orderedItems) {
                    itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
                }
                for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
                    System.out.println(entry.getValue() + " x " + entry.getKey());
                }
                System.out.println("Would you like to remove any items? (type the item name to remove or 'no' to proceed)");
                String response = scanner.nextLine().trim();
                if (response.equalsIgnoreCase("no")) {
                    break;
                } else if (itemCount.containsKey(response)) {
                    orderedItems.remove(response);
                    System.out.println("Removed " + response + " from order.");
                } else {
                    System.out.println("Item not in order. Please try again.");
                }
            }
            double totalCost = 0;
            for (String item : orderedItems) {
                totalCost += MENU_ITEMS.get(item);
            }
            return totalCost;
        }

        // Simulate payment processing
        private void processPayment(double totalCost) throws InterruptedException {
            System.out.println("Counter " + counterNumber + ": Processing payment of $" + totalCost);
            Thread.sleep(1000); // Simulate time taken to process payment
        }

        // Issue a bill with a token number and total cost
        private void issueBill(double totalCost) throws InterruptedException {
            int tokenNumber = new Random().nextInt(1000) + 1; // Generate a random token number
            System.out.println("Counter " + counterNumber + ": Issuing bill. Token Number: " + tokenNumber + ", Total: $" + totalCost);
            Thread.sleep(1000); // Simulate time taken to issue bill
        }
    }

    public static void main(String[] args) {
        // Create and start a single counter thread
        Thread counter = new Counter(1);
        counter.start();

        try {
            counter.join(); // Wait for the counter to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}