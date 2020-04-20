package com.assignment.counterapi.service.impl;

import com.assignment.counterapi.domain.Paragraph;
import com.assignment.counterapi.repository.ParagraphRepository;
import com.assignment.counterapi.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Comparator;
//import Java.util.Tuple;


@Service
public class ParagraphServiceImpl implements ParagraphService {

    private ParagraphRepository paraRepository;

    private List<Paragraph> Paragraphs;
    private HashMap<String, Integer> WordMap;

    @Autowired
    public ParagraphServiceImpl(ParagraphRepository paraRepository) {

        this.paraRepository = paraRepository;
        Paragraphs = (List<Paragraph>)paraRepository.findAll();

        WordMap = new LinkedHashMap<String, Integer>();
        this.Paragraphs.stream().forEach(p -> this.countRepeatedWords(p.getPara()));
    }

    @Override
    public String search(List<String> searchList) {

        Map returnWordMap = new HashMap(WordMap);

        List<String> lowerSearchList = searchList.stream()
                                        .map(String::toLowerCase)
                                        .collect(Collectors.toList());

        returnWordMap.keySet().retainAll(lowerSearchList);

        lowerSearchList.stream().forEach(x -> returnWordMap.putIfAbsent(x , 0));

        return formatSearchResult(returnWordMap);
    }

    @Override
    public String top(Integer count) {

        Map<String, Integer> returnWordMap = new LinkedHashMap<>();;

        WordMap.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .forEachOrdered(x -> returnWordMap.put(x.getKey(), x.getValue()));

        return formatTopSearchResult(returnWordMap);
    }

    private void  countRepeatedWords(String wordToFind) {
        String[] words = wordToFind.toLowerCase().split(" ");

        for (String word : words) {
            WordMap.put(word,
                    (WordMap.get(word) == null ? 1 : (WordMap.get(word) + 1)));
        }

        System.out.println(WordMap);
    }


    private String formatSearchResult(Map<String, Integer> searchResultWordMap) {

        JSONArray ja = new JSONArray();

        searchResultWordMap.entrySet()
                           .stream()
                           .forEachOrdered(x -> ja.put((new JSONObject()).put(x.getKey(), x.getValue())));


        JSONObject mainObj = new JSONObject();
        mainObj.put("counts", ja);

        return mainObj.toString();
    }

    private String formatTopSearchResult(Map<String, Integer> searchResultWordMap) {

        StringBuilder resultCSV = new StringBuilder();

        searchResultWordMap.entrySet()
                            .stream()
                            .forEach(x -> {
                                resultCSV.append(x.getKey() + "|" + x.getValue());
                                resultCSV.append("\n");
                            });


        return resultCSV.toString();

    }
}
