/*
1 fire the first rule in sequence
2 Assign rule priorities (by importance)
3 More specific rule are preferred over general rule (longest matching)
4 Prefer rule whose premises are added more recently (time stamping)
5 Parallel strategy (create view points)
*/
package tuvan;

import java.util.ArrayList;

/**
 *
 * @author binhminh
 */
public class Ranking {
    public static int longestMatching(ArrayList<String> smallSet, ArrayList<String> bigSet) {
        int sum = 0;
        for (int i = 0; i < smallSet.size(); i++) {
            for (int j = 0; j < bigSet.size(); j++) {
                if(smallSet.get(i).equals(bigSet.get(j))){
                    sum++;
                }
            }
        }
        if(sum==smallSet.size()){
            return sum;
        }
        return 0;
    }
}
