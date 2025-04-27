package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewpreparedischargeadviselistqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ViewPrepareDischargeAdviseListQueryResult.jsp", 1709117947963L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table><br>\n\t\t<br>\n\t\t<br>\n\t\t</P>\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t</head>\n<BODY class=\'CONTENT\'>\n\n<table align=\'center\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<thead id=\'table_header\'>\n<tr>\n<th nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;</th>\n<th nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;</th>\n</tr></thead>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\tdocument.getElementById(\"next\").style.display=\"none\";\n\t\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\tdocument.getElementById(\"next\").style.display=\"inline\";\n\t\t\t</SCRIPT>\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\tparent.frames[2].location.href =\'../../eCommon/html/blank.html\';\n\t\t\t\t\n\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</table>\n\n</body>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");	
String facility_id			= (String)session.getAttribute("facility_id");
String v_patient_id			=	checkForNull(request.getParameter("v_patient_id"));
String v_encounter_id		=	checkForNull(request.getParameter("v_encounter_id"));
String practid_desc		    =	checkForNull(request.getParameter("practid_desc"));
String v_nursing_unit_code	= checkForNull(request.getParameter("v_nursing_unit_code"));
String v_spacialty_code		= checkForNull(request.getParameter("v_spacialty_code"));
String from_date			= checkForNull(request.getParameter("from_date"));
String to_date		        = checkForNull(request.getParameter("to_date"));
String from 				= request.getParameter( "from" ) ;
String to 					= request.getParameter( "to" ) ;
String whereclause = request.getParameter("whereclause")== null?"":request.getParameter("whereclause");  
StringBuffer where_criteria = new StringBuffer();
String locale				= (String)session.getAttribute("LOCALE");
Connection con				= null;
ResultSet rs				= null;
PreparedStatement pstmt		= null;
con  =  ConnectionManager.getConnection(request);
StringBuffer sql			= new StringBuffer();
	
//Added by Arthi for ML-MMOH-SCF-2095
Boolean isListaggAppl = false;

int start = 0 ;
int end = 0 ;


	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 11 ;
	else
		end = Integer.parseInt( to ) ;
	
try{

    //Added by Arthi for ML-MMOH-SCF-2095
	isListaggAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "VW_PREP_DISCH_ADV_LST_QRY");
	
	if(whereclause.equals(""))
	{
	where_criteria.append("AND a.patient_id = NVL('"+v_patient_id+"',a.patient_id) AND a.encounter_id = NVL('"+v_encounter_id+"', a.encounter_id) AND a.nursing_unit_code = NVL('"+v_nursing_unit_code+"', a.nursing_unit_code) AND a.specialty_code = NVL('"+v_spacialty_code+"', a.specialty_code) AND a.attend_practitioner_id =NVL('"+practid_desc+"', a.attend_practitioner_id) AND TRUNC(c.dis_adv_date_time) BETWEEN TO_DATE('"+from_date+"', 'dd/mm/yyyy') AND  TO_DATE('"+to_date+"' , 'dd/mm/yyyy')");
	}else{
		where_criteria.append(whereclause);
	}
	
	sql.append("SELECT a.patient_id,DECODE('"+locale+"','en', b.patient_name,NVL(b.patient_name_loc_lang, b.patient_name)) patient_name, a.encounter_id, DECODE(b.sex,'F','Female','M','Male','U','Unknown')gender, Mp_get_age_ymdh(b.date_of_birth)age, TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, am_get_desc.am_practitioner(a.admit_practitioner_id,'"+locale+"',2) admit_practitioner, am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',2)attend_practitioner, ip_get_desc.ip_nursing_unit(a.facility_id,a.nursing_unit_code,'"+locale+"',2)nursing_unit_desc, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2)bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, a.bed_num bed_no, TO_CHAR(a.modified_date,'dd/mm/rrrr hh24:mi:ss')modified_date, ip_get_desc.IP_DISCHARGE_TYPE(c.discharge_type_code,'en',2)discharge_type_code, TO_CHAR(c.expected_discharge_date,'dd/mm/rrrr hh24:mi')expected_discharge_date, ");
	
	//Modified for ML-MMOH-SCF-2095
	if(isListaggAppl){
	sql.append(" ( select distinct listagg( h.term_code || '-' ||h. term_code_short_desc) from pr_diagnosis_enc_dtl h where h.ENCOUNTER_ID=a.ENCOUNTER_ID and h.ENC_STAGE='D' and h.status!='E')diagnosis ,( select distinct listagg( e.proc_narration) ");
	}
	else{ 
		sql.append(" ( select distinct wm_concat( h.term_code || '-' ||h. term_code_short_desc) from pr_diagnosis_enc_dtl h where h.ENCOUNTER_ID=a.ENCOUNTER_ID and h.ENC_STAGE='D' and h.status!='E')diagnosis ,( select distinct wm_concat( e.proc_narration) ");
    }
	
	sql.append(" from pr_encounter_procedure e where e.ENCOUNTER_ID=a.ENCOUNTER_ID and e.error_yn='N')procedure_recording FROM ip_open_encounter a,mp_patient b,ip_discharge_advice c WHERE a.facility_id='"+facility_id+"' AND a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND a.encounter_id = c.encounter_id  AND c.dis_adv_status != '9'  "+where_criteria+" GROUP BY a.patient_id,DECODE ('"+locale+"','en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)),a.encounter_id,b.sex,Mp_get_age_ymdh(b.date_of_birth),TO_CHAR (a.admission_date_time, 'dd/mm/rrrr hh24:mi'),a.admit_practitioner_id,a.attend_practitioner_id,ip_get_desc.ip_nursing_unit (a.facility_id,a.nursing_unit_code,'en',2), ip_get_desc.ip_bed_class (a.bed_class_code, 'en', 2),ip_get_desc.ip_bed_type (a.bed_type_code, 'en', 2),a.bed_num, a.modified_date,ip_get_desc.ip_discharge_type (c.discharge_type_code,'en',2), c.expected_discharge_date ORDER BY  c.expected_discharge_date ");
	//out.println("sql.toString()-->"+sql.toString());
