package christmas;

import christmas.config.AppConfig;
import christmas.controller.WootecoRestaurantController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        appConfig.menuInit();
        appConfig.eventInit();
        WootecoRestaurantController wootecoRestaurantController = appConfig.getController();
        wootecoRestaurantController.run();
    }
}
