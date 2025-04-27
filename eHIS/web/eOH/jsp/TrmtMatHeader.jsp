<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
%>
<%
	Connection conn=null;												    
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
    int maxRecord = 0;
	int totalrec=0;
	String modified_flag="N";
	String facility_id = (String)session.getValue( "facility_id" ) ;
    //String task_code_req = checkForNull(request.getParameter("task_code"));
    String task_code_req = checkForNull(request.getParameter("task_code_req")); 
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Johi on 5/27/2010 for IN021653
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Johi on 5/27/2010 for IN021668

	
    //String treatment_status_param = checkForNull(request.getParameter("treatment_status_param"));
    String trmt_dtls_entry_cmpl_yn=  "";
	String disable_flag="";
	
	//Added by Sharon Crasta on 11/13/2008 for SCR #6492
	//Added to display the Task Description.
    String task_desc = checkForNull(request.getParameter("task_desc"));
	//End
	
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/TrmtMatDetails.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name="TrmtMatHeaderForm" id="TrmtMatHeaderForm" method="post">
		<%   
			 String select_value="Y";
			 String select_checked="";
			 String composition_class_code="";
			 String composition_code="";
			 String composition_class_desc="";
			 String composition_desc="";
			 String composition_remarks="";
			 String composition_seq_no="";
			 String classValue="";

			 String from = checkForNull(request.getParameter( "from" )) ;
			 String to =   checkForNull(request.getParameter( "to" ) ) ;

			 int start = ( from.equals("") )?1:Integer.parseInt(from);
			 int end =  ( to.equals("") )?10:Integer.parseInt(to);

			 int total=0;
			 int i=1;

			 StringBuffer sbr = new StringBuffer();
			 String totalSelected=checkForNull(request.getParameter("totalSelected"));
			 String tooth_range_count_for_order=checkForNull(request.getParameter("tooth_range_count_for_order"));
			 String patient_id=checkForNull(request.getParameter("patient_id"));
			 String chart_num=checkForNull(request.getParameter("chart_num"));
			 String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
			 String trmt_code=checkForNull(request.getParameter("trmt_code"));
			 String ind_chart_line_num=checkForNull(request.getParameter("ind_chart_line_num"));
			 String status_disabled =  checkForNull(request.getParameter("status_disabled"));
			 String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			 String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			 String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
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

				pstmt=conn.prepareStatement("SELECT TRMT_DTLS_ENTRY_CMPL_YN TRMT_DTLS_ENTRY_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ? AND TASK_CODE=? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id); 
				pstmt.setString(2,chart_num); 
				pstmt.setString(3,chart_line_num); 
				pstmt.setString(4,trmt_code); 
				pstmt.setString(5,task_code_req); 
				pstmt.setString(6,seq_no); 
				rst = pstmt.executeQuery();

				while(rst.next()){
					trmt_dtls_entry_cmpl_yn = rst.getString("TRMT_DTLS_ENTRY_CMPL_YN1");
				}
				
				//By Sridevi Joshi for CRF-709(IN012626) : This is to disable the fields if dataentry is already completed and we are loading this page without closing the window.
				if(trmt_dtls_entry_cmpl_yn.equals("Y") || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/27/2010 for IN021653
					disable_flag= "disabled";
				}else{
					disable_flag= "";
				}

				//strsql="SELECT A.TASK_CODE,D.TASK_DESC,B.COMPOSITION_CLASS_CODE, B.COMPOSITION_CLASS_DESC, C.COMPOSITION_CODE, A. COMPOSITION_REMARKS, A.COMPOSITION_SEQ_NO, DECODE(B.COMPOSITION_CLASS_CODE,'OTH',A.COMPOSITION_REMARKS,C.COMPOSITION_DESC) COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A, OH_COMPOSITION_CLASS B, OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?";

				strsql="SELECT A.TASK_CODE,D.TASK_DESC,B.COMPOSITION_CLASS_CODE, B.COMPOSITION_CLASS_DESC, C.COMPOSITION_CODE, A. COMPOSITION_REMARKS, A.COMPOSITION_SEQ_NO, DECODE(B.COMPOSITION_CLASS_CODE,'OTH',A.COMPOSITION_REMARKS,C.COMPOSITION_DESC) COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A, OH_COMPOSITION_CLASS B, OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND  A.TASK_SEQ = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?";
				
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				pstmt = conn.prepareStatement(strsql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,ind_chart_line_num);
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
			%>

			<table border="0" width="98%" cellspacing='0' cellpadding='2'  align='center'>
				<tr>
					<td align="right" class='CAGROUPHEADING' width="20%" colspan=4>
						<%
							int m=1;
							for(int k=1;k<=maxRecord;k=k+10){
								if(maxRecord > 10){
									out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='showRecords("+k+");'>"+m+"</font>");
								}
								m++;
							}
						%>
					</td>
				</tr>
			</table>
			<table border="1" width="98%" cellspacing='0' cellpadding='2'  align='center'>
				<%
					if ( start != 1 ){
						for( int j=1; j<start; i++,j++ ){
							rst.next() ;
						}
					}
				
					while ( rst.next() && i<=end  ){
						classValue  = ( i % 2 == 0 )?"QRYEVENSMALL":"QRYODDSMALL" ;
						composition_class_code= rst.getString("COMPOSITION_CLASS_CODE");
						composition_code= rst.getString("COMPOSITION_CODE");
						composition_class_desc= rst.getString("COMPOSITION_CLASS_DESC");
						composition_desc=rst.getString("COMPOSITION_DESC");
						composition_remarks=checkForNull(rst.getString("COMPOSITION_REMARKS"));
						composition_seq_no=checkForNull(rst.getString("COMPOSITION_SEQ_NO"));
						
						sbr.append("<tr>");
						sbr.append("<td  width='30%' class='"+classValue+"' wrap>"+composition_class_desc+"</td>");
						sbr.append("<td  width='30%' class='"+classValue+"' wrap>"+composition_desc+"</td>");
						sbr.append("<td  width='10%' class='" + classValue+"'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" composition_seq_no='"+composition_seq_no+"' composition_remarks='"+composition_remarks+"' composition_class_code='"+composition_class_code+"' composition_code='"+composition_code+"'select_yn='"+select_value+"'modified_flag='"+modified_flag+"' onclick='validateCheckBox(this)'" +status_disabled+" "+disable_flag+" >");
						sbr.append("</td>");
						sbr.append("</tr>");
						
						if(totalSelected!=null && !totalSelected.equals(null) && totalSelected.length()>0){
							String tokens[] = totalSelected.split(",");
							for(int p = 0;p<tokens.length;p++){
								if(Integer.parseInt(tokens[p])==i)
									sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
							}
						}
						i++;
					}	
					out.println(sbr.toString());	
				%>
			</table>
			<br>
		   <% 
		   }catch(Exception e){
				out.println("TrmtDetailsForm : "+e);
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					if(sbr!=null)   sbr.setLength(0);
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		   %>
			<%if(!task_code_req.equals("")){%>
				<table align='right'>
					<tr>
						<td>
							<input type="button" class="button" name="delete1" id="delete1" value="<fmt:message key='Common.delete.label' bundle='${common_labels}'/>" onclick ="deleteCompRecorded()" <%=status_disabled%> <%=disable_flag%>>
						</td>
					</tr>
				</table>
			<%}%>
			<input type="hidden" name="start" id="start" value="<%=start%>" >
			<input type="hidden" name="end" id="end" value="<%=end%>" >
			<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
			<input type="hidden" name="tooth_range_count_for_order" id="tooth_range_count_for_order" value="<%=tooth_range_count_for_order%>" >
			<input type="hidden" name= "patient_id" value = "<%=patient_id%>">
			<input type="hidden" name= "chart_num" value = "<%=chart_num%>">
			<input type="hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
			<input type="hidden" name= "trmt_code" value = "<%=trmt_code%>">
			<input type="hidden" name= "maxRecord" value = "<%=maxRecord%>">
			<input type="hidden" name= "i" value = "<%=i%>">
			<input type="hidden" name= "totalrec" value = "<%=totalrec%>">
			<input type="hidden" name= "modified_flag" value = "<%=modified_flag%>">
			<input type="hidden" name= "ind_chart_line_num" value = "<%=ind_chart_line_num%>">
			<input type="hidden" name= "params" value = "<%=request.getQueryString()%>">
			<input type="hidden" name= "task_code_req" value = "<%=task_code_req%>">
			<input type="hidden" name= "status_disabled" value = "<%=status_disabled%>">
			<input type="hidden" name= "baseline_chart_yn" value = "<%=baseline_chart_yn%>">
			<input type="hidden" name= "date_diff_flag" value = "<%=date_diff_flag%>">

			<!--Added by Sharon Crasta on 11/13/2008 for SCR #6492-->
			<input type="hidden" name= "task_desc" value = "<%=task_desc%>">
			<!-- End -->

			<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
			<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
			<!--Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480) -->
			<input type = "hidden" name= "seq_no" value = "<%=seq_no%>">
		</form>
	</body>
</html>

