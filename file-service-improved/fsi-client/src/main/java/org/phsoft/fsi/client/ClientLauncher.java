package org.phsoft.fsi.client;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientLauncher {

	private static Map<String, AbstractCommand> COMMANDS = new HashMap<>();

	static {
		COMMANDS.put("ls", new LsCommand());
		COMMANDS.put("список", new LsCommand());
		COMMANDS.put("quit", new QuitCommand());
		COMMANDS.put("exit", new QuitCommand());
		COMMANDS.put("get", new GetCommand());
	}

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("?>");
			String cmd = scanner.nextLine();
			String[] cmdParts = cmd.trim().split(" ");
			if (cmdParts.length > 0) {
				AbstractCommand command = COMMANDS.get(cmdParts[0]);
				if (command == null) {
					System.out.println("Command «" + cmdParts[0] + "» not found");
					System.out.println("Available commands:");
					for (String cmdName : COMMANDS.keySet()) {
						System.out.println("  " + cmdName + " - " + COMMANDS.get(cmdName).getHelp());
					}
				} else {
					try {
						command.runCommand(cmdParts);
					} catch (Exception ex) {
						System.out.println("There was error: " + ex.getMessage() + ". Please try again later...");
						ex.printStackTrace(System.out);
					}
					if (command instanceof TerminateAfterExecution) {
						break;
					}
				}
			}
		}
	}
}
