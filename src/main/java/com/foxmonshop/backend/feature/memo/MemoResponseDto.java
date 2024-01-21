package com.foxmonshop.backend.feature.memo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoResponseDto {
    private Long id;

    private String title;

    private String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();

        this.title = memo.getTitle();

        this.contents = memo.getContents();
    }
}
