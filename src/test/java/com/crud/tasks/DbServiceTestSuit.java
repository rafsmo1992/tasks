package com.crud.tasks;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbServiceTestSuit {

    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository taskRepository;


    @Test
    void dbServiceTest() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "title", "content");
        Task task1 = new Task(2L, "title1", "content1");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);
        long id = task.getId();
        long id1 = task1.getId();
        when(dbService.saveTask(any(Task.class))).thenReturn(task);
        when(dbService.getAllTasks()).thenReturn(tasks);
        when(taskRepository.findById(id1)).thenReturn(Optional.of(task1));
        Mockito.doNothing().when(taskRepository).deleteById(any());

        //When
        Task savedTask = dbService.saveTask(task);
        List<Task> tasksResult = dbService.getAllTasks();
        Task resultTask = dbService.getTask(id1);

        //Then
        assertEquals(2, tasksResult.size());
        assertEquals("content", savedTask.getContent());
        assertEquals("title1", resultTask.getTitle());

        //CleanUp
        dbService.deleteTask(id);
        dbService.deleteTask(id1);
    }
}