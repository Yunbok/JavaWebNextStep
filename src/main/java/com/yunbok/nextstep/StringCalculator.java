package com.yunbok.nextstep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 요구사항
 * 문자열 계산기의 요구사항은 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환해야한다.
 * 1. 쉼표 (,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
 * 2. 앞의 기본 구분자 외에 커스텀 구분자를 지정할수있다. "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 *      예를들어 "//;\n1;2;3" 과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;) 이며 결과 값은 6이 반환되어야한다.
 * 3. 문자열 계산기에 음수를 전달하는 경우 RuntimeException 으로 예외 처리해야 한다.
 */
public class StringCalculator {

/*
    //리팩토링 전 코드
    public int add(String[] stringArr) {
        int result = 0;

        for ( String intText : stringArr ) {
            result += Integer.parseInt(intText);
        }
        return result;
    }

    public String[] customSplit(String calcText) {
        String customSeparator = "";
        String[] tempArr = calcText.split("\n");
        String[] resultArr;


        if ( tempArr.length == 1) {
            resultArr = tempArr[0].split(":|,");

        } else {
            customSeparator = tempArr[0].substring(2,tempArr[0].length());
            resultArr = tempArr[1].split(customSeparator);

        }

        return resultArr;
    }
*/

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    private int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if ( number < 0 ) {
            throw new RuntimeException();
        }
        return number;
    }

}
