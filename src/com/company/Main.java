package com.company;

import java.util.Scanner;


public class Main {
    public static String fmt = "%s | %-10s | %-6s | %-8s | %-6s | %-8s\n";
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        JsonReader jsonReader = new JsonReader("product.json");
        Product[] products = jsonReader.getProducts();
        showTable(products);

    }

    private static void showTable(Product[] products) {
        String str = "%-3s | %-3s | %-10s\n";
        int counter = 1;
        System.out.printf(str, "#", "ID", "Name");
        System.out.println("---------------------------");
        for (Product p: products) {
            System.out.printf(str, counter, p.getId(), p.getName());
            counter++;
        }
        System.out.println();
        System.out.println("Выберите товар (введите его в порядковый номер):");
        int chosenProduct = scanner.nextInt();
        showSingleProduct(products[chosenProduct-1], products);

    }

    private static void showSingleProduct(Product product, Product[] products) {
        System.out.printf(fmt, "Id", "Name", "Price", "St.Price", "Code", "State");
        System.out.println("-------------------------------------------------------");
        System.out.printf(fmt, product.getId(), product.getName(), product.getPrice(), product.getStartPrice(),
                product.getHonorary_code(), product.getState().getDescription());
        choseAction(product, products);
    }

    public static void choseAction(Product product, Product[] products) {
        String[] actions = {
                "Выставить на аукцион",
                "Поднять цену",
                "Выдать победителю",
                "Снять с торгов",
                "Отобразить информацию о товаре",
                "Вернуться в список товаров"
        };
        System.out.println("Доступные действия:");
        int counter = 1;
        for (String a : actions) {
            System.out.printf("%s- %s\n", counter++, a);
        }
        System.out.println("Что вы хотите сделать?");
        int chosenActionNumber = scanner.nextInt();
        try {
            switch (chosenActionNumber) {
                case 1:
                    product.startSale();
                    break;
                case 2:
                    product.raisePrice();
                    break;
                case 3:
                    product.giveToTheWinner();
                    break;
                case 4:
                    product.withDraw();
                    break;
                case 5:
                    showSingleProduct(product, products);
                    break;
                case 6:
                    showTable(products);
                    break;
            }
            showSingleProduct(product, products);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showSingleProduct(product, products);
        }
    }
}

