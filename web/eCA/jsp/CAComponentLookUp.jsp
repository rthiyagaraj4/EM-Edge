<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @10-12-2008> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown="lockKey()">
<center>
<form name='CAComponentLookUpForm' id='CAComponentLookUpForm' target="">
<%
	String comp_id="",comp_type="",comp_prompt="",accept_option="",dflt_value="",classValue = "";
	String numericyn="",max_allowed_length = "", min_num_value = "", max_num_value = "";
	
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

			whereClause.append(" and upper(DISCR_MSR_ID) like upper(?) ");
			andCheck		=	true;
		}
		if(!(comp_prompt.equals("")))
		{
			comp_prompt		=	comp_prompt + "%";
			arrWhereClauseID.add("comp_prompt");
			if(andCheck)
			{
				whereClause.append(" and upper(short_desc) like upper(?) ");
			}
			else
			{
				whereClause.append(" and upper(short_desc) like upper(?) ");
				andCheck		=	true;
			}
		}
		if(!(comp_type.equals("")))
		{
			comp_type		=	comp_type + "%";
			arrWhereClauseID.add("comp_type");
			
			if(andCheck)
			{
				whereClause.append(" and upper(result_type) like upper(?) ");
			}
			else
			{
				whereClause.append(" and upper(result_type) like upper(?) ");
				andCheck		=	true;
			}
		}
		if(calledFrom.equals("PF"))
			whereClause.append(" and result_type not in ('P','A','R') ");
		if(calledFrom.equals("GD") || calledFrom.equals("MA"))
			whereClause.append(" and result_type not in ('P','A','F','R','X') ");
		
%>	
		<table  class='grid' width='100%' border='1' cellspacing='0' cellpadding='3' >
		<tr>
			<th  class= 'columnheadercenter'><fmt:message key="Common.ComponentID.label" bundle="${common_labels}"/></th>
			<th  class= 'columnheadercenter'><fmt:message key="Common.ComponentPrompt.label" bundle="${common_labels}"/></th>
			<th  class= 'columnheadercenter'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></th>
		</tr>
<%
		con = ConnectionManager.getConnection(request);
		
		
		StringBuffer sql =new StringBuffer();
		sql.append(" select discr_msr_id comp_id, short_desc , decode(result_type,'C','Yes/No','D','Date','T',");
		sql.append(" 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', " );
		sql.append(" 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line','P','Embedded Component','A','Formula','R', 'Grid Component','X', 'Matrix Component','M','Multi-List Component') " );
		sql.append(" comp_type,NUMERIC_PREFIX_YN, num_digits_max max_allowed_length , min_value min_num_value, max_value max_num_value ");
		sql.append(" from am_discr_msr where tm_appl_yn ='Y' ");
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
		
		while(rs.next())
		{
			i++;
			if(i%2!=0)
				classValue = "gridData";
			else
				classValue = "gridData";

			comp_id				=	rs.getString("comp_id");	
			comp_type			=	rs.getString("comp_type");	
			numericyn		    =	rs.getString("NUMERIC_PREFIX_YN");	
			comp_prompt			=	rs.getString("short_desc");	
			
			max_allowed_length	=	rs.getString("max_allowed_length");	
			min_num_value		=	rs.getString("min_num_value");	
			max_num_value		=	rs.getString("max_num_value");	

			if(dflt_value==null)			dflt_value			=	"&nbsp;";
			if(accept_option==null)			accept_option		=	"&nbsp;";
			if(max_allowed_length==null)	max_allowed_length	=	"&nbsp;";
			if(min_num_value==null)			min_num_value		=	"&nbsp;";
			if(max_num_value==null)			max_num_value		=	"&nbsp;";
%>
			<tr>
				<td align='left'  class='<%=classValue%>' nowrap><a class='gridLink'  href ='javascript:closewjj("<%=comp_id%>","<%=java.net.URLEncoder.encode(comp_prompt)%>","<%=comp_type%>","<%=numericyn%>")'><%=comp_id%></a></td> 
				<td align='left'  class='<%=classValue%>' nowrap><%=comp_prompt%></td>
				<td align='left'  class='<%=classValue%>' nowrap><%=comp_type%></td>
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
		//out.println("Exception in CAComponentLookUp.jsp:"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		arrWhereClauseID.clear();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</center>
</body>
</html>

