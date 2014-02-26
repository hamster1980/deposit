package com.hamster.model;

import java.util.Date;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Operation implements Persistable {

	private static final long serialVersionUID = 1L;
	
	private final Key key;
	private Date creationDate;
	private PaymentCondition paymentCondition;
	private State state;
	private Type type;

	public Operation() {
		this(EmptyKey.DEFAULT);
	}

	public Operation(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public PaymentCondition getPaymentCondition() {
		return paymentCondition;
	}

	public void setPaymentCondition(PaymentCondition paymentCondition) {
		this.paymentCondition = paymentCondition;
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
        			.add("paymentCondition", paymentCondition)
        			.add("state", state)
        			.add("type", type)
        				.toString();
    }

}
