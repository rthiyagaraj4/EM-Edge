<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="alAutoclavingList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<script language="JavaScript" src="../../eSS/js/Autoclaving.js"></script>	
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>

<body onMouseDown='CodeArrest();'>
<%
	String disabled				=	"";
	String chk_uncheck			=	"N";
	String chk					=	"";
	String bean_id				=	"autoclavingListBean";
	String bean_name			=	"eSS.AutoclavingListBean";
	
	AutoclavingListBean bean	=	(AutoclavingListBean) getBeanObject(bean_id, bean_name , request ) ;  
	//AutoclavingBean beanObj		=	(AutoclavingBean) getBeanObject("autoclavingBean", "eSS.AutoclavingBean" , request ) ;  
	
	// from here

	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));

	String autoclave_wash_unit_code =	request.getParameter("autoclave_wash_unit_code")==null?"":request.getParameter("autoclave_wash_unit_code");
	String load_no					=	request.getParameter("load_no")==null?"":request.getParameter("load_no");
	String store_code				=	request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String sterile_type				=	request.getParameter("sterile_type")==null?"":request.getParameter("sterile_type");
	String selectAll				=	request.getParameter("selectAll")==null?"":request.getParameter("selectAll");
	System.out.println("selectAll==========>"+selectAll);
	bean.clear();
	
	//from
	int maxRec						=	0; 
	//String  str_select				=	"";
	String mode						=	"";
	String dispMode					=	request.getParameter( "dispMode" ) ;
	String initString				=	"";
	if(dispMode==null) dispMode		=	"";
	int start						=	0;
	int end							=	0;
	int displaySize					=	0;
	int count						=	0;
	String classvalue				=	"";
	String from						=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to						=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	count							=	start;
	HashMap dataList				=	 null;
	//till
	mode							=	request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );

	if(request.getParameter("mode")!=null)
		bean.setMode(request.getParameter("mode"));
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));

	ArrayList alAutoclavingRecords	=	null;
	
	HashMap hmRecord				=	new HashMap();
	boolean show_expiry_date = bean.isSiteSpecific("SS","SHOW_EXPIRY_DATE");//Added for TH-KW-CRF-0030

