<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
 	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
<%
	int i						 =		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String item_code			 =		request.getParameter("item_code");
	String tmp_conv				 =		(String)request.getParameter("tmp_conv");
	mode						 =		request.getParameter( "mode" ) ;
	if(mode==null)	mode		 =		"1";
	function_id					 =		request.getParameter( "function_id" ) ;
	
	bean_id						 =		"goodsReturnToVendorBean" ;
	bean_name					 =		"eST.GoodsReturnToVendorBean";

	GoodsReturnToVendorBean bean =		(GoodsReturnToVendorBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	ArrayList alDetailData		 =		bean.getDtlRecords();
	/**
	 * @Name - Priya
	 * @Date - 28/05/2010
	 * @Inc# - 
	 * @Desc -  To get no of decimals for cost    
	 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
%>
	</head>
<body>
<form name='formGoodsReturnToVendorDetail' id='formGoodsReturnToVendorDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>

	<%
	HashMap ht	=	new HashMap();
	for(i=0;i<alDetailData.size();i++)
	{
		String classValue			=		"";
		ht							=		(HashMap)alDetailData.get(i);
		item_code					=		(String)ht.get("item_code") ;
		double lqty					=		Double.parseDouble(ht.get("item_qty_normal").toString());

		if (!ht.get("item_qty_bonus").toString().equals("")) {
			lqty					=		lqty+Double.parseDouble(ht.get("item_qty_bonus").toString());
		}
		if(i%2==0)	classValue		=		"QRYEVEN";
		else classValue				=		"QRYODD";

		if (item_code!=null) {
			if (item_code.equals((String)ht.get("item_code"))) {
				classValue			=		"STLIGHTPINK";
			}
		
		}
		String no_deci = (String)ht.get("no_deci");
		String allow_deci_yn = (String)ht.get("allow_deci_yn");
		if(allow_deci_yn.equals("N"))
			no_deci ="0";
		%>
	<tr id="tr_<%=i%>" name="tr_<%=i%>">
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
		<font size=1><a id="a_<%=i%>" name="a_<%=i%>" href="javascript:modifyData(<%=i%>);"><%=ht.get("item_desc")%><br><fmt:message key="eST.RTVQuantity.label" bundle="${st_labels}"/>:<%=bean.setNumber(""+lqty,Integer.parseInt(no_deci))%>&nbsp;&nbsp;<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=bean.setNumber((String)ht.get("item_cost_value"),noOfDecimalsForCost)%></font></a></td>
	</tr>
	<%}%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="tmp_conv" id="tmp_conv"				value="<%=tmp_conv%>">
	<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">

	</form>

<%
//	putObjectInBean(bean_id,bean,request);
%>

</body>
<%if(alDetailData.size()>0)
	%><script>
	    setTimeout("toConvFactor();",1500);
//		toConvFactor();
	</script>
<%if (request.getParameter("index")!=null) {%>
<script language="JavaScript">
	//document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	//changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
	document.getElementById("a_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>).scrollIntoView();
	changeRowColor(document.getElementById("tr_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>));	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	}%>
</html>

