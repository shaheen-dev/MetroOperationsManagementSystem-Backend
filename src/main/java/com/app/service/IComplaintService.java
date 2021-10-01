package com.app.service;

import java.util.List;

import com.app.dto.UserEmailRequest;
import com.app.dto.RegisterComplaint;
import com.app.dto.ReplyToComplaint;
import com.app.pojos.Complaints;

public interface IComplaintService {

	public Complaints registerComplaint(RegisterComplaint complaint);
	
	public List<Complaints>  displayAllComplaintsByEmail(UserEmailRequest request);

	public String replyToComplaints(int id, ReplyToComplaint msgString);

	public List<Complaints> displayAllComplaints();//admin

	public long getAllComplaints();

	public int getAllPendingComplaints();
}
