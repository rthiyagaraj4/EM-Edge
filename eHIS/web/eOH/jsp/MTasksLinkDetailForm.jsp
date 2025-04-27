<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
	<form name="MTasksLinkDetailForm" id="MTasksLinkDetailForm">
		
		<%
		   String called_from = checkForNull(request.getParameter( "called_from" )) ;
		   String from = checkForNull(request.getParameter( "from" )) ;
		   String to =   checkForNull(request.getParameter( "to" ) ) ;
		   String treatment_code=checkForNull(request.getParameter("treatment_code"));
		   String task_search_text=checkForNull(request.getParameter("task_search_text"));
		   String search_criteria=checkForNull(request.getParameter("search_criteria"));
		   String multiple_yn=checkForNull(request.getParameter("multiple_yn"));
		   String totalSelected=request.getParameter("totalSelected");
		   String count_val=checkForNull(request.getParameter("count"));
		   String select_value="Y";
		   String task_code = "";
		   String task_desc = "";
		   String seq_no = checkForNull(request.getParameter("seq_no"));
		   String mode="";
		   String sel="";
		   String select_checked="";
		  
		   int start = ( from.equals("") )?1:Integer.parseInt(from);
		   int end =  ( to.equals("") )?14:Integer.parseInt(to);
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rst=null;

		   if(search_criteria.equals("S")) 
				task_search_text = " AND TASK_DESC LIKE '"+task_search_text+"%' ";
			else if(search_criteria.equals("E")) 
				task_search_text = " AND TASK_DESC LIKE '%"+task_search_text+"' ";
			else if(search_criteria.equals("C")) 
				task_search_text = " AND TASK_DESC LIKE '%" + task_search_text + "%' " ;
		   
		   StringBuffer sql_append_str = new StringBuffer();
		   sql_append_str.append("SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.TRMT_CODE = ?");

		   if(!search_criteria.equals("")){
			sql_append_str.append(task_search_text);
		   }
			sql_append_str.append(" UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ? ) ");
		   if(!search_criteria.equals("")){
				sql_append_str.append(task_search_text);
		   }
		   sql_append_str.append(" ORDER BY 4 DESC, 3, 2 ");

		   //String strsql="SELECT A.TASK_CODE, B.TASK_DESC, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS B WHERE A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE UNION SELECT TASK_CODE, TASK_DESC, 'N' SEL FROM OH_TASKS WHERE TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 2";
		   String strsql="SELECT A.TASK_CODE, B.TASK_DESC,SEQ_NO, 'Y' SEL FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.TRMT_CODE = ?  UNION SELECT TASK_CODE, TASK_DESC,NULL SEQ_NO, 'N' SEL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? AND TASK_CODE NOT IN (SELECT TASK_CODE FROM OH_TREATMENT_TASKS WHERE TRMT_CODE = ?) ORDER BY 4 DESC, 3, 2";
			int maxRecord = 0;
			int i=1;
			try{
		   		conn  =  ConnectionManager.getConnection(request);
				//pstmt = conn.prepareStatement(sql_append_str.toString());
				pstmt = conn.prepareStatement(strsql);
				/*
				pstmt.setString(1,treatment_code);
				pstmt.setString(2,treatment_code);
				*/
				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery();
				int total=0;
				while(rst.next()){
					total++;
				}
				maxRecord = total;
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				//pstmt=conn.prepareStatement(sql_append_str.toString());
				pstmt=conn.prepareStatement(strsql);
				pstmt.setString(1,locale);
				pstmt.setString(2,treatment_code);
				pstmt.setString(3,locale);
				pstmt.setString(4,treatment_code);
				rst = pstmt.executeQuery(); 
		%>
		
		<table align='right' border=0>
			<tr>
				<td>
				<%
					if ( !(start <= 1) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+14) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				%>
				</td>
			</tr>
		</table>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
			<tr>
				<td class='columnHeader'  width="30%" align="center">
					<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOH.TaskDescription.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</td>
			</tr>
			<%
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				rst.next() ;
				String classValue= " ";
				int k=0;
				while ( rst.next() && i<=end  ){
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
					task_code = checkForNull(rst.getString(1));
					task_desc= checkForNull(rst.getString(2));
					seq_no= checkForNull(rst.getString(3));
					
					
					if(!(seq_no.equals("") && seq_no.equals("null") && seq_no.equals(null))){
						mode = "update";
					}
					else{
						mode = "";
					}
					
					sel=checkForNull(rst.getString(4));
					if (sel.equals("Y")){
						   select_checked="checked";
						   select_value="Y";
							k++;
					}else{
						select_checked="";
						select_value="N";
					}
					out.println("<tr>");
					out.println("<td class='" + classValue+"' width='30%'>"+task_code+"</td>");
					out.println("<td class='" + classValue+"' width='30%'>"+task_desc+"</td>");
					out.println("<td class='" + classValue+"' width='20%'><input type='text' name='seq_no"+i+"' id='seq_no"+i+"' size='3' maxlength='3' value='"+seq_no+"' task_code='"+task_code+"'task_desc='"+task_desc+"' seq_no='"+seq_no+"' select_yn='"+select_value+"' db_change_seq_yn='N' value_yn='"+seq_no+"' mode='"+mode+"' onBlur=\"return validateSeqNo(this,'"+i+"')\"; onKeyPress='return allowNumOnly(event);'></td>");
					
					out.println("<td class='" + classValue+"' width='30%'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" task_code='"+task_code+"'task_desc='"+task_desc+"' db_change='N' seq_no='"+seq_no+"' select_yn='"+select_value+"' mode='"+mode+"' onclick=\"validateCheckBox(this,'"+multiple_yn+"');\">");
					out.println("</td>");
					out.println("</tr>");
					if(totalSelected!=null && !totalSelected.equals(null) && totalSelected.length()>0){
						//out.println("totalSelected:=="+totalSelected);
						out.println("<script>clearListItemValue("+i+");</script>");
						String tokens[] = totalSelected.split(",");
						for(int p = 0;p<tokens.length;p++){
							if(Integer.parseInt(tokens[p])==i){
								out.println("<script>assingListItemValue("+tokens[p]+");</script>");
							}
						}
					}
				   
				  	i++;
				}
			%>
		</table>
		</center>
		<br><center>
		<% 
		   }catch(Exception e){
				out.println("MTasksLinkDetailForm : "+e);
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		%>
		<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
		<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
		<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
		<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
		<input type="hidden" name="start" id="start" value="<%=start%>" >
		<input type="hidden" name="end" id="end" value="<%=end%>" >
		<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
		<input type="hidden" name="treatment_code" id="treatment_code" value="<%=treatment_code%>" >
		<input type="hidden" name="task_desc" id="task_desc" value="<%=task_desc%>" >
		<input type="hidden" name="task_code" id="task_code" value="<%=task_code%>" >
		<input type="hidden" name="seq_no1" id="seq_no1" value="<%=seq_no%>" >
		<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
		<input type="hidden" name="multiple_yn" id="multiple_yn" value="<%=multiple_yn%>" >
		<input type="hidden" name="count_val" id="count_val" value="<%=count_val%>">
		<input type="hidden" name="maxRecord" id="maxRecord" value="<%=maxRecord%>">
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">

		</center>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">

		
	</form>
	<script>
		var formObj = document.forms[0];
		var called_from = formObj.called_from.value;
		if(called_from != "N" && called_from != "P"){
			getAllTasksLink();
		}
	</script>
	<!-- <script>
	var count=0;
	var count_val =document.forms[0].count_val.value;
		var arrObj = document.forms[0].elements;
		for(var i=0;i<arrObj.length;i++){
			if(arrObj[i].type=="checkbox"){
				if(arrObj[i].checked == true){
					count_val++
				}
			}
		}
		//document.forms[0].count_val.value = count;
	</script> -->
</BODY>
</HTML>

