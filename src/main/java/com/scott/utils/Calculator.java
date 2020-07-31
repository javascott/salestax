package com.scott.utils;

import com.scott.controller.SalesTaxController;
import com.scott.dto.InputItem;
import com.scott.model.ItemTaxRates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {

    public BigDecimal getSubTotal(InputItem inputItem) {
        return inputItem.getPrice().multiply(new BigDecimal(inputItem.getQuantity()));
    }

    public BigDecimal getSalesTax(InputItem inputItem, List<ItemTaxRates> skuLibrary, BigDecimal subtotal) {
        BigDecimal salesTax = SalesTaxController.ZERO_RATE;
        BigDecimal rate = SalesTaxController.DEFAULT_TAX_RATE;

        //doing this so we can read the string, if they had a variable on input, I wouldn't have to search
        boolean imported = inputItem.getItemName().toLowerCase().indexOf(SalesTaxController.IMPORTED_SEARCH_STRING) > -1;

        for (ItemTaxRates rateItem: skuLibrary) {
            if (inputItem.getItemName().toLowerCase().indexOf(rateItem.getItem().toLowerCase()) > -1) {
                //item matched, use this rate
                rate = rateItem.getTaxRate().getTaxRate();
                break;
            }
        }
        //calculate sales tax
        salesTax = subtotal.multiply(rate);

        //if imported, add extra rate
        if (imported) {
            if (rate.compareTo(SalesTaxController.ZERO_RATE) > 0) {
                BigDecimal importTax = subtotal.multiply(SalesTaxController.IMPORTED_TAX_RATE);
                salesTax = salesTax.add(importTax);
            } else {
                salesTax = subtotal.multiply(SalesTaxController.IMPORTED_TAX_RATE);
            }
        }

        return salesTax;
    }
}
