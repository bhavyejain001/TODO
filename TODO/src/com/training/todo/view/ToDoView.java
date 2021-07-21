package com.training.todo.view;
import static com.training.todo.utils.MessageReader.getValue;
import static com.training.todo.utils.Constants.*;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.training.todo.dto.ToDoDTO;
import com.training.todo.repo.IToDoRepo;
import com.training.todo.repo.ToDoRepo;
public class ToDoView {
	private static Scanner scanner=new Scanner(System.in);
	
	private static void addTask() {
		scanner.nextLine();
		System.out.println(getValue("input.taskname"));
		String name=scanner.nextLine();
		System.out.println(getValue("input.taskdescription"));
		String desc=scanner.nextLine();
		ToDoDTO todo=new ToDoDTO(name,desc);
		String result = getValue("record.notadded");

		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			ArrayList<ToDoDTO> tasks = null;
			try {
				 tasks = repo.printTasks();
			}
			catch(EOFException e) {
				System.out.println("File is Empty and add a new reacord in empty file");
			}
			if(tasks!=null && tasks.size()>0) {
				tasks.add(todo);
			}else {
				tasks = new ArrayList<>();
				tasks.add(todo);
			}
			result = repo.addTask(tasks) ? getValue("record.added") : getValue("record.notadded");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	public static void printAllTasks() {
		
		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			ArrayList<ToDoDTO> tasks = repo.printTasks();
			for(ToDoDTO task : tasks) {
				System.out.println(task);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		outer:
		while(true) {
		System.out.println(getValue("addtask"));
		System.out.println(getValue("deletetask"));
		System.out.println(getValue("updatetask"));
		System.out.println(getValue("printtask"));
		System.out.println(getValue("searchtask"));
		System.out.println(getValue("exittask"));
		System.out.println(getValue("choice"));
		int choice=scanner.nextInt();
		switch(choice) {
		case ADD_TASK:
			addTask();
			break;
		case PRINT_TASK:
			printAllTasks();
			break;
		case EXIT:
			break outer;
		}
		}
		scanner.close();
	}
}
