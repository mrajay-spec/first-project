// Custom Comparable interface
interface Comparable {
    int compareTo(Object o);
}

// Product class implementing Comparable
class Product implements Comparable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Compare products by price
    public int compareTo(Object o) {
        Product p = (Product) o;
        if (this.price > p.price) return 1;
        else if (this.price < p.price) return -1;
        else return 0;
    }

    // For printing product details
    public String toString() {
        return name + " - $" + price;
    }
}

// Main class to test sorting
public class ProductSortDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop", 75000),
            new Product("Phone", 30000),
            new Product("Tablet", 20000),
            new Product("Monitor", 15000)
        };

        // Bubble sort using compareTo
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].compareTo(products[j+1]) > 0) {
                    Product temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
            }
        }

        // Print sorted products
        System.out.println("Products sorted by price:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
