

public class mainMethod {
	
	public static void main(String arg[]){
		
		String problem = arg[0];
		String queryVariable = arg[1];
		
		BayesianNetwork network = new BayesianNetwork();
		
				Assignment assignment = new Assignment();
		
		if( problem.contains(".xml") ) {
			XMLBIFParser parser = new XMLBIFParser();
			try {
				network = parser.readNetworkFromFile(problem);
				for(int i=2; i < arg.length; i+=2) {
					String evidenceVariable = arg[i];
					String evidenceVariableValue = arg[i+1];
					assignment.set(network.getVariableByName(evidenceVariable), evidenceVariableValue);
				}
				//distribution code here
			}
			catch (IOException exception){
				exception.printStackTrace();
			}
			catch (ParserConfigurationException exception){
				exception.printStackTrace();
			}
			catch (SAXException exception) {
				exception.printStackTrace();
			}
		} 
		else {
			BIFParser parser = new BIFParser(new FileInputStream(problem));
			try {
				network = parser.parseNetwork();
				for(int i=2; i < arg.length; i+=2) {
					String evidenceVariable = arg[i];
					String evidenceVariableValue = arg[i+1];
					assignment.set(network.getVariableByName(evidenceVariable), evidenceVariableValue);
				}
				//distribution code here
			}
			catch (IOException exception) {
				exception.printStackTrace()
			}
			catch (FileNotFoundException exception) {
				exception.printStackTrace();
			}
		}	
    
	}
  
}
