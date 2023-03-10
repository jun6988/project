package com.bit.project.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.project.readingnote.entity.ReadingNoteComment;

public interface ReadingNoteCommentRepository extends JpaRepository<ReadingNoteComment, Integer>{

}
