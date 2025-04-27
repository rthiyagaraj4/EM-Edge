<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con=null;
	try{
	con = ConnectionManager.getConnection(request);
	Statement stmt =con.createStatement();
	ResultSet rs =null;		
%>
<html>
	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="JavaScript">

		function Pass2MsgFrm(){

			var n=parent.document.f_query_add_mod.document.forms[0].Report_Id.options.length; 
			//var n=parent.document.f_query_add_mod.document.getElementById(Report_Id).options.length;
			for(var i=0;i<n;i++) parent.document.f_query_add_mod.document.forms[0].Report_Id.remove("Report_Id");
			var num = "four";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("Module_Id").value+"\"  /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","GetValues.jsp",false)

			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText)
		}

			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()';  onload='FocusFirstElement()'>
	<form name="report_for_facility" id="report_for_facility" action="../../servlet/eSM.ReportForFacilityServlet" method="post" target="messageFrame"><center>
	<br><br><br><br><br><br><br>
 		<table border="0" cellpadding="0" cellspacing="0" width="65%" align='center'>
 			<tr>
				<td width='25%'>&nbsp;</td>
 				<td width='25%'>&nbsp;</td>
			</tr>

			<tr>
				<td class="label" width='25%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><!-- width="60%"--><Select name="Module_Id" id="Module_Id" onChange="Pass2MsgFrm()"><OPTION VALUE=''>&nbsp;&nbsp; ----------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- &nbsp;&nbsp;
				<%
					rs = stmt.executeQuery( "Select distinct a.Module_Id,a.module_name from Sm_Module a,sm_report b where Install_Yn='Y' and facility_based_yn='Y' and b.module_id=a.module_id order by module_name");	
					if( rs != null ) {
						while( rs.next() ) {
						     	String moduleid = rs.getString( "Module_Id" ) ;
								String modulename = rs.getString( "module_name" ) ;
							%>
								<OPTION VALUE='<%= moduleid %>' ><%= modulename %>	
							<%
						}
				      	}
						
				%>	     	 
  		   		</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			</tr>  
			<tr>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
			</tr>

  			<tr>
  				<td class="label" width='25%'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
  		    	<td class='fields' width='25%'><Select name="Report_Id" id="Report_Id"><OPTION VALUE=''>&nbsp;&nbsp----------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------&nbsp;&nbsp;
  				</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  			</tr> 
  			<tr>
  				<td width='25%'>&nbsp;</td>
  				<td width='25%'>&nbsp;</td>
			</tr>

			<tr>
				<td  class="label" width='25%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><Select name="Facility_Id" id="Facility_Id"><OPTION VALUE=''>&nbsp;&nbsp----------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------&nbsp;&nbsp;	
				<%if(rs!=null) rs.close();
  					rs = stmt.executeQuery( "Select Facility_Id,Facility_Name from Sm_Facility_Param where Facility_Type='F' order by facility_name");
					if( rs != null ) {
						while( rs.next() ) {
						     	String facilityid = rs.getString( "Facility_Id" ) ;
						     	String facilityname = rs.getString( "Facility_Name" ) ;
							%>
								<OPTION VALUE='<%= facilityid %>' ><%= facilityname %>	
							<%
						}
				      	}
		
				%>	     	 
  		   		</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			</tr>  
			<tr>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
			</tr>

			<tr>
    				<td class="label" width='25%'><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/></td>
    				<td class='fields' width='25%'><Select name="Report_Group_Id" id="Report_Group_Id"><Option value="">&nbsp;---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;
    					<%if(rs!=null) rs.close();
    						rs = stmt.executeQuery("Select Report_Group_Id,Short_Desc from Sm_Report_Group where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc");
						if(rs!=null) {
							while(rs.next())	{
								%>
								<Option value='<%=rs.getString("Report_Group_Id")%>'><%= rs.getString("Short_Desc")%>
							<%}
						}
			
    					%>
    					</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
    			</tr>
    			<tr>
    				<td width='25%'>&nbsp;</td>
    				<td width='25%'>&nbsp;</td>
			</tr>

			      	<%
	         			if( stmt != null) stmt.close();
	         			if( rs != null) rs.close();
	      			%>
					<input type="hidden" name="function" id="function" value="insert">
					<input type="hidden" name="function_name" id="function_name" value="insert">
		</table>
	</center>			
</form>
</body>
</html>
<%
	}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

