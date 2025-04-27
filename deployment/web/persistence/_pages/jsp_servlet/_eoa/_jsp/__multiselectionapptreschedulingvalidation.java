package jsp_servlet._eoa._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __multiselectionapptreschedulingvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MultiSelectionApptReschedulingValidation.jsp", 1717499903643L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\tvar flag=true;\r\n\tvar error=true;\r\n\tvar cnt_val=\"\";\r\n\tvar max_pat_per_day=\"\";\r\n\tvar tot_booked=\"\";\r\n\tvar max_forced_in_booking=\"\";\r\n\tvar max_pat_per_day_from=\"\";\r\n\tvar tot_booked_from=\"\";\r\n\tvar max_forced_in_booking_from=\"\";\r\n\tvar total_forced_in_booked_to=\"\";\r\n\tvar max_over_booking_from=\"\"; \r\n\tvar total_overbooked_from=\"\";\r\n\tvar max_over_booking_to=\"\"; \r\n\tvar total_overbooked_to=\"\";\r\n\tvar total_first_visit_slots_booked_from=\"\";\r\n\tvar total_other_visit_slots_booked_from=\"\";\r\n\tvar total_first_visit_slots_booked_to=\"\";\r\n\tvar total_other_visit_slots_booked_to=\"\";\r\n\tvar max_first_visits_to=\"\";\r\n\tvar max_other_visits_to=\"\";\r\n\tvar max_first_visits_from=\"\";\r\n\tvar max_other_visits_from=\"\";\r\n\tvar schedule_extend_to=\"\";\r\n\tvar schedule_extend_from=\"\";\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\t\t\terror=true;\r\n\t\t\tmax_pat_per_day=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =";\r\n\t\t\ttot_booked=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\r\n\t\t\tmax_forced_in_booking=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =";\r\n\t\t\ttotal_forced_in_booked_to=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =";\r\n\t\t\tmax_pat_per_day_from=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =";\r\n\t\t\ttot_booked_from=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =";\r\n\t\t\tmax_forced_in_booking_from=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";\r\n\t\t\tmax_over_booking_from=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\r\n\t\t\ttotal_overbooked_from=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";\r\n\t\t\tmax_over_booking_to=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\r\n\t\t\ttotal_overbooked_to=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";\r\n\t\t\ttotal_first_visit_slots_booked_from=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\r\n\t\t\ttotal_other_visit_slots_booked_from=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";\r\n\t\t\ttotal_first_visit_slots_booked_to=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";\r\n\t\t\ttotal_other_visit_slots_booked_to=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";\r\n\t\t\tmax_first_visits_to=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";\r\n\t\t\tmax_other_visits_to=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";\r\n\t\t\tmax_first_visits_from=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =";\r\n\t\t\tmax_other_visits_from=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";\r\n\t\t\tschedule_extend_to=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =";\r\n\t\t\tschedule_extend_from=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =";\r\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\terror=false;\r\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\tflag=false;\r\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n\t\tflag=true;\r\n\t\tcnt_val=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\tflag=true;\r\n\t\t max_pat_per_day=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";\r\n\t\t tot_booked=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =";\r\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="var flag1=true;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="var flag2=true;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="var TT_empty=false;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="var scheduleStatusFlag=false;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="flag1=false;\r\n\t\tflag2=false;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="flag1=true;\r\n\t\tflag2=true;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\t\t\t\tflag1=false;\r\n\t\t\t\tscheduleStatusFlag=true;\r\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="parent.frames[1].document.getElementById(\'time_table_type\').value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\r\n\t\t\t\tflag1=true;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="flag1=false;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="flag1=false;\r\n\t\tTT_empty=true;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\r\n\r\n\t\tvar i=1;\r\n\t\tvar len=parent.frames[1].document.getElementById(\'b_loc2\').options.length;\r\n\t\tvar lBox=parent.frames[1].document.getElementById(\'b_loc2\'); \r\n\r\n\t\twhile(i<=len){\r\n\t\t\tlBox.remove(lBox.options[i]);\r\n\t\t\ti+=1;\r\n\t\t}\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\r\n\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\r\n\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\r\n\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\r\n\t\t\t\tparent.frames[1].document.getElementById(\'b_loc2\').add(element);\r\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\r\n\t\tparent.frames[1].document.getElementById(\'resourceType1\').value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'location_code1\').value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'specialty_code1\').value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'locationType1\').value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\r\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\r\n\t\tparent.frames[1].document.getElementById(\'resourceType3\').value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'location_code2\').value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'specialty_code2\').value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\r\n\t\tparent.frames[1].document.getElementById(\'locationType2\').value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="var flag;";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" \r\n\t\t\t\t\tflag=\"T\"; \r\n\t\t\t\t\tdocument.getElementById(\'sec_value_count\').value=\"Y\"; ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" flag=\"F\";\r\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\r\n\r\n\t\t\t\tif(flag==\'T\'){\r\n\t\t\t\t\tdocument.getElementById(\'sec_value_count\').value=\"Y\"; \r\n\t\t\t\t}else{\r\n\t\t\t\t\tdocument.getElementById(\'sec_value_count\').value=\"N\";\r\n\t\t\t\t}";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
ResultSet rs = null;
ResultSet rs3 = null;
Statement stmtas = null;
Statement stmt = null;
ResultSet rset_sec_value = null;

