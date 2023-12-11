package Exceptions;

public class ClientConnectionException extends Exception
{

	private static final long serialVersionUID = 1L;

	public ClientConnectionException(String msg)
	{
		super(msg);
	}
}
