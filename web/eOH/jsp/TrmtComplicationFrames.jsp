<!DOCTYPE html>
<!--Created by sathish on 20-01-2010-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<%
	String complication_title = "";
	String trmt_desc = "";
	String site_type=checkForNull(request.getParameter("site_type"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String params = request.getQueryString();	
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String task_cmplication_cmpl_yn="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String task_desc=checkForNull(request.getParameter("task_desc"));
	String super_tooth_ref=checkForNull(request.getParameter("super_tooth_ref"));
	String super_key_num=checkForNull(request.getParameter("super_key_num"));
	String tooth_no=checkForNull(request.getParameter("tooth_no"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String area_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels");//Added by Sridevi Joshi on 5/17/2010 for IN021414 

    if(("undefined").equals(super_key_num))
	{
		super_key_num="";
	}
	

	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
    try{
		connection  =  ConnectionManager.getConnection(request);
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
		pstmt.setString(1,trmt_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			trmt_desc = rs.getString("TRMT_DESC");
		}

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
	}
	catch(Exception ee){
	System.err.println("Exception=="+ee);
	}
	finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection,request);
	 }catch(Exception es){es.printStackTrace();}
	}
		
	if(site_type.equals("ARCH") || site_type.equals("QUAD")){
		if(!task_code_req.equals("")){
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+display_tooth_no;
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+display_tooth_no;
		}
	}
	else if(site_type.equals("MAXFS")){//Added by Sridevi Joshi on 5/17/2010 for IN021414 
		if(!task_code_req.equals("")){
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
		}
	}
	else{
		if(!task_code_req.equals("")){
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc;
			}
			else{
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc+",";
				if(("").equals(super_key_num) || super_tooth_ref.equals("RD")){
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}else{
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+super_key_num+"["+display_tooth_no+"]";
				}
			}
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc;
			}
			else{
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc+",";
				if(("").equals(super_key_num) || super_tooth_ref.equals("RD")){
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}else{
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+super_key_num+"["+display_tooth_no+"]";
				}
			}
		}
	}

							
%>
<html>
	<head>
		<title><%=complication_title%></title>
		<script src="../../eOH/js/TrmtComplicationDetails.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%  
		try{
			  String sql_trmt_dtls= "SELECT TASK_CMPLICATION_CMPL_YN TASK_CMPLICATION_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ?";
			  connection	= ConnectionManager.getConnection(request);
			  pstmt=connection.prepareStatement(sql_trmt_dtls);
			  pstmt.setString(1,patient_id); 
			  pstmt.setString(2,chart_num); 
			  pstmt.setString(3,chart_line_num); 
			  pstmt.setString(4,trmt_code); 
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				task_cmplication_cmpl_yn=checkForNull(rs.getString("TASK_CMPLICATION_CMPL_YN1"));
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

	<iframe name="TrmtComplicationHeaderTitle" id="TrmtComplicationHeaderTitle" frameborder="0" noresize src="../../eOH/jsp/TrmtComplicationHeaderTitle.jsp?<%= params %>" scrolling='auto' style='height:17%;width:100vw'></iframe><iframe name="TrmtComplicationHeaderLabel" id="TrmtComplicationHeaderLabel" frameborder="0" src="../../eOH/jsp/TrmtComplicationHeaderLabel.jsp?<%= params %>" scrolling='auto' noresize style='height:3%;width:100vw'></iframe>
		<iframe name="TrmtComplicationHeader" id="TrmtComplicationHeader" frameborder="0" src="../../eCommon/html/blank.html" scrolling='auto' noresize style='height:44%;width:100vw'></iframe>
		<iframe name="TrmtComplicationDetails" id="TrmtComplicationDetails" frameborder="0" src="../../eCommon/html/blank.html" scrolling='auto' noresize style='height:25%;width:100vw'></iframe>
		<iframe name='hidden_frame' id='hidden_frame'	frameborder="0" src='../../eOH/jsp/CommonMasterObjectCollect.jsp'  noresize style='height:0%;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
	<body  onKeyDown = 'lockKey();'>
		<form name="TrmtComplicationFramesForm" id="TrmtComplicationFramesForm" >
			<input type='hidden' name='task_cmplication_cmpl_yn' id='task_cmplication_cmpl_yn' value='<%=task_cmplication_cmpl_yn%>' >
			<input type='hidden' name='params' id='params' value='<%=params%>' >
		</form>
	</body>
</html>

