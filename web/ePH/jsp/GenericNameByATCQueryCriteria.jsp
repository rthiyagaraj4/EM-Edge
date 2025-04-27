<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
     request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/GenericNameByATC.js"></SCRIPT>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;  
	try{
	con				= ConnectionManager.getConnection(request);
    boolean generic_name_max_len_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","GENERIC_NAME_MAX_LEN_APP");//added for NMC-JD-CRF-0119 

	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	GenericNameByATCBean bean = (GenericNameByATCBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setLanguageId(locale);
     //added for NMC-JD-CRF-0119 - start
		String max_length = "";	

	if(generic_name_max_len_app)
		max_length = "100";
	else
		max_length = "40";
	//added for NMC-JD-CRF-0119 - end

%>
<form name="frmGenericnameByATCQueryCriteria" id="frmGenericnameByATCQueryCriteria" id="Generic Name By Query Criteria" method='post' action='GenericNameByATCQueryResult.jsp' target='genericNameFrame' >

	<br> 
	<table cellpadding=0 cellspacing=0 width="80%" align="center" id="queryCriteriaTable">				
		<thead >
		<tr>
			<th colspan="3"><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		</tr>
		</thead>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td></td>
			<td  class="label"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;
				<select name="drug_name" id="drug_name" onChange="hideExecute(this)">
					<option value="G"><fmt:message key="ePH.ByGenericName.label" bundle="${ph_labels}"/></option>
					<option value="A"><fmt:message key="ePH.ByATCClassification.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td  colspan="3" align="right" >
				<input type="button" class="BUTTON" name="btnExecute1" id="btnExecute1"  value="Execute" onClick="getQueryResult()" style="visibility:hidden">
			</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td  class="label" id="Name"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;
				<input type="text"  name="generic_name" id="generic_name"   size="42" maxlength="<%=max_length%>" >
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="label" id="drugclass"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td >&nbsp;&nbsp;
				<select name="drug_class" id="drug_class">
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N">Narcotic</option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="label" id="nature"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
			<td >&nbsp;&nbsp;
				<select name="eff_status" id="eff_status">
					<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="right" >
				<input type="button" class="BUTTON" name="btnExecute2" id="btnExecute2"  value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>' onClick="getQueryResult()" >
			</td>
		</tr>
	</table>
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	
</form>
</body>
<script language="javascript">

			if (document.frmGenericnameByATCQueryCriteria.drug_name.value=="A"){				
				
				document.getElementById("generic_name").style.visibility='hidden';
				document.getElementById("drug_class").style.visibility='hidden';
				document.getElementById("eff_status").style.visibility='hidden';	

				document.getElementById("btnExecute1").style.visibility='visible';
				var objRow=document.getElementById("queryCriteriaTable").children(1);

				objRow.children[3].style.visibility='hidden';
				objRow.children[4].style.visibility='hidden';
				objRow.children[5].style.visibility='hidden';
				objRow.children[6].style.visibility='hidden';
				objRow.children[7].style.visibility='hidden';
				objRow.children[8].style.visibility='hidden';
				
			}				
			else{				
				document.getElementById("generic_name").style.visibility='visible';
				document.getElementById("drug_class").style.visibility='visible';
				document.getElementById("eff_status").style.visibility='visible';				
				
			}
				
			document.frmGenericnameByATCQueryCriteria.drug_name.focus();

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}

%>

