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
  <script language='javascript' src='../../eCA/js/SpecialityOutcome.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
  <%	
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 ResultSet rs					    = null;
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  try
  {
			con								= ConnectionManager.getConnection(request);
			String mode=request.getParameter("mode");
			String readOnlyAttribute=null;
			String md_module_id="";
			String md_module_name="";
			String md_outcomecode="";
			String md_outcomedesc="";
			String md_outcometype="";
			String selecte="";
			String selecto="";
			String selecta="";
			String agegroupDes="";
			String agegroupCode="";
			String sql="";
			String disabled="";
			if(mode.equals("MODIFY")){
				disabled="disabled";
			readOnlyAttribute	= "READONLY";
			String md_sql="SELECT OUTCOME_CODE,MODULE_NAME,OUTCOME_DESC,OUTCOME_TYPE,A.MODULE_ID,AGE_GROUP FROM CA_SPLTY_OUTCOME A,SM_MODULE B where UPPER(OUTCOME_CODE) LIKE UPPER(?) and A.MODULE_ID=B.MODULE_ID";
			pstmt   = con.prepareStatement(md_sql.toString());
			pstmt.setString(1,request.getParameter("outcome_code"));
			rset=pstmt.executeQuery();
			while(rset!=null && rset.next()){
				md_outcomecode=rset.getString(1);
				md_module_name=rset.getString(2);
				md_outcomedesc=rset.getString(3);
				md_outcometype=rset.getString(4);
				md_module_id=rset.getString(5);
				agegroupCode=rset.getString(6);
				}
			if(rset!=null)
				rset.close();
			if(pstmt!=null)
				pstmt.close();
			if(md_outcometype!=null){
			if(md_outcometype.equals("E"))
				selecte="selected";
			else if(md_outcometype.equals("O"))
				selecto="selected";
			}
			else
				selecta="selected";
			
			try{
			 
		     sql = "Select   SHORT_DESC  from  AM_AGE_GROUP where AGE_GROUP_CODE=?";
		     pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,agegroupCode);
		     rs = pstmt.executeQuery();
			 if(rs.next())
			 agegroupDes=rs.getString("SHORT_DESC");
			 if(rs != null) rs.close();
		     if(pstmt != null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
			}
			String sql_module="select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
			pstmt   = con.prepareStatement(sql_module.toString());
			rset = pstmt.executeQuery();
				
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="specialityoutcomeform" id="specialityoutcomeform" action="../../servlet/eCA.SpecialityOutcomeServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		<td class="label"  width='30%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<%if(mode.equals("INSERT")){%>
		<td class="field" width='50%'><select name="module_id" id="module_id" <%=readOnlyAttribute%> <%=disabled%> >
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
		<td class="field" width='50%'><input type='text' name="module_name" id="module_name" value='<%=md_module_name%>' maxLength='6' size='6' <%=readOnlyAttribute%> <%=disabled%>>
		<input type='hidden' name='module_id' id='module_id' value='<%=md_module_id%>' >
		<%}%>
		<img src='../../eCommon/images/mandatory.gif' ></img>
		</td>
	    </tr>
		<tr>
		<td class='label'  width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="outcome_code" id="outcome_code" value='<%=md_outcomecode%>' maxLength='6' size='6' <%=readOnlyAttribute%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)" <%=disabled%>><img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
		<tr>
		<td class='label'  width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="descrptn" id="descrptn" value='<%=md_outcomedesc%>' maxLength='30' size='30' <%=disabled%>><img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
		<tr><td class='label' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
			<td class='fields'>
							<input type ='hidden' name='agegroupCode' id='agegroupCode' value='<%=agegroupCode%>'>
<input type ='text' name='agegroupDes' id='agegroupDes' size='20'   value="<%=agegroupDes%>" onblur="getageGroup1(this,agegroupDes)"><input type ='Button' class='button' name='buttonAgeGrp' id='buttonAgeGrp' value='?' Onclick='getageGroup()' ><img src="../../eCommon/images/mandatory.gif" align="center" ></td>
		</tr>
		<!--<tr>
		<td class="label"  width='30%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class="field" width='50%'><select name="type" id="type" <%=readOnlyAttribute%> <%=disabled%>>
		<option value=''<%=selecta%>>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<option value='E' <%=selecte%>><fmt:message key="Common.Event.label" bundle="${common_labels}"/></option>
		<option value='O' <%=selecto%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	    </tr>-->	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >
		     <input type='hidden' name='module_id_val' id='module_id_val' value='' >				 
		     <input type='hidden' name='outcome_code_val' id='outcome_code_val' value='' >	
		     <input type='hidden' name='descrptn_val' id='descrptn_val' value='' >	
		     <input type='hidden' name='type_val' id='type_val' value='' >	
	 </form>
    </body>

<%
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();

} catch(Exception e){
	//out.println(e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
	}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

