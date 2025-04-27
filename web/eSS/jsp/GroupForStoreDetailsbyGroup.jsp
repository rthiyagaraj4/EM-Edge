<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%-- Mandatory declarations end --%>
<%! 
	int maxRec=0; 
%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
     <%
	 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/SsMessages.js"></script> -->
	<script language="JavaScript" src="../js/GroupForStoreByGroup.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>

</script>
</head>
<body onMouseDown="CodeArrest();">
<form name="groupforstore_dtls" id="groupforstore_dtls">
<%
	
	//set mode always as INSERT.
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	boolean database_rec=false;
	String initString	= "";
	if(dispMode==null) dispMode="";
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;
	String classvalue	= "";
	String classvalueChange="";	
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	HashMap dataList	= null;
		GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id,bean_name,request ) ;

	try{
	
	/* Initialize Function specific start */
	bean.setLoginFacilId((String)session.getValue( "facility_id" ));
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	ArrayList result=new ArrayList();
	//Clear the Duplicates in DB
	bean.emptyDupRecords();
//	out.println("dispMode = "+dispMode);
	if(dispMode.equals("")){

		result=bean.getGroupCodeResultPagebyGroup();
		//System.out.println("getGroupCodeResultPagebyGroup"+bean.getGroupCodeResultPagebyGroup());
	}
	else{
		result=bean.getBeanRecords();
		//System.out.println("getBeanRecords"+bean.getBeanRecords());
	}
	
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
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<tr style="position: sticky; top: 0; background-color: white; z-index: 1;">
			<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<!--	<th><fmt:message key="eSS.MinQty.label" bundle="${ss_labels}"/></th>  -->
			<th><fmt:message key="eSS.ReorderLevel.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.ReorderQuantity.label" bundle="${ss_labels}"/></th>
		</tr>
<%
	
	count	= start;
	int chkCount = 0;
	initString = "";
	String str_service_code = "";
	String str_short_desc	= "";
	String str_process		= "";
	String eff_status		= "";
	String min_qty			= "";
	String readonly			= "";
	String visible			= "";
	String reorder_qty			= "";
	
	while ( count < maxRec && count < end)
	{
	dataList =(HashMap) result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		eff_status		 = (String)dataList.get("EFF_STATUS");
		str_service_code = (String)dataList.get("STORE_CODE");
		str_short_desc	 = (String)dataList.get("SHORT_DESC");
		str_process		 = (String)dataList.get("PROCESS");
		
		String disp_effstatus	= "";
		String associate_yn		= "";
		String disabled			= "";
		
		ArrayList key=bean.chkGroupCodeDBbyGroup((String)dataList.get( "STORE_CODE" ));
	
		if( key.size()==5 ){

	//	out.println("key :"+key.get(0));
	//	out.println("eff :"+key.get(1));
	//	out.println("source :"+key.get(2));
	
			min_qty = (String)key.get(3)==null?"":(String)key.get(3);
			reorder_qty = (String)key.get(4)==null?"":(String)key.get(4);
		
		if( ((String)key.get(2)).equals("FB") ){
			classvalueChange=classvalue;
			disabled = "";
			database_rec=false;
				if( !key.get(0).equals("DN") ){
					associate_yn = "checked";
					str_process  = "Y";
				}
				else{
					associate_yn = "";
				}
				if( ((String)key.get(1)).equals("E") ){
					disp_effstatus = "checked";	
				}
				else{
					disp_effstatus = "";
					eff_status = "D";
				}
		}
		else{
			database_rec=true;
			readonly = "readonly";
		//	 min_qty = (String)key.get(3)==null?"":(String)key.get(3);
		//	System.out.println("min_qty = "+min_qty);
			
			if(key.get(0).equals("U")){
			classvalueChange="DATACHANGE";
			}
			else{
			classvalueChange=classvalue;
			}
			

			disabled = "";
			associate_yn = "checked";
				if( ((String)key.get(1)).equals("E") ){
					disp_effstatus = "checked";	
				}
				else{
					disp_effstatus ="";
					eff_status     ="D";
				}
		}
	}
	else{
			classvalueChange=classvalue;
			database_rec=false;
			if(((String)dataList.get( "EFF_STATUS" )).equals( "D" )){
			disp_effstatus = "";
			}
			else{
			disp_effstatus = "checked";	
			}

			if(((String)dataList.get( "PROCESS" )).equals( "Y" )){
			associate_yn= "checked" ;
			}
			else{
			associate_yn = "";	
			}
		
	}
	/*System.out.println("associate_yn"+associate_yn);
	if(associate_yn.equals("checked")){
		visible="visible";
	}else{
		visible="";
	}*/

	if( chkCount==0 ){
//		initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc;
	//initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty;
	initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty+"|"+reorder_qty;
	
	}else{
//	initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc;
	//initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty;
	initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty+"|"+reorder_qty;
	
	}
	%>
		<tr>
			<td class="<%=classvalue%>" align="center" width="20%" >
			<%
			if(database_rec){
			%>
			<font color=#FF5400 style="font-weight:500"><%= str_short_desc %></font>
			<%
			}else{
			%>
				<%= str_short_desc %>
			<%
			}
			%>
			<input type="hidden" name="store_desc<%=count%>" id="store_desc<%=count%>" value="<%= str_short_desc%>"></input><input type="hidden" name="store_code<%=count%>" id="store_code<%=count%>" value="<%= str_service_code%>"></input></td>

			<td class="<%=classvalueChange%>" align="center" width="8%" onMouseOver="displayToolTipDataChange('<%=classvalueChange%>','Record has been Modified');" onMouseOut="disasbleToolTipDataChange('<%=classvalueChange%>');" ><input type="checkbox" <%=disp_effstatus%>  name="eff_status<%=count%>" value="<%=eff_status%>" onclick="assignEffStatus(this); enableqty('<%=count%>');" <%=disabled%> ></input></td>
			<td class="<%=classvalue%>" align="center" width="8%">
			<% 
		if(database_rec){
	%>	
		<input type="hidden"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>"></input>
	<%
		}else{
	%>
		<input type="checkbox"  align="center" name="process<%=count%>" id="process<%=count%>" value="<%=str_process%>" onclick="assignValue(this);enableqty('<%=count%>');"  <%=associate_yn%>  <%=disabled%> ></input>
	<%
		}
	%>	
			
			</td>
		
		<% if(database_rec) { 	%>
			<td class="<%=classvalue%>" align="center" width="5%"  ><input type="hidden"  name="min_qty<%=count%>" id="min_qty<%=count%>" value="<%=min_qty%>" ></input>
			<center><%=CommonBean.checkForNull(min_qty,"&nbsp;")%></center></td>
		<% } else if(associate_yn.equals("checked")){ %>
			<td class="<%=classvalue%>" align="center" width="5%"  ><div id="qty_<%=count%>" style="float: right;text-align: right;visibility:visible;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="min_qty<%=count%>" id="min_qty<%=count%>" value="<%=min_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" onclick="" ></input></td>
		<% } else { %>	
			<td class="<%=classvalue%>" align="center" width="5%"  ><div id="qty_<%=count%>" style="float: right;text-align: right;visibility:hidden;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="min_qty<%=count%>" id="min_qty<%=count%>" value="" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" onclick="" ></input></div></td>
		<% } %>
		
		<% if(database_rec) { %>
			<td class="<%=classvalue%>" align="center" width="5%"  ><input type="hidden"  name="reorder_qty<%=count%>" id="reorder_qty<%=count%>" value="<%=reorder_qty%>" ></input>
			<center><%=CommonBean.checkForNull(reorder_qty,"&nbsp;")%></center></td>
		<% } else if(associate_yn.equals("checked")){ %>
			<td class="<%=classvalue%>" align="center" width="5%"  ><div id="reorder_qty_<%=count%>" style="float: right;text-align: right;visibility:visible;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="reorder_qty<%=count%>" id="reorder_qty<%=count%>" value="<%=reorder_qty%>" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" onclick="" ></input></td>
		<% } else {  %>	
			<td class="<%=classvalue%>" align="center" width="5%"  ><div id="reorder_qty_<%=count%>" style="float: right;text-align: right;visibility:hidden;" valign="middle"><input type="text" size="25" maxlength="8" class='NUMBER' name="reorder_qty<%=count%>" id="reorder_qty<%=count%>" value="" onKeyPress="return isValidInteger();" onBlur="validate_reorder_qty('<%=count%>');" onclick="" ></input></div></td>
		<% } %>
		
		</tr>
	
	<%
		count++;
		chkCount++;
	}
	
	}else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
	
	}
	}
	catch(Exception es){
	// out.println(es);
	es.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="initString" id="initString" value="<%=java.net.URLEncoder.encode(initString)%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

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
<input type="hidden" value="select" name="choosen_link" id="choosen_link">
<input type="hidden" name="location_ref" id="location_ref" value="bygroup">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
	<tr><td width="100%" id="t"></td></tr>
</table>
</div>	 
</form>
</body>
</html>

<%
	putObjectInBean( bean_id,bean,request);
%>

