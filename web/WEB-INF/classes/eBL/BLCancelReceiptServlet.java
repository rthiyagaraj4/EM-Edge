/**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
 */

package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.eslp.ServiceLocator;
/*import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;*/
import webbeans.eCommon.ConnectionManager;

public class BLCancelReceiptServlet extends javax.servlet.http.HttpServlet {
	//private static final long serialVersionUID = 1L; //commented V210416
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String locale = "";
	String facility_id = "";
	HttpSession session;
	String mode="";
	String loginUser;
	String local;
	String docTypeCode;
	String docNumber;
	String reasonCode;
	String reasonDesc;
	String docDate;
	String receiptNatureCode;
	String receiptTypeCode;
	float docAmount;
	String patientId;
	String episodeType;
	String episodeId;
	String visitId;
	String reportOption;
	String authFlag;
	String voidNumber;
	String void_number;
	String wsNumber;
	String alertFlag;
	PrintWriter out = null;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
     
	Locale loc = null;
	ResourceBundle rb = null;
	
    public BLCancelReceiptServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		
	try{
		HttpSession session=request.getSession(false);
		locale = (String)session.getAttribute("LOCALE");
		loc = new Locale(locale);
		rb = ResourceBundle.getBundle("eSM.resources.Messages",loc);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
		boolean local_ejbs = false;
		String mode = replaceNull(request.getParameter("mode"));
		String retValue = "";
		 out = response.getWriter();
	
		
		String locale = this.p.getProperty("LOCALE") ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		if ((getServletConfig().getServletContext().getInitParameter(
				"LOCAL_EJBS") != null)
				&& (getServletConfig().getServletContext()
						.getInitParameter("LOCAL_EJBS")
						.equalsIgnoreCase("TRUE"))) {
			local_ejbs = true;
		}
		Object home = ServiceLocator.getInstance().getHome(
				"java:comp/env/ReceiptMaintenance",eBL.ReceiptMaintenance.ReceiptMaintenanceHome.class, local_ejbs);
		Object busObj = (home.getClass().getMethod("create")).invoke(home);
		HashMap results = new HashMap();
		HashMap tabData = new HashMap();
		
		Object argArray[]  = new Object[2];
		argArray[0] = tabData;	
		argArray[1] = p;
		Class [] paramArray	   = new Class[2];
		paramArray[0] = tabData.getClass();
		paramArray[1] = p.getClass();
	   if("checkForSubmit".equals(mode)){
		   reasonCode 		= replaceNull(request.getParameter("cancel_reasoncode"));			
			reasonDesc 		= replaceNull(request.getParameter("cancel_reason"));
			alertFlag 		= replaceNull(request.getParameter("p_alert_flag"));
			facilityId   	= replaceNull(request.getParameter("facilityId"));
			docTypeCode  	= replaceNull(request.getParameter("docTypeCode"));
			docNumber 		= replaceNull(request.getParameter("docNum"));
			loginUser   	= replaceNull(request.getParameter("login_user"));
			local  			= replaceNull(request.getParameter("language_id"));
			receiptNatureCode= replaceNull(request.getParameter("recpt_nature_code"));
			episodeType		= replaceNull(request.getParameter("episode_type"));
			patientId		= replaceNull(request.getParameter("patient_id"));			
			episodeId 		= replaceNull(request.getParameter("episode_id"));				
			authFlag 		= replaceNull(request.getParameter("auth_flag"));				
			void_number		= replaceNull(request.getParameter("voidNumber"));			
			
			if(episodeId.length() == 0 ){
				episodeId = "0";
			}
	
			tabData.put("facilityId", facility_id);
			tabData.put("loginUser", loginUser);
			tabData.put("client_ip_address", client_ip_address);
			tabData.put("mode",mode);
			tabData.put("patientId", patientId);
			tabData.put("reasonCode", reasonCode);
			tabData.put("reasonDesc", reasonDesc);
			tabData.put("alertFlag", alertFlag );
			tabData.put("docTypeCode",docTypeCode  );
			tabData.put("docNumber", docNumber );
			tabData.put("local", local  );
			tabData.put("receiptNatureCode", receiptNatureCode   );
			tabData.put("episodeType", episodeType);
			tabData.put("episodeId",episodeId );
			tabData.put("authFlag", authFlag );
			tabData.put("void_number", void_number);
			tabData.put("wsNumber",wsNumber);
		
		  results=(HashMap) (busObj.getClass().getMethod("insertEncounterDetails",paramArray)).invoke(busObj, argArray);
			//String error = ""; //commented V210416
			String mapValue = "";
			//int err_val = 1; //commented V210416
		
			for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if("retValue".equals(type)){
					mapValue = (String) results.get(type);
					if(mapValue != null){
						out.println(mapValue);
					}
				}
			}					
		}
		else if("checkForSubmitBulk".equals(mode)){	   
			int lastindx = Integer.parseInt(request.getParameter("lastindx"));
			int countReceipt = 0;
			for (int i=1;i<=lastindx;i++) {					
				 if(!"".equals(request.getParameter("doc_typ_code"+i))){
					 countReceipt++;
				 }			                   
			}
			locale = (String)session.getAttribute("LOCALE");
			loginUser = request.getParameter("login_user");
			
			reasonCode = replaceNull(request.getParameter("cancel_reasoncode"));			
			reasonDesc = replaceNull(request.getParameter("cancel_reason"));	   			   	
			authFlag   = replaceNull(request.getParameter("auth_flag"));
			facilityId = replaceNull(request.getParameter("facilityId"));
			alertFlag 		= replaceNull(request.getParameter("p_alert_flag"));
			tabData.put("mode",mode);
			tabData.put("reasonCode",reasonCode);
			tabData.put("reasonDesc",reasonDesc);
			
			tabData.put("authFlag",authFlag);
			tabData.put("facilityId",facilityId);
			tabData.put("loginUser",loginUser);
			tabData.put("client_ip_address", client_ip_address);
			tabData.put("locale",locale);
			tabData.put("alertFlag",alertFlag);
			tabData.put("lastindx",lastindx);
			tabData.put("countReceipt",countReceipt);
			//boolean status = true; //commented V210416
			//String strError = ""; //commented V210416
			for (int i=1 ; i<=lastindx ; i++) {		
				if (!"".equals(request.getParameter("doc_typ_code"+i)) && request.getParameter("doc_typ_code"+i) != null ){
				tabData.put("docTypeCode"+i,request.getParameter("doc_typ_code"+i));	  		
				tabData.put("docNumber"+i,request.getParameter("doc_num"+i));   		  		
				tabData.put("receiptNatureCode"+i,request.getParameter("Recpt_Nature_Code"+i));
				tabData.put("episodeType"+i,request.getParameter("episode_type"+i));			
				tabData.put("patientId"+i,request.getParameter("patient_id"+i));
				tabData.put("void_number"+i,request.getParameter("void_number"+i));	
				episodeId = replaceNull((request.getParameter("episode_id"+i)));
					  
				if(episodeId.length() == 0 ){
					episodeId = "0";
				}					
			//	tabData.put("episodeId"+i,request.getParameter("episode_id"+i));
				tabData.put("episodeId"+i,episodeId);
				}else{
					tabData.put("docTypeCode"+i,".");		    		  		
					tabData.put("docNumber"+i,".");		    		  		
					tabData.put("receiptNatureCode"+i,".");
					tabData.put("episodeType"+i,".");		    				
					tabData.put("patientId"+i,".");	
					tabData.put("episodeId"+i,".");
					tabData.put("void_number"+i,".");
				}
			}
			results=(HashMap) (busObj.getClass().getMethod("insertEncounterDetails",paramArray)).invoke(busObj, argArray);
		   // String error = ""; //commented V210416
			//String mapValue = ""; //commented V210416
		
			//int err_val = 1; //commented V210416
			for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if("retValue".equals(type)){
					System.out.println("in if");
					retValue = (String) results.get("retValue");								
				}
			}
			
