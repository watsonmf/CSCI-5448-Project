package subtractionModule;

import tenjinMath.Lesson;
import tenjinMath.Question;

public class SubtractionStrategyGradeK implements SubtractionStrategy
{
	private int[] progress;
	
	public SubtractionStrategyGradeK(int[] progress)
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
		questionArray[0] = new SubtractionQuestion(new int[] {3,1}, new char[] {'-'}, new int[] {2});
		questionArray[1] = new SubtractionQuestion(new int[] {2,1}, new char[] {'-'}, new int[] {1});
		questionArray[2] = new SubtractionQuestion(new int[] {1,1}, new char[] {'-'}, new int[] {0});
		questionArray[3] = new SubtractionQuestion(new int[] {5,1}, new char[] {'-'}, new int[] {4});
		questionArray[4] = new SubtractionQuestion(new int[] {2,1}, new char[] {'-'}, new int[] {1});
		questionArray[5] = new SubtractionQuestion(new int[] {3,1}, new char[] {'-'}, new int[] {2});
		questionArray[6] = new SubtractionQuestion(new int[] {4,1}, new char[] {'-'}, new int[] {3});
		questionArray[7] = new SubtractionQuestion(new int[] {5,1}, new char[] {'-'}, new int[] {4});

		Lesson newLesson = new Lesson(questionArray, numberOfQuestions);
		
		return newLesson;
	}

}
