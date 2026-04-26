package com.moodsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moodsync.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{}
