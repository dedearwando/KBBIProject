import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class kamus {
	static tree tr = new tree();
	String line = "";
	ArrayList<Data> ar = new ArrayList<Data>();

	public kamus() {
		Random r = new Random();
		Data data;
		String fileName = "C:/Users/Dede/Desktop/Tubes - KBBI/kbbi.dict.csv";
		try {
			File f = new File(fileName);
			FileReader file = new FileReader(f);
			BufferedReader bc = new BufferedReader(file);
			while ((line = bc.readLine()) != null) {
				String tmp[] = line.split("\t");
				tmp[1] = tmp[1].replace("[pb]", "").replace("<br>", "");
				data = new Data();
				data.kata = tmp[0].trim().toLowerCase();
				data.makna = tmp[1];
				ar.add(data);
			}
			bc.close();
		} catch (IOException e) {
			System.out.println("Error opening file !! ");
			System.exit(0);
		}
		while (!ar.isEmpty()) {
			int rand = new Random().nextInt(ar.size());
			tr.insert(ar.remove(rand));
		}

	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		kamus kamus = new kamus();
		System.out.println(" ===========================================");
		System.out.println(" KAMUS BESAR BAHASA INDONESIA (KBBI)");
		System.out.println(" ===========================================");
		String pilih = "y";
		while (pilih.equalsIgnoreCase("y")) {
			System.out.print(" masukkan kata yang ingin dicari : ");
			String key = sc.nextLine();
			System.out.println("---------------------------------------");
			tr.search(key);
			System.out.print("Find Again ? y/n : ");
			pilih = sc.nextLine();
		}

	}
}
