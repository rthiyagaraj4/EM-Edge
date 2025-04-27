<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
22/4/2021		TFS:14012				Shazana			22/4/2021	   			Manickam				MO-CRF-20165 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con				= null; //MO-CRF-20165 
	con						= ConnectionManager.getConnection(request);
	String bean_id					=		"goodsReceivedNoteBean" ;
	String bean_name				=		"eST.GoodsReceivedNoteBean";
	eST.GoodsReceivedNoteBean bean  =		(eST.GoodsReceivedNoteBean) getBeanObject(bean_id,bean_name,request);
	String remarks = "";//END 
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<style>
textarea {
  resize: none;
}
</style>

		<script>
			function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
		</script>

		<title>Goods Receipt Note Remarks </title>
</head>
<%
try{
	
		bean.setLanguageId(locale);
		 remarks			=		 bean.checkForNull(bean.getRemarks(),"");
		
     String remarks_code = remarks;
		if(remarks.length()>0)
		{
     String sql= "SELECT mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.trn_remarks_code = mm.trn_remarks_code AND  mm.language_id= ? AND mm.module_id= ?   AND  st.trn_type= ?     AND  mm.trn_remarks_code = ?";
	  String remarks_desc = (String)bean.fetchRecord(sql,new String[]{locale,"ST",bean.checkForNull(bean.getTrn_type(),"GRN"),remarks}).get("DESCRIPTION");
	  remarks =bean.checkForNull(remarks_desc,"");

		}
		//added for MO-CRF-20165 START
		boolean grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");//Added for MO-CRF-20165 
		if(grn_newfields_applicable){   
			remarks =  bean.getGrnRemarks(); 
		}//end  

	%>
<body onload='FocusFirstElement();'>
	<form name= "formReplaceGRNRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<!-- added for MO-CRF-20165 -->
			<%if(grn_newfields_applicable){ %>
			<textarea id="grn_remarks" name="remarks"  rows="3" cols="40" onKeyPress="checkMaxLimit(this,182);"><%=remarks%></textarea>&nbsp; 
			<% }else {%> 
			<textarea name="remarks" rows="3"  cols="40" readonly onKeyPress="return false;"><%=remarks%></textarea>&nbsp;
			<%} %>
			<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = '<%=remarks_code%>' >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,remarks);">
		</td>
	  </tr>
	  <tr>
		<td  colspan="2"><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();"></td>
	  </tr>
	</table>
	<%
}//added for MO-CRF-20165 
catch(Exception e) {
	e.printStackTrace();
			}
finally{
	if(con!=null){
		ConnectionManager.returnConnection(con,request); 
	}
}
%>
	
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="bean_trans_type" id="bean_trans_type"						value=''>
		<input type="hidden"	name="grnRemarks" id="grnRemarks"								value="<%=remarks%>"> <!-- Added for MO-CRF-20165 -->
		 
		
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