if(from.equals(""))		
{
	
	alAutoclavingList.clear();
	if (bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY"))) //UPDATE MODE
	{
		
		try{
			ArrayList alParameters = new ArrayList(3);
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(autoclave_wash_unit_code.trim());
			alParameters.add(load_no.trim());
			
			alAutoclavingRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_SELECT_MULTIPLE"),alParameters);

			
			for (int i=0;i<alAutoclavingRecords.size();i++){
				HashMap hmAutoclavingRecord=(HashMap)alAutoclavingRecords.get(i);
				hmAutoclavingRecord.put("doc_type_desc",		(String)hmAutoclavingRecord.get("DOC_TYPE_DESCRIPTION") );
				hmAutoclavingRecord.put("group_desc",		(String)hmAutoclavingRecord.get("GROUP_DESCRIPTION") );
				hmAutoclavingRecord.put("doc_type_code",		(String)hmAutoclavingRecord.get("ROF_DOC_TYPE_CODE") );
				hmAutoclavingRecord.put("doc_no",	(String)hmAutoclavingRecord.get("ROF_DOC_NO") );
				hmAutoclavingRecord.put("group_code",		(String)hmAutoclavingRecord.get("GROUP_CODE")  );
				hmAutoclavingRecord.put("tray_no",		(String)hmAutoclavingRecord.get("TRAY_NO")  );
				hmAutoclavingRecord.put("description",		(String)hmAutoclavingRecord.get("DESCRIPTION"));
                hmAutoclavingRecord.put("expiry_date",		(String)hmAutoclavingRecord.get("EXPIRY_DATE"));//Added for TH-KW-CRF-0030
				hmAutoclavingRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmAutoclavingRecord.put("SELECTED",		"N"   );

				hmAutoclavingRecord.remove("DOC_TYPE_CODE") ;
				hmAutoclavingRecord.remove("DOC_NO") ;
				hmAutoclavingRecord.remove("GROUP_CODE") ;
				hmAutoclavingRecord.remove("TRAY_NO")  ;
				hmAutoclavingRecord.remove("DESCRIPTION");
				hmAutoclavingRecord.remove("REMARKS");
			
				alAutoclavingList.add(hmAutoclavingRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
	else
//INSERT MODE 
	{
	   try{

			ArrayList alParameters = new ArrayList(3);
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(store_code);
			alParameters.add(sterile_type);
			System.err.println("store_code@@=="+store_code+"sterile_type=="+sterile_type+"SQL_SS_AUTOCLAVE_ROF_DTLS=="+bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_ROF_DTLS"));
			alAutoclavingRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_ROF_DTLS"),alParameters);
			System.err.println("alAutoclavingRecords=="+alAutoclavingRecords);
			
		if(alAutoclavingRecords.size()!=0)
			{
			for (int i=0;i<alAutoclavingRecords.size();i++){
				HashMap hmAutoclavingRecord=(HashMap)alAutoclavingRecords.get(i);
				hmAutoclavingRecord.put("doc_type_desc",		(String)hmAutoclavingRecord.get("DOC_TYPE_DESCRIPTION") );
				hmAutoclavingRecord.put("group_desc",		(String)hmAutoclavingRecord.get("GROUP_DESCRIPTION") );
				hmAutoclavingRecord.put("doc_type_code",		(String)hmAutoclavingRecord.get("DOC_TYPE_CODE") );
				hmAutoclavingRecord.put("doc_no",	(String)hmAutoclavingRecord.get("DOC_NO") );
				hmAutoclavingRecord.put("group_code",		(String)hmAutoclavingRecord.get("GROUP_CODE")  );
				hmAutoclavingRecord.put("tray_no",		(String)hmAutoclavingRecord.get("TRAY_NO")  );
				System.err.println("expiry_date=="+(String)hmAutoclavingRecord.get("EXPIRY_DATE"));
				hmAutoclavingRecord.put("expiry_date",		bean.getExpiryDate((String)hmAutoclavingRecord.get("GROUP_CODE")));//Added for TH-KW-CRF-0030
				hmAutoclavingRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmAutoclavingRecord.put("SELECTED",		"N"  );

				hmAutoclavingRecord.remove("DOC_TYPE_CODE") ;
				hmAutoclavingRecord.remove("DOC_NO") ;
				hmAutoclavingRecord.remove("GROUP_CODE") ;
				hmAutoclavingRecord.remove("TRAY_NO")  ;
				hmAutoclavingRecord.remove("REMARKS");
			
				alAutoclavingList.add(hmAutoclavingRecord);
			
			}
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}

	if(bean.getMode().equals(bean.getCommonRepositoryValue("MODE_MODIFY"))) //UPDATE MODE
	{
		disabled=bean.isEntryCompleted(autoclave_wash_unit_code,load_no)?"disabled":disabled;
	}
}
displaySize = Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));

	//till here
	if(alAutoclavingList.size()!=0)
	{
		hmRecord	=(HashMap)	alAutoclavingList.get(count);
		bean.initialize(hmRecord);
		
		maxRec=alAutoclavingList.size();
	
	

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
	<form name='formAutoclavingList' id='formAutoclavingList' >
		<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
		<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th width='20%'><fmt:message key="eSS.ROFDocType.label" bundle="${ss_labels}"/></th>
			<th width='20%'><fmt:message key="eSS.ROFDocNo.label" bundle="${ss_labels}"/></th>
			<th width='20%'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
<%           if(show_expiry_date){
%>
			<th width='20%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th><!-- Added for TH-KW-CRF-0030 -->
<%}%>
			<%if (mode.equals("1")) {%>
			<th width='20%'><fmt:message key="eSS.Autoclave.label" bundle="${ss_labels}"/><input type=checkbox name='selectAll' id='selectAll' onClick="changeStatusCheckBox(this);" <%=disabled%>  value="<%=selectAll%>" <%=selectAll.equals("Y")?"checked":"" %>></th>
			<%}else{%>
			<th width='20%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/><input type=checkbox name='selectAll' id='selectAll' onClick="changeStatusCheckBox(this);" <%=disabled%>  ></th>
			<%}%>
<%
	
	count	= start;
	int chkCount = 0;
	initString = "";
	while ( count < maxRec && count < end)
	{
			dataList = (HashMap)alAutoclavingList.get(count);
			System.err.println("dataList@@@==="+dataList);
			
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			chk_uncheck=(String)dataList.get("SELECTED");
		
			if(chk_uncheck.equals("Y"))				chk="checked";
			else if(chk_uncheck.equals("N"))		chk="";
			

%>
	<tr>
		<td width='20%' class="<%=classvalue%>" nowrap><%=(String)dataList.get("doc_type_desc")%></a></td>
		<td width='20%' class="<%=classvalue%>"><%=(String)dataList.get("doc_no")%></td>
		<td width='20%'  class="<%=classvalue%>" ><%=(String)dataList.get("group_desc")%></td>
		<td width='20%'  class="<%=classvalue%>" ><%=(String)dataList.get("tray_no")%>
		<input type="hidden" name="tray_no<%=count%>" id="tray_no<%=count%>" 		value="<%=(String)dataList.get("tray_no")%>">
		</td>
<%      if(show_expiry_date){
%>
		<td width='20%'  class="<%=classvalue%>" ><%=bean.getExpiryDate((String)dataList.get("group_code"))%></td><!-- Added for TH-KW-CRF-0030 -->
<%}%>
		<td width='20%'  class="<%=classvalue%>" ><input type='checkbox' name="checkbox<%=count%>" id="checkbox<%=count%>" value="<%=chk_uncheck%>"  onclick='assignValue(this); alterBean(this,"<%=count%>","<%=(String)dataList.get("tray_no")%>")' <%=chk_uncheck.equals("Y")?"checked":"" %> <%=chk%>    <%=disabled%>  ></td>
	</tr>
	<%
		count++;
		chkCount++;
	}
	
}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA" ,"Coomon"));</script> 
		
	<%
	
	}
%>

</table>
		<input type="hidden" name="start" id="start"		value="<%=start%>">
		<input type="hidden" name="end" id="end"			value="<%=end%>">
		<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
		<input type="hidden" name="totalRecords" id="totalRecords" value='<%=alAutoclavingList.size()%>'>
		<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
		<input type="hidden" value="select"		name="choosen_link" id="choosen_link">
		<input type="hidden" name="count" id="count"		value="">
		<input type="hidden" name="checked_yn" id="checked_yn"  value="N"	>
<%
if(dispMode.equals("")){
%>
	<script>
		maxRec = <%=maxRec%> ;
		if(maxRec>0)
		activeLink();
	</script>
<%
}
	else{
	%>
	<script>
		maxRec = <%=maxRec%> ;
		if(maxRec>0)
		activeLink();
	</script>
<%
	}
%>
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


