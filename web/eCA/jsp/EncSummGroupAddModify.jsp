<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description 
-------------------------------------------------------------------------------------------------------------------------------------
18/07/2013     		1   		Sethuraman      Created for Adding encounter Summary Groups/Sub-Groups
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
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	String mode="";
	String readOnly = "";
	String status = "";
	String enabled_checked1="";
	
	String es_group_type="";
	String es_group_code="";

	String enabled_checked="";
	String es_group_type1="";
	String es_group_code1="";
	String es_group_desc1="";
	String es_group_remarks1="";	
	String es_group_image_url1="";	
	String es_group_status1="";	
	
	String checkedGroup="checked";	
	String checkedSubGroup="";	
	
	String disabledStatus = "disabled";
	
	int es_group_flag = 0;
	int es_group_flag1 = 0;
	
	int nGroupListSize = 0;
	int ntypeListSize = 0;

	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 	
	
	List<EncSummHistTypeBean> oHistTypeList = null;
	EncSummHistTypeBean sHistTypeBean = null;
	
	List<EncSummGroupBean> oSummGrpList = null;
	EncSummGroupBean sSummGroupBean = null;	
	
	String oHistType = "";

	if(mode=="insert" || mode.equals("insert") || mode == null) 
	{
		mode="insert";
		enabled_checked1 = "checked";		
		
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
	}
	
	ntypeListSize = 0;
	
	if(mode.trim().equalsIgnoreCase("update")){	
		
		oSummGrpList = new ArrayList<EncSummGroupBean>();
		sSummGroupBean = new EncSummGroupBean(); 	
		
		es_group_flag = Integer.parseInt(request.getParameter("es_group_flag"));
		es_group_type = (request.getParameter("es_group_type")==null)?"":request.getParameter("es_group_type");
		es_group_code = (request.getParameter("es_group_code")==null)?"":request.getParameter("es_group_code");
		
		sSummGroupBean.setRequest(request);	
		sSummGroupBean.setiGroupFlag(es_group_flag);
		sSummGroupBean.setsGroupType(es_group_type);
		sSummGroupBean.setsGroupCode(es_group_code);
		
		oSummGrpList = summGrpDetails.getSummaryGroupDetails(sSummGroupBean);
		nGroupListSize = oSummGrpList.size();
		if (nGroupListSize>0){
			
			EncSummGroupBean oSummGroupBean = null;
			oSummGroupBean = oSummGrpList.get(nGroupListSize-1);
			
			oHistTypeList = new ArrayList<EncSummHistTypeBean>();
			sHistTypeBean = new EncSummHistTypeBean();
			
			sHistTypeBean.setRequest(request);
			sHistTypeBean.setsHistTypeRec(es_group_type);
			
			es_group_flag1 = es_group_flag;
			
			if (es_group_flag == 1)
			{
				checkedSubGroup = "checked";
			}
			else
			{
				checkedGroup = "checked";
			}
			es_group_type1 = oSummGroupBean.getsGroupType();
			
			if (es_group_type1.equalsIgnoreCase("ug"))
			{
				oHistType = oHistType + "<Option value=\"UG\"> User Defined </option>";
			}
			else
			{
				sHistTypeBean.setsHistTypeRec(es_group_type1);
				oHistTypeList = summGrpDetails.getSummaryGroupType(sHistTypeBean);		
				
				ntypeListSize = oHistTypeList.size();
				
				if (ntypeListSize>0){
					for (int i=0;i<ntypeListSize;i++){
						sHistTypeBean = oHistTypeList.get(i);
						oHistType = oHistType + "<Option value="+sHistTypeBean.getsHistTypeRec()+">" +sHistTypeBean.getsShortDesc()+ "</option>";
					}
				}
			}

			es_group_code1 = oSummGroupBean.getsGroupCode();
			es_group_desc1 = oSummGroupBean.getsGroupDesc();
			es_group_remarks1 = oSummGroupBean.getsGroupRemarks();			
			es_group_image_url1 = oSummGroupBean.getsImageURL();			
			es_group_status1 = oSummGroupBean.getsGroupStatus();				
			
			if (es_group_status1.equalsIgnoreCase("e"))
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
<script language='javascript' src='../js/EncSummaryGroup.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>

<form name="summgroup_form" id="summgroup_form" action="../../servlet/eCA.EncSummGroupServlet" method="post" enctype="multipart/form-data" target="messageFrame">
<BR>
<table border=0 cellspacing=0 cellpadding='3' width='90%' align=center>
<tr>
	    <td class=label ><fmt:message key="Common.GroupSubFlag.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type='radio' name='es_group_flag' id='es_group_flag' value=0 <%=checkedGroup%> <%= status%> onclick='checkApplicable(this);'><fmt:message key="Common.Group.label" bundle="${common_labels}"/> 
		<input type='radio' name='es_group_flag' id='es_group_flag' value=1 <%=checkedSubGroup%> <%= status%> onclick='checkApplicable(this);'><fmt:message key="Common.SubGroup.label" bundle="${common_labels}"/>		
		</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<select name='es_group_type' id='es_group_type'  onchange='mainGroupType(this)' <%= status%>>
	<%
		if (mode=="insert"){
	%>
	<option value="">-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>	
	<%=oHistType%>
	<option value="UG">User Defined</option>
	<%
		}
		else
		{
	%>
		<%=oHistType%>
	<%
		}
	%>
	</select><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="es_group_code" id="es_group_code" value="<%=es_group_code1%>" <%=readOnly%> <%=status%> 
	size=16 maxlength=16 onkeypress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);getGroupCode(this,'<%=locale %>')" >
	<input type="button" value="?"  class="button" name='groupCode_srch' id='groupCode_srch' OnClick="getGroupCode(this,'<%=locale %>')" <%= disabledStatus%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="es_group_desc" id="es_group_desc" value="<%=es_group_desc1%>" size=30 maxlength=64  onBlur="checkdefaultdesc();return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>	
	<td class='fields' >&nbsp;<textarea name="es_group_remarks"  maxlength='200' rows="3" cols ="60"  onchange='chopText(this,200)' ><%=es_group_remarks1%></textarea></td>	
</tr>
<tr>
	<td class=label ><fmt:message key="Common.ImageURL.label" bundle="${common_labels}"/></td>	
	<%
		if (mode=="insert"){
	%>
	<td class='fields'>&nbsp;<input type="file" name="es_group_image_url" id="es_group_image_url" size=128 maxlength=128></td>
	<%
		}
		else
		{
	%>
	<td class='fields' >&nbsp;<input type="text" name="es_group_image_url" id="es_group_image_url" value="<%=es_group_image_url1%>" <%=readOnly%> <%=status%> 
		size=96 maxlength=128></td>
	<%
		}
	%>	
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields><input type="checkbox" name="es_group_status" id="es_group_status" value="E" <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="es_group_flag1" id="es_group_flag1" value="<%=es_group_flag1%>">
<input type=hidden name="es_group_type1" id="es_group_type1" value="<%=es_group_type1%>">
<input type=hidden name="es_group_code1" id="es_group_code1" value="<%=es_group_code1%>">
<input type=hidden name="es_group_desc1" id="es_group_desc1" value="<%=es_group_desc1%>">
<input type=hidden name="es_group_remarks1" id="es_group_remarks1" value="<%=es_group_remarks1%>">
<input type=hidden name="es_group_image_url1" id="es_group_image_url1" value="<%=es_group_image_url1%>">
<input type=hidden name="es_group_status1" id="es_group_status1" value="<%=es_group_status1%>">
<input type=hidden name="es_image_name" id="es_image_name" value="">
<input type=hidden name="flag" id="flag" value="true">
</form>
</body>
</html>

