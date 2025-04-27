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

public final class __bookappointmentvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BookAppointmentValidations.jsp", 1722231131371L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A\n\nvar myarr = new Array();\nvar sp_code=new Array();\nvar sp_des=new Array();\nindex=0;\n//end  Bru-HIMS-CRF-168 [IN030287]_0A\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\tparent.frames[0].document.forms[0].inpatient_yn.value=\'Y\';\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\tparent.frames[0].document.forms[0].inpatient_yn.value=\'N\';\n\t ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t    sp_code[index]=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t sp_des[index]=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t index++;\n\t\t//end  Bru-HIMS-CRF-168 [IN030287]_0A\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\tparent.frames[0].document.forms[0].maxrecord.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\tparent.frames[0].document.forms[0].ipbookings.value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\tparent.frames[0].document.forms[0].radbookings.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tparent.frames[2].document.forms[0].OtherAppts.disabled=true;\n\tparent.frames[2].document.getElementById(\"other_id1\").style.visibility=\'hidden\';\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n\t\tparent.frames[2].document.forms[0].OtherAppts.disabled=false;\n\t\tparent.frames[2].document.getElementById(\"other_id1\").style.visibility=\'visible\';\n\t\talert(getMessage(\"PAT_FUTURE_APPT_EXISTS\",\'OA\'));\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A\n          \n\t\t    parent.frames[2].document.forms[0].OtherAppts.disabled=false;\n\t\t    parent.frames[2].document.getElementById(\"other_id1\").style.visibility=\'visible\';\n\t\t    var main_msg=getMessage(\"PAT_FUTURE_APPT_EXISTS\",\'OA\');\n\t\t\n\t\t   \n\t\t    var flag=0;\n\t\t    var msg1;\n\t\t    var msg2=\'\';\n            var dotvalidation=(sp_code.length-1);\t\n          \n\t\t  \n\t\t \n\t\t      //VALIDATION FOR MULTIPLE RECORD\t\n\t\t\t  \n\t\t\t  if(sp_code.length >=2)\n\t\t\t  {\n\t\t\t \n\t\t\t  for(i=0;i<sp_code.length;i++)\n\t\t\t { \n\t\t\t \n            if(sp_code[i]==\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\n\t\t     { \n\t\t\t flag=1 \n\t\t      msg1=sp_des[i];\n\t\t\t \n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t \n\t\t\t  \n\t\t\t if( dotvalidation > i )\n\t\t   {    \n\t\t   if(sp_code[sp_code.length-1]==\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"){ msg2=msg2+sp_des[i]+\".\"}else{\n\t\t \n\t\t   msg2=msg2+sp_des[i]+\",\" }\n\t\t   }\n\t\t   else{   \n\t\t   msg2=msg2+sp_des[i]+\".\" \n\t\t\n\t\t   }\n\t\t\t \n\t\t\t \n\t\t\t }\n\t\t\t \n\t\t\t } // for end;\n\t\t\t\n             if( flag==1)\n\t\t\t {\n\t\t\t  alert(main_msg+\" in same Specialty; \"+msg1+\" & other Specialty(ies); \"+msg2)\n\t\t\t\n\t\t\t }\n\t\t\telse\n\t\t\t {\n\t\t\t alert (main_msg+\" in other Specialty(ies); \"+msg2)\n\t\t\t   }\n\n\t\t\t} //first if end\n\t\t\t \n\t\t\t\n\t\t\t \n\t\t\t //VALIDATION FOR SINGLE RECORD\n\t\t\t\n\t\t\tif(sp_code.length ==1) \n\t\t\t{\n\t\t\t  if(sp_code[0]== \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\")\n\t\t\t  {\n\t\t\t  alert (main_msg+\" in same specialty; \"+sp_des[0]+\".\")\n\t\t\t } \n\t\t\t else \n\t\t\t { \n\t\t\t alert (main_msg+\" in other specialty(ies); \"+sp_des[0]+\".\") \n\t\t\t }\n\t\t\t }\n\t\t\t \n\t\t\t  \n\t\t  \t\t   \n\t//end  Bru-HIMS-CRF-168 [IN030287]_0A\n\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\tparent.frames[2].document.getElementById(\"previous_encounter\").disabled = true;\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\tparent.frames[2].document.getElementById(\"previous_encounter\").disabled = false;\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\tvar obj1=parent.frames[0].document.forms[0].pat_cat;\n\t\twhile(obj1.options.length>0) obj1.remove(obj1.options[0]);\n\t\topt=document.createElement(\'OPTION\');\n\t\topt.value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\t\topt.text=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\tobj1.add(opt);\n\t\tparent.frames[0].document.forms[0].pat_cat.value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\tparent.frames[0].document.forms[0].pat_category.value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\tparent.frames[0].document.forms[0].pat_cat.value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\t\tif(parent.frames[0].document.forms[0].pat_cat.value==\"\")\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_cat.value=\"*O\";\n\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\t\tparent.frames[0].document.forms[0].pat_cat.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\n\t\t\t\tvar err_age = getMessage( \"FIRST_VISIT_ONLY_ALLOWED\",\'OA\' ) ;\n\t\t\t\talert(err_age);\n\t\t\t\tparent.frames[2].document.forms[0].recurring.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\tvar err_age = getMessage( \"NO_SERVICE_VISIT_FIRST_VISIT_ONLY\",\'OA\' ) ;\n\t\t\t\talert(err_age);\n\t\t\t\tparent.frames[2].document.forms[0].recurring.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\tparent.frames[2].document.forms[0].recurring.disabled=false;\n\t\t\t";
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Map hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
request.setCharacterEncoding("UTF-8");	

Connection conn = null;
String facilityid=(String)session.getValue("facility_id");
String patientid=(String) hash.get("pat_id");
String cliniccode=(String) hash.get("clinic_code");
String alcn_criteria=(String) hash.get("alcn_criteria_pop");
String ip_installed_yn=(String) hash.get("ip_installed_yn");
String rad_installed_yn=(String) hash.get("rad_installed_yn");
String visit_type_cd=(String) hash.get("visit_type_cd");
String sel_service_code=(String) hash.get("sel_service_code");
if(visit_type_cd==null) visit_type_cd="";
//String age_group_code=(String) hash.get("age_group_code");
String pat_cat_code="";
//below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
//String param             ="N";
String speciality_code   =(String)hash.get("speciality_code");
String dtl_msg_yn        =(String)hash.get("dtl_msg_yn");
String sp_code           ="";
String sp_des            ="";
//end  Bru-HIMS-CRF-168 [IN030287]_0A

Statement stmtc=null;
PreparedStatement pstmt=null;

ResultSet rsc=null;
ResultSet rs=null;
Statement stmt=null;

int maxRecord1=0;
int ip_bkgs=0;
int rad_bkgs=0;

int prev_encntr=0;

try{
	conn = ConnectionManager.getConnection(request);
	String In_patient_status =  patdata.CheckInPatient(conn,patientid,facilityid);

	if(In_patient_status.equals("CURRENTLY_IN_PATIENT")){
            _bw.write(_wl_block2Bytes, _wl_block2);
}else{
            _bw.write(_wl_block3Bytes, _wl_block3);
}
				
	//pstmt = conn.prepareStatement("select count(1) as total from oa_appt where patient_id='"+patientid+"'  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time");
pstmt = conn.prepareStatement("SELECT  a. speciality_code, b.short_desc,COUNT (*) AS total FROM oa_appt a,am_speciality b WHERE patient_id = '"+patientid+"' and a.speciality_code = b.speciality_code AND TRUNC (appt_date) >= TRUNC (SYSDATE) AND NVL (appt_status, 1) != 'A' GROUP BY a.speciality_code,b.short_desc ORDER BY a.speciality_code");

	rs = pstmt.executeQuery();
	while(rs!=null && rs.next())
	{ 
		 //below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
		sp_code=rs.getString("speciality_code");
		sp_des=rs.getString("short_desc"); 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sp_code));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sp_des));
            _bw.write(_wl_block6Bytes, _wl_block6);
 maxRecord1 = rs.getInt("total");
		
	   
	
	}
	
	
	if(pstmt !=null) pstmt.close();
	if(rs !=null) rs.close();
	if(rad_installed_yn.equals("Y")){

		pstmt = conn.prepareStatement("SELECT count(1) as total FROM RD_APPT where patient_id='"+patientid+"' and trunc(APPT_DATE)>=trunc(sysdate)  AND NVL (appt_status, 1) != 'A'");

		rs = pstmt.executeQuery();	
		if(rs!=null){
			rs.next();
			rad_bkgs = rs.getInt("total");
		}
	}

