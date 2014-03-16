package com.hamster.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

@Embeddable
public class PaymentCondition implements Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	@Transient
	private final Integer key;
	@Transient
	private Integer operationKey;
	@Embedded
	private Amount fullAmount;
	
	public PaymentCondition() {
		this(null);
	}
	
	public PaymentCondition(Integer key) {
		this.key = key;
	}

	@Override
	public Integer getId() {
		return key;
	}

	@Override
	public boolean isNew() {
		return key == null;
	}

	public Integer getOperationKey() {
		return operationKey;
	}

	public void setOperationKey(Integer operationKey) {
		this.operationKey = operationKey;
	}

	public Amount getFullAmount() {
		return fullAmount;
	}

	public void setFullAmount(Amount fullAmount) {
		this.fullAmount = fullAmount;
	}

	@Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PaymentCondition
                && Objects.equal(((PaymentCondition)obj).key, key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("operation", operationKey)
        			.add("fullAmount", fullAmount)
        				.toString();
    }

}
