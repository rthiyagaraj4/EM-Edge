<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgEnqBean, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgEnq.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
	<% 
	try
	{

		String packageCode		=	"" ;
		String srvLmt			= "N";
		String srvLmtChk        = "";
		String dtlsDisp	        = "NONE";
		String refndDisp		= "NONE";
		String factorAppl		="N";
		String roundTo			= "";
		String roundInd			= "";
		String uSelect			= "";
		String dSelect			= "";

		String refund			="N";
		String autoRefund		= "N";
		String refundAmt		="";
		String cbService		= "";
		String cbServiceDesc	= "";;
		String amountLimitInd	= "";
	
		String amountLimit		= "";
	
		String utilizedAmt		= "";
		String utilizedQty		= "";
		String refundedYN		= "N";
		int  totRec=1;
		packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
		String packageSeqNo	=	request.getParameter("packageSeqNo") ;
		packageSeqNo		=	packageSeqNo == null ? "" :packageSeqNo ;


		HashMap includedItems	    =	new HashMap();
		ArrayList services          =	new ArrayList();
		ArrayList serviceGroup	    =	new ArrayList();
		ArrayList serviceDescGroup  =	new ArrayList();
		ArrayList amtLmtIndGroup	=	new ArrayList();
		ArrayList amtLmtGroup		=	new ArrayList();
		ArrayList srvLmtsGroup	    =	new ArrayList();
		ArrayList factorApplGroup	=	new ArrayList();
		ArrayList roundToGroup      =	new ArrayList();
		ArrayList roundIndGroup     =	new ArrayList();
		ArrayList refund_list		=	new ArrayList();
		ArrayList refundAmt_list    =	new ArrayList();	
		ArrayList auto_refund_list  =	new ArrayList();
		ArrayList utilizedAmt_list	=	new ArrayList();
		ArrayList utilizedQty_list	=	new ArrayList();
		ArrayList refundedYN_list	=	new ArrayList();
		String bean_id				= "bl_PkgEnqBean" ;
		String bean_name			= "eBL.PkgEnqBean";
		PkgEnqBean bean				= (PkgEnqBean)getBeanObject( bean_id, bean_name, request ) ;
		includedItems				= bean.getIncludedItems_CB();
			
	
		if(includedItems.size()>0 && includedItems.containsKey(packageCode) )
		{
			services =(ArrayList)includedItems.get(packageCode);
			if(services.size()>0)
			{
				serviceGroup		= (ArrayList)services.get(0);
			    serviceDescGroup	= (ArrayList)services.get(1);
				amtLmtIndGroup		= (ArrayList)services.get(2);
				amtLmtGroup			= (ArrayList)services.get(3);
				srvLmtsGroup		= (ArrayList)services.get(4);
				factorApplGroup		= (ArrayList)services.get(5);
				roundToGroup		= (ArrayList)services.get(6);
				roundIndGroup		= (ArrayList)services.get(7);
				refund_list			= (ArrayList)services.get(8);
				refundAmt_list		= (ArrayList)services.get(9);
				auto_refund_list	= (ArrayList)services.get(10);
				utilizedAmt_list	= (ArrayList)services.get(11);
				utilizedQty_list    = (ArrayList)services.get(12);
				refundedYN_list		= (ArrayList)services.get(13);
				if(serviceGroup.size()>1)
					totRec =  serviceGroup.size();
			}
		}

   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">
	<form name='frmPkgEnqChargeBased' id='frmPkgEnqChargeBased'>	
	<table class='grid' width='100%' id="pkgCbased">
	<tr >
	<th  class='COLUMNHEADER' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></th>
	<th class='COLUMNHEADER'><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></th>
	<th  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></th>
	<th  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></th>
	<%if(!(packageSeqNo.equals("")))
	{%>
	<th class='columnheader' ><fmt:message key="eBL.UtilizedQty.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.UtilizedAmt.label" bundle="${bl_labels}"/></th>
	<th class='columnheader' ><fmt:message key="eBL.Refunded.label" bundle="${bl_labels}"/></th>

	<%}%>
	</tr>
	
	<%
	for(int i=0; i<totRec; i++)
	{	
		if(serviceGroup.size()>0)
		{
			cbService 		= (String)serviceGroup.get(i);
			cbServiceDesc 	= (String)serviceDescGroup.get(i);
			amountLimitInd 	= (String)amtLmtIndGroup.get(i);
			amountLimit		= (String)amtLmtGroup.get(i);
			srvLmt          = (String)srvLmtsGroup.get(i);
			factorAppl		= (String)factorApplGroup.get(i);
			roundTo			= (String)roundToGroup.get(i);
			roundInd		= (String)roundIndGroup.get(i);
			refund			=(String) refund_list.get(i);
			utilizedAmt		=(String) utilizedAmt_list.get(i);
			utilizedQty		=(String) utilizedQty_list.get(i);
			refundedYN		=(String) refundedYN_list.get(i);
			if(refund==null || refund.equals("") || refund.equals("null"))
				refund="N";
			refundAmt		= (String)refundAmt_list.get(i);
			autoRefund		= (String)auto_refund_list.get(i);
			
			if(srvLmt.equals("Y"))
			{
				srvLmtChk = " checked ";
				dtlsDisp = "inline ";
			}
			else
			{
				srvLmtChk = " ";
				dtlsDisp = "none ";
			}
			if(refund.equals("Y"))
				refndDisp  = "inline ";
			else
			   refndDisp  = "none ";

		}
			%>
	<tr >
	<td  class='fields' ><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>' id='cbCode_<%=i%>'size='5' maxlength="10"  value="<%=cbService%>" disabled >
	<input type='text' name='cbDesc_<%=i%>' id='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='15' maxlength="100"  value="<%=cbServiceDesc%>" disabled></td>
	<td  align="left" nowrap>
	<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>'disabled>
	<option value='A' <%=(amountLimitInd.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
	<option value='P'  <%=(amountLimitInd.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
	<option value='U'  <%=(amountLimitInd.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
	</select>
	</td>

	<td><input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>' disabled size='5' maxlength='5'  value="<%=amountLimit%>"/></td>

	<td  class='fields'>
	<input type='checkbox' name='srvLmt_<%=i%>' id='srvLmt_<%=i%>' value="<%=srvLmt%>" disabled <%=srvLmtChk%>  />
	<a  style ="display:<%=dtlsDisp%>"	 id='srvLmtDtls_<%=i%>' href='javascript:loadChargeBasedServiceLimit("<%=packageCode%>","<%=packageSeqNo%>","<%=cbService%>")'><fmt:message key='eBL.Dtls.label' bundle='${bl_labels}'/> </a>
			
	</td>
	<td  class='fields' ><input type='text' name='roundTo_<%=i%>' id='roundTo_<%=i%>' size='1'   value="<%=roundTo%>" disabled  /></td>

	<td  class='fields' >
	<select name='roundInd_<%=i%>' id='roundInd_<%=i%>' disabled >
	<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
	<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
	</select>
	</td>

	<td align="left" nowrap><input type='checkbox'    name='refund_<%=i%>' id='refund_<%=i%>' <%=refund.equals("Y")?"checked":""%> value="<%=refund%>" disabled/><input type='text' name='refundAmt_<%=i%>' id='refundAmt_<%=i%>' id='refundAmt_<%=i%>' style ="display:<%=refndDisp%>" value='<%=refundAmt%>' disabled  size='2' maxlength='4'  ></td>

	<td align="left" nowrap><input type='checkbox' disabled   name='autoRefund_<%=i%>' id='autoRefund_<%=i%>' <%=autoRefund.equals("Y")?"checked":""%> value="<%=autoRefund%>"/></td>

	<td align="left" nowrap><input type='checkbox'  name='factor_appl<%=i%>' id='factor_appl<%=i%>'  DISABLED  <%=factorAppl.equals("Y")?"checked":""%> value="<%=factorAppl%>"/></td>
	<%if(!(packageSeqNo.equals("")))
	{%>
	<td><input type='text' name='utilizedAmt<%=i%>' id='utilizedAmt<%=i%>' size='3' maxlength='5'   value="<%=utilizedAmt%>"disabled /></td>
	<td  class='fields' ><input type='text' name='utilizedQty<%=i%>' id='utilizedQty<%=i%>' size='3' maxlength="3"  value="<%=utilizedQty%>" disabled /></td>
	<td align="left" nowrap><input type='checkbox'    name='refundedYN<%=i%>' id='refundedYN<%=i%>' <%=refundedYN.equals("Y")?"checked":""%> value="<%=refundedYN%>" disabled/></td>
<%}%>
	</tr>
		<%} %>
		</table>		
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from PkgEnqChargeBased :"+e);
	e.printStackTrace();
}
%>

