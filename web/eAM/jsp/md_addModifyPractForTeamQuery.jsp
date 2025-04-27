<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/md_Practforteam.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <script>

	

	 function enable_txt(obj)
	{
		if(obj.value!='00')
		        
		  document.forms[0].search_txt.disabled=false;
		 		
		else
		{
          document.forms[0].search_txt.disabled=true;
		   document.forms[0].search_txt.value="";
		}
	}

	 function callPractitioner()
	{
		
		if(chkPractitionerList())
		{
			var team=document.forms[0].team.value;
			var arr= new Array();
			arr=team.split("$");
			if(parent.frames[1].document.forms[0])
				parent.frames[1].document.forms[0].submit();
			temp='';rowId='';
			var search_by=document.forms[0].search_by.value;
			 var search_txt=document.forms[0].search_txt.value;
			parent.frames[1].location.href='../../eAM/jsp/md_addModifyPractForTeamResult.jsp?team_id='+arr[0]+'&speciality_code='+arr[1]+'&facilityID='+document.forms[0].facility_id.value+"&clsSessRoleValue=Y"+"&search_txt="+search_txt+"&search_by="+search_by;
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
		}
	}
	function populateSpeciality(Obj)
	{
	if(Obj.value !='')
	{
	var arr=new Array();
	arr=Obj.value.split("$");
	document.getElementById('speciality_code').innerHTML="&nbsp;&nbsp;"+arr[2];
	//document.getElementById('speciality_label').innerHTML="Specialty";
	document.getElementById('speciality_label').innerHTML=getLabel("Common.speciality.label","Common");
	}
	else
	{
	document.getElementById('speciality_code').innerHTML="<b>&nbsp;&nbsp;</b>";
	document.getElementById('speciality_label').innerHTML="&nbsp;&nbsp;";
	}
	parent.f_query_add_mod_res.location.href='../../eCommon/html/blank.html'
	}
	
	function focusObj()
	{
		document.forms[0].facility_id.focus();
	
	}
	
	function getTeam(Obj)
	{
		
	document.getElementById("team").value='';
	document.getElementById('speciality_code').innerHTML="<b>&nbsp;&nbsp;</b>";
	document.getElementById('speciality_label').innerHTML="&nbsp;&nbsp;";
	
	parent.f_query_add_mod_res.location.href='../../eCommon/html/blank.html'
	
	
	
	      var selected = document.forms[0].team;
	      while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);
			
	
	       
	       var xmlDoc = "";
	       var xmlHttp = new XMLHttpRequest();	
	       xmlStr ="<root><SEARCH facilityID=\""+Obj.value+"\" /></root>"
	       xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	       xmlHttp.open("POST","PopulateTeam.jsp",false)
			
	
	       xmlHttp.send(xmlDoc)
	       responseText=xmlHttp.responseText
	       responseText = trimString(responseText)
		   
	       eval(responseText) 
	}
</script>
<%

	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String facility_id ="";
	String facilityId = (String)session.getValue("facility_id");

	facility_id=request.getParameter("facility_id");
	if(facility_id == null || facility_id.equals("")) facility_id=facilityId;
	String globaluser="";

	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	globaluser = (String)p.getProperty("login_user");

	try
	{
		con = ConnectionManager.getConnection(request);

 	%>
	</head>

	<body onLoad='focusObj()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='facility_form_query' id='facility_form_query'>
		<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
			<tr>
		     <td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		     <td colspan='2' nowrap align='left'>&nbsp;&nbsp;<select name='facility_id' id='facility_id' onChange='getTeam(this)'>
			<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>

			<%
				String dat1="",id1="",en1="";
				pstmt1=con.prepareStatement("Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id ='"+ globaluser+"' and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)");
				rset1=pstmt1.executeQuery();
				if(rset1!=null)
				{
				   while(rset1.next())
				   {
				   dat1=rset1.getString("Facility_Name");
				   id1=rset1.getString("Facility_Id");
				   if(id1.equals(facility_id))
					en1="selected";
				    else
					en1="";

				 out.println("<option value='"+id1+ "' "+en1+">"+dat1);

				   }
				}
				out.print("</select>");
				%>
			<img src='../../eMP/images/mandatory.gif'></td>
			<td >&nbsp;</td>
			
			</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
				     <td  width='20%' class='label' nowrap><fmt:message key="eAM.Team.label" bundle="${am_labels}"/></td>
				     <td align='left' width='20%'  nowrap>&nbsp;&nbsp;<select name='team' id='team' onChange='populateSpeciality(this)'>
					<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
					</select>
					 <img src='../../eMP/images/mandatory.gif'>
				     </td>
   				     <td width='20%'  nowrap class='label'  id='speciality_label' nowrap>&nbsp;&nbsp;</td>
    				     <td align='left' width='20%' class='querydata'  nowrap id='speciality_code'>&nbsp;&nbsp;</td>
    				</tr>

				<!-- Added by Rafiq on 5/3/2007  -->
								<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
									<tr>
		<td  class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td  colspan=4 class='fields' >&nbsp;
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
		<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=15 maxlength=15></td>
	</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
    				<tr>
    					<td colspan='4' nowrap align='right'>&nbsp;<input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='callPractitioner()'></td>
   				</tr>
			
  			</table>
		</div>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<script>getTeam(document.getElementById("facility_id"))</script>
	</form>
</body>
</html>
		<%	 }
			  catch(Exception e){
				  //out.print(e);
				  e.printStackTrace();
			  }
			  finally
			  {
				try
				{
				  if(stmt!=null)	stmt.close();
				  if(pstmt!=null)	pstmt.close();
				  if(pstmt1!=null)  pstmt1.close();
				  if(rset!=null)	rset.close();
				  if(rset1!=null)	rset1.close();
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			  ConnectionManager.returnConnection(con,request);

			  }%>

