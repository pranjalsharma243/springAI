package com.springai.service;

import com.springai.entity.Tutorial;

import java.util.List;

public interface ChatService {

    List<Tutorial> chat(String query);
}
