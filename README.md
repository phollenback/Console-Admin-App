<h1 align="center">Console Store App JAVA</h1>

<h3>UML Design and Flowcharts:</h3>
<table>
  <th width="500">
    <img src="https://github.com/phollenback/Skills-Overview/assets/145724342/4166e6c7-8e61-4009-b100-56d050947b14">
  </th>
  <th width="500">
    <img src="https://github.com/phollenback/Skills-Overview/assets/145724342/44eadb88-0b8d-4a8e-8310-ce3d562ab585">
  </th>
</table>
<table>
  <th><img src="https://github.com/phollenback/Skills-Overview/assets/145724342/45b802ee-1dff-42bd-b452-981c7ede7a14"></th>
</table>
<h1 align="center">How I included threading(Client Side):</h1>
<p align="left">The following code snippet shows how I implemented the server side of the project in a thread class that actively updates the inventory or returns the current inventory of the store back to the seperate admin app.</p>
<table>

    
    
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

</table>
<h1 align="center">How I implemented threading(Server Side): </h1>
<p>Once making a command to the server, the client responds accordingly after recieving a return message that is detirmined by the previous code snippet. This snippet also utilizes Custom Exceptions which are necessary when working on larger projects such as this one.</p>
<table>



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
</table>
