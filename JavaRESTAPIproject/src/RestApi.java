import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;


public class RestApi {

	public static void main(String[] args) throws Exception{
		
		Trancript transcript = new Transcript();
		trancript.setAudio_url("");
		Gson gson = new Gson();
		gson.toJson(transcript);
		String jsonRequest = gson.toJson(transcript);
		
		System.out.println(jsonRequest);
		
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.assemblyai.com/v2/transcript"))
				.header("Authorization", Constants.API_KEY)
				.POST(BodyPublishers.ofString(""))
		
		
		
	}

}
