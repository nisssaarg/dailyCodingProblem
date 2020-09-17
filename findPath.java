/*
  You are given an M by N matrix consisting of booleans that represents a board. 
  Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start.
If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
 since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

import java.util.LinkedList;
import java.util.Queue;

public class findPath {

	public static class unit{
		int x;
		int y;
		int dist;
		public unit(int x,int y,int dist) {
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
	}
	
	public static void main(String[] args) {
		boolean[][] board= {{false,false,false,false},
				{true,true,false,true},
				{false,false,false,false},
				{false,false,false,false} };
		
		System.out.println(pathInMaze(board,0,0,3,0));
	}
	
	public static boolean isValid(boolean[][] board,int M , int N, boolean[][] visited, int i,int j) {
		return (i<=0 || j<0 || i>=M || j>=N || !board[i][j] || visited[i][j]);
	}
	
	public static int pathInMaze(boolean[][] board,int sx,int sy,int dx,int dy) {
		int M=board.length;
		int N=M>0 ? board[0].length :0;
		
		boolean[][] visited=new boolean[M][N];
		
		Queue<unit> element=new LinkedList<>();
		
		if(isValid(board,M,N,visited,sx,sy)) {
			element.add(new unit(sx,sy,0));
			visited[sx][sy]=true;
		}
		
		while(!element.isEmpty()) {
			unit temp=element.poll();
			
			System.out.println("x:"+temp.x+"y:"+temp.y);
			
			if(temp.x==dx && temp.y==dy) {
				return temp.dist;
			}
			
			
			if(isValid(board,M,N,visited,temp.x+1,temp.y))
				element.add(new unit(temp.x+1,temp.y,temp.dist+1));
			
			if(isValid(board,M,N,visited,temp.x-1,temp.y))
				element.add(new unit(temp.x-1,temp.y,temp.dist+1));
			
			if(isValid(board,M,N,visited,temp.x,temp.y+1))
				element.add(new unit(temp.x,temp.y+1,temp.dist+1));
			
			if(isValid(board,M,N,visited,temp.x,temp.y-1))
				element.add(new unit(temp.x,temp.y-1,temp.dist+1));
		}

		return -1;
	}
	
}
