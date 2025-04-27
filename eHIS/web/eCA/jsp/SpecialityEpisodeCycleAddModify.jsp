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
  <script language='javascript' src='../../eCA/js/SpecialityEpisodeCyccle.js'></script>
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
			String spepisodemodid="";
			String spepisodemodname="";
			String spepisodedesc="";
			String spepisodeevntdesc="";
			String  disabled="";
			if(mode.equals("MODIFY")){
				disabled="disabled";
			readOnlyAttribute	= "READONLY";
			String md_sql="SELECT B.MODULE_NAME,SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC,A.MODULE_ID FROM CA_SPLTY_EPISODE_CYCLE A ,SM_MODULE B  WHERE A.MODULE_ID=B.MODULE_ID and UPPER (A.MODULE_ID) LIKE(?)";
			pstmt   = con.prepareStatement(md_sql.toString());
			pstmt.setString(1,request.getParameter("episode_mod_id"));
			rset=pstmt.executeQuery();
			while(rset!=null && rset.next()){
				spepisodemodname=(rset.getString(1)==null)?"":rset.getString(1);
				spepisodedesc=(rset.getString(2)==null)?"":rset.getString(2);
				spepisodeevntdesc=(rset.getString(3)==null)?"":rset.getString(3);
				spepisodemodid=(rset.getString(4)==null)?"":rset.getString(4);
				//sp_exname=(rset.getString(5)==null)?"":rset.getString(5);
				//sp_actncode=(rset.getString(6)==null)?"":rset.getString(6);
				//sp_actndesc=(rset.getString(7)==null)?"":rset.getString(7);
				//sp_module_id=(rset.getString(8)==null)?"":rset.getString(8);
				/*if(sp_tasktype.equals("CT")||sp_tasktype.equals("NG")||sp_tasktype.equals("NT"))
					flag="enabled";
				if(sp_tasktype.equals("FX"))
				fixedflag="enabled";*/
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

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	 <form name="specialityepisodeform" id="specialityepisodeform" action="../../servlet/eCA.SpecialityEpisodeCycleServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		<td class="label"  width='30%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<%if(mode.equalsIgnoreCase("INSERT")){%>
		<td class="field" width='50%'><select name="module_id" id="module_id"  >
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
		<td class="field" width='50%'><input type='text' name="module_name" id="module_name" value='<%=spepisodemodname%>' maxLength='6' size='6'  <%=disabled%>>
		<input type='hidden' name='module_id' id='module_id' value='<%=spepisodemodid%>' >
		<%}%>
		<img src='../../eCommon/images/mandatory.gif' ></img>
		</td>
	    </tr>
		<tr>
		<td class='label'  width='30%'><fmt:message key="eCA.EpisodeDescription.label" bundle="${ca_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="spepsd_desc" id="spepsd_desc" value='<%=spepisodedesc%>' maxLength='40' size='40'><img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
	  	<td class='label'  width='30%'><fmt:message key="eCA.EventTitleDescription.label" bundle="${ca_labels}"/></td>
		<td class='field'  width='50%'><input type='text' name="spevnt_desc" id="spevnt_desc" value='<%=spepisodeevntdesc%>' maxLength='40' size='40'><img src='../../eCommon/images/mandatory.gif' ></td>
		</tr>
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >
		     <input type='hidden' name='mod_id_val' id='mod_id_val' value='' >				 
		     <input type='hidden' name='spepisode_desc_val' id='spepisode_desc_val' value='' >	
		     <input type='hidden' name='spevnt_desc_val' id='spevnt_desc_val' value='' >	
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

