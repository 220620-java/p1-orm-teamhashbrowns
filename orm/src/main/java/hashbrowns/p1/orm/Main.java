package hashbrowns.p1.orm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import hashbrowns.p1.orm.mapper.*;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class Main {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) throws Exception {
		
		// Instantiate the ORM and Test Model
		QueryBuilder orm = new QueryBuilder();
		
		
		
		Object cook = new TestModel();

		Object cook2  = orm.selectByIdQuery("recipe.cook", cook);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(cook2);
		
		System.out.println(json);
		System.out.println(cook2);
		//cook.setName("Chef Tony");
		//cook.setUsername("tonyw");
		//cook.setPassword("newpassword");
		//cook.setRecipes(someRecipes);
		
		logger.log("Test model assigned example field values", LoggingLevel.INFO);
		
		//Test some queries	
		//orm.insertQuery("recipe.cook", cook);
		
		//orm.updateQuery("recipe.cook", cook);
		//orm.deleteQuery("recipe.cook", cook);
		logger.log("Example query strings have been output", LoggingLevel.INFO);
	}

}
