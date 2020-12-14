package com.app.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.constants.AppConstants;
import com.app.entity.Contact;
import com.app.props.AppProperties;
import com.app.service.ContactService;

@Controller
public class ContactController {

	private static final Logger logger=LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private AppProperties appProps;

	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		logger.debug("loadForm() method execution started");
		model.addAttribute("contact", new Contact());
		logger.debug("loadForm() method execution completed");
		logger.info("loadForm() method executed successfully");
		return AppConstants.INDEX_VIEW;
	}

	@PostMapping("/saveContact")
	public String handleSaveContactBtn(Contact contact, RedirectAttributes attributes) {
		logger.debug("saveConttact() execution started");
		Map<String, String> messages = appProps.getMessages();
		String msgTxt=null;
		if(contact.getContactId()==null) {
			msgTxt=messages.get(AppConstants.SAVE_SUCCESS);
		}
		else {
			msgTxt=messages.get(AppConstants.UPDATE_SUCCESS);
		}

		boolean isSaved = contactService.saveContact(contact);
		if(isSaved) {
			logger.info("Contact saved successfully");
			attributes.addFlashAttribute(AppConstants.SAVE_SUCCESS,msgTxt);
		}else {
			logger.info("Contact saved failed");
			attributes.addFlashAttribute(AppConstants.ERROR_MSG, messages.get("saveFail"));
		}
		logger.debug("loadForm() method execution completed");
		return "redirect:contactCreationSuccess";
	}

	@GetMapping("/contactCreationSuccess")
	public String contactCreationSuccess(Model model) {
		logger.debug("contactCreationSuccess() execution started ");
		model.addAttribute(AppConstants.CONTACT, new Contact());
		return AppConstants.INDEX_VIEW;		   
	}

	@GetMapping("/viewContacts")
	public String handleViewContactsHyperlink(Model model) {
		logger.debug("viewContacts execution started ");
		List<Contact> contactsList = contactService.getAllContacts();
		if(contactsList.isEmpty()) {
			logger.info("Contacts Are not available in Database");
		}
		model.addAttribute(AppConstants.CONTACTS, contactsList);
		logger.debug("viewContacts execution ended ");
		return "viewContacts";
	}

	@GetMapping("/edit")
	public String handleEditClick(@RequestParam("cid") Integer cid, Model model) {
		logger.debug("Execution started Edit Click Hyperlink ");
		Contact contactObj = contactService.getContactById(cid);
		model.addAttribute(AppConstants.CONTACT, contactObj);
		logger.debug("Execution completed for Edit Click Hyperlink ");
		logger.info("Execution completed successfully for Edit Click Hyperlink ");
		return AppConstants.INDEX_VIEW;
	}

	@GetMapping("/delete")
	public String handleDeleteClick(@RequestParam("cid") Integer cid) {
		logger.debug(" execution started for deleting contacts");
		contactService.deleteContactById(cid);
		logger.debug(" execution completed for deleting contacts");
		logger.info("contacts deleted successfully");
		return "redirect:/viewContacts";
	}
}
