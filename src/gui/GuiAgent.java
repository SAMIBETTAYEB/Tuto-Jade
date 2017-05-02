package gui;

import jade.core.AID;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

public class GuiAgent extends jade.gui.GuiAgent{

	Gui gui;
	
	@Override
	protected void setup() {
		gui=new Gui();
	}
	
	@Override
	protected void onGuiEvent(GuiEvent arg0) {
		if(arg0.getType()==1){
			ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
			msg.setContent("Test of send");
			msg.addReceiver(new AID("gui",AID.ISLOCALNAME));
			send(msg);
			gui.showMessage(null, "send: \n"+msg, true);
		}
	}

}
