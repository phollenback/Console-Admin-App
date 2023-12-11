package CustomExceptions;

public class ServerCommunicationException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ServerCommunicationException(String errorMessage)
	{
		super(errorMessage);
	}
}
