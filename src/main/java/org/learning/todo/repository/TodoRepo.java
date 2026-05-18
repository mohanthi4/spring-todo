package org.learning.todo.repository;
import org.learning.todo.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends MongoRepository<Todo,String>{
//    @Query("{'id': ?0 }")
    Todo findTodoById(String Id);
}
