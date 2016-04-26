package tenjinMath;

import additionModule.AdditionModule;
import subtractionModule.SubtractionModule;

public class ModuleFactory
{
	public static Module getModule(String moduleName, User currentUser)
	{
		switch(moduleName)
		{
			case "Addition":
				return AdditionModule.getInstance(currentUser);
			case "Subtraction":
				return SubtractionModule.getInstance(currentUser);
				
		}
		
		
		return null;
	}
	
	public static String[] getModuleNames()
	{
		return new String[] {"Addition", "Subtraction"};
	}
}
