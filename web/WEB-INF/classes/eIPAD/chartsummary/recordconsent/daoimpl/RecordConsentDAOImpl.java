/**
 * 
 */
package eIPAD.chartsummary.recordconsent.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.recordconsent.dao.RecordConsentDAO;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;

/**
 * @author psenthil
 *
 */
public class RecordConsentDAOImpl extends GenericDAOImpl implements RecordConsentDAO{
	
	
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
	 
	public RecordConsentFieldResponse getConsentFormList(PatContext patientContext){
		RecordConsentFieldResponse response = new RecordConsentFieldResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			locale = patientContext.getLocale();
			ArrayList<RecordConsentFieldItem> consentFormList = new ArrayList<RecordConsentFieldItem>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer noteTypeListQuery = new StringBuffer("SELECT CONSENT_FORM_LABEL DESCRIPTION,CONSENT_FORM_ID CODE FROM OR_CONSENT_FORM_LANG_VW where LANGUAGE_ID='"+locale+"' AND EFF_STATUS='E' AND CONSENT_TYPE='C' AND CONSENT_FORM_ID LIKE UPPER('%') AND UPPER(CONSENT_FORM_LABEL) LIKE UPPER('%')  ORDER BY 2 ");
			try {
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(noteTypeListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code ;
						String desc;
						
						
						while(rs.next())
						{
							code=rs.getString("CODE")==null?"":rs.getString("CODE");
							desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
							RecordConsentFieldItem consentfielditem = new RecordConsentFieldItem();
							consentfielditem.setCode(code);
							consentfielditem.setDesc(desc);
							consentFormList.add(consentfielditem);
						}
						response.setFieldList(consentFormList);
						if(consentFormList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
							
					}
				}
			}catch(SQLException e){
				System.out.println("A database exception occurred while fetching consent forms" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
}