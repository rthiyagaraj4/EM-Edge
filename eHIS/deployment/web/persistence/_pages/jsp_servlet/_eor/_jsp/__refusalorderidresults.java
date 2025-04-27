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
import eCommon.Common.*;
import java.util.*;

public final class __refusalorderidresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/RefusalOrderIDResults.jsp", 1737004454000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n---------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n---------------------------------------------------------------------------------------------------------\n?             100            ?           created\n\n12/12/2011    IN029211       Chowminya G    Incident No: IN029211 - <Record Refusal of order set then view Existing Refusal system show only 1 order with multiple line> \n24/09/2012    IN034904        Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal\n---------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n \t<script language=\"JavaScript\" src=\"../js/RefusalOrders.js\"></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"orderidresult\" id=\"orderidresult\">\n<table >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td></tr>\n\t\t</table>\n\n\t\t<table border=\"\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" class=\"grid\">\n\t\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\"20%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"20%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\"20%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n            <tr >\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t \n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"4\" class=\"CAGROUPHEADING\" align=\'left\'><font size=\"1pt\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </font></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n            <td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ><font size=\"1pt\"> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><font size=\"1pt\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  align=\"center\"><input type=\"checkbox\" name=\"s_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"s_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =":$#";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\tonClick=\"checky_n(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\">\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  onClick=\"checky_n(this,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\" >\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =":";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" disabled> <!--///@@@@/////-->\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" disabled>\n\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" >\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<!--\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onClick=\"checky_n(this,\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\">\n\t\t</td> -->\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >&nbsp;</td>-->\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</table>\n\n<table  width=\"100%\" class=\"a1\">\n <tr>\n <td align=\'right\' bgcolor=\'white\'>\n <input type=\"button\"   class=\"button\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onClick=\"displayOrderId()\">\n\t\n </td>\n </tr>\n </table>\n<input type=\"hidden\" name=\"store_n\" id=\"store_n\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"order_y_n\" id=\"order_y_n\" value=\"\">\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n<input type=\"hidden\" name=\"store_orderid\" id=\"store_orderid\" value=\"\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n<input type=\"hidden\" name=\"line_num\" id=\"line_num\" value=\"\">\n<input type=\"hidden\" name=\"selectedCatalog\" id=\"selectedCatalog\" value=\"\">\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n</form>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\t\t\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
			
	String temp = "";
	//String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "RefusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";


	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);

	ArrayList getBeanOrderId = new ArrayList();
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patientId=request.getParameter("patientid");
	String orderid=request.getParameter("orderid");
	String linenum = request.getParameter("linenum");
	
	if(orderid == null && linenum == null && !patientId.equals("")|| orderid.equals("") || linenum.equals(""))
	{
		//bean.clearBean();
	}

	if(request.getQueryString() != null)
		bean.clearBean();

	getBeanOrderId.add(orderid);

	if(linenum.equals("") || linenum.equals(" ") || linenum == null)
	{
		getBeanOrderId.add(linenum);
	}
	else
	{
		StringTokenizer strTokenizer = new StringTokenizer(linenum,":");
		
		while(strTokenizer.hasMoreTokens())
		{
			temp = strTokenizer.nextToken();

			if(temp != "" && temp != null)
			{
				getBeanOrderId.add(temp+":");	
				temp = "";
			}
		}
	}
					
	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
	//String order_y_n = request.getParameter( "order_y_n" ) ;
	String check="";
	String classvalue		= "";
	//	String get_y_n="";

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_ID"));//Commented --[IN029211]
	//sqlMap.put( "sqlData", "select b.order_id order_id,b.order_line_num order_line_num, b.ORD_CONSENT_REQD_YN ord_consent_reqd_yn,b.catalog_synonym_dc catalog_desc,b.ORD_PRACT_ID ord_pract_id,c.practitioner_name practitioner_name,a.encounter_id encounter_id, b.order_type_code order_type_code, a.patient_class patient_class,a.source_type  location_type,a.source_code location_code,b.priority priority,b.order_catalog_code order_catalog_code  from or_order a, or_order_line b, am_Practitioner c  where a.order_id = b.order_id and a.order_type_code = b.order_type_code and a.order_category = b.order_category and a.ord_pract_id = c.practitioner_id and a.patient_id=? and upper(b.order_id) LIKE upper(?||'%') and a.order_category not in ('PH') and SUBSTR (a.order_id, 1, 2) NOT IN ('CS') and b.order_line_status not in ( select order_status_code from or_order_status_code where order_status_type in (60,70,75,85,90,93,96,97,99))   order by b.order_id desc,b.order_line_num");//--[IN034904] - Commented - include form_id value
	sqlMap.put( "sqlData", "select b.order_id order_id,b.order_line_num order_line_num, b.ORD_CONSENT_REQD_YN ord_consent_reqd_yn,b.catalog_synonym_dc catalog_desc,b.ORD_PRACT_ID ord_pract_id,c.practitioner_name practitioner_name,a.encounter_id encounter_id, b.order_type_code order_type_code, a.patient_class patient_class,a.source_type  location_type,a.source_code location_code,b.priority priority,b.order_catalog_code order_catalog_code, d.consent_form_id consent_form_id  from or_order a, or_order_line b, am_Practitioner c,or_order_catalog d  where a.order_id = b.order_id and a.order_type_code = b.order_type_code and a.order_category = b.order_category and a.ord_pract_id = c.practitioner_id and a.patient_id=? and upper(b.order_id) LIKE upper(?||'%') and a.order_category not in ('PH') and SUBSTR (a.order_id, 1, 2) NOT IN ('CS') and b.order_line_status not in ( select order_status_code from or_order_status_code where order_status_type in (60,70,75,85,90,93,96,97,99)) AND b.order_catalog_code = d.order_catalog_code   order by b.order_id desc,b.order_line_num");
	
	ArrayList selList = new ArrayList();
	ArrayList selList1 = new ArrayList();//--[IN029211]
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("order_id");
	displayFields.add("order_line_num" );
	displayFields.add("catalog_desc" );
	displayFields.add("practitioner_name" );
	displayFields.add("ord_consent_reqd_yn" );
	displayFields.add("encounter_id");
	displayFields.add("patient_class");
	displayFields.add("order_type_code");
	displayFields.add("location_code");
	displayFields.add("location_type");
	displayFields.add("PRIORITY");
	displayFields.add("order_catalog_code");
	displayFields.add("consent_form_id"); //--[IN034904]

	ArrayList chkFields = new ArrayList();

	chkFields.add(patientId);
	chkFields.add(orderid);
	
	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	int  n=0;
		
	String msg="";
	String msg1=""; //uncommented by --[IN029211]

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		//For display the previous/next link
	     out.println(result.get(1));
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		selList = bean.getSelectedCatalog();
		selList1 = bean.getSelectedOrderId(); //--[IN029211]

		//int count=0;
		int count1=0;
		
        for(int recCount=2; recCount<result.size(); recCount++) 
		{
           classvalue="gridData";

            _bw.write(_wl_block15Bytes, _wl_block15);

		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		 //  String link_columns = "1";

		records=(ArrayList) result.get( recCount );
	//	for(int colCount=0; colCount<records.size(); colCount+=12)//--[IN034904]
	// includ consent_form_id in all the js calls IN034904
		for(int colCount=0; colCount<records.size(); colCount+=13)
		{
			if(! msg.equals((String)records.get( colCount)))
			{	
				msg=(String)records.get( colCount);
				msg1=(String)records.get( colCount+2);//--[IN029211]

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(msg ));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( colCount+2)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records.get( colCount+1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records.get( colCount+3)));
            _bw.write(_wl_block22Bytes, _wl_block22);

					 //get_y_n=(String)records.get( colCount+4);
			
			n=n+1;				
			if(selList.contains(msg1) && selList1.contains(msg))
			{
				//String get_ord_id_line="";

				//	String strOrderId = "";


				/*if(cnt > 1)
				{
				get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";
				strOrderId = "1:";
				}
				else
				{
				}*/
				/*if(((String)records.get( colCount+1)).equals("1"))
				{
				get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";
				strOrderId = "1:";
				}
				else
				{
				get_ord_id_line = msg+":"+(String)getBeanOrderId.get(1);
				strOrderId = "1:2:";
				}*/

				//get_ord_id_line = msg +":"+(String)records.get( colCount+1)+":";




				//if((get_ord_id_line).equals((String)getBeanOrderId.get(0)+ ":"+(String)getBeanOrderId.get(count1+1)))
							
				if(selList.contains((String)records.get( colCount+2)) && selList1.contains((String)records.get( colCount)))//--[IN029211]
				{
					count1=count1+1;
					check="CHECKED";
					//chk = true;
											

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(n));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+5)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+6)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+8)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(check ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(msg ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block30Bytes, _wl_block30);

				}//153
				else if(selList1.contains(msg)) //Condition Added By --[IN029211] 
				{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(n));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+5)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+6)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+8)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block33Bytes, _wl_block33);
				
				}
				else
				{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+2)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)records.get(colCount+5)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+6)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+8)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msg ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block36Bytes, _wl_block36);
									//	} /////
				}
			}//149
			else
			{
				if(selList.size() != 0)
				{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(n));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+5)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+6)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)records.get(colCount+7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+8)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msg ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}
				else
				{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(n));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(n));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+5)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+6)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+8)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+11)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get( colCount+12)));
            _bw.write(_wl_block38Bytes, _wl_block38);

				}
			}
							
						//}//147
			//	else
			//		{
										
				
            _bw.write(_wl_block39Bytes, _wl_block39);
