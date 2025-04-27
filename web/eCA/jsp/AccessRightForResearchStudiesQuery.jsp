<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/AccessRightForResearchStudies.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
	function CheckForSpecChars_local(event){
		var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*'";
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

		return true ;
	}
	 function enable_txt(obj){
		if(obj.value!='00')		        
		  document.forms[0].search_txt.disabled=false;		 		
		else
		{
			document.forms[0].search_txt.disabled=true;
			document.forms[0].search_txt.value="";
		}
	}
	function checkVal(Obj){
		if(Obj.checked)
			Obj.value='Y';
		else
			Obj.value='N';
	}
	function callPractitioner(){
		parent.frames[0].selected='';
		if(chkPractitionerList()){
			var primary_specialty=document.forms[0].primary_specialty.value;
			var facility_id= document.forms[0].facility.value;
			var search_by=document.forms[0].search_by.value;
			var search_txt=document.forms[0].search_txt.value;
			if(search_txt.indexOf("'")!=-1){			
				search_txt = search_txt.replace("'","''");
			}
			parent.frames[1].location.href='../../eAM/jsp/md_addModifyOPPFForFacilityResult.jsp?primary_specialty='+primary_specialty+'&facility_id='+facility_id+"&search_txt="+encodeURIComponent(search_txt)+"&search_by="+search_by;
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
		}
	}
	function call(){
		var error=getMessage("WELCOME","common");
		alert(error);
	}
	function focusObj(){
		document.forms[0].resePatCategory.focus();
	}
		
	function chgFacility(){
		parent.frames[1].location.href='../../eCommon/html/blank.html'		
	}
	function chgSpecialty(){
		parent.frames[1].location.href='../../eCommon/html/blank.html'
	}
	</script>
<%
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String globaluser="";
	
	String dat="";
	String facility="";
	String pract="";
	String en="";
	String id="";
	request.setCharacterEncoding("UTF-8");

	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	globaluser = (String)p.getProperty("login_user");

	String facilityid=(String)session.getValue("facility_id") ;

	facility=request.getParameter("facility_id")==null ||  request.getParameter("facility_id").equals("") ?facilityid:request.getParameter("facility_id");
	pract=request.getParameter("practitioner_id")==null ?"":request.getParameter("practitioner_id");

	try
	{
	con = ConnectionManager.getConnection(request);

%>
	</head>

	<body  OnMouseDown="CodeArrest()" onSelect='call()' onLoad='focusObj()' onKeyDown = 'lockKey()'>
		<form name='AccessRightForResearchStudiesQueryform' id='AccessRightForResearchStudiesQueryform' action='../../servlet/eAM.OPPFServlet' method='post' target='messageFrame'>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='85%' >
				<!-- <tr>
					<th colspan='1' width="20%"></th>
					<th colspan='1' width="30%"></th>
					<th colspan='1' width="15%"></th>
					<th colspan='1' width="20%"></th>
				</tr> -->
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
    			<tr>
    				<td   class='label'><fmt:message key="eCA.ResearchPatientCategory.label" bundle="${ca_labels}"/></td>
    				<td  align='left' >&nbsp;
						<select name='resePatCategory' id='resePatCategory' onChange='getReseaFactors()'>
							<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
							<%
								stmt=con.createStatement();
    				    		String sqlfac="SELECT RESEARCH_CATEG_ID,RESEARCH_CATEG_DESC FROM CA_RESEARCH_CATEGORY WHERE EFF_STATUS='E'";
    				    		rset=stmt.executeQuery(sqlfac);
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("RESEARCH_CATEG_DESC");
    				    			id=rset.getString("RESEARCH_CATEG_ID");
    				    			if(id.equals(facility))
    				    			  en="selected";

    				    			 else
    				    			    en="";

    				    			out.println("<option value='"+id+ "' "+en +">"+dat);
    				    		   }
								 }  
							%>
    				    </select>&nbsp<img src='../../eCommon/images/mandatory.gif'>    				    		
					</td>
    				<td   nowrap  class='label'><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/></td>
    				<td  align='left' >&nbsp;<select name='reseCategoryFact' id='reseCategoryFact'>
    				   	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>    				    	
    				    	 </select>&nbsp<img src='../../eCommon/images/mandatory.gif'>				
					</td>
				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  id = 'lab1'  ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  colspan=2 class='fields' >&nbsp;
						<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
							<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
							<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
						</SELECT>&nbsp;&nbsp;
						<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=15 maxlength=15 value="">
					</td>	
    				<td nowrap align='center'>&nbsp;<input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='searchClick()'></td>
   				</tr>
			</table>
			
    <% 
	 }
	  catch(Exception e)
	{
		//  out.print(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	  finally
	  {
		 try
		{
		if(stmt!=null)	stmt.close();
		if(pstmt!=null)	pstmt.close();
		if(rset!=null)	rset.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	  }%>

			

</form>
</body>
</html>

