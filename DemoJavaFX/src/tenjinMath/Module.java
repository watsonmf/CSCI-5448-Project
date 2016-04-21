package tenjinMath;

public interface Module 
{	
	public static Module getInstance(User currentUser) { return null;}
	public abstract Lesson getLesson();
	public abstract String getSavedData();
	public abstract void loadSavedData(String savedData);
	public abstract void updateProgress(Lesson currentLesson);
}
