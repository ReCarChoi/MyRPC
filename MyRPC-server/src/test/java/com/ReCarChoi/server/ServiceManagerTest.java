package com.ReCarChoi.server;

import com.ReCarChoi.protocol.Request;
import com.ReCarChoi.protocol.ServiceDescriptor;
import com.ReCarChoi.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * @ Author     ：ReCarChoi.
 * @ Date       ：Created in 10:45 2022/1/22
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

public class ServiceManagerTest {

      ServiceManager serviceManager;

      @Before
      public void init(){
          serviceManager = new ServiceManager();
          TestInterface bean = new TestClass();
          serviceManager.register(TestInterface.class, bean);
      }
      @Test
      public void register() {
          TestInterface bean = new TestClass();
          serviceManager.register(TestInterface.class, bean);
      }

      @Test
      public void lookup() {
          Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
          ServiceDescriptor descriptor = ServiceDescriptor.from(TestInterface.class, method);
          Request request = new Request();
          request.setServiceDescriptor(descriptor);
          ServiceInstance serviceInstance = serviceManager.lookup(request);
          assertNotNull(serviceInstance);
      }
}
