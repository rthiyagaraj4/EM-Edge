<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--

---------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
27/11/2017		IN061890		Kamalakannan G		27/11/2017		Ramesh G		ML-MMOH-CRF-0542
05/12/2017		IN066006		Kamalakannan G		05/12/2017		Ramesh G		OR-ML-MMOH-CRF-0542/01
04/06/2018		IN066548		Kamalakannan G		04/06/2018		Ramesh G		ML-MMOH-CRF-1076
06/06/2018		IN067881 		Kamalakannan G		04/06/2018		Ramesh G		CA-ML-MMOH-CRF-1076/01-Result Reporting
24/10/2019    	IN071315	    Nijitha S   		24/10/2019  	Ramesh G		GHL-CRF-0607
---------------------------------------------------------------------------------------------------------------
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<title><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>  
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script><!--IN066548-->
 	<script language="JavaScript" src="../../eOR/js/CompleteOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	<script>
	function checkMaxLimitLocal(obj,maxSize){

		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
		}	
	</script>
	<style>
	
	textarea {
        overflow-y: scroll;
        height: 100px;
        resize: none; /* Remove this if you want the user to resize the textarea */
    }
	</style>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" >
<FORM name="completeRemarks" id="completeRemarks"><!-- replaceOrderableRemarks -->
<Table cellpadding=3 cellspacing=0 border='0' width='100%' height='100%' align='center'>
<%
	
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String complete_remarks 	= request.getParameter("complete_remarks");
	Properties p = (Properties)session.getValue("jdbc");//IN066548
	String locale= (String) p.getProperty("LOCALE");//IN066548
	if (complete_remarks == null) complete_remarks = "";
	String order_id		=  request.getParameter("orderId");
	if(order_id==null) order_id="";
	String order_line_num		=  request.getParameter("line_num");
	if(order_line_num==null) order_line_num="";
	String function_from = request.getParameter("function_from");
	String order_type_code = request.getParameter("order_type_code");//IN066548
	//String order_category  = request.getParameter("order_category");//IN067881
	String ord_cat = request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");//IN067881
	if(function_from==null) function_from="";
	String catalog_code = request.getParameter("catalog_code")==null?"&nbsp;":request.getParameter("catalog_code");
	String catalog_desc = request.getParameter("catalog_desc")==null?"&nbsp;":request.getParameter("catalog_desc");
	
	String bean_id = "Or_CompleteOrder" ;
	String bean_name = "eOR.CompleteOrderBean";
	CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name , request) ;
	
	ArrayList orderables = new ArrayList();
	orderables = bean.getReplaceOrderable(catalog_code,order_id,order_line_num);//Modified by Uma for package billing
	String[] record= null;//Added by Uma for package billing
//	System.out.println("qrystr="+request.getQueryString());
//	System.out.println("catalog_code="+catalog_code);
	/**/
	String term_set_style = "";//IN061890
	//String[] record1 = null;//IN061890 commented for checkstyle
	String l_repl_ord_thro_termset_yn = bean.OrdThroTermSetYN();//IN061890
%>
<tr><td colspan='2'></td></tr>
<tr><td class='label' width='48%'><fmt:message key="eOR.ExistingOrderable.label" bundle="${or_labels}"/></td>
<td  class='data' width='52%'><font size="1"><B><%=catalog_desc%></B></font>
</td></tr>
<!-- IN061890 starts-->
<%if (l_repl_ord_thro_termset_yn.equals("Y")) {%>
<!-- added for IN066548 -->
<tr><td class='label' width='48%'>Replace Orderable Type</td>
<td  class='data' width='52%'>
<select name='rep_type' id='rep_type'  onChange="parent.parent.parent.onChangeRepType(this);" >
				<option value='C' selected>Category Wise</option>
				<option value='T'>Term set</option>
</select><!-- IN066548 end -->
</td></tr>
<tr id="termID" style="display:none;">			
		<td width='25%' class='label' id='term_set_id_lbl' style='<%=term_set_style%>'  width='20%' ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td width='25%' id="term_set_id_td"  style='<%=term_set_style%>' class="fields"><select name="term_set_id" id="term_set_id" onChange="parent.parent.parent.onChangeTermSetID();" >
		<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option><!-- IN066006 select '-' added -->
		<%
		
			ArrayList TermSetID=new ArrayList();
			TermSetID=bean.populateTermSetID();
			for(int k=0;k<TermSetID.size(); k++){
			record = (String [])TermSetID.get(k);
%>	
			<option value="<%=record[0]%>"><%=record[1]%></option>  
<%
			}TermSetID=null;
			record=null;
%>
		</select><img align=center src="../../eCommon/images/mandatory.gif"></img>
</tr>
<tr id="termCode" style="display:none;"><!-- added for IN066548 -->
		<td class='label' width='23%' id='term_code_lbl'  style='<%=term_set_style%>'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
		<td width='25%' id='term_code_td' style ='<%=term_set_style%>' class="fields">
		<input type='hidden' name='term_code' id='term_code' value="">
			
		<input type='text' width='18%' name='term_desc' id='term_desc' size='28' maxlength='30'
		<%//onBlur="parent.parent.parent.before_show_term_code_window(this,term_code);" %>
		onBlur="parent.parent.parent.before_show_term_code_window(term_set_id);"  value="" disabled>
		<input type='button' class='button' name='term_code_button' id='term_code_button' value='?' <%// onClick="parent.parent.parent.show_term_code_window(term_desc,term_code);"%>
		onClick="parent.parent.parent.show_term_code_window(term_set_id);" disabled>
		<img src="../../eCommon/images/mandatory.gif" ></img><input type="hidden" name="temp_term_desc" id="temp_term_desc" value="">
		</td> 
 	</tr> 
 	
 	<%} %>
