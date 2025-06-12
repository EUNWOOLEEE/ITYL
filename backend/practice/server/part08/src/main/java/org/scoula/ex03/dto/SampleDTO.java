package org.scoula.ex03.dto;

import lombok.Data;

@Data
public class SampleDTO {
    private String name;
    private int age;

    // 가방에서 넣을 때는 setter, 꺼낼 때는 getter 사용
    // 핸들러 어댑터가 http로 전달된 데이터를 가방에 넣음(setter 이용)
}
