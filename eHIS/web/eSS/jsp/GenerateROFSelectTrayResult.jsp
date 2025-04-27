<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eSS.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
		
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language="javascript" src="../../eSS/js/GenerateROF.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest();'>
	<%
		String bean_id			=		"generateROFBean";
		String bean_name		=		"eSS.GenerateROFBean";
		
		GenerateROFBean bean	=		(GenerateROFBean) getBeanObject( bean_id, bean_name,request ) ;

		String store_code		=		request.getParameter("store_code");
		String discrepancy_code =		request.getParameter("discrepancy_code");
 		String group_type		=		bean.checkForNull(request.getParameter("group_type"),"%"); //ML-MMOH-CRF-1821
		if(group_type!=null && (group_type.equals("") || group_type.equals(" ")))
			group_type			=		"%";
//System.err.println("===Sterilization request - group_type"+group_type);
		boolean searched		=		(request.getParameter("searched") == null) ?false:true;
		String classvalue		=		 "";

		java.util.ArrayList selectedTrays =			bean.getSelectTray();
		boolean hasCheckedValues		  =			false;
		String canCheck					  =			"";
		if (selectedTrays != null) {
			hasCheckedValues			  =			true;
		}
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));

			store_code					 =			CommonBean.checkForNull(store_code,"%");
			discrepancy_code			 =			CommonBean.checkForNull(discrepancy_code,"%");
			
			HashMap sqlMap				 =			new HashMap();
			sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_QUERY_RESULT_FOR_GENERATE_ROF"));  //decode(a.group_type,'E','Set','T','Tray','P','Soft Pack','S','Single','L','Linen') GROUP_TYPE  // added for ML-MMOH-CRF-1830
			

			HashMap funcMap				 =			new HashMap();

			ArrayList displayFields = new ArrayList();
			displayFields.add("owner_store_code");
			displayFields.add("store_desc");
			displayFields.add("group_code");
			displayFields.add("group_desc");
			displayFields.add("tray_no");
			displayFields.add("sterilize_reqd_yn");
			displayFields.add("wash_reqd_yn");
			displayFields.add("pack_reqd_yn");
 			displayFields.add("group_type");  // added for ML-MMOH-CRF-1830
			displayFields.add("group_type_desc");  // added for ML-MMOH-CRF-1830

			ArrayList chkFields = new ArrayList();
			


			chkFields.add(store_code);
			chkFields.add(discrepancy_code);
			chkFields.add(group_type); //ML-MMOH-SCF-1821

			// Adding function related array list into the HashMap

			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
 
			ArrayList result	=	(ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
 
			bean.updateDisplayArrayList(result);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
			%>
			<form name="formGenerateROFQueryResult" id="formGenerateROFQueryResult">
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<th><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th> <!--ML-MMOH-CRF-1830-->
					<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name='selectAll' id='selectAll'  onClick="changeStatusCheckBox(this);" ></th>
				</tr>		
		<%
			int index=0, recCount=2;
			ArrayList records=new ArrayList();

			for(index=0, recCount=2; recCount<result.size(); recCount++,index++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr>
		<%

				records = (ArrayList) result.get( recCount );
System.err.println("---records"+records);

				%>
					<td class="<%=classvalue%>"><%=records.get(1)%></td>
					<td class="<%=classvalue%>"><%=records.get(9)%></td><!--ML-MMOH-CRF-1830-->
					<td class="<%=classvalue%>"><%=records.get(3)%></td>
					<td class="<%=classvalue%>"><%=records.get(4)%></td>
				<%
				String tray_key		=	records.get(0) + "-"+records.get(2) + "-" +records.get(4);
				String tray_type	=	""+records.get(5)+records.get(6) + records.get(7);
				String total_key	=	tray_key+"-"+tray_type;
				if (hasCheckedValues && selectedTrays.contains(total_key)) {
					canCheck		=	"checked";
				}
				else {
					canCheck		=	"";
				}
		%>

                <td class="<%=classvalue%>" align="center"><input type="checkbox" name="tray_<%=index%>" id="tray_<%=index%>" value="<%=tray_type%>" onclick="assignValue(this);"  <%=canCheck%>></td>

			</tr>
			<input type="hidden" name="tray_key_<%=index%>" id="tray_key_<%=index%>"		value ="<%=tray_key%>">
			<input type="hidden" name="total_key_<%=index%>" id="total_key_<%=index%>"	value ="<%=total_key%>">
			<input type="hidden" name="group_type_<%=index%>" id="group_type_<%=index%>"	value ="<%=records.get(8)%>"><!--ML-MMOH-CRF-1830-->
		<%
			}
		%>
		</table>
			<input type="hidden" name="total_trays" id="total_trays"		value="<%=index%>">
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
		</form>	
		<%
			out.flush();
		}
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/GenerateROFSelectTrayResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}
%>
</body>
</html>
<%
	putObjectInBean(bean_id, bean,request);
%>

