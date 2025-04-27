<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*,eOH.* ,eOH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eOR.ProcedureLink.label" bundle="${or_labels}"/>
</title>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=result_entry_proclink>

<%
	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	//String task_type=request.getParameter("task_type");
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String proc_link_resulting_option_result = request.getParameter("proc_link_resulting_option_result")==null?"":request.getParameter("proc_link_resulting_option_result");
	String order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
	String chk_val = request.getParameter("chk_val")==null?"": request.getParameter("chk_val");
	String proc_scheme_code = request.getParameter("proc_scheme_code")==null?"": request.getParameter("proc_scheme_code");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String win_close = request.getParameter("win_close")==null?"":request.getParameter("win_close");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,bean_name ,request) ;
	bean.setLanguageId(localeName);
	//out.println("<script>alert('"+request.getQueryString()+","+request.getParameter("func_type")+","+bean.getFunc_type()+"')</script>");
	
	//allValues = bean.getProcedureDetails("RDOP00000005686");
	int count=bean.getRecordedProcedureCount(orderId);
	allValues = bean.getProcedureDetails(orderId,count);
	//String[] procScheme=bean.getProcScheme();

	String temp_chk="";String tmp_dsr_id="";
	//chk_val="N~Y~Y~";//chk_val="";
	int j=0,k=0;
	
	java.util.StringTokenizer stoken = new StringTokenizer(chk_val,"~");
%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center class="grid">
<tr>
					<td class=columnheader width=''><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
					<td class=columnheader width=''><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
					<td class=columnheader width=''><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class=columnheader width=''></td>
				</tr>
<%
	String[] record = null;
	String classValue=""; String tmp_ord_cd="",disabled="";
	String checked="";boolean chk_flag= false;
	for(int i=0; i<allValues.size(); i++){
	//for(int i=0; i<2; i++){
		record = (String [])allValues.get(i);
		
		
		/*if(i % 2 == 0){
			classValue = "QRYEVEN";
		}else{
			classValue = "QRYODD";
		}*/
		classValue="gridData";
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";
		if(record[3] == null) record[3] = "";
		if(record[4] == null) record[4] = "";
		if(record[5] == null) record[5] = "";
		if(record[6] == null) record[6] = "";
		if(record[7] == null) record[7] = "";
		if(record[8] == null) record[8] = "";
		if(record[9] == null) record[9] = "";
		if(record[10] == null) record[10] = "";
		if(record[11] == null) record[11] = "";
		if(record[12] == null) record[12] = "";
		if(record[13] == null) record[13] = "";
		if(record[14] == null) record[14] = "";
		if(called_from.equals("Coding") && record[14].equalsIgnoreCase("Y"))
			disabled="disabled";
		else
			disabled="";

		if(stoken.hasMoreTokens()) {
			temp_chk = stoken.nextToken();
			//out.println("<script>alert('---"+temp_chk+"--"+i+"-')</script>");
		}
		if(record[9].equals("Y")&& temp_chk.equals(""))
			checked ="checked";
		else if((!temp_chk.equals("")) && temp_chk.equals("Y"))
			checked ="checked";
		else
			checked ="";
		//out.println("<script>alert('---"+checked+"--"+i+"-')</script>");
		/*
        	
        	while (stoken.hasMoreTokens()) {
        		if ((stoken.nextToken()).equals(record[1])) {
        			showedGroup = true;
        			break;
        		}
        	}
        	strPanels = strPanels + "," + record[1];*/
        %>
		
			<%if(!tmp_ord_cd.equals(record[5]) && !record[3].equals(record[4]) ){%>
				<tr>
					<td colspan='4' width='' class='CAHIGHERLEVELCOLOR'><font size=1><%=record[3]%><%//=record[4]%></font><%if(record[6].equals("R")&&record[7].equals("M")){%>
				<img src="../../eCommon/images/mandatory.gif" align='ABSMIDDLE'></img>	
			<%}%></td>

				</tr>
				
			<%	tmp_ord_cd = record[5];chk_flag = true;
			}%>
			<!-- Result -->
			
			<%
				if(!tmp_dsr_id.equals(record[0])){
				//out.println("<script>alert('chk_flag===="+chk_flag+"===');</script>");%>
				<tr>
					<!-- <td colspan='' width='' class='CAHIGHERLEVELCOLOR'>&nbsp;</td> -->
					<td colspan='4' width='' class='CAHIGHERLEVELCOLOR'>
						<%if(chk_flag){
						//out.println("\t");%>
					  <%}%><font size=1><%=record[4]%></font><%if(record[6].equals("R") && !chk_flag && record[7].equals("M")){%>
				<img src="../../eCommon/images/mandatory.gif" align='ABSMIDDLE'></img>
						
			<%	
				}%></td>

				</TR>
				<!-- <tr>
					<th width=''>Term Set</th>
					<th width=''>Term Code</th>
					<th width=''>Description</th>
					<th width=''>&nbsp;</th>
				</tr> -->
			<%	tmp_dsr_id = record[0];if(k!=0){
				//out.println("<script>alert('=j=="+j+"==k=="+k+"===');</script>");
				%>
					 <input type=hidden name='grp_cnt<%=j%>' id='grp_cnt<%=j%>' value='<%=k%>'>			
			<%	j++;}k=0;
			}%>
			<tr>

			<td width='40%' class='<%=classValue%>'><font size=1><%=record[13]%></font></td>
			<td width='16%' class='<%=classValue%>'><font size=1><%=record[10]%></font></td>
			<td width='40%' id='desc' class='<%=classValue%>'><font size=1><%=record[8]%></font></td>

			<td width='4%' class='<%=classValue%>'>
				<input type="checkbox" name="proc_chk<%=j%><%=k%>" id="proc_chk<%=j%><%=k%>" <%=checked%>  <%//=eHISFormatter.ChkBoxChecked("Y",record[9])%> <%=disabled%>>&nbsp;
			
			</td>

		<input type='hidden' name='proc_link_resulting_option<%=j%><%=k%>' id='proc_link_resulting_option<%=j%><%=k%>' value='<%=record[7]%>'>
		<input type='hidden' name='default_yn<%=j%><%=k%>' id='default_yn<%=j%><%=k%>' value='<%=record[7]%>'>
		<input type='hidden' name='proc_code<%=j%><%=k%>' id='proc_code<%=j%><%=k%>' value='<%=record[10]%>'>
		<input type='hidden' name='proc_scheme<%=j%><%=k%>' id='proc_scheme<%=j%><%=k%>' value='<%=record[12]%>'>
		<input type='hidden' name='line_srl_num<%=j%><%=k%>' id='line_srl_num<%=j%><%=k%>' value='<%=record[1]%>'>
		<input type='hidden' name='parent_srl_no<%=j%><%=k%>' id='parent_srl_no<%=j%><%=k%>' value='<%=record[2]%>'>
		<input type='hidden' name='long_desc<%=j%><%=k%>' id='long_desc<%=j%><%=k%>' value='<%=record[11]%>'>
 			
		</tr>
