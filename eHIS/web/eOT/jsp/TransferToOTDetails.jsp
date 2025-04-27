<!DOCTYPE html>
  <%
//"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*"
%>
<%@ page import ="java.util.ArrayList,java.util.HashMap,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.*"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id  = (String) session.getValue("facility_id");//PMG2016-KDAH-CRF-0001	
	
	//PMG2016-KDAH-CRF-0001 starts
		String setup_bean_id = "SetUpParamForFacilityBean";
		String setup_bean_name = "eOT.SetUpParamForFacilityBean";
		SetUpParamForFacilityBean setup_bean = (SetUpParamForFacilityBean) mh.getBeanObject( setup_bean_id, request, setup_bean_name );
		HashMap map=new HashMap();
		String tab_id="OtherDetails";
		map = setup_bean.getQueryDtls(tab_id, facility_id);
		System.err.println("OtherDetails map-->"+map);
		String multi_check_in_yn=(String)map.get("multiCheckInAllowed_YN");	
	//PMG2016-KDAH-CRF-0001 ends
%>

<HTML>
<head>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<Script Language="JavaScript" src="../../eOT/js/TransferToOT.js"></Script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<!-- <script language="javascript" src='../../eOT/js/OTMessages.js'></script>
 --><script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<html>
<head>
</head>
<%
	String theatre_type=CommonBean.checkForNull(request.getParameter("theatre_type"));
	String reason_desc = CommonBean.checkForNull(request.getParameter("reason_desc"));
	String reason_code = CommonBean.checkForNull(request.getParameter("reason_code"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String status_code = "";
	
	ArrayList theatre_list= new ArrayList();
	
	String bean_id = "TransferToOTBean";
	String bean_name = "eOT.TransferToOTBean";
	TransferToOTBean bean = (TransferToOTBean)mh.getBeanObject( bean_id, request, bean_name );
	if(theatre_type!=null && !theatre_type.equals("null") && !theatre_type.equals(""))
	theatre_list=bean.getTheatreDesc(theatre_type,multi_check_in_yn);//Added For PMG2016-KDAH-CRF-0001
%>




<body >
<form name='TransferToOTDetailForm' id='TransferToOTDetailForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="center">
<tr>
	<td class='CAGROUPHEADING'  colspan='6'> <B>
	<fmt:message key="eOT.TransferDetails.Label" bundle="${ot_labels}"/></B> </td>
</tr>

<tr>
	<td class='label' width="25%"  nowrap>
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
	  <select name='theatre_type' id='theatre_type'  onChange='funLoadValues(this);'>
		<option value="">
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
		<%
		   String theatre_type_temp   = "";
		   String theatre_type_select = "";
		   ArrayList arr_list_theatre_types = bean.getTheatreType();
		   if(arr_list_theatre_types!=null){
		   for (int i=0;i< arr_list_theatre_types.size();i=i+2){
			 theatre_type_temp   = (String) arr_list_theatre_types.get(i);
			 if(theatre_type.equals(theatre_type_temp)){
				 theatre_type_select = "selected";
			 }else{
				  theatre_type_select = "";
			 }
		 %>
		 <option value="<%=theatre_type_temp%>" <%=theatre_type_select%>> 
		 <%=arr_list_theatre_types.get(i+1)%>    
		 </option>
		 <%}}%>
	 </select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width="25%"  nowrap>
	<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td class='label' width="25%" >
		<select name='theatre' id='theatre'>
		<option value="">
			 <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
<%
		int size1 = theatre_list.size();
		if(size1>0){
		for(int i=0;i<size1;i+=2){
				
%>
		<option value='<%=theatre_list.get(i)%>' > <%=theatre_list.get(i+1)%> </option>
		<%}}%>
		</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr> 
	<td  class='label' width="25%"  valign='top' nowrap>
		<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
	</td> 
	<td class='fields' width="25%" valign='top' nowrap>
	    <input type='hidden' name='reason_code' id='reason_code' value='<%=reason_code%>'>
		<textarea name='reason_desc' rows='3' cols='35' readonly><%=reason_desc%></textarea>&nbsp;
		 <input type='button' class='button' value='?' name='reasonLookUp' id='reasonLookUp' onClick='searchReason(reason_code,reason_desc);' >
    	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
	<td valign='top' class='label' width="25%"  nowrap>
		<fmt:message key="eOT.ChangeStatusto.Label" bundle="${ot_labels}"/>
	</td>
	<td valign='top' class="label"  width="25%" >
	<select name="status_code" id="status_code">
	 <%
             String status_code_temp   = "";
                 String status_code_select = "";
                 ArrayList arr_list_status_codes = bean.getStatus();
                 if(arr_list_status_codes!=null){
                 for (int i=0;i< arr_list_status_codes.size();i=i+2){
					 status_code_temp   = (String) arr_list_status_codes.get(i);
					 if(status_code.equals(status_code_temp) || status_code_temp.equals("50") ){
						 status_code_select = "selected";
					 }else {
		                  status_code_select = "";
					}
         %>

			<option value="<%=status_code_temp%>" <%=status_code_select%>> 
			<%=arr_list_status_codes.get(i+1)%>    
			</option>
			<%}}%>
	    </select>
	<img src='../../eCommon/images/mandatory.gif'></img>
    </td>
</tr>
<tr> 
	<td  class='label' width="25%"  valign='top' nowrap>
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	</td> 
	<td class='fields' width="25%">
		<textarea name='remarks_desc' rows='3' cols='35' onkeyup="return checkLimit(this,'500');" onmouseout="return checkLimit(this,'500');"></textarea>&nbsp;&nbsp;
		 
	</td>
</table>
<input type ='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
<input type ='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type ='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value="<%=facility_id%>">
<input type="hidden" name="multi_check_in_yn" id="multi_check_in_yn" id="multi_check_in_yn" value="<%=multi_check_in_yn %>">
</form>
</body>
</html>

