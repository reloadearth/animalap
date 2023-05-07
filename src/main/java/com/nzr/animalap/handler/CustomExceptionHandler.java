package com.nzr.animalap.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public String exceptionHandler(Model model, HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常!原因是:"+e);
        model.addAttribute("result",ResultResponse.error(ExceptionEnum.NOT_FOUND));
        return "error/404";
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model,HttpServletRequest req, Exception e){
        log.error("发生未知异常!原因是:"+e);
        model.addAttribute("result",ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR));
        return "error/500";
    }
}
