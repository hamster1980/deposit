package com.hamster.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class PaymentCondition implements Persistable {

	private static final long serialVersionUID = 1L;

	private final Key key;
	private Key operationKey;
	private Amount fullAmount;
	
	public PaymentCondition() {
		this(EmptyKey.DEFAULT);
	}
	
	public PaymentCondition(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public Key getOperationKey() {
		return operationKey;
	}

	public void setOperationKey(Key operationKey) {
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
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PaymentCondition
                && ((PaymentCondition)obj).key.equals(key);
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
