<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 		10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
Connection conlCon		= null;
PreparedStatement pstmt = null;
ResultSet rslRst		= null;
%>
<html>
	<head>
		<title><fmt:message key="eCA.ApplicationTask.label" bundle="${ca_labels}"/></title>
		<%request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		%>
		<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
	
	
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/ApplicationTask.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onscroll='scrollTitle()'>
		<form name='ppln_task_form' id='ppln_task_form' method='post' target="messageFrame">
		<%
		int ilRow = 0;
		int count=0;
		int i=0;
		int rsize=0; //to get the number of records retrieved

		String slAppl_task_id			= "";
		String slAppl_task_desc			= "";
		String slDflt_privilege_status	= "";
		String slClassValue = "gridData";
		String slSql ="";

		String taskSearch="";
		String taskApplicable="";
		String taskText = "";
		String selectoption1 = "";
		String selectoption2 = "";
		String selectoption3 = "";
		String access_rigths_appl = "";
		//String task_name=""; //commented for checkstyle
		//String access_applicable = "";//commented for checkstyle
		//String access_for_all = ""; //commented for checkstyle

		try{
			slSql = " SELECT b.short_desc headermenu , appl_task_id, appl_task_desc, dflt_privilege_status,ACCESS_RIGTHS_APPL FROM ca_appl_task a, ca_option b where a.SPLTY_SPEC_YN='N' and  b.option_id(+) = a.option_id  and upper(appl_task_desc) like  upper(?) and upper(dflt_privilege_status) like upper(?) order by appl_task_desc,b.order_seq_no";
			
			taskSearch		= request.getParameter("search_val") == null ? "" : request.getParameter("search_val");
			taskApplicable	= request.getParameter("appl_val")==null ?"":request.getParameter("appl_val");
			taskText		= request.getParameter("text_val") == null ? "" : request.getParameter("text_val");  	

			conlCon = ConnectionManager.getConnection(request);
			pstmt = conlCon.prepareStatement(slSql);
			
		%>
		<div id='divApplTitle' style="display: flex; justify-content: center;">
			<!-- <div id='divApplTitle' style='position:relative'>  -->
			<table class='grid' width='80%'  align=center>
				<tr>
					<th width='60%' ><fmt:message key="Common.Tasks.label" bundle="${common_labels}"/></th>
					<th width ='15%'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> <input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);"></th>
					<th width='25%' ><fmt:message key="eCA.AccessRestriction.label" bundle="${ca_labels}"/></th>
				</tr>
			</table>
			</div> 
			<div  style="display: flex; justify-content: center;">
			<table class='grid' width='80%'  align=center>
			<%
			if(taskSearch.equals("S")) 
				taskText = taskText  + "%";
			else if(taskSearch.equals("E")) 
				taskText = "%" + taskText;
			else 
				taskText = "%" + taskText + "%" ;
			
			pstmt.setString(1,taskText);
			pstmt.setString(2,taskApplicable+"%");
			rslRst = pstmt.executeQuery();
	
			while(rslRst.next())
			{
				slAppl_task_id	= rslRst.getString("appl_task_id");
				if (slAppl_task_id==null) { slAppl_task_id=""; }
				slAppl_task_desc		= rslRst.getString("appl_task_desc");
				if (slAppl_task_desc==null) { slAppl_task_desc=""; }
				slDflt_privilege_status = rslRst.getString("dflt_privilege_status");
				if (slDflt_privilege_status==null) { slDflt_privilege_status=""; }

				if (slDflt_privilege_status == null) slDflt_privilege_status="";
				/*Below code  added by Channaveer B for crf MO-CRF-33 */
				access_rigths_appl = rslRst.getString("ACCESS_RIGTHS_APPL");
				if (access_rigths_appl == null) access_rigths_appl="";
				//IN061903 starts
				//if(slAppl_task_desc.equals("Amend Order") || slAppl_task_desc.equals("Cancel Order") || slAppl_task_desc.equals("Discontinue Order") || slAppl_task_desc.equals("Hold Order") ){
				if(slAppl_task_desc.equals("Amend Order") || slAppl_task_desc.equals("Cancel Order") || slAppl_task_desc.equals("Discontinue Order") || slAppl_task_desc.equals("Hold Order")|| slAppl_task_desc.equals("Not Done") ){
				//IN061903 ends
				if(access_rigths_appl.equals("MO"))
				{
				   selectoption1="";
                   selectoption2="selected";
                   selectoption3="";
				}else if(access_rigths_appl.equals("MS"))
				{
                 selectoption1="";
                 selectoption2="";
                 selectoption3="selected";
				}else
				{
                 selectoption1="selected";
                 selectoption2="";
                 selectoption3="";
				}
				}
				
				/*ENDS HERE*/

				/*if(ilRow % 2 == 0)
					slClassValue = "QRYEVEN";
				else
					slClassValue = "QRYODD";*/
				%>
				<tr>
					<%if(!slAppl_task_id.equals("")) { %>
						<td  class = '<%= slClassValue %>' width='60%'><input type="hidden"  name="task_name<%=count%>" id="task_name<%=count%>" value="<%=slAppl_task_id %>"><%=slAppl_task_desc%></td>
						<td class = '<%= slClassValue %>' width='15%'>
						<input type=checkbox onclick = 'chkunchk(this,"<%=count%>")'  name='task_status<%=count%>' value='<%=slAppl_task_id%>' 
						<% if(slDflt_privilege_status.equals("A")){ %>checked <% i++;} %> >
					</td>
					<!-- Below code is added by Channaveer B for crf MO-CRF-33-->
					<%//IN061903 start
					//if(slAppl_task_id.equals("AMEND_ORDER") || slAppl_task_id.equals("CANCEL_ORDER") || slAppl_task_id.equals("DISCONTINUE") || slAppl_task_id.equals("HOLD")){
					if(slAppl_task_id.equals("AMEND_ORDER") || slAppl_task_id.equals("CANCEL_ORDER") || slAppl_task_id.equals("DISCONTINUE") || slAppl_task_id.equals("HOLD") || slAppl_task_id.equals("NOTDONE")){	
					//IN061903 ends
						%>
					<td class = '<%=slClassValue%>' width='25%'>
					<select name='app_access_rights<%=count%>' id='app_access_rights<%=count%>' style="width:150px" <%if(!slDflt_privilege_status.equals("A")){%>disabled<%}%>>
					<%	 if(slDflt_privilege_status.equals("A")){ %>
						<option value='ALL' <%=selectoption1%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='MO' <%=selectoption2%>><fmt:message key="eCA.SelfOrder.label" bundle="${ca_labels}"/></option>
						<option value='MS' <%=selectoption3%>><fmt:message key="eCA.SelfSpltyOrders.label" bundle="${ca_labels}"/></option>
					<%}else{%>
						<option  value='' ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					<%}%>
					</select>					
					</td>
						<%}else{%>
						<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
						<!--ENDS HERE -->
				<%}
							ilRow = ilRow + 1;		
							}%>
				</tr>
			<%
				rsize++;
				count++;
			}
			if(rsize==0)
			{%>
				<script>
					var errorMsg =  getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
					parent.dispFrame.location.href='../../eCommon/html/blank.html';
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
				</script>
				<%
			}
			else{
				if(i==rsize)
				{
					out.println("<script>document.ppln_task_form.ctrlChkBox.checked=true;</script>");
				}
			}%>
			</table>
			</div>
		<input type=hidden name='count' id='count' value='<%=count%>'>
		<input type=hidden name='taskText' id='taskText' value='<%=taskText%>'>
		<input type=hidden name='rsize' id='rsize' value='<%=rsize%>'>
		<input type=hidden name='taskApplicable' id='taskApplicable' value='<%=taskApplicable%>'>
		<input type=hidden name='selectoption1' id='selectoption1' value=''>
		<input type=hidden name='selectoption2' id='selectoption2' value=''>
		<input type=hidden name='selectoption3' id='selectoption3' value=''>
		
		<%
			if (rslRst != null) rslRst.close();
			if (pstmt != null) pstmt.close();
		}catch(Exception e)
			{
			//out.println("Exception in try of addApplicationTask.jsp : "+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}finally 
		{
			if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
		}
		%>
		</form>	
	</body>
</html>

