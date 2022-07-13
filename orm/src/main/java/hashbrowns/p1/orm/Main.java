package hashbrowns.p1.orm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import hashbrowns.p1.orm.mapper.*;
import hashbrowns.p1.orm.utils.Logger;
import hashbrowns.p1.orm.utils.LoggingLevel;

public class Main {
	private static Logger logger = Logger.getLogger();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		// For testing generated sql strings
		QueryBuilder orm = new QueryBuilder();
		TestModel cook = new TestModel();
		Scanner scan = new Scanner(System.in);

		//
		System.out.println("Chef Name:");
		String name = scan.nextLine();
		
		System.out.println("Username:");
		String user = scan.nextLine();
		
		System.out.println("Adding some example recipes to your object!\nPress [Enter]");
		scan.nextLine();
		logger.log("User has entered in test field information", LoggingLevel.INFO);
		
		//
		ArrayList<String> someRecipes = new ArrayList<String>();
		someRecipes.add("Cake");
		someRecipes.add("Hot Dogs");
		someRecipes.add("Cheesesteaks");

		cook.setId(1);
		cook.setName(name);
		cook.setUsername(user);
		cook.setRecipes(someRecipes);
		logger.log("User input and example array has been added to the test model", LoggingLevel.INFO);
		
		//
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(cook);
		System.out.println(json);
		logger.log("Java object has been displayed as a JSON object", LoggingLevel.INFO);
		
		//
		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.insertObject("p1.cooks", cook) + "\n");

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.selectById("p1.cooks", cook) + "\n");

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.update("p1.cooks", cook) + "\n");
		logger.log("Example query strings have been output", LoggingLevel.INFO);
	}

}
