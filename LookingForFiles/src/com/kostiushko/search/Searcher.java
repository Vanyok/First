package com.kostiushko.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Searcher {

    public ArrayList<File> find(String path, String mask)
	    throws FileNotFoundException {

	ArrayList<File> result = new ArrayList<>();
	File file = new File(path);
	if (!file.isDirectory()) {
	    throw (new FileNotFoundException("it is not directory!"));
	}

	if (!MaskValidator.isValid(mask)) {
	    throw (new RuntimeException("bad mask"));
	}

	File[] fileList = file.listFiles();
	for (File f : fileList) {
	    if (f.isFile()) {
		if (MaskValidator.isNameValid(mask, f.getName())) {

		    result.add(f);
		    System.out.println(f.getName());
		}
	    }
	    if (f.isDirectory()) {
		ArrayList<File> temp = find(f.getAbsolutePath(), mask);
		result.addAll(temp);
	    }
	}
	return result;

    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter file path :");
	String path = sc.nextLine();
	System.out.println("enter file name or mask :");
	String mask = sc.nextLine();
	Searcher searcher = new Searcher();
	try {
	    searcher.find(path, mask);
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	sc.close();
    }

}
