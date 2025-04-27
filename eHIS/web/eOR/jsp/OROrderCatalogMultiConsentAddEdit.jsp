<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>

<html>
<style>
		TD.FIRSTSELECTED
		{
			BACKGROUND-COLOR: #B1C5E9;  
			FONT-SIZE: 8pt ;
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;
		}
</style>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
 	<script language="JavaScript" src="../js/OROrderCatalogMultiConsent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function callfun(srlno)
	{
		var rowId_obj = document.getElementById("rowId");
				
		for(i=0;i<rowId_obj.length;i++)
		{
			for(j=0;j<rowId_obj[i].cells.length;j++)
			{
				if(i == (srlno-1))
				{	
					rowId_obj[i].cells[j].className = "FIRSTSELECTED";	
				}					
			}
		}
	}
	function callFunction(i)
	{
		var flds=new Array(eval("document.forms[0].mandatory"+i));
		var check = flds[0].checked;
		if(check)
			flds[0].value="Y";
		else
			flds[0].value="N";
		
	}

	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	if(mode==null)
	{		
		mode = "2";	
	}
	String bean_id = "Or_OrderCatalogMultiConsent" ;
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	// Initialize Function specific start 
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);

	String categoryDesc = "";
	String orderTypeDesc = "";
	String catalogDesc = "";
	String catalogCode = "";
	int sequenceNumber = 0;
	String consentDesc = "";
	String tempConsentDesc = "";
	String consentID = "";
	//String consentCode = "";
	String consentStage = "";
	String dfltSelected = "";
	String form_list = "";
	String consent_req_bef_order = "";
	String consent_req_bef_regn = "";
	String[] orMultiConsent = null;
	String temp = "";
	String classValue="";
	int totalRecords= 0;
	int recordsCount = 0;
	String change="";
	String pos1="";
	String pos2="";
	String lastlink="";
	String select = "";


	categoryDesc = request.getParameter("categoryDesc");
	orderTypeDesc = request.getParameter("orderTypeDesc");
	catalogDesc = request.getParameter("catalog_desc");
	catalogCode = request.getParameter("catalog_code");




	change = (request.getParameter("change")==null)?"":request.getParameter("change");
	pos1 = (request.getParameter("pos1")==null)?"":request.getParameter("pos1");
	pos2 = (request.getParameter("pos2")==null)?"":request.getParameter("pos2");
	lastlink = (request.getParameter("lastlink")==null)?"":request.getParameter("lastlink");
	temp = (request.getParameter("temp")==null)?"":request.getParameter("temp");
	if(null!=request.getParameter("count"))
	{
		recordsCount = Integer.parseInt(request.getParameter("count"));
	}
	ArrayList catalogDetails = new ArrayList();
	if(temp.equals(""))
	{
		bean.clearAll();
		
		catalogDetails = bean.getCatalogDetails(catalogCode);
		for(int i=0;i<catalogDetails.size();i++)
		{
			orMultiConsent = (String[]) catalogDetails.get(i);
			bean.putObject(orMultiConsent);
		}
		ArrayList catalogInfo = new ArrayList();
		catalogInfo = bean.getCatalogInfo(catalogCode);
		form_list = (String) catalogInfo.get(0);
		consent_req_bef_order = (String) catalogInfo.get(1);
		consent_req_bef_regn = (String) catalogInfo.get(2);
	}
	else
	{
		form_list = request.getParameter("form_list");
		consent_req_bef_order = request.getParameter("befOrder");
		consent_req_bef_regn = request.getParameter("befRegn");
	}
	int befOrder = Integer.parseInt(consent_req_bef_order);
	int befRegn = Integer.parseInt(consent_req_bef_regn);
	int sp=0;
	int sptemp1=0;
	int sptemp2=0;
	String[] catalogues = null;
	
	if(change.equals("Y"))
	{
		catalogDetails = (ArrayList) bean.getCatalog_details();
		//catalogDetails = (ArrayList) session.getAttribute("CATALOGUES_DETAILS");
		//session.removeAttribute("CATALOGUES_DETAILS");
		bean.clearAll();
		for(int i=0;i<catalogDetails.size();i++)
		{
			orMultiConsent = (String[]) catalogDetails.get(i);
			bean.putObject(orMultiConsent);
		}
		ArrayList b= new ArrayList();
		b= bean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);

		int m=(1*j)-1;

		catalogues = (String[]) b.get(m);
		
		sp=(j*1);

		bean.removeObject(m);
		
	
		int n=Integer.parseInt(pos2);
		int p=(1*n)-1;
		int q;
		if(j<n)
		{
			q=p-1;
		}
		else
		{
			q=p;
		}
		if(lastlink.equals("X"))
		{
			bean.putObject(catalogues);
		}
		else
		{
			bean.addObject(q,catalogues);
		}
		b.clear(); 
	}
	else if (change.equals("NR"))
	{
		//catalogDetails = (ArrayList) session.getAttribute("CATALOGUES_DETAILS");
		catalogDetails = (ArrayList) bean.getCatalog_details();
		//session.removeAttribute("CATALOGUES_DETAILS");
		bean.clearAll();
		for(int i=0;i<catalogDetails.size();i++)
		{
			orMultiConsent = (String[]) catalogDetails.get(i);
			bean.putObject(orMultiConsent);
		}
	}
	
	ArrayList a= new ArrayList();
	a= bean.getRecordSetHandle();
						           
	int size=0;
	int j=0;
	size=a.size();
	int totalList = Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn);
	if(form_list.equalsIgnoreCase("F"))
	{
		totalRecords = Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn);
		
	}
	else if(form_list.equalsIgnoreCase("V"))
	{
		if(recordsCount!=0)
		{
			totalRecords = recordsCount;
		}
		else
		{
			totalRecords= Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn);
			if(totalRecords<10 && size < 10 )
			{
				totalRecords = 10;
			}
			else
			{
				totalRecords = size;
			}
		}
	}
