package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.Menu;
import christmas.repository.MenuRepository;
import christmas.utils.MenuCategoryInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    private MenuService menuService;

    @BeforeEach
    void setUp() {
        this.menuService = new MenuService(MenuRepository.getInstance());
    }

    @Test
    void createMenu() {
        Menu menu = menuService.createMenu("test", 1000, MenuCategoryInfo.APPETIZER.getMessage());
        String menuName = "test";
        assertEquals(menu, menuService.findById(menuName));
    }

    @Test
    void findById() {
        String menuName = "testFindById";
        Menu menu = menuService.createMenu(menuName, 2000, MenuCategoryInfo.APPETIZER.getMessage());

        Menu testMenu = menuService.findById(menuName);
        assertEquals(menu, testMenu);
    }
}