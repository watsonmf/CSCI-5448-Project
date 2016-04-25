package tenjinMath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import additionModule.AdditionModule;

import java.util.Properties;

public class Tenjin
{
	private static final String configFileName = "Tenjin.config";
	private static Properties tenjinProperties;
	private static User currentUser;
	private static Module currentModule;
	private static Lesson currentLesson;
	
	public static void main(String[] args)
	{
		/* TEST FUNCTIONALITY */
		Scanner scan = new Scanner(System.in);
		String userInput;
		System.out.println("Welcome to Tenjin Math.\nPlease enter your userName:");
		userInput = scan.nextLine();
		
		currentUser = new Student(userInput);
		currentUser.setProperty("userName", userInput);
		
		currentModule = ModuleFactory.getModule("Addition", currentUser);
		
		currentLesson = currentModule.getLesson();
		
		
		for (int i = 0; i < currentLesson.getNumberOfQuestions(); i++)
		{
			System.out.println(currentLesson.getQuestion(i).getShortQuestion());
		}
		
		for (int i = 0; i < currentLesson.getNumberOfQuestions(); i++)
		{
			System.out.println(currentLesson.getQuestion(i).getLongQuestion());
			String answer = scan.nextLine();
			
			currentLesson.getQuestion(i).storeAnswer(answer);
		}
		
		boolean results[] = currentLesson.gradeLesson();
		
		for (int i = 0; i < currentLesson.getNumberOfQuestions(); i++)
		{
			System.out.println(currentLesson.getQuestion(i).getShortQuestion() + " " + results[i]);
		}
		
		//getProps("test.cfg", "users");
		
		buildDefaultConfig();
		
		//currentModule = new AdditionModule();
		
		
		scan.close();
		/* END TEST */
	}
	
	private void loadModules()
	{
		
	}
	
	private void startLesson()
	{
		
	}
	
	private User[] loadUsers(String userDir)
	{
		//Files.exists(userDir, );
		return null;
	}
	
	private static Properties loadProperties(String fileName)
	{
		return loadProperties(fileName, null);
	}
	
	public static Properties loadProperties(String fileName, String fileDir)
	{
		String filePath;
		
		if (fileDir != null)
		{
			filePath = fileDir + File.separatorChar + fileName;
		} else
		{
			filePath = fileName;
		}
		
		File file = new File(fileDir + File.separatorChar + fileName);
				
		Properties props = new Properties();
		
		try
		{
			props.load(new FileInputStream(file));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return props;
	}
	
	private static void buildDefaultConfig()
	{
		Properties newProperties = new Properties();
		OutputStream os = null;
		
		try
		{
			os = new FileOutputStream(configFileName);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newProperties.setProperty("userDirectory", "users");
		newProperties.setProperty("moduleDirectory", "modules");
		
		try
		{
			newProperties.store(os, "This is a test");
			os.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String userFileDir = "user";
		//String moduleDir = "modules";
	}

	public Properties getTenjinProperties()
	{
		return tenjinProperties;
	}

	public void setTenjinProperties(Properties tenjinProperties)
	{
		this.tenjinProperties = tenjinProperties;
	}
	
	public static String[] getUserList()
	{
		File folder = new File("users");
		folder.mkdir();
		
		File[] fileList = folder.listFiles();
		int fileCount = fileList.length;
		
		String[] list = new String[fileCount];
		String[] fileNameArray;
		
		int j = 0;
		for (int i = 0; i < fileCount; i++)
		{
			fileNameArray = fileList[i].getName().split("\\.");
			
			System.out.println(fileNameArray[0] + " " + fileNameArray[1]);
			
			if (fileNameArray[1].equalsIgnoreCase("config"))
			{
				System.out.println("equals");
				list[j++] = fileNameArray[0];
			}
		}
		
		return list;
	}

}
