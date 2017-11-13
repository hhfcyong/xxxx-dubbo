package threadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxxx.thread.ThreadRunnable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class ThreadRunnableTest extends AbstractJUnit4SpringContextTests{
  
	@Autowired
	ThreadRunnable threadRunnable;
	
	@Test
	public void test() throws InterruptedException{
		CountDownLatch latch=new CountDownLatch(10);
		for(int i=0;i<11;i++){	
		threadRunnable.executeThread("走在大数据的边缘",latch);
		}
		latch.await();
		System.out.println("执行完毕了吗！");
	}
}
