package com.example.servingwebcontent.controller;

import java.util.List;
import java.util.Optional;

import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.servingwebcontent.entity.CountryEntity;
import com.example.servingwebcontent.entity.Customer;
import com.example.servingwebcontent.form.CountryForm;
import com.example.servingwebcontent.form.CountrySearchForm;
import com.example.servingwebcontent.form.CustomerForm;
import com.example.servingwebcontent.repository.CountryEntityMapper;
import com.google.gson.Gson;

@Controller
public class CountryController2 {

	@Autowired
	private CountryEntityMapper mapper;


	
	@GetMapping("/countryList")
	public String list(Model model) {
		String names = "kunis";
		List<CountryEntity> kuni = mapper.select(SelectDSLCompleter.allRows());
		
		model.addAttribute(names, kuni);
		return "countryList";
	}
	
	
	
	@GetMapping("/countryList2")
	public String add(CountryForm countryForm) {
		//model.addAttribute("user", new CustomerForm());
		return "countryList2";
	}
	
	@PostMapping("/addCountry")
	@ResponseBody
	public String addCustomer(@Validated CountryForm countryForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
            return "countryList2";
        }

		CountryEntity countryEntity = new CountryEntity();
		BeanUtils.copyProperties(countryForm, countryEntity);
		mapper.insert(countryEntity);
		
		countryForm.setMstcountrycd("");
		countryForm.setMstcountrynanme("");
		
		
		return "添加成功";
	}


}
