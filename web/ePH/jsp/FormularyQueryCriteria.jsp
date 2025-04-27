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


		String bean_id="@StoreForLocationBean";
		String bean_name="ePH.StoreForLocationBean";
		StoreForLocationBean bean			= (StoreForLocationBean)getBeanObject( bean_id, bean_name, request);
		 bean.setLanguageId(locale);
		bean.clear() ;

%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='JavaScript' src='../../eCommon/js/messages.js'></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<script language="JavaScript" src="../../ePH/js/FormularyMast.js"></script>
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
					document.formulary_query_form.submit();
				}
				else{
				alert(getMessage('ORDERBY_NOT_BLANK','Common'))
				}
			}
		</script>
	</head>

	<body onMouseDown="" onKeyDown="lockKey()">
		<form name='formulary_query_form' id='formulary_query_form' method='post' action='FormularyQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0" >
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='35%' align='right'>			
					<fmt:message key="ePH.FormularyCode.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;
					</td>
					<td width='*%' >
						<input type='text' name='formulary_code' id='formulary_code' value="" size='20' maxlength='20'>
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
<tr>
					<td class='label' width='35%' align='right'>			
					<fmt:message key="ePH.FormularyDescription.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;
					</td>
					<td width='*%' >
						<input type='text' name='formulary_desc' id='formulary_desc' value="" size='60' maxlength='60'>
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
					<tr>
                   <td class="label" width="10%">
				   <fmt:message key="ePH.FormularyType.label" bundle="${ph_labels}"/> &nbsp; </td>
				  
				  <td class="data" >
		<SELECT name="formulary_type" id="formulary_type">
					<option value="C"><fmt:message key="Common.Cash.label" bundle="${common_labels}"/></option>
					<option value="R"><fmt:message key="Common.Credit.label" bundle="${common_labels}"/></option>		
					<option value="X" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>		
					</SELECT>   

</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td> 
				</tr>
				<tr>
					<td class='label' width='35%' align='right' > <fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/>
					</td>
					<td width='*' >
						<input type='text' name='blg_grp' id='blg_grp' value='' size='25' maxlength='100' readonly>&nbsp;<input type="button" name="blg_grp_search" id="blg_grp_search" value="?" class="button"   onClick="billingGroupsearch(blg_grp_code,blg_grp);">
						<input type='hidden' value='' name="blg_grp_code" id="blg_grp_code">
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
				<td align="right" class="label" > 
						<fmt:message key="Common.Nature.label" bundle="${common_labels}"/>		
					</td>
					<td class="label">
					<select name='nature' id='nature' size='1' >
					 <option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					 <option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					 <option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					 </select> 
					</td >
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
									
									<option value='formulary_desc'>                                     
									 <fmt:message key="ePH.FormularyDescription.label" bundle="${ph_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true' width='20'>
									<option value='formulary_code'>
									 <fmt:message key="ePH.FormularyCode.label" bundle="${ph_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
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
			<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
			<input type="hidden" name="SQL_PH_BILLING_GRP_SEARCH" id="SQL_PH_BILLING_GRP_SEARCH" value="select BLNG_GRP_ID,short_desc from bl_blng_grp WHERE BLNG_GRP_ID LIKE UPPER(?) AND Upper(SHORT_DESC) like upper(?)">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
		</form>
	</body>
</html>

