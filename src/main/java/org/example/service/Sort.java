package org.example.service;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    private List<Long> listIntegers = new ArrayList<>();
    private List<Double> listFloats = new ArrayList<>();
    private List<String> listStrings = new ArrayList<>();

    void assort(List<String> dataList){
        for (String el : dataList){
            if (isLong(el)) {
                listIntegers.add(Long.parseLong(el));
            }
            else if (isDouble(el)) {
                listFloats.add(Double.parseDouble(el));
            }
            else {
                listStrings.add(el);
             }
        }
    }

    private boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<String> getListStrings() {
        return listStrings;
    }

    public List<Long> getListIntegers() {
        return listIntegers;
    }
    public List<Double> getListFloats() {
        return listFloats;
    }
}
