package org.learning.todo.controller;

import org.junit.jupiter.api.Test;
import org.learning.todo.exceptions.TodoNotFoundException;
import org.learning.todo.models.Todo;
import org.learning.todo.repository.TodoRepo;
import org.learning.todo.views.TodoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureRestTestClient
class TodoControllerTest {
    @Autowired
    private RestTestClient client;

    @Autowired
    private TodoRepo repo;

    @Test
    void shouldRetrieveTodo() throws TodoNotFoundException {
        TodoView expectedTodoView = new TodoView("2", "Official", List.of());
        repo.save(new Todo("2","Official"));
        TodoView actualTodoView = client.get().uri("/api/todo/2")
                .exchange()
                .expectStatus().isOk()
                .expectBody(TodoView.class).returnResult().getResponseBody();

        assertEquals(expectedTodoView, actualTodoView);
    }
}