package com.advaya.kafkaconsumerwikimedia.repositories;

import com.advaya.kafkaconsumerwikimedia.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
