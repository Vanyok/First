package com.kostiushko.search;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

public class SearcherTest {

    private String testPath = "D:/java/";
    private String mask = "Cal*";

    @Test
    public void findTest() throws FileNotFoundException {

	ArrayList<File> expecteds = new ArrayList<>();
	expecteds
		.add(new File(
			"D:/java/.metadata/.plugins/org.eclipse.debug.core/.launches/calculator.launch"));
	expecteds.add(new File("D:/java/Calculator.rar"));
	expecteds.add(new File(
		"D:/java/test/bin/com/basic/kostiushko/Calculator.class"));
	expecteds.add(new File(
		"D:/java/test/bin/com/basic/kostiushko/Calculator.java"));

	Searcher testInstance = new Searcher();

	ArrayList<File> actuals = testInstance.find(testPath, mask);
	System.out.println(expecteds);
	System.out.println(actuals);
	System.out.println(actuals.containsAll(expecteds));
	assertTrue((actuals.containsAll(expecteds)));
    }
}
