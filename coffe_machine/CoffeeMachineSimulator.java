package coffe_machine;

import java.util.Scanner;

public class CoffeeMachineSimulator {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int money;
    private int espressoPrice = 4;
    private int lattePrice = 7;
    private int cappuccinoPrice = 6;
    private int espressoWater = 250;
    private int espressoMilk = 0;
    private int espressoBeans = 16;
    private int latteWater = 350;
    private int latteMilk = 75;
    private int latteBeans = 20;
    private int cappuccinoWater = 200;
    private int cappuccinoMilk = 100;
    private int cappuccinoBeans = 12;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;
    private int totalEarned;

    public CoffeeMachineSimulator() {
        water = 0;
        milk = 0;
        coffeeBeans = 0;
        money = 0;
        espressoCount = 0;
        latteCount = 0;
        cappuccinoCount = 0;
        totalEarned = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Buy");
            System.out.println("2. Fill");
            System.out.println("3. Take");
            System.out.println("4. Show");
            System.out.println("5. Analytics");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    buyCoffee();
                    break;
                case 2:
                    fillIngredients();
                    break;
                case 3:
                    takeMoney();
                    break;
                case 4:
                    showIngredients();
                    break;
                case 5:
                    showAnalytics();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the type of coffee:");
        System.out.println("1. Espresso ($" + espressoPrice + ")");
        System.out.println("2. Latte ($" + lattePrice + ")");
        System.out.println("3. Cappuccino ($" + cappuccinoPrice + ")");

        int coffeeType = scanner.nextInt();
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int coffeePrice = 0;

        switch (coffeeType) {
            case 1:
                waterNeeded = espressoWater;
                milkNeeded = espressoMilk;
                beansNeeded = espressoBeans;
                coffeePrice = espressoPrice;
                break;
            case 2:
                waterNeeded = latteWater;
                milkNeeded = latteMilk;
                beansNeeded = latteBeans;
                coffeePrice = lattePrice;
                break;
            case 3:
                waterNeeded = cappuccinoWater;
                milkNeeded = cappuccinoMilk;
                beansNeeded = cappuccinoBeans;
                coffeePrice = cappuccinoPrice;
                break;
            default:
                System.out.println("Invalid coffee type. Please try again.");
                return;
        }

        if (water < waterNeeded || milk < milkNeeded || coffeeBeans < beansNeeded) {
            System.out.println("Insufficient ingredients to make coffee. Please fill the machine.");
            return;
        }

        System.out.println("Please insert $" + coffeePrice);
        int payment = scanner.nextInt();
        if (payment < coffeePrice) {
            System.out.println("Insufficient payment. Please try again.");
            return;
        }

        water -= waterNeeded;
        milk -= milkNeeded;
        coffeeBeans -= beansNeeded;
        money += coffeePrice;

        switch (coffeeType) {
            case 1:
                espressoCount++;
                break;
            case 2:
                latteCount++;
                break;
            case 3:
                cappuccinoCount++;
                break;
        }

        totalEarned += coffeePrice;

        System.out.println("Coffee dispensed. Enjoy!");
    }

    private void fillIngredients() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount of water to fill:");
        water += scanner.nextInt();
        System.out.println("Please enter the amount of milk to fill:");
        milk += scanner.nextInt();
        System.out.println("Please enter the amount of coffee beans to fill:");
        coffeeBeans += scanner.nextInt();
    }

    private void takeMoney() {
        System.out.println("Money collected: $" + money);
        money = 0;
    }

    private void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee Beans: " + coffeeBeans + " grams");
        System.out.println("Money: $" + money);
    }

    private void showAnalytics() {
        System.out.println("Espresso sold: " + espressoCount);
        System.out.println("Latte sold: " + latteCount);
        System.out.println("Cappuccino sold: " + cappuccinoCount);
        System.out.println("Total earnings: $" + totalEarned);
    }

    public static void main(String[] args) {
        CoffeeMachineSimulator coffeeMachine = new CoffeeMachineSimulator();
        coffeeMachine.run();
    }
}
