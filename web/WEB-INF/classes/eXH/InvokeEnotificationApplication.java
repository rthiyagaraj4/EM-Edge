/***************************************************************************************************************
 * Author   :   Prithvirajan. R
 * Desc     :	This class is used to invoke the external eNotification application -- MMOH
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class InvokeEGLapplication
 */
public class InvokeEnotificationApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseTxt=null;
		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType");

			 System.out.println("callType...."+callType);
		
			if("CheckEnotification".equals(callType)) 
			{
					responseTxt=processRequest(reqParams,request);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt);
					resp.flush();
					resp.close();
			}	
		}
		catch (Exception exp) 
		{
			exp.printStackTrace(System.err);
		}
    }
    
	private String processRequest(Map<String, String> reqParams, HttpServletRequest request) throws Exception 
		
	{
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement=null;
		String returnStr = "";
		//ML-MMOH-CRF-2156.1
		boolean proceedEnotiCheck=true;
		
		String patientId = "", encounterIdStr = "", termSetId = "", termCode = "", termStage = "", termStatus = "" ;	
		String isPatAddrsAvailable="N",restrictIntFlag="N";
		String paramString=reqParams.get("paramString");

		System.out.println("PARAMSTRING SETHU ::: "+paramString);

		String replacedStr = paramString.replace("$!^","^!^");

		String delims = "^!^";
		StringTokenizer st = new StringTokenizer(replacedStr,delims );
		
		String tokenData  = "";
		while (st.hasMoreElements()) 
		{
			tokenData = st.nextElement().toString();		
			if (tokenData.indexOf("PATIENT_ID") > 0)
			{
				patientId = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("PATIENT_ID ::: "+patientId);
			}
			if (tokenData.indexOf("ENCOUNTER_ID") > 0)
			{
				encounterIdStr = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("ENCOUNTER_ID ::: "+encounterIdStr);
			}
			if (tokenData.indexOf("TERMSET_ID") > 0)
			{
				termSetId = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("TERMSET_ID ::: "+termSetId);
			}
			if (tokenData.indexOf("TERMCODE") > 0)
			{
				termCode = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("TERMCODE ::: "+termCode);
			}
			if (tokenData.indexOf("TERMSTAGE") > 0)
			{
				termStage = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("TERMSTAGE ::: "+termStage);
			}
			if (tokenData.indexOf("TERMSTATUS") > 0)
			{
				termStatus = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("TERMSTATUS ::: "+termStatus);
			}
		}					

		String profileId = "MLENOTIFY01";

		String returnFlag = "Y";
		
		long encounterId = 0;
		HttpSession		session		=	null;  
		session	=	request.getSession(false);

		if(!"".equals(encounterIdStr) && encounterIdStr != null)
		{
			encounterId = Long.parseLong(encounterIdStr);
		}

		CallableStatement checkEnotiStatement = null;

		System.out.println("process REquest method...");
		String checkProfileIdQuery = "{ ? = call xh_standard_profile_exists(?) }";

		try{
		
			if (connection == null)
			connection = ConnectionManager.getConnection();

			checkEnotiStatement = connection.prepareCall(checkProfileIdQuery);
			checkEnotiStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
			checkEnotiStatement.setString(2, profileId);
			checkEnotiStatement.execute();
			System.out.println("checkEnotiDiagnosis value....11");
		
			String checkEnotiDiagnosis = checkEnotiStatement.getString(1);

			System.out.println("checkEnotiDiagnosis value...."+checkEnotiDiagnosis);

			if ("Y".equals(checkEnotiDiagnosis)) {
					//ML-MMOH-CRF-2156.1-US002
				String valPatientAddress = "{ ? = call mp_pat_address_return_fnc(?) }";
				String sql = "select nvl(REST_INTEGRATION_ENOTIFIKASI,'N') REST_INTEGRATION_ENOTIFIKASI from MR_PARAMETER";
				System.out.println("REST_INTEGRATION_ENOTIFIKASI value....11");
				statement= connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				if(resultSet.next()){
					restrictIntFlag=resultSet.getString("REST_INTEGRATION_ENOTIFIKASI");
				}  
					
				System.out.println("restrictIntFlag value...."+restrictIntFlag);
				if(restrictIntFlag.equals("Y")){
					checkEnotiStatement = connection.prepareCall(valPatientAddress);
					checkEnotiStatement.registerOutParameter(1,java.sql.Types.VARCHAR);
					checkEnotiStatement.setString(2, patientId);
					checkEnotiStatement.execute();
					isPatAddrsAvailable = checkEnotiStatement.getString(1);
					System.out.println("isPatAddrsAvailable value...."+isPatAddrsAvailable);
				
				}
				
				System.out.println("proceedEnotiCheck value...."+proceedEnotiCheck);
		
					String diagnosisFlag = "";
					String diagErrorCode = "";
					String diagErrorMsg = "";
					String facilityId = (String)session.getValue("facility_id") ;

				String checkDiagQuery = "{ call xhenotifixml.XH_ENOTI_CHECK_DIAG(?,?,?,?,?,?,?,?) }";

				System.out.println(" facilityId ::: "+ facilityId + " ::: termSetId ::: "+ termSetId + " ::: termCode ::: "+ termCode + " ::: termStage ::: "+ termStage + " ::: termStatus ::: "+ termStatus);

				checkEnotiStatement = connection.prepareCall(checkDiagQuery);
				checkEnotiStatement.setString(1, facilityId);
				checkEnotiStatement.setString(2, termSetId);
				checkEnotiStatement.setString(3, termCode);
				checkEnotiStatement.setString(4, termStage);
				checkEnotiStatement.setString(5, termStatus);
				checkEnotiStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
				checkEnotiStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
				checkEnotiStatement.registerOutParameter(8,java.sql.Types.VARCHAR);
				checkEnotiStatement.execute();				
					
				diagnosisFlag = checkEnotiStatement.getString(6);
				diagErrorCode = checkEnotiStatement.getString(7);
				diagErrorMsg = checkEnotiStatement.getString(8);

				System.out.println("diagnosisFlag in XH_ENOTI_CHECK_DIAG...."+ diagnosisFlag);
				
				if ( (!"".equals(diagErrorCode) && diagErrorCode != null && !"S".equals(diagErrorCode)) && (!"".equals(diagErrorMsg) || diagErrorMsg != null)) {
					
					System.out.println("Error code in XH_ENOTI_CHECK_DIAG...."+ diagErrorCode);
					System.out.println("Error msg in XH_ENOTI_CHECK_DIAG...."+ diagErrorMsg);
					returnFlag =  "N";
				} 
				else if("Y".equals(diagnosisFlag)){
					
					System.out.println("disp flag value in XH_ENOTI_CHECK_DIAG...."+ diagnosisFlag);
					
					String msgFlag = "";
					String checkMsgErrorCode = "";
					String checkMsgErrorMsg = "";

					String checkMsgQuery = "{ call xhenotifixml.XH_ENOTI_CHECK_MSG(?,?,?,?,?,?,?,?) }";

					System.out.println(" facilityId ::: "+ facilityId +" ::: Patient ID ::: "+ patientId +" ::: encounterId ::: "+ encounterId + " ::: termSetId ::: "+ termSetId + " ::: termCode ::: "+ termCode);

					checkEnotiStatement = connection.prepareCall(checkMsgQuery);
					checkEnotiStatement.setString(1, facilityId);
					checkEnotiStatement.setString(2, patientId);
					checkEnotiStatement.setLong(3, encounterId);
					checkEnotiStatement.setString(4, termSetId);
					checkEnotiStatement.setString(5, termCode);
					checkEnotiStatement.registerOutParameter(6,java.sql.Types.VARCHAR);
					checkEnotiStatement.registerOutParameter(7,java.sql.Types.VARCHAR);
					checkEnotiStatement.registerOutParameter(8,java.sql.Types.VARCHAR);
					checkEnotiStatement.execute();				
					
					msgFlag = checkEnotiStatement.getString(6);
					checkMsgErrorCode = checkEnotiStatement.getString(7);
					checkMsgErrorMsg = checkEnotiStatement.getString(8);		
					
					System.out.println("values in XH_ENOTI_CHECK_MSG...."+ msgFlag);
					
					if( (!"".equals(checkMsgErrorCode) && checkMsgErrorCode != null  && !"S".equals(checkMsgErrorCode)) && (!"".equals(checkMsgErrorMsg) || checkMsgErrorMsg != null))
					{
						System.out.println("Error code in XH_ENOTI_CHECK_MSG...."+ checkMsgErrorCode);
						System.out.println("Error msg in XH_ENOTI_CHECK_MSG...."+ checkMsgErrorMsg);
						returnFlag = "N";
					}
					else if("Y".equals(msgFlag))
					{
						returnFlag = "N";
					}
					else
					{
						returnFlag = "Y";
						if(restrictIntFlag.equals("Y")){
							if(isPatAddrsAvailable.equals("N")){
								proceedEnotiCheck=false;
							}
						}//ML-MMOH-SCF-3046
					}					
				}
				else
				{
					returnFlag = "N";
				}
			} 
			else 
			{
				System.out.println("value returned from xh_standard_profile_exists.... "+checkEnotiDiagnosis);
				returnFlag = "N";
			}
			System.out.println("Final returnFlag.... "+returnFlag);
			if("Y".equals(returnFlag))
			{				
				if(!proceedEnotiCheck){ //ML-MMOH-CRF-2156.1-To handle new msg for incomplete info
					returnStr = "The e-Notifikasi reporting is not successfully sent because of incomplete information. Medical Officer is requested to report in the e-Notifikasi portal. e-Notifikasi which is not reported is a compoundable offense under Section 10(2) of the Prevention and Control of Infectious Diseases Act 1988.";
				}else{
					returnStr = "eNotifikasi message has been sent.";
				}
			}
			else
			{
				returnStr = "";
			}

			return returnStr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "E";
		}
		finally{
			
			if(connection!=null)
				connection.close();
			
			if(checkEnotiStatement != null)
				checkEnotiStatement.close();
			
			if(resultSet!=null)
				resultSet.close();
			
			if(resultSet!=null)
				resultSet.close();
			
			if(statement!=null)
				statement.close();
		}
	}
}