package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __addmodifydeathregistration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/addModifyDeathRegistration.jsp", 1722863327047L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tKumar\n\tCreated on \t:\t29/11/2001\n\tModule\t\t:\tmr\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/dchk.js\' language=\'javascript\'></script> \n\t\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eMR/js/CreatePatientFile.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<script>\n\n//This function is to limit the no of character entry into text box/ text area.\nfunction checkMaxRemarksLimit(obj,maxSize) \n{\n\tif(obj.value.length >= maxSize)\n\t{\n\t\talert(getMessage(\"REMARKS_NOT_EXCEED_200_CH\",\'SM\'));\n\t\tobj.focus();\n\t}\n}\n</script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<form name=\'DeathRegister_form\' id=\'DeathRegister_form\'  method=\"post\" target=\"Dummy_frame\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table cellpadding=3 cellspacing=0 width=\"100%\">\n\t\t\t<tr><td colspan=4 class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\t\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\" class=label >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td width=\"25%\" class=\'querydata\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<input type=\"hidden\"  name=\"admission_date_time\" id=\"admission_date_time\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></td>\n\t\t\t\t<td width=\"25%\" class=label >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<input type=\"hidden\"  name=\"admission_short_desc\" id=\"admission_short_desc\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\"text\"  name=\"death_date_time\" id=\"death_date_time\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=16 maxlength=16 readonly></td>\n\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td class=\'fields\'><input type=\'text\' name=practid_desc maxLength=30 size=30  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onblur=\'getPractIDblur(document.forms[0].practid_desc, document.forms[0].practid);\'><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\'getPractID(document.forms[0].practid_desc, document.forms[0].practid);\'></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td  class=\'fields\' colspan=3><textarea rows=2  cols=70 size=200 name=\"remarks\" onBlur=\"checkMaxRemarksLimit(this,200);return makeValidString(this);\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</textarea></td>\n\t\t\t</tr>\n\t\t\t<tr><td class=label colspan=4>&nbsp;</td></tr>\n\t\t</table>\n\n\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n        <input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\"hidden\" name=\"practid\" id=\"practid\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"sysdatetime\" id=\"sysdatetime\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"> \n\t\t<input type=\"hidden\" name=\"finalize_yn\" id=\"finalize_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"actualdeathdatetime\" id=\"actualdeathdatetime\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"> \n\t\t<input type=\"hidden\" name=\"AdmDatetime\" id=\"AdmDatetime\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> \n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	String facilityId		= (String)session.getValue("facility_id");
	String locale           = (String)session.getAttribute("LOCALE"); 


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		Connection con	= null;
		try{
		con=ConnectionManager.getConnection(request);
		Statement stmt	= null;
		ResultSet rset		= null;		
		String curdate					= "";
		String finalize_yn				= "";
		String visit_adm_date_time		= "";
		String vis_adm_dat_tim_display	= "";
		String death_date_time			= "";
		String death_date_time_display	= "";
		String actual_death_date_time	= "";
		String admission_short_desc		= ""; 
		String practitioner_name		= "";
		String practitioner_id			= "";
		String patient_id				= "";
		String gender					= "";
		String death_by_pregnancy_yn	= "";
		String autopsy_yn				= "";
		String medical_legal_case_yn	= "";
		String remarks					= "";

		String specialty_code			= "";
		String disabledfield			= "";
		String deathChkProp				= "";
		String autopsyChkProp			= "";
		String medicalChkProp			= "";
		
		String sql = "";
		StringBuffer sqlBuff= new StringBuffer();
		String d = "";
		String eid = request.getParameter("encounter_id");
		String call_from = request.getParameter("call_from");
		if (eid==null) eid="0";
		if (call_from==null) call_from="";
		long encounterid = Long.parseLong(eid);
			/*sqlBuff.append(" select patient_id, practitioner_id, ");
			sqlBuff.append("to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("admission_short_desc, to_char(death_date_time,'dd/mm/yyyy hh24:mi') Death_date_time,");
			sqlBuff.append("to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, ");
			sqlBuff.append(" practitioner_name FROM  MR_DEATH_REGISTER_HDR_VW where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
			*/

			/*sqlBuff.append(" select a.patient_id, a.practitioner_id, ");
			sqlBuff.append("to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("ip_get_desc.IP_ADMISSION_TYPE(b.ASSIGN_CARE_LOCN_TYPE,'"+locale+"','2')admission_short_desc,to_char(a.death_date_time,'dd/mm/yyyy hh24:mi') Death_date_time,");
			sqlBuff.append("to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, ");
			sqlBuff.append("am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_name from  MR_DEATH_REGISTER_HDR_VW a, PR_ENCOUNTER b where a.facility_id = '"+facilityId+"' and a.facility_id = b.facility_id and a.encounter_id = '"+encounterid+"' and a.encounter_id = b.encounter_id ");
			*/


			sqlBuff.append("select patient_id, practitioner_id,");
			sqlBuff.append("to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("DECODE(ASSIGN_CARE_LOCN_TYPE,'C',OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID,VISIT_ADM_TYPE,'"+locale+"','2'),'N',IP_GET_DESC.IP_ADMISSION_TYPE(VISIT_ADM_TYPE,'"+locale+"','2')) ADMISSION_SHORT_DESC,to_char(death_date_time,'dd/mm/yyyy hh24:mi') death_date_time,");
			sqlBuff.append("to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time,");
			sqlBuff.append("am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from  MR_DEATH_REGISTER_HDR_VW where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"'");



			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			rset	 =	 stmt.executeQuery(sqlBuff.toString());
			if(rset != null && rset.next())
			{
				visit_adm_date_time	= rset.getString("visit_adm_date_time") == null ? "" : rset.getString("visit_adm_date_time"); 
				vis_adm_dat_tim_display = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
				
				death_date_time	= rset.getString("death_date_time") == null ? "" : rset.getString("death_date_time"); 
				death_date_time_display = DateUtils.convertDate(death_date_time,"DMYHM","en",locale);
				
				actual_death_date_time	= rset.getString("discharge_date_time") == null ? "" : rset.getString("discharge_date_time"); 
				admission_short_desc = rset.getString("admission_short_desc") == null ? "" : rset.getString("admission_short_desc"); 
				patient_id = rset.getString("patient_id") == null ? "" : rset.getString("patient_id");
				practitioner_id	= rset.getString("practitioner_id") == null ? "" : rset.getString("practitioner_id");
				practitioner_name = rset.getString("practitioner_name") == null ?"" : rset.getString("practitioner_name");
			}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			//Added on 19/05/2003
			sql = "select sex gender from mp_patient where PATIENT_ID = '"+patient_id+"'";
			rset	 =	 stmt.executeQuery(sql);
			if(rset != null && rset.next())
			{
				gender = rset.getString("gender");
			}
			if(gender.equals("M"))
			{
				disabledfield = "disabled";
			}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			//End of addition on 19/03/2003
			sql = "select auth_practitioner_id, death_by_pregnancy_yn, autopsy_yn, medical_legal_case_yn, remarks, finalize_yn from mr_death_register_hdr where facility_id = '"+facilityId+"' and encounter_id = "+encounterid;

			rset	 =	 stmt.executeQuery(sql);

			
			if(rset != null && rset.next())
			{
				practitioner_id	= rset.getString("auth_practitioner_id") == null ? "" : 				
								  rset.getString("auth_practitioner_id"); 
				remarks = rset.getString("remarks") == null ? "" : 
						  rset.getString("remarks");
				death_by_pregnancy_yn = rset.getString("death_by_pregnancy_yn");
				medical_legal_case_yn = rset.getString("medical_legal_case_yn") == null ? "" : rset.getString("medical_legal_case_yn");
				finalize_yn	= rset.getString("finalize_yn") == null ? "" : rset.getString("finalize_yn");
				if (death_by_pregnancy_yn.equals("Y"))
					deathChkProp = "checked";	
				autopsy_yn = rset.getString("autopsy_yn");
				if (autopsy_yn.equals("Y")) 
					autopsyChkProp = "checked";
				if (medical_legal_case_yn.equals("Y")) 
					medicalChkProp = "checked";
			}

			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();			

			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			d = dateFormat.format( dt ) ;
			d=d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
			curdate = d;
			d=actual_death_date_time;
	
            _bw.write(_wl_block8Bytes, _wl_block8);
	if(call_from.equals("MAINTAIN_DEATH_REGISTER"))
		{	
            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Facility_Id"), weblogic.utils.StringUtils.valueOf(facilityId
                        )},{ weblogic.utils.StringUtils.valueOf("EncounterId"), weblogic.utils.StringUtils.valueOf(eid
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
	}	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(vis_adm_dat_tim_display));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(admission_short_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(admission_short_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(death_date_time_display));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					try
					{
						Statement stmt1=con.createStatement();
						String sql1="Select specialty_code from PR_ENCOUNTER where facility_id = '"+facilityId+"' and encounter_id= "+encounterid+" ";
						ResultSet rs=stmt1.executeQuery(sql1);
						if (rs.next())
						{
							specialty_code =rs.getString(1);
						}
						if(rs!=null) rs.close();
						if(stmt1!=null) stmt1.close();
					}catch(Exception e){/* out.println(e); */e.printStackTrace();}
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(curdate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(actual_death_date_time));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block35Bytes, _wl_block35);

}
catch(Exception e) {
//out.println(e);
e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DeathRegistrationDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deathdatetime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuthorizingPractitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
