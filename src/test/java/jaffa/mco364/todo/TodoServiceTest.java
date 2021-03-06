package jaffa.mco364.todo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoServiceTest {

	// should verify that you download 200 todo items
	@Test
	public void testListTodos() throws IOException {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://jsonplaceholder.typicode.com")
				.addConverterFactory(GsonConverterFactory.create()).build();

		TodoService service = retrofit.create(TodoService.class);

		Call<List<Todo>> call = service.listTodos();

		Response<List<Todo>> response = call.execute();

		List<Todo> list = response.body();

		assertEquals(200, list.size());
	}

}
