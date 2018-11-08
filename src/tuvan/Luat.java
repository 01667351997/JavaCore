
package tuvan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Minh
 */
public class Luat {

    private String[] condition;

    public String[] getCondition() {
        return condition;
    }

    public void setCondition(String[] v) {
        this.condition = v;
    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String v) {
        this.result = v;
    }

    // this is constructor
    public Luat() {
        this.condition = null;
        this.result = "";
    }
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
