<%@ page  import="eST.ScheduleAutoRequestBean" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>

<% 
		 request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";


		String bean_id="scheduleAutoRequestBean";
		String bean_name="eST.ScheduleAutoRequestBean";
		ScheduleAutoRequestBean bean			= (ScheduleAutoRequestBean)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);
		bean.clear() ;
				
%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<script language="JavaScript" src="../../eST/js/ScheduleAutoRequest.js"></script>
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
		<form name='query_form' id='query_form' method='post' action='ScheduleAutoRequestQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0" >
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  ><fmt:message key="eST.ScheduleCode.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
						<input type='text' name='schdule_code' id='schdule_code' value="" size='12' maxlength='10' class="UPPER" >
						</td>
					</tr>
					<tr>
					<td class='label' nowrap ><fmt:message key="eST.SchduleDescription.label" bundle="${st_labels}"/>&nbsp;

					<input type='text' name='schdule_desc' id='schdule_desc' value="" size='60' maxlength='60' >
					</td>
					</tr>
					<tr>
					<td class=label ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='req_by_store_desc' id='req_by_store_desc' value="" size="30" readonly><input type="button" name="req_code" id="req_code" value="?" class="button" onClick="requestByStoreLookup(req_by_store_desc);">
					</tr>
					<input type="hidden" name="requisition_by_store" id="requisition_by_store" value="">
					<tr>
					<td class=label ><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='req_on_store_desc' id='req_on_store_desc' size="30" value="" readonly><input type="button" name="req_on_code" id="req_on_code" value="?" class="button" onClick="requestOnStoreLookup(req_on_store_desc,requisition_by_store);">
					</tr>
					</td>
				</tr>
				<input type="hidden" name="requisition_on_store" id="requisition_on_store" value="">
				<tr>
                   <td class="label" width="10%">
				  <fmt:message key="Common.status.label" bundle="${common_labels}"/> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="status" id="status"  >
				<OPTION value=" " ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="E" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="D" ><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
				</SELECT>    
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
									<option value='schdule_desc'>                                 
									<fmt:message key="eST.SchduleDescription.label" bundle="${st_labels}"/>	&nbsp;&nbsp;&nbsp;&nbsp;</option>
									</select>
							</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true' width='20'>
									<option value='schdule_code'><fmt:message key="eST.ScheduleCode.label" bundle="${st_labels}"/>
									 </option>
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
			<input type="hidden" name="user_id" id="user_id" value="<%= (String) session.getValue( "login_user" ) %>">
			<input type="hidden"   name="SQL_SCHDULE_AUTO_STORE_LOOKUP" id="SQL_SCHDULE_AUTO_STORE_LOOKUP" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_SCHDULE_AUTO_STORE_LOOKUP")%>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
		</form>
	</body>
</html>

