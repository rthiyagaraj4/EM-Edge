<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/SuspendOrReinstateBatch.js"></script>
<!-- 			<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"

    </script>
	<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
</head>
<%
		String bean_id = "SuspendOrReinstateBatchBean";
		String bean_name = "eST.SuspendOrReinstateBatchBean";
		String item_code = request.getParameter("item_code").trim();
		String batch_id = request.getParameter("batch_id").trim();
		String expiry_date = request.getParameter("expiry_date").trim();
		String TempRemarks = request.getParameter("remarks_for").trim();
		String display_flag ="visibility:hidden";
		//String flag = request.getParameter("flag").trim();
		if(TempRemarks.equals("C"))
		  TempRemarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Notified.label","st_labels");

		if(TempRemarks.equals("R"))
		  TempRemarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reinstate.label","common_labels");

  		if(TempRemarks.equals("S"))
		{
		  TempRemarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels");
		  display_flag ="visibility:visible";
		}
		

		SuspendOrReinstateBatchBean bean = (SuspendOrReinstateBatchBean) getBeanObject(bean_id,  bean_name, request );  
		bean.setLanguageId(locale);
   if(!locale.equals("en"))
   {
   expiry_date= com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);

   }
		String key = item_code+"-"+batch_id+"-"+expiry_date;

		String remarks =bean.getRemarks(key);
		if(((String)remarks).equals(""))
			remarks=(String)TempRemarks;
		//String initited_by = (String)session.getAttribute("login_user") ;
		String productrecall = bean.getProduct_Recall(key);
		//String initited_by = bean.getInitiated_by(key) ;
       // if(initited_by.equals(""))
		  
		//String profile    =  bean.getProfile(key);
		
	%>
<body onload='FocusFirstElement();' >
	<form name= "formSuspendOrReinstateRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align="center">

	  <tr>
		<td align="right" colspan="4">&nbsp;</td>
	  </tr>

	  <tr>
		<td align="right" class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td colspan ="3">&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="52"><%=remarks%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	  </tr>
	   <tr>
		<td align="right" class="label" nowrap><%=TempRemarks%> <fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td  >&nbsp;&nbsp;<input type=text size=60 maxlength=30 name="initiated_by" id="initiated_by" value="<%=(String)bean.getInitiated_by(key)%>" >&nbsp;<td>
		<td class="label"> <font style ="<%=display_flag%>" id ="product_recall"  ><fmt:message key="eST.ProductRecall.label" bundle="${st_labels}"/> <Input type ="Checkbox" name="product_recall" id="product_recall" <%=(productrecall.equals("Y") ? "Checked" : "") %> ></td>
		 
	  </tr>

	  <tr>
		<td align="right" class="label" nowrap><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
		<td colspan ="3" >&nbsp;&nbsp;<textarea name="profile"  rows="3" cols="52"><%=bean.checkForNull(bean.getProfile(key))%></textarea>&nbsp;</td>
	  </tr>


	  <tr>
		<td align="right" colspan="4"><input type="button" class="button" name="close" id="close" value=' <fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	  </tr>

	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">

		<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
        <input type="hidden" name="batch_id" id="batch_id" value="<%=batch_id%>">
		<input type="hidden" name="expiry_date" id="expiry_date" value="<%=expiry_date%>">
	</form>
<%
//putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

