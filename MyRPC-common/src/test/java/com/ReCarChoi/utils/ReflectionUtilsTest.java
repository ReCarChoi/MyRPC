package com.ReCarChoi.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @ Author     ：ReCarChoi.
 * @ Date       ：Created in 15:40 2022/1/21
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ReflectionUtilsTest {

  @Test
  public void newInstance() {
    Object clazz = ReflectionUtils.newInstance(TestClass.class);
    assertNotNull(clazz);
  }

  @Test
  public void getPublicMethods() {
    Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
    assertEquals(1, methods.length);
    System.out.println(methods[0].getName());
  }

  @Test
  public void invoke() {
    Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
    Method b = methods[0];
    TestClass testClass = new TestClass();
    assertEquals("b", testClass.b());
  }

}
