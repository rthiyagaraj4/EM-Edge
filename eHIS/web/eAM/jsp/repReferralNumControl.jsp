<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_passing_local_date="";
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBRFNMB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

	Connection con = null;
	//PreparedStatement pstmt = null ;
	//ResultSet rs = null;
	Statement stmt=null;
	ResultSet rset=null;
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eAM/js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onLoad="Focusing('p_facility');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repRefNum" id="repRefNum" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='60%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="60%" class="Border" align='center'>

				<table width='60%' cellPadding="" cellSpacing="0"  align='center' >

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

		<tr>
			<td align="right" class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td colspan='2'><select name='p_facility' id='p_facility'>
			
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
						String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";			

					rset=stmt.executeQuery(sql1);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						if(fid.equals("All"))
						out.println("<option value='"+fid+"'  selected>"+fname+"</option>");
						else
                        out.println("<option value='"+fid+"' >"+fname+"</option>");
					   }
					}
					}catch(Exception e) { //out.println(e);
						e.printStackTrace();
					}
					finally
					{
						if(rset!=null) rset.close();
						if(stmt!=null) stmt.close();
						ConnectionManager.returnConnection(con,request);
					} %>
				</select>
			</td>
			</tr>


				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
				<tr>
					<td align='right' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  align="left">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type='hidden' name='locale' id='locale'              value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id'		value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</BODY>
</HTML>

