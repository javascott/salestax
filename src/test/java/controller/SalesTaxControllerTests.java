package controller;

import com.scott.controller.SalesTaxController;
import com.scott.dto.InputItem;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxControllerTests {

    SalesTaxController controller = new SalesTaxController();

    @Test
    public void testCalculateTotal1() {
        InputItem book = new InputItem("book", 1, new BigDecimal(12.49));
        getController().addInputItem(book);
        InputItem cd = new InputItem("music CD", 1, new BigDecimal(14.99));
        getController().addInputItem(cd);
        InputItem bar = new InputItem("chocolate bar", 1, new BigDecimal(0.85));
        getController().addInputItem(bar);
        BigDecimal total = controller.calculateAndPrintReceipt();
        assert (total != null && total.setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP)) ==0);
    }

    @Test
    public void testCalculateTotal2() {
        InputItem chocolates = new InputItem("imported box of chocolates", 1, new BigDecimal(10.0));
        getController().addInputItem(chocolates);
        InputItem bottle = new InputItem("imported bottle of perfume", 1, new BigDecimal(47.50));
        getController().addInputItem(bottle);
        BigDecimal total = controller.calculateAndPrintReceipt();
        assert (total != null && total.setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP)) ==0);
    }

    @Test
    public void testCalculateTotal3() {
        InputItem importedBottle = new InputItem("imported bottle of perfume", 1, new BigDecimal(27.99));
        getController().addInputItem(importedBottle);
        InputItem bottle = new InputItem("bottle of perfume", 1, new BigDecimal(18.99));
        getController().addInputItem(bottle);
        InputItem pills = new InputItem("packet of headache pills", 1, new BigDecimal(9.75));
        getController().addInputItem(pills);
        InputItem chocolates = new InputItem("box of imported chocolates", 1, new BigDecimal(11.25));
        getController().addInputItem(chocolates);
        BigDecimal total = controller.calculateAndPrintReceipt();
        assert (total != null && total.setScale(2, RoundingMode.HALF_UP).compareTo(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP)) ==0);
    }

    public SalesTaxController getController() {
        return controller;
    }
}
