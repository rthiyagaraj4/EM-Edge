<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.RecordDiagnosis RecordDiagnosisBean = (eCA.RecordDiagnosis)getObjectFromBean("RecordDiagnosisBean","eCA.RecordDiagnosis",session);
%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		// added by Arvind @  07-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintDiag.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
//String sql ="";
//String srl_nos ="";
//String flag_vals ="";


//String complaint_id = request.getParameter("complaint_id");
RecordDiagnosisBean.clearAllRecord();

Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;
	try
	{	
    	con	= ConnectionManager.getConnection();
%>
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
     <form name="ChiefComplaintDiagSearchfrm" id="ChiefComplaintDiagSearchfrm" >
	<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
	<tr><td class='COLUMNHEADER' width='100%' colspan='8'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>
	<tr>
	<td align="right" class="label"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/> &nbsp</td>
	<td align="left">
		<select name='term_set' id='term_set'>
			<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			<%				   
                 String sqlpop2 = "SELECT TERM_SET_ID,TERM_SET_DESC FROM  MR_TERM_SET ORDER BY 2";
		          String term_set_id="";
		          String term_set_desc="";
		          stmt= con.prepareStatement(sqlpop2);
		          rs = stmt.executeQuery();
		          while(rs!=null && rs.next())
		            {
			           term_set_id = rs.getString("TERM_SET_ID") == null ? "" : rs.getString("TERM_SET_ID");
			           term_set_desc = rs.getString("TERM_SET_DESC") == null ? "" : rs.getString("TERM_SET_DESC");	
			           out.println("<option value='"+term_set_id+"'>"+term_set_desc+"</option>"); 		
		            }
	
		       %>
		</select><img src='../../eCommon/images/mandatory.gif'></td>	
	<td align="right" class="label"><fmt:message key="Common.TermSetDescription.label" bundle="${common_labels}"/>  &nbsp</td>
	<td class='fields'><input type='text' name='term_desc' id='term_desc' size='20' maxlength='20' value=""></input> </td>	
	
	 <td align="left" class='fields'><select name='search_criteria' id='search_criteria'>
			    <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			    <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			    <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>  	                 
			   </select>
	<input type='button' name='search' id='search' class='Button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="SearchDetails()"> </input></td>
</tr>
</table>
<!-- added by arvind @ 07-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->

<%
   if(rs!=null)  rs.close(); 
   if(stmt!=null)  stmt.close();
  }
  catch(Exception e){
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
	            e.printStackTrace();//COMMON-ICN-0181
	 }finally	{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}	
%>	
</form>
</body>
</html>


