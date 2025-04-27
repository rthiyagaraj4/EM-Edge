<!DOCTYPE html>

<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<TITLE></TITLE>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
   
  

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src="../js/repSMDisInaUserMenuForm.js"></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection				con		=	null;
	ResultSet				rset	=	null; 
	Statement				stmt	=	null;
	String p_module_id		= "SM" ;
	String p_report_id		= "SMDINUSL" ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");
	try{
		  
	con = ConnectionManager.getConnection(request);
	
%>

</head>
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onload='FocusFirstElement()'  >
<BR>
	<form name="repSMDisInaUserMenuForm" id="repSMDisInaUserMenuForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table border='0' align='center' cellspacing='0' cellpadding='0' width='80%'>
		
		 <tr>
            <td class='columnheader' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td><br>
            
         </tr>
         
         <tr>
			<td>&nbsp;</td>
		 </tr>
         
     <table width='80%' align='center' valign='top' border='0'>
	
	 <tr>
		<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class="fields" colspan ="3"> 
				<select name='p_for_facility_id' id='p_for_facility_id'>
			<%
				try
				{
				con		=	ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				String fid;
				String fname;
				StringBuffer sql1 = new StringBuffer();					
				
				String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

				sql1.append("select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2");					
				rset=stmt.executeQuery(sql1.toString());
				if(rset!=null)
				{
				   while(rset.next())
				   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
					out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
					else
					out.println("<option value='"+fid+ "' >"+fname+"</option>");
				   }
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();
				}
				catch(Exception e)
				{
					out.println(e);
				}
				finally 
				{ 
					if(rset!=null)rset.close();
					if(stmt!=null)stmt.close();
					ConnectionManager.returnConnection(con,request);
				}
			%>	
			</select>
		</td>
	</tr>

	 <tr>
                    <td width="33%">&nbsp;</td>
                    <td class="querydata" width="33%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td class="querydata" width="33%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
    <tr>
				<td width='20%' class="label" nowrap><fmt:message key="Common.userid.label" bundle="${sm_labels}"/></td>
				<td width='10%' class='fields'><input type="text" name="p_fm_user_id" id="p_fm_user_id"size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(from_user_id,this);'><input type='button' align='left' name='from_user_id' id='from_user_id' value='?' class='button' onclick='searchCode(this,p_fm_user_id)'></td>
				<td width='05%' class='fields'><input type="text" name="p_to_user_id" id="p_to_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(to_user_id,this);'><input type='button' align='left' name='to_user_id' id='to_user_id' value='?' class='button' onclick='searchCode(this, p_to_user_id)'></td>
				<td width='10%' >&nbsp;</td>
	</tr>
	
			<tr>
			<td>&nbsp;</td>
		 	</tr>

			<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eSM.AutoDisbleDate.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class='fields' width='30%'  >
							<input type=text id="date_range_from"  name='p_fm_date_range' id='p_fm_date_range' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>");DateCompare1(p_fm_date_range,p_to_date_range);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_range_from');DateCompare1(p_fm_date_range,p_to_date_range);"/>
						</td>
						<td class='fields' width='30%'> 
							<input type=text id="date_range_to"  name='p_to_date_range' id='p_to_date_range' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY","<%=localeName%>");DateCompare1(p_fm_date_range,p_to_date_range);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_range_to');DateCompare1(p_fm_date_range,p_to_date_range);"/>
						</td>
				</tr>
				
		   
   </table>
   <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
   <input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
    <input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">

	</table>	
</form>
</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html> 

