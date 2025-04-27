<!DOCTYPE html>
 <%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>

<% 
		 request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

		String bean_id="@DrugDrugTypeBean";
		String bean_name="ePH.DrugDrugTypeBean";
		DrugDrugTypeBean bean			= (DrugDrugTypeBean)getBeanObject( bean_id, bean_name, request);
		 bean.setLanguageId(locale);
		bean.clear() ;
		String sql_select_drug_type = PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_SELECT1");

%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='JavaScript' src='../../eCommon/js/messages.js'></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<script language="JavaScript" src="../../ePH/js/DrugDrugType.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script>
			function focusObject(){
				document.forms[0].elements[0].focus();
			} 
			
			function addOrderByCol(){  
				var i=0;
				var from = document.getElementById("item")('orderbycols'); 
				if ( from.options.length > 0 ) {
					var to = document.getElementById("item")('orderbycolumns'); 
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value= from.options[from.selectedIndex].value; 
						to.add(element);      
						from.remove(from.selectedIndex);
						if(from.options[i])
							from.options[i].selected=true ;
						i++;
					}
				} 
			} 

			function removeOrderByCol(){
				var j=0;
				var from = document.getElementById("item")('orderbycolumns');
				if ( from.options.length > 0 ){ 
					var to = document.getElementById("item")('orderbycols');
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value = from.options[from.selectedIndex].value;
						to.add(element);    from.remove(from.selectedIndex);
						if(from.options[j]) 
							from.options[j].selected=true; 
						j++;
					}
				}
			}  

			function SelectAll(){
				var i = 0;
				document.getElementById("orderbycolumns").selectedIndex=0; 
				while ( i < document.getElementById("orderbycolumns").length) {
					document.getElementById("orderbycolumns").options[i].selected=true;
					i++; 
				}
			}  

			function execQuery(){
				if(document.getElementById("orderbycolumns").options.length >0 ){
					SelectAll(); 
					document.query_form.submit();
				}
				else{
					alert(getMessage('ORDERBY_NOT_BLANK'))
				}
			}
		</script>
	</head>

	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
		<form name='query_form' id='query_form' method='post' action='DrugDrugTypeQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0" >
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='35%' align='right'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
					</td>
					<td width='*%' >
						<input type='text' name='drug_desc' id='drug_desc' value='' size='60' maxlength='60'><input type="button" name="drug_search" id="drug_search" value="?" class="button"  onClick="queryDrugSearch(drug_desc,drug_code, this);">
						<input type='hidden' value='' name='drug_code' id='drug_code'>
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='35%' align='right' ><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/>
					</td>
					<td width='*' >
						<input type='text' name='drug_type_desc' id='drug_type_desc' value='' size='25' maxlength='100'><input type="button" name="drug_type_search" id="drug_type_search" value="?" class="button" onClick="drugTypeSearch(drug_type_desc,drug_code, this);">
						<input type='hidden' value='' name='drug_type_code' id='drug_type_code'>
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			</table>
			<br>
			<table width='98%' align='center' ><th width='20%' align='left' ><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
				<tr>
					<td width='60%' > 
					<p  title='Sort Order'>
					<table width='100%'align='center' ><td ><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						<td>&nbsp;</td><td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<tr>
							<td width='45%' align='center'>
								<select name='orderbycols' id='orderbycols' size='5' width='20'>
									<option value='drug_type'><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true' width='20'>
									<option value='drug_code'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
						</tr>
					</table>
					</p>
					</td>
				</tr>
			</table>
			<br>
			<table border='0' width='100%' align='center'>
				<tr>
					<td width='100%' align='center' class='white'>
						<input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'>
					</td>
				</tr>
			</table> 
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="sql_select_drug_type" id="sql_select_drug_type" value="<%= sql_select_drug_type %>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
		</form>
	</body>
</html>

