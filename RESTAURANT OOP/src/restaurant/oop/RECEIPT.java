package restaurant.oop;

import java.util.*;

public class RECEIPT {

    private static List<String> receiptItems = new ArrayList<>();
    private static double total = 0;

    public static void addItem(MenuItem item, int quantity) {
        if (item == null || quantity <= 0) return;
        double itemTotal = item.getPrice() * quantity;
        receiptItems.add(quantity + "x " + item.getName() + " - ₱" + itemTotal);
        total += itemTotal;
    }

    public static void clear() {
        receiptItems.clear();
        total = 0;
    }

    public static String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        for (String line : receiptItems) {
            sb.append(line).append("\n");
        }
        sb.append("\nTOTAL: ₱").append(total);
        return sb.toString();
    }

    public static boolean isEmpty() {
        return receiptItems.isEmpty();
    }

    public static void viewReceipt() {
        System.out.println(getReceiptText());
    }
}

class ConfirmPayment{
    
    public static void confirm(){
        if (RECEIPT.isEmpty()) {
            System.out.println("Your receipt is empty. Nothing to confirm.");
            return;
        }
        RECEIPT.viewReceipt();
    }
}

class ClearReceipt{
    public static void clearingReceipt(){
        RECEIPT.clear();
    }
}
