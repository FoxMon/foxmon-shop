package com.foxmonshop.backend.feature.memo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "memo")
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memo_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 255)
    private String contents;

    public static Memo createMemo(String title, String contents) {
        Memo memo = new Memo();

        memo.setTitle(title);
        memo.setContents(contents);

        return memo;
    }
}
