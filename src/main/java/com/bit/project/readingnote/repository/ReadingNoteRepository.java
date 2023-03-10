package com.bit.project.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.ReadingNote;

public interface ReadingNoteRepository extends JpaRepository<ReadingNote, Integer>{

}
