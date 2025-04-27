<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
13/09/2013     		1   		Sethuraman      Created for Adding encounter Summary  
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String mode="";
	String readOnly = "";
	String status = "";
	String enabled_checked1="";	
	
	String es_summ_code="", es_summ_desc="", es_summ_title="", es_summ_status="", es_summ_type = "";
	String es_summ_code1="", es_summ_desc1="", es_summ_title1="", es_summ_status1="", es_summ_type1 = "";

	String enabled_checked="";
	
	String disabledStatus = "disabled";
	
	int nGroupSummListSize = 0;
	int ntypeListSize = 0;

	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 		
	
	List<EncSummHistTypeBean> oHistTypeList = null;
	EncSummHistTypeBean sHistTypeBean = null;
	
	String oHistType = "";
	
	oHistTypeList = new ArrayList<EncSummHistTypeBean>();
	sHistTypeBean = new EncSummHistTypeBean();
	
	sHistTypeBean.setRequest(request);
	oHistTypeList = summGrpDetails.getSummaryGroupType(sHistTypeBean);		
	
	ntypeListSize = oHistTypeList.size();
	if (ntypeListSize>0){
		for (int i=0;i<ntypeListSize;i++){
			sHistTypeBean = oHistTypeList.get(i);
			oHistType = oHistType + "<Option value="+sHistTypeBean.getsHistTypeRec()+">" +sHistTypeBean.getsShortDesc()+ "</option>";
		}
	}
	
	List<EncSummGroupSummBean> oSummGrpSummList = null;
	EncSummGroupSummBean sSummGroupSummBean = null;	

	if(mode=="insert" || mode.equals("insert") || mode == null) 
	{
		mode="insert";
		enabled_checked1 = "checked";	
	}
	
	if(mode.trim().equalsIgnoreCase("update")){	
		
		oSummGrpSummList = new ArrayList<EncSummGroupSummBean>();
		sSummGroupSummBean = new EncSummGroupSummBean();		
		
		es_summ_code = (request.getParameter("es_summ_code")==null)?"":request.getParameter("es_summ_code");		
		
		sSummGroupSummBean.setRequest(request);		
		sSummGroupSummBean.setsSummCode(es_summ_code);
		
		oSummGrpSummList = summGrpDetails.getSummaryDetails(sSummGroupSummBean);
		nGroupSummListSize = oSummGrpSummList.size();
		if (nGroupSummListSize>0)
		{			
			EncSummGroupSummBean oSummGroupSummBean = null;
			oSummGroupSummBean = oSummGrpSummList.get(nGroupSummListSize-1);			
			
			es_summ_code1 = oSummGroupSummBean.getsSummCode();
			es_summ_desc1 = oSummGroupSummBean.getsSummDesc();
			es_summ_title1 = oSummGroupSummBean.getsSummTitle();						
			es_summ_status1 = oSummGroupSummBean.getsSummStatus();		
			es_summ_type1 = oSummGroupSummBean.getsSummType();	
			
			if (es_summ_status1.equalsIgnoreCase("e"))
				enabled_checked1 = "checked";
			else
				enabled_checked1 = "";
		}
		
	}

	if(mode.trim().equalsIgnoreCase("update")) 
	{
		status="disabled" ;readOnly = "readonly"; 
	}
	else if(mode.trim().equalsIgnoreCase("insert"))
	{
		status = "enabled"; 
		readOnly = "";
	}
	else
	{
		status = "disabled"; 
		readOnly = "readonly";
	}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EncSummaryGroupSumm.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>

<form name="SummGroupSummForm" id="SummGroupSummForm" action="../../servlet/eCA.EncSummGroupSummServlet" method="post" target="messageFrame">
<BR>
<table border=0 cellspacing=0 cellpadding='3' width='90%' align=center>
<tr>
	<td class=label><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="es_summ_code" id="es_summ_code" value="<%=es_summ_code1%>" <%=readOnly%> <%=status%> 
	size=16 maxlength=16 onkeypress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);getSummCode(this)" >
	<input type="button" value="?"  class="button" name='SummCodesrch' id='SummCodesrch' OnClick='getSummCode(this)' <%= disabledStatus%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="es_summ_desc" id="es_summ_desc" value="<%=es_summ_desc1%>" size=30 maxlength=64  onBlur="checkdefaultdesc();return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.Title.label" bundle="${ca_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="es_summ_title" id="es_summ_title" value="<%=es_summ_title1%>" size=30 maxlength=64  onBlur="checkdefaultdesc();return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.SummaryType.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<select name='es_summ_type' id='es_summ_type'   enabled>	
		<option value="">-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>	
		<%=oHistType%>
		<option value="UG">User Defined</option>	
	</select><img src='../../eCommon/images/mandatory.gif'>
		<script>
			var tempObjName = 'es_summ_type';									
			if ('<%=es_summ_type1.length()%>' > 0 )
			{
				var selTempObj = document.getElementById(tempObjName);										
				for(var i=0;i<selTempObj.options.length;i++){											
		            if (selTempObj.options[i].value == '<%=es_summ_type1%>') {

		            	selTempObj.selectedIndex = i;
		                break;
		            }
		        }
			}
		</script>
	</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields><input type="checkbox" name="es_summ_status" id="es_summ_status" value="E" <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="es_summ_code1" id="es_summ_code1" value="<%=es_summ_code1%>">
<input type=hidden name="es_summ_desc1" id="es_summ_desc1" value="<%=es_summ_desc1%>">
<input type=hidden name="es_summ_title1" id="es_summ_title1" value="<%=es_summ_title1%>">
<input type=hidden name="es_summ_status1" id="es_summ_status1" value="<%=es_summ_status1%>">
<input type=hidden name="es_summ_type1" id="es_summ_type1" value="<%=es_summ_type1%>">
<input type=hidden name="flag" id="flag" value="true">
</form>
</body>
</html>

