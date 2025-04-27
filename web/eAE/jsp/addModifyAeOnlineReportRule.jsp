<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eAE/js/AeOnlineReportRule.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

<script>
function change()
{
	if (online_reportsrule_form.print_at_ci_yn1.checked == true)
	  online_reportsrule_form.print_at_ci_yn.value="Y";
   else
	  online_reportsrule_form.print_at_ci_yn.value="N";
}
</script>

<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<head>

<%
	Connection con = null;
	try
	{


		con=ConnectionManager.getConnection(request);
		
		PreparedStatement pstmt=null;
		ResultSet rset=null ;

	    String Print="";
		String reportDesc="";
		String VisitDesc="";
		String locCode="";
		String Location_code="";
		
		String visit_type="";
		String report_id="";
		String fnval="insert";
		String ID="";
		String dat="";
		String sel1="";
		String sel2="";
		String clinic_code="";
		String visittype="";
		String reportID="";
		String moduleID = "";
		String checkboxval="Y";
		String checkBoxAttribute="checked";
	    String facilityId = (String) session.getValue( "facility_id" ) ;

	    Location_code=request.getParameter("locationcode");
	  
	    visit_type=request.getParameter("visittype");
	    report_id=request.getParameter("reportid");

		if(Location_code != null )
		{
			fnval="modify";

			try
			{
				
				pstmt=con.prepareStatement("select CLINIC_CODE, VISIT_TYPE_CODE, MODULE_ID,REPORT_ID, PRINT_YN, REPORT_DESC, VISIT_TYPE_SHORT_DESC, CLINIC_DESC  from  AE_ONLINE_REPORT_VW where  module_id in ('AE' ,'MP','OP','FM')  and  CLINIC_CODE=? and  VISIT_TYPE_CODE=?  and   REPORT_ID=? and OPERATING_FACILITY_ID=? ");
				
				pstmt.setString(1,Location_code);
				
				pstmt.setString(2,visit_type);
				
				pstmt.setString(3,report_id);
				
				pstmt.setString(4,facilityId);

				rset=pstmt.executeQuery();
				rset.next();
				
				locCode=rset.getString("CLINIC_DESC");
				VisitDesc=rset.getString("VISIT_TYPE_SHORT_DESC");
				reportDesc=rset.getString("REPORT_DESC");
				Print=rset.getString("PRINT_YN");
				if(Print.equals("N")) checkBoxAttribute=""; 
				clinic_code=rset.getString("CLINIC_CODE");
				visittype=rset.getString("VISIT_TYPE_CODE");
				reportID=rset.getString("REPORT_ID");
				moduleID = rset.getString("MODULE_ID");
				checkboxval=Print; 
				

			}catch(Exception e) {e.printStackTrace();}
			finally
			{
				if (pstmt != null) pstmt.close();
				if (rset != null) rset.close();
			}

		}
%>
		</head>
		<body  OnMouseDown="CodeArrest()" onLoad="change();FocusFirstElement()" onKeyDown = 'lockKey();'>
		<form name='online_reportsrule_form' id='online_reportsrule_form' action='../../servlet/eAE.AeOnlineReportRuleServlet'
    method='post' target='messageFrame'>
				<div align='center'>
					<br><br><br><br><br><br><br><br><br><br>
				<center>
					<table border='0' cellpadding='0' cellspacing='0' width='auto' >
						<td class="BORDER">

						<tr>
							<td width='10%'>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td width='10%'>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td   class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td   >
							<%if(fnval.equals("modify"))
							 {
								out.println("<input type='text' name='short_desc' id='short_desc'  value=\""+locCode+"\" length=15 size=15  readonly>");
								out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
							%>

							<%
							 }
							 else{ %>
								<select name='short_desc' id='short_desc' onChange="PopService('visit_type');">
								<option value=''>&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
								<%
									try
									{
										pstmt=con.prepareStatement("select '*All' clinic_code,'*All' short_desc from dual union select clinic_code,long_desc short_desc from op_clinic where facility_id='"+facilityId+"' and eff_status='E' and LEVEL_OF_CARE_IND='E' order by short_desc " );
										rset=pstmt.executeQuery();
										if(rset!=null)
										{
											   while(rset.next())
											   {
												dat=rset.getString("short_desc");
												ID=rset.getString("clinic_code");
												if(dat.equals(locCode))
												  sel1="selected";
												else
													sel1="";
												out.println("<option value='"+ID+ "' "+sel1+">"+dat+"</option>");
											   }%>
											 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'>
										<%
										}
									}catch(Exception e) {e.printStackTrace();}
									finally
									{
										if (pstmt != null) pstmt.close();
										if (rset != null) rset.close();
									}
								}%>
							</td>
						   <td>&nbsp;</td>
					   </tr>
					   <tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
					   </tr>
					   <tr>
							 <td>&nbsp;</td>
							 <td  class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
							 <td  >
							 <%if(fnval.equals("modify"))
							  {
								out.println("<input type='text' name='visit_type' id='visit_type'  value='"+VisitDesc+"' length=15 size=15  readonly>");
								out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
								out.println("<td>&nbsp;</td>");
							  }
							   else{ %>
								 <select name='visit_type' id='visit_type' >
									<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
								 </select>
								 <img src='../../eCommon/images/mandatory.gif'align='center'>
								 </td>
								 <td>&nbsp;</td>
								<%}%>
					  </tr>
		              <tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					  </tr>
	   				  <tr>
						<td>&nbsp;</td>
						<td   class='label' ><fmt:message key="Common.report.label" bundle="${common_labels}"/> </td>
			        	<td   colspan='2'>
						<%if(fnval.equals("modify"))
						 {
							out.println("<input type='text' name='report_desc' id='report_desc' value='"+reportDesc+"'  size=60  readonly>&nbsp;<img  align='center' src='../../eCommon/images/mandatory.gif '>&nbsp;");
						 }
						 else{%>
							 <select name='report_desc' id='report_desc'>
								 <option value=''>&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
						 <%
							try
							{
							 /* The prepare statement fetches the various kinds of reports available for OP module and populated those names into the report_desc drop down box --- Srijagadeesh. */

								pstmt=con.prepareStatement("select report_desc,report_id,module_id from  sm_report where module_id in ('AE' ,'MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM', 'OPBQTKNO','MPBIRCER','MPDTHCER','OPRNTFMR','OPBMEDCR','OPRFLETR','OPRVSLBL','MPSTBCER','MPBSTLBL','MPBPTLBL') order by report_desc");
								rset=pstmt.executeQuery() ;
								if(rset!=null)
								{
									while(rset.next())
									{
										dat=rset.getString("report_desc");
										ID=rset.getString("report_id");
										if(ID.equals(reportDesc))
										  sel2="selected";
										else
											sel2="";
										out.println("<option value='"+ID+"::"+rset.getString("module_id")+ "' "+sel2+">"+dat+"</option>");

								   }
							    }
								if (rset != null) rset.close();
						 %>
							 </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'>
						</td>
					</tr>
				    <%
						}catch(Exception e) { e.printStackTrace();}
						finally
						{
							if (pstmt != null) pstmt.close();
							if (rset != null) rset.close();
						}
					 }%>
	
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td    class=label nowrap> <fmt:message key="Common.PrintApplicability.label" bundle="${common_labels}"/></td>
							<td >
							<input type='checkbox' name='print_at_ci_yn1' id='print_at_ci_yn1' value='<%=checkboxval%>' 	<%=checkBoxAttribute%> onClick="change()"></td>
    					    </td>
						   <td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</div>
				<input type='hidden' name='function' id='function' value='<%=fnval%>'>
				<input type='hidden' name='function_name' id='function_name'  value='<%=fnval%>'>
				<input type='hidden' name='Loc_Code' id='Loc_Code' value='<%=clinic_code%>'>
				<input type='hidden' name='visitype' id='visitype' value='<%=visittype%>'>
				<input type='hidden' name='report' id='report' value='<%=reportID%>::<%=moduleID%>'>
				<input type='hidden' name='print_at_ci_yn' id='print_at_ci_yn' value=''>	
				<!-- <input type='hidden' name='print_at_pr_yn' id='print_at_pr_yn' value='N'>	
				<input type='hidden' name='print_at_xt_yn' id='print_at_xt_yn' value='N'>
				<input type='hidden' name='print_at_ns_yn' id='print_at_ns_yn' value='N'> -->
			</form>
		</body>
	</html>
	<%
	}catch(Exception e){}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
%>

