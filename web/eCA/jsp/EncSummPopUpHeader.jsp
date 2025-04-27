<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
08/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="Common.PrintSummary.label" bundle="${common_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
			String queryString = request.getQueryString();
			
			String patientId = request.getParameter("patientId");	
			String currEncId = request.getParameter("encounterId");			
			
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
	 		{
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 		}		
			
			String checkedCurrEnc="checked";	
			String checkedPrevEnc="";	
			
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<style>
			
			@media print {
				div#printDiv {       
					display: visible;      
				} 
			} 	
			
		</style>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src ='../../eCommon/js/CommonLookup.js'></Script>
		
		<script language='javascript' src='../../eCA/js/EncSummPopUp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
				function loadiFrame()
			    {
					var patientId = ""; 
					var encounterId = "";	
					var summCode = "LABSUMM";
						
					patientId = document.EncSummPopUpHeadForm.patientId.value;
					encounterId = document.EncSummPopUpHeadForm.encounterId.value;					
					
					var src = "../../eCA/jsp/EncounterSummaryGH_Kendo_XML.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&summCode="+summCode+"&printFlag=1";
					$("#printDiv").html("<iframe id='myiframe' name='myname' src='" + src + "' style='position:absolute; left:-10000px; top: 15%; width: 70%; height: 70%;' />");
			    }
		
			    $(function()
			    {
			        $("#print").bind("click", 
			            function() { 
			                loadiFrame(); 
			                $("#myiframe").load( 
			                    function() {
			                        window.frames['myname'].focus();
			                        window.frames['myname'].print();
			                    }
			                 );
			            }
			        );
			    });

			
		</script>
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'EncSummPopUpHeadForm'>
			<table cellpadding='3' cellspacing='0' width='50%' align='left' border='1' RULES=NONE FRAME=BOX>			
				<tr>
				    <td class=label > Do you want to print the </td>					
				
					<td class='fields'>
						<input type='radio' name='printEnc' id='printEnc' value=0 <%=checkedCurrEnc%> onclick="setEncounterFlag(this);setEncounterValue('<%=patientId %>','<%=currEncId %>');">
						<fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/> 
					</td>
				
					<td class='fields'>
						<input type='radio' name='printEnc' id='printEnc' value=1 <%=checkedPrevEnc%> onclick='setEncounterFlag(this);'>
						<fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/>		
					</td>
				</tr>			
				<tr>					
					<td align='right' colspan ='2'><input type='button' class='button' name='search' id='search' id='search'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' 
												onclick="SearchEncounters();" disabled>
					</td>									
					<td align='left' colspan ='1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='button' name='view' id='view' id='view'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")%>' 
												onclick="checkForSummary(this);">
					</td>
					<!--
					<td align='left' colspan ='1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='button' name='print' id='print' id='print'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>'>
					</td>
					-->	
					<!--  
					<td align='left' colspan ='1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='button' name='view' id='view' id='view'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")%>' 
												onclick="PrintSummary();">
					</td>
					-->
					<!-- 
					<td align='right' colspan ='2'><input type='button' class='button' name='close' id='close' id='close'
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' 
												onclick="window.close();">
					</td>
					-->
				</tr>				
			</table>
			<table cellpadding='3' cellspacing='0' width='50%' align='right' border='1' RULES=NONE FRAME=BOX>
				<tr>					
				</tr>
			</table>
			<input type='hidden' name='CurrPrevEnc' id='CurrPrevEnc' value='0'>
			<input type='hidden' name='patientId' id='patientId' value='<%=patientId %>'>
			<input type='hidden' name='encounterId' id='encounterId' value='<%=currEncId %>'>
			<input type='hidden' name='currEncId' id='currEncId' value='<%=currEncId %>'>
			
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>	
			<div id="printDiv"></div>		
		</form>
	</body>	
</html>

