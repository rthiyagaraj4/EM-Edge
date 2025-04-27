<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
20/11/12      100         pparthasarathy  created
Acts as create and Modify screen for Payer Group Mapping screen
called on click of create button from common tool bar
on submission (apply) request will be submitted to BLPayerGroupServlet.java
-----------------------------------------------------------------------------------------------
-->

<%@page import="webbeans.eOT.DisplayMappingDtlBean"%>
<%@page import="eOT.Common.OTRepository"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eCommon.Common.*, webbeans.eOT.DisplayMappingBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eOT/html/style.css' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eOT/js/Colourpalette.js'></script>
<script language="JavaScript" src="../../eOT/js/DisplayMapping.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
var otStatusArray;
var headTop = -1;
var FloatHead1;
function processScroll()
{
	if (headTop < 0)
	{
		saveHeadPos();
		
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function saveHeadPos()
{
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}
	
/*function lockKey()
{
	 	 
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
}*/

 function lockbackSpace()
 {
// alert(document.order_type_form.mode.value);
   var mode = document.mode.value;
    // alert(window.event.keyCode);
 if(mode=='modify' && window.event.keyCode==8)
  {
         //return false;
  }
 }

<%
	String mode = checkForNull(request.getParameter("mode"));
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	Properties p = (Properties) session.getValue( "jdbc" ) ;
	int index = 0;
%>

	
</script>
</head>
<style>
		thead td, thead td.locked	{ 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server


String beanId = "ot_DisplayMappingBean" ;
String beanName = "webbeans.eOT.DisplayMappingBean";


try  
{
	
	Map<String, String> otStatusMap = null;
	DisplayMappingBean mappingBeanDtls = null;
	
	DisplayMappingBean displayMappingBean = (DisplayMappingBean)getBeanObject(beanId, beanName, request) ;
	
	otStatusMap = displayMappingBean.fetchOTSlateStatus(facilityId, locale, p);

	mappingBeanDtls = displayMappingBean.fetchDisplayMappingDetails(facilityId, locale, p);
	
	
%>	
<script>	
	 otStatusArray = [
	<%	
		index = 0;
		for(String key : otStatusMap.keySet())
		{
	%>	
			["<%=key %>" , "<%=otStatusMap.get(key) %>"] <%= index++ < (otStatusMap.keySet().size() -1) ? "," : "" %>
	<%
			
		}
	%>
	];	
 
</script> 
		
<body onKeyDown = 'lockKey()'>
	<form name="DisplayMappingForm" id="DisplayMappingForm" >
		<input type='hidden' name='totalCount' id='totalCount' id='totalCount'>
		<div id='colorpicker201' class='colorpicker201'></div>
		<br />
		<br/>
		<div class="main" style="width:99%; height:600px; overflow: auto; ">
			
			<div class="tcontent" >
				<div class="stfdet">
					<div class="floatleft" >
						<span class="stftitle"><fmt:message key="eOT.DisplayMapping.Label" bundle="${ot_labels}"/></span> 
					</div>
					<div class="floatright"><input class="oldbtn"  id="addBtn" type="button" value="Add" onclick='javascript:addRow()'/></div>
				</div>
				<div class="tablediv" > 
					<table  class="crstaffgrid" cellspacing="0" id='DisplayDetailTable'>
						<th><fmt:message key="eOT.DisplayStatus.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.OTSlateStatus.Label" bundle="${ot_labels}"/></th>
						<th><fmt:message key="eOT.SAAction.Label" bundle="${ot_labels}"/></th>
						<tr>
							<td class="alignimgtext">
								<input class="brdclr" type='text'  name='displayStatus_1' id='displayStatus_1'  maxlength=40 size=30  onkeypress="return checkForSpecCharsforID(event);" value="" >
								<img id="img_src" src='../../eOT/images/ColorPalette.gif' onclick="showColorGrid2('colorCode_1','colorCodeDiv_1');">
								<input type="hidden" name="colorCode_1" id="colorCode_1" id="colorCode_1" value=""> 
								<div class="colorspec midalign floatright" id='colorCodeDiv_1' > </div>
							</td>
							<td class="alignimgtext">
								<select name="statusCode_1" id="statusCode_1" id ="ot_slate_status" multiple>
				<%
									for(String code : otStatusMap.keySet())
									{
				%>
											<option value="<%= code %>" >  <%= otStatusMap.get(code) %> </option> 
				<%
									}
				%>	
								</select>
							</td>
							<td></td>
						</tr>
				<%
						int rowIndex = 1;
						if(mappingBeanDtls != null && mappingBeanDtls.getDtlbeanList() != null)
						{
							
							for(DisplayMappingDtlBean dtlBean : mappingBeanDtls.getDtlbeanList())
							{
								rowIndex++;
							
				%>	
						<tr>
							<td class="alignimgtext">
								<input type='hidden' name='displayStatus_<%= rowIndex%>' id='displayStatus_<%= rowIndex%>' id='displayStatus_<%= rowIndex%>'  value='<%= dtlBean.getDisplayStatus()%>' ><%= dtlBean.getDisplayStatus()%>
								<div class="colorspec midalign floatright" id='colorCodeDiv_<%= rowIndex%>'> </div>
								<input type="hidden" name="colorCodeVal_<%= rowIndex%>" id="colorCodeVal_<%= rowIndex%>" id="colorCodeVal_<%= rowIndex%>" value='<%= dtlBean.getColorCode()%>'> </div>
							</td>
							<td class="alignimgtext">
								<%= dtlBean.getDescString() %>
								<input type='hidden'  name='statusCode_<%= rowIndex%>' id='statusCode_<%= rowIndex%>' id='statusCode_<%= rowIndex%>'  value='<%= dtlBean.getCodeString()%>' >
								<input type='hidden'  name='statusDesc_<%= rowIndex%>' id='statusDesc_<%= rowIndex%>'  value='<%= dtlBean.getDescString()%>' >
								<input type='hidden'  name='colorCode_<%= rowIndex%>' id='colorCode_<%= rowIndex%>'  value='<%= dtlBean.getColorCode()%>' >
							</td>
							<td>
								<img src="../../eOT/images/Close.png" class="midalign" onclick='javascript:deleteRow(<%= rowIndex %> , true)'/><span class="tbtxt" >Delete</span>
							</td>
						</tr>
						<script>
							document.getElementById("colorCodeDiv_" + <%=rowIndex%>).style.backgroundColor='<%= dtlBean.getColorCode()%>';
							removeSelectedCode('<%= dtlBean.getCodeString()%>', <%=rowIndex%>);
						</script>		
				<%
							}
						}
				%>		
							<script>document.forms[0].totalCount.value = "<%=rowIndex%>";</script>
					</table>
				</div>
				<div class="refresh">
					<%
						String refreshIntervalTime = "30";
						if(mappingBeanDtls.getRefreshIntervalTime() != null)
						{
							refreshIntervalTime = mappingBeanDtls.getRefreshIntervalTime();
						}
						if(refreshIntervalTime.equals("0"))
						{
							refreshIntervalTime = "30";
						}
						String refreshInterval = "S";
						if(mappingBeanDtls.getRefreshInterval() != null)
						{
							refreshInterval = mappingBeanDtls.getRefreshInterval();
						}
						
					%>
					<div class="">
						<div class="valign">
							<fmt:message key="eOT.AutoRefreshTime.Label" bundle="${ot_labels}"/> 
							<fmt:message key="Common.time.label" bundle="${common_labels}"/>
							<input type='text' name='refreshIntervalTime' id='refreshIntervalTime' maxlength=2 size=2  onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='CheckNum(this)' value="<%= refreshIntervalTime%>" >
							<select class="roomopt" name= "refreshInterval" value='' id="refreshInterval">
								<option value='S'>
									<fmt:message key="eOT.seconds.Label" bundle="${ot_labels}"/>
								</option>
								<option value='M'>
									<fmt:message key="eOT.minutes.Label" bundle="${ot_labels}"/>
								</option>
							</select>
							<script>
								document.forms[0].refreshInterval.value = "<%= refreshInterval %>";
							</script> 
						</div>
					</div>
				</div>
			</div>
			<div>
			<input class="oldbtn1 floatleft" id="displayBtn" type="button"  value="Display Dashboard"  onclick='javascript:displayDashboard()'  />
			<input class="oldbtn1 floatleft" id="displayCloseBtn" type="button" value="Close Dashboard"  onclick='javascript:closeDashboard()' disabled />	
			<input class="oldbtn floatright" type="button" onclick='javascript:preview()' value="Preview" />
			</div>
				
		</div>
		
		
		<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
		<input type='hidden' name='deleteId' id='deleteId' value='' />
		<input type='hidden' name='rowCount' id='rowCount' value='<%=rowIndex - 1%>' />
		<input type='hidden' name='mode' id='mode' value='insert' />
	</form>	
</body>
<%
}
catch(Exception e)
{
	System.out.println("Exception in DisplayMappingAdd.jsp::"+e.toString());
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

