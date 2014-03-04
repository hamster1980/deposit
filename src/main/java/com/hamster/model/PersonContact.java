package com.hamster.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class PersonContact implements Persistable, Stateable, Typeable {

	private static final long serialVersionUID = 1L;

	private final Key key;
	private Key personKey;
	private Type type;
	private State state;
	private String value;
	private boolean main;
	
	public PersonContact() {
		this(EmptyKey.DEFAULT);
	}
	
	public PersonContact(Key key) {
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

	@Override
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	@Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PersonContact
                && ((PersonContact)obj).key.equals(key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("personKey", personKey)
        			.add("type", type)
        			.add("state", state)
        			.add("value", value)
        			.add("main", main)
        				.toString();
    }

}
