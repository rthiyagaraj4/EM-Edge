<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/TextBlock.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
textarea {
  resize: none;
}
</style>

</head>
 
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<%
	
	String readOnly = "" ;
	String readOnlyID = "";
	String checked = " checked ";
	//String disabled="";
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_text_block" ;
	String bean_name = "eOR.TextBlockBean";

		String text_block_id="";
		String discr_msr_panel_id	="";
		String text_block="";
		String eff_status="E";
		String short_desc="";
	/* Initialize Function specific start */

	
	TextBlockBean bean = (TextBlockBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;

String[]  allVal=new String[4];
/* Initialize Function specific end */

	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {

		readOnlyID = "readOnly";
		
		try{
			text_block_id			=(String)request.getParameter("text_block_id" ) ;
			bean.setMode(mode);

			allVal =(String[]) bean.loadData(text_block_id);
			//System.out.println("===="+allVal);
			text_block_id=(String)allVal[0];
			discr_msr_panel_id=(String)allVal[1];
			text_block=(String)allVal[2];
			eff_status=(String)allVal[3];
			short_desc=(String)allVal[4];
			allVal=null;

			if(discr_msr_panel_id == null)
			 discr_msr_panel_id = "";
			if(short_desc == null)
			 short_desc = "";
				

			if(eff_status.equals("E")){
					checked="checked";
					//disabled="";
					eff_status="E";
					readOnly="";
					}
					else
					{
						checked="";
						//disabled="disabled";
						eff_status="D";
    					readOnly="readOnly";
					}


						readOnlyID = "readonly";
					}catch(Exception e){
							System.out.println("Exception here no 123 :"+e);
				}
	}
%>
<form name="text_block_add_modify" id="text_block_add_modify" method="post" target="messageFrame">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align='center'>
	<tr>
		<td width="20%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>
	<tr>
		<td width="15%"  class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td>
		<input type=text name="text_block_id" id="text_block_id" size=10 maxlength=10  value='<%=text_block_id%>'    onBlur='ChangeUpperCase(this)' onkeypress="return CheckForSpecChars(event)"
		<%=readOnlyID%>
		><img src="../../eCommon/images/mandatory.gif" align='center'></td>
		<td></td>
	</tr>
	<tr>
		<td width="20%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>
			<tr>
		<td width="25%" class="label"><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></td> 
		<td><%
		
		if(mode.equals("1")){%>
			<input type='hidden' name='discr_msr_panel_id' id='discr_msr_panel_id' value=""><input type='text' name='discr_msr_panel_desc' id='discr_msr_panel_desc' value="" size='30' maxlength='30' onBlur="before_showDiscreteWindow(this,discr_msr_panel_id);"><input type='hidden' name='discr_msr_panel_desc_temp' id='discr_msr_panel_desc_temp' value=""><input type='button' class='button' name='DiscreteSearch' id='DiscreteSearch' value='?' onClick="showDiscreteWindow(discr_msr_panel_desc,discr_msr_panel_id);">
			<input type='hidden' name='discrete_sql' id='discrete_sql' value="<%=OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_DISC_MEAS_LOOKUP")%>">
			<%}else{%>
		<input name=discr_msr_panel_id  value='<%=discr_msr_panel_id%>' type=hidden >
		<input type='text' name='discr_msr_panel_desc' id='discr_msr_panel_desc' size='30' maxlength='30' <%=readOnlyID%> value='<%=short_desc%>'>
			<%
		}%>
		
		</td>
		<td></td>
	</tr>
	<tr>
	<td colspan=3></td>
	</tr>
	<tr>
		<td class="label" width='15%'><fmt:message key="Common.TextBlock.label" bundle="${common_labels}"/></td> 
		<td>
		<textarea name='text_block'   <%=readOnly%> cols=54 rows=12 onBlur="SPCheckMaxLen('Text Block',this,2000,'');"  onkeyPress='return checkMaxLimit(this,2000)'   ><%=text_block%></TEXTAREA> 
		<img src="../../eCommon/images/mandatory.gif" align=center></td>
		<td></td>
		</tr>
	<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>
	
	<tr>
		<td width="" class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width=""  >
		<input name='eff_status_disp' id='eff_status_disp' type='checkbox' value='<%=eff_status%>'   <%=checked%> >
		<input type=hidden name='eff_status' id='eff_status' value='<%=eff_status%>'>
		</td>
		<td></td>
	</tr>
<tr>
		<td width="15%" ></td>
		<td width="80%"  colspan=""></td>
		<td></td>
	</tr>
	
</table>


<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="text_block">

</form>
</body>

</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>


