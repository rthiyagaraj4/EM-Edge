<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            ?           	created
23/05/2013      IN040127    Chowminya 	   Quick Link - Flowsheet id not fetched	
21/11/2013		IN045031	Chowminya	   Define Quick Link - entered external URL is now disappeared
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
20/01/2017		IN061898	Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
12/03/2018		IN066387	Kamalakannan G	12/03/2018		Ramesh G			Quick Link enable
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
03/02/2022		IN27709     Suji Keerthi G	03/02/2022		Ramesh G			GHL-CRF-0658
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
---------------------------------------------------------------------------------------------------------------
--> 
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 09/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	{
	imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	/** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCA/html/Tabs.css'></link><!-- IN069654 -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../js/DefineQuickLinks.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<STYLE TYPE="text/css">
tbody.scrolling
{
  overflow: auto;
}
</STYLE>
<%
	Connection con			= null;
	PreparedStatement stmt	= null;
	//PreparedStatement pstmt = null;
	ResultSet rs			= null;
	PreparedStatement pst = null;
	ResultSet rs1 = null;
	PreparedStatement ps = null;
	ResultSet rs2 = null;

	//String sql				= "";
	String mode				= "";
	String description		= "";
	String ql_type			= "";
	String function_id		= "";
	String function_name	= "";
	String url				= "";
	String desc				= "";
	String function_spec	= "";
	String global			= "";
	String eff_status		= "E";//IN066387
	String function_checked	= "";
	String function_value	= "N";
	String global_checked	= "";
	String global_value		= "N";
	String enabled_checked	= "checked";
	String ql_ref			= "";
	String adpt_id			= "";
	String param_ref        = "";
	String param_name       = "";
	String param_list_str   = "";
//String	val="";//Checkstyle 4.0 Beta 6
	ArrayList<HashMap<String,String>> external_list = new ArrayList<HashMap<String,String>>();
    HashMap<String,String> extnal_lst = null;

	mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facilityId = (String)session.getValue("facility_id");
	//String clinician_id = (String) session.getValue("ca_practitioner_id");
	String clinician_id 	=	(String) session.getValue("login_user");
	//String pract_type = (String) session.getValue("practitioner_type");//Commentted - IN040127
	String pract_type = (String) session.getValue("practitioner_type") ==null ? "" : (String) session.getValue("practitioner_type");//IN040127
	String grphistory_type	=request.getParameter("grphistory_type") == null ? "LBIN" : request.getParameter("grphistory_type");//IN069654	
	String browser_check = "I",browser_check_I="",browser_check_G="",browser_check_M=""; //IN27709
	String browser_check_E="";//51215
	try
	{
		con = ConnectionManager.getConnection(request);

		if(mode.equals("update"))
		{
			//description = URLDecoder.decode(request.getParameter("description"),"UTF-8") == null ? "" : URLDecoder.decode(request.getParameter("description"),"UTF-8");

			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			
			String ql_ref1 = request.getParameter("ql_ref1") == null ? "" : request.getParameter("ql_ref1");		
			

			//String sql1 = "select QUICK_LINK_REF, QUICK_LINK_TYPE,OPTION_ID, EXTERNAL_URL_APPL, QUICK_LINK_DESCRIPTION,FUNCTION_SPEC_YN, GLOBAL_YN, EFF_STATUS, SYS_OPTION_DESC from SM_QUICK_LINK_LIST_VW where QUICK_LINK_DESCRIPTION = '"+description+"' and QUICK_LINK_REF = '"+ql_ref1+"' ";//IN069654
			String sql1 = "select QUICK_LINK_REF, QUICK_LINK_TYPE,OPTION_ID, EXTERNAL_URL_APPL, QUICK_LINK_DESCRIPTION,FUNCTION_SPEC_YN, GLOBAL_YN, EFF_STATUS, SYS_OPTION_DESC,HIST_TYPE,BROWSER_CHECK from SM_QUICK_LINK_LIST_VW where QUICK_LINK_DESCRIPTION = ? and QUICK_LINK_REF = ? ";//IN069654 //IN27709
			stmt = con.prepareStatement(sql1);
			stmt.setString(1,description);
			stmt.setString(2,ql_ref1);
			rs = stmt.executeQuery();

			if(rs.next())
			{
				ql_ref = rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
				ql_type = rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
				function_id = rs.getString("OPTION_ID") == null ? "" : rs.getString("OPTION_ID");
				url = rs.getString("EXTERNAL_URL_APPL") == null ? "" : rs.getString("EXTERNAL_URL_APPL");
				desc = rs.getString("QUICK_LINK_DESCRIPTION") == null ? "" : rs.getString("QUICK_LINK_DESCRIPTION");
				
				function_spec = rs.getString("FUNCTION_SPEC_YN") == null ? "" : rs.getString("FUNCTION_SPEC_YN");
				global = rs.getString("GLOBAL_YN") == null ? "" : rs.getString("GLOBAL_YN");
				eff_status = rs.getString("EFF_STATUS") == null ? "" : rs.getString("EFF_STATUS");
				function_name = rs.getString("SYS_OPTION_DESC") == null ? "" : rs.getString("SYS_OPTION_DESC");
				grphistory_type = rs.getString("HIST_TYPE") == null ? "" : rs.getString("HIST_TYPE");//IN069654
				browser_check  = rs.getString("BROWSER_CHECK") == null ? "" : rs.getString("BROWSER_CHECK"); //IN27709
				if(function_spec.equals("Y"))
				{
					function_checked = "checked";
					function_value = "Y";
				}
				else
				{
					function_checked = "";
					function_value = "N";
				}

				if(global.equals("Y"))
				{
					global_checked = "checked";
					global_value = "Y";
				}
				else
				{
					global_checked = "";
					global_value = "N";
				}

				if(eff_status.equals("E"))
					enabled_checked = "checked";
				else
					enabled_checked = "";
				
				//IN27709
				if(browser_check.equals("I"))
					browser_check_I = "selected";
				else if(browser_check.equals("G"))
					browser_check_G = "selected";
				else if(browser_check.equals("M"))
					browser_check_M = "selected";
				else if(browser_check.equals("E")) //51215
					browser_check_E = "selected";  //51215
				//IN27709

			}
			String sql = "select QUERY_STRING from SM_QUICK_LINK_LIST where QUICK_LINK_REF = ? and QUICK_LINK_DESCRIPTION = ?";
			ps = con.prepareStatement(sql);
		    ps.setString(1,ql_ref1);
			ps.setString(2,description);
			rs2 = ps.executeQuery();
			while(rs2.next())
			{
				param_list_str = rs2.getString(1);
			}
			if(param_list_str == null) param_list_str = "";
			if(rs != null)  rs.close(); 
			if(stmt != null)  stmt.close();
			if(rs2 != null) rs2.close();
			if(ps != null) ps.close();

			adpt_id = ql_ref;
		}
		String sqlquery="select PARAM_REF,PARAM_NAME from CA_EXT_APPL_PARAM_LIST WHERE APPL_QUICKLINK_YN = 'Y'";
	       pst = con.prepareStatement(sqlquery);
	       rs1 = pst.executeQuery();
	        while(rs1.next())
	         {
	            extnal_lst = new HashMap<String,String>();
	            extnal_lst.put("param_ref",rs1.getString(1));
                extnal_lst.put("param_name",rs1.getString(2));
                external_list.add(extnal_lst);
      
	         }
			 if(rs1 != null)  rs1.close(); 
			 if(pst != null)  pst.close();
			 
		//IN040127 - Start
		if("".equals(pract_type))	
		{	
			String sqlquery1="Select PRACT_TYPE pract_type from am_practitioner where PRACTITIONER_ID = (Select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID = ?)";
			pst = con.prepareStatement(sqlquery1);
			pst.setString(1,clinician_id);
			rs1 = pst.executeQuery();
			while(rs1.next())
			{
				pract_type 	  = rs1.getString( "pract_type" )  ;
			}
			if(rs1 != null)  rs1.close(); 
			if(pst != null)  pst.close();
		}	
		//IN040127 - End
	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	} 
%>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='' onScroll='staticTitle()' onKeyDown="lockKey()">
	<form name="QuickLink_Form" id="QuickLink_Form" action="../../servlet/eCA.QuickLinksServlet" method="post" target="messageFrame">
		<br><br>
		<table border=0 cellspacing=0 cellpadding='3' width='100%' align='center'>
			<tr>
				<td class=label style="width: 200px;"><fmt:message key="eCA.QuickLinkType.label" bundle="${ca_labels}"/></td>
				<td colspan="2" class='fields'>
					<select id='ql_type' name='ql_type' id='ql_type' onchange='showFields(this)'>
						<option value = ''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<option value = 'QF'><fmt:message key="eCA.QueryFilter.label" bundle="${ca_labels}"/></option>
						<option value = 'AF'><fmt:message key="eCA.ActualFunction.label" bundle="${ca_labels}"/></option>
						<option value = 'EX'><fmt:message key="eCA.ExternalApplication.label" bundle="${ca_labels}"/></option>
						<option value = 'AM'><fmt:message key="eCA.AdaptiveMenu.label" bundle="${ca_labels}"/></option>
					</select><img src="../../eCommon/images/mandatory.gif">
					<input type=hidden name="ql_type1" id="ql_type1" value="">
				</td>
			</tr>	
			
			<tr id="adpt" style="display:none">
				<td class=label><fmt:message key="eCA.AdaptiveFuncTo.label" bundle="${ca_labels}"/> </td>
				<td colspan="2" class='fields'>
					<input type='text'  name="function_adpt" id="function_adpt" value="<%=function_name%>" size='30' maxlength='50' onBlur="getAdptFunction1(this);loadLinkedFunck(this)" ><input type='button' class='button' value='?' name='search_ref1' id='search_ref1' onClick="getAdptFunction()" >
					<input type="hidden" name="adpt_id" id="adpt_id" value='<%=adpt_id%>'><img src="../../eCommon/images/mandatory.gif" >
				</td>
			</tr>
			<tr id="functionHide" >
				<td class=label><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td colspan="2" class='fields'>
					<input type='text' name="function_name" id="function_name" value="<%=function_name%>" size='30' maxlength='50' onBlur="getFunction1(this)"><input type='button' class='button' value='?' name='search_ref' id='search_ref' onClick="getFunction()">
					<input type="hidden" name="function_id" id="function_id" value='<%=function_id%>'><img src="../../eCommon/images/mandatory.gif" style="display:none" id='mand_fun'>
				</td>
			</tr>
			<tr id="External_URL" >
				<td class=label><fmt:message key="eCA.ExternalURL.label" bundle="${ca_labels}"/></td>
				<td colspan="2" class='fields'>
				<textarea style="resize:none" disabled  name="url" onblur="makeValidString(this);chkMaxLenForLongTest('url',250)"
           cols="60" rows="3" onkeypress="if(event.keyCode==13){return false;}"><%=url%></textarea>
					<!-- <input type='text' name="url" id="url" value="<%=url%>" size='45' maxlength='60' disabled onBlur="makeValidString(this)"><input type=hidden name="url1" id="url1" value="<%=url%>"> --><img src="../../eCommon/images/mandatory.gif" style="display:none" id='mand_url'>
					<div id='validateURL'> </div>
				</td>
			</tr>
			<tr id="desc_field">
				<td class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td colspan="2" class='fields'>
					<input type='text' name="desc" id="desc" value="<%=desc%>" onBlur="makeValidString(this)" size='30' maxlength='30'><input type=hidden name="desc1" id="desc1" value="<%=desc%>"><img src="../../eCommon/images/mandatory.gif" style="display:none" id='mand_desc'>
				</td>
			</tr>
			<tr id="scope_id">
				<td class=label><fmt:message key="Common.Scope.label" bundle="${common_labels}"/></td>
				<td colspan="2" class='fields'>
					<input type="checkbox" name="function_spec" id="function_spec" value="<%=function_value%>" onclick='setValue(this)' <%=function_checked%>><fmt:message key="eCA.FunctionSpecific.label" bundle="${ca_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="global" id="global" value="<%=global_value%>" onclick='setValue(this)' <%=global_checked%>><fmt:message key="eCA.Global.label" bundle="${ca_labels}"/>
				</td>
			</tr>
			<tr>
				<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" onclick="setStatus(this)" <%=enabled_checked%>></td>
			</tr>
			<!--IN27709-->
			<tr id="browser_chk" style='display:none' >
				<td class=label><fmt:message key="eCA.Browser.label" bundle="${ca_labels}"/></td>
				<td colspan="2" class='fields'>
					<select id='brows_check' name='brows_chk' id='brows_chk'>
						<option value = 'I' <%=browser_check_I%>><fmt:message key="eCA.InternetExplorer.label" bundle="${ca_labels}"/></option>
						<option value = 'G' <%=browser_check_G%>><fmt:message key="eCA.GoogleChrome.label" bundle="${ca_labels}"/></option>
						<option value = 'M' <%=browser_check_M%>><fmt:message key="eCA.MozillaFirefox.label" bundle="${ca_labels}"/></option>
						<option value = 'E' <%=browser_check_E%>><fmt:message key="eCA.MicrosoftEdge.label" bundle="${ca_labels}"/></option> <!--  51215 -->
					</select>
				</td>
			</tr>
			<!--IN27709-->
			<!-- added by kishore kumar n on 09/12/2009  -->
			<tr id='searchBoxBG' style='display'><td colspan="3">
			<%if(!imgUrl.equals("")){ %>
			<img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%></td>
			</tr>
			<!--ends here -->
			<tbody class=scrolling>
			<tr>
				<td style="padding: 0; display: '';" colspan="2"  id='criteria'>
					
				</td>
			</tr>
			</tbody>
		</table>
		<!--Below code is added by channaver B on 14/04/2010-->
		<div id='ExtApp' style='display:none'>
		
		<table border='0' cellpadding='3' cellspacing='1' width='65%' align='center'>
            	<tr id ="param_detail">
                     <td class="COLUMNHEADER" colspan='3' align="left"><fmt:message key="eCA.ParameterDetails.label" bundle="${ca_labels}"/></td>
	            </tr>
				<tr></tr><tr></tr><tr></tr><tr></tr>
	            <tr id = "param_nm">
	                 <td class="label" ><fmt:message key="eCA.ParamName.label" bundle="${ca_labels}"/></td>
			         <td class="fields" ><input type="text" name="parameterName" id="parameterName"  value = '' onkeyPress='return CheckForSpecChars(event)'></td>&nbsp;&nbsp;
			         <td class="COLUMNHEADER" align="center"><fmt:message key="eCA.ConstructedParameterList.label" bundle="${ca_labels}"/></td>
				</tr>
			    <tr id = "param_val">
	                 <td class="label"  align="left"><fmt:message key="eCA.ParamValue.label" bundle="${ca_labels}"/></td>
			          <td ><select name="param_list" id="param_list">
						      <option value = ''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			                     <%
                                   if(!external_list.equals("") || !external_list.equals(null))
	                                {
				                      for(int i=0;i<external_list.size();i++)
					                   {
					                      extnal_lst = external_list.get(i);
					                      param_name = extnal_lst.get("param_name") == null?"":extnal_lst.get("param_name");
					                      param_ref = extnal_lst.get("param_ref") == null?"":extnal_lst.get("param_ref");
					                   %>
					        <option value="<%=param_ref%>"><%=param_name%></option>	
			                         <%} 
	                               }%>
			            </select>
					</td>
			         <td class="fields" rowspan='2'><textarea style="resize:none"  name="externalParamResult" id="externalParamResult" value="<%=param_list_str%>"   onblur="chkMaxLenForLongTest('externalParamResult',3000)"   size="90" width="100" height="100" cols="57" rows="4"><%=param_list_str%></textarea></td>
	         </tr>
	         <tr id = "add_bt">
               <td></td>
	           <td class="fields"><input type="Button" name="Add" id="Add" value="Add" onclick='callExternalList()'></td>
	        </tr>	
	</table>
	</div>
		<input type=hidden name="mode" id="mode" value="<%=mode%>">
		<input type=hidden name="count" id="count" value="0">
		<input type=hidden name="function_spec1" id="function_spec1" value="<%=function_value%>">
		<input type=hidden name="global1" id="global1" value="<%=global_value%>">
		<input type=hidden name="ql_ref" id="ql_ref" value='<%=ql_ref%>'>
		<input type=hidden name="locale" id="locale" value='<%=locale%>'>
		<input type=hidden name="facilityId" id="facilityId" value='<%=facilityId%>'>
		<input type=hidden name="clinician_id" id="clinician_id" value='<%=clinician_id%>'>
		<input type=hidden name="pract_type" id="pract_type" value='<%=pract_type%>'>
		<input type=hidden name="grphistory_type" id="grphistory_type" value='<%=grphistory_type%>'><!-- IN069654 -->
		<input type=hidden name="brows_chk" id="brows_chk" value='<%=browser_check%>'><!--IN27709-->
	</form>
</body>
<script>	
	if('<%=mode%>' == 'update')
	{		
		if('<%=ql_type%>' != '')
		{
			
			document.getElementById("ql_type").value = '<%=ql_type%>';
			document.getElementById("ql_type1").value = '<%=ql_type%>';
		}
		document.QuickLink_Form.ql_type.disabled = true;
		document.QuickLink_Form.function_name.disabled = true;
		document.QuickLink_Form.search_ref.disabled = true;
		if('<%=eff_status%>' == 'E')
		{
			document.QuickLink_Form.desc.disabled = false;
			document.QuickLink_Form.function_spec.disabled = false;
			document.QuickLink_Form.global.disabled = false;
			document.getElementById("brows_check").disabled = false; //IN27709
		}
		else
		{
			document.QuickLink_Form.desc.disabled = true;
			document.QuickLink_Form.function_spec.disabled = true;
			document.QuickLink_Form.global.disabled = true;
			document.getElementById("brows_check").disabled = true; //IN27709
		}

		if('<%=ql_type%>' == 'QF')
		{
			document.QuickLink_Form.mand_fun.style.display = 'inline';
			document.QuickLink_Form.mand_desc.style.display = 'inline';
			enableCriteria('<%=function_id%>');
			document.getElementById("browser_chk").style.display = 'none'; //IN27709
		}
		else if('<%=ql_type%>' == 'AM')
		{
			//document.getElementById("function_adpt").value='<%=desc%>';
			document.getElementById("function_adpt").value=document.QuickLink_Form.desc.value;
			document.getElementById("External_URL").style.display ='none';
			document.getElementById("scope_id").style.display ='none';
			document.getElementById("adpt").style.display ='inline';
			document.getElementById("functionHide").style.display ='none';
			document.getElementById("desc_field").style.display ='none';
			document.QuickLink_Form.function_adpt.disabled = true;
			document.QuickLink_Form.search_ref1.disabled = true;
			document.getElementById("browser_chk").style.display = 'none'; //IN27709
			parent.panel.rows='8%,20%,*,8%';
			parent.frames[2].location.href='../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?load=load';		
			parent.frames[3].location.href='../../eCA/jsp/AdaptiveMenuLinkedFunctions.jsp?mode=insert';

			//document.QuickLink_Form.global.checked = true;
			//document.QuickLink_Form.global.disabled = true;
			//document.QuickLink_Form.global.value = 'Y';
			//document.QuickLink_Form.global1.value = 'Y';
			//document.QuickLink_Form.function_spec.checked = false;
			//document.QuickLink_Form.function_spec.disabled = true;
			//document.QuickLink_Form.function_spec.value = 'N';
			//document.QuickLink_Form.function_spec1.value = 'N';
			//document.QuickLink_Form.desc.disabled = true;
			//document.QuickLink_Form.mand_fun.style.display = 'inline';
		}
		else if('<%=ql_type%>' == 'AF')
		{
			document.QuickLink_Form.global.checked = true;
			document.QuickLink_Form.global.disabled = true;
			document.QuickLink_Form.global.value = 'Y';
			document.QuickLink_Form.global1.value = 'Y';
			document.QuickLink_Form.function_spec.checked = false;
			document.QuickLink_Form.function_spec.disabled = true;
			document.QuickLink_Form.function_spec.value = 'N';
			document.QuickLink_Form.function_spec1.value = 'N';
			document.QuickLink_Form.desc.disabled = true;
			document.QuickLink_Form.mand_fun.style.display = 'inline';
			document.getElementById("browser_chk").style.display = 'none'; //IN27709
		}
		else if('<%=ql_type%>' == 'EX')
		{
			document.QuickLink_Form.mand_desc.style.display = 'inline';
			document.QuickLink_Form.mand_url.style.display = 'inline';
			document.QuickLink_Form.global.checked = true;
			document.QuickLink_Form.global.disabled = true;
			document.QuickLink_Form.global.value = 'Y';
			document.QuickLink_Form.global1.value = 'Y';
			document.QuickLink_Form.function_spec.checked = false;
			document.QuickLink_Form.function_spec.disabled = true;
			document.QuickLink_Form.function_spec.value = 'N';
			document.QuickLink_Form.function_spec1.value = 'N';
			document.getElementById('ExtApp').style.display='inline';
			document.getElementById("browser_chk").style.display =''; //IN27709
			//if('<%=eff_status%>' == 'E')//IN045031
				document.QuickLink_Form.url.disabled = false;
			/*else
				document.QuickLink_Form.url.disabled = true;*/ //IN045031
			
			document.getElementById("validateURL").innerHTML = "<b><font size='1' color=red>( "+getLabel('eCA.ValidateURL.label','CA')+" )<br>(<B>Note: Only below fields can be used as URL parameter values (Ex : Patient_id=~PATIENT_ID`) which can be replaced with actuals values in transaction.</B> <br/>~PATIENT_ID`,~ENCOUNTER_ID`,~FACILITY_ID`,~NRIC`,~LOGIN_USERID`,~PATIENT_NAME`,~AGE`,~GENDER`,~VISIT_TYPE_DESC`)</font></b>"; //IN27709
		}
	}
	if(document.QuickLink_Form.function_id.value=="PREVIOUS_NOTES")
			document.QuickLink_Form.global.disabled=true;
//Added below if for IN061898 
	if(document.QuickLink_Form.function_id.value=="CA_TASK_LIST")
			document.QuickLink_Form.global.disabled=true;
</script>
</html>

