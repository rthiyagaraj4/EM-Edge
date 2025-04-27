<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>


<%
	String locale = (String)session.getAttribute("LOCALE");
	String composition_title = "";
	String trmt_desc = "";
	String site_type=checkForNull(request.getParameter("site_type"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String params = request.getQueryString();	
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String trmt_dtls_entry_cmpl_yn="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String task_desc=checkForNull(request.getParameter("task_desc"));
	
	String tooth_no=checkForNull(request.getParameter("tooth_no"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String super_tooth_ref=checkForNull(request.getParameter("super_tooth_ref"));//Added by Sridevi Joshi on 2/24/2010 for IN010894 
	String area_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels");//Added by Sridevi Joshi on 5/17/2010 for IN021414 
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	
	try{
	connection  =  ConnectionManager.getConnection(request);
	if(super_tooth_ref.equals("RD")){
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		pstmt = connection.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH WHERE TOOTH_NO = ?) AND NUMBERING_SYSTEM = ?");
		pstmt.setString(1,tooth_no);
		pstmt.setString(2,tooth_numbering_system);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next()){
			display_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
		}
	}
	else if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !site_type.equals("MAXFS")){ //Added by Sridevi Joshi on 2/24/2010 for IN010894 
		display_tooth_no = super_tooth_ref+"["+display_tooth_no+"]";
	}

	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
	pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT_lang_vw  WHERE TRMT_CODE = ? and language_id=?");
	//pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
	pstmt.setString(1,trmt_code);
	pstmt.setString(2,locale);//Added by Sridevi Joshi on 8/16/2010 for 
	rs = pstmt.executeQuery();
	while(rs.next()){
		trmt_desc = rs.getString("TRMT_DESC");
	}
		
	if(site_type.equals("ARCH") || site_type.equals("QUAD")){
		if(!task_code_req.equals("")){
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+display_tooth_no;
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+display_tooth_no;
		}
	}
	else if(site_type.equals("MAXFS")){//Added by Sridevi Joshi on 5/17/2010 for IN021414 
		if(!task_code_req.equals("")){
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
		}
	}
	else{
		if(!task_code_req.equals("")){
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc;
			}
			else{
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc+",";
				if(super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")){
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}
				else{
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+display_tooth_no+"";
				}
			}
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc;
			}
			else{
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc+",";
				if(super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")){
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}
				else{
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+display_tooth_no+"";
				}
			}
		}
	}

							
%>
<html>
	<head>
		<title><%=composition_title%></title>
		<script src="../../eOH/js/TrmtMatDetails.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<%  
		try{
			  String sql_trmt_dtls= "SELECT TRMT_DTLS_ENTRY_CMPL_YN TRMT_DTLS_ENTRY_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ?";
			  connection	= ConnectionManager.getConnection(request);
			  pstmt=connection.prepareStatement(sql_trmt_dtls);
			  pstmt.setString(1,patient_id); 
			  pstmt.setString(2,chart_num); 
			  pstmt.setString(3,chart_line_num); 
			  pstmt.setString(4,trmt_code); 
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				trmt_dtls_entry_cmpl_yn=checkForNull(rs.getString("TRMT_DTLS_ENTRY_CMPL_YN1"));
			  }
		}catch(Exception ee){
			System.err.println("Exception=="+ee);
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
			 }catch(Exception es){es.printStackTrace();}
		}
	%>

	<iframe name="TrmtMatHeaderTitle" id="TrmtMatHeaderTitle" frameborder="0" noresize src="../../eOH/jsp/TrmtMatHeaderTitle.jsp?<%= params %>"  style="height:20%;width:100vw"></iframe><iframe name="TrmtMatHeaderLabel" id="TrmtMatHeaderLabel" frameborder="0" src="../../eOH/jsp/TrmtMatHeaderLabel.jsp?<%= params %>" noresize style="height:3%;width:100vw"></iframe>
		<iframe name="TrmtMatHeader" id="TrmtMatHeader" frameborder="0" src="../../eCommon/html/blank.html" noresize style="height:45%;width:100vw"></iframe>
		<iframe name="TrmtMatDetails" id="TrmtMatDetails" frameborder="0" src="../../eCommon/html/blank.html" noresize style="height:20%;width:100vw"></iframe>
		<iframe name='hidden_frame' id='hidden_frame'	frameborder="0" src='../../eOH/jsp/CommonMasterObjectCollect.jsp'  noresize style='height:0%;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
	<body  onKeyDown = 'lockKey();'>
		<form name="TrmtMatFramesForm" id="TrmtMatFramesForm" >
			<input type='hidden' name='trmt_dtls_entry_cmpl_yn' id='trmt_dtls_entry_cmpl_yn' value='<%=trmt_dtls_entry_cmpl_yn%>' >
			<input type='hidden' name='params' id='params' value='<%=params%>' >
		</form>
	</body>
</html>
<%
}catch(Exception e){
		connection.rollback();
		 System.err.println("Err Msg from TrmtMatFrames.jsp "+e);
	}
   finally{
		 if(rs!=null) rs.close();
		 if(pstmt!=null)pstmt.close();
		 if(connection!=null)
		 ConnectionManager.returnConnection(connection,request);
	}
%>

