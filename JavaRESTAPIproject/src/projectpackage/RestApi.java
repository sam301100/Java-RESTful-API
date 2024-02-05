package projectpackage;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import com.google.gson.*;

public class RestApi {

	public static void main(String[] args) throws Exception{
		
		Transcript transcript = new Transcript();
		transcript.setAudio_url("https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw=true");
		Gson gson = new Gson();
		gson.toJson(transcript);
		String jsonRequest = gson.toJson(transcript);
		
		System.out.println(jsonRequest);
		
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", Constants.API_KEY)
                .POST(BodyPublishers.ofString("{\"audio_url\": \"https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw=true\"}"))
                .build();
		
	}

}
