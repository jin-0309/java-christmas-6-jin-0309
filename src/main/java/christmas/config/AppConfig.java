package christmas.config;

import christmas.controller.WootecoRestaurantController;
import christmas.repository.MenuRepository;
import christmas.repository.ReservationRepository;
import christmas.repository.UserRepository;
import christmas.service.MenuService;
import christmas.service.ReservationService;
import christmas.service.UserService;
import christmas.utils.AppetizerMenuInfo;
import christmas.utils.BeveragesMenuInfo;
import christmas.utils.DessertMenuInfo;
import christmas.utils.MainMenuInfo;
import christmas.utils.MenuCategoryInfo;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    private final MenuService menuService;

    private final ReservationService reservationService;

    private final UserService userService;

    public AppConfig() {
        this.menuService = new MenuService(MenuRepository.getInstance());
        this.reservationService = new ReservationService(ReservationRepository.getInstance());
        this.userService = new UserService(UserRepository.getInstance());
    }

    public WootecoRestaurantController getController() {
        return new WootecoRestaurantController(menuService, userService, reservationService, new InputView(),
                new OutputView());
    }

    public void menuInit() {
        appetizerMenuInti();
        mainMenuInti();
        dessertMenuInit();
        beveragesMenuInit();
    }

    public void appetizerMenuInti() {
        for (AppetizerMenuInfo appetizer : AppetizerMenuInfo.values()) {
            menuService.createMenu(appetizer.getMessage(), appetizer.getPrice(),
                    MenuCategoryInfo.APPETIZER.getMessage());
        }
    }

    public void mainMenuInti() {
        for (MainMenuInfo main : MainMenuInfo.values()) {
            menuService.createMenu(main.getMessage(), main.getPrice(), MenuCategoryInfo.MAIN.getMessage());
        }
    }

    public void dessertMenuInit() {
        for (DessertMenuInfo dessert : DessertMenuInfo.values()) {
            menuService.createMenu(dessert.getMessage(), dessert.getPrice(), MenuCategoryInfo.DESSERT.getMessage());
        }
    }

    public void beveragesMenuInit() {
        for (BeveragesMenuInfo beverages : BeveragesMenuInfo.values()) {
            menuService.createMenu(beverages.getMessage(), beverages.getPrice(),
                    MenuCategoryInfo.BEVERAGES.getMessage());
        }
    }

}
