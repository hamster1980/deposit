package com.hamster.model;

import java.util.Date;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hamster.utils.Dates;

public class Operation implements Entity {

	private static final long serialVersionUID = 1L;
	
	private final Key key;
	private Date creationDate;
	private Amount amount;
	private State state;
	private Type type;

	public Operation() {
		this(new EmptyKey());
	}

	public Operation(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Date getCreationDate() {
		return Dates.get(creationDate);
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = Dates.get(creationDate);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Operation
                && ((Operation)obj).key.equals(key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("creationDate", creationDate)
        			.add("amount", amount)
        			.add("state", state)
        			.add("type", type)
        				.toString();
    }

}
