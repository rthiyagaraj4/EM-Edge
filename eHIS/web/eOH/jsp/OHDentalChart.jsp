<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,eOH.Common.*,eOH.*,eCommon.Common.CommonBean" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 

	String load_images_yn	= request.getParameter("load_images_yn");
	load_images_yn=checkForNull(load_images_yn,"Y");
	String tooth_numbering_system	= request.getParameter("tooth_numbering_system");
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String date_diff_flag        = request.getParameter("date_diff_flag");
	
	String patient_id = request.getParameter( "patient_id" ) ;
	String encounter_id = request.getParameter( "encounter_id" ) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_class = request.getParameter("patient_class");
	String chart_type = request.getParameter( "chart_type" ) ;
	String header_tab = request.getParameter( "header_tab" ) ;
	String treat_Locn_Type = request.getParameter( "treat_Locn_Type" ) ;

	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	
	String mode = checkForNull(request.getParameter("mode")) ;
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn")) ;//added by parul  for other facility chart CRF#0423
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;//added by parul  for other facility chart CRF#0423
	if(mode.equals("modify")){
		patient_id = request.getParameter( "patient_id_new" ) ;
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	//Statement stmt=null;
	ResultSet rs=null;
	String sql = "";
	String tooth_num = "";
	String tooth_name ="";
	String tooth_sn = "";
	String mapped_tooth_string = "";
	int mapped_tooth_no = 0;
	//int i = 0;
	//int j = 1;
	int k = 1;
	int z = 0;

	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String chart_hdr_insert_yn = checkForNull(request.getParameter("chart_hdr_insert_yn"));
	String chart_num =checkForNull(request.getParameter("chart_num")) ;
	String called_from_viewchart_yn =checkForNull(request.getParameter("called_from_viewchart_yn")) ;
	String baseline_chart_yn =checkForNull(request.getParameter("baseline_chart_yn")) ;
	String chart_status_from_view =checkForNull(request.getParameter("chart_status_from_view")) ;
	String oh_chart_level =checkForNull(request.getParameter("oh_chart_level")) ;
	String add_new_yn =checkForNull(request.getParameter("add_new_yn")) ;
	String add_new_done_flag =checkForNull(request.getParameter("add_new_done_flag")) ;
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	   date_diff_flag = "enable";
	   called_from_viewchart_yn = "N";
	}
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
	
