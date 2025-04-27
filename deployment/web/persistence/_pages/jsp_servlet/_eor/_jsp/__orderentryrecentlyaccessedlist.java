package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryrecentlyaccessedlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryRecentlyAccessedList.jsp", 1709119828000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- \t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n -->\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name =\"recentlyAccessedForm\">\n<table class=\"BOX\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t  <td class=\"LABEL\" align=\"RIGHT\" width=\"20%\" onClick=\'parent.parent.displayToolTip(escape(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"),escape(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"),\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"recentlyAccessedForm_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\' onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"recentlyAccessedForm\")\' onMouseOut=\"hideToolTip()\"> <font size=1 color=\"BLUE\">\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t  <td class=\"LABEL\" align=\"RIGHT\" width=\"20%\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"recentlyAccessedForm\")\' onMouseOut=\"hideToolTip()\"><font size=1>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<input type=\"hidden\" name=\"catalog_desc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"catalog_desc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t</font></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<td class=\"LABEL\" align=\"center\" width=\"5%\" >\n\t \n\t\t\t\t\t<input type=\"checkbox\"  name=\"ck";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"ck";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"Y\" onClick=\'parent.parent.setCheckBoxVal(this,escape(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"),\"recentlyAccessedForm_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\", \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\t\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"h1";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"h2";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"prompt_desc";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"prompt_desc";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_warn";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"bill_warn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_warn_err";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"bill_warn_err";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"bill_error";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"bill_error";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"LABEL\" align=\"left\" width=\"3%\" nowrap>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\t\t\t\t&nbsp;<img id=\'authorization\"+i+\"\' src=\"../../eOR/images/Authorization.gif\" align=\"center\" title=\"Authorization\"></img>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\t\t<img id=\'special_approval\"+i+\"\' src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\" title=\"Special Approval\"></img>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t</table>\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"N\">\t<!-- To identify that atleast one of the checkbox(catalog) is checked -->\n\t<input type=\"hidden\" name=\"care_set_check_box_val\" id=\"care_set_check_box_val\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"discharge_date_time\" id=\"discharge_date_time\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n </form>\n \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n \t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n \t\t   \t<tr>\n \t\t \t\t<td width=\'100%\' id=\'t\'></td>\n \t\t\t</tr>\n \t\t</table>\n\t</div>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
		//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		OrderEntryBean	 bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
 	String patient_id	 		= bean.checkForNull(request.getParameter("patient_id"),"");
 	String order_category 		= bean.checkForNull(request.getParameter("order_category"),"");
	// if it null, then take by default there should be 10 occurances
 	String no_of_occurances 	= bean.checkForNull(request.getParameter("no_of_occurances"),"10");
	String search_by			= bean.checkForNull(request.getParameter("search_by"),"");
 	String entryValue			= "";
	String prev_group_title		= "";
	String checkedAttribute 	= "";
	String disabled				= "";
	String care_set_order		= "";
	String order_catalog_category = "";
	String key					= (bean.getPatientId()+bean.getEncounterId());
 	if(!order_category.equals(""))	order_category = order_category.trim();
 	int i=0;int count = 0; // counters for loop
	String amend_key			= "";
	HashMap previousValues		= null;
	HashMap amendPreviousValues = null;
 	StringTokenizer stBillMsg	= null;
	Set setValues 				= null;
	Iterator iterator			= null;
	
	String bill_warn_message	= null;
	String bill_warn_err_message= null;
	String bill_error_message	= null;
	String measure_id			= "" , contr_msr_panel_id = "";
	String category				= "";

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		// Since at the maximum there will be 100 or 150 records no need for next/previous
 		ArrayList FrequentOrdersPractitionerItems =  bean.getFrequentOrdersItems(search_by, patient_id,  no_of_occurances,order_category);
 	
		String[] records	= null;
		for(i=0; i<FrequentOrdersPractitionerItems.size(); i++)
		{
			checkedAttribute = "";disabled= "";
			records = (String[])FrequentOrdersPractitionerItems.get(i);
			if(!prev_group_title.equals(records[0]))
			{
				if( count%1 > 0)
				{
					 for (int u=0;u<1-count%1;u++)
						out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>");
					out.println("</tr>");
				}
				count =0 ;
				out.println("<tr>");
				out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\">"+records[0]+" </td>");
				out.println("</tr><tr>");
			}
			//Order Catalog Nature --> records[3]
			if(records[3].equals("P") || records[3].equals("S"))
			{
				contr_msr_panel_id 	= records[10];
				category     		= records[7];
				if(records[3].equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
				{
					measure_id 		= records[4]; // discrete_measure_id
				}
				else if(records[3].equals("S")) // Pass the catalog_code
				{
					measure_id 		= records[1]; // Catalog Code
				}
			} // End of If
			if(!records[3].equals("") && (records[3].equalsIgnoreCase("P")) || records[3].equalsIgnoreCase("S"))
			{
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(records[3]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(category));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
			}
			else
			{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);
			}  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records[2]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records[1]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records[1]));
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records[2]));
            _bw.write(_wl_block22Bytes, _wl_block22);

				 previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
				if(previousValues!=null)
				{
					setValues 		 = previousValues.keySet();
		   			iterator 		 = setValues.iterator();
		   			for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		   			{
						entryValue = ((String)iterator.next()) ;
						if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
						{
							// For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
							care_set_order = (String)previousValues.get(entryValue) ;
							if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
								care_set_order = "Y";
						}
						// For the checkboxes
						if(entryValue.equalsIgnoreCase("ck"+(String)records[1]))
						{
							checkedAttribute	= "CHECKED";
							break;
						}
						else
						   checkedAttribute 	= "";
					} // End of For
				}
				/*Added by Uma on 8/24/2009 for PMG20089 -CRF 641*/
				// From the Query priv_yn_yn --> depending upon the privilege level.
				if(records[13]!=null && records[13].equals("Y"))
					disabled		 = "";
				else
					disabled		 = "DISABLED";
				/*End Here*/
			// For Amend of Review Order
				if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
				{
					amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
					amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
					if(amendPreviousValues!=null)
					{
						setValues 	 = amendPreviousValues.keySet();
						iterator 	 = setValues.iterator();
						for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
						{
							 entryValue = ((String)iterator.next()) ;
							if(entryValue.equalsIgnoreCase("ck"+(String)records[1]))
							{
								checkedAttribute = "CHECKED";
								disabled		 = "DISABLED";
								break;
							}
						}
					}
				}
				if(records[3].equals("S")) // For Care Sets
				{
				   order_catalog_category 	= "CS";
				   order_category	  		= "CS";
				}
				else
				   order_catalog_category 	= ((String)records[7]);
 
				// Billing Informations Retrieved
				if(((String)records[12])!=null)
				{
					stBillMsg	= new StringTokenizer(((String)records[12]),"|");
					while(stBillMsg.hasMoreTokens())
					{
						  bill_warn_message		= stBillMsg.nextToken();
						  bill_warn_err_message	= stBillMsg.nextToken();
						  bill_error_message	= stBillMsg.nextToken();
						  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
						  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
						  if(bill_error_message.equals("*")) bill_error_message 	= "";
					}
				}
 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records[5]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(checkedAttribute));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records[8]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)records[6],"")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bill_warn_message));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bill_warn_err_message));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bill_error_message));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)records[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean.checkForNull((String)records[14],"")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block45Bytes, _wl_block45);
				if(((String)records[9]).equalsIgnoreCase("Y")) // For Authorization Required
				{

            _bw.write(_wl_block46Bytes, _wl_block46);
				}	
            _bw.write(_wl_block1Bytes, _wl_block1);
 				if(((String)records[11]).equalsIgnoreCase("Y")) // For Special Approval Required
				{

            _bw.write(_wl_block47Bytes, _wl_block47);
				}	
            _bw.write(_wl_block48Bytes, _wl_block48);

			count++;
			if( count % 1 == 0)
				  out.println("</tr><tr>");
			prev_group_title = records[0];
		} // End of for
		if( count % 1 > 0)
		{
			for (int u=0;u<1-count%1;u++)
		 		out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
			 	out.println("</tr>");
		}

		//if(FrequentOrdersPractitionerItems.size()==0)
		//{
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script> ");
		//}

		// Nullifying the objects
		previousValues					= null;			amendPreviousValues = null;
		stBillMsg						= null;
		setValues						= null;			iterator			= null;
		FrequentOrdersPractitionerItems = null;			records				= null;

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(care_set_order));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bean.getVisitAdmDate()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean.getDischargeDateTime()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block58Bytes, _wl_block58);

	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryFrequentAccessedPractitionerItems.label", java.lang.String .class,"key"));
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
}
