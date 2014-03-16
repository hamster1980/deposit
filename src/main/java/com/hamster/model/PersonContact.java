package com.hamster.model;

import com.google.common.base.Objects;

public class PersonContact implements Stateable<Integer>, Typeable<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer key;
	private Integer personKey;
	private Type type;
	private State state;
	private String value;
	private boolean main;
	
	public PersonContact() {
		this(null);
	}
	
	public PersonContact(Integer key) {
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

	public Integer getPersonKey() {
		return personKey;
	}

	public void setPersonKey(Integer personKey) {
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
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PersonContact
                && Objects.equal(((PersonContact)obj).key, key);
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
