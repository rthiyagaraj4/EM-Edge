package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import eBL.Common.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __loaddefaultpolicydateandapprovedamount extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/LoadDefaultPolicyDateAndApprovedAmount.jsp", 1727437930160L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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

	
private String checkForNull(String inputString)
{
	
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}

public String formatDate(String inputDate){
	if(inputDate==null || inputDate.equals("")){
		return "";
	}
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Timestamp inputTimeStamp = null;
    String outputDate=inputDate;
    long longTimeStamp = 0;
    inputTimeStamp = Timestamp.valueOf(inputDate);
    longTimeStamp = inputTimeStamp.getTime();
    outputDate=sdf.format(longTimeStamp);
    return outputDate;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
String Str																					=	"!";
String pateintId																			=	"";
String moduleId																				=	"";
String customerGroupcode																	=	"";
String customerCode																			=	"";
String policyTypeCode																		=	"";
String locale																				=	"";
String facilityId																			=	"";
Connection connection																		=   null;
PreparedStatement preparedStatement															= 	null;
ResultSet resultSet																			= 	null;
String	mId																					=	"@moduleId";
String	fId																					=	"@facilityId";
String	cGId																				=	"@customerGroupcode";
String	cId																					=	"@customerCode";
String	pTCId																				=	"@policyTypeCode";
StringBuffer sql																			= 	null;		
try
{
	
	request.setCharacterEncoding("UTF-8");
	System.err.println("In LoadDefaultPolicyDateAndApprovedAmount.jsp.::: ");
	sql																						=	new StringBuffer();	
	connection																				=	ConnectionManager.getConnection(request);
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	moduleId																				=	checkForNull(request.getParameter("strModuleId")); 
	customerGroupcode																		=	checkForNull(request.getParameter("cust_group_code"));
	customerCode																			=	checkForNull(request.getParameter("cust_code"));
	policyTypeCode																			=	checkForNull(request.getParameter("policy_type_code"));
	/*System.out.println("facilityId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::: "+facilityId);
	System.out.println("moduleId in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::::::: "+moduleId);
	System.out.println("customerGroupcode in LoadDefaultPolicyDateAndApprovedAmount.jsp::: "+customerGroupcode);
	System.out.println("customerCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::::: "+customerCode);
	System.out.println("policyTypeCode in LoadDefaultPolicyDateAndApprovedAmount.jsp:::::: "+policyTypeCode);
	*/
	
	
	if(moduleId.equalsIgnoreCase("MP"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_MP"));
	}
	if(moduleId.equalsIgnoreCase("IP") || moduleId.equalsIgnoreCase("DC"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_IP"));
	}
	if(moduleId.equalsIgnoreCase("OP") || moduleId.equalsIgnoreCase("AE"))
	{
		sql.append(BlRepository.getBlKeyValue("BILLING_ADDPAYER_INSURANCE_DEFAULT_VALUES_OP"));
	}
	//System.out.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp BEFORE:::::: "+sql);
	sql.replace(sql.indexOf(cGId),sql.indexOf(cGId)+cGId.length(),  customerGroupcode);
	sql.replace(sql.indexOf(cId),sql.indexOf(cId)+cId.length(),  customerCode);
	sql.replace(sql.indexOf(pTCId),sql.indexOf(pTCId)+pTCId.length(),  policyTypeCode);
	System.err.println("sql in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+sql);
	//System.out.println("connection in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+connection);
	preparedStatement = connection.prepareStatement(sql.toString());
	resultSet=preparedStatement.executeQuery();
		
	if( resultSet != null ) 
	{
		while(resultSet.next())
		{
			
			Str=Str+formatDate(checkForNull(resultSet.getString(1)))+"~"+formatDate(checkForNull(resultSet.getString(2)))+"~"+checkForNull(resultSet.getString(3))+"~"+checkForNull(resultSet.getString(4))+"~"+checkForNull(resultSet.getString(5))+"~";
		}
	}
	System.out.println("Str in LoadDefaultPolicyDateAndApprovedAmount.jsp AFTER:::::: "+Str);

 	out.println(Str);

}
catch(Exception e)
{
	System.err.println("EXCEPTION IN LoadDefaultPolicyDateAndApprovedAmount.jsp.::::: "+e); 
}
finally
{
	if(resultSet!=null) resultSet.close();
	if(preparedStatement!=null) preparedStatement.close();
	if(connection!=null) ConnectionManager.returnConnection(connection);
	
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
