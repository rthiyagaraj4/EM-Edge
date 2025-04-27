<!DOCTYPE html>
 <% 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/05/2021  	        TFS id:-17345           Haribabu	      05/05/2021	 	 Manickavasagam J         NMC-JD-SCF-0183
--------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page contentType="text/html;charset=UTF-8" 
import="eST.*,eST.Common.*,java.lang.*,java.util.*"%>  
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
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String PO_from="";
	String item_code			=		"";
	String tmp_conv				=		(String)request.getParameter("tmp_conv");
	int rec_high_no				=		-1;
	mode						=		request.getParameter( "mode" ) ;
	System.out.println("mode=========31==========>"+mode+"====="+request.getQueryString());
	if(mode==null)	mode		=		"1";
	function_id					=		request.getParameter( "function_id" ) ;
	PO_from						=		request.getParameter( "PO_from" )==null?"":request.getParameter( "PO_from" );

	if(request.getParameter("index") != null && !request.getParameter("index").equals("undefined")){
			rec_high_no			=		Integer.parseInt(request.getParameter("index"));
	}

	bean_id						=		"goodsReceivedNoteBean" ;
	bean_name					=		"eST.GoodsReceivedNoteBean";

	GoodsReceivedNoteBean bean	=		(GoodsReceivedNoteBean) getBeanObject(bean_id,bean_name,request);
	ArrayList alDetailData		=		bean.getDtlRecords();//bean.getDetailValues();
	bean.setLanguageId(locale);


	String item_cost_value = "";
//	String by_po = "N";

	HashMap PO_Interface			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")});

	String po_interface_yn =    bean.checkForNull((String)PO_Interface.get("PO_INTERFACE_YN"),"N");
	String by_po		   = "N";
	

%>
	</head>
<body>
<form name='formGoodsReceivedNoteDetail' id='formGoodsReceivedNoteDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 >
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></th>
	<%
	HashMap ht	=	new HashMap();
	for(i=0;i<alDetailData.size();i++)
	{
		ht						=		(HashMap)alDetailData.get(i);

		System.out.println("ht=========59==========>"+ht);

		String classValue		=		"";
		double lqty=0.0;
		double ordered_qty = 0.0;

		if (!ht.get("item_qty_normal").toString().equals("")) {
			lqty				=		lqty+Double.parseDouble(ht.get("item_qty_normal").toString());
		}
		if (!ht.get("item_qty_bonus").toString().equals("")) {
			lqty				=		lqty+Double.parseDouble(ht.get("item_qty_bonus").toString());
		}
		/*if (!ht.get("item_qty_sample").toString().equals("")) {
			lqty				=		lqty+Long.parseLong(ht.get("item_qty_sample").toString());
		}*/
		
		item_code			=		(String)ht.get("item_code") ;
		String no_deci = (String)ht.get("no_deci");
		String allow_deci_yn = (String)ht.get("allow_deci_yn");
		if(allow_deci_yn.equals("N"))
			no_deci ="0";
		if(i%2==0)classValue	=		"QRYEVEN";
		else	  classValue	=		"QRYODD";

		if(i == rec_high_no)
				classValue		=		"STLIGHTPINK";

		item_cost_value = (String)ht.get("item_cost_value");
		
		double item_cost_value_new=lqty*Double.parseDouble(bean.checkForNull((String)ht.get("grn_unit_cost_in_pur_uom"),"0"));//Added for TFS Id:-17345
		
		if(po_interface_yn.equals("Y") && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		ordered_qty = Double.parseDouble(bean.checkForNull((String)ht.get("ordered_qty"),"0"));
		}

		by_po =  bean.checkForNull((String)ht.get("by_po"),"N");

		%> 
	<tr id="tr_<%=i%>" name="tr_<%=i%>">
		<td class='fields'  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" ></td>
		<td class='fields' width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
		<%if(!po_interface_yn.equals("Y")){%>
		<font size=1><a name="a_<%=i%>" id="a_<%=i%>" href="javascript:modifyData('<%=i%>','<%=by_po%>');setTempConvFactor(<%=tmp_conv%>);"><%=ht.get("item_code")%>_<%=ht.get("item_desc")%><br><!-- item_code NMC-JD-CRF-0142 added for  -->
		<fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/>:<%=bean.setNumber(""+lqty,Integer.parseInt(no_deci))%>&nbsp;&nbsp;
		<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=ht.get("item_cost_value")%></font></a>
		<%}else{%>
		<font size=1><a name="a_<%=i%>" href="javascript:modifyData('<%=i%>','<%=by_po%>');setTempConvFactor(<%=tmp_conv%>);"><%=ht.get("item_code")%>_<%=ht.get("item_desc")%><br><!-- item_code NMC-JD-CRF-0142 added for  -->
		<fmt:message key="eST.GRNQuantity.label" bundle="${st_labels}"/>:<%=bean.setNumber(""+lqty,Integer.parseInt(no_deci))%>&nbsp;&nbsp;
		<!--<fmt:message key="Common.OrderQty.label" bundle="${common_labels}"/>:<%=bean.setNumber(""+ordered_qty,Integer.parseInt(no_deci))%>&nbsp;&nbsp;--upto to now this is commented 35256-->
		<fmt:message key="Common.Value.label" bundle="${common_labels}"/>:<%=bean.setNumber(""+item_cost_value_new,Integer.parseInt(no_deci))%></font></a><!-- Modified for TFS id:-17345 -->
		<%}%> 
		</td> 
	</tr>
	<%}%>
	</table><b></b>
	<!--<table border='1' cellpadding='0' cellspacing='0' width=300 align=center>
			<tr><td>
				<input type=button name="preview" id="preview" value="Preview" class=button onclick="previewDetails();"></td>
			</tr>
	</table>-->
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"	value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id"			value="<%= function_id %>">
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="tmp_conv" id="tmp_conv"			value="<%=tmp_conv%>">
	<input type="hidden" name="item_code" id="item_code"			value="<%=item_code%>">
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
<%if(alDetailData.size()>0)%>
	<script>
	    setTimeout("toConvFactor();",1500);
	</script>
<%if (request.getParameter("index")!=null && !request.getParameter("index").equals("undefined")) {%>
<script language="JavaScript">
	document.getElementById("a_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>).scrollIntoView();
	changeRowColor(document.getElementById("tr_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>));	
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</html>

