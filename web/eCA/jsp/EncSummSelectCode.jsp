<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head>
		<title><fmt:message key="eCA.SummaryList.label" bundle="${ca_labels}"/></title>
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummPopUp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>	        
	        function refreshParent() 
	        {	        	
	        	window.close();	        	
	        }	
	        
	        function setSummValue(summCode, recordCount)
	        {		
	        	if (recordCount == 0){
	    			errorMsg = getMessage("RESULTS_NOT_AVAILABLE",'CA');
	    			alert(errorMsg);
	    			return;
	    		}
	        	document.encSummSelectCodeForm.selSummCode.value = summCode;
	        }
	        
	        function callPrintSummary()
	        {	        	
	        	var selSummCode = "";
	        	
	        	var patientId = document.encSummSelectCodeForm.patientId.value;
	        	var encounterId = document.encSummSelectCodeForm.encounterId.value;
	        	selSummCode = document.encSummSelectCodeForm.selSummCode.value;
	        	
	        	
	    		if (selSummCode.length > 0){		    			
	    			PrintSummary(patientId, encounterId, selSummCode);
	    			window.close();	
	    		}
	    		else
	    		{
	    			alert("Please select "+getLabel("eCA.SummaryCode.label","eCA")+ " to print ");	    			
	    			return false;
	    		}	        		           		        	
	        }
	    </script>
	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'encSummSelectCodeForm'>
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='5'><fmt:message key="eCA.SelectSummaryList.label" bundle="${ca_labels}"/></td>					
				</tr>
			</table>
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>												
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>					
				</tr>
				<%	
						
					String summDescStr = "", summDescVal = "", summCode = "", summDesc = ""; 
					int summCount = 0, i = 0, recordCount = 0;	
					
					String patientid = "", encounterid = "";
					
					patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
					encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
				
					summDescStr = request.getParameter("summDesc");	
					
					StringTokenizer tokenizeCarrat  = null;
					StringTokenizer tokenizeTilde = null;			
				
					try
					{
						
						tokenizeCarrat = new StringTokenizer(summDescStr, "^");
						
						
						while (tokenizeCarrat.hasMoreTokens())// loop for Splitting the Final String
						{
							
							summDescVal = tokenizeCarrat.nextToken();					
							tokenizeTilde = new StringTokenizer(summDescVal, "~");
							summCode = tokenizeTilde.nextToken();
							summCode = java.net.URLDecoder.decode(summCode);
							summDesc = tokenizeTilde.nextToken();	
							recordCount = Integer.parseInt(tokenizeTilde.nextToken());
							i++;
							%>
							<tr id ='trRowId<%=i %>'>								
								<td style='display:none'> <input type='hidden' name ='summCode<%=i %>' value = '<%=summCode %>' > </td>
								<td style='display:none'> <input type='hidden' name ='recordCount<%=i %>' value = '<%=recordCount %>' > </td>
								<td class='gridData'> <%=summCode %> </td>
								<td class='gridData'> <%=summDesc %> </td>										
								<td class='gridData'   align='center'> 
									<input type='radio' name='encSummSel' id='encSummSel'  onclick="setSummValue('<%=summCode %>',<%=recordCount %>);"> 
								</td>							
							</tr>	
							<%
						}
						
						
					}
					catch(Exception e){
						//out.println("Exception: "+e.toString());//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}					
				%>
			</table>	
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='3'></td>						
					<td class='columnHeader' align=left colspan='1'><input type='button' name='okBtn' id='okBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'
											onclick='callPrintSummary()'>
					</td>					 					
					<td class='columnHeader' align=left colspan='1'><input type='button' name='cancelBtn' id='cancelBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'
											onclick='refreshParent()'>
					</td>				
				</tr>
			</table>	
			<input type='hidden' name='summCodeCount' id='summCodeCount' value ='<%=i %>' >	
			<input type='hidden' name='patientId' id='patientId' value ='<%=patientid %>' >	
			<input type='hidden' name='encounterId' id='encounterId' value ='<%=encounterid %>' >	
			<input type='hidden' name='selSummCode' id='selSummCode' value ='' >	
		</form>		
	</body>
</html>

		

