package hashbrowns.p1.orm;

import java.util.ArrayList;
import java.util.Scanner;

import hashbrowns.p1.orm.mapper.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// For testing generated sql strings
		QueryBuilder orm = new QueryBuilder();
		TestModel cook = new TestModel();
		Scanner scan = new Scanner(System.in);

		System.out.println("Chef Name:");
		String name = scan.nextLine();
		System.out.println("Username:");
		String user = scan.nextLine();
		System.out.println("Adding some example recipes to your object!\nPress [Enter]");
		scan.nextLine();

		ArrayList<String> someRecipes = new ArrayList<String>();
		someRecipes.add("Cake");
		someRecipes.add("Hot Dogs");
		someRecipes.add("Cheesesteaks");

		cook.setId(1);
		cook.setName(name);
		cook.setUsername(user);
		cook.setRecipes(someRecipes);

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.insertObject("p1.cooks", cook) + "\n");

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.selectById("p1.cooks", cook) + "\n");

		System.out.println("--Example INSERT QUERY--");
		System.out.println(orm.update("p1.cooks", cook) + "\n");
	}

}
