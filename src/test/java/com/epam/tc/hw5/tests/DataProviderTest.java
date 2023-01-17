package com.epam.tc.hw5.tests;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider
    public static Object[][] textIconsCorrectData() {
        return new Object[][]{
                {"To include good practices"
                        + "\nand ideas from successful\nEPAM project"},
                {"To be flexible and"
                        + "\ncustomizable"},
                {"To be multiplatform"},
                {"Already have good base\n(about 20 internal and\n"
                        + "some external projects),\nwish to get more…"}
        };
    }

    @DataProvider
    public static Object[][] browserTitleCorrectData() {
        return new Object[][]{
                {"Home Page"}
        };
    }

    @DataProvider
    public static Object[][] userNameCorrectData() {
        return new Object[][]{
                {"ROMAN IOVLEV"}
        };
    }

    @DataProvider
    public static Object[][] userNameIncorrectData() {
        return new Object[][]{
                {"XXXX"}
        };
    }
}
