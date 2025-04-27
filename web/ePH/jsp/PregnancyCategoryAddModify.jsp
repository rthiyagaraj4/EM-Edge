<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
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
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>


	
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PregnancyCategory.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>
<style>
textarea {
  resize: none;
}
</style>
<!-- <body onMouseDown="CodeArrest()"  onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "PregnancyCategory" ;
	String bean_name = "ePH.PregnancyCategoryBean";


	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		
	/* Mandatory checks end */


	PregnancyCategoryBean bean = (PregnancyCategoryBean)getBeanObject( bean_id, bean_name, request ) ;
    bean.clear() ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;

	int	    totalRecords	=	0;	
	String categoryGroupCode ="";
	String categoryGroupDescription = "";
	String categoryGroupStatus = "E";
	String categoryGroupCheck = "checked";
	String categoryCode = "";
	String categoryDescription = "";
	String categoryStatus ="Y";
	String categoryCheck = "";
	String readOnly = "";
	String check = "checkCGCode(this);";
	String dbMode = "I";
	String categoryReadOnly = "";
	ArrayList categoryList = new ArrayList();
	ArrayList categoryGroupList = new ArrayList();

	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

%>	
<form name="PregnancyCategoryForm" id="PregnanctCategory" >
<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			readOnly = "readonly";
			check="";
			categoryGroupCode = request.getParameter("cgCode");
			categoryGroupList = bean.getPregnancyCategoryInfo(categoryGroupCode,locale);
			categoryGroupDescription = categoryGroupList.get(0).toString();
			//categoryGroupDescription = java.net.URLDecoder.decode(categoryGroupDescription,"UTF-8");
			categoryGroupStatus = categoryGroupList.get(1).toString();
			if (categoryGroupStatus.equals("E"))
				categoryGroupCheck = "checked";
			else
				categoryGroupCheck = "";
			categoryList = bean.getCategoryList(categoryGroupCode,locale);
					
		}
%>
<br>
<table cellpadding="1" cellspacing="0" width="75%"  border=0>
 <tr>
			<td  class="label"><fmt:message key="ePH.CategoryGroupCode.label" bundle="${ph_labels}"/> </td>
			<td colspan="1" >&nbsp;&nbsp;
				<input type="text" name="cgCode" id="cgCode" size="8" maxlength="6" onKeyPress="return CheckForSpecChars(event);" class="UPPER" onBlur='CodeCheck(this);<%= check%>' value="<%= categoryGroupCode%>" <%=readOnly %> />
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
            
</tr>
 <tr>
			<td  class="label"><fmt:message key="ePH.CategoryGroupDesc.label" bundle="${ph_labels}"/>  </td>
			<td colspan="1" >&nbsp;&nbsp;
				<input type="text" name="cgDesc" id="cgDesc" size="65" maxlength="60"  value="<%= categoryGroupDescription%>" onBlur ="makeValidString(this);allow_nochars1(this)" onKeyPress = "return allow_nochars();" >
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
            
</tr>
<tr>
			<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan="1" >&nbsp;
				<input type="checkbox" name="cgStatus" id="cgStatus" value="<%= categoryGroupStatus%>" <%= categoryGroupCheck%>>
			</td>
            
</tr>
</table>
<br><br>
<div style="overflow-y: auto; max-height: 78vh;">
    <table cellpadding="0" cellspacing="0" width="70%"  border=1 align="center">
        <TR>
            <TH width="30%"> <fmt:message key="Common.category1.label" bundle="${common_labels}"/> </TH>
            <TH width="50%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
            <TH width="50%"> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TH>
        </TR>
        <%
        String classValue="";
        int i=0;
        for ( int cnt=1; cnt<=totalRecords+2; cnt++ ) {
            if(cnt%2 ==0)
                classValue="QRYEVEN";
            else
                classValue="QRYODD";
            if((mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ))&&(i<categoryList.size())){
                categoryReadOnly ="readonly";
                categoryCode = categoryList.get(i++).toString();
                categoryDescription =  categoryList.get(i++).toString();
                categoryStatus = categoryList.get(i++).toString();
                if(categoryStatus.equals("Y"))
                    categoryCheck ="checked";
                else
                    categoryCheck = "";
                dbMode = "U";		
            }
            else
            {
                categoryReadOnly = "";
                categoryCode = "";
                categoryDescription = "";
                categoryStatus = "Y";
                categoryCheck = "";
                dbMode = "I";
            }
        %>
         <TR >
                <TD CLASS="<%=classValue %>" >
                    <INPUT TYPE="text" NAME = "cCode<%=cnt %>" SIZE="4" value ="<%=categoryCode%>" MAXLENGTH="3" onKeyPress="return CheckForSpecChars(event)" onBlur="checkCCode(this,'<%=cnt%>');CodeCheck(this,'<%=cnt%>')" class="UPPER" <%=categoryReadOnly %> >
                </TD>
                <TD CLASS="<%=classValue %>" >
                    <textarea  rows='2'cols='50' name="cDesc<%=cnt %>"   onKeyPress="return allow_nochars();return(checkMaxLimit(this,600));return CheckForSpecChars(event);" 
                    onBlur ="makeValidString(this);allow_nochars2(this);pValidmaxlength(this);"  width="90%" MAXLENGTH="600"><%=categoryDescription%></textarea>
                </TD>
                <TD CLASS="<%=classValue %>" >
                    <input type="checkbox" name="cStatus<%=cnt%>" id="cStatus<%=cnt%>" value="<%=categoryStatus%>" <%=categoryCheck%>>
                </TD>
                <TD CLASS="<%=classValue %>" >
                    <input type="hidden" name="dbMode<%=cnt%>" id="dbMode<%=cnt%>" value="<%=dbMode%>" >
                </TD>
         </TR>
         <%}%>
    </table>
</div>



	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">	
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</FORM>

</BODY>
</HTML>

<%
categoryList.clear();
putObjectInBean(bean_id,bean,request);
%>

