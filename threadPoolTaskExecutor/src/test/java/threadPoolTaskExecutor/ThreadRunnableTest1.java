package threadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxxx.thread.ThreadRunnable;
import com.xxxx.thread.ThreadRunnable1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class ThreadRunnableTest1 extends AbstractJUnit4SpringContextTests{
  
	@Autowired
	ThreadRunnable1 threadRunnable1;
	
	@Test
	public void test() throws InterruptedException{
		
		for(int i=0;i<11;i++){	
		threadRunnable1.executeThread("走在大数据的边缘");
		}
		
		System.out.println("执行完毕了吗！");
	}
}
