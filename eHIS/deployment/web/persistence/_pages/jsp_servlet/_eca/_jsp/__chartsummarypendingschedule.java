package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarypendingschedule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryPendingSchedule.jsp", 1709115706168L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction show_Reference_details(appt_no2,fac_id2)\n{\nvar dialogHeight = \"37.5\" ;\nvar dialogWidth\t= \"50\" ;\nvar dialogTop = \"160\" ;\nvar center = \"1\" ;\nvar status=\"no\";\nvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\nvar arguments\t= \"\" ;\nwindow.showModalDialog(\"../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2=\"+appt_no2+\"&fac_id2=\"+fac_id2,arguments,features);\n}\n\nfunction showToolTip(obj)\n{\n\tvar displayText = \"<table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\'center\'><td class=YELLOW>\"+getLabel(\"eCA.ClickheretoviewSecondaryResources.label\",\"CA\")+\"</td></table>\";\n\n\tdocument.getElementById(\"secondaryResources\").innerHTML = displayText;\n\t//document.getElementById(\"secondaryResources\").style.top  = obj.offsetTop+15; \n\tdocument.getElementById(\"secondaryResources\").style.top  = obj.offsetTop+30; //Changed for CHL_CRF Issue\n\tdocument.getElementById(\"secondaryResources\").style.left  = obj.offsetLeft ;\n\tdocument.getElementById(\"secondaryResources\").style.visibility=\'visible\' ;\n\t\n\t\n}\nfunction hideToolTip()\n{\n\tdocument.getElementById(\"secondaryResources\").style.visibility=\'hidden\' ;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n\t<!--<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>--><!--IN035950-->\n\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title><!--IN035950-->\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<center>\n\t\t<form name=\'CAViewPatientAllergyForm\' id=\'CAViewPatientAllergyForm\' method=\'post\'>\n\t\t<table class=\'grid\' colspan=9 width=\'100%\'>\n\t\t<!--IN037701 Starts-->\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnHeadercenter\'  colspan=\"1\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t<td class=\'columnHeadercenter\'  colspan=\"2\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<!--IN037701 Ends-->\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'gridData\'  colspan=\"1\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\'  colspan=\"2\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<tr><td class=\'gridData\' colspan=\'9\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'gridData\'  colspan=\"1\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="-";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n                       ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td class=\'gridData\'  colspan=\"1\" ><a class=\'gridLink\' href=\"javascript:show_Reference_details(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\" onMouseOver=\"showToolTip(this)\" onMouseOut=\"javascript:hideToolTip()\"> Ref:";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td></a></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                        <td class=\'gridData\'  colspan=\"2\" > Ref:";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td></tr>\n\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</table>\n\t\t</form>\n\t\t<div id=\'secondaryResources\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n\t</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
	String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(title));
            _bw.write(_wl_block10Bytes, _wl_block10);
