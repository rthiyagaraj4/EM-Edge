<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>



<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function ChangeTabClass(obj,tabName){
//alert("obj="+obj.value);
//alert("tabName="+tabName.value);
	if(document.getElementById("sysnonyms") != null)
	document.getElementById("sysnonyms").className = "normal" ;

	/*if(document.getElementById("others") != null)
	document.getElementById("others").className = "normal" ;

	if(document.getElementById("timing") != null)
	document.getElementById("timing").className = "normal" ;*/
	if(document.getElementById("duplicate") != null)
	document.getElementById("duplicate").className = "normal" ;

	if(document.getElementById("consent_refusal") != null)
	document.getElementById("consent_refusal").className = "normal" ;	

	if(document.getElementById("explanatoryText") != null)
	document.getElementById("explanatoryText").className = "normal" ;

	obj.className = "clicked";
}

</script>

<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
<STYLE TYPE="text/css">
	A:active { 	COLOR: white; }
	A:visited { COLOR: white; }
	A:link { COLOR: white; }
	</STYLE>
<%  } %>
</head>
 <body topmargin="0"   STYLE="overflow-y:hidden;overflow-X:hidden" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="detailUpperForm" id="detailUpperForm" >

<%	
	
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;

	String module_id =bean.checkForNull(request.getParameter("module_id"));
	String order_category =	bean.checkForNull(request.getParameter("order_category"));
	String tableWidth = "60%";

	String click_chk_syn				   = "normal";
	//**String click_chk_Timing			= "normal" ;//Timing tab is moved to main tabs
	String click_chk_Dup				   = "normal" ;
	String click_chk_Con				   = "normal" ;
	String click_chk_expText			   = "normal" ;
	//**String click_chk_Instrns			   = "normal" ;//Charting tab is moved to main tabs




	String StyleDefaultSyn				   = "";  //Primary tab to be hidden
	//**String StyleDefaultTiming			   = ""  ;//Shown by default//Timing tab is moved to main tabs
	String StyleDefaultDup				   = ""  ;
	String StyleDefaultCon				   = ""  ;
	String StyleDefaultexpText				="";
	//**String StyleDefaultInstrns			   = "" ; //Instr's tab to be hidden//Charting tab is moved to main tabs

	 if(module_id.trim().equalsIgnoreCase("PH")){
	 StyleDefaultSyn					   = "display:none";  //Primary tab to be hidden
	 //**StyleDefaultTiming				   = ""  ;//Shown by default//Timing tab is moved to main tabs
	 StyleDefaultDup			           = "display:none"  ;
	 StyleDefaultCon			           = ""  ;
	 StyleDefaultexpText				   = "display:none"  ;
	//** StyleDefaultInstrns			   = "display:none" ;//Charting tab is moved to main tabs
	 click_chk_syn					   = "normal";
	 click_chk_Con					   = "clicked";
	 //**click_chk_Timing				   = "Clicked" ;//Timing tab is moved to main tabs

	 tableWidth = "20%";
	 }
	 if( !module_id.trim().equalsIgnoreCase("PH") && order_category.trim().equalsIgnoreCase("PH")){
		
	 StyleDefaultSyn				   = "display:none";  //Primary tab to be hidden
	//** StyleDefaultTiming				   = ""  ;//Shown by default//Timing tab is moved to main tabs
	 StyleDefaultDup				   = "display:none"  ;
	 StyleDefaultCon				   = ""  ;
	 StyleDefaultexpText			   = "display:none"  ;
	//** StyleDefaultInstrns			   = "display:none" ;//Charting tab is moved to main tabs

	 click_chk_syn					   = "normal";
	 click_chk_Con					   = "clicked";
	// click_chk_Timing				   = "Clicked" ;//Timing tab is moved to main tabs

	 tableWidth = "20%";
	
	 }

%>


<table border="1" width="<%=tableWidth%>" cellspacing="1" cellpadding="3">
<tr>

		<td  id="sysnonyms" style="<%=StyleDefaultSyn%>" class="<%=click_chk_syn%>" width="15%" height="20"  onClick='parent.parent.parent.displayForOthersSetUp("S");ChangeTabClass(this,"S")'><a href='#'><fmt:message key="eOR.Synonyms.label" bundle="${or_labels}"/>&nbsp;</a></td>

		<td  id="duplicate" class="<%=click_chk_Dup%>" style="<%=StyleDefaultDup%>"  width="20%" height="20" onClick='parent.parent.parent.displayForOthersSetUp("D");ChangeTabClass(this,"D")' nowrap><a href='#'><fmt:message key="eOR.DuplicateCheck.label" bundle="${or_labels}"/></a></td>

		<td  id="consent_refusal" class="<%=click_chk_Con%>" style="<%=StyleDefaultCon%>"  width="20%" height="20" onClick='parent.parent.parent.displayForOthersSetUp("ConsentRefusal");ChangeTabClass(this,"ConsentRefusal")' nowrap><a href='#'><fmt:message key="eOR.ConsentRefusal.label" bundle="${or_labels}"/></a></td>

		<td  id="explanatoryText" class="<%=click_chk_expText%>" style="<%=StyleDefaultexpText%>"  width="20%" height="20" onClick='parent.parent.parent.displayForOthersSetUp("E");ChangeTabClass(this,"E")' nowrap><a href='#'><fmt:message key="eOR.ExplanatoryText.label" bundle="${or_labels}"/></a></td>
</tr>
</table>

<input type="hidden" name="detail_page_loaded" id="detail_page_loaded" value="Y">


</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>



