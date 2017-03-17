package javafxapplication5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author dell pc
 */
public class DatasetGenerator {

    public Random rnd = new Random(0);
    public static int size;
    public static int support;
    public static int setsize;
    public static double skew;
    public static int numOfTransactions;
    public double bottom = 0;
    public boolean automode;

    public DatasetGenerator(int size, double skew, int numOfTransactions, boolean flag) {
        this.size = size;
        this.skew = skew;
        this.numOfTransactions = numOfTransactions;
        this.automode = false;
        this.support = support;
        this.setsize = setsize;
        for (int i = 1; i <= size; i++) {
            this.bottom += (1 / Math.pow(i, this.skew));
        }
    }

    public DatasetGenerator(boolean flag) {
        this.automode = flag;
        size = 75;
        skew = 0.5;
        numOfTransactions = 10000;
        support = 800;
        setsize = 4;
        for (int i = 1; i <= size; i++) {
            this.bottom += (1 / Math.pow(i, this.skew));
        }
    }

    public double getProbability(int rank) {
        double val = (1.0d / Math.pow(rank, this.skew)) / this.bottom;;
        return val;
    }

    public void generate() throws IOException {
        FileWriter write = new FileWriter("dataset.txt");
        PrintWriter fw = new PrintWriter(write);


        ArrayList<Integer> array_of_items = new ArrayList<Integer>();
        int cumm_prob = 0;
        for (int i = 1; i <= size; i++) {
            //This returns me the probability of each item in my dataset
            cumm_prob += Math.round(this.getProbability(i) * 100);
            array_of_items.add(cumm_prob);
        }
        int itemsetsize = 0;
        int k, trans_item;
        boolean flag;

        //generates k-sized itemsets with k between 1 and 7
        Set<Integer> transaction = new HashSet<Integer>();

        for (int j = 0; j < numOfTransactions; j++) {
            itemsetsize = (int) ((Math.round(Math.random() * 100) % 7) + 1);
            k = 1;
            while (k <= itemsetsize) {
                trans_item = (int) Math.round(Math.random() * 100);
                for (int c = 0; c < size; c++) {
                    if ((array_of_items.get(c)) >= trans_item) {
                        flag = transaction.add(c + 1);
                        if (flag == true) {
                            k++;
                        }
                        break;
                    }
                }
            }
            Iterator it = transaction.iterator();
            while (it.hasNext()) {
                fw.print(it.next() + "");
                if (it.hasNext()) {
                    fw.print(",");
                }
            }
            transaction.clear();
            fw.println();
        }
        fw.close();       

    }
}
