package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarypendingordersd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryPendingOrdersD.jsp", 1738058108955L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n<!--  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCA/html/CAHomeIeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n<head>\n\t<!--<title></title> [IN035950]-->\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title><!--[IN035950]-->\n\t<script>\n\tasync function orderFormatWindow(orderId,lineId){\n\t\n\t\tvar dialogHeight =\'80vh\' ;\n\t\tvar dialogWidth = \'80vw\' ;\n\t\tvar dialogTop\t= \'\';\n\t\tvar dialogLeft = \'\' ;\n\t\tvar title = \'\'\n\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\';dialogTitle:\'+title+\'; scroll=yes; status=no\';\n\n\t\tvar arguments = \"\";\n\t\tvar finalString\t= \"orderId=\"+ orderId+\"&lineId=\"+lineId;\n\n\t\tvar retVals = await window.showModalDialog(\"../../eOR/jsp/ViewOrderFormatFrame.jsp?\"+finalString,arguments,features);\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!-- <script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n\t<center>\n\t\t<form name=\'CAViewPatientAllergyForm\' id=\'CAViewPatientAllergyForm\' method=\'post\'>\n\t\t<table width=\'100%\' class=\'grid\' align=\'center\'>\n\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<!-- <tr><td class=\'columnHeadercenter\' colspan=\"2\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr> IN035950 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tr><td class=\'columnHeadercenter\' colspan=\"3\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<tr><td class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' colspan=\"3\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t \n\t\t\t\t\t\t<td class=\'gridData\'  >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<!-- </td> commented for IN061896 -->\n\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<td class=\'gridData\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<!-- </td> commented for IN061896 -->\n\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<!-- IN061896 start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t \t\t<img  title=\"Overdue\" src=\'../../eCA/images/order_overdue.PNG\' align=\'center\'></td><!--IN065781-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\t\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<!-- IN061896 end -->\t\t\n\t\t\t\t\t\t<td class=\'gridData\' nowrap><B>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td>\n\t\t\t\t\t\t<td class=\'gridData\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<a class=\'gridLink\' href=\"javascript:orderFormatWindow(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\"><img src=\'../../eOR/images/Flex_red.gif\' align=\'center\'></a>\n\t\t\t\t\t\t\t</tr>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\t</tr>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</table>\n\t\t</form>\n\t</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.
19/06/2013		IN040967		ChowminyaG		System doesn?t sorting data by start date/time											
02/06/2014	  	IN037701		Ramesh G		SKR-CRF-0036											
09/09/2014      PER0909			Akbar	     	Performance changes suggested by sunil									
10/11/2017		IN061896		Kamalakannan G			System should show icon for stat pending orders
16/11/2017 		IN065781		Kamalakannan G			icon link removed
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String prefStyleSheet = request.getParameter("prefStyle");
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);
			
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			String practitioner_type = (String)session.getValue("practitioner_type");
			String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");			
			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet	rs = null;
			//[IN035950] Starts
			String order_category = request.getParameter("order_category");
			System.out.println("ChartSummaryPendingOrders.jsp--->"+order_category);
			if ("null".equals(order_category) || order_category==" ") order_category="";
			String date_from = request.getParameter("p_date_from");
			String date_to = request.getParameter("p_date_to");
			//[IN035950] Ends

			try
			{	String patient_id = "", query_pending_orders = "";
				String test_date_time = "", item_short_desc = 	"",item_short_desc_ms="",category_short_desc = "",category="",order_type_code="" ,format_exist_yn = "",orderId="",lineId="";
				String overdue_yn = ""; //IN061896
				String classValue = "";
				int i=0;
				patient_id = request.getParameter("patient_id");
				if(patient_id==null) patient_id = "";
				
				String currCategory = "";
				 
				//PER0909 - Start
				//query_pending_orders = "SELECT DISTINCT b.order_category,b.ORDER_TYPE_CODE, c.short_desc order_category_short_desc,TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc,e.catalog_synonym||DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,'en','1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,'en','1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY('"+facilityId+"',b.order_uom,'"+locale+"')|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num, b.start_date_time date_to_sort FROM or_order a,or_order_line b,or_order_category_lang_vw c,am_duration_type d,or_catalog_synonym_lang_vw e WHERE b.order_category = c.order_category AND b.order_catalog_code = e.order_catalog_code AND e.language_id = ? AND catalog_synonym_type =    or_get_synonym_type(?,b.order_catalog_code) AND patient_id = ? AND a.order_id = b.order_id AND b.durn_type = d.durn_type(+) AND b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')AND c.language_id = ?  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY c.short_desc,b.order_category,date_to_sort DESC";//IN040967
				/* IN061896 Start*/
				//query_pending_orders = "SELECT b.order_category,b.ORDER_TYPE_CODE, (select short_desc from or_order_category_lang_vw where language_id = ? and order_Category = b.order_category) order_category_short_desc, TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc , (select catalog_synonym from or_catalog_synonym_lang_vw where  language_id = ?  AND catalog_synonym_type = or_get_synonym_type ('PH', b.order_catalog_code) and order_catalog_code = b.order_catalog_code) || DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,?,'1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,?,'1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY(?,b.order_uom,?)|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num, b.start_date_time date_to_sort FROM or_order a,or_order_line b WHERE patient_id = ? AND a.order_id = b.order_id AND b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY 3,b.order_category,date_to_sort DESC";//IN040967
				//PER0909 - End
				query_pending_orders = "SELECT b.order_category,b.ORDER_TYPE_CODE, (select short_desc from or_order_category_lang_vw where language_id = ? and order_Category = b.order_category) order_category_short_desc, TO_CHAR (b.start_date_time,'dd/mm/yyyy HH24:MI') test_date_time,   or_get_order_catalog(a.order_id,a.order_type_code,?,?,b.order_line_num)  item_short_desc , (select catalog_synonym from or_catalog_synonym_lang_vw where  language_id = ?  AND catalog_synonym_type = or_get_synonym_type ('PH', b.order_catalog_code) and order_catalog_code = b.order_catalog_code) || DECODE(a.order_category,'PH', ((SELECT DECODE(am_get_desc.am_trade_name(trade_code,?,'1'),NULL, '','['|| am_get_desc.am_trade_name(trade_code,?,'1')|| ']') trade_name FROM or_order_line_ph WHERE order_id = b.order_id AND order_line_num = b.order_line_num))|| '<br />'|| RTRIM(RTRIM(TO_CHAR (b.order_qty,'9999999999999990.999999999999'),'0'), '.')|| ' '|| PH_GET_UOM_DISPLAY(?,b.order_uom,?)|| ' '|| ( '['|| TO_CHAR (b.start_date_time, 'dd/mm/yyyy')||']'),'') item_short_desc_ms,NVL2 (line_fields_display_text, 'Y', 'N') format_exist_yn,b.order_id order_id, b.order_line_num order_line_num, b.start_date_time date_to_sort,OR_STATORDER_OVERDUE_YN(b.ORDER_CATEGORY,b.ORDER_CATALOG_CODE,b.START_DATE_TIME,b.PRIORITY) OVERDUE_YN FROM or_order a,or_order_line b WHERE patient_id = ? AND a.order_id = b.order_id AND b.order_line_status IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN (10,15,16,17,20,23,25,30,40,45,50,52,54,55,65,67)) AND NVL(a.cont_order_ind, 'DO') IN ('DO', 'CO', 'CR', 'DR') and EXISTS (SELECT 1 FROM or_order_catalog WHERE order_catalog_code=b.order_catalog_code AND ORDER_CATALOG_NATURE != 'S')  &&ORDER_CAT_FILTER &&DATE_FROM_FILTER &&DATE_TO_FILTER ORDER BY 3,b.order_category,date_to_sort DESC";//IN061896 end
				if((!"".equals(order_category)) && (null!=order_category)){
					query_pending_orders=query_pending_orders.replace("&&ORDER_CAT_FILTER", "AND A.ORDER_CATEGORY = ? AND B.ORDER_CATEGORY = ?");	
				}
				else{
					query_pending_orders=query_pending_orders.replace("&&ORDER_CAT_FILTER", "");
				}
				if((!"".equals(date_to)) && (null!=date_to))
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_FROM_FILTER", "and b.start_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' )");
				}
				else
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_FROM_FILTER", "");
				}
				//
				if((!"".equals(date_from)) && (null!=date_from))
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_TO_FILTER", "and b.end_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' )");
				}
				else
				{
				query_pending_orders=query_pending_orders.replace("&&DATE_TO_FILTER", "");
				}
				//[IN035950] Ends
				//Modified by Uma on 7/2/2009 for IN08174

				con = ConnectionManager.getConnection(request);

				String orInstallYn="select 1 from  sm_module where module_id='OR' and INSTALL_YN='Y'";
				pstmt1 = con.prepareStatement(orInstallYn);

				if(rs != null) rs = null;
				rs = pstmt1.executeQuery();
				int index=1;//[IN035950]				
				if(rs.next())
				{
				if(rs!=null)rs.close();
				pstmt	=	con.prepareStatement(query_pending_orders);
				//[IN035950] Starts				
				/*pstmt.setString(1,locale);
				pstmt.setString(2,practitioner_type);
				pstmt.setString(3,locale);	
				pstmt.setString(4,practitioner_type);
				pstmt.setString(5,patient_id);				
				pstmt.setString(6,locale);				
				
				if((!"".equals(order_category)) 	&& (null!=order_category)){
				pstmt.setString(7,order_category);
				pstmt.setString(8,order_category);
				}*/
				pstmt.setString(index++,locale);	//PER0909
				pstmt.setString(index++,locale);
				pstmt.setString(index++,practitioner_type);
				pstmt.setString(index++,locale);
				//PER0909 - start					
				pstmt.setString(index++,locale);	
				pstmt.setString(index++,locale);	
				pstmt.setString(index++,facilityId);	
				pstmt.setString(index++,locale);	
				//pstmt.setString(index++,practitioner_type);
				//PER0909 - end
				pstmt.setString(index++,patient_id);
				//pstmt.setString(index++,locale);		//PER0909
				if((!"".equals(order_category)) && (null!=order_category)){
				pstmt.setString(index++,order_category);
				pstmt.setString(index++,order_category);
				}
				if((!"".equals(date_from)) && (null!=date_from))
				{
				pstmt.setString(index++,date_from);
				}
				if((!"".equals(date_to)) && (null!=date_to))
				{
				pstmt.setString(index++,date_to);
				}
				//[IN035950] Ends
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					i++;

					if(i%2==0) classValue = "CAQUERYEVEN";
					else classValue = "CAQUERYODD";

					test_date_time			= rs.getString("test_date_time");

					if(test_date_time == null)
						test_date_time = "";
					

					test_date_time = com.ehis.util.DateUtils.convertDate(test_date_time,"DMYHM","en",locale);

					item_short_desc			= rs.getString("item_short_desc");				
					overdue_yn			= rs.getString("overdue_yn");//IN061896
					order_type_code			= rs.getString("ORDER_TYPE_CODE");
					item_short_desc_ms		= rs.getString("item_short_desc_MS");
					category_short_desc		= rs.getString("order_category_short_desc");
					category				= rs.getString("order_category");
					format_exist_yn			= rs.getString("format_exist_yn");
					orderId					= rs.getString("order_id");
					lineId					= rs.getString("order_line_num");

					if(test_date_time==null)	test_date_time	= "&nbsp;";
					if(item_short_desc==null)	item_short_desc	= "&nbsp;";
					if(format_exist_yn==null)	format_exist_yn	= "N";
					if(orderId==null)	orderId	= "";
					if(lineId==null)	lineId	= "";
					if(!currCategory.trim().equalsIgnoreCase(category_short_desc.trim()))
					{
					
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(category_short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

						//IN035950 Starts
						if(sStyle.equals(prefStyleSheet) || "CA_SPC".equals(p_called_from))//IN037701
						{
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(category_short_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(category_short_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
						//IN035950 Ends
						currCategory = 	 category_short_desc;
				    }

			
            _bw.write(_wl_block16Bytes, _wl_block16);
if((category.equals("PH") && order_type_code.equals("MS"))){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_short_desc_ms));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_short_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

								if(overdue_yn.equals("Y"))
								{
								
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(test_date_time));
            _bw.write(_wl_block25Bytes, _wl_block25);

						if(format_exist_yn.equals("Y"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(lineId));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						else
						{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

				}
				
				if(i==0)
				{
				out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
				}
				
			} // module install
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
