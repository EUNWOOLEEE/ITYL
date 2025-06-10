package org.scoula;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ContextConfiguration(classes = RootConfig.class)
@ExtendWith(SpringExtension.class)
class RestaurantTest {
    @Autowired
    Restaurant restaurant; // RestaurantTest <- Restaurant <- Chef

    @Test
    void getChef() {
        log.info(restaurant);
        log.info(restaurant.getChef());
        assertNotNull(restaurant);
    }
}