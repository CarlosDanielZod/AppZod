package br.com.app.model;

/**
 *
 * @author carlos
 */
public class ProductSalesManagement {
    
    public String product_sales_id;
    public String labor;
    public String cost_additional;
    public String price_sales;
    public String totalPrice_sales;

    public String getProduct_sales_id() {
        return product_sales_id;
    }

    public void setProduct_sales_id(String product_sales_id) {
        this.product_sales_id = product_sales_id;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public String getCost_additional() {
        return cost_additional;
    }

    public void setCost_additional(String cost_additional) {
        this.cost_additional = cost_additional;
    }

    public String getPrice_sales() {
        return price_sales;
    }

    public void setPrice_sales(String price_sales) {
        this.price_sales = price_sales;
    }

    public String getTotalPrice_sales() {
        return totalPrice_sales;
    }

    public void setTotalPrice_sales(String totalPrice_sales) {
        this.totalPrice_sales = totalPrice_sales;
    }
}
