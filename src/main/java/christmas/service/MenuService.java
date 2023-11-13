package christmas.service;

import christmas.model.Menu;
import christmas.repository.MenuRepository;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuService {
    private final AtomicInteger nextMenuId = new AtomicInteger(1);
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu createMenu(String name, int price, String category) {
        Menu menu = new Menu(nextMenuId.getAndIncrement(), name, price, category);
        menuRepository.add(menu);
        return menu;
    }

    public Menu findById(int menuId) {
        return menuRepository.findById(menuId);
    }
}