%>
<form name='Order_Catalog_MultiConsent_AddEdit' id='Order_Catalog_MultiConsent_AddEdit'>
<input type="hidden" name="first" id="first" value="">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="consent_sql" id="consent_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND")%>">
<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<INPUT TYPE="hidden" name="form_list" id="form_list" value="<%=form_list%>">
<INPUT TYPE="hidden" name="befOrder" id="befOrder" value="<%=consent_req_bef_order%>">
<INPUT TYPE="hidden" name="befRegn" id="befRegn" value="<%=consent_req_bef_regn%>">
<INPUT TYPE="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=catalogCode%>">
<INPUT TYPE="hidden" name="catalog_desc" id="catalog_desc" value="<%=catalogDesc%>">
<INPUT TYPE="hidden" name="categoryDesc" id="categoryDesc" value="<%=categoryDesc%>">
<INPUT TYPE="hidden" name="orderTypeDesc" id="orderTypeDesc" value="<%=orderTypeDesc%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

<table class='grid' width="100%" id="consent_details">

<%
	int k = 1;
	for(int i=0;i<totalRecords;i++)
	{
		if ( j % 2 == 0 )
		{
			classValue = "gridData" ;
		}
		else
		{
			classValue = "gridData" ;
		}
		int num = i + 1;
		if((i+1)<=size && (form_list.equalsIgnoreCase("F") || form_list.equalsIgnoreCase("V")))
		{
			orMultiConsent = (String[]) a.get(i);
			consentDesc = orMultiConsent[0];
			consentID = orMultiConsent[1];
			consentStage = orMultiConsent[2];
			dfltSelected = orMultiConsent[3];
			tempConsentDesc = orMultiConsent[5];
			//System.out.println("==="+tempConsentDesc+"======"+consentDesc);
			sequenceNumber = Integer.parseInt(orMultiConsent[4]);
			if(change.equals("Y") || change.equals("NR"))
			{
				select = orMultiConsent[6];
			}
			if(form_list.equals("F"))
			{
				out.println("<tr id=rowId><td class='" + classValue + "' align='left' width='15%' nowrap><a href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
				%>
				<input type="hidden" name='select<%=i%>' id='select<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<tr id=rowId>
			<TD width="10%" class='<%=classValue%>'>
				<%
				if(change.equals("Y") || change.equals("NR"))
				{
					if(select.equals("Y"))
					{
				%>
						<input type="checkbox" name='select<%=i%>' id='select<%=i%>' value="Y" checked>
					<%
					}
					else
					{
					%>
						<input type="checkbox" name='select<%=i%>' id='select<%=i%>' value="">
					<%
					}
				}
				else
				{
					%>
						<input type="checkbox" name='select<%=i%>' id='select<%=i%>' value="Y" checked>
				<%
				}
				%>
			</TD>
			<%
				out.println("<td class='" + classValue + "'width='14%' nowrap><a class='gridLink' href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
			}
			%>
			<input type=hidden name='seq_no<%=i%>' id='seq_no<%=i%>' value="<%=num%>">
			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="42%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="30%" class='<%=classValue%>'>  
			<%
			}
			%>
				<input type='text' name='consent_desc<%=i%>' id='consent_desc<%=i%>' value="<%=consentDesc%>" onBlur="colorResetCode(this);before_show_consent_lookup(this,consent_form_id<%=i%>,temp_consent_desc<%=i%>);"><input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_lookup(consent_desc<%=i%>,consent_form_id<%=i%>,temp_consent_desc<%=i%>)">
				<input type=hidden name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' value="<%=consentID%>">
				<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="<%=tempConsentDesc%>">
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="45%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="32%" class='<%=classValue%>'>  
			<%
			}
			%>
				<select name='consent_stage<%=i%>' id='consent_stage<%=i%>' onBlur="colorResetCode(this);">
					<%
					if(!consentStage.equals("") && consentStage.equalsIgnoreCase("A"))
					{
						if(befOrder > 0 && befRegn==0)
						{
					%>
							<option value='A' selected><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
							<option value='A' selected><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<%
						}
					}
					else if(!consentStage.equals("") && consentStage.equalsIgnoreCase("R"))
					{
						if(befOrder==0 && befRegn > 0)
						{
					%>
							<option value='R' selected><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
							<option value='R' selected><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<%
						}
					}
					else
					{
						if(befOrder > 0 && befRegn==0)
						{
					%>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
						<%
						}
						else if(befOrder==0 && befRegn > 0)
						{
						%>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<%
						}
					}
					%>
				</select>
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
				<input type="hidden" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<td width="18%" align="center" class='<%=classValue%>'>
					<%
					if(!dfltSelected.equals("") && dfltSelected.equalsIgnoreCase("Y") && form_list.equalsIgnoreCase("V"))
					{
					%>
						<input type="checkbox" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y" checked onclick="callFunction(<%=i%>);">
					<%
					}
					else if((dfltSelected.equals("") || dfltSelected.equalsIgnoreCase("N")) && form_list.equalsIgnoreCase("V"))
					{
					%>
						<input type="checkbox" name='mandatory<%=i%>' id='mandatory<%=i%>' value="" onclick="callFunction(<%=i%>);">
					<%
					}
					%>	
			</td>
		<%
			}
		}
		else if((i+1)<=totalList)
		{
			if(form_list.equals("F"))
			{
				out.println("<tr id=rowId><td class='" + classValue + "' width='15%' nowrap><a href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
				%>
				<input type="hidden" name='select<%=i%>' id='select<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<tr id=rowId>
			<TD width="10%" class='<%=classValue%>'>
				<input type="checkbox" name='select<%=i%>' id='select<%=i%>' value="Y" checked>
			</TD>
			<%
			out.println("<td class='" + classValue + "' width='13%' nowrap><a href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
			}
			%>

			<input type=hidden name='seq_no<%=i%>' id='seq_no<%=i%>' value="<%=num%>">

			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="42%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="30%" class='<%=classValue%>'>  
			<%
			}
			%>
				<input type='text' name='consent_desc<%=i%>' id='consent_desc<%=i%>' value="" onBlur="colorResetCode(this);before_show_consent_lookup(this,consent_form_id<%=i%>,temp_consent_desc<%=i%>);"><input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_lookup(consent_desc<%=i%>,consent_form_id<%=i%>,temp_consent_desc<%=i%>)">
				<input type=hidden name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' value="">
				<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="">
				
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="45%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="32%" class='<%=classValue%>'>  
			<%
			}
			%>
				<select name='consent_stage<%=i%>' id='consent_stage<%=i%>' onBlur="colorResetCode(this);">
					<%
						if(befOrder > 0 && befRegn==0)
						{
					%>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
						<%
						}
						else if(befOrder==0 && befRegn > 0)
						{
						%>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<%
						}
					%>
				</select>
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
				<input type="hidden" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<td width="18%" class='<%=classValue%>'>
				<%
				if(form_list.equalsIgnoreCase("V"))
				{
				%>
					<input type="checkbox" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y" onclick="callFunction(<%=i%>);">
				<%
				}
				%>
			</td>
		<%
			}
		}
		else if(form_list.equalsIgnoreCase("V"))
		{
			if(form_list.equals("F"))
			{
				out.println("<tr id=rowId><td class='" + classValue + "' width='15%' nowrap><a href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
				%>
				<input type="hidden" name='select<%=i%>' id='select<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<tr id=rowId>
			<TD width="10%" class='<%=classValue%>'>
				<input type="checkbox" name='select<%=i%>' id='select<%=i%>' value="Y" checked>
			</TD>
			<%
			out.println("<td class='" + classValue + "' width='13%' nowrap><a href='javascript:panelposition("+num+");onclick=callfun("+num+");' title='Click to sort the row'> "+num+" </a></td>");
			}
			%>
			<input type=hidden name='seq_no<%=i%>' id='seq_no<%=i%>' value="<%=num%>">
			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="42%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="30%" class='<%=classValue%>'>  
			<%
			}
			%>
				<input type='text' name='consent_desc<%=i%>' id='consent_desc<%=i%>' value="" onBlur="colorResetCode(this);before_show_consent_lookup(this,consent_form_id<%=i%>,temp_consent_desc<%=i%>);"><input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_lookup(consent_desc<%=i%>,consent_form_id<%=i%>,temp_consent_desc<%=i%>)">
				<input type=hidden name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' value="">
				<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="">
				
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
			<td width="45%" class='<%=classValue%>'>  
			<%
			}
			else
			{
			%>
			<td width="32%" class='<%=classValue%>'>  
			<%
			}
			%>
				<select name='consent_stage<%=i%>' id='consent_stage<%=i%>' onBlur="colorResetCode(this);">
					<%
						if(befOrder > 0 && befRegn==0)
						{
					%>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
						<%
						}
						else if(befOrder==0 && befRegn > 0)
						{
						%>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
							<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
							<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<%
						}
					%>
				</select>
			</td>
			<%
			if(form_list.equals("F"))
			{
			%>
				<input type="hidden" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y">
			<%
			}
			else
			{
			%>
			<td width="18%" class='<%=classValue%>'><input type="checkbox" name='mandatory<%=i%>' id='mandatory<%=i%>' value="Y" onclick="callFunction(<%=i%>);"></td>
		<%
			}
		}
		out.println("</tr>");
		j++;
		k++;
	}
	a.clear();
%>
<%
	if(form_list.equals("F"))
	{%>
		<tr id='last' class='<%=classValue%>'>
		<td class='<%=classValue%>' width='15%' nowrap>
			<a href='javascript:panelposition("<%=totalRecords+1%>","X");onclick=callfun("<%=totalRecords+1%>");' title='Click to sort the row'> <%=totalRecords+1%> </a>
		</td>

	<%}
	else
	{
%>		
	<tr id='last' >
		<TD width="10%" class='<%=classValue%>'>
		<input type="checkbox" name='select<%=totalRecords+1%>' id='select<%=totalRecords+1%>' value="Y" checked>
		</TD>
		<td class='<%=classValue%>' width='12%' nowrap>
			<a href='javascript:panelposition("<%=totalRecords+1%>","X");onclick=callfun("<%=totalRecords+1%>");' title='Click to sort the row'> <%=totalRecords+1%> </a>
		</td>
	<%
	}
	%>
		<td></td><td></td><td></td>
	</tr>	

</table>

<%
out.println("<script>showvis('true')</script>");
putObjectInBean(bean_id,bean,request);
%>
</form>
</body>
</html>

