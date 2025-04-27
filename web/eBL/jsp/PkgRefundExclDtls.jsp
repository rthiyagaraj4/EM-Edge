
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat,eBL.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/PkgRefund.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<% 
	try
	{		
		String locale			= (String)session.getAttribute("LOCALE");
		String	loggedInUser	=  (String) session.getValue("login_user");	
		String facility_id			= request.getParameter("facility_id")==null?"": request.getParameter("facility_id");
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		String pkg_code			= request.getParameter("pkg_code")==null?"": request.getParameter("pkg_code");
		String pkg_seq_no			= request.getParameter("pkg_seq_no")==null?"": request.getParameter("pkg_seq_no");
		String pkg_serv_code			= request.getParameter("pkg_serv_code")==null?"": request.getParameter("pkg_serv_code");
		String parent_index			= request.getParameter("parent_index")==null?"": request.getParameter("parent_index");
		String pkg_serv_desc			= request.getParameter("pkg_serv_desc")==null?"": request.getParameter("pkg_serv_desc");
		String no_of_decimal			= request.getParameter("no_of_decimal")==null?"": request.getParameter("no_of_decimal");
		//System.out.println("pkg_serv_code="+pkg_serv_code);
		String bean_id		= "PkgRefundBean" ;
		String bean_name	= "eBL.PkgRefundBean";
		PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
		
		ArrayList excl_srv_list=bean.getExclSrvDtls(facility_id,patient_id,locale,pkg_code,pkg_seq_no,pkg_serv_code);
		String[] excl_srv_dtls=new String[12];
		String disabled="";
		String refund_serv="N";
		int total_records=0;		
		
		String excl_serv_ind="";
		String excl_serv_code="";
		String excl_serv_desc="";
		String refund_yn="";
		String exclude_yn="";
		String refund_rate="";
		String utilized_serv_qty="";
		String utilized_serv_amt="";
		String available_amt="";
		String refund_amt="0";
		String refunded="";
		String refunded_amount="0";
		boolean user_adhoc_refund_appl=bean.getUserAdhocRefundAppl(loggedInUser,facility_id);
		boolean user_refund_appl = bean.getUserPkgRefundAppl(loggedInUser,facility_id);

   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">	
	<form name='PkgRefundExclDtlsForm' id='PkgRefundExclDtlsForm' >
	<table class='grid' >
	<%	if(excl_srv_list!=null && excl_srv_list.size()>0){%>
	<tr><td colspan='2' class='COLUMNHEADER'><fmt:message key="eBL.PackageServiceCode.label" bundle="${bl_labels}"/></td>
	<td colspan='2' class='COLUMNHEADER'><%=pkg_serv_desc%></td>
	<td colspan='6' class='COLUMNHEADER'></td>
	</tr>
	<tr >
		<td  class='COLUMNHEADER' ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>			
		<td  class='COLUMNHEADER' ><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>			
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.RefundRate.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.UtilizedServiceQty.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.UtilizedServiceAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.AvailableServiceAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.RefundAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.APPLY_REFUND.label" bundle="${bl_labels}"/></td>	
	</tr>
	<%

		total_records=excl_srv_list.size();
		//System.out.println("total_records="+total_records);
		for(int i=0;i<total_records;i++){
		excl_srv_dtls=(String[])excl_srv_list.get(i);

			
		excl_serv_ind=excl_srv_dtls[0];
		excl_serv_code=excl_srv_dtls[1];
		excl_serv_desc=excl_srv_dtls[2];
		exclude_yn=excl_srv_dtls[3];
		refund_yn=excl_srv_dtls[4];
		refund_rate=excl_srv_dtls[5];
		utilized_serv_qty=excl_srv_dtls[6];
		utilized_serv_amt=excl_srv_dtls[7];		
		available_amt=excl_srv_dtls[8];
		refund_amt=excl_srv_dtls[9];
		refunded=excl_srv_dtls[10];
		refund_serv=excl_srv_dtls[12];
			refunded_amount="0";
	%>
		
	<tr>
		<td class="label" nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>			
		<td class="label" nowrap><%=excl_serv_code%></td>			
		<td class="label" nowrap><%=excl_serv_desc%></td>			
		<td class="label" nowrap><%=exclude_yn%></td>			
		<td class="label" nowrap><%=refund_yn%></td>			
		<td class="label" nowrap><%=refund_rate%></td>			
		<td class="label" nowrap><%=utilized_serv_qty%></td>			
		<td class="label" nowrap><%=utilized_serv_amt%></td>	
	
	<%
	if(disabled.equals("")){
		if(user_refund_appl && user_adhoc_refund_appl){
			disabled="";
		}else if(user_refund_appl && !user_adhoc_refund_appl){
			if(refund_yn.equals("N")){
				disabled="disabled";
				refund_serv="N";
				refund_amt="0";
			}else{
				disabled="";		
			}
		}else if(!user_refund_appl && user_adhoc_refund_appl){
			if(refund_yn==null || refund_yn.equals("N")){
				disabled="";
			}else{
				disabled="disabled";	
				refund_serv="N";
				refund_amt="0";				
			}
		} 
	}

	if(refunded.equals("Y")){
		disabled="disabled";
		 refund_serv="Y";
		 refunded_amount=excl_srv_dtls[11];
		 refund_amt=refunded_amount;
		 available_amt="0";
	}

	if(exclude_yn.equals("Y")){
		disabled="disabled";
		refund_serv="N";
		refund_amt="0";
		available_amt="0";
	}	
	%>	
<td class="label" nowrap><%=available_amt%></td>		
		<td class="field" nowrap><input type="text" name="refund_amt<%=i%>" id="refund_amt<%=i%>" <%=disabled%> value="<%=refund_amt%>" onBlur="ChkExclRefundAmt(this,'<%=i%>')" onkeypress='return allowValidNumber(this,event,"<%=no_of_decimal%>")'></td>	
		<td class="field" nowrap><input type='checkbox' name='refund_serv<%=i%>' id='refund_serv<%=i%>'  <%=refund_serv.equals("Y")?"checked":""%>  value="<%=refund_serv%>"  <%=disabled%> onClick="refundExclService(this,'<%=i%>');"></td>		
				
		<input type="hidden" name="excl_serv_ind<%=i%>" id="excl_serv_ind<%=i%>" value="<%=excl_serv_ind%>">
		<input type="hidden" name="excl_serv_code<%=i%>" id="excl_serv_code<%=i%>" value="<%=excl_serv_code%>">
		<input type="hidden" name="excl_serv_desc<%=i%>" id="excl_serv_desc<%=i%>" value="<%=excl_serv_desc%>">			
		<input type="hidden" name="exclude_yn<%=i%>" id="exclude_yn<%=i%>" value="<%=exclude_yn%>">
		<input type="hidden" name="refund_yn<%=i%>" id="refund_yn<%=i%>" value="<%=refund_yn%>">
		<input type="hidden" name="refund_rate<%=i%>" id="refund_rate<%=i%>" value="<%=refund_rate%>">		
		<input type="hidden" name="utilized_serv_qty<%=i%>" id="utilized_serv_qty<%=i%>" value="<%=utilized_serv_qty%>">
		<input type="hidden" name="utilized_serv_amt<%=i%>" id="utilized_serv_amt<%=i%>" value="<%=utilized_serv_amt%>">
		<input type="hidden" name="available_amt<%=i%>" id="available_amt<%=i%>" value="<%=available_amt%>">
		<input type="hidden" name="refunded<%=i%>" id="refunded<%=i%>" value="<%=refunded%>">
		<input type="hidden" name="refunded_amount<%=i%>" id="refunded_amount<%=i%>" value="<%=excl_srv_dtls[10]%>">
	
			
	</tr>
	<%}
		}
	%>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
<input type='hidden' name='pkg_code' id='pkg_code' value="<%=pkg_code%>" >
<input type='hidden' name='pkg_seq_no' id='pkg_seq_no' value="<%=pkg_seq_no%>" >
<input type='hidden' name='pkg_serv_code' id='pkg_serv_code' value="<%=pkg_serv_code%>" >
<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" >
<input type='hidden' name='total_records' id='total_records' value="<%=total_records%>" >
<input type='hidden' name='no_of_decimal' id='no_of_decimal' value="<%=no_of_decimal%>" >
</form>
</body>

</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package Refund excl dtls :"+e);
	e.printStackTrace();
}finally
	{
	//	if(pstmt != null)pstmt.close();
		//ConnectionManager.returnConnection(con, request);
	}
		%>
		



