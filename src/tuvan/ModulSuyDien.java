/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tuvan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.invoke.VolatileCallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Binh Minh
 */
public class ModulSuyDien {

    /**
     * @param contructor
     * @throws IOException
     */
    protected String[] tapgiathiet;

    public String[] getTapgiathiet() {
        return tapgiathiet;
    }

    protected String[] tapketluan;

    public String[] getTapketluan() {
        return tapketluan;
    }

    protected Luat[] rule;

    public Luat[] getRule() {
        return rule;
    }

    private ArrayList arr;

    public ModulSuyDien() throws IOException {
        // ArrayList la mot mang dong
        arr = NapLuat("rule.txt");
        // tra ve phan tu tai index da cho, tuc la tra ve dong dau tien nhu tren file
        String giathiet = arr.get(0).toString().trim();

        // Mang tap gia thiet F
        // Phan chia xau bang dau "," Ex: "m,inh"->"m","inh"
        this.tapgiathiet = giathiet.split(",");

        String[] vetrai = getVeTrai(arr);
        // Mang tap ve trai
        // Them tung phan tu tu mang ve trai ve tap ve trai
        ArrayList tapvetrai = new ArrayList();
        for (int i = 0; i < vetrai.length; i++) {
            tapvetrai.add(vetrai[i].split(","));
        }

        // Mang tap ve phai
        String[] vephai = getVePhai(arr);
        ArrayList tapvephai = new ArrayList();
        ArrayList taphang = new ArrayList();
        for (int i = 0; i < vephai.length; i++) {
            for (int j = 0; j < vephai[i].length(); j++) {
                if (vephai[i].charAt(j) == '/') {
                    String ketqua = vephai[i].substring(0, j);
                    String hang = vephai[i].substring(j + 1, vephai[i].length());
                    // tap cac ket luan
                    tapvephai.add(ketqua);
                    // tap cac hang cua luat
                    taphang.add(hang);
                }
            }

        }
        // Su kien can chung minh
        String ketluan = (String) arr.get(1);
        this.tapketluan = ketluan.split(",");

        /*
		 * tru 2 do bo di 2 dong dau??
         */
        this.rule = new Luat[arr.size() - 2];
        for (int i = 0; i < arr.size() - 2; i++) {
            rule[i] = new Luat();
            rule[i].setCondition((String[]) tapvetrai.get(i));
            rule[i].setResult((String) tapvephai.get(i));
            rule[i].setRank(Integer.parseInt((String) taphang.get(i)));
        }
    }

    /**
     * So sanh neu smallSet nam hoan toan trong bigSet thi tra ve 1
     *
     * @param bigSet: giathiet
     * @param smallSet: vetrai, vephai cua luat
     * @return true or false
     */
    public void displayInfor() {
        // In thong tin ra man hinh
        System.out.print("Tap gia thiet F = ");
        for (int i = 0; i < tapgiathiet.length; i++) {
            System.out.print(tapgiathiet[i] + " ");
        }
        System.out.println("\nTap cac luat la: ");
        for (int i = 0; i < arr.size() - 2; i++) {
            System.out.print("R[" + (i + 1) + "]: ");
            for (int j = 0; j < rule[i].getCondition().length; j++) {
                System.out.print(rule[i].getCondition()[j] + " ");
            }
            System.out.println(" ->" + rule[i].getResult());
        }
        System.out.print("Tap cac ket luan can dat den: ");
        for (int i = 0; i < tapketluan.length; i++) {
            System.out.print(tapketluan[i] + " ");
        }

    }

    public boolean Sosanh(ArrayList<String> smallSet, ArrayList<String> bigSet) {
        int temp = 0, dem = smallSet.size();
        int t = 0;
        while (temp < smallSet.size()) {
            for (int i = 0; i < bigSet.size(); i++) {
                String s = smallSet.get(temp);
                if (s == null ? bigSet.get(i) == null : s.equals(bigSet.get(i))) {
                    smallSet.set(temp, "");
                }
            }
            temp++;
        }
        for (int i = 0; i < dem; i++) {
            if ("".equals(smallSet.get(i))) {
                t++;
            }
        }
        if (t == smallSet.size()) {
            return true;
        }

        return false;
    }

    public ArrayList NapLuat(String filename) throws IOException {
        // Doc tung dong va nap vao danh sach
        ArrayList lines = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                // khong con dong nao nua

                if (line == null) {
                    reader.close();
                    break;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException loi) {
            System.out.println("Gap phai loi: " + loi);
        }
        return lines;
    }

    /*
	 * @param thuc hien suy dien
     */
    public static void napGiaThiet(String fileName, String giathiet) {
        try {
            RandomAccessFile output = new RandomAccessFile(fileName, "rw");
            output.seek(0);
            output.writeBytes(giathiet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String[] getVeTrai(ArrayList lines) {
        String[] vt = new String[lines.size() - 2];
        for (int i = 2; i < lines.size(); i++) {
            String line = (String) lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == ' ') {
                    // tra ve xau tu 0 den j
                    String vt1 = line.substring(0, j);
                    vt[i - 2] = vt1;
                }
            }
        }
        return vt;

    }

    public String[] getVePhai(ArrayList lines) {
        String[] vp = new String[lines.size() - 2];
        for (int i = 2; i < lines.size(); i++) {
            String line = (String) lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == ' ') {
                    String vp1 = line.substring(j + 1, line.length());
                    vp[i - 2] = vp1;
                }
            }
        }
        return vp;

    }
}
