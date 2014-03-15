package com.hamster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

@Entity
@Table(name="OPERATION")
public class Operation implements Persistable, Stateable, Typeable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private final StringKey key;
	@Transient
	private Date creationDate;
	@Transient
	private PaymentCondition paymentCondition;
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_ID")
	private OperationStateEnum state;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE_ID")
	private OperationTypeEnum type;

	public Operation() {
		this(StringKey.EMPTY_KEY);
	}

	public Operation(StringKey key) {
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

	@Override
	public State getState() {
		return state;
	}

	public void setState(OperationStateEnum state) {
		this.state = state;
	}

	@Override
	public Type getType() {
		return type;
	}

	public void setType(OperationTypeEnum type) {
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
