package eBL.ReceiptMaintenance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.sql.Types;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
*/
import java.sql.*;
import webbeans.eCommon.ConnectionManager;



/**
 * 
 * @ejb.bean name="ReceiptMaintenance" type="Stateless" transaction-type="Bean"
 *           view-type="both" jndi-name="ReceiptMaintenance"
 *           local-jndi-name="ReceiptMaintenance"
 *           impl-class-name="eBL.ReceiptMaintenance.ReceiptMaintenanceManager"
 * 
 * 
 * @ejb.interface extends="javax.ejb.EJBObject"
 *                local-extends="javax.ejb.EJBLocalObject"
 *                local-class="eBL.ReceiptMaintenance.ReceiptMaintenanceLocal"
 *                remote-class="eBL.ReceiptMaintenance.ReceiptMaintenanceRemote"
 *                generate= "local,remote"
 * 
 * @ejb.home extends="javax.ejb.EJBHome" local-extends="javax.ejb.EJBLocalHome"
 *           local-class="eBL.ReceiptMaintenance.ReceiptMaintenanceLocalHome"
 *           remote-class="eBL.ReceiptMaintenance.ReceiptMaintenanceHome" generate=
 *           "local,remote"
 * 
 */
public class ReceiptMaintenanceManager implements SessionBean {
	
	SessionContext ctx;
	String facilityId="";
	String mode = "";
	String client_ip_address="";
//	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";	
	String locale = "";
	String facility_id = "";
	String loginUser;
	String local;
	String docTypeCode;
	int docNumber;
	String reasonCode;
	String reasonDesc;
	String docDate;
	String receiptNatureCode;
	String receiptTypeCode;
	float docAmount;
	String patientId;
	String episodeType;
	int episodeId;
	String visitId;
	String reportOption;
	String authFlag;
	String voidNumber;
	String void_number;
	String wsNumber;
	String alertFlag;
	String recpt_nature_code;
	
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	Locale loc = null;
	ResourceBundle rb = null;

