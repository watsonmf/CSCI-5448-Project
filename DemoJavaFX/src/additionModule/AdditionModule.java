package additionModule;

import tenjinMath.Lesson;
import tenjinMath.Module;
import tenjinMath.Question;
import tenjinMath.User;

public class AdditionModule implements tenjinMath.Module
{
	private static Module instance;
	private static String moduleID = "addition";
	private static String currentGrade;
	private static String[] mileStones = new String[] {
			"Add number <= 5 with 1", "Add number <= 10 with 1",
			"Add number <= 5 with 2", "Add number <= 10 with 2",
			"Add number <= 5 with 3", "Add number <= 10 with 3"};
	private static User currentUser;
	int progress[];
	private AdditionStrategy strategy;
	
	
	private AdditionModule(User user)
	{
		currentUser = user;
		
		String moduleProperties = currentUser.getProperty(moduleID);
		
		progress = new int[mileStones.length];
		
		if (moduleProperties == null)
		{
			char[] properties = new char[mileStones.length];
			for (int i = 0; i < mileStones.length; i ++)
			{
				progress[i] = 0;
				properties[i] = 33;
			}
			currentUser.setProperty(moduleID, new String(properties));
			
		} else
		{
			for (int i = 0; i < mileStones.length; i ++)
			{
				progress[i] = (int)moduleProperties.charAt(i);
			}
		}
		
		System.out.println(currentUser.getProperty("gradeLevel"));
		
		switch (currentUser.getProperty("gradeLevel"))
		{
		case "K":
			strategy = new AdditionStrategyGradeK(progress);
			break;
		case "1":
			strategy = new AdditionStrategyGrade1(progress);
			break;
		case "2":
			strategy = new AdditionStrategyGrade2(progress);
			break;
		case "3":
			strategy = new AdditionStrategyGrade3(progress);
			break;
		case "4":
			strategy = new AdditionStrategyGrade4(progress);
			break;
		case "5":
			strategy = new AdditionStrategyGrade5(progress);
			break;
		default:
			strategy = null;
		}
	}
	

	public static Module getInstance(User user)
	{
		if (instance == null || user.getProperty("userName").compareTo(currentUser.getProperty("userName")) != 0)
		{
			instance = new AdditionModule(user);
		}
		
		return instance;
	}
	
	@Override
	public Lesson getLesson()
	{
		return strategy.generateLesson();
	}

	@Override
	public String getSavedData()
	{
		/* PLACEHOLDER: return saved data string*/
		return "AdditionModule: Saved Data";
	}
	
	@Override
	public void loadSavedData(String savedData)
	{
		/* PLACEHOLDER: Print loading string */
		System.out.println("AdditionModule: Loading Saved Data...");
	}

	@Override
	public void updateProgress(Lesson currentLesson)
	{
		/* PLACEHOLDER: Print update string */
		System.out.println("AdditionModule: Updating Progress...");
	}
	
	private Question generateAdditionQuestion(int i)
	{
		/* PLACEHOLDER: GENERATES 1 + 1 = 2 */
		int[] operators = {i,1};
		char[] operands = {'+'};
		int[] possibleAnswers = {operators[0] + operators[1]};
		
		return new AdditionQuestion(operators, operands, possibleAnswers);
	}
}
