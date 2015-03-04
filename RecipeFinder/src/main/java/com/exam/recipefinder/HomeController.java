package com.exam.recipefinder;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.recipefinder.model.Input;
import com.exam.recipefinder.services.RecipeProcessor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/showrecipe", method = RequestMethod.POST)
	public String findrecipe(@ModelAttribute("inputForm") Input input,	
            Model model) {
		
		logger.info("CSV: " + input.getFridgeFilePath() + "; JSON: " + input.getRecipeFilePath() );
		String result = RecipeProcessor.findRecipe(input.getFridgeFilePath(), input.getRecipeFilePath());
		
		model.addAttribute("result",result);
		return "showrecipe";
	}
}
