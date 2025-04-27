package eXH;
 
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsAuthStatusGenerateBill extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		Map<String, String> reqParams = XHUtil.getRequestParams(request);
		String callType = reqParams.get("callType");	
		HttpSession session;
		java.util.Properties p;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc") ;
			try{
				if("GenerateBill".equals(callType)) {
					String responseTxt="";
					responseTxt=generatebill(request, reqParams, p, session);
					
					System.out.println("***Inside InsAuthStatusGenerateBill GenerateBill - generatebill Response... " +responseTxt);
					
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 						
				}
			}catch (Exception exp) {
				exp.printStackTrace(System.err);
			}
	}
	
	
	private String generatebill(HttpServletRequest request, Map<String, String> reqParams, java.util.Properties p, HttpSession session) throws Exception {	
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		CallableStatement ostmt1 = null;
		String module_id = "PH";
		p.getProperty("LOCALE");
		String facilityid = (String)session.getValue("facility_id")==null ? "" :(String)session.getValue("facility_id");
		String userid = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" );	
		String wsno = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
		request.getSession().getId();	
			

		String getPatientIdvalue="", getEncounterIdvalue="", getDrugCodevalue="", strgetOrderLineNo="", getDispQtyvaluestr="", getOrderIdvalue="", getPatientClassvalue="", getDocNovaluestr="", getDocTypevalue="", getAuthStatus="", docsrlnodtl="", getBenefitValue="", getapprovalno ="";
		
		String p_function_id="", l_session_id = "", l_pgm_date = "", p_transaction_status = "", p_sys_message_id = "", p_message_text = "", consessionid ="";
		
		int getOrderLineNovalue = 0, getDocNovalue = 0, getDocSrlNovalue = 0, getDispQtyvalue = 0;
		Float approvalTotalAmount = 0.0f;
		
		String l_slmt_reqd_yn="", l_bill_doc_type="", l_bill_doc_num="", v_blng_group_id="", l_sys_message_id="", l_error_text="", p_call_disc_function_yn="";
		
		String sqlQuery = null;
		Connection connection 	= null;
		PreparedStatement conpstmt = null;
		ResultSet conrs=null;
			
		try
		{ 

		dbConn = ConnectionManager.getConnection(request);

		sqlQuery ="SELECT SID FROM V$SESSION WHERE AUDSID = Sys_Context('USERENV', 'SESSIONID')";
	
		try {
			connection	= ConnectionManager.getConnection() ;
			conpstmt = connection.prepareStatement( sqlQuery ) ;

			conrs = conpstmt.executeQuery() ;

			while(conrs.next()){
				consessionid = conrs.getString("SID"); 	
				//System.out.println("INSIDEE consessionid"+consessionid);
			}
		}catch (Exception e) {
		  e.printStackTrace();
		}finally {	
			conpstmt.close();
			conrs.close();
			connection.close();
		}

		String recordsStr = reqParams.toString();
		String[] recordSplit=recordsStr.split("#");

		for(String recbillprint:recordSplit){

		String[] recordSplit1=recbillprint.split("~");

		PatientDetails billprint= addValuesToObject(recordSplit1); 

			List<PatientDetails> list = new ArrayList<PatientDetails>();
			list.add(billprint);
			list.toString();
			
			for(int i = 0; i < list.size(); i++) {
	
				if( list.get(i).getPatientId() != null && !"".equals(list.get(i).getPatientId()) ){
					getPatientIdvalue = list.get(i).getPatientId().replace("{dataElements=","");
				} 
				
				if( list.get(i).getEncounterId() != null && !"".equals(list.get(i).getEncounterId()) ){
					getEncounterIdvalue = list.get(i).getEncounterId();
				} 
				
				if( list.get(i).getDispNo() != null && !"".equals(list.get(i).getDispNo()) ){
					list.get(i).getDispNo();	
				} 
				
				if( list.get(i).getDrugCode() != null && !"".equals(list.get(i).getDrugCode()) ){
					getDrugCodevalue = list.get(i).getDrugCode();
				} 
				
				if( list.get(i).getOrderLineNo() != null && !"".equals(list.get(i).getOrderLineNo()) ){
					strgetOrderLineNo = list.get(i).getOrderLineNo();
					getOrderLineNovalue = Integer.parseInt(strgetOrderLineNo);
				} 
				
				if( list.get(i).getDispQty() != null && !"".equals(list.get(i).getDispQty()) ){
					getDispQtyvaluestr = list.get(i).getDispQty();
					getDispQtyvalue = Integer.parseInt(getDispQtyvaluestr);
				} 
				
				if( list.get(i).getOrderId() != null && !"".equals(list.get(i).getOrderId()) ){
					getOrderIdvalue = list.get(i).getOrderId();
				}

				if( list.get(i).getPatientClass() != null && !"".equals(list.get(i).getPatientClass()) ){
					getPatientClassvalue = list.get(i).getPatientClass();
				} 
				
				List<PatientDetails> docdetails = getdocdetails(getPatientIdvalue, getOrderIdvalue); 
				
				if( list.get(i).getDocNo() != null && !"".equals(list.get(i).getDocNo()) ){
					getDocNovaluestr = docdetails.get(i).getDocNo(); 
					getDocNovalue = Integer.parseInt(getDocNovaluestr);
				}
				
				if( list.get(i).getDocType() != null && !"".equals(list.get(i).getDocType()) ){
					getDocTypevalue = docdetails.get(i).getDocType();
				}
				
				if( list.get(i).getAuthStatus() != null && !"".equals(list.get(i).getAuthStatus()) ){
					getAuthStatus = list.get(i).getAuthStatus();
					if(getAuthStatus.equals("P")){
						getAuthStatus = "APPROVED";
					}else if(getAuthStatus.equals("R")){
						getAuthStatus = "PARTIALLY APPROVED";
					}else if(getAuthStatus.equals("E")){
						getAuthStatus = "REJECTED";
					}else{
						getAuthStatus = "E";
					}
				}
	
				if( list.get(i).getBenefitValue() != null && !"".equals(list.get(i).getBenefitValue()) ){
					getBenefitValue = list.get(i).getBenefitValue();
					approvalTotalAmount = Float.parseFloat(getBenefitValue);	
				}
				
				if( list.get(i).getApprovalNo() != null && !"".equals(list.get(i).getApprovalNo()) ){
					getapprovalno = list.get(i).getApprovalNo();	
				}

				docsrlnodtl = getDocSrlNo(getOrderIdvalue); 
	
				getDocSrlNovalue = Integer.parseInt(docsrlnodtl);

				ostmt = dbConn.prepareCall("{ CALL BL_RECORD_APPROVAL.PROCESS_RECORD_APPR_PH (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );

				ostmt.setString(1,consessionid); //p_session_id 
				ostmt.setDate(2, new java.sql.Date(System.currentTimeMillis())); //p_pgm_date
				ostmt.setString(3,facilityid); //p_facility_id
				ostmt.setString(4,module_id); // p_module_id
				ostmt.setString(5,getPatientIdvalue); //p_patient_id
				ostmt.setString(6,getEncounterIdvalue); //p_encounter_id
				ostmt.setString(7,getPatientClassvalue); //p_sal_trn_type
				ostmt.setString(8,getDocTypevalue); //p_doc_type_code
				ostmt.setInt(9,getDocNovalue); //p_doc_no
				ostmt.setInt(10,getDocSrlNovalue); //p_doc_srl_no
				ostmt.setString(11,getOrderIdvalue); //p_order_id
				ostmt.setInt(12,getOrderLineNovalue); //p_order_line_no
				ostmt.setString(13,getDrugCodevalue); //p_item_code
				ostmt.setString(14,getAuthStatus); //p_auth_status
				ostmt.setString(15,getapprovalno); //p_approval_no
				ostmt.setDate(16, new java.sql.Date(System.currentTimeMillis())); //p_approval_given_date
				ostmt.setInt(17,getDispQtyvalue); //p_item_approved_qty
				ostmt.setFloat(18, approvalTotalAmount);//p_item_approved_amt  benified value
				ostmt.setString(19,userid); //p_user_id
				ostmt.setString(20,wsno); //p_ws_no
				
				ostmt.registerOutParameter(21,java.sql.Types.VARCHAR); //p_function_id
				ostmt.registerOutParameter(22,java.sql.Types.VARCHAR); //l_session_id
				ostmt.registerOutParameter(23,java.sql.Types.VARCHAR); //l_pgm_date
				ostmt.registerOutParameter(24,java.sql.Types.VARCHAR); //p_transaction_status
				ostmt.registerOutParameter(25,java.sql.Types.VARCHAR); //p_sys_message_id
				ostmt.registerOutParameter(26,java.sql.Types.VARCHAR); //p_message_text

				ostmt.execute();
				
				p_function_id = ostmt.getString(21);
				l_session_id = ostmt.getString(22);				
				l_pgm_date = ostmt.getString(23);				
				p_transaction_status = ostmt.getString(24);				
				p_sys_message_id = ostmt.getString(25);				
				p_message_text = ostmt.getString(26);				
			
				if(p_transaction_status.equals("S")){	
	
					ostmt1	= connection.prepareCall("{ call ST_BL_BILL_GEN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
   
					ostmt1.setString(1, facilityid); 
					ostmt1.setString(2, getDrugCodevalue);
					ostmt1.setString(3, getDocTypevalue+"-"+getDocNovalue );
					ostmt1.setString(4, userid);
					ostmt1.setString(5, wsno);
					//ostmt1.setFloat(6,  Float.parseFloat(p_charge_amt));
					ostmt1.setFloat(6, approvalTotalAmount);
					ostmt1.setString(7, getPatientIdvalue);
					ostmt1.setString(8, getPatientClassvalue); 
					ostmt1.setString(9, getEncounterIdvalue);	

					ostmt1.registerOutParameter(10, Types.VARCHAR);
					ostmt1.registerOutParameter(11, Types.VARCHAR);
					ostmt1.registerOutParameter(12, Types.VARCHAR);
					ostmt1.registerOutParameter(13, Types.VARCHAR);
					ostmt1.registerOutParameter(14, Types.VARCHAR);
					ostmt1.registerOutParameter(15, Types.VARCHAR);
					
					ostmt1.setString(16, module_id);
					ostmt1.setString(17,  "Y");

					ostmt1.registerOutParameter(18, Types.VARCHAR);
					
					ostmt1.setString(19, facilityid);
					
					ostmt1.execute();	
				
					l_slmt_reqd_yn = ostmt.getString(10);
					l_bill_doc_type = ostmt.getString(11);				
					l_bill_doc_num = ostmt.getString(12);				
					v_blng_group_id = ostmt.getString(13);				
					l_sys_message_id = ostmt.getString(14);				
					l_error_text = ostmt.getString(15);		
					p_call_disc_function_yn = ostmt.getString(18);		
					
					l_error_text = l_error_text+"#"+p_transaction_status;
				
				}else{
					l_error_text = p_message_text+"#"+p_transaction_status;
				}
			}//inner-for-loopC100000025
		}//outer-for-loop
		
		}
		catch(Exception exp)
		{
			System.out.println("***Exception in InsAuthStatusGenerateBill - generatebill procedure "+exp);
			System.out.println("***Exception in InsAuthStatusGenerateBill - generatebill procedure line number "+exp.getStackTrace()[0].getLineNumber());
			exp.printStackTrace();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		
	return l_error_text;			
	}	
	
	
	public static PatientDetails addValuesToObject(String[] recordSplit1){

			PatientDetails authdetails = new PatientDetails();
			
			if(recordSplit1 !=null && recordSplit1.length > 1){
				authdetails.setPatientId(recordSplit1[0]);
				authdetails.setEncounterId(recordSplit1[1]);
				authdetails.setDispNo(recordSplit1[2]);
				authdetails.setDrugCode(recordSplit1[3]);
				authdetails.setOrderLineNo(recordSplit1[4]);
				authdetails.setDispQty(recordSplit1[5]);
				authdetails.setOrderId(recordSplit1[6]);
				authdetails.setPatientClass(recordSplit1[7]);
				authdetails.setAuthStatus(recordSplit1[8]);
				authdetails.setBenefitValue(recordSplit1[9]);
				authdetails.setApprovalNo(recordSplit1[10]);
			}

			return authdetails;
		}
		
	public List<PatientDetails> getdocdetails (String strPatientId, String strOrderId) throws Exception{	

		Connection connection1 = null ;
		PreparedStatement pstmt1 = null ;
		ResultSet resultSet1 = null ;
		List<PatientDetails> InsAuthStatus = new ArrayList<PatientDetails>() ;
		PatientDetails patientDetails;
		
		try {
		connection1 = ConnectionManager.getConnection() ;

		pstmt1 = connection1.prepareStatement("SELECT DOC_NO,DOC_TYPE from PH_DISP_HDR_TMP WHERE PATIENT_ID=? AND order_id=?");

		pstmt1.setString(1,strPatientId);
		pstmt1.setString(2,strOrderId);

		resultSet1 = pstmt1.executeQuery() ;
		
		while (resultSet1.next()) {
			
			patientDetails = new PatientDetails();
			
			patientDetails.setDocNo(resultSet1.getString("DOC_NO")); //0
			patientDetails.setDocType(resultSet1.getString("DOC_TYPE")); //1
			
			InsAuthStatus.add(patientDetails);
			
		}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally{pstmt1.close();
			resultSet1.close();
			connection1.close();}
			
		return InsAuthStatus;
	}

	public static String getDocSrlNo(String strOrderId) throws SQLException {
		Connection connection2 = null ;
		PreparedStatement pstmt2 = null ;
		ResultSet resultSet2 = null ;
		String doc_srl_no="";
		
		try {
		connection2 = ConnectionManager.getConnection() ;

		pstmt2 = connection2.prepareStatement("SELECT DOC_SRL_NO FROM PH_DISP_DTL WHERE ORDER_ID=?") ;

		pstmt2.setString(1,strOrderId);

		resultSet2 = pstmt2.executeQuery() ;
		while (resultSet2.next()) {
			doc_srl_no = resultSet2.getString("DOC_SRL_NO");
		}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally{pstmt2.close();
			resultSet2.close();
			connection2.close();}		
		return doc_srl_no;
	}

}
