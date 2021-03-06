package jaffa.mco364.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoService {

	@GET("/todos")
	Call<List<Todo>> listTodos(); // returns a Call object

}
