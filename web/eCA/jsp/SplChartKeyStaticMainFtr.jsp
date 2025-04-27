<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>SplChartKeyStaticMainFtr</title>
		<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="JavaScript">
			function addMoreRows()
			{
				var formObj = parent.frameSplChartKeyStaticMainDtl.document.SplChartKeyStaticMainDtl;
				var total	= formObj.rec_count.value;
				var count	= parseInt(total) + 5; 
				classval = "gridData";
				for (j=parseInt(total)+1;j<=count;j++ )
				{
					/*if(j % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}*/
					curr_row	= parent.frameSplChartKeyStaticMainDtl.document.getElementById('splchart_details').insertRow();
							
					cell	=	curr_row.insertCell();
					curr_row.cells[0].className = 'gridNumericData';
					curr_row.cells[0].innerHTML = "&nbsp;"+(j)+"&nbsp;";
					curr_row.cells[0].align = "right";
					
					cell	=	curr_row.insertCell();
					curr_row.cells[1].className = classval;
					curr_row.cells[1].innerHTML = "<input type='text'  name=\"start_value"+j+"\" id=\"start_value"+j+"\" maxlength=11 value='' onkeypress=\"return allowPositiveNumber();\"  onBlur=\"checkPositiveNumber(this);\" readOnly>";
					curr_row.cells[1].align = "center";
				
					cell	=	curr_row.insertCell();
					curr_row.cells[2].className = classval;
					curr_row.cells[2].innerHTML = "<input type='text'  name=\"end_value"+j+"\" id=\"end_value"+j+"\" maxlength=11 value='' onkeypress=\"return checkval3("+j+")\"  onBlur=\"if(checkPositiveNumber(this)) if(checkval2("+j+")) setNextFirstValue(this,"+j+");\">";
					curr_row.cells[2].align = "center";
				}
				var j = parseInt(total);
				formObj.elements[j*2].value = formObj.elements[(j*2)-1].value;
				formObj.elements[(j*2)+1].focus();
				
				formObj.rec_count.value = count;
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<br>
<table cellpadding='3' cellspacing='0' border='0' width='98%' align='center'>

<tr>
	<td align='right'><input type='button' class='button' 
	value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddRows.label","ca_labels")%>' onClick='addMoreRows()'/></td>
</tr>

</table>
</body>
</html>

