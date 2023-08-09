package Connection;

import java.util.List;

import Dto.EventDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/Event/GetAll/Get All Events")
    Call<List<EventDto>> getAllEvents();

    @GET("Get Events By Id")
    Call<EventDto> getEventById(@Query("id") int id);
}
