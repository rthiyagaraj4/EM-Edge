<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Rev.Date 	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------
04/09/2017    IN007187		Raja		04/09/2017	Ramesh G	GHL-SCF-1235		
13/06/2019     IN070698              sivabagyam	          13/06/2019          Ramesh G		SKR-SCF-1227
14/10/2019  IN071315	    Nijitha S   14/10/2019  Ramesh G	GHL-CRF-0607
25/03/2020	IN072752		Nijitha S	25/03/2020	Ramesh G	ML-MMOH-CRF-1229/12
---------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- IN072752 -->
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <jsp:useBean id="beanExisOrder" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CancelOrder" ;
	String bean_name = "eOR.CancelOrder";

	//String ord_cat = request.getParameter("ord_cat");
	//String cancelled_at = request.getParameter("cancelled_at");
	String order_line_num = request.getParameter("order_line_num");
	String orderId = request.getParameter("orderId");
	String ord_typ_code = request.getParameter("ord_typ_code");
	String catalog_code = request.getParameter("catalog_code");
	String ord_cat_id = request.getParameter("val1");
	String order_status = request.getParameter("order_status");
	String p_called_from_ca			=request.getParameter("p_called_from_ca");//IN071315
	//String reason_desc = "";
	//out.println(">>>>>>>>>>>"+orderId+"<BR>");
	
//	out.println(cancelled_at+"<BR>");

	ArrayList allValues = new ArrayList();
/* Mandatory checks end */
	String cont_order_ind = request.getParameter("cont_order_ind");
	if(cont_order_ind == null) cont_order_ind = "";
	
	/* Initialize Function specific start */
//	CancelOrder bean = (CancelOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	allValues		= bean.getCancelReason(ord_cat_id);
	//IN072752 Starts
	Boolean isFPPApplicableyn =false;
	String fpp_yn = "";
	String fpp_category = "";
	Connection con=null ;
	try {
	con = ConnectionManager.getConnection(request);
	isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");
	if(isFPPApplicableyn){
	ArrayList fppDtls = bean.getFPPDetailsForOrder(orderId, order_line_num);
	
	if(null!=fppDtls && fppDtls.size()> 0){
	 if(null!=fppDtls.get(0) && null!=fppDtls.get(1)){
		fpp_yn = fppDtls.get(0).toString();
		fpp_category = fppDtls.get(1).toString();
	 }
	}
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	//IN072752 Ends
	//IN043143 Starts
	String order_line_status = "";
	if("PH".equals(ord_cat_id))
	{
		order_line_status	= beanExisOrder.getOrderLineStatus(orderId,order_line_num);
	}	
	//IN043143 Ends
	//out.println("<script>alert('ord_cat_id="+ord_cat_id+"');</script>");

	// Get the appt_ref_num if it is there

	String appt_ref_num = bean.getApptRefNo(orderId);
 %>

<html>
<head>
	<title><fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
 	<script language="JavaScript" src="../js/CancelOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body   onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST name="cancel_line" id="cancel_line">
<table cellpadding=3 cellspacing=0 border=0 width='100%' height="100%" align=center>
<tr><td class=label><fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/></td>
	<td class=fields><SELECT name="cancel_reason" id="cancel_reason" onchange='displayDesc(this)'>
	<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			try{
				

				for(int i=0; i<allValues.size(); i++){
					String[] record = (String [])allValues.get(i);
			
		%>
				<option value="<%=record[1]%>"><%=record[2]%>
		<%	
				}
    //		allValues.clear();
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
	</SELECT>
	</td>
	</tr>
	<tr>
	<td class='fields' colspan="2">
	<TEXTAREA NAME="reason_desc" ROWS="12" COLS="50" onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA>
	</td>
	</tr>
	<tr>
	<!--<td  colspan=2 class='button'>IN070698-->
	<td  colspan=2 class='button' style="padding-right:50px;"><!--IN070698-->
	<input type=button class=button name='ok' id='ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onClick="cancelLineRecord()"><input type=button class=button name='close' id='close' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="window.close()">
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="which_place" id="which_place" value="cancel_line_rec">
	<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>">
	<input type="hidden" name="ord_typ_code" id="ord_typ_code" value="<%=ord_typ_code%>">
	<input type="hidden" name="catalog_code" id="catalog_code" value="<%=catalog_code%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
	<input type="hidden" name="cont_order_ind" id="cont_order_ind" value="<%=cont_order_ind%>">
	<input type="hidden" name="appt_ref_num" id="appt_ref_num" value="<%=appt_ref_num%>">
	<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat_id%>"><!--IN043143-->
	<input type="hidden" name="order_status" id="order_status" value="<%=order_line_status%>"><!--IN043143-->
	<input type="hidden" name="OldOrderStatus" id="OldOrderStatus" value="<%=request.getParameter("order_status")%>"><!--IN007187 -->
	<input type="hidden" name="p_called_from_ca" id="p_called_from_ca" value="<%=p_called_from_ca%>"><!--Added for IN071315 -->
	<input type="hidden" name="fpp_yn" id="fpp_yn" value="<%=fpp_yn%>"><!--IN072752 -->
	<input type="hidden" name="fpp_category" id="fpp_category" value="<%=fpp_category%>"><!--IN072752 -->

</FORM>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

