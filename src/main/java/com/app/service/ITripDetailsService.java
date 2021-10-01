package com.app.service;

import java.util.List;

import com.app.dto.ScheduleRequest;
import com.app.dto.ScheduleResponse;

public interface ITripDetailsService {

	public List<ScheduleResponse> getSchedule(int id);
}
