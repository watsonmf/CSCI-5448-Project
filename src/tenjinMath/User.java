package tenjinMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Properties;

public abstract class User
{
	protected String userName;
	protected Properties userData;
	
	public User(String userName)
	{
		this.userName = userName;
		loadUserData();
	}
	
	private void loadUserData()
	{
		userData = Tenjin.loadProperties(userName + ".config", "users");
	}
	
	private void storeUserData()
	{
		OutputStream os = null;
		
		File dir = new File("users");
		
		dir.mkdirs();
		
		try
		{
			os = new FileOutputStream("users" + File.separatorChar + userName + ".config");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			userData.store(os, "Tenjin User Account");
			os.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key)
	{
		return userData.getProperty(key);
	}
	
	public void setProperty(String key, String value)
	{
		userData.setProperty(key, value);
		storeUserData();
	}
	
	public abstract boolean checkLoginInfo();
}
