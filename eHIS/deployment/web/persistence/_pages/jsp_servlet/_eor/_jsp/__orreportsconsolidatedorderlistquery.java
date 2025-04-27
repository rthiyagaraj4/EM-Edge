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

public final class __orreportsconsolidatedorderlistquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORReportsConsolidatedOrderListQuery.jsp", 1709119900000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../js/OrCommonFunction.js\"></script>\n\n\t<script language=\"javascript\" src=\"../js/ORReportsConsolidatedOrderList.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n \n<body onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<BR><BR><BR><BR><BR><BR>\n<form name=\'RepConsolidatedOrderList\' id=\'RepConsolidatedOrderList\'  target=\'messageFrame\' action=\"../../eCommon/jsp/report_options.jsp\">\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\"98%\" align=\'center\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t\t<td colspan=\"5\">&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=label align=\'right\'>Patient ID&nbsp;</TD>\n        <TD>&nbsp;<input type=\'text\' width=\'16%\' name=\'p_patient_id\' id=\'p_patient_id\' value=\'\' nowrap   maxlength=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\'ChangeUpperCase(this)\'><input align=\'right\' type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\'button\' tabIndex=\"4\" onClick=\"callPatientSearch()\"></TD>\n        <TD colspan=\'3\'>&nbsp;</TD>\n\t</TR>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<tr>\n\t\t<td class=label align=\'right\' width=\'16%\'>From Order Status </td>\n\t\t<td width=\'16%\'>&nbsp;<SELECT name=\"p_from_staus\" id=\"p_from_staus\">\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<option value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</Option>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</SELECT></td>\n\t\t<td class=label align=\'right\' width=\'16%\'>To Order Status</td>\n\t\t<td>&nbsp;<SELECT name=\"p_to_status\" id=\"p_to_status\">\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</SELECT></td>\n\n\t\t<TD>&nbsp;</TD>\n\t</tr>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<TR>\n\t\t<TD align=\'right\' class=\'label\'>Location Type&nbsp;</TD>\n\t\t<TD>&nbsp;<Select name=\'p_location_type\' id=\'p_location_type\' onChange=\'clearLocations()\'><Option value=\'\'>All</Option>\n\t\t\t<Option value=\'N\'>Nursing Unit</Option>\n\t\t\t<Option value=\'C\'>Clinic</Option>\n\t\t\t</Select>\n\t\t</TD>\n\t\t<TD colspan=\'3\'>&nbsp;</TD></TR>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<TR>\n\t\t<TD class=label align=\'right\'>From Location&nbsp;</TD>\n        <TD>&nbsp;<input type=\'text\' width=\'16%\' name=\'from_location\' id=\'from_location\' value=\'\' nowrap   maxlength=\'15\' readonly><Input type=\'hidden\' name=\'p_from_location\' id=\'p_from_location\' value=\'\'><input align=\'right\' type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\'button\' tabIndex=\"4\" onClick=\"searchCode(this,from_location,p_from_location)\"></TD>\n        <TD class=label align=\'right\'>To Location&nbsp;</TD>\n        <TD>&nbsp;<input type=\'text\' width=\'16%\' name=\'to_location\' id=\'to_location\' value=\'\' nowrap   maxlength=\'15\' readonly><Input type=\'hidden\' name=\'p_to_location\' id=\'p_to_location\' value=\'\'><input align=\'right\' type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\'button\' tabIndex=\"4\" onClick=\"searchCode(this,to_location,p_to_location)\"></TD>\n        <TD>&nbsp;</TD>\n\t</TR>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<tr>\n\t\t<td width=\"35%\"  align=right class=\"label\">From Order Category&nbsp;</td>\n\t\t<td>&nbsp;<SELECT name=\"p_from_category\" id=\"p_from_category\" onChange=\'populateOrderTypes(this)\'>\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</Option>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</SELECT></td>  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td width=\"35%\"  align=\'right\' class=\"label\">To Order Category&nbsp;</td>\n\t\t<td>&nbsp;<SELECT name=\"p_to_category\" id=\"p_to_category\" onChange=\'populateOrderTypes(this)\'>\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</SELECT></td>\n\t\t\t<TD>&nbsp;</TD>\n\t</tr>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<tr>\n\t\t<td width=\"35%\"  align=\'right\' class=\"label\">From Order Type&nbsp;</td>\n\t\t<td>&nbsp;<SELECT name=\"p_from_order_type\" id=\"p_from_order_type\">\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<td width=\"35%\"  align=\'right\' class=\"label\">To Order Type&nbsp;</td>\n\t\t<td>&nbsp;<SELECT name=\"p_to_order_type\" id=\"p_to_order_type\">\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</SELECT></td>\n\t\t\t<TD>&nbsp;</TD>\n\t</tr>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<tr>\n\t\t<td class=\'label\' align=\'right\'>Order Date From</td>\n\t\t<td>&nbsp;<input type=\"text\" name=\"p_from_date_range\" id=\"p_from_date_range\" value=\"\" size=\"10\" maxlength=\"10\" onBlur=\"CheckDate(this)\" onKeyPress=\'return OrAllowDateFormat()\'></td>\n\t\t<td class=label align=\'right\'>To</td>\n\t\t<td>&nbsp;<input type=\'text\' name=\'p_to_date_range\' id=\'p_to_date_range\' value=\'\' size=\'10\' maxlength=\'10\' onBlur=\"CheckDate(this)\" onKeyPress=\'return OrAllowDateFormat()\'></td>\n\t\t<TD>&nbsp;</TD>\n\t</tr>\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n\t<TR>\n\t\t<TD class=\'label\' align=\'right\'>Group By</TD>\n\t\t<TD>&nbsp;<Select><Option value=\'E\'>Encounter Type</Option>\n\t\t\t<Option value=\'O\'>Order Category</Option></Select></TD>\n\t\t<TD colspan=\'3\'>&nbsp;</TD></TR>\n\n\t<tr><td colspan=\"5\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<Input type=\"hidden\" name=\'p_report_id\' id=\'p_report_id\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" VALUE=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n</form>\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String bean_id = "Or_ORReportsConsolidatedOrderList" ;
	String bean_name = "eOR.ORReportsConsolidatedOrderList";

	//String report = request.getParameter("rep");
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	ArrayList OrderType_Data = new ArrayList();
	ArrayList Status_Data = new ArrayList();


	/* Mandatory checks end */

	/* Initialize Function specific start */
	ORReportsConsolidatedOrderList bean = (ORReportsConsolidatedOrderList)getBeanObject( bean_id,  bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	int patient_id_length 	= 10;
	patient_id_length		= bean.getPatientIdLength();

	String p_report_id		= "ORRCOORL";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;


            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block11Bytes, _wl_block11);

			try{
				Status_Data = bean.getAllOrderStatus();

				for(int i=0; i<Status_Data.size(); i++){
					String[] record = (String [])Status_Data.get(i);

			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);
for(int i=0; i<Status_Data.size(); i++){
					String[] record = (String [])Status_Data.get(i);

			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
			
            _bw.write(_wl_block16Bytes, _wl_block16);

			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);

		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block19Bytes, _wl_block19);

			try{
				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                    e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block20Bytes, _wl_block20);

			try{
				OrderType_Data = bean.getAllOrderType();

				for(int i=0; i<OrderType_Data.size(); i++){
					String[] record = (String [])OrderType_Data.get(i);

		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block21Bytes, _wl_block21);

			try{
				for(int i=0; i<OrderType_Data.size(); i++){
					String[] record = (String [])OrderType_Data.get(i);
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block34Bytes, _wl_block34);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
