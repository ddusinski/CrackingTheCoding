package com.dusinski;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.dusinski.chapter4.*;
import org.junit.Assert;
import org.junit.Test;

public class chapter4Test {
    @Test
    public void printTreeTest() {
        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);
        bt2.addValue(7);

        assertEquals("    4\n" +
                "   2|6\n" +
                "  1|3|5|7\n" +
                " -|-|-|-|-|-|-|7\n", bt2.printAll());
    }

    @Test
    public void isTreeBalancedTest() {
        BinaryTree bt2 = new BinaryTree();
        bt2.addValue(4);
        bt2.addValue(2);
        bt2.addValue(6);
        bt2.addValue(3);
        bt2.addValue(1);
        bt2.addValue(5);
        bt2.addValue(7);
        assertTrue(bt2.isTreeBalanced());
        bt2.addValue(7);
        assertTrue(bt2.isTreeBalanced());
        bt2.addValue(7);
        assertFalse(bt2.isTreeBalanced());
    }


}
