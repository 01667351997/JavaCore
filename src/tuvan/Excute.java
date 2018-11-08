package tuvan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 *  @author Minh
 */
public class Excute extends ModulSuyDien {

    private ArrayList setDynamicSuppose = new ArrayList();

    public Excute() throws IOException {
        System.out.println("\nBat dau qua trinh phan tich....");
    }

    public void initTapDich() {
        // BUOC 1: KHOI TAO T=F
        //setDynamicSuppose = new ArrayList();

        // copy cac phan tu tu tap gia thiet vao tapsukiendongT
        for (int i = 0; i < tapgiathiet.length; i++) {
            setDynamicSuppose.add(tapgiathiet[i]);
        }
    }

    public ArrayList<String> excuteBackTract(int count) {

        ArrayList<String> ketqua = new ArrayList<>();
        int mutex = 0;
        boolean flag = false;

        while (mutex < rule.length) {
            // neu luat da duoc dung thi khong dung lai
            if (!"1".equals(rule[mutex].getCondition())) {
                ArrayList tempVT = new ArrayList();
                tempVT.addAll(Arrays.asList(rule[mutex].getCondition()));

                ArrayList tempVP = new ArrayList();
                tempVP.addAll(Arrays.asList(rule[mutex].getResult()));

                // neu ve phai cua luat m nam trong gia thiet thi khong xet lai
                if (!Sosanh(tempVP, setDynamicSuppose)) {
                    // thuc hien neu vetrai nam hoan toan trong gia thiet
                    if (Sosanh(tempVT, setDynamicSuppose)) {
                        //=====================================================================
                        // Neu co nhieu ket luan giong nhau
                        // ====================================================================
                        int number = 0, numberSameConclusion = 0;
                        int x = mutex;
                        mutex = -1;
                        int[] sameConclusion = new int[rule.length];

                        while (number < rule.length) {
                            if (!"1".equals(rule[number].getCondition())) {
                                ArrayList small = new ArrayList();
                                small.addAll(Arrays.asList(rule[number].getCondition()));
                                if (Sosanh(small, setDynamicSuppose)) {
                                    sameConclusion[numberSameConclusion] = number;
                                    numberSameConclusion++;
                                }
                            }
                            number++;
                        }
                        if (numberSameConclusion > 1) {
                            //========================================================================
                            // CHOISE FOLLOW RANKING

                            int imax = 0;
                            int numberRank = 0;
                            int[] ranks = new int[sameConclusion.length];
                            for (int i = 0; i < numberSameConclusion; i++) {
                                if (rule[sameConclusion[i]].getRank() > imax) {
                                    imax = rule[sameConclusion[i]].getRank();
                                    x = sameConclusion[i];
                                    numberRank = 0;
                                    ranks[numberRank] = sameConclusion[i];
                                } else {
                                    numberRank++;
                                    ranks[numberRank] = sameConclusion[i];
                                }
                            }

                            //==========================================================================
                            //=========================================================================
                            //LONGEST MATCHING STRATEGY
                            if (numberRank > 1) {
                                int max = 0;
                                for (int i = 0; i < numberRank; i++) {
                                    ArrayList small = new ArrayList();
                                    small.addAll(Arrays.asList(rule[ranks[i]].getCondition()));
                                    if (Ranking.longestMatching(small, setDynamicSuppose) > max) {
                                        max = Ranking.longestMatching(small, setDynamicSuppose);
                                        x = ranks[i];
                                    }
                                }
                            }
                            //=========================================================================

                            //=========================================================================
                            //==========================================================================
                        }

                        setDynamicSuppose.add(rule[x].getResult()); // them Ket luan vao KB
                        rule[x].setCondition(new String[]{"1"}); //Neu luat nao tu KB hien tai da du suy ra thi khong xet lai
                        flag = true; // Danh dau da mo rong duoc KB
                        // in thong tin tap su kien
                        for (int j = 0; j < setDynamicSuppose.size(); j++) {
                            System.out.print(setDynamicSuppose.get(j) + ",");
                        }
                        System.out.println("  So Sanh " + "R[" + (x + 1) + "] = true");
                        // Neu tapsukiendongT = null -> canchungminh = null
                        // else tim xem canchungminh co trong tap su kien khong
                        for (int i = 0; i < setDynamicSuppose.size(); i++) {
                            if (setDynamicSuppose.get(i).toString() != null) {
                                for (int j = 0; j < tapketluan.length; j++) {
                                    if (setDynamicSuppose.get(i).toString().equals(tapketluan[j])) {
                                        ketqua.add(tapketluan[j]);
                                        if (ketqua.size() >= 3) {
                                            System.out.println(" Ket thuc suy dien !");
                                            return ketqua;
                                        }
                                        tapketluan[j] = null;
                                    }
                                }

                            }
                        } // End for
                    }
                }
            }
            mutex++;
            if (mutex == rule.length) {
                if (flag == false) {
                    System.out.println(" Khong co them bat ki ket luan nao ! ");
                    return ketqua;
                }
                //neu KB duoc mo rong thi xet lai cac luat
                mutex = 0;
                flag = false;
            }
        } // End while
        return null;
    }// End excute()

}
