<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection conn=null;
	Statement stmt = null;
	
	
		try
		{
			conn = ConnectionManager.getConnection(request);
			
		}
		catch (Exception e)
		{			
			e.printStackTrace() ;
		}



	stmt= conn.createStatement();
	ResultSet rset=null;	
	PreparedStatement pstmt=null;
	String m_name="";
	String codeTextAttribute="";
	String fun_id="";
	String fun_name="";
	String sql="";
	String m_id="";
	String sel="";
	String code="", name="",eff_status="",Contents_types="";
	String module_id="";
	String Function_id="";
	String operation 				= request.getParameter( "operation" ) ;
	String sum_id="";
	String sum_name="";
	String classValue="";
	String check_eff="";
	String menu_id="";
	String menu_name="";
	String summary_type="";
	String summ_clin="checked";
	String summ_non_clin="";
	String summ_half="checked";
	String summ_full="";
	String summary_area="";


	int cnt=0;
	
	int i=0;

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

	}
    if(rset!=null)rset.close();
	if(pstmt!=null)pstmt.close();

	
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/ConstructCAMenu_temp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'> 
<form name="CreateDesktop_form" id="CreateDesktop_form">
<BR>
<div  align="left">
<table border="0" cellpadding="3" cellspacing="0" width='85%' align='center'>
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
		<td width="25%"  class="fields"><input type="text" onBlur='makeValidString(this)' name="Desktop_name" id="Desktop_name" value='<%=name%>' size="50" maxlength="50"><img src='../../eCommon/images/mandatory.gif'></img></td>
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
    <td width="25%" class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>

       <td class="fields" width='25%'><select name="module_id" id="module_id" OnChange='Getvalues(this)'>
    <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
		
					try{						
                    
					  sql="Select  module_id,module_name from sm_module   where install_yn='Y'  order by 2";
						pstmt=conn.prepareStatement(sql);
						rset=pstmt.executeQuery();
						if(rset!=null){
							while(rset.next()){
								m_id=rset.getString(1);
								m_name=rset.getString(2);
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
						
				}catch(Exception e) 
				{ 
					e.printStackTrace() ;
				}
				finally
				{
					if(conn != null) ConnectionManager.returnConnection(conn,request);
				}
  %>

    </select><img src='../../eCommon/images/mandatory.gif'></img>
    </td>
	<INPUT TYPE="hidden" name="Module_Name" id="Module_Name" value="">
	 <td width="50%" colspan ='2' class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--</td>-->

	<!-- <td class="fields" width='30%'>-->
	<%if(operation.equals("insert")){%>
       <select name="Function_id" id="Function_id"   >
    <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    </select>
	 <%} else {%>
	 <select name="Function_id" id="Function_id"  >
    <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

		 <%  try
				 {
			
			 //pstmt=conn.prepareStatement("select function_id, function_name from Sm_Function where module_id='" + module_id + "'  and desktop_appl_yn='Y'  order by  function_name");//common-icn-0180
			 pstmt=conn.prepareStatement("select function_id, function_name from Sm_Function where module_id=?  and desktop_appl_yn='Y'  order by  function_name");//common-icn-0180
			 pstmt.setString(1,module_id);//common-icn-0180
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
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			//if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			 }		 
			catch(Exception e) 
			{
				e.printStackTrace() ;				
			} 
			finally
			{
				if(conn != null) ConnectionManager.returnConnection(conn,request);
			}
			}
		
			 %>
    </select><img src='../../eCommon/images/mandatory.gif'></img>
 <script>
var function_id="<%=fun_id%>";
var module_id="<%=m_name%>";

</script>
    </td>
  
 
<!--
   <tr class="label">
    <td width="40%" class="label">&nbsp;</td>
  	<td width="60%" colspan="2" class="label">&nbsp;</td>
  </tr>
  <tr>
    <td width="40%" class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
	<td class="fields" width='60%'>
	<%if(operation.equals("insert")){%>
       <select name="Function_id" id="Function_id"   >
    <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    </select>
	 <%} else {%>
	 <select name="Function_id" id="Function_id"  >
    <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

		 <%  try
				 {
			
			// pstmt=conn.prepareStatement("select function_id, function_name from Sm_Function where module_id='" + module_id + "'  and desktop_appl_yn='Y'  order by  function_name");//common-icn-0180
			 pstmt=conn.prepareStatement("select function_id, function_name from Sm_Function where module_id= ?  and desktop_appl_yn='Y'  order by  function_name");//common-icn-0180
			 pstmt.setString(1,module_id);//common-icn-0180
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
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			//if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			 }		 
		catch(Exception e) {
				e.printStackTrace() ;
			} 
			}
		
			 %>
    </select><img src='../../eCommon/images/mandatory.gif'></img>
 <script>
var function_id="<%=fun_id%>";
var module_id="<%=m_name%>";

</script>
    </td>
  </tr>
  <tr class="label">
		<td width="40%" class="label">&nbsp;</td>
		<td width="60%" colspan="2" class="label">&nbsp;</td>
  </tr> -->
 <!-- <tr>
  <td width="50%" class="label" >Default from</td><td width="50%" class="fields"> <select>
	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	<%/*
	 try
		 {
			
		 pstmt=conn.prepareStatement("select DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where SYS_USER_DEF_IND ='S'");
			rset=pstmt.executeQuery();
		 while(rset.next())
			{		 
				menu_id=rset.getString("DESKTOP_SUMMARY_ID");
			    menu_name=rset.getString("DESKTOP_SUMMARY_NAME");
			   
			%>			
			<option value='<%=menu_id%>'><%=menu_name%></option>;				
			<% 
			}
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			if(conn != null) conn.close();
			
			 }		 
		catch(Exception e) {
		e.printStackTrace() ;
			} 
			//}
		
			*/ %>



	
	</select></td>
  </tr> -->
  <!--<tr class="label">
    <td width="40%" class="label">&nbsp;</td>
  	<td width="60%" colspan="2" class="label">&nbsp;</td>
  </tr>-->
	<INPUT TYPE="hidden" name="function_name" id="function_name" value="<%=operation%>">
	 </tr>
	 <tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td class="COLUMNHEADER" colspan=4><b>Summary Menu Customisation</b></td>
	</tr>
<tr>
<td class='label' width='25%'>User Type</td>
<td width="25%"  class="label"><input type="radio" name="clin_rad" id="clin_rad" id='clinician' class="label" value="C" <%=summ_clin%> onclick='setClinrad(this);' >Clinician&nbsp;<input type="radio" name="clin_rad" id="clin_rad" id='nonClinician' class="label" value="N" <%=summ_non_clin%> onclick='setClinrad(this);'>Non&nbsp;Clinician&nbsp;</td>

<td width="25%" class="label" >&nbsp;</td>
<td width="25%"  class="label">&nbsp;</td>

</tr>

<tr>
<td class='label' width='25%'>Show Summary Menu</td>
<td width="25%"  class="label"><input type="radio" name="menu_rad" id="menu_rad" id='menuhalf' class="label" value="H" onclick='setMenurad(this);' <%=summ_half%> >50%&nbsp;<input type="radio" name="menu_rad" id="menu_rad" id='menufull' class="label" value="F"  onclick='setMenurad(this); ' <%=summ_full%> >100%</td>

<td width="25%" class="label" >&nbsp;</td>
<td width="25%"  class="label">&nbsp;</td>

</tr>


</table>
<BR><BR>

<!--<table border="1" cellpadding="0" cellspacing="0" width='75%' align='center'>
<tr ><td class="COLUMNHEADER" colspan=4><b><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/> <fmt:message key="eSM.SummaryDetls.label" bundle="${sm_labels}"/>
</b></td></tr>
<br>
<tr>
	<td class='columnheader' width='80%' ><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/> <fmt:message key="eSM.Summary.label" bundle="${sm_labels}"/></td>
	<td class='columnheader' width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<!-- 19/12/2008 -->
<!--
<%

try{			
	
                    
				//sql="SELECT A.DESKTOP_SUMMARY_ID, B.DESKTOP_SUMMARY_NAME, 'Y' APPLICABLE FROM SM_DESKTOP_SETUP_DTL A,SM_DESKTOP_SUMMARY B WHERE A.DESKTOP_CODE='0000000001' AND A.DESKTOP_SUMMARY_ID=B.DESKTOP_SUMMARY_ID UNION SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME, 'N' APPLICABLE  FROM SM_DESKTOP_SUMMARY WHERE DESKTOP_SUMMARY_ID NOT IN (SELECT DESKTOP_SUMMARY_ID FROM SM_DESKTOP_SETUP_DTL WHERE DESKTOP_CODE='0000000001') ORDER BY DESKTOP_SUMMARY_NAME";


				//sql="SELECT A.DESKTOP_SUMMARY_ID, B.DESKTOP_SUMMARY_NAME, B.SRL_NO, 'Y' APPLICABLE FROM SM_DESKTOP_SETUP_DTL A,SM_DESKTOP_SUMMARY B WHERE A.DESKTOP_CODE='"+ code +"' AND A.DESKTOP_SUMMARY_ID=B.DESKTOP_SUMMARY_ID UNION SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME, SRL_NO, 'N' APPLICABLE  FROM SM_DESKTOP_SUMMARY WHERE DESKTOP_SUMMARY_ID NOT IN (SELECT DESKTOP_SUMMARY_ID FROM SM_DESKTOP_SETUP_DTL WHERE DESKTOP_CODE='"+ code +"') ORDER BY SRL_NO";//common-icn-0180
			
				sql="SELECT A.DESKTOP_SUMMARY_ID, B.DESKTOP_SUMMARY_NAME, B.SRL_NO, 'Y' APPLICABLE FROM SM_DESKTOP_SETUP_DTL A,SM_DESKTOP_SUMMARY B WHERE A.DESKTOP_CODE= ? AND A.DESKTOP_SUMMARY_ID=B.DESKTOP_SUMMARY_ID UNION SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME, SRL_NO, 'N' APPLICABLE  FROM SM_DESKTOP_SUMMARY WHERE DESKTOP_SUMMARY_ID NOT IN (SELECT DESKTOP_SUMMARY_ID FROM SM_DESKTOP_SETUP_DTL WHERE DESKTOP_CODE=?) ORDER BY SRL_NO";//common-icn-0180
				
						
					//	out.println("sql1234"+sql);
				pstmt=conn.prepareStatement(sql);
				//common-icn-0180 starts
				pstmt.setString(1, code);
				pstmt.setString(2, code);
				//common-icn-0180 ends
				rset=pstmt.executeQuery();
				if(rset!=null)
				{
					while(rset.next()){
					sum_id=rset.getString(1);
					sum_name=rset.getString(2);
					
					if(rset.getString(3).equals('Y'))
						{
							sum_name="CHECKED";
						}
						else
						{
							sum_name="";
						}
					
					if( i%2 == 0)  classValue="QRYEVEN";
					else
					classValue="QRYODD";
					cnt++;
							%>
				
					
			<tr>
			
			<td class='<%=classValue%>'><%=rset.getString(2)%></td>
			<td class='<%=classValue%>' align='center'><input type='checkbox'  name='chk<%=i%>' id='chk<%=i%>' <%=sum_name%> value='N' onclick="checkvalue(this,chk<%=i%>)" ></td>

				</tr>

			<% 
				i++;  
				}
				}
			
			%>			
			<% 

					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();	
						
				}catch(Exception e) { 
					//out.println("desktopcode"+e);//COMMON-ICN-0181
                                         e.printStackTrace();//COMMON-ICN-0181
					}



%>
				
</table>-->
</div>
<input type='hidden' name='cnt' id='cnt' value='<%=cnt%>'>
<input type='hidden' name='chk' id='chk' value=''>
<input type='hidden' name='result_value' id='result_value' value=''>
<input type='hidden' name='desktop_summary_type' id='desktop_summary_type' value="C">
<input type='hidden' name='summ_show_by' id='summ_show_by' value="H">

</form>
</body>
</html>

