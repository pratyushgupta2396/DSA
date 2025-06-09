import java.util.*;

public class Main {
	
	static boolean checkSolution(int sol[][]){
	    int[] x = new int[64];
	    int[] y = new int[64];
	    for(int i=0;i<64;i++){
	        x[i] = -1;
	        y[i] = -1;
	    }
	    for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++){
			    x[sol[i][j]] = i;
			    y[sol[i][j]] = j;
			}
		}
		
		for(int i=1;i<=63;i++){
		    if(x[i] == -1 || y[i] == -1){
		        return false;
		    }
		    int xDist = Math.abs(x[i]-x[i-1]);
		    int yDist = Math.abs(y[i]-y[i-1]);
		    if((xDist == 1 && yDist == 2) || (xDist == 2 || yDist == 1)){
		        continue;
		    }
		    else{
		        return false;
		    }
		}
		return true;
	}
	public static boolean printKnightsTour(int[][] findPath,int r,int c,int m){
		if(r<0 || c<0 || r>=findPath.length || c>= findPath.length || findPath[r][c]!=-1){
			return false;
		}

		findPath[r][c]=m;
		if(m==findPath.length*findPath.length-1){
			return true;
		}
		if (printKnightsTour(findPath, r - 2, c + 1, m + 1)) return true;
        if (printKnightsTour(findPath, r - 1, c + 2, m + 1)) return true;
        if (printKnightsTour(findPath, r + 1, c + 2, m + 1)) return true;
        if (printKnightsTour(findPath, r + 2, c + 1, m + 1)) return true;
        if (printKnightsTour(findPath, r + 2, c - 1, m + 1)) return true;
        if (printKnightsTour(findPath, r + 1, c - 2, m + 1)) return true;
        if (printKnightsTour(findPath, r - 1, c - 2, m + 1)) return true;
        if (printKnightsTour(findPath, r - 2, c - 1, m + 1)) return true;

		findPath[r][c]=-1;
		return false;
	}

	static int[][] findPath()
	{
		// write code here
		int [][] find = new int [8][8];
		for(int i =0;i<8;i++){
			for(int j =0;j<8;j++){
				find[i][j]= -1;
			}
		}

		if(printKnightsTour(find,0,0,0)){
			return find;
		}
		else {
			return new int [find.length][find.length];
		}
	}
	
    public static void main(String[] args) {
        int[][] ans = findPath();
        if(checkSolution(ans)){
            System.out.print("1");
        }
        else{
            System.out.print("0");
        }
    }
}
