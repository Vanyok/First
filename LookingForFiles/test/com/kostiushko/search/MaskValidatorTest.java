package com.kostiushko.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MaskValidatorTest {

    @Test
    public void isValidTest() {
	assertTrue(MaskValidator.isValid("file*_.com"));
	assertFalse(MaskValidator.isValid("fil^:e*_.com"));
    }

    @Test
    public void isNameValidTest() {
	assertTrue(MaskValidator.isNameValid("file*.com", "filefinder.com"));
	assertFalse(MaskValidator.isNameValid("file_.com", "filefinder.com"));
	assertTrue(MaskValidator.isNameValid("file_.com", "filer.com"));
	assertFalse(MaskValidator.isNameValid("file*.com", "filinder.com"));
    }
}
