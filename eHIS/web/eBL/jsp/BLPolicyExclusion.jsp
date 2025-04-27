<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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
	Connection con = null;
	PreparedStatement pstmt1 = null;
	Statement stmt=null ;
	ResultSet rs1 = null;
	ResultSet rs3=null ;
	
		
	try
	{
	//con = (Connection) session.getValue("connection" );
	con	=	ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");
	String from1 = request.getParameter( "from1" ) ;
	String to1 = request.getParameter( "to1" ) ;

	//String from2 = request.getParameter( "from2" ) ;
	//String to2 = request.getParameter( "to2" ) ;
	int maxRecord1 /*,maxRecord2  = 0*/ ;
	int start1 /*,start2 = 0*/ ;
	int end1 /*,end2 = 0*/ ;

	//unused variable, commented on 09/06/05
	//String  cust_name="", policy_name="";

	String cust_code="";
	String policy_code="";
	
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

	if ( from1 == null )
		start1 = 1 ;
	else
		start1 = Integer.parseInt( from1 ) ;

	if ( to1 == null )
	  	end1 = 9 ;
	else
		end1 = Integer.parseInt( to1 ) ;

	/*String cust_name="", policy_name="";
	String cust_code=request.getParameter("cust_code");
	String policy_code=request.getParameter("policy_code");
	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	cust_code=cust_code.trim();
	policy_code=policy_code.trim();
	*/

	String query_serv_exclu = "Select c.blng_serv_code from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=c.cust_code and b.policy_type_code=c.policy_type_code and b.cust_code=nvl('"+cust_code+"',b.cust_code) and c.excl_incl_ind='E'";

	//out.println("query_serv_exclu :"+query_serv_exclu);
	
	String query_serv_exclu_count="select count(*) as total from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=c.cust_code and b.policy_type_code=c.policy_type_code and b.cust_code=nvl('"+cust_code+"',b.cust_code) and c.excl_incl_ind='E'";

	//out.println("query_serv_exclu_count :"+query_serv_exclu_count);

	stmt=con.createStatement();
	rs3=stmt.executeQuery(query_serv_exclu_count);
	rs3.next();
	maxRecord1 = rs3.getInt("total");
	
	if (rs3 != null) rs3.close();
	stmt.close();

	%>
	<%
	policy_code = java.net.URLEncoder.encode(policy_code);
	cust_code = java.net.URLEncoder.encode(cust_code);
	%>
	<P>
<!-- 	<table align='right'> -->
	<table align='center' cellpadding='3'>

	<tr>
	<td>
	<%
	int i1=1;
	if ( !(start1 <= 1) )
		out.println("<A HREF='BLPolicyExclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from1="+(start1-9)+"&to1="+(end1-9)+"&whereclause="+URLEncoder.encode(query_serv_exclu)+"'"+" text-decoration='none'>Previous</A>");

	if ( !( (start1+9) > maxRecord1 ) )
		out.println("<A HREF='BLPolicyExclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from1="+(start1+9)+"&to1="+(end1+9)+"&whereclause="+URLEncoder.encode(query_serv_exclu)+"'"+" text-decoration='none'>Next</A>");
	%>
	</td>
	</tr>
	</table>
	<br><br>
	</P>
	<table border='1' cellpadding='3' cellspacing='0'   width='100%'>
<!--	<th>Services</th> -->
		<td class="COLUMNHEADERCENTER"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<%
		try
		{
			pstmt1 = con.prepareStatement(query_serv_exclu);
			rs1 = pstmt1.executeQuery() ;
			if ( start1 != 1 )
			for( int j1=1; j1<start1; i1++,j1++ )
			{
			  rs1.next() ;
			}
			 String classValue = "" ;
			while ( rs1.next() && i1<=end1 )
			{
				if ( i1 % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				String blng_serv_code=rs1.getString("blng_serv_code");
				//out.println("<tr><td class='"+classValue+"'>" );
				out.println("<tr>");
				out.println("<td class='" + classValue + "' align='center'>"+blng_serv_code+"</td>");
				out.println("</tr>");
				i1++;
			}
			if (rs1 != null)   rs1.close();
			pstmt1.close();
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
		if(pstmt1 != null)pstmt1.close();
		ConnectionManager.returnConnection(con, request);
	}
	%>
</table>

</body>
</html>

