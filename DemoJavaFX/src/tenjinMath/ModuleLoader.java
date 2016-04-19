package tenjinMath;

public class ModuleLoader
{
	private ModuleLoader loader;
	private Module currentModule;
	
	private ModuleLoader()
	{
		
	}
	
	public ModuleLoader getInstance()
	{
		if (loader == null)
		{
			this.loader = new ModuleLoader();
		}
		
		return loader;
	}
	
	public Module getModule(String moduleName)
	{
		
		return currentModule;
	}
	
	private void buildModuleList()
	{
		
	}
}
