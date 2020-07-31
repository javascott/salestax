package com.scott.controller;

import com.scott.model.ItemTaxRates;
import com.scott.model.TaxRates;
import com.scott.dto.InputItem;
import com.scott.utils.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SalesTaxController {

    //using a static map, but could be moved to a DB.  Maybe wire in h2 for simple example
    public List<ItemTaxRates> skuLibrary;
    public static final BigDecimal IMPORTED_TAX_RATE = new BigDecimal(.05).setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal DEFAULT_TAX_RATE = new BigDecimal(.1).setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal ZERO_RATE = BigDecimal.ZERO;
    public List<InputItem> inputItems;
    public static final String IMPORTED_SEARCH_STRING = "import";

    public SalesTaxController() {
        //initialize before startup
        TaxRates exemptRates = new TaxRates("exempt", ZERO_RATE);
        skuLibrary = new ArrayList<ItemTaxRates>();
        inputItems = new ArrayList<InputItem>();
        skuLibrary.add(new ItemTaxRates("book", exemptRates));
        skuLibrary.add(new ItemTaxRates("chocolate", exemptRates));
        skuLibrary.add(new ItemTaxRates("pills", exemptRates));
    }


    public BigDecimal calculateAndPrintReceipt() {
        BigDecimal runningSubTotal = ZERO_RATE;
        BigDecimal runningSalesTax = ZERO_RATE;
        Calculator c = new Calculator();
        System.out.println("Output:");
        for (InputItem inputItem: inputItems) {
            BigDecimal subtotal = c.getSubTotal(inputItem);
            BigDecimal salesTax = c.getSalesTax(inputItem, getSkuLibrary(), subtotal);
            System.out.println(inputItem.getQuantity() + " " + inputItem.getItemName() + " " + subtotal.add(salesTax).setScale(2, RoundingMode.HALF_UP));
            runningSubTotal = runningSubTotal.add(subtotal);
            runningSalesTax = runningSalesTax.add(salesTax);
        }
        System.out.println("Sales Taxes: " + runningSalesTax.setScale(2, RoundingMode.HALF_UP));
        BigDecimal total = runningSubTotal.add(runningSalesTax).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Total: " + total);
        return total;
    }

    public void addInputItem(InputItem inputItem) {
        getInputItems().add(inputItem);
    }

    private List<ItemTaxRates> getSkuLibrary() {
        return skuLibrary;
    }

    private List<InputItem> getInputItems() {
        return inputItems;
    }
}
