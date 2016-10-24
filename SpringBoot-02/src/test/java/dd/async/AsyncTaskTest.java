package dd.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Created by huaaijia on 2016/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsyncTaskTest {

    @Autowired
    private Task task;


    @Autowired
    private AsyncTask asyncTask;

    /**
     * 同步
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    /**
     * @throws Exception
     *
    开始做任务二
    开始做任务三
    开始做任务一
    完成任务三，耗时：3694毫秒
    现在时间：14:25:03
    完成任务二，耗时：6916毫秒
    完成任务一，耗时：8260毫秒
    任务全部完成，总耗时：9032毫秒
     */
    @Test
    public void asyncTest() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }
}