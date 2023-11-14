package christmas.controller;

import christmas.exception.CustomException;
import christmas.model.Order;
import christmas.model.Reservation;
import christmas.model.User;
import christmas.model.event.impl.GiftEvent;
import christmas.service.EventManager;
import christmas.service.MenuService;
import christmas.service.OrderService;
import christmas.service.ReservationService;
import christmas.service.UserService;
import christmas.utils.PlannerNumber;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.function.Supplier;

public class WootecoRestaurantController {

    private final MenuService menuService;

    private final UserService userService;

    private final ReservationService reservationService;

    private final OrderService orderService;

    private final InputView inputView;

    private final OutputView outputView;
    private final EventManager eventManager;

    public WootecoRestaurantController(MenuService menuService, UserService userService,
                                       ReservationService reservationService, OrderService orderService,
                                       EventManager eventManager,
                                       InputView inputView, OutputView outputView) {
        this.menuService = menuService;
        this.userService = userService;
        this.reservationService = reservationService;
        this.orderService = orderService;
        this.eventManager = eventManager;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        User user = userService.createUser("wooteco");
        outputView.printHello();
        LocalDate date = createReservationDate();
        Order order = repeatValidate(() -> orderService.createOrder(inputView.readOrder()));
        Reservation reservation = reservationService.createReservation(user.getUserId(), order, date);
        outputView.printPreview();
        outputView.printOrderMenu(reservation);
        outputView.printBeforeTotalPrice(reservation);
        eventManager.applyEvent(reservation);
        showBenefit(reservation);
    }

    public void showBenefit(Reservation reservation) {
        presentGift(reservation);
        outputView.printGift(reservation);
    }

    public void presentGift(Reservation reservation) {
        if (reservation.getEvents().stream().anyMatch(GiftEvent.class::isInstance)) {
            reservation.setGift(menuService.findById(GiftEvent.getGiftId()));
        }
    }

    public LocalDate createReservationDate() {
        return LocalDate.of(PlannerNumber.THIS_YEAR.getNumber(), PlannerNumber.DECEMBER.getNumber(),
                repeatValidate(() -> {
                    int input = inputView.readDate();
                    reservationService.validateDecemberDate(input);
                    return input;
                }));
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
