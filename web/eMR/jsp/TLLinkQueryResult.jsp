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
<script src='../../eMR/js/TLReportSetup.js' language='javascript'></script>

</head>
<body onmousedown='CodeArrest()' onkeydown = 'lockKey()'  class='content'>
<%
	String whereClause = request.getParameter("whereclause");
	String sql="" ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if((whereClause == null || whereClause.equals("")))
	{
		
		sql="";
		String Report	= request.getParameter("Report");
			if(Report == null) Report = "";
		String Master	= request.getParameter("Master");
			if(Master == null) Master = "";
		String main_group	= request.getParameter("main_group");
			if(main_group == null) main_group = "";
		String sub_group	= request.getParameter("sub_group");
			if(sub_group == null) sub_group = "";
		String catalog_desc	= request.getParameter("catalog_desc");
			if(catalog_desc == null) catalog_desc = "";
			String level3_group	= request.getParameter("level3_group");
			if(level3_group == null) level3_group = "";
		
		//group_code	=	group_code.toUpperCase();
		//group_name	=	group_name.toUpperCase();
		//report_id	=	report_id.toUpperCase();
		//mast_table_name_reference	=	mast_table_name_reference.toUpperCase();
		if ( !(Report == null || Report.equals("")) )
		{
			sql = " where upper(REPORT_ID) like upper('"+Report+"%')";
		}
		if(!(Master == null || Master.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_TABLE_NAME_REFERENCE) like upper('"+Master+"%')";
		}
		if(!(main_group == null || main_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(GROUP_DESC) like upper('"+main_group+"%')";
		}

		if(!(sub_group == null || sub_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(SUB_GROUP_DESC) like upper('"+sub_group+"%')";
		}
		if(!(level3_group == null || level3_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(LEVEL3_DESC) like upper('"+level3_group+"%')";
		}


		if(!(catalog_desc == null || catalog_desc.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(MAST_DESC) like upper('"+catalog_desc+"%')";
		}
     
		String ord[]=new String[4];
		String concatvalues= request.getParameter("concatvalues");
		 java.util.StringTokenizer st = new StringTokenizer(concatvalues,"|");
		 int i2=0;
        while (st.hasMoreTokens())
		{
               ord[i2]=st.nextToken();i2++;
         }
		//String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";

			//out.println("sql--------"+sql);
			}
		}
	}
	else 
	{
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
	try
	{
		conn=ConnectionManager.getConnection(request);
		String CountSql=" SELECT COUNT(*) TOTAL FROM MR_REPORT_MAPPING_VW " + sql ;
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		String FinalSql=" select REPORT_DESC,REPORT_ID, MAST_TABLE_NAME_REFERENCE,GROUP_DESC,SUB_GROUP_DESC, LEVEL3_DESC,MAST_DESC,ORDER_BY_SRL_NO from MR_REPORT_MAPPING_VW " + sql ;

		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		stmt = conn.createStatement();	
		rs = stmt.executeQuery(FinalSql);
		%>
		<P>
		<table align='right'>
		<tr>
			<td>
				<%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eMR/jsp/TLLinkQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Previous</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/TLLinkQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
				%>
			</td>
		</tr>

			

		</table>
		<br><br>
		</P>
		<table border="1" width="140%" cellspacing='0' cellpadding='0'>
		<th width="20%" align='left' nowrap><fmt:message key="Common.report.label" bundle="${common_labels}"/></th>
		<th width="15%" align='left' nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></th>
		<th width="25%" align='left' nowrap><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></th>
		<th width="25%" align='left' nowrap><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></th>
		<th width="25%" align='left' nowrap><fmt:message key="eMR.level3group.label" bundle="${mr_labels}"/></th>
		<th width="25%" align='left' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width="5%" align='left' nowrap><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
		 <%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
		String classValue="";
		while ( rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String REPORT_DESC =checkForNull(rs.getString("REPORT_DESC"));
			String MAST_TABLE_NAME_REFERENCE =checkForNull(rs.getString("MAST_TABLE_NAME_REFERENCE"));
			String GROUP_DESC =checkForNull(rs.getString("GROUP_DESC"));
			String SUB_GROUP_DESC =checkForNull(rs.getString("SUB_GROUP_DESC"));
			//if(SUB_GROUP_DESC.equals("null") || SUB_GROUP_DESC==null)
             //SUB_GROUP_DESC="";
			String MAST_DESC =checkForNull(rs.getString("MAST_DESC"));
			String LEVEL3_DESC=checkForNull(rs.getString("LEVEL3_DESC"));
			float count_float =rs.getFloat("ORDER_BY_SRL_NO");
			int   ORDER_BY_SRL_NO_INT=rs.getInt("ORDER_BY_SRL_NO");
			
				
			if(GROUP_DESC.equals(""))
				GROUP_DESC="&nbsp";
			if(SUB_GROUP_DESC.equals(""))
				SUB_GROUP_DESC="&nbsp";
			if(LEVEL3_DESC.equals(""))
				LEVEL3_DESC="&nbsp";
			if(MAST_TABLE_NAME_REFERENCE.equals("OC"))
			MAST_TABLE_NAME_REFERENCE="Order Catalog";
			if(MAST_TABLE_NAME_REFERENCE.equals("RC"))
			MAST_TABLE_NAME_REFERENCE="Race Group";
			if(MAST_TABLE_NAME_REFERENCE.equals("DT"))
			MAST_TABLE_NAME_REFERENCE="Delivery Type";
			if(MAST_TABLE_NAME_REFERENCE.equals("SP"))
			MAST_TABLE_NAME_REFERENCE="Specialty";
			if(MAST_TABLE_NAME_REFERENCE.equals("BT"))
			MAST_TABLE_NAME_REFERENCE="Bed Type";
			
			if(MAST_TABLE_NAME_REFERENCE.equals("TL"))
			MAST_TABLE_NAME_REFERENCE="Tabulation List";
			if(MAST_TABLE_NAME_REFERENCE.equals("OC"))
			MAST_TABLE_NAME_REFERENCE="Order Catalog";
			if(MAST_TABLE_NAME_REFERENCE.equals("IC"))
			MAST_TABLE_NAME_REFERENCE="ICD Code";
			if(MAST_TABLE_NAME_REFERENCE.equals("BD"))
			MAST_TABLE_NAME_REFERENCE="Bed Class";
			if(MAST_TABLE_NAME_REFERENCE.equals("DP"))
			MAST_TABLE_NAME_REFERENCE="Disposal";
			if(MAST_TABLE_NAME_REFERENCE.equals("NS"))
			MAST_TABLE_NAME_REFERENCE="Name Suffix";
			/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
			if(MAST_TABLE_NAME_REFERENCE.equals("SC"))
			MAST_TABLE_NAME_REFERENCE="Staff Clinic";
			/*End ML-MMOH-CRF-1340*/
			/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
			if(MAST_TABLE_NAME_REFERENCE.equals("DA"))
			MAST_TABLE_NAME_REFERENCE="Delivery Attended By";
			/*End ML-MMOH-CRF-1341*/


			out.println("<tr>");
			
			out.println("<td class='"+classValue+"' width='20%' nowrap>"+REPORT_DESC+" &nbsp; </td>");
			out.println("<td class='"+classValue+"' width='15%' nowrap>"+MAST_TABLE_NAME_REFERENCE+" &nbsp; </td>");
			out.println("<td class='"+classValue+"' width='25%' nowrap>"+GROUP_DESC+" &nbsp; </td>");
			out.println("<td class='"+classValue+"' width='25%' nowrap>"+SUB_GROUP_DESC+" &nbsp; </td>");
			out.println("<td class='"+classValue+"' width='25%' nowrap>"+LEVEL3_DESC+" &nbsp; </td>");
			out.println("<td  class='"+classValue+"'  width='25%' nowrap>"+MAST_DESC+" &nbsp; </td>");
			String count_float_string="";
			/*Below line modified for this CRF PER-RH-206*/
			//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
			if(rs.getString("REPORT_ID").equals("MRIPCSMB") || rs.getString("REPORT_ID").equals("MRDCCSMB") || rs.getString("REPORT_ID").equals("MROPCSMB"))
			{
			   int occ=String.valueOf(count_float).indexOf('.');
			  // String  number1=String.valueOf(count_float).substring(0,occ);
			   String  number2=String.valueOf(count_float).substring((occ+1),(String.valueOf(count_float).length()));
			   if(number2.length()<2)
				   count_float_string=String.valueOf(count_float)+"0";
			   else
				   count_float_string=String.valueOf(count_float);
			  out.println("<td class='"+classValue+"' width='5%' nowrap>"+count_float_string+" &nbsp;</td>");
			}
			else{
					if(ORDER_BY_SRL_NO_INT==0){
						out.println("<td class='"+classValue+"' width='5%' nowrap>&nbsp;</td>");
					}else{
						out.println("<td class='"+classValue+"' width='5%' nowrap>"+ORDER_BY_SRL_NO_INT+" &nbsp;</td>");
					}
			}

			out.println("</tr>");
			i++;
		}
	}
	catch(Exception e)
	{ 
		//out.println("Error in result page : "+e.toString());
		e.printStackTrace();
	}
	finally   
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

