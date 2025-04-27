package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dischargechecklisttab1appts extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListTab1Appts.jsp", 1740378350719L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\nasync function showRefDtls(ref_id)\n{\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"90vh\" ;\n\tvar dialogTop = \"\" ;\n\tvar dialogWidth\t= \"85vw\" ;\n\tvar status = \"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ; dialogTop:\" + dialogTop + \" ; scroll=no; status:\" + status ;\n\t\n\tvar retVal = await top.window.showModalDialog(\"../../eMP/jsp/ViewPatReferral.jsp?referral_id=\"+ref_id,arguments,features);\n}\n\nasync function view_appt_details(ref_no, pract_id, clinic_code, from_time, to_time, appt_date, res_class, care_locn_ind )\n{\n\tif(ref_no != \'\')\n\t{\n\t\tvar retVal\t\t=    new String();\n\t\tvar dialogHeight= \"70vh\";\t\n\t\tvar dialogWidth = \"80vw\";\n\t\tvar dialogTop\t= \"\";\n\t\tvar center\t\t= \"1\";\n\t\tvar status\t\t= \"no\";\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments   = \"\" ;\n\t\tretVal = await top.window.showModalDialog(\"../../eOA/jsp/AppointmentDetails1.jsp?calling_mode=IP&i_appt_ref_no=\"+ref_no,arguments,features);\n\t}\n}\n\nfunction setValue(obj)\n{\n\tif(obj.checked)\n\t\tobj.value=\'Y\';\n\telse\n\t\tobj.value = \'\';\n}\n\nfunction Valid_DT(event)\n{\n\t\tvar strCheck = \'0123456789:/ \';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  \n\t\tif (strCheck.indexOf(key) == -1) return false;  \n} \n\nfunction chk_with_sysdate(obj)\n{\n\tif(obj.value!=\'\')\n\t{\n\t\tvar to = parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;\n\t\tif(isAfter(obj.value,to.value,\"DMYHM\",localeName))\n\t\t{\n\t\t\tvar str = getMessage(\"CANNOT_GREATER\",\"MP\");\n\t\t\tstr = str.replace(\'#\', getLabel(\"Common.date.label\",\"Common\"));\n\t\t\tstr = str.replace(\'$\', getLabel(\"Common.SystemDate.label\",\"Common\"));\n\t\t\talert(str);\n\t\t\tobj.value=\"\";\n\t\t\t//obj.select();\n\t\t\t//obj.focus();\t\t\t\n\t\t}\n\t}\n}   \n\n</script>\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DischargeCheckListTab5\' id=\'DischargeCheckListTab5\'>\n\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'7\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t</tr>\n\t\t<tr></tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t<th width=\'16%\' align=\'center\' nowrap >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th width=\'12%\' align=\'center\' nowrap >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th width=\'15%\' align=\'center\' nowrap >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t<th width=\'10%\' align=\'center\' nowrap >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\'16%\' class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ><a href =\"javascript:showRefDtls(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'12%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'15%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'10%\' ><a href=\"javascript:view_appt_details(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></td>\n\t\t\t</tr>\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</table>\n<form>\n</body>\n</html>\n \n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

Connection con	= null;
ResultSet rset  = null; 
Statement stmt	= null;

