package machine;

public class Drink {
    public int needWater;
    public int needMilk;
    public int needCoffeeBeans;
    public int priceOfDrink;

    Drink(int drink) {
        switch (drink) {
            case 1 -> {
                //ESPRESSO
                needWater = 250;
                needMilk = 0;
                needCoffeeBeans = 16;
                priceOfDrink = 4;
            }
            case 2 -> {
                //LATTE
                needWater = 350;
                needMilk = 75;
                needCoffeeBeans = 20;
                priceOfDrink = 7;
            }
            case 3 -> {
                //CAPPUCCINO
                needWater = 200;
                needMilk = 100;
                needCoffeeBeans = 12;
                priceOfDrink = 6;
            }
        }
    }
}
