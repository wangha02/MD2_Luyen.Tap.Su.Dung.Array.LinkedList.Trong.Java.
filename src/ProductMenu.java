import java.util.Scanner;

public class ProductMenu {
    Scanner scanner;
    private ProductManager pm;

    public ProductMenu() {
        this.scanner = new Scanner(System.in);
        this.pm = new ProductManager();
    }

    private int menu() {
        System.out.println("Lua chon Menu: ");
        System.out.println("1. Add Product");
        System.out.println("2. Show Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Exit ");
        return readMenu(0, 4);

    }

    private int readMenu(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > min && choice <= max) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void addProduct() {
        System.out.println("Enter In Id Product: ");
        int id = readMenu(0, Integer.MAX_VALUE);
        System.out.println("Enter Name Product: ");
        String name = scanner.nextLine();
        System.out.println("Enter Price ");
        int price = readMenu(0, Integer.MAX_VALUE);
        Product p = new Product(id, name, price);
        this.pm.addProduct(p);
    }

    private void showProduct() {
        System.out.println("List Product ");
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            System.out.println("ID: " + p.getId() + " " + "Name: " + p.getName() + " " + "Price: " + p.getPrice());
        }
    }

    private void removeProduct2() {
        System.out.println("Enter id Remove ");
        int id = readMenu(0, Integer.MAX_VALUE);
        if (this.pm.removeProduct(id)) {
            System.out.println("OK nhe");
        } else {
            System.out.println("No Ok ");
        }
    }

    public void begin() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    removeProduct2();
                    break;
                default:
                    break;
            }

        }
    }

}

