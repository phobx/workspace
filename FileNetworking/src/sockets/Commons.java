package sockets;

public class Commons {
	public static final int SERVER_PORT = 7777;

	public static final String EXIT_COMMAND = "exit";
	public static final String LIST_COMMAND = "ls";
	public static final String REMOVE_COMMAND = "rm ";
	public static final String DOWNLOAD_COMMAND = "get ";
	public static final String HELP_COMMAND = "help";

	public static final String FILE_DIR = "server";
	public static final String DOWNLOAD_DIR = "downloads";

	public static final String HELP_NOTES = "List of commands:" + "\n exit \t\t shut down server;"
			+ "\n help \t\t show all commands;" + "\n ls \t\t list all files;" + "\n get <filename>  download chosen file;"
			+ "\n rm <filename> \t remove chosen file from list.";

}
