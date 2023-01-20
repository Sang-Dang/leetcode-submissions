import java.util.ArrayList;
import java.util.List;

public class P0070 {

    public int climbStairs(int n) {
        if(n==0){return 1;}
		if(n==1){return 1;}
		int fst=1, scd=1, ans = 0;
		for(int i=2; i<=n; i++){
			ans=fst+scd;
			fst=scd; scd=ans;
		}
		return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P0070().climbStairs(4));
    }
}