%>
<%	
	try{
		con = ConnectionManager.getConnection(request);
%>

<html>
<head>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script src="../../eOH/js/OHDentalChart.js" language="javascript"></script>
	<script src="../../eOH/js/FillImages.js" language="javascript"></script>
	<script src="../../eOH/js/DrawShapes.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eOH/js/GetImages.js" language="javascript"></script>
	<script src="../../eOH/js/Rules.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<style>
		
		TABLE{
				BACKGROUND-COLOR:#CACEF9;
		}
		TD{
				BACKGROUND-COLOR:white;
				border-color:#999999
		}
		TD.OTHER{
				BACKGROUND-COLOR:#D7E6F9;
				COLOR:navy;
				FONT-SIZE: 8pt;
				TEXT-ALIGN: LEFT;
				
		}
		TD.ARCH{
				BACKGROUND-COLOR:#99ddee;
				COLOR:navy;
				FONT-SIZE: 8pt;
				TEXT-ALIGN: LEFT;
				
		}
		TD.QUADRANT{
				BACKGROUND-COLOR:#CCECFF;
				COLOR:navy;
				FONT-SIZE: 8pt;
				TEXT-ALIGN: LEFT;
		}

		#menu, #menu ul {list-style:none;	padding:0;	margin:0;}
		#menu li {	float:left;	position:relative;	line-height: 4.5em;	width: 10em;}

		#menu li ul {	position:absolute;	margin-top:-1em;	margin-left:.5em;	display:none;}
		#menu ul li ul {	margin-top:-3em;	margin-left:7em;}

		#menu a {	display:block;	border-right:1px solid #fff;	background:#E0F574;	color:#3B3B3B;	text-decoration:none;	padding:0 10px;}
		#menu a:hover {	background-color:#5798B4;	color:#fff;}
		#menu ul {	border-top:1px solid #fff;}
		#menu ul a {	border-right:none;	border-right:1px solid #fff;	border-bottom:1px solid #fff;	border-left:1px solid #fff;	background:#AEC245;}

		/* SHOW SUBMENU 1 */#menu li:hover ul, #menu li.over ul {	display:block;}
		#menu li:hover ul ul, #menu li.over ul ul {	display:none;}
		/* SHOW SUBMENU 2 */#menu ul li:hover ul, #menu ul li.over ul {	display:block;}

	</style>

	<!--[if IE]><style type="text/css">	#menu li {		position:static;	}</style><![endif]-->



</head>
 <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onMouseOver='hideMenuOnOutFocus()'> 
<!-- <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()"> -->
<form name="dentalChartMainForm" id="dentalChartMainForm">
<!-- This is the hidden field which will hold the value of the tooth that is currently clicked on this field is set with the value by showMenu() function that is present in menu.js -->
<input type='hidden' name='teethClickedOn' id='teethClickedOn' value=''>
 <table width="99%" border="0" cellspacing="1" cellpadding="0" align="left" valign="top">
 
	<tr>
		 <td ><table width="100%" border="1" cellspacing="0" cellpadding="0" >
			<tr>
				<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="QUADRANT" style="text-align:left" nowrap ><table border=0 width="100%"><tr><td id="COLORQ<%=Q1_id%>" class="QUADRANT" style="text-align:left" nowrap ><input type="checkbox" name="sel<%=Q1_id%>" id="sel<%=Q1_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q1_id%>');" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q1_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q1_desc%></A></td><td id="Q<%=Q1_id%>" class="QUADRANT" style="text-align:left" nowrap ><a onclick="getDialogFeaturesForNoImage('Q<%=Q1_id%>','<%=Q1_desc%>','QUAD');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="QUADRANT" style="text-align:left" nowrap ><table border=0 width="100%"><tr><td id="COLORQ<%=Q1_id%>" class="QUADRANT" style="text-align:left" nowrap ><input type="checkbox" name="sel<%=Q1_id%>" id="sel<%=Q1_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q1_id%>');" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q1_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q1_desc%></A></td><td id="Q<%=Q1_id%>" class="QUADRANT" style="text-align:left" nowrap ><table border="0"  width="100%" cellspacing="0" cellpadding="3" onMouseOver='hideToolTip();' onclick="getDialogFeaturesForNoImage('Q<%=Q1_id%>','<%=Q1_desc%>','QUAD');" style='cursor:pointer'><tr><td class="QUADRANT"  width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18">&nbsp;</td></tr></table></td></tr></table></td>
			   <!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="ARCH" style="text-align:center" nowrap ><table border=0 width="100%"><tr><td id="COLORAU" class="ARCH" style="text-align:left" nowrap ><input type="checkbox" name="selU" id="selU" value="" onclick="setCheckvalForArch(this,'U')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('U');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=upper_arch_desc%></A></td><td id="AU" class="ARCH" style="text-align:left" nowrap><a onclick="getDialogFeaturesForNoImage('AU','<%=upper_arch_desc%>','ARCH');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="ARCH" style="text-align:center" nowrap ><table border=0 width="100%"><tr><td id="COLORAU" class="ARCH" style="text-align:left" nowrap ><input type="checkbox" name="selU" id="selU" value="" onclick="setCheckvalForArch(this,'U')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('U');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=upper_arch_desc%></A></td><td id="AU" class="ARCH" style="text-align:left" nowrap><table border="0" width="100%" cellspacing="0" cellpadding="3"  onMouseOver='hideToolTip();' onclick="getDialogFeaturesForNoImage('AU','<%=upper_arch_desc%>','ARCH');" style='cursor:pointer'><tr><td class="ARCH" width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18" >&nbsp</td></tr></table></td></tr></table></td>
				<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="QUADRANT" style="text-align:right" nowrap ><table border=0 width="100%"><tr><td  id="COLORQ<%=Q2_id%>" class="QUADRANT" style="text-align:left" nowrap ><input type="checkbox" name="sel<%=Q2_id%>" id="sel<%=Q2_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q2_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q2_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q2_desc%></A></td><td id="Q<%=Q2_id%>" class="QUADRANT" style="text-align:left" nowrap><a onclick="getDialogFeaturesForNoImage('Q<%=Q2_id%>','<%=Q2_desc%>','QUAD');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="QUADRANT" style="text-align:right" nowrap ><table border=0 width="100%"><tr><td  id="COLORQ<%=Q2_id%>" class="QUADRANT" style="text-align:left" nowrap ><input type="checkbox" name="sel<%=Q2_id%>" id="sel<%=Q2_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q2_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q2_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q2_desc%></A></td><td id="Q<%=Q2_id%>" class="QUADRANT" style="text-align:left" nowrap><table border="0"  width="100%" cellspacing="0" cellpadding="3" onMouseOver='hideToolTip();' onclick="getDialogFeaturesForNoImage('Q<%=Q2_id%>','<%=Q2_desc%>','QUAD');" style='cursor:pointer'><tr onMouseOver='hideToolTip();'><td class="QUADRANT" width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18">&nbsp;</td></tr></table></td></tr></table></td>
			</tr>
		</table></td>
	</tr>
	<tr>
		<td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top"><table  border="0" cellpadding="1" cellspacing="1">
					<tr>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr>
						<%
							//LOGIC FOR DISPLAYING UPPER RIGHT QUADRANT OF DENTAL CHART
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, DECODE(?,'UNI',B.UNIVERSAL_TOOTH_NO, B.FDI_TOOTH_NO) TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B WHERE B.PERMANENT_DECIDUOUS = ?";												
							//If additional Lang_vw object is added to the below query, make sure that the TOOTH_NAME qry from the TOOTH_LANG_VW is retrieved properly
							if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER";
							}else{
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ?";
							}
							pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
							pstmt.setString(1,locale);
							pstmt.setString(2,tooth_numbering_system);
							pstmt.setString(3,permanent_deciduous_flag);
							rs=pstmt.executeQuery();
							k=1;
							//This is the count (only for deciduous tooth ) which goes on reducing as the teeths absent increases in the patient with age less than 6 / 5 
							z=32;
							while(rs.next()){
								if(k<=8){
									tooth_sn = rs.getString("TOOTH_NO");
									tooth_num = rs.getString("TOOTH_NUM");
									tooth_name = rs.getString("TOOTH_NAME");
									mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
									if(mapped_tooth_string != null){
										mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
									}
									
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 1){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=1 && k<=3){
												out.println("<td id ='decith_table"+k+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+k+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+k+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center' background-color='red'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											
												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											
												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 1){ //Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}

											out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											//	out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><font size='1'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a></font><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");
											
											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										/*
										while(mapped_tooth_no != k){
											out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

											out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

											out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

											out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

											k++;
											z--;
										}*/
										
										if(mixed_dentition_YN.equals("Y")){
											if(k == 1){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=1 && k<=3){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											while(mapped_tooth_no != k){
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												k++;
												z--;
											}

											if(k==4 || k==5){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R3.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR3' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='check_num"+tooth_sn+"' align='center'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
									}
									k++;
								}
								else{
									rs.previous();
									break;
								}
							}
						%>
						</tr></table></td>
					</tr>
				</table></td>
				<td valign="top"><table border="0" cellpadding="1" cellspacing="1" >
					<tr>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr>
						<%	
							//LOGIC FOR DISPLAYING UPPER LEFT QUADRANT OF DENTAL CHART
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k<=16){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 16){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=16 && k>=14){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 16){ //Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}
												
											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
											//	out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><font size='1'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a></font><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 16){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											
											}
											else if(k!=16 && k>=14){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											if(mapped_tooth_no == k){
												if(k==12 || k==13){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R14.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR14' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");
													
													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}

											}else{
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												z--;
											}
										}
									}
									k++;
								}
								else{
									break;
								}
							}
						%>
						</tr></table></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
	</tr>

	<tr>
		<td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top"><table border="0" cellpadding="1" cellspacing="1">
					<tr>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr>
						<%
							//LOGIC FOR DISPLAYING LOWER RIGHT QUADRANT OF DENTAL CHART
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, DECODE(?,'UNI',B.UNIVERSAL_TOOTH_NO, B.FDI_TOOTH_NO) TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B WHERE B.PERMANENT_DECIDUOUS = ? ORDER BY TOOTH_NO DESC";
							//If additional Lang_vw object is added to the below query, make sure that the TOOTH_NAME qry from the TOOTH_LANG_VW is retrieved properly
							if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND B.LANGUAGE_ID = ? AND C.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER DESC";
							}else{
								//sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, C.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH  B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE B.TOOTH_NO = C.TOOTH_NO AND C.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
								sql = "SELECT B.TOOTH_NO, B.TOOTH_NAME, B.NS_TOOTH_NO TOOTH_NUM, B.MAPPED_TOOTH_NO, B.PERMANENT_DECIDUOUS FROM OH_TOOTH_LANG_VW  B WHERE B.LANGUAGE_ID = ? AND B.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? ORDER BY B.TOOTH_NO DESC";
							}
							pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
							pstmt.setString(1,locale);
							pstmt.setString(2,tooth_numbering_system);
							pstmt.setString(3,permanent_deciduous_flag);
							rs=pstmt.executeQuery();

							k=32;
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k>=25){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 32){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=32 && k>=30){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 32){//Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
											}

											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 32){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=32 && k>=30){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
			 
													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");	
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
			 
													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");				
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											while(mapped_tooth_no != k){
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");

												k--;
												z--;
											}

											if(k==29 || k==28){//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
		 
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R30.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR30' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
		 
												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
									}
									k--;
								}
								else{
									rs.previous();
									break;
								}
							}
							%>
						</tr></table></td>
					</tr>
				</table></td>
				<td valign="top"><table border="0" cellpadding="1" cellspacing="1" >
					<tr>
						<td><table border="0" cellpadding="0" cellspacing="0"><tr>
						<%
							//LOGIC FOR DISPLAYING LOWER LEFT QUADRANT OF DENTAL CHART
							while(rs.next()){
								tooth_sn = rs.getString("TOOTH_NO");
								tooth_num = rs.getString("TOOTH_NUM");
								tooth_name = rs.getString("TOOTH_NAME");
								mapped_tooth_string = rs.getString("MAPPED_TOOTH_NO");
								if(mapped_tooth_string != null){
									mapped_tooth_no = Integer.parseInt(mapped_tooth_string);
								}
								if(k>=17){
									if(permanent_deciduous_flag.equals("P")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 17){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=17 && k<=19){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
										}
										else if(mixed_dentition_YN.equals("N")){
											if(k == 17){//Remove Images for 3rd Molars(Extreame Teeth)
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

											}
											else{
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"'  border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");
												
											}
											out.println("<tr><td id='check_num"+tooth_sn+"' align='center' ><A  onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

											out.println("<tr onMouseOver='hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
										}
									}
									else if(permanent_deciduous_flag.equals("D")){
										if(mixed_dentition_YN.equals("Y")){
											if(k == 17){
												out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
												
											}
											else if(k!=17 && k<=19){
												out.println("<td id ='decith_table"+tooth_sn+"' align='center'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+ "' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td id='R"+tooth_sn+"' align='center'><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");


												out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

												out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
											}
											else{
												if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','MR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
										}else if(mixed_dentition_YN.equals("N")){
											if(mapped_tooth_no == k){
												if(k==20 || k==21){ //Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R19.gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR19' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
												else{
													out.println("<td id ='decith_table"+tooth_sn+"'><table border='0' cellpadding='1' cellspacing='1'><tr><td id='T"+tooth_sn+"' align='center'><div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td id='R"+tooth_sn+ "' align='center'><div id='rootLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/R" + k + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + k + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div></td></tr>");

													out.println("<tr><td align='center' id='check_num"+tooth_sn+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"></td></tr>");

													out.println("<tr onMouseOver = 'hideToolTip();'><td align='center' height='36' id='"+tooth_sn+"'><table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_sn+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table></td></tr></table></td>");
												}
											}
											else{
												out.println("<td><table border='0' cellpadding='1' cellspacing='1'><tr><td><img src='../../eOH/images/spacer.gif' width='45' height='25'/></td></tr>");

												out.println("<tr><td ><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='20'/></td></tr>");

												out.println("<tr><td><img src='../../eOH/images/spacer.gif' width='45' height='34'/></td></tr></table></td>");
											}
										}
									}
									k--;
								}
								else{
									break;
								}
							}
					%>
						</tr></table></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
	</tr>
		<tr>
		<td><table width="100%" border="1" cellspacing="0" cellpadding="0">
			<tr>
			    <!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="QUADRANT" style="text-align:left" nowrap><table border=0 width="100%"><tr><td id="COLORQ<%=Q4_id%>" class="QUADRANT" style="text-align:left" nowrap><input type="checkbox" name="sel<%=Q4_id%>" id="sel<%=Q4_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q4_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q4_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q4_desc%></A></td><td id="Q<%=Q4_id%>" class="QUADRANT" style="text-align:left" nowrap><a onclick="getDialogFeaturesForNoImage('Q<%=Q4_id%>','<%=Q4_desc%>','QUAD');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="QUADRANT" style="text-align:left" nowrap><table border=0 width="100%"><tr><td id="COLORQ<%=Q4_id%>" class="QUADRANT" style="text-align:left" nowrap><input type="checkbox" name="sel<%=Q4_id%>" id="sel<%=Q4_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q4_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q4_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q4_desc%></A></td><td id="Q<%=Q4_id%>" class="QUADRANT" style="text-align:left" nowrap><table border="0" width="100%" cellspacing="0" cellpadding="3"  onclick="getDialogFeaturesForNoImage('Q<%=Q4_id%>','<%=Q4_desc%>','QUAD');" style='cursor:pointer'><tr><td class="QUADRANT" width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18">&nbsp;</td></tr></table></td></tr></table></td>

				<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="ARCH" style="text-align:center" nowrap><table border=0 width="100%"><tr><td id="COLORAL" class="ARCH" style="text-align:left" nowrap><input type="checkbox" name="selL" id="selL" value="" onclick="setCheckvalForArch(this,'L')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('L');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=lower_arch_desc%></A></td><td id="AL" class="ARCH" style="text-align:left" nowrap><a onclick="getDialogFeaturesForNoImage('AL','<%=lower_arch_desc%>','ARCH');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="ARCH" style="text-align:center" nowrap><table border=0 width="100%"><tr><td id="COLORAL" class="ARCH" style="text-align:left" nowrap><input type="checkbox" name="selL" id="selL" value="" onclick="setCheckvalForArch(this,'L')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('L');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=lower_arch_desc%></A></td><td id="AL" class="ARCH" style="text-align:left" nowrap><table border="0" width="100%" cellspacing="0" cellpadding="3"  onclick="getDialogFeaturesForNoImage('AL','<%=lower_arch_desc%>','ARCH');" style='cursor:pointer'><tr><td class="ARCH" width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18">&nbsp;</td></tr></table></td></tr></table></td>

				<!-- Commented by Sharon Crasta on 12/1/2008 for SCR #6755-->
				<!-- Added a <table> inside <td> so that the hand cursor can be applied to the whole td-->
				<!--<td width="33%" class="QUADRANT" style="text-align:right" nowrap><table border=0 width="100%"><tr><td id="COLORQ<%=Q3_id%>" class="QUADRANT" style="text-align:left" nowrap><input type="checkbox" name="sel<%=Q3_id%>" id="sel<%=Q3_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q3_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q3_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q3_desc%></A></td><td id="Q<%=Q3_id%>" class="QUADRANT" style="text-align:left" nowrap><a onclick="getDialogFeaturesForNoImage('Q<%=Q3_id%>','<%=Q3_desc%>','QUAD');" style='cursor:pointer'>&nbsp;</a></td></tr></table></td>-->

				<td width="33%" class="QUADRANT" style="text-align:right" nowrap><table border=0 width="100%"><tr><td id="COLORQ<%=Q3_id%>" class="QUADRANT" style="text-align:left" nowrap><input type="checkbox" name="sel<%=Q3_id%>" id="sel<%=Q3_id%>" value="" onclick="setCheckvalForQuad(this,'<%=Q3_id%>')" onMouseOver = "hideToolTip();"/>&nbsp;<A onclick = "onMouseClickFunctionArchQuad('<%=Q3_id%>');" onmouseover="this.style.color='blue'" onmouseout = "this.style.color=''" style='cursor:pointer'><%=Q3_desc%></A></td><td id="Q<%=Q3_id%>" class="QUADRANT" style="text-align:left" nowrap><table border="0" width="100%" cellspacing="0" conellpadding="3"  onclick="getDialogFeaturesForNoImage('Q<%=Q3_id%>','<%=Q3_desc%>','QUAD');" style='cursor:pointer'><tr><td class="QUADRANT" width="100%"><img src="../../eOH/images/spacer.gif" height="16.5" width="18">&nbsp;</td></tr><table></td></tr></table></td>

			</tr>
		</table></td>
	</tr>
</table>

<!-- <input type="hidden" name='patientAge' id='patientAge' value=<%//=patientAge%> > -->
<input type="hidden" name='locale' id='locale' value=<%=locale%> >
<input type="hidden" name='patient_id' id='patient_id' value=<%=patient_id%> >
<input type="hidden" name='encounter_id' id='encounter_id' value=<%=encounter_id%> >
<input type="hidden" name='facility_id' id='facility_id' value=<%=facility_id%> >
<input type="hidden" name='Treat_Locn_Type' id='Treat_Locn_Type' value=<%=treat_Locn_Type%> >
<input type="hidden" name='patient_class' id='patient_class' value=<%=patient_class%> >
<input type="hidden" name='chart_type' id='chart_type' value=<%=chart_type%> >
<input type="hidden" name='chart_num' id='chart_num' value=<%=chart_num%> >
<input type="hidden" name='header_tab' id='header_tab' value=<%=header_tab%> >
<input type="hidden" name='show_new_active_yn' id='show_new_active_yn' value=<%=show_new_active_yn%> >
<input type="hidden" name='mixed_dentition_YN' id='mixed_dentition_YN' value=<%=mixed_dentition_YN%> >

<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
<input type = "hidden" name= "location_code" value = "<%=location_code%>">
<input type = "hidden" name= "location_type" value = "<%=location_type%>">
<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">


<input type="hidden" name='tooth_numbering_system' id='tooth_numbering_system' value=<%=tooth_numbering_system%> >
<input type="hidden" name='permanent_deciduous_flag' id='permanent_deciduous_flag' value=<%=permanent_deciduous_flag%> >
<input type="hidden" name="chart_hdr_insert_yn" id="chart_hdr_insert_yn" value="<%=chart_hdr_insert_yn%>">
<input type="hidden" name="called_from_viewchart_yn" id="called_from_viewchart_yn" value="<%=called_from_viewchart_yn%>">
<input type="hidden" name="date_diff_flag" id="date_diff_flag" value="<%=date_diff_flag%>">
<input type = "hidden" name= "decith_yn" value = ""> 
<input type = "hidden" name= "ca_params" value = "<%=request.getQueryString()%>"> 

<!-- These variables are used in the developing Menu -->
<input type="hidden" name="function_id_list" id="function_id_list" value="">		
<input type="hidden" name="function_name_list" id="function_name_list" value="">		
<input type="hidden" name="function_type_list" id="function_type_list" value="">
<input type="hidden" name="function_type_desc_list" id="function_type_desc_list" value="">
<input type="hidden" name="function_cat_code_list" id="function_cat_code_list" value="">

<!-- These variables are for disabling the check Boxes when not applicable -->
<input type="hidden" name="lower_arch_applicable_yn" id="lower_arch_applicable_yn" value="Y">
<input type="hidden" name="upper_arch_applicable_yn" id="upper_arch_applicable_yn" value="Y">

<input type="hidden" name="UR_quadrant_applicable_yn" id="UR_quadrant_applicable_yn" value="Y">
<input type="hidden" name="UL_quadrant_applicable_yn" id="UL_quadrant_applicable_yn" value="Y">
<input type="hidden" name="LR_quadrant_applicable_yn" id="LR_quadrant_applicable_yn" value="Y">
<input type="hidden" name="LL_quadrant_applicable_yn" id="LL_quadrant_applicable_yn" value="Y">

<!-- This param is to clear 'selected_tooth_count' for multi selection on Supernumenary tooth after form submission(after reset) -->
<input type="hidden" name="reset_done" id="reset_done" value="">



<!-- DentalChart Variables -->
<input type="hidden" name="upper_arch_desc" id="upper_arch_desc" value="<%=upper_arch_desc%>">
<input type="hidden" name="lower_arch_desc" id="lower_arch_desc" value="<%=lower_arch_desc%>">
<input type="hidden" name="Q1_id" id="Q1_id" value="<%=Q1_id%>">
<input type="hidden" name="Q2_id" id="Q2_id" value="<%=Q2_id%>">
<input type="hidden" name="Q3_id" id="Q3_id" value="<%=Q3_id%>">
<input type="hidden" name="Q4_id" id="Q4_id" value="<%=Q4_id%>">
<input type="hidden" name="Q1_desc" id="Q1_desc" value="<%=Q1_desc%>">
<input type="hidden" name="Q2_desc" id="Q2_desc" value="<%=Q2_desc%>">
<input type="hidden" name="Q3_desc" id="Q3_desc" value="<%=Q3_desc%>">
<input type="hidden" name="Q4_desc" id="Q4_desc" value="<%=Q4_desc%>">



<input type="hidden" name="baseline_chart_yn" id="baseline_chart_yn" value="<%=baseline_chart_yn%>">
<input type="hidden" name="chart_status_from_view" id="chart_status_from_view" value="<%=chart_status_from_view%>">
<!-- added by parul  for other facility chart CRF#0423 -->
<input type="hidden" name="other_facilitychart_yn" id="other_facilitychart_yn" value="<%=other_facilitychart_yn%>">
<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>">
<!-- Added by Sharon Crasta on 1/11/2010 for IN017822  -->
<input type = "hidden" name= "chart_disable_from_main" value = "<%=chart_disable_from_main%>">
<!-- -->
</form>

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue' >
	<table id='tooltiptable' cellpadding="3" cellspacing=0 border='0' width='100%' align='center' >
		<tr id='tooltiprow'>
			<!-- <td width='100%' id='menu_table' onMouseOver='hideMenuOnOutFocus()'></td> -->
			<td width='100%' id='menu_table'></td>
			</td>
		</tr>
	</table>
</div> 

 <div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue' >
	<table id='tooltiptable1' cellpadding="3" cellspacing=0 border='0' width='100%' align='center' >
		<tr id='tooltiprow1'>
			<td width='100%' id='menu_table1'></td>
			</td>
		</tr>
	</table>
</div> 

	<%
		if(load_images_yn.equals("Y")){
	%>
	<script>
		getAllImagesFromDB();
	</script>
	<%
		}
	%>
</body>
<!--Map for Teeth-->
<map name="MapTUR1" id="MapTUR1">
    <!--Deistal-->
	<area shape="poly" coords="4,6,11,13,11,23,4,30" href="#" />
	<!--Labial/Buccal-->
	<area shape="poly" coords="5,5,39,5,32,12,12,12" href="#" />
	<!--Palatal/Lingual-->
	<area shape="poly" coords="5,31,12,24,32,24,39,31" href="#" />
    <!--Mesial -->
	<area shape="poly" coords="33,13,40,6,40,30,33,23" href="#" />
	<!--Mesio Occlusal-->
	<area shape="rect" coords="13,14,22,23" href="#" />
	<!--Disto Occlusal-->
	<area shape="rect" coords="23,14,32,23" href="#" />
</map>

<!--Map for Upper Right Top Row of Root -->

<map name="MapRUR1" id="MapRUR1">
	<area shape="poly"  coords="13,37,12,31,11,25,15,17,20,9,29,16,29,24,30,27,30,38,26,38,18,38" href="R1" />
</map>

<map name="MapRUR2" id="MapRUR2">
	<area shape="poly" coords="17,14,20,15,17,21,17,31,20,33,20,38,14,39,12,35,12,27" href="#" />
	<area shape="poly" coords="24,13,31,20,32,33,28,39,21,37,21,33,24,23" href="#" />
</map>

<map name="MapRUR3" id="MapRUR3">
	<area shape="poly" coords="23,39,14,39,10,29,9,11,12,8,14,10,16,27,23,33" href="#" />
	<area shape="poly" coords="17,12,21,8,24,13,26,18,28,21,28,26,24,30,19,24,18,21" href="#" />
	<area shape="poly" coords="24,32,28,29,31,25,31,14,34,19,34,28,33,30,33,39,30,39,26,38,24,39" href="#" />
</map>

<map name="MapRUR4" id="MapRUR4">
	<area shape="poly" coords="18,11,22,7,24,10,23,13,23,20,26,27,27,38,21,36,19,36,16,36,16,29,18,16" href="#" />
</map>

<map name="MapRUR5" id="MapRUR5">
	<area shape="poly" coords="20,9,26,13,25,25,27,28,27,27,27,33,27,37,22,37,18,36,16,37,16,23" href="#" />
</map>

<map name="MapRUR6" id="MapRUR6">
	<area shape="poly" coords="16,8,16,29,15,32,15,43,16,42,19,41,20,43,23,43,25,41,27,41,28,37,21,8,18,5" href="#" />
</map>

<map name="MapRUR7" id="MapRUR7">
	<area shape="poly" coords="20,5,20,15,15,30,15,43,17,42,23,42,27,42,29,44,28,38,26,26,26,14,25,9" href="#" />
</map>

<map name="MapRUR8" id="MapRUR8">
	<area shape="poly" coords="13,38,15,29,18,21,22,10,24,11,26,16,28,25,29,32,29,41,25,37,21,40,17,38" href="#" />
</map>

<!--Map for Upper Left Row of Root -->

<map name="MapRUL9" id="MapRUL9">
	  <area shape="poly" coords="13,40,14,28,17,18,19,10,22,10,26,22,28,30,29,34,30,40,25,39,22,40,18,39" href="#" />
</map>

<map name="MapRUL10" id="MapRUL10">
	  <area shape="poly" coords="19,5,22,5,23,14,26,23,28,40,22,42,16,41,15,42,16,19,17,10" href="#" />
</map>

<map name="MapRUL11" id="MapRUL11">
	  <area shape="poly" coords="13,44,18,24,20,11,26,4,28,5,28,28,29,35,30,42,28,44,26,41,21,43" href="#" />
</map>
<map name="MapRUL12" id="MapRUL12">
	  <area shape="poly" coords="16,36,17,27,20,19,21,11,24,9,28,16,28,25,29,32,29,36,22,37" href="#" />
</map>
<map name="MapRUL13" id="MapRUL13">
	  <area shape="poly" coords="15,37,15,28,19,19,18,8,24,8,27,20,27,28,28,32,27,37,25,37,23,38,19,38" href="#" />
</map>
<map name="MapRUL14" id="MapRUL14">
	  <area shape="poly" coords="12,14,9,21,8,27,10,34,10,39,19,39" href="#" />
	  <area shape="poly" coords="20,34,21,38,25,38,29,39,32,34,34,27,35,14,32,8,28,25" href="#" />
	  <area shape="poly" coords="42,26" href="#" />
	  <area shape="poly" coords="21,8,23,9,27,13,24,25,19,31,15,24,18,18,18,16,18,15" href="#" />
</map>

<map name="MapRUL15" id="MapRUL15">
	  <area shape="poly" coords="15,37,12,31,13,19,19,13,22,13,21,24,23,30,25,32,23,35,20,37" href="#" />
	  <area shape="poly" coords="22,9,29,20,28,27,26,33,23,36,28,39,32,35,32,26,28,14,25,10" href="#" />
</map>

<map name="MapRUL16" id="MapRUL16">
      <area shape="poly" coords="12,37,12,29,13,21,14,14,17,9,24,9,29,15,30,21,31,30,32,34,27,34,22,36,17,34" href="#" />
</map>


<!--Map for Lower Right Row of Root -->

<map name="MapRLR32" id="MapRLR32">
<area shape="poly" coords="10,14,14,12,22,12,23,16,22,23,21,30,15,39,11,39,11,28,11,22" href="#" />
<area shape="poly" coords="16,40,23,33,22,29,25,15,26,10,26,9,32,9,32,26,29,31,18,40" href="#" />
</map>

<map name="MapRLR31" id="MapRLR31">
<area shape="poly" coords="12,40,15,40,20,26,20,16,24,14,24,7,18,8,12,9,11,12,11,28" href="#" />
<area shape="poly" coords="23,42,22,35,25,30,25,16,25,8,33,9,32,15,33,24,24,39" href="#" />
</map>

<map name="MapRLR30" id="MapRLR30">
<area shape="poly" coords="8,11" href="#" />
<area shape="poly" coords="9,11,15,12,22,11,22,15,12,38,8,39,9,26,8,25,8,15" href="#" />
<area shape="poly" coords="24,39,28,39,34,26,34,18,33,9,26,9,23,11,24,15" href="#" />
</map>

<map name="MapRLR29" id="MapRLR29">
<area shape="poly" coords="14,8,17,26,18,29,17,33,17,41,24,34,28,19,30,7,27,6,25,6,18,7" href="#" />
</map>

<map name="MapRLR28" id="MapRLR28">
<area shape="poly" coords="15,6,21,6,22,4,26,4,28,5,28,28,28,32,23,42,21,42,18,22,18,24,17,13" href="#" />
</map>

<map name="MapRLR27" id="MapRLR27">
<area shape="poly" coords="15,19,20,33,20,43,22,44,27,31,29,4,26,4,24,5,22,5,17,6" href="#" />
</map>

<map name="MapRLR26" id="MapRLR26">
<area shape="poly" coords="16,10,19,8,24,6,27,7,28,11,25,23,22,40,17,43,17,28" href="#" />
</map>

<map name="MapRLR25" id="MapRLR25">
<area shape="poly" coords="15,15,18,8,23,8,28,7,29,12,20,41,17,43,15,39,16,37,16,25" href="#" />
</map>


<!--Map for Lower Left Row of Root -->

<map name="MapRLL24" id="MapRLL24">
<area shape="poly" coords="14,7,14,19,21,38,26,42,27,41,28,38,27,27,27,22,28,12,25,6,23,9,17,8" href="#" />
</map>

<map name="MapRLL23" id="MapRLL23">
<area shape="poly" coords="17,8,21,9,24,7,27,7,28,8,28,23,27,24,28,36,27,41,24,41,19,29,18,22,17,17,17,12" href="#" />
</map>

<map name="MapRLL22" id="MapRLL22">
<area shape="poly" coords="15,6,18,6,23,7,25,8,28,8,28,8,28,21,25,32,24,42,20,43,16,34,15,28" href="#" />
</map>

<map name="MapRLL21" id="MapRLL21">
<area shape="poly" coords="15,13,17,9,17,7,20,7,22,8,26,9,28,8,28,12,27,20,25,27,23,32,23,39,22,40,20,41,17,34,15,27,15,26" href="#" />
</map>

<map name="MapRLL20" id="MapRLL20">
<area shape="poly" coords="14,10,14,14,20,34,25,39,27,37,27,21,28,19,28,11,23,12,20,9" href="#" />
</map>

<map name="MapRLL19" id="MapRLL19">
<area shape="poly" coords="10,8,13,8,14,9,17,9,18,10,22,10,22,14,18,14,18,31,19,32,18,38,16,39,8,27,8,15" href="#" />
<area shape="poly" coords="22,10,22,15,25,19,26,27,31,38,35,39,35,32,35,28,34,12,32,11,32,10,25,10" href="#" />
</map>

<map name="MapRLL18" id="MapRLL18">
<area shape="poly" coords="10,8,16,8,18,7,19,6,21,10,23,10,23,14,19,15,18,27,22,36,22,39,19,40,11,24,11,14" href="#" />
<area shape="poly" coords="24,10,25,8,29,8,29,7,32,7,33,9,33,12,34,25,32,28,32,39,31,41,24,24,24,13" href="#" />
</map>

<map name="MapRLL17" id="MapRLL17">
<area shape="poly" coords="27,39" href="#" />
<area shape="poly" coords="27,39,17,33,11,24,10,19,10,8,16,8,18,9,19,11,21,11,20,17" href="#" />
<area shape="poly" coords="22,11,25,9,29,8,32,9,33,12,33,23,32,27,31,28,30,37,32,37,27,35,24,28,22,18" href="#" />
</map>

</html>
<%
}catch ( Exception e ) {
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