			retValue = java.net.URLEncoder.encode(retValue, "UTF-8" );
			response.sendRedirect("../eBL/jsp/BLReceiptResponse.jsp?retValue="+retValue);		
		}else if("CheckForReprint".equals(mode)){
				facilityId  = replaceNull(request.getParameter("facilityId"));
				docTypeCode = replaceNull(request.getParameter("docTypeCode"));
				docNumber 	= replaceNull(request.getParameter("docNum"));				
				local  		= replaceNull(request.getParameter("language_id"));					
				episodeType	= replaceNull(request.getParameter("episode_type"));			
				reportOption= replaceNull(request.getParameter("print_option"));
				tabData.put("facilityId", facility_id);
				tabData.put("client_ip_address", client_ip_address);
				tabData.put("mode",mode);					
				tabData.put("docTypeCode",docTypeCode  );
				tabData.put("docNumber", docNumber );
				tabData.put("local", local  );
				tabData.put("episodeType", episodeType);					
				tabData.put("wsNumber",wsNumber);
				tabData.put("reportOption", reportOption);	
				results=(HashMap) (busObj.getClass().getMethod("insertEncounterDetails",paramArray)).invoke(busObj, argArray);
				 //   String error = ""; //commented V210416
				//	String mapValue = ""; //commented V210416
					
					//int err_val = 1; //commented V210416
					for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if("retValue".equals(type)){
							retValue = (String) results.get("retValue");						
						}
					}
			out.println(retValue);					
		}else if("CheckForReprintBulk".equals(mode)){			
			String facilityId = replaceNull(request.getParameter("facilityId"));
			reportOption	  = replaceNull(request.getParameter("print_option"));	
			int countReceipt = 0;
			int lastindx = Integer.parseInt(request.getParameter("lastindx"));
			tabData.put("client_ip_address",client_ip_address);
			tabData.put("local",locale);
			tabData.put("reportOption",reportOption);
			tabData.put("facilityId",facilityId);		
			tabData.put("mode",mode );
			tabData.put("lastindx", lastindx);
		
			for (int i=1;i<=lastindx;i++) {	
			if(!"".equals(request.getParameter("doc_typ_code"+i)) && request.getParameter("doc_typ_code"+i) != null){
				countReceipt++;
				tabData.put("docTypeCode"+i,request.getParameter("doc_typ_code"+i));			
				tabData.put("docNumber"+i,request.getParameter("doc_num"+i));			 
				tabData.put("episodeType"+i,request.getParameter("episode_type"+i));              
				}else {
					 System.out.println("in else i="+i);
					 tabData.put("docTypeCode"+i,".");			
					  tabData.put("docNumber"+i,".");			 
					  tabData.put("episodeType"+i,"."); 
				 }	    				 
			}
			tabData.put("countReceipt",countReceipt);		
			 results=(HashMap) (busObj.getClass().getMethod("insertEncounterDetails",paramArray)).invoke(busObj, argArray);
				//String error = ""; //commented V210416
				//String mapValue = "";		//commented V210416			
				//int err_val = 1; //commented V210416
				for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					if("retValue".equals(type)){
						retValue = (String) results.get("retValue");							
					}
				}
				retValue = retValue+"::"+reportOption+"::"+facilityId+"::"+locale;
				response.sendRedirect("../eBL/jsp/BLReceiptResponse.jsp?retValue="+retValue);	
			}   		  						
		}catch(Exception e){
			System.err.println("Exception in Cancel Receipt Servlet->"+e);
			e.printStackTrace();
		}							
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public String CheckForReprint(HttpServletRequest request,String locale,String ws_no,String printOption){
		String facilityId = replaceNull(request.getParameter("facilityId"));
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
		Connection con = null;
		CallableStatement cstmt= null ;
		try{						
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			/* Object[] receiptNumbersArr   = new Object[3];
			 receiptNumbersArr[0] = replaceNull(request.getParameter("doc_typ_code"));
			 receiptNumbersArr[1] = Integer.parseInt(request.getParameter("docNum"));
			 receiptNumbersArr[2] = replaceNull(request.getParameter("episode_type"));      
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
			 System.out.println(facilityId+" "+locale+" "+ws_no+" "+printOption);
		
			 String docTypCode = replaceNull(request.getParameter("doc_typ_code"));
			 String docNumbr = replaceNull(request.getParameter("docNum"));
			 String episodeType = replaceNull(request.getParameter("episode_type"));   
			 if(!"".equals(docTypCode)){
				 doc_typ_code.append(docTypCode).append("|");
			 }else{
				 doc_typ_code.append(" |");
			 }
			 if(!"".equals(docNumbr)){
				 docNum.append(docNumbr).append("|");
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
			//V231129 BL-RBU-GHL-CRF-0023
			cstmt.setString(5,printOption);
			cstmt.setString(6, locale);
			cstmt.setString(7,ws_no);
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
			}
			else{
				con.rollback();
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
		}catch(SQLException e){
			System.err.println("error--"+e);
			e.printStackTrace();
		}finally{
			try{
				ConnectionManager.returnConnection(con);
				if(cstmt != null) {
					cstmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return output;	
	}
	
	public String CheckForReprintBulk(HttpServletRequest request,String locale,String ws_no,String printOption){
		String facilityId = replaceNull(request.getParameter("facilityId"));
		int lastindx = Integer.parseInt(request.getParameter("lastindx"));
		System.out.println(facilityId+" "+locale+" "+ws_no+" "+printOption);
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
		Connection con = null;
		CallableStatement cstmt= null ;
		String output="R::";
		try{						
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			int countReceipt = 0;
			for (int i=1;i<=lastindx;i++) {					
				 if(!"".equals(request.getParameter("doc_typ_code"+i))){
					 countReceipt++;
				 }			                   
			}
			/*Object[] receiptNumbersArr   = new Object[3];
			 Object[] DocNumbersArr = new Object[countReceipt];
			StructDescriptor recDescriptor =  StructDescriptor.createDescriptor("REC_DOC_NUMBERS",con);
			ArrayDescriptor des = ArrayDescriptor.createDescriptor("REC_DTLS", con);			
			*/
			//V231129 BL-RBU-GHL-CRF-0023
			 StringBuffer doc_typ_code = new StringBuffer();
			 StringBuffer docNum = new StringBuffer();
			 StringBuffer episode_type = new StringBuffer();
			 System.out.println("511"+facilityId+" "+locale+" "+ws_no+" "+printOption);
			 String docTypCode="",docNumbr="",episodeType="";
			 
			for (int i=1,j=0;i<=lastindx;i++) {	
				 if(!"".equals(request.getParameter("doc_typ_code"+i))){
				/* receiptNumbersArr[0] = replaceNull(request.getParameter("doc_typ_code"+i));			
				 receiptNumbersArr[1] = Integer.parseInt(request.getParameter("doc_num"+i));			 
				 receiptNumbersArr[2] = replaceNull(request.getParameter("episode_type"+i));      			
	       		*/ /*STRUCT oracle_record = new STRUCT(recDescriptor, con, receiptNumbersArr);         
	        	 DocNumbersArr[j++] = oracle_record; */                 
					 docTypCode=replaceNull(request.getParameter("doc_typ_code"+i));
					 if(!"".equals(docTypCode)){
						 doc_typ_code.append(docTypCode).append("|");
					 }else{
						 doc_typ_code.append(" ").append("|");
					 }
					
					 docNumbr=replaceNull(request.getParameter("doc_num"+i));
					 if(!"".equals(docNumbr)){
						 docNum.append(docNumbr).append("|");
					 }else{
						 docNum.append(" ").append("|");
					 }
					
					 episodeType=replaceNull(request.getParameter("episode_type"+i));
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
			
		//	ARRAY DocNumbersArr1 = new ARRAY(des,con,DocNumbersArr);
			cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cancel_receipt_print(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			//cstmt.setArray(2,DocNumbersArr1);
			cstmt.setString(2,doc_typ_code.toString());
			cstmt.setString(3,docNum.toString());
			cstmt.setString(4,episode_type.toString());
			//V231129 BL-RBU-GHL-CRF-0023
			cstmt.setString(5,printOption);
			cstmt.setString(6, locale);
			cstmt.setString(7,ws_no);
			cstmt.registerOutParameter (8, Types.VARCHAR);
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
			}
			else{
				con.rollback();
				output=output+"N::"+errorId+"::"+errorText ;
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
		}catch(SQLException e){
			System.err.println("error--"+e);
			e.printStackTrace();
		}finally{
			try{
				ConnectionManager.returnConnection(con);
				if(cstmt != null) {
					cstmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return output;		
	}

	public String replaceNull(String input){
		if(input == null || "null".equals(input)){
			input = "";	
		}
		return input;
	}
}
