package studyo.json.validator;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONUtils {
	public static boolean isValid(String json) {
		boolean valid = false;
		   try {
		      final JsonParser parser = new ObjectMapper().getFactory().createParser(json);
		      while (parser.nextToken() != null) {
		      }
		      valid = true;
		   } catch (JsonParseException jpe) {
		      jpe.printStackTrace();
		   } catch (IOException ioe) {
		      ioe.printStackTrace();
		   }

		   return valid;
	}
	
	public static String addEntry(String json, String name, String value) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readValue(json, JsonNode.class);
		((ObjectNode)rootNode).put(name, value);
		
		return rootNode.toString();
	}
}
