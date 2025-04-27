<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>

<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ReasonCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String readOnly = "" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "reason_code" ;
	String bean_name = "eOR.ReasonCode";
	String disabled = "" ;

//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */

	/* Initialize Function specific start */
	ReasonCode bean = (ReasonCode)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ;
	ArrayList Category_Data = new ArrayList();
/* Initialize Function specific end */
	//IN061903 starts
	String type_code = request.getParameter( "action_type" );
	type_code = type_code.trim();
	//IN061903 ends
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {

		String action_type			=	request.getParameter( "action_type" ) ;
		String action_reason_code	=	request.getParameter( "action_reason_code" ) ;
		String action_reason_desc	=	request.getParameter( "action_reason_desc" ) ;
		String action_description	=	request.getParameter( "action_description" ) ;
		String eff_status			=	request.getParameter( "eff_status" ) ;
	if(eff_status==null || eff_status.equals("null"))
	eff_status="D";
		action_type = action_type.trim();
		action_reason_code = action_reason_code.trim();

		bean.setReasonType(action_type);
		bean.setReasonCode( action_reason_code);
		bean.setReasonDesc( action_reason_desc);
		bean.setReasonShortDesc( action_description);
		bean.setEffectiveStatus(eff_status);
		
		if(eff_status.equals("D")){
			readOnly = "readonly" ;
			disabled = "disabled" ;
		}
//		readOnly = "readonly" ;
//		disabled = "disabled" ;
        if (action_type.equals("O")) {
            readOnly = "readonly" ;
			disabled = "disabled" ;
        }
	}
%>
<form name="reason_code_ord_cat" id="reason_code_ord_cat" method="post" target="messageFrame">
<table class='grid' width="100%">
<tr>
	<td colspan=2>
		<table cellpadding=3 cellspacing=0 border=1 width='100%'>
		<tr>
			<th class='columnheader' width='50%' style="text-align:left;"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th><th class='columnheader'style="text-align:left;"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			int ilRow=0;
			String slClassValue = "";
			String checked = "";

			if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
				Category_Data = bean.allOrderCategory() ;
			}else{
				Category_Data = bean.getOrderCategory();
			}

			String[] record=null;

			for(int i=0; i<Category_Data.size(); i++){
				record = (String [])Category_Data.get(i);

				if(ilRow % 2 == 0){
					slClassValue = "gridData";
				       }
				else   {
					slClassValue = "gridData";
				      }

			if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
				if(record[2].equals("Y")){
					checked = " checked ";
				}
			}
			//IN061903 starts
			if("ND".equals(type_code)){
				if("PC".equals(record[0]) || "TR".equals(record[0])){
					disabled = "";
				}
				else{
					disabled = "disabled";
				}
			}
			//IN061903 ends
		%>
				<tr>
					<td  class='<%= slClassValue %>'><%=record[1]%> <input type=hidden name=scope<%=i% id=scope<%=i%> value=<%=record[0]%>></td>
					<td  class='<%= slClassValue %>'><input type=checkbox name=chk<%=i% id=chk<%=i%> <%=checked%> <%=readOnly%> <%=disabled%> ></td>
				</tr>
		<%	ilRow++;
			checked = "";
			}
		%>
		</table>
	</td>
</tr>
</table>
<input type=hidden name='reason_type' id='reason_type' value = "">
<input type=hidden name='reason_code' id='reason_code' value = "">
<input type=hidden name='reason_desc' id='reason_desc' value = "">
<input type=hidden name='reason_short_desc' id='reason_short_desc' value = "">
<input type=hidden name='eff_status' id='eff_status' value = "">

<input type="hidden" name="totalSize" id="totalSize" value="<%=Category_Data.size()%>">
<%Category_Data=null;%>
<input type="hidden" name="allOrderCats" id="allOrderCats" value="">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>
</body>

</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

