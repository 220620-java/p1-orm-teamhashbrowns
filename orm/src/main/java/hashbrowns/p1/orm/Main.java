package hashbrowns.p1.orm;

import java.util.ArrayList;

import hashbrowns.p1.orm.mapper.*;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class Main {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) throws Exception {
		
		// Instantiate the ORM and Test Model
		QueryBuilder orm = new QueryBuilder();
		TestModel cook = new TestModel();

		
		// Setup a test object
		ArrayList<String> someRecipes = new ArrayList<String>();
		someRecipes.add("Cake");
		someRecipes.add("Hot Dogs");
		someRecipes.add("Cheesesteaks");

		cook.setId(6);
		cook.setName("Chef Tony");
		cook.setUsername("tonyw");
		cook.setPassword("newpassword");
		cook.setRecipes(someRecipes);
		logger.log("Test model assigned example field values", LoggingLevel.INFO);
		
		//Test some queries	
		//orm.insertQuery("recipe.cook", cook);
		//orm.selectByIdQuery("recipe.cook", cook);
		//orm.updateQuery("recipe.cook", cook);
		//orm.deleteQuery("recipe.cook", cook);
		logger.log("Example query strings have been output", LoggingLevel.INFO);
	}

}
