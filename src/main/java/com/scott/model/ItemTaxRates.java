package com.scott.model;

public class ItemTaxRates {

    private String item;
    private TaxRates taxRate;

    public ItemTaxRates() {}

    public ItemTaxRates(String item, TaxRates taxRate) {
        this.item = item;
        this.taxRate = taxRate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TaxRates getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRates taxRate) {
        this.taxRate = taxRate;
    }
}
