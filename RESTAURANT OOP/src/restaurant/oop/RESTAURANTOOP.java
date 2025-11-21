package restaurant.oop;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class RESTAURANTOOP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Framing frame = new Framing();

            List<MenuItem> menu = new ArrayList<>();
            menu.addAll(new DISHES().loadItems());
            menu.addAll(new DESSERT().loadItems());
            menu.addAll(new DRINKS().loadItems());

            
            frame.setMenuItems(menu.toArray(new MenuItem[0]));
        });
    } 
}
