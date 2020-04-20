package com.assignment.counterapi.repository;

import com.assignment.counterapi.domain.Paragraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParagraphRepository extends CrudRepository<Paragraph, Long> {

}
