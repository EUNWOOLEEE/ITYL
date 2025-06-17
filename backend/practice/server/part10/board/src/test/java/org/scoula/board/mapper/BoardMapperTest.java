package org.scoula.board.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;
    // sprin과 mybatis가 환경설정한 것을 기반으로 해서 자동으로 클래스를 생성하고 싱글톤으로 만듦

    @Test
    void getList() {
        List<BoardVO>  list = boardMapper.getList();
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i).toString());
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    void get() {
        // 존재하는 게시물 번호로 테스트
        BoardVO board = boardMapper.get(1L);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의새글작성")
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로작성하는글");
        board.setContent("새로작성하는내용");
        board.setWriter("user00");
        boardMapper.create(board);
        log.info(board);
    }
}