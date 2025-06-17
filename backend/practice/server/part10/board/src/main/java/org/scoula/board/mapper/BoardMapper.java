package org.scoula.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository // 저장(db)
//@Component + db 예외처리
public interface BoardMapper {
//    @Select("select * from tbl_board order by no desc")
    public abstract List<BoardVO> getList();

    // 상세 검색
    public BoardVO get(Long id);

    // 게시판 글쓰기 -> vo가 거의 대부분
    public void create(BoardVO board);
}
