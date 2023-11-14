package christmas.model.event.impl;

import christmas.model.Badge;
import christmas.model.Reservation;
import christmas.model.event.Event;
import christmas.utils.BadgeInfo;
import christmas.utils.DiscountConstants;
import christmas.utils.EventInfo;

public class BadgeEvent implements Event {
    private final int discount = DiscountConstants.DISCOUNT_NONE.getIndex();
    private Badge badge;

    @Override
    public BadgeEvent condition(Reservation reservation) {
        int price = reservation.getTotalPrice();
        if (price >= BadgeInfo.SANTA_BADGE.getPrice() && price < BadgeInfo.TREE_BADGE.getPrice()) {
            this.badge = new Badge(BadgeInfo.STAR_BADGE.getValue());
            return this;
        }
        if (price >= BadgeInfo.TREE_BADGE.getPrice() && price < BadgeInfo.SANTA_BADGE.getPrice()) {
            this.badge = new Badge(BadgeInfo.TREE_BADGE.getValue());
            return this;
        }
        if (price >= BadgeInfo.SANTA_BADGE.getPrice()) {
            this.badge = new Badge(BadgeInfo.STAR_BADGE.getValue());
            return this;
        }
        return null;
    }

    @Override
    public int getDiscount() {
        return this.discount;
    }

    @Override
    public String getEventName() {
        return EventInfo.BADGE_EVENT.getMessage();
    }

    public Badge getBadge() {
        return this.badge;
    }
}
