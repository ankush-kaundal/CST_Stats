package com.manh.dao;

import java.util.List;

import com.manh.model.CSTCheckList;

public interface ICSTCheckListDao {
    public List<CSTCheckList>  getProjectList();
    public void submitCheckList(CSTCheckList cstCheckList);
    public CSTCheckList getAllCSTListValueForAProject(String projectCode);
}