package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int waterStorage;
    private int milkStorage;
    private int coffeeBeansStorage;
    private int disposableCupsStorage;
    private int moneyStorage;
    private boolean exit = false;

    public CoffeeMachine() {
        waterStorage = 400;
        milkStorage = 540;
        coffeeBeansStorage = 120;
        disposableCupsStorage = 9;
        moneyStorage = 550;
    }


    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (!coffeeMachine.exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            coffeeMachine.doAction(action);
        }
    }

    public void doAction(String action) {
        switch (action) {
            case "buy" -> buyDrink();
            case "fill" -> addSupplies();
            case "take" -> giveMoney();
            case "remaining" -> printCoffeeMachineStorage();
            case "exit" -> this.exit = true;
            default -> System.out.println("Wrong command");
        }
    }

    private void buyDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String actionDrink = scanner.nextLine();
        int currentDrinkNumber;
        if ("back".contains(actionDrink)) {
            return;
        } else if ("exit".contains(actionDrink)) {
            exit = true;
            return;
        } else {
            currentDrinkNumber = Integer.parseInt(actionDrink);
        }

        Drink currentDrink = new Drink(currentDrinkNumber);
        if (this.waterStorage >= currentDrink.getNeedWater()) {
            this.waterStorage -= currentDrink.getNeedWater();
        } else {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (this.milkStorage >= currentDrink.getNeedMilk()) {
            this.milkStorage -= currentDrink.getNeedMilk();
        } else {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (this.coffeeBeansStorage >= currentDrink.getNeedCoffeeBeans()) {
            this.coffeeBeansStorage -= currentDrink.getNeedCoffeeBeans();
        } else {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        if (this.disposableCupsStorage >= 1) {
            this.disposableCupsStorage -= 1;
        } else {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        this.moneyStorage += currentDrink.getPriceOfDrink();

    }

    private void addSupplies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.waterStorage += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        this.milkStorage += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeansStorage += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add: ");
        this.disposableCupsStorage += Integer.parseInt(scanner.nextLine());
    }

    private void printCoffeeMachineStorage() {
        System.out.printf("""
                The coffee machine has:
                %d  ml of water
                %d  ml of milk
                %d  g of coffee beans
                %d  disposable cups
                $%d of money
                """, this.waterStorage, this.milkStorage, this.coffeeBeansStorage, this.disposableCupsStorage, this.moneyStorage);
    }

    private void giveMoney() {
        System.out.println("I gave you $" + this.moneyStorage);
        this.moneyStorage = 0;
    }
}
