package restaurant.oop;

import java.util.ArrayList;
import java.util.List;

public class DISHES extends Category {

    @Override
    public List<MenuItem> loadItems() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Trattoria Risotto", "Dishes", 240.0));
        list.add(new MenuItem("Requiem Pasta", "Dishes", 210.0));
        list.add(new MenuItem("Golden Caprese", "Dishes", 180.0));
        return list;
    }
}
