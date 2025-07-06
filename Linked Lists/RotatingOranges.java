


class Solution {
    int [] [] dirr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int [][] grid) {
        LinkedList<int[]> q = new LinkedList<>();
        int fc =0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    int [] arr = {i ,j};
                    q.addLast(arr);
                }else if(grid[i][j] ==1){
                    fc++;
                }
            }
        }
        if(fc == 0){
            return 0;
        }
        int time = -1;
        while(q.size() != 0){
            int size = q.size();
            while(size-- != 0){
                int [] rem = q.removeFirst();
                int i = rem[0];
                int j = rem[1];
                for(int d = 0; d < dirr.length; d++){
                    int [] dir = dirr[d];
                    int nr = i + dir[0];
                    int nc = j + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        int [] arr = {nr, nc};
                        grid[nr][nc] = 2;
                        fc--;
                        q.addLast(arr);
                    }
                }
            }
            time++;
        }
        if(fc != 0){
            return -1;
        }

        return time;

    }
}
