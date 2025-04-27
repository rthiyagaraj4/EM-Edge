<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
    <script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<!-- 	<script language="Javascript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../ePH/js/TpnUomConst.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String	bean_id		=	"TPNUOMConstBean" ;
	String	bean_name	=	"ePH.TPNUOMConstBean";
	TPNUOMConstBean bean= (TPNUOMConstBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear() ; 
	bean.setLanguageId(locale);
	Hashtable result = bean.energyloadInitialData1(locale);
	ArrayList arr_list_energy = (ArrayList)result.get("ENERGY");
	ArrayList arr_list_pres_base_unit = (ArrayList)result.get("PRES_BASE_UNIT");
	String	mode			=	request.getParameter( "mode" ) ;
		
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

	Hashtable ht_data_for_update =bean.loadDataForUpdate();
	ArrayList uom_parameters = (ArrayList)ht_data_for_update.get("uom_parameters");
	String max_weight="";
	String min_weight="";
	String expiry_period="";
	String itm_fluid_req_yn="";
	String ord_regmn="";
	String disabled="";
	
	if(uom_parameters.size()>0)
	{
	  max_weight=(String)uom_parameters.get(2);
	  if(max_weight==null)
		  max_weight="";
	  min_weight=(String)uom_parameters.get(3);
	   if(min_weight==null)
		  min_weight="";
	  expiry_period=(String)uom_parameters.get(4);
	   if(expiry_period==null)
		  expiry_period="";
	  itm_fluid_req_yn=(String)uom_parameters.get(5);
	  ord_regmn=(String)uom_parameters.get(6);
	  disabled="disabled";

	}

	String selected1="";
	String selected2="";
	String selected3="";

    if(ord_regmn.equals("B"))
	{
		selected3="selected";
	}
	else if(ord_regmn.equals("A"))
	{
		selected2="selected";
	}
	else if(ord_regmn.equals("W"))
	{
		selected1="selected";
	}
	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formTpnUomConstUOMParameters" id="formTpnUomConstUOMParameters" >
	<table cellpadding="0" cellspacing="0" width="100%" border="0">
		<tr>
			<th colspan="4" ><fmt:message key="ePH.TPNParameters.label" bundle="${ph_labels}"/></th>
	</tr>
		<tr>
			<th colspan="4"><b><fmt:message key="Common.UnitofMeasure.label" bundle="${common_labels}"/></b></th>
		</tr>
		<tr >
			<td class="label" style="border:none"><fmt:message key="ePH.Energy.label" bundle="${ph_labels}"/></td>
			<td  style="border:none">&nbsp;
				<select name="energy_unit" id="energy_unit" <%=disabled%> >

				<%
					
					for (int i=0;i<arr_list_energy.size();i=i+2){
						String strSelect = "";
						if(uom_parameters.size()>0 ){
							if(((String)uom_parameters.get(0)).equals(arr_list_energy.get(i))){
								strSelect = "selected";
							}
						}
				%>
					<option value="<%=arr_list_energy.get(i)%>" <%=strSelect%> > <%=arr_list_energy.get(i+1)%></option>
				<%
					}
				%>
				</select>
				
			</td>
			<td class="label"  style="border:none"><fmt:message key="ePH.PrescribingBaseUnitforRegimen.label" bundle="${ph_labels}"/></td>
			<td style="border:none">&nbsp;
				<select name="regimen_presc_base_unit" id="regimen_presc_base_unit" <%=disabled%> >
				
				<%
					for (int i=0;i<arr_list_pres_base_unit.size();i=i+2){
						String strSelect = "";
						if(uom_parameters.size()>0 ){
							if(((String)uom_parameters.get(1)).equals(arr_list_pres_base_unit.get(i))){
								strSelect = "selected";
							}
						}
						if(arr_list_pres_base_unit.get(i).equals("GM") || arr_list_pres_base_unit.get(i).equals("ML")
						||arr_list_pres_base_unit.get(i).equals("MCG")
						||arr_list_pres_base_unit.get(i).equals("NCG") ||arr_list_pres_base_unit.get(i).equals("MG") ||arr_list_pres_base_unit.get(i).equals("IU") ||arr_list_pres_base_unit.get(i).equals("MIU") ||arr_list_pres_base_unit.get(i).equals("UNIT") ||arr_list_pres_base_unit.get(i).equals("MEQT") ||arr_list_pres_base_unit.get(i).equals("MMOL") )
						{
					  %>
						<option value="<%=arr_list_pres_base_unit.get(i)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(i+1)%></option>
					  <%
					 	}
					}
				%>
				</select>
				
			</td>
		</tr>
<tr>
		<td class="label" style="border:none"><fmt:message key="ePH.OrderRegimenBy.label" bundle="${ph_labels}"/></td>
			<td style="border:none">&nbsp;
				<select name="order_regimen_by" id="order_regimen_by" >
				
				<option value="A" <%=selected2%>><fmt:message key="Common.age.label" bundle="${common_labels}"/></option>  
				<option value="W" <%=selected1%>><fmt:message key="Common.weight.label" bundle="${common_labels}"/></option>  
				<!-- <option value="B" <%=selected3%>>Both</option> -->
				</select></td>
				
	<td class="label">   
       <fmt:message key="ePH.SelectionofPreferredItemFluidApplicable.label" bundle="${ph_labels}"/>
    </td>
	<td >&nbsp;&nbsp;<input type="checkbox" name="itmfld_req_yn" id="itmfld_req_yn"  value="" onclick='assignVal(this)'></td>
</tr> 
		<tr>
<td  class="label">
<fmt:message key="ePH.Maximumweightforpediatricpatient.label" bundle="${ph_labels}"/>
</td>
<td >&nbsp;&nbsp;<input type="text" name="max_weight" id="max_weight" maxLength=3 size=5  value="<%=max_weight%>" onKeyPress="return(ChkNumberInput(this,event,0)); " onBlur="checkforZero(this);" >&nbsp;<LABEL class='label'><fmt:message key="Common.kg.label" bundle="${common_labels}"/></LABEL>
</td>
<td class="label"> 
<fmt:message key="ePH.Minimumweightforadultpatient.label" bundle="${ph_labels}"/>
</td>
<td >&nbsp;&nbsp;<input type="text" name="min_weight" id="min_weight" maxLength=3 size=5  value="<%=min_weight%>" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkforZero(this); checkRange(max_weight,this)">&nbsp;<LABEL class='label'><fmt:message key="Common.kg.label" bundle="${common_labels}"/></LABEL>
</td>
</tr>
<tr>
<td class="label"> 
<fmt:message key="ePH.ExpiryperiodforTPNadmixtures.label" bundle="${ph_labels}"/>
</td>
<td colspan='3'>&nbsp;&nbsp;<input type="text" name="exp_period" id="exp_period" maxLength=2 size=5  value="<%=expiry_period%>" onKeyPress="return(ChkNumberInput(this,event,0));">&nbsp;<LABEL class='label'><fmt:message key="Common.days.label" bundle="${common_labels}"/></LABEL> 
</td>
</tr>	  
	</table>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<tr  ><td class="label" style="color:red;font-size:13">&nbsp;&nbsp;<b>
		<fmt:message key="ePH.WarningChangesOnlyTPNRegimenorders.label" bundle="${ph_labels}"/></b></td>
		</tr>
	</table>	
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="item_fluid" id="item_fluid" value="<%= itm_fluid_req_yn %>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
<SCRIPT>
if(document.formTpnUomConstUOMParameters.item_fluid.value=="Y")
      document.formTpnUomConstUOMParameters.itmfld_req_yn.checked=true;
else
	 document.formTpnUomConstUOMParameters.itmfld_req_yn.checked=false;

    assignVal(document.formTpnUomConstUOMParameters.itmfld_req_yn);
</SCRIPT>
</html>

