package com.gentara.elurah.config;

import com.gentara.elurah.master.model.entity.RwEntity;
import com.gentara.elurah.master.repository.RwRepository;
import com.gentara.elurah.util.CommonUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final RwRepository rwRepository;

    @Override
    public void run(String... args) throws Exception {
        initialize();
    }

    private void initialize() {
        if (rwRepository.count() != 0) return;

        RwEntity rw04 = RwEntity.builder()
                .id("b215588d82014eddac837252b5f14fb4")
                .name("RW-04")
                .address("West Java")
                .build();

        List<RwEntity> rwList = List.of(rw04);

        try {
            rwRepository.saveAll(rwList);
        } catch (Exception e) {
            throw new RuntimeException("save all rw entity failed", e);
        }
    }
}
