package com.adsandboards.web.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adsandboards.web.service.GenericService;

public abstract class GenericController<T, PK extends Serializable> {

	private GenericService<T, PK> genericService;

	public GenericController(GenericService<T, PK> genericService) {
		this.genericService = genericService;
	}

	protected abstract T getNewCommand();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewList() {
		List<T> list = genericService.getAll();
		return new ModelAndView(getListPageName(), getListCommandName(), list);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createModel(ModelMap model) {
		T t = getNewCommand();
		model.put("modelObject", t);
		setAdditionalModelsForForm(model);
		return getEditPageName();
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String addModel(@ModelAttribute("modelObject") T t,
			BindingResult bindingResult) {
		genericService.save(t);
		return "redirect:" + getRedirectName();
	}

	@RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
	public String editModel(@RequestParam("id") PK id, ModelMap model) {
		model.put("modelObject", genericService.get(id));
		setAdditionalModelsForForm(model);
		return getEditPageName();

	}

	protected void setAdditionalModelsForForm(ModelMap model) {
		//
	}

	protected abstract String getListPageName();

	protected abstract String getListCommandName();

	protected abstract String getEditPageName();

	protected abstract String getRedirectName();

}
