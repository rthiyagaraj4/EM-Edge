package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.Common.BlRepository;
import java.sql.*;
import java.util.*;
import java.sql.Types;
import webbeans.eCommon.ConnectionManager;

public final class __blreceiptcancelpackagevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/ebl/jsp/BLReceiptCancelPackageValidation.jsp", 1733829071055L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


public String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";	
	}
	return input;
}


public String checkForFirstAlert(String facilityId,String docTypeCode,int docNum){
	Connection con = null;
	CallableStatement cstmt= null ;
	String output = "";
	String alert_flag="";       
    String error_level="";       
    String error_code="";         
    String error_text="";
    String warning_msg="";
	try{		
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_rcpt_cr_card_pymt_chk1(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);							
		cstmt.setString (2,  docTypeCode);
		cstmt.setInt(3, docNum);				
		cstmt.registerOutParameter(4, Types.VARCHAR);							
		cstmt.registerOutParameter (5, Types.VARCHAR);
		cstmt.registerOutParameter(6, Types.VARCHAR);
		cstmt.registerOutParameter(7, Types.VARCHAR);
		cstmt.registerOutParameter(8, Types.VARCHAR);
		cstmt.execute();
		alert_flag=cstmt.getString(4);
		error_code=cstmt.getString(5);
		error_level=cstmt.getString(6);
		error_text = replaceNull(cstmt.getString(7));	
		warning_msg=cstmt.getString(8);
		output = alert_flag+"::"+error_text;
	
	}
	catch (SQLException e) {
		System.err.println("Exception ->"+e);
	}
	finally{
		ConnectionManager.returnConnection(con);
	}
	return output;
}


public String checkForSecondAlert(String facilityId,String docType,int docNum,String locale){
	Connection con = null;
	CallableStatement cstmt= null ;
	String output = "";
	String alert_flag="";       
    String error_level="";       
    String error_code="";         
    String error_text=""; 
    String warning_msg="";
	try{
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_rcpt_cr_card_pymt_chk2(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);							
		cstmt.setString (2,  docType);
		cstmt.setInt(3, docNum);
		cstmt.setString (4, locale);									
		cstmt.registerOutParameter (5, Types.VARCHAR);
		cstmt.registerOutParameter(6, Types.VARCHAR);
		cstmt.registerOutParameter(7, Types.VARCHAR);
		cstmt.registerOutParameter(8, Types.VARCHAR);
		cstmt.registerOutParameter(9, Types.VARCHAR);
		cstmt.execute();
		alert_flag=cstmt.getString(5);
		error_code=cstmt.getString(6);
		error_level=cstmt.getString(7);
		error_text = replaceNull(cstmt.getString(8));
		warning_msg=cstmt.getString(9);
		output = alert_flag+"::"+error_text;
		System.out.println("outputoutput=="+output);
	}
	catch (SQLException e) {
		System.err.println("Exception ->"+e);
	}
	finally{
		ConnectionManager.returnConnection(con);
	}
	return output;
}



public String CheckForReprint(HttpServletRequest request,String locale,String ws_no,String printOption){
	String facilityId = request.getParameter("facilityId");
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
		//V231129 BL-RBU-GHL-CRF-0023
		 StringBuffer doc_typ_code = new StringBuffer();
		 StringBuffer docNum = new StringBuffer();
		 StringBuffer episode_type = new StringBuffer();
		  
		String doctypcode=request.getParameter("doc_typ_code")==null?" ":request.getParameter("doc_typ_code");
		 doc_typ_code.append(doctypcode).append("|");
		 String docNumbr=request.getParameter("docNum")==null?" ":request.getParameter("docNum");
		 docNum.append(docNumbr).append("|");
		 String episodetype=request.getParameter("episode_type")==null?" ":request.getParameter("episode_type");
		 episode_type.append(episodetype).append("|");
		  System.out.println("BLReceiptCancelPackageValidation.jsp 140 ");
        // System.out.println("receiptNumbersArr[0]-"+receiptNumbersArr[0]+"-receiptNumbersArr[1]-"+receiptNumbersArr[1]+"-receiptNumbersArr[2]-"+receiptNumbersArr[2]);
     	 System.out.println(doc_typ_code.toString()+" "+docNum.toString()+" "+episode_type.toString()+" 161");
			
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cancel_receipt_print(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);
		cstmt.setString(2,doc_typ_code.toString());
		cstmt.setString(3,docNum.toString());
		cstmt.setString(4,episode_type.toString());
		
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
	}catch(SQLException e){
		System.err.println("error--"+e);
	}finally{
		ConnectionManager.returnConnection(con);
	}
	return output;	
}



public String CheckForReprintBulk(HttpServletRequest request,String locale,String ws_no,String printOption){
	String facilityId = request.getParameter("facilityId");
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
		//Object[] receiptNumbersArr   = new Object[3];
		//V231129 BL-RBU-GHL-CRF-0023
		StringBuffer doc_typ_code = new StringBuffer();
		StringBuffer docNum = new StringBuffer();
		StringBuffer episode_type = new StringBuffer();
		String docTypCode="",docNumbr="",episodeType="";
		for (int i=1,j=0;i<=lastindx;i++) {	
			 if(!"".equals(request.getParameter("doc_typ_code"+i))){
				 docTypCode=request.getParameter("doc_typ_code"+i)==null?" ":request.getParameter("doc_typ_code"+i);
				 doc_typ_code.append(docTypCode).append("|");
				 docNumbr=request.getParameter("doc_num"+i)==null?" ":request.getParameter("doc_num"+i);
				 docNum.append(docNumbr).append("|");
				 episodeType=request.getParameter("episode_type"+i)==null?" ":request.getParameter("episode_type"+i);
				 episode_type.append(episodeType).append("|");
			 }else{
				 doc_typ_code.append(" ").append("|");
				 docNum.append(" ").append("|");
				 episode_type.append(" ").append("|");
			 }
		}//V231129
		System.out.println(doc_typ_code.toString()+" "+docNum.toString()+" "+episode_type.toString()+" 284");
		//ARRAY DocNumbersArr1 = new ARRAY(des,con,DocNumbersArr);
		cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cancel_receipt_print(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, facilityId);
		//cstmt.setArray(2,DocNumbersArr1);
		cstmt.setString(2,doc_typ_code.toString());
		cstmt.setString(3,docNum.toString());
		cstmt.setString(4,episode_type.toString());
		//V231129
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
		cstmt.registerOutParameter(18, Types.VARCHAR);
		cstmt.registerOutParameter(19, Types.VARCHAR);
		cstmt.registerOutParameter (20, Types.VARCHAR);
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
	}catch(SQLException e){
		System.err.println("error--"+e);
	}finally{
		ConnectionManager.returnConnection(con);
	}
	return output;	
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

System.out.println("shikha jsp");
String errorFlag =null;
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	System.out.println("111111111111");
	String locale = (String)session.getAttribute("LOCALE"); 
	String alert_flag="";       
    String error_level="";       
    String error_code="";         
    String error_text="";
    String pgm_id="";       
    String pgm_date="";       
    String session_id="";            
    String error_id="";            
    java.util.Properties prop; 
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String ws_no = prop.getProperty("client_ip_address") ;	
	try{
		
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
		    String facilityId = null; 	  	   
		    String docTypeCode = null;
		    int docNum = 0;	
		    String login_user = null;		   
		    String language_id = null;
		    String recpt_nature_code = null;
		    String episode_type = null;
		    int episode_id = 0;	
		    String patient_id = null;
		    String auth_flag = null;
		    String cancel_reasoncode = null;
		    String cancel_reason = null;
		    String void_number = null;
		    String p_alert_flag = null;
		    String print_option = null;
		    String action1 =  request.getParameter("action1");	
		    String episodeId = null;
		
		    String action =  request.getParameter("action");	
		    if("checkForFirstAlert".equals(action)){
		    	facilityId   		= request.getParameter("facilityId");
		  		docTypeCode  		= request.getParameter("docTypeCode");
		  		docNum 		 		= Integer.parseInt(request.getParameter("docNum"));
				login_user   		= request.getParameter("login_user");
				language_id  		= request.getParameter("language_id");
				recpt_nature_code   = request.getParameter("recpt_nature_code");
				episode_type 		= request.getParameter("episode_type");
				patient_id 			= request.getParameter("patient_id");			
			
			
				episodeId=replaceNull(request.getParameter("episode_id"));
				if(episodeId.length() == 0){
					episodeId = "0";
				}
				episode_id = Integer.parseInt(episodeId);
				
				auth_flag 			= request.getParameter("auth_flag");
//System.out.println("facilityId-"+facilityId+"-docTypeCode-"+docTypeCode+"-docNum-"+docNum+"-login_user-"+login_user+"-recpt_nature_code-"+recpt_nature_code+"-episode_type-"+episode_type+"-patient_id-"+patient_id+"-episode_id-"+episode_id);
				String retVal 		= checkForFirstAlert(facilityId, docTypeCode, docNum);
				String retValArr[]	= retVal.split("::");

			if("Y".equals(retValArr[0])){
					out.println("1::"+retVal);
				}
			else{
					String retVal1 = checkForSecondAlert(facilityId, docTypeCode, docNum, locale);	
					String retValArr1[] = retVal1.split("::");
					System.out.println("retValArr1[0]-"+retValArr1[0]);
					out.println("2::"+retVal1);					
				}
		    }
		    else if("checkForFirstdAlertBulk".equals(action)){
		    	System.out.println("checkForFirstAlertBulk begin");
		    
		    	facilityId 		= request.getParameter("facilityId");
		    	login_user 		= request.getParameter("login_user");
		
				auth_flag 		= request.getParameter("auth_flag");
				facilityId		= request.getParameter("facilityId");
				String errTxt 	= "";
				String alertFlag = "N";
				int lastIndex	= Integer.parseInt(request.getParameter("lastindx"));
			
				String retVal 	= "";
				boolean execute = true;
				int exitFrom 	= 0;
				String receiptNumbers = "";
			//	System.out.println("facilityId-"+facilityId+"-login_user-"+login_user+"-language_id-"+locale+"-auth_flag-"+auth_flag+"-lastIndex-"+lastIndex);
				for(int i=1; i<=lastIndex; i++){
						
					if(!"".equals(replaceNull(request.getParameter("doc_typ_code"+i)))){
							docTypeCode =replaceNull(request.getParameter("doc_typ_code"+i));
							docNum = Integer.parseInt(request.getParameter("doc_num"+i));
							System.out.println("checkForFirstAlertBulk in loop");
							retVal = checkForFirstAlert(facilityId, docTypeCode, docNum);
							System.out.println("checkForFirstAlertBulk retVal="+retVal);							
							String retValArr[] = retVal.split("::");
							if("Y".equals(retValArr[0])){	
								alertFlag="Y";
								System.out.println("docNum-"+docNum);
								if (receiptNumbers == "") {
									receiptNumbers =  docTypeCode+"/"+String.valueOf(docNum);
								}else {
									receiptNumbers =receiptNumbers+","+ docTypeCode+"/"+String.valueOf(docNum);
								}
							}
						}						
				}		
					System.out.println("receiptNumbers len-"+receiptNumbers.length());
					out.println(alertFlag+"::"+receiptNumbers);			
		    }
		    else  if("checkForSecondAlert".equals(action)){
		    	facilityId = request.getParameter("facilityId");
		  		docTypeCode = request.getParameter("docTypeCode");
		  		docNum = Integer.parseInt(request.getParameter("docNum"));
				login_user = request.getParameter("login_user");
				language_id = request.getParameter("language_id");
				recpt_nature_code = request.getParameter("recpt_nature_code");
				episode_type = request.getParameter("episode_type");
				patient_id = request.getParameter("patient_id");
				System.out.println("patient_id----"+patient_id);
		
				episodeId=replaceNull(request.getParameter("episode_id"));
				if(episodeId.length() == 0){
					episodeId = "0";
				}
				episode_id = Integer.parseInt(episodeId);
				System.out.println("episode_id----"+episode_id);
				auth_flag = request.getParameter("auth_flag");
		    	String retVal = checkForSecondAlert(facilityId, docTypeCode, docNum, locale);					
				out.println("2::"+retVal);
		    }
		    else if ("checkForSecondAlertBulk".equals(action)) {
		    	facilityId 		= request.getParameter("facilityId");
		    	login_user 		= request.getParameter("login_user");
		
				auth_flag 		= request.getParameter("auth_flag");
				String alertFlag ="N";
				String errTxt 	= "";
				int lastIndex	= Integer.parseInt(request.getParameter("lastindx"));
				String retVal 	= "";
				String receiptNumbers = "";
				boolean execute = true;
				int exitFrom 	= 0;
				for(int i=1; i<=lastIndex; i++){
					if(!"".equals(replaceNull(request.getParameter("doc_typ_code"+i)))){						
							docTypeCode =replaceNull(request.getParameter("doc_typ_code"+i));
							docNum = Integer.parseInt(request.getParameter("doc_num"+i));
							System.out.println("facilityId="+facilityId+ "=docTypeCode="+docTypeCode+"=docNum="+docNum+"=locale="+locale);
							retVal = checkForSecondAlert(facilityId, docTypeCode, docNum, locale);							
							System.out.println("retVal==="+retVal);
							String secArr[] = retVal.split("::");
							if("Y".equals(secArr[0])){
								alertFlag = "Y";							
								System.out.println("docNum 222 -"+docNum);
								if (receiptNumbers == "") {
									receiptNumbers = docTypeCode+"/"+String.valueOf(docNum);
								}else {
									receiptNumbers = receiptNumbers+","+docTypeCode+"/"+String.valueOf(docNum);
								
								}
							}
						}		
						if ( receiptNumbers == "" ){
							System.out.println("receiptNumbers is null");							
						} else 
						System.out.println("222222receiptNumbers ="+receiptNumbers+"==length="+receiptNumbers.length()+"==alertFlag=="+alertFlag);							
		    	}
				out.println(alertFlag+"::"+receiptNumbers);		
			}else if("checkForSubmit".equals(action)){
				System.out.println("in checkForSubmit");
				cancel_reasoncode 	= request.getParameter("cancel_reasoncode");			
				cancel_reason 		= request.getParameter("cancel_reason");
				p_alert_flag 		= request.getParameter("p_alert_flag");
				facilityId   		= request.getParameter("facilityId");
		  		docTypeCode  		= request.getParameter("docTypeCode");
		  		docNum 		 		= Integer.parseInt(request.getParameter("docNum"));
				login_user   		= request.getParameter("login_user");
				language_id  		= request.getParameter("language_id");
				recpt_nature_code   = request.getParameter("recpt_nature_code");
				episode_type 		= request.getParameter("episode_type");
				patient_id 			= request.getParameter("patient_id");			
				episode_id 			= Integer.parseInt(request.getParameter("episode_id"));				
				auth_flag 			= request.getParameter("auth_flag");					
				void_number			= request.getParameter("void_number");			
				cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cncl_rcpt_valchk_commit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
				cstmt.setString(1, facilityId);					
				cstmt.setString (2,  docTypeCode);
				cstmt.setInt(3, docNum);
				cstmt.setString(4, login_user);		
				cstmt.setString (5,  ws_no);
				cstmt.setString(6, language_id);			
				cstmt.setString(7, recpt_nature_code);	
				cstmt.setString (8,  episode_type);
				cstmt.setString(9, patient_id);
				cstmt.setInt(10, episode_id);						
				cstmt.setString (11,  auth_flag);									
				cstmt.setString(12,cancel_reasoncode);				
				cstmt.setString(13,cancel_reason);										
				cstmt.setString (14,void_number);			
			System.out.println("facilityId--"+facilityId+"docTypeCode----"+docTypeCode+"docNum--"+docNum+"login_user----"+login_user+"ws_no----"+ws_no+"language_id----"+language_id);
			System.out.println("recpt_nature_code----"+recpt_nature_code+"episode_type----"+episode_type+"patient_id--"+patient_id+"-episode_id-"+episode_id+"auth_flag----"+auth_flag);
			System.out.println("cancel_reasoncode----"+cancel_reasoncode+"cancel_reason----"+cancel_reason+"void_number----"+void_number);
			
				p_alert_flag="Y";
				cstmt.setString(15, p_alert_flag);
				cstmt.registerOutParameter(16, Types.VARCHAR);							
				cstmt.registerOutParameter (17, Types.VARCHAR);
				cstmt.registerOutParameter(18, Types.VARCHAR);
				cstmt.registerOutParameter(19, Types.VARCHAR);
				System.out.println("before cstmt exe");
				cstmt.execute();
				System.out.println("after cstmt exe");
				alert_flag=cstmt.getString(16);
				error_code=cstmt.getString(17);
				error_level=cstmt.getString(18);
				error_text = cstmt.getString(19);
				System.out.println("out cstmt exe");
				if(alert_flag==null) alert_flag="";	
				if(error_code==null) error_code="";
				if(error_level==null) error_level="";	
				if(error_text==null) error_text="";	
				if(error_id == "" && error_text == "" ){
					con.commit();
					System.err.println("commit");					
				}
				else{
					con.rollback();
					System.err.println("rollback");					
				}
			System.out.println("error --"+alert_flag+" -error_code- "+error_code);
			System.out.println("END cancel package jsp"+error_level+"-error_text-"+error_text);
		    }
		    else if("checkForSubmitBulk".equals(action1)){		 
		    	System.out.println("check for bulk submit");
String retValue = "";
		    	int lastindx = Integer.parseInt(request.getParameter("lastindx"));
		    	locale = (String)session.getAttribute("LOCALE");
		    	login_user   		= request.getParameter("login_user"); //"ALPHA";//
		    	System.out.println("login_user--"+login_user);
		    	cstmt = con.prepareCall("{call bl_cancel_receipt_proc.bl_cncl_rcpt_valchk_commit(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
    			System.out.println("lastindx="+lastindx);
    			cancel_reasoncode = request.getParameter("cancel_reasoncode");			
    			cancel_reason = request.getParameter("cancel_reason");
				void_number = request.getParameter("void_number");
    		
    			System.out.println("cancel_reasoncode=="+cancel_reasoncode+"-cancel_reason--"+cancel_reason+"-void_number-"+void_number);
    			auth_flag 			= request.getParameter("auth_flag");
    			facilityId   		= request.getParameter("facilityId");
    			boolean status = true;
    			String strError = "";
    			for (int i=1 ; i<=lastindx ; i++) {		    					    						    				
    		  		docTypeCode  		= request.getParameter("doc_typ_code"+i);		    		  		
    		  		docNum				=Integer.parseInt(request.getParameter("doc_num"+i));		    		  		
    				recpt_nature_code   = request.getParameter("Recpt_Nature_Code"+i);
    				episode_type 		= request.getParameter("episode_type"+i);		    				
    				patient_id 			= request.getParameter("patient_id"+i);	
    				episode_id 			= Integer.parseInt(request.getParameter("episode_id"+i));		
	/*	    				
System.out.println("facilityId-"+facilityId+"doc type "+docTypeCode+"docNum"+docNum+"locale--"+locale+"login_user"+login_user+"Recpt_Nature_Code"+recpt_nature_code);
System.out.println("episode_type"+episode_type+"patient_id"+patient_id+"episode_id"+episode_id);
*/		    						    						    											    				
		    			cstmt.setString(1, facilityId);					
	    				cstmt.setString(2,  docTypeCode);
	    				cstmt.setInt(3, docNum);
   						cstmt.setString(4, login_user);		
	    				cstmt.setString(5,  ws_no);
	    				cstmt.setString(6, locale);		    				
	    				cstmt.setString(7, recpt_nature_code);	
	    				cstmt.setString(8,  episode_type);
	    				cstmt.setString(9, patient_id);
	    				cstmt.setInt(10, episode_id);			    				
	    				cstmt.setString (11,  auth_flag);		    					
	    				cstmt.setString(12,cancel_reasoncode);		    			
	    				cstmt.setString(13,cancel_reason);		    				
	    				cstmt.setString (14,void_number);		    			
	    				cstmt.setString(15, p_alert_flag);
	    				System.out.println("facilityId--"+facilityId+"docTypeCode----"+docTypeCode+"docNum--"+docNum+"login_user----"+login_user+"ws_no----"+ws_no+"language_id----"+locale);
		    			System.out.println("recpt_nature_code----"+recpt_nature_code+"episode_type----"+episode_type+"patient_id--"+patient_id+"-episode_id-"+episode_id+"auth_flag----"+auth_flag);
		    			System.out.println("cancel_reasoncode----"+cancel_reasoncode+"cancel_reason----"+cancel_reason+"void_number----"+void_number);		    				
	    				cstmt.registerOutParameter(16, Types.VARCHAR);							
	    				cstmt.registerOutParameter (17, Types.VARCHAR);
	    				cstmt.registerOutParameter(18, Types.VARCHAR);
	    				cstmt.registerOutParameter(19, Types.VARCHAR);
	    				System.out.println("before cstmt exe");
	    				cstmt.execute();
	    				System.out.println("after cstmt exe");
	    				alert_flag=cstmt.getString(16);
	    				error_code=cstmt.getString(17);
	    				error_level=cstmt.getString(18);
	    				error_text = cstmt.getString(19);
	    				System.out.println("out cstmt exe");
	    				if(alert_flag==null) alert_flag="";	
	    				if(error_code==null) error_code="";
	    				if(error_level==null) error_level="";	
	    				if(error_text==null) error_text="";	
//}

}
		    				if(error_id == "" && error_text == "" ){
		    					con.commit();
retValue = "C::Y";
		    					System.err.println("commit");					
		    				}
		    				else{
		    					con.rollback();
	retValue = "C::N::"+error_text;
		    					System.err.println("rollback");					
		    				}
		    				    			
		    			response.sendRedirect("BLReceiptResponse.jsp?retValue="+retValue);		
		    			System.out.println("error --"+alert_flag+" -error_code- "+error_code);
		    			System.out.println("END cancel package jsp"+error_level+"-error_text-"+error_text);			    			
		    }else if("CheckForReprint".equals(action)){
		    	System.out.println("Reprint");		
				print_option		= request.getParameter("print_option");
				 String doc11 = request.getParameter("doc_typ_code");
				 System.out.println("doc11--"+doc11);
				String retValue = CheckForReprint(request,locale,ws_no,print_option);
				System.out.println("retValue-"+retValue);
				out.println(retValue);
		    }
		    else if("CheckForReprintBulk".equals(action1)){
		    	System.out.println("CheckForReprintBulk");		    		  	
				facilityId   		= request.getParameter("facilityId");				
				print_option		= request.getParameter("print_option");		
				System.out.println("facilityId-"+facilityId+" print_option - "+print_option);
				String retValue = CheckForReprintBulk(request,locale,ws_no,print_option);				
				System.out.println("retValue--"+retValue);

	response.sendRedirect("BLReceiptMultipleReport.jsp?data="+retValue);
		    }
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
