package org.scoula.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
//@Controller
@RestController // views로 forward하지 않고 모두 data로 응답. @Controller + @ResponseBody
@Api(tags = "게시글 관리")
public class BoardController {
    private final BoardService service; // 생성자 주입

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("")
//    @ResponseBody // 컨트롤러에서 views로 forward하지 않고 http의 body에 리턴값을 넣어서 응답
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/get") // /api/board/get?no=1
    public BoardDTO get(@RequestParam("no") Long no) {
        return service.get(no);
    }

    @ApiOperation(value = "상세정보 얻기", notes = "게시글 상제 정보를 얻는 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("/get/{no}") // /api/board/get/15
    public BoardDTO get2(@PathVariable("no") Long no) {
        return service.get(no);
    }

    @PostMapping("") // /api/board + post
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO boardDTO) {
        // @RequestBody: 브라우저에서 보낼 때도 json으로 보낼 수 있음
        // 서버에서 json을 받을 때 사용하는 어노테이션
        return ResponseEntity.ok(service.create(boardDTO));
    }
}
