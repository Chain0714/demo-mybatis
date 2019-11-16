package org.chain.demo.demomybatis.aspect;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renchen
 * @date 2019-11-16 16:20
 **/
@RestControllerAdvice
public class ControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));

        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("timestamp", System.currentTimeMillis());
    }

    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

}
