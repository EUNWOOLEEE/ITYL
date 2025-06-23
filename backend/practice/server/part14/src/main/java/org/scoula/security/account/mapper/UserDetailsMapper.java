package org.scoula.security.account.mapper;

import org.scoula.security.account.domain.MemberVO;

public interface UserDetailsMapper {
    // 로그인 처리할 때 db 연동할 기능 정의
    // username(id) 주소 회원정보를 검색
    public MemberVO get(String username);
}
