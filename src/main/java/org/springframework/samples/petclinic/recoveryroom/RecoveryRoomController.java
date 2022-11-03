package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	private static final String VIEWS_RECOVERYROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private RecoveryRoomService service;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService service) {
		// TODO Auto-generated constructor stub
        this.service = service;
	}
	
    @GetMapping(value="/recoveryroom/create")
    public String initCreationForm(ModelMap map) {
    	RecoveryRoom rr = new RecoveryRoom();
    	map.put("recoveryRoom", rr);
    	List<RecoveryRoomType> rt = service.getAllRecoveryRoomTypes();
    	map.put("recoveryRoomType", rt);
    	return VIEWS_RECOVERYROOM_CREATE_FORM;
    }
    
    @PostMapping(path = "/recoveryroom/create")
    public String createRecoveryRoom(@Valid RecoveryRoom r, BindingResult br, ModelMap map) {
    	if(br.hasErrors()) {
    		RecoveryRoom rr = new RecoveryRoom();
    		map.put("recoveryRoom", rr);
    		List<RecoveryRoomType> rt = service.getAllRecoveryRoomTypes();
        	map.put("recoveryRoomType", rt);
        	return VIEWS_RECOVERYROOM_CREATE_FORM;
    	}else {
    		try {
				service.save(r);
			} catch (DuplicatedRoomNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		map.addAttribute("message", "Product succcesfully save");
    	}
    	return "redirect:/welcome";
    }
	
	
    
}
