<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties property = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String locale = (String) property.getProperty("LOCALE");
//	String qryString = request.getQueryString();
	String curr_sys_date = "";
	String to_date = "";
	String from_date = "";	
	String resultType = "";
	String cpName = "";
	String std_comp_id ="",std_comp_result_type="", lookup_type="", lookup_url="";
	int selCnt = 1;
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    from_date = com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",locale,0,"d");
    to_date = com.ehis.util.DateUtils.plusDate(curr_sys_date,"DMY",locale,0,"d");	
	String qryRef = request.getParameter("qryRef")==null?"":request.getParameter("qryRef");
	
	//QueryTemplateDataFunctionBean qryDataBean = new QueryTemplateDataFunctionBean();

	QueryTemplateDataFunctionBean qryDataBean = (QueryTemplateDataFunctionBean)getObjectFromBean("qryDataBean","eCA.QueryTemplateDataFunctionBean",session);
	
	qryDataBean.clearKeyComponents();
	qryDataBean.clearDateChk(); //IN057467
%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language = 'javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language = 'javascript' src='../../eCommon/js/common.js'></script>
	<script language = 'javascript' src='../../eCommon/js/dchk.js'></script>
	<script language = 'javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<Script language = 'JavaScript' src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language = 'javascript'  src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCA/js/QueryTemplateDataFunction.js"></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table width='100%' cellpadding='3' cellspacing='0' border='0' id='tblCrc' name='tblCrc' id='tblCrc' style='display;'>
		<tr>
			<td class='columnheader' colspan='2' width='35%'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/> </td>
		</tr>
		<tr>
			<td class='label' colspan='2'><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Period.label" bundle="${common_labels}"/> &nbsp;&nbsp<input type="text" name="date_from" id="date_from" value="<%=from_date%>" size="10" maxlength="10" onBlur="dateChecking(this,date_to,'<%=locale%>')"><img src="../../eCommon/images/CommonCalendar.gif" align='center' onclick="return showCalendar('date_from');" style='cursor:pointer'>&nbsp;&nbsp;-&nbsp;&nbsp;<input type=text name='date_to' id='date_to' value='<%=to_date%>' size="10" maxlength="10" onBlur="dateChecking(date_from,this,'<%=locale%>')"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" align='center'>
		</tr>
		<tr>
			<td class='label' colspan='2' width='35%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select name='selSex' id='selSex'>
					<option selected value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				</select>
			&nbsp;&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Range.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='fromAge' id='fromAge' value='' maxlength='3' onblur='checkAge()' onkeypress='return onlyNumbers(event)' size='3'/>
				<select name='fromSelAgeUnit' id='fromSelAgeUnit' onchange="checkAge();">
					<option selected value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
					<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
					<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				</select>
			&nbsp;&nbsp;-&nbsp;&nbsp;
				<input type='text' name='toAge' id='toAge' onkeypress='return onlyNumbers(event)' value='' size='3' maxlength='3' onblur='checkAge()'/>
				<select name='toSelAgeUnit' id='toSelAgeUnit' onchange="checkAge();">
					<option selected value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
					<option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
					<option value='Y'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<%
			try
			{
				Map<String, String> compound = qryDataBean.getComponent(qryRef);
				if(compound != null)
				{
					Set<String> qryKeySet = compound.keySet();					
					//out.println("compound ------->    :    "+compound);
					for(String cmpName : qryKeySet)
					{
						String []str = cmpName.split("`~");
						resultType = str[2];
						cpName = str[0];
						std_comp_id =str[3].trim();
						std_comp_result_type=str[4].trim();
						lookup_type=str[5].trim();
						lookup_url=str[6].trim();
					%>
						<tr>
						<td class='label' width='35%'><%=compound.get(cmpName)%></td>
						<td width='65%'>
							<%if(!resultType.equals("L") && !resultType.equals("D") && !resultType.equals("E")){%>
								<select id='<%=selCnt+"_"+resultType%>' name='<%=selCnt+"_"+resultType%>' onchange='dispCompound(this)'>
									<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<%
									if(resultType.equals("C"))
									{%>
										<option  value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
										<option  value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
									<%}
									else if(resultType.equals("I") || resultType.equals("N") || resultType.equals("A"))
									{%>
										<option value='EQ'> = </option>
										<option value='BT'><fmt:message key="Common.Between.label" bundle="${common_labels}"/></option>
										<option value='LT'> < </option>
										<option value='GT'> > </option>

									<%}else if(resultType.equals("L")){								
										List<String> descLst = qryDataBean.getRefRangeDesc(cpName);
								
										if(descLst != null)
										{
											for(String desc : descLst)
											{%>
												<option value='<%=desc%>'><%=desc%></option>
											<%}
										}
									}

								if(resultType.equals("I") || resultType.equals("N") || resultType.equals("A"))
								{%>
								</select>
								<input type='text' value='' name='<%=selCnt%>_txtBetween1' id='<%=selCnt%>_txtBetween1' style='display:none' onblur='saveObjToBeanByTxt(this)' ><img src="../../eCommon/images/mandatory.gif" align='center' name='<%=selCnt%>_imgBetween1' style='display:none'>&nbsp;&nbsp;<input type='text' value='' name='<%=selCnt%>_txtBetween2' id='<%=selCnt%>_txtBetween2' onblur='saveObjToBeanByTxt(this)'  style='display:none' ><img src="../../eCommon/images/mandatory.gif" align='center' name='<%=selCnt%>_imgBetween2' style='display:none'>
								<%}
							}else if(resultType.equals("L") && std_comp_id.equals("")){%>
								<select id='<%=selCnt+"_"+resultType%>' name='<%=selCnt+"_"+resultType%>' onchange='dispCompound(this)'>
								<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%		List<String> descLst = qryDataBean.getRefRangeDesc(cpName);
								
								if(descLst != null)
								{
									for(String desc : descLst)
									{%>
										<option value='<%=desc%>'><%=desc%></option>
									<%}
								}
							}else if(resultType.equals("L") && !std_comp_id.equals("")) {%>
								<input type="text" name='<%=selCnt+"_"+resultType%>' id='<%=selCnt+"_"+resultType%>' value="" onBlur='openComponentLookup(this,"<%=compound.get(cmpName)%>","<%=std_comp_id%>","<%=lookup_url%>");'><input type="button" value="?" class="button" name='btn<%=selCnt+"_"+resultType%>' id='btn<%=selCnt+"_"+resultType%>' onClick='openComponentLookup(this,"<%=compound.get(cmpName)%>","<%=std_comp_id%>","<%=lookup_url%>");'>
							
							<%
							//IN057467 Start.
							}else if(resultType.equals("D") || resultType.equals("E")) {%>
								<input type="text" name='DF<%=selCnt+"_"+resultType%>' id="DF<%=selCnt+"_"+resultType%>" value="" size="10" maxlength="10" onBlur="dateCheckingDF(this,DT<%=selCnt+"_"+resultType%>,'<%=locale%>')">
								<img src="../../eCommon/images/CommonCalendar.gif" align='center' onclick="return showCalendar('DF<%=selCnt+"_"+resultType%>');" style='cursor:pointer'>
								&nbsp;&nbsp;-&nbsp;&nbsp;
								<input type=text name='DT<%=selCnt+"_"+resultType%>' id='DT<%=selCnt+"_"+resultType%>' value='' size="10" maxlength="10" onBlur="dateCheckingDT(DF<%=selCnt+"_"+resultType%>,this,'<%=locale%>')">
								<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('DT<%=selCnt+"_"+resultType%>');" style='cursor:pointer'>
								<input type="hidden" value="<%=cpName%>" id="='<%=selCnt%>_Date" name='<%=selCnt%>_Date'>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" value="N" name='<%=selCnt%>_CHKDate' id='<%=selCnt%>_CHKDate' id="<%=selCnt%>_CHKDate" onClick="storeChkVal(this)"> <font class='label'>Include in Result</font>
								<input type='hidden' value='<%=resultType%>' name='<%=selCnt%>_resultType' id='<%=selCnt%>_resultType'>
							<%
							//IN057467 End.
							}%>
							<input type='hidden' value='<%=cmpName%>' name='<%=selCnt%>_hidden'>
						</td>
						</tr>
					<%
						selCnt++;
					}
				}

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			putObjectInBean("qryDataBean",qryDataBean,session);
		%>
<!-- 		<tr>
			<td colspan='2' align='right' width='35%'><input type='button' value='Search' onclick='search()'><input type='button' value='Clear' onclick='reload("<%=qryRef%>")'></td>

		</tr> -->
	</table>
	<input type='hidden' value='<%=selCnt%>' name='selCount' id='selCount'>
	<input type='hidden' value='<%=qryRef%>' name='qryRef' id='qryRef'>
</body>
<SCRIPT LANGUAGE="JavaScript">
<!--
	parent.QryTempDataSerachBtnFrm.location.href = '../../eCA/jsp/QueryTemplateDataFunctionCriteriaSearchButton.jsp?<%=request.getQueryString()%>';
//-->
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</html>

