package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

@Entity
@Table(name="PERSON")
public class Person implements Persistable<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private final long key;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="SECOND_NAME")
	private String secondName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Transient
	private Type mainContactType;
	
	public Person() {
		this(0);
	}
	
	public Person(long key) {
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
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person
                && Objects.equal(((Person)obj).key, key);
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
