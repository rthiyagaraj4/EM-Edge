<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");

	Connection conn=null;
	Statement stmt = null;
	ResultSet rset=null;	
	PreparedStatement pstmt=null;

	String m_name="";
	String codeTextAttribute="";
	String fun_id="";
	String fun_name="";
	String sql="";
	String m_id="";
	String sel="";
	String dis="";
	String code="", name="",eff_status="",Contents_types="";
	String module_id="";
	String Function_id="";
	String operation= request.getParameter( "operation" ) ;
//	String sum_id="";
//	String sum_name="";
//	String classValue="";
	String check_eff="";
	//String menu_id="";
	//String menu_name="";
	String summary_type="N";
	String summ_clin="";
	String summ_non_clin="checked";
	String summ_half="";
	String summ_full="checked";
	String summary_area="F";
	String option_id="";
	String long_desc="";
	String other_read_only="";
	String disableval="";

	int cnt=0;
//	int i=0;


	 try {
		conn = ConnectionManager.getConnection(request);
		stmt= conn.createStatement();

		if ( operation == null ) operation="insert";
		code=request.getParameter("Desktop_code");
		if ( code == null ) code="";
		name=request.getParameter("Desktop_name");
		if ( name == null ) name="";
		eff_status =request.getParameter("eff_status");
		if ( eff_status == null )
			eff_status="E";
		Contents_types=request.getParameter("Contents_types");
		if ( Contents_types == null ) Contents_types="";
			module_id=request.getParameter("module_id");
		if ( module_id == null ) module_id="";
			Function_id=request.getParameter("Function_id");
		if ( Function_id == null ) Function_id="";
		
		
		if(eff_status.equals("E")){
			check_eff="checked";
		}
		if(eff_status.equals("D")){
		  other_read_only="readonly";
			check_eff="";
			disableval = "disabled";
		}
						
		if ( operation.equalsIgnoreCase( "modify" )) {
			codeTextAttribute="disabled";
			codeTextAttribute="readonly";
			// sql = "select  desktop_code, desktop_name,desktop_layout_type,content_type,module_id,function_id,eff_status from sm_desktop_setup where  desktop_code ='"+code+"'order by 1" ;
			 sql = "select h.DESKTOP_SUMMARY_ID desktop_code ,h.DESKTOP_SUMMARY_NAME desktop_name,h.DESKTOP_LAYOUT_TYPE desktop_layout_type, h.DFLT_CONTENT_TYPE content_type,h.DFLT_MODULE_ID module_id,h.DFLT_FUNCTION_ID function_id ,h.EFF_STATUS eff_status,h.DESKTOP_SUMMARY_TYPE,h.DESKTOP_SUMMARY_AREA from SM_DESKTOP_SUM_HDR h where h.DESKTOP_SUMMARY_ID=? " ;
			 pstmt = conn.prepareStatement( sql);
			 pstmt.setString(1,code);
			 rset = pstmt.executeQuery() ;
			 if (rset !=null&& rset.next()){
				code = rset.getString(1);
				name = rset.getString(2);
				Contents_types = rset.getString(4);
				module_id = rset.getString(5);
				Function_id = rset.getString(6);
				eff_status = rset.getString(7);
				summary_type = rset.getString(8);
				summary_area = rset.getString(9);
			 }
			
			if(summary_type.equals("C"))
			{
				summ_clin="checked";
				summ_non_clin="";
			}
			else
			{
				summ_clin="";
				summ_non_clin="checked";
			}

			if(summary_area.equals("H"))
			{
				summ_half="checked";
				summ_full="";
			}
			else
			{
				
				summ_half="";
				summ_full="checked";
			}

			if(eff_status.equals("E")){
				check_eff="checked";
			}
			if(eff_status.equals("D")){
			  other_read_only="readonly";
				check_eff="";
				disableval = "disabled";
			}
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();

		
	%>

	<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eSM/js/CreatUserDesktop.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'> 
	<form name="CreateDesktop_form" id="CreateDesktop_form">
	<BR>
	<div  align="left">
	<table border="0" cellpadding="3" cellspacing="0" width='98%' align='center'>
		<!--<tr>
			<td width="25%" class="label" >&nbsp;</td>
			<td width="30%" class="label" >&nbsp;</td>
			<td width="30%"  class="label">&nbsp;</td>
		</tr> -->
		<tr>
			<td width="25%" class="label"><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields">
				<input type="text" onKeyPress="return CheckForSpecChars(event)"  name="Desktop_code" id="Desktop_code" value='<%=code%>' <%=codeTextAttribute%> size="10" maxlength="10" onBlur="ChangeUpperCase(this) "><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td width="25%" class="label" >&nbsp;</td>
			<td width="25%"  class="label">&nbsp;</td>
		</tr>
		<!--<tr class="label">
			<td width="40%" class="label">&nbsp;</td>
			<td width="60%" colspan="2" class="label">&nbsp;</td>
		</tr>-->
		<tr>
			<td width="25%" class="label"><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td width="25%"  class="fields"><input type="text" onBlur='makeValidString(this)' name="Desktop_name" id="Desktop_name" <%=other_read_only%> value='<%=name%>' size="30" maxlength="50"><img src='../../eCommon/images/mandatory.gif'></img></td>
			<td width="25%" class="label" >&nbsp;</td>
			<td width="25%"  class="label">&nbsp;</td>
		</tr>
		<!--<tr class="label">
			<td width="40%" class="label">&nbsp;</td>
			<td width="60%" colspan="2" class="label">&nbsp;</td>
		</tr>-->
		<tr>
			<td width="25%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width="25%"  class="fields"><input type="checkbox" name="eff_status" id="eff_status" value='<%=eff_status%>' onclick='check_eff(this)' <%=check_eff%>/></td>
			<td width="25%" class="label" >&nbsp;</td>
			<td width="25%"  class="label">&nbsp;</td>
			
		<!--	<td width="30%"  class="label"><input type="radio" name="clin_rad" id="clin_rad" id='clinician' class="label" value="C" <%=summ_clin%> onclick='setClinrad(this);' >Clinician&nbsp;<input type="radio" name="clin_rad" id="clin_rad" id='nonClinician' class="label" value="N" <%=summ_non_clin%> onclick='setClinrad(this);'>Non&nbsp;Clinician&nbsp;</td>-->
		
		</tr>

	<!--	<tr>
			<td class="COLUMNHEADER" colspan=3><b><fmt:message key="eSM.SelectContentsLayout.label" bundle="${sm_labels}"/></b></td>
		</tr>

		<tr class="label">
			<td width="40%" class="label">&nbsp;</td>
			<td width="60%" colspan="2" class="label">&nbsp;</td>
		</tr> -->
		<tr>
				<td class='label' width='25%'><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Type.label" bundle="${sm_labels}"/></td>
				<td width="25%"  class="label"><input type="radio" name="clin_rad" id="clin_rad" class="label" <%=disableval%> value="C" <%=summ_clin%> onclick='setClinrad(this);' ><fmt:message key="Common.Clinician.label" bundle="${common_labels}"/>&nbsp;<input type="radio" name="clin_rad" id="clin_rad" <%=disableval%>  class="label" value="N" <%=summ_non_clin%> onclick='setClinrad(this);'>&nbsp;<fmt:message key="eSM.Non.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.Clinician.label" bundle="${common_labels}"/>&nbsp;</td>

				<td width="25%" class="label" >&nbsp;</td>
				<td width="25%"  class="label">&nbsp;</td>

			</tr>
			<tr>
				<td class='label' width='25%'><fmt:message key="eSM.Show.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="eSM.Summary.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>
				<td width="25%"  class="label"><input type="radio" name="menu_rad" id="menu_rad"  class="label" value="H" onclick='setMenurad(this);' <%=summ_half%> <%=disableval%> >50%&nbsp;<input type="radio" name="menu_rad" id="menu_rad"  class="label" value="F"  onclick='setMenurad(this);' <%=summ_full%> <%=disableval%> >100%</td>

				<td width="25%" class="label" >&nbsp;</td>
				<td width="25%"  class="label">&nbsp;</td>

			</tr>

		<tr> 
			<td class=label  width="25%" ><fmt:message key="eSM.ContentType.label" bundle="${sm_labels}"/></td>
			<td class="fields" width='25%'>
				<select name="Contents_types" id="Contents_types"   disabled>
					<option value='F' selected  ><fmt:message key="Common.Function.label" bundle="${common_labels}"/>
					</option>
				</select>
			</td>
			<td width="25%" class="label" >&nbsp;</td>
			<td width="25%"  class="label">&nbsp;</td>
		</tr>

	 <!-- <tr>
		<td width="25%" class="label">&nbsp;</td>
		<td width="25%" class="label">&nbsp;</td>
	  </tr>-->
	  <tr>
		<%if(summary_type.equals("C"))dis="disabled";%>
		<td width="25%" class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>

		   <td class="fields" width='25%'><select name="module_id" id="module_id" OnChange='Getvalues(this)' <%=dis%> <%=disableval%>>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
			
						try{						
						   sql="select module_id, module_name from sm_module where module_id in (select distinct module_id from sm_function where desktop_appl_yn = 'Y') order by module_name ";
						  
							pstmt=conn.prepareStatement(sql);
							rset=pstmt.executeQuery();
							if(summary_type.equals("C"))%>
							   <option value='CA' selected>Clinician Access</option>
							<%if(rset!=null){
								while(rset.next()){
									m_id=rset.getString("module_id");
									m_name=rset.getString("module_name");
									   if(m_id.equals(module_id))
											sel="selected";
								%>
						
										<option value='<%=m_id%>' <%=sel%>><%=m_name%></option>
										<% sel="";
								}
							}
							
							%>			
							<% 

						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();	
							
					}catch(Exception e) {
						out.println("desktopcode"+e);
						e.printStackTrace();
					}
	  %>

		</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>

		<INPUT TYPE="hidden" name="Module_Name" id="Module_Name" value="">
		 <td width="10%" colspan ='2' class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/>&nbsp;<!--</td>-->

		<!-- <td class="fields" width='30%'>-->
		<%if(operation.equals("insert")){%>
		   <select name="Function_id" id="Function_id"   >
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			</select>
		 <%} else {%>
			 <select name="Function_id" id="Function_id" <%=disableval%> >
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

			 <%try{
						if(summary_type.equals("C"))
						{
							pstmt=conn.prepareStatement("select OPTION_ID,long_desc from ca_option where DESKTOP_YN='Y' AND OPTION_TYPE='F' and OPEN_IN_MODAL_WINDOW_YN='N' order by 2");
							rset=pstmt.executeQuery();
							while(rset.next())
							{
								 option_id=rset.getString("OPTION_ID");
								 long_desc=rset.getString("long_desc");
								 if(option_id.equals(Function_id))
									  sel="selected";
						 %>
								 <option value='<%=option_id%>'<%=sel%>><%=long_desc%></option>;
								 <%sel="";
								 
							}
						}else{
							 pstmt=conn.prepareStatement("select function_id, function_name from Sm_Function where module_id='" + module_id + "'  and desktop_appl_yn='Y'  order by  function_name");
							rset=pstmt.executeQuery();
								 while(rset.next())
									{		 
										fun_id=rset.getString("function_id");
										fun_name=rset.getString("function_name");
									   if(fun_id.equals(Function_id))
														sel="selected";
												%>			
									<option value='<%=fun_id%>'<%=sel%>><%=fun_name%></option>;				
												<% sel="";
									}
						}
						if(pstmt != null) pstmt.close();
						if(rset != null) rset.close();
						if(stmt != null) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			} 
		}
			
				 %>
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	 <script>
	var function_id="<%=fun_id%>";
	var module_id="<%=m_name%>";

	</script>
		</td>
	  
		<INPUT TYPE="hidden" name="function_name" id="function_name" value="<%=operation%>">
		 </tr>
		 
		 </table>
	<%
}catch(Exception e){
	e.printStackTrace();
	out.println(e);
}
finally { 
	
	ConnectionManager.returnConnection(conn,request);
}
%>

</div>
<input type='hidden' name='cnt' id='cnt' value='<%=cnt%>'>
<input type='hidden' name='chk' id='chk' value=''>
<input type='hidden' name='result_value' id='result_value' value=''>
<input type='hidden' name='desktop_summary_type' id='desktop_summary_type' value="<%=summary_type%>">
<input type='hidden' name='summ_show_by' id='summ_show_by' value="<%=summary_area%>">
  <script>
if('<%=operation%>'=='modify')
{
	frameLoad();
	
}
</script>   
</form>
</body>
</html>

