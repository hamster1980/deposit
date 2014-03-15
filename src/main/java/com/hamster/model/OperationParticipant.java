package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

@Entity
@Table(name="OPERATION_PARTICIPANT")
public class OperationParticipant implements Persistable, Stateable, Typeable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private final StringKey key;
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
		this(StringKey.EMPTY_KEY);
	}
	
	public OperationParticipant(StringKey key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
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
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof OperationParticipant
                && ((OperationParticipant)obj).key.equals(key);
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
