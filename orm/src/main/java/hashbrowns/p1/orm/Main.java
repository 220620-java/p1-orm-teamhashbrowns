package hashbrowns.p1.orm;

import java.util.ArrayList;

import hashbrowns.p1.orm.mapper.*;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class Main {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		// For testing generated sql strings
		QueryBuilder orm = new QueryBuilder();
		TestModel cook = new TestModel();

		//

		ArrayList<String> someRecipes = new ArrayList<String>();
		someRecipes.add("Cake");
		someRecipes.add("Hot Dogs");
		someRecipes.add("Cheesesteaks");

		cook.setId(3);
		cook.setName("Chef Tyler");
		cook.setUsername("cheftee");
		cook.setPassword("password123");
		cook.setRecipes(someRecipes);
		logger.log("Test model assigned example field values", LoggingLevel.INFO);
		
		//
		
		//System.out.println(json);
		//logger.log("Java object has been displayed as a JSON object", LoggingLevel.INFO);
		
		//
		
		orm.insertQuery("recipe.cook", cook);
		orm.selectByIdQuery("recipe.cook", cook);
		orm.updateQuery("recipe.cook", cook);
		
		/*
		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.insertQuery("p1.cooks", cook) + "\n");

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.selectByIdQuery("p1.cooks", cook) + "\n");

		System.out.println("--Example UPDATE QUERY--");
		System.out.println(orm.updateQuery("p1.cooks", cook) + "\n");
		 */
		logger.log("Example query strings have been output", LoggingLevel.INFO);
	}

}