if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
	if(ip_installed_yn.equals("Y")){
String sql2="select count(1) as total from ip_booking_list where  patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";
		pstmt = conn.prepareStatement(sql2);

		rs = pstmt.executeQuery();	
		if(rs!=null){
			rs.next();
			ip_bkgs = rs.getInt("total");
		}
	}
	
	if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(maxRecord1));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ip_bkgs));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rad_bkgs));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(dtl_msg_yn.equals("N") || dtl_msg_yn.equals("n") ){ 
	if(maxRecord1 !=0 || ip_bkgs !=0 || rad_bkgs!=0){
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
	}else{ 
            if(maxRecord1 !=0){	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
}}
	
            _bw.write(_wl_block16Bytes, _wl_block16);

		String sql12="select count(1) total from pr_encounter where facility_id='"+facilityid+"' and patient_id='"+patientid+"'";
	pstmt = conn.prepareStatement(sql12);

	rs = pstmt.executeQuery();

	
            _bw.write(_wl_block17Bytes, _wl_block17);

	if(rs!=null){
		rs.next();
		prev_encntr = rs.getInt("total");
	}
	if(pstmt !=null) pstmt.close();
	if(rs !=null) rs.close();

            _bw.write(_wl_block18Bytes, _wl_block18);
if(prev_encntr !=0 ){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	

	if(!alcn_criteria.equals("")){
		String pat_cat_desc="";
		pstmt = conn.prepareStatement("select STAT_GRP_ID, STAT_GRP_DESC from (select STAT_GRP_ID, STAT_GRP_DESC from am_stat_group UNION select '*O' STAT_GRP_ID,   'Others'  STAT_GRP_DESC from dual) where STAT_GRP_ID=NVL(GET_PAT_CAT_CODE('"+patientid+"'),'*O')");
		rs = pstmt.executeQuery();	
		if(rs!=null){
			if(rs.next())
			   pat_cat_code = rs.getString("STAT_GRP_ID");
			   pat_cat_desc = rs.getString("STAT_GRP_DESC");
		}

if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
		if(!pat_cat_code.equals("")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_cat_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
if (!pat_cat_code.equals("*O")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
		}
	}



	if(visit_type_cd.equals("S")){
		
			stmt=conn.createStatement();
			String override_vtype_on_epsd_yn="";
		String sql = "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID='"+facilityid+"'" ;
		pstmt=conn.prepareStatement(sql);

		 rs=pstmt.executeQuery();

		int cnt=0;

		if(rs!=null && rs.next()){

	 override_vtype_on_epsd_yn = rs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
		}

		if(rs !=null)rs.close();
			if (override_vtype_on_epsd_yn.equals("N") && !visit_type_cd.equals("F")){
				String sql_one="";
				if(sel_service_code==null || sel_service_code.equals("")){
				sql_one="select count(*) count from pr_encounter where facility_id ='"+facilityid+"' and assign_care_locn_code = '"+cliniccode+"' and visit_adm_type_ind = 'F' and patient_id ='"+patientid+"' and patient_class = 'OP'";
				}else{
					sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = '"+facilityid+"' AND service_code = '"+sel_service_code+"' and patient_id ='"+patientid+"'   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
				}

		  rs=stmt.executeQuery(sql_one);
		  
		

		
            _bw.write(_wl_block27Bytes, _wl_block27);

	if(rs !=null && rs.next())
		 {
			cnt=rs.getInt("count");
			if (cnt==0){//validation for series visit - for incident no 36620 - called when series visit type is selected.
				if(sel_service_code==null || sel_service_code.equals("")){
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
			}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
		}
	}
	}
if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();

	

	
	if(rs != null) rs.close();
	if(rsc != null) rsc.close();
	if(stmtc !=null) stmtc.close();
	if(stmt !=null) stmt.close();
	if(pstmt !=null) pstmt.close();
	hash.clear();

}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
