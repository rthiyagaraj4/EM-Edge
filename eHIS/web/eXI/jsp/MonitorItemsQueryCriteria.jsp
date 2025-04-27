<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eXI.MonitorItemsBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>						  
<% 
	request.setCharacterEncoding("UTF-8");	
	HashMap<String,String> domainMap = MonitorItemsBean.getDomainList();
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String moduleID = request.getParameter("moduleID");
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'></link> 

<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>	
<script language="javascript" src="../../eXI/js/MonitorItems.js" ></script>
<script Language="javascript" src="../../eXH/js/jquery-1.7.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="SchemaDefValues" id="SchemaDefValues" method="GET">
<fieldset style=" border-color:grey;">
	<table id='tblHeader'>
	<tr><tr/>
	<tr align="center">														   
		<td class='label' COLSPAN=1>
			<fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/> 
		</td>
		<td class='field' COLSPAN=1>
			<select name='interfaceDomain' id='interfaceDomain' id="interfaceDomain" onChange='moduleChange()'>
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${xh_labels}"/>-----</option>
			<%
				String selected = "";
				Set<String> domainIDSet = domainMap.keySet();				
				for(Object domainID : domainIDSet)
				{
					if("XI".equals(domainID)) selected = "SELECTED";
					else selected = "";
			%>
			<option value="<%=domainID%>" <%= selected %>> <%= domainMap.get((String)domainID) %> </option>
			<%}%>	
			</select>			
		</td>		
		<td class='label' COLSPAN=1><fmt:message key="Common.Function.label" bundle="${xh_labels}"/></td>
		<td class='field' COLSPAN=1>
			<input type='text' name='functionName' id='functionName' id="functionName" onblur='searchMonItemsFunc(functionName)' SIZE="25">
			<input type='hidden' name='funcID' id='funcID' id="funcID">
			<input class='BUTTON' type='button' name='searchMonItemsFunc()' id='searchMonItemsFunc()' value='?' onClick="searchMonItemsFunc(functionName);">
		</td>
		<td class='label' COLSPAN=1><fmt:message key="eXH.QueueType.Label" bundle="${xh_labels}"/></td>
		<td class='field' COLSPAN=1>
			<select id="queueType" name="queueType" id="queueType" style="width: 150px">
				<option value="ONLINE"><fmt:message key="eXH.Online.Label" bundle="${xh_labels}"/></option>
				<option value="OFFLINE"><fmt:message key="eXH.Offline.Label" bundle="${xh_labels}"/></option>
				<option value="PURGE"><fmt:message key="eXH.Purge.Label" bundle="${xh_labels}"/></option>				
				<option value="CONSOLIDATE">Consolidate</option>
			</select>
		</td>
		<td COLSPAN=2>&nbsp;</td><td COLSPAN=2>&nbsp;</td>
	</tr>
	</table>
	</fieldset>
	
<!--
<input type='button' value='Download' onclick='getExcelBook()' title='Download excel' background='../../eCA/images/serachImg.JPG'>	
-->

	<table id='upload_id' style="display:none;">
		<td class=label><fmt:message key="eXH.ChooseXLSFile.Label" bundle="${xh_labels}"/></td>
		<td class="fields">
			<INPUT TYPE="file" name="upload_text" id="upload_text" id="upload_text" >&nbsp;&nbsp;
			<INPUT type='button' id='btnUpload' value='Go' onclick='doUpload();'>
		</td>
	</table>
	 <INPUT TYPE="hidden" id="operation" name="operation" id="operation" value="">
	</form>
</body>
</html>

