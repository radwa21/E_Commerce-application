import  java.util.*;
public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                productList.remove(product);
                break;
            }
        }
    }

    public void viewAllProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void updateStock(int productId, int newStock) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                product.setStockQuantity(newStock);
                break;

            }
        }
    }
}
