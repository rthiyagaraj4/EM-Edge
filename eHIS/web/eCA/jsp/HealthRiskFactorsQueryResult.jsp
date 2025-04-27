<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String risk_factor_id  = request.getParameter("risk_factor_id");
    String risk_fact_desc = request.getParameter("risk_fact_desc");
	String risk_fact_code = request.getParameter("risk_fact_code");
	if(!(risk_fact_code == null || risk_fact_code.equals(""))){
		risk_fact_code = risk_fact_code.trim();
	}
	if(risk_fact_desc == null)
	{
		risk_fact_desc = "";
	}
	else
	{
		risk_fact_desc = risk_fact_desc.toUpperCase();
	}
   
    String eff_status= request.getParameter("eff_status");
	 
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(risk_factor_id == null || risk_factor_id.equals("")) )
        {
			sql.append(" and upper(FT.RISK_FACTOR_TYPE ) like upper('"+risk_factor_id +"%')");
        }

        if ( !(risk_fact_desc == null || risk_fact_desc.equals("")) )
        {
				sql.append(" and upper(FT.RISK_FACTOR_DESC) like '"+risk_fact_desc+"%'");
        }  
		 if ( !(risk_fact_code == null || risk_fact_code.equals("")))
	    {			
			   sql.append(" and FR.RISK_FACTOR_IND='"+risk_fact_code+"'");			
        }
		if ( !(eff_status == null || eff_status.equals("")) )
		{
			 if( eff_status.equals("E") )
				   sql.append(" and eff_status='E'");
			 
			 if ( eff_status.equals("D") )
				   sql.append(" and eff_status='D'");
		}
    
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
			}
		}

    }else
		 sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

Connection conn  = null;
PreparedStatement pstmt;
ResultSet rs = null;

int maxRecord = 0;

String strsql1="SELECT FT.RISK_FACTOR_TYPE,FT.RISK_FACTOR_DESC,FR.RISK_FACTOR_IND,FT.EFF_STATUS FROM CA_RISK_FACTOR_TYPE FT,CA_RISK_FACTOR FR WHERE FT.RISK_FACTOR_TYPE=FR.RISK_FACTOR_TYPE "+sql.toString();
System.out.println("	HealthRiskFactorsQueryResult.jsp======strsql1===>"+strsql1);
try
{
	conn 	= ConnectionManager.getConnection(request);
	pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs		= pstmt.executeQuery();
	
	while(rs.next())
	{
		maxRecord++;
	}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='white' width='100%'></td> 
			<td  width='25%' nowrap>
			<%
				String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
				int pageCnt = Integer.parseInt(MstQryPageCnt);
			if ( !(start <= 1) )
				out.println("<A class='gridLink' HREF='../../eCA/jsp/HealthRiskFactorsQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/HealthRiskFactorsQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>

	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
		<th class='columnheadercenter' width='25%' align="left"><fmt:message key="eCA.RiskFactorId.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='65%' align="left"><fmt:message key="eCA.RiskFactorDescription.label" bundle="${ca_labels}"/></th>
		<th class='columnheadercenter' width='10%' align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<%
	rs.beforeFirst();

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;
	String classValue= " ";
	while ( rs.next() && i<=end  ){
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr>");
		out.println("<td class='gridData'>");
			String risk_factor_id_	=(rs.getString("RISK_FACTOR_TYPE")==null)?"":rs.getString("RISK_FACTOR_TYPE");
			String risk_fact_desc_	 =(rs.getString("RISK_FACTOR_DESC")==null)?"":rs.getString("RISK_FACTOR_DESC");		
			String eff_status_		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
	  
		out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyHealthRiskFactors.jsp?mode=update&risk_factor_id="+ URLEncoder.encode(risk_factor_id_)+"' target='f_query_add_mod' >");
		out.println(risk_factor_id_ + "</a></td>");
		out.println("<td class='gridData'>");
		out.println(risk_fact_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");	
		if ( eff_status_.equalsIgnoreCase("E") )    
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
		out.println("</tr>");
		i++;
	} 
	%>
	</table>
	<br>
	<center>
	<%
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

}catch(Exception e){
	//out.println("Exception from NoteGroupQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();	
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}

%>
	</center>
</BODY>
</HTML>

