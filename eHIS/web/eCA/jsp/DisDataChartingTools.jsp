<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name      		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
03/06/2014	  	IN037701		Chowminya		 								SKR-CRF-0036
18/06/2014		IN049742		Chowminya		 								Alpha	CRF linked
12/08/2014		IN050523		Vijayakumar K					Ramesh G		PA - PAS -  ICN - OP-OP Transaction -Manage Patient Queue -
																				Record Vital Signs - Script error is displaying
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
			String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script><!--IN050523 moved to line no 29 from 32-->
		<script src='../../eCA/js/DisDataCharting.js' language='javascript'></SCRIPT>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<!--<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
--><!--IN050523 commented-->
		</head>

	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<%
			String qs = request.getQueryString();

			String facilityid = (String) session.getValue("facility_id");
			String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			String amerepMode = request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
			String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
			String replaceMode = request.getParameter("replaceMode")== null?"":request.getParameter("replaceMode");
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String resp_id = (String)session.getValue("responsibility_id");
			String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
			String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
			String called_from		=	request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");//IN037701
			String battey_id		=	request.getParameter("battey_id")==null?"":request.getParameter("battey_id");//IN037701
			String applied="";
			String rec_exist="";
			String newIns="";
			Connection con = null;
			PreparedStatement pstmt1=null;
			PreparedStatement  pstmt=null;
			ResultSet rs1=null;
			ResultSet rs=null;

			try{
				con = ConnectionManager.getConnection(request);

				/////
				
				String sql1= "select 1 from ca_encntr_discr_msr where FACILITY_ID=? and ENCOUNTER_ID   =? and rownum=1";
				 pstmt1=con.prepareStatement(sql1);
				pstmt1.setString(1,facilityid);
				pstmt1.setString(2,episodeid);
				 rs1 = pstmt1.executeQuery();
				if(rs1.next()){
					newIns="Y";
				}

				String sql="SELECT GET_TASK_APPLICABILITY('MARK_VITAL_ERROR',NULL,?,?,?,?,?), nvl((SELECT 'Y' FROM CA_ENCNTR_DISCR_MSR WHERE PATIENT_ID=? AND ERROR_YN='Y' AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";

			 pstmt=con.prepareStatement(sql);

				pstmt.setString(1,resp_id);
				pstmt.setString(2,reln_id);
				pstmt.setString(3,facilityid);
				pstmt.setString(4,episodeid);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,patient_id);
				 rs=pstmt.executeQuery();

				if (rs.next()){
					applied=rs.getString(1);
					rec_exist=rs.getString(2);
				}
				if( rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();
			}catch ( Exception e){
				//out.println("Error " +e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}finally {
						if(con!=null)ConnectionManager.returnConnection(con,request);
					}
    %>
			<form name="F" id="F">
			    <table cellpadding=3 cellspacing=0 width="100%">
			    <tr>
					<%if(module_id.equals("")){%>
					<td align=left>

    <%				
						if(applied!=null && applied.equals("A")){
									if(!amendMode.equals("Y") && !replaceMode.equals("Y") && newIns.equals("Y")){%>
								<input type='button' name='btnAmeRep' id='btnAmeRep' onclick="ameRep();" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AmendError.label","ca_labels")%>"  class='button'>
									<%}

									if (rec_exist.equals("Y")) {%>
										<input type='button' name='btnView' id='btnView' onclick="showErrorList();" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")%>"  class='button'></td>
									<%}
						}
					}
    %>

			       <td align=right>
						<!-- IN037701 Start-->
			     		<% if ("CA_SPC".equals(called_from)){
							//IN049742 Added if condition Start	
							if("Y".equals(newIns)){%>
								<input type='button' name='add' id='add' onclick="discrete_add('<%=battey_id%>');"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels")%>" class='button'>
							<% } //IN049742 End %>	
								<input type='button' name='record' id='record' onclick="apply('<%=module_id%>');" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  class='button'>
								<input type='button' name='reset' id='reset' onclick="resetFormSPC('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class='button'>
				     			<input type='button' name='cancel' id='cancel' onclick="cancelform('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
						<% } %>
						<!--IN037701 end-->
						<% if (replaceMode.equals("Y")){ %>
								<input type='button' name='upd' id='upd' onclick="update();"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>"  class='button'>
						<% } %>
						<!-- IN037701 Added if condition Start-->
						<% if(!"CA_SPC".equals(called_from)){
						if (!replaceMode.equals("Y")){ %>
								<input type='button' name='record' id='record' onclick="apply('<%=module_id%>');" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  class='button'>
						<% } 
						}%>
						
						<% if(!"CA_SPC".equals(called_from)){
						if (amerepMode.equals("N")){ %>
									<input type='button' name='reset' id='reset' onclick="resetForm('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class='button'>
									<input type='button' name='cancel' id='cancel' onclick="cancelform('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
						<%}else{ %>
									<input type='button' name='cancel' id='cancel' onclick="cancelform1('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
						<%}
						}%>
						<!-- IN037701 Added if condition End-->
					</td>
				</tr>
			    </table>

				<input type='hidden' name='query_string' id='query_string' value='<%=qs%>'>
			 	 <input type=hidden name=patient_id value='<%=patient_id%>'>
			 	 <input type=hidden name=module_id value='<%=module_id%>'>
				 
		</form>
	</body>
</html>

