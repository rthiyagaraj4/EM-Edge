<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, ePH.Common.*, ePH.* ,java.sql.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TpnConsNsRegimen.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhMessages.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	
	/* Mandatory checks start */
	String mode				= request.getParameter( "mode" ) ;
	String bean_id = "TPNConsNSRegimenBean" ;
	String bean_name = "ePH.TPNConsNSRegimenBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	TPNConsNSRegimenBean bean = (TPNConsNSRegimenBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear();
	Hashtable result = bean.getInitialValues(locale);
	ArrayList arr_list_generic = (ArrayList)result.get("arr_list_generic");
	String const_generic_code = "";		String const_srl_no = "";
	String const_short_name ="";		String const_long_name ="";
	String physical_form ="";			String concentration_percent="";
	String manufacturer_var_percentage =""; String eff_status="E";
	String disableAll="";
	String conc_percent = "";
	String const_generic_desc="";
	String generic_code="";
	ArrayList arr_list_modify_data = new ArrayList();
	//added for ml-mmoh-crf-1201 start
	Connection connection				= null;
	boolean site_moh=false;
		 try {
				connection						= ConnectionManager.getConnection(request);
		
				 site_moh=eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","APPLICABILITY_SETTINGS");
		 }
		 catch(Exception e) {
				out.print("Exception @ Result JSP :"+e.toString());
				e.printStackTrace();
			}
			finally{
				

				if(connection != null)
					ConnectionManager.returnConnection(connection,request);
			
			}
			//Added  for ml-mmoh-crf-1201 end
	String site_moh_YN="N";
	if(site_moh){
		site_moh_YN="Y";
	}
	else{
		site_moh_YN="N";
	}

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		const_generic_code	 = request.getParameter( "const_generic_code" ) ;
	//	const_srl_no		 = request.getParameter( "const_srl_no" ) ;
		conc_percent		 = request.getParameter( "conc_percent" ) ;
		if(conc_percent.equals("null")) {conc_percent="";}
/*
	for(int i=0;i<arr_list_generic.size();i=i+3){
	if (arr_list_generic.get(i).equals(const_generic_code.trim())) {
		generic_code=(String)arr_list_generic.get(i+2);
		}
	}
*/
		arr_list_modify_data = bean.getModifyData(const_generic_code,conc_percent,locale);
		if(arr_list_modify_data != null && arr_list_modify_data.size()!= 0){
		const_generic_desc=(String)arr_list_modify_data.get(1);
		const_short_name	 = (String)arr_list_modify_data.get(2);
		const_long_name		 = (String)arr_list_modify_data.get(3);
		physical_form		 = (String)arr_list_modify_data.get(4);
		concentration_percent= (String)arr_list_modify_data.get(5);
		if(concentration_percent==null)concentration_percent="";
		manufacturer_var_percentage = (String)arr_list_modify_data.get(6);
		if(manufacturer_var_percentage==null)manufacturer_var_percentage="";
		eff_status			=(String)arr_list_modify_data.get(7);
		if(eff_status.equals("D")){
			disableAll ="disabled";
		}
	} }
		bean.setLanguageId(locale);
