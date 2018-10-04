import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.helico.entities.Mesure;
import com.helico.entities.Seance;
import com.helico.entities.Variante;
import com.helico.files.RecurseFolder;
import com.helico.files.tabs.ReadTabFile;


public class Test_recurse {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        File[] pdfFiles = RecurseFolder.filesFromFolder("C:\\Users\\AELION\\Documents", "txt");
       
        // Boucle sur les fichiers lus...
        for (int i=0; i < pdfFiles.length; i++) {
        	
        	// A ce stade, on doit créer une séance
        	Seance seance = new Seance();
        	// On doit découper le nom du fichier et son chemin pour :

        	// Récupérer la variante
        	Variante variante = new Variante();
        	int varianteId = variante.selectBySerial("123456");
        	
        	//	- Déterminer la date
        	seance.setDate("2018-10-03 15:48");
        	seance.setCode(pdfFiles[i].getName());
        	seance.setVariante_id(varianteId);
        	
        	seance.add(); // Insère la donnée dans la base de données
        	
        	int seanceId = seance.getId(); // Identifiant de la séance créée
        	
        	ReadTabFile fileContent = new ReadTabFile(pdfFiles[i]);
        	ArrayList<String[]> datas = fileContent.getDatas();
        	Iterator<String[]> it = datas.iterator();
        	String typeData = "";
        	
        	while(it.hasNext()) {
        		String[] readDatas = it.next();
        		Mesure mesure = new Mesure();
        		mesure.setT0(Float.parseFloat(readDatas[0]));
        		mesure.setNg(Float.parseFloat(readDatas[1]));
        		mesure.setPw(Float.parseFloat(readDatas[2]));
        		mesure.setSeance_id(seanceId);
        		
        		mesure.add();
        		
        		// Pour contrôle
        		for(int j=0; j < readDatas.length; j++) {
        			switch(j) {
        			case 0:
        				typeData = "T0";
        			break;
        			
        			case 1:
        				typeData = "Ng";
        			break;
        			
        			case 2:
        				typeData = "PW";
        			break;
        			}
        			System.out.println(typeData + "[" + pdfFiles[i].getName() + "] : " + readDatas[j]);
        			
        		}
        	}
        	System.out.println("********************************************");
        }
        
        JOptionPane.showMessageDialog(null,pdfFiles);
        
        System.exit(0);
        
	}

}
