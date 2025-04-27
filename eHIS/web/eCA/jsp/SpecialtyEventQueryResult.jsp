<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="JavaScript" src ="../../eCA/js/SpecialtyEvent.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%@page import="java.sql.*,java.io.*, webbeans.eCommon.ConnectionManager"%>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement  pstmt = null;
	ResultSet rs = null;
	 ResultSet rs1= null;
	String whereClause = "";	 
	String code = "";
	String description = "";
	String agegroupDes = "";
	String agegroupCode = "";
	String orderSequence = "";
	String from = request.getParameter( "from" ) ;
	String mode = "modify";
    String to = request.getParameter( "to" ) ;
	String definitionType = "";
	String classValue = "";
	int rowCount = 0;
	int i =0 ;
	int j = 0;
	String enabled = "";
	StringBuffer sql =new StringBuffer();
	int start = 0;
	int end = 0;
	//String locationCode="";
	StringBuffer sqlQuery =new StringBuffer();
	StringBuffer sqlCount =new StringBuffer();
	int maxRecord =0;
	int count = 0;
	
	try
	{	
		
		con = ConnectionManager.getConnection(request);
		whereClause = request.getParameter("whereClause")==null  ? "" : request.getParameter("whereClause");	
		if(whereClause == null || whereClause.equals(""))
		{
			code = request.getParameter("code");

			if(code != null || !(code.equals("")))
			{
				code = code.trim().toUpperCase();
				if(code.equals("") || code==null) code = "%";
				else
				 code = code + "%";
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(SPLTY_EVENT_CODE)  like upper( '"+code+"') ");
				count ++;
			}
			
			description = request.getParameter("description");
			if(description != null || !(description.equals("")))
			{
				
				description = description.trim().toUpperCase();
			   if(count > 0)
				{
					sql.append(" and upper(SPLTY_EVENT_DESC)  like  upper('"+description+"%') ");
				}
				else
				{
					sql.append(" where upper(SPLTY_EVENT_DESC)  like  upper('"+description+"%' )");
					count++;
				}
			}
			orderSequence = request.getParameter("orderSequence");
			if(orderSequence != null || !(orderSequence.equals("")))
			{
				orderSequence = orderSequence.trim().toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(ORDER_SEQ_NO)  like upper( '"+orderSequence+"%') ");
				}
				else
				{
					sql.append(" where upper(ORDER_SEQ_NO)  like upper( '"+orderSequence+"%') ");
					count++;
				}
				
			}
			definitionType = request.getParameter("definitionType");
			if(definitionType != null || !(definitionType.equals("")))
			{
				definitionType = definitionType.trim().toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(SYS_IND)  like upper( '"+definitionType+"%' )");
				}
				else
				{
					sql.append(" where upper(SYS_IND)  like  upper('"+definitionType+"%') ");
					count ++;
				}
				
			}
			enabled = request.getParameter("enabled");
			if(enabled != null || !(enabled.equals("")))
			{
				enabled = enabled.trim().toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(EFF_STATUS)  like upper( '"+enabled+"%' )");
				}
				else
				{
					sql.append(" where upper(EFF_STATUS)  like  upper('"+enabled+"%' )");
					count ++;
				}
				
			}
			
			
			String ord[] = request.getParameterValues("orderbycolumns");
			if ( !(ord == null || ord .equals("")) )
			{
				sql.append(" order by ");
				for (i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
				}
			}

		}
		else
		{
			sql.append(whereClause);
		}
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if ( to == null )
			end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;

		sqlCount.append("select count(*) total from CA_SPLTY_EVENT  ");
		sqlCount.append(sql.toString());

		ps = con.prepareStatement(sqlCount.toString());
		rs = ps.executeQuery();
		while(rs.next())
		{
			maxRecord = rs.getInt("total");
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		sqlQuery.append("select * from CA_SPLTY_EVENT");
		sqlQuery.append(sql.toString());
		ps = con.prepareStatement(sqlQuery.toString());
		rs = ps.executeQuery();
%>
<br>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td>
<td align=right>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eCA/jsp/SpecialtyEventQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("<A HREF='../../eCA/jsp/SpecialtyEventQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
	</td>
</tr>
</table>
<table width="100%" class='grid' >
	<tr>
		<td class='columnheadercenter' width='15%'>
			<fmt:message key="Common.code.label" bundle="${common_labels}"/>
		</td>
		<td class='columnheadercenter'  >
			<fmt:message key="Common.description.label" bundle="${common_labels}"/>
		</td>
	 <td class='COLUMNHEADERCENTER'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'  width='12%' >
			<fmt:message key="eCA.OrderSequence.label" bundle="${ca_labels}"/>
		</td>
		<td class='columnheadercenter'  width='15%'>
			<fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/>
		</td>
		

<!--<td class='columnheadercenter'  width='12%'>
			<fmt:message key="eCA.AutoClosePeriod.label" bundle="${ca_labels}"/>
		</td>-->	
		<td class='columnheadercenter' width='10%' >
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
		</td>
	</tr>
			
	<tr>
<%
	 for(j=1,i=1; j<start; i++,j++ )
      rs.next() ;
      while ( rs.next() && i<= end  ) 
		{
			classValue =((rowCount & 1) == 0) ? "gridData" : "gridData";
		out.println("<td class='"+classValue+"'> <a href='../../eCA/jsp/SpecialtyEventAddModify.jsp?code_vlue="+java.net.URLDecoder.decode(rs.getString("SPLTY_EVENT_CODE"))+ "&mode="+mode+"' class='gridLink'>"+rs.getString("SPLTY_EVENT_CODE")+"</a></td>");
		%>
<td class='<%=classValue%>'><%=rs.getString("SPLTY_EVENT_DESC")%></td>
  <%
			  agegroupCode=rs.getString("AGE_GROUP_CODE");
				if(agegroupCode==null || agegroupCode.equals("null"))agegroupCode="&nbsp;";
			 try{
			 
			 String sql1 = "Select   SHORT_DESC  from  AM_AGE_GROUP where AGE_GROUP_CODE=?";
			  pstmt = con.prepareStatement(sql1);
			 pstmt.setString(1,agegroupCode);
		    rs1 = pstmt.executeQuery();
			 if(rs1.next())
				 agegroupDes=rs1.getString("SHORT_DESC");
			 else
				agegroupDes="&nbsp;";
			 if(rs1 != null) rs1.close();
		     if(pstmt != null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
%>
<td class='<%=classValue%>'><%=agegroupDes%> </td>
<td class='<%=classValue%>'><%=rs.getString("ORDER_SEQ_NO")%></td>
<%
	   String SysInd="";
		if(rs.getString("SYS_IND").equals("U")) 
		  SysInd=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");
		else
		  SysInd=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels");

		String  auto_close_period="";
			 auto_close_period=rs.getString("AUTO_CLOSE_PERIOD");
			 if(auto_close_period==null || auto_close_period.equals("null"))auto_close_period="";
	 %>

<td class='<%=classValue%>'><%=SysInd%></td>

	<%
			  


			String auto_close_period_type="";
			String auto_close_period_type_value="";
			auto_close_period_type_value=rs.getString("AUTO_CLOSE_PERIOD_TYPE") ;
			  if(auto_close_period_type_value==null || auto_close_period_type_value.equals("null"))auto_close_period_type_value="";
			if (auto_close_period_type_value.equals("D") )
			{
				auto_close_period_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			}
			else if(auto_close_period_type_value.equals("W") )
			{
				auto_close_period_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
			}
			else if(auto_close_period_type_value.equals("M"))
			{
			   auto_close_period_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			}
			else if(auto_close_period_type_value.equals("Y"))
			{
				 auto_close_period_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			}
		%>

 <% out.println("<td class='" + classValue + "' >");
					if (rs.getString("EFF_STATUS").equals("E") )
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td>");   %>
</tr>
<%		
		rowCount ++;
		i++;
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialityEventQueryResult Module "+ee.toString());//common-icn-0181
		ee.printStackTrace();
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}

%>
	</body>
</html>


