package Acmicpc.GOLD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        ArrayList<ArrayList<String>> maps = new ArrayList<>();
        for(int i=0; i < T; i++) {
        	String[] row = bf.readLine().split(" ");
        	ArrayList<String> rowList = new ArrayList<>();
        	
        	for(String st : row) {
        		rowList.add(st);
        	}
        	maps.add(rowList);
        	
        }
        
        for(ArrayList<String> mp : maps) {
	        for(String ch : mp)
	        	System.out.printf(ch+" ");
	        System.out.println();
        }
        
        // --------- ��������� �Է�
        
        
        
    }
}
