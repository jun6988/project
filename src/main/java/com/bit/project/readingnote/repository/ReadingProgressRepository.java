package com.bit.project.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.ReadingProgress;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Integer> {

}
