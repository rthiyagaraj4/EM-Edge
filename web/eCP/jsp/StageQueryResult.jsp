<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	Hema Malini B
*	Created On		:	30th Dec 2004
-->
<!-- StageQueryResult.jsp-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eCP/js/Stage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 	String whereClause = request.getParameter("whereclause");
   StringBuffer sql_Stage=new StringBuffer();
   String from=request.getParameter("from");
   String to=request.getParameter("to");
   StringBuffer qryWhere=new StringBuffer();

   String qry_stage_code ="";
   String qry_stage_description = 	"";
   String qry_stage_indicator ="";
   String qry_eff_status="";

   Connection con=null;
   Statement stmt=null;
   ResultSet rs=null;
   int MaxRecord=0;

   StringBuffer sqlCount =null;
   StringBuffer sql_out=null;

   
	int start = 0 ;
	int end = 0 ;

	String stage_code = "";
	String long_desc  = "";
	String short_desc  = "";
	String stage_indicator = "";
	String eff_status = "";

	String classValue="";
    int rowCount=0;

  
   if(whereClause == null || whereClause.equals(""))
   {
	   qry_stage_code = request.getParameter("stage_code").equals("")?"":request.getParameter("stage_code");

	   qry_stage_description =  			request.getParameter("stage_description").equals("")?"":request.getParameter("stage_description");

	   qry_stage_indicator = request.getParameter("stage_indicator").equals("")?"":request.getParameter("stage_indicator");

	   qry_eff_status= request.getParameter("eff_status").equals("")?"D":request.getParameter("eff_status");

	   qry_stage_code=qry_stage_code+"%";
	   qry_stage_description=qry_stage_description+"%";
 
	   qryWhere.append("where upper(stage_code) like upper('"+qry_stage_code+"') and language_id='"+locale+"' and upper(long_desc) like upper('"+qry_stage_description+"') and upper(stage_indicator) like upper('"+qry_stage_indicator+"') and upper(eff_status) like upper('"+qry_eff_status+"')" );

	   sql_Stage.append(qryWhere.toString());

	   //Appending orderbyclause
	   String ord[]= request.getParameterValues("orderbycolumns");
    
	   if( !((ord==null)|| ord.equals(""))  )
	   {
		   sql_Stage.append(" order by ");
		   for(int i=0;i<ord.length;i++)
		   {
			   if(i== ord.length - 1)
				   sql_Stage.append(ord[i]);
				   else
			        {
						sql_Stage.append(ord[i]);
						sql_Stage.append(",");
					}
		   }
	   }
   }
   else
     sql_Stage.append(whereClause);
 	
 

 try
 {
	 con = ConnectionManager.getConnection(request);
	 stmt=con.createStatement(); 

	  sqlCount =new StringBuffer();

	 sqlCount.append("select count(*) from cp_stage_lang_vw ");
	 
	 sqlCount.append(sql_Stage);

	  sql_out=new StringBuffer();
	 sql_out.append("select stage_code,short_desc,long_desc,stage_indicator,eff_status from cp_stage_lang_vw ");
	 sql_out.append(sql_Stage);
	
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	rs=stmt.executeQuery(sqlCount.toString());

	if(rs.next())
	 {
		MaxRecord=rs.getInt(1);
	 }
	if(MaxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
%>
<p>
<table align="right">
 <tr><td>
<% if(!(start<=1))
	out.println("<a href='StageQueryResult.jsp?from="+(start-13)+"&to="+(end-13)+  "&whereclause="+URLEncoder.encode(sql_Stage.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

   if(!((start+14) > MaxRecord))
	out.println("<a href='StageQueryResult.jsp?from="+(start+13)+"&to="+(end+13)+  "&whereclause="+URLEncoder.encode(sql_Stage.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td></tr></table></p>
   <br><br>
	<body onKeyDown="lockKey()">
	<table border="1" width="100%" cellspacing="0" cellpadding="0">
	<tr>
	<th rowspan='2' width="10%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th rowspan='2' width="30%" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="15%" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="15%" ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="10%" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
	 classValue="";
     rowCount=0;
	//int i=0;
	rs=stmt.executeQuery(sql_out.toString());
	if( start!=1)
		for(int i=1; i<start; rowCount++,i++)
		 {
			rs.next();
		 }

		 while(rs.next() && rowCount < end )
	    {
			if(rowCount%2==0)
			   classValue="QRYEVEN";
		    else
				classValue="QRYODD";

     stage_code = rs.getString("stage_code")==null ? "":rs.getString("stage_code");
	 long_desc  = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	 short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	 stage_indicator = rs.getString("stage_indicator")==null?"":rs.getString("stage_indicator");
	 eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	%>
	
	<tr>
	<td align="left" class=<%=classValue%>><a href="../../eCP/jsp/StageAddModify.jsp?mode=2&	stage_code=<%=stage_code%>"><%=stage_code%></a></td>

	<td align="left" class=<%=classValue%>><%=long_desc%></td>
    <td align="left" class=<%=classValue%>><%=short_desc%></td>
   

  <% if(stage_indicator.equals("01")){%>
		<td align="left" class=<%=classValue%>><fmt:message key="eCP.PreAdmit.label" bundle="${cp_labels}"/></td>
	<%}else if(stage_indicator.equals("02")){%>
				<td align="left" class=<%=classValue%>><fmt:message key="eCP.PostAdmit.label" bundle="${cp_labels}"/></td>
	<%}else if(stage_indicator.equals("03")){%>
				<td align="left" class=<%=classValue%>><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></td>
	<%}else if(stage_indicator.equals("04")){%>
				<td align="left" class=<%=classValue%>><fmt:message key="eCP.PostDischarge.label" bundle="${cp_labels}"/></td>
	<%}%>
	  
	 
	 <% if(eff_status.equals("E")){%>
		<td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
			<%}else{%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
		</tr>
			<%}%>
	<%
			rowCount++;
		}

  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  %>
	  </table>
  <%
  }catch(Exception e)
  {
	//out.println(e.toString());//common-icn-0181
	e.printStackTrace();
  }
  finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  ConnectionManager.returnConnection(con,request);
	}
  %>

</BODY>
</HTML>
	 
         





	     






