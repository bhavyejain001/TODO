package com.training.todo.repo;

import java.io.IOException;
import java.util.ArrayList;

import com.training.todo.dto.ToDoDTO;

public interface IToDoRepo  {
	public boolean addTask(ArrayList<ToDoDTO> todo) throws IOException;
	ArrayList<ToDoDTO> printTasks() throws IOException, IOException, ClassNotFoundException;
}
