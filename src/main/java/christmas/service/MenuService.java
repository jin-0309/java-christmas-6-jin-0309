package christmas.service;

import christmas.exception.InvalidOrderException;
import christmas.model.Menu;
import christmas.repository.MenuRepository;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu createMenu(String name, int price, String category) {
        Menu menu = new Menu(name, price, category);
        menuRepository.add(menu);
        return menu;
    }

    public Menu findById(String menuId) {
        return menuRepository.findById(menuId).orElseThrow(InvalidOrderException::new);
    }

}
