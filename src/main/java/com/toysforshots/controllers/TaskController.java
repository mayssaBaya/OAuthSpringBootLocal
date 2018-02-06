package com.toysforshots.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toysforshots.dto.TaskDTO;
import com.toysforshots.dto.UserDTO;
import com.toysforshots.entities.Task;
import com.toysforshots.repositories.ITaskRepository;




@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo")
public class TaskController {
	@Autowired // This means to get the bean called userRepository
	private ITaskRepository TaskRepository;
	@GetMapping(path="/all")
	@ResponseBody
	public  Iterable<TaskDTO> getAllTasks() {
		// This returns a JSON or XML with the users
		Iterable<Task> listOfTask = TaskRepository.findAll();
		List<TaskDTO> listOfTaskDto =new ArrayList<>();
		for (Task task : listOfTask) {
			TaskDTO dto = new TaskDTO();
			dto.setDescription(task.getDescription());
			dto.setEndDate(task.getEndDate());
			dto.setStartDate(task.getStartDate());
			UserDTO userDto =new UserDTO();
			dto.setUser(userDto);
			dto.setStatus(task.getStatus());
			listOfTaskDto.add(dto);

		}
		return listOfTaskDto;
	}
	
	

}