<%	k++;}%>
 <input type=hidden name='grp_cnt<%=j%>' id='grp_cnt<%=j%>' value='<%=k%>'>
<%//out.println("<script>alert('=j=="+j+"==k=="+k+"===');</script>");%>
<input type=hidden name='cnt' id='cnt' value='<%=j%>'>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>	<!-- data required for bean -->
<input type=hidden name='function_id' id='function_id' value='<%//=function_id%>'>	<!-- data required for bean -->
<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>		<!-- data required for bean -->
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>		<!-- data required for bean -->
<input type=hidden name='totalRecs' id='totalRecs' value='<%=allValues.size()%>'>		<!-- data required for bean -->
<input type=hidden name='proc_link_resulting_option_result' id='proc_link_resulting_option_result' value='<%=proc_link_resulting_option_result%>'>		
<input type=hidden name='chk_val' id='chk_val' value='<%=chk_val%>'>
<input type=hidden name='proc_scheme_code' id='proc_scheme_code' value='<%=proc_scheme_code%>'>
<input type=hidden name='order_type_code' id='order_type_code' value='<%=order_type_code%>'>
<input type=hidden name='order_id' id='order_id' value='<%=orderId%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type=hidden name='patient_class' id='patient_class' value='<%=patient_class%>'>

</table>
<%
	if(allValues.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html';window.close();</script>");
		
	}else if(allValues.size() == 1)
	{
		out.println("<script>if(eval('document.result_entry_proclink.proc_chk00').checked && eval('document.result_entry_proclink.proc_chk00').disabled){parent.proc_btn.document.result_entry_proc_btn.record.style.visibility='hidden';}</script>");
		
	}
	
	if(win_close.equals("Y")){
		out.println("<script>callRetainStatus('')</script>");
	}
	if(called_from.equals("Coding")){
		out.println("<script>callDisable()</script>");
	}
%>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