%>																		   
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!-- onload="loadMolecule('<%=generic_code%>')" -->
<form name="frmTpnConstNsRegimenConsDetails" id="frmTpnConstNsRegimenConsDetails">
<table cellpadding="2" cellspacing="0" width="100%" align="left" border="0">
	<th colspan="2" align="left"><fmt:message key="ePH.TPNConstituents.label" bundle="${ph_labels}"/></th>
	<tr>
		<td align="left" class="label" width="40%"><fmt:message key="ePH.ConstituentGenericName.label" bundle="${ph_labels}"/></td>
		<td align="left" width="60%">&nbsp;
			<%
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			%>
				<input type="text" name="const_generic_desc" id="const_generic_desc" value="<%=const_generic_desc%>" disabled>
				<input type="hidden" name="const_generic_code" id="const_generic_code" value="<%=const_generic_code%>">
				<input type="hidden" name="const_srl_no" id="const_srl_no" value="<%=const_srl_no%>">
				<input type="hidden" name="generic_code" id="generic_code" value="<%=generic_code%>">
			<%
				}else{
			%>
			<select name="const_generic_code" id="const_generic_code"  onChange="showMolecule(this,'<%=const_generic_code%>','<%=const_srl_no%>','<%=mode%>')" >
				<option value="">----<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>----</option>
				<%  if(arr_list_generic!=null){
					for (int i=0;i<arr_list_generic.size();i=i+3){
				%>
				<option value="<%=arr_list_generic.get(i)%>"><%=arr_list_generic.get(i+1)%></option>				
				<%
					}	}			%>
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			<%
					for (int i=0;i<arr_list_generic.size();i=i+3){
			%>
			<input type="hidden" name="<%=arr_list_generic.get(i)%>" id="<%=arr_list_generic.get(i)%>" value="<%=arr_list_generic.get(i+2)%>">
			<%		}	

				}
			%>
			
		</td>
	</tr>
	<tr>
		<td align="left" class="label"><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<input type="text" name="const_short_name" id="const_short_name" value="<%=const_short_name%>" size="15" maxlength="15" <%=disableAll%>>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
	</tr>
	<tr>
		<td align="left" class="label"><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<input type="text" name="const_long_name" id="const_long_name" value="<%=const_long_name%>" size="30" maxlength="30" <%=disableAll%>>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
	</tr>
	<tr>
		<td align="left" class="label" ><fmt:message key="ePH.PhysicalForm.label" bundle="${ph_labels}"/></td>
		<td align="left">&nbsp;
			<select name="physical_form" id="physical_form"  <%=disableAll%>>
				<%
					String strLiquidSelect = "";
					String strSolidSelect = "";
					if(physical_form.equals("L")){
						strLiquidSelect ="selected";
					}else if(physical_form.equals("S")){
						strSolidSelect  ="selected";
					}
				%>
				
				<option value="L" <%=strLiquidSelect%>><fmt:message key="ePH.Liquid.label" bundle="${ph_labels}"/></option>
				<option value="S" <%=strSolidSelect%>><fmt:message key="ePH.Solid.label" bundle="${ph_labels}"/></option>
			</select>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
	</tr>
	<%if(!site_moh){//added for ml-mmoh-crf-1201 start %>
	 <tr><td align="left" class="label"><fmt:message key="ePH.Concentration.label" bundle="${ph_labels}"/></td><td>&nbsp;&nbsp;<input type="text"  name="concentration_percent" id="concentration_percent" value="<%=concentration_percent%>" maxlength="7" size="7" onKeyPress="return allowValidNumber(this,event,4,2);" onBlur="CheckNum(this)" <%=disableAll%>><b class="label"><fmt:message key="ePH.gm/100ML.label" bundle="${ph_labels}"/></b>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="conc_mand" style="visibility:hidden"></img></td>
	</tr>
	<%}//added for ml-mmoh-crf-1201 end %>
	
	<tr>
		<td align="left" class="label"><fmt:message key="ePH.VariancePercentageforManufacturing.label" bundle="${ph_labels}"/></td>
	<td align="left">&nbsp;
			<input type="text" name="manufacturer_var_percentage" id="manufacturer_var_percentage" value="<%=manufacturer_var_percentage%>" size="2" maxlength="1" onBlur="CheckNum(this)" <%=disableAll%>>
		</td>
	</tr>
	<tr>
		<td align="left" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;
			<%
				if(eff_status.equals("E")){
			%>
				<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
			<%
				}else{
			%>
				<input type="checkbox" name="eff_status" id="eff_status" value="E" >
			<%
				}
			%>
		</td>
	</tr>
</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="site_moh_YN" id="site_moh_YN" value="<%=site_moh_YN%>"><!--added for ml-mmoh-crf-1201 -->
	
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

