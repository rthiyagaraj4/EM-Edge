package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLEncoder;
import com.ehis.util.*;

import webbeans.eCommon.*;

public class MRCoaderDiagServlet extends javax.servlet.http.HttpServlet{
	

                                      
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		    req.setCharacterEncoding("UTF-8");
	        res.setContentType("text/html;charset=UTF-8");
			
		try	{
			
			
			insertCoaderDiagnosis(req, res);


		}catch(Exception e){
			e.printStackTrace();
		}
	} //End of doPost

	 private void  insertCoaderDiagnosis(HttpServletRequest req, HttpServletResponse res){
			String errorMsg	= "";
			PrintWriter out = null; 
			String facilityId = "";
			HttpSession session = null; 
			Properties p = null;
			String client_ip_address = ""; 	
			Connection con = null;
		  try{
			session           	        = req.getSession(false) ;
			out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			String selectedRows = "";  
			String modifiedById = "";  
			String locale = "";  
			String modifiedAtWorkstation="";
			String totalRecords ="";
			String patientId = "";
			String encounterId = "";
			String patientClass = "";
			String modified_date	= "";
			String modified_date_db	= "";
			int coderCount	= 0;
			session 						= req.getSession(true);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    client_ip_address = p.getProperty("client_ip_address");
			facilityId = (String) session.getValue( "facility_id" ) ;
			modifiedById	      = p.getProperty( "login_user" ) ;
			locale				  = p.getProperty("LOCALE");
			modifiedAtWorkstation  = client_ip_address ;
            
			
			selectedRows		=   checkForNull(req.getParameter("selectedRows"));
			patientId			=   checkForNull(req.getParameter("patient_id"));
			encounterId			=   checkForNull(req.getParameter("EncounterId"));
			patientClass		=   checkForNull(req.getParameter("patientClass"));
			modified_date		=   checkForNull(req.getParameter("modified_date"));


			totalRecords		= checkForNull(req.getParameter("coderCount"));
			coderCount			=	Integer.parseInt(totalRecords);

				
			int result	= 0;
			int result1	= 0;
			int result2	= 0;
			int insertCount	= 0;
			int updateCount	= 0;
			int exUpdateCount	= 0;
			String sql		= "";
			int i=1;
			String isTermCodeExistAll	= "";

			String existingTermCodeDtls	= checkForNull(req.getParameter("existingTermCodeDtls"));
			String isProceed	= "Y";
			String errCode		= "";

			StringTokenizer strTok1 = null;
			StringTokenizer strTok2 = null;
		   	HashMap<String,String> hashMap = new HashMap<String,String>();

			if(!existingTermCodeDtls.equals("")){
				strTok1 = new StringTokenizer(existingTermCodeDtls,"|@|");
				while(strTok1.hasMoreTokens()) {
					String codeDtls	= strTok1.nextToken();
					hashMap.put(codeDtls,codeDtls);
				}
			}
			



			String insertCoderDiagDtls	= "insert into PR_CODER_DIAGNOSIS_DTLS(ENCOUNTER_ID,PATIENT_ID,FACILITY_ID,TERM_SET_ID,TERM_CODE,DIAG_CLASS_CODE,TERM_CODE_SHORT_DESC,POA_INDICATOR,ONSET_DATE,INCLUDE_YN,REPORTED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,sysdate,?,?,?,sysdate,?,?)";
			
			String updateCoderDiagDtls	= "update PR_CODER_DIAGNOSIS_DTLS set DIAG_CLASS_CODE=?, TERM_CODE_SHORT_DESC=?,POA_INDICATOR=?, INCLUDE_YN=?, REPORTED_YN=?, ONSET_DATE=to_date(?,'dd/mm/yyyy hh24:mi:ss'), MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID=? where PATIENT_ID=? and ENCOUNTER_ID=? and TERM_SET_ID=? and TERM_CODE = ? and facility_id	= ?";

			String updateExistingDiagDtls	= "update PR_CODER_DIAGNOSIS_DTLS set INCLUDE_YN='N', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID=? where PATIENT_ID=? and ENCOUNTER_ID=? and TERM_SET_ID=? and TERM_CODE = ? and facility_id	= ?";

			PreparedStatement prep =  con.prepareStatement(insertCoderDiagDtls);
			PreparedStatement prep1 =  con.prepareStatement(updateCoderDiagDtls);
			PreparedStatement prep2 =  con.prepareStatement(updateExistingDiagDtls);

			if(coderCount == 0){
				try{
				sql	= "insert into PR_CODER_HDR (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,PATIENT_CLASS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
				prep2	= con.prepareStatement(sql);
				i=1;
				prep2.setString(i++, patientId);
				prep2.setString(i++, encounterId);
				prep2.setString(i++, facilityId);
				prep2.setString(i++, patientClass);
				prep2.setString(i++, modifiedById);
				prep2.setString(i++, modifiedAtWorkstation);
				prep2.setString(i++, facilityId);
				prep2.setString(i++, modifiedById);
				prep2.setString(i++, modifiedAtWorkstation);
				prep2.setString(i++, facilityId);
				prep2.executeUpdate();
				prep2.close();
				}catch ( SQLException se ){
					isProceed	= "N";
					if(se.getErrorCode()==1){
						errCode	= "1";	
					}else{
						errCode	= "Exception while inserting PR_CODER_HDR table";
						se.printStackTrace();
					}
				}finally{
				}

			}else{
				
				try{

					modified_date_db	= eMR.MRCoaderDiagBean.getLastModifiedDate(con,encounterId,facilityId,patientId);
					if(!modified_date_db.equals(modified_date)){
						isProceed	= "N";
						errCode	= "1";	
					}
	
				}catch ( Exception e){
					e.printStackTrace();
					
				}finally{
				}

			}

			if(isProceed.equals("Y")){
				StringTokenizer strTok = null;
				if(!"".equals(selectedRows)){
					strTok = new StringTokenizer(selectedRows,"|~|");
					while(strTok.hasMoreTokens()) {
						String id	= strTok.nextToken();
						String termSetId				= checkForNull(req.getParameter("termSetId_"+id));	
						String diagClass				= checkForNull(req.getParameter("diag_class_"+id));	
						String termCode					= checkForNull(req.getParameter("diagprob_code_"+id));	
						String termShortDesc			= checkForNull(req.getParameter("diagprob_desc_"+id));
						String poaIndicator				= checkForNull(req.getParameter("poa_indicator_"+id));
						String onSetDate				= checkForNull(req.getParameter("onset_date_"+id));
						String reportedChk				= checkForNull(req.getParameter("chk_reported_"+id),"N");
						String codeToChk				= termSetId+"~"+termCode;
						String isTermCodeExist					= "N";
						if(!existingTermCodeDtls.equals("")){

							if(hashMap.containsValue(String.valueOf(codeToChk))){
								hashMap.remove(codeToChk);
								isTermCodeExist			= "Y";
							}
						}
						if(isTermCodeExist.equals("Y")){
							i=1;
							prep1.setString(i++, diagClass);
							prep1.setString(i++, termShortDesc);
							prep1.setString(i++, poaIndicator);
							prep1.setString(i++, "Y");
							prep1.setString(i++, reportedChk);
							prep1.setString(i++, onSetDate);
							prep1.setString(i++, modifiedById);
							prep1.setString(i++, modifiedAtWorkstation);
							prep1.setString(i++, facilityId);
							prep1.setString(i++, patientId);
							prep1.setString(i++, encounterId);
							prep1.setString(i++, termSetId);
							prep1.setString(i++, termCode);
							prep1.setString(i++, facilityId);
							prep1.addBatch();
							updateCount++;
						}else{
							i=1;
							prep.setString(i++, encounterId);
							prep.setString(i++, patientId);
							prep.setString(i++, facilityId);
							prep.setString(i++, termSetId);
							prep.setString(i++, termCode);
							prep.setString(i++, diagClass);
							prep.setString(i++, termShortDesc);
							prep.setString(i++, poaIndicator);
							prep.setString(i++, onSetDate);
							prep.setString(i++, "Y");
							prep.setString(i++, reportedChk);
							prep.setString(i++, modifiedById);
							prep.setString(i++, modifiedAtWorkstation);
							prep.setString(i++, facilityId);
						prep.setString(i++, modifiedById);
						prep.setString(i++, modifiedAtWorkstation);
						prep.setString(i++, facilityId);
						prep.addBatch();
						insertCount++;
					}

				}

					if(!existingTermCodeDtls.equals("")){
						Iterator entries = hashMap.entrySet().iterator();

						 while (entries.hasNext()) {
							Map.Entry entry = (Map.Entry) entries.next();
							String values = (String)entry.getKey();
							  if(!values.equals("")){

									strTok2 = new StringTokenizer(values,"~");
									if(strTok2.hasMoreTokens()) {
										String exTermSet	= strTok2.nextToken();
										String exTermCode	= strTok2.nextToken();
										i=1;
										prep2.setString(i++, modifiedById);
										prep2.setString(i++, modifiedAtWorkstation);
										prep2.setString(i++, facilityId);
										prep2.setString(i++, patientId);
										prep2.setString(i++, encounterId);
										prep2.setString(i++, exTermSet);
										prep2.setString(i++, exTermCode);
										prep2.setString(i++, facilityId);
										prep2.addBatch();
										exUpdateCount++;
									}
							  }
						 }
					}

					try{
						if(insertCount>0){
							int[] no = prep.executeBatch();
							result	 = no.length;
						}
						if(updateCount>0){
							int[] no1 = prep1.executeBatch();
							result1	 = no1.length;
						}
						if(exUpdateCount>0){
							int[] no2 = prep2.executeBatch();
							result2	 = no2.length;
						}
						prep.close();
						prep1.close();
						prep2.close();
					}catch ( SQLException se ){
						isProceed	= "N";
						if(se.getErrorCode()==1){
							errCode	= "1";	
						}else{
							errCode	= "Exception while inserting PR_CODER_DIAGNOSIS_DTLS table";
							se.printStackTrace();
						}
					
					}finally{
					}

		
				}
				if(isProceed.equals("Y")){
					if(result > 0 || result1 > 0 || result2 >0){ 
							con.commit();
							java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
							String error =((String) message.get("message"));
					String error_value= "1";
					 //out.println("<script> alert(\""+error+"\"); </script>");
					 //out.println("<script>parent.onSuccess();</script>");
					// out.println("<script>parent.frames(1).workAreaFrame.frames(1).onSuccess();</script>");
					res.sendRedirect("../eMR/jsp/MRCoderFunError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
				
			}else{
				con.rollback();
				String error_value="0";
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				//out.println("<script> alert(\""+error+"\"); </script>");
						res.sendRedirect("../eMR/jsp/MRCoderFunError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
					}
				}else{
					con.rollback();
					String error	= "";
					if(errCode.equals("1")){
						java.util.Hashtable message = MessageManager.getMessage(locale, "ENC_ALREADY_MODIFIED", "IP");
						error =((String) message.get("message"));
					}else{
						error = errCode;
					}
					String error_value= "1";
					res.sendRedirect("../eMR/jsp/MRCoderFunError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
				}
			}else{
				con.rollback();
				String error	= "";
				if(errCode.equals("1")){
					java.util.Hashtable message = MessageManager.getMessage(locale, "ENC_ALREADY_MODIFIED", "IP");
					error =((String) message.get("message"));
				}else{
					error = errCode;
				}
				String error_value= "1";
				res.sendRedirect("../eMR/jsp/MRCoderFunError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
			}

		}catch ( Exception e ){
			
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, req);
		}
	} 
	  
		 

		private String checkForNull(String inputString) {
			return (inputString==null)	?	""	:	inputString;
		}

		public static String checkForNull(String inputString, String defaultValue) {
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}



} // End of the Class
