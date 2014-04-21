package org.zhubao.util;
import java.util.Calendar;  
  
import org.quartz.Job;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class TestJob implements Job {  
  
    @SuppressWarnings("deprecation")  
    public void execute(JobExecutionContext arg0) throws JobExecutionException {  
        System.out.println(Calendar.getInstance().getTime().toLocaleString()+ "★★★★★★★★★★★");  
    }  
  
}  