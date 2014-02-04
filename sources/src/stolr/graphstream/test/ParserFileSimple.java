/**
 * 
 */
package stolr.graphstream.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author hackman
 *
 */
public class ParserFileSimple {
	
	

	public static ArrayList<UserFacebook> getUserList(String fichier) {
		
		ArrayList<UserFacebook> listUSer = new ArrayList<UserFacebook>();

		//lecture du fichier Texte
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if ( ligne.contains("name"))
				{
					int pIndexN = ligne.indexOf(":");
					int lIndexN = ligne.lastIndexOf("\"");
					String name = ligne.substring(pIndexN+3, lIndexN);
					
					ligne=br.readLine();
					int pIndexI = ligne.indexOf(":");
					int lIndexI = ligne.lastIndexOf("\"");
					String id= ligne.substring(pIndexI+3, lIndexI);
					
					ligne=br.readLine();
					int pIndexC = ligne.indexOf(":");
					int lIndexC = ligne.lastIndexOf("\"");
					String confiance= ligne.substring(pIndexC+3, lIndexC);
					
					listUSer.add(new UserFacebook(id, name,confiance));
					
				}
					
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	
	
	
	return listUSer;
	}

}


