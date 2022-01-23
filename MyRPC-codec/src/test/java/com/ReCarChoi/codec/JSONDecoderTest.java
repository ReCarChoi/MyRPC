package com.ReCarChoi.codec;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @ Author     ：ReCarChoi.
 * @ Date       ：Created in 16:41 2022/1/21
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

public class JSONDecoderTest {
      @Test
      public void decode() {
          JSONEncoder encoder = new JSONEncoder();
          TestBean bean = new TestBean();
          bean.setName("ReCarChoi");
          bean.setAge(20);
          byte[] bytes = encoder.encode(bean);
          assertNotNull(bytes);
          JSONDecoder decoder = new JSONDecoder();
          TestBean bean1 = decoder.decode(bytes, TestBean.class);
          assertEquals(bean.getName(), bean1.getName());
          assertEquals(bean.getAge(), bean1.getAge());
      }
}
