package stolr.graphstream.test;

import java.util.Iterator;
import java.util.Scanner;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.graphicGraph.GraphPosLengthUtils;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.swingViewer.Viewer;

class AffichageThread implements Runnable {

	Viewer viewer;
	LinLog layout;
	protected static String styleSheet = "edge.rum { fill-color:red;}";
	private static ProxyPipe fromViewer;
	double a = 0;
	double r = -1.3;
	double force = 3;
	double cutThreshold = 1;
	UserFacebook userGraph;
	Graph graph;
	boolean cpt;
	
	
	

	public AffichageThread(UserFacebook userGraph, Graph graph) {
		super();
		this.userGraph = userGraph;
		this.graph = graph;
		this.cpt = false;
	}




	public void run() {
		
		
		graph = new SingleGraph("Graphe de test");
		viewer = graph.display(false); // 1
		graph = GraphFacebook.getGraph(userGraph, userGraph.getFriends());

		graph.addAttribute("ui.antialias");
		graph.addAttribute("ui.stylesheet", styleSheet);
		layout = new LinLog(false); // 2
		layout.addSink(graph);
		graph.addSink(layout);
		fromViewer = viewer.newThreadProxyOnGraphicGraph(); // 1
		fromViewer.addSink(graph);

		layout.configure(a, r, true, force); // 3

		while (!graph.hasAttribute("ui.viewClosed")) {
			
			
			fromViewer.pump();
			layout.compute();

			int nEdges = graph.getEdgeCount();
			double averageDist = 0;
			double edgesDist[] = new double[nEdges];

			for (int i = 0; i < nEdges; i++) {
				Edge edge = graph.getEdge(i);
				edgesDist[i] = GraphPosLengthUtils.edgeLength(edge);
				averageDist += edgesDist[i];
			}

			averageDist /= nEdges;
			for (int i = 0; i < nEdges; i++) {
				Edge edge = graph.getEdge(i);

			}

			if ( cpt ==  false)
			{
			String tab ="";
			ColorationThread trc = new ColorationThread();
			trc.run(graph,graph.getNode(userGraph.getId()),tab);
			cpt = true;
			}
			
			
			
			//System.out.println("lolAffichageTh");
		}

	}
}