if("CA_SPC".equals(p_called_from)){
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
 String patient_id = "", appt_date_str = "", pend_sche = "";
			String from_time_str = "",  to_time_str = "",classValue = "",	location_desc	=	"",currdate = "";
			String speciality_desc = "", resource_name = "",appt_ref_no = "",facility_id ="";
			int i=0,sec_resource_cnt=0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet	rs = null;
			String modified_date = "";
			String modified_by_id = "";
			try	{
				patient_id = request.getParameter("patient_id");
				if(patient_id==null) patient_id = "";
				facility_id=(String) session.getValue("facility_id");
				//pend_sche = "select TO_CHAR(APPT_DATE,'DD/MM/YYYY') APPT_DATE_STR, TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR, CLINIC_SHORT_DESC LOCATION_DESC, SPECIALITY_DESC, nvl2( PRACTITIONER_SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||PRACTITIONER_SHORT_NAME resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = oa_appt_vw.appt_ref_no  and FACILITY_ID=oa_appt_vw.FACILITY_ID)  sec_resource_cnt from oa_appt_vw where FACILITY_ID= ? AND PATIENT_ID=? AND  APPT_DATE>=trunc(sysdate) ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME ";
				// modified on 04/08/2010 for the Incident 23079	SRR20056-SCF-4928
				//pend_sche ="select TO_CHAR(APPT_DATE,'DD/MM/YYYY')APPT_DATE_STR,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI') TO_TIME_STR,(CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END )LOCATION_DESC,(CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_LANG_vW x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND X.LANGUAGE_ID = ? ) END ) SPECIALITY_DESC, nvl2( B.SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||B.SHORT_NAME resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = a.appt_ref_no  and oa_resource_for_appt.FACILITY_ID=a.FACILITY_ID) sec_resource_cnt from oa_appt_vw A,am_practitioner_lang_vw B where A.FACILITY_ID= ? AND A.PATIENT_ID=? AND  A.APPT_DATE>=trunc(sysdate) and b.practitioner_id=a.practitioner_id      and b.language_id=? and ((ORDER_ID is not null and exists (select 1 from or_order_line where ORDER_ID = a.ORDER_ID and ORDER_LINE_NUM = a.ORDER_LINE_NUM and order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code 	WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF= 'EXT_COMPL_ORD') or order_status_type in ('99','96','97','93'))))OR ORDER_ID is null) ORDER BY A.APPT_DATE, A.APPT_SLAB_FROM_TIME";
				pend_sche ="select TO_CHAR(APPT_DATE,'DD/MM/YYYY')APPT_DATE_STR,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR, TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI') TO_TIME_STR,(CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END )LOCATION_DESC,(CASE WHEN a.clinic_code IS NOT NULL THEN (SELECT x.short_desc FROM am_speciality_LANG_vW x, op_clinic y WHERE x.speciality_code = y.speciality_code AND y.facility_id = a.facility_id AND y.clinic_code = a.clinic_code AND X.LANGUAGE_ID = ? ) END ) SPECIALITY_DESC, DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room','Others')||'/'|| case when RESOURCE_CLASS='P' then am_get_desc.am_practitioner(PRACTITIONER_ID,?,'1') when RESOURCE_CLASS='R' then am_get_desc.AM_FACILITY_ROOM(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') else am_get_desc.AM_RESOURCE(a.FACILITY_ID,a.PRACTITIONER_ID,?,'1') end  resource_name, APPT_REF_NO,(select count(appt_ref_no) from oa_resource_for_appt where appt_ref_no = a.appt_ref_no  and oa_resource_for_appt.FACILITY_ID=a.FACILITY_ID) sec_resource_cnt,TO_CHAR(a.modified_date,'DD/MM/YYYY HH24:MI') modified_date,AM_GET_DESC.AM_PRACTITIONER(a.modified_by_id,?,1) pract_name from oa_appt_vw A where A.FACILITY_ID= ? AND A.PATIENT_ID=? AND  A.APPT_DATE>=trunc(sysdate) and ((ORDER_ID is not null and exists (select 1 from or_order_line where ORDER_ID = a.ORDER_ID and ORDER_LINE_NUM = a.ORDER_LINE_NUM and order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code 	WHERE order_status_type IN (SELECT order_status_type FROM OR_STATUS_APPLICABILITY WHERE OPER_OR_GROUP_REF= 'EXT_COMPL_ORD') or order_status_type in ('99','96','97','93'))))OR ORDER_ID is null) and appt_status = '1' ORDER BY A.APPT_DATE, A.APPT_SLAB_FROM_TIME";
				con = ConnectionManager.getConnection(request);
				pstmt	=	con.prepareStatement(pend_sche);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,locale);
				pstmt.setString(6,locale);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,patient_id);
		
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					i++;
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					appt_date_str			=	rs.getString("APPT_DATE_STR")== null ? "" : rs.getString("APPT_DATE_STR");
					from_time_str			=	rs.getString("FROM_TIME_STR")== null ? "" : rs.getString("FROM_TIME_STR");
					to_time_str				=	rs.getString("TO_TIME_STR") == null ? "" : rs.getString("TO_TIME_STR");
					location_desc			=	rs.getString("LOCATION_DESC") == null ? "" : rs.getString("LOCATION_DESC");
					speciality_desc			=	rs.getString("SPECIALITY_DESC") == null ? "" : rs.getString("SPECIALITY_DESC");
					resource_name			=	rs.getString("resource_name") == null ? "&nbsp;" : rs.getString("resource_name");
					appt_ref_no				=	rs.getString("APPT_REF_NO") == null ? "" : rs.getString("APPT_REF_NO"); 
					sec_resource_cnt		=	rs.getInt("sec_resource_cnt");
					modified_by_id				=	rs.getString("pract_name") == null ? "" : rs.getString("pract_name"); //IN037701
					modified_date				=	rs.getString("modified_date") == null ? "" : rs.getString("modified_date");//IN037701 
					appt_date_str		= com.ehis.util.DateUtils.convertDate(appt_date_str,"DMY","en",locale);
//					from_time_str		= com.ehis.util.DateUtils.convertDate(from_time_str,"DMYHM","en",locale);
//					to_time_str			= com.ehis.util.DateUtils.convertDate(to_time_str,"DMYHM","en",locale);
					modified_date			= com.ehis.util.DateUtils.convertDate(modified_date,"DMYHM","en",locale);//IN037701
					//IN037701 Starts
					if("CA_SPC".equals(p_called_from))
					{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(resource_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_date_str));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modified_by_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
					else{//IN037701 Ends
					if(!currdate.trim().equalsIgnoreCase(appt_date_str.trim())){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appt_date_str));
            _bw.write(_wl_block20Bytes, _wl_block20);
 currdate =	 appt_date_str; }
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_time_str));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(to_time_str));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(resource_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(sec_resource_cnt > 0)
					{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
						else
					{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
				}//IN037701
			}
		//IN035950  Starts
		if(i==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
		//IN035950  Ends
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}	catch(Exception e){
					//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}  finally	{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}
		
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PEND_SCH.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LOCATIONORPRACT.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.APPOINTMENTDATE.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ACCESSSEDBY.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ACCESSEDDATETIME.label", java.lang.String .class,"key"));
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
