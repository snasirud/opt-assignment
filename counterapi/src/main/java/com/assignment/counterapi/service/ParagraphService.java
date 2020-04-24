package com.assignment.counterapi.service;

import com.assignment.counterapi.domain.Paragraph;
import com.assignment.counterapi.exception.CounterApiException;

import java.util.List;
import java.util.Map;

public interface ParagraphService {
    String search(List<String> searchList) throws CounterApiException;

    String top(Integer count) throws CounterApiException;

}
