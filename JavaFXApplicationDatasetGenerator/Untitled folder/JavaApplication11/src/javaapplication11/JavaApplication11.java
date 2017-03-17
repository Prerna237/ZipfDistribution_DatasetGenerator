/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pranjal Mathur
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
List<Integer> list = new ArrayList<Integer>();
while (scanner.hasNextInt()){
  list.add(scanner.nextInt());
}
list.toArray();

System.out.print(list.get(3));
    }
    
}
