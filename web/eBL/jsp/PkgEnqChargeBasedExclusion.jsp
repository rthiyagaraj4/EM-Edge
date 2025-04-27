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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script> <script language="javascript" src='../js/PkgEnq.js'></script> 
<!--  <script language="javascript" src='../js/PkgEnqTemp.js'></script> 
 --><Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<% 
try
{

	String packageCode			=	"" ;
	String itemCode				= "";
	String itemDesc				= "";
	String qtyLimit				= "";
	String amountLimit			= "";
	String inExcl				= "N";
	String inDisabled			= " ";

	HashMap excludedItems		= new HashMap();
	ArrayList itemsForService	= new ArrayList();
	packageCode					= request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;

	String serviceCode			=	request.getParameter("serviceCode") == null ? "" :request.getParameter("serviceCode") ;
	
	
	String packageSeqNo			=	request.getParameter("packageSeqNo") ;
	packageSeqNo				=	packageSeqNo == null ? "" :packageSeqNo ;

	ArrayList itemGroup	        =	new ArrayList();
	ArrayList itemDescGroup     =	new ArrayList();
	ArrayList inExcnGroup		=	new ArrayList();
	ArrayList amountLtGroup		=	new ArrayList();
	ArrayList qtyLtGroup		=	new ArrayList();
	
	
	int  totRec=0;
	String bean_id				= "bl_PkgEnqBean" ;
	String bean_name			= "eBL.PkgEnqBean";
	PkgEnqBean bean				= (PkgEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	excludedItems				=  bean.getExcludedItems_CB();
	if(excludedItems.size()>0 && excludedItems.containsKey(serviceCode) )
	{
		itemsForService =(ArrayList)excludedItems.get(serviceCode);
		if(itemsForService.size()>0)
		{
			itemGroup		= (ArrayList)itemsForService.get(0);
			itemDescGroup	= (ArrayList)itemsForService.get(1);
			qtyLtGroup		= (ArrayList)itemsForService.get(2);
			amountLtGroup	= (ArrayList)itemsForService.get(3);
			inExcnGroup		= (ArrayList)itemsForService.get(4);
			if(itemGroup.size()>0)
				totRec =  itemGroup.size();
			
		}
	}
	%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">
	<form name='frmPkgEnqChargeBasedExcln' id='frmPkgEnqChargeBasedExcln'>	
	<table class='grid' width='100%' id="pkgCbasedItem">
	<tr >
	<td  class='COLUMNHEADER' width="20%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' ><b><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></b></td>
	<td  class='COLUMNHEADER' ><b><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></b></td>
	<td  class='COLUMNHEADER' ><b><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></b></td>	
	</tr>
	
	<%
	String inSel = "";
	for(int i=0; i<totRec; i++)
	{	
		if(itemGroup!=null && itemGroup.size()>0)
		{
			itemCode	= (String)itemGroup.get(i);
			itemDesc	=	(String)itemDescGroup.get(i);
			qtyLimit	= (String)qtyLtGroup.get(i);
			amountLimit = (String)amountLtGroup.get(i);
			inExcl		=  (String)inExcnGroup.get(i);
			if(inExcl.equals("Y"))
			{
				inSel = " checked ";
				inDisabled = " disabled ";
			}
			else 
			{
				inSel = "  ";
				inDisabled = " ";
			}
		}
		%>
		<tr >
		<td  class='fields'><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>' id='cbCode_<%=i%>'size='10' maxlength="10"  value="<%=itemCode%>" disabled ><input type='text' name='cbDesc_<%=i%>' id='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='30' maxlength="100"  value="<%=itemDesc%>"  disabled></td>

		<td  class='fields' >
		<input type='checkbox' name='inEx_<%=i%>' id='inEx_<%=i%>' value="<%=inExcl%>" <%=inSel%> disabled   />
		</td>
		<td  class='fields' >
		 <input type='text' name='quantityLimit_<%=i%>' id='quantityLimit_<%=i%>'  <%=inDisabled%>  size='15' maxlength="15"  value="<%=qtyLimit%>" disabled/></td>
		<td  class='fields' >
		<input type='text' name='amountLimit_<%=i%>' id='amountLimit_<%=i%>' <%=inDisabled%>  size='15' maxlength="15"  value="<%=amountLimit%>" disabled /></td>
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
	System.out.println("Exception from  PkgEnqChargeBasedExclusion:"+e);
	e.printStackTrace();
}
%>

