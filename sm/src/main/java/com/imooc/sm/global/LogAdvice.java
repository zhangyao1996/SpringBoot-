package com.imooc.sm.global;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 3:15:20 PM
*/


import com.imooc.sm.entity.Log;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;
    @AfterReturning("execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.SelfController.*(..)) && !execution(* com.imooc.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOpration(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }
    @AfterThrowing(throwing ="e",pointcut ="execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOpration(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }
    @After("execution(* com.imooc.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }
    @Before("execution(* com.imooc.sm.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }
    private void log(JoinPoint joinPoint){
        Log log = new Log();
        //获取类名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        //获取方法名
        log.setOpration(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }
        logService.addLoginLog(log);
    }
}

