package com.hamster.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class OperationParticipant implements Persistable {

	private static final long serialVersionUID = 1L;

	private final Key key;
	private Key personKey;
	private Key operationKey;
	private OperationRole role;

	public OperationParticipant() {
		this(EmptyKey.DEFAULT);
	}
	
	public OperationParticipant(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public Key getPersonKey() {
		return personKey;
	}

	public void setPersonKey(Key personKey) {
		this.personKey = personKey;
	}

	public Key getOperationKey() {
		return operationKey;
	}

	public void setOperationKey(Key operationKey) {
		this.operationKey = operationKey;
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
        			.add("personKey", personKey)
        			.add("operationKey", operationKey)
        			.add("role", role)
        				.toString();
    }

}
