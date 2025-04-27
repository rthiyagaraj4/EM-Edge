
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
15/12/2016	  IN062834		Karthi											ML-MMOH-CRF-0508.1/02- System does not Clear the values when Cancel button is pressed in Order Format Window 
------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"  %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
    request.setCharacterEncoding("UTF-8");
	String 	bean_id		= request.getParameter("bean_id");
    String 	bean_name	= request.getParameter("bean_name");
	/* Initialize Function specific start */
	OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
%>
<html>
    <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
        <script language="javascript" src="../../eCommon/js/common.js"></script>
        <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language='javascript' src='../../eOR/js/OrderEntry1.js' ></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    </head>
    <body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
    <br><br>
    <form name="OrderEntryFormatMultiSelectControl" id="OrderEntryFormatMultiSelectControl" method="post" >
<%
	String 			multichk_validate				= bean.checkForNull(request.getParameter("multichk_validate"),"");
    String ord_formt_multi_chk_nonmandate_yn = bean.getMultiSelectListItemMandatYN(); 
	if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && multichk_validate.equals("UPDATETEMPUTILS")){  
		List validateList		= bean.getValidateMnemonicList(); 
		Map validateMap			= bean.getValidateMnemonicMap();
		List validateAllList	= bean.getValidateAllMnemonicList();
		System.err.println(" 58. OrderEntryFormatMultiSelectControl.jsp validateList => " + validateList + " validateMap " + validateMap + " validateAllList " + validateAllList);
		Map dupeMultiCheckSelMap = bean.getDupeMultiCompMnemonicMapClone();
		bean.setMultiListCompMnemonicMapClone(validateMap);
		List dupeAllMultiCheckList = bean.getDupeAllMultiCompMnemonicList();
		bean.setMultiCheckCompMnemonicList(validateAllList);
		bean.setCompleteMultiCheckCompList(validateList);
		bean.setMultiListCompMnemonicMap(validateMap);
		bean.setMultiListCompMnemonicMapClone(validateMap);
		bean.setDupeAllMultiCompMnemonicList(validateAllList);
		bean.setDupeMultiCompMnemonicMapClone(validateMap);
		bean.setCompleteMultiCheckCompList(validateAllList);
		
	} else if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && multichk_validate.equals("ADDTEMPUTILS")){
		List selectedCompList 		=	bean.getMultiCheckCompMnemonicList();
		//Map selectedCompMap		= 	bean.getDupeMultiCompMnemonicMapClone();
		List allMnemonicCompList	=	bean.getCompleteMultiCheckCompList();
	    Map selectedCompMap		= 	bean.getMultiListCompMnemonicMapClone(); 
		System.err	.println(" 75. OrderEntryFormatMultiSelectControl.jsp selectedCompList => " + selectedCompList + " allMnemonicCompList " + allMnemonicCompList + " selectedCompMap " + selectedCompMap);	
		bean.setValidateMnemonicList(selectedCompList);
		bean.setValidateMnemonicMap(selectedCompMap);
		bean.setValidateAllMnemonicList(allMnemonicCompList);
	} 
	
  %>
	</form>
	</body>
    
   	<script language="javascript">

   	 parent.window.close();
   	
//   	const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");//    
   	
  //  dialogTag.close();   
    
	</script>


  </html>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);

%>

