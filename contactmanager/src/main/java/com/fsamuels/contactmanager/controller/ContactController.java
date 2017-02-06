/**
 * 
 */
package com.fsamuels.contactmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fsamuels.contactmanager.domain.Contact;
import com.fsamuels.contactmanager.service.ContactService;

/**
 * Controller for handling actions associated with Contact requests.
 * 
 * @author Forrest
 * 
 */
@Controller
@SessionAttributes
public class ContactController {
	
	/**
	 * String displayed on the Contact create/edit page indicating the action being taken.
	 */
	private static final String CONTACT_ACTION_DISPLAY 	= "contactActionDisplay";
	/**
	 * Form action for the Contact create/edit page.
	 */
	private static final String FORM_ACTION				= "formAction";
	
	@Autowired
	private ContactService contactService;
		
	/**
	 * Set the list of {@link Contact} objects to be displayed.
	 * @return
	 */
	@RequestMapping(value = { "/", "index" })
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("contacts", contactService.getContacts());			
		return mv;
	}
	
	/**
	 * Prepare the create page by creating a new {@link Contact} and setting up
	 * create page specific display and action text
	 * @return
	 */
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createPrepare() {
		ModelAndView mv = setupCreateModelAndView();
		mv.addObject("contact", new Contact());
	    return mv;
	}

	/**
	 * Create a new {@link Contact}
	 * @param contact
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createProcess(@Valid Contact contact, BindingResult result) {
		ModelAndView mv = setupCreateModelAndView();
		
		if(result.hasErrors()) {
			return handleCreateAndEditErrors(result, mv);
		}
		
		contactService.create(contact);
		
		return new ModelAndView("redirect:/");
	}

	/**
	 * Changes needed when there are errors for the create/edit page.
	 * @param result
	 * @param mv
	 * @return
	 */
	private ModelAndView handleCreateAndEditErrors(BindingResult result, ModelAndView mv) {
		mv.addObject("message", "There are errors in the information you provided.");
		mv.addObject("errors", result.getAllErrors());
		return mv;
	}

	/**
	 * Create a {@link ModelAndView} for the create page and do any required setup
	 * @return
	 */
	private ModelAndView setupCreateModelAndView() {
		ModelAndView mv = new ModelAndView("create");
		mv.addObject(CONTACT_ACTION_DISPLAY,	"Create");
		mv.addObject(FORM_ACTION, 			"create");
		return mv;
	}
	
	/**
	 * Prepare the edit page by accessing the specified contact and
	 * setting up edit page specific display and action text
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPrepare(@PathVariable Integer id) {
		ModelAndView mv = setupEditModelAndView();
		mv.addObject("contact",contactService.getContact(id.toString()));
	    return mv;
	}

	/**
	 * Edit the existing {@link Contact}
	 * @param contact
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView editProcess(@Valid Contact contact, BindingResult result) {
		ModelAndView mv = setupEditModelAndView();
		
		if(result.hasErrors()) {
			return handleCreateAndEditErrors(result, mv);
		}
		
		contactService.update(contact);
		
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * Create a {@link ModelAndView} for the edit page and do any required setup
	 * @return
	 */
	private ModelAndView setupEditModelAndView() {
		ModelAndView mv = new ModelAndView("create");
		mv.addObject(CONTACT_ACTION_DISPLAY,	"Edit");
		mv.addObject(FORM_ACTION, 			"edit");
		return mv;
	}
	
	/**
	 * Prepare the delete page by accessing the specified contact
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePrepare(@ModelAttribute Contact contact, @PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("delete");
	    mv.addObject("contact", contactService.getContact(id.toString()));
	    return mv;
	}

	/**
	 * Delete the existing {@link Contact}
	 * @param contact
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public ModelAndView deleteProcess(@ModelAttribute Contact contact, @PathVariable Integer id) {
		contactService.delete(id.toString());
		
		return new ModelAndView("redirect:/");
	}
	
}
