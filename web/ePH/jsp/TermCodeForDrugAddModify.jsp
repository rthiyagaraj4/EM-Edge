<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>


<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/TermCodeForDrug.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<!-- <BODY>  -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	
	String bean_id	="TermCodeForDrug";
	String bean_name	="ePH.TermCodeForDrugBean";
    
	String drug_code="";	
	String drug_desc="";	
	
	String Term_desc="";
	String Term_code="";
	String TermSetList_code="";
    String mode="1";
	
	String code="";	
	String desc="";	
	
	String term_code="";
   String term_code_desc="";
   String term_set_id="";
   String term_set_desc="";
   String eff_status="";
   String drug_desc11="";
   String drug_code11="";
   String eff_status_check="";
   String retVal0="";
   String retVal1="";
  

	TermCodeForDrugBean bean = (TermCodeForDrugBean)getBeanObject(bean_id,bean_name ,request);

   ArrayList termlist=new ArrayList(); 
   HashMap termlistvalues=new HashMap();
   
   bean.setLanguageId(locale);
   termlist=bean.getTermList();

	term_code		=	request.getParameter("term_code");
	mode			=	request.getParameter("mode");
	term_code_desc	=	request.getParameter("term_code_desc");
	term_set_id		=	request.getParameter("term_set_id");
	term_set_desc	=	request.getParameter("term_set_desc");
	eff_status		=	request.getParameter("eff_status");
	
	if(eff_status==null)
	{
      eff_status="";
	}
	//drug_desc11		=	request.getParameter("drug_desc");
	drug_desc11		=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
	//drug_code11		=	request.getParameter("drug_code");
	drug_code11		=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");

	
	retVal0			=	request.getParameter("retVal0");
	retVal1			=	request.getParameter("retVal1");
	mode			=	request.getParameter("mode");
	//Added on Dt:8/9/09
	if(drug_desc11.length()==0)
	drug_desc11=retVal1;
	
	if(drug_code11.length()==0)
	drug_code11=retVal0;
	
	if(mode==null)
	{
		mode="1";
	}
   
 
   bean.setMode( mode ) ;

   
		if(eff_status.equals("E")){
			eff_status_check = "checked";
		}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<form name="TermCodeAddModifyform" id="TermCodeAddModifyform">
<table cellpadding="1" cellspacing="0" width="100%" align="center" border="0">
<input type="hidden" name="SQL_PH_DRUG_SEARCH_DRUG" id="SQL_PH_DRUG_SEARCH_DRUG" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2")%>">
<input type="hidden" name="SQL_PH_TERM_CODE_SELECT_LOOKUP" id="SQL_PH_TERM_CODE_SELECT_LOOKUP" value="<%=PhRepository.getPhKeyValue("SQL_PH_TERM_CODE_SELECT_LOOKUP")%>">

<tr>
	<td class="label"></td>
	<td class="label"></td>
    <td class="label"></td>
    <td class="label"></td>

</tr>
<%if(mode.equals("1")){%>
<tr>
<td  class="label"  width="20%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
			
			<td align="left" width="80%">&nbsp;&nbsp;<input type="text" maxlength="60" size="40" name="drug_desc" id="drug_desc"   value="<%=drug_desc%>"readOnly><input type="button" class="button" value="?"   onClick="searchCode(this);"  ><img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif"><input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			</td>
			
         
			<td class="label">
			</td>
			<td class="label">
			</td>

</tr>
<tr>
<td  class="label" align="right" ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
<td>&nbsp;
            <select name="TermSetList" id="TermSetList" onChange="clearValues();">
			<option value="" >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<% for(int i=0; i<termlist.size(); i++)
				{
					termlistvalues = (HashMap)termlist.get(i);
					code = (String)termlistvalues.get("code");
                    desc = (String)termlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
			</select>
			<img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
</td>
            <td class="label"></td>
			<td class="label"></td>
</tr>
<tr>
<td  class="label" width="20%" ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
          <td align="left"width="80%">&nbsp;&nbsp;<input type="text" maxlength="120" size="80" name="Term_desc" id="Term_desc"   value="<%=Term_desc%>" readOnly><input type="button" class="button" value="?"   onClick="searchCode1(this)">
			<img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
			<input type="hidden" name="Term_code" id="Term_code" value="<%=Term_code%>">
			</td>
 
  <td class="label"></td>
  <td class="label"></td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class="label">
	<input type="checkbox" name="chk_opt" id="chk_opt" value="E" checked></td>
  <td class="label"></td>
  <td class="label"></td>
</tr>
<%}%>
<%
if(mode.equals("2") && mode!=null)
{
	%>
<tr>
<td  class="label"  width="20%" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
			
			<td align="left" width="80%">&nbsp;&nbsp;<input type="text" maxlength="60" size="40" name="drug_desc" id="drug_desc"   value="<%=drug_desc11%>"readOnly ><input type="button" name="drug_desc_name" id="drug_desc_name" class="button" value="?"   onClick="searchCode(this);" disabled ><img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif"><input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code11%>">
			</td>
         
			<td class="label">
			</td>
			<td class="label">
			</td>

			</tr>
			<tr>
<td  class="label" align="right" ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
<td>&nbsp;
                    <select name="TermSetList" id="TermSetList" disabled>
					
					<option value="" >-----select------</option>
				<% for(int i=0; i<termlist.size(); i++)
				{
					termlistvalues = (HashMap)termlist.get(i);
					code = (String)termlistvalues.get("code");
                    desc = (String)termlistvalues.get("desc");
			if(term_set_id.equals(code))
					{
			%>
            <OPTION value="<%=term_set_id%>"selected><%=desc%></OPTION>
			<%
			
			}
			else{%>
			 <OPTION value="<%=code%>"><%=desc%></OPTION>
		
			<%}
			}%>
			</select>
			<img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
</td>
            <td class="label"></td>
			<td class="label"></td>
</tr>
<tr>
<td  class="label" width="20%" ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/> </td>
          <td align="left"width="80%">&nbsp;&nbsp;<input type="text" maxlength="120" size="80" name="Term_desc" id="Term_desc"   value="<%=term_code_desc%>"readOnly ><input type="button" name ="Term_desc_name" class="button" value="?" disabled  onClick="searchCode1(this)">
			<img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
			<input type="hidden" name="Term_code" id="Term_code" value="<%=term_code%>">
			</td>
 
  <td class="label"></td>
  <td class="label"></td>
</tr>
<tr>
	<td align="right" class="label">
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class="label">
	<input type="checkbox" name="chk_opt" id="chk_opt" value="E" <%=eff_status_check%>></td>
  <td class="label"></td>
  <td class="label"></td>
</tr>
<%}%>
</table>
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode"		value="<%= mode %>">	
</form>
<script>document.forms[0].drug_desc.focus();</script>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

