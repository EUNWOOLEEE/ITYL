package org.scoula.security.account.domain;

import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class CustomUser extends User {
    // Security 내에서 회원 정보를 담을 객체는 User 객체임
    // 우리의 회원정보는 MemberVO에 있음
    // MemberVO --> User 객체에 매핑

    private MemberVO memberVO;

    // 생성자 2개를 만들어줌
    public CustomUser(MemberVO memberVO) {
        super(memberVO.getUsername(), memberVO.getPassword(), memberVO.getAuthList());
        this.memberVO = memberVO;
    }

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
