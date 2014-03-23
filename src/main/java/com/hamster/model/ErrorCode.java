package com.hamster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Persistable;

import com.google.common.base.Objects;

@Entity
@Table(name="ERROR_CODE")
public class ErrorCode implements Persistable<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private final long key;
	@Column(name="TYPE_ID")
	private final String type;
	@Column(name="DEFAULT_MESSAGE")
	private final String defaultMessage;
	
	public ErrorCode() {
		this(0, StringUtils.EMPTY, StringUtils.EMPTY);
	}
	
	public ErrorCode(long key, String type, String defaultMessage) {
		this.key = key;
		this.type = type;
		this.defaultMessage = defaultMessage;
	}

	@Override
	public Long getId() {
		return key;
	}

	@Override
	public boolean isNew() {
		return false;
	}

	public String getType() {
		return type;
	}

	public String getDefautMessage() {
		return defaultMessage;
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ErrorCode
                && Objects.equal(((ErrorCode)obj).key, key);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
        			.add("key", key)
        			.add("type", type)
        			.add("defaultMessage", defaultMessage)
        				.toString();
    }

}
