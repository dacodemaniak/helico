package com.helico.files;

import java.io.File;
import java.util.TreeSet;

public class RecurseFolder {

	public static File[] filesFromFolder(String folder, String extension) {
		
		File path = new File(folder);
		
		if (!path.exists() || !path.isDirectory()) {
			throw new IllegalArgumentException(path + " inconnu ou supprimé.");
		}
		
		TreeSet<File> sortedFiles = new TreeSet<File>();
		
		filesFromFolder(sortedFiles, path, extension);
		File[] files = new File[sortedFiles.size()];
		sortedFiles.toArray(files);
		
		return files;
	}
	
	private static void filesFromFolder(TreeSet<File> files, File path, String extension) {
		
		File[] pathes = path.listFiles();
		
		if (pathes != null ) {
			for (int i = 0;i<pathes.length;i++) {
				if (pathes[i].isDirectory()) {
					filesFromFolder(files, pathes[i], extension);
				}
				else {
					if (pathes[i].getName().endsWith(extension)) {
						files.add(pathes[i]);
					}
				}
			}
		}
	}
	
}
