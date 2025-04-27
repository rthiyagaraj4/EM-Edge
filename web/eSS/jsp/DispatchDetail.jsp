<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page   import=" eSS.*,eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha">
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String locale			= (String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/Dispatch.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		

	</head>
	<body onMouseDown='CodeArrest();'>
	<form name="formWashingDetail" id="formWashingDetail">
<%
	

	String mode					=		"";
	ArrayList result			=		new ArrayList();
	String bean_id				=	"DispatchBean" ;
	String bean_name			=	"eSS.DispatchBean";	
	String rof_doc_type_code	=		request.getParameter( "rof_doc_type_code" ) ==null?"":request.getParameter( "rof_doc_type_code" );
	String rof_doc_no			=		request.getParameter( "rof_doc_no" ) ==null?"":request.getParameter( "rof_doc_no" );
	String doc_date				=		request.getParameter( "doc_date" ) ==null?"":request.getParameter( "doc_date" );
	 if(!(locale.equals("en")))
		{
				doc_date			= com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
		}
	String store_code			=		request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );
	String location				=		request.getParameter( "location" ) ==null?"":request.getParameter( "location" );
	String doc_ref				=		request.getParameter( "doc_ref" ) ==null?"":request.getParameter( "doc_ref" );
	
	
	DispatchBean bean			=		(DispatchBean)getBeanObject( bean_id, bean_name,request  );  
	
	String classvalue			=		"";

	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	if(!searched){
		bean.clear() ;
		bean.initialize();
	}
		String checked					=		"";  
		int checked_ind;
try{
	/* Mandatory checks start */
	mode						=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	bean.setMode( mode ) ;
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();

			HashMap sqlMap				=		new HashMap();
			sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DISPATCH_SEARCH_QUERY"));

			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();


			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("DOC_NO");
			displayFields.add("DOCDATE");
			displayFields.add("STORE_CODE");
			displayFields.add("SERVICE_LOCATION_CODE");
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("SERVICE_LOCATION_DESC");
			displayFields.add("STORE_DESC");
			
			ArrayList chkFields			=		new ArrayList();

			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add(rof_doc_type_code);
			chkFields.add(rof_doc_no);
			chkFields.add(doc_date);
			chkFields.add(location);
			chkFields.add(store_code);
			chkFields.add(doc_ref);
			chkFields.add(bean.getLoginById()); 
		


	// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			 result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0,i = 0;

			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){

%>
	<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%=result.get(1)%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
		   		<tr>
				<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="eSS.SterReqDocType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.SterReqDocNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.Dispatch.label" bundle="${ss_labels}"/><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(formWashingDetail);" ></th></tr>
		<%
			ArrayList records=new ArrayList();
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;

				
		%>

		<tr id="tr_<%=i%>">
		<%
				records				=		(ArrayList) result.get(recCount);
								
				checked_ind			=		 Arrchkitem.indexOf(records.get(0)+"-"+records.get(1));
				checked				=		(checked_ind != -1 ? "checked":"");
				classvalue			=		(checked == ""?classvalue:"DATACHANGE");
								

		%>

		<td class="<%=classvalue%>" onClick="modifymore('<%=i%>','<%=(String)records.get(0)%>','<%=(String)records.get(1)%>')" onmouseover="changeCursor(this);" nowrap>	<font class='HYPERLINK'><%=(String)records.get(5)%>	</font>	</td>
		<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td><td class="<%=classvalue%>" onclick="disableClick(event);" ><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td><td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(6)%>	</td><td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(7)%></td>

		<td class="<%=classvalue%>" align='center'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="updateSelection()" value="<%=records.get(0)%>-<%=records.get(1)%>" <%=checked%>></td>
		</tr>


		<%
			}
		%>
		</table>

		<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="total_check_boxes" id="total_check_boxes" value="<%=i%>">
		
		<input type="hidden" name="checkedIndices" id="checkedIndices" >
		<input type="hidden" name="rof_doc_type_code" id="rof_doc_type_code" value="<%=records.get(0)%>">
		<input type="hidden" name="rof_doc_no" id="rof_doc_no" value="<%=records.get(1)%>">

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
		out.println(CommonBean.setForm (request ,"../../eSS/jsp/DispatchDetail.jsp", searched));
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>
<script>
updateSelection();
</script>
  

