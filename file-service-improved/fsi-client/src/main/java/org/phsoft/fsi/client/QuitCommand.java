package org.phsoft.fsi.client;


public class QuitCommand extends AbstractCommand implements
		TerminateAfterExecution {

	@Override
	public void runCommand(String[] cmd) throws Exception {
		System.out.println("Goodbye!");
	}

	@Override
	public String getHelp() {
		return "Exits client";
	}

}
