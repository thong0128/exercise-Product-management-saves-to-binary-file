import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeDataToFile(String path, List<Product> productList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(productList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path) throws ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            productList = (List<Product>) ois.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
    public static void printFromList(List<Product> productList) {
        for(Product product : productList) {
            System.out.println(product);
        }
    }
    public static void addProductToFile(Product product, String path) throws ClassNotFoundException {
        List<Product> tempList = readDataFromFile(path);
        tempList.add(product);
        writeDataToFile(path, tempList);
    }

    public static Product findProductFromFile (String path, String id) throws ClassNotFoundException {
        List<Product> tempList = readDataFromFile(path);
        for (Product product : tempList) {
            if (product.getId().equals(id))
                return product;
        }
        System.out.println("Can't find product in " + path);
        return null;
    }
    public static void printFromFile(String path) throws ClassNotFoundException {
        List<Product> tempList = readDataFromFile(path);
        printFromList(tempList);
    }
    public static void printFromFile(String path,String id) throws ClassNotFoundException {
        List<Product> tempList = readDataFromFile(path);
        System.out.println(findProductFromFile(path,id));
    }
    public static int intInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static Product productInput() {
        System.out.print("Enter id: ");
        String id = stringInput();
        System.out.print("Enter name: ");
        String name = stringInput();
        System.out.print("Enter manufacture: ");
        String manufacture = stringInput();
        System.out.print("Enter description: ");
        String description = stringInput();
        System.out.print("Enter price: ");
        int price = intInput();
        return new Product(id, name, manufacture, description, price);
    }
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
        int choice = -1;
        while (choice != 0){
            System.out.println("-------------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Find by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice:");
            choice = intInput();
            switch (choice){
                case 1:
                    addProductToFile(productInput(),pathInput());
                    break;
                case 2:
                    printFromFile(pathInput());
                    break;
                case 3:
                    String path = pathInput();
                    System.out.print("Enter id: ");
                    String id = stringInput();
                    printFromFile(path, id);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static String pathInput() {
        System.out.print("Enter file path: ");
        return stringInput();
    }
}


