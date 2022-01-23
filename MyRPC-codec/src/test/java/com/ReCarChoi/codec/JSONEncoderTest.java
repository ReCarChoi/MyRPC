package com.ReCarChoi.codec;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * @ Author     ：ReCarChoi.
 * @ Date       ：Created in 16:36 2022/1/21
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

public class JSONEncoderTest {
    @Test
    public void encode() {
      JSONEncoder encoder = new JSONEncoder();
      TestBean bean = new TestBean();
      bean.setName("ReCarChoi");
      bean.setAge(20);
      byte[] bytes = encoder.encode(bean);
      assertNotNull(bytes);
    }
}
