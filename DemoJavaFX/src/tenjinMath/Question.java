package tenjinMath;

public abstract class Question
{
	protected String shortQuestion;
	protected String longQuestion;
	protected String helpQuestion;
	
	protected String studentAnswer;

	public abstract boolean checkAnswer();
	
	public void storeAnswer(String studentAnswer)
	{
		this.studentAnswer = studentAnswer;
	}

	/**
	 * @return the shortQuestion
	 */
	public String getShortQuestion()
	{
		return shortQuestion;
	}

	/**
	 * @param shortQuestion the shortQuestion to set
	 */
	public void setShortQuestion(String shortQuestion)
	{
		this.shortQuestion = shortQuestion;
	}

	/**
	 * @return the longQuestion
	 */
	public String getLongQuestion()
	{
		return longQuestion;
	}

	/**
	 * @param longQuestion the longQuestion to set
	 */
	public void setLongQuestion(String longQuestion)
	{
		this.longQuestion = longQuestion;
	}
	
	/**
	 * @return the helpQuestion
	 */
	public String getHelpQuestion()
	{
		return helpQuestion;
	}

	/**
	 * @param helpQuestion the helpQuestion to set
	 */
	public void setHelpQuestion(String helpQuestion)
	{
		this.helpQuestion = helpQuestion;
	}
}
