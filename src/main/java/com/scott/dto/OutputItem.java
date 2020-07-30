package com.scott.dto;

import java.math.BigDecimal;

public class OutputItem extends InputItem {

    private BigDecimal fullprice;
    private boolean imported;

    public BigDecimal getFullprice() {
        return fullprice;
    }

    public void setFullprice(BigDecimal fullprice) {
        this.fullprice = fullprice;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
}