	boolean insertable = false;
	
	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap insertEncounterDetails(java.util.HashMap tabdata,java.util.Properties p) 
	{	
		System.out.println("in EJB");
		Connection con=null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		
	//	ResultSet rst = null;
		
		HashMap<String, String> returnMap = new HashMap();
	//	HashMap returnMapAll = new HashMap();	
		
			//req.setCharacterEncoding("UTF-8");
		//	res.setContentType("text/html;charset=UTF-8");
			
		 
		try{
			con = ConnectionManager.getConnection(p);
			locale = p.getProperty("LOCALE") ;
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);									
			mode = (String) tabdata.get("mode");			
			System.out.println("mode=="+mode);		
			String newvariablefortesting = "Test" ;	
			System.err.println("newvariablefortesting-changes done on 26072022-"+newvariablefortesting);			
			 if("checkForSubmit".equals(mode)){
				 String retValue="";
			    	System.out.println("in checkForSubmit");
			    	loginUser = (String) tabdata.get("loginUser");
					facilityId = (String) tabdata.get("facilityId");
					wsNumber = (String) tabdata.get("client_ip_address");
					patientId = (String) tabdata.get("patientId");
					reasonCode = (String) tabdata.get("reasonCode");
					reasonDesc = (String) tabdata.get("reasonDesc");
					alertFlag = (String) tabdata.get("alertFlag");
					docTypeCode = (String) tabdata.get("docTypeCode");		
					docNumber = Integer.parseInt((String)tabdata.get("docNumber"));
					local = (String) tabdata.get("local");
					receiptNatureCode = (String) tabdata.get("receiptNatureCode");
					episodeType = (String) tabdata.get("episodeType");
					episodeId = Integer.parseInt((String) tabdata.get("episodeId"));
					authFlag = (String) tabdata.get("authFlag");
					void_number = (String) tabdata.get("void_number");
					System.out.println("before void_number="+void_number);
					pstmt = con.prepareStatement("select distinct recpt_nature_code from bl_receipt_nature_lang_vw where  long_desc = '"+receiptNatureCode+"' AND upper(LANGUAGE_ID) = upper('"+local+"') "); 					
					ResultSet rst = pstmt.executeQuery();
					if(rst != null && rst.next()){
						receiptNatureCode = rst.getString("recpt_nature_code");
					}	
					System.out.println("after receiptNatureCode="+receiptNatureCode);
			    	cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cncl_rcpt_valchk_commit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
					cstmt.setString(1,facilityId);					
					cstmt.setString (2,docTypeCode);
					cstmt.setInt(3,docNumber);
					cstmt.setString(4,loginUser);		
					cstmt.setString (5,wsNumber);
					cstmt.setString(6,local );			
					cstmt.setString(7,receiptNatureCode);	
					cstmt.setString (8,episodeType);
					cstmt.setString(9,patientId);
					cstmt.setInt(10, episodeId);						
					cstmt.setString (11,authFlag);									
					cstmt.setString(12,reasonCode);				
					cstmt.setString(13,reasonDesc);										
					cstmt.setString (14,void_number);						
					//alertFlag="Y";
					cstmt.setString(15, alertFlag);
					cstmt.registerOutParameter(16, Types.VARCHAR);							
					cstmt.registerOutParameter (17, Types.VARCHAR);
					cstmt.registerOutParameter(18, Types.VARCHAR);
					cstmt.registerOutParameter(19, Types.VARCHAR);
					cstmt.registerOutParameter(20, Types.VARCHAR);
					System.out.println("before cstmt exe==facilityId="+facilityId+"-docTypeCode-"+docTypeCode+"-docNumber-"+docNumber+"-wsNumber-"+wsNumber+"-local-"+local);
					System.out.println("receiptNatureCode= in manager "+receiptNatureCode+"-episodeType-"+episodeType+"-patientId-"+patientId+"-authFlag-"+authFlag+"-reasonCode-"+reasonCode);
					System.out.println("reasonDesc="+reasonDesc+"-void_number-"+void_number+"-login_user="+loginUser);
					cstmt.execute();
					System.out.println("after cstmt exe");
					String printDeposit = cstmt.getString(16);
					String error_level  = cstmt.getString(17);
					String error_code = cstmt.getString(18);
					String error_text = cstmt.getString(19);
					String warning_msg = cstmt.getString(20);
					System.out.println("out cstmt exe");
					if(printDeposit==null) printDeposit="";						
					if(error_level==null) error_level="";	
					if(error_code==null) error_code="";
					if(error_text==null) error_text="";	
					if(warning_msg==null)warning_msg="";
					System.out.println("error_text="+error_text+"=error_level="+error_level+"=error_code="+error_code+"-printDeposit-"+printDeposit+"-warning_msg-"+warning_msg);
					
					if(error_text == "" && error_code=="" ){
						if(warning_msg != "") {
							retValue =docTypeCode+"/"+docNumber+":"+warning_msg;
						}
						con.commit();
						returnMap.put("retValue",retValue+"APP-SM0070 Operation Completed Successfully ....");
						System.err.println("commit");
					}else{
						System.out.println("in else for rollback error_level="+error_level);
						con.rollback();		
						if(error_code != "" && error_text != "" ) {
							
							retValue = docTypeCode+"/"+docNumber+":"+ error_code +":"+error_text;
						}else if(error_code != "" ){
							retValue =docTypeCode+"/"+docNumber+":"+ rb.getString(error_code);
						}else if( error_text != "") {
							retValue =docTypeCode+"/"+docNumber+":"+ error_text;
						}
						 if(warning_msg != "" ){
							retValue = retValue+"<br>"+warning_msg;
						}
					
						System.out.println("shikha in else 1 retValue="+retValue);
						returnMap.put("retValue",retValue);							
					}
			 }else if("checkForSubmitBulk".equals(mode)){		
			    	String printDeposit="" ;
    				String error_level="";
    				String error_code ="";
    				String error_text ="";
    				String warning_msg="";
			    	System.out.println("check for bulk submit");
			    	String retValue = "";
			    	String errorMsg="";
			  
			    	int errorCount = 0  ;
			    	int lastindx=0;			
			    	int error_code_text_yn = 0;
			    	lastindx = (Integer)tabdata.get("lastindx");			    	
			    	facilityId = (String) tabdata.get("facilityId");
			    	reasonCode = (String) tabdata.get("reasonCode");
			    	reasonDesc = (String) tabdata.get("reasonDesc");
		   			authFlag   = (String) tabdata.get("authFlag");
		   			loginUser = (String) tabdata.get("loginUser");
		   			wsNumber   = (String) tabdata.get("client_ip_address");
		   			locale     = (String) tabdata.get("locale");
		   			alertFlag  = (String) tabdata.get("alertFlag");		   		
		   			int error = 0;
	    			for (int i=1 ; i<=lastindx ; i++) {	
	    				if (errorCount == 10 ) 
	    					break;
	    				if(!".".equals((String) tabdata.get("docTypeCode"+i))) {
	    					
	    		  		docTypeCode  		= (String) tabdata.get("docTypeCode"+i);		    		  		
	    		  		docNumber			= Integer.parseInt((String) tabdata.get("docNumber"+i));		
	    		  		receiptNatureCode 	= (String) tabdata.get("receiptNatureCode"+i);
	    		  		void_number 			= (String) tabdata.get("void_number"+i);
	    				episodeType 		= (String) tabdata.get("episodeType"+i);		    				
	    				patientId 			= (String) tabdata.get("patientId"+i);	
	    				episodeId 			= Integer.parseInt((String) tabdata.get("episodeId"+i));	    	
System.out.println("facilityId="+facilityId+"-reasonCode="+reasonCode+"-reasonDesc="+reasonDesc+"-void_number="+void_number+"-authFlag="+authFlag+"-login_user="+loginUser);
System.out.println("wsNumber="+wsNumber+"-locale="+locale+"-alertFlag="+alertFlag+"-episodeId="+episodeId);
System.out.println("docTypeCode="+docTypeCode+"-docNumber="+docNumber+"-receiptNatureCode="+receiptNatureCode+"-episodeType="+episodeType+"-patientId="+patientId);
System.out.println("before receiptNatureCode="+receiptNatureCode);
						PreparedStatement pstmt1 = null;
						String quer = "select distinct recpt_nature_code from bl_receipt_nature_lang_vw where  long_desc = '"+receiptNatureCode+"' AND upper(LANGUAGE_ID) = upper('"+locale+"') ";
						 					
						
						pstmt1 = con.prepareStatement(quer);
						ResultSet rst1 = pstmt1.executeQuery();
						//System.out.println("before result set");
						if(rst1 != null && rst1.next()){
							
							receiptNatureCode = rst1.getString("recpt_nature_code");
						}	
						//System.out.println("after receiptNatureCode="+receiptNatureCode);

		    			cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cncl_rcpt_valchk_commit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
		    			System.out.println("procedure called");
		    			cstmt.setString(1, facilityId);					
	    				cstmt.setString(2,  docTypeCode);
	    				cstmt.setInt(3, docNumber);
						cstmt.setString(4, loginUser);		
	    				cstmt.setString(5,  wsNumber);
	    				cstmt.setString(6, locale);	
	    				cstmt.setString(7,receiptNatureCode);												
	    				cstmt.setString(8,  episodeType);
	    				cstmt.setString(9, patientId);
	    				cstmt.setInt(10, episodeId);			    				
	    				cstmt.setString (11,  authFlag);		    					
	    				cstmt.setString(12,reasonCode);		    			
	    				cstmt.setString(13,reasonDesc);		    				
	    				cstmt.setString (14,void_number);		    			
	    				cstmt.setString(15, alertFlag);    				
	    				cstmt.registerOutParameter(16, Types.VARCHAR);							
	    				cstmt.registerOutParameter (17, Types.VARCHAR);
	    				cstmt.registerOutParameter(18, Types.VARCHAR);
	    				cstmt.registerOutParameter(19, Types.VARCHAR);
	    				cstmt.registerOutParameter(20, Types.VARCHAR);
	    				System.out.println("void_number"+void_number);
						try{
							System.out.println("inside execute Receiptmaintmanager");
							cstmt.execute();
						}catch(Exception ex){
							System.out.println("exception in execute Receiptmaintmanager ="+ex);
							ex.printStackTrace();
						}
	    				System.out.println("after cstmt exe");
	    				 printDeposit =cstmt.getString(16);
	    				 error_level =cstmt.getString(17);
	    				 error_code =cstmt.getString(18);
	    				 error_text = cstmt.getString(19);
	    				 warning_msg =  cstmt.getString(20);
	    				System.out.println("out cstmt exe");
		    			if(printDeposit==null) printDeposit="";	
						if(error_code==null) error_code="";
						if(error_level==null) error_level="";	
						if(error_text==null) error_text="";	
						if(warning_msg==null)warning_msg="";
						System.out.println("error_text="+error_text+"=error_level="+error_level+"=error_code="+error_code+"-printDeposit-"+printDeposit+"-warning_msg-"+warning_msg);										
						
						if(error_code != "" || error_text != ""  ||warning_msg != "" ) {	
							errorMsg = errorMsg+docTypeCode+"/"+docNumber;
							if(error_code != "" && error_text != "" ) {	
								error = 1;							
								errorMsg = errorMsg+":"+error_code +":"+error_text;								
							}else if(error_code != "" ){
								error = 1;
								errorMsg = errorMsg+":"+rb.getString(error_code)	;													
							}else if( error_text != "") {
								error = 1;
								errorMsg = errorMsg+":"+error_text;																					
							}
							 if(warning_msg != "" ){								 							
								errorMsg = errorMsg+":"+warning_msg;		
							
							}
							 errorMsg +="<<";
								errorCount++;	
						}																																						
	    			}							
	    		}
	    			
	    			if(errorMsg == "") {	   
	    				con.commit();
						retValue = "C::Y::N";						
						System.err.println("commit with warning");
	    			}else {
	    				if(error ==0) {
	    					con.commit();
							retValue = "C::Y::"+errorMsg;
	    				}else{
	    				con.rollback(); System.err.println("rollback");
	    				retValue = "C::N::"+errorMsg;
	    				}
	    			}
	    			returnMap.put("retValue",retValue);	    		    			
			     }else if("CheckForReprint".equals(mode)){
			    	System.out.println("Reprint");					    	
					facilityId = (String) tabdata.get("facilityId");					
					wsNumber = (String) tabdata.get("client_ip_address");
					docTypeCode = (String) tabdata.get("docTypeCode");		
					docNumber = Integer.parseInt((String)tabdata.get("docNumber"));
					episodeType = (String) tabdata.get("episodeType");
					local = (String) tabdata.get("local");		
					reportOption = (String) tabdata.get("reportOption");
					System.out.println("in manager facilityId="+facilityId+"-docTypeCode="+docTypeCode+"-docNumber="+docNumber+"-local="+local+"-episodeType="+episodeType+"-reportOption="+reportOption+"-wsNumber="+wsNumber);
					String retValue = CheckForReprint(con);
					System.out.println("retValue12343-"+retValue);	
					returnMap.put("retValue",retValue);									
			    }
			    else if("CheckForReprintBulk".equals(mode)){
			    	System.out.println("CheckForReprintBulk");		    		  						
					String retValue = CheckForReprintBulk(tabdata,con);
					System.out.println("retValue bulk-"+retValue);	
					returnMap.put("retValue",retValue);						
			    }
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception e1){
				System.out.println("exception="+e1);
			}
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
		
