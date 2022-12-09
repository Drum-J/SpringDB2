package hello.springtx.propagation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    public Member() {
        //JPA 스펙상 기본 생성자는 있어야 한다!! 모르고 있었음
    }

    public Member(String username) {
        this.username = username;
    }
}
