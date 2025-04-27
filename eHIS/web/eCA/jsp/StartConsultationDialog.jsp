<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           created
10/07/2012	  IN032842		Chowminya G	    On Consultation Parameter setup  OP Consultation, Patient chart function.	
10/07/2012	  IN033734		Chowminya G	    On Consultation Parameter setup  OP Consultation, Patient chart
											function.related		
13/07/2012	  IN032803		Menaka V		When open Patient Chart without encounter on Manage Patient queue, the system
											still allow to order. Actually, this functionality should allow viewing Patient Chart only.												
---------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script>
function confirmationYes()
{
	returnValue = "PCWE"+"#"+"Yes"
	window.close();
	return returnValue;
}	

function confirmationNo()
{
	var returnVal;
	//alert(document.getElementById("patChartCalledFrm").value+"=>"+document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value);
	if(document.getElementById("patChartCalledFrm").value=='OP' && document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value=='RUNTIME')
	{
		//alert('1');
		document.getElementById("chartTypeDtlRow").style.display='inline'
		document.getElementById("chartTypeHdrRow").style.display='inline'
		document.getElementById("okCancelRow").style.display='inline'
		document.getElementById("startConsBtnRow").style.display='none'
		document.getElementById("startConsRow").style.display='none'
	}
	//IN065070 starts
	else if(document.getElementById("patChartCalledFrm").value=='AE' && document.getElementById("AE_CURR_EMR_PATIENT_CHART_TYPE").value=='RUNTIME')
	{
		//alert('1');
		document.getElementById("chartTypeDtlRow").style.display='inline'
		document.getElementById("chartTypeHdrRow").style.display='inline'
		document.getElementById("okCancelRow").style.display='inline'
		document.getElementById("startConsBtnRow").style.display='none'
		document.getElementById("startConsRow").style.display='none'
	}
	//else if(document.getElementById("patChartCalledFrm").value=='' && document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value=='RUNTIME')
	else if(document.getElementById("patChartCalledFrm").value=='' && document.getElementById("patient_class").value=='OP' && document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value=='RUNTIME')
	{
		//alert('2');
		document.getElementById("chartTypeDtlRow").style.display='inline'
		document.getElementById("chartTypeHdrRow").style.display='inline'
		document.getElementById("okCancelRow").style.display='inline'
		document.getElementById("startConsBtnRow").style.display='none'
		document.getElementById("startConsRow").style.display='none'	
	}
	else if(document.getElementById("patChartCalledFrm").value=='' &&  document.getElementById("patient_class").value=='AE' && document.getElementById("AE_PATLIST_BY_LOCN_CHART_TYPE").value=='RUNTIME')
	{
//IN065070 Ends
		//alert('2');
		document.getElementById("chartTypeDtlRow").style.display='inline'
		document.getElementById("chartTypeHdrRow").style.display='inline'
		document.getElementById("okCancelRow").style.display='inline'
		document.getElementById("startConsBtnRow").style.display='none'
		document.getElementById("startConsRow").style.display='none'	
	}
	else
	{
		if(document.getElementById("patChartCalledFrm").value=='')
		{
			//alert('1');
	//IN065070 starts
			if(document.getElementById("patient_class").value=='OP')
			{
				if(document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value=='PCWE')
				{
					returnValue = "PCWE"+"#"+"No"
				}
				else if(document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value=='PCWOE')
				{
					returnValue = "PCWOE"+"#"+"No"
				}	
			}else (document.getElementById("patient_class").value=='AE')
			{
				if(document.getElementById("AE_PATLIST_BY_LOCN_CHART_TYPE").value=='PCWE')
				{
					returnValue = "PCWE"+"#"+"No"
				}
				else if(document.getElementById("AE_PATLIST_BY_LOCN_CHART_TYPE").value=='PCWOE')
				{
					returnValue = "PCWOE"+"#"+"No"
				}
			}
	//IN065070 Ends
		}
		else if(document.getElementById("patChartCalledFrm").value=='OP')
		{
			if(document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value=='PCWE')
			{
				returnValue = "PCWE"+"#"+"No"
			}
			else if(document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value=='PCWOE')
			{
				returnValue = "PCWOE"+"#"+"No"
			}
		}
		//IN065070 starts
		else if(document.getElementById("patChartCalledFrm").value=='AE')
		{
			if(document.getElementById("AE_CURR_EMR_PATIENT_CHART_TYPE").value=='PCWE')
			{
				returnValue = "PCWE"+"#"+"No"
			}
			else if(document.getElementById("AE_CURR_EMR_PATIENT_CHART_TYPE").value=='PCWOE')
			{
				returnValue = "PCWOE"+"#"+"No"
			}
		}
		//IN065070 Ends
		window.close();
		return(returnValue);
		//confirmationOk();
	}	
}

