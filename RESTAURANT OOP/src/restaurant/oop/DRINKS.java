package restaurant.oop;

import java.util.ArrayList;
import java.util.List;

public class DRINKS extends Category {

    @Override
    public List<MenuItem> loadItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Lavender Latte", "Drinks", 95.0));
        list.add(new MenuItem("Rose Quartz Fizz", "Drinks", 110.0));
        list.add(new MenuItem("Grape Stand Spritz", "Drinks", 105.0));
        list.add(new MenuItem("Mista Melon Juice", "Drinks", 67.0));
        list.add(new MenuItem("Polnareff's Oasis", "Drinks", 143.0));
        return list;
    }
}
