<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/rowcolor.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../js/rowcolor.js' language='javascript'></script>
		
		<!-- <script src='../js/PatProblem.js' language='javascript'></SCRIPT> -->
	</head>
	<% 
	String Diag_code="";
	String gender_spec_ind = "";
	String age_spec_ind = "";
	String select_yn	= "";
	%>

	<script>
		function closew(Diagcode){
			//window.parent.parent.parent.returnValue=Diagcode;
			if(parent.parent.parent.document.getElementById("dialog_tag")){
				window.parent.parent.returnValue=Diagcode;
				const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");
				//const dialogTag = parent.parent.parent.parent.document.getElementById("dialog_tag");
				dialogTag.close();    
			} else {
				//window.parent.parent.parent.returnValue=Diagcode;
				window.parent.parent.parent.returnValue=Diagcode;
				const dialogTag = parent.parent.parent.parent.document.getElementById("dialog_tag");
				//const dialogTag = parent.parent.parent.parent.document.getElementById("dialog_tag");
				dialogTag.close();  
			}
			
		}
		async function showLongDescription(diagcode,term_set_id){
			var dialogHeight= "90vh" ;
			var dialogWidth = "69vw" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
			await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?term_code="+diagcode+"&term_set_id="+term_set_id,"",features);
		}
		
		function longDescToolTip(term_code, long_desc) {
		    var tab_data = "<td class='label'>" + term_code + "</td>";
		    var tab_data2 = "<td class='label'>" + long_desc + "</td>";
		    var final_table = "<table border='0' cellpadding='0' cellspacing='0' align='center'>" + 
		                      "<tr>" + 
		                      tab_data + 
		                      tab_data2 + 
		                      "</tr></table>";
		    return final_table;
		}	
	</script>
	</head>
	<% 
	String Diag_code="";
	String gender_spec_ind = "";
	String age_spec_ind = "";
	String select_yn	= "";
	%>
	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
		<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet rset=null;
		String Diag_desc			="";
		String diagcode				= checkForNull(request.getParameter("p_diag_code"));
		String diagdesc				= checkForNull(request.getParameter("p_diag_scheme_desc"));
		String authorize				= checkForNull(request.getParameter("p_auth_yn"));
		String DiagGcode			= checkForNull(request.getParameter("Diag_code"));
		String cause_indicator	= checkForNull(request.getParameter("cause_indicator"));
		String search_by			= checkForNull(request.getParameter("Search_By"));
		String notifiable_yn		= checkForNull(request.getParameter("opt_notifiable"));
		String search_criteria		= checkForNull(request.getParameter("Search_Criteria"));
		String sensitive_yn		= checkForNull(request.getParameter("sensitive_yn"));
		String search_text			= checkForNull(request.getParameter("Search_Text"));
		String term_set_id			= checkForNull(request.getParameter("term_set_id"));
		String sex						= checkForNull(request.getParameter("Sex"));
		String dob						= checkForNull(request.getParameter("Dob"));
		String p_code_indicator =checkForNull(request.getParameter("code_indicator"));
		String function_id			= checkForNull(request.getParameter("function_id"));
		String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
		String long_description  ="";
		String searchcondition   ="";
		String notifiable_value	="";
		String sensitive_value	="";
		//out.println("<script>alert(\""+request.getQueryString()+"\")</script>");
		search_text = search_text.toUpperCase();
		if(cause_indicator==null)
		cause_indicator	 ="";
		searchcondition	 ="";
		//out.println("--------"+searchcondition);
		//out.println("----search_criteria----"+search_criteria);
		/*
		1.For below condition was added 1/18/2010 for IN018218;
		2.search_criteria is null because Other than this function CustomICDQueryFrames.jsp are used.
		3. In above Frames they are maintaining the Search Criteria.
		*/
		search_text=search_text.replaceAll("'","''");
		if(function_id.equals("ca_diagnosis")){
			if(search_by.equals("D")){
				if (search_criteria.equals("S")) {		
					if(diagnosis_by_long_desc_yn.equals("Y"))	
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('"+search_text+"%')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('"+search_text+"%')";
				} else if (search_criteria.equals("E")) {
					if(diagnosis_by_long_desc_yn.equals("Y"))
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('%"+search_text+"')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('%"+search_text+"')";
				} else if (search_criteria.equals("C"))	{
					if(diagnosis_by_long_desc_yn.equals("Y"))
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('%"+search_text+"%')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('%"+search_text+"%')";
				}	
			}else{
				if (search_criteria.equals("S")) {			
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('"+search_text+"%')";
				} else if (search_criteria.equals("E")) {
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('%"+search_text+"')";
				} else if (search_criteria.equals("C"))	{
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('%"+search_text+"%')";
				}	
			}
		}
		if(sensitive_yn.equals("Y")){
			searchcondition = searchcondition + " and  b.SENSITIVE_YN = 'Y' ";
		}else if(sensitive_yn.equals("N")){
			searchcondition = searchcondition + " and nvl(b.SENSITIVE_YN, 'N') = 'N'";
		}
		if (notifiable_yn.equals("Y")){
			searchcondition = searchcondition + " and b.notifiable_yn = 'Y'";
		}else if(notifiable_yn.equals("N")){
			searchcondition = searchcondition + " and nvl(b.notifiable_yn, 'N') = 'N'";
		}
		String from	= request.getParameter( "from" ) ;
		String to		= request.getParameter( "to" ) ;
		int start = 0 ;
		int end = 0 ;
		int i=1;
