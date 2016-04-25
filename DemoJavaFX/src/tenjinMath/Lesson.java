package tenjinMath;

public class Lesson
{
	private int numberOfQuestions;
	private String lessonTitle;
	private Question[] questions;
	
	public Lesson(Question[] questions, int numberOfQuestions)
	{
		this.questions = questions;
		this.numberOfQuestions = numberOfQuestions;
	}
	
	public int getNumberOfQuestions()
	{
		return numberOfQuestions;
	}
	
	public Question getQuestion(int questionNumber)
	{
		if (questionNumber > numberOfQuestions)
		{
			// THROW ERROR
		}
		return questions[questionNumber];
	}
	
	public boolean[] gradeLesson ()
	{
		boolean[] results = new boolean[numberOfQuestions];
		
		for (int i = 0; i < numberOfQuestions; i++)
		{
			results[i] = questions[i].checkAnswer();
		}
		
		return results;
	}
	
	public String getLessonTitle()
	{
		return "Grade K - Lesson 1";
	}
}
