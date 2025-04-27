<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.lang.*, ePH.*, ePH.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
	try{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mode = request.getParameter("mode")==null?"1":request.getParameter("mode");
	String formulary_code = request.getParameter("formulary_code")==null?"":request.getParameter("formulary_code");
	String formulary_desc = request.getParameter("formulary_desc")==null?"":request.getParameter("formulary_desc");
	String formulary_type = request.getParameter("formulary_type")==null?"":request.getParameter("formulary_type");
	String called_from    = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String enable_status = request.getParameter("enable_status")==null?"D":request.getParameter("enable_status");
	//System.err.println("mode===>"+request.getParameter("mode")+"==formulary_code===>"+formulary_code);
	String disabled = "";

	if(called_from.equals("modify")){
		disabled = "disabled";
	}


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<style>

.billing
{
    overflow-y:auto;
	height: 100px;
	width: 250px;
}
.drugresult
{
    overflow-y:auto;
	height: 240px;
	width: 1320px;
}
.drugsearch
{

    overflow-y:auto;
	height: 170px;
	width: 1320px;
}
::placeholder {
  color: blue;
  opacity: 1; /* Firefox */
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
 color: green;
}

::-ms-input-placeholder { /* Microsoft Edge */
 color: red;
}


.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: inline-block;
  min-width: 100px;
  height: 100px;
  overflow-y:auto;
  border: 1px solid #ddd;
}

.dropdown-content a {
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}

</style>

	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
		
	
	
	String bean_id					=		"ItemMasterBean" ;
	String bean_name				=		"eMM.ItemMasterBean";
	ItemMasterBean bean				=		(ItemMasterBean)getBeanObject( bean_id,bean_name,request ) ;
	
	//ArrayList genericName		= new ArrayList();
	ArrayList itemlist		= null;
	
	
	String	bean_id_1					=	"FormularyBillingGroupBean" ;
	String	bean_name_1					=	"ePH.FormularyBillingGroupBean";
	FormularyBillingGroupBean bean_1			= (FormularyBillingGroupBean)getBeanObject( bean_id_1, bean_name_1,request);
	bean_1.setLanguageId(locale);
	bean_1.clear();
	bean_1.setMode(mode);
	bean_1.getNoOfDecimalsCost();
	//itemlist   = (ArrayList)bean_1.getItemListForGenericName("IC");
	if(called_from.equals("modify"))
	bean_1.getFormularyDetail(formulary_code);
	
	HashMap itemList= bean_1.getSelectedGenericID();
	bean_1.setFormularyDesc(formulary_desc);
//	ArrayList genericItemType = bean_1.getItemGenericType();
	String cash_selected="";
	String credit_selected="";
    String enabled = "";
	if(!formulary_type.equals("")){
		if(formulary_type.equals("C")){
			cash_selected = "selected";
			credit_selected = "";
		}else{
			credit_selected="selected";
			cash_selected   = "";
		}
		bean_1.setBillingType(formulary_type);
    }else{
	   bean_1.setBillingType("C");
    }

	if(enable_status.equals("E"))
		enabled="checked";
	else
		enabled="";

if(formulary_code.equals(""))
	enabled="checked";


%>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/FormularyMast.js"></SCRIPT>
	
	<!-- <script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</HEAD>
