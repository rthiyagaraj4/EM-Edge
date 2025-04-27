<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:
*	Created By		:	Hema Malini B
*	Created On		:	27th Dec 2004
-->

<!-- FactorQueryResult.jsp-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language=JavaScript src="../../eCommon/js/common.js"></script>



<% 
   request.setCharacterEncoding("UTF-8"); 
   String whereClause=request.getParameter("whereclause");
   StringBuffer sql_factor=new StringBuffer();
   String from=request.getParameter("from");
   String to=request.getParameter("to");
   StringBuffer qryWhere=new StringBuffer();
   //String factor_type="";
   String related_factor_yn="";
   String risk_factor_yn="";
   String defn_characteristic_yn="";

   
   if(whereClause == null || whereClause.equals(""))
   {
	  String qry_factor_code = request.getParameter("factor_code").equals("")?"":request.getParameter("factor_code");

	  String qry_factor_description =  			request.getParameter("factor_description").equals("")?"":request.getParameter("factor_description");

	  String qry_factor_type = request.getParameter("factor_type").equals("")?"":request.getParameter("factor_type");

	   qry_factor_code=qry_factor_code+"%";
	   qry_factor_description=qry_factor_description+"%";
 
	   qryWhere.append("where upper(factor_code) like upper('"+qry_factor_code+"') and upper(long_desc) like upper('"+qry_factor_description+"') ");
	  
	  if(qry_factor_type.equals("L"))
	   {
		  related_factor_yn="Y";
		  qryWhere.append("and upper(related_factor_yn) like upper('"+related_factor_yn+"') ");
	   }
	   else if(qry_factor_type.equals("K"))
	   {
			risk_factor_yn="Y";
			qryWhere.append("and upper(risk_factor_yn) like upper('"+risk_factor_yn+"') ");
	
	   }
	   else if(qry_factor_type.equals("R"))
	   {
			risk_factor_yn="Y";
			related_factor_yn="Y";
			qryWhere.append("and upper(risk_factor_yn) like upper('"+risk_factor_yn+"') and upper(related_factor_yn) like upper('"+related_factor_yn+"') ");
	   }
	   else if(qry_factor_type.equals("C"))							
	   {
		 defn_characteristic_yn="Y";
    	 qryWhere.append("and upper(defn_characteristic_yn) like upper('"+defn_characteristic_yn+"') ");	
	   }
	  

	   String qry_eff_status= request.getParameter("eff_status").equals("")?"D":request.getParameter("eff_status");
	
	   qryWhere.append("and upper(eff_status) like upper('"+qry_eff_status+"')" );
	   qryWhere.append("and language_id='"+locale+"' " );
	   sql_factor.append(qryWhere.toString());

	   //Appending orderbyclause
	   String ord[]= request.getParameterValues("orderbycolumns");
       
	   if( !((ord==null)|| ord.equals(""))  )
	   {
		   sql_factor.append(" order by ");
		   for(int i=0;i<ord.length;i++)
		   {
			   if(i== ord.length - 1)
				   sql_factor.append(ord[i]);
				   else
			        {
						sql_factor.append(ord[i]);
						sql_factor.append(",");
					}
		   }
	   }
   }
   else
     sql_factor.append(whereClause);
	 	
	 Connection con=null;
	 Statement stmt=null;
	 ResultSet rs=null;
	 int MaxRecord=0;

 try
 {
	 con = ConnectionManager.getConnection(request);
	 stmt=con.createStatement(); 

	 /*StringBuffer sqlCount =new StringBuffer();

	 sqlCount.append("select count(*) from mr_factor ");
	 
	 sqlCount.append(sql_factor);
	*/
	 StringBuffer sql_out=new StringBuffer();
	 sql_out.append("select factor_code,short_desc,long_desc,related_factor_yn,risk_factor_yn,defn_characteristic_yn,eff_status from mr_factor_lang_vw ");
	 sql_out.append(sql_factor);
	 rs=stmt.executeQuery(sql_out.toString());


 	int start = 0 ;
	int end = 0 ;

	
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	/*rs=stmt.executeQuery(sqlCount.toString());

	if(rs.next())
	 {
		MaxRecord=rs.getInt(1);
	 }
	if(MaxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		*/

	int rowCount=1;
	
	if( start!=1)
		for(int i=1; i<start; rowCount++,i++)
		 {
			rs.next();
		 }
	
	while( rowCount <= end && rs.next())
	 {
		if (MaxRecord==0)
			{
%>
	<p>
	<table align="right">
	 <tr>
	<% if(!(start<=1))
		out.println("<td align ='right' id='prev'><A href='FactorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+  "&whereclause="+URLEncoder.encode(sql_factor.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	   //if(!((start+14) > MaxRecord))
		out.println("<td align ='right' id='next' style='visibility:hidden'><A href='FactorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+  "&whereclause="+URLEncoder.encode(sql_factor.toString())+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
	</tr></table></p>
	<br><br>
	<body onKeyDown="lockKey()">
	<table border="1" width="110%" cellspacing="0" cellpadding="0">
	<tr>
	<th rowspan='2' width="10%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th rowspan='2' width="35%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="15%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th colspan='3'width="30%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<tr><th width="10%"><fmt:message key="eMR.Related.label" bundle="${mr_labels}"/></th>					
	    <th width="10%"><fmt:message key="eMR.Risk.label" bundle="${mr_labels}"/></th>
	    <th width="10%"><fmt:message key="Common.DC.label" bundle="${common_labels}"/></th>
	</tr>
<%
			}
	String classValue="";
   /* int rowCount=0;
	//int i=0;
	rs=stmt.executeQuery(sql_out.toString());
	if( start!=1)
		for(int i=1; i<start; rowCount++,i++)
		 {
			rs.next();
		 }*/

		// while(rs.next() && rowCount < end )
	    //{
			if(rowCount%2==0)
			   classValue="QRYEVEN";
		    else
				classValue="QRYODD";

    String factor_code = rs.getString("factor_code")==null ? "":rs.getString("factor_code");
	String long_desc  = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	String short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	String related_factor = rs.getString("related_factor_yn")==null?"N":rs.getString("related_factor_yn");
	String risk_factor = rs.getString("risk_factor_yn")==null ? "N":rs.getString("risk_factor_yn");
	String defn_char = rs.getString("defn_characteristic_yn")==null?"N":rs.getString("defn_characteristic_yn");
	String eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");


  /*if(defn_char.equals("Y"))
	factor_type = "C";
  else
  {
	if(related_factor.equals("Y"))
	{
		if (risk_factor.equals("Y"))
			factor_type = "R";
		else
			factor_type = "L";
	}		
	else
		factor_type = "K";
  }*/
	
	
%>
	<tr>
	<td align="left" class=<%=classValue%>><a href="../../eMR/jsp/FactorAddModify.jsp?mode=2&
	factor_code=<%=factor_code%>"><%=factor_code%></a></td>

	<td align="left" class=<%=classValue%>><%=long_desc%></td>
    <td align="left" class=<%=classValue%>><%=short_desc%></td>
	 

	<% if(related_factor.equals("N")){%>
		<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
		<%} else {%>
			 <td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
	 <%}%>

	<% if(risk_factor.equals("N")){%>
		<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
		<%} else {%>
			 <td align="center" class="<%=classValue%>"><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
	 <%}%>
	<% if(defn_char.equals("N")){%>
		<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
		<%} else {%>
			 <td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
	 <%}%>
		
	 <% if(eff_status.equals("E")){%>
		<td align="center" class=<%=classValue%> ><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
			<%}else{%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
			<%}%>
		</tr>
	<%
			rowCount++;
			MaxRecord++;
	 }

			

			if(MaxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				if ( MaxRecord < 14 || (!rs.next()) )
				{
				%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
				<% 
				}
				else
				{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				}

  //if(rs!=null) 	rs.close();
  //if(stmt!=null) stmt.close();
  %>
	  </table>
  <%
  }catch(Exception e)
  {
	//out.println(e.toString());
	e.printStackTrace();
  }
  finally {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  
	  if(con != null)
		ConnectionManager.returnConnection(con,request);
	}
  %>

</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

