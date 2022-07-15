package hashbrowns.p1.orm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import hashbrowns.p1.orm.mapper.*;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class ObjectTesting {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) throws Exception {
		
		// Instantiate the ORM and Test Model
		Orm orm = new Orm();
		
		
		
		TestModel testObj = new TestModel();
		//testObj.setName("Tony Wiedman");
		//testObj.setPosition("3B/SS");
		//testObj.setDebut("04/10/2022");
		//testObj.setAverage(0.348);
		//testObj.setHomeruns(47);
		//testObj.setRbi(115);
		//testObj.setActive(false);
		testObj.setId(2);
		
		Object returnObj  = orm.selectByIdQuery("players.player", testObj);

		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(returnObj);
		
		System.out.println(json);
		
		
		
		logger.log("Test model assigned example field values", LoggingLevel.INFO);
		
		//Test some queries	
		//orm.insertQuery("recipe.cook", testObj);
		//orm.selectByIdQuery("recipe.cook", testObj);
		//orm.updateQuery("recipe.cook", testObj);
		//orm.deleteQuery("recipe.cook", testObj);
		logger.log("Example query strings have been output", LoggingLevel.INFO);
	}

}
