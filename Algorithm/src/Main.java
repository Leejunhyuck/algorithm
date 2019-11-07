import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
	
	static int[] dirx= { 0, 0,  -1, 1};
	static int[] diry= { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int[][] bridge;
	static int n,m,apart=0;
	static Queue<Node> q = new LinkedList<Node>() ;
	static ArrayList<Integer> list = new ArrayList<>();

public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			//m= Integer.parseInt(st.nextToken());
			m=n;
			
			
			
			
			
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(str.nextToken());
			}
			
		}
		int cnt =1;
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				if(map[i][j]==1&&!visited[i][j]) {
				bfs(i,j,cnt);
				cnt++;}
			}
			
		}
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0)
					q.add(new Node(i,j));
			}
			
		}
		bridge= new int[n][m];
		visited = new boolean[n][m];
		bfs2();

		
//		for(int i=0;i<n;i++) {
//			
//			for(int j=0;j<m;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		
		 int ans = Integer.MAX_VALUE;
	        for(int v : list) {
	            if(ans>v) {
	                ans = v;
	            }
	        }
	        
	        System.out.println(ans);


	
	
		
		
		
		bw.flush();
		br.close();
		bw.close();
	
	
		}





public static void bfs(int i,int j,int cnt) {
	
	Queue<Node> que = new LinkedList<Node>() ;
	
	map[i][j]=cnt;
	que.add(new Node(i,j));
	visited[i][j] =true;
	
	while(!que.isEmpty()) {
		
		Node node = que.poll();
		int row = node.row;
		int col = node.col;
		
		
		
		for(int k=0;k<4;k++) {
			int nr= row+dirx[k];
			int nc= col+diry[k];
			
			
		
			
			if(isBoundary(nr, nc)&&map[nr][nc]==1&&!visited[nr][nc]) {
				visited[nr][nc] =true;
				map[nr][nc]=cnt;
				que.add(new Node(nr,nc));
				
			}
		
		
		
	}
	}
}





public static void bfs2() {
	
	
	
	
	while(!q.isEmpty()) {
		
		
		Node node = q.poll();
		int row = node.row;
		int col = node.col;
		
		for(int k=0;k<4;k++) {
			int nr= row+dirx[k];
			int nc= col+diry[k];
			
			if(isBoundary(nr, nc)) {
			if(map[nr][nc]!=0 && map[nr][nc] != map[row][col]) {
				
				list.add(bridge[nr][nc]+bridge[row][col]);
			}
			
			
			if(map[nr][nc]==0) {
				
				q.add(new Node(nr,nc));
				map[nr][nc]=map[row][col];
				bridge[nr][nc]=bridge[row][col]+1;
				
				
				
			}}
			
		}
		
		
		
		
	}
	
	
	
}



	public static boolean isBoundary (int row, int col) {
		
		return (row>=0 && row<n)&&(col>=0 && col<m);
	}


}

class Node {
	
	int row;
	int col;
	int cnt;
	Node(int row,int col){
		
		this.row =row;
		this.col = col;
		
	}
	
}

//	
//	public static void bfs(int start) {
//		
//		Queue<Integer> que = new LinkedList<Integer>();
//		
//		que.add(start);
//		check[start]=true;
//		
//		while(!que.isEmpty()) {
//			int temp =que.poll();
//			
//			for (int y : list[temp]) {
//				if(!check[y]) {
//					check[y]=true;
//					que.add(y);
//				}
//			}
//		}
//		
//		
//	}	
//		
		
	



		


	

	

	