try{
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	con = ConnectionManager.getConnection(request);

	stmtas = con.createStatement();
	stmt = con.createStatement();

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String facilityId = (String) session.getValue("facility_id");
	String loginuser = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
	String steps = (String) hash.get("steps");
	String from_date = (String) hash.get("from_date");
	String clinic_type = (String) hash.get("clinic_type");
	String resc_code = (String) hash.get("resc_code");
	String resc_class = (String) hash.get("resc_class");
	String to_date = (String) hash.get("to_date");
	String clinic_type_to = (String) hash.get("clinic_type_to");
	String resc_code_to	= (String) hash.get("resc_code_to");
	String resc_class_to = (String) hash.get("resc_class_to");
	String locn_type = (String) hash.get("locn_type");
	String Sys_date	= (String) hash.get("Sys_date");
	String CARE_LOCN_TYPE_IND = (String) hash.get("CARE_LOCN_TYPE_IND");
	String speciality_code = (String) hash.get("speciality_code");
	String clinic_code1 = (String) hash.get("clinic_code1");
	String sec_req = (String) hash.get("sec_req");
	String clinic_code_sec = (String) hash.get("clinic_code");
	String clinic_date_sec = (String) hash.get("clinic_date");
	String facility_id_sec = (String) hash.get("facility_id");
	String sel_sec = (String) hash.get("sel_sec");

	if(steps.equals("bulktransfer_sch_exists")){
	int cnt_from=0;
	int cnt_to=0;
	int MAX_PATIENTS_PER_DAY=0;
	int TOTAL_SLOTS_BOOKED=0;
	int MAX_FORCED_IN_BOOKING=0;
	int MAX_PATIENTS_PER_DAY_FROM=0;
	int TOTAL_SLOTS_BOOKED_FROM=0;
	int MAX_FORCED_IN_BOOKING_FROM=0;
	int TOTAL_FORCED_IN_BOOKED=0;
	int MAX_OVER_BOOKING_FROM=0; 
	int TOTAL_OVERBOOKED_FROM=0;
	int MAX_OVER_BOOKING_TO=0; 
	int TOTAL_OVERBOOKED_TO=0;
	int TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM=0;
	int TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM=0;
	int TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO=0;
	int TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO=0;
	int MAX_FIRST_VISITS_TO=0;
	int MAX_OTHER_VISITS_TO=0;
	int MAX_FIRST_VISITS_FROM=0;
	int MAX_OTHER_VISITS_FROM=0;
	int SCHEDULE_EXTEND_TO=0;
	String SCHEDULE_EXTEND_TO_STR="";
	int SCHEDULE_EXTEND_FROM=0;
	String SCHEDULE_EXTEND_FROM_STR="";

            _bw.write(_wl_block2Bytes, _wl_block2);

	StringBuffer sql_from = new StringBuffer();

	 sql_from.append("SELECT Count(*) FROM oa_appt WHERE appt_date=To_Date('"+from_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"' and Trunc(APPT_DATE) >=Trunc(sysdate) ");

	if(from_date.equals(Sys_date))
	{
		sql_from.append("and to_char(APPT_SLAB_TO_TIME,'hh24:mi') >= to_char(sysdate,'hh24:mi')");
	}

	if(resc_code.equals("")){
		sql_from.append(" AND PRACTITIONER_ID is null");
	}else{
		sql_from.append(" AND PRACTITIONER_ID ='"+resc_code+"'");
	}

	rs = stmtas.executeQuery(sql_from.toString());

	if(rs!=null && rs.next()) 
	{
		cnt_from = rs.getInt(1);
	}
	if(rs !=null) rs.close();
	
	if(cnt_from > 0)
	{
		StringBuffer sql_to = new StringBuffer();

		sql_to.append("SELECT MAX_PATIENTS_PER_DAY,TOTAL_SLOTS_BOOKED,MAX_FORCED_IN_BOOKING,TOTAL_FORCED_IN_BOOKED ,MAX_OVER_BOOKING ,TOTAL_OVERBOOKED,TOTAL_FIRST_VISIT_SLOTS_BOOKED,nvl(TOTAL_FOLLOW_UP,0)+ nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0) other_visits_booked,MAX_FIRST_VISITS,MAX_OTHER_VISITS,nvl(SCHEDULE_EXTEND_YN,'N') SCHEDULE_EXTEND_YN FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+to_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type_to+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class_to+"' ");

		if(resc_code_to.equals("")){
			sql_to.append("AND PRACTITIONER_ID is null");
		}else{
			sql_to.append("AND PRACTITIONER_ID ='"+resc_code_to+"'");
		}

		rs = stmtas.executeQuery(sql_to.toString());

		if(rs!=null && rs.next()) 
		{
			MAX_PATIENTS_PER_DAY=rs.getInt("MAX_PATIENTS_PER_DAY");
			TOTAL_SLOTS_BOOKED=rs.getInt("TOTAL_SLOTS_BOOKED");
			MAX_FORCED_IN_BOOKING=rs.getInt("MAX_FORCED_IN_BOOKING");
			TOTAL_FORCED_IN_BOOKED=rs.getInt("TOTAL_FORCED_IN_BOOKED");
			MAX_OVER_BOOKING_TO=rs.getInt("MAX_OVER_BOOKING");
			TOTAL_OVERBOOKED_TO=rs.getInt("TOTAL_OVERBOOKED");
			TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO=rs.getInt("TOTAL_FIRST_VISIT_SLOTS_BOOKED");
			TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO=rs.getInt("other_visits_booked");
			MAX_FIRST_VISITS_TO=rs.getInt("MAX_FIRST_VISITS");
			MAX_OTHER_VISITS_TO=rs.getInt("MAX_OTHER_VISITS");
			SCHEDULE_EXTEND_TO_STR=rs.getString("SCHEDULE_EXTEND_YN");
			if(SCHEDULE_EXTEND_TO_STR.equals("Y"))
				SCHEDULE_EXTEND_TO=1; 
			cnt_to=1;
		}else
		{
			cnt_to=0;
		}

		if(rs !=null) rs.close();

		StringBuffer sql_appt_form = new StringBuffer();

		 sql_appt_form.append("SELECT MAX_FIRST_VISITS,MAX_OTHER_VISITS,MAX_PATIENTS_PER_DAY,TOTAL_SLOTS_BOOKED,TOTAL_FORCED_IN_BOOKED,MAX_OVER_BOOKING ,TOTAL_OVERBOOKED,TOTAL_FIRST_VISIT_SLOTS_BOOKED,nvl(TOTAL_FOLLOW_UP,0)+ nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0) other_visits_booked,nvl(SCHEDULE_EXTEND_YN,'N') SCHEDULE_EXTEND_YN FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+from_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"'");

		if(resc_code.equals("")){
			sql_appt_form.append(" AND PRACTITIONER_ID is null");
		}else{
			sql_appt_form.append(" AND PRACTITIONER_ID ='"+resc_code+"'");
		}

		rs=stmtas.executeQuery(sql_appt_form.toString());

		if(rs!=null && rs.next())  
		{
			MAX_PATIENTS_PER_DAY_FROM=rs.getInt("MAX_PATIENTS_PER_DAY");
			TOTAL_SLOTS_BOOKED_FROM=rs.getInt("TOTAL_SLOTS_BOOKED");
			MAX_FORCED_IN_BOOKING_FROM=rs.getInt("TOTAL_FORCED_IN_BOOKED");
			MAX_OVER_BOOKING_FROM=rs.getInt("MAX_OVER_BOOKING");
			TOTAL_OVERBOOKED_FROM=rs.getInt("TOTAL_OVERBOOKED");
			TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM=rs.getInt("TOTAL_FIRST_VISIT_SLOTS_BOOKED");
			TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM=rs.getInt("other_visits_booked");
			MAX_FIRST_VISITS_FROM=rs.getInt("MAX_FIRST_VISITS");
			MAX_OTHER_VISITS_FROM=rs.getInt("MAX_OTHER_VISITS");
			SCHEDULE_EXTEND_FROM_STR=rs.getString("SCHEDULE_EXTEND_YN");
			if(SCHEDULE_EXTEND_FROM_STR.equals("Y"))
				SCHEDULE_EXTEND_FROM=1;
			cnt_to=1;
		}

		if(cnt_to >0)
		{
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(MAX_PATIENTS_PER_DAY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(TOTAL_SLOTS_BOOKED));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(MAX_FORCED_IN_BOOKING));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(TOTAL_FORCED_IN_BOOKED));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(MAX_PATIENTS_PER_DAY_FROM));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(TOTAL_SLOTS_BOOKED_FROM));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(MAX_FORCED_IN_BOOKING_FROM));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(MAX_OVER_BOOKING_FROM));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(TOTAL_OVERBOOKED_FROM));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(MAX_OVER_BOOKING_TO));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(TOTAL_OVERBOOKED_TO));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(MAX_FIRST_VISITS_TO));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(MAX_OTHER_VISITS_TO));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(MAX_FIRST_VISITS_FROM));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(MAX_OTHER_VISITS_FROM));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(SCHEDULE_EXTEND_TO));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(SCHEDULE_EXTEND_FROM));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}else
		{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	}else
	{
            _bw.write(_wl_block26Bytes, _wl_block26);

	}
	
	if(cnt_from >0 )
	{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(cnt_from));

	}else if(cnt_to >0)
	{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(MAX_PATIENTS_PER_DAY));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(TOTAL_SLOTS_BOOKED));
            _bw.write(_wl_block30Bytes, _wl_block30);

	}else
	{
            _bw.write(_wl_block26Bytes, _wl_block26);
}

	session.removeAttribute("sec_resc_val_old");
	}
	else if(steps.equals("bulktransfer_slot_slab_freeformat")){
	String time_table_type_from="";
	String time_table_type_to="";
	String schedule_status="";
	
            _bw.write(_wl_block31Bytes, _wl_block31);

	
            _bw.write(_wl_block32Bytes, _wl_block32);

	
            _bw.write(_wl_block33Bytes, _wl_block33);

	
            _bw.write(_wl_block34Bytes, _wl_block34);


	StringBuffer sql_from = new StringBuffer();

	 sql_from.append("SELECT TIME_TABLE_TYPE FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+from_date+"','dd/mm/yyyy') AND 	clinic_code='"+clinic_type+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"'");

	if(resc_code.equals("")){
		sql_from.append(" AND PRACTITIONER_ID is null");
	}else{
		sql_from.append(" AND PRACTITIONER_ID ='"+resc_code+"'");
	}

	rs=stmtas.executeQuery(sql_from.toString());
	if(rs!=null && rs.next()) 
	{
		time_table_type_from=rs.getString(1);
	}

	if(rs !=null) rs.close();

	StringBuffer sql_to = new StringBuffer();

		sql_to.append("SELECT TIME_TABLE_TYPE,schedule_status FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+to_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type_to+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class_to+"' ");

		if(resc_code_to.equals("")){
			sql_to.append("AND PRACTITIONER_ID is null");
		}else{
			sql_to.append("AND PRACTITIONER_ID ='"+resc_code_to+"'");
		}

	rs=stmtas.executeQuery(sql_to.toString());
	if(rs!=null && rs.next()) 
	{
		time_table_type_to=rs.getString(1);
		schedule_status=rs.getString(2);
	}
		
	if(time_table_type_from.equals("3") || time_table_type_to.equals("3"))
	{
		
            _bw.write(_wl_block35Bytes, _wl_block35);

	}else
	{
		
            _bw.write(_wl_block36Bytes, _wl_block36);

	}

	if(!time_table_type_from.equals("") && !time_table_type_to.equals("")){
		if(time_table_type_from.equals(time_table_type_to )){			
			if(schedule_status!=null && schedule_status.equals("B")){
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
				
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(time_table_type_from));
            _bw.write(_wl_block39Bytes, _wl_block39);

			}
		}else{
			
            _bw.write(_wl_block40Bytes, _wl_block40);

		}
	}else{
		
            _bw.write(_wl_block41Bytes, _wl_block41);

	}

	}else if(steps.equals("ADD_BULK_SEC_TO_SESSION"))
	{
		String 	SEC_RESC_VAL= (String) hash.get("sel_sec");
		session.putValue("sec_resc_val_old",SEC_RESC_VAL);

	}else if(steps.equals("REMOVE_ADD_BULK_SEC_TO_SESSION"))
	{
		session.removeAttribute("sec_resc_val_old");

		String 	SEC_RESC_VAL= (String) hash.get("sel_sec");
		session.putValue("sec_resc_val_old",SEC_RESC_VAL);

	}else if(steps.equals("bulk_Loc")){
		String sql="select locn_type, short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and CARE_LOCN_TYPE_IND='"+CARE_LOCN_TYPE_IND+"' and language_id = '"+locale+"' order by short_desc";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
	
		String b_loc1_value ="";
		String b_loc1_name ="";
		
            _bw.write(_wl_block42Bytes, _wl_block42);

		if(rs!=null) {
			while(rs.next()) {
				b_loc1_value= rs.getString("CARE_LOCN_TYPE_IND");
				b_loc1_name = rs.getString("short_desc");
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(b_loc1_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(b_loc1_value));
            _bw.write(_wl_block45Bytes, _wl_block45);
    
			}
		}

	}else if(steps.equals("bulk_enable_pract_from")){
		String location	= (String) hash.get("location");

		String sql = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		}
		
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(location));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block50Bytes, _wl_block50);


	}else if(steps.equals("bulk_enable_pract_to")){

		String location	= (String) hash.get("location");

		String sql = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		}

		
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(location));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block50Bytes, _wl_block50);

	}else if(steps.equals("ADD_SEC_TO_SESSION")){
		int sec_count=0;
		String sec_value="";

		
            _bw.write(_wl_block55Bytes, _wl_block55);

		sec_value="select count(practitioner_id) sum from oa_clinic_schedule where clinic_code='"+clinic_code_sec+"' and  trunc(clinic_date)=to_date('"+clinic_date_sec+"','dd/mm/yyyy') and facility_id='"+facility_id_sec+"' and primary_resource_yn='N' and resource_class in ("+sec_req+") and time_table_type in (1,2) group by resource_class";

		rset_sec_value=stmtas.executeQuery(sec_value);
		
		if(rset_sec_value !=null){
			while( rset_sec_value.next()){
				sec_count=rset_sec_value.getInt("sum");
			
				if(sec_count >1){
            _bw.write(_wl_block56Bytes, _wl_block56);

					break ;
				}else{
					
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

			}
		}

		session.putValue("SEC_RES_SEL",sel_sec);

		if(stmtas !=null) stmtas.close();
	}

	if(rs !=null) rs.close();
	if(rs3 !=null) rs3.close();
	if(stmtas !=null) stmtas.close();
	if(stmt!= null) stmt.close() ;

	hash.clear();

}catch( Exception e ){
	e.printStackTrace();
}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block59Bytes, _wl_block59);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
