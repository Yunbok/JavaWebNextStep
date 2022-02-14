package com.yunbok.nextstep;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    /*
        Calculator cal = new Calculator();
        // 위 문법처럼 사용하는것은 자바문법에 문제없지만
        // 테스트코드 작성시에는 필드에 초기화 하는 방식은 각 테스트를 실행할때마다 Calculator 인스턴스를 생성하는것과 같다.
    */
    Calculator cal;

    @Before
    public void setup() {
        //JUnit 에는 @RunWith , @Rule 같은 애노테이션을 사용해 기능확장이 가능한데
        //@Before 태그안에서만 @RunWith , @Rule 로 초기화된 객체에 접근이 가능하다는 제약사항이 있다.
        //그래서 @Before 에서 초기화 작업을 하는것이 추후 문제가 발생할 가능성을 없앨 수 있다.
        cal = new Calculator();
        System.out.println("Before");
    }

    @Test
    public void add() {
        assertEquals(7,cal.add(4,3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        assertEquals(10 , cal.subtract(11 ,1));
        System.out.println("subtract");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }
}
