package subtractionModule;

import tenjinMath.Question;

public class SubtractionQuestion extends tenjinMath.Question
{
	private int[] possibleAnswers;
	private int[] operands;
	private char[] operators;
	
	public SubtractionQuestion(int[] operands, char[] operators, int[] possibleAnswers)
	{
		this.operands = operands;
		this.operators = operators;
		this.possibleAnswers = possibleAnswers;
		
		int numberOfOperands = operands.length;
		
		super.shortQuestion = "" + operands[0];
		super.longQuestion = "\t" + operands[0] + "\n";
		
		for (int i = 1; i < numberOfOperands; i++)
		{
			super.shortQuestion += " " + operators[i - 1] + " " + operands[i];
			super.longQuestion += operators[i - 1] + "\t" + operands[i] + "\n";
		}
		
		super.shortQuestion += " = ";
		super.longQuestion += "--------\n";
	}
	
	@Override
	public boolean checkAnswer()
	{
		int studentAnswerInteger;
		try
		{
			studentAnswerInteger = Integer.parseInt(studentAnswer);
		} catch (NumberFormatException e)
		{
			return false;
		}
		
		for (int i = 0; i < possibleAnswers.length; i++ )
		{
			if (studentAnswerInteger == possibleAnswers[i])
			{
				return true; 
			}
		}
		
		return false;
	}
/*
	@Override
	protected boolean checkAnswerFormat(String studentAnswer)
	{
		try
		{
			Integer.parseInt(studentAnswer);
		} catch ()
		
		// TODO Auto-generated method stub
		return false;
	}*/

}
