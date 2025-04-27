<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>

	<script language="javascript" src="../../eOR/js/SectionForTickSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function setCheckStatus(thisObj)
{
			if(thisObj.checked == true){
				if(document.tick_sheet_section_dtl.description.disabled==true)
						document.tick_sheet_section_dtl.description.disabled=false;
					if(document.tick_sheet_section_dtl.description.readOnly==true)
							document.tick_sheet_section_dtl.description.readOnly=false;
						}
			else {
						thisObj.focus();
						if(document.tick_sheet_section_dtl.description.disabled==false){
						document.tick_sheet_section_dtl.description.disabled=true;
						}
						if(document.tick_sheet_section_dtl.description.readOnly==false){
						document.tick_sheet_section_dtl.description.readOnly=true;
						}
					}
		}
</script>
 </head>
 <body onload='FocusFirstElement()' onMouseDown="CodeArrest()">
 <%

	
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";


	/* Initialize Function specific start */

	String order_category_id="";
	String tick_sheet_id= "";
	String eff_status = "";
	String section_code ="";
	String seq_no = "";
	String section_desc = "";
	String order_category_short_desc="";
	String tick_sheet_desc="";
	String disabled="";
	String readOnly="";
	
	order_category_id= request.getParameter("order_category").trim();
	tick_sheet_id= request.getParameter("tick_sheet_id").trim();
	section_code = request.getParameter("section_code").trim();
	seq_no			= request.getParameter("seq_no").trim();
	eff_status = request.getParameter("eff_status").trim();
	section_desc = request.getParameter("section_desc").trim();
	order_category_short_desc=request.getParameter("order_category_short_desc").trim();
	tick_sheet_desc=request.getParameter("tick_sheet_desc").trim();
	//System.out.println("========="+request.getParameter("tick_sheet_desc").trim());

		if(eff_status.equals("E")){
		disabled="";
		readOnly="readOnly";
		}
		else{
		disabled="disabled";
		readOnly="readOnly";
		}
%>
<form name="tick_sheet_section_dtl" id="tick_sheet_section_dtl" target='messageFrame'  method="post">
	   <table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
			<td class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td><input type="hidden" name="order_category" id="order_category" value='<%=order_category_id%>' size="10" maxlength="10"   readOnly >
				<input class='fields' type="text" name="order_category_desc" id="order_category_desc" value='<%=order_category_short_desc%>' size="15" maxlength="15" <%=readOnly%>  <%=disabled%>><img src="../../eCommon/images/mandatory.gif"></img>
			</td>
			</tr>
		<tr>
			<td class="label"><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td> 
			<td>
			   <input type="hidden" name="tick_sheet_id" id="tick_sheet_id" value='<%=tick_sheet_id%>'   size="10" maxLength="10" >
			   <input type="text" name="tick_sheet_desc" id="tick_sheet_desc" value="<%=tick_sheet_desc%>"   size="30" maxLength="30"  <%=readOnly%>  <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img>

			</td>
			
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.SectionCode.label" bundle="${common_labels}"/></td> 
			<td  class='fields'>
		   <input type="text" name="section_code" id="section_code" readOnly value='<%=section_code%>'  size="10" maxLength="10" <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img>
		</td>		
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td> 
			<td class='fields'><input type="text" name="seq_no" id="seq_no" readonly value='<%=seq_no%>' size='2' maxlength='2' onKeyPress='return OrAllowPositiveNumber()' onBlur="return checkPositiveNumber(this)"  <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img>
		</td>
			
		</tr>
		<tr>
			<td class="label"><fmt:message key="eOR.SectionDesc.label" bundle="${or_labels}"/></td> 
			<td class='fields'>
		<input type="text" name="description" id="description"    value="<%=section_desc%>"
						<%if(!eff_status.equals("E"))out.println("disabled");%>
						<%if(!eff_status.equals("E"))out.println("readOnly");%>
		size="30" maxLength="30"  onBlur="makeValidString( this );" ><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
			
		
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
			<td class=fields><input type="checkbox" name='eff_status' id='eff_status'   onClick=''   <%if(eff_status.equals("E"))out.println("checked");%>></td>
			</tr>
	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Tick_Sheet_Section">
	</form>
 </body>
</html>

