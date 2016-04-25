package tenjinMath;

import additionModule.AdditionModule;

public class ModuleFactory
{
	public static Module getModule(String moduleName, User currentUser)
	{
		switch(moduleName)
		{
			case "Addition":
				return AdditionModule.getInstance(currentUser);
			case "Subtraction":
				return AdditionModule.getInstance(currentUser);
				
		}
		
		
		return null;
	}
	
	public static String[] getModuleNames()
	{
		return new String[] {"Addition", "Subtraction"};
	}
}
