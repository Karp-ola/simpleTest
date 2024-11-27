import java.util.Objects;

public class Sale {
    private String product;
    private int quantity;

    public Sale(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return quantity == sale.quantity && Objects.equals(product, sale.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
