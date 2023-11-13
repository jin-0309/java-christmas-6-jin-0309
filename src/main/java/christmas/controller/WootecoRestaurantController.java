package christmas.controller;

import christmas.exception.CustomException;
import christmas.service.MenuService;
import christmas.service.ReservationService;
import christmas.service.UserService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class WootecoRestaurantController {

    private final MenuService menuService;

    private final UserService userService;

    private final ReservationService reservationService;

    private final InputView inputView;

    private final OutputView outputView;

    public WootecoRestaurantController(MenuService menuService, UserService userService,
                                       ReservationService reservationService, InputView inputView,
                                       OutputView outputView) {
        this.menuService = menuService;
        this.userService = userService;
        this.reservationService = reservationService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int date = inputView.readDate();
    }

    private <T> T repeatValidate(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CustomException customException) {
                outputView.printMessage(customException.getMessage());
            }
        }
    }
}