<!-- IN061890 ends -->
<tr><td colspan='2' ></td></tr>
<tr><td class='label' ><fmt:message key="eOR.ReplaceOrderable.label" bundle="${or_labels}"/></td>
<%
/*Added by Uma on 4/15/2010 for package billing*/
String billingPackageRef = (String)bean.getBillingPackageRef(order_id,order_line_num)==null?"0":(String)bean.getBillingPackageRef(order_id,order_line_num);
if(Integer.parseInt(billingPackageRef)>0)
{

	for(int j=0;j<orderables.size();j++)
	{
		record = new String[2];
		record = (String[])orderables.get(j);
		if((bean.checkForNull((String)record[0]).equalsIgnoreCase(""))&&(bean.checkForNull((String)record[1]).equalsIgnoreCase("")))
		{
			out.println("<script>alert(getMessage('BL8649','BL')); window.close()</script>");
		}
		%>
			<td class='fields'>
			<input type="text" name="replace_orderable" id="replace_orderable" value="<%=record[1]%>">
			<input type="hidden" name="replace_orderable0" id="replace_orderable0" value="<%=record[0]%>">
			</td>
			</tr>
		<%
	}
}
else
{
	/*Ends Here*/
	%>
	
	
	
	<%
//IN061890 start
		if("N".equals(l_repl_ord_thro_termset_yn))
		{%>
			<td class='fields'><select name="replace_orderable0" id="replace_orderable0" >
			<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<% for(int j=0;j<orderables.size();j++)
			{
				record = new String[2];
				record = (String[])orderables.get(j);
				%>
			
				<option value='<%=record[0]%>'><%=record[1]%></option>
				<%
			}//IN061890 end
			%>
			</select><img src="../../eCommon/images/mandatory.gif" align=center></td><!--IN067881-->
			
		<%}
		else{%>
			<td id="lookupForCategory"  width='25%' id='term_code_td' style ='<%=term_set_style%>' class="fields">
			<input type='hidden' name='replace_orderable_code' id='replace_orderable_code' value="">
				
			<input type='text' width='18%' name='replace_orderable_desc' id='replace_orderable_desc' size='28' maxlength='30'
			 onBlur="parent.parent.parent.onChangeRepOrdForCat(this,replace_orderable_code);" 
			 value="" ><!--IN067881-->
			<input type='button' class='button' name='replace_orderable_code_button' id='replace_orderable_code_button' value='?' 
			onClick="parent.parent.parent.populateReplaceOrderableForCategory(replace_orderable_desc,replace_orderable_code)" >
			<img src="../../eCommon/images/mandatory.gif"></img><!-- <input type="hidden" name="temp_term_desc" id="temp_term_desc" value=""> -->
			</td> 
			
			<td id="lookupForTermSet" style="display:none;" width='25%' id='term_code_td' style ='<%=term_set_style%>' class="fields">
			<input type='hidden' name='replace_orderable_code1' id='replace_orderable_code1' value="">
				
			<input type='text' width='18%' name='replace_orderable_desc1' id='replace_orderable_desc1' size='28' maxlength='30'
			onBlur="parent.parent.parent.onChangeRepOrdForTrm(this,replace_orderable_code1);" 
			 value="" disabled><!--IN067881-->
			<input type='button' class='button' name='replace_orderable_code_button1' id='replace_orderable_code_button1' value='?' 
			onClick="parent.parent.parent.populateReplaceOrderableForTermSet(replace_orderable_desc1,replace_orderable_code1)" disabled>
			<img src="../../eCommon/images/mandatory.gif"></img><!-- <input type="hidden" name="temp_term_desc" id="temp_term_desc" value=""> -->
			</td> 
		<%}
	%>
	<!-- removed for IN066548 </select><img src="../../eCommon/images/mandatory.gif" align=center><!--<Input class='button' type='button' name='add0' id='add0' value='V' onClick='insertRow(0)' style='visibility:visible'> </td>-->
	</tr>
<%
}
%>

