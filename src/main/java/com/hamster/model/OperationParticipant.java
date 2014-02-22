package com.hamster.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class OperationParticipant implements Entity {

	private static final long serialVersionUID = 1L;

	private final Key key;
	private Key person;
	private OperationRole role;

	public OperationParticipant() {
		this(new EmptyKey());
	}
	
	public OperationParticipant(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public Key getPerson() {
		return person;
	}

	public void setPerson(Key person) {
		this.person = person;
	}

	public OperationRole getRole() {
		return role;
	}

	public void setRole(OperationRole role) {
		this.role = role;
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
        			.add("role", role)
        				.toString();
    }

}
