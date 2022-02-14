package com.yunbok.nextstep;


import jdk.tools.jlink.internal.plugins.ExcludePlugin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {

    StringCalculator stringCalc;

    @Before
    public void setup(){
        this.stringCalc = new StringCalculator();
    }

    /*
    @Test
    public void add() {
        int result = stringCalc.add(stringCalc.customSplit("//;\n1;2;3"));

        assertEquals(6,result);

    }
    */



    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, stringCalc.add(null));
        assertEquals(0, stringCalc.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertEquals(1,stringCalc.add("1"));
    }

    @Test
    public void add_쉼표구분자() throws Exception{
        assertEquals(3,stringCalc.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertEquals(6, stringCalc.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertEquals(6, stringCalc.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        stringCalc.add("-1,2,3");
    }
}
