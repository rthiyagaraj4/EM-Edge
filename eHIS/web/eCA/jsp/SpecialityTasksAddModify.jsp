<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCA/js/SpecialityTasks.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
  <%	
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  try
  {
			con								= ConnectionManager.getConnection(request);
			String mode=request.getParameter("mode");
			String readOnlyAttribute=null;
			String sp_module_id="";
			String sp_module_name="";
			String sp_taskcode="";
			String sp_taskdesc="";
			String sp_tasktype="";
			String sp_exname="";
			String sp_actncode="";
			String sp_actndesc="";
			String flag ="disabled";
			String fixedflag ="disabled";
			if(mode.equals("MODIFY")){
			readOnlyAttribute	= "READONLY";
			String md_sql="SELECT SPLTY_TASK_CODE,B.MODULE_NAME,SPLTY_TASK_DESC,SPLTY_TASK_TYPE,EXECUTABLE_NAME,ACTION_CODE,(CASE SPLTY_TASK_TYPE WHEN 'NT' THEN (SELECT NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE NOTE_TYPE=A.ACTION_CODE) WHEN 'NG' THEN (SELECT NOTE_GROUP_DESC FROM CA_NOTE_GROUP WHERE NOTE_GROUP=A.ACTION_CODE) WHEN 'CT' THEN(SELECT TASK_DESC FROM CA_PAT_TASK_LIST WHERE TASK_CODE=A.ACTION_CODE) ELSE NULL END) ACTION_DESC,A.MODULE_ID FROM CA_SPLTY_TASKS A ,SM_MODULE B  WHERE A.MODULE_ID=B.MODULE_ID and UPPER(SPLTY_TASK_CODE) like UPPER(?)";
			pstmt   = con.prepareStatement(md_sql.toString());
			pstmt.setString(1,request.getParameter("sptask_code"));
			rset=pstmt.executeQuery();
			while(rset!=null && rset.next()){
				sp_taskcode=(rset.getString(1)==null)?"":rset.getString(1);
				sp_module_name=(rset.getString(2)==null)?"":rset.getString(2);
				sp_taskdesc=(rset.getString(3)==null)?"":rset.getString(3);
				sp_tasktype=(rset.getString(4)==null)?"":rset.getString(4);
				sp_exname=(rset.getString(5)==null)?"":rset.getString(5);
				sp_actncode=(rset.getString(6)==null)?"":rset.getString(6);
				sp_actndesc=(rset.getString(7)==null)?"":rset.getString(7);
				sp_module_id=(rset.getString(8)==null)?"":rset.getString(8);
				if(sp_tasktype.equals("CT")||sp_tasktype.equals("NG")||sp_tasktype.equals("NT"))
					flag="enabled";
				if(sp_tasktype.equals("FX"))
				fixedflag="enabled";
				}
			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();

			}
			String sql_module="select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
			pstmt   = con.prepareStatement(sql_module.toString());
			rset = pstmt.executeQuery();


   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='calldis()'>
	 <form name="specialitytaskform" id="specialitytaskform" action="../../servlet/eCA.SpecialityTasksServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		<td class="label"  width='30%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<%if(mode.equalsIgnoreCase("INSERT")){%>
		<td class="field" width='50%'><select name="module_id" id="module_id" <%=readOnlyAttribute%> >
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%
		 while(rset!=null && rset.next()){
		 out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		if(rset!=null)  rset.close();
		if(pstmt!=null)  pstmt.close();
		%>
		</select>
		<%}else{%>
		<td class="field" width='50%'><input type='text' name="module_name" id="module_name" value='<%=sp_module_name%>' maxLength='6' size='6' <%=readOnlyAttribute%>>
		<input type='hidden' name='module_id' id='module_id' value='<%=sp_module_id%>' >
		<%}%>
		<img src='../../eCommon/images/mandatory.gif' ></img>
		</td>
	    </tr>
		<tr>
		<td class='label'  width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="sptask_code" id="sptask_code" value='<%=sp_taskcode%>' maxLength='6' size='6' <%=readOnlyAttribute%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
		<tr>
		<td class='label'  width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="sptask_descrptn" id="sptask_descrptn" value='<%=sp_taskdesc%>' maxLength='30' size='30'><img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
	    <tr>
		<td class="label"  width='30%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class="field" width='50%'><select name="sptask_type" id="sptask_type" <%=readOnlyAttribute%> onchange='typeset(this)'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='FX' <%if(sp_tasktype.equals("FX")){%>selected<%}%>><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
		<option value='NT' <%if(sp_tasktype.equals("NT")){%>selected<%}%>><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
		<option value='NG' <%if(sp_tasktype.equals("NG")){%>selected<%}%>><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></option>
		<option value='CH' <%if(sp_tasktype.equals("CH")){%>selected<%}%>><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></option>
		<option value='CT' <%if(sp_tasktype.equals("CT")){%>selected<%}%>><fmt:message key="eCA.ClinicianAccessTasks.label" bundle="${ca_labels}"/></option>
		<option value='HD' <%if(sp_tasktype.equals("HD")){%>selected<%}%>><fmt:message key="Common.Header.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	    </tr>
		<td class='label'  width='30%'><fmt:message key="eSM.Executable.label" bundle="${sm_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="sptask_exectable" id="sptask_exectable" value='<%=sp_exname%>' maxLength='30' size='30' <%=fixedflag%> ></td>
		</tr>
		<input type='hidden' name='actn_code' id='actn_code' value='<%=sp_actncode%>' >
		<td class='label'  width='20%'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
		<td class='field'  width='30%'><input type='text' name="actn_code_desc" id="actn_code_desc" value='<%=sp_actndesc%>' maxLength='30' onblur='if(this.value!="")getactioncode(this,actn_code);' size='30'  <%=flag%> ><input type='BUTTON' class='BUTTON' name='action_butn' id='action_butn' value='?' onclick='getactioncode(actn_code_desc,actn_code)' <%=flag%> ></td>
		</tr>
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >
		     <input type='hidden' name='mod_id_val' id='mod_id_val' value='' >				 
		     <input type='hidden' name='sptask_code_val' id='sptask_code_val' value='' >	
		     <input type='hidden' name='sptask_desc_val' id='sptask_desc_val' value='' >	
		     <input type='hidden' name='sptask_type_val' id='sptask_type_val' value='' >	
		     <input type='hidden' name='sptask_extbl_val' id='sptask_extbl_val' value='' >	
		     <input type='hidden' name='sptask_actn_val' id='sptask_actn_val' value='' >	
	 </form>
    </body>

<%
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();

} catch(Exception e){
	//out.println(e.toString());//common-icn-181
	e.printStackTrace();//COMMON-ICN-0181
	}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

