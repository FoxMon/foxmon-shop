package com.foxmonshop.backend.feature.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    public List<Memo> getAllMemoList() {
        return this.memoRepository.findAll();
    }

    public Memo createMemo(MemoRequestDto request) {
        Memo createdMemo = Memo.createMemo(request.getTitle(), request.getContents());

        this.memoRepository.save(createdMemo);

        return createdMemo;
    }
}