//=classvalue
            _bw.write(_wl_block24Bytes, _wl_block24);
//=n 
            _bw.write(_wl_block25Bytes, _wl_block25);
//=n 
            _bw.write(_wl_block26Bytes, _wl_block26);
//=msg 
            _bw.write(_wl_block35Bytes, _wl_block35);
//=(String)records.get( colCount+1)
            _bw.write(_wl_block35Bytes, _wl_block35);
//=(String)records.get( colCount+2)
            _bw.write(_wl_block40Bytes, _wl_block40);
//=msg 
            _bw.write(_wl_block35Bytes, _wl_block35);
//=(String)records.get( colCount+1)
            _bw.write(_wl_block41Bytes, _wl_block41);

			//	
			//		}
			/*	}//143
				else
				{
					*/
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);

			//	}//last else block 
		
						
		}
	}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean_id ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( localeName ));
            _bw.write(_wl_block49Bytes, _wl_block49);

	 //selList.clear();
	
}
else
{

            _bw.write(_wl_block50Bytes, _wl_block50);

	out.println("<script>window.close();</script>");
}	
out.println(CommonBean.setForm(request ,"../../eOR/jsp/RefusalOrderIDResults.jsp",searched) );

            _bw.write(_wl_block51Bytes, _wl_block51);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CatalogDescription.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderLineNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
