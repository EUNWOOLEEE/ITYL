package org.scoula.board.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Service // @Component + 서비스 역할의 클래스라고 스프링에 등록됨
@RequiredArgsConstructor // 생성자 자동 생성, @Autowired 자동 추가
public class BoardServiceImpl implements BoardService {
    // 전처리해서 dao의 메서드를 불러서 db처리해달라고 해야 함
    final private BoardMapper mapper;
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
//        List<BoardVO> list = boardMapper.getList();
//        return List.of();

        return mapper.getList().stream() // BoardVO의 스트림
                .map(BoardDTO::of) // BoardDTO의 스트림
                .toList(); // List<BoardDTO> 변환
    }

    @Override
    public BoardDTO get(Long no) {
        BoardVO vo = boardMapper.get(no);
        // 다른 곳으로 넘길 때는 dto로 변환
        BoardDTO dto = new BoardDTO().of(vo);
        return dto;

//        BoardDTO board = BoardDTO.of(mapper.get(no));
//        return Optional.ofNullable(board).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(BoardDTO board) {

    }

    @Override
    public boolean update(BoardDTO board) {
        return false;
    }

    @Override
    public boolean delete(Long no) {
        return false;
    }
}
