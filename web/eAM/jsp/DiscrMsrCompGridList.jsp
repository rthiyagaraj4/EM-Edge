<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<style>
TD.FIRSTSELECTED
{
	BACKGROUND-COLOR: #B1C5E9;  
	FONT-SIZE: 9pt ;
	BORDER-STYLE: SOLID;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	
}
</style>
<%
try
{
	request.setCharacterEncoding("UTF-8");
	int component_srlno = 1;
	String gridComponentDefinition = request.getParameter("gridComponentDefinition")==null?"":request.getParameter("gridComponentDefinition");
	//gridComponentDefinition = java.net.URLDecoder.decode(gridComponentDefinition);
	java.util.StringTokenizer st = new java.util.StringTokenizer(gridComponentDefinition,"|");
	String gridID = request.getParameter("gridID")==null?"":request.getParameter("gridID");	
	String grid_max_columns_allowed = request.getParameter("grid_max_columns_allowed")==null?"":request.getParameter("grid_max_columns_allowed");	
	//out.println(gridComponentDefinition);
%>
<HEAD>
<SCRIPT LANGUAGE="JavaScript">
var firstElementSelected = false, secondElementSelected = false;
var firstElementIndex = 0, secondElementIndex = 0;
function populateDetails(details)
{	//alert(details);
	details = unescape(details);
	var temp = details.split("~");
	//alert(temp);
	//details = (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + (textRows==""?"NA":textRows));
	var srlno = "";
	var member_comp_id = "";
	var member_comp_desc = "";
	var member_comp_type = "";
	var componentColPos = "";
	var componentColSpan = "";
	var textRows = "";
	if(temp != null && temp.length == 7)
	{
		srlno = escape(temp[0]);
		member_comp_id = escape(temp[1]);
		member_comp_desc = escape(temp[2]);
		member_comp_type = escape(temp[3]);
		componentColPos = escape(temp[4]);
		componentColSpan = escape(temp[5]);
		textRows = temp[6];
	}
var action_url = '../../eAM/jsp/DiscrMsrCompGridDef.jsp?gridID=<%=gridID%>&grid_max_columns_allowed=<%=grid_max_columns_allowed%>&gridComponentDefinition=<%=java.net.URLEncoder.encode(gridComponentDefinition)%>&mode=Update&srlno=' + srlno + '&member_comp_id=' + member_comp_id + '&member_comp_desc=' + escape(member_comp_desc) + "&member_comp_type=" + member_comp_type + "&componentColPos=" + componentColPos + "&componentColSpan=" + componentColSpan + "&textRows=" + textRows;
	//alert(action_url);
	parent.templateGridDefFrame.document.location.href = action_url;
	var rowId_obj = document.getElementById('rowId');
	for(i=0;i<rowId_obj.length;i++)
		for(j=0;j<rowId_obj[i].cells.length;j++)
			rowId_obj[i].cells[j].className = (i%2==0?"QRYEVEN":"QRYODD");
	firstElementSelected = false;	
}
function positionComponents(firstElementIndex, secondElementIndex)
{
	//alert('firstElementIndex'+firstElementIndex);
   // alert('secondElementIndex'+secondElementIndex);
	var gridComponentDefinition = document.templateGridListForm.gridComponentDefinition.value.split("|");	
	//alert('gridComponentDefinition'+gridComponentDefinition);
	var temp = document.templateGridListForm.gridComponentDefinition.value.split("|");
	var firstElementDefinition = gridComponentDefinition[firstElementIndex];
	var secondElementDefinition = gridComponentDefinition[secondElementIndex]; 
	//alert(firstElementDefinition + "=" + secondElementDefinition);
	if(firstElementIndex < secondElementIndex)
	{
		for(i=0;i<temp.length;i++)
		{
			if(i < firstElementIndex || i >= secondElementIndex)
				temp[i] = gridComponentDefinition[i];			
			else if(i >= firstElementIndex && i < (secondElementIndex-1))
				temp[i] = gridComponentDefinition[i+1];
			else if(i == (secondElementIndex-1))
				temp[i] = firstElementDefinition;
		}

	}
	else if(firstElementIndex > secondElementIndex)
	{
		for(i=0;i<temp.length;i++)
		{
			if(i > firstElementIndex || i < secondElementIndex)
				temp[i] = gridComponentDefinition[i];
			else if(i == secondElementIndex)
				temp[i] = firstElementDefinition;
			else if(i <= firstElementIndex && i > secondElementIndex)
				temp[i] = gridComponentDefinition[i-1];
		}
	}
	return temp;
	
}
function positionGridComponents(details)
{
//	alert('details'+details);
var table = parent.window[2].document.templateGridComponentDefinitionForm.querySelectorAll('#temporary_label');	
	var temp = details.split("~");
  //  alert('temp'+temp);
	var srlno = "";
	var member_comp_id = "";
	var member_comp_desc = "";
	var member_comp_type = "";
	var componentColPos = "";
	var componentColSpan = "";
	var textRows = "";
	if(temp != null && temp.length == 7)
	{
		srlno = escape(temp[0]);
	//	alert('srlno'+srlno);
		member_comp_id = escape(temp[1]);
	//	alert('member_comp_id'+member_comp_id);
		member_comp_desc = escape(temp[2]);
		//alert('member_comp_desc'+member_comp_desc);
		member_comp_type = escape(temp[3]);
	//	alert('member_comp_type'+member_comp_type);
		componentColPos = escape(temp[4]);
	//	alert('componentColPos'+componentColPos);
		componentColSpan = escape(temp[5]);
	//	alert('componentColSpan'+componentColSpan);
		textRows = temp[6];
	}
	var action_url = '../../eAM/jsp/DiscrMsrCompGridDef.jsp?gridID=<%=gridID%>&grid_max_columns_allowed=<%=grid_max_columns_allowed%>&gridComponentDefinition=<%=java.net.URLEncoder.encode(gridComponentDefinition)%>&mode=Update&srlno=' + srlno + '&member_comp_id=' + member_comp_id + '&member_comp_desc=' + escape(member_comp_desc) + "&member_comp_type=" + member_comp_type + "&componentColPos=" + componentColPos + "&componentColSpan=" + componentColSpan + "&textRows=" + textRows;

	if(!firstElementSelected)
	{
		if (table.length > 0 ) {
		    table[0].style.display = 'block';
		}
		firstElementSelected = true;
		firstElementIndex = srlno;
		secondElementIndex = 0;
		secondElementSelected = false;
		var rowId_obj = document.getElementById('rowId');
		//alert(rowId_obj.length);
		for(i=0;i<rowId_obj.length;i++)
		{
			for(j=0;j<rowId_obj[i].cells.length;j++)
			{
				if(i == (firstElementIndex-1))
					rowId_obj[i].cells[j].className = "FIRSTSELECTED";				
				else
					rowId_obj[i].cells[j].className = (i%2==0?"QRYEVEN":"QRYODD");
				
			}
		}
		//alert('selected');
		parent.templateGridDefFrame.document.getElementById('gridComponentDefinitionTable').style.display = "none";
		parent.templateGridDefFrame.document.getElementById('gridToolbarTable').style.display = "none";
	}
	else 
	{
	//	alert('in else');
	if (table.length > 0 ) {
		    table[0].style.display = 'none';
		}
		firstElementSelected = false;
		secondElementSelected = true;
		secondElementIndex = srlno;
	//	alert('srlno'+srlno);
		newGridComponentDefinition_temp = positionComponents(firstElementIndex-1, secondElementIndex-1);
		var newGridComponentDefinition = "";
		var prevColPos = 0;
		for(i=0;i<newGridComponentDefinition_temp.length;i++)
		{
			var srlno =(i+1);
			var member_comp_id = newGridComponentDefinition_temp[i].split("~")[1];
			var member_comp_desc = newGridComponentDefinition_temp[i].split("~")[2];

			var member_comp_type = newGridComponentDefinition_temp[i].split("~")[3];
			var componentColPos = (prevColPos+1);			
			if(i > 0)
			{
				if(newGridComponentDefinition_temp[i-1].split("~")[5] > 1)
				{			
					componentColPos = prevColPos + parseInt(newGridComponentDefinition_temp[i-1].split("~")[5]);
					//alert('added for ' + member_comp_desc + " value of=" + newGridComponentDefinition_temp[i-1].split("~")[5]);
				}
			}
			var componentColSpan = newGridComponentDefinition_temp[i].split("~")[5];
			var textRows = newGridComponentDefinition_temp[i].split("~")[6];
			if(newGridComponentDefinition == "")
				newGridComponentDefinition += (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows);
			else
				newGridComponentDefinition += ("|" + (srlno + "~" + member_comp_id + "~" + member_comp_desc + "~" + member_comp_type + "~" + componentColPos + "~" + componentColSpan + "~" + textRows));
			prevColPos = componentColPos;
		}
		//alert(newGridComponentDefinition);
		parent.templateGridDefFrame.document.getElementById('gridComponentDefinitionTable').style="display";
		parent.templateGridDefFrame.document.getElementById('gridToolbarTable').style="display";
	}	
	//alert(firstElementSelected + "=" + secondElementSelected + "=" + firstElementIndex + "=" + secondElementIndex);
	if(!secondElementSelected)
	{
		//parent.templateGridDefFrame.document.location = action_url;
	}
	else
	{
//		alert(newGridComponentDefinition);
//		alert(escape(newGridComponentDefinition));
		parent.templateGridListFrame.document.location.href = "../../eAM/jsp/DiscrMsrCompGridList.jsp?gridID=<%=gridID%>&gridComponentDefinition=" + escape(newGridComponentDefinition) + "&grid_max_columns_allowed=<%=grid_max_columns_allowed%>";
		parent.templateGridDefFrame.document.templateGridComponentDefinitionForm.gridComponentDefinition.value = newGridComponentDefinition;
		parent.templateGridDefFrame.showGridPreview();
		parent.templateGridDefFrame.clearFields();
		firstElementSelected = false;
		secondElementSelected = false;
		firstElementIndex = 0;
		secondElementIndex = 0;
	}
}
</SCRIPT>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY onKeyDown = 'lockKey()'>
<table width="100%">
	<tr>
		<th align='left' style='BACKGROUND-COLOR:#ffc5b5;color:black'>
			<fmt:message key="Common.ListofGridComponents.label" bundle="${common_labels}"/>
		</th>
	</tr>
</table>
<table width="100%" id="list_of_components" border=1 cellspacing=0 cellpadding=0>
	<tr>
		<th>
			<fmt:message key="Common.ColumnPosition.label" bundle="${common_labels}"/>
		</th>
		<th>
			<fmt:message key="Common.ColumnHeader.label" bundle="${common_labels}"/>
		</th>
		<th>
			<fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/>
		</th>		
		<th>
			<fmt:message key="Common.ColumnSpan.label" bundle="${common_labels}"/>
		</th>
		<th>
			<fmt:message key="Common.TextRows.label" bundle="${common_labels}"/>
		</th>
	</tr>
	<%
	int i=0;

	while(st.hasMoreTokens())
	{
		String temp = st.nextToken();
		String member_comp_desc	= ""	,	member_comp_type	= "";
		String componentColPos	= ""	,	componentColSpan	= "";
		String 	textRows		= "";
		java.util.StringTokenizer st_comp = new java.util.StringTokenizer(temp, "~");
		out.println("<tr id=\"rowId\" >");
		
		String GridCompTemp = "";
		while(st_comp.hasMoreTokens())
		{
			String tem1 = 	st_comp.nextToken();//1
			String tem2 = st_comp.nextToken();//2
			member_comp_desc	= st_comp.nextToken();//3
			member_comp_type	= st_comp.nextToken();//4
			componentColPos		= st_comp.nextToken();//5
			componentColSpan	= st_comp.nextToken();//6
			textRows			= st_comp.nextToken();//7
			
			GridCompTemp = tem1.trim() + "~" + tem2.trim() + "~" + member_comp_desc.trim() + "~" + 
					member_comp_type.trim() + "~"+ componentColPos.trim() + "~"+ 
					componentColSpan.trim() + "~"+ textRows.trim();
		}
	//	String temp1 = temp.replaceAll("\n","");
			//out.println("<script>alert('"+GridCompTemp+"');</script>");

		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "' align='center'>");
		%>
		<a href='javascript:positionGridComponents("<%=java.net.URLEncoder.encode(GridCompTemp)%>")'><%=componentColPos%>
		</a>
        <%
		
		out.println("</td>");
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "' >");
		//out.println("<a class=\"drag\" id= 'list_item_id_" + component_srlno + "' href = \"javascript:populateDetails('" + temp + "')\" >" + member_comp_desc + "</a>");	
		%>
		<a class="drag" id= "list_item_id_<%=component_srlno %>"  
	href = 'javascript:populateDetails("<%=java.net.URLEncoder.encode(GridCompTemp)%>")' ><%=member_comp_desc%>
		</a>	
		<%
		out.println("</td>");
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(member_comp_type);
		out.println("</td>");		
		out.println("<td class='" + (i%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(componentColSpan);
		out.println("</td>");
		out.println("<td class='" + (i++%2==0?"QRYEVEN":"QRYODD") + "'>");
		out.println(textRows.trim().equals("NA")?"--":textRows);
		out.println("</td>");
		out.println("</tr>");
		component_srlno++;
	}
	%>
</table>
<form name="templateGridListForm" id="templateGridListForm">
	<input type="hidden" name="gridComponentDefinition" id="gridComponentDefinition" value="<%=gridComponentDefinition.trim()%>">
</form>
</BODY>
</HTML>
<%	
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		out.println(e);
	}
%>