		return returnMap;
	}
	
	

public String CheckForReprint(Connection con){
	System.out.println("in method checkforreprint");
	String pgimId_R = null;
	String sessionId_R = null;
	String pgimDate_R = null;
	String pgimId_C = null;
	String sessionId_C = null;
	String pgimDate_C = null;
	String pgimId_A1 = null;
	String sessionId_A1 = null;
	String pgimDate_A1 = null;
	String pgimId_A2 = null;
	String sessionId_A2 = null;
	String pgimDate_A2 = null;
	String errorId = null;
	String errorText = null; 
	String output = null;
	//Connection con = null;
	CallableStatement cstmt= null ;
	try{				
		//con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		 /* Object[] receiptNumbersArr   = new Object[3];
		 receiptNumbersArr[0] = docTypeCode;
		 receiptNumbersArr[1] = docNumber;
		 receiptNumbersArr[2] = episodeType;      
        StructDescriptor recDescriptor =  StructDescriptor.createDescriptor("REC_DOC_NUMBERS",con);
         STRUCT oracle_record = new STRUCT(recDescriptor, con, receiptNumbersArr);         
         Object array[] = {oracle_record};          
         ArrayDescriptor des = ArrayDescriptor.createDescriptor("REC_DTLS", con);
         ARRAY DocNumbersArr = new ARRAY(des,con,array);
         System.out.println(Arrays.asList(DocNumbersArr));
         System.out.println("receiptNumbersArr[0]-"+receiptNumbersArr[0]+"-receiptNumbersArr[1]-"+receiptNumbersArr[1]+"-receiptNumbersArr[2]-"+receiptNumbersArr[2]);
     	*/
		//V231129 BL-RBU-GHL-CRF-0023
		 StringBuffer doc_typ_code = new StringBuffer();
		 StringBuffer docNum = new StringBuffer();
		 StringBuffer episode_type = new StringBuffer();
		 System.out.println("469 manager "+docTypeCode+"/ "+docNumber+" /"+episodeType);
		 if(!"".equals(docTypeCode)){
			 doc_typ_code.append(docTypeCode).append("|");
		 }else{
			 doc_typ_code.append(" |");
		 }
		 if(!"".equals(docNumber)){
			 docNum.append(docNumber).append("|");
		 }else{
			 docNum.append(" |");
		 }
		 if(!"".equals(episodeType)){
			 episode_type.append(episodeType).append("|");
		 }else{
			 episode_type.append(" |");
		 }
		
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cancel_receipt_print(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);
		//cstmt.setArray(2,DocNumbersArr);		
		cstmt.setString(2,doc_typ_code.toString());
		cstmt.setString(3,docNum.toString());
		cstmt.setString(4,episode_type.toString());
		
		cstmt.setString(5,reportOption);
		cstmt.setString(6, local);
		cstmt.setString(7,wsNumber);
		cstmt.registerOutParameter(8, Types.VARCHAR);
		cstmt.registerOutParameter(9, Types.VARCHAR);
		cstmt.registerOutParameter(10, Types.VARCHAR);
		cstmt.registerOutParameter(11, Types.VARCHAR);
		cstmt.registerOutParameter(12, Types.VARCHAR);
		cstmt.registerOutParameter(13, Types.VARCHAR);
		cstmt.registerOutParameter(14, Types.VARCHAR);
		cstmt.registerOutParameter(15, Types.VARCHAR);
		cstmt.registerOutParameter(16, Types.VARCHAR);
		cstmt.registerOutParameter(17, Types.VARCHAR);
		cstmt.registerOutParameter(18, Types.VARCHAR);
		cstmt.registerOutParameter(19, Types.VARCHAR);	
		cstmt.registerOutParameter(20, Types.VARCHAR);
		cstmt.registerOutParameter(21, Types.VARCHAR);
		
		System.out.println("before exe");
		cstmt.execute();
		System.out.println("after exe");

		pgimId_R = cstmt.getString(8);
		sessionId_R = cstmt.getString(9);
		pgimDate_R = cstmt.getString(10);
		pgimId_C = cstmt.getString(11);
		sessionId_C = cstmt.getString(12);
		pgimDate_C = cstmt.getString(13);
		pgimId_A1 = cstmt.getString(14);
		sessionId_A1 = cstmt.getString(15);
		pgimDate_A1 = cstmt.getString(16);
		pgimId_A2 = cstmt.getString(17);
		sessionId_A2 = cstmt.getString(18);
		pgimDate_A2 = cstmt.getString(19);
		errorId = cstmt.getString(20);
		errorText = cstmt.getString(21);
		if (errorId == null ) errorId = "";
		if (errorText == null) errorText = "";
		if (errorId == "" && errorText == ""){
			con.commit();
			System.err.println("commit");					
		}
		else{
			con.rollback();
			System.err.println("rollback");							
		}
		if (pgimId_R == null ) pgimId_R = "";
		if (sessionId_R == null) sessionId_R = "";
		if (pgimDate_R == null ) pgimDate_R = "";
		if (pgimId_C == null) pgimId_C = "";
		if (sessionId_C == null ) sessionId_C = "";
		if (pgimDate_C == null) pgimDate_C = "";
		if (pgimId_A1 == null ) pgimId_A1 = "";
		if (sessionId_A1 == null) sessionId_A1 = "";
		if (pgimDate_A1 == null ) pgimDate_A1 = "";
		if (pgimId_A2 == null) pgimId_A2 = "";
		if (sessionId_A2 == null ) sessionId_A2 = "";
		if (pgimDate_A2 == null) pgimDate_A2 = "";
	
		output=pgimId_R +"::"+sessionId_R +"::"+pgimDate_R +"::"+pgimId_C+"::"+sessionId_C+"::"+pgimDate_C+"::"+pgimId_A1+"::"+sessionId_A1+"::"+pgimDate_A1+"::"+pgimId_A2+"::"+sessionId_A2+"::"+pgimDate_A2+"::"+errorId+"::"+errorText+"::E" ;
		System.out.println("output--"+output);
		//System.out.println(pgimId_R +sessionId_R +pgimDate_R +pgimId_C +sessionId_C +pgimDate_C +pgimId_A1 +sessionId_A1 +pgimDate_A1 +pgimId_A2 +sessionId_A2 +pgimDate_A2 +errorId +errorText );
	}catch(SQLException e){
		System.err.println("error--"+e);
	}/*finally{
		ConnectionManager.returnConnection(con);
	}*/
	return output;	
}


