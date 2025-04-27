/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.response;

import java.util.ArrayList;
import java.util.List;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesTemplateField;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

/**
 * @author vchoughule
 *
 */
public class ClinicalNotesTemplateResponse extends GenericResponse {
  private List<ClinicalNotesTemplateField> templateLst; // have to remove - TODO 
  private ClinicalNotesTemplateField templateField ;
  public boolean isEmptyDataResponse(){
		boolean isEmpty = false;
		ArrayList<ErrorInfo> errorsList = getErrorsList();
		if(!errorsList.isEmpty()){
			for(ErrorInfo errorInfo:errorsList){
				if(errorInfo.getErrorType() == Errors.CLINICALNOTES_EMPTY_DATA)
				{
					isEmpty = true;
					break;
				}
			}
		}
		return isEmpty;
	}

/**
 * @return the templateLst
 */
public List<ClinicalNotesTemplateField> getTemplateLst() {
	return templateLst;
}

/**
 * @param templateLst the templateLst to set
 */
public void setTemplateLst(List<ClinicalNotesTemplateField> templateLst) {
	this.templateLst = templateLst;
}

/**
 * @return the templateField
 */
public ClinicalNotesTemplateField getTemplateField() {
	return templateField;
}

/**
 * @param templateField the templateField to set
 */
public void setTemplateField(ClinicalNotesTemplateField templateField) {
	this.templateField = templateField;
}


}
