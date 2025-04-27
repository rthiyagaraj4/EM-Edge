<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8 " import="java.util.*, ePH.*,eCommon.Common.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> --> 
	<%
	request.setCharacterEncoding("UTF-8");
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/TPNConsLimits.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%

ArrayList ageGroups=new ArrayList();
ArrayList RegimenList=new ArrayList();

String bean_id					= "TPNConsLimitsBean";
String bean_name				= "ePH.TPNConsLimitsBean";
String mode=request.getParameter("mode");
String  regimen_name="";
String  regimen_code="";

if ( mode == null || mode.equals("") )
       return ;
if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
       return ;

TPNConsLimitsBean bean			= (TPNConsLimitsBean)getBeanObject( bean_id,bean_name,request);
bean.setLanguageId(locale);
ageGroups=bean.getAgeGroups(locale);
RegimenList=bean.getRegimenList();
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<br>
<form name="FormTPNConsLimit" id="FormTPNConsLimit" >
	<table cellpadding="2" cellspacing="0" width="98%" align="center" border="0">
		<tr>
			<td align="right" class="label" nowrap><fmt:message key="ePH.Non-StandardRegimen.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;
			<select name="Regimen_Code" id="Regimen_Code" onChange="enableagegrp();">><option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			 <%
						for (int i=0;i<RegimenList.size();i=i+2){
							String desc		=(String)RegimenList.get(i);
							String code		=(String)RegimenList.get(i+1);
						%>
							<option value="<%=code%>"><%=desc%></option>						
						<%}
						
				%>
			</select>
			</td>
			<td colspan="4">&nbsp;</td>
<!-- 	onfocus="searchItem(this)"-->	
		</tr>
		<tr>	<td align="right" class="label" width="20%"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td><!-- checkforvalid(this);//removed -->
				<td align="left" width="20%">&nbsp;&nbsp;<select name="age_group" id="age_group" onChange="setagevalues(this);validateAgegroup();"><option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<%
						for (int i=0;i<ageGroups.size();i=i+6){
							String code		=(String)ageGroups.get(i);
							String desc		=(String)ageGroups.get(i+1);
							String gender	=(String)ageGroups.get(i+2);					out.println("<script>genderArray['"+code+"']='"+gender+"';</script>");								

						%>
							<option value="<%=code%>"><%=desc%></option>						
						<%}
				
				
				%>

				</select>
				
			</td>
			<td align="right" class="label"  width="20%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td align="left" width="10%" class="data">&nbsp;&nbsp;<label id="gender"   name="gender"><label></td>
			<INPUT TYPE="hidden" name="infusion_line" id="infusion_line" VALUE="C">
			
			<td align="right" class="label"  width="20%"></td>
			<td align="left" >	
			</td>

		</tr>
		<script>
				<%
					for (int i=0;i<ageGroups.size();i=i+6){

				  
					    
						String code1		=(String)ageGroups.get(i);
						String min_age		=(String)ageGroups.get(i+3);
						String max_age		=(String)ageGroups.get(i+4);
						String age_unit		=(String)ageGroups.get(i+5);
                     %>
						minageArray['<%=code1%>'] = "<%=min_age%>";
						maxageArray['<%=code1%>'] = "<%=max_age%>";
						ageunitArray['<%=code1%>'] = "<%=age_unit%>";
						
				
				<%	}
				%>

		</script>			
		<tr >
		<td align="right" class="label"><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></td>
		<td align="left" colspan="1">&nbsp;&nbsp;<input type="text" name="Min_Age" id="Min_Age"   maxlength="4" size="4" value=""readonly></td>

		<td align="right" class="label"><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></td><td align="left" colspan="1">&nbsp;&nbsp;<input type="text" name="Max_Age" id="Max_Age"   maxlength="4" size="4" value="" readonly></td>

		<td align="right" class="label"><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/></td><td align="left" colspan="1">&nbsp;&nbsp;<input type="text" name="Age_Unit" id="Age_Unit"  maxlength="4" size="4" value="" readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>


		</tr>
	
	<tr>
	<td  colspan=6>&nbsp;</td>
	</tr>
		</table>
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="age_unit_code" id="age_unit_code" VALUE="">
<INPUT TYPE="hidden" name="gender_val" id="gender_val" VALUE="">

<% putObjectInBean(bean_id,bean,request); %>
<script>document.FormTPNConsLimit.age_group.disabled=true</script>
</form>
</body>
</html>


