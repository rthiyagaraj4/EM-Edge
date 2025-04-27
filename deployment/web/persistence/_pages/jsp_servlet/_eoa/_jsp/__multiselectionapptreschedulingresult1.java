package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import org.json.simple.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __multiselectionapptreschedulingresult1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MultiSelectionApptReschedulingResult1.jsp", 1742452866457L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->\r\n<!DOCTYPE html>\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n<html>\r\n<head>\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\r\n<script language=\"javascript\" src=\"../../eOA/js/MultiSelectionApptRescheduling.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"> </script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n<script language=\'JavaScript\' src=\'../../eCommon/js/showModalDialog.js\' ></script>\r\n\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\r\n</head>\r\n\r\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\r\n\r\n<form name=\"MultiSelectionApptReschResult1Form\" id=\"MultiSelectionApptReschResult1Form\">\r\n\r\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'results1\'>\r\n\r\n<tr>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head1\' class=\'myClass\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head1\' class=\'myClass\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\'  ><div  id=\'head2\' width=\'12%\' class=\'myClass\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head3\'  class=\'myClass\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\'  ><div  id=\'head4\' width=\'12%\' class=\'myClass\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\r\n\t<th class=\'COLUMNHEADER\' ><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div></th>\r\n</tr>\r\n\r\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t<tr>\r\n\r\n\t\t<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" align=\"center\"><input type=\'checkbox\' name=\'select_check_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\'checkbox_value(this)\' value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" style=\'visibility:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\r\n\r\n\t\t<!--<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></td>-->\r\n\r\n\t\t<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\r\n\r\n\t\t<td width=\"10%\" nowrap class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\r\n\r\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\t<td width=\'23%\' nowrap class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\r\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t<td width=\'23%\' class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">&nbsp;</td>\r\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\r\n\r\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t<td width=\'13%\' nowrap class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t<td width=\'13%\' class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\r\n\r\n\t\t<input type=\'hidden\' name=\'from_srl_no_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\r\n\t\t<input type=\'hidden\' name=\'from_appt_ref_no_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\r\n\t\t<input type=\'hidden\' name=\'from_visit_type_ind_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\r\n\t\t<input type=\'hidden\' name=\'no_of_slots_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\r\n\r\n\t</tr>\r\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\r\n\r\n</table>\r\n\r\n<input type=\'hidden\' name=\'total_from_slot_count\' id=\'total_from_slot_count\'  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\r\n\r\n</form>\r\n\r\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\r\n\r\n</body>\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static JSONArray getFromSchedule(Connection con, String locale, String fac_id, String locn_type, String from_locn, String from_res_class, String from_resc, String from_date) throws Exception{
	
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	JSONArray ArrJSONSch	= new JSONArray();

	try{

		StringBuffer sql_label = new StringBuffer();

		sql_label.append("SELECT a.srl_no, a.pri_appt_ref_no, TO_CHAR (a.slot_slab_start_time, 'hh24:mi') AS slot_slab_start_time, TO_CHAR (a.slot_slab_end_time, 'hh24:mi') AS slot_slab_end_time, NVL (b.no_of_slots, 0) no_of_slots, b.patient_id, NVL (b.patient_name_loc_lang, b.patient_name) AS patient_name, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown' ) AS gender, (SELECT short_desc visit_type FROM op_visit_type_lang_vw WHERE visit_type_code = b.appt_type_code AND ROWNUM = 1) AS visit_type_desc, (SELECT visit_type_ind FROM op_visit_type_lang_vw WHERE visit_type_code = b.appt_type_code AND ROWNUM = 1) AS visit_type_ind, am_get_desc.am_contact_reason (b.contact_reason_code, ?, 1 ) AS reason_for_contact FROM oa_clinic_schedule_slot_slab a LEFT JOIN oa_appt b ON a.pri_appt_ref_no = b.appt_ref_no and a.facility_id = b.facility_id WHERE a.facility_id = ? AND a.care_locn_type_ind = ? AND a.clinic_code = ? AND a.resource_class = ? AND a.clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND ");

		if(from_resc.equals("")){
			sql_label.append("a.practitioner_id is null");
		}else{
			sql_label.append("a.practitioner_id = ?");
		}

		pstmt = con.prepareStatement(sql_label.toString());

		pstmt.setString(1,locale);
		pstmt.setString(2,fac_id);
		pstmt.setString(3,locn_type);
		pstmt.setString(4,from_locn);
		pstmt.setString(5,from_res_class);
		pstmt.setString(6,from_date);
		
		if(!from_resc.equals("")){
			pstmt.setString(7,from_resc);
		}

		rs = pstmt.executeQuery();

		while( rs != null && rs.next() ){

			JSONObject jsonObjSch = new JSONObject();

			String srl_no = rs.getString("srl_no")==null?"":rs.getString("srl_no");
			String pri_appt_ref_no = rs.getString("pri_appt_ref_no")==null?"":rs.getString("pri_appt_ref_no");
			String slot_slab_start_time	= rs.getString("slot_slab_start_time")==null?"":rs.getString("slot_slab_start_time");
			String slot_slab_end_time = rs.getString("slot_slab_end_time")==null?"":rs.getString("slot_slab_end_time");
			String patient_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			String patient_name = rs.getString("patient_name")==null?"":rs.getString("patient_name");
			String gender = rs.getString("gender")==null?"":rs.getString("gender");
			String visit_type_desc = rs.getString("visit_type_desc")==null?"":rs.getString("visit_type_desc");
			String visit_type_ind = rs.getString("visit_type_ind")==null?"":rs.getString("visit_type_ind");
			String reason_for_contact = rs.getString("reason_for_contact")==null?"":rs.getString("reason_for_contact");
			String no_of_slots = rs.getString("no_of_slots")==null?"":rs.getString("no_of_slots");
			
			jsonObjSch.put("srl_no",srl_no);
			jsonObjSch.put("pri_appt_ref_no",pri_appt_ref_no);
			jsonObjSch.put("slot_slab_start_time",slot_slab_start_time);
			jsonObjSch.put("slot_slab_end_time",slot_slab_end_time);
			jsonObjSch.put("patient_id",patient_id);
			jsonObjSch.put("patient_name",patient_name);
			jsonObjSch.put("gender",gender);
			jsonObjSch.put("visit_type_desc",visit_type_desc);
			jsonObjSch.put("visit_type_ind",visit_type_ind);
			jsonObjSch.put("reason_for_contact",reason_for_contact);
			jsonObjSch.put("no_of_slots",no_of_slots);

			ArrJSONSch.add(jsonObjSch);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getFromSchedule - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return ArrJSONSch;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection con = null;

int init = 0;
String classValue = "OAQRYEVEN";
String srl_no = "";
String pri_appt_ref_no = "";
String previous_appt_ref_no = "";
String slot_slab_start_time = "";
String slot_slab_end_time = "";
String patient_id = "";
String patient_name = "";
String gender = "";
String visit_type_desc = "";
String visit_type_ind = "";
String reason_for_contact = "";
String no_of_slots = "";
String selCheckboxValue = "";
String selCheckboxAttr = "";
String selCheckboxEnDis = "";
String selCheckboxVisibility = "visible";

try{
	con = ConnectionManager.getConnection(request);

	String locale = (String)session.getAttribute("LOCALE");
	String fac_id = (String) session.getValue( "facility_id" );

	String locn_type = request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";

	String from_speciality = request.getParameter("from_speciality");
	if(from_speciality ==null) from_speciality="";

	String from_locn = request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";

	String from_resc = request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";

	String from_date = request.getParameter("from_date");
	if(from_date ==null) from_date="";

	String from_res_class = request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";

	String to_speciality = request.getParameter("to_speciality");
	if(to_speciality ==null) to_speciality="";

	String to_locn = request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";

	String to_resc = request.getParameter("to_resc");
	if(to_resc ==null)to_resc="";

	String to_date = request.getParameter("to_date");
	if(to_date ==null) to_date="";

	String to_res_class = request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";

	String visit_limit_rule = request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


JSONArray ArrJSONSch = new JSONArray();
ArrJSONSch  = getFromSchedule(con,locale,fac_id,locn_type,from_locn,from_res_class,from_resc,from_date);	

for(int i = 0 ; i < ArrJSONSch.size() ; i++) 
{
	JSONObject jsonObjSch = (JSONObject)ArrJSONSch.get(i);

	srl_no = (String) jsonObjSch.get("srl_no");
	pri_appt_ref_no = (String) jsonObjSch.get("pri_appt_ref_no");

	if(pri_appt_ref_no.equals("")){
		selCheckboxValue = "N";
		selCheckboxAttr = "";
		selCheckboxEnDis = "Disabled";
	}else{
		selCheckboxValue = "Y";
		selCheckboxAttr = "Checked";
		selCheckboxEnDis = "";
	}

	if(previous_appt_ref_no.equals(pri_appt_ref_no) && !pri_appt_ref_no.equals("")){
		selCheckboxValue = "N";
		selCheckboxAttr = "";
		selCheckboxEnDis = "Disabled";
		selCheckboxVisibility = "hidden";
	}else{
		previous_appt_ref_no = pri_appt_ref_no;
		selCheckboxVisibility = "visible";
	}

	slot_slab_start_time = (String) jsonObjSch.get("slot_slab_start_time");
	slot_slab_end_time = (String) jsonObjSch.get("slot_slab_end_time");

	patient_id = (String) jsonObjSch.get("patient_id");

	if(patient_id.equals("")){
		patient_id="";
	}else{
		patient_id=patient_id+", ";
	}

	patient_name = (String) jsonObjSch.get("patient_name");
	gender = (String) jsonObjSch.get("gender");
	visit_type_desc = (String) jsonObjSch.get("visit_type_desc");
	visit_type_ind = (String) jsonObjSch.get("visit_type_ind");
	reason_for_contact = (String) jsonObjSch.get("reason_for_contact");
	no_of_slots = (String) jsonObjSch.get("no_of_slots");


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(init));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selCheckboxValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selCheckboxAttr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(selCheckboxEnDis));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selCheckboxVisibility));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(init));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selCheckboxValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selCheckboxAttr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(selCheckboxEnDis));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selCheckboxVisibility));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slot_slab_start_time));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slot_slab_end_time));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(!patient_name.equals("")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
if(!visit_type_desc.equals("")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(visit_type_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
if(!reason_for_contact.equals("")){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(reason_for_contact));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(init));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(init));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(pri_appt_ref_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(init));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(no_of_slots));
            _bw.write(_wl_block41Bytes, _wl_block41);


	init++;
}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(init));
            _bw.write(_wl_block43Bytes, _wl_block43);


}catch(Exception es){
	es.printStackTrace();
}
finally { 
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
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
}