public String CheckForReprintBulk(java.util.HashMap tabdata,Connection con){
	facilityId   		= (String)tabdata.get("facilityId");				
	reportOption        = (String)tabdata.get("reportOption");		
	wsNumber			= (String)tabdata.get("client_ip_address");
	local 				= (String)tabdata.get("local");
	int lastindx = (Integer)tabdata.get("lastindx");
	int countReceipt = (Integer)tabdata.get("countReceipt"); 
	
	System.out.println(facilityId+" "+locale+" "+wsNumber+" "+reportOption);
	String pgimId_R = null;
	String sessionId_R = null;
	String pgimDate_R = null;
	String pgimId_C = null;
	String sessionId_C = null;
	String pgimDate_C = null;
	String pgimId_A1 = null;
	String sessionId_A1 = null;
	String pgimDate_A1 = null;
	String pgimId_A2 = null;
	String sessionId_A2 = null;
	String pgimDate_A2 = null;
	String errorId = null;
	String errorText = null; 
	//Connection con = null;
	CallableStatement cstmt= null ;
	String output="R::";
	try{						
		//con = ConnectionManager.getConnection();
		con.setAutoCommit(false);		
		//V231129 BL-RBU-GHL-CRF-0023
		StringBuffer doc_typ_code = new StringBuffer();
		 StringBuffer docNum = new StringBuffer();
		 StringBuffer episode_type = new StringBuffer();
		  String docTypCode="",docNumbr="",episodeType="";
		 System.out.println("lastindx="+lastindx);
		for (int i=1,j=0;i<=lastindx;i++) {	
			System.out.println("(String)tabdata.get(docTypeCode+i)"+(String)tabdata.get("docTypeCode"+i)+"--i="+i+"--j="+j);
			 //if(!".".equals((String)tabdata.get("docTypeCode"+i))){
			if(!"".equals((String)tabdata.get("docTypeCode"+i))){
				 docTypCode=replaceNull((String)tabdata.get("docTypeCode"+i));
				 if(!"".equals(docTypCode)){
					 doc_typ_code.append(docTypCode).append("|");
				 }else{
					 doc_typ_code.append(" ").append("|");
				 }
				
				 docNumbr=replaceNull((String)tabdata.get("docNumber"+i));
				 if(!"".equals(docNumbr)){
					 docNum.append(docNumbr).append("|");
				 }else{
					 docNum.append(" ").append("|");
				 }
				
				 episodeType=replaceNull((String)tabdata.get("episodeType"+i));
				 if(!"".equals(episodeType)){
					 episode_type.append(episodeType).append("|");
				 }else{
					 episode_type.append(" ").append("|");
				 }
			}else{
				 doc_typ_code.append(" ").append("|");
				 docNum.append(" ").append("|");
				 episode_type.append(" ").append("|");
			 }
		}
		//RBU-GHL-CRF-0021 V231129
		System.out.println("632 manager "+doc_typ_code.toString()+" "+docNum.toString()+" "+episode_type.toString());
		
		//ARRAY DocNumbersArr1 = new ARRAY(des,con,DocNumbersArr);
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cancel_receipt_print(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);
		//cstmt.setArray(2,DocNumbersArr1); 
		//RBU-GHL-CRF-0021 V231129
		cstmt.setString(2,doc_typ_code.toString());
		cstmt.setString(3, docNum.toString());
		cstmt.setString(4, episode_type.toString());
		
		cstmt.setString(5,reportOption);
		cstmt.setString(6, locale);
		cstmt.setString(7,wsNumber);
		cstmt.registerOutParameter(8, Types.VARCHAR);
		cstmt.registerOutParameter(9, Types.VARCHAR);
		cstmt.registerOutParameter (10, Types.VARCHAR);
		cstmt.registerOutParameter(11, Types.VARCHAR);
		cstmt.registerOutParameter(12, Types.VARCHAR);
		cstmt.registerOutParameter(13, Types.VARCHAR);
		cstmt.registerOutParameter (14, Types.VARCHAR);
		cstmt.registerOutParameter(15, Types.VARCHAR);
		cstmt.registerOutParameter(16, Types.VARCHAR);
		cstmt.registerOutParameter(17, Types.VARCHAR);
		cstmt.registerOutParameter (18, Types.VARCHAR);
		cstmt.registerOutParameter(19, Types.VARCHAR);
		cstmt.registerOutParameter(20, Types.VARCHAR);
		cstmt.registerOutParameter(21, Types.VARCHAR);
		
		cstmt.execute();
		pgimId_R = cstmt.getString(8);
		sessionId_R = cstmt.getString(9);
		pgimDate_R = cstmt.getString(10);
		pgimId_C = cstmt.getString(11);
		sessionId_C = cstmt.getString(12);
		pgimDate_C = cstmt.getString(13);
		pgimId_A1 = cstmt.getString(14);
		sessionId_A1 = cstmt.getString(15);
		pgimDate_A1 = cstmt.getString(16);
		pgimId_A2 = cstmt.getString(17);
		sessionId_A2 = cstmt.getString(18);
		pgimDate_A2 = cstmt.getString(19);
		errorId = cstmt.getString(20);
		errorText = cstmt.getString(21);
		if (errorId == null ) errorId = "";
		if (errorText == null) errorText = "";
		
		if (errorId == "" && errorText == ""){
			con.commit();
			output=output+"Y::";
			System.err.println("commit");					
		}
		else{
			con.rollback();
			output=output+"N::"+errorId+"::"+errorText ;
			System.err.println("rollback");							
		}
		if (pgimId_R == null ) pgimId_R = "";
		if (sessionId_R == null) sessionId_R = "";
		if (pgimDate_R == null ) pgimDate_R = "";
		if (pgimId_C == null) pgimId_C = "";
		if (sessionId_C == null ) sessionId_C = "";
		if (pgimDate_C == null) pgimDate_C = "";
		if (pgimId_A1 == null ) pgimId_A1 = "";
		if (sessionId_A1 == null) sessionId_A1 = "";
		if (pgimDate_A1 == null ) pgimDate_A1 = "";
		if (pgimId_A2 == null) pgimId_A2 = "";
		if (sessionId_A2 == null ) sessionId_A2 = "";
		if (pgimDate_A2 == null) pgimDate_A2 = "";
		
	
		output=pgimId_R +"::"+sessionId_R +"::"+pgimDate_R +"::"+pgimId_C+"::"+sessionId_C+"::"+pgimDate_C+"::"+pgimId_A1+"::"+sessionId_A1+"::"+pgimDate_A1+"::"+pgimId_A2+"::"+sessionId_A2+"::"+pgimDate_A2+"::"+errorId+"::"+errorText+"::E" ;
		System.out.println("output---"+output);
	}catch(SQLException e){
		System.err.println("error--"+e);
	}/*finally{
		ConnectionManager.returnConnection(con);
	}*/
	return output;	
	
}

public String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";	
	}
	return input;
}
	
}
