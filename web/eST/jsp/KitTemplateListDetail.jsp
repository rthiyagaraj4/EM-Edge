<%@ page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title> 
		<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/KitTemplate.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		HashMap ht					=		null;//new HashMap();
		KitTemplateBean bean		=		(KitTemplateBean)getBeanObject( "kitTemplateBean","eST.KitTemplateBean", request ) ;  
		bean.setLanguageId(locale);
		ArrayList alDtlRecords		=		new ArrayList();
		alDtlRecords				=		bean.getDtlRecords();
		String classValue			=		"";
		String usage_type			=		""; //27/07/12
		String mode					=		request.getParameter("mode");

		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			String kit_template_code		=		(String)request.getParameter("kit_template_code");

			if(alDtlRecords.size()<=0){
				bean.loadData(kit_template_code);
				alDtlRecords		=		bean.getDtlRecords();
			}
		}
		/**
		* @Name - Krishna Kiran 
		* @Date - 20/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - added code to handle the decimal values DYNAMICALLY.
		*/
		int no_of_decimals = bean.getNoOfDecimals();
		int no_of_decimals_tmp = no_of_decimals;
		//NumberFormat nf_qty = NumberFormat.getInstance(new Locale(locale));
	%>
	<body onMouseDown="CodeArrest()">
		<form name="KitTemplateListDetailform" id="KitTemplateListDetailform" >
			<table cellspacing=0 cellpadding=0 height="5%" width="100%"  align="center" border=1>			    
				<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.UsageType.label" bundle="${st_labels}"/></th>
				<%
					for(int i=0;i<alDtlRecords.size();i++){
						ht					=	(HashMap)alDtlRecords.get(i);
					if(i%2==0) classValue	=	"QRYEVEN";
					else		classValue	=	"QRYODD"; 
					
					//27/07/12
				    if(bean.checkForNull((String)ht.get("usage_type")).equals("R")){
					 usage_type = "Required";
				 }else if(bean.checkForNull((String)ht.get("usage_type")).equals("O")){
					 usage_type = "Optional Required";
				 }else if(bean.checkForNull((String)ht.get("usage_type")).equals("P")){
					 usage_type = "Optional Pre-Selected";
				 }else if(bean.checkForNull((String)ht.get("usage_type")).equals("D")){
					 usage_type = "Optional De-Selected";
				 } 
				%>
				<tr onclick="ModifyData('<%=i%>',this,'<%=(String)ht.get("uom_code")%>','<%=(String)ht.get("eff_status")%>','<%=(String)ht.get("db_action")%>');">
					<td class="<%=classValue%>" onmouseover="this.style.cursor='pointer'"><font class='HYPERLINK' ><%=(String)ht.get("item_code")%></font></td>
					<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" onclick='disableClick(event);'><%=(String)ht.get("item_desc")%></td>
					<%
					if((bean.getAllowDecimalsYN(ht.get("item_code").toString())).equals("N"))
						no_of_decimals = 0;	
					else
						no_of_decimals = no_of_decimals_tmp;
				    %>
					<td class="<%=classValue%>" onclick='disableClick(event);' style="TEXT-ALIGN:right">					
					<%=bean.setNumber(bean.checkForNull(ht.get("qty").toString(),"0"),no_of_decimals)%>&nbsp;	
					</td>

					<td class="<%=classValue%>" onclick='disableClick(event);'><%=bean.getShortDesc((String)ht.get("uom_code"))%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);' style="TEXT-ALIGN:right"><%=(String)ht.get("seq_no")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);'>	
				<%	if(ht.get("eff_status").equals("E")){%><img src="../../eCommon/images/enabled.gif"></img>
				  <%}else if(ht.get("eff_status").equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}
				%></td>
				<!--<td class="<%=classValue%>" onclick='disableClick(event);' style="TEXT-ALIGN:left"><%=bean.checkForNull((String)ht.get("usage_type"))%>&nbsp;</td>-->
				<td class="<%=classValue%>" onclick='disableClick(event);' style="TEXT-ALIGN:left"><%=usage_type%>&nbsp;</td>
				</tr>
					<%}%>
		 </table>
	<%
//putObjectInBean("kitTemplateBean",bean,request);
%>
		<input type="hidden" name="records" id="records" value="<%=alDtlRecords.size()%>">
		</form>
	</body>
</html>

