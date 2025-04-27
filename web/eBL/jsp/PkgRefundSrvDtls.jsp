<!DOCTYPE html>
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
		Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
	try
	{		

		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= request.getParameter("facility_id")==null?"": request.getParameter("facility_id");
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		String pkg_code			= request.getParameter("pkg_code")==null?"": request.getParameter("pkg_code");
		String pkg_seq_no			= request.getParameter("pkg_seq_no")==null?"": request.getParameter("pkg_seq_no");
		String	loggedInUser	=  (String) session.getValue("login_user");	
		
		String bean_id		= "PkgRefundBean" ;
	String bean_name	= "eBL.PkgRefundBean";
	PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList srv_list=bean.getSrvDtls(facility_id,patient_id,locale,pkg_code,pkg_seq_no);
	boolean user_adhoc_refund_appl=bean.getUserAdhocRefundAppl(loggedInUser,facility_id);
	boolean user_refund_appl = bean.getUserPkgRefundAppl(loggedInUser,facility_id);
	String[] srv_dtls=new String[13];
	String disabledExcl="";
	String disabledRefundAppl="";

	String pkg_serv_ind="";
	String pkg_serv_code="";
	String pkg_serv_desc="";
	String order_catalog_code="";
	String refund_yn="";
	String refund_rate="";
	String utilized_serv_qty="";
	String utilized_serv_amt="";
	String refunded="";

	String refunded_amt="0";
	String available_amt="0";
	int total_records=0;
	
	ResultSet rscurr			= null;
	int noofdecimal=2;
	try{
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}			
		}catch(Exception e)
			{
				System.out.println("Exception no. of decimal :"+e);
				e.printStackTrace();
			}
   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">	
	<form name='PkgRefundSrvDtlsForm' id='PkgRefundSrvDtlsForm' >
	<table class='grid' >
	<tr >
		<td  class='COLUMNHEADER' ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>			
		<td  class='COLUMNHEADER' ><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></td>			
		<td  class='COLUMNHEADER' ><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.RefundRate.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.UtilizedServiceQty.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.UtilizedServiceAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.AvailableServiceAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.RefundAmt.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.APPLY_REFUND.label" bundle="${bl_labels}"/></td>		
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.Excl.label" bundle="${bl_labels}"/></td>		
	</tr>
	<%
	if(srv_list!=null && srv_list.size()>0){
		total_records=srv_list.size();
		for(int i=0;i<total_records;i++){
			srv_dtls=(String[])srv_list.get(i);
			
			pkg_serv_ind=srv_dtls[0];
			pkg_serv_code=srv_dtls[1];
			pkg_serv_desc=srv_dtls[2];
			order_catalog_code=srv_dtls[3];
			refund_yn=srv_dtls[4];
			refund_rate=srv_dtls[5];
			utilized_serv_qty=srv_dtls[6];
			utilized_serv_amt=srv_dtls[7];
			available_amt=srv_dtls[8];
			refunded=srv_dtls[9];
			disabledExcl="";
			disabledRefundAppl="";
			refunded_amt="0";
	%>
	<tr>
<td class="label" nowrap>	
<%	
		if(pkg_serv_ind.equals("S")){%>
			<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
		<%disabledExcl="disabled";
		}else if(pkg_serv_ind.equals("C")){%>
			<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
		<%
			disabledExcl="";
			disabledRefundAppl="disabled";
	
		}else if(pkg_serv_ind.equals("G")){%>
			<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/>
		<%
			disabledExcl="";
			disabledRefundAppl="disabled";

		}%>
	</td>			
		<td class="label" nowrap><%=pkg_serv_code%></td>			
		<td class="label" nowrap><%=pkg_serv_desc%></td>			
		<td class="label" nowrap><%=order_catalog_code%></td>			
		<td class="label" nowrap><%=refund_yn%></td>			
		<td class="label" nowrap><%=refund_rate%></td>			
		<td class="label" nowrap><%=utilized_serv_qty%></td>			
		<td class="label" nowrap><%=utilized_serv_amt%></td>			
		
	<%


	
	if(disabledRefundAppl.equals("")){
		if(user_refund_appl && user_adhoc_refund_appl){
			disabledRefundAppl="";
		}else if(user_refund_appl && !user_adhoc_refund_appl){
			if(refund_yn.equals("N")){
				disabledRefundAppl="disabled";
			}else{
				disabledRefundAppl="";		
			}
		}else if(!user_refund_appl && user_adhoc_refund_appl){
			if(refund_yn==null || refund_yn.equals("N")){
				disabledRefundAppl="";
			}else{
				disabledRefundAppl="disabled";		
			}
		} 
	}
	if(refunded.equals("Y")){
		disabledRefundAppl="disabled";		
		disabledExcl="disabled";	
		refunded_amt=	srv_dtls[10];	
		available_amt="0";
	}
	%>		
		<td class="label" nowrap><%=available_amt%></td>
		<td class="label" nowrap><input type="text" name="refund_amt<%=i%>" id="refund_amt<%=i%>" <%=disabledRefundAppl%> value="<%=refunded_amt%>" onBlur="chkRefundAmt(this,'<%=i%>')" onkeypress='return allowValidNumber(this,event,"<%=noofdecimal%>")';></td>	
		<td class="field" nowrap><input type='checkbox' name='refund_serv<%=i%>' id='refund_serv<%=i%>' <%=disabledRefundAppl%> value="<%=refunded%>" <%=refunded.equals("Y")?"checked":""%>  onClick="refundService(this,'<%=i%>');"></td>
		<td class="field" nowrap><a href='#' name='excl_srv<%=i%>' onClick="displayExcl('<%=i%>');" <%=disabledExcl%>><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a></td>
		<input type="hidden" name="pkg_serv_ind<%=i%>" id="pkg_serv_ind<%=i%>" value="<%=pkg_serv_ind%>">
		<input type="hidden" name="pkg_serv_code<%=i%>" id="pkg_serv_code<%=i%>" value="<%=pkg_serv_code%>">
		<input type="hidden" name="pkg_serv_desc<%=i%>" id="pkg_serv_desc<%=i%>" value="<%=pkg_serv_desc%>">	
		<input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=order_catalog_code%>">		
		<input type="hidden" name="refund_yn<%=i%>" id="refund_yn<%=i%>" value="<%=refund_yn%>">
		<input type="hidden" name="refund_rate<%=i%>" id="refund_rate<%=i%>" value="<%=refund_rate%>">
		<input type="hidden" name="utilized_serv_qty<%=i%>" id="utilized_serv_qty<%=i%>" value="<%=utilized_serv_qty%>">
		<input type="hidden" name="utilized_serv_amt<%=i%>" id="utilized_serv_amt<%=i%>" value="<%=utilized_serv_amt%>">			
		<input type="hidden" name="available_amt<%=i%>" id="available_amt<%=i%>" value="<%=available_amt%>">			
		<input type="hidden" name="refunded<%=i%>" id="refunded<%=i%>" value="<%=refunded%>">			
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
<input type='hidden' name='total_records' id='total_records' value="<%=total_records%>" >
<input type='hidden' name='no_of_decimal' id='no_of_decimal' value="<%=noofdecimal%>" >
</form>
</body>

</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package Refund Service Dtl :"+e);
	e.printStackTrace();
}finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
		%>

