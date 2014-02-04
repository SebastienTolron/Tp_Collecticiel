/**
 * 
 */
package stolr.graphstream.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author hackman
 *
 */
public class ParserFileMutual {

	/**
	 * @param args
	 */
	
      
      
      
	
	public static ArrayList<UserFacebook> getUserMutual(
			UserFacebook UserF,String nomFichier) {

		
		try{
			InputStream ips=new FileInputStream(nomFichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			String previousLine = null ;
			while ((ligne=br.readLine())!=null){
				
				
				if ( ligne.contains("\"mutualfriends\""))
				{					
					int pIndexI = previousLine.indexOf(":");
					int lIndexI = previousLine.lastIndexOf("\"");
					String id =  previousLine.substring(pIndexI+3, lIndexI);
					while(!((ligne=br.readLine()).contains("next")))
					{
						if ( ligne.contains("name"))
						{
							int pIndexN = ligne.indexOf(":");
							int lIndexN = ligne.lastIndexOf("\"");							
							String name = ligne.substring(pIndexN+3, lIndexN);
							
							//System.out.println(name);
							
							ligne=br.readLine();
							int pIndexI2 = ligne.indexOf(":");
							int lIndexI2 = ligne.lastIndexOf("\"");
							String idNew= ligne.substring(pIndexI2+3, lIndexI2);
							
							//System.out.println(idNew);
							// AU fait , il faut qu'on lie la liste d'ami avec le user							
							UserFacebook uGeneral = UserF.getById(id);
							UserFacebook uEnCommun = UserF.getById(idNew);
							
												
							uGeneral.getMutualFriends().add(uEnCommun);
							
						
						}
						
					}
			
				}
				
				previousLine = ligne;
					
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	
		return null;
	}

}