<%--commented 61890 <%
for(i=1;i<10;i++){
%>
<tr id='replaceRow<%=i%>' style='display:none'><td class='label' align='right'>&nbsp;</td>
<td class='label' align=''>&nbsp;<select name="replaceadd_orderable<%=i%>" id="replaceadd_orderable<%=i%>">
<option value='*ALL<%=i%>'>----Select-----</option>
<%
for(int j=0;j<orderables.size();j++){
	record = new String[2];
	record = (String[])orderables.get(j);
	%><option value='<%=record[0]%>'><%=record[1]%></option>
<%
}
%>
</select>&nbsp;<Input class='button' type='button' name='add<%=i%>' id='add<%=i%>' value='V' onClick='insertRow(<%=i%>)' style='visibility:visible'>&nbsp;<Input class='button' type='button' name='del<%=i%>' id='del<%=i%>' value='-' onClick='deleteRow(<%=i%>)' style='visibility:visible'></td>
</tr>	

<%
}
%> 
<input type="hidden" name="row_cnt" id="row_cnt" value="0"> commented 61890--%>
<tr><td colspan='2'></td></tr>
<tr><td class='label' width='50%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class='fields'><TextArea rows='8' cols='30' name='complete_remarks' value=''  width='50%' onkeypress="checkMaxLimitLocal(this,255)" onBlur="makeValidString(this);chkRemarksLength();" ><%=complete_remarks%></TextArea><img src="../../eCommon/images/mandatory.gif" align=center; style=" transform: translate(0px,-50px);" >
</td></tr>

<tr><td  colspan='2' class='button'  style="text-align: right;padding-top: 30px;"><Input class='button' type='button' name='replace' id='replace' value='<fmt:message key="Common.Replace.label" bundle="${common_labels}"/>' onClick='callOrder()'><Input class='button' type='button' name='Ok' id='Ok' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='clickClose();'><!-- <Input type='hidden' name='chkreplaced' id='chkreplaced' value="" > --></td></tr>
<!-- IN066548 start-->
<input type="hidden" name="replace_orderable_query" id="replace_orderable_query" value="select order_catalog_code_repl code,short_desc description from (SELECT DISTINCT a.order_catalog_code order_catalog_code_repl,or_get_desc.or_order_catalog(a.order_catalog_code,'<%=locale%>','2') short_desc FROM or_order_catalog_proc_link a, or_order_catalog b WHERE a.order_catalog_code = b.order_catalog_code and order_category = (SELECT order_category FROM or_order_catalog WHERE order_catalog_code = '<%=catalog_code%>') AND b.order_catalog_code !='<%=catalog_code%>' AND a.proc_coding_scheme =##termsetId## AND a.proc_code = ##termsetCode## AND b.order_category NOT IN ('CN', 'PH') UNION SELECT DISTINCT a.order_catalog_code order_catalog_code_repl, or_get_desc.or_order_catalog(a.order_catalog_code,'<%=locale%>','2') short_desc FROM  or_order_catalog a where term_code= ##termsetCode## AND a.term_set_id = ##termsetId## AND a.order_catalog_code != '<%=catalog_code%>' AND order_category = (SELECT order_category FROM or_order_catalog WHERE order_catalog_code = '<%=catalog_code%>')AND a.order_category NOT IN ('CN', 'PH')and upper(a.order_catalog_code) like upper(?) and upper(or_get_desc.or_order_catalog(a.order_catalog_code,'<%=locale%>','2')) like upper(?))order by short_desc">
<%-- <input type="hidden" name="replace_orderable_query_for_category" id="replace_orderable_query_for_category" value="select ORDER_CATALOG_CODE code, SHORT_DESC description from or_order_catalog where order_category='<%=order_category%>' and ORDER_TYPE_CODE='<%=order_type_code%>' and upper(ORDER_CATALOG_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)"> commented for IN067881--%>
<input type="hidden" name="replace_orderable_query_for_category" id="replace_orderable_query_for_category" value="select ORDER_CATALOG_CODE code, SHORT_DESC description from or_order_catalog where order_category='<%=ord_cat%>' and ORDER_TYPE_CODE='<%=order_type_code%>'  and order_catalog_code!='<%=catalog_code%>' and upper(ORDER_CATALOG_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)"><!-- IN067881 -->
<!-- IN066548 end-->
<input type="hidden" name="qrystr" id="qrystr" value="<%=request.getQueryString()%>">
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>"><!--IN067881-->
 <input type="hidden" name="l_repl_ord_thro_termset_yn" id="l_repl_ord_thro_termset_yn" value="<%=l_repl_ord_thro_termset_yn%>">
<input type="hidden" name="mode" id="mode" value="2"> 
<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value="<%=request.getParameter("p_called_from_ca")%>"><!-- IN071315 -->
</Table>
</Form>
</Body>
</Html>
<%
	putObjectInBean(bean_id,bean,request);
%>

