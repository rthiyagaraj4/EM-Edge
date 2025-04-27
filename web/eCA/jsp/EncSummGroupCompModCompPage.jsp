<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="Common.ComponentDefinition.label" bundle="${common_labels}"/></title>
	<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			String mode = "", groupFlag = "", groupType = "", groupCode = "", comp_flag = "", comp_type = "", comp_code = "", comp_desc = "", comp_temp_def = "", comp_column_type = "";
			
			String comp_col_count = "", comp_col_name = "";
			
			String es_xaxis_label = "", es_xaxis_datatype = "", es_yaxis_label = "", es_yaxis_datatype = "";
			
			String columnWidth1 = "40%"; 
			String columnWidth2 = "60%";
			
			int comp_temp_int = 0;
			
			EncSummGroup summGrpDetails = new EncSummGroup();			 	
			
			List<EncSummTemplateTypeBean> oTempTypeList = null;
			EncSummTemplateTypeBean sTempTypeBean = null;
			
			int ntypeListSize = 0;
			String oTempType = "";
			
			oTempTypeList = new ArrayList<EncSummTemplateTypeBean>();
			sTempTypeBean = new EncSummTemplateTypeBean();
			
			sTempTypeBean.setRequest(request);
			oTempTypeList = summGrpDetails.getTemplateType(sTempTypeBean);		
			
			ntypeListSize = oTempTypeList.size();
			if (ntypeListSize>0){
				for (int i=0;i<ntypeListSize;i++){
					sTempTypeBean = oTempTypeList.get(i);
					oTempType = oTempType + "<Option value="+sTempTypeBean.getsTemplateType()+">" +sTempTypeBean.getsTemplateDesc()+ "</option>";
				}
			}
			
			mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");	
			groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
			
			comp_flag = request.getParameter("compFlag") == null ? "" : request.getParameter("compFlag");
			comp_type = request.getParameter("compType") == null ? "" : request.getParameter("compType");	
			comp_code = request.getParameter("compId") == null ? "" : request.getParameter("compId");
			comp_desc = request.getParameter("compDesc") == null ? "" : request.getParameter("compDesc");
			comp_col_count = request.getParameter("compColumns") == null ? "" : request.getParameter("compColumns");
			comp_temp_def = request.getParameter("compTempDef") == null ? "" : request.getParameter("compTempDef");
			
			comp_temp_int = Integer.parseInt(request.getParameter("compTemplate"));
			
			comp_column_type = request.getParameter("compColumnType") == null ? "" : request.getParameter("compColumnType");
			
			String comptypecode[] = {"","D","E","N","I","T"};
			String comptypedesc[]={"&nbsp;------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------&nbsp;",
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels"), 
													com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")};
			
			   String sel	= "";
			
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>	
			var fields = 0;
	        function cancelParent() {	        	
	        	window.close();	        	
	        }	 
	        function saveComponents()
	        {	        	
	        	var tempValue = 0;
	        	var tableValue = "";
	        	var ColumnValue = "";
	        	var ColumnLabel = "";
	        	var LineChartValue = "";
	        	var colno = 0;
	        	
	        	var tableColumnCount = 0;
	        	
	        	var esXaxisLabel = "";
	        	var esXaxisDatatype = "";
	        	var esYaxisLabel = "";
	        	var esYaxisDatatype = "";	
	        	
	        	var tableTypeValue = "";
	        	var ColumnTypeValue = "";
	        	var ColumnTypeLabel = "";
	        	
	        	tempValue = document.getElementById("es_comp_template").value;
	        	
	        	//document.getElementById("es_table_details").value = "";
	        	//document.getElementById("es_LineChart_details").value = "";
	        	
	        	fields = 0;	        	
	        	
	        	if (tempValue == '2')
	        	{
	        		ColumnValue = "";
	        		colno = 0;
	        		tableColumnCount = document.getElementById("es_comp_colcount").value;
	        		if (tableColumnCount > 5){		
		        		alert("Table column cannot exceed 5. ");
		        		document.getElementById("es_comp_colcount").focus();
		        		return false;		
		        	}
	        		if (tableColumnCount>0)
	        		{
	        			tableValue = "<Column>";
	        			while (fields<tableColumnCount)	
						{
	        				colno = fields+1;
	        				ColumnValue = "";
	        				ColumnValue = document.getElementById("column"+fields).value;
	        				ColumnLabel = "<ColumnName"+colno+">" +ColumnValue+ "</ColumnName"+colno+">";	        				
	        				tableValue = tableValue + ColumnLabel;
	        				fields++;
						}
	        			tableValue = tableValue + "</Column>"; 
	        			
	        			fields = 0;	
	        			
	        			tableTypeValue = "<ColumnType>";
	        			while (fields<tableColumnCount)	
						{
	        				colno = fields+1;
	        				ColumnTypeValue = "";
	        				ColumnTypeValue = document.getElementById("columnType"+fields).value;
	        				ColumnTypeLabel = "<ColumnType"+colno+">" +ColumnTypeValue+ "</ColumnType"+colno+">";	        				
	        				tableTypeValue = tableTypeValue + ColumnTypeLabel;
	        				fields++;
						}
	        			tableTypeValue = tableTypeValue + "</ColumnType>"; 
	        			
	        		}
	        	}
	        	else if (tempValue == '4')
	        	{
	        		esXaxisLabel = document.getElementById("es_xaxis_label").value;
	        		esXaxisLabel = esXaxisLabel.replace(/^\s+|\s+$/g,'');
	        		esXaxisDatatype = document.getElementById("es_xaxis_datatype").value;
	        		
	        		esYaxisLabel = document.getElementById("es_yaxis_label").value;	 
	        		esYaxisLabel = esYaxisLabel.replace(/^\s+|\s+$/g,'');
	        		esYaxisDatatype = document.getElementById("es_yaxis_datatype").value;
	        		
	        		if (esXaxisDatatype == '')
	        			esXaxisDatatype = "D";
	        		
	        		LineChartValue = "<ValueRange dataPlot='3' xAxisLabel='"+esXaxisLabel+"' xDataType='"+esXaxisDatatype+"' yAxisLabel='"+esYaxisLabel+"'  yDataType='"+esYaxisDatatype+"'>";      		
	        	}
	        	else
	        	{
	        		tableValue = "";
		        	LineChartValue = "";
	        	}
	        	
	        	document.getElementById("es_table_details").value  = tableValue;
	        	document.getElementById("es_columnType_details").value  = tableTypeValue;
	        	document.getElementById("es_LineChart_details").value  = LineChartValue;	        	
	        	
	        	//window.close();
	        	document.encSummCompModForm.action='../../servlet/eCA.EncSummGroupCompServlet';
	        	document.encSummCompModForm.target='messageFrame';
	        	document.encSummCompModForm.method='post';
	        	document.encSummCompModForm.submit();	
	        	
	        }	        
	        
	        function addInput(obj) 
	        {
	        	var colTypeName = "";
	        	var colName = "";

	        	var colValue = 0;	        	
	        	colValue = obj;	   
	        	
	        	if (colValue > 5){		
	        		alert("Table column cannot exceed 5. ");
	        		document.getElementById("es_comp_colcount").focus();
	        		return false;		
	        	}
	        	
				if ( colValue > 0) {
					while (fields<colValue)	
					{
						var newRow = document.all("columnTable").insertRow();				    
					    var colno = fields+1;
					    
					    var oCell = newRow.insertCell();
					    oCell.innerHTML = " Column "+colno;
					    oCell.className = "label"; 
					    oCell.width = "100px"; 
					    
					    colTypeName = "columnType"+fields;    
					    colName = "column"+fields;					    
					    
					    var select = document.createElement("select");   
					    select.setAttribute("name", colTypeName);   
					    select.setAttribute("id", colTypeName); 
					    select.setAttribute("onchange", function() {selectOptionChange(this)}); 
					    //select.onchange = function() {selectOptionChange(this)};
					    
					    var option;  
					    option = document.createElement("option");  
					    option.setAttribute("value", "");  
					    option.innerHTML = "Select";  
					    select.appendChild(option);
					    
					    option = document.createElement("option");  
					    option.setAttribute("value", "P");  
					    option.innerHTML = "Parameter";  
					    select.appendChild(option);

					    option = document.createElement("option");  
					    option.setAttribute("value", "U");  
					    option.innerHTML = "Units";  
					    select.appendChild(option);

					    option = document.createElement("option");  
					    option.setAttribute("value", "V");  
					    option.innerHTML = "Values";  
					    select.appendChild(option);

					    option = document.createElement("option");  
					    option.setAttribute("value", "Y");  
					    option.innerHTML = "Your value is ";  
					    select.appendChild(option);

					    option = document.createElement("option");  
					    option.setAttribute("value", "R");  
					    option.innerHTML = "Reference";  
					    select.appendChild(option);
					    
					    oCell = newRow.insertCell();
					    oCell.appendChild(select);	
					    oCell.width = "100px";
					    
					    oCell = newRow.insertCell();
					    oCell.innerHTML = '<input type="text" name="column'+fields+'" id="column'+fields+'"  id="column'+fields+'">';	
					    oCell.width = "100px";
					    fields++;
					}				    
				   				
				}
	        }
	        
	        function selectOptionChange(obj) 
	        {	        	
	        	var colCount = 0;
	        	var colName = "column";
	    		var colTypeName = "columnType";  	
	    		var objName = obj.name;
	    		var colTextName = "";
	    		
	    		colCount = objName.substring(objName.length,objName.length-1);	    		
	    		colTextName = colName + colCount;
	    		
	        	if (obj.value == 'P')
	        	{
	        		document.getElementById(colTextName).value = 'Parameter';
	        	}
	        	else if (obj.value == 'U')
	        	{
	        		document.getElementById(colTextName).value = 'Units';
	        	}
	        	else if (obj.value == 'V')
	        	{
	        		document.getElementById(colTextName).value = 'Values';
	        	}
	        	else if (obj.value == 'Y')
	        	{
	        		document.getElementById(colTextName).value = 'Your Value is ';
	        	}
	        	else if (obj.value == 'R')
	        	{
	        		document.getElementById(colTextName).value = 'Reference';
	        	}
	        	
	        }

	</script>
</head>
<body>
	<form name = 'encSummCompModForm' >
		<div id="buttonDiv" name="buttonDiv" >
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='3'><fmt:message key="eCA.ModifyComponents.label" bundle="${ca_labels}"/></td>						
					<td class='columnHeader' align=left colspan='1'><input type='button' name='saveBtn' id='saveBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%>'
											onclick='saveComponents()'>
					</td>					 					
					<td class='columnHeader' align=left colspan='1'><input type='button' name='cancelBtn' id='cancelBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'
											onclick='cancelParent()'>
					</td>				
				</tr>
			</table>
		</div>
	
		<div id="headerDiv" name="headerDiv" >
			<table width='100%'  cellpadding='3' cellspacing=0  align='center'>
				<tr>
					<td class='label' width="15%" ><fmt:message key="eCA.ComponentCode.label" bundle="${ca_labels}"/> </td>
					<td class='gridData' width="15%" ><%=comp_code%></td>					
					<td class='label' width="25%" ><fmt:message key="eCA.ComponentDescription.label" bundle="${ca_labels}"/></td>
					<td class='gridData' width="45%" ><%=comp_desc%></td>
						
				</tr>
			</table>
		</div>
		<div id="templateDiv" name="templateDiv" >
			<table width='100%'  cellpadding='3' cellspacing=0  align='center'>
				<tr>
					<td class='label' width=<%=columnWidth1 %>><fmt:message key="eCA.TemplateType.label" bundle="${ca_labels}"/></td>
					<td class='fields' width=<%=columnWidth2 %>><select name='es_comp_template' id='es_comp_template'  id='es_comp_template' onChange='changeTemplate(this.value)'>								
								<option value="">-----<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>-----</option>	
									<%=oTempType%>
								</select><img src='../../eCommon/images/mandatory.gif'>
					</td>	
								
					<script>									
						var tempObjName = 'es_comp_template';	
						var compTempValue = <%=comp_temp_int%>;
						if ('<%=comp_temp_int%>' > 0 )
						{
							var selTempObj = document.getElementById(tempObjName);										
							for(var i=0;i<selTempObj.options.length;i++){											
					            if (selTempObj.options[i].value == '<%=comp_temp_int%>') {
					            	selTempObj.selectedIndex = i;
					                break;
					            }
					        }
						}						
					</script>
						
				</tr>
			</table>
		</div>
		<div id="tableDiv" name="tableDiv" style="display:none;">
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='5'><fmt:message key="eCA.ColumnDetails.label" bundle="${ca_labels}"/></td>					
				</tr>
			</table>
			<table width='100%'  cellpadding='3' cellspacing=0  border='0'  align='center'>
				<tr>
					<td class='label' width=<%=columnWidth1 %> ><fmt:message key="eCA.ColumnNumbers.label" bundle="${ca_labels}"/></td>
					<td class='fields' width=<%=columnWidth2 %> align='center'> <input type='text' name='es_comp_colcount' id='es_comp_colcount'  id='es_comp_colcount' size=2 value="<%=comp_col_count%>" onBlur='addInput(this.value)'> </td>						
				</tr>
			</table>
			<table width='100%'  cellpadding='3' cellspacing=0  align='center' id='columnTable'>	
				<tr id='trcoll'>
					<td class='columnHeader' colspan='5'>Column Header Labels</td>					
				</tr>	
				<tr id='trcoll'>
					<td class='columnHeader' >Column No</td>
					<td class='columnHeader' >Column Type</td>
					<td class='columnHeader' >Column Title</td>					
				</tr>			
			</table>
		</div>
		<div id="lineGraphDiv" name="lineGraphDiv" style="display:none;">
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='5'><fmt:message key="eCA.LineChartdetails.label" bundle="${ca_labels}"/></td>					
				</tr>
			</table>
			<table width='100%'  cellpadding='3' cellspacing=0  border='0'  align='center'>
				<tr>
					<td class='label' width=<%=columnWidth1 %>><fmt:message key="Common.XAxisLabel.label" bundle="${common_labels}"/></td>
					<td class='fields' width=<%=columnWidth2 %> align='center' > <input type='text' name='es_xaxis_label' id='es_xaxis_label'  id='es_xaxis_label' size=20 value="<%=es_xaxis_label%>" > </td>						
				</tr>
				<tr>
					<td class='label' width='40%'><fmt:message key="Common.XAxisLabelDataType.label" bundle="${common_labels}"/></td>
					<td class='fields' width='60%' align='center'> 
						<select name='es_xaxis_datatype' id='es_xaxis_datatype' id='es_xaxis_datatype'>
						<% 
							for(int k=0;k<comptypecode.length;k++)
							{								
								out.println("<option value='"+comptypecode[k]+"' "+sel+">"+comptypedesc[k]);
							}
						%>
	 					</select> 
	 				</td>						
				</tr>
				<tr>
					<td class='label' width=<%=columnWidth1 %>><fmt:message key="Common.YAxisLabel.label" bundle="${common_labels}"/></td>
					<td class='fields' width=<%=columnWidth2 %> align='center'> <input type='text' name='es_yaxis_label' id='es_yaxis_label'  id='es_yaxis_label' size=20 value="<%=es_yaxis_label%>" > </td>						
				</tr>
				<tr>
					<td class='label' width=<%=columnWidth1 %>><fmt:message key="Common.YAxisLabelDataType.label" bundle="${common_labels}"/></td>
					<td class='fields' width=<%=columnWidth2 %> align='center'>
						<select name='es_yaxis_datatype' id='es_yaxis_datatype' id='es_yaxis_datatype'>
						<% 
							for(int k=0;k<comptypecode.length;k++)
							{								
								out.println("<option value='"+comptypecode[k]+"' "+sel+">"+comptypedesc[k]);
							}
						%>
	 					</select> 
					</td>						
				</tr>
			</table>
		</div>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="es_group_flag" id="es_group_flag" value="<%=groupFlag%>">
		<input type="hidden" name="es_group_type" id="es_group_type" value="<%=groupType%>">
		<input type="hidden" name="es_group_code" id="es_group_code" value="<%=groupCode%>">
		<input type="hidden" name="es_comp_flag" id="es_comp_flag" value="<%=comp_flag%>">
		<input type="hidden" name="es_comp_type" id="es_comp_type" value="<%=comp_type%>">
		<input type="hidden" name="es_comp_code" id="es_comp_code" value="<%=comp_code%>">
		<input type="hidden" name="es_table_details" id="es_table_details" value="">
		<input type="hidden" name="es_LineChart_details" id="es_LineChart_details" value="">
		<input type="hidden" name="es_columnType_details" id="es_columnType_details" value="">
	</form>
					<script>							
						var compTempValue = <%=comp_temp_int%>;
						var compColCount = <%=comp_col_count%>;
						var compDef = '<%=comp_temp_def%>';
						var compColumnType = '<%=comp_column_type%>';
						changeTemplate(compTempValue);
						addInput(compColCount);
						
						
						if (compTempValue == '2' || compTempValue == '4')
						{
							returnCompDef(compTempValue, compColCount, compDef, compColumnType);
						}
					</script>
</body>
</html>

