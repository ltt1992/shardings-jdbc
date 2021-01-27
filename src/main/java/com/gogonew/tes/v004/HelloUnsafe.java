package com.gogonew.tes.v004;

import sun.misc.*;

import java.lang.reflect.Field;

//import sun.misc.Unsafe;

public class HelloUnsafe {
    static class M {
        private M() {}

        int i =0;
    }

    public static void main(String[] args) throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        /*Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
*/

        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}