function selectChartType(obj)
{
	document.getElementById("userChartType").value=obj.value;
}

function confirmationOk()
{
	if(document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value=='RUNTIME' && (document.getElementById("userChartType").value==""||document.getElementById("userChartType").value=='undefined'))
	{
		alert("APP-CA0372 Please select the Chart Type.");
		return;
	}else if(document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value=='RUNTIME' && (document.getElementById("userChartType").value==""||document.getElementById("userChartType").value=='undefined'))
	{
		alert("APP-CA0372 Please select the Chart Type.");
		return;
	} //Condition added --[IN032842]
//IN065070 starts
	if(document.getElementById("AE_CURR_EMR_PATIENT_CHART_TYPE").value=='RUNTIME' && (document.getElementById("userChartType").value==""||document.getElementById("userChartType").value=='undefined'))
	{
		alert("APP-CA0372 Please select the Chart Type.");
		return;
	}else if(document.getElementById("AE_PATLIST_BY_LOCN_CHART_TYPE").value=='RUNTIME' && (document.getElementById("userChartType").value==""||document.getElementById("userChartType").value=='undefined'))
	{
		alert("APP-CA0372 Please select the Chart Type.");
		return;
	} 
//IN065070 ends
	if(document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value!='RUNTIME' && document.getElementById("CA_PATLIST_BY_LOCN_CHART_TYPE").value!= 'null')
	{
		//returnValue = document.getElementById('CA_PATLIST_BY_LOCN_CHART_TYPE').value+"#"+"No";//IN032803
		returnValue = document.getElementById('userChartType').value+"#"+"No";//IN032803
		window.close();
		return returnValue;
	} else if(document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value!='RUNTIME' && document.getElementById("MNG_PAT_QUEUE_CHART_TYPE").value!= 'null')
	{
		//returnValue = document.getElementById('MNG_PAT_QUEUE_CHART_TYPE').value+"#"+"No";//IN032803
		returnValue = document.getElementById('userChartType').value+"#"+"No";//IN032803
		window.close();
		return returnValue;
	} //Condition added --[IN033734]
	else
	{
		returnValue = document.getElementById("userChartType").value+"#"+"No";
		window.close();
		return returnValue;
	}
}
function confirmationCancel()
{
	window.close();
}
</script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<title>
Confirmation
</title>
</head>
<body>
<%
	Statement stmt=null; 
	ResultSet rst=null;
	Connection con = null;
	String CA_PATLIST_BY_LOCN = "";
	String MNG_PAT_QUEUE ="";
	String CA_PATLIST_BY_LOCN_CHART_TYPE="";
	String MNG_PAT_QUEUE_CHART_TYPE ="";
	//IN065070 starts
	String AE_CURR_EMR_PATIENT ="";
	String AE_CURR_EMR_PATIENT_CHART_TYPE ="";
	String AE_CA_PATLIST_BY_LOCN="";
	String AE_PATLIST_BY_LOCN_CHART_TYPE="";
	String pat_class = request.getParameter("pat_class")==null?"":request.getParameter("pat_class");
	//IN065070 Ends

	String patChartCalledFrm = request.getParameter("patChartCalledFrm")==null?"":request.getParameter("patChartCalledFrm");
	//System.out.println("112,patChartCalledFrm=>"+patChartCalledFrm);
	try
	{				
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		//rst=stmt.executeQuery("SELECT CA_PATLIST_BY_LOCN,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE FROM CA_CONS_PARAM"); //Commented for IN065070
		rst=stmt.executeQuery("SELECT CA_PATLIST_BY_LOCN,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE FROM CA_CONS_PARAM");//Modified for IN065070

		while(rst.next())
		{ 
			CA_PATLIST_BY_LOCN= rst.getString("CA_PATLIST_BY_LOCN");
			MNG_PAT_QUEUE= rst.getString("MNG_PAT_QUEUE");
			CA_PATLIST_BY_LOCN_CHART_TYPE= rst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE");
			MNG_PAT_QUEUE_CHART_TYPE= rst.getString("MNG_PAT_QUEUE_CHART_TYPE");
			//IN065070 changes starts
			AE_CURR_EMR_PATIENT= rst.getString("AE_CURR_EMR_PATIENT");
			AE_CURR_EMR_PATIENT_CHART_TYPE= rst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE");
			AE_CA_PATLIST_BY_LOCN=rst.getString("AE_CA_PATLIST_BY_LOCN");
			AE_PATLIST_BY_LOCN_CHART_TYPE=rst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE");
			//IN065070 changes ends
		}
		//System.out.println(CA_PATLIST_BY_LOCN+" "+MNG_PAT_QUEUE+" "+CA_PATLIST_BY_LOCN_CHART_TYPE+" "+MNG_PAT_QUEUE_CHART_TYPE);

		if(rst != null) rst.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception ex)
	{	
		ex.printStackTrace();
	}			
	finally 
	{
		if(rst != null) rst.close();
		if(stmt != null) stmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

%>
<form name='confirmForm' id='confirmForm'>
<table width='100%'>
	<tr id='startConsRow'>
		<td colspan='3' align='center'>
		Do you want to start the Consultation?
		</td>
	</tr>
	<tr>
	<td colspan='3'></td>
	</tr>
	<tr>
	<td colspan='3'></td>
	</tr>
	<tr id='startConsBtnRow'>
		<td colspan ='3' align='center'>
		<input class='button' align='right' type='button' name = 'confirmYes' value='Yes' onclick='confirmationYes()'/>&nbsp;&nbsp;
		<input class='button' align='right' type='button' name = 'confirmNo' value='No' onclick='confirmationNo()'/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr style='display:none' id='chartTypeHdrRow'>
	<td>
	Select the Chart Type <img src='../../eCommon/images/mandatory.gif'>
	<td>
	</tr>
	<tr style='display:none' id='chartTypeDtlRow'>
	<td class='fields'>
		<input type='radio' id = 'chartType' name='chartType' id='chartType' value = 'PCWE' onclick='selectChartType(this)'/>Patient Chart with Encounter</br>
		<input type='radio' id = 'chartType' name='chartType' id='chartType' value = 'PCWOE' onclick='selectChartType(this)'/>Patient Chart without Encounter
	</td>
	</tr>
	<tr style='display:none' id='okCancelRow'>
		<td>
		</td>
		<td>
		<input class='button' align='right' type='button' name = 'confirmYes' value='Ok' onclick='confirmationOk()'/>&nbsp;&nbsp;
		<input class='button' align='right' type='button' name = 'confirmNo' value='Cancel' onclick='confirmationCancel()'/>
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
<input name='CA_PATLIST_BY_LOCN' id='CA_PATLIST_BY_LOCN' type='hidden' value='<%=CA_PATLIST_BY_LOCN%>'/>
<input name='MNG_PAT_QUEUE' id='MNG_PAT_QUEUE' type='hidden' value='<%=MNG_PAT_QUEUE%>'/>
<input name='CA_PATLIST_BY_LOCN_CHART_TYPE' id='CA_PATLIST_BY_LOCN_CHART_TYPE' type='hidden' value='<%=CA_PATLIST_BY_LOCN_CHART_TYPE%>'/>
<input name='MNG_PAT_QUEUE_CHART_TYPE' id='MNG_PAT_QUEUE_CHART_TYPE' type='hidden' value='<%=MNG_PAT_QUEUE_CHART_TYPE%>'/>
<!--IN065070 changes starts -->
<input name='AE_CURR_EMR_PATIENT' id='AE_CURR_EMR_PATIENT' type='hidden' value='<%=AE_CURR_EMR_PATIENT%>'/>
<input name='AE_CURR_EMR_PATIENT_CHART_TYPE' id='AE_CURR_EMR_PATIENT_CHART_TYPE' type='hidden' value='<%=AE_CURR_EMR_PATIENT_CHART_TYPE%>'/>
<input name='AE_CA_PATLIST_BY_LOCN' id='AE_CA_PATLIST_BY_LOCN' type='hidden' value='<%=AE_CA_PATLIST_BY_LOCN%>'/>
<input name='AE_PATLIST_BY_LOCN_CHART_TYPE' id='AE_PATLIST_BY_LOCN_CHART_TYPE' type='hidden' value='<%=AE_PATLIST_BY_LOCN_CHART_TYPE%>'/>
<input name='patient_class' id='patient_class' type='hidden' value='<%=pat_class%>'/>
<!--IN065070 changes ends -->
<input name='patChartCalledFrm' id='patChartCalledFrm' type='hidden' value='<%=patChartCalledFrm%>'/>
<input name='userChartType' id='userChartType' type='hidden' value=''/>
</form>
</body>
</html>

