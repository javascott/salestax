package com.scott.model;

import java.math.BigDecimal;

public class TaxRates {

    private String label;
    private BigDecimal taxRate;

    public TaxRates() {}

    public TaxRates(String label, BigDecimal tax_rate) {
        this.label = label;
        this.taxRate = tax_rate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
