<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script> -->
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
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
		String census_date	= request.getParameter("p_census_date");
			if(census_date == null) census_date = "";
		String main_group	= request.getParameter("main_group");
			if(main_group == null) main_group = "";
		String sub_group	= request.getParameter("sub_group");
			if(sub_group == null) sub_group = "";
		String catalog_desc	= request.getParameter("bed_class_group");
			if(catalog_desc == null) catalog_desc = "";			
		
		//group_code	=	group_code.toUpperCase();
		//group_name	=	group_name.toUpperCase();
		//report_id	=	report_id.toUpperCase();
		//mast_table_name_reference	=	mast_table_name_reference.toUpperCase();
		
		if(!(census_date == null || census_date.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " to_char(A.census_year,'YYYY') = '"+census_date+"'";
		}
		if(!(main_group == null || main_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.GROUP_CODE) like upper('"+main_group+"%')";
		}

		if(!(sub_group == null || sub_group.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.SUB_GROUP_CODE) like upper('"+sub_group+"%')";
		}
		if(!(catalog_desc == null || catalog_desc.equals("")))
		{
			if(sql.equals(""))
				sql = sql + " where ";
			else
				sql = sql + " and ";

			sql = sql + " upper(A.BED_CLASS_GROUP_CODE) like upper('"+catalog_desc+"%')";
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
	    System.err.println("AnnualCensusofoperationalBedQueryResult.jsp sql===>"+sql);
		conn=ConnectionManager.getConnection(request);
		String CountSql=" SELECT COUNT(*) TOTAL FROM mr_annual_census_of_opr_bed A " + sql ;
		System.err.println("AnnualCensusofoperationalBedQueryResult.jsp CountSql===>"+CountSql); 
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(CountSql);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		String FinalSql=" select  to_char(A.census_year,'YYYY') CENSUS_YEAR,(SELECT group_desc from mr_report_grouping where group_code = A.GROUP_CODE and report_id =  'MRIPCSOBD')GROUP_CODE,(SELECT group_desc from mr_report_grouping where group_code = A.SUB_GROUP_CODE and report_id =  'MRIPCSOBD')SUB_GROUP_CODE, A.BED_CLASS_GROUP_CODE,A.COMM_BED_CNT,A.MALE_BED_CNT,A.FEMALE_BED_CNT,A.CHILD_BED_CNT,(SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE and report_id =  'MRIPCSOBD')bed_desc from mr_annual_census_of_opr_bed A " + sql ;
         
        System.err.println("AnnualCensusofoperationalBedQueryResult.jsp FinalSql===>"+FinalSql); 		 
		
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
					out.println("<A HREF='../../eMR/jsp/AnnualCensusofoperationalBedQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Previous</A>");
				if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMR/jsp/AnnualCensusofoperationalBedQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
				%>
			</td>
		</tr>

			

		</table>
		<br>
		</P>
		<table border="1" width="140%" cellspacing='0' cellpadding='0'>		
		<th width="10%">Census Year</th>
		<th width="20%">Level1 Group</th>
		<th width="20%">Level2 Group</th>
		<th width="20%">Bed Class Group</th>
		<th width="20%">Bed Class Group Description</th>
		<th width="5%">Comm Bed Cnt</th>
		<th width="5%">Male Bed Cnt</th>
		<th width="5%">Female Bed Cnt</th>
		<th width="5%">Child Bed Cnt</th>
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
			
			String CESUS_YEAR =checkForNull(rs.getString("census_year"));
			String GROUP_DESC =checkForNull(rs.getString("GROUP_CODE"));
			String SUB_GROUP_DESC =checkForNull(rs.getString("SUB_GROUP_CODE"));
			//if(SUB_GROUP_DESC.equals("null") || SUB_GROUP_DESC==null)
             //SUB_GROUP_DESC="";
			String MAST_DESC =checkForNull(rs.getString("BED_CLASS_GROUP_CODE"));
			String BED_CLASS_DESC=checkForNull(rs.getString("bed_desc"));
		//	float count_float =rs.getFloat("ORDER_BY_SRL_NO");
			int   ORDER_BY_SRL_NO_INT=rs.getInt("COMM_BED_CNT");
			int   MALE_BED_CNT=rs.getInt("MALE_BED_CNT");
			int   FEMALE_BED_CNT=rs.getInt("FEMALE_BED_CNT");
			int   CHILD_BED_CNT=rs.getInt("CHILD_BED_CNT");
			
				
			if(GROUP_DESC.equals(""))
				GROUP_DESC="&nbsp";
			if(SUB_GROUP_DESC.equals(""))
				SUB_GROUP_DESC="&nbsp";
			if(BED_CLASS_DESC.equals(""))
				BED_CLASS_DESC="&nbsp";
			
			
			
		
		//	if(MAST_TABLE_NAME_REFERENCE.equals("NS"))
		//	MAST_TABLE_NAME_REFERENCE="Name Suffix";


			out.println("<tr>");
			
		
			out.println("<td class='"+classValue+"' width='10%'> "+CESUS_YEAR+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+SUB_GROUP_DESC+" </td>");
			out.println("<td class='"+classValue+"' width='20%'> "+MAST_DESC+" </td>");
			out.println("<td  class='"+classValue+"'  width='20%'> "+BED_CLASS_DESC+"</td>");			
			
			
			if(ORDER_BY_SRL_NO_INT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+ORDER_BY_SRL_NO_INT+"</td>");
			}
			if(MALE_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+MALE_BED_CNT+"</td>");
			}
			if(FEMALE_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+FEMALE_BED_CNT+"</td>");
			}
			if(CHILD_BED_CNT==0){
					out.println("<td class='"+classValue+"' width='5%'> &nbsp;</td>");
			}else{
					out.println("<td class='"+classValue+"' width='5%'> "+CHILD_BED_CNT+"</td>");
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

