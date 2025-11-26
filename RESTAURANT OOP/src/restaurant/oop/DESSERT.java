package restaurant.oop;

import java.util.ArrayList;
import java.util.List;

public class DESSERT extends Category {

    @Override
    public List<MenuItem> loadItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Panna Cotta Giorno", "Desserts", 120.0));
        list.add(new MenuItem("Amaretto Dream", "Desserts", 115.0));
        list.add(new MenuItem("Passione Gelato", "Desserts", 130.0));
        return list;
    }
}
