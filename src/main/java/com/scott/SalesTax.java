package com.scott;

import com.scott.controller.SalesTaxController;
import com.scott.dto.InputItem;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesTax {

    public static final String DONE = "done";

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String item, qty, price;

        SalesTaxController controller = new SalesTaxController();
        System.out.println("Welcome to the Sales Tax Calculator\n");
        System.out.print("Please type DONE after your last item, to calculate the total.\n");

        boolean done = false;
        while (!done) {
            System.out.print("Please enter your item name:\n");
            item = scanner.next();
            if (item.toLowerCase().equalsIgnoreCase(DONE)) {
                done = true;
            } else {
                System.out.print("Please enter the quantity of " + item + " that you are purchasing:\n");
                qty = scanner.next();
                System.out.print("Please enter the price of " + item + " that you are purchasing:\n");
                price = scanner.next();

                //TODO: check types and cleanup
                Integer parsedQty = Integer.parseInt(qty);
                BigDecimal parsedPrice = new BigDecimal(price);
                controller.getInputItems().add(new InputItem(item, parsedQty, parsedPrice));
            }
        }
        controller.calculateAndPrintReceipt();
    }
}
