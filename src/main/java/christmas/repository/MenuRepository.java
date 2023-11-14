package christmas.repository;

import christmas.model.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuRepository {

    private static MenuRepository menuRepository = null;

    private final Map<String, Menu> menus = new HashMap<>();

    private MenuRepository() {
    }

    public static MenuRepository getInstance() {
        if (menuRepository == null) {
            menuRepository = new MenuRepository();
        }
        return menuRepository;
    }

    public void add(Menu menu) {
        menus.put(menu.name(), menu);
    }

    public Optional<Menu> findById(String menuId) {
        return Optional.ofNullable(menus.get(menuId));
    }

}
