package com.example.demo.service;

import com.example.demo.entity.dayEntity;

public interface DayServiceInterface {
    /**
     *  Creates a day with start and end time
     */
    dayEntity create(dayEntity day);

    /**
     *  Updates a day's start and end time
     */
    dayEntity change(dayEntity day);

    /**
     *  Deletes a day
     */
    void delete(Long id);
}
