package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispensequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/DispenseQueryResult.jsp", 1731409414000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/Dispense.js\"></script>\n \t<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction hideToolTip()\t{ \n\t  document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t}\n\n\t   \n\tfunction callMouseOver(obj)\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'ORMENU\'; \n\t\t\t\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = currClass; \n\t}\n\t</script>\n       <STYLE TYPE=\"text/css\">\n       \tA:link \n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited \n     \t {\n             COLOR: blue ;\n         }\n        A:active \n         {\n             COLOR: red;\n         }\n   \t\n\t\t\n  \t</STYLE> \n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'disp_query_result_dtl\' id=\'disp_query_result_dtl\' action=\"../../eOR/jsp/DispenseQueryResult.jsp\" method=\"post\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" align=\'center\' class=\"grid\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="   \n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t \n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<tr align=\'left\'>\n\t\t\t\t<th class=\"columnheader\" colspan=7 > <font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>  <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'Completion\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></font></td>\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </font> ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </td> \n\t\t\t<td width=\'62%\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\"> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</a> </td> \n\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' align=center><font size=1>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font> </td>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" </td> \n\t\t\t<td width=\'28%\' class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</a> </td> \n\t\t\t<td width=\'34%\' class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'> <font size=1>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </font></td> \n\t\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=center><font size=1> ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n</table>\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n<input type=\"hidden\" name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<!-- <input type=\"hidden\" name=\"Parameters\" id=\"Parameters\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> -->\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"patient_id_found\" id=\"patient_id_found\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"location\" id=\"location\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\"hidden\" name=\"single_multi\" id=\"single_multi\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\"hidden\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\"hidden\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<input type=\"hidden\" name=\"order_type\" id=\"order_type\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085


	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String DispenseDate="";
	HashMap Parameters = new HashMap();
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();
		String paramValue = request.getParameter(pName);
		if(paramValue == null)	paramValue = "";
		else paramValue = paramValue.trim();
		Parameters.put(pName, paramValue);
	}
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String bean_id =   request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	String order_category = request.getParameter("order_category");
	String encounter_id = request.getParameter("encounter_id");
	String priority = request.getParameter("priority");
	String location_type = request.getParameter("location_type");
	String location = request.getParameter("location");
	String order_id = request.getParameter("order_id");
	String function_id = request.getParameter( "function_id" ) ;
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String responsibility_id = (String)session.getValue("responsibility_id"); 
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String patient_id_found = request.getParameter("patient_id_found");
	String patient_class = request.getParameter("patient_class");
	String patient_id = request.getParameter("patient_id");
	String date_from = request.getParameter("date_from");
	String single_multi = request.getParameter("single_multi");
	String date_to = request.getParameter("date_to");
	String order_type = request.getParameter("order_type");
	String total_query_records  = "0";
	if(location_type == null)	location_type = "";
	if(patient_class == null)	patient_class = "";
	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(patient_id == null)patient_id = "";
	if(location == null)location = "";
	if(order_category == null)order_category = "";
	if(single_multi == null)single_multi = "";
	if(priority == null)priority = "";
	if(date_from == null)date_from = "";
	if(date_to == null)date_to = "";
	if(order_id == null)order_id = "";
	if(encounter_id == null)encounter_id = "";
	if(order_type == null)order_type = "";

	//Parameters.put("location_type", location_type);
	//Parameters.put("location", location);
	//Parameters.put("order_category", order_category);
	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	//Parameters.put("order_type", order_type);
	//Parameters.put("patient_class", patient_class);
	//Parameters.put("patient_id_found", patient_id_found);
	//Parameters.put("patient_id", patient_id);
	//Parameters.put("single_multi", single_multi);
	//Parameters.put("priority", priority);
	//Parameters.put("date_from", date_from);
	//Parameters.put("date_to", date_to);
	//Parameters.put("order_id", order_id);
	//Parameters.put("encounter_id", encounter_id);
	/* Mandatory checks end */
	
/* Initialize Function specific start */

	//DispenseBean bean = (DispenseBean)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	DispenseBean bean = (DispenseBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;

/* Initialize Function specific end */

	ArrayList allValues = new ArrayList();
	allValues = bean.getSearchDetails(Parameters,start,end);


            _bw.write(_wl_block9Bytes, _wl_block9);

	String slClassValue = "";
	String tmp_ord_cat = "";
	int k			= 0;
	for(int i=0; i<allValues.size(); i++)
	{
		String[] row_details = new String[14];
		row_details = (String[])allValues.get(i);
		
		slClassValue="gridData";
		if(i==0)
		{
			if(row_details[14] != null)
			total_query_records = bean.checkForNull((String)row_details[14],"0");

            _bw.write(_wl_block10Bytes, _wl_block10);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("disp_query_result_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block16Bytes, _wl_block16);

		}

		if(row_details[1].equals("R"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(row_details[1].equals("U"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(row_details[1].equals("S"))
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}

		if (row_details[3].indexOf(",")!=-1)
		{

			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
			while (fieldTokenizer.hasMoreTokens()) 
			{
				String tempToken = fieldTokenizer.nextToken();

				if ((tempToken.indexOf('/'))==1)
				{
					String tempstr=tempToken.substring(1);
					if (tempToken.charAt(0)=='M')
						tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
					else if(tempToken.charAt(0)=='F')
						tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
				}
				row_details[3]=row_details[3].concat(tempToken).concat(",");
			}
		}
		
			
		if(!(tmp_ord_cat.equals(row_details[7])))
		{
			tmp_ord_cat = (String)row_details[7];
			//out.println("tmp_ord_cat-->"+tmp_ord_cat);

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row_details[8]));
            _bw.write(_wl_block18Bytes, _wl_block18);
 		
		}

            _bw.write(_wl_block19Bytes, _wl_block19);
		
		String fontValue = "";
		String imageTag = "";
		if(row_details[13].equals("U"))
		{
			fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
		}
		else if(row_details[13].equals("S"))
		{
			fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
			imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
		}
		else
		{
			fontValue = "<font size=1 color=black><b>";
		}

		if ( !localeName.equals("en") )
		{ 
			 DispenseDate 	=com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName);
		}
		else
		{
			DispenseDate=row_details[0];
		}

		if(row_details[2].indexOf("!~!")!=-1)
		{
			row_details[2] = row_details[2].replace("!~!",",");
		}

		if(patient_id_found.equals("yes"))
		{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[5]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(DispenseDate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fontValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(imageTag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[5]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_details[4]));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
		else
		{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[5]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(DispenseDate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fontValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(imageTag));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(row_details[5]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_details[4]));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
k++;
	}

	if(allValues.size() == 0)
	{

            _bw.write(_wl_block40Bytes, _wl_block40);

	} 

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(from));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(to));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Parameters));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id_found));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(location));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(single_multi));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block61Bytes, _wl_block61);

	putObjectInBean(bean_id,bean,request);

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
