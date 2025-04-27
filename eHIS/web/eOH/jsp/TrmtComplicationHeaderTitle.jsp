<!DOCTYPE html>
<!--Created by sathish on 20-01-2010-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
%>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
    String facility_id = (String)session.getValue( "facility_id" ) ;
	int maxRecord = 0;
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/TrmtComplicationDetails.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
		
	</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="TrmtComplicationHeaderFormTitle" id="TrmtComplicationHeaderFormTitle">
	<%   
    String DB_task_desc="";
	String DB_task_code="";
	String DB_task_seq="";
	int i=1;
	int count=0;

	String from = checkForNull(request.getParameter( "from" )) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?10:Integer.parseInt(to);

	StringBuffer sbr = new StringBuffer();

	String trmt_desc = "";
	String task_cmplication_cmpl_yn = "";
    
	String totalSelected=checkForNull(request.getParameter("totalSelected"));
	String tooth_range_count_for_order=checkForNull(request.getParameter("tooth_range_count_for_order"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String trmt_cat_type = checkForNull(request.getParameter("trmt_cat_type"));
	String seq_no	= checkForNull(request.getParameter( "task_seq" )) ;

	 
	String ind_chart_line_num=checkForNull(request.getParameter("ind_chart_line_num"));
	String task_desc = checkForNull(request.getParameter("task_desc"));

	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;	
	String date_diff_flag  = checkForNull(request.getParameter( "date_diff_flag" )) ;	//Added by Sridevi Joshi on 6/1/2010 for IN021668
	
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id)){
		status_disabled = "disabled";	
	}




	try{
		conn  =  ConnectionManager.getConnection(request);
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
		pstmt=conn.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
		pstmt.setString(1,trmt_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			trmt_desc = rst.getString("TRMT_DESC");
		}

		//To get task_cmplication_cmpl_yn for Task
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
		pstmt=conn.prepareStatement("SELECT TASK_CMPLICATION_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ? AND TASK_CODE=? AND TASK_SEQ=?");
		pstmt.setString(1,patient_id); 
		pstmt.setString(2,chart_num); 
		pstmt.setString(3,chart_line_num); 
		pstmt.setString(4,trmt_code); 
		pstmt.setString(5,task_code_req); 
		pstmt.setString(6,seq_no); 
		rst = pstmt.executeQuery();
		while(rst.next()){
			task_cmplication_cmpl_yn = rst.getString("TASK_CMPLICATION_CMPL_YN");
		}
		if(task_cmplication_cmpl_yn.equals("N") || task_cmplication_cmpl_yn.equals("")){
			status_disabled = "";
		}
		else{
			status_disabled = "disabled";
		}

        if(("Y").equals(baseline_chart_yn) || date_diff_flag.equals("disable"))//Condition for date_diff_flag is added by Sridevi Joshi on 6/1/2010 for IN021668
		{
         status_disabled = "disabled";
		}
		//strsql="SELECT A.TASK_CODE,D.TASK_DESC FROM OH_RESTORATIVE_CHART_MATRL A,  OH_COMPOSITION_CLASS B,OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?";
		strsql="SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS, A.COMPLICATION_SEQ_NO, B.COMPLICATION_DESC COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION  A, OH_COMPLICATION B, OH_TASKS_LANG C WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ?";
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
    
		int total=0;

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,task_code_req);
		pstmt.setString(6,seq_no);
		pstmt.setString(7,locale);
		rst = pstmt.executeQuery();
		while(rst.next()){
			total++;
		}

        maxRecord = total;

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,task_code_req);
		pstmt.setString(6,seq_no);
		pstmt.setString(7,locale);
		rst = pstmt.executeQuery();
		if( start != 1 ){
			for( int j=1; j<start; i++,j++ ){
				rst.next() ;
			}
		}

		while ( rst.next() && i<=end  ){
			i++;
		}
