package com.yunbok.nextstep;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {

    StringCalculator stringCalc;

    @Before
    public void setup(){
        this.stringCalc = new StringCalculator();
    }

    @Test
    public void add() {
        int result = stringCalc.add(stringCalc.customSplit("//;\n1;2;3"));

        assertEquals(6,result);

    }


}
