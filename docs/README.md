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
- [x] 사용자가 받을 혜택 내역을 출력 합니다.
- [x] 총혜택 금액을 출력 합니다.
    - 총혜택 금액 = 할인 금애의 합계 + 증정 메뉴의 가격
- [x] 할인 후 예상 결제 금액을 출력 합니다.
    - 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- [x] 사용자가 받을 이벤트 배지를 출력 합니다.
    - 이벤트 배지가 부여되지 않는 경우, "없음"으로 출력 됩니다.
- [x] 모든 에러 메시지는 "[ERROR] "로 시작 합니다
- [x] 혜택 내역이 출력 됩니다.
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
        <td>사용자 클래스 입니다.</td>
    </tr>
    <tr>
        <td>Badge</td>
        <td>배지 레코드 입니다.</td>
    </tr>
    <tr>
        <td>Menu</td>
        <td>메뉴 record 입니다.</td>
    </tr>
    <tr>
        <td>Reservation</td>
        <td>예약 클래스 입니다.</td>
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
        <td rowspan="6">model.event.impl</td>
        <td>WeekendEvent</td>
        <td>주말 할인 이벤트 클래스 입니다.</td>
    </tr>
    <tr>
        <td>WeekDayEvent</td>
        <td>평일 할인 이벤트 클래스 입니다.</td>
    </tr>
    <tr>
        <td>StarDayEvent</td>
        <td>별이 달린 날짜 이벤트 클래스 입니다.</td>
    </tr>
    <tr>
        <td>GiftEvent</td>
        <td>증정 이벤트 클래스 입니다.</td>
    </tr>
    <tr>
        <td>DayByDayEvent</td>
        <td>크리스마스 디데이 이벤트 클래스 입니다.</td>
    </tr>
    <tr>
        <td>BadgeEvent</td>
        <td>배지 증정 이벤트 클래스 입니다.</td>
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
        <td rowspan="5">service</td>
        <td>ReservationService</td>
        <td>예약 service 입니다.</td>
    </tr>
    <tr>
        <td>MenuService</td>
        <td>메뉴 service 입니다.</td>
    </tr>
    <tr>
        <td>EventPlanner</td>
        <td>이벤트 플래너 클래스 입니다.</td>
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
        <td rowspan="14">utils</td>
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
        <td>PlannerNumber</td>
        <td>planner 숫자 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>ExceptionMessage</td>
        <td>에러 메시지 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>BadgeInfo</td>
        <td>배지 정보 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>DateInfo</td>
        <td>날짜 정보 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>DiscountConstants</td>
        <td>할인 상수 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>EventInfo</td>
        <td>이벤트 정보 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>OrderConstants</td>
        <td>주문 상수 들을 담고 있는 enum 입니다.</td>
    </tr>
    <tr>
        <td>StarDateInfo</td>
        <td>별이 있는 날짜 들을 관리 하고 있는 enum 입니다.</td>
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

---

## 고민한 포인트들

1. 객체지향의 의미

이번 미션은 객체지향의 의미를 살리는 것에 집중 했습니다.<br>
예를 들어 제네릭 타입을 사용하여 여러 에러를 하나의 메소드로 반복 시킬 수 있도록 기능을 구현했습니다.<br>
또한 이벤트 처리에 있어서도 확상성을 고혀하면서 구조를 설계했습니다.<br>
이벤트가 추후에 추가되고 삭제되는 다양한 상황을 고려하여 기존 코드를 변경하지 않도록 구조를 설계했습니다.<br>
Event interface를 상속받는 event 객체들을 구현하여 예약 진행 시 reservation에 event를 추가 하여 적용할 수 있도록 구현했습니다.<br>
이에 따라 이벤트가 추가된다면 reservation이나 user등 다른 도메인의 코드 변경없이 새로운 event를 상속 받는 객체를 생성해주고 이벤트를 관리하는<br>
EventMageer에 추가된다면 유저가 예약을 진행할
시 자동으로 이벤트 적용을 검사한 뒤 적용받게 됩니다.

2. 요구사항 분석

실제 서비스를 진행하는 방식으로 요구사항을 전달 받아 최대한 요구사항을 분석하고 의도대로 개발이 되도록 고민했습니다.<br>
출력예시에 나와있긴 하지만 이벤트의 목표인 ‘고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것’ 이 부분을 구현하기 위해 혜택받은 내역을 출력하고<br>
할인 받은 내역과, 이전 가격, 적용 이후 가격을
출력하도록 했다고 생각합니다.<br>
이후 1월 이벤트에 이 배지를 활용하기 위해서 배지를reservation에 적용되는 것이 아닌 user 객체에 필드로 가질 수 있도록 했습니다.<br>
따라서 1월 이벤트가 새로 시작되더라도 사용자들은 본인의 user안에 배지가 존재하기 때문에 재참여가 이뤄질 수 있습니다.

3. 예외 처리

다양하고 꼼꼼한 예외 처리를 진행하기 위해 노력했습니다.<br>
좋은 예외와 검증이 무엇인지 고민하였고 명확하고 신뢰성이 있는 예외 처리가 좋은 예외라는 생각이 들었습니다.<br>
이를 통해 협업, 개발 효율성이 높아진다고 생각했습니다.<br>
따라서 명확한 에러를 위해 커스텀 에러를 구현하여 각각 상황에 맞는 에러를 구현하여 보다 명확하고 정확한 에러를 발생 시키도록 개발했습니다.<br>
User, resevation, menu는 데이터베이스에 저장되어 있는 데이터라고 생각하여 각각 service와 repository를 구현하여 관리하도록 했습니다.<br>
repository의 경우는 실제 서비스와 연결되어 있지 않기 때문에 저장 후 데이터의 일괄성을 유지하기 위해 싱글톤으로 구현했습니다.<br>
service 레이어는 비즈니스 로직의 처리와 데이터의 가공과 관리를 진행했습니다.<br>
이런 구조를 통해 역할과 책임을 나눠 클래스(객체)를 분리하도록 개발했습니다.<br>
이를 통해 유지보수와 확장을 쉽게 만들며 단일 책임 원칙과 코드의 재사용성, 테스트 용이성을 높였습니다.

4. 클래스(객체) 분리

실제 서비스를 개발한다는 생각하여 controller-servie-repostiroy 구조와 mvc 패턴을 사용했습니다.