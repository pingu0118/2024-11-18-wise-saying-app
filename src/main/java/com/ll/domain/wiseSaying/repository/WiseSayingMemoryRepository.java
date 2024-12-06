package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


    public class WiseSayingMemoryRepository implements WiseSayingRepository {
        private final List<WiseSaying> wiseSayings;
        private int lastId;

        public WiseSayingMemoryRepository() {
            this.wiseSayings = new ArrayList<>();
            this.lastId = 0;
        }

        public void add(WiseSaying wiseSaying) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        public List<WiseSaying> findAll() {
            return wiseSayings;
        }

        public boolean removeById(int id) {
            return wiseSayings.removeIf(e -> e.getId() == id);
        }

        public Optional<WiseSaying> findById(int id) {
            return wiseSayings.stream()
                    .filter(e -> e.getId() == id)
                    .findFirst();
        }

        public void modify(WiseSaying wiseSaying) {
            // 현재는 메모리에 저장, so 여기서 할일이 없음.
        }
    }
