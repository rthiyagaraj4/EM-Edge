<%@ page import ="java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>

<% 
		 request.setCharacterEncoding("UTF-8");
	
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		 <script language="javascript" src="../../eST/js/StCommon.js"></script>
	    <script language="javascript" src="../../eST/js/DisposableAdjustment.js"></script>
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
				alert(getMessage('ORDERBY_NOT_BLANK','Common'))
				}
			}
		</script>
	</head>

	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
		<form name='query_form' id='query_form' method='post' action='DisposableAdjustmentQueryResult.jsp' >
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0" >
				<tr>
					<td class='label' width='20%'   align='left' >       
					<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>&nbsp;&nbsp;&nbsp;
				<td width='*' >	<input type='text' name='store_code' id='store_code' value="" size='8' maxlength='8' >
				</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label' width='20%'   align='left' >       
					<fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></td>&nbsp;&nbsp;&nbsp;
				<td width='*' >	<input type='text' name='store_desc' id='store_desc' value="" size='15' maxlength='15' >
				</td>
				</tr>
				
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			     <tr>
			     <td class='label' width='20%'   align='left' >       
				 <fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>&nbsp;&nbsp;&nbsp;
				<td width='*' >	<input type='text' name='next_batch_id' id='next_batch_id' value="" size='8' maxlength='8' onkeypress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);">
				</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
				<td class='label' width='20%'     align='left'>    
				   <fmt:message key="Common.Nature.label" bundle="${common_labels}"/> </td>&nbsp;&nbsp;&nbsp;<td width='*' >
			 <SELECT name="eff_status" id="eff_status"  >
			<OPTION value="%" >   <fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="E" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="D" ><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
				</SELECT>   
				</td>
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
								<option value='next_batch_id'>
									<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
									<option value='store_desc'>
									<fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true' width='20'>
									<option value='store_code'>
									<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>
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
	
		</form>
	</body>
</html>

