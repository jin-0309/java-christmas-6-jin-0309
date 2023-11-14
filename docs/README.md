# 크리스마스 프로모션

---
우아한 테크코스 백엔드 6기 프리코스 4주차 미션 입니다.<br>
크리스마스 프로모션을 구현 합니다.
---

# 기능목록

- [x] 프로그램 시작 시 식당 메뉴를 초기화 합니다.
    - [x] 에피타이저
        - 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
    - [x] 메인
        - 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
    - [x] 디저트
        - 초코케이크(15,000), 아이스크림(5,000)
    - [x] 음료
        - 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
- [x] 사용자에게 식당 예상 방문 날짜 입력 받습니다.
    - 방문할 날짜는 1 이상 31 이하의 숫자로만 입력 받습니다.
    - 1 이상 31 이하의 숫자가 아닐 경우 "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 라는 에러 메시지가 출력됩니다.
- [x] 사용자에게 주문할 메뉴와 개수를 입력 받습니다.
    - 고객이 메뉴판에 없는 메뉴를 입력할 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요." 라는 에러 메시지가 출력됩니다.
    - 메뉴의 개수는 1 이상의 숫자만 입력 받습니다. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 라는 메시지가 출력됩니다.
    - 메뉴 형식이 예시와 다를 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 라는 메시지가 출력됩니다.
    - 중복 메뉴를 입력할 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 라는 메시지가 출력됩니다.
- [x] 사용자의 예약을 통해 이벤트 혜택 내역을 초기화 합니다.
    - [x] 크리스마스 디데이 할인
        - 이벤트 기간 2023.12.1 ~ 2023.12.25
        - 시작일 부터 1,000원 씩 총주문 금액에서 해당 금액만큼 할인 합니다.
    - [x] 평일 할인
        - 평일(일요일 ~ 목요일)
        - 디저트 메뉴를 메뉴 1개당 2,023원 할인 합니다.
    - [x] 주말 할인
        - 주말(금요일, 토요일)
        - 메인 메뉴를 메뉴 1개달 2,023원 할인 합니다.
    - [x] 특별 할인
        - 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
    - [x] 증정 이벤트
        - 할인 전 총주문 금액이 12만 원 이상일때, 샴페인 1개 증정 합니다.
    - 크리스마스 디데이 할인을 제외한 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용 합니다.
    - [x] 이벤트 배지 증정
        - 총혜택 금액에 따라 다른 이벤트 배지를 부여 합니다
        - 5천 원 이상: 별
        - 1만 원 이상: 트리
        - 2만 원 이상: 산타
- [x] 사용자가 입력한 주문 메뉴와 개수를 출력 합니다.
- [x] 할인 전 총주문 금액을 출력 합니다.
- [x] 증정 메뉴가 있을 시 증정 메뉴를 출력 합니다.
    - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 출력 됩니다.
- [ ] 사용자가 받을 혜택 내역을 출력 합니다.
- [ ] 총혜택 금액을 출력 합니다.
    - 총혜택 금액 = 할인 금애의 합계 + 증정 메뉴의 가격
- [ ] 할인 후 예상 결제 금액을 출력 합니다.
    - 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- [ ] 사용자가 받을 이벤트 배지를 출력 합니다.
    - 이벤트 배지가 부여되지 않는 경우, "없음"으로 출력 됩니다.
- [ ] 모든 에러 메시지는 "[ERROR] "로 시작 합니다
- [ ] 혜택 내역이 출력 됩니다.
    - 고객에게 제공된 이벤트 내역만 출력 됩니다.
    - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 출력 됩니다.

---

## 패키지 구조

<table>
  <tr>
    <td>패키지</td>
    <td>클래스</td>
    <td>설명</td>
  </tr>
  <tr>
    <td>controller</td>
    <td>WootecoRestaurantController</td>
    <td>우테코 레스토랑 컨트롤러 입니다. 뷰와 모델을 연결합니다.</td>
  </tr>
  <tr>
    <td rowspan="5">model</td>
    <td>User</td>
    <td>사용자 record 입니다.</td>
  </tr>
  <tr>
    <td>Menu</td>
    <td>메뉴 record 입니다.</td>
  </tr>
  <tr>
    <td>EventPlanner</td>
    <td>이벤트 플래너 클래스 입니다.</td>
  </tr>
  <tr>
    <td>Reservation</td>
    <td>예약 record 입니다.</td>
  </tr>
    <tr>
        <td>Order</td>
        <td>주문 정보 클래스 입니다.</td>
    </tr>
  <tr>
    <td>model.event</td>
    <td>Event</td>
    <td>이벤트 interface 입니다.</td>
  </tr>
  <tr>
    <td rowspan="3">model.event.impl</td>
    <td>WeekendEvent</td>
    <td>주말 할인 이벤트 입니다.</td>
  </tr>
  <tr>
    <td>WeekDayEvent</td>
    <td>평일 할인 이벤트 입니다.</td>
  </tr>
  <tr>
    <td>StarDayEvent</td>
    <td>별이 달린 날짜 이벤트 입니다.</td>
  </tr>
  <tr>
    <td rowspan="3">repository</td>
    <td>UserRepository</td>
    <td>유저 repository 입니다.</td>
  </tr>
  <tr>
    <td>MenuRepository</td>
    <td>메뉴 repository 입니다.</td>
  </tr>
  <tr>
    <td>ReservationRepository</td>
    <td>예약 repository 입니다.</td>
  </tr>
  <tr>
    <td rowspan="4">service</td>
    <td>ReservationService</td>
    <td>예약 service 입니다.</td>
  </tr>
  <tr>
    <td>MenuService</td>
    <td>메뉴 service 입니다.</td>
  </tr>
  <tr>
    <td>UserService</td>
    <td>유저 service 입니다.</td>
  </tr>
    <td>OrderService</td>
    <td>주문 service 입니다.</td>
  <tr>
    <td rowspan="2">view</td>
    <td>InputView</td>
    <td>입력 처리를 진행 하는 view 입니다.</td>
  </tr>
  <tr>
    <td>OutputView</td>
    <td>출력 처리를 진행 하는 view 입니다.</td>
  </tr>
  <tr>
    <td rowspan="7">utils</td>
    <td>MenuCategoryInfo</td>
    <td>메뉴 들의 정보를 담고 있는 enum 입니다.</td>
  </tr>
  <tr>
        <td>AppetizerMenuInfo</td>
        <td>에피타이저 메뉴 정보를 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>MainMenuInfo</td>
        <td>메인 메뉴 정보를 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>DessertMenuInfo</td>
        <td>디저트 메뉴 정보를 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>BeveragesMenuInfo</td>
        <td>음료 메뉴 정보를 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>PlannerMessage</td>
        <td>planner 메시지 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>ErrorMessage</td>
        <td>에러 메시지 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td rowspan="4">Exception</td>
        <td>CustomException</td>
        <td>커스텀 예외 입니다.</td>
    </tr>
    <tr>
        <td>InvalidDateException</td>
        <td>유효하지 않은 날짜 예외</td>
    </tr>
    <tr>
        <td>InvalidOrderException</td>
        <td>유효하지 않은 주문 예외</td>
    </tr>
    <tr>
        <td>InvalidNumberInputException</td>
        <td>숫자 입력 시 문자열을 입력할 경우 예외</td>
    </tr>
    <tr>
        <td>config</td>
        <td>AppConfig</td>
        <td>앱 실행 시 초기화 되는 초기 설정 입니다.</td>
    </tr>
</table>
