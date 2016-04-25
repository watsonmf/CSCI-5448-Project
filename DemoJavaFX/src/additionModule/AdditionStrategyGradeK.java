package additionModule;

import tenjinMath.Lesson;
import tenjinMath.Question;

public class AdditionStrategyGradeK implements AdditionStrategy
{
	private int[] progress;
	
	public AdditionStrategyGradeK(int[] progress)
	{
		this.progress = progress;
	}
	
	@Override
	public Lesson generateLesson()
	{
		int numberOfQuestions = 8;
		Question[] questionArray = new Question[numberOfQuestions];
		
/*		for (int i = 0; i < numberOfQuestions; i++)
		{
			 PLACEHOLDER: GENERATES 1 + 1 = 2 
			int[] operators = {i,1};
			char[] operands = {'+'};
			int[] possibleAnswers = {operators[0] + operators[1]};
			
			questionArray[i] =  new AdditionQuestion(operators, operands, possibleAnswers);
		}
		*/
		questionArray[0] = new AdditionQuestion(new int[] {3,1}, new char[] {'+'}, new int[] {4});
		questionArray[1] = new AdditionQuestion(new int[] {2,1}, new char[] {'+'}, new int[] {3});
		questionArray[2] = new AdditionQuestion(new int[] {1,1}, new char[] {'+'}, new int[] {2});
		questionArray[3] = new AdditionQuestion(new int[] {5,1}, new char[] {'+'}, new int[] {6});
		questionArray[4] = new AdditionQuestion(new int[] {2,1}, new char[] {'+'}, new int[] {3});
		questionArray[5] = new AdditionQuestion(new int[] {3,1}, new char[] {'+'}, new int[] {4});
		questionArray[6] = new AdditionQuestion(new int[] {4,1}, new char[] {'+'}, new int[] {5});
		questionArray[7] = new AdditionQuestion(new int[] {5,1}, new char[] {'+'}, new int[] {6});

		Lesson newLesson = new Lesson(questionArray, numberOfQuestions);
		
		return newLesson;
	}

}
