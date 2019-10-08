import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Main {

	private final static Properties properties = new Properties();

	public static void main(String[] args) throws IOException {

		properties.load(Main.class.getResourceAsStream("example.properties"));

		BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		String input = rdr.readLine();

		while (!"exit".equals(input)) {
			try {
				printProp(input);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			input = rdr.readLine();
		}

	}

	private static void printProp(String propName) throws Exception {

		if (!properties.containsKey(propName))
			throw new Exception(String.format("No such property [%s]", propName));

		System.out.println(properties.getProperty(propName));
	}

}
