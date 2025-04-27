package ePH;

public class Speciality {

	String drug_code = "";
	String speciality_code = "";
	String speciality_desc = "";
	String set_limit_by = "";
	String quota_limit = "";
	String additional_quota_limit = "";
	String resetClicked="No";

	public String getResetClicked() {
		return resetClicked;
	}

	public void setResetClicked(String resetClicked) {
		this.resetClicked = resetClicked;
	}

	public String getDrug_code() {
		return drug_code;
	}

	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	public String getSpeciality_code() {
		return speciality_code;
	}

	public void setSpeciality_code(String speciality_code) {
		this.speciality_code = speciality_code;
	}

	public String getSpeciality_desc() {
		return speciality_desc;
	}

	public void setSpeciality_desc(String speciality_desc) {
		this.speciality_desc = speciality_desc;
	}

	public String getSet_limit_by() {
		return set_limit_by;
	}

	public void setSet_limit_by(String set_limit_by) {
		if(set_limit_by.equals("patient"))
		this.set_limit_by = "P";
		else if (set_limit_by.equals("quantity"))
			this.set_limit_by = "Q";
		else
		 this.set_limit_by=set_limit_by;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additional_quota_limit == null) ? 0 : additional_quota_limit.hashCode());
		result = prime * result + ((drug_code == null) ? 0 : drug_code.hashCode());
		result = prime * result + ((quota_limit == null) ? 0 : quota_limit.hashCode());
		result = prime * result + ((resetClicked == null) ? 0 : resetClicked.hashCode());
		result = prime * result + ((set_limit_by == null) ? 0 : set_limit_by.hashCode());
		result = prime * result + ((speciality_code == null) ? 0 : speciality_code.hashCode());
		result = prime * result + ((speciality_desc == null) ? 0 : speciality_desc.hashCode());
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
		Speciality other = (Speciality) obj;
		if (additional_quota_limit == null) {
			if (other.additional_quota_limit != null)
				return false;
		} else if (!additional_quota_limit.equals(other.additional_quota_limit))
			return false;
		if (drug_code == null) {
			if (other.drug_code != null)
				return false;
		} else if (!drug_code.equals(other.drug_code))
			return false;
		if (quota_limit == null) {
			if (other.quota_limit != null)
				return false;
		} else if (!quota_limit.equals(other.quota_limit))
			return false;
		if (resetClicked == null) {
			if (other.resetClicked != null)
				return false;
		} else if (!resetClicked.equals(other.resetClicked))
			return false;
		if (set_limit_by == null) {
			if (other.set_limit_by != null)
				return false;
		} else if (!set_limit_by.equals(other.set_limit_by))
			return false;
		if (speciality_code == null) {
			if (other.speciality_code != null)
				return false;
		} else if (!speciality_code.equals(other.speciality_code))
			return false;
		if (speciality_desc == null) {
			if (other.speciality_desc != null)
				return false;
		} else if (!speciality_desc.equals(other.speciality_desc))
			return false;
		return true;
	}

	public String getQuota_limit() {
		return quota_limit;
	}

	public void setQuota_limit(String quota_limit) {
		this.quota_limit = quota_limit;
	}

	public String getAdditional_quota_limit() {
		return additional_quota_limit;
	}

	public void setAdditional_quota_limit(String additional_quota_limit) {
		this.additional_quota_limit = additional_quota_limit;
	}

	@Override
	public String toString() {
		return "Speciality [drug_code=" + drug_code + ", speciality_code=" + speciality_code + ", speciality_desc="
				+ speciality_desc + ", set_limit_by=" + set_limit_by + ", quota_limit=" + quota_limit
				+ ", additional_quota_limit=" + additional_quota_limit + "]";
	}

}
