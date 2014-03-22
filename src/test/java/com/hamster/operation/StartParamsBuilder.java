package com.hamster.operation;

import java.util.Currency;

import com.hamster.model.Amount;
import com.hamster.model.OperationRole;
import com.hamster.model.OperationRoleEnum;
import com.hamster.model.OperationTypeEnum;
import com.hamster.model.PaymentCondition;
import com.hamster.model.Type;

public class StartParamsBuilder {

	public static StartParamsBuilder create() {
		return new StartParamsBuilder();
	}
	
	private Type type = OperationTypeEnum.FLAT_RENTING;
	private long author = 1;
	private OperationRole role = OperationRoleEnum.MEDIATOR;
	private Amount amount = Amount.create("100.56", Currency.getInstance("RUB"));
	
	private StartParamsBuilder() {
	}

	public StartParamsBuilder type(Type type) {
		this.type = type;
		return this;
	}

	public StartParamsBuilder author(long author) {
		this.author = author;
		return this;
	}

	public StartParamsBuilder role(OperationRole role) {
		this.role = role;
		return this;
	}
	
	public StartParamsBuilder amount(Amount amount) {
		this.amount = amount;
		return this;
	}
	
	public StartParams build() {
		final PaymentCondition condition = new PaymentCondition();
		condition.setFullAmount(amount);
		return new StartParams() {
			@Override
			public Type getType() {
				return type;
			}
			@Override
			public long getAuthor() {
				return author;
			}
			@Override
			public OperationRole getAuthorRole() {
				return role;
			}
			@Override
			public PaymentCondition getPaymentCondition() {
				return condition;
			}
		};
	}
}
