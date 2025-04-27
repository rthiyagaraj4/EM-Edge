<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
</head>
<body onmousedown='CodeArrest()' onkeydown = 'lockKey()'  class='content'>
<%
	String whereClause = request.getParameter("whereclause");
	String sql="" ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if((whereClause == null || whereClause.equals(""))){
		sql="";
		String group_code	= request.getParameter("group_code");
			if(group_code == null) group_code = "";
		String group_name	= request.getParameter("group_name");
			if(group_name == null) group_name = "";
		String report_id	= request.getParameter("report_id");
			if(report_id == null) report_id = "";
		String Group_type	= request.getParameter("Group_type");
			if(Group_type == null) Group_type = "";
		String Main_Group	= request.getParameter("Main_Group");
			if(Main_Group == null) Main_Group = "";

		String mast_table_name_reference	= request.getParameter("mast_table_name_reference");
		mast_table_name_reference	= mast_table_name_reference.trim();
		if(mast_table_name_reference == null) mast_table_name_reference = "";
		group_code	=	group_code.toUpperCase();
		group_name	=	group_name.toUpperCase();
		report_id	=	report_id.toUpperCase();
		mast_table_name_reference	=	mast_table_name_reference.toUpperCase();
		if ( !(group_code == null || group_code.equals("")) ){
			sql = " where upper(group_code) like upper('"+group_code+"%')";
		}
		if(!(group_name == null || group_name.equals(""))){
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(group_desc) like upper('"+group_name+"%')";
		}
		if(!(report_id == null || report_id.equals(""))){
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(report_id) like upper('"+report_id+"%')";
		}

		if(!(Group_type == null || Group_type.equals(""))){
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(GROUP_CATEGORY) like upper('"+Group_type+"%')";
		}

		if(!(Main_Group == null || Main_Group.equals(""))){
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(SUBGROUP_CODE) like upper('"+Main_Group+"%')";
		}

		if(!(mast_table_name_reference == null || mast_table_name_reference.equals(""))){
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(mast_table_name_reference) like upper('"+mast_table_name_reference+"%')";
		}

		String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) ){
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}

		}
	}else {
		sql = whereClause;
	}
	int start = 0;
	int end = 0;
	int i=1;
	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);
	if (to == null)
	  	end = 14;
	else
		end = Integer.parseInt(to);
		Connection conn =null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;
	try{
		
		conn=ConnectionManager.getConnection(request);
		String CountSql=" SELECT COUNT(*)TOTAL FROM MR_REPORT_GROUPING " + sql ;
	
		stmt = conn.createStatement();
		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
	
		if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}else{
		//String FinalSql=" select GROUP_CODE, GROUP_DESC,GROUP_CATEGORY,SUBGROUP_CODE, REPORT_ID, MAST_TABLE_NAME_REFERENCE,ORDER_BY_SRL_NO from MR_REPORT_GROUPING " + sql ;
		String FinalSql=" select A.GROUP_CODE, A.GROUP_DESC,A.GROUP_CATEGORY,A.SUBGROUP_CODE,PRINT_DESC_YN,(CASE WHEN A.SUBGROUP_CODE IS NOT NULL THEN (SELECT GROUP_DESC FROM MR_REPORT_GROUPING WHERE GROUP_CODE = A.SUBGROUP_CODE AND  REPORT_ID = A.REPORT_ID AND MAST_TABLE_NAME_REFERENCE = A.MAST_TABLE_NAME_REFERENCE ) END ) MAIN_DESC, (select REPORT_DESC from sm_report where report_id=a.report_id) REPORT_ID,a.report_id  report_id1, A.MAST_TABLE_NAME_REFERENCE, A.ORDER_BY_SRL_NO from MR_REPORT_GROUPING A " + sql ;

		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		stmt = conn.createStatement();
//		out.println("FinalSql--------"+FinalSql);
		rs = stmt.executeQuery(FinalSql);
		%>
		<table align='right'>
		<tr>
			<td>
				<%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eMR/jsp/ReportGroupSetupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/ReportGroupSetupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
			</td>
		</tr>
		</table>
		<br><br>
		<table border="1" width="130%" cellspacing='0' cellpadding='0'>
		<th nowrap width='10%' align='left'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></th>
		<th nowrap width='50%' align='left'><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></th>
		<th nowrap align='left'><fmt:message key="Common.report.label" bundle="${common_labels}"/></th>
		<th nowrap align='left'><fmt:message key="eMR.GroupCategory.label" bundle="${mr_labels}"/></th>
		<th nowrap align='left'><fmt:message key="eMR.MainGroup.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th nowrap align='left'><fmt:message key="eMR.MainGroup.label" bundle="${mr_labels}"/></th>
		<th nowrap align='left'><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></th>
		<th nowrap align='left'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
		<th nowrap align='left'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		}
		String classValue="";
		while ( rs.next() && i<=end ){
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String report_code			= checkForNull(rs.getString("report_id1"));
			String grp_code				= checkForNull(rs.getString("GROUP_CODE"));
			String grp_name				= checkForNull(rs.getString("GROUP_DESC"));
			String rep_id						= checkForNull(rs.getString("REPORT_ID"));
			String PRINT_DESC_YN = checkForNull(rs.getString("PRINT_DESC_YN"));
			String table_ref					= checkForNull(rs.getString("MAST_TABLE_NAME_REFERENCE"));
			String order_by_srl_no		= checkForNull(rs.getString("ORDER_BY_SRL_NO"));
			String Group_Category		= checkForNull(rs.getString("GROUP_CATEGORY"));
			String Sub_Group				= checkForNull(rs.getString("SUBGROUP_CODE"));
			String main_desc				= checkForNull(rs.getString("MAIN_DESC"));

			//if(!Sub_Group.equals("")||Sub_Group!=null) Sub_Group = grp_name;
			//else if(Sub_Group.equals("")||Sub_Group==null) Sub_Group = "&nbsp;";

			if(Group_Category.equals("M")) Group_Category = "Level1 Group";
			else if(Group_Category.equals("S")) Group_Category = "Level2 Group";
			else if(Group_Category.equals("G")) Group_Category = "Level3 Group";

			if(table_ref.equals("DT"))
			table_ref="Delivery Type";
			if(table_ref.equals("TL"))
			table_ref="Tabulation List";
			if(table_ref.equals("HC"))
			table_ref="HealthCare Setting Type";
			if(table_ref.equals("RC"))
			table_ref="Race Group";
			if(table_ref.equals("SP"))
			table_ref="Specialty";
			if(table_ref.equals("OC"))
			table_ref="Order Catalog";
			if(table_ref.equals("BT"))
			table_ref="Bed Type";
			if(table_ref.equals("IC"))
			table_ref="ICD Code";
			if(table_ref.equals("BD"))
			table_ref="Bed Class";
			if(table_ref.equals("DP"))
			table_ref="Disposal";
			if(table_ref.equals("NS"))
			table_ref="Name Suffix";
			if(table_ref.equals("NU"))
			table_ref="Nursing Unit";
			if(table_ref.equals("CL"))
			table_ref="Clinic";
			if(table_ref.equals("CP"))
			table_ref="Clinic/Procedure Unit";
			//Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
			if(table_ref.equals("SC"))
			table_ref="Staff Clinic";
			//Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
			if(table_ref.equals("DA"))
			table_ref="Delivery Attended By";

			out.println("<tr>");
			out.println("<td width='10%' class='"+classValue+"'> ");
			out.println("<a href='../../eMR/jsp/addModifyReportGroupSetup.jsp?GROUP_CODE="+grp_code+"&REPORT_ID="+report_code+"&MAST_TABLE_NAME_REFERENCE="+table_ref+"&mode=modify'>");
			out.println(grp_code+"</a></td>");
			out.println("<td class='"+classValue+"' width='60%'>&nbsp;"+grp_name+" </td>");
			out.println("<td nowrap class='"+classValue+"'>&nbsp;" +rep_id+" </td>");
			out.println("<td class='"+classValue+"'>&nbsp;"+Group_Category+" </td>");
			out.println("<td class='"+classValue+"'>&nbsp;"+Sub_Group+" </td>");
			out.println("<td class='"+classValue+"' nowrap>&nbsp;"+main_desc+" </td>");
			out.println("<td class='"+classValue+"' nowrap>&nbsp;"+table_ref+"</td>");
			out.println("<td class='"+classValue+"'>&nbsp;"+order_by_srl_no+"</td>");

			if ( PRINT_DESC_YN.equals("Y") )
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
			else
				out.println("<td class='"+classValue+"' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");

			out.println("</tr>");
			i++;
		}
	}
}catch(Exception e){ 
	e.printStackTrace();
	}finally   {
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

<%!	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

