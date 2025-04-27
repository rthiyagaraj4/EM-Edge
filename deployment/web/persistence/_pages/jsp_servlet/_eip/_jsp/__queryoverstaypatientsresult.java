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

public final class __queryoverstaypatientsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryOverstayPatientsResult.jsp", 1742452796662L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script language=\"JavaScript\">\n\n\tasync function showEncounterDetails(enc,patid,changefunc)\n\t{\n\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"80vh\" ;\n\t\tvar dialogWidth\t= \"70vw\" ;\n\t\tvar dialogTop = \"0vh\" ;\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\t}\n\t</script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n    <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
 
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection con			= null;
			//PreparedStatement pstmt = null;
			Statement stmt			= null;
			ResultSet rs			= null;
			//int total_count=0;
			int start=1;
			int end=0;
			int records_to_show=14;
			
			String facilityid	= (String)session.getValue("facility_id");
			String locale       =(String) session.getAttribute("LOCALE"); 
			String from			= request.getParameter("from");
			String to			= request.getParameter("to");
			String whereclause = request.getParameter("whereclause");
			String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
			String specialty	= checkForNull(request.getParameter("specialty"));
			String practitioner = checkForNull(request.getParameter("practitioner"));
			String fromdate		= checkForNull(request.getParameter("from_date"));
			String todate		= checkForNull(request.getParameter("to_date"));
			String gender		= checkForNull(request.getParameter("gender"));
			String patientno	= checkForNull(request.getParameter("patient_no"));
			String encounterid	= checkForNull(request.getParameter("encounter_id"));
			String expdisdate	= checkForNull(request.getParameter("exp_dis_date"));
			nursingunit			= singleToDoubleQuotes(nursingunit);
			specialty			= singleToDoubleQuotes(specialty);
			practitioner		= singleToDoubleQuotes(practitioner);
			String className	= "";
			StringBuffer whereClause = new StringBuffer();
			StringBuffer sqlQuery	 = new StringBuffer();
			int i = 0;
			int nextOfRes =1;
			int cnt = 0;
			if(whereclause==null)
			{
			if(!nursingunit.equals(""))
				whereClause.append(" and a.nursing_unit_code = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				whereClause.append(" and a.specialty_code = '"+specialty+"' ");
			if(!practitioner.equals(""))
				//whereClause.append(" and a.practitioner_id = '"+practitioner+"' ");
				whereClause.append(" and a.attend_practitioner_id = '"+practitioner+"' ");				
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(A.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				//whereClause.append(" and a.gender = '"+gender+"' ");
				whereClause.append(" and c.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				whereClause.append(" and A.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				whereClause.append(" and A.encounter_id = '"+encounterid+"' ");
			if(!expdisdate.equals(""))
				whereClause.append(" and trunc(a.EXP_DISCHARGE_DATE_TIME) = to_date('"+expdisdate+"','dd/mm/rrrr') ");
			}else{
				if(whereClause.length() > 0) whereClause.delete(0,whereClause.length());
					whereClause.append(whereclause) ;
			}
				
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
				con =ConnectionManager.getConnection(request);
				
				/*sqlQuery.append("select count(*) cnt from IP_OPEN_ENCOUNTER_VW A,PR_ENCOUNTER_OTHER_DETAIL b  WHERE A.facility_id= ?  ");
				sqlQuery.append(" "+whereClause.toString()+" ");
				sqlQuery.append(" AND A.facility_id=b.operating_facility_id ");
				sqlQuery.append(" AND A.encounter_id=b.encounter_id ");
				sqlQuery.append(" AND NVL(EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE ");
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,facilityid);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					total_count=rs.getInt("cnt");
						
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(sqlQuery.length()>0)  sqlQuery.delete(0,sqlQuery.length());
				if(total_count==0)
				{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}else{*/
				
				/*sqlQuery.append(" SELECT (trunc(sysdate)-trunc(b.expected_discharge_date))excess_date, TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi') admn_date_time, ");
				sqlQuery.append(" A.encounter_id,A.patient_id, A.patient_name,decode(a.gender,'M','Male','F','Female','U','Unknown') gender, ");
				sqlQuery.append(" TO_CHAR(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date, ");
				sqlQuery.append(" A.nursing_unit_short_desc nursing_unit, a.specialty_short_desc,a.practitioner_name,A.bed_no ,A.room_no ");
				sqlQuery.append(" FROM IP_OPEN_ENCOUNTER_VW A,IP_ADT_TRN b ");
				sqlQuery.append(" WHERE A.facility_id= ?  ");
				sqlQuery.append(""+whereClause.toString()+"");
				sqlQuery.append(" AND A.facility_id=b.facility_id ");
				sqlQuery.append(" AND A.encounter_id=b.encounter_id ");
				sqlQuery.append(" AND NVL(expected_discharge_date,SYSDATE)<SYSDATE order by excess_date desc");*/

				/*sqlQuery.append(" SELECT (trunc(sysdate)-trunc(b.EXP_DISCHARGE_DATE_TIME))excess_date,TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') admn_date_time, A.encounter_id,A.patient_id, A.patient_name,decode(a.gender,'M','Male','F','Female','U','Unknown') gender, TO_CHAR(b.EXP_DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') expected_discharge_date, A.nursing_unit_short_desc nursing_unit,a.specialty_short_desc,a.practitioner_name,A.bed_no ,A.room_no FROM IP_OPEN_ENCOUNTER_VW A, PR_ENCOUNTER_OTHER_DETAIL b WHERE A.facility_id= ? ");
				sqlQuery.append(whereClause.toString());
				sqlQuery.append(" AND A.facility_id=b.operating_facility_id  AND A.encounter_id=b.encounter_id AND NVL(EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE order by excess_date desc ");*/


				sqlQuery.append("SELECT  (trunc(sysdate)-trunc(a.EXP_DISCHARGE_DATE_TIME))excess_date, TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') admn_date_time,A.encounter_id, A.patient_id, decode('"+localeName+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))  patient_name, c.sex gender, TO_CHAR(a.EXP_DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') expected_discharge_date,IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.nursing_unit_Code,'"+localeName+"','2') nursing_unit, AM_GET_DESC.AM_SPECIALITY(A.Specialty_Code,'"+localeName+"','2') specialty_short_desc, AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name, A.bed_num bed_no, A.room_num  room_no FROM IP_OPEN_ENCOUNTER A, mp_patient c WHERE A.facility_id= '"+facilityid+"' "+whereClause.toString()+" AND NVL(a.EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE and a.patient_id = c.patient_id  order by excess_date desc"); 				
				//pstmt = con.prepareStatement(sqlQuery.toString());
				//pstmt.setString(1,facilityid);
				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//rs = pstmt.executeQuery();
				rs = stmt.executeQuery(sqlQuery.toString());

				if ( (rs != null) )
				{
						rs.last();
						total_count = rs.getRow();
						rs.beforeFirst();
				}

				if(total_count==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
				else
				{*/
				//out.println(sqlQuery.toString());
				stmt = con.createStatement();
				rs = stmt.executeQuery(sqlQuery.toString());

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
				
				while((z < records_to_show) && rs.next())
				{
					if(cnt == 0)
					{
				out.println("<p><table align='right'><tr><td>");
				if ( !(start <= 1) )
                        out.println("<A HREF='../jsp/QueryOverstayPatientsResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryOverstayPatientsResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				


				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
				out.println("<tr><th nowrap>&nbsp;</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.OverstayDays.label","ip_labels")+"&nbsp;"+"</th><th  nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th></tr>");
				}
				/*int z=0;		
				while(rs.next() && (z < records_to_show))
				{*/
					z++;
					
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";

					String sex = rs.getString("gender");

					if(sex.equalsIgnoreCase("M"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
					String admn_date_time_display = rs.getString("admn_date_time");
					if(admn_date_time_display == null)
						admn_date_time_display = "";
					else
						admn_date_time_display = DateUtils.convertDate(admn_date_time_display,"DMYHM","en",locale);

					String expected_discharge_date_display = rs.getString("expected_discharge_date");
					if(expected_discharge_date_display == null)
						expected_discharge_date_display = "";
					else
						expected_discharge_date_display = DateUtils.convertDate(expected_discharge_date_display,"DMYHM","en",locale);

					out.println("<tr><td class='"+className+"' ><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"','N')\">+</a></td>");
					out.println("<td nowrap class='"+className+"'>"+admn_date_time_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+expected_discharge_date_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("excess_date")==null?"&nbsp;":rs.getString("excess_date"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("encounter_id")==null?"&nbsp;":rs.getString("encounter_id"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("patient_id")==null?"&nbsp;":rs.getString("patient_id"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("patient_name")==null?"&nbsp;":rs.getString("patient_name"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("gender")==null?"&nbsp;":sex)+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("nursing_unit")==null?"&nbsp;":rs.getString("nursing_unit"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("specialty_short_desc")==null?"&nbsp;":rs.getString("specialty_short_desc"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("practitioner_name")==null?"&nbsp;":rs.getString("practitioner_name"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("room_no")==null?"&nbsp;":rs.getString("room_no"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("bed_no")==null?"&nbsp;":rs.getString("bed_no"))+"&nbsp;</td></tr>");

					i++;
					cnt++;
				}
				out.println("</table>");

				if( !rs.next() && cnt!=0 )
				{
					nextOfRes=0;
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				} 
				if( cnt == 0) {																					        out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}
				//}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();
			}
			finally
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				ConnectionManager.returnConnection(con,request);
				out.println("<script>if(parent.frames[1].document.forms[0] != null) parent.frames[1].document.forms[0].search.disabled = false;</script>");
			}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
