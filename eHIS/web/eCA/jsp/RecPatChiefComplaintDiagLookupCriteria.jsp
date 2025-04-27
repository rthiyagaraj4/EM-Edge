<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name      		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/10/2018	IN066282		sivabagyam M  	04/10/2018		Ramesh G		ML-MMOH-CRF-1041
22/08/2020	IN073645		Ramesh Goli		22/08/2020		Ramesh G		CA-PMG2020-TECH-CRF-0001/02-Lookup issues
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import="java.sql.*, java.util.*, java.text.*" %>

<html>
<head>

<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 22/12/2008  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
	 //	IN068837 starts
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	 
	boolean isSpecltAll=false;
	String specaltyChkAll=" ";
	//String specaltyChk="";//	IN068837
	String specaltyChk="checked";
   String complaint = (request.getParameter("complaint")==null?"":request.getParameter("complaint"));
   String spltCode =  (request.getParameter("spltCode")==null?"":request.getParameter("spltCode"));
   String speciality_desc =  "";
try{
	conn=ConnectionManager.getConnection(request);
	isSpecltAll= eCommon.Common.CommonBean.isSiteSpecific(conn, "CA","DEF_ALL_CHIEF_COMPLAINTS");
	if(isSpecltAll)
	{
		 specaltyChkAll="checked";
		 specaltyChk=" ";
	}
	else
	{
		 specaltyChkAll="";
		 specaltyChk="checked";
	}
	if (stmt != null) stmt.close();
	if (rs != null) rs.close();	
   
 //	IN068837 ends
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->

<script language="JavaScript" src ="../../eCA/js/ChartApplicability.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





<script>
	var radioval="D";
	var radioFilter = "S";
	 //	IN068837 starts
	if(<%=isSpecltAll%>==true){
		radioFilter = "A";		
	}
	//	IN068837 ends	
	var specaility_desc = null;
	
	function closew()
	{
		//parent.window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
	
	function storeVal(currad)
	{
	radioval=currad.value
	 }
	
	 function valtext(comp)
	 {
		//var txt=comp.value
		var search_criteria =document.getElementById("search_criteria");
		var selectedOption = search_criteria.options[search_criteria.selectedIndex];
        
        // Get the value of the selected option
       var listval = selectedOption.value;
		var txtbox=document.getElementById("search_text").value;
		/*Below parameter instead of 'escape(txtbox)' only 'txtbox' has been passed now by Archana on 5/27/2010  for IN021646*/
	    parent.frames[1].location.href='../../eCA/jsp/RecPatChiefComplaintDiagLookupResult.jsp?<%=request.getQueryString()%>&search_by='+radioval+'&search_criteria='+listval+'&search_text='+txtbox+'&filter_by='+radioFilter+'&filter_desc='+document.getElementById("Speciality_desc").value+'&speciality_code='+document.getElementById("Speciality_code").value;
	//document.getElementById("Speciality_code").value = '';		
	}

      function doCall(complaint)
	 {		
		 if(complaint != null || complaint != "")
		 {
			valtext();
		 }

	 }

     function clearPage()
	 {
		  document.getElementById("Speciality_desc").value = "";
		  document.getElementById("Speciality_code").value = "";
		  document.getElementById("search_text").value = "";
        parent.frames[1].location.href='../../eCA/jsp/blank.jsp';
	 }

	 function disableComponents(radio)
     {		 
         radioFilter = radio.value;
		 if(radioFilter == "S")
		 {
           document.getElementById("Speciality_desc").disabled = false;
		   document.getElementById("SpecialtySrch").disabled = false;
         }
		 else if(radioFilter == "N" || radioFilter == "A")
		 {
           document.getElementById("Speciality_desc").disabled = true;
		   document.getElementById("SpecialtySrch").disabled = true;
		   document.getElementById("Speciality_desc").value = '';
		   document.getElementById("Speciality_code").value = '';
		   
		 }

	 }

	 async function getSpeciality()
     {
		
			 var sql = "SELECT A.SPECIALITY_CODE CODE, A.SHORT_DESC DESCRIPTION FROM AM_SPECIALITY A WHERE EFF_STATUS = 'E' AND A.SPECIALITY_CODE LIKE UPPER(?) AND UPPER(A.SHORT_DESC) LIKE UPPER(?)";
			 retArray = await callFunctionButton(sql,getLabel("Common.speciality.label","Common"),document.getElementById("Speciality_desc"));
			 var str =unescape(retArray);
			 var arr = str.split(",");
			 if(retArray != null && retArray !="")	
				{
				   document.getElementById("Speciality_desc").value = arr[1];
				   document.getElementById("Speciality_code").value = arr[0];
				}
			else
		    {
				document.getElementById("Speciality_desc").value = '';
				document.getElementById("Speciality_code").value = '';
			}
         
	 }

	 function checkSpltTxt(txtSplt)
	 {		 
         if(txtSplt.value != '')
		 {
			getSpeciality();
		 }else{
			document.getElementById("Speciality_code").value = '';
		 }
	 }

</script>
</head>
<% 
   
   if (!spltCode.equals("") && spltCode != null){
		
		String sql = "SELECT am_get_desc.AM_SPECIALITY(A.SPECIALITY_CODE,?,2) specialty_desc FROM AM_SPECIALITY A WHERE EFF_STATUS = 'E' AND UPPER(A.SPECIALITY_CODE) =UPPER(?)";

		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,locale);
		stmt.setString(2,spltCode);
		rs=stmt.executeQuery();

		while(rs.next())
		{
			speciality_desc = rs.getString("specialty_desc")== null?"":rs.getString("specialty_desc");
		}
   }
}catch(Exception e){
		e.printStackTrace();
}finally{
	if (stmt != null) stmt.close();
	if (rs != null) rs.close();	
	if (conn != null) 
	ConnectionManager.returnConnection(conn,request);		
}  
     
