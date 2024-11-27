public class ProductInfo {

    public String product;
    public int price;

    public ProductInfo(String product, int price) {
        this.product = product;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "product='" + product + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
