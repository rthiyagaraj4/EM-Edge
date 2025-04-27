<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037679	   		Karthi	 								SRR20056-SCF-9534
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import="eST.CondemnExpiredBatchesHeaderBean, eST.Common.*,eCommon.Common.*,eMM.Common.*,  java.util.ArrayList,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eST.ModifyDocumentDetails.label" bundle="${st_labels}"/></title>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<!--   added DateUtils.js  for SRR20056-SCF-9534 -->
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <script>
        function_id = "<%= 
        request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
	
    <%
    	CondemnExpiredBatchesHeaderBean bean =  null;       	
    	try {    	
    		bean = (eST.CondemnExpiredBatchesHeaderBean) getBeanObject( "condemnExpiredBatchesHeaderBean", "eST.CondemnExpiredBatchesHeaderBean", request);    		
			bean.setLanguageId(locale);
    	}    	
    	catch (Exception ex) {    	
			ex.printStackTrace();
    	}
		//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
		String chk_val = bean.checkForNull(request.getParameter("chk_val"));
		//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) beg
		String doc_date="";
		if(!locale.equals("en")){
			doc_date	=	com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale);
		}else{
			doc_date	=	bean.getDoc_date();
		}
		//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) end
		//String remarks_desc = bean.checkForNull(bean.getAdj_remarks_Desc());
		 
    %>    
</head>
	<body onload='FocusFirstElement();'>
	<form name= "formCondemnExpiredBatchesCreate" id="formCondemnExpiredBatchesCreate">
	<table border="0" cellpadding='0' cellspacing='0' width='100%' height='100%' >
	  <tr>
		<td  class="label">
			<fmt:message key="Common.DocType.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="doc_type_code" id="doc_type_code">
				<%=bean.getDoc_type_code_List()%>
			</select>
			<%=bean.getImage("M")%>
		</td>
		<td  class="label">
			<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<input type="text" size="10" maxlength="8" name="doc_no" id="doc_no" value="<%=bean.getCon_doc_no()%>" disabled>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		
		
	  </tr>
	  <tr>
		<td  class="label">
			<fmt:message key="Common.DocRef.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<input type="text" size="15" maxLength="20" name="doc_ref" id="doc_ref" value="<%=bean.getDoc_ref()%>">
			
		</td>
		<td  class="label">
			<fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<!-- Leap year issue changed from CheckDate(this) to CheckDateLeap()  for SRR20056-SCF-9534 -->
			<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" value="<%=/*com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale) against #048587(SKR-SCF-0990)*/doc_date%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">		
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img>
			<%=bean.getImage("M")%>
		</td>		
	  </tr>		
	  
	  <tr>
	
		<td  class="label">
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
		<input type="hidden" name="remarks_code" id="remarks_code" value="">
		<input type="hidden" name="lang_id" id="lang_id" value="<%=locale%>">
		<input type="hidden" name="SQL_MM_TRN_REMARKS_LOOKUP1" id="SQL_MM_TRN_REMARKS_LOOKUP1" value="<%=MmRepository.getMmKeyValue("SQL_MM_TRN_REMARKS_LOOKUP")%>">
		</td>
		<td colspan=3 class='fields'>
			&nbsp;&nbsp; 
			<textarea   name="adj_remarks" rows='1' cols='70'  style = "resize:none; overflow: hidden;"; onBlur ="SPCheckMaxLen('adj_remarks',this,200);" onPaste="checkMaxLengthPaste(this,200);" onKeyPress="checkMaxLimit(this,200);" ><%=bean.checkForNull(bean.getAdj_remarks_Desc())%></textarea> 
			<!--<input type="text" size="70" maxLength="200" name="adj_remarks" id="adj_remarks" value="<%=bean.checkForNull(bean.getAdj_remarks_Desc())%>" > -->
			<!-- Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 -->
			  <!-- <input type='button' class='BUTTON' value='?' onClick="searchRemarks(remarks_code,adj_remarks,lang_id,SQL_MM_TRN_REMARKS_LOOKUP1);"> -->
			  <%if(chk_val.equals("false")) {%>
			  <img id="remarks_img"   src="../../eCommon/images/mandatory.gif" />
			  <%} %>
		</td>			
	  </tr>
	  
	<tr>  
	<td  colspan='3' class='fields'></td>
	<td>
		<input type="button" name="record" id="record" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="saveAndExit()">
		<input type=reset name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button">
	</td>
</tr></table>
		<input type='hidden' name="request_by_store_code" id="request_by_store_code">
		<input type='hidden' name="request_on_store_code" id="request_on_store_code">
		<input type='hidden' name="item_class_code" id="item_class_code">
		<input type='hidden' name="mode" id="mode">
		<input type="hidden" name="bean_id" id="bean_id">
		<input type="hidden" name="bean_name" id="bean_name">
		<!-- "language_id" Added for  for SRR20056-SCF-9534-->
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		<input type="hidden" name="function_id" id="function_id">
		<input type="hidden" name="SQL_MM_TRN_REMARKS_LOOKUP" id="SQL_MM_TRN_REMARKS_LOOKUP" value="<%=MmRepository.getMmKeyValue("SQL_MM_TRN_REMARKS_LOOKUP")%>">
		<input type="hidden" name = "val_chk" value ="<%=chk_val%>">
		 
		
	</form>
	<%
putObjectInBean("condemnExpiredBatchesHeaderBean",bean,request);
%>
	</body>
</html>

