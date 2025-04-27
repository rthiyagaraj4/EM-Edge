<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
   
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="javascript" src="../../eSS/js/ChangeBinLocationForTray.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
TD.ANBOR
{
  FONT-FAMILY: VERDANA ;
  FONT-SIZE: 9PT ;
  BACKGROUND-COLOR: #CFCFCF;
  COLOR:black;
}

</style>
	</head>
	<%
		String owner_store_code			=	request.getParameter("owner_store_code");
		String bin_location_code		=	request.getParameter("bin_location_code" );
		String tray_no					=	request.getParameter( "tray_no");
		String group_code				=	request.getParameter("group_code");
		String new_bin_location_desc	=	request.getParameter("new_bin_location_desc");
		String doc_desc					=	"";
		String pre_doc_no				=	"";
		ArrayList result				=	new ArrayList();
		String group_desc				=	"";
		String store_desc				=	"";
		String bin_desc					=	"";
		String new_bin_location			=	"";
		
		String bean_id					=	"changeBinLocationForTrayBean";
		String bean_name				=	"eSS.ChangeBinLocationForTrayBean";
		HashMap dataList				=	 null;
		int start						=	0;
		int end							=	0;
		int displaySize					=	0;
		int count						=	0;
		int maxRec						=	0;
		int chkCount					=	0;
		String classvalue				=	"";
		String from						=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
		String to						=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;

		String mode						=	 request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
		if ( mode == null || mode.equals("") ) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
			
		ChangeBinLocationForTrayBean bean = (ChangeBinLocationForTrayBean) getBeanObject( bean_id,  bean_name, request);  
	try{
	
		result=(ArrayList)bean.getResultList();
		maxRec=  result.size();
		displaySize = Integer.parseInt( eCommon.Common.CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));

		if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}

		
	%>
<body onMouseDown='CodeArrest();'>
		<form name="formChangeBinLocationForTrayQueryResult" id="formChangeBinLocationForTrayQueryResult"> 
	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<tr>
					<th><fmt:message key="eSS.OwnerStore.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.OldBinLocation.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="eSS.NewBinLocation.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
				</tr>	
<%
	
	count	= start;
	chkCount=start;


	while ( count < maxRec && chkCount < end)
	{
		dataList				 = (HashMap)result.get(count);
		group_code				 = (String)dataList.get("GROUP_CODE");
		group_desc				 = (String)dataList.get("GROUP_DESC");
		tray_no					 = (String)dataList.get("TRAY_NO");
		owner_store_code		 = (String)dataList.get("OWNER_STORE_CODE");
		store_desc				 = (String)dataList.get("STORE_DESC");
		bin_location_code		 = (String)dataList.get("BIN_LOCATION_CODE");
		bin_desc				 = (String)dataList.get("BIN_DESC");
		new_bin_location		 = (String)dataList.get("NEW_BIN_LOCATION");
		doc_desc				 = (String)dataList.get("DOC_DESC");
		pre_doc_no				 = (String)dataList.get("PRE_DOC_NO");
		new_bin_location_desc		 = (String)dataList.get("NEW_BIN_LOCATION_DESC")==null?"&nbsp;":(String)dataList.get("NEW_BIN_LOCATION_DESC");
		if(!bin_location_code.equals(bean.getNew_bin_location_code())){
			if ( chkCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	
	%>
			<tr  onClick="changeRowColor(this,7);Modify(this,'<%=group_code%>','<%=owner_store_code%>','<%=new_bin_location%>','<%=bin_location_code%>','<%=count%>')">
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%= store_desc %>
				</font></td>
			<td class="<%=classvalue%>" ><%= group_desc %></td>
			<td class="<%=classvalue%>" ><%= tray_no %></td>
			<td class="<%=classvalue%>" ><%= bin_desc %></td>
			<td class="<%=classvalue%>" ><%=( new_bin_location_desc)%></td>
			<td class="<%=classvalue%>" ><%=doc_desc%></td>
			<td class="<%=classvalue%>" ><%=pre_doc_no%></td>
			<td class='NODISPLAY'><%=new_bin_location%></td>
			<td class='NODISPLAY'><%=new_bin_location_desc%></td>
		</tr>
	<%
					chkCount++;
		}
		count++;
	
		
	}
	%>
	
<%
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					self.location.href="../../eCommon/html/blank.html";
	</script> 

	<%
	
	}
	}
	catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>

		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="start" id="start" value="<%=start%>">
		<input type="hidden" name="end" id="end" value="<%=end%>">
		<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
		<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
		<input type="hidden" value="select" name="choosen_link" id="choosen_link">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	
		<input type="hidden" name="locale" id="locale"			value="<%=locale%>">
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = <%=end%> ;
	start=<%=start%>;
	if(parseInt('<%=maxRec%>')>0)
	activeLink();
	</script>

		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