<body TOPMARGIN="0" onMouseDown="" onKeyDown="lockKey()">
<FORM name="formulary_drug_search" id="formulary_drug_search" >

 
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
		<tr>
			<TD ALIGN="right" WIDTH="25%" CLASS="label" nowrap><fmt:message key="ePH.FormularyCode.label" bundle="${ph_labels}"/></td>
	    	<td align="left" width="12%">
			&nbsp;<INPUT TYPE="text" align="left" CLASS="UPPER" onBlur="toUpper(this);FormularyCodeCheck(this);checkDuplicate(this)"  onKeyPress="return CheckForSpecChars( event );" name="formulary_code" id="formulary_code" value="<%=formulary_code%>" <%=disabled%> MAXLENGTH="20" SIZE="20" id="formularycode">
			<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
			
		
			<TD ALIGN="right" WIDTH="25%" CLASS="label" nowrap><fmt:message key="ePH.FormularyType.label" bundle="${ph_labels}"/> &nbsp;
		      	 
				<SELECT name="billing_type" id="billing_type"  align="left"   <%=disabled%> onchange="getBillingType(this)">
					<option value="C" <%=cash_selected%>><fmt:message key="Common.Cash.label" bundle="${common_labels}"/></option>
					<option value="R" <%=credit_selected%>><fmt:message key="Common.Credit.label" bundle="${common_labels}"/></option>

				</SELECT>
				</td>
					
		</tr>
		<TR>	
			<TD ALIGN="right" WIDTH="30%" CLASS="label" nowrap><fmt:message key="ePH.FormularyDescription.label" bundle="${ph_labels}"/></td>
			<td align="left" width="12%" nowrap>
			&nbsp;<INPUT TYPE="text"  name="formulary_desc" id="formulary_desc" MAXLENGTH="60" SIZE="60" value="<%=formulary_desc%>"  id="formulary_desc">
			<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
						
<%				
						String span_visible_cash = "visibility:visible";	
						String span_visible_credit = "visibility:none";	
						
						ArrayList blg_group = bean_1.getBillingGroup();
						ArrayList selected_blg_grp= bean_1.getselectedFormularyBLGId();
						
						 

%>		
			
		   
	   <td  rowspan="4" align="left" width="20%" CLASS="label" id="bill_grp_cash" style="<%=span_visible_cash%>">
		<fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/><br>
		<input type="text"  size="80" id="myInput"  onkeyup="filterFunction()">
		<div id="myDropdown" class="dropdown-content">


	  <%
	  int blng_grp_cunt = 0;
	  if(blg_group!=null && blg_group.size()>0){
			   String blg_group_id = "";
			   String blg_group_desc = "";
			   String checked = "";
			   String bl_grp_disabled = "";
				ArrayList otherBlgGrpId= bean_1.getOtherFormularyBlngGrpId();
		
			   for(int i=0;i<blg_group.size();i=i+2){
				   bl_grp_disabled = "";
				   checked = "";
				   blg_group_id = (String)blg_group.get(i);
				   blg_group_desc = (String)blg_group.get(i+1);
					if(selected_blg_grp!=null && selected_blg_grp.size()>0){
						if(selected_blg_grp.contains(blg_group_id)){
							checked = "checked";
						}else{
							checked = "";
						}							 
					}
					if(otherBlgGrpId!=null && otherBlgGrpId.size()>0){
						 if(otherBlgGrpId.contains(blg_group_id))
							 bl_grp_disabled = "disabled";
					}
					if(checked.equals("checked"))
						bl_grp_disabled = "";
	   %>
		<a><input type="checkbox" name="Billing_group_<%=blng_grp_cunt%>" id="Billing_group_<%=blng_grp_cunt%>" <%=checked%> <%=bl_grp_disabled%> value="<%=blg_group_id%>" onclick="saveBlgGroupID(this)"> <%=blg_group_desc%></a>  
	    	    
		<% blng_grp_cunt++;	
		   }
		}
	   %>
	    
	    </div>
	    </td>
	    
	    
	    
	    
		</TR>
		
		<tr>
			<TD ALIGN="right" WIDTH="25%" CLASS="label" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
			<td align="left" class="label" >
			<SELECT name="item_type" id="item_type" onchange="getItemType(this)" style="width: 130px;">
			<OPTION VALUE="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
			<OPTION VALUE="M"><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></option>
					</select><img align="center" src="../../eCommon/images/mandatory.gif"></img></td></tr>
					
		        <tr>
					        <td align="left" class="label" width="33%" id=item_generic_name  style="<%=span_visible_cash%>">
					        <fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>
						 	<INPUT TYPE="text" name="generic_name" id="generic_name" SIZE="26" id="generic_name">
							<INPUT TYPE="hidden" name="generic_id" id="generic_id" value = "">
							<input type="button" class='BUTTON' value="?" onclick="searchGenericName(generic_id,generic_name)">
							 </td> 
						
							<td align="left" class="label" width="33%" id=drug_form_name  style="<%=span_visible_cash%>">
							<fmt:message key="ePH.FormName.label" bundle="${ph_labels}"/>
							<select name="form_name" id="form_name" onchange="changeForm(this);" style="width: 130px;">
 							<option value="">---select---</option>
							  </select><img align="center" src="../../eCommon/images/mandatory.gif"></img>
							&nbsp;&nbsp;&nbsp;
							<fmt:message key="Common.Strength.label" bundle="${common_labels}"/>
							<select name="strength" id="strength" onchange="changeStrength(this);" style="width: 130px;">
							<option value="">---select---</option>
 							  </select> &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
							  <input type="hidden" name="strength_value" id="strength_value" value=""> 
							</td>
									
							<td align="left" class="label" width="33%" id=item_tech_name style="display:none">
					        <fmt:message key="ePH.ItemTechnicalName.label" bundle="${ph_labels}"/>
					        <input type='text' id="item_tech_desc" name="item_tech_desc" id="item_tech_desc" value="" maxLength='15' size='26'  > 
							<input type='button' class='BUTTON' value='?' onClick="searchItemTech(item_tech_code,item_tech_desc);"> 
						    <input type="hidden" name="item_tech_code" id="item_tech_code" value=""> 
						   	</td>		
				</tr>
				<tr></tr>
	
		<tr>		
			<td align="right" class="label" WIDTH="25%" nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;&nbsp;
			<input type="checkbox"  value="<%=enable_status%>" name="enable_status" id="enable_status" <%=enabled%>></td> 
			
