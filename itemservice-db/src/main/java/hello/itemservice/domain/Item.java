package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //필드 이름을 테이블 컬럼 명으로 변경할 때
    //객체 필드의 카멜 케이스를 테이블 컬럼의 언더스코어로 자동 변환 해준다. 그래서 @Column을 생략해도 됨!
    @Column(name = "item_name",length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
        // JPA는 기본 생성자가 필수이다.(public 이나 protected)
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
