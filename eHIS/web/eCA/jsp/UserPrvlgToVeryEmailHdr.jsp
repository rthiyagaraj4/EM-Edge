<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>
<head>
 <%
 eCA.UserPrvlgToVeryEmailBean UserPrvlgToVeryEmailBean = null;

UserPrvlgToVeryEmailBean = (eCA.UserPrvlgToVeryEmailBean)getObjectFromBean("UserPrvlgToVeryEmailBean","eCA.UserPrvlgToVeryEmailBean",session);
UserPrvlgToVeryEmailBean.clearBean();
    request.setCharacterEncoding("UTF-8");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			// added by Ambiga.M  on 02/02/2009 
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
			//ends here 
		 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/UserPrvlgToVeryEmail.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String sql_module_id="";
	String sql_module_name="";
	String sql="";
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="UserPrvlgToVeryEmailHdrForm" id="UserPrvlgToVeryEmailHdrForm" action="" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding='5' width='95%' align='center'>
	<tr>
		<td>
			<table border=0 cellspacing=0 cellpadding='5' width='95%' align='center'>
				<tr>
					<td class='label' align='right' width='10%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
					<td class='fields' width='35%'><select name='module_id' id='module_id'  onchange='populateReportId(this)'><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			<%
			try {
											
				con = ConnectionManager.getConnection(request);
				sql="select module_id,module_name from sm_module where install_yn='Y' and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_module.module_id) order by 2 ";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while( rs != null &&  rs.next())
				{
					sql_module_id = rs.getString( "module_id" ) ;
					sql_module_name = rs.getString( "module_name" ) ;
					out.println("<option value='"+sql_module_id+"'>"+sql_module_name+"</option>");  
				}
				if( rs != null )  rs.close();
				if( stmt != null )  stmt.close();
											
			} catch(Exception e) {				
				e.printStackTrace();
			}finally { 
				ConnectionManager.returnConnection(con,request);
			}
			%>
					</select><img src='../../eCommon/images/mandatory.gif' ></img></td>

					<td class=label width='14%'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
					<td class='fields'  ><select name='report_id' id='report_id' ><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					</select><img src='../../eCommon/images/mandatory.gif' ></img></td>
				</tr>
			</table>
			<table border=0 cellspacing=0 cellpadding='5' width='95%' align='center'>
				<tr>
					<td  class='label' width='45%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> &nbsp;<input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="Common.username.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="Common.userid.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class='fields' width='14%'>&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name="search_criteria" id="search_criteria">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' width='41.5%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="search_text" id="search_text" size='30' maxlength='8' value=""></td>
					<td  colspan='2' align='right'><input type='button' class='button' onclick="populateFormVals()" value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>"></td>					
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- added by Ambiga.M  on 02/02/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
</form>
</body>
</html>
<%putObjectInBean("UserPrvlgToVeryEmailBean",UserPrvlgToVeryEmailBean,session);%>

