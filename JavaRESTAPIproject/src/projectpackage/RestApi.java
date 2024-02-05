package projectpackage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

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
                .POST(BodyPublishers.ofString(jsonRequest))
                .build();
        
        HttpClient httpClient = HttpClient.newHttpClient();
        
        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        
        System.out.println(postResponse.body());
        
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        
        System.out.println(transcript.getId());
        
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", Constants.API_KEY)
                .build();
        
        
        //What we want to do next?
        /*Keep sending the getRequest over and over again until 
        the response that we get back has a status - "Completed" */
        //or the API could also return an error for the file!
        while(true) {
        	   HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
        	   
//        	   System.out.println(getResponse.body());

               transcript = gson.fromJson(getResponse.body(), Transcript.class);
               
               System.out.println(transcript.getStatus());
               
               //break out of the loop if there is an error or the request process is completed
               
               if("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
            	   break;
               }
               
               Thread.sleep(1000);
        }
        
        System.out.println("Transcription Completed!");
        System.out.println("Trancribed Text: "+ transcript.getText());    
		
	}

}


/*
 OUTPUT:
 
{"audio_url":"https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw\u003dtrue"}
{"id": "ecd24a96-dee6-47c5-b014-d7e29a4446b6", "language_model": "assemblyai_default", "acoustic_model": "assemblyai_default", "language_code": "en_us", "status": "queued", "audio_url": "https://github.com/sam301100/Java-RESTful-API/blob/master/Thirsty.mp4?raw=true", "text": null, "words": null, "utterances": null, "confidence": null, "audio_duration": null, "punctuate": true, "format_text": true, "dual_channel": null, "webhook_url": null, "webhook_status_code": null, "webhook_auth": false, "webhook_auth_header_name": null, "speed_boost": false, "auto_highlights_result": null, "auto_highlights": false, "audio_start_from": null, "audio_end_at": null, "word_boost": [], "boost_param": null, "filter_profanity": false, "redact_pii": false, "redact_pii_audio": false, "redact_pii_audio_quality": null, "redact_pii_policies": null, "redact_pii_sub": null, "speaker_labels": false, "content_safety": false, "iab_categories": false, "content_safety_labels": {}, "iab_categories_result": {}, "language_detection": false, "custom_spelling": null, "throttled": null, "auto_chapters": false, "summarization": false, "summary_type": null, "summary_model": null, "custom_topics": false, "topics": [], "speech_threshold": null, "speech_model": null, "chapters": null, "disfluencies": false, "entity_detection": false, "entities": null, "speakers_expected": null, "summary": null, "sentiment_analysis": false, "sentiment_analysis_results": null}
ecd24a96-dee6-47c5-b014-d7e29a4446b6
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
processing
completed
Transcription Completed!
Trancribed Text: These pretzels are making me thirsty.

*/
