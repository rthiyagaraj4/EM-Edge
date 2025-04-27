<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
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
	
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../ePH/js/TpnConsNsRegimen.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
/* Mandatory checks start */
	String mode		= request.getParameter( "mode" ) ;
	String bean_id	= "TPNConsNSRegimenBean" ;
	String bean_name= "ePH.TPNConsNSRegimenBean";
	String diableButton		=	"";
	String con_generic_code =	"";
	String molecule_code =	"";
	//added for ml-mmoh-crf-1201 start
	
	Connection connection				= null;
	boolean site_moh =false;
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
	//added for ml-mmoh-crf-1201  end
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	TPNConsNSRegimenBean bean = (TPNConsNSRegimenBean)getBeanObject( bean_id,bean_name,request);
	Hashtable result = bean.getInitialValues(locale);
	ArrayList arr_list_generic = (ArrayList)result.get("arr_list_generic");
	ArrayList arr_list_molecule = (ArrayList)result.get("arr_list_molecule");
	String group_code = request.getParameter("group_code");
	String generic_code = request.getParameter("const_generic_code");
	

	String style="visibility:hidden";
	if(group_code == null)group_code="";
//	if((group_code.trim()).equals("EL") || (group_code.trim()).equals("MN")) {
	if((group_code.trim()).equals("EL")) {
		style="visibility:visible";
	}
if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
	for(int i=0;i<arr_list_generic.size();i=i+3){
	if (arr_list_generic.get(i).equals(generic_code.trim())) {
		con_generic_code=(String)arr_list_generic.get(i+2);
		}
	  }
if((con_generic_code.trim()).equals("EL")) {
		style="visibility:visible";
	}
	}

	bean.setLanguageId(locale);
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="disbleBtn()">
<form name="frmTpnConstNsRegimenButtons" id="frmTpnConstNsRegimenButtons">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" align="right">
			<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
		</td>
		<td class="label" align="left">
			&nbsp;&nbsp;<input type="text" name="item_code" id="item_code" value="" readOnly><input type="button" name="btnItemLookup" id="btnItemLookup" value="?" class="button" onClick="populateItemLookup(item_code)">
			<input type="hidden" name="item_desc" id="item_desc" value="">
		</td>
		<td class="label" align="right"><div id="molculeVisble">
			<label id="lbl_molecule" style="<%=style%>"><fmt:message key="ePH.Molecule.label" bundle="${ph_labels}"/></label>
		</td></div>
		<td class="label" align="left"><div id="molculeVisble2">
			&nbsp;&nbsp; 
			<select name="molecule" id="molecule" style="<%=style%>">
				<%
					for (int i=0;i<arr_list_molecule.size();i=i+2){
				%>
					<option value="<%=arr_list_molecule.get(i)%>"><%=arr_list_molecule.get(i+1)%>
					
					</option>
				<%
					molecule_code=(String)arr_list_molecule.get(i);
					}
				%>
			</select>
		</td></div>  
		<td class="label" align="right" colspan="2"><fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;<INPUT TYPE="text" name="osmolar_value" id="osmolar_value" size="3" maxlength="5" onKeyPress="return(ChkNumberInput(this,event,'1'))">&nbsp;<b><fmt:message key="ePH.mOsmol/L.label" bundle="${ph_labels}"/></b></td><td>&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td align="left" class="label">&nbsp;<b><label id="lbl_item_desc" name="lbl_item_desc"></label></b></td>
		<td align="right" class="label"><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></td>
		<td class="label" align="left">&nbsp;&nbsp;<b><label id="lbl_sale_uom_desc" name="lbl_sale_uom_desc"></label></b></td>
		<input type="hidden" name="content_in_pres_base_uom" id="content_in_pres_base_uom" value="">
		<td class="label" align="left" colspan="2"><b><fmt:message key="ePH.ContentinPresBaseUOM.label" bundle="${ph_labels}"/>: </b><label id="lbl_content_in_pres_base_uom"> </label></td><td>&nbsp;&nbsp;</td>
	</tr>
	<!-- Adding start for ML-MMOH-CRF-1201 -->
<%if(site_moh){//added for ml-mmoh-crf-1201 start %>

	<tr> 
		<td align="right" class="label"><fmt:message key="ePH.Concentration.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;<input type="text"  name="item_concentration" id="item_concentration" value="" maxlength="7" size="7" onKeyPress="return allowValidNumber(this,event,4,2);" onBlur="CheckNum(this)" >&nbsp;<b class="label"><fmt:message key="ePH.%/mmol.label" bundle="${ph_labels}"/></b></td>
		<td align="right" class="label"><fmt:message key="Common.volume.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  name="volume" id="volume" value="" maxlength="7" size="7" onKeyPress="return allowValidNumber(this,event,4,2);" onBlur="CheckNum(this)" ><b class="label">&nbsp;<fmt:message key="ePH.ml.label" bundle="${ph_labels}"/></b></td>
		<td class="label"><b><a href="javascript:applicibilitySetting(frmTpnConstNsRegimenButtons.item_code)" title='Applicibility_Setting' name="applicibility_setting"><fmt:message key="ePH.ApplicibilitySetting.label" bundle="${ph_labels}"/></a></b></td>
       
	</tr>
	<%}else{ %>
	<tr>
		<td class="label" colspan="7">&nbsp;</td>
		</tr>
	<%}//added for ml-mmoh-crf-1201 end %>
	
	
	<tr>
		<td align="right" class="white" colspan="4"><div id="updBtn">
			<input type="button" name="btnUpdate" id="btnUpdate" class="button" value='<fmt:message key="Common.Update.label" bundle="${common_labels}"/>' onClick="updateItems()"></div>
		</td>
		<td align="left" class="white" colspan="2">
			<input type="button" name="btnAdd" id="btnAdd" class="button"   value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'   onClick="addItemDetails()">
			<input type="button" name="btnReset" id="btnReset" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="clearAll()">		
		</td>
	</tr>
</table>
	<input type="hidden" name="SQL_PH_TPN_CONS_NS_REGIMEN_SELECT3" id="SQL_PH_TPN_CONS_NS_REGIMEN_SELECT3" value="<%=PhRepository.getPhKeyValue("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT3")%>">
	<input type="hidden" name="delete_row" id="delete_row" value="">	
	<input type="hidden" name="generic_code" id="generic_code" value="<%=generic_code%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="molecule_code" id="molecule_code" value="<%=molecule_code%>">
	<input type="hidden" name="site_moh_YN" id="site_moh_YN" value="<%=site_moh_YN%>"><!-- added for ml-mmoh-crf-1201 -->
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>
<%
	if(!(group_code.trim()).equals("EL")){
%>
	<script language="javascript">
		document.getElementById("molecule").value="";
	</script>
<%
	}
%>

