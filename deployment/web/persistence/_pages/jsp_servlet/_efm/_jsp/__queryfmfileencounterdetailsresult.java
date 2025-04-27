package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmfileencounterdetailsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMFileEncounterDetailsResult.jsp", 1726210419527L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t</HEAD>\n\t\t<!-- <LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/QueryFMFileEncounterDetails.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<HEAD>\n\t<BODY OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey();\'>\n\t\t<SCRIPT>\n\t\t\t//if(parent.QFMFEDSearchFrame.document.getElementById(\"tab\").style.visibility == \'hidden\') <!--Below commented by Mano Aganist SCF-0761 -->\n\t\t\t\t//parent.QFMFEDSearchFrame.document.getElementById(\"tab\").style.visibility = \'visible\'; <!--Below commented by Mano Aganist SCF-0761 -->\n\t\t</SCRIPT>\n\t\t<FORM name=\'QFMFEDResultForm\' id=\'QFMFEDResultForm\'>\n\t\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\'); \n\t\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.patientId.label\',\'Common\'));\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tparent.frames[2].location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\tparent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].patient_id.select();\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\n\t\t\t\t\t<!--below banner added by Mano aganist ML-MMOH-SCF-0761 -->\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\" >\n\t<tr>\n\t\t<td colspan=\'4\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t</tr>\n</table>\n<br>\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n\t\t\t\n\t\t\t\t<TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<Th width=\"15%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</Th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<Th class=\'columnheader\' width=\"15%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<Th class=\'columnheader\' width=\"8%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</Th>\n\t\t\t\t\t<th class=\'columnheader\' width=\"15%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</Th>\n\t\t\t\t\t<Th class=\'columnheader\' width=\"15%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</Th>\n\t\t\t\t\t<Th class=\'columnheader\' width=\"12%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</Th>\n\t\t\t\t\t<Th class=\'columnheader\' width=\"10%\">Specialty</Th>\n\t\t\t\t\t<Th class=\'columnheader\' width=\"10%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</Th>\n\t\t\t\t</TR>\n\t\t\t<TABLE>\n\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t<!-- End of ML-MMOH-SCF-0761 by mano -->\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" width=\'15%\'><FONT size=1>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</FONT></TD>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" width=\'8%\'><FONT size=1><CENTER>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</CENTER></FONT></TD>\n\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</FONT></TD>\n\t\t\t\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" width=\'15%\'><FONT \n\t\t\t\t\t\t\tsize=1>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" width=\'12%\'><FONT size=1>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" width=\'10%\'><FONT \n\t\t\t\t\t\t\tsize=1>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</FONT></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\t\tparent.frames[2].location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\tparent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t</TABLE>\n\t\t\t\t</FORM>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection conn = null;
	Statement stmt  = null;
	Statement stmt1 = null;
	ResultSet rst   = null;
	ResultSet rst1  = null;

	try
	{
		conn	= ConnectionManager.getConnection(request);

		String facility_id		 = (String) session.getValue("facility_id");
		String patient_id		 = checkForNull(request.getParameter("patient_id"));
		String p_encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String encounterCriteria = "";

		if(!p_encounter_id.equals(""))
		{
			encounterCriteria = " AND a.encounter_id = '"+p_encounter_id+"' ";
		}
		if(!patient_id.equals(""))
		{
				webbeans.op.PatientData patdata = new webbeans.op.PatientData();
				patdata.setFacility_id(facility_id);
				String patient_status = patdata.CheckStatus(conn,patient_id);
				if(patient_status.equals("INVALID_PATIENT"))
				{

            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else
				{
					String file_type_appl_yn  = checkForNull(request.getParameter("file_type_appl_yn"));
					String class_value		     = "QRYEVEN";
					String mysql                 = "";					
					String encounter_type	     = ""; 
					String encounter_id		     = ""; 
					String encounter_date_time   = ""; 
					String practitioner_name     = ""; 
					String specialty		     = ""; 
					String volume_no		     = "";
					String file_no			     = "";
				//	String assign_care_locn_type = "";
				//	String assign_care_locn_code = "";
					String location				 = "";
					String file_type_desc	     = "";

					int recordCount = 0; // To count no of rows reterived from "mysql" query.
					
					stmt  = conn.createStatement();
					stmt1 = conn.createStatement();
					if(file_type_appl_yn.equals("N"))
					{
					//	mysql = "SELECT b.short_desc encounter_type, e.encounter_id,TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time,c.practitioner_name, d.short_desc specialty, 		a.assign_care_locn_type,a.assign_care_locn_code,Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, e.volume_no, e.file_no FROM pr_encounter a,am_patient_class b,am_practitioner c,am_speciality d,fm_encounter_volume_link e WHERE a.encounter_id = e.encounter_id(+) AND a.facility_id = e.facility_id AND a.attend_practitioner_id = c.practitioner_id(+) AND a.specialty_code = d.speciality_code AND a.patient_class = b.patient_class AND a.facility_id = '"+facility_id+"' "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"' ";
						mysql = "SELECT  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') encounter_type  , a.encounter_id  ,TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time  ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name  , AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') specialty  , a.assign_care_locn_type  ,a.assign_care_locn_code  ,Decode(a.assign_care_locn_type, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, a.assign_care_locn_code,'"+localeName+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, a.assign_care_locn_code, '"+localeName+"','1'))) location  , e.volume_no  , e.file_no  FROM  pr_encounter a  ,fm_encounter_volume_link e  WHERE a.encounter_id = e.encounter_id   AND a.facility_id = e.facility_id  AND a.facility_id = '"+facility_id+"' "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"'";
					}
					else if(file_type_appl_yn.equals("Y"))
					{
					//	mysql = "SELECT b.short_desc encounter_type, e.encounter_id,TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time,c.practitioner_name, d.short_desc specialty, 		a.assign_care_locn_type,a.assign_care_locn_code,Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, e.volume_no, e.file_no, f.short_desc file_type_desc FROM pr_encounter a,am_patient_class b,am_practitioner c,am_speciality d,fm_encounter_volume_link e,mr_file_type f WHERE a.encounter_id = e.encounter_id(+) AND a.facility_id = e.facility_id AND e.facility_id = f.facility_id(+) AND a.attend_practitioner_id = c.practitioner_id(+) AND a.specialty_code = d.speciality_code AND a.patient_class = b.patient_class AND e.file_type_code = f.file_type_code AND a.facility_id = '"+facility_id+"' "+encounterCriteria+" AND a.patient_id = '"+patient_id+"' ";
						mysql = "SELECT  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') encounter_type  , a.encounter_id  ,TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time  ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name  , AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') specialty  , a.assign_care_locn_type  ,a.assign_care_locn_code  ,Decode(a.assign_care_locn_type, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, a.assign_care_locn_code,'"+localeName+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, a.assign_care_locn_code, '"+localeName+"','1'))) location  , e.volume_no  , e.file_no  ,MR_GET_DESC.MR_FILE_TYPE(E.FACILITY_ID, E.FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc  FROM  pr_encounter a  ,fm_encounter_volume_link e WHERE a.encounter_id = e.encounter_id   AND a.facility_id = e.facility_id   AND a.facility_id = '"+facility_id+"'  "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"' ";
					}
						rst  = stmt.executeQuery(mysql);
						
						System.out.println(" **************** Inside QueryFMFileEncounterResult 100 : mysql "+mysql);
					while(rst !=null && rst.next())
					{
						encounter_type		  = checkForNull(rst.getString("encounter_type"));
						encounter_id		  = checkForNull(rst.getString("encounter_id"));
						encounter_date_time   = checkForNull(rst.getString("encounter_date_time"));
						if(!encounter_date_time.equals("&nbsp;"))
						{
							encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM","en",localeName);
						}

						practitioner_name	  = checkForNull(rst.getString("practitioner_name"));
						specialty			  = checkForNull(rst.getString("specialty"));
						volume_no			  = checkForNull(rst.getString("volume_no"));
					//	assign_care_locn_type = checkForNull(rst.getString("assign_care_locn_type"));
					//	assign_care_locn_code = checkForNull(rst.getString("assign_care_locn_code"));
												
						location = checkForNull(rst.getString("location"));
						
						if(file_type_appl_yn.equals("N"))
						{
							file_no	= checkForNull(rst.getString("file_no"));
						}
						if(file_type_appl_yn.equals("Y"))
						{
							file_type_desc	= checkForNull(rst.getString("file_type_desc"));
						}
						if(class_value.equals("QRYEVEN"))
							class_value = "QRYODD";
						else
							class_value = "QRYEVEN";
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
if(file_type_appl_yn.equals("N")){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}else if(file_type_appl_yn.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(file_type_appl_yn.equals("N")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else if(file_type_appl_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(specialty));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(location));
            _bw.write(_wl_block31Bytes, _wl_block31);
	
						recordCount++;
					}
					if(recordCount == 0)
					{
					
            _bw.write(_wl_block32Bytes, _wl_block32);

					}
					
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
			}
			if(rst   != null) rst.close();
			if(rst1  != null) rst1.close();
			if(stmt  != null) stmt.close();
			if(stmt1 != null) stmt1.close();
		}
		catch(Exception e)
		{
			out.println("Exception e :"+e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}
		
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fileno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
