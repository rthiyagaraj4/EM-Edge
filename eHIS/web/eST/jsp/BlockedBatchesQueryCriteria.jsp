
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
21/6/2021				TFS-20203				Shazana													MOHE-CRF-0084.1-US011
15/7/2021				TFS-21515				Shazana													MOHE-CRF-0084.1-US013
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language='javaScript' src="../../eST/js/BlockedBatches.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id							=		"<%= request.getParameter("function_id") %>"
		menu_id								=		"<%= request.getParameter("menu_id") %>"
		module_id							=		"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
		String bean_id						=		"blockedBatchesBean";
		String bean_name					=		"eST.BlockedBatchesBean";
		String facility_id					=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;//MOHE-CRF-0084.1 
		eST.BlockedBatchesBean bean			=		(eST.BlockedBatchesBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
	    String ISS_ACK_REQ_YN = "N";
	    String RET_ACK_REQ_YN = "N";
	    String TFR_ACK_REQ_YN = "N";
		String defaultSelect				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		boolean restrict_stores_user_access_yn =false;//Added for TFS id:20203 
	    String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		 try{
				con						= ConnectionManager.getConnection(request);
			    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
		    }
		 catch (Exception exp){
			 exp.printStackTrace();
		//	 System.out.println("Exception in BlockedBatchesQueryCriteria.jsp");  
		 }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
		 strFacilityParam = bean.getRestrictUserAccessStore();
		//	System.out.println("strFacilityParam: "+strFacilityParam);   
			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//END 
		try{
			HashMap hmTemp = (HashMap)(bean.fetchRecord("SELECT ISS_ACK_REQ_YN, RET_ACK_REQ_YN, TFR_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", bean.getLoginFacilityId()));
			if((bean.checkForNull((String)hmTemp.get("ISS_ACK_REQ_YN"),"N")).equals("Y")){
				ISS_ACK_REQ_YN = "Y";
			}
			if((bean.checkForNull((String)hmTemp.get("RET_ACK_REQ_YN"),"N")).equals("Y")){
				RET_ACK_REQ_YN = "Y";
			}
			if((bean.checkForNull((String)hmTemp.get("TFR_ACK_REQ_YN"),"N")).equals("Y")){
				TFR_ACK_REQ_YN = "Y";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Added by Rabbani 16/11/12 Starts
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	 //ends
%>
<body onload='FocusFirstElement();'>
	<form name= "formBlockedBatchesQueryCriteria" action="../../eST/jsp/BlockedBatchesQueryResult.jsp" method="post"  target="frameBlockedBatchesQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" height="100%" >
	  <tr>
		<td align="right" class="label"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="trn_type" id="trn_type" onBlur="populateDocTypeCode(this.value);" onchange="displayModuleid(this.value);"><!--Added displayModuleid(this.value); by suresh.r on 29-09-2014 against Inc 51460 -->
			<%=bean.getTrn_type_List()%>
			<% if((ISS_ACK_REQ_YN.equals("Y")) || (TFR_ACK_REQ_YN .equals("Y")) || (RET_ACK_REQ_YN.equals("Y"))){%> 
			<option value="ACK">Acknowledge</option>
			<%}%>
			</select></td>
		<td align="right" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code">
			<%=defaultSelect%>
			</select></td>
		<td align="right" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input class="NUMBER" type="text" size="8" maxlength="8" 
			onKeyPress="return isValidInteger();" name="doc_no" id="doc_no" 
			onBlur="return checkIntegerFormat(this);" ></td>
	  </tr>
	  <tr>
		<td align="right"  class="label" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type='text' size='6'  maxlength='6' 
			name='store_code' id='store_code'>
		<% if(restrict_stores_user_access_yn){ %> <!-- added for 20203 START-->	
		<input class='BUTTON' type='button' 	name='searchStore' id='searchStore' value='?' onClick="searchStoreCode1(store_code);"></td>
		<%}else{ %>
		<input class='BUTTON' type='button' 	name='searchStore' id='searchStore' value='?' onClick="searchStoreCode(store_code);"></td> 
		<%} %>
		<td align="right"  class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type='text' size='20'  maxlength='20' 
			name='item_code' id='item_code'><input class='BUTTON' type='button' name='searchItemCode' id='searchItemCode' value='?'  onClick="callItemSearchScreen(item_code);"></td>
		<td align="right"  class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
		<!--
				* @Name - Priya
				* @Date - 04/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - maxlength & size of the text field 'batch_id' is increased to 20
				-->
		<td>&nbsp;&nbsp;<input type='text' size='20'  maxlength='20' 
			name='batch_id' id='batch_id'></td>
	  </tr>
	  <tr>
	 	<td align="right" class="label"><fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> </td>
		<td >&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>"   onBlur="CheckDate(this,'<%=locale%>');">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"  ></img><%=bean.getImage("M")%>
		&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this,'<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"  ></img></td>
		<!--Added by suresh.r on 29-09-2014 against Inc 51460 beg -->
		<!--<td align="right" class="label" id="module_lab" style="dispaly: none;"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td> -->
		<td id="module_sel" style="display: none;">&nbsp;&nbsp;
		<select name="module_id" id="module_id"><option value="ALL" selected="selected">ALL</option><option value="ST">Inventory</option><option value="PH">Pharmacy</option> </select></td>
		<!--Added by suresh.r on 29-09-2014 against end  Inc 51460 -->
		<!-- 
		   
			* @Name - Priya
			* @Date - 29/01/2010
			* @Inc# - IN018492
			* @Desc - To check whether From date is less than or equal to to date, the function searchResult() is added in the onClick event of the 'Search' button
			
		-->
		<td colspan="3"></td><td align='right'>&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchResult()"></td> 
	  </tr>
	</table>
		<input type="hidden" name="locale" id="locale"				value="<%=locale%>">
		<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name %>">
		<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
		<input type="hidden" name="RET_ACK_REQ_YN" id="RET_ACK_REQ_YN"			value="<%=RET_ACK_REQ_YN %>">
		<input type="hidden" name="ISS_ACK_REQ_YN" id="ISS_ACK_REQ_YN"			value="<%=ISS_ACK_REQ_YN %>">
		<input type="hidden" name="TFR_ACK_REQ_YN" id="TFR_ACK_REQ_YN"			value="<%=TFR_ACK_REQ_YN %>">
		<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"			value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1 -->
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"		value="doc_type_desc,doc_no,doc_date,item_desc">

	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

