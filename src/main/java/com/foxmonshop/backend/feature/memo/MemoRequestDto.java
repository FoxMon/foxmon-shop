package com.foxmonshop.backend.feature.memo;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class MemoRequestDto {
    private String title;

    private String contents;
}
