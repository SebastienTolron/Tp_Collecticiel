package stolr.graphstream.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.graphstream.graph.Node;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphFacebook {

	public static Graph getGraph(UserFacebook userC,
			ArrayList<UserFacebook> listUser) {

		Graph graph = new SingleGraph("Graphe de mes amis facebook");

		graph.addNode(userC.getId());
		graph.display();
		int i;
		for (i = 0; i < listUser.size(); i++) {
			Node temp = graph.addNode(listUser.get(i).getId());
			graph.addEdge(userC.getId() + "+" + listUser.get(i).getId(),
					userC.getId(), listUser.get(i).getId());
			temp.addAttribute("ui.label", listUser.get(i).getName());

		}

		for (i = 0; i < listUser.size(); i++) {
			int j = 0;

			ArrayList<UserFacebook> mutualF = listUser.get(i)
					.getMutualFriends();

			for (j = 0; j < listUser.get(i).getMutualFriends().size(); j++) {
				if (graph.getEdge(listUser.get(i).getMutualFriends().get(j)
						.getId()
						+ "+" + listUser.get(i).getId()) != null) {

				} else {

					Edge temp2 = graph.addEdge(
							listUser.get(i).getId()
									+ "+"
									+ listUser.get(i).getMutualFriends().get(j)
											.getId(), listUser.get(i).getId(),
							listUser.get(i).getMutualFriends().get(j).getId());

				}

			}

		}

		/*
		 * Edge temp2 =
		 * graph.addEdge("100003231949562+100003588916276","100003231949562",
		 * "100003588916276"); temp2.setAttribute("ui.color", 1);
		 */

		return graph;
	}

	
}