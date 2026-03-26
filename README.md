Console Store App JAVA
UML Design and Flowcharts:
	

How I included threading(Client Side):
The following code snippet shows how I implemented the server side of the project in a thread class that actively updates the inventory or returns the current inventory of the store back to the seperate admin app.

while((inputLine = in.readLine()) != null)
		{
			// check length of input line
			if(inputLine.length() == 1)
			{
				// if command is 'r'
				if(inputLine.equals("r"))
				{
					// show that response is received
					// create current array list
					String json = om.writeValueAsString(im.getInventory().toArray(Saleable[]::new));
					// pass back to client
					out.println(json);
				}
				else if (inputLine.equals("q"))
				{
					break;
				}
				else 
					out.println("Invalid command. Please retry.");
					
			}
			else if (inputLine.length() > 1)	// input needs to be parsed
			{
				// parse string
				String[] tokens = inputLine.split("\\|");
					
				// if first part of tokens is u
				if(tokens[0].equals("u"))
				{
					// set second part to json string
					String json = tokens[1];
					// parse json side of inputLIne
					Saleable addItem = om.readValue(json, Saleable.class);
					// re do add item
					im.addNewItem(addItem);
					// echo that it worked
					out.println("Update Successful.");
				}
				
			}
				Thread.sleep(1000);
		}
		cleanup();
	} 
How I implemented threading(Server Side):
Once making a command to the server, the client responds accordingly after recieving a return message that is detirmined by the previous code snippet. This snippet also utilizes Custom Exceptions which are necessary when working on larger projects such as this one.

private String sendMessage(String msg) throws ServerCommunicationException 
{
	// print passed in message to server
    out.println(msg);
    
    // check for issue with server connection
    try 
    {
    	// return message from server
		return in.readLine();
	} 
    catch (IOException e) 
    {
    	// throw server error if there is an issue with communication
		throw new ServerCommunicationException("ERROR: Issue communicating with the server");
	}
}
