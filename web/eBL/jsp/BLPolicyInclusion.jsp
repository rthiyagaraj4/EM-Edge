<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>	
<head>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	Connection con = null ;
	
	PreparedStatement pstmt2 = null ;
	Statement stmt=null ;
	ResultSet rs2 = null ;
	ResultSet rs4 = null ;

	try
	{
	
	con	=	ConnectionManager.getConnection(request);
	//con = (Connection) session.getValue("connection" );

	//String from1 = request.getParameter( "from1" ) ;
	//String to1 = request.getParameter( "to1" ) ;
	request.setCharacterEncoding("UTF-8");
	String from2 = request.getParameter( "from2" ) ;
	String to2 = request.getParameter( "to2" ) ;
	int maxRecord2  = 0;
	int start2 = 0 ;
	int end2 = 0 ;

	//String cust_name="", policy_name="";
	String cust_code="";
	String policy_code="";
	//String whereClause="";
	String whereClause = request.getParameter("whereclause");
	
	if ((whereClause == null || whereClause.equals("")) )
	{
		cust_code=request.getParameter("cust_code");
		policy_code=request.getParameter("policy_code");
		if(cust_code==null)cust_code="";
		if(policy_code==null)policy_code="";
		cust_code=cust_code.trim();
		policy_code=policy_code.trim();
		//policy_code = java.net.URLEncoder.encode(policy_code);
	
	}
	else
	{
		//out.println()
		cust_code=request.getParameter("P_cust_code");
		policy_code=request.getParameter("P_policy_code");
		if(cust_code==null)cust_code="";
		if(policy_code==null)policy_code="";
		cust_code=cust_code.trim();
		policy_code=policy_code.trim();
		//policy_code = java.net.URLEncoder.encode(policy_code);

	}
		

	if ( from2 == null )
		start2 = 1 ;
	else
		start2 = Integer.parseInt( from2 ) ;

	if ( to2 == null )
	  	end2 = 7 ;
	else
		end2 = Integer.parseInt( to2 ) ;

	

	String query_serv_inclu="select c.blng_serv_code, /*--decode(c.copay_ind,'P','Percentage','F','Fixed','R','Rate')--*/c.copay_ind, c.copay_val, c.pre_approval_yn from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=nvl('"+cust_code+"',b.cust_code) and b.policy_type_code=c.policy_type_code and b.cust_code=c.cust_code and c.excl_incl_ind='I'";

	//out.println("query_serv_inclu :"+query_serv_inclu);

	String query_serv_inclu_count="select count(*) as total from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=nvl('"+cust_code+"',b.cust_code) and b.policy_type_code=c.policy_type_code and b.cust_code=c.cust_code and c.excl_incl_ind='I'";

	//out.println("query_serv_inclu_count :"+query_serv_inclu_count);

	stmt=con.createStatement();
	rs4=stmt.executeQuery(query_serv_inclu_count);
	rs4.next();
	maxRecord2 = rs4.getInt("total");

	if (rs4 != null)   rs4.close();
%>
<%
policy_code = java.net.URLEncoder.encode(policy_code);
cust_code = java.net.URLEncoder.encode(cust_code);
%>
<!--
<%=maxRecord2%>
<%=cust_code%>
<%=policy_code%>
-->
<P>
<!-- <table align='right'> -->
	<table cellpadding="3" align='center'>
	<tr>
	<td>
	<%
	int i2=1;
	if ( !(start2 <= 1) )
	{
		out.println("<A HREF='BLPolicyInclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from2="+(start2-7)+"&to2="+(end2-7)+"&whereclause="+URLEncoder.encode(query_serv_inclu)+"'"+" text-decoration='none'>Previous</A>");
	}

	if ( !( (start2+7) > maxRecord2 ) )
	{
		out.println("<A HREF='BLPolicyInclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from2="+(start2+7)+"&to2="+(end2+7)+"&whereclause="+URLEncoder.encode(query_serv_inclu)+"'"+" text-decoration='none'>Next</A>");
	}
	%>	
	</td>
	</tr>
	</table>
	<br><br>
	</P>

	<table border='1' cellpadding='3' cellspacing='0'  width='100%'>
<!--
	<th>Service</th>
	<th>Co-Pay Indicator</th>
	<th>Co-Pay Value</th>
	<th>Pre.App Yn</th>
-->
	<td class="COLUMNHEADERCENTER"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADERCENTER"><fmt:message key="eBL.COPAY_INDICATOR.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADERCENTER"><fmt:message key="eBL.COPAY_VALUE.label" bundle="${bl_labels}"/></td>
	<td class="COLUMNHEADERCENTER"><fmt:message key="eBL.PRE_APP_YN.label" bundle="${bl_labels}"/></td>
	<%
	try
	{
		pstmt2 = con.prepareStatement(query_serv_inclu);
		rs2 = pstmt2.executeQuery() ;
		if ( start2 != 1 )
		for( int j2=1; j2<start2; i2++,j2++ )
		{
		  rs2.next() ;
		}
		 String classValue = "" ;
		while ( rs2.next() && i2<=end2 )
		{
			if ( i2 % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
		
			String blng_serv_code1=rs2.getString("blng_serv_code");
			String copay_ind=rs2.getString("copay_ind");
			String copay_val=rs2.getString("copay_val");
			String pre_approval_yn=rs2.getString("pre_approval_yn");
			if(pre_approval_yn==null || pre_approval_yn.equals("null"))pre_approval_yn="&nbsp;";
			if(copay_ind.equals("P")) copay_ind="Percentage";
			else if(copay_ind.equals("F")) copay_ind="Fixed";
			else if(copay_ind.equals("R")) copay_ind="Rate";
			if(copay_val==null || copay_val.equals("null"))copay_val="0.00";
			CurrencyFormat cf1 = new CurrencyFormat();
			copay_val = cf1.formatCurrency(copay_val, 2);

			out.println("<tr>");
			out.println("<td  class='" + classValue + "' align='center'>"+blng_serv_code1+"</td>");
			out.println("<td  class='" + classValue + "' align='left'>"+copay_ind+"</td>");
			out.println("<td  class='" + classValue + "' align='right'>"+copay_val+"</td>");
			if(pre_approval_yn.equals("Y"))
			{
				out.println("<td  class='" + classValue + "' align='center'> <img src='../../eCommon/images/enabled.gif'></img> </td>");
			}
			else
			{
				out.println("<td  class='" + classValue + "' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			}
			out.println("</tr>");
			i2++;
		}
		if (rs2 != null) rs2.close();
		pstmt2.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in "+e);
		e.printStackTrace();
	}
}
catch(Exception ee)
{
	//out.println("Exception in main try"+ee);
	ee.printStackTrace();
}
finally
{
	if(stmt != null)stmt.close();
	if(pstmt2  != null)pstmt2.close();
	ConnectionManager.returnConnection(con, request);
}


%>
</table>
</body>
</html>


