/**
 * 
 */
package stolr.graphstream.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.algorithm.measure.Modularity;
import org.graphstream.graph.Edge;
import org.graphstream.stream.GraphParseException;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.graphicGraph.GraphPosLengthUtils;
import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants.Units;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.swingViewer.Viewer;

/**
 * @author hackman
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	private static Graph graph;
	private static Viewer viewer;
	private static LinLog layout;

	private static ProxyPipe fromViewer;


	
	public static void main(String[] args) {
	
		
		

		// definir les variables 
		String fichier = "data/facebook_simple.bosviel";
		String fichierMutual ="data/facebook_mutual.bosviel";
		UserFacebook userGraph = new UserFacebook("100000214299365", "Thomas Bosviel","1");
		
		// Creer  Une liste d'utilisateur facebook
		
		ArrayList<UserFacebook> listUser = new ArrayList<UserFacebook>();
		listUser = ParserFileSimple.getUserList(fichier); 
		
		
		userGraph.setFriends(listUser);
		ParserFileMutual.getUserMutual(userGraph,fichierMutual);
	
			
		//new .run();
		
	    //treadAffichage.run();
		
		Runnable affThread = new AffichageThread(userGraph,graph);
		affThread.run();
	
	System.out.println("lollollol");
		int cRumeur = 12;
		
		//Rumeur r = new Rumeur(NomRumeur,cRumeur);
	
	
	
	}
	
	
	
}
		
	
	


