package subtractionModule;

import tenjinMath.Lesson;
import tenjinMath.Question;

public class SubtractionStrategyGrade4 implements SubtractionStrategy
{
	private int[] progress;
	
	public SubtractionStrategyGrade4(int[] progress)
	{
		this.progress = progress;
	}
	
	@Override
	public Lesson generateLesson()
	{

		int numberOfQuestions = 10;
		Question[] questionArray = new Question[numberOfQuestions];
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			/* PLACEHOLDER: GENERATES 1 + 1 = 2 */
			int[] operators = {i,1};
			char[] operands = {'+'};
			int[] possibleAnswers = {operators[0] + operators[1]};
			
			questionArray[i] =  new SubtractionQuestion(operators, operands, possibleAnswers);
		}
		
		Lesson newLesson = new Lesson(questionArray, numberOfQuestions);
		
		return newLesson;
	}

}
