<!DOCTYPE html>
<html>
<head>
<title>Instruments</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String delInstr =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.InstructionCode.Label","ot_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Description.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script language='javascript'>
	function focusObject() {
		document.forms[0].elements[0].focus();
	}
	function addOrderByCol() {
		var i = 0;
		var from = document.getElementById('orderbycols');
		if (from.options.length > 0) {
			var to = document.getElementById('orderbycolumns');
			var element = document.createElement('OPTION');
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);
			from.remove(from.selectedIndex);
			if (from.options[i])
				from.options[i].selected = true;
			i++;
		}
	}
	function removeOrderByCol() {
		var j = 0;
		var from = document.getElementById('orderbycolumns');
		if (from.options.length > 0) {
			var to = document.getElementById('orderbycols');
			var element = document.createElement('OPTION');
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);
			from.remove(from.selectedIndex);
			if (from.options[j])
				from.options[j].selected = true;
			j++;
		}
	}
	function SelectAll() {
		var i = 0;
		document.getElementById("orderbycolumns").selectedIndex = 0;
		while (i < document.getElementById("orderbycolumns").length) {
			document.getElementById("orderbycolumns").options[i].selected = true;
			i++;
		}
	}
	function execQuery() {
		if (document.getElementById("orderbycolumns").options.length > 0) {
			SelectAll();
			document.query_form.submit();
		} else {
			alert(getMessage('ORDERBY_NOT_BLANK', 'Common'))
		}
	}
	function textAreaLimit(field, maxlen) {
		if (field.value.length > maxlen + 1)
		alert('Should not be more than  '+maxlen+" characters");
		if (field.value.length > maxlen)
		field.value = field.value.substring(0, maxlen);
	}

</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	onLoad='focusObject()'>
	<form name='query_form' id='query_form' method='post'
		action='../../eDS/jsp/DeliveryInstructionsQueryResult.jsp?ph_module_yn=null'
		onsubmit='SelectAll()'>
		<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<table width='100%' align='center' cellspacing='0' cellpadding='0'>
			<tr>
				<th align='left' width='20%'><%=queryCriteria %></th>
			<tr>
				<td width='60%'><p title='Query Criteria'>
					<table width='100%'>
						<tr>
							<td width='40%' class='label'><%=delInstr %></td>
							<td class='fields' width='60%'><input type=text
								name='del_Instr' id='del_Instr' size='4' maxlength='4'
								onBlur='makeValidQueryCriteria(this);'></td>
						</tr>
						<tr>
							<td width='40%' class='label'><%=longDesc %></td>
							<td>
							<textarea name="long_Desc" style="resize: none;"  rows="5" cols="60" onkeyup="textAreaLimit(this,100);"></textarea>
							</td>
						</tr>
						<tr>
							<td width='40%' class='label'><%=nature %></td>
							<td width='60%' class='fields'><select name='enabled_Yn' id='enabled_Yn'><option
										value='B'><%=both %></option>
									<option value='E'><%=enabled %></option>
									<option value='D'><%=disabled %></option></select>&nbsp;</td>
						</tr>
					</table></td>
			</tr>
		</table>
		</p>
		<table width='100%' align='center'>
			<th width='20%' align='left'><%=sortorder %>
			</td>
			<tr>
				<td width='60%'>
					<p title='Sort Order'>
					<table width='100%'>
						<td align='center'><b><%=comSelect %></td>
						<td>&nbsp;</td>
						<td align='center'><b><%=orderby %></td>
						<tr>
							<td width='45%' align='center'><select name='orderbycols' id='orderbycols'
								size='5'><option value='long_desc'><%=longDesc %></option>
									<option value='eff_status'><%=nature %></option></select></td>
							<td align='center' width='3%'><input type='button'
								name='add' id='add' class='button' onclick='addOrderByCol()'
								value='---->'> <input type='button' name='add' id='add'
								class='button' value='<----' onclick='removeOrderByCol()'></img></td>
							<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns'
								size='5' multiple='true'><option value='instr_code'><%=delInstr %></option></select></td>
						</tr>
					</table>
					</p>
				</td>
			</tr>
		</table>
		<br>
		<table border='0' width='100%' align='center'>
			<tr>
				<td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'
					onclick='execQuery()'></td>
			</tr>
		</table>
		<script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>
	</form>
</body>
</html>

