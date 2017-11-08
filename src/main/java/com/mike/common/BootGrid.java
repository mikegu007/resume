package com.mike.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 2017/11/7.
 */
public class BootGrid<T> implements Serializable {
    private String id;
    private boolean result;
    private String resultDes;
    private int current;
    private int rowCount;
    private String searchPhrase;
    private int total;
    private List<T> rows = new ArrayList();
    private T row;
    private Map sort;
    private Date currentServiceDate;

    public BootGrid() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getResultDes() {
        return this.resultDes;
    }

    public void setResultDes(String resultDes) {
        this.resultDes = resultDes;
    }

    public int getCurrent() {
        return this.current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String getSearchPhrase() {
        return this.searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public T getRow() {
        return this.row;
    }

    public void setRow(T row) {
        this.row = row;
    }

    public Map getSort() {
        return this.sort;
    }

    public void setSort(Map sort) {
        this.sort = sort;
    }

    public Date getCurrentServiceDate() {
        return this.currentServiceDate;
    }

    public void setCurrentServiceDate(Date currentServiceDate) {
        this.currentServiceDate = currentServiceDate;
    }
}
