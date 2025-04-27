<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType = " text/html;charset=UTF-8 " import = " java.sql.* , java.util.* , java.net.* , java.text.* , webbeans.eCommon.*,eCommon.XSSRequestWrapper" 
%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	</head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad=''>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String classvalue = "";
	String facilityId = (String) session.getValue( "facility_id" ) ;
	StringBuffer sql=new StringBuffer(" ");
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String mds_code = request.getParameter("mds_code");
	String patient_class = request.getParameter("patient_class");
	if ( (whereClause == null || whereClause.equals("")) )
	{
	//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	String mds_sub_code =request.getParameter("mds_sub_code");
	String mds_sub_desc =request.getParameter("mds_sub_desc");
	//End
	int andCheck = 0;

	String ord[] = request.getParameterValues("orderbycolumns");

	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	String qry_mds_sub_desc="";
	if((mds_code.equals("ORDR"))||(mds_code.equals("CHRT")))
	qry_mds_sub_desc="c.short_desc";
	if(mds_code.equals("DIAG"))
	qry_mds_sub_desc="c.term_set_desc";
	if(mds_code.equals("CLIN"))
	qry_mds_sub_desc="c.NOTE_TYPE_DESC";
	if ( !(mds_sub_code == null || mds_sub_code.equals("")) )
		{
		sql.append(" and  upper(a.term_set_id)  like  upper('"+mds_sub_code+"%') ");
		andCheck = 1;
		}
	else 
		{
		sql.append(" and  upper(a.term_set_id)  =  NVL ('"+mds_sub_code+"', UPPER (a.term_set_id)) ");
		andCheck = 1;
		}
	if ( !(mds_sub_desc == null || mds_sub_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append(" upper("+qry_mds_sub_desc+")  like  upper('"+mds_sub_desc+"%') ") ;
			}
			else
			{
				sql.append(" and  upper("+qry_mds_sub_desc+") like upper('"+mds_sub_desc+"%') " );
				andCheck = 1;
			}
		}
	else 
		{
		sql.append(" and  upper("+qry_mds_sub_desc+")  =  NVL ('"+mds_sub_desc+"', UPPER ("+qry_mds_sub_desc+")) ");
		andCheck = 1;
		}	
	//End	
if ( !(ord == null || ord .equals("")) )
	{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sql.append(ord[i]);
				}else{
					sql.append(ord[i]);
					sql.append(",");
				}
			}
		}
	
		}
	else
		{
		sql.append(whereClause);
		}
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	Connection conn = null;
	PreparedStatement pstmt=null;
	Statement stmt = null;
	ResultSet rs=null;
	try
		{
			StringBuffer sql2 = new StringBuffer();
			conn = ConnectionManager.getConnection(request);
			
			//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			if(mds_code.equals("DIAG")){
			sql2.append(" SELECT a.MDS_CODE,b.short_desc, a.TERM_SET_ID mds_sub_code,c.term_set_desc mds_sub_desc, a.APPLICABLE_TO_IP_YN,a.MANDATORY_FOR_IP_YN, a.APPLICABLE_TO_OP_YN, a.MANDATORY_FOR_OP_YN, a.APPLICABLE_TO_EM_YN, a.MANDATORY_FOR_EM_YN, a.APPLICABLE_TO_DC_YN, a.MANDATORY_FOR_DC_YN FROM mr_mds_for_patient_class a,mr_mds b,mr_term_set c WHERE a.MDS_CODE=b.mds_code AND a.TERM_SET_ID= c.term_set_id and upper(a.mds_code) = NVL('"+mds_code+"',upper(a.mds_code)) and ((a.APPLICABLE_TO_IP_YN='Y' and '"+ patient_class +"' ='IP') or (a.APPLICABLE_TO_OP_YN='Y' and '"+ patient_class +"' ='OP') or (a.APPLICABLE_TO_EM_YN='Y' and '"+ patient_class +"' ='EM') or (a.APPLICABLE_TO_DC_YN='Y' and '"+ patient_class +"' ='DC') or '"+ patient_class +"' ='ALL') and c.diag_spec_yn='Y' " + sql.toString());
			}
			if(mds_code.equals("CHRT"))
			{
			sql2.append(" SELECT a.MDS_CODE,b.short_desc, a.TERM_SET_ID mds_sub_code,c.short_desc mds_sub_desc, a.APPLICABLE_TO_IP_YN,a.MANDATORY_FOR_IP_YN, a.APPLICABLE_TO_OP_YN, a.MANDATORY_FOR_OP_YN, a.APPLICABLE_TO_EM_YN, a.MANDATORY_FOR_EM_YN, a.APPLICABLE_TO_DC_YN, a.MANDATORY_FOR_DC_YN FROM mr_mds_for_patient_class a,mr_mds b,ca_chart c WHERE a.MDS_CODE=b.mds_code AND a.TERM_SET_ID= c.chart_id and upper(a.mds_code) = NVL('"+mds_code+"',upper(a.mds_code)) and ((a.APPLICABLE_TO_IP_YN='Y' and '"+ patient_class +"' ='IP') or (a.APPLICABLE_TO_OP_YN='Y' and '"+ patient_class +"' ='OP') or (a.APPLICABLE_TO_EM_YN='Y' and '"+ patient_class +"' ='EM') or (a.APPLICABLE_TO_DC_YN='Y' and '"+ patient_class +"' ='DC') or '"+ patient_class +"' ='ALL') " + sql.toString());
			}
			if(mds_code.equals("ORDR")){
			sql2.append(" SELECT a.MDS_CODE,b.short_desc, a.TERM_SET_ID mds_sub_code,c.short_desc mds_sub_desc, a.APPLICABLE_TO_IP_YN,a.MANDATORY_FOR_IP_YN, a.APPLICABLE_TO_OP_YN, a.MANDATORY_FOR_OP_YN, a.APPLICABLE_TO_EM_YN, a.MANDATORY_FOR_EM_YN, a.APPLICABLE_TO_DC_YN, a.MANDATORY_FOR_DC_YN FROM mr_mds_for_patient_class a,mr_mds b,or_order_category c WHERE a.MDS_CODE=b.mds_code AND a.TERM_SET_ID= c.order_category and upper(a.mds_code) = NVL('"+mds_code+"',upper(a.mds_code)) and ((a.APPLICABLE_TO_IP_YN='Y' and '"+ patient_class +"' ='IP') or (a.APPLICABLE_TO_OP_YN='Y' and '"+ patient_class +"' ='OP') or (a.APPLICABLE_TO_EM_YN='Y' and '"+ patient_class +"' ='EM') or (a.APPLICABLE_TO_DC_YN='Y' and '"+ patient_class +"' ='DC') or '"+ patient_class +"' ='ALL') " + sql.toString());
			}
			if(mds_code.equals("CLIN")){
			sql2.append(" SELECT a.MDS_CODE,b.short_desc, a.TERM_SET_ID mds_sub_code,c.note_type_desc mds_sub_desc, a.APPLICABLE_TO_IP_YN,a.MANDATORY_FOR_IP_YN, a.APPLICABLE_TO_OP_YN, a.MANDATORY_FOR_OP_YN, a.APPLICABLE_TO_EM_YN, a.MANDATORY_FOR_EM_YN, a.APPLICABLE_TO_DC_YN, a.MANDATORY_FOR_DC_YN FROM mr_mds_for_patient_class a,mr_mds b,ca_note_type c WHERE a.MDS_CODE=b.mds_code AND a.TERM_SET_ID= c.note_type and upper(a.mds_code) = NVL('"+mds_code+"',upper(a.mds_code))  and ((a.APPLICABLE_TO_IP_YN='Y' and '"+ patient_class +"' ='IP') or (a.APPLICABLE_TO_OP_YN='Y' and '"+ patient_class +"' ='OP') or (a.APPLICABLE_TO_EM_YN='Y' and '"+ patient_class +"' ='EM') or (a.APPLICABLE_TO_DC_YN='Y' and '"+ patient_class +"' ='DC') or '"+ patient_class +"' ='ALL') " + sql.toString());
			}
			//End
			stmt = conn.createStatement();	
			rs = stmt.executeQuery(sql2.toString());
	
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			rs.next() ;
	  		String classValue = "" ;
			int cnt=0;

			while ( i<=end && rs.next())
				{
				if(cnt==0)
					{
		%><table align='right'>
		<tr>
<%		if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/MDSForPatClassQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&patient_class="+patient_class+"&mds_code="+mds_code+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
			<td align ='right' id='next' style='visibility:hidden'>
			<%
				//if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eMR/jsp/MDSForPatClassQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&patient_class="+patient_class+"&mds_code="+mds_code+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>			</td>
	</tr>
</table>

<br><br><br>
<table cellpadding=0 cellspacing=0 border=1 width='100%'  align=center>
	<tr>
		<th width="15%" align='left'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></th>
		<th width="18%" align='left'><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<!--Maheshwaran K added and modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
		<!--Start-->
		<%if(mds_code.equals("CLIN"))
		{
			%>
			<th width="13%" align='left'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
			<th width="20%" align='left'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%
			}
		if(mds_code.equals("ORDR"))
			{
			%>
			<th width="13%" align='left'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
			<th width="20%" align='left'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%
			}
		if(mds_code.equals("CHRT"))
			{
			%>
			<th width="13%" align='left'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></th>
			<th width="20%" align='left'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%
			}
		if(mds_code.equals("DIAG"))
			{
			%>
			<th width="13%" align='left'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></th>
			<th width="20%" align='left'><fmt:message key="eMR.TerminologySetDescription.label" bundle="${mr_labels}"/></th>
			<%
			}
		%>
		<%if(patient_class.equals("IP")) {%>
		<th width="5%" align='left'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></th>
		<%}
		else if(patient_class.equals("OP")) {%>
		<th width="5%" align='left'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></th>
		<%}
		else if(patient_class.equals("EM")) {%>
		<th width="5%" align='left'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></th>
		<%}
		else if(patient_class.equals("DC")) {%>
		<th width="9%" align='left'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></th>
		<%}
		else if(patient_class.equals("ALL")) {%>
		<th width="5%" align='left'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></th>
		<th width="5%" align='left'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></th>
		<th width="5%" align='left'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></th>
		<th width="9%" align='left'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></th>
		<%}%>
	</tr>
	<!--End-->
<% 
			}
			
			String msdcode = checkForNull(rs.getString("mds_code"));
			String mds_desc = checkForNull(rs.getString("short_desc"));
			//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			String mds_sub_code1 = checkForNull(rs.getString("mds_sub_code"));
			String mds_sub_desc1 = checkForNull(rs.getString("mds_sub_desc"));
			String app_ip  = checkForNull(rs.getString("applicable_to_ip_yn"));
			String app_op  = checkForNull(rs.getString("applicable_to_op_yn"));
			String app_em  = checkForNull(rs.getString("applicable_to_em_yn"));
			String app_dc  = checkForNull(rs.getString("applicable_to_dc_yn"));
			String man_ip  = checkForNull(rs.getString("mandatory_for_ip_yn"));
			String man_op  = checkForNull(rs.getString("mandatory_for_op_yn"));
			String man_em  = checkForNull(rs.getString("mandatory_for_em_yn"));
			String man_dc  = checkForNull(rs.getString("mandatory_for_dc_yn"));
			String app_ip_y = "";
			String app_op_y = "";
			String app_em_y = "";
			String app_dc_y = "";
			
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			/*app_ip_y = app_ip.equals("Y") ? "Yes" : "No";
			app_op_y = app_op.equals("Y") ?  "Yes" : "No";
			app_em_y = app_em.equals("Y") ? "Yes" : "No";
			app_dc_y = app_dc.equals("Y") ? "Yes" : "No";*/
			
			app_ip_y = app_ip.equals("Y") ? "<img src='../../eCommon/images/enabled.gif'></img>" : "<img src='../../eCommon/images/RRnwd.gif'></img>" ;
			app_op_y = app_op.equals("Y") ? "<img src='../../eCommon/images/enabled.gif'></img>" : "<img src='../../eCommon/images/RRnwd.gif'></img>" ;
			app_em_y = app_em.equals("Y") ? "<img src='../../eCommon/images/enabled.gif'></img>" : "<img src='../../eCommon/images/RRnwd.gif'></img>" ;
			app_dc_y = app_dc.equals("Y") ? "<img src='../../eCommon/images/enabled.gif'></img>" :"<img src='../../eCommon/images/RRnwd.gif'></img>" ;

			out.println("<tr><td align='left' class='" + classValue + "'>");	
			out.println("<a href=\'../../eMR/jsp/addModifyMDSForPatientClass.jsp?mds_code="+msdcode+"&patient_class="+patient_class+"&mds_sub_code="+mds_sub_code1+"&mds_sub_desc="+mds_sub_desc1+"&applicable_to_ip_yn="+app_ip+"&applicable_to_op_yn="+app_op+"&applicable_to_em_yn="+app_em+"&applicable_to_dc_yn="+app_dc+"&mandatory_for_ip_yn="+man_ip+"&mandatory_for_op_yn="+man_op+"&mandatory_for_em_yn="+man_em+"&mandatory_for_dc_yn="+man_dc+"&mode=modify' target='f_query_add_mod'>");
			out.println(msdcode+"</a></td><td class='" + classValue + "'>");
			out.println(mds_desc);
			out.println("</td><td class = '" + classValue + "'>");
			//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			out.println(mds_sub_code1 );
			out.println("</td><td class='" + classValue +"'>");
			out.println(mds_sub_desc1);
			out.println("</td>");
			if(patient_class.equals("IP"))
			out.println("<td class='" + classValue +"'>"+app_ip_y+"</td>");
			if(patient_class.equals("OP"))
			out.println("<td class='" + classValue +"'>"+app_op_y+"</td>");
			if(patient_class.equals("EM"))
			out.println("<td class='" + classValue +"'>"+app_em_y+"</td>");
			if(patient_class.equals("DC"))
			out.println("<td class='" + classValue +"'>"+app_dc_y+"</td>");
			if(patient_class.equals("ALL")){
			out.println("<td class='" + classValue +"'>"+app_ip_y+"</td>");
			out.println("<td class='" + classValue +"'>"+app_op_y+"</td>");
			out.println("<td class='" + classValue +"'>"+app_em_y+"</td>");
			out.println("<td class='" + classValue +"'>"+app_dc_y+"</td>");
			}
			out.println("</tr>");
			//End
			cnt++;
			i++;
		}//end of while
		if (cnt==0)
		{
			out.println( " <script> alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')) ; history.go(-1);</script>");
		}
		//out.println("<script>alert(\""+cnt+"\");</script>");
		boolean flag = false;
		if ( cnt < 14 || (!rs.next()) ) {
%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
<%     
		flag = true;
			} else {
%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%         
			}
%>
	
</table>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e) { //out.println(e.toString());
	e.printStackTrace();
	}
	finally
	{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

