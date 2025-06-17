package org.scoula.board.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder가 쉽게 해당 객체로 만들 수 있게 하는 어노테이션
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    // VO -> DTO 변환
    public static BoardDTO of(BoardVO vo) {
        return vo == null ? null : BoardDTO.builder()
                .no(vo.getNo())
                .title(vo.getTitle())
                .content(vo.getContent())
                .writer(vo.getWriter())
                .regDate(vo.getRegDate())
                .updateDate(vo.getUpdateDate())
                .build();
        // Builder 객체를 이용하면 순서 상관 없이 값을 넣어서 간단하게 객체를 만들 수 있음
    }

    // DTO -> VO 변환
    public BoardVO toVo() {
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer) .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
