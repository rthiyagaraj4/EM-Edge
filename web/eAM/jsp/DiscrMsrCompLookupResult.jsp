<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eAM/js/DiscrMsrCompSectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<center>
<form name='CAComponentLookUpForm' id='CAComponentLookUpForm' target="">
<%
request.setCharacterEncoding("UTF-8");
	String comp_id="",comp_type="",comp_prompt="",accept_option="",dflt_value="",classValue = "";
	String max_allowed_length = "", min_num_value = "", max_num_value = "";
	StringBuffer whereClause = new StringBuffer();
	int		i						=	0,		colIndex		=	0;
	boolean				andCheck	=	false;

	Connection			con			=	null;
	
	
	ArrayList	arrWhereClauseID	=	new ArrayList();
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");

	try
	{
		
		PreparedStatement	pstmt		=	null;
		ResultSet			rs			=	null;
		
		comp_id		=	(request.getParameter("comp_id")==null)		?	""	:	request.getParameter("comp_id");
		
		comp_prompt	=	(request.getParameter("comp_prompt")==null)	?	""	:	request.getParameter("comp_prompt");
		comp_type	=	(request.getParameter("comp_type")==null)	?	""	:	request.getParameter("comp_type");

			
		if(!(comp_id.equals("")))
		{
			comp_id			=	comp_id + "%";
			arrWhereClauseID.add("comp_id");

			whereClause.append(" and upper(discr_msr_id) like upper(?) ");
			andCheck		=	true;
		}
		if(!(comp_prompt.equals("")))
		{
			comp_prompt		=	comp_prompt + "%";
			arrWhereClauseID.add("comp_prompt");

			if(andCheck)
			{
				whereClause.append(" and upper(SHORT_DESC) like upper(?) ");
			}
			else
			{
				whereClause.append(" and upper(SHORT_DESC) like upper(?) ");
				andCheck		=	true;
			}
		}
		if(!(comp_type.equals("")))
		{
			comp_type		=	comp_type + "%";
			arrWhereClauseID.add("comp_type");

			if(andCheck)
			{
				whereClause.append(" and upper(RESULT_TYPE) like upper(?) ");
			}
			else
			{
				whereClause.append(" and upper(RESULT_TYPE) like upper(?) ");
				andCheck		=	true;
			}
		}
		if(calledFrom.equals("PF"))
			whereClause.append(" and RESULT_TYPE not in ('P','A','R') ");
		if(calledFrom.equals("GD") || calledFrom.equals("MA"))
			whereClause.append(" and RESULT_TYPE not in ('P','A','F','R','X') ");
		
%>	
		<table  width='100%' border='1' cellspacing='0' cellpadding='0' >
		<tr>
			<th nowrap><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
			<!-- <th nowrap>Length</th>
			<th nowrap>Accept Option</th> 
			<th nowrap>Min Value</th>
			<th nowrap>Max Value</th>-->
			<!-- <th nowrap>Default Value</th> -->
		</tr>
	
<%
		con = ConnectionManager.getConnection(request);
		
		
		StringBuffer sql =new StringBuffer();
		sql.append(" select discr_msr_id,short_desc, decode(result_type,'C','Yes/No','D','Date','T',");
		sql.append(" 'Time','E','Date/Time','L','List Time','I','Integer Numeric','N', " );
		sql.append(" 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line','P','Embedded  Component','A','Formula','R', 'Grid Component','X', 'Matrix Component') " );
		sql.append(" comp_type, NUM_DIGITS_MAX,");
		sql.append("min_value, max_value");
		sql.append(" from am_discr_msr where EFF_STATUS = 'E' and result_type in('C','D','E','N','I','L','H','T')");
		sql.append(whereClause.toString());
		sql.append(" order by short_desc");
		
		pstmt	=	con.prepareStatement(sql.toString());
		
		if(arrWhereClauseID.size()>0)
		{
			if( arrWhereClauseID.contains("comp_id") )
			{
				pstmt.setString	(	++colIndex,		comp_id		);
			}
			if( arrWhereClauseID.contains("comp_prompt") )
			{
				pstmt.setString	(	++colIndex,		comp_prompt	);
			}
			if( arrWhereClauseID.contains("comp_type") )
			{
			
				pstmt.setString	(	++colIndex,		comp_type	);
			}
		}

		rs		=	pstmt.executeQuery();

		arrWhereClauseID.clear();
		
		while(rs.next())
		{
			i++;
			if(i%2!=0)
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";
          
			comp_id				=	rs.getString("discr_msr_id");	
			comp_prompt			=	rs.getString("short_desc");	
			comp_type			=	rs.getString("comp_type");
			max_allowed_length	=	rs.getString("NUM_DIGITS_MAX");	
			min_num_value		=	rs.getString("MIN_VALUE");	
			max_num_value		=	rs.getString("MAX_VALUE");
			if(dflt_value==null)			dflt_value			=	"&nbsp;";
			if(accept_option==null)			accept_option		=	"&nbsp;";
			if(max_allowed_length==null)	max_allowed_length	=	"&nbsp;";
			if(min_num_value==null)			min_num_value		=	"&nbsp;";
			if(max_num_value==null)			max_num_value		=	"&nbsp;";
%>
			<tr>
				<td align='left'  class='<%=classValue%>' nowrap><a href='javascript:closewjj("<%=comp_id%>","<%=java.net.URLEncoder.encode(comp_prompt)%>","<%=comp_type%>")'><%=comp_id%></a></td> 
				<td align='left'  class='<%=classValue%>' nowrap><%=comp_prompt%></td>
				<td align='left'  class='<%=classValue%>' nowrap><%=comp_type%></td>
				<!--<td align='right' class='<%=classValue%>' nowrap><%=max_allowed_length%></td>
				<td align='left'  class='<%=classValue%>' nowrap><%=accept_option%></td> 
				<td align='right' class='<%=classValue%>' nowrap><%=min_num_value%></td>
				<td align='right' class='<%=classValue%>' nowrap><%=max_num_value%></td>-->
				<!-- <td align='left'  class='<%=classValue%>' nowrap><%=dflt_value%></td> -->
				
			</tr>
<%
		} // end of while

		if(i == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");

		if(rs!=null)rs.close();
		if(pstmt!=null) pstmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("Exception in DiscreteLookUp.jsp:"+e.toString());
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</center>
</body>
</html>

