<!DOCTYPE html>
<!-- Created by sathish on09-02-2010 against CRF-482(10895)  -->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	
	
	Connection con=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String task_code = "";
	String task_desc = "";
	String status = "";
	String status_type = "";
	String status_desc = "";
	String classValue = "";
	String date = "";
	String doneby = "";
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String tooth_no_display_for_task = checkForNull(request.getParameter("tooth_no_display_for_task")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
	String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String condition_trmt_code_desc_for_task = checkForNull(request.getParameter( "condition_trmt_code_desc_for_task" )) ;
	String site_type = checkForNull(request.getParameter( "site_type" )) ;
	String title_desc_hid = checkForNull(request.getParameter( "title_desc_hid" )) ;
	String task_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TasksforTreatment.Label","oh_labels"); 
	String for_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.For.Label","oh_labels"); 
	String toothno_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels"); 
	
	if(site_type.equals("QUAD") || site_type.equals("ARCH")){
	task_title = task_title+ " '" + condition_trmt_code_desc_for_task+ "'  " + " "+for_label+ " " + title_desc_hid;
	}
	else{
	task_title = task_title+ " '" + condition_trmt_code_desc_for_task+ "'  " + " "+ for_label +" "+toothno_label + " " + tooth_no_display_for_task;
	}

	//task_title = task_title+"  "+condition_trmt_code_desc_for_task;

	try{
		con=ConnectionManager.getConnection(request);
        if(oh_chart_level.equals("E")){
		String sql="SELECT A.PATIENT_CLASS,A.TASK_CODE,B.TASK_DESC,C.REMARKS,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI') MODIFIED_DATE,A.MODIFIED_BY_ID,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC FROM OH_RESTORATIVE_CHART_TASKS A,OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TASK_SEQ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,locale);
		}else
		{
		String sql="SELECT A.PATIENT_CLASS,A.TASK_CODE,B.TASK_DESC,C.REMARKS,TO_CHAR(A.MODIFIED_DATE,'DD/MM/YYYY HH24:MI') MODIFIED_DATE,A.MODIFIED_BY_ID,(SELECT SHORT_DESC FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_CODE = A.STATUS) STATUS_DESC FROM OH_RESTORATIVE_CHART_TASKS A,OH_TASKS_LANG_VW B, OH_RESTORATIVE_CHART_DTL C WHERE A.OPERATING_FACILITY_ID  =C.OPERATING_FACILITY_ID AND A.PATIENT_ID=C.PATIENT_ID AND A.CHART_NUM=C.CHART_NUM AND A.CHART_LINE_NUM =C.CHART_LINE_NUM AND A.TRMT_CODE = C.TRMT_CODE AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM =? AND A.TRMT_CODE = ? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID=? AND NVL(A.STATUS,'X') != 'E' AND NVL(C.COND_CLOSED_YN,'N') = 'N' AND A.OPERATING_FACILITY_ID=? ORDER BY A.TASK_SEQ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_id);
		}
		rs=pstmt.executeQuery();


%>
<html>
	<head>
		<script>
		async function openNotes(patient_id,chart_num,chart_line_num,trmt_code,task_code,progress_note_type){
			var formObj = document.OHTreatmentForm;
			//var params = formObj.params.value;
			var contr_mod_acession_num=chart_num+"$$"+trmt_code+"$$"+chart_line_num;
			var contr_mod_acession_num="";
			var speciality_code="11";

			//params=params+"&note_type="+progress_note_type;
			//alert("params  : "+params)
			var title = getLabel("eOH.ProgressNotes.Label","OH");
			var url="../../eCA/jsp/ProgressNotesModal.jsp?title="+title+"&module_id=OH&appl_task_id=PROGRESS_NOTES";
			var dialogHeight = "80vh" ;
			var dialogWidth  = "80vw" ;
			//var dialogWidth  		= window.screen.availWidth;
			var dialogTop    = "10";
			var dialogLeft   = "50";
			var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" + ";title:" +title ;
			await top.window.showModalDialog(url,"CAWindow",features);
		}
		</script>
		<title>
        <%=task_title%>
		</title> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name = "showAllImagesForm" >
		<!-- 	<table width="101.7%"> 
				<tr>
					<td align="right" class="button" colspan="7">
						<input type="button" class="button" name="" id="" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();">
					</td>
				</tr>
			</table> -->
 <table width="101.1%">
	<tr>
		<td>
			<!-- <table border=1 cellpadding=0 cellspacing=0 width="100%">
				<tr>
					
							<td class = "CAGROUPHEADING" style="text-align:center" colspan="7"><%=task_title%></th>
					
				</tr>
				<tr>
					<th WIDTH="8%" style="text-align:center"><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th>
					
					<th WIDTH="18%" style="text-align:center"><fmt:message key='Common.Task.label' bundle='${common_labels}'/></th>
					

                    <th WIDTH="18%" style="text-align:center"><fmt:message key='Common.status.label' bundle='${common_labels}'/></th>
							 
					<th WIDTH="33%" style="text-align:center"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th> 
 
					
					
					<th WIDTH="5%" style="text-align:center"><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></th>
					
					<th WIDTH="10%" style="text-align:center"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>

					<th WIDTH="20%" style="text-align:center"><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></th>

			</tr>				
			</table> -->

			<table border=1 cellpadding=0 cellspacing=0 width="100%">
			    <tr>
					<td align="right" class="button" colspan="5">
						<input type="button" class="button" name="" id="" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();">
					</td>
				</tr>
				<tr>

					<td class = "CAGROUPHEADING" style="text-align:center" colspan="5"><%=task_title%></th>

				</tr>
				<tr>
					<!-- <th WIDTH="8%" style="text-align:center"><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th> -->
					
					<th WIDTH="18%" style="text-align:center"><fmt:message key='Common.Task.label' bundle='${common_labels}'/></th>
					

                    <th WIDTH="18%" style="text-align:center"><fmt:message key='Common.status.label' bundle='${common_labels}'/></th>
							 
					<th WIDTH="33%" style="text-align:center"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th> 
 
					
					
					<!-- <th WIDTH="5%" style="text-align:center"><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></th> -->
					
					<th WIDTH="10%" style="text-align:center"><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>

					<th WIDTH="20%" style="text-align:center"><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></th>

			</tr>			
				
						<%	
						int i=1;
						while(rs.next()){
						if ( i % 2 == 0 ){
							classValue = "QRYEVEN" ;
						}
						else{
							classValue = "QRYODD" ;
						}
						task_code= rs.getString("TASK_CODE");
						task_desc= rs.getString("TASK_DESC");
						//status=checkForNull(rs.getString("STATUS"));
						date=checkForNull(rs.getString("MODIFIED_DATE"));
						doneby=checkForNull(rs.getString("MODIFIED_BY_ID"));
						remarks=checkForNull(rs.getString("REMARKS"));
						status_desc=checkForNull(rs.getString("STATUS_DESC"));
						
						if(status_type.equals("10")){
							status = "OS"; //  Outstanding
						}
						else if(status_type.equals("15")){
							status = "SC"; //Scheduled
						}
						else if(status_type.equals("25")){
							status = "RG"; //Registered
						}
						else if(status_type.equals("52")){
							status = "IM"; //In Progress
						} 
						else if(status_type.equals("55") || status_type.equals("80")){ // Partial
							status = "IR"; //Registered
						}
						else if(status_type.equals("85") || status_type.equals("60")){
							status = "RS"; //ResultEntry(Result completed)
						}
						//Added by Sharon Crasta on 3/17/2010 for IN019604 - thai conversion
						date = checkForNull(com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale));
						//End

                        out.println("<tr>");
                        //out.println("<td WIDTH='8%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2><font color='blue'><a onClick=javascript:openNotes('"+i+"') style='cursor:pointer;'>"+"Notes"+"</a></font></td>");
						/*out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+task_code+"</td>");*/
						out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+task_desc+"</td>");
						out.println("<td WIDTH='18%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+status_desc+"</td>");
					    out.println("<td id='remarksCondition_"+i+"' WIDTH='33%' class='"+classValue+"' style='text-align:left';text-color:navy;cursor:pointer;text-size:2 wrap >"+remarks+"</td>");
						//out.println("<td WIDTH='5%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+tooth_no_display_for_task+"</td>"); 
						out.println("<td WIDTH='10%' class='"+classValue+"' style='text-align:center';text-color:navy;text-size:2>"+date+"</td>");
						out.println("<td WIDTH='20%' class='"+classValue+"' style='text-align:left';text-color:navy;text-size:2>"+doneby+"</td>");
						out.println("</tr>");
                        out.println("</tr>");
						i++;
						}
						%>

							
			</table>
		</td>
	</tr>
</table>
			
			<input type="hidden" name="chart_num" id="chart_num" value ="<%=chart_num%>">
			<input type="hidden" name="patient_id" id="patient_id" value ="<%=patient_id%>">
			<input type="hidden" name="chart_line_num" id="chart_line_num" value ="<%=chart_line_num%>">
			<input type="hidden" name="trmt_code" id="trmt_code" value ="<%=trmt_code%>">
		</form>
	</body>
</html>

<%
}catch ( Exception e ) {
	System.err.println("Error in Show Tasks for Treatment,:"+request.getQueryString());
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

