package com.scott.controller;

import com.scott.model.ItemTaxRates;
import com.scott.model.TaxRates;
import com.scott.dto.InputItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesTaxController {

    //using a static map, but could be moved to a DB.  Maybe wire in h2 for simple example
    public static List<ItemTaxRates> skuLibrary;
    public static final BigDecimal IMPORTED_TAX_RATE = new BigDecimal(1.05);
    public static final BigDecimal DEFAULT_TAX_RATE = new BigDecimal(1.1);
    public List<InputItem> inputItems = new ArrayList<InputItem>();

    static void setupSkuLibrary() {
        //initialize before startup
        TaxRates exemptRates = new TaxRates("exempt", new BigDecimal(0));
        skuLibrary = new ArrayList<ItemTaxRates>();
        skuLibrary.add(new ItemTaxRates("book", exemptRates));
        skuLibrary.add(new ItemTaxRates("chocolate", exemptRates));
        skuLibrary.add(new ItemTaxRates("pills", exemptRates));
    }


    public void calculateAndPrintReceipt() {
        for (InputItem inputItem: inputItems) {
            System.out.println(inputItem.getItemName());
        }
    }

    public static List<ItemTaxRates> getSkuLibrary() {
        return skuLibrary;
    }

    public List<InputItem> getInputItems() {
        return inputItems;
    }
}
