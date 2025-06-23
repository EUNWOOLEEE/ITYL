package org.scoula.security.account.domain;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String username;
    private String password;
    private String email;
    private Date regDate;
    private Date updateDate;

    // Auth 테이블의 role(auth 컬럼)이 여러 개 필요
    // member의 username과 auth는 1:다

    private List<AuthVO> authList;
}
