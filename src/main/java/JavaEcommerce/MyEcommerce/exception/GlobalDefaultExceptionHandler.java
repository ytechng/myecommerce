package JavaEcommerce.MyEcommerce.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Page Not Found!");
		mv.addObject("errorMessage", "The page you are requesting is not found!");
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product Not Found!");
		mv.addObject("errorMessage", "The product you are looking for is not found!");
		mv.addObject("title", "Product Unavailable ");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact the Administrator!");
		
		/** for debugging */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);
		
		mv.addObject("errorMessage", e.toString());
		mv.addObject("title", "Error");
		
		return mv;
	}
}
