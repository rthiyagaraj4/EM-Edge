<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import=" eST.*,eST.Common.*,java.util.*,java.lang.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String item_code			=		"";
	String tmp_conv				=		(String)request.getParameter("tmp_conv");

	mode						=		request.getParameter( "mode" ) ;
	if(mode==null)	mode		=		"1";
	function_id					=		request.getParameter( "function_id" ) ;
	
	bean_id						=		"replacementGRNBean" ;
	bean_name					=		"eST.ReplacementGRNBean";

	ReplacementGRNBean bean		=		(ReplacementGRNBean) getBeanObject( bean_id,bean_name, request);
	ArrayList alDetailData		=		bean.getDtlRecords();//bean.getDetailValues();
	bean.setLanguageId(locale);
%>
	</head>
<body>
<form name='formGoodsReceivedNoteDetail' id='formGoodsReceivedNoteDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align="center">
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></th>
	<%
	HashMap ht					= null;
	for(i=0;i<alDetailData.size();i++)
	{
		String classValue			=		"";
		ht							=		(HashMap)alDetailData.get(i);
		double lqty=0;
		if (!ht.get("item_qty_normal").toString().equals("")) {
			lqty					=		lqty+Double.parseDouble(ht.get("item_qty_normal").toString());
		}
		if (!ht.get("item_qty_bonus").toString().equals("")) {
			lqty					=		lqty+Double.parseDouble(ht.get("item_qty_bonus").toString());
		}
	/*	if (!ht.get("item_qty_sample").toString().equals("")) {
			lqty					=		lqty+Long.parseLong(ht.get("item_qty_sample").toString());
		}*/
		item_code					=		(String)ht.get("item_code") ;
		String no_deci = (String)ht.get("no_deci");
		String allow_deci_yn = (String)ht.get("allow_deci_yn");
		if(allow_deci_yn.equals("N"))
			no_deci ="0";
		
		if(i%2==0)	classValue		=		"QRYEVEN";
		else		classValue		=		"QRYODD";
		%>
	<tr>
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
		<font size=1><a href="javascript:modifyData(<%=i%>);setTempConvFactor(<%=tmp_conv%>);"><%=ht.get("item_desc")%><br>
		<fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/>:<%=bean.setNumber(""+lqty,Integer.parseInt(no_deci))%>&nbsp;&nbsp;
		<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%>
		</font></a></td>
	</tr>
	<%}%>
	</table><b></b>
	<!--<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
			<tr><td>
				<input type=button name="preview" id="preview" value="Preview" class=button onclick="previewDetails();"></td>
			</tr>
	</table>-->
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id"			    value="<%= function_id %>">
	<input type="hidden" name="tmp_conv" id="tmp_conv"				value="<%=tmp_conv%>">
	<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">

	</form>
<%
//putObjectInBean(bean_id,bean,request);
%>

</body>
</html>

