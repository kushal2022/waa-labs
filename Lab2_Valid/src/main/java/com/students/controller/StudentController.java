package com.students.controller;

import com.students.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class StudentController {
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)	
	    public String showForm(@ModelAttribute("student") Student student, Model model){

 	        return "registration";
	    }
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)	
	    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}

		// save student here
		model.addAttribute("student", student);
 
             return "success";
 
	
	    }
	    
	}

	

