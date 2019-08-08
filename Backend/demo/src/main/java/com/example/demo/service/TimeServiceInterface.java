package com.example.demo.service;

import com.example.demo.entity.projectTimeEntity;

public interface TimeServiceInterface {

    /**
     *  Creates a ProjectTime entry
     */
    projectTimeEntity create(projectTimeEntity time);

    /**
     *  Edit a projectsTime entry
     */
    projectTimeEntity change(projectTimeEntity time);

    /**
     *  Deletes a project time
     */
    void delete(Long id);
}
