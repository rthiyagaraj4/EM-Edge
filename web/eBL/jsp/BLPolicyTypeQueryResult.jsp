<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200904            72977         NMC-JD-CRF-0059       Mohana Priya K
2            V201022            74289         NMC-JD-CRF-0059       Mohana Priya K
3  			 V211020											Mohanapriya K
-->

<%@ page import ="java.util.*,java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<HTML>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
	Connection conn  = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset=null;
	ResultSet rs = null;
	boolean siteSpec=false;
	String sitespecval="N";
	try{
		conn=ConnectionManager.getConnection(request);
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_POLICY_TYPES");
		if(siteSpec){
			sitespecval="Y";
		}else{
			sitespecval="N";
		}
		}catch(Exception e)
		{
		out.println("Exception in sitespec is "+e);
		}
		finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
				//ConnectionManager.returnConnection(conn); //V211020
			}catch(Exception e)
			{
				//out.println("Exception is "+e);
				e.printStackTrace();
			}
		}

	try
	{   
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";
		String from = checkForNull(request.getParameter( "from" ),"1") ;
		String to = checkForNull(request.getParameter( "to" ),"14" ) ;
		String sql = "";
   	 	String facility= (String) session.getValue( "facility_id" );
		String policy_type_code= request.getParameter("policy_type_code")==null?"":request.getParameter( "policy_type_code" );
		String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
		String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" );
		String gosi_yn = request.getParameter("gosipolicy")==null?"N":request.getParameter( "gosipolicy");
		if(request.getParameter("gosipolicy")==null || request.getParameter("gosipolicy")=="N"){
		   gosi_yn="N";
		}else{
			gosi_yn="Y";
		} 

		if ( (whereClause == null || whereClause.equals("")) )
		{
			int cnt=0;
		if ( !(policy_type_code == null || policy_type_code.equals("")) ){					
			sql = sql + "where  upper(policy_type_code ) like upper('"+policy_type_code +"%') ";
			cnt++;
		}

		if ( !(short_desc == null || short_desc.equals("")) ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(short_desc) like upper('"+short_desc+"%') ";
			else 
			{
				sql = " where upper(short_desc) like upper('"+short_desc+"%') ";
				cnt++;
			}
		}

		if ( !(long_desc == null || long_desc.equals("")) ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(long_desc) like upper('"+long_desc+"%')";
			else 
			{
				sql = " where upper(long_desc) like upper('"+long_desc+"%') ";
				cnt++;
			}
		}
		 if ( !(facility == null || facility.equals("")) ){   //V201022
			 if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(OPERATING_FACILITY_ID) like upper('"+facility+"%')";
			else 
				{
				  sql = " where upper(OPERATING_FACILITY_ID) like upper('"+facility+"%') ";
				  cnt++;
				}
        }//V201022
		if("Y".equals(sitespecval)){
			if ( !(gosi_yn == null || gosi_yn.equals("")) ){			
				if( gosi_yn.equals("Y") ){
				if (sql.length() > 0)  sql =sql+"  and ";
				if(cnt>0)
					sql = sql+"  nvl(GOSI_YN,'N')='Y'";
				else{
					sql=sql+ " where  nvl(GOSI_YN,'N')='Y'";
					cnt=1;
				}
		}
	
		if ( gosi_yn.equals("N") ){
			if (sql.length() > 0)  sql =sql+"  and ";
				if(cnt>0)
					sql = sql+"  nvl(GOSI_YN,'Y')='N'";
				else
					sql=sql+ "where  nvl(GOSI_YN,'Y')='N'";
			}
		}
		}

		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}
		} //end of where clause IF
		else{
				sql = whereClause;
			}
		}

		int start = 0;
		int end = 0;
		int i=1;
		start = Integer.parseInt( from );
		end = Integer.parseInt( to );

		//conn  =  ConnectionManager.getConnection(request); //V211020

	int maxRecord = 0;
	try{
			String strsql= "SELECT POLICY_TYPE_CODE,LONG_DESC,SHORT_DESC FROM BL_INS_POLICY_TYPES "+sql;
			String strsql1= "SELECT POLICY_TYPE_CODE,LONG_DESC,SHORT_DESC FROM BL_INS_POLICY_TYPES "+sql;			
			
			stmt = conn.prepareStatement(strsql);
			rs = stmt.executeQuery();
			int total=0;
			while(rs.next())
			{
				total++;
			}
			
			maxRecord = total;
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}
			stmt1=conn.prepareStatement(strsql1);
			rset = stmt1.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
			//out.println("sdfsadfs "+e);
		}
%>
<P>
<form name="QueryResult" id="QueryResult">
<table cellspacing=0 cellpadding=3  align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eBL/jsp/BLPolicyTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eBL/jsp/BLPolicyTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table width="99%" cellspacing="0" cellpadding="3" align="center" style="border: 1px solid black; border-collapse: collapse;">
    <tr>
        <td class='COLUMNHEADERCENTER' align="center" nowrap> 
            <fmt:message key="eBL.POLICY_TYPE_CODE.label" bundle="${bl_labels}"/>
        </td>
        <td class='COLUMNHEADERCENTER' align="center" nowrap>
            <fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
        </td>
        <td class='COLUMNHEADERCENTER' align="center" nowrap>
            <fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
        </td>
    </tr>

    <%
        if (start != 1)
            for (int j = 1; j < start; i++, j++)
                rset.next();

        String classValue = " ";
        while (rset.next() && i <= end) {
            classValue = (i % 2 == 0) ? "gridData" : "gridData"; 

            // Use a very light gray color for the row separator
            out.println("<tr style='border-bottom: 1px solid #e0e0e0;'>"); // Lighter gray
            out.println("<td align='left' class='" + classValue + "'>");
            
            policy_type_code = rset.getString(1);
            long_desc = rset.getString(2);
            short_desc = rset.getString(3);
            String mode = "modify"; 

            out.println("<a href='../../eBL/jsp/BLPolicyTypesAddModify.jsp?mode=" + mode + "&policy_type_code=" + policy_type_code + "' target='f_query_add_modify'>");
            out.println(policy_type_code + "</a></td>");
            out.println("<td class='" + classValue + "'>" + long_desc + "</td>");  
            out.println("<td class='" + classValue + "'>" + short_desc + "</td>");		 
            out.println("</tr>");
            i++;
        }
    %>
</table>
</center>
<br><center>
<%
	}
	catch(Exception e)
	{
		//out.println("here "+e);
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

