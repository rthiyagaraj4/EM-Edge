/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.healthobject;

/**
 * @author vchoughule 
 *
 */
public class ClinicalNotesFieldItem {

	private String code;
	private String desc;
	private String detail;// to add any extra field which is required
	private String detail2;
	private boolean defaultField;
	/**
	 * @return the detail2
	 */
	public String getDetail2() {
		return detail2;
	}
	/**
	 * @param detail2 the detail2 to set
	 */
	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the defaultField
	 */
	public Boolean getDefaultField() {
		return defaultField;
	}
	/**
	 * @param defaultField the defaultField to set
	 */
	public void setDefaultField(Boolean defaultField) {
		this.defaultField = defaultField;
	}
	
}
