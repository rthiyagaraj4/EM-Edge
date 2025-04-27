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
import java.sql.*;
import com.ehis.util.*;
import java.net.*;

public final class __querycanceltransferresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryCancelTransferResult.jsp", 1742452597190L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t\t<script language=\"JavaScript\">\n\n\t\tasync function showDetails(patid,encid,bookingrefno)\n\t\t{\n\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= 24 ;\n\t\t\tvar dialogWidth\t= 45 ;\n\t\t\tvar dialogTop = \"80\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/PaintAmendTransfer.jsp?encounterId=\"+escape(encid)+\"&patientId=\"+escape(patid)+\"&booking_ref_no=\"+escape(bookingrefno)+\"&fromFunction=Q\",arguments,features);\n\t\t}\n\n\t\tasync function showEncounterDetails(enc,patid,changefunc)\n\t\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"700px\" ;\n\t\t\tvar dialogWidth\t= \"900px\" ;\n\t\t\tvar dialogTop = \"80\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\t\t}\n\t</script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
			String sql = "";
//			String sql_count = "";
			int start=1;
			int end=0;
			int records_to_show=14;
			int nextOfRes = 1;
			int cnt = 0;

			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String locale       =(String) session.getAttribute("LOCALE"); 
			StringBuffer whereClause = new StringBuffer();
			whereClause.append(checkForNull(request.getParameter("whereclause")));

			String facilityid = (String)session.getAttribute("facility_id");
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
			String call_function	= request.getParameter("call_function")==null?"":request.getParameter("call_function");

			String className = "";
			
			int i = 0;

			if(!nursingunit.equals(""))
				//whereClause.append(" and NURSING_UNIT_CODE = '"+nursingunit+"' ");
				whereClause.append(" and a.REQ_NURSING_UNIT_CODE = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				//whereClause.append(" and SPECIALTY_CODE = '"+specialty+"' ");
				whereClause.append(" and a.REQ_SPECIALTY_CODE = '"+specialty+"' ");				
			if(!practitioner.equals(""))
				//whereClause.append(" and PRACTITIONER_ID = '"+practitioner+"' ");
				whereClause.append(" and A.REQ_PRACTITIONER_ID = '"+practitioner+"' ");
			if(!fromdate.equals("") || !todate.equals(""))
				//whereClause.append(" and trunc(TFR_REQ_DATE_TIME) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
				whereClause.append(" and trunc(A.TFR_REQ_DATE_TIME) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				//whereClause.append(" and gender = '"+gender+"' ");
				whereClause.append(" and b.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				//whereClause.append(" and patient_id = '"+patientno+"' ");
				whereClause.append(" and a.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				//whereClause.append(" and encounter_id = '"+encounterid+"' ");
				whereClause.append(" and a.encounter_id = '"+encounterid+"' ");
			if(!cancelledfromdate.equals("") || !cancelledtodate.equals(""))
				//whereClause.append(" and trunc(cancellation_date_time) between to_date(nvl('"+cancelledfromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+cancelledtodate+"','9/9/9999'),'dd/mm/rrrr') ");
				whereClause.append(" and trunc(a.cancellation_date_time) between to_date(nvl('"+cancelledfromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+cancelledtodate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!user.equals(""))
				//whereClause.append(" and cancelled_by_id = '"+user+"' ");
				whereClause.append(" and a.cancelled_by_id = '"+user+"' ");
		
            _bw.write(_wl_block8Bytes, _wl_block8);


			try{
				con =ConnectionManager.getConnection(request);
				
				//sql_count ="select count(*)  FROM IP_TRANSFER_REQUEST_VW  WHERE facility_id = ?  and tfr_req_status in ('2','9') "+whereClause.toString()+" ORDER BY tfr_req_type,encounter_id,patient_id";

				//sql_count ="select count(*)  FROM IP_TRANSFER_REQUEST a, mp_patient b, IP_OPEN_ENCOUNTER c WHERE a.facility_id = ? and a.tfr_req_status in ('2','9') and a.patient_id = b.patient_id AND A.ENCOUNTER_ID = c.ENCOUNTER_ID AND   A.FACILITY_ID = c.FACILITY_ID "+whereClause.toString()+" ORDER BY a.tfr_req_type,a.encounter_id,a.patient_id";

				if(call_function.equals("CT"))
				{
					sql = "select a.tfr_req_type, a.TFR_REQ_TYPE tfr_req_type_desc, a.encounter_id,a.patient_id, decode('"+localeName+"','en', b.patient_name, nvl(b.patient_name_loc_lang,b.patient_name)) patient_name, to_char(a.TFR_REQ_DATE_TIME,'dd/mm/rrrr') booking_date_time, a.cancelled_by_id, to_char(a.cancellation_date_time,'dd/mm/rrrr') cancellation_date_time, AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(a.REQ_SPECIALTY_CODE,'"+localeName+"','1')specialty_code, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.REQ_NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit, AM_GET_DESC.AM_CONTACT_REASON(a.CANCEL_REASON_CODE,'"+localeName+"','1') contact_reason FROM IP_TRANSFER_REQUEST a, mp_patient b, IP_OPEN_ENCOUNTER c WHERE a.facility_id = '"+facilityid+"' and a.tfr_req_status in ('2','9') and a.patient_id = b.patient_id AND A.ENCOUNTER_ID = c.ENCOUNTER_ID AND   A.FACILITY_ID = c.FACILITY_ID "+whereClause.toString()+" ORDER BY a.tfr_req_type,a.encounter_id,a.patient_id";

				}
				else
				{
					sql = " SELECT a.BOOKING_TYPE BOOKING_TYPE_DESC, a.bed_booking_ref_no, A.encounter_id,  A.patient_id, decode('"+localeName+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name,b.sex gender, AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(a.REQ_SPECIALTY_CODE,'"+localeName+"','1')specialty_code, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.REQ_NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit, to_char(a.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time, a.booked_by_id, to_char(a.CANCELLATION_DATE_TIME,'dd/mm/rrrr hh24:mi') cancelled_date_time, a.cancelled_by_id FROM IP_BED_BOOKING A, mp_patient b,IP_NURSING_UNIT C WHERE a.booking_status='9' and a.Booking_Type='T'  AND A.facility_id=  '"+facilityid+"' AND C.FACILITY_ID = A.FACILITY_ID AND C.NURSING_UNIT_CODE = A.REQ_NURSING_UNIT_CODE AND 		B.PATIENT_ID(+) = A.PATIENT_ID "+whereClause.toString()+" order by CANCELLATION_DATE_TIME";

				}

				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery(sql);
				if ( (rs != null) )
				{
					rs.last();
					total_count = rs.getRow();
					rs.beforeFirst();
				}*/
			
				/*pstmt_count = con.prepareStatement(sql_count);
				pstmt_count.setString(1,facilityid);
				rs_count = pstmt_count.executeQuery();
				if(rs_count.next())
					{
						total_count=rs_count.getInt(1);
					}
				*/
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

				/*if(total_count==0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}else{*/

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
				if ( !(start <= 0) )
                        out.println("<A HREF='../jsp/QueryCancelTransferResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&call_function="+call_function+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryCancelTransferResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&call_function="+call_function+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");

				
				/*if(call_function.equals("CT"))
				{
					sql = "select tfr_req_type,tfr_req_type_desc, encounter_id,patient_id,patient_name,to_char(TFR_REQ_DATE_TIME,'dd/mm/rrrr') booking_date_time,cancelled_by_id,to_char(cancellation_date_time,'dd/mm/rrrr') cancellation_date_time ,contact_reason  FROM  IP_TRANSFER_REQUEST_VW  WHERE facility_id = ?  and tfr_req_status in ('2','9') "+whereClause.toString()+" ORDER BY tfr_req_type,encounter_id,patient_id";

										
					
				}
				else
				{
					
					sql = " SELECT BOOKING_TYPE_DESC,bed_booking_ref_no, "+
						" A.encounter_id,A.patient_id,A.patient_name,a.gender,"+
						" to_char(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time,booked_by_id,"+
						" to_char(CANCELLATION_DATE_TIME,'dd/mm/rrrr hh24:mi') cancelled_date_time,cancelled_by_id"+
						" FROM IP_BED_BOOKING_VW A "+
						" WHERE booking_status='9' and Booking_Type='T' "+
						""+whereClause.toString()+""+
						" AND A.facility_id= ? order by CANCELLATION_DATE_TIME";

				}*/


				//pstmt = con.prepareStatement(sql);

				//pstmt.setString(1,facilityid);
				out.println("<tr><th nowrap>&nbsp;</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels")+"&nbsp;"+" </th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels")+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels")+"<br>Date/Time"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledByID.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelReasonDescription.label","ip_labels")+"&nbsp;"+"</th></tr>");
				}
						
				//rs = pstmt.executeQuery();
//out.println(sql);

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
					
					if(call_function.equals("CT"))
					{
						String tfr_req_type_desc= checkForNull(rs.getString("tfr_req_type_desc"));

						if(tfr_req_type_desc.equalsIgnoreCase("RT"))
							tfr_req_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RequestforTransfer.label","common_labels");
						else if(tfr_req_type_desc.equalsIgnoreCase("TO"))
							tfr_req_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferOut.label","common_labels");

						String booking_date_time_display = rs.getString("booking_date_time");
						if(booking_date_time_display == null)
							booking_date_time_display = "";
						else
							booking_date_time_display = DateUtils.convertDate(booking_date_time_display,"DMY","en",locale);

						String cancellation_date_time_display = rs.getString("cancellation_date_time");
						if(cancellation_date_time_display == null)
							cancellation_date_time_display = "";
						else
							cancellation_date_time_display = DateUtils.convertDate(cancellation_date_time_display,"DMY","en",locale);

						out.println("<tr><td class='"+className+"' ><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"','N')\">+</a></td>");
						out.println("<td class='"+className+"' nowrap >"+tfr_req_type_desc+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("encounter_id"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("patient_id"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("patient_name"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("nursing_unit"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("specialty_code"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("practitioner_name"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+booking_date_time_display+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+cancellation_date_time_display+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("cancelled_by_id"))+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("contact_reason"))+"</td></tr>");
					}
					else
					{
						String booking_type_desc= checkForNull(rs.getString("BOOKING_TYPE_DESC"));

						if(booking_type_desc.equalsIgnoreCase("B"))
							booking_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.block.label","common_labels");
						else if(booking_type_desc.equalsIgnoreCase("T"))
							booking_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels");
						else if(booking_type_desc.equalsIgnoreCase("D"))
							booking_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");

						else if(booking_type_desc.equalsIgnoreCase("H"))
							booking_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Hold.label","or_labels");

						else if(booking_type_desc.equalsIgnoreCase("L"))
							booking_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");

						String sex = checkForNull(rs.getString("gender"));

						if(sex.equalsIgnoreCase("M"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(sex.equalsIgnoreCase("F"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else 
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						String booking_date_time_display = rs.getString("booking_date_time");
						if(booking_date_time_display == null)
							booking_date_time_display = "";
						else
							booking_date_time_display = DateUtils.convertDate(booking_date_time_display,"DMY","en",locale);

						String cancellation_date_time_display = rs.getString("cancelled_date_time");
						if(cancellation_date_time_display == null)
							cancellation_date_time_display = "";
						else
							cancellation_date_time_display = DateUtils.convertDate(cancellation_date_time_display,"DMY","en",locale);


						out.println("<tr><td class='"+className+"'>"+booking_type_desc+"</td>");
						out.println("<td class='"+className+"'>"+checkForNull(rs.getString("bed_booking_ref_no"))+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("encounter_id"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("patient_id"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("patient_name"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("nursing_unit"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("specialty_code"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("practitioner_name"))+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+sex+"&nbsp;</td>");
						out.println("<td nowrap class='"+className+"'>"+booking_date_time_display+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("booked_by_id"))+"</td>");
						out.println("<td nowrap class='"+className+"'>"+cancellation_date_time_display+"</td>");
						out.println("<td nowrap class='"+className+"'>"+checkForNull(rs.getString("cancelled_by_id"))+"</td></tr>");
					}
					i++;
					cnt++;
				}
				out.println("</table>");

				if(cnt == 0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");

				if( !rs.next() && cnt!=0 )
				{
					nextOfRes=0;
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				}

				//}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();}
			finally
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (pstmt != null) pstmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();
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
