<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con;
	Statement stmt1=null;
	ResultSet rset1=null ;
	//	Statement stmt2=null;
	//ResultSet rset2=null ;

	String p_module_id		= "OR" ;
	String p_report_id		= "ORRSTAGS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	con = (Connection) session.getValue( "connection" );
	try
	{


%>

<html>
<HEAD>
<TITLE></TITLE>
<!--<link rel="stylesheet" type="text/css" href="/eCIS/common/html/ecis.css"></link>-->
======================

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="/eHIS/eCommon/js/ValidateControl.js"></script>
<script src="/eHIS/eCommon/js/common.js"></script>
<script src="/eHIS/eOR/js/TotalAgeGroupSexNationality.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

		
	async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			//alert(obj.name)
			if(obj.name=="service_code")
			{
				tit="Service Code"
				sql="select service_code, short_desc from or_service ";
				search_code="service_code";
				search_desc="short_desc";
			}
			else if(obj.name=="service_category")
			{
				tit="Service Category"
				sql="select service_category_code, short_desc from or_service_category ";
				search_code="service_category_code";
				search_desc="short_desc";
			}


			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("/eHIS/eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	

</script>
</HEAD>
<BODY   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
<br>

<form name="TotalAgeGroupSexNationalityForm" id="TotalAgeGroupSexNationalityForm" action="/eHIS/eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>

		<th align='left'> Report Criteria
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>
		<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>

				
				<tr>
					
						<td align='right' width='30%' class="label">Service Type Code&nbsp;</td>
						<td width='20%'>
				<select name='p_service_type_code' id='p_service_type_code' value='short_desc'><option value=''>&nbsp;&nbsp;---------- All -----------&nbsp;&nbsp;
			
			<%
				
				try{
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery("select short_desc,service_type_code from or_service_type order by short_desc");
				

				if(rset1!=null)
				{
				 while(rset1.next())
				 {
					String selectedList = "" ;
					String servicetype="";
					String dat=rset1.getString("short_desc");
					String ID =rset1.getString("service_type_code");
					if(servicetype!= null &&  servicetype.equalsIgnoreCase(ID) ) 
						selectedList = "SELECTED" ;
					out.println("<option value='"+ID+ "'"+selectedList+" >"+dat+"</option>");
				
			  
				 }
				}
				if(rset1!=null) rset1.close();
				if(stmt1!=null) stmt1.close();

			 	}catch(Exception e){e.toString();}
		
		   %>
</select>&nbsp;
</td>
<td>&nbsp</td>
</tr>
<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
</tr>

<!-- Added from here for Order Status here  -->

<tr>
<td align='right' width='30%' class="label">Result Status&nbsp;</td>
						<td width='20%'  >
							<select name='p_order_Status' id='p_order_Status' value ='long_desc'><option value=''>&nbsp;&nbsp;-------------- All ---------------&nbsp;&nbsp;</option>
							<option value='2'>Partial</option>
							<option value='3'>Complete</option>
		<%
				
	/*			try{
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery("select long_desc,order_status_code from or_ordeR_status_code order by short_desc");
				

				if(rset1!=null)
				{
				 while(rset1.next())
				 {
					String selectedList = "" ;
					String servicetype="";
					String dat=rset1.getString("long_desc");
					String ID =rset1.getString("order_status_code");
					if(servicetype!= null &&  servicetype.equalsIgnoreCase(ID) ) 
						selectedList = "SELECTED" ;
					out.println("<option value='"+ID+ "'"+selectedList+" >"+dat+"</option>");
				 }
				}
			 	}catch(Exception e){e.toString();}*/
		
		   %>
</select>&nbsp;
</td>
<td>&nbsp</td>
</tr>
</td>
</tr>

<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
</tr>

<!-- Till for Order Status here  -->

			<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%">From</td>
					<td class="label" width="40%">To</td>
			</tr>

<!--Added for Order Date From and To validations -->
	<tr>
		<td align='right' width='30%' class="label">Period&nbsp;</td>
		<td width='20%'  >
		<input type=text name='p_fr_order_date_time' id='p_fr_order_date_time'
		onBlur = 'CheckDate(this);'  size="10" maxlength="10" align="center">&nbsp;<img src='/eHIS/eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td width='20%'  >
		<input type=text name='p_to_order_date_time' id='p_to_order_date_time' 
		onBlur="CheckDate(this);doDateCheckForOr()"; size="10" maxlength="10" align="center">&nbsp;<img src='/eHIS/eCommon/images/mandatory.gif'align='center'></img>

		</td>
</tr>
			
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label">Service Category&nbsp;</td>
						<td width='20%'>
						<select name='p_fr_service_category' id='p_fr_service_category' value ='short_desc'><option value=''>&nbsp;&nbsp;---------- All -----------&nbsp;&nbsp;
	<%
				
				try{
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery("select short_desc,service_category_code from or_service_category order by short_desc");
				

				if(rset1!=null)
				{
				 while(rset1.next())
				 {
					String selectedList = "" ;
					String servicetype="";
					String dat=rset1.getString("short_desc");
					String ID =rset1.getString("service_category_code");
					if(servicetype!= null &&  servicetype.equalsIgnoreCase(ID) ) 
						selectedList = "SELECTED" ;
					out.println("<option value='"+ID+ "'"+selectedList+" >"+dat+"</option>");
				 }
				}
				if(rset1!=null) rset1.close();
				if(stmt1!=null) stmt1.close();
			 	}catch(Exception e){e.toString();}
		
   %>
		</select>&nbsp;
		</td>
						<td width='40%'> 
							<select name='p_to_service_category' id='p_to_service_category' value ='short_desc'><option value=''>&nbsp;&nbsp;---------- All -----------&nbsp;&nbsp;
	<%
				
				try{
				stmt1=con.createStatement();
				rset1=stmt1.executeQuery("select short_desc,service_category_code from or_service_category order by short_desc");
				

				if(rset1!=null)
				{
				 while(rset1.next())
				 {
					String selectedList = "" ;
					String servicetype="";
					String dat=rset1.getString("short_desc");
					String ID =rset1.getString("service_category_code");
					if(servicetype!= null &&  servicetype.equalsIgnoreCase(ID) ) 
						selectedList = "SELECTED" ;
					out.println("<option value='"+ID+ "'"+selectedList+" >"+dat+"</option>");
				 }
				}
				if(rset1!=null) rset1.close();
				if(stmt1!=null) stmt1.close();
			 	}catch(Exception e){e.toString();}
		
   %>
		</select>&nbsp;
		</td>
				</tr>
			
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<tr>
						<td align='right' width='30%' class="label">Service&nbsp;</td>
						<td width='20%'>
							<input type=text  name='p_fr_service_code' id='p_fr_service_code' size="10" maxlength="10" align="center"><input type='button' name='service_code' id='service_code' value='?' class='button' onclick='searchCode(this,p_fr_service_code)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_service_code' id='p_to_service_code' size="10" maxlength="10" align="center"><input type='button' name='service_code' id='service_code' value='?' class='button' onclick='searchCode(this,p_to_service_code)'>
						</td>
				</tr>
			
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td align='right' width='30%' class="label">Include Stat Report&nbsp;</td>
						<td width='20%'>
						<select name='p_include_stat_report' id='p_include_stat_report' >
						<option value='B'>Both&nbsp;&nbsp;  
						<option value='Y'>Yes
						<option value='N'>No
						</select>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
	
<!-- End for Adding the Order Date  -->
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value='<%= p_facility_id %>'>
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=localeName%>">
</form>
</BODY>
</HTML>
		<% 
			 	}
catch(Exception e){e.toString();}
finally { 
if(rset1!=null)rset1.close();
if(stmt1!=null)stmt1.close();

}
				
				%>

