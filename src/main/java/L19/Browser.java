package L19;

import java.net.*;
import java.util.Optional;

public class Browser {
	public Optional<URL> back() {
		try {
			//simulate: fetch last URL from Stack
			return back(Math.random() < 0.5);
		}
		catch(Exception e) {
			return Optional.empty();
		}
	}

	static Optional<URL> back(boolean is_last) throws URISyntaxException, MalformedURLException {
		if (is_last) {
			return Optional.empty();
		} else {
			return Optional.of(new URI("https://duckduckgo.com").toURL());
		}
	}

	public String retrieveSite(URL url) {
		//simulate download site:
		return url.toString();
	}

	public static void main(String[] args) {
		System.out.println("Normal back");
		Browser browser = new Browser();
		Optional<URL> back = browser.back();
		if (back.isPresent()) browser.retrieveSite(back.get());
//		back.ifPresent(browser::retrieveSite);
	}
}