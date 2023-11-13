package christmas.repository;

import christmas.model.Menu;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {

    private static MenuRepository menuRepository = null;

    private final Map<Integer, Menu> menus = new HashMap<>();

    private MenuRepository() {
    }

    public static MenuRepository getInstance() {
        if (menuRepository == null) {
            menuRepository = new MenuRepository();
        }
        return menuRepository;
    }

    public void addMenu(int menuId, Menu menu) {
        menus.put(menuId, menu);
    }

    public Menu findById(int menuId) {
        return menus.get(menuId);
    }
}
