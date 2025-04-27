<!DOCTYPE html>
<!-- /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History         Name        Rev.Date         Rev.By		            Description
--------------------------------------------------------------------------------------------------------
21/01/2021	 TFS-12204          Prabha      21/01/2021	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------
*/
-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

%>

<html>
<script>
	var argArray = window.dialogArguments ;
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>

<title id="lookup_title"></title>
<iframe name="lookup_head" id="lookup_head" src="../../ePH/jsp/DrugNameGenericCommonLookupSearchCriteria.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17vh;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>


</html>

