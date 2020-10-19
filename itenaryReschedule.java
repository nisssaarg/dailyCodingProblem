/*
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
 * and a starting airport, compute the person's itinerary. If no such itinerary exists, return null
 * If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', 
 * you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', 
 * you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. 
 * However, the first one is lexicographically smaller.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class itenaryReschedule {
	public static void main(String[] args) {
		String[][] tickets= {{"JFK","ABC"},{"ABC","CDE"},{"CDE","JFK"}};
		List<String> r=findItinerary(tickets);
		for(String s:r) {
			System.out.println(s);
		}
	}
	
	static HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	static LinkedList<String> result = new LinkedList<String>();
 
	public static List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket[0], q);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
 
		dfs("JFK");
		return result;
	}
 
	public static void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}
}
