package additionModule;

import tenjinMath.Lesson;
import tenjinMath.Module;
import tenjinMath.Question;

public class AdditionModule implements tenjinMath.Module
{
	private static Module instance;
	private static int moduleID = 1919;
	
	
	private AdditionModule()
	{
		
	}
	

	public static Module getInstance()
	{
		if (instance == null)
		{
			instance = new AdditionModule();
		}
		
		return instance;
	}
	
	@Override
	public Lesson getLesson()
	{
		int numberOfQuestions = 10;
		Question[] questionArray = new Question[numberOfQuestions];
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			questionArray[i] = generateAdditionQuestion();
		}
		
		Lesson newLesson = new Lesson(questionArray, numberOfQuestions);
		
		return newLesson;
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
	
	private Question generateAdditionQuestion()
	{
		/* PLACEHOLDER: GENERATES 1 + 1 = 2 */
		int[] operators = {1,1};
		char[] operands = {'+'};
		int[] possibleAnswers = {2};
		
		return new AdditionQuestion(operators, operands, possibleAnswers);
	}
}
