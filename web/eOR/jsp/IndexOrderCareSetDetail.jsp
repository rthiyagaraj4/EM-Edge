<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eOR.*, eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="JavaScript" src="../js/IndexOrderCareSet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">

	A:active {
		COLOR: white;
	}

	A:visited {
		COLOR: white;
	}
	A:link {
		COLOR: white;
	}
 

	</STYLE>

</head>

<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode				= request.getParameter( "mode" ) ;
	String index_type		= request.getParameter( "index_type" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String care_set_id		= request.getParameter( "care_set_id" ) ;
	if(order_category == null )	order_category = "";

	String bean_id		= "indexordercareset" ;
	String bean_name	= "eOR.IndexOrderCareSetBean";
	//String readOnly		= "" ;
	//String disabled		= "" ;
	mode="1";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCareSetBean bean = (IndexOrderCareSetBean)getBeanObject( bean_id, bean_name, request );
	/* Initialize Function specific end */
%>

<form name="form_index_care_set_detail" id="form_index_care_set_detail">
<table cellpadding=3 cellspacing=0 border ="0" width="100%" height='100%' align="center" id="Tab">
<%if(index_type.equals("F"))
{%>
	<tr>
		<td class="label" width='30%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="facility_id" id="facility_id">
				<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%=bean.getComboOptionsFacId()%>
			</select>
			<img src="../../eCommon/images/mandatory.gif" align='center'></img>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="source_type" id="source_type" onChange="callSourceDtl(this);" >
				<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
			<img src="../../eCommon/images/mandatory.gif" align='center'></img>
		</td>
	</tr>
	<tr id="rowSelAssTab" style="visibility:hidden">
		<td colspan='2'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td align="center" id="SelectTab" name="SelectTab" class="clicked" width="15%" height="20" >
						<a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a>
					</td>
					<td align="center" id="AssociateTab" name="AssociateTab" class="normal" width="15%" height="20" >
						<a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr id="rowLinkTab" style="visibility:hidden">
		<td colspan='2' id='linkId' class="COMMONTOOLBARFUNCTION">
			<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
		</td>
	</tr>
<%}else if((index_type.equals("S")) || (index_type.equals("P")))
{%>
<tr>
		<td colspan='2'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td align="center" id="SelectTab" class="clicked" width="15%" height="20" ><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td align="center" id="AssociateTab" class="normal" width="15%" height="20" ><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan='2' id='linkId' class="COMMONTOOLBARFUNCTION">
			<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
		</td>
	</tr>
	<input type="hidden" name="source_type" id="source_type" value=""><input type="hidden" name="facility_id" id="facility_id" value="">
<%}else if(index_type.equals("D"))
	{		
		String diagcode[] = new String[2];
		diagcode = bean.getDiagCodeString(care_set_id);
		String[] record	   = null;
		String diag_scheme_value="ICD10";
%>
<tr>
		<td class="label" width='30%'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
		<td class="fields" ><select name="diag_code_scheme" id="diag_code_scheme">
		<%
			ArrayList Diag_scheme =	null;
			Diag_scheme = bean.getDiagScheme();
				for(int i=0; i<Diag_scheme.size(); i++)
				{
					record = (String[])Diag_scheme.get(i);
					if(diag_scheme_value.equals(record[0]))
						out.println("<option value = \""+record[0]+"\" selected> "+record[1]+"");
					else
						out.println("<option value = \""+record[0]+"\"> "+record[1]+"");
					record	= null;
				}
				Diag_scheme = null;
			%></select><input type='hidden' name='diagnosis_code' id='diagnosis_code' value="">
			<input type="text" name="diagnosis_code_desc" id="diagnosis_code_desc" readonly><input type='button' name='diagnosis_button' id='diagnosis_button' class='button' value='?' onClick="show_window()">
			<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	</tr>
	<%diagcode=null;
		}else if(index_type.equals("A"))
{		//String diagcode[] = new String[2];
		//diagcode = bean.getPatDiagCodeString(care_set_id);
%>	<tr>
		<td class="label" width='30%'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
		<td class="fields" >
			<input type="text" name="diagnosis_code" id="diagnosis_code" readonly><input type='button' name='practitioner_button' id='practitioner_button' class='button' value='?' onClick="show_pat_diagnosis_window()">
			<input type="hidden" name="diagnosis_desc" id="diagnosis_desc" value=''>
			<img src="../../eCommon/images/mandatory.gif" align='center'></img>
			<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value=''>
		</td>
	</tr>
	<%}%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="index_type" id="index_type" value="<%=index_type%>">
<input type="hidden" name="tabVal" id="tabVal" value="S">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="care_set_id" id="care_set_id" value="<%=care_set_id%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="pat_diagnosis_sql" id="pat_diagnosis_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_PAT_DIAG_SELECT")%>">
</form>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

