<!DOCTYPE html>
<%@ page import ="eMM.*, eMM.Common.*,eCommon.Common.*,java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eMM/js/ItemMaster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style type='text/css'>
	select{
		width:145px;
	}
	</style>
</head>
<%
//	java.util.HashMap defaultParameter = null;
	String bean_id = "ItemMasterQueryBean";
	String bean_name = "eMM.ItemMasterQueryBean";
	String flag = request.getParameter("flag");
	ItemMasterQueryBean bean = (ItemMasterQueryBean) getBeanObject( bean_id,bean_name,request);  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	String search_string=CommonBean.checkForNull(request.getParameter("search_string"),"");

	//System.out.println("Qcrieteria page"+flag); 
%>

<body onload='FocusFirstElement();<%=(bean.getSearch_string().equals(""))?"":"searchVals();"%>' >

	<form name="ItemMasterCriteria_Form" id="ItemMasterCriteria_Form" >
		<table border="" cellpadding="0" cellspacing="0" width='100%' align=center>
			<form name="searchform" id="searchform" onSubmit= 'return submitPage();' >
       		<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
			<th   colspan=6  align=left>
			<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
			<tr>
					<td class='fields'>
					<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
					</td>
					<td></td>
					<td class='LABEL'   >
					<fmt:message key="eMM.CategoryType.label" bundle="${mm_labels}"/></td>
					<td  class=fields width="15%">&nbsp;<select name='category' id='category' value = 'Inventory 'accesskey='Y' Disabled ><%=bean.getCategoryList()%></select></td>
					<td class='LABEL'    nowrap > 
					<fmt:message key="Common.SpecialItem.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class=fields><select name='spl_item' id='spl_item'   accesskey='f' >
<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
					</td>
				</tr>
				<tr>
					<td class='fields'>&nbsp;<input type='radio' checked name='searchby' id='searchby' accesskey='N' value='IC' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='radio'  name='searchby' id='searchby' value='IN' accesskey='T' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.ItemName.label" bundle="${common_labels}"/>&nbsp;
					<td class='LABEL'  >
					<fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields>&nbsp;<select name='sole_source' id='sole_source' accesskey='S'   >
<option value="A"  <%=bean.getsole_source().equals("A")?"Selected":""%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value="Y"<%=bean.getsole_source().equals("Y")?"Selected":""%>><fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/></option>
<option value="N"<%=bean.getsole_source().equals("N")?"Selected":""%>><fmt:message key="eST.NonSoleSource.label" bundle="${st_labels}"/></option></select>
					</td>
					<td class='LABEL'  >
					<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields><select name='item_class' id='item_class' accesskey='C'  ><%=bean.getItemClass()%></select>
					</td>
				</tr>
				<tr>
 
					<td class='fields' nowrap>&nbsp;<input type='radio'  name='searchby' id='searchby' value='IR' accesskey='A' onClick='storeVal(this.value);' nowrap>&nbsp;
					<fmt:message key="eMM.ItemRemarks.label" bundle="${mm_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class='fields' ><input type='radio'  accesskey='P' name='searchby' id='searchby' value='AC' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='LABEL'>
					<fmt:message key="eMM.PharmacyStockItem.label" bundle="${mm_labels}"/></td>
					<td class=fields >&nbsp;<select name='ps_item' id='ps_item' accesskey='I'  >
<option value="A"  <%=bean.getPs_item_yn().equals("A")?"Selected":""%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value="Y"<%=bean.getPs_item_yn().equals("Y")?"Selected":""%>><fmt:message key="eMM.PharmacyStockItem.label" bundle="${mm_labels}"/></option>
<option value="N"<%=bean.getPs_item_yn().equals("N")?"Selected":""%>><fmt:message key="eST.NonPSItems.label" bundle="${st_labels}"/></option>					
				    </select>
					</td>
					<td class='LABEL'>
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;1</td>
					<td class=fields><select name='item_analysis_1' id='item_analysis_1'  accesskey='1' ><%=bean.getItemAnalysis()%>
				  </select>
					</td>
				</tr>
				 <tr>
					<td class='fields'>&nbsp;<input type='radio'  name='searchby' id='searchby' value='TC' accesskey='T' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='radio' name='searchby' id='searchby' value='TN' onClick='storeVal(this.value);'>&nbsp;
					<fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class='LABEL'   >
					<fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;<select name='manufacturer' id='manufacturer' accesskey ='u' ><%=bean.getManufacturerList()%></select>
					</td>
					<td class='LABEL'  >
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;2</td>
					<td class=fields>
						<select name='item_analysis_2' id='item_analysis_2'  accesskey='2' ><%=bean.getItemAnalysis()%>
					</select>
					</td>
				</tr>
				<tr>
 
					<td class='LABEL'>
					&nbsp;&nbsp;</td><td class='LABEL' ></td>
					<td class='LABEL' >
					<fmt:message key="eMM.MaterialGroup.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;<select name='' id='' disabled>
					<option value="A">
					<fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				    </select>
					</td>
					<td class='LABEL'  >
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;3</td>
					<td class=fields><select name='item_analysis_3' id='item_analysis_3' accesskey='3'><%=bean.getItemAnalysis()%>
				    </select>
					</td>
				</tr>
				<tr>
				<td class='label'  nowrap Colspan = 2>
				<fmt:message key="eMM.SearchString.label" bundle="${mm_labels}"/>&nbsp;&nbsp;
				<input type='text' name='search_string' id='search_string'  size=35 maxlength=40   value=<%=search_string%>></td> 
				<td class='LABEL'  nowrap>
					<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;<select name='search_criteria' id='search_criteria'>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>	
				    </select>
					</td>
					<td class='LABEL'  >
					<fmt:message key="Common.Nature.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields><select name='enabled_Yn' id='enabled_Yn'  accesskey='1' >
<option value="A"  <%=bean.getEff_status().equals("A")?"Selected":""%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value="E"<%=bean.getEff_status().equals("E")?"Selected":""%>><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
<option value="D"<%=bean.getEff_status().equals("D")?"Selected":""%>><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					
				</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align=center>
				<tr>
						<!-- <td class='label'  nowrap>Search String&nbsp;&nbsp;
							<input type='text' name='search_string' id='search_string'  size=35 maxlength=40   value=<%=search_string%>>
						</td>   -->
						<td  class=fields  colspan='4'>
							<input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'>
							<input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled>
							<input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'>
							<input type='hidden'  name='flag' id='flag'  value = "<%=flag%> ">
						</td>
				</tr>
						</td> 									
	</table>
</center>
</table>
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