%>
		
		<table align='center' cellpadding='4' cellspacing='' border='0' width='98%'>
			<tr>
				<td width="25%">&nbsp;</td>
				<td colspan=2 width="25%" align=right>
					<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="closewindow();" >
				</td>
			</tr>
		</table>
		<table align='center' cellpadding='4' cellspacing='' border='1' width='98%'>
			<tr>
				<td class="columnHeaderCenter" width="25%"><fmt:message key="eOH.Task.Label" bundle="${oh_labels}"/></td>
				<td class="columnHeaderCenter" width="25%"><fmt:message key="eOH.DataEntryCompleted.Label" bundle="${oh_labels}"/></td>
			</tr>
		</table>
		<table align='center' cellpadding='4' cellspacing='' border='0' width='98%'>
	
			<%
				if(!task_code_req.equals("")){
			%>		<tr>
						<!-- <td  width='45%' ><A onclick = "populateComplicationDetails('<%=task_code_req%>','<%=task_desc%>','<%=status_disabled%>','<%=seq_no%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=task_desc%></A></td> -->

					<!--Added java.net.URLEncoder.encode(task_desc) in this page for 23245 by AnithaJ on 9/17/2010 -->
						<td  width='45%'><font color='blue'><A onclick = "populateComplicationDetails('<%=task_code_req%>','<%=java.net.URLEncoder.encode(task_desc)%>','<%=status_disabled%>','<%=seq_no%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer;font-weight:normal' name='tasklink<%=count%>'><%=task_desc%></A></font></td>
			<%	 
						if(task_cmplication_cmpl_yn.equals("N") || task_cmplication_cmpl_yn.equals("")){
			%>
							<td width="25%">
								<input type="checkbox" name="completed<%=count%>" id="completed<%=count%>" onClick="setCheckValue(count);updateTaskCmplicationCmplyn(this,'<%=task_code_req%>','<%=java.net.URLEncoder.encode(task_desc)%>','<%=seq_no%>','<%=count%>');" value='' <%=status_disabled%> >
							</td>
		
			<% 
						}else if(task_cmplication_cmpl_yn.equals("Y")){
			%>
							<td width="25%">
								<input type="checkbox" name="completed<%=count%>" id="completed<%=count%>" onClick="setCheckValue(count);updateTaskCmplicationCmplyn(this,'<%=task_code_req%>','<%=java.net.URLEncoder.encode(task_desc)%>','<%=seq_no%>','<%=count%>');" value='' checked disabled <%=status_disabled%>>
							</td>
			<%	
						}
			%>      
			            <input type="hidden"  name="DB_task_code_first" id="DB_task_code_first"    value="<%=task_code_req%>" >
		                <input type="hidden"  name="DB_task_desc_first" id="DB_task_desc_first"    value="<%=task_desc%>" >
		                <input type="hidden"  name="DB_task_seq_first" id="DB_task_seq_first"     value="<%=seq_no%>" >
					</tr>
			<%
				}else{	
					strsql="SELECT A.TASK_SEQ, A.TASK_CODE, D.TASK_DESC, A.TASK_CMPLICATION_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ? AND NVL(STATUS,'X') != 'E' ORDER BY TASK_SEQ";
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt = conn.prepareStatement(strsql);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,locale);
					rst = pstmt.executeQuery();
					while(rst.next()){
						
						DB_task_code = checkForNull(rst.getString("TASK_CODE"));
						DB_task_desc = checkForNull(rst.getString("TASK_DESC"));
						DB_task_seq =  checkForNull(rst.getString("TASK_SEQ"));
						task_cmplication_cmpl_yn = checkForNull(rst.getString("TASK_CMPLICATION_CMPL_YN"));
						if(task_cmplication_cmpl_yn.equals("N") || task_cmplication_cmpl_yn.equals("")){
							status_disabled = "";
						}
						else{
							status_disabled = "disabled";
						}

					if(("Y").equals(baseline_chart_yn) || date_diff_flag.equals("disable"))//Condition for date_diff_flag is added by Sridevi Joshi on 6/1/2010 for IN021668
					{
					status_disabled = "disabled";
					}
			%>		
						<tr>
							<!-- <td  width='45%' ><font color='blue'><A onclick = "populateComplicationDetails('<%=DB_task_code%>','<%=DB_task_desc%>','<%=status_disabled%>','<%=DB_task_seq%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=DB_task_desc%></A></font></td> -->
							<td  width='45%' ><font color='blue'><A onclick = "populateComplicationDetails('<%=DB_task_code%>','<%=DB_task_desc%>','<%=status_disabled%>','<%=DB_task_seq%>',<%=count%>);" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer' name='tasklink<%=count%>'><%=DB_task_desc%></A></font></td>
			<%	 
							if(task_cmplication_cmpl_yn.equals("N") || task_cmplication_cmpl_yn.equals("")){
			%>
								<td width="25%">
									<input type="checkbox" name="completed<%=count%>" id="completed<%=count%>" onClick="setCheckValue(count);updateTaskCmplicationCmplyn(this,'<%=DB_task_code%>','<%=DB_task_desc%>','<%=DB_task_seq%>','<%=count%>');" value='' <%=status_disabled%> > 
								</td>
					
			<% 
							}else if(task_cmplication_cmpl_yn.equals("Y")){
			%>
								<td width="25%">
									<input type="checkbox" name="completed<%=count%>" id="completed<%=count%>" onClick="setCheckValue(count);updateTaskCmplicationCmplyn(this,'<%=DB_task_code%>','<%=DB_task_desc%>','<%=DB_task_seq%>','<%=count%>');" value='' checked disabled <%=status_disabled%>>
								</td>
			<%	
							}
			%>
						</tr>
			<%			count++;	
					if(count<2){%>
						<input type="hidden"  name="DB_task_code_first" id="DB_task_code_first"   value="<%=DB_task_code%>" >
		                <input type="hidden"  name="DB_task_desc_first" id="DB_task_desc_first"   value="<%=DB_task_desc%>" >
		                <input type="hidden"  name="DB_task_seq_first" id="DB_task_seq_first"    value="<%=DB_task_seq%>" >
					<%}
					}	 
			%>
			<%	} %>
		</table>
        
		<input type="hidden" name="start" id="start" value="<%=start%>" >
		<input type="hidden" name="end" id="end" value="<%=end%>" >
		<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
		<input type="hidden" name="tooth_range_count_for_order" id="tooth_range_count_for_order" value="<%=tooth_range_count_for_order%>" >
		<input type="hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type="hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type="hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type="hidden" name= "trmt_code" value = "<%=trmt_code%>">
		<input type="hidden" name= "maxRecord" value = "<%=maxRecord%>">
		<input type="hidden" name= "display_tooth_no" value = "<%=display_tooth_no%>">
		<input type="hidden" name= "task_cmplication_cmpl_yn" value = "<%=task_cmplication_cmpl_yn%>">
		<input type="hidden" name= "params" value = "<%=request.getQueryString()%>">
		<input type="hidden" name= "task_code_req" value = "<%=task_code_req%>">
		<input type="hidden" name= "status_disabled" value = "<%=status_disabled%>">
		<input type="hidden" name= "ind_chart_line_num" value = "<%=ind_chart_line_num%>">
		<input type="hidden" name= "i" value = "<%=i%>">
		<input type="hidden" name= "count" value = "<%=count%>">

		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
		<input type = "hidden" name= "seq_no" value = "<%=seq_no%>">


		<input type = "hidden" name= "from" value = "<%=from%>">
		<input type = "hidden" name= "to" value = "<%=to%>">
		<input type = "hidden" name= "task_desc" value = "<%=task_desc%>">
		<input type = "hidden" name= "trmt_cat_type" value = "<%=trmt_cat_type%>">
		<input type = "hidden" name= "baseline_chart_yn" value = "<%=baseline_chart_yn%>">
		<input type = "hidden" name= "date_diff_flag" value = "<%=date_diff_flag%>">

		<script>populateComplicationDetailsFirstLoadingTime();</script>
<% 
	}catch(Exception e){
		out.println("TrmtComplicationDetailsForm : "+e);
  	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}
%>	

</form>
</body>
</html>

