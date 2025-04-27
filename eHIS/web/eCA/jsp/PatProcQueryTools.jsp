<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<% 	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCA/js/procedures.js" ></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
		Connection con=null;
		PreparedStatement pstmt=null;		
		ResultSet rset=null;		
		String applied="";
		String rec_exist="";		
		String modify = "";
		String sql="";
		String Encounter_Id=request.getParameter("Encounter_Id");
		
		String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
		String viewErrButton = request.getParameter("viewErrButton")==null?"N":request.getParameter("viewErrButton");
		String errorModify=request.getParameter("errorModify")==null?"N":request.getParameter("errorModify");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	
		String resp_id = (String)session.getValue("responsibility_id");
		String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		String facilityid = (String) session.getValue("facility_id");

		try
		{
			con=ConnectionManager.getConnection(request);
	
			sql="SELECT GET_TASK_APPLICABILITY('MARK_PROC_ERROR',NULL,?,?,?,?,?), nvl((SELECT 'Y' FROM pr_encounter_procedure WHERE PATIENT_ID=? AND ERROR_YN='Y' AND ROWNUM=1),'N') ERR_EXIST, GET_TASK_APPLICABILITY('MOIDFY_PROCEDURE',NULL,?,?,?,?,?) FROM DUAL";
					
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,resp_id);
			pstmt.setString(2,reln_id);
			pstmt.setString(3,facilityid);
			pstmt.setString(4,Encounter_Id);
			pstmt.setString(5,patient_id);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,resp_id);
			pstmt.setString(8,reln_id);
			pstmt.setString(9,facilityid);
			pstmt.setString(10,Encounter_Id);
			pstmt.setString(11,patient_id);
			rset=pstmt.executeQuery();

			if (rset.next())
			{
				applied = rset.getString(1);
				rec_exist = rset.getString(2);
				modify = rset.getString(3);			
			}

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();		
		}

		catch(Exception e)
		{
			//out.println("Exception "+e.toString());//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);

		}
%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='Proc_toolForm' id='Proc_toolForm'>
	<br>
		<table border='0' width='100%' cellpadding='3' cellspacing='0'>
         <tr>
			<%	
			if(viewErrButton.equals("Y"))
				rec_exist="Y";
				
				if(applied!=null && applied.equals("A"))
				{ 
					if (rec_exist.equals("Y")) 
					{
			%>
						<td align='left'>
 						<input type='button' name='btnView' id='btnView' onclick="showErrorList();" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")%>"  class='button'></td>
			<%
					}
				}
			%>

				<td align='right'> 
					<input type="button" class='Button' name="cannedText" id="cannedText" title='Canned Text' onclick="return canTextValue();" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CannedText.label","ca_labels")%>">
				
			<%	
				if(applied!=null && applied.equals("A"))
				{ 
					if(errorModify.equals("Y")) 
					{ 
			%>
						<input type='button'  name='error' id='error' onclick="markError()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")%>">					
			<%
					}
				}
			%>
			<input type="button" class='Button' name="record_button" id="record_button" title='Record' onclick="apply()" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>">
			<input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> " onclick="clearform('<%=modal_yn%>')">
			<!-- <input type="button" class='Button' name="cancel_button" id="cancel_button" title='Cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>"  onclick="cancel_a('<%=modal_yn%>')"> --></td>
		</tr>
        </table>
		<%
			
			if(mode.equals("update"))
			{
				if(modify.equals("A"))
				{
		%>
					<script>
						
						var msg = getLabel('Common.Modify.label','COMMON');	
		                //alert("msg"+msg);
						document.forms[0].record_button.title = msg;
						document.forms[0].record_button.value = msg;
						
						
					</script>
		<%
				}
				else
				{
		%>
					<script>
						document.forms[0].record_button.style.display = 'none';
						document.forms[0].cannedText.style.display = 'none';
						

					</script>
		<%
				}
			}
		%>
		<input type="hidden" name="objName" id="objName"   value=''>
		<input type="hidden" name="Encounter_Id" id="Encounter_Id"   value='<%=Encounter_Id%>'>
		<input type="hidden" name="patient_id" id="patient_id"   value='<%=patient_id%>'>
		<input type="hidden" name="mode" id="mode"   value='<%=mode%>'>
		<input type="hidden" name="viewErrButton" id="viewErrButton"   value=''>
		
	</form>
</body>
</html>

