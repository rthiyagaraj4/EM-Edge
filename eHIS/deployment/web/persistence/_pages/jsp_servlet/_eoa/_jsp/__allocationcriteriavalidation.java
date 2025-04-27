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
import java.net.*;
import webbeans.eCommon.*;

public final class __allocationcriteriavalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AllocationCriteriaValidation.jsp", 1722399224386L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eOA/js/BookAppointment.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n</head>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t <script>\n\t\t\t\tvar err_age = getMessage( \"AGE_GENDER_NOT_MATCH\",\"OA\" ) ;\n\t\t\t\talert(err_age);\n\t\t\t\tclear_all_fun_alcn();\t\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t <script>\n\t\t\t\tApply();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t <script>\n\t\t\t Apply();\n\t\t</script>\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <script>\n\t\t\tvar err_age = getMessage( \"FIRST_VISIT_ONLY_ALLOWED\",\"OA\") ;\n\t\t\talert(err_age);\n\t\t\tparent.frames[2].document.forms[0].Insupd.disabled=false;\n\t\t\tparent.document.frames[0].document.forms[0].visit_type_short_desc.focus();\n\t\t</script>\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\tvar err_age = getMessage( \"NO_SERVICE_VISIT_FIRST_VISIT_ONLY\",\"OA\") ;\n\t\t\talert(err_age);\n\t\t\tparent.frames[2].document.forms[0].Insupd.disabled=false;\n\t\t\tparent.document.frames[0].document.forms[0].visit_type_short_desc.focus();\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\n\t\t\t Apply();\n\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script>\n\talert(getMessage(\'APPT_OVERLAP_NOT_PROCEED\',\'OA\'));\n\t\t\tclear_fun_all();\n\n\t</script>\n  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n <script>\n\tcheckagegender();\n </script>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<script>\nparent.document.frames[0].document.forms[0].patient_id.value=\'\';\nparent.document.frames[0].document.forms[0].patient_id.disabled=false;\nparent.document.frames[0].document.getElementById(\"pat_ser_but\").disabled=false;\nparent.document.frames[0].document.forms[0].patient_name.value=\'\';\nparent.document.frames[0].document.forms[0].patient_name.readOnly=false;\nif (parent.document.frames[0].document.forms[0].national_id){\nparent.document.frames[0].document.forms[0].national_id.value=\'\';\nparent.document.frames[0].document.forms[0].national_id.readOnly=false;}\nif(parent.document.frames[0].document.forms[0].other_id1!=null)\n\tparent.document.frames[0].document.forms[0].other_id1.style.visibility=\'hidden\';\n\n</script>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].name_prefix.value=\'\';\n    parent.document.frames[0].document.forms[0].name_prefix.disabled=false;\n\t</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].first_name.value=\'\';\n\tparent.document.frames[0].document.forms[0].first_name.readOnly=false;\n\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].second_name.value=\'\';\n\tparent.document.frames[0].document.forms[0].second_name.readOnly=true;\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].third_name.value=\'\';\n\tparent.document.frames[0].document.forms[0].third_name.readOnly=false;\n\t</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].family_name.value=\'\';\n\tparent.document.frames[0].document.forms[0].family_name.readOnly=false;\n\t</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\tparent.document.frames[0].document.forms[0].name_suffix.value=\'\';\n\tparent.document.frames[0].document.forms[0].name_suffix.disabled=false;\n\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\n\t<script>\n\tparent.document.frames[0].document.forms[0].sex.value=\'\';\n\tparent.document.frames[0].document.forms[0].sex.disabled=false;\n\tparent.document.frames[0].document.forms[0].nationality.value=\'\';\n\tparent.document.frames[0].document.forms[0].date_of_birth.value=\'\';\n\tparent.document.frames[0].document.forms[0].date_of_birth.readOnly=false;\n\tparent.document.frames[0].document.forms[0].b_age.value=\'\';\n\tparent.document.frames[0].document.forms[0].b_age.readOnly=false;\n\tparent.document.frames[0].document.forms[0].b_months.value=\'\';\n\tparent.document.frames[0].document.forms[0].b_months.readOnly=false;\n\tparent.document.frames[0].document.forms[0].b_days.value=\'\';\n\tparent.document.frames[0].document.forms[0].b_days.readOnly=false;\n\tparent.document.frames[0].document.forms[0].contact1_no.value=\'\';\n\tparent.document.frames[0].document.forms[0].contact2_no.value=\'\';\n\tparent.document.frames[0].document.forms[0].email.value=\'\';\n\tparent.document.frames[0].document.forms[0].OtherAppts.disabled=false;\n\tparent.document.frames[0].document.forms[0].source.disabled=false;\n\tparent.document.frames[0].document.forms[0].source.value=\'\';\n    parent.document.frames[0].document.getElementById(\"ref_ser_but\").disabled=false;\n\t\t\t\t\t\t\t\t\t\n\tallow_book=false;\n</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script>\n\tcheckagegender();\n\t</script>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'MULTI_SLOT_NOT_AVAILABLE\',\'OA\'));\n\t\t\t\t\tclear_all_fun_alcn();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\'test_time()\',500);\n\t\t\t\t\tfunction test_time(){\n\t\t\t\t\t\tvar allow_book_across=confirm(getMessage(\"APPT_BOOK_ANOTHER_CAT\",\"OA\"));\n\t\t\t\t\t\tif(allow_book_across){\n\t\t\t\t\t\t\tparent.document.frames[0].document.Bkappt_form.book_apt_acr_cat_yn.value=\"Y\";\n\t\t\t\t\t\t\t checkagegender();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'APPT_CAN_NOT_BOOK_OTH_CAT\',\'OA\'));\n\t\t\t\t    clear_all_fun_alcn();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t\t\tsetTimeout(\'test_time()\',500);\n\t\t\tfunction test_time(){\n\t\t\t\tvar allow_book_across=confirm(getMessage(\"APPT_BOOK_ANOTHER_CAT\",\"OA\"));\n\t\t\t\tif(allow_book_across){\n\t\t\t\t\tparent.document.frames[0].document.Bkappt_form.book_apt_acr_cat_yn.value=\"Y\";\n\t\t\t\t\tcheckagegender();\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\t\talert(getMessage(\'APPT_CAN_NOT_BOOK_OTH_CAT\',\'OA\'));\n\t\t\tclear_all_fun_alcn();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<script>\n\t//Added by Suman\n\talert(getMessage(\'APPT_OVERLAP_NOT_PROCEED\',\'OA\'));\n\tclear_fun_all();\n\t</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\n\n";
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

