<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eST.*,eSS.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="JavaScript" src="../../eSS/js/CheckList.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		HashMap ht					=		null;//new HashMap();
		CheckListBean bean		=		(CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ;  
		bean.setLanguageId(locale);
		String checklist_code = "";
		ArrayList alDtlRecords		=		new ArrayList();
		alDtlRecords				=		bean.getDtlRecords();
		String classValue			=		"";
		String mode					=		request.getParameter("mode");
		int mad_records = 0;

		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			 checklist_code		=		(String)request.getParameter("checklist_code");
//System.out.println("checklist_code"+checklist_code);
			if(alDtlRecords.size()<=0){
				bean.loadData(checklist_code);
				alDtlRecords		=		bean.getDtlRecords();
			//System.out.println("alDtlRecords"+alDtlRecords);
			}
		}
	%>
	<body onMouseDown="CodeArrest()">
		<form name="KitTemplateListDetailform" id="KitTemplateListDetailform" >
			<table cellspacing=0 cellpadding=0 height="5%" width="100%"  align="center" border=1>			    
				<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
				<th>Mandatory&nbsp</th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%
					for(int i=0;i<alDtlRecords.size();i++){
						ht					=	(HashMap)alDtlRecords.get(i);
					if(i%2==0) classValue	=	"QRYEVEN";
					else		classValue	=	"QRYODD"; 

				%>
				<tr onclick="ModifyData('<%=i%>',this,'<%=(String)ht.get("mandatory_status")%>','<%=(String)ht.get("eff_status")%>','<%=(String)ht.get("db_action")%>');">
					<td class="<%=classValue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK' ><%=(String)ht.get("item_code")%></font></td>
					<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" onclick='disableClick(event);'><%=(String)ht.get("item_desc")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);'><%=(String)ht.get("qty")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);'><%=(String)ht.get("seq_no")%></td>
					<td class="<%=classValue%>" onclick='disableClick(event);'>	
				<%	if(ht.get("mandatory_status").equals("Y")){ mad_records = mad_records+1;%><img src="../../eCommon/images/enabled.gif"></img>
				  <%}else if(ht.get("mandatory_status").equals("N")){%><img src="../../eCommon/images/disabled.gif"></img> <%}
				%></td>
				<td class="<%=classValue%>" onclick='disableClick(event);'>	
				<%	if(ht.get("eff_status").equals("E")){%><img src="../../eCommon/images/enabled.gif"></img>
				  <%}else if(ht.get("eff_status").equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}
				%></td>
				</tr>
					<%}%>
		 </table>
	<%
//putObjectInBean("kitTemplateBean",bean,request);
%>
		<input type="hidden" name="records" id="records" value="<%=alDtlRecords.size()%>">
		<input type="hidden" name="mad_records" id="mad_records" value="<%=mad_records%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="checklist_code" id="checklist_code" value="<%=bean.checkForNull(checklist_code,"")%>">
		</form>
	</body>
</html>