%>
<!-- <body onload='doCall("<%=complaint%>")' onKeyDown="lockKey()">--><!-- 	IN068837 -->
<body onload='' onKeyDown="lockKey()"><!-- 	IN068837 -->
	<form >
	<table align='center'  border="0" width='100%' cellspacing='0' cellpadding='3'>
        <tr width='100'>
           <td>&nbsp;&nbsp;</td>
			<td colspan=4  class="label">
				<fmt:message key="eCA.FilterBy.label" bundle="${ca_labels}"/>
				<!-- &nbsp;&nbsp;&nbsp;<input type="radio" name="Filter_by" id="Filter_by" value="S" checked OnClick='disableComponents(this)'/>--><!-- commented for IN066282 -->
				&nbsp;&nbsp;&nbsp;<input type="radio"  name="Filter_by" id="Filter_by" value="S" <%=specaltyChk%> OnClick='disableComponents(this)'/><!-- IN066282 -->
				<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				&nbsp;<input type="radio" name="Filter_by" id="Filter_by" value="N" OnClick='disableComponents(this)'/>
				<fmt:message key="eCA.NonSpeciality.label" bundle="${ca_labels}"/>
				<!-- <input type="radio" name="Filter_by" id="Filter_by" value="A"  OnClick='disableComponents(this)'/>--><!-- commneted for IN066282 -->
				<input type="radio" name="Filter_by" id="Filter_by" value="A" <%=specaltyChkAll%> OnClick='disableComponents(this)'/><!-- IN066282 -->
				<fmt:message key="Common.all.label" bundle="${common_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='Speciality_desc' id='Speciality_desc' size='35' maxlength='50' value="<%=speciality_desc%>" onblur='checkSpltTxt(this);'/><input type ='Button' class='button' name='SpecialtySrch' id='SpecialtySrch' value='?' Onclick = 'getSpeciality()'/>
				<input type='hidden' name='Speciality_code' id='Speciality_code' value='<%=spltCode%>'/>
			</td>
			<td  colspan=4  class="label"></td>
		</tr>
		<!-- Below if condition is added by Archana on 4/19/2010 at 4.00 PM for IN020735 -->
		<tr width='100'>
		<td>&nbsp;&nbsp;</td>
		<td colspan=4  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/><%if(!locale.equals("en")){%>&nbsp;&nbsp;&nbsp;&nbsp;<%}%>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if(!locale.equals("en")){%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%}%><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;<select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		</select>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;</td>
		<td class='label'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>		
		<input type="text" name="search_text" id="search_text" value='<%=complaint%>' width=30% align="left" size='40' maxlength='70' > </td>
		<!--<img src='../../eMP/images/mandatory.gif'align='center'></img>-->
		<td ><input type="button" width='20%' align="left" name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="clearPage();" class='button' >&nbsp;
		<input type="button" width='20%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="valtext(search_text); " class='button' >	</td>
		<td colspan="3"></td>
		</tr>
	<input type=hidden name="site" id="site" value=<%=isSpecltAll%>><!-- 	IN068837 -->
	<input type=hidden name="filter_by" id="filter_by" value=<%=specaltyChkAll%>><!-- 	IN068837 -->
</table>
<!-- added by kishore kumar n on 22/12/2008  -->
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!-- 	IN068837 starts -->
<%if(isSpecltAll==true){ %>
<SCRIPT>
 	radioFilter = "A";
 	document.getElementById("Speciality_desc").disabled = true;
	document.getElementById("SpecialtySrch").disabled = true;
	document.getElementById("Speciality_desc").value = '';
	document.getElementById("Speciality_code").value = '';
	doCall("<%=complaint%>");
</SCRIPT>
<%}else{%>
<SCRIPT>
	doCall("<%=complaint%>");
</SCRIPT>
<%}%>
<!-- 	IN068837 ends -->
<!--ends here -->	
</form>
</body>
</html>

