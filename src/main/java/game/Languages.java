package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.HashMap;

public class Languages {

	public static String[] getAvailableLanguages() {
		File folder = new File("languages");
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".csv"); // Filters for .csv files
			}
		};
		File[] listOfFiles = folder.listFiles(filter);
		String[] fileNames = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++) {
			String name = listOfFiles[i].getName();
			fileNames[i] = name.substring(0, name.length() - 4); // Remove the .csv extension
		}
		return fileNames;
	}

	public static HashMap<String, String> getLanguage(String language) {
		try {
			return parse("languages/" + language + ".csv");
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public static HashMap<String, String> parse(String fileName) throws FileNotFoundException {
		HashMap<String, String> map = new HashMap<>();
		String data;
		String[] dataParsed;

		File lang = new File(fileName);
		Scanner sc = new Scanner(lang, "UTF-8");
		while (sc.hasNextLine()) {
			data = sc.nextLine();
			dataParsed = data.split(",", 2);
			if (dataParsed[1].length() > 0 && dataParsed[1].charAt(0) == '"') {
				dataParsed[1] = dataParsed[1].substring(1, dataParsed[1].length() - 1);
			}
			map.put(dataParsed[0], dataParsed[1]);
		}
		sc.close();

		return map;
	}

}
