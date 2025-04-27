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

public final class __querycancelledadmissionsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryCancelledAdmissionsResult.jsp", 1742452583236L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t\t<script language=\"JavaScript\">\n\t\tasync function showModal(remarks){\n\n\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \'500px\' ;\n\t\t\t\tvar dialogWidth\t= \'800px\' ;\n\t\t\t\tvar dialogTop = \"40px\" ;\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/ShowCancelReason.jsp?remarks=\"+remarks,arguments,features);\n\t\t\n\t\t}\n\t\t\n\t\t\tasync function showEncounterDetails(enc,patid,changefunc)\n\t\t\t{\n\t\t\t\t\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"700px\";\n\t\t\t\t\tvar dialogWidth = \"900px\";\n\t\t\t\t\tvar dialogTop\t= \"72\";\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\t\t\t\t\tif(retVal!=null && retVal!=\'\')\n\t\t\t\t\tdocument.location.reload();\n\t\t\t}\n\t</script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n</html>\n\n";
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

			Connection con = null;
			//PreparedStatement pstmt = null;
			//PreparedStatement pstmt_count = null;
			Statement stmt = null;
			ResultSet rs =null;
//			ResultSet rs_count =null;
			//int total_count=0;
			String sql = "";
//			String sql_count = "";
			int start=1;
			int end=0;
			int records_to_show=14;


			String from = request.getParameter("from");
			String to = request.getParameter("to");
			StringBuffer whereClause	= new StringBuffer();
			String locale       =(String) session.getAttribute("LOCALE"); 
			whereClause.append(checkForNull(request.getParameter("whereclause")));

			if(whereClause.toString() == null)whereClause.append("");
			String facilityid = (String)session.getValue("facility_id");
			String nursingunit = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
			String specialty = request.getParameter("specialty")==null?"":request.getParameter("specialty");
			String practitioner = request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
			String fromdate = request.getParameter("from_date")==null?"":request.getParameter("from_date");
			String todate = request.getParameter("to_date")==null?"":request.getParameter("to_date");
			String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
			String patientno = request.getParameter("patient_no")==null?"":request.getParameter("patient_no");
			String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String cancelledfromdate = request.getParameter("cancelled_from_date")==null?"":request.getParameter("cancelled_from_date");
			String cancelledtodate = request.getParameter("cancelled_to_date")==null?"":request.getParameter("cancelled_to_date");
			String user = request.getParameter("user")==null?"":request.getParameter("user");

			nursingunit	=singleToDoubleQuotes(nursingunit);
			specialty	=singleToDoubleQuotes(specialty);
			practitioner=singleToDoubleQuotes(practitioner);
			user		=singleToDoubleQuotes(user);

			String className = "";
			
			int i = 0;
			int nextOfRes = 1;
			int cnt = 0;

			if(!nursingunit.equals(""))
				//whereClause.append(" and c.nursing_unit_code = '"+nursingunit+"' ");
				whereClause.append(" and a.assign_care_locn_code = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				whereClause.append(" and a.specialty_code = '"+specialty+"' ");
			if(!practitioner.equals(""))
				whereClause.append(" and a.attend_practitioner_id = '"+practitioner+"' ");
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(a.visit_adm_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				whereClause.append(" and b.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				whereClause.append(" and b.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				whereClause.append(" and a.encounter_id = '"+encounterid+"' ");
			if(!cancelledfromdate.equals("") || !cancelledtodate.equals(""))
				whereClause.append(" and trunc(a.adt_status_set_on_date) between to_date(nvl('"+cancelledfromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+cancelledtodate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!user.equals(""))
				whereClause.append(" and a.adt_status_set_by_user = '"+user+"' ");
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			try{


				con =ConnectionManager.getConnection(request);
				//Added by Devang for Previous/Next logic
				/*sql_count ="select count(*) "+
				" from pr_encounter a , "+
				" mp_patient b, "+
				" ip_nursing_unit_vw c, "+
				" ip_admission_type d, "+
				" am_practitioner e "+
				" where a.adt_status  ='09' "+
				" and a.facility_id = ? "+
				""+whereClause.toString()+""+
				" and a.assign_care_locn_code = c.nursing_unit_code(+)  "+
				" and a.facility_id = c.facility_id  "+
				" and a.patient_id = b.patient_id(+)  "+
				" and a.visit_adm_type = d.admission_type_code(+)  "+
				" and a.attend_practitioner_id = e.practitioner_id(+)  "+
				" order by nursing_unit_short_desc,a.adt_status_set_on_date desc  ";
				pstmt_count = con.prepareStatement(sql_count);
				pstmt_count.setString(1,facilityid);
				rs_count = pstmt_count.executeQuery();

				if(rs_count.next())
					{
						total_count=rs_count.getInt(1);
					}
				if(total_count==0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}else{*/
					

				/*sql = " select "+
						" a.ADT_STATUS_SET_REASON,a.encounter_id , a.patient_id , "+
						" b.patient_name, decode(b.sex,'M','Male','F','Female','Unknown') sex, to_char(b.date_of_birth,'dd/mm/rrrr') DOB, "+
						" to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') adm_date_time , "+
						" d.short_desc admission_type_desc, "+
						" decode(d.adm_type_ind,'A','Accident','U','Emergency','M','Labour and Delivery','N','Routine','O','Observation','D','Day Care') adm_type_ind, "+
						" c.nursing_unit_short_desc nursing_unit, "+
						" c.nursing_unit_type_short_desc, "+
						" e.practitioner_name, "+
						" a.assign_room_num , "+
						" a.assign_bed_num , "+
						" to_char(a.discharge_date_time,'dd/mm/rrrr hh24:mi') dis_date_time, "+
						" to_char(a.adt_status_set_on_date,'dd/mm/rrrr hh24:mi') cancelled_date, "+
						" a.modified_by_id, a.cancel_reason_code, f.contact_reason "+
						" from pr_encounter a , "+
						" mp_patient b, "+
						" ip_nursing_unit_vw c, "+
						" ip_admission_type d, "+
						" am_practitioner e, "+
						" am_contact_reason f "+
						" where a.adt_status  ='09' "+
						" and a.facility_id = ? "+
						""+whereClause.toString()+""+
						" and a.assign_care_locn_code = c.nursing_unit_code  "+
						" and a.facility_id = c.facility_id  "+
						" and a.patient_id = b.patient_id  "+
						" and a.visit_adm_type = d.admission_type_code  "+
						" and a.admit_practitioner_id = e.practitioner_id  "+
						" and a.cancel_reason_code = f.contact_reason_code "+
						" order by a.adt_status_set_on_date,a.ENCOUNTER_ID,nursing_unit_short_desc desc  ";*/

						sql ="select a.ADT_STATUS_SET_REASON, a.encounter_id, a.patient_id,decode('"+localeName+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex  sex, to_char(b.date_of_birth,'dd/mm/rrrr') DOB,to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') adm_date_time, IP_GET_DESC.IP_ADMISSION_TYPE(A.VISIT_ADM_TYPE ,'"+localeName+"','2') admission_type_desc,A.VISIT_ADM_TYPE adm_type_ind, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.ASSIGN_CARE_LOCN_code,'"+localeName+"','2') nursing_unit, NULL nursing_unit_type_short_desc, AM_GET_DESC.AM_PRACTITIONER(a.admit_practitioner_id,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','1')specialty_code, a.assign_room_num , a.assign_bed_num ,to_char(a.discharge_date_time,'dd/mm/rrrr hh24:mi') dis_date_time, to_char(a.adt_status_set_on_date,'dd/mm/rrrr hh24:mi') cancelled_date, A.modified_by_id, a.cancel_reason_code, AM_GET_DESC.AM_CONTACT_REASON(A.cancel_reason_code,'"+localeName+"','1') contact_reason FROM pr_encounter a , mp_patient b  where a.adt_status ='09' and a.facility_id = '"+facilityid+"' " + whereClause.toString()+" and a.patient_id = b.patient_id order by a.adt_status_set_on_date, a.ENCOUNTER_ID,IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.ASSIGN_CARE_LOCN_code,'"+localeName+"','2') desc ";

						/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						rs = stmt.executeQuery(sql);

						if ( (rs != null) )
						{
							rs.last();
							total_count = rs.getRow();
							rs.beforeFirst();
						}
						if (total_count==0)	
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
						else
						{*/
						//out.println(sql);
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
				
				
				//added by Devang for Previous/Next

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
				String sex;
				while( (z < records_to_show) && rs.next() )
				{
					if(cnt == 0)
					{
						
				out.println("<p><table align='right'><tr><td>");
				if ( !(start <= 0) )
                        out.println("<A HREF='../jsp/QueryCancelledAdmissionsResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryCancelledAdmissionsResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
				out.println("<tr><th nowrap>&nbsp;</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiontype.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDate/Time.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledByID.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforCancellation.label","common_labels")+"&nbsp;"+"</th></tr>");						
				}
				/*if(start > 1)
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}
				int z=0;
				String sex;
				while(rs.next() && (z < records_to_show))
				{*/
					z++;
					if(i%2 == 0)
						className = "QRYEVENSMALL";
					else
						className = "QRYODDSMALL";
				
					sex = rs.getString("sex");

					if(sex.equalsIgnoreCase("M"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					out.println("<tr><td class='"+className+"' ><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"','N')\">+</a></td>");
					out.println("<td class='"+className+"'>"+rs.getString("encounter_id")+"&nbsp;</td>");
					out.println("<td class='"+className+"'>"+rs.getString("patient_id")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+sex+"&nbsp;</td>");
				
					String adm_date_time_display = rs.getString("adm_date_time");
					if(adm_date_time_display == null)
						adm_date_time_display = "";
					else
						adm_date_time_display = DateUtils.convertDate(adm_date_time_display,"DMYHM","en",locale);

					String cancelled_date_display = rs.getString("cancelled_date");
					if(cancelled_date_display == null)
						cancelled_date_display = "";
					else
						cancelled_date_display = DateUtils.convertDate(cancelled_date_display,"DMYHM","en",locale);

					out.println("<td nowrap class='"+className+"'>"+adm_date_time_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("admission_type_desc")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+cancelled_date_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("specialty_code")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("practitioner_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("assign_room_num")==null?"&nbsp;":rs.getString("assign_room_num"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("assign_bed_num")==null?"&nbsp;":rs.getString("assign_bed_num"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("modified_by_id")==null?"&nbsp;":rs.getString("modified_by_id"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("contact_reason")==null?"&nbsp;":rs.getString("contact_reason"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'></td></tr>");
					i++;
					cnt++;
				}
				out.println("</table>");
				if( !rs.next() && cnt!=0 )
				{
					nextOfRes=0;
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
				if(cnt == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}

				//}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();}
			finally
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				ConnectionManager.returnConnection(con,request);
				
				//added on 20-10-2003 by dhanasekaran
				out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
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
