package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    // 필요한 db 처리 기능을 함수로 불완전하게 써놓음
    // 추상메서드

    // 어노테이션으로 sql문 사용하는 방법
    @Select("SELECT sysdate()")
    public String getTime();

    // TimeMapper.xml에 있는 sql문 실행시키는 방법 사용
    // 더 많이 사용되는 방법
    public String getTime2();
}