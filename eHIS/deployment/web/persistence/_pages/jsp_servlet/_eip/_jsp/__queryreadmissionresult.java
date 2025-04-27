package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;

public final class __queryreadmissionresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryReAdmissionResult.jsp", 1742452891059L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script language=\"JavaScript\">\n\tasync function showEncounterDetails(enc,patid)\n\t{\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"80vh\";\n\t\tvar dialogWidth = \"70vw\";\n\t\tvar dialogTop\t= \"0vh\";\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\t}\n</script>\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\t\t\t\t\t\t\t\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<table  cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n\t\t\t\t\t\t<tr><th nowrap>&nbsp;</th><th nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</th><th nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;</th></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	//PreparedStatement pstmt = null;
	//PreparedStatement pstmt_count = null;
	Statement stmt = null;
	ResultSet rs =null;
	//ResultSet rs_count =null;
	//int total_count=0;
	String sql = "";
//	String sql_count = "";
	int start=1;
	int end=0;
	int records_to_show=14;

	int nextOfRes = 1;
	int cnt = 0;
	
	String facilityid = (String)session.getValue("facility_id");
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	StringBuffer whereClause = new StringBuffer();
	whereClause.append(checkForNull(request.getParameter("whereclause")));
	String nursingunit = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	String specialty = request.getParameter("specialty")==null?"":request.getParameter("specialty");
	String practitioner = request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
	String fromdate = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String todate = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
	String patientno = request.getParameter("patient_no")==null?"":request.getParameter("patient_no");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	//Added by Devang for Spl. Chars.

	nursingunit=singleToDoubleQuotes(nursingunit);
	specialty=singleToDoubleQuotes(specialty);
	practitioner=singleToDoubleQuotes(practitioner);
	String className = "";

	int i = 0;

	if(!nursingunit.equals(""))
		whereClause.append(" and a.assign_care_locn_code = '"+nursingunit+"' ");
	if(!specialty.equals(""))
		whereClause.append(" and a.specialty_code = '"+specialty+"' ");
	if(!practitioner.equals(""))
		whereClause.append(" and a.attend_practitioner_id = '"+practitioner+"' ");
	if(!fromdate.equals("") || !todate.equals(""))
		whereClause.append(" and trunc(a.visit_adm_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
	if(!gender.equals(""))
		whereClause.append(" and e.sex = '"+gender+"' ");
	if(!patientno.equals(""))
		whereClause.append(" and a.patient_id = '"+patientno+"' ");
	if(!encounterid.equals(""))
		whereClause.append(" and a.encounter_id = '"+encounterid+"' ");

            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
				con =ConnectionManager.getConnection(request);

				/*sql_count ="SELECT count(1) FROM PR_ENCOUNTER a , MP_PATIENT e "+
				" WHERE a.facility_id='"+facilityid+"' AND a.patient_id=e.patient_id and a.adt_status != '09' AND "+
				" a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) "+
				" OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+ 
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b "+
				" WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id = "+
				" (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR "+
				" (TRUNC(visit_adm_date_time) IS NOT NULL AND  TRUNC(discharge_date_time) IS NULL)) "+
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString();


				pstmt_count = con.prepareStatement(sql_count);
				rs_count = pstmt_count.executeQuery();
				
				if(rs_count.next())
				{
					total_count=rs_count.getInt(1);
				}
					
			if (total_count>0)
			{
				*/
				/*sql="SELECT a.patient_id,patient_name,decode(sex,'M','Male','F','Female','U','Unknown') sex, a.encounter_id,to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,adt_status, "+
				" to_char(a.Discharge_date_time,'dd/mm/rrrr hh24:mi') disc_date_time FROM PR_ENCOUNTER a , MP_PATIENT e "+
				" WHERE a.facility_id='"+facilityid+"' AND a.patient_id=e.patient_id AND a.adt_status != '09' and "+
				" a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) "+
				" OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+ 
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b "+
				" WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id = "+
				" (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR "+
				" (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString() ;*/


				sql="SELECT a.patient_id, decode('"+localeName+"','en',E.patient_name,nvl(E.patient_name_loc_lang, E.patient_name)) patient_name, E.sex sex, a.encounter_id, to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,adt_status, AM_GET_DESC.AM_PRACTITIONER(a.admit_practitioner_id,'"+localeName+"','1') practitioner_name, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.ASSIGN_CARE_LOCN_code,'"+localeName+"','2') nursing_unit, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','1')specialty_code, to_char(a.Discharge_date_time,'dd/mm/rrrr hh24:mi') disc_date_time FROM PR_ENCOUNTER a, MP_PATIENT e WHERE a.facility_id='"+facilityid+"'  AND a.patient_id=e.patient_id AND a.adt_status != '09' and  a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b  WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id =  (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString() + " order by a.visit_adm_date_time desc" ;

				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//pstmt = con.prepareStatement(sql);
				//rs = pstmt.executeQuery();

				rs = stmt.executeQuery(sql);

				if ( (rs != null) )
				{
						rs.last();
						total_count = rs.getRow();
						rs.beforeFirst();
				}

				if (total_count>0)
				{		*/
						//out.println(sql);
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
						if ( from == null )
							start = 0 ;
						else
							start = Integer.parseInt( from ) ;
						
						if ( to == null )
							end = records_to_show ;
						else
							end = Integer.parseInt( to ) ;

						if(start > 1)
						{
							for(int k=0; k < start ;k++)
								rs.next();
						}

						int z=0;	
						
						while( (z < records_to_show) && rs.next() )
						{
							if(cnt == 0) 
							{
						out.println("<p><table align='right'><tr><td>");
						if ( !(start <= 0) )
								out.println("<A HREF='../jsp/QueryReAdmissionResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
								" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

							if ( nextOfRes == 1 )
								out.println("<A id='nextval' HREF='../jsp/QueryReAdmissionResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
								+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");
						
						/*out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
						out.println("<tr><th nowrap>&nbsp;</th><th nowrap>Admission Date/Time</th><th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></th></tr>");
						*/
						
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						}
						/*int z=0;		
						while(rs.next() && (z < records_to_show))
						{*/
							z++;
							if(i%2 == 0)
								className = "QRYEVEN";
							else
								className = "QRYODD";
							
							String adt_status=rs.getString("adt_status");
							if(adt_status == null) adt_status	= "";

							String sex = rs.getString("sex");

							if(sex.equalsIgnoreCase("M"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if(sex.equalsIgnoreCase("F"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");


							if(adt_status.equals("01"))
							out.println("<tr><td class='"+className+"'><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"')\">+</a></td>");
							else
							out.println("<td class='"+className+"'>&nbsp;</td>");

							String admn_date_time_display = rs.getString("admn_date_time");
							if(admn_date_time_display == null)
								admn_date_time_display = "&nbsp;";
							else
								admn_date_time_display = DateUtils.convertDate(admn_date_time_display,"DMYHM","en",localeName);

							String disc_date_time_display = rs.getString("disc_date_time");
							if(disc_date_time_display == null)
								disc_date_time_display = "&nbsp;";
							else
								disc_date_time_display = DateUtils.convertDate(disc_date_time_display,"DMYHM","en",localeName);

							
							out.println("<td nowrap class='"+className+"'>"+admn_date_time_display+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+sex+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("encounter_id")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("practitioner_name")+"</td>"); out.println("<td nowrap class='"+className+"'>"+rs.getString("specialty_code")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+disc_date_time_display+"</td></tr>");
							i++;
							cnt++;
						}
						out.println("</table>");
			 /*}
			 else
			 {
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			 }*/

			 if(cnt == 0)
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			 
			 if( !rs.next() && cnt!=0 )
			{
				nextOfRes=0;
			
            _bw.write(_wl_block12Bytes, _wl_block12);

			}

			}catch(Exception e) {out.println(e.toString());}
			finally
			{
				if (rs != null) rs.close();
				//if (pstmt != null) pstmt.close();
				if (stmt != null) stmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();
				ConnectionManager.returnConnection(con,request);
				out.println("<script>if(parent.frames[1].document.forms[0] != null) parent.frames[1].document.forms[0].search.disabled = false;</script>");
			}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedatetime.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
