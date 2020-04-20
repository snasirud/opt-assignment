package com.assignment.counterapi.service;

import com.assignment.counterapi.domain.Paragraph;

import java.util.List;
import java.util.Map;

public interface ParagraphService {
    String search(List<String> searchList);

    String top(Integer count);

}
