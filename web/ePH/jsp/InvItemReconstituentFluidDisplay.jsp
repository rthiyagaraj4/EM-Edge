<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
	<script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/ReconstituentFluid.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--onMouseDown="CodeArrest()"  onKeyDown="lockKey()"-->
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String rfid		= request.getParameter( "rf_id" ) ;
	String bean_id	=	"ReconstituentFluidBean";
	String bean_name	=	"ePH.ReconstituentFluidBean";
	//int totalRecords=0;
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	//String facility_id=(String) session.getValue( "facility_id" );

	/* Initialize Function specific start */
	ReconstituentFluidBean bean = (ReconstituentFluidBean)getBeanObject( bean_id, bean_name , request) ;
	String Immodule_Yn=(String) bean.getImModule();

	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

	//totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );
	ArrayList itemList=new ArrayList();
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
	{
		itemList=bean.getItemList(rfid);
	}
%>

<form name="frmInvItemReconstituentFluidDisplay" id="frmInvItemReconstituentFluidDisplay">

	<table cellpadding=0 cellspacing=0 width='90%' align='center' border='1' id='tab'>
	<th align="left" colspan="2"><fmt:message key="ePH.ViewInventoryItems.label" bundle="${ph_labels}"/></th>
	<tr>
	<th align="left" width="65%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	<th align="left" width="35%"><fmt:message key="ePH.ContentinBaseUnit.label" bundle="${ph_labels}"/></th>
	</tr>
<%
	int count	=	0;
	String classvalue	=	"";
	String item_desc	=	"";
	String itemcode		=	"";
	String content		=	"";

	if (itemList.size()>0)
	{
		for (int i=0;i<itemList.size();i+=3)
		{
			itemcode	= ((String)itemList.get(i)).trim();
			item_desc	= ((String)itemList.get(i+1)).trim();	
			content		= ((String)itemList.get(i+2)).trim();
			if (count%2==0)	{
				classvalue="QRYEVEN";
			} else	{
				classvalue="QRYODD";
			}
%>
	<TR>
		<TD class="<%=classvalue%>"><a href='javascript:showDetail("<%=itemcode%>","<%=item_desc%>","<%=content%>","<%=count%>")'><%=item_desc%></a><input type='hidden' name="item_code<%=count%>" id="item_code<%=count%>" value="<%=itemcode%>"></TD>		
		<TD class="<%=classvalue%>"><%=content%><input type='hidden' name="content_in_base_uom<%=count%>" id="content_in_base_uom<%=count%>" value="<%=content%>" ></TD></TR>
				<%
				count++;
		}
	}
	%>
	</table>
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="<%=( (itemList.size()/2)-1)%>">

	<input type="hidden" name="RF_ID" id="RF_ID"	value="">
	<input type="hidden" name="RF_NAME" id="RF_NAME" value="">
	<input type="hidden" name="RF_BASE_UNIT" id="RF_BASE_UNIT" value="">

	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input TYPE="hidden" name="Immodule_Yn" id="Immodule_Yn" value="<%=Immodule_Yn%>">
	<input TYPE="hidden" name="itemcode" id="itemcode" value="<%=itemcode%>">


	</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

