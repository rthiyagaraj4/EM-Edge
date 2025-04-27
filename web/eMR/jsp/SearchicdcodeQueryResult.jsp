<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 
%>

<html>
	<head>
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
			<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>

			async function showLongDescription(term_code,term_set_id){
				var dialogHeight= "320px" ;
				var dialogWidth = "350px" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
				await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?term_code="+term_code+"&term_set_id="+term_set_id,"",features);
			}
			function closewindow(Dcode){
				/* window.parent.parent.returnValue=Dcode;
				parent.parent.parent.document.getElementById("dialog_tag").close(); */
				// window.parent.parent.close();
				window.returnValue=Dcode;
				window.close();
				/* parent.parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=Dcode;
				parent.parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.parent.document.querySelectorAll('#dialog_tag').length-1].close(); */
			}
			function scrollTitle(){
				var y = parent.codedesc.document.body.scrollTop;
				if(y == 0){
					parent.codedesc.document.getElementById("divDataTitle").style.position = 'static';
				}else{
					parent.codedesc.document.getElementById("divDataTitle").style.position = 'relative';
					parent.codedesc.document.getElementById("divDataTitle").style.posTop  = y-2;
				}
			}

			function alignWidth(){
					var totalRows =  parent.codedesc.document.getElementById("dataTable").rows.length;
					var counter = totalRows-1;
					var temp = parent.codedesc.document.getElementById("dataTitleTable").rows[0].cells.length;
					for(var i=0;i<temp;i++) {
						parent.codedesc.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.codedesc.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;	
					}
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
			/*
			function alignWidth(){

			var totalRows =  parent.codedesc.document.getElementById("dataTable").rows.length;

			var counter = totalRows-1;
			var temp = parent.TermCodeSearchKWResultFrame.document.getElementById("dataTitleTable").rows(0).cells.length;
			for(var i=0;i<temp;i++) {
			parent.TermCodeSearchKWResultFrame.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.TermCodeSearchKWResultFrame.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;

			}
			}
			*/
			</script>
	</head>

<%	
request.setCharacterEncoding("UTF-8");
StringBuffer sql			= new StringBuffer();
String term_code		= "";
String long_desc		= "";
String short_desc		= "";
String notifiable			= "";
String sensitive			= "";
//String code_indicator = "";
String sensitive_disp	 = "";
String notifiable_disp = "";
String age_spec_ind_val	= "";
String age_spec_ind			= "";
String gender_spec_ind		= "";
String term_set_id				= "";
String select_yn				= "";

Connection conn				= null; 
PreparedStatement stmt   =  null;
ResultSet rs						= null;
PreparedStatement stmt_1  = null;
ResultSet rs_1					= null;
conn		= ConnectionManager.getConnection(request);
boolean toolTip_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS"); 


try{
		String clearPage = request.getParameter("clearResultPage")==null?"":request.getParameter("clearResultPage");
		if(clearPage.equals("y")){
		  /*Below line Added for this incident [IN:040385]*/
		  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		  out.println("<script>parent.frames[0].document.forms[0].Search.disabled = false</script>");			  
          //End this incident [IN:040385]		  
		}
		else{
		String from_code		=	checkForNull(request.getParameter("from_code"));
		String to_code			=	checkForNull(request.getParameter("to_code"));
		String searchby			=	checkForNull(request.getParameter("Search_By"));
		String searchcriteria	=	checkForNull(request.getParameter("Search_Criteria"));
		String searchtext		=	checkForNull(request.getParameter("Search_Text"));
		String sensitive_yn	=	checkForNull(request.getParameter("sensitive_yn"));
		String notifiable_yn	=	checkForNull(request.getParameter("notifiable_yn"));
		String sensitivity_appl_yn =	checkForNull(request.getParameter("sensitivity_appl_yn"));
		String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
		if(sensitivity_appl_yn.equals("N"))
			sensitive_disp = "display:none";
		String notification_appl_yn	=	 checkForNull(request.getParameter("notification_appl_yn"));
		if(notification_appl_yn.equals("N"))
		notifiable_disp	 = "display:none";
		String age_group_appl_yn		=	checkForNull(request.getParameter("age_group_appl_yn"));
		//String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
		String sex	 =	checkForNull(request.getParameter("Sex"));	
		String dob  =	checkForNull(request.getParameter("Dob"));
		//modified on 15-07-08 for SCR 4827
		String title  = checkForNull(request.getParameter("title"));
		if(title.equals("ICD10 Code List")){
			term_set_id =checkForNull(request.getParameter("p_diag_scheme_desc"));
		}else{
			term_set_id =checkForNull(request.getParameter("term_set_id"));
		}
		String code_indicator =checkForNull(request.getParameter("code_indicator"));
		String dagger_independent_yn ="";//Added On 1/23/2010 For SRR-CRF-303.2
		term_set_id	 = term_set_id.trim();
		searchtext		 = searchtext.toUpperCase();
		int i =0;
		if(age_group_appl_yn.equals("Y")){
			//String sql_age_spec_ind = " select case when sysdate-to_date('"+dob+"','dd/mm/yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date('"+dob+"','dd/mm/yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date('"+dob+"','dd/mm/yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
			String sql_age_spec_ind = "SELECT age_group_code from AM_AGE_GROUP where 1 = check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max)and GENDER = ?";
			stmt_1 = conn.prepareStatement(sql_age_spec_ind);
			/*stmt_1.setString(1,dob);
			stmt_1.setString(2,dob);
			stmt_1.setString(3,dob);
			*/
			stmt_1.setString(1,dob);
			stmt_1.setString(2,sex);
			rs_1 = stmt_1.executeQuery();
			while(rs_1.next())
			age_spec_ind_val = rs_1.getString(1);	
			if(age_spec_ind_val==null)
			age_spec_ind_val="";
		}		

		if(rs_1!= null) rs_1.close();
		if(stmt_1!= null) stmt_1.close();

		if(searchby.equals("D")) {
		//Maheshwaran added for the HSA-CRF-0234
		if(diagnosis_by_long_desc_yn.equals("Y"))
		sql.append(" upper(long_desc)  like upper(?)");//Maheshwaran
		else
		sql.append(" upper(short_desc)  like upper(?)");//Maheshwaran
		}
		else 
		sql.append(" upper(term_code)  like upper(?)");

		/*
		if(searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
		else if(searchcriteria.equals("E"))
		sql.append("'%"+searchtext+"'");
		else if(searchcriteria.equals("C"))
		sql.append("'%"+searchtext+"%'");
		*/
		/*	if(sex.equals("F"))
		sql.append(" and GENDER_SPEC_IND = 'F' ");
		else if(sex.equals("M"))
		sql.append(" and GENDER_SPEC_IND = 'M' ");*/

		if(sensitive_yn.equals("Y")) 
		sql.append(" and  SENSITIVE_YN = 'Y' ");
		else if (sensitive_yn.equals("N")) 
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");

		if(notifiable_yn.equals("Y"))  
		sql.append(" and NOTIFIABLE_YN = 'Y'");
		else if (notifiable_yn.equals("N"))  
		sql.append(" and nvl(NOTIFIABLE_YN,'N') ='N'");

		if(!code_indicator.equals("")){
			sql.append(" and  code_indicator = ?");
		}else{
			sql.append(" and ( code_indicator in ('C','D','E','A') or code_indicator is null )");	
		}
		sql.append(" and EFF_STATUS='E'");	
		sql.append(" and LANGUAGE_ID='"+locale+"'");// Language Id is added for IN023648 	

		//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");		


		sql.append(" and TERM_CODE between '"+from_code+"' and '"+to_code+"'");
		//8/20/2009 Free text Recording
		sql.append(" AND FREE_TEXT_YN = 'N'");
		//11/13/2008 MODIFIED FOR EFFSTAUTS
		sql.append(" ORDER BY TERM_CODE ");    
			/*
				The following query was modified for IN023648.
				Modified On:10/5/2010
			*/
		StringBuffer searchKW_sql = new StringBuffer("select TERM_CODE,LONG_DESC,SHORT_DESC,decode(CODE_INDICATOR,'A','Asterisk(*)','D','Dagger(+)','C','Consequence(C)','E','External Cause Indicator(E)')CODE_INDICATOR,decode(SENSITIVE_YN,'Y','Yes','N','No')SENSITIVE_YN,decode(NOTIFIABLE_YN,'Y','Yes','N','No')NOTIFIABLE_YN,AGE_SPEC_IND,GENDER_SPEC_IND,select_yn,DAGGER_INDEPENDENT_YN from MR_D_"+term_set_id+"_LANG_VW  where");// 
		

		stmt = conn.prepareStatement(searchKW_sql.toString()+sql.toString());
		if(searchcriteria.equals("S")) {  
			stmt.setString(1,searchtext+"%");		
		} else if(searchcriteria.equals("E")) {
			stmt.setString(1,"%"+searchtext);		
		} else if(searchcriteria.equals("C")) {
			stmt.setString(1,"%"+searchtext+"%");		
		} 
		if(!code_indicator.equals(""))
		stmt.setString(2,code_indicator);	
		rs = stmt.executeQuery();

		%>
		<body  onScroll='scrollTitle()' onKeyDown='lockKey()'>
			<form name='query_form' id='query_form'>
				<!-- <div id='divDataTitle' style='postion:relative'>
					<table border='1' width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
						
					</table>
				</div> -->
				<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
					<TR>
							<th align='center' width='' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
							<th align='center' width='' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
							<%if(!toolTip_diagnosis){ %>
							<th align='center' width='' nowrap><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
							<%} %>
							<th align='center' width='' nowrap><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
							<%if(notification_appl_yn.equals("Y") || notification_appl_yn.equals("")){%>
							<th align='center' width=''  nowrap><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
							<%}%>
							<%if(sensitivity_appl_yn.equals("Y") || sensitivity_appl_yn.equals("")){%>
							<th align='center' width=''  nowrap><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
							<%}%>
					</tr>
					<%
					String rowclass = "" ;
					String disp_dagger_dep_ind = "" ;
					while(rs.next()){
						if (i%2==0) 
						rowclass = "QRYEVEN" ;
						else	 
						rowclass = "QRYODD" ;
						term_code			= checkForNull(rs.getString("TERM_CODE"));
						long_desc				= checkForNull(rs.getString("LONG_DESC"));
						short_desc			= checkForNull(rs.getString("SHORT_DESC"));
						code_indicator		= checkForNull(rs.getString("CODE_INDICATOR"));
						notifiable				= checkForNull(rs.getString("NOTIFIABLE_YN"));
						sensitive				= checkForNull(rs.getString("SENSITIVE_YN"));
						age_spec_ind		= checkForNull(rs.getString("AGE_SPEC_IND"));
						gender_spec_ind  = checkForNull(rs.getString("GENDER_SPEC_IND"));
						select_yn				= checkForNull(rs.getString("select_yn"));
						dagger_independent_yn	= checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));//Added On 1/23/2010 For SRR-CRF-303.2.
//						out.println("=======1============>" +dagger_independent_yn);
						if(dagger_independent_yn.equals("Y")){
							disp_dagger_dep_ind	="display:inline";
						}else{
							disp_dagger_dep_ind	="display:none";
						}
						out.println("<tr style='background-color:;'>");	
						if(age_group_appl_yn.equals("Y") ){
							//if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("") || age_spec_ind.equals("O")||age_spec_ind.equals("M")||age_spec_ind.equals("C")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
							/*Monday, June 08, 2009 modified for IN011172*/
							if ((gender_spec_ind.equals(sex) || gender_spec_ind.equals("") || sex.equals(""))){
							if(select_yn.equals("Y")){
								out.println("<td class='"+rowclass+"' width='' nowrap><a href=javascript:closewindow('"+term_code+"')>" + term_code +"</a></td>");
							}else{
								out.println("<td class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
							}
							}else{
								out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
							}
						}else{
							if(select_yn.equals("Y"))
								out.println("<td class='"+rowclass+"' width='' nowrap><a href=javascript:closewindow('"+term_code+"')>" + term_code +"</a></td>");
							else
								out.println("<td class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
						}
							/* out.println("<td class='"+rowclass+"' width='' nowrap>");
							out.println(short_desc+"</td>"); */
							if(toolTip_diagnosis){
							out.println("<td class='" + rowclass + "' width='' nowrap " +
						            "onMouseOver=\"Tip(longDescToolTip('" + term_code + "','" + long_desc + "'))\" " +
						            "onMouseOut=\"UnTip()\">");
						out.println(short_desc + "</td>");
							}else{
								 out.println("<td class='"+rowclass+"' width='' nowrap>");
								out.println(short_desc+"</td>"); 
								
							}
						if(!toolTip_diagnosis){
						if(!short_desc.equals(long_desc)){
							//out.println("<td class='"+rowclass+"' align='center' width='' nowrap><a href=javascript:showLongDescription(\""+java.net.URLEncoder.encode(long_desc)+"\") ><b>!</b></a></td>");
							out.println("<td class='"+rowclass+"' align='center' width='' nowrap><a href=javascript:showLongDescription(\""+java.net.URLEncoder.encode(term_code)+"\",\""+java.net.URLEncoder.encode(term_set_id)+"\") ><b>!</b></a></td>");
						}else{
							out.println("<td class='"+rowclass+"' width='' nowrap>&nbsp;</td>");
						}  
						out.println("<td class='"+rowclass+"' width='' nowrap>"+code_indicator+" &nbsp;<img src='../../eCommon/images/mandatory.gif' style='"+disp_dagger_dep_ind+"'>&nbsp;</td>");
						out.println("<td class="+rowclass+" style='"+notifiable_disp+"' width='' nowrap>"+notifiable+"&nbsp;</td>");
						out.println("<td class="+rowclass+" style='"+sensitive_disp+"' width='' nowrap>"+sensitive+"&nbsp;</td>");
						out.println("</tr>");
						i++;
					}
					if(i==0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();	
				%>
					<tr style='visibility:hidden'>
						<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
						<%if(notification_appl_yn.equals("Y") || notification_appl_yn.equals("")){%>
						<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
						<%}%>
						<%if(sensitivity_appl_yn.equals("Y") || sensitivity_appl_yn.equals("")){%>
						<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
						<%}%>

					</tr>
				</table>
			</form>
			<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eOT/js/wz_tooltip.js'></script>
		</body>
	</html>
		<script>
		alignWidth();
		parent.frames[0].document.forms[0].Search.disabled=false;
		</script>

		<%}

}
catch(Exception e)
{
//out.println("Exception is  "+e.toString());
e.printStackTrace();
}
finally	
{
if(conn!=null)
ConnectionManager.returnConnection(conn,request);
}
%>
<%!
public static String checkForNull(String inputString)
{
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

