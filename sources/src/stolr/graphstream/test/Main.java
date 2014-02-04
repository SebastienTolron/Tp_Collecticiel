/**
 * 
 */
package stolr.graphstream.test;

import java.io.IOException;
import java.util.ArrayList;

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
	private static double a = 0;
	private static double r = -1.3;
	private static double force = 3;
	private static ProxyPipe fromViewer;
	protected static String styleSheet ="edge.edgeRumeur { fill-color: rgba(255,0,0,1.0); }" ; 
	private static double cutThreshold = 1;	
	
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
	
		
		graph = new SingleGraph("Graphe de test");
		viewer = graph.display(false);		// 1
		graph = GraphFacebook.getGraph(userGraph,userGraph.getFriends());	
		
		graph.addAttribute("ui.antialias");			
		graph.addAttribute("ui.stylesheet", styleSheet);
		layout = new LinLog(false);		// 2
		layout.addSink(graph);			
		graph.addSink(layout);	
		fromViewer = viewer.newThreadProxyOnGraphicGraph();	// 1
		fromViewer.addSink(graph);		
		layout.configure(a, r, true, force);	

		
		// Creation d'un nouveau Thread pour la propagation d'une rumeur
		
		ColorationThread tr1 = new ColorationThread();
		tr1.run(graph,userGraph);
		
		// thread qui colorie le graph.
		
		while(! graph.hasAttribute("ui.viewClosed")) {
			fromViewer.pump();
			layout.compute();
			showCommunities();
		
		}
		
		
				
	
		
	}
	
	public static void showCommunities() {					
		int nEdges = graph.getEdgeCount();
		double averageDist = 0;
		double edgesDist[] = new double[nEdges];
		
		for(int i=0; i<nEdges; i++) {					
			Edge edge = graph.getEdge(i);
			edgesDist[i] = GraphPosLengthUtils.edgeLength(edge);	
			averageDist += edgesDist[i];				
		}
		
		averageDist /= nEdges;						
		for(int i=0; i<nEdges; i++) {					
			Edge edge = graph.getEdge(i);
			
			if(edgesDist[i] > averageDist * cutThreshold) {		
				edge.addAttribute("ui.class", "cut");		
				edge.addAttribute("cut");
			} else {
				edge.removeAttribute("ui.class");		
				edge.removeAttribute("cut");				
			}
		}
	}
	
	
	
}
		
	
	