int maxRecords=0;
pstmt = con.prepareStatement(sql.toString());

rs= pstmt.executeQuery();
int i=0;
int j=0;

            _bw.write(_wl_block6Bytes, _wl_block6);

if ( !(start <= 1) ){
out.println("<A  HREF='../jsp/ViewPrepareDischargeAdviseListQueryResult.jsp?from="+(start-11)+"&to="+(end-11)+"&facility_id="+facility_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'id='previous'>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
}
out.println("<A  HREF='../jsp/ViewPrepareDischargeAdviseListQueryResult.jsp?from="+(start+11)+"&to="+(end+11)+"&facility_id="+facility_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'text-decoration='none' style='display:none'id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittingPractitioner.label","ip_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.BedNumber.Label","ds_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PrepareDischargeAdvice.label","ip_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Date/Time.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedatetime.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisDetails.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.details.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);

String  classValue = "" ;
if(rs != null)
{
	if ( start != 1 )
	for(  j=1; j<start; i++,j++ )
	rs.next() ;

  while(rs.next() && i<=end)
	{ 
     if ( i % 2 == 0 )
			classValue = "QRYEVENSMALL" ;
		else
			classValue = "QRYODDSMALL" ;
    
	out.println("<tr>");
	 String patient_id=rs.getString("patient_id"); if(patient_id == null) patient_id="";
	 out.println("<td class='"+classValue+"' nowrap>"+patient_id+"&nbsp;</td>");
	 String patient_name=rs.getString("patient_name"); if(patient_name == null) patient_name="";
	 out.println("<td class='"+classValue+"' nowrap>"+patient_name+"&nbsp;</td>");
	 String encounter_id=rs.getString("encounter_id"); if(encounter_id == null) encounter_id="";
	 out.println("<td class='"+classValue+"' nowrap>"+encounter_id+"&nbsp;</td>");
	 String gender=rs.getString("gender"); if(gender == null) gender="";
	 out.println("<td class='"+classValue+"' nowrap>"+gender+"&nbsp;</td>");
	 String age=rs.getString("age"); if(age == null) age="";
	 out.println("<td class='"+classValue+"' nowrap>"+age+"&nbsp;</td>");
	 String admission_date_time=rs.getString("admission_date_time"); if(admission_date_time == null) admission_date_time="";
	 out.println("<td class='"+classValue+"' nowrap>"+admission_date_time+"&nbsp;</td>");
	 String admit_practitioner=rs.getString("admit_practitioner"); if(admit_practitioner == null) admit_practitioner="";
	 out.println("<td class='"+classValue+"' nowrap>"+admit_practitioner+"&nbsp;</td>");
	 String attend_practitioner=rs.getString("attend_practitioner"); if(attend_practitioner == null) attend_practitioner="";
	 out.println("<td class='"+classValue+"' nowrap>"+attend_practitioner+"&nbsp;</td>");
	 String nursing_unit_desc=rs.getString("nursing_unit_desc"); if(nursing_unit_desc == null) nursing_unit_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+nursing_unit_desc+"&nbsp;</td>");
	 String bed_class_short_desc=rs.getString("bed_class_short_desc"); if(bed_class_short_desc == null) bed_class_short_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_class_short_desc+"&nbsp;</td>");
	 String bed_type_short_desc=rs.getString("bed_type_short_desc"); if(bed_type_short_desc == null) bed_type_short_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_type_short_desc+"&nbsp;</td>");
	 String bed_no=rs.getString("bed_no"); if(bed_no == null) bed_no="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_no+"&nbsp;</td>");
	 String modified_date=rs.getString("modified_date"); if(modified_date == null) modified_date="";
	 out.println("<td class='"+classValue+"' nowrap>"+modified_date+"&nbsp;</td>");
	 String discharge_type_code=rs.getString("discharge_type_code"); if(discharge_type_code == null) discharge_type_code="";
	 out.println("<td class='"+classValue+"' nowrap>"+discharge_type_code+"&nbsp;</td>");
	 String expected_discharge_date=rs.getString("expected_discharge_date"); if(expected_discharge_date == null) expected_discharge_date="";
	 out.println("<td class='"+classValue+"' nowrap>"+expected_discharge_date+"&nbsp;</td>");
	 String diagnosis=rs.getString("diagnosis"); if(diagnosis == null) diagnosis="";
	 out.println("<td class='"+classValue+"' nowrap>"+diagnosis+"&nbsp;</td>");
	 String procedure_recording=rs.getString("procedure_recording"); if(procedure_recording == null) procedure_recording="";
	 out.println("<td class='"+classValue+"' nowrap>"+procedure_recording+"&nbsp;</td>");
	 out.println("</tr>");
	 i++;
	 maxRecords++;
}
}

if(maxRecords<12 || !(rs.next())){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{  
            _bw.write(_wl_block13Bytes, _wl_block13);
}
if(maxRecords==0){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

		if(rs != null)	rs.close();
		if(pstmt != null)	pstmt.close();
	}catch(Exception e)
	{ 
		out.println("Error  : "+e.toString());	
		e.printStackTrace();
	}
	finally
	{     
		ConnectionManager.returnConnection(con,request);
	}	


            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
