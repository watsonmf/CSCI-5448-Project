package tenjinMath;

public interface Module 
{
	public Lesson getLesson();
	public String getSavedData();
	public void loadSavedData(String savedData);
	public void updateProgress(Lesson currentLesson);
}