<td align="right" colspan="5" class="white"><input type="button" VALUE='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="getItemSearchList()">&nbsp;&nbsp;&nbsp;
			</td>
			 
		</tr>
</table>

<script>
  <%
	  if(called_from.equals("modify")){ %>
		
		getItemSearchList('<%=called_from%>');
<%	}
  %> 
	  </script>
  
<input type="hidden" name="SQL_MM_ITEM_TECH_NAME" id="SQL_MM_ITEM_TECH_NAME" value="select item_tech_name_code code,short_desc description from mm_item_tech_name_lang_vw where item_tech_name_code like upper(?) and upper(short_desc) like upper(?) AND EFF_STATUS= 'Y' AND language_id =">
<input type="hidden" name="SQL_PH_DRUG_SEARCH_GENERIC" id="SQL_PH_DRUG_SEARCH_GENERIC" value="SELECT  GENERIC_ID  code,  GENERIC_NAME  description  FROM  PH_GENERIC_NAME_LANG_VW  PH_GENERIC_NAME    WHERE   UPPER(GENERIC_ID)  LIKE  UPPER(?)  AND  UPPER(GENERIC_NAME)  LIKE  UPPER(?) AND EFF_STATUS= 'E' AND LANGUAGE_ID =">
<input type="hidden" name="language_id" id="language_id" value="<%=locale %>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id_1%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_1%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="formulary_apply_proceed" id="formulary_apply_proceed" value="">
<input type="hidden" name="blng_grp_mand" id="blng_grp_mand" value="">
<input type="hidden" name="blng_grp_cunt" id="blng_grp_cunt" value="<%=blng_grp_cunt%>">
<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">




 	   <%
		putObjectInBean(bean_id_1,bean_1,request);   
	   }catch(Exception e){
		   e.printStackTrace();
	   } %>
	  </FORM>
</body>
</HTML>



