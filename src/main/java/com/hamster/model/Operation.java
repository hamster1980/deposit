package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.google.common.base.Objects;

@Entity
@Table(name="OPERATION")
public class Operation implements Stateable<Long>, Typeable<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private final long key;
	@Column(name="CREATION_DATE")
	@org.hibernate.annotations.Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime creationDate;
	@Embedded
	private PaymentCondition paymentCondition;
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_ID")
	private OperationStateEnum state;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE_ID")
	private OperationTypeEnum type;

	public Operation() {
		this(0);
	}

	public Operation(long key) {
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


	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
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
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Operation
                && Objects.equal(((Operation)obj).key, key);
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
