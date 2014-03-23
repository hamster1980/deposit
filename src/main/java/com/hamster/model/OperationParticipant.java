package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;
import com.hamster.Stateable;
import com.hamster.Typeable;

@Entity
@Table(name="OPERATION_PARTICIPANT")
public class OperationParticipant implements Stateable, Typeable, Persistable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue
	private final long key;
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	@ManyToOne
	@JoinColumn(name="OPERATION_ID")
	private Operation operation;
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_ID")
	private OperationParticipantStateEnum state;
	@Enumerated(EnumType.STRING)
	@Column(name="ROLE_ID")
	private OperationRoleEnum role;

	public OperationParticipant() {
		this(0);
	}
	
	public OperationParticipant(long key) {
		this.key = key;
	}

	@Override
	public Long getId() {
		return key;
	}

	@Override
	public boolean isNew() {
		return key == 0;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public State getState() {
		return state;
	}

	public void setState(OperationParticipantStateEnum state) {
		this.state = state;
	}

	public OperationRole getRole() {
		return role;
	}

	public void setRole(OperationRoleEnum role) {
		this.role = role;
	}

	@Override
	public Type getType() {
		return getRole();
	}

	@Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof OperationParticipant
                && Objects.equal(((OperationParticipant)obj).key, key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("person", person)
        			.add("operation", operation)
        			.add("role", role)
        			.add("state", state)
        				.toString();
    }

}
