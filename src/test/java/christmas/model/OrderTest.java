package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.repository.MenuRepository;
import christmas.service.MenuService;
import christmas.utils.BeveragesMenuInfo;
import christmas.utils.MainMenuInfo;
import christmas.utils.MenuCategoryInfo;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;
    private MenuService menuService;

    @BeforeEach
    void setUp() {
        this.menuService = new MenuService(MenuRepository.getInstance());
        this.order = new Order();
        for (MainMenuInfo main : MainMenuInfo.values()) {
            menuService.createMenu(main.getMessage(), main.getPrice(), MenuCategoryInfo.MAIN.getMessage());
        }
        for (BeveragesMenuInfo beverages : BeveragesMenuInfo.values()) {
            menuService.createMenu(beverages.getMessage(), beverages.getPrice(),
                    MenuCategoryInfo.BEVERAGES.getMessage());
        }
    }

    @Test
    void add() {
        assertEquals(0, order.size());
        order.add(menuService.findById(MainMenuInfo.BBQ_RIBS.getMessage()), 1);
        assertEquals(1, order.size());
    }

    @Test
    void size() {
        assertEquals(0, order.size());
    }

    @Test
    void getCountByCategory() {
        int mainCount = 2;
        int beveragesCount = 3;
        order.add(menuService.findById(MainMenuInfo.SEAFOOD_PASTA.getMessage()), mainCount);
        order.add(menuService.findById(BeveragesMenuInfo.CHAMPAGNE.getMessage()), beveragesCount);
        int mainMenuCount = order.getCountByCategory(MenuCategoryInfo.MAIN.getMessage());
        int beveragesMenuCount = order.getCountByCategory(MenuCategoryInfo.BEVERAGES.getMessage());
        assertEquals(mainCount, mainMenuCount);
        assertEquals(beveragesCount, beveragesMenuCount);
    }

    @Test
    void getTotalPrice() {
        order.add(menuService.findById(MainMenuInfo.SEAFOOD_PASTA.getMessage()), 2);
        order.add(menuService.findById(BeveragesMenuInfo.RED_WINE.getMessage()), 3);
        assertEquals(250000, order.getTotalPrice());
    }

    @Test
    void getOrders() {
        order.add(menuService.findById(MainMenuInfo.CHRISTMAS_PASTA.getMessage()), 2);
        order.add(menuService.findById(BeveragesMenuInfo.ZERO_COLA.getMessage()), 1);
        Map<Menu, Integer> orders = order.getOrders();
        assertEquals(2, orders.size());
    }

    @Test
    void getCategory() {
        order.add(menuService.findById(MainMenuInfo.SEAFOOD_PASTA.getMessage()), 1);
        order.add(menuService.findById(BeveragesMenuInfo.CHAMPAGNE.getMessage()), 1);
        List<String> categories = order.getCategory();
        assertEquals(MenuCategoryInfo.MAIN.getMessage(), categories.get(0));
        assertEquals(MenuCategoryInfo.BEVERAGES.getMessage(), categories.get(1));
    }

    @Test
    void getAllQuantity() {
        int mainMenuQuantity = 3;
        int beveragesMenuQuantity = 2;
        order.add(menuService.findById(MainMenuInfo.SEAFOOD_PASTA.getMessage()), mainMenuQuantity);
        order.add(menuService.findById(BeveragesMenuInfo.CHAMPAGNE.getMessage()), beveragesMenuQuantity);
        int allQuantity = mainMenuQuantity + beveragesMenuQuantity;
        assertEquals(allQuantity, order.getAllQuantity());
    }
}