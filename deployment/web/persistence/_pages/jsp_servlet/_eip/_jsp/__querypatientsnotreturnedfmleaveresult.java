package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __querypatientsnotreturnedfmleaveresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryPatientsNotReturnedFmLeaveResult.jsp", 1742452854933L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script language=\"JavaScript\">\n<!--\nasync function showEncounterDetails(enc,patid)\n{\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"80vh\" ;\n\tvar dialogWidth\t= \"70vw\" ;\n\tvar dialogTop = \"0vh\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n}\n//-->\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\tif (parseInt(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')==0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\tparent.frames[2].document.location.href = \'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[1].document.forms[0].search.disabled\n\t\t\t\t\t=false;\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	Statement stmt = null;
	//PreparedStatement pstmt = null;
	//PreparedStatement pstmt_count = null;
	ResultSet rs =null;
	//ResultSet rs_count =null;
	//int total_count=0;
	StringBuffer sql = new StringBuffer();
//	StringBuffer sql_count = new StringBuffer();
	StringBuffer whereClause = new StringBuffer();
	int start=1;
	int end=0;
	int records_to_show=14;

	String facilityid	= (String)session.getValue("facility_id");
	String locale		= (String)session.getAttribute("LOCALE");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");
	String condition	= checkForNull(request.getParameter("whereclause"));
	String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
	String specialty	= checkForNull(request.getParameter("specialty"));
	String practitioner = checkForNull(request.getParameter("practitioner"));
	String fromdate		= checkForNull(request.getParameter("from_date"));
	String todate		= checkForNull(request.getParameter("to_date"));
	String gender		= checkForNull(request.getParameter("gender"));
	String display		= checkForNull(request.getParameter("display"));
	String patientno	= checkForNull(request.getParameter("patient_no"));
	String encounterid	= checkForNull(request.getParameter("encounter_id"));
	String leavefromdate= checkForNull(request.getParameter("leave_from_date"));
	String leavetodate	= checkForNull(request.getParameter("leave_to_date"));
	String className	= "";
	int p_max_rec_cnt = 0;
	int nextOfRes = 1;
	int i = 0;
	//Added by Devang for Spl. Chars.
	nursingunit=singleToDoubleQuotes(nursingunit);
	specialty=singleToDoubleQuotes(specialty);
	practitioner=singleToDoubleQuotes(practitioner);
	whereClause.append(condition);

	if(!nursingunit.equals(""))
		//whereClause.append(" and assign_care_locn_code = '"+nursingunit+"' ");
		whereClause.append(" and B.NURSING_UNIT_CODE = '"+nursingunit+"' ");		
	if(!specialty.equals(""))
		//whereClause.append(" and specialty_code = '"+specialty+"' ");
		whereClause.append(" and B.specialty_code = '"+specialty+"' ");
	if(!practitioner.equals(""))
		//whereClause.append(" and attend_practitioner_id = '"+practitioner+"' ");
		whereClause.append(" and B.attend_practitioner_id = '"+practitioner+"' ");
	if(!fromdate.equals("") || !todate.equals(""))
			//whereClause.append(" and trunc(admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			whereClause.append(" and trunc(B.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
	if(!gender.equals(""))
		//whereClause.append(" and sex = '"+gender+"' ");
		whereClause.append(" and C.sex = '"+gender+"' ");
	if(display.equals("0"))
		//whereClause.append(" and  (leave_to_date < SYSDATE AND leave_status IN ('1') OR leave_status = '4')");
		whereClause.append(" and  (A.leave_to_date < SYSDATE AND A.leave_status IN ('1') OR A.leave_status = '4')");
	else if(display.equals("1"))
		//whereClause.append("and leave_to_date < SYSDATE AND leave_status IN ('1')");
		whereClause.append("and A.leave_to_date < SYSDATE AND A.leave_status IN ('1')");
	else if(display.equals("2"))
		//whereClause.append("AND leave_status = '4'");
		whereClause.append("AND A.leave_status = '4'");
	if(!patientno.equals(""))
		//whereClause.append(" and patient_id = '"+patientno+"' ");
		whereClause.append(" and B.patient_id = '"+patientno+"' ");
	if(!encounterid.equals(""))
		//whereClause.append(" and encounter_id = '"+encounterid+"' ");
		whereClause.append(" and A.encounter_id = '"+encounterid+"' ");
	if(!leavefromdate.equals(""))
	//whereClause.append(" and trunc(leave_fr_date) >=  to_date(nvl('"+leavefromdate+"','1/1/1111'),'dd/mm/rrrr')");
		whereClause.append(" and trunc(A.leave_fr_date) >=  to_date(nvl('"+leavefromdate+"','1/1/1111'),'dd/mm/rrrr')");
	if(!leavetodate.equals(""))
		//whereClause.append(" and trunc(leave_to_date) <= to_date(nvl('"+leavetodate+"','9/9/9999'),'dd/mm/rrrr') ");
		whereClause.append(" and trunc(A.leave_to_date) <= to_date(nvl('"+leavetodate+"','9/9/9999'),'dd/mm/rrrr') ");

            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
				con =ConnectionManager.getConnection(request);
				//Added by Devang for Previous/Next logic

				/*sql_count.append(" SELECT count(*) ");
				sql_count.append(" FROM ip_leave_detail_vw ");
				sql_count.append(" WHERE facility_id= ? ");
				sql_count.append(" "+whereClause.toString()+" ");
				sql_count.append(" ORDER BY encounter_id ");
				
				// out.println("First:"+ sql_count.toString());
				pstmt_count = con.prepareStatement(sql_count.toString());
				pstmt_count.setString(1,facilityid);

				rs_count = pstmt_count.executeQuery();
				if(rs_count.next())
				{
					total_count=rs_count.getInt(1);
				}
				*/	

				sql.append("SELECT TO_CHAR(b.admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time,a.encounter_id, c.patient_id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name, c.SEX gender, a.leave_status, IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_CODE,'"+locale+"','2') nursing_unit, AM_GET_DESC.AM_PRACTITIONER(B.attend_practitioner_id,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(B.specialty_code,'"+localeName+"','1')specialty_code, TO_CHAR(a.leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, TO_CHAR(a.leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, NVL(a.release_bed_yn,'N') release_bed_yn, b.bed_num bed_no FROM ip_leave_detail a, ip_open_encounter b, mp_patient c WHERE a.facility_id= '"+facilityid+"' and a.facility_id= b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id "+whereClause.toString()+" ORDER BY a.encounter_id");
					
				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
				rs = stmt.executeQuery(sql.toString());

				if ( (rs != null) )
				{
				   rs.last();
				   total_count = rs.getRow();
				   rs.beforeFirst();
				}*/
				//out.println(sql.toString());
				stmt = con.createStatement();	
				rs = stmt.executeQuery(sql.toString());


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

				while((z < records_to_show) &&  rs.next())
				{
					if(p_max_rec_cnt==0)
					{
				
					out.println("<p><table align='right'><tr><td>");
					if ( !(start <= 0) )
                        out.println("<A HREF='../jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				
				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");

				/*sql.append(" SELECT TO_CHAR(admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time, ");
				sql.append(" encounter_id,patient_id,patient_name,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,leave_status,NURSING_UNIT_SHORT_DESC nursing_unit, ");
				sql.append(" TO_CHAR(leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, ");
				sql.append(" TO_CHAR(leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, ");
				sql.append(" NVL(release_bed_yn,'N') release_bed_yn, bed_no ");
				sql.append(" FROM ip_leave_detail_vw ");
				sql.append(" WHERE facility_id= ? ");
				sql.append(""+whereClause.toString()+"");
				sql.append(" ORDER BY encounter_id ");*/

				/*sql.append("SELECT TO_CHAR(b.admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time,		a.encounter_id, c.patient_id, decode('"+locale+"','"+locale+"',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name, c.SEX gender, a.leave_status, IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_CODE,'"+locale+"','2') nursing_unit, TO_CHAR(a.leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, TO_CHAR(a.leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, NVL(a.release_bed_yn,'N') release_bed_yn, b.bed_num bed_no FROM ip_leave_detail a, ip_open_encounter b, mp_patient c WHERE a.facility_id= ? and a.facility_id= b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id and a.leave_to_date < SYSDATE AND a.leave_status IN ('1') and trunc(a.leave_fr_date) >= to_date(nvl('29/11/2005','1/1/1111'),'dd/mm/rrrr') and trunc(a.leave_to_date) <= to_date(nvl('29/11/2006','9/9/9999'),'dd/mm/rrrr') ORDER BY a.encounter_id");*/

				//out.println("Second:"+ sql.toString());

				//pstmt = con.prepareStatement(sql.toString());
				//pstmt.setString(1,facilityid);
				out.println("<tr><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdatetime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToDateTime.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReleaseBed.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th></tr>");
				}
						
				//rs = pstmt.executeQuery();
				/*if(start > 1)
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}
				int z=0;
				while(rs.next()&& (z < records_to_show))
				{*/
					z++;
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";

					String sex = rs.getString("gender");

					if(sex.equalsIgnoreCase("M"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
					String adm_date_time_display = rs.getString("adm_date_time");
					if(adm_date_time_display == null)
						adm_date_time_display = "";
					else
						adm_date_time_display = DateUtils.convertDate(adm_date_time_display,"DMYHM","en",locale);

					String leave_fr_date_display = rs.getString("leave_fr_date");
					if(leave_fr_date_display == null)
						leave_fr_date_display = "";
					else
						leave_fr_date_display = DateUtils.convertDate(leave_fr_date_display,"DMYHM","en",locale);

					String leave_to_date_display = rs.getString("leave_to_date");
					if(leave_to_date_display == null)
						leave_to_date_display = "";
					else
						leave_to_date_display = DateUtils.convertDate(leave_to_date_display,"DMYHM","en",locale);

					String img = "<img src='../../eCommon/images/enabled.gif'></img>";
					String img1 = "<img src='../../eCommon/images/disabled.gif'></img>";
					out.println("<tr><td nowrap class='"+className+"'>"+rs.getLong("encounter_id")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+sex+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+adm_date_time_display+"&nbsp;</td>");
					String disp = rs.getString("leave_status");
					if (disp.equals("1"))
						disp= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
					else
						disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abscond.label","common_labels");
					out.println("<td nowrap class='"+className+"'>"+disp+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+leave_fr_date_display+"&nbsp;</td>");			
					out.println("<td nowrap class='"+className+"'>"+leave_to_date_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("practitioner_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("specialty_code")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"' align=center>"+(rs.getString("release_bed_yn").equals("Y")?img:img1)+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("bed_no")==null?"&nbsp;":rs.getString("bed_no"))+"&nbsp;</td></tr>");
					i++;
					p_max_rec_cnt++;
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_max_rec_cnt));
            _bw.write(_wl_block10Bytes, _wl_block10);

				out.println("</table>");
				if( !rs.next() && p_max_rec_cnt!=0 )
				{
					nextOfRes=0;
				
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (pstmt != null) pstmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();

			}catch(Exception e) {out.println(e.toString());}
			finally
			{
				ConnectionManager.returnConnection(con,request);
				out.println("<script>if(parent.frames[1].document.forms[0] != null) parent.frames[1].document.forms[0].search.disabled = false;</script>");
			}

            _bw.write(_wl_block12Bytes, _wl_block12);
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
