package CustomExceptions;

public class InventoryTranslationException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InventoryTranslationException(String error)
	{
		super(error);
	}
}
