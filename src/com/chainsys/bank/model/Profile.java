package com.chainsys.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profile {

	private String name;
	private long acnumber;
	private long id;
	private String email;
	private long phonenumber;
	private String fathersname;
	private String gender;
	private BigDecimal balance;
	private String username;
	private String password;
	private LocalDate dob;
	private String pmtaddress;
	private String pmtcity;
	private String cntaddress;
	private String cntcity;
	private String state;
	private String ifsc;
	private LocalDateTime cdate;
	private LocalDateTime mdate;
	private String mmid;

	
	public String getMmid() {
		return mmid;
	}

	public void setMmid(String mmid) {
		this.mmid = mmid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(long acnumber) {
		this.acnumber = acnumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFathersname() {
		return fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPmtaddress() {
		return pmtaddress;
	}

	public void setPmtaddress(String pmtaddress) {
		this.pmtaddress = pmtaddress;
	}

	public String getPmtcity() {
		return pmtcity;
	}

	public void setPmtcity(String pmtcity) {
		this.pmtcity = pmtcity;
	}

	public String getCntaddress() {
		return cntaddress;
	}

	public void setCntaddress(String cntaddress) {
		this.cntaddress = cntaddress;
	}

	public String getCntcity() {
		return cntcity;
	}

	public void setCntcity(String cntcity) {
		this.cntcity = cntcity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public LocalDateTime getCdate() {
		return cdate;
	}

	public void setCdate(LocalDateTime cdate) {
		this.cdate = cdate;
	}

	public LocalDateTime getMdate() {
		return mdate;
	}

	public void setMdate(LocalDateTime mdate) {
		this.mdate = mdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (acnumber ^ (acnumber >>> 32));
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((cdate == null) ? 0 : cdate.hashCode());
		result = prime * result + ((cntaddress == null) ? 0 : cntaddress.hashCode());
		result = prime * result + ((cntcity == null) ? 0 : cntcity.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fathersname == null) ? 0 : fathersname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ifsc == null) ? 0 : ifsc.hashCode());
		result = prime * result + ((mdate == null) ? 0 : mdate.hashCode());
		result = prime * result + ((mmid == null) ? 0 : mmid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phonenumber ^ (phonenumber >>> 32));
		result = prime * result + ((pmtaddress == null) ? 0 : pmtaddress.hashCode());
		result = prime * result + ((pmtcity == null) ? 0 : pmtcity.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (acnumber != other.acnumber)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (cdate == null) {
			if (other.cdate != null)
				return false;
		} else if (!cdate.equals(other.cdate))
			return false;
		if (cntaddress == null) {
			if (other.cntaddress != null)
				return false;
		} else if (!cntaddress.equals(other.cntaddress))
			return false;
		if (cntcity == null) {
			if (other.cntcity != null)
				return false;
		} else if (!cntcity.equals(other.cntcity))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fathersname == null) {
			if (other.fathersname != null)
				return false;
		} else if (!fathersname.equals(other.fathersname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (ifsc == null) {
			if (other.ifsc != null)
				return false;
		} else if (!ifsc.equals(other.ifsc))
			return false;
		if (mdate == null) {
			if (other.mdate != null)
				return false;
		} else if (!mdate.equals(other.mdate))
			return false;
		if (mmid == null) {
			if (other.mmid != null)
				return false;
		} else if (!mmid.equals(other.mmid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber != other.phonenumber)
			return false;
		if (pmtaddress == null) {
			if (other.pmtaddress != null)
				return false;
		} else if (!pmtaddress.equals(other.pmtaddress))
			return false;
		if (pmtcity == null) {
			if (other.pmtcity != null)
				return false;
		} else if (!pmtcity.equals(other.pmtcity))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", acnumber=" + acnumber + ", id=" + id + ", email=" + email + ", phonenumber="
				+ phonenumber + ", fathersname=" + fathersname + ", gender=" + gender + ", balance=" + balance
				+ ", username=" + username + ", password=" + password + ", dob=" + dob + ", pmtaddress=" + pmtaddress
				+ ", pmtcity=" + pmtcity + ", cntaddress=" + cntaddress + ", cntcity=" + cntcity + ", state=" + state
				+ ", ifsc=" + ifsc + ", cdate=" + cdate + ", mdate=" + mdate + ", mmid=" + mmid + ", getMmid()="
				+ getMmid() + ", getName()=" + getName() + ", getAcnumber()=" + getAcnumber() + ", getId()=" + getId()
				+ ", getEmail()=" + getEmail() + ", getPhonenumber()=" + getPhonenumber() + ", getFathersname()="
				+ getFathersname() + ", getGender()=" + getGender() + ", getBalance()=" + getBalance()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getDob()=" + getDob()
				+ ", getPmtaddress()=" + getPmtaddress() + ", getPmtcity()=" + getPmtcity() + ", getCntaddress()="
				+ getCntaddress() + ", getCntcity()=" + getCntcity() + ", getState()=" + getState() + ", getIfsc()="
				+ getIfsc() + ", getCdate()=" + getCdate() + ", getMdate()=" + getMdate() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
