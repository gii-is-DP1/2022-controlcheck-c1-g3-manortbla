package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "RecoveryRoomType")
public class RecoveryRoomType extends BaseEntity{
	
	@NotNull
	@Size(min = 5, max = 50)
	String name;
}
