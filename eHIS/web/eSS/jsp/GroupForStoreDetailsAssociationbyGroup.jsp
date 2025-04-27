<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%!
	int maxRec=0; 
%>
<html>
<head>
	<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
	<script language="JavaScript" src="../js/GroupForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();">
<form name="groupforstore_dtls" id="groupforstore_dtls">
<%
	//set mode always as INSERT.
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	if(dispMode==null) dispMode="";
	boolean database_rec=false;
	String initString	="";
	String classvalue	= "";
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;
	HashMap dataList = null;
		GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id,bean_name, request ) ;

	try{
		
		/* Initialize Function specific start */
		bean.setMode( mode ) ;
		bean.setLanguageId(locale);
		ArrayList result=null;
		result=bean.getDBResult();
		result=bean.sortList(result,"SHORT_DESC");
		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		if ( from == null )
			start = 0 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null ){
			end = displaySize ;
		}
		else{
		end = Integer.parseInt( to ) ;	
		}
	%>
	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrevbyGroup('association');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNextbyGroup('association');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>
	<%
	if( result.size()>0  ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<!--<th><fmt:message key="eSS.MinQty.label" bundle="${ss_labels}"/></th>-->
		<th><fmt:message key="eSS.ReorderLevel.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ReorderQuantity.label" bundle="${ss_labels}"/></th>
	<%
		count=start;
		int chkCount=0;
		initString="";
		while ( count < maxRec && count < end)
		{
			
		dataList = (HashMap)result.get(count);
		if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	if(chkCount==0){
//	initString=((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC");
	//initString=((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC")+"|"+(String)dataList.get("MIN_QTY");
	initString=((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC")+"|"+(String)dataList.get("MIN_QTY")+"|"+(String)dataList.get("REORDER_QTY");
	}
	else{
//	initString=initString+"~"+((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC");
	//initString=initString+"~"+((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC")+"|"+(String)dataList.get("MIN_QTY");
	initString=initString+"~"+((String)dataList.get("EFF_STATUS"))+"|"+((String)dataList.get("OPER_MODE"))+"|"+(String)dataList.get("STORE_CODE")+"|"+(String)dataList.get("SHORT_DESC")+"|"+(String)dataList.get("MIN_QTY")+"|"+(String)dataList.get("REORDER_QTY");
	}

	String disp_effstatus="";
	String associate_yn="";
	String disable_eff ="";
	String disable_proces ="";
	
	String min_qty =(String)dataList.get("MIN_QTY")==null?"":(String)dataList.get("MIN_QTY");
	String reorder_qty =(String)dataList.get("REORDER_QTY")==null?"":(String)dataList.get("REORDER_QTY");

	if( ((String)dataList.get("SOURCE")).equals("FB") ){
		database_rec=false;
		disable_proces="";		
		if(!((String)dataList.get("OPER_MODE")).equals("DN")){
			associate_yn="checked";
		}
		else{
			associate_yn="";
		}

		if(((String)dataList.get("EFF_STATUS")).equals("E")){
			disp_effstatus="checked";	
		}
		else{
			disp_effstatus="";
		}
		
	}
	else{
		database_rec=true;
		associate_yn="checked";
		disable_proces="disabled";

		if(((String)dataList.get("EFF_STATUS")).equals("E")){
			disp_effstatus="checked";	
			disable_eff="";
		}
		else{
			disp_effstatus="";
			disable_eff="";
		}
	}
	
%>
		<tr>
			<td class="<%=classvalue%>" >
	<% 
			if(database_rec){
	%>
			<font color=#FF5400 style="font-weight:500"><%=(String)dataList.get("SHORT_DESC")%></font>
	<%
		}
		else{
	%>
			<%=(String)dataList.get("SHORT_DESC")%>
	<%
		}
	%>
	
	
			
			<input type="hidden" name="short_desc<%=count%>" id="short_desc<%=count%>" value="<%= (String)dataList.get("SHORT_DESC") %>"></input><input type="hidden" name="store_code<%=count%>" id="store_code<%=count%>" value="<%= (String)dataList.get("STORE_CODE") %>"></input></td>
			

		<% if(database_rec){ %>	
		
			<td class="<%=classvalue%>" align="center" width="15%"><input type="checkbox" <%=disp_effstatus%>  name="eff_status<%=count%>" value="<%=(String)dataList.get("EFF_STATUS")%>" onclick="assignEffStatusAssociation(this); enableqty(this,'<%=count%>');" <%=disable_eff%> ></input></td>
		<% 	}else{ 	%>	
			<td class="<%=classvalue%>" align="center" width="15%"><input type="checkbox" <%=disp_effstatus%>  name="eff_status<%=count%>" value="<%=(String)dataList.get("EFF_STATUS")%>" onclick="assignEffStatusAssociation(this);" <%=disable_eff%> disabled ></input></td>
		
		<% 	} %>	
		
			<td class="<%=classvalue%>" align="center" width="15%">
		
		

		
			<% 
			
		if(database_rec){
	%>	
			<input type="hidden"  align="center" name="oper_mode<%=count%>" id="oper_mode<%=count%>" value="<%=(String)dataList.get("OPER_MODE")%>" ></input>
			<input type="hidden"  align="center" name="min_qty_chk<%=count%>" id="min_qty_chk<%=count%>" value="<%=(String)dataList.get("MIN_QTY_CHK")%>" ></input>
	<%
		}else{
	%>
			<input type="checkbox"  align="center" name="oper_mode<%=count%>" id="oper_mode<%=count%>" value="<%=(String)dataList.get("OPER_MODE")%>" onclick="assignValueAssociation(this);"  <%=associate_yn%> <%=disable_proces%> disabled></input>
	<%
		}
	%>	
			
			</td>
			
		<% if(database_rec && disp_effstatus.equals("checked")){ %>	
		
			<td class="<%=classvalue%>" align="center" width="10%"><div style="float: right;text-align: right;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="min_qty<%=count%>" id="min_qty<%=count%>" value="<%=min_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" ></input></div></td>
		<% 	} else {  %>	
			
			<td class="<%=classvalue%>" align="center" width="10%"><div style="float: right;text-align: right;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="min_qty<%=count%>" id="min_qty<%=count%>" value="<%=min_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" disabled></input></div></td>
		
		<% 	} %>	
		
		<% if(database_rec && disp_effstatus.equals("checked")){ %>	
		
			<td class="<%=classvalue%>" align="center" width="10%"><div style="float: right;text-align: right;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="reorder_qty<%=count%>" id="reorder_qty<%=count%>" value="<%=reorder_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" ></input></div></td>
		<% 	} else {  %>	
			
			<td class="<%=classvalue%>" align="center" width="10%"><div style="float: right;text-align: right;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="reorder_qty<%=count%>" id="reorder_qty<%=count%>" value="<%=reorder_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" disabled></input></div></td>
		
		<% 	} %>	
			
		</tr>
	
	<%
		count++;
		chkCount++;
		
	}
	}else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
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
<input type="hidden" name="initString" id="initString" value="<%=java.net.URLEncoder.encode(initString)%>">
<%
if(dispMode.equals("")){
%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = displaySize ;
	activeLink();
	</script>
<%
}
	else{
	%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = <%=end%> ;
	start=<%=start%>;
	activeLink();
	</script>
<%
	}
%>
<input type="hidden" value="<%=end%>" name="end">
<input type="hidden" value="<%=start%>" name="start">
<input type="hidden" value="<%=count%>" name="count">
<input type="hidden" value="association" name="choosen_link" id="choosen_link">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="location_ref" id="location_ref" value="bygroup">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>
<%
	putObjectInBean( bean_id,bean,request);
%>

