<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	 <%
 		eCA.PatientBannerGroupLine usrPrvlgBean = null;

		usrPrvlgBean = (eCA.PatientBannerGroupLine)getObjectFromBean("usrPrvlgBean","eCA.PatientBannerGroupLine",session);
		usrPrvlgBean.clearBean();

		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE") == null ? "en" : (String) p.getProperty("LOCALE");

		// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String noteType = "";
		String noteDesc = "";
		String chkEmailOpt = "";
		
		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement("select 1 from CA_APPL_TASK where appl_task_id='EMAIL_DATA' ");

			res = ps.executeQuery();
			while(res.next())
			{
				chkEmailOpt = res.getString("1") == null ? "" : res.getString("1");				
			}
			if(res != null) res.close();
			if(ps != null) ps.close();
		}
		catch(Exception e)
		{
			
			//out.println("Exception at try of UserPrvlgToPrintAndEMailDetails.jsp -"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(res != null) res.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
						

	 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCA/js/UserPrvlgToPrintAndEMail.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onKeyDown='lockKey()'>
		<form name='usrPrvlgDetailForm' id='usrPrvlgDetailForm'>
			<table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
				<tr>
					<td class='label' width='11%'>
						<fmt:message key='eCA.PrivilegeFor.label' bundle='${ca_labels}'/>
					</td>
					<td class='label'>
						<select name='privilegeFor' id='privilegeFor'>
							<option value='P'><fmt:message key='Common.print.label' bundle='${common_labels}'/></option>
							<%if (chkEmailOpt.equals("1")) { %>
								<option value='E'><fmt:message key='eCA.EMail.label' bundle='${ca_labels}'/></option>
							<%}%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td class='label' width='18%'>
						<fmt:message key='eCA.PatientMedicalReport.label' bundle='${ca_labels}'/>
					</td>
					<td class='fields' width='30%'> <input type="Text" name="txtPatMedReport" id="txtPatMedReport" value = "" size="25" OnKeyPress='return CheckForSpeChar(event)' Onblur='getData(this)'><input type="hidden" name ="patMedicalReport" value=""><input type='button' class='button' name='buttonCategory' id='buttonCategory' value='?' OnClick='populateReportsLookup()'><img src='../../eCommon/images/mandatory.gif'></img></td> 


					<!--<td>
						<select name='patMedicalReport' id='patMedicalReport'> 
						<option value=''>----<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>----</option>
						<%
							try
							{
								con = ConnectionManager.getConnection(request);
								ps = con.prepareStatement("select a.note_type note_type,a.note_type_desc note_desc from  ca_note_type  a ,ca_note_group b where b.note_group = a.NOTE_GROUP_ID and b.APPL_TASK_ID='PAT_MEDICAL_REPORT' and a.EFF_STATUS = 'E' ");

								res = ps.executeQuery();
								while(res.next())
								{
									noteType = res.getString("note_type") == null ? "" : res.getString("note_type");
									noteDesc = res.getString("note_desc") == null ? "" : res.getString("note_desc");
									out.println("<option value='"+noteType+"'>"+noteDesc+"</option>");
								}
								if(res != null) res.close();
								if(ps != null) ps.close();
							}
							catch(Exception e)
							{
								
								//out.println("Exception at try of UserPrvlgToPrintAndEMailDetails.jsp -"+e.toString());//COMMON-ICN-0181
								e.printStackTrace();
							}
							finally
							{
								if(res != null) res.close();
								if(ps != null) ps.close();
								if(con != null) ConnectionManager.returnConnection(con,request);
							}
						%>
						</select><img src='../../eCommon/images/mandatory.gif'>
					</td> -->
				</tr>
				
<!-- 					<td class='label'><fmt:message key='Common.responsibility.label' bundle='${common_labels}'/>
					</td>
					<td class='label' colspan='2'>
					<input type='text' name='respDesc' id='respDesc'><input type='button' class='button' value='?' onclick='getResponsibility()'><img src='../../eCommon/images/mandatory.gif'>
					</td> -->

<!--shaiju-->
				
				<tr>
					<td  class='label' width='20%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td><td class='fields' width='30%'><input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class='label' width='25%'>&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
						<select name="search_criteria" id="search_criteria">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' width='20%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td><td class='fields' width='30%'>&nbsp;<input type="text" name="search_text" id="search_text" size='30' maxlength='8' value=""></td>
				<!--	<td  colspan='2' align='right'><input type='button' class='button' onclick="populateFormVals()" value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>"></td>					
				</tr> -->

<!--shaiju-->

					
					
					<td align='right' colspan='2'><input type='button' class='button' value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>" onclick='loadPractNames()'>
					</td>
				</tr>
			</table>
			<!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
			<input type='hidden' name='respId' id='respId' value=''>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		</form>
	</body>
</html>

