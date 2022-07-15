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
		//testObj.setName("Mr. Man");
		testObj.setUsername("mrtony");
		//testObj.setPassword("SuperSecret2");
		testObj.setId(12);
		
		Object returnObj  = orm.selectByIdQuery("recipe.cook", testObj);

		
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
