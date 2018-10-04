/**
 * 
 */
package com.helico.files.tabs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jean-
 *
 */
public class ReadTabFile {
	private File file;
	private static String _SEPARATOR = "\\t";
	private ArrayList<String[]> datas;
	private String[] normalHeaders = {"T0","Ng","PW"};
	
	public ReadTabFile(File tabFile) {
		this.file = tabFile;
		
		this.process();
	}
	
	public ArrayList<String[]> getDatas() {
		return this.datas;
	}
	
	private void process() {
		List<String> lines = this.readFile();
		
		if (lines != null) {
	        this.datas = new ArrayList<String[]>(lines.size());
	        
	        int lineIndex = 0;
	        String[] headers = new String[3];
	        
	        for (String line : lines) {
	        	if (lineIndex > 0) {
	        		String[] oneData = this.shuffle(line.split(_SEPARATOR), headers);
	        		this.datas.add(oneData);
	        	} else {
	        		// Première ligne : en-têtes des colonnes
	        		headers = line.split(_SEPARATOR);
	        	}
	        	lineIndex++;
	        }
		}
	}
	
	private List<String> readFile() {
        List<String> result = new ArrayList<String>();

        FileReader fr;
        
		try {
			fr = new FileReader(this.file);
	        BufferedReader br = new BufferedReader(fr);

	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	            result.add(line);
	        }

	        br.close();
	        fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return result;		
	}
	
	private String[] shuffle(String[] data, String[] headers) {
		String[] shuffledDatas = new String[data.length]; // Définit le tableau final à retourner
		
		for (int i = 0; i < headers.length; i++) { // Boucle sur les en-têtes du fichier lu
			int indice = this.findIndex(headers[i]);
			if (indice != -1) {
				shuffledDatas[indice] = data[i];
			}
		}
		
		return shuffledDatas;
	}
	
	private int findIndex(String header) {
		for(int i = 0; i < this.normalHeaders.length; i++) {
			if (header.equals(this.normalHeaders[i])) {
				return i;
			}
		}
		return -1;
	}
}
