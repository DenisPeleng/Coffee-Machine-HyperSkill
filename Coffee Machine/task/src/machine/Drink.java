package machine;

public class Drink {
    public static int needWater;
    public static int needMilk;
    public static int needCoffeeBeans;
    public static int priceOfDrink;

    Drink(int drink) {
        switch (drink) {
            case 1: {
                //ESPRESSO
                needWater = 250;
                needMilk = 0;
                needCoffeeBeans = 16;
                priceOfDrink = 4;
                break;
            }
            case 2: {
                //LATTE
                needWater = 350;
                needMilk = 75;
                needCoffeeBeans = 20;
                priceOfDrink = 7;
                break;
            }
            case 3: {
                //CAPPUCCINO
                needWater = 200;
                needMilk = 100;
                needCoffeeBeans = 12;
                priceOfDrink = 6;
                break;
            }
        }
    }
}
