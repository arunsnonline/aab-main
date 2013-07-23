package com.adsandboards.web.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.model.DisplayGrid;
import com.adsandboards.web.service.GenericService;

/**
 * 
 * @author arun
 * 
 *         Controller for CRUD operations and listing of all Models.Pagination
 *         inputs are also taken here.
 * @param <T>
 * @param <PK>
 */
public abstract class GenericController<T, PK extends Serializable> {

	private GenericService<T, PK> genericService;

	public GenericController(GenericService<T, PK> genericService) {
		this.genericService = genericService;
	}

	protected abstract T getNewCommand();

	@RequestMapping(method = RequestMethod.GET)
	public String viewList() {
		return getListPageName();
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public DisplayGrid<T> login(
			@RequestParam(value = "iDisplayStart") int start,
			@RequestParam(value = "iDisplayLength") int length) {
		List<T> list = this.genericService.getAll(start, length);
		Long totalCount = this.genericService.getTotalCount();
		DisplayGrid<T> displayGrid = new DisplayGrid<T>(totalCount, totalCount,
				list);
		return displayGrid;
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
		// For setting additional models to form
	}

	protected abstract String getListPageName();

	protected abstract String getListCommandName();

	protected abstract String getEditPageName();

	protected abstract String getRedirectName();

}
