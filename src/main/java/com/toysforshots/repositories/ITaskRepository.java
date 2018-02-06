package com.toysforshots.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toysforshots.entities.Task;

public interface ITaskRepository   extends CrudRepository<Task, Long>{

}
