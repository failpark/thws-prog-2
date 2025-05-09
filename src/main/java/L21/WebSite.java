package L21;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.*;

public class WebSite {
	public static void main(String[] args) {
		Response response = ClientBuilder.newClient()
				.target("https://jsonplaceholder.typicode.com")
				.path("posts/1")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get();
		String s = response.readEntity(String.class);
		System.out.println(s);
	}
}
