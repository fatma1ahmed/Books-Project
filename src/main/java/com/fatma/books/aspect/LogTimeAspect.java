//package com.fatma.books.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//
//@Aspect
//@Component
//public class LogTimeAspect {
//    Logger logger= LoggerFactory.getLogger(LogTimeAspect.class);
//    @Around(value = "execution(* com.fatma.books.service..*(..))")
//    public void LogTime(JoinPoint joinPoint){
//        long startTime=System.currentTimeMillis();
//        StringBuilder sb=new StringBuilder("KPI: ");
//        sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getArgs());
////                .append("\twithArg: ").append("(").append(StringUtils.join(joinPoint.getArgs(),",")).append(")");
//           sb.append("\ttook: ");
//logger.info(sb.append(System.currentTimeMillis()-startTime).append("ms").toString());
//    }
//}
