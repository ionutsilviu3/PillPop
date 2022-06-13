package application;

public class EntityManagerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityManagerException(String errorMessage)
	{
		super(errorMessage);
	}
}

