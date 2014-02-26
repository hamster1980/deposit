package com.hamster.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Person implements Persistable {

	private static final long serialVersionUID = 1L;

	private final Key key;
	private String firstName;
	private String secondName;
	private String lastName;
	private Type mainContactType;
	
	public Person() {
		this(EmptyKey.DEFAULT);
	}
	
	public Person(Key key) {
		this.key = Preconditions.checkNotNull(key);
	}

	@Override
	public Key getKey() {
		return key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Type getMainContactType() {
		return mainContactType;
	}

	public void setMainContactType(Type mainContactType) {
		this.mainContactType = mainContactType;
	}

	@Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person
                && ((Person)obj).key.equals(key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("firstName", firstName)
        			.add("secondName", secondName)
        			.add("lastName", lastName)
        			.add("mainContactType", mainContactType)
        				.toString();
    }

}
