package delete;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag extends Agent {
	@Override
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg=receive();
				if(msg!=null){
					if(msg.getContent().equals("delete"))
						doDelete();
				}else block();
			}
		});
	}
}