//		int maxRecord=0;
		if ( from == null ){
			start = 1 ;
		}else{
			start = Integer.parseInt( from ) ;
		}
		if ( to == null ){
			end = 14 ;
		}else{
			end = Integer.parseInt( to ) ;
		}
		try{
			/*
				The following query was modified for IN023648 
				Modified On:10/5/2010
			*/
			conn = ConnectionManager.getConnection(request);
			//Added by Ajay Hatwate for ML-MMOH-CRF-1940
			boolean toolTip_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS"); 
			
			StringBuffer sql = new StringBuffer("select a.term_code,c.short_desc,c.long_desc,b.notifiable_yn,b.sensitive_yn ,c.age_spec_ind, c.gender_spec_ind,c.code_indicator,c.select_yn from mr_term_group_dtl a , mr_term_Code b ,  mr_d_"+term_set_id+"_lang_vw c where a.term_group_id ='"+DiagGcode+"'  and  a.term_set_id='"+term_set_id+"'   and a.term_set_id = b.term_set_id and a.term_code = b.term_code  and a.term_set_id = c.term_set_id and a.term_Code = c.term_code and c.language_id='"+locale+"' ");
			if(p_code_indicator.equals("")){
				//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");	
				sql.append(" and ( code_indicator in ('C','D','A','E') or code_indicator is null )");//Modified by Dharma on 23rd Oct 2017 against ML-MMOH-SCF-0833 [IN:065389]
			}else{
				sql.append(" and code_indicator = '"+p_code_indicator+"'");
			}
			if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals(""))){
				sql.append(" and ( c.gender_spec_ind = '"+sex+"' OR c.gender_spec_ind IS NULL OR nvl(c.age_spec_ind,'O')='O' ) ");
			}
			sql.append(searchcondition);
			if(search_by.equals("D")){
				sql.append("  order by ORDER_SRL_NO");//Added by shanmukh on 12th-Jun-2018 for ARYU-SCF-0114
			}else{
				sql.append("  order by term_code");
			}
			stmt = conn.createStatement();
			rset=stmt.executeQuery(sql.toString());
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			rset.next() ;
			String rowclass="";
			int maxRecords=0;
			while (rset.next()&& i<=end ){
					if(maxRecords==0){%>
							<P>
								<table align='right'>  <!--below Search_By value pass against ML-MMOH-SCF-0852 by mano-->
									<tr>
										<td>
											<%
											if ( !(start <= 1) )
											out.println("<A HREF='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+p_code_indicator+"&from="+(start-14)+"&to="+(end-14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator="+cause_indicator+"&Search_Criteria="+search_criteria+"&Search_By="+search_by+"&Sex="+sex+"&Dob="+dob+"&function_id="+function_id+"' text-decoration='none' id='previous'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
											out.println("<A HREF='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+p_code_indicator+"&from="+(start+14)+"&to="+(end+14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator=	"+cause_indicator+"&Search_Criteria="+search_criteria+"&Search_By="+search_by+"&Sex="+sex+"&Dob="+dob+"&function_id="+function_id+"'  text-decoration='none' id='next' style='display:none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
											%>
										</td>
									</tr>
								</table>
									<br>
									<br>
							</p>
							<table width='100%' border='1' cellspacing='0' cellpadding='2' id='tb1'>
								<th align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
								<th align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
								<%if(!toolTip_diagnosis){ %>
									<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
								<%} %>
								<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
								<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
								<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
								<%}
								if (i%2==0){
									rowclass="QRYEVEN";
								}else{
									rowclass="QRYODD";
								}
								Diag_code			=rset.getString("term_code");
								Diag_desc			=rset.getString("short_desc");
								long_description	=rset.getString("long_desc");
								if(toolTip_diagnosis){
									long_desc_1 = long_description;
								}
								long_description	=java.net.URLEncoder.encode(long_description);
								notifiable_value	=rset.getString("notifiable_yn");
								sensitive_value		= rset.getString("sensitive_yn").trim();
								p_code_indicator	= rset.getString("code_indicator")==null?"":rset.getString("code_indicator");
								gender_spec_ind	= rset.getString("gender_spec_ind")==null?"":rset.getString("gender_spec_ind");
								age_spec_ind		= rset.getString("age_spec_ind")==null?"":rset.getString("age_spec_ind");
								select_yn				= rset.getString("select_yn")==null?"N":rset.getString("select_yn");
								p_code_indicator = (p_code_indicator.equals("D")?"Dagger(+)":(p_code_indicator.equals("C")?"Consequence(C)":(p_code_indicator.equals("E")?"External Cause Indicator(E)":(p_code_indicator.equals("A")?"*":"&nbsp;"))));
								out.println("<tr style='background-color:;' >");
								if(select_yn.equals("Y")){
									out.println("<td class='"+rowclass+"'><a href=javascript:closew('"+Diag_code+"')>" + Diag_code + "</a></td>");
								}else{
									out.println("<td class='"+rowclass+"'>" + Diag_code + "</td>");
								}
								
/* 								System.out.println(toolTip_diagnosis+" : toolTip_diagnosis " +Diag_code+" Diag_code "+long_desc_1+" long_desc_1 "); */
								//Added by Ajay Hatwate for ML-MMOH-CRF-1940
								if(toolTip_diagnosis){
								out.println("<td  class='"+rowclass+"' onMouseOver=\"Tip(longDescToolTip('"+Diag_code+"', '"+long_desc_1+"'))\" onMouseOut=\"UnTip()\" >");
								out.println(Diag_desc+"</td>");
								}else{
									out.println("<td  class='"+rowclass+"'>");
									out.println(Diag_desc+"</td>");									
								}
								if(!toolTip_diagnosis){
									if (!Diag_desc.equals(long_description)){
										//out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + long_description + "\"); ><b>!</b></a></td>");
										out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + Diag_code + "\",\"" + term_set_id + "\"); ><b>!</b></a></td>");
									}else{
										out.println("<td class="+rowclass+">&nbsp;</td>");
									}
								}
								out.println("<td class='"+rowclass+"'>");
								out.println(notifiable_value.equals("Y")?"Yes":"No"+"</td>");
								out.println("<td class='"+rowclass+"'>");
								out.println(sensitive_value.equals("Y")?"Yes":(sensitive_value.equals("N")?"No":"&nbsp;")+"</td>");
								out.println("<td class='"+rowclass+"' align = center>");
								out.println(p_code_indicator+"</td>");
								out.println("</tr>");
								i++;
								maxRecords++;
								}//End Of While
								if(maxRecords==0){%>
									<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script LANGUAGE="JavaScript">
										alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));			
									</SCRIPT>
								<%}
								if ( maxRecords<14 || (!rset.next()) ) {%>
								<script >
									if (document.getElementById("next")){
										document.getElementById("next").style.display='none';
									}
								</script>
								<%
								} else {%>
									<script >
										if (document.getElementById("next")){
											document.getElementById("next").style.display='inline';
										}
									</script>
								<%}
								if(rset != null) rset.close();
								if(stmt != null )stmt.close();
								%>
				</table>
		<%
		}catch  (Exception e) {
				e.printStackTrace();
		} finally {
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		%>
	<script language='javascript' src='../../eOT/js/wz_tooltip.js'></script>
	</body>
	<SCRIPT LANGUAGE="JavaScript">
		if(parent.searchframe != null)
		parent.searchframe.document.radio.Search.disabled = false;
	</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>
<%!
public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

