package com.calculate.CalculateProject.service;

import java.util.List;

import com.calculate.CalculateProject.model.Feedback;

public interface FeedbackService {

	Feedback insertrecord(Feedback r);
    List<Feedback> getAll();
    void del(int ri);
    Feedback updaterecord( int i,Feedback r);
}