Connection con = null;
ResultSet rs=null;
ResultSet prs=null;
ResultSet prs1=null;
request.setCharacterEncoding("UTF-8");	

Statement stmt = null;
PreparedStatement pstmt =null;
String facilityid=(String)session.getValue("facility_id");
String step=request.getParameter("step");
//String locale=(String)session.getAttribute("LOCALE");
if (step==null) step ="";
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
 if (step.equals("3")){
		 String clinic_code=request.getParameter("clinic_code");
		 String gender=request.getParameter("gender");
		 String date_of_birth=request.getParameter("date_of_birth");
	
		 String sql =  "select count(1) cnt from op_clinic a where clinic_code =? and  ((age_group_code is null ) or ((age_group_code is not null) and  exists (select age_group.age_group_code from am_age_group age_group  where age_group.age_group_code=a.age_group_code and nvl(age_group.gender,?)=? and trunc(sysdate)-trunc(to_date(?,'dd/mm/yyyy')) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id = ?" ;
		 pstmt=con.prepareStatement(sql);
		 pstmt.setString(1,clinic_code);
		 pstmt.setString(2,gender);
		 pstmt.setString(3,gender);
		 pstmt.setString(4,date_of_birth);
		 pstmt.setString(5,facilityid);
		 prs=pstmt.executeQuery();
		 int cnt=0;


		 while(prs!=null&&prs.next()){
		  cnt = prs.getInt(1);
		  if (cnt==0){ 
            _bw.write(_wl_block7Bytes, _wl_block7);

		  }else{
			 
            _bw.write(_wl_block8Bytes, _wl_block8);

		  }
		}
	 
}	
else if (step.equals("4"))
	{

	 String clinic_code  = request.getParameter("clinic_code");
	 String patient_id   = request.getParameter("patient_id");
	 String service_code = request.getParameter("service_code");
	 String sel_service_code = request.getParameter("sel_service_code");
	 String vtype_ind = request.getParameter("vtype_ind");
	 String override_vtype_on_epsd_yn=""; 
	if(clinic_code==null) clinic_code="";
	if(patient_id==null) patient_id="";
	if(service_code==null) service_code="";
	if(vtype_ind==null) vtype_ind="";
	if(pstmt !=null) pstmt.close();
	if(prs !=null)prs.close();
	//String sql =  "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID='"+facilityid+"'" ;
	String sql =  "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID=?" ;
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,facilityid);
	 prs=pstmt.executeQuery();
	 int cnt=0;
	 if(prs!=null && prs.next()){
	 override_vtype_on_epsd_yn = prs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
	 }
	 String sql_one="";
	  if (override_vtype_on_epsd_yn.equals("N") && !vtype_ind.equals("F"))
		 {
		  if(sel_service_code==null || sel_service_code.equals("")){
			 // sql_one="select count(*) count from pr_encounter where facility_id ='"+facilityid+"'and assign_care_locn_code = '"+clinic_code+"' and patient_id ='"+patient_id+"'  AND visit_adm_type_ind = 'F'  and patient_class = 'OP'";
			  sql_one="select count(*) count from pr_encounter where facility_id =? and assign_care_locn_code = ? and patient_id =?  AND visit_adm_type_ind = 'F'  and patient_class = 'OP'";
		  }
		  else{
			//  sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = '"+facilityid+"' AND service_code = '"+sel_service_code+"' and patient_id ='"+patient_id+"'   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
			  sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = ? AND service_code = ? and patient_id = ?   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
		  }

		  //prs1=stmt.executeQuery(sql_one);
		  pstmt = con.prepareStatement(sql_one);
		  if (override_vtype_on_epsd_yn.equals("N") && !vtype_ind.equals("F"))
		 {
		  if(sel_service_code==null || sel_service_code.equals("")){
		  pstmt.setString(1,facilityid);
		  pstmt.setString(2,clinic_code);
		  pstmt.setString(3,patient_id);
		 }
		 }
		 else{
		  pstmt.setString(1,facilityid);
		  pstmt.setString(2,sel_service_code);
		  pstmt.setString(3,patient_id);
		 }
		  prs1 = pstmt.executeQuery();
		  while(prs1 !=null && prs1.next())
		 {
			cnt=prs1.getInt("count");
		 }

		 if(cnt >=1)
		 {
            _bw.write(_wl_block9Bytes, _wl_block9);
}else
		{
			//Called during normal book appointment on click of "Confirm Booking"
			if(sel_service_code==null || sel_service_code.equals("")){
		 
            _bw.write(_wl_block10Bytes, _wl_block10);

			}else{
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}
    
		}else {
            _bw.write(_wl_block12Bytes, _wl_block12);
}
}
else
{


String clinic_code=request.getParameter("clinic_code");
String practitioner_id=request.getParameter("practitioner_id");
String clinic_date=request.getParameter("appt_date");
String facilityId=(String)session.getValue("facility_id");
String pat_cat=request.getParameter("pat_cat");
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
if(pat_cat==null) pat_cat="";
String no_slots=request.getParameter("no_slots");
if(no_slots==null) no_slots="0";
if(no_slots==""||no_slots.equals("")) no_slots="0";
int no_slots_value=Integer.parseInt(no_slots);
String book_appt_across_catg_yn=request.getParameter("book_appt_across_catg_yn");
String from_time=request.getParameter("from_time");
String to_time=request.getParameter("to_time");
String patient_id=request.getParameter("patient_id");
String time_table_type=request.getParameter("time_table_type");
String clinic_type=request.getParameter("clinic_type");
String c_name_prefix_accept_yn="";
String c_first_name_accept_yn="";
String c_second_name_accept_yn="";
String c_third_name_accept_yn="";
String c_family_name_accept_yn="";
String c_name_suffix_accept_yn="";
boolean allow_book=true;
boolean overlap=false;
String chk="";
String chk_cat_limit="";

//Added by Suman
if(pat_cat.equals(""))
	{
			
			//if(time_table_type.equals("1"))
		//{
			//String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'" ;
			//rs = stmt.executeQuery(chk_overlap1) ;
			String chk_overlap1= "select '1'  from oa_appt where ((to_date(?,'HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(?,'HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date(?,'hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date(?,'hh24:miss'))) and appt_date = to_date(?,'dd/mm/yyyy') and patient_id=?	and CARE_LOCN_TYPE_IND=?" ;
			pstmt = con.prepareStatement(chk_overlap1);
			pstmt.setString(1,from_time);
			pstmt.setString(2,to_time);
			pstmt.setString(3,from_time);
			pstmt.setString(4,to_time);
			pstmt.setString(5,clinic_date);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,clinic_type);
			rs = pstmt.executeQuery();
			if(rs !=null){
				if(rs.next())
				{
					chk=rs.getString(1);
					overlap=true;
				}
				else
				{
				overlap=false;
				}
		  }
		/*}else if(time_table_type.equals("2") || time_table_type.equals("3"))
		{
			//String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"' and clinic_code='"+clinic_code+"'" ;
			String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'" ;
			System.out.println("chk_overlap1 time_table2:"+chk_overlap1);
			rs = stmt.executeQuery(chk_overlap1) ;
			if(rs !=null){
			if(rs.next())
			{
				chk=rs.getString(1);
				overlap=true;
		    }
			else
				{
			overlap=false;

			}
			
			
	}
		}*/
if(rs !=null) rs.close();
if (overlap){
            _bw.write(_wl_block13Bytes, _wl_block13);

}else{
 
            _bw.write(_wl_block14Bytes, _wl_block14);

				
}


}else{

if(allow_book){
	if (no_slots_value>1 && time_table_type.equals("1") && slot_appt_ctrl.equals("S"))
	{
		if(practitioner_id== null || practitioner_id.equals("")){
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id ='"+facilityId+"' and a.clinic_code='"+clinic_code+"'  and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= '"+pat_cat+"'and a.max_patients >= a.total_booked_patients +"+no_slots_value+"";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id =? and a.clinic_code=?  and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= ? and a.max_patients >= a.total_booked_patients + ?";
		}else{
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id ='"+facilityId+"' and a.clinic_code='"+clinic_code+"'  and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id ='"+practitioner_id+"' and a.alcn_catg_code= '"+pat_cat+"'and a.max_patients >= a.total_booked_patients +"+no_slots_value+"";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id =? and a.alcn_catg_code= ? and a.max_patients >= a.total_booked_patients +? ";
		}
		
	}else{
		if(practitioner_id== null || practitioner_id.equals("")){
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id ='"+facilityId+"'   and a.clinic_code='"+clinic_code+"' and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= '"+pat_cat+"' and a.max_patients > a.total_booked_patients";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= ? and a.max_patients > a.total_booked_patients";

		}else{
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id ='"+facilityId+"'   and a.clinic_code='"+clinic_code+"' and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id= '"+practitioner_id+"' and a.alcn_catg_code= '"+pat_cat+"' and a.max_patients > a.total_booked_patients";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id= ? and a.alcn_catg_code= ? and a.max_patients > a.total_booked_patients";

		}
	}
			//rs = stmt.executeQuery(chk_cat_limit) ;
			pstmt = con.prepareStatement(chk_cat_limit);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			if (no_slots_value>1 && time_table_type.equals("1") && slot_appt_ctrl.equals("S")){
			if(practitioner_id== null || practitioner_id.equals("")){
			pstmt.setString(4,pat_cat);
			pstmt.setInt(5,no_slots_value);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setString(5,pat_cat);
			pstmt.setInt(6,no_slots_value);
			}}
			else
			{
			if(practitioner_id== null || practitioner_id.equals("")){
			pstmt.setString(4,pat_cat);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setString(5,pat_cat);
			}
			}
			rs = pstmt.executeQuery();
			if(rs !=null){
				if(rs.next())
				{
				chk=rs.getString(1);
				allow_book=true;
				}
				else
				  allow_book=false;
				
			}
if(rs !=null) rs.close();
			if(chk.equals("N"))
				allow_book=true;			
			else
				allow_book=false;
					
		if(!patient_id.equals("")){
			String checking="select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param where module_id='MP'";
			//rs=stmt.executeQuery(checking);
			pstmt = con.prepareStatement(checking);
			rs = pstmt.executeQuery();
			if(rs!=null){
			while(rs.next()){
			c_name_prefix_accept_yn=rs.getString(1);
			c_first_name_accept_yn=rs.getString(2);
			c_second_name_accept_yn=rs.getString(3);
			c_third_name_accept_yn=rs.getString(4);
			c_family_name_accept_yn=rs.getString(5);
 			c_name_suffix_accept_yn=rs.getString(6);
			}
			}
			if(rs !=null) rs.close();
			//String chk_overlap= "select '1' from oa_appt where (appt_slab_from_time between to_date('"+from_time+"','hh24:mi') and to_date('"+to_time+"','hh24:mi') or appt_slab_to_time between to_date('"+from_time+"','hh24:mi') and to_date('"+to_time+"','hh24:mi'))and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' and CARE_LOCN_TYPE_IND='"+clinic_type+"' ";
			//rs = stmt.executeQuery(chk_overlap) ;
			String chk_overlap= "select '1' from oa_appt where (appt_slab_from_time between to_date(?,'hh24:mi') and to_date(?,'hh24:mi') or appt_slab_to_time between to_date(?,'hh24:mi') and to_date(?,'hh24:mi'))and appt_date = to_date(?,'dd/mm/yyyy') and patient_id=? and CARE_LOCN_TYPE_IND=? ";
			pstmt = con.prepareStatement(chk_overlap);
			pstmt.setString(1,from_time);
			pstmt.setString(2,to_time);
			pstmt.setString(3,from_time);
			pstmt.setString(4,to_time);
			pstmt.setString(5,clinic_date);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,clinic_type);
			rs = pstmt.executeQuery();
			if(rs !=null){
			if(rs.next())
			{
			chk=rs.getString(1);
			overlap=true;
		    }
			else
			{
			overlap=false;
			}
}
if(rs !=null) rs.close();
}
else{
overlap=false;
}
if(allow_book){
if(!(overlap))
{
allow_book=true;
}
else{

            _bw.write(_wl_block15Bytes, _wl_block15);
	
	if(c_name_prefix_accept_yn.equals("Y")){

            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);

	if(c_first_name_accept_yn.equals("Y")){

            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	
	if(c_second_name_accept_yn.equals("Y"))
	{

            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
 if(c_third_name_accept_yn.equals("Y"))
	{

            _bw.write(_wl_block19Bytes, _wl_block19);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
if(c_family_name_accept_yn.equals("Y"))
	{

            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
 if(c_name_suffix_accept_yn.equals("Y"))
   {

            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);

}
}
}


if(!(overlap)){	
	if(allow_book){	
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	}else{
		if (no_slots_value>1 && time_table_type.equals("1")&& slot_appt_ctrl.equals("S")){
			String s1="";
			if(practitioner_id==null || practitioner_id.equals("")){
				//s1="select count(1) from oa_clinic_schedule_dtl where facility_id = '"+facilityid+"' and clinic_code ='"+clinic_code+"' and clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY') and practitioner_id is null  and max_patients >= total_booked_patients+"+no_slots_value+"   ";
				s1="select count(1) from oa_clinic_schedule_dtl where facility_id = ? and clinic_code =? and clinic_date= to_date(?,'DD/MM/YYYY') and practitioner_id is null  and max_patients >= total_booked_patients+? ";
			}else{
				//s1="select count(1) from oa_clinic_schedule_dtl where facility_id = '"+facilityid+"' and clinic_code ='"+clinic_code+"' and clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY') and practitioner_id= '"+practitioner_id+"' and max_patients >= total_booked_patients+"+no_slots_value+"   ";
				s1="select count(1) from oa_clinic_schedule_dtl where facility_id = ? and clinic_code = ? and clinic_date= to_date(? ,'DD/MM/YYYY') and practitioner_id= ? and max_patients >= total_booked_patients+? ";
			}
			
			if (rs!=null)rs.close();
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			if (no_slots_value>1 && time_table_type.equals("1")&& slot_appt_ctrl.equals("S")){
		    pstmt.setInt(4,no_slots_value);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setInt(5,no_slots_value);
			}
			rs = pstmt.executeQuery();
			//rs=stmt.executeQuery(s1);
			while(rs!=null&&rs.next()){
				if (rs.getInt(1)==0){
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{	
					if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}else if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("N")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
				}
			}
		}else{	
		if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("Y")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}else if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("N")){
            _bw.write(_wl_block28Bytes, _wl_block28);
}
	 }
   }
}
else{
	
            _bw.write(_wl_block29Bytes, _wl_block29);
}
	}
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(prs !=null) prs.close();
	if(prs1 !=null) prs1.close();
	if(pstmt !=null) pstmt.close();
}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(prs !=null) prs.close();
	if(prs1 !=null) prs1.close();
	if(pstmt !=null) pstmt.close();
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
}
