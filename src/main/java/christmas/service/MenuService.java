package christmas.service;

import christmas.model.Menu;
import christmas.repository.MenuRepository;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuService {
    private AtomicInteger nextMenuId = new AtomicInteger(1);
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu createMenu(String name, int price) {
        int id = nextMenuId.getAndIncrement();
        Menu menu = new Menu(id, name, price);
        menuRepository.addMenu(menu.menuId(), menu);
        return menu;
    }

    public Menu findById(int menuId) {
        return menuRepository.findById(menuId);
    }
}
