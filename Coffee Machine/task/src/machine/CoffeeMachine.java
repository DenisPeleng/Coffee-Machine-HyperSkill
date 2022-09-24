package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int waterStorage = 400;
    private int milkStorage = 540;
    private int coffeeBeansStorage = 120;
    private int disposableCupsStorage = 9;
    private int moneyStorage = 550;
    private boolean exit = false;


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

            case "buy": {
                buyDrink();
                break;
            }
            case "fill": {
                addSupplies();
                break;
            }
            case "take": {
                giveMoney();
                break;
            }
            case "remaining": {
                printCoffeeMachineStorage();
                break;
            }
            case "exit": {
                this.exit = true;
                break;
            }
            default: {
                System.out.println("Wrong command");
            }
        }
    }

    private void buyDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String actionDrink = scanner.nextLine();
        int currentDrinkNumber;
        if ("back".contains(actionDrink)) {
            return;
        } else {
            currentDrinkNumber = Integer.parseInt(actionDrink);
        }

        Drink currentDrink = chooseReciept(currentDrinkNumber);
        if (this.waterStorage >= currentDrink.needWater) {
            this.waterStorage -= currentDrink.needWater;
        } else {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (this.milkStorage >= currentDrink.needMilk) {
            this.milkStorage -= currentDrink.needMilk;
        } else {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (this.coffeeBeansStorage >= currentDrink.needCoffeeBeans) {
            this.coffeeBeansStorage -= currentDrink.needCoffeeBeans;
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
        this.moneyStorage += currentDrink.priceOfDrink;

    }

    private static Drink chooseReciept(int numberOfDrink) {
        return new Drink(numberOfDrink);
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
                $%d of money\n
                """, this.waterStorage, this.milkStorage, this.coffeeBeansStorage, this.disposableCupsStorage, this.moneyStorage);
    }

    private void giveMoney() {
        System.out.println("I gave you $" + this.moneyStorage);
        this.moneyStorage = 0;
    }
}
