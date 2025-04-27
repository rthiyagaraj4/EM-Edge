<!DOCTYPE html>
<!-- 
	Created 
		on 12/14/2010
		For Retunin 
		Function :Procedure Code For Practitioner
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap ,eCommon.XSSRequestWrapper"%>
 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale			= checkForNull((String)session.getAttribute("LOCALE")); 
	String link_by		= checkForNull(request.getParameter("link_by")); 
	String link_code	= checkForNull(request.getParameter("link_code")); 
	String specialty		= checkForNull(request.getParameter("specialty")); 
	String search_by			= checkForNull(request.getParameter("search_by")); 
	String search_criteria		= checkForNull(request.getParameter("search_criteria"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String RESULT_QRY="";
	String desc_criteria="";
	String splty_criteria="";
	
	if(search_criteria.equals("S")){
		desc_criteria=search_by+"%";
	}else if(search_criteria.equals("E")){
		desc_criteria="%"+search_by;
	}else if(search_criteria.equals("C")){
		desc_criteria="%"+search_by+"%";
	}
	

	if(link_by.equals("PROC_CODE")){
		if(!specialty.equals("")){
			splty_criteria=" AND A.PRIMARY_SPECIALITY_CODE=?";
		}
		RESULT_QRY="SELECT  DISTINCT A.PRACTITIONER_ID CODE,A.PRACTITIONER_NAME SHORT_DESC,A.SHORT_NAME,(SELECT NVL(EFF_STATUS,'N')  FROM OA_PRACT_PROC_LINK WHERE PRACTITIONER_ID=A.PRACTITIONER_ID AND PROC_CODE =? AND PROC_CODING_SCHEME=?) STATUS FROM AM_PRACTITIONER_LANG_VW A WHERE  A.EFF_STATUS='E' AND UPPER(A.PRACTITIONER_NAME) LIKE UPPER(NVL(?,A.PRACTITIONER_NAME)) AND A.EFF_STATUS='E' "+splty_criteria+" ORDER BY SHORT_DESC";
	}else{
		RESULT_QRY="SELECT DISTINCT A.TERM_CODE CODE,A.LONG_DESC, A.SHORT_DESC ,(SELECT NVL(EFF_STATUS,'N') FROM OA_PRACT_PROC_LINK WHERE PRACTITIONER_ID=? AND PROC_CODING_SCHEME=A.TERM_SET_ID AND PROC_CODE=A.TERM_CODE) STATUS FROM MR_D_"+term_set_id+"_LANG_VW A WHERE A.TERM_SET_ID=? AND A.EFF_STATUS='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(NVL(?,A.SHORT_DESC)) ORDER BY SHORT_DESC";
	}

%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/ProcCodeforPractitioner.js'></script>
		<!-- in below line only one line added by VenkateshS (4008) on 23 /july/2012 -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	</head>
	<!-- in below line  this method only  "onKeyDown = lockKey()"  added by VenkateshS (4008) on  23/july/2012  -->
   <body onload="paintDesc()" onKeyDown = 'lockKey()'>
	
		<form name="Proccode_For_Pract_Result_Form" id="Proccode_For_Pract_Result_Form" action='../../servlet/eOA.ProccodeforpractitionerServlet' method="post" target='messageFrame'>
		<%
			try{
					con=ConnectionManager.getConnection(request);
					%>
						<table border='0' width='30%' cellpadding='0' cellspacing='0' id="paint_data_tab">
							<tr>
								<td class='PANELTOOLBAR' id='paint_desc' nowrap></td>
							</tr>
						</table>
						<div  id="scroll_div" style="position:relative;height:500px;width:1010px;overflow:auto;" >
						<table border=0 width="100%" cellpadding='0' cellspacing='0' id="data_tab">
							<thead id="TabHead">
							<tr style="position:relative;top:expression(this.offsetParent.scrollTop)" >
								<th align='left'>Practitioner</th>
								<th align='center' >Select All&nbsp;<input type='checkbox' name="select_all" id="select_all" value='N' onclick="selectAll(this)"></th>
							</tr>
								<%
										String status="";
										String box_status="";
										pstmt=con.prepareStatement(RESULT_QRY);
										pstmt.setString(1,link_code);
										pstmt.setString(2,term_set_id);
										pstmt.setString(3,desc_criteria);
										if(!specialty.equals("") && link_by.equals("PROC_CODE") ){
											pstmt.setString(4,specialty);
										}
										rs=pstmt.executeQuery();
										int i=0;
										String classValue="";
										String linking_code="";
										String display_desc="";
										while(rs.next()){
												linking_code= checkForNull(rs.getString("CODE"));
												display_desc= checkForNull(rs.getString("SHORT_DESC"));
												status=checkForNull(rs.getString("STATUS"));
												if(status.equals("Y")){
													box_status="checked";
												}else{
													box_status="";
												}	
											if(i%2==0){
												classValue="QRYEVENSMALL";
											}else{
												classValue="QRYODDSMALL";
											}
											%>
											<tr>
												<td class=<%=classValue%>>
													<%=display_desc%>
													<input type='hidden' name="linking_code_<%=i%>" id="linking_code_<%=i%>" value='<%=linking_code%>'>
												</td>
												<td class=<%=classValue%> align='center'>
													<input type='checkbox' name="linking_box_<%=i%>" id="linking_box_<%=i%>" value='<%=linking_code%>' <%=box_status%> onclick="setValue(this,'<%=i%>')">
												</td>
											<tr>
										<%i++;}%>
						</table>
						<input type='hidden' name='total_num' id='total_num' value="<%=i%>"/>
						<%
								if(i==0){%>
									<SCRIPT LANGUAGE="JavaScript">
									<!--
												document.getElementById("paint_data_tab").style.display="none";
												document.getElementById("data_tab").style.display="none";
												alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
									//-->
									</SCRIPT>		
							<%}
						%>
					</div>
			<%}catch(Exception ex){
				//System.out.println("Exception-@-proccodeforpractitioner_result.jsp=>"+ex);
				ex.printStackTrace();
			}
			finally{
				ConnectionManager.returnConnection(con,request);	
			}
		%>

		<input type='hidden' name='final_linked_codes' id='final_linked_codes' value=""/>
		<input type='hidden' name='final_unlinked_codes' id='final_unlinked_codes' value=""/>
		<input type='hidden' name='code_to_be_link' id='code_to_be_link' value="<%=link_code%>"/>
		<input type='hidden' name='term_set_id' id='term_set_id' value="<%=term_set_id%>"/>
		<input type='hidden' name='link_by' id='link_by' value="<%=link_by%>"/>
		<input type='hidden' name='db_linked_codes' id='db_linked_codes' value=""/>
		<SCRIPT LANGUAGE="JavaScript">
		<!--
			buildDBValues();
		//-->
		</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		</form>
	</body>
</html>
<%!	
	private String checkForNull(String inputString){
	return (inputString==null)	? "" : inputString;
}
	private String checkForNull(String inputString, String defaultValue){
	return (inputString==null)	? defaultValue : inputString;
}

%>

