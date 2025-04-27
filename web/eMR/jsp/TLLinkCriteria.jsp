<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eMR/js/TLReportSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	</script>
</head>
<body OnMouseDown="CodeArrest()">
<form name='ssordercatalog_form' id='ssordercatalog_form'  action=''  method='post' target='messageFrame'>
	<%
	request.setCharacterEncoding("UTF-8");
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;

	String report_gr_id			= "";
   	String str1					= "";
  try{
		con				= ConnectionManager.getConnection(request);
		stmt			= con.createStatement();
	%>
		  <input type=hidden name="report_gr_id" id="report_gr_id" value='<%=report_gr_id%>'>
			  <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
						<tr>
							<td colspan=1></td>
							<td colspan=1></td>
							<td colspan=1></td>
							<td colspan=1></td>
						</tr>
						<tr> 
							<td align=right class='label' width=14%><fmt:message key="Common.report.label" bundle="${common_labels}"/></td> 
							<td align=left width=63% colspan=3>&nbsp;<SELECT name="Report" id="Report" onChange="callOtherReport(this);callMaster(this);"><option>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------- </option>
							<%  //Below line Modified for this PER-RH-0206 and PER-PD-209A
								str1="select report_id,report_desc from sm_report where report_id in ('MROPCSMB','MRIPCSMB','MROPCSMS','IPBMIPCS','MRBRADEX','MRBLABWL','MRBLABRG','MRBSS203','MROPRFLS','MROPCSAT','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','IPBMCSBU','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF','MRBBAT3A','MRBBAT3B','MRBBAT3C','MRBRH212','MRDCCSMB','MRIPCSOBD','MRDCPROD','MRDCPROS','MRBRH203') order by report_desc";//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
								rs	= stmt.executeQuery(str1);
								while(rs.next()){
								report_gr_id=rs.getString("report_id");
							%>
								<option value="<%=rs.getString("report_id")%>"><%=rs.getString("report_desc")%></option>
						<% }%>
						</select> <img src='../../eMP/images/mandatory.gif'>
						</td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td  class='label'  width=14%  align='right'><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></td>
							<td colspan=1>&nbsp;<select name="Master" id="Master" onchange="callClear_l1(this);clearMandatory()"> 
							<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option></SELECT> <img   src='../../eMP/images/mandatory.gif'> &nbsp;&nbsp;<td  class='label'  width=14%  align='right'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
							<td class='querydata' width='11%' id='fetchdata'>&nbsp;</td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr> 
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td> 
						</tr>
						<tr>
							<td align=right class='label' ><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></td> 
							<td align=left colspan=3>&nbsp;<textarea rows=2  disabled cols=50 name="Main_group_desc"   onBlur="level1(this);"  readonly></textarea><input disabled type="button" name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getLevelGroupId();"><input type="hidden" name="Main_group" id="Main_group"><img  style="visibility:hidden" src='../../eMP/images/mandatory.gif'  id='mand_gif1'></td>
						</tr>
						<tr>
							<td colspan=4></td> 
						</tr>
						<tr>
							<td colspan=4></td>
						</tr> 
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td colspan=4></td>
						</tr>
						<tr>
							<td align=right class='label'><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></td>
							<td  align="left" colspan=3>&nbsp;<textarea rows=2  cols=50  name="sub_group1" readonly></textarea><input type="button" name="sub_group12" id="sub_group12"  value="?" class="BUTTON" onClick="getSubGroupId();"><input type="hidden" name="sub_group" id="sub_group" value=""><img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif2'></td>
						</tr>
					<tr>
						<td colspan=4></td>
					</tr>
					<tr>
						<td colspan=4></td>
					</tr> 
					 <tr>
						<td colspan=4></td>
					</tr>
					<tr>
						<td colspan=4></td>
					</tr> 
					<tr>  
						 <td align=right class='label'><fmt:message key="eMR.level3group.label" bundle="${mr_labels}"/></td>
						 <td colspan=3 align="left">&nbsp;<textarea rows=2 disabled cols=50 name="level_code3_desc" readonly></textarea><input type="button"  disabled name="sub_group13" id="sub_group13" value="?" class="BUTTON" onClick="getLevel3GroupId();">
							<input type="hidden" name="level_code3" id="level_code3" value="">
							<img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif3'>
						 </td>
						<!--  <td class='label' align="right">Serial No&nbsp;&nbsp;</td>
						 <td class='querydata' id='fetchdata'></td> -->
						   <input type='hidden' name="serialvalue" id="serialvalue">
					</tr>
					<tr>
						<td colspan=4></td>
					</tr>
					<tr>
						<td colspan=4></td>
					</tr> 
					<tr>
						<td colspan=4></td>
					</tr>
					<tr>
						<td colspan=4></td>
					</tr>
					<tr>
						<td colspan=4>
							<table border=0 width='100%' align='center'>
								<tr>
									<td  width='100%' id='t'></td>
								</tr>
								<tr>
									<td  width='100%' id='t1'></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan=4></td>
					</tr> 
					<tr>
						<td colspan=4></td>
					</tr> 
					<tr>
						<td colspan=4></td>
					</tr> 
					<tr>
						<td class='label' align="right">&nbsp;</td>
						<td class='querydata' id='fetchdata1'>&nbsp;</td>
						<td colspan=2 align=right>&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" Onclick="FetchValues()"><INPUT TYPE="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" Onclick="clearValues()"> 
						</td>
					</tr>
				</table>
				<input type="hidden" name=type id=type value="">
		<% 
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			}catch(Exception e){
				//out.println("Exception in File SSOrderCatalogLinkCriteria"+e.toString());
				e.printStackTrace();
			}finally{
				ConnectionManager.returnConnection(con,request);
			}
		%>
		</form>
	</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

