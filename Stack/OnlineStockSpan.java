/*Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
*/
class StockSpanner {

    Stack<int[]> st;
    int day;
    public StockSpanner() {
        st = new Stack<>();
        day = 0;
        
    }
    
    public int next(int price) {
        while(st.size() > 0 && price >= st.peek()[1]){
            st.pop();
        }
        int span = -1;
        if(st.size() == 0){
            span = day - (-1);
        }else{
            span = day - st.peek()[0];
        }
        int [] arr = {day, price};
        st.push(arr);
        day++;
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
