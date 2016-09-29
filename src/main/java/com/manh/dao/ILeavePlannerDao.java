package com.manh.dao;

import java.util.List;

import com.manh.model.LeavePlanner;

public interface ILeavePlannerDao {
    public void submitLeaveDetails(LeavePlanner leavePlanner);	
    public List<LeavePlanner> getAllAppliedLeave();
    public List<LeavePlanner> getAppliedLeaveByUserId(String userId);
    public List<LeavePlanner> getAllUserInfo();
}