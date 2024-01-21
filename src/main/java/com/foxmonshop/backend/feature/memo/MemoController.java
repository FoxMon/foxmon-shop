package com.foxmonshop.backend.feature.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memos")
    private ResponseEntity<List<MemoResponseDto>> getMemos() {
        List<Memo> memoList = this.memoService.getAllMemoList();
        List<MemoResponseDto> response = memoList
            .stream()
            .map(memo -> new MemoResponseDto(
                memo.getId(),
                memo.getTitle(),
                memo.getContents()
            ))
            .toList();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/memos")
    private ResponseEntity<MemoResponseDto> createMemo(
        @RequestBody MemoRequestDto request
    ) throws Exception {
        Memo memo = this.memoService.createMemo(request);

        return ResponseEntity.ok().body(new MemoResponseDto(memo));
    }
}
