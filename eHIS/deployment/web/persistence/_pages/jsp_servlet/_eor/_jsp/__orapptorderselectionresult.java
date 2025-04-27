package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orapptorderselectionresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORApptOrderSelectionResult.jsp", 1734679730000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n24/08/2013    IN030284\t\tChowminya G \tCreated:To capture Pre-consultation orders in Appointment Scheduling\n13/09/2013    IN030284.1 \tChowminya G \tCRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)\t\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eOR/js/ORApptOrderSelection.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    \n</head>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\'OrderableResult\' id=\'OrderableResult\' action=\"ORApptOrderSelectionResult.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  method=\'post\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\n\t <table border=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'65%\'></td> \n\t\t\t<td align=\'right\' width=\'35%\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<a class=\'gridLink\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =",";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' text-decoration=\'none\'>&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t</tr>\n\t </table>\n\n\t  <table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\'tableId\' class=\'grid\'>\n\t\t<th class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' align=\'center\'>\n\t\t\t<input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"chk";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="~~";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onclick=\'getDescription(this,\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\",\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\");\'> <!-- IN030284.1 -->\n\t\t\t<input type=\"hidden\" name=\"short_desc";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"short_desc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_code1";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"order_type_code1";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_category1";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"order_category1";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type=\"hidden\" name=\"appt_ref_no";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"appt_ref_no";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t</td></tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=hidden name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t<input type=hidden name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=hidden name=\'order_type_code\' id=\'order_type_code\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=hidden name=\'activity_type\' id=\'activity_type\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=hidden name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=hidden name=\'description_code\' id=\'description_code\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=hidden name=\'long_desc\' id=\'long_desc\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=hidden name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=hidden name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=hidden name=\'qry_str\' id=\'qry_str\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<input type=hidden name=\'appt_ref_no\' id=\'appt_ref_no\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t </table>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);</script>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</form>\n</body>\n<script>\nfunction submitPrevNext(from, to)\n{\n\tdocument.OrderableResult.from.value = from;\n\tdocument.OrderableResult.to.value = to; \n\tdocument.OrderableResult.target = \"OrderSelectionResult\"\n\tdocument.OrderableResult.submit();\n}\nfunction ok(from,to)\n{\n\tsubmitOrderable();\n\ttoCloseTopShowModal();\n\t\n}\nfunction dummy()\n{\n}\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	Orderables.setLanguageId(localeName);
	

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);


	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String  req_start   =   "", req_end     =   "";
	String order_category1 = "",order_type_code1="";
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
	String order_category=(request.getParameter("order_category")==null||request.getParameter("order_category").equals("null"))?"":request.getParameter("order_category");
	String order_type_code=(request.getParameter("type_code")==null||request.getParameter("type_code").equals("null"))?"":request.getParameter("type_code");
	String activity_type=(request.getParameter("activity_type")==null||request.getParameter("activity_type").equals("null"))?"":request.getParameter("activity_type");
 	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
 	String p_clinic_code = (request.getParameter("p_clinic_code")==null||request.getParameter("p_clinic_code").equals("null"))?"":request.getParameter("p_clinic_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = ""; 		
 	String facility_id = (String)session.getValue("facility_id");
 	String qry_str = (request.getParameter("qry_str")==null||request.getParameter("qry_str").equals("null"))?"":request.getParameter("qry_str");
 	String appt_ref_no = Orderables.getapptrefno();
 	String facilityid = Orderables.getfacilityid();
	String from1 = Orderables.getfrom();
	String to1 = Orderables.getto();
	String flag = "";
	
	int counts=0;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
		
	if((from == null) || (to == null))
	{
		flag = Orderables.getflag();
		if("box_unchecked".equals(flag))
		{
			from = from1;
			to = to1;
		}
	}
		
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	
	int i=1;
	
	if (from == null)
	{ 
		start = 1 ;  
	}  
	else
	{  
		start = Integer.parseInt( from ) ; 
	}

	if (to == null)
	{ 
		end = 7 ;
	}  
	else 
	{ 
		end = Integer.parseInt( to ) ; 
	}


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	if(from != null && to != null)
	{
		int j=0;

		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i-1)) != null) 
			{
				checkedOnes = request.getParameter("chk"+(i-1));
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}

	putObjectInBean("refusalOrdersBean",Orderables,request);
	i = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
		String option_id	= "";
		String short_desc	= "";
		int ilCkeckedYN = 0;
		int recordCount;
		String checkStatus  = "";	
		String checkProp = "";
		StringBuffer sql = new StringBuffer();
		String classValue="";
		String limit_catalog_to_locn = "";

		sql.append("select nvl(limit_catalog_to_locn,'N') limit_catalog_to_locn from or_param_by_facility where operating_facility_id=?");
		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1 , facility_id);
		rs = pstmt.executeQuery();

		while(rs.next() && rs!=null)
		{
			limit_catalog_to_locn = rs.getString("limit_catalog_to_locn")==null?"":rs.getString("limit_catalog_to_locn");
		}

		rs.close();
		pstmt.close();
		sql.setLength(0);

		sql.append("select a.order_catalog_code,or_get_desc.or_order_catalog(a.order_catalog_code,?,'2') long_desc,order_catalog_nature order_catalog_nature,order_category,order_type_code from or_order_catalog a"); 
		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			sql.append(" ,OP_CATALOG_FOR_CLINIC b "); 
		}
		sql.append(" where order_category not in( 'PH' ) and order_category=NVL(?,order_category) AND order_type_code=NVL(?,order_type_code) AND ((upper(short_desc) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'D' = ?) OR (upper(a.order_catalog_code) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'C' = ?))  AND eff_status='E' AND NVL(activity_type,'!') = NVL(?,NVL(activity_type,'!'))");//IN031116

		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			sql.append(" and a.order_catalog_code=b.order_catalog_code and b.clinic_code=?");
		}
		
		sql.append(" ORDER BY long_desc");

		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		int indval =1;
		pstmt.setString(indval++ , localeName);
		pstmt.setString(indval++ , order_category);
		pstmt.setString(indval++ , order_type_code);
		pstmt.setString(indval++ , description_code);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , search_by);
		pstmt.setString(indval++ , description_code);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ ,	long_desc);
		pstmt.setString(indval++ , long_desc);
		pstmt.setString(indval++ , search_by);
		pstmt.setString(indval++ , activity_type);
		if(limit_catalog_to_locn.equalsIgnoreCase("Y"))
		{
			pstmt.setString(indval++ , p_clinic_code);
		}

		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
	

            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( !(start <= 1)) 
		{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start-7)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end-7)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}

		if ( !((start+7) > maxRecord ))
		{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start+7)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+7)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		if (start != 0)
		{
			for(int j=1; j<start; i++,j++)
			{
				rs.next() ;
			}
			ilCkeckedYN+=start;
			--ilCkeckedYN ;
		}

		recordCount			=	Orderables.getSize();

		while(rs.next()&& i<=end)
		{
			counts++;
			option_id = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
			short_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
			order_category1 = rs.getString("order_category")==null?"":rs.getString("order_category");
			order_type_code1 = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
		
			try
			{
				//IN030284.1
				if(Orderables.containsTempObject(option_id+"~~"+short_desc+"~~"+order_type_code1+"~~"+order_category1+"~~"+appt_ref_no))
				{
					checkStatus = "Y";
				}
				else
					checkStatus = "N";	
			} 
			catch(Exception e) 
			{
               //out.println("Exception in OrderableResult.jsp: "+e.toString());	//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181			
			}
			
			if(checkStatus.equals("Y")) 
			{
				checkProp = " CHECKED "; 
			} 
			else 
			{
				checkProp = "";
			}
			
			classValue="gridData";

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_type_code1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_type_code1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_category1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(counts));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block38Bytes, _wl_block38);

			ilCkeckedYN = ilCkeckedYN + 1;		
			i=i+1;
		}
		out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
		out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
		out.println("<input type=hidden name=occurance value='next'>");
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(start));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(end));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(start));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(end));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(description_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(qry_str));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
	    if(counts==0)
		{

            _bw.write(_wl_block56Bytes, _wl_block56);

		}
		else
		{

            _bw.write(_wl_block57Bytes, _wl_block57);

		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block58Bytes, _wl_block58);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
