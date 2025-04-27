/**
 * 
 */
package eIPAD.chartsummary.recordconsent.response;

import java.util.List;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem;

/**
 * @author SaraswathiR
 *
 */
public class RecordConsentFieldResponse extends GenericResponse {
	
	private List<RecordConsentFieldItem> fieldList;

	/**
	 * @return the fieldList
	 */
	public List<RecordConsentFieldItem> getFieldList() {
		return fieldList;
	}

	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(List<RecordConsentFieldItem> fieldList) {
		this.fieldList = fieldList;
	}
}
