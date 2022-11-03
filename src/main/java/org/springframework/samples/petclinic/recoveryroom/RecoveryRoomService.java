package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository rt;
	
    public List<RecoveryRoom> getAll(){
        return rt.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return rt.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return rt.getRecoveryRoomType(typeName);
    }
    
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return this.rt.save(p);       
    }

    
}
