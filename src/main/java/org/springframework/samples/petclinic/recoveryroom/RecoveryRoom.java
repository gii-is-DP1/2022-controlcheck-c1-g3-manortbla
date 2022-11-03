package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecoveryRoom extends BaseEntity{
	@NotNull
	@Size(min = 3, max = 50)
	String name;
	@NotNull
	@PositiveOrZero
    double size;
	@NotNull
    boolean secure;
	@ManyToOne
	@NotEmpty
	@JoinColumn(name = "recovery_room_type_id")
	RecoveryRoomType recoveryRoomType;
    @Transient
    RecoveryRoomType roomType;
}
