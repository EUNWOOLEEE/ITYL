package org.scoula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class Restaurant {
    // 자동으로 싱글톤 객체 찾아서 주입
    @Autowired
    private Chef chef; // 주입되었으면 주소 존재, 아니면 null
}