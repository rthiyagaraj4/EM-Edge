package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eBL.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __userauthenticationpayerpolicyvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/UserAuthenticationPayerPolicyValidation.jsp", 1709114148726L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n1-Jan-2014      100           \tKarthikeyan.K          created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<HTML>\n<HEAD>\n</HEAD>\n<body>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</body>\n</HTML>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/



	/* 
	MMS-SCF-0355 - Added by Karthikeyan on 26/05/2014 
	Successful Authentication returns "Y", failed Authentication returns "N"
	*/
	String isAuthenticatedUser(Connection con,String facilityId,String loggedUser,String responsibilityId,String functionId,String custGroupCode,String custCode,String policyTypeCode,String privilageCode,java.sql.Date curDate) throws SQLException{
				
	CallableStatement calStmt = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_multi_privlege_yn(?,?,?,?,?,?,?,?,?,?,?) }");
	calStmt.setString(1,facilityId);
	calStmt.setString(2,loggedUser);
	calStmt.setString(3,responsibilityId);
	calStmt.setString(4,functionId);
	calStmt.setString(5,custGroupCode);
	calStmt.setString(6,custCode);
	calStmt.setString(7,policyTypeCode);
	calStmt.setString(8,privilageCode);
	calStmt.setDate(9,curDate);
	calStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	calStmt.registerOutParameter(11,java.sql.Types.VARCHAR);
	calStmt.execute();	
	String privilageValue = calStmt.getString(10);	
	String validAuthenticatedUser = calStmt.getString(11);
	System.err.println("54, validAuthenticatedUser==>"+validAuthenticatedUser);
	if(calStmt!=null){
		calStmt.close();
	}
	
	if(validAuthenticatedUser==null) validAuthenticatedUser="N";		
	return validAuthenticatedUser;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//System.out.println("$$$$ UserAuthenticationPayerPolicyValidation.jsp page called" + request.getQueryString());

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String calledFromPage=null; 
	String loggedUser=null;
	Connection con=null;

	calledFromPage=request.getParameter("calledFromPage");
	if(calledFromPage==null)calledFromPage="";

	if(calledFromPage.equals("SAVE_SUCCESSFULLY_LOGGED_IN_USER")){	
		loggedUser= request.getParameter("successfulUser"); 
		session.setAttribute("succesfully_logged_in_user",loggedUser);
		out.println("@@@SUCCESS@@@");
	}else{		
	try {
		con=ConnectionManager.getConnection(request);
		request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");		
		System.out.println(hash);
   		String validAuthenticatedUser="N";   		
   		boolean validateAllPayers=false;

		String functionId="";
		String privilageCode="";
		String custGroupCode="";
		String custCode="";
		String policyTypeCode="";
		String episodeType="";

   		if(calledFromPage.equals("POLICY_DEFN_CREATE")){  
   			loggedUser=(String)session.getAttribute("login_user");
   			custGroupCode=request.getParameter("payerCode");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			functionId="POLICY_DEFN";
			privilageCode="CREATE_PLCY";
   		}  
   		
   		if(calledFromPage.equals("POLICY_DEFN_MODIFY")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");									
   			custGroupCode=(String)hash.get("payerCode2");
   			custCode=(String)hash.get("payerCode");
   			policyTypeCode=(String)hash.get("policyTypeCode");  
			functionId="POLICY_DEFN";
			privilageCode="MODIFY_PLCY";
   		}  
   		/* Added V190517-Aravindh/NMC-JD-CRF-0010/Starts */
   		if(calledFromPage.equals("POLICY_DEFN_APPROVE")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");   			
			custGroupCode=request.getParameter("payerCode");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			functionId="POLICY_DEFN";
			privilageCode="APPRV_UNAPPRV_PLCY";
   		}
   		/* Added V190517-Aravindh/NMC-JD-CRF-0010/Ends */
   		if(calledFromPage.equals("MOD_FIN_DTLS_VAL_ALL")){  
    			loggedUser=(String)session.getAttribute("login_user");
//    			custGroupCode=request.getParameter("payerCode");
//    			custCode=request.getParameter("payer");
//    			policyTypeCode=request.getParameter("policy");
//    			String calledModuleId = request.getParameter("blngClass");   			

   			custGroupCode=(String)hash.get("payerCode");
   			custCode=(String)hash.get("payer");
   			policyTypeCode=(String)hash.get("policy");
   			String calledModuleId = (String)hash.get("blngClass");   			
   			
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			if(calledModuleId == null) calledModuleId="";
   			
			if("OP".equals(calledModuleId)){
				functionId="OP_VISIT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("EM".equals(calledModuleId) || "AE".equals(calledModuleId)){
				functionId="REG_ATTENDANCE";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("IP".equals(calledModuleId) || "DC".equals(calledModuleId)){
				functionId="IP_ADMMISION";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("MP".equals(calledModuleId) || "".equals(calledModuleId)){
				functionId="REG_PATIENT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			} 	
			
			validateAllPayers=true;
			
   		}
   		
   		if(calledFromPage.equals("MOD_FIN_DTLS_VAL_ALL_AUTH")){  
//  			loggedUser=request.getParameter("authorizedUser");
//    			custGroupCode=request.getParameter("payerCode");
//    			custCode=request.getParameter("payer");
//    			policyTypeCode=request.getParameter("policy");
//    			String calledModuleId = request.getParameter("blngClass");
   			
   			loggedUser=(String)hash.get("authorizedUser");
   			custGroupCode=(String)hash.get("payerCode");
   			custCode=(String)hash.get("payer");
   			policyTypeCode=(String)hash.get("policy");
   			String calledModuleId = (String)hash.get("blngClass");		
		
   			
   			if(custGroupCode==null) custGroupCode="";
   			if(custCode==null) custCode="";
   			if(policyTypeCode==null) policyTypeCode="";
			if(calledModuleId == null) calledModuleId="";
   			
			if("OP".equals(calledModuleId)){
				functionId="OP_VISIT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("EM".equals(calledModuleId) || "AE".equals(calledModuleId)){
				functionId="REG_ATTENDANCE";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("IP".equals(calledModuleId) || "DC".equals(calledModuleId)){
				functionId="IP_ADMMISION";
				privilageCode="ASSOCIATE_CUST_PLCY";
			}
			else if("MP".equals(calledModuleId) || "".equals(calledModuleId)){
				functionId="REG_PATIENT";
				privilageCode="ASSOCIATE_CUST_PLCY";
			} 	
			
			validateAllPayers=true;
   		}
   		
   		if(calledFromPage.equals("MOD_FIN_DTLS")){  
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
   			custGroupCode=(String)hash.get("ins_cust_group_code");
   			custCode=(String)hash.get("cust_3");
   			policyTypeCode=(String)hash.get("policy_type_code"); 
   			episodeType=(String)hash.get("episode_type");
   			
   			if("O".equals(episodeType)){
   				functionId="OP_VISIT";
   				privilageCode="MODIFY_CUST_PLCY";
   			}
   			else if("E".equals(episodeType)){
   				functionId="REG_ATTENDANCE";
   				privilageCode="MODIFY_CUST_PLCY";
   			} 
   			else if(("I".equals(episodeType)) || ("D".equals(episodeType))){
   				functionId="IP_ADMMISION";
   				privilageCode="MODIFY_CUST_PLCY";
   			}
   			else if("R".equals(episodeType)){
   				functionId="REG_PATIENT";
   				privilageCode="MODIFY_CUST_PLCY";
   			}   			
   		}  

   		if(calledFromPage.equals("ENC_SPEC_PLCY")){
   			loggedUser= (session.getAttribute("succesfully_logged_in_user")==null)?(String)session.getAttribute("login_user") : (String)session.getAttribute("succesfully_logged_in_user");
   			custGroupCode=request.getParameter("payerGroup");
   			custCode=request.getParameter("payer");
   			policyTypeCode=request.getParameter("policy");   			
			functionId="ENCOUNTR_POLCY";
			privilageCode="MODIFY_ENC_PLCY";
   		}
   		
  	//start-added for MMS CRF 125- Pradeepa 
  	
  	// System.out.println("successfulUser:"+request.getParameter("successfulUser"));
 	// System.out.println("calledFromPage:"+request.getParameter("calledFromPage"));
  	
   		if(calledFromPage.equals("PKG_PRIC_BULK_UPDATE")){
  			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="PKG_BULK_UPDATE";
			privilageCode="PKG_PRICE_UPD";
   		}	
   		
   		if(calledFromPage.equals("PKG_DISC_BULK_UPDATE")){
  			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="PKG_BULK_UPDATE";
			privilageCode="PKG_DISC_UPD";
   		}	
   		
   		if(calledFromPage.equals("Billed")){
  			
   			System.out.println("Called from billed");
   			loggedUser=(request.getParameter("successfulUser")==null)?(String)session.getAttribute("login_user") : request.getParameter("successfulUser");
  			System.out.println("loggedUser:"+loggedUser);
   			custGroupCode="**";//request.getParameter("");
   			custCode="**";//request.getParameter("");
   			policyTypeCode="**";//request.getParameter("");   			
			functionId="RECORD_APPROVAL";
			privilageCode="CHG_APPR_STATUS_FOR_BILLED_REC";
   		}
	
   	//end- added for MMS CRF 125- Pradeepa 
   	
   

   		String facilityId=(String)session.getAttribute("facility_id");
   		String responsibilityId=(String)session.getAttribute("responsibility_id");
   		java.sql.Date curDate= new java.sql.Date(new java.util.Date().getTime());
   		
		/* 
		MMS-SCF-0355 - Added by Karthikeyan on 26/05/2014 
		The below logic loads the default loaded policies for the default billing group from the session
		and seperates them from new policies and provides them different previlage for authentication. 
		*/
   		if(validateAllPayers==true){
   			
   			ArrayList<String> defaultLoadedCustomerList=session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO")==null ? new ArrayList<String>() : (ArrayList<String>)session.getAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO") ;
   					  			
   			StringTokenizer stCustGrpTok=new StringTokenizer(custGroupCode,"|");
   			StringTokenizer stCustCodeTok=new StringTokenizer(custCode,"|");
   			StringTokenizer stCustPlcyTok=new StringTokenizer(policyTypeCode,"|");
   			
   			String defaultCustGroupCode="";
   			String defaultCustCode="";
   			String defaultPolicyTypeCode="";
   			String newCustGroupCode="";
   			String newCustCode="";
   			String newPolicyTypeCode="";
   			boolean defaultPolicyAvailable=false;
   			boolean newPolicyAvailable=false;
   			
   			while(stCustGrpTok.hasMoreTokens()){
   				String stCustGrpTemp= stCustGrpTok.nextToken();
   				String stCustCodeTemp=stCustCodeTok.nextToken();
   				String stCustPlcyTemp=stCustPlcyTok.nextToken();
   				
   				if( stCustGrpTemp!=null && !stCustGrpTemp.equals("") ){
   				String strDefaultInfo = stCustGrpTemp+"|"+stCustCodeTemp+"|"+stCustPlcyTemp;
  			
   					if(defaultLoadedCustomerList.contains(strDefaultInfo)){
   						defaultCustGroupCode+=stCustGrpTemp+"|";
   						defaultCustCode+=stCustCodeTemp+"|";
   						defaultPolicyTypeCode+=stCustPlcyTemp+"|";
   						defaultPolicyAvailable=true;
	   				}else{
	   					newCustGroupCode+=stCustGrpTemp+"|";
	   					newCustCode+=stCustCodeTemp+"|";
	   					newPolicyTypeCode+=stCustPlcyTemp+"|";
	   					newPolicyAvailable=true;
	   				}
   				}
   			}  	
   			
   			
  /*   		System.out.println("**************   ALL POLICY LIST     ******************");
   			System.out.println(custGroupCode);
   			System.out.println(custCode);
   			System.out.println(policyTypeCode); 
    		System.out.println("**************   NEW POLICY LIST     ******************");
   			System.out.println(newCustGroupCode);
   			System.out.println(newCustCode);
   			System.out.println(newPolicyTypeCode);
			System.out.println("**************   DEFAULT POLICY LIST     ******************");
   			System.out.println(defaultCustGroupCode);
   			System.out.println(defaultCustCode);
   			System.out.println(defaultPolicyTypeCode); */
   			
   						
   			/*	For Validating Newly added customer Group			*/  
   			if(newPolicyAvailable==true){
   			validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,newCustGroupCode,newCustCode,newPolicyTypeCode,privilageCode,curDate);
   			}else{
   				validAuthenticatedUser="Y"; 
   			}
 			/*	For Validating Default loaded customer Group		*/
			if(defaultPolicyAvailable==true && validAuthenticatedUser.equals("Y")){
			privilageCode="DFLT_CUST_PLCY";
		   	validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,defaultCustGroupCode,defaultCustCode,defaultPolicyTypeCode,privilageCode,curDate);	
			}	   		
   		}else{   /*For Regular validations where a policy is authenticated for a user*/	
		validAuthenticatedUser=isAuthenticatedUser(con,facilityId,loggedUser,responsibilityId,functionId,custGroupCode,custCode,policyTypeCode,privilageCode,curDate);
   		}
			
		if(validAuthenticatedUser.equals("Y")){
		out.println("@@@SUCCESS@@@");
		}else{
		out.println("@@@FAILED@@@");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from PayerMaterialValidation.jsp :"+ e);
	}finally{
		ConnectionManager.returnConnection(con);
	}

}



            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
