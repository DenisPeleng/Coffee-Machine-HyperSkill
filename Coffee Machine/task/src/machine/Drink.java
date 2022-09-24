package machine;

public class Drink {
    private int needWater;
    private int needMilk;
    private int needCoffeeBeans;
    private int priceOfDrink;

    Drink(int drink) {
        switch (drink) {
            case 1 -> {
                //ESPRESSO
                setNeedWater(250);
                setNeedMilk(0);
                setNeedCoffeeBeans(16);
                setPriceOfDrink(4);
            }
            case 2 -> {
                //LATTE
                setNeedWater(350);
                setNeedMilk(75);
                setNeedCoffeeBeans(20);
                setPriceOfDrink(7);
            }
            case 3 -> {
                //CAPPUCCINO
                setNeedWater(200);
                setNeedMilk(100);
                setNeedCoffeeBeans(12);
                setPriceOfDrink(6);
            }
        }
    }

    public int getNeedWater() {
        return needWater;
    }

    public void setNeedWater(int needWater) {
        this.needWater = needWater;
    }

    public int getNeedMilk() {
        return needMilk;
    }

    public void setNeedMilk(int needMilk) {
        this.needMilk = needMilk;
    }

    public int getNeedCoffeeBeans() {
        return needCoffeeBeans;
    }

    public void setNeedCoffeeBeans(int needCoffeeBeans) {
        this.needCoffeeBeans = needCoffeeBeans;
    }

    public int getPriceOfDrink() {
        return priceOfDrink;
    }

    public void setPriceOfDrink(int priceOfDrink) {
        this.priceOfDrink = priceOfDrink;
    }
}
