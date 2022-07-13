package hashbrowns.p1.orm;

import java.util.ArrayList;

import hashbrowns.p1.orm.mapper.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		QueryBuilder orm = new QueryBuilder();
		TestModel cook = new TestModel();


		
		  ArrayList<String> someRecipes = new ArrayList<String>();
		    someRecipes.add("Cake");
		    someRecipes.add("Hot Dogs");
		    someRecipes.add("Cheesesteaks");
		
		cook.setId(1);
		cook.setName("Tony");
		cook.setRecipes(someRecipes);
		
		 System.out.println("INSERT QUERY");
		 System.out.println(orm.insertObject("p1.cooks", cook) + "\n");
		 
		 System.out.println("SELECT QUERY");
		 System.out.println(orm.selectById("p1.cooks", cook) + "\n");
		 
		 System.out.println("UPDATE QUERY");
		 System.out.println(orm.update("p1.cooks", cook) + "\n");
	}

}
