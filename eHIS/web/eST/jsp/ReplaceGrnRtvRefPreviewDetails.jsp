<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<title><fmt:message key="eST.AssociatedRTVsforReplacement.label" bundle="${st_labels}"/></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	
	String mode;
	String bean_id;
	String bean_name;
	// pmd 29/01/05
//	String function_id;

	mode						=		 request.getParameter( "mode" ) ;
	if(mode==null)	mode		=		"1";
	//function_id				=		request.getParameter( "function_id" ) ;
	
	bean_id						=		"replacementGRNBean" ;
	bean_name					=		"eST.ReplacementGRNBean";

	ReplacementGRNBean bean		=		(ReplacementGRNBean) getBeanObject( bean_id,bean_name, request );
	bean.setLanguageId(locale); 
	String classValue			=		"";
//	String current_item			=		"";
//	String previous_item		=		"";
//	String curr_item_cost_val	=		"";
//	String pre_item_cost_val	=		"";
	String item_code			=		request.getParameter("item_code");
	String all_deci_yn          =       bean.getAllowDecimalsYN(item_code);
	String no_deci              =       ""+bean.getNoOfDecimals();
	if(all_deci_yn.equals("N"))
	no_deci = "0";
			/**
			* @Name - Priya 
			* @Date - 15/06/2010
			* @Inc# - IN022070
			* @Desc - To Display the Item desc without junck characters removed java.net.URLDecoder.decode from the below coding
			* 
			*/
	String item_desc			=		request.getParameter("item_desc");
//String item_desc				=		java.net.URLDecoder.decode(request.getParameter("item_desc"));
%>
	</head>
<body>
<form name='formGrnRtvRefPreviewDetails' id='formGrnRtvRefPreviewDetails' >
	
	
	
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align="center">
	<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ReplacementQty.label" bundle="${st_labels}"/></th>	
	<th ><fmt:message key="eST.ReceivedQuantity.label" bundle="${st_labels}"/></th>
	<th ><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="Common.close.label" bundle="${common_labels}"/></th>
	
	<%
	
	int size			=		((HashMap)bean.getGRNRecords()).size();
	HashMap values		=		(HashMap)bean.getGRNRecords();
	ArrayList  records	=		new ArrayList();
	HashMap data		= new HashMap();
	for(int i=0;i<size;i++)
	{			
			records		=		(ArrayList)values.get(item_code);
	}
	if(records==null){
			  records	=		new ArrayList();

	}		
		%>
			<tr>
		<%
			
			for(int j=0;j<records.size();j++)
			{
				data = (HashMap)records.get(j);
				if(j%2==0)classValue="QRYEVEN";
					else classValue="QRYODD";
				
			%>

				<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" ><%=item_desc%></td>
				<td class="<%=classValue%>" ><%=(String)data.get("doc_type_code")%></td>
				<td class="<%=classValue%>" ><%=(String)data.get("doc_no")%></td>
				<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Replacement Qty, Received Qty, Pending Qty.				
					-->
				<td class="<%=classValue%>" style="TEXT-ALIGN:right" ><%=bean.setNumber((String)data.get("rtv_repl_qty"),Integer.parseInt(no_deci))%>&nbsp;</td>
				
				<td class="<%=classValue%>" style="TEXT-ALIGN:right"  ><%=bean.setNumber((String)data.get("received_qty"),Integer.parseInt(no_deci))%>&nbsp;</td>
					<td class="<%=classValue%>" style="TEXT-ALIGN:right"  ><%=bean.setNumber((String)data.get("pend_repl_qty"),Integer.parseInt(no_deci))%>&nbsp;</td>
				<td class="<%=classValue%>" ><font size=1>
				<%if(((String)data.get("close_yn")).equals("Y"))
					out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
				else
					out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
				%>
				</td>	</tr>
			<%
					}
				
			%>







	
	</table>
	</form>
<%
//	putObjectInBean(bean_id,bean,request);
%>

</body>
</html>

