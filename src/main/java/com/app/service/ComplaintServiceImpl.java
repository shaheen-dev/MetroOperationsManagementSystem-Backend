package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IComplaintRepository;
import com.app.dto.RegisterComplaint;
import com.app.dto.ReplyToComplaint;
import com.app.dto.UserEmailRequest;
import com.app.pojos.Complaints;

@Service
@Transactional
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	private IComplaintRepository complaintRepo;

	public Complaints registerComplaint(RegisterComplaint complaint) {

		Complaints newComplaint = new Complaints();

		newComplaint.setName(complaint.getName());
		newComplaint.setAddress(complaint.getAddress());
		newComplaint.setEmail(complaint.getEmail());
		newComplaint.setMsg(complaint.getMsg());
		newComplaint.setPhone(complaint.getPhone());
		newComplaint.setStatus(false);
		newComplaint.setDateTime(LocalDate.now());
		newComplaint.setResponse("");

		return complaintRepo.save(newComplaint);

	}

	@Override
	public List<Complaints> displayAllComplaintsByEmail(UserEmailRequest request) {

		return complaintRepo.findByEmail(request.getEmail());
	}
	@Override
	public List<Complaints> displayAllComplaints() {
		
		return complaintRepo.findAll();
	}

	@Override
	public String replyToComplaints(int id, ReplyToComplaint msg) {
		var complaint = complaintRepo.getById(id);
		complaint.setResponse(msg.getMsgString());
		complaint.setStatus(true);
		complaintRepo.save(complaint);
		return "Replied to Complaint";
	}

	@Override
	public long getAllComplaints() {
		// TODO Auto-generated method stub
		return complaintRepo.count();
	}

	@Override
	public int getAllPendingComplaints() {
		// TODO Auto-generated method stub
		return complaintRepo.getAllPendingComplaints();
	}
}
