package com.neptune.tddDemo.maths;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatheratorTest {
    private Matherator math;

    @Before
    public void setUp() throws Exception{
        math=new Matherator();
    }
    @Test
    public void testSubstract(){
        long result=100-34-4-(-17);

        assertEquals(result,math.substract(100,34,4,-17));

    }
    @Test
    public void testAdd(){
        long result=10+23+(-1) + 16;

        //Compare the result given by the matherator
        assertEquals(result,math.add(10,23,-1,16));

        result=0;
        assertEquals(result,math.add(0));
    }
    @Test
    public void testMultiplication(){
        long result=5*5;

        assertEquals(result,math.multiply(5,5));

        result=5*78*98*98;

        assertEquals(result,math.multiply(5,78,98,98));

        result=0;

        assertEquals(result,math.multiply(0));
    }
}