String  patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String  facilityId			= (String)session.getValue("facility_id");
StringBuffer sqlSB			= new StringBuffer();
String  cname				= "";
String	care_locn_type_ind	= ""; 
String	appt_ref_no			= ""; 
String	referral_id			= ""; 
String	referral_date		= "";
String	to_pract_id			= "";
String	to_speciality_desc	= "";
String	Practitioner		= "";
String	to_ref_locn_desc	= "";
String	to_locn_type		= "";
String  to_nurs_unit_code	= "";
String  to_clinic_code		= "";
String  referred_to			= "";
String  Location_Code		= "";
String  Location_Desc		= "";
String  to_nurs_unit_desc	= "";
String  to_clinic_desc		= "";
String  to_ref_type			= "";
String  to_facility_name	= "";
String  from_time			= "";
String  to_time				= "";
String  appt_date			= "";
String  resource_class		= "";
String  apptNO				= "";
int		maxRecord			= 0;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	try
	{
		con	= ConnectionManager.getConnection(request);
		
		/*sqlSB.append(" SELECT count(*) FROM pr_referral_register a, OA_APPT b WHERE a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and BEDSIDE_REFERRAL_YN !='Y' order by a.REFERRAL_ID, a.REFERRAL_DATE desc");
		stmt	= con.createStatement();
		rset	= stmt.executeQuery(sqlSB.toString());

		

		
		int record_count = 0;
		if(rset!=null)
		{
			while(rset.next())
				record_count = rset.getInt(1);
		}
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		*/
		//if(record_count>0)
		//{

			if (sqlSB.length() > 0)
				sqlSB.delete(0, sqlSB.length());

			sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME , a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

			stmt= con.createStatement();
			rset	= stmt.executeQuery(sqlSB.toString());

			cname= "QRYEVEN" ;

			while(rset.next())
			{
				if(maxRecord==0)
				{
      
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
		
				}
		//if (sqlSB.length() > 0)
			//sqlSB.delete(0, sqlSB.length());
        

		//sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME PATIENT_NAME, a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

		/*sqlSB.append("SELECT b.CARE_LOCN_TYPE_IND care_locn_type_ind, b.APPT_REF_NO appt_ref_no, sm_get_desc.sm_facility_param(a.to_facility_id, '"+locale+"', 1) to_facility_name, to_char(b.appt_slab_from_time,'hh24:mi') from_time, to_char(b.appt_slab_to_time,'hh24:mi') to_time, to_char(b.appt_date,'dd/mm/rrrr') appt_date, b.resource_class resource_class,  a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/rrrr hh24:mi') sydate, a.REFERRAL_ID REFERRAL_ID, TO_CHAR (a.referral_date, 'dd/mm/rrrr') REFERRAL_DATE,  a.TO_REF_CODE TO_REF_CODE,  (CASE WHEN a.TO_REF_CODE IS NOT NULL THEN (AM_GET_DESC.AM_REFERRAL(a.TO_REF_CODE,'"+locale+"',1)) END ) TO_REF_DESC ,  a.PATIENT_ID PATIENT_ID, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME , a.TO_PRACT_ID TO_PRACT_ID,  a.TO_PRACT_NAME TO_REF_PRACT_NAME, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  (CASE WHEN a.TO_SPECIALITY_CODE IS NOT NULL THEN (AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,'"+locale+"',2)) END ) TO_SPECIALITY_DESC , a.TO_locn_DESC TO_REF_LOCN_DESC, a.TO_LOCN_TYPE TO_LOCN_TYPE, a.TO_SPECIALITY_CODE TO_SPECIALITY_CODE,  a.to_locn_code TO_CLINIC_CODE, a.to_locn_code TO_NURS_UNIT_CODE, (CASE WHEN a.TO_locn_CODE IS NOT NULL and a.to_locn_type != 'N' THEN (OP_GET_DESC.OP_CLINIC('"+facilityId+"', a.TO_locn_CODE,'"+locale+"',1)) END ) TO_CLINIC_DESC ,  (CASE WHEN a.to_locn_code IS NOT NULL and a.to_locn_type = 'N' THEN (IP_GET_DESC.IP_NURSING_UNIT('"+facilityId+"',a.to_locn_code,'"+locale+"',2)) END ) TO_NURS_UNIT_DESC  FROM pr_referral_register a, OA_APPT b  WHERE  a.ADDED_FACILITY_ID = b.facility_id (+) and a.REFERRAL_ID = b.REFERRAL_ID(+) and a.ADDED_FACILITY_ID = '"+facilityId+"' AND a.from_encounter_id = '"+encounter_id+"' and a.patient_id = '"+patient_id+"' and a.BEDSIDE_REFERRAL_YN !='Y'  order by a.REFERRAL_ID, a.REFERRAL_DATE desc");

		stmt= con.createStatement();
		rset	= stmt.executeQuery(sqlSB.toString());*/
		
		//if(rset != null)
		//{
				//cname= "QRYEVEN" ;
			//while(rset.next())
			//{
				if(cname.equals("QRYEVEN"))
					cname = "QRYODD" ;
				else
					cname = "QRYEVEN" ;
				
				care_locn_type_ind	= checkForNull(rset.getString("care_locn_type_ind"));
				appt_ref_no			= checkForNull(rset.getString("APPT_REF_NO"));

				if(appt_ref_no==null ||appt_ref_no.equals("")) appt_ref_no="&nbsp;";

				apptNO = rset.getString("APPT_REF_NO");	if(apptNO == null) apptNO = "";

				from_time			= checkForNull(rset.getString("FROM_TIME"));
				to_time				= checkForNull(rset.getString("TO_TIME"));
				appt_date			= checkForNull(rset.getString("APPT_DATE"));
				resource_class		= checkForNull(rset.getString("RESOURCE_CLASS"));
				referral_id			= checkForNull(rset.getString("REFERRAL_ID"));
				referral_date		= checkForNull(rset.getString("REFERRAL_DATE"));

				if(!(referral_date==null || referral_date.equals("")))
					referral_date = DateUtils.convertDate(referral_date,"DMY","en",locale);

				referred_to			= checkForNull(rset.getString("TO_REF_DESC"));
				if(referred_to.equals("")) 
				{
					to_facility_name	= checkForNull(rset.getString("TO_FACILITY_NAME"));
						if(to_facility_name.equals("")) to_facility_name = "&nbsp;";
							referred_to	= to_facility_name;
				}

				to_speciality_desc	= rset.getString("TO_SPECIALITY_DESC");
				if(to_speciality_desc == null) to_speciality_desc = "&nbsp;";
				to_pract_id			= checkForNull(rset.getString("TO_PRACT_ID"));
			
				Practitioner		= rset.getString("TO_REF_PRACT_NAME");
					if(Practitioner == null)	Practitioner = "&nbsp;";
				
				to_locn_type		= checkForNull(rset.getString("TO_LOCN_TYPE"));
				
				to_ref_type			= checkForNull(rset.getString("TO_REF_TYPE"));
					if(!to_ref_type.equals("L")) to_ref_type = "&nbsp;";

				if(to_locn_type.equals("N") || to_locn_type.equals("D") )
				{
					to_nurs_unit_code	= checkForNull(rset.getString("TO_NURS_UNIT_CODE"));
					to_nurs_unit_desc	= checkForNull(rset.getString("TO_NURS_UNIT_DESC"));
					Location_Code		= to_nurs_unit_code;
					Location_Desc		= to_nurs_unit_desc;
				}
				else if(to_locn_type.equals("C") || to_locn_type.equals("E"))
				{
					to_clinic_code		= checkForNull(rset.getString("TO_CLINIC_CODE"));
					to_clinic_desc		= checkForNull(rset.getString("TO_CLINIC_DESC"));
					
					Location_Code		= to_clinic_code;
					Location_Desc		= to_clinic_desc;
				}
				else
				{
					to_ref_locn_desc	= checkForNull(rset.getString("TO_REF_LOCN_DESC"));
					Location_Desc		= to_ref_locn_desc;
				}

				if(Location_Desc == null || Location_Desc.equals("")) 
					Location_Desc = "&nbsp;";
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(referral_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(referred_to));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(to_speciality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Location_Desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Practitioner));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cname));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(apptNO));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(to_pract_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Location_Code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
		
				maxRecord++;
			}
		
		//}
	//}

		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();

	}catch(Exception e) 
	{ 
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.FollowupAppointments.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredOn.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
