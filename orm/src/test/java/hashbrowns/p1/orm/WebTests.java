package hashbrowns.p1.orm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import hashbrowns.p1.services.ChefServiceImpl;
import hashbrowns.p1.services.PlayerServiceImpl;
import hashbrowns.p1.services.RecipeServiceImpl;
import hashbrowns.p1.services.Service;


@ExtendWith(MockitoExtension.class)
public class WebTests 
{
  
	
	@InjectMocks
	private static Service chefService = new ChefServiceImpl();
	@InjectMocks
	private static Service recipeService = new RecipeServiceImpl();
	@InjectMocks
	private static Service playerService = new PlayerServiceImpl();
	
	
	
	
	
	
	
}
