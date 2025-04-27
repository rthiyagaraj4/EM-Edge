<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %><!--IN072524-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<script language="javascript" src="../../eOR/js/CatalogsBySection.js"></script>



<script>
 
   var alpha = new String();

   function callOnAlphaLink(obj1,obj2)
   {
		document.getElementById('searchTxt').style.display = "inline";	
		document.getElementById('search_text').value = "";
		if(obj1 == "OTH")
			obj1 = "Others" ;
		alpha = obj1;
		changeAlphaColor(obj2);
		document.CatalogSectionHeader.searchinglink.value=alpha;
		parent.parent.callOderCatalog(obj1,"");
		//document.CatalogSectionHeader.all.search_text.focus();
   }

   function callSearch()
   {	   
	   var sText = new String();
	   sText = document.CatalogSectionHeader.search_text.value;
	   var searchlink=document.CatalogSectionHeader.searchinglink.value;
	   parent.parent.callOderCatalog(searchlink,sText);
	  /* if((sText=="")||(sText==null)||(sText=="null"))
	   {		   
		 parent.parent.callOderCatalog(searchlink,sText);
	   }
	   else
	   {
		if((alpha.charAt(1)).toUpperCase()!='T')
		{			
			if((sText.charAt(0)).toUpperCase()==(alpha.charAt(0)).toUpperCase())
			{
		         if(sText == "OTH")
					 sText = "Others" ;
				 parent.parent.callOderCatalog(searchlink,sText);
		   }
		   else
		   {
			    document.CatalogSectionHeader.search_text.value = "";
				//parent.parent.callOderCatalog(searchlink,sText);
		   }
			sText = "";
	   }
	   else
	   {
		   // parent.parent.callOderCatalog(searchlink,sText);		 
		  if(sText.length==0){
			  parent.parent.callOderCatalog(searchlink,sText);
		   }
		   else
		   {
		   var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		   var temp=sText.charAt(0);
		   
			if (strCheck.indexOf(temp) == -1) 
			{
				parent.parent.callOderCatalog(searchlink,sText);}
			else 
		    {
				document.CatalogSectionHeader.search_text.value = "";
				return false ;
			}
		   }
	    }
	   }*/
   }

   function notAllowOtherChar(event)
   {	 
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    var key = String.fromCharCode(whichCode); 
		var sText = new String();
		sText = document.CatalogSectionHeader.search_text.value;
		if((alpha.charAt(1)).toUpperCase()!='T'){
				if (whichCode == 13) 
				{
					return false; 
				}			
		
  			/*	if(sText.length==0)
				{
					if((key.toUpperCase())!=(alpha.charAt(0)).toUpperCase())
					{
						 return false;
					}  
				}*/
		}
		else
		{		
			var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';	
  			if (whichCode == 13) 
			{
				return false; 
			}	
			/*if(sText.length==0)
			{			
				if (strCheck.indexOf(key) == -1) 
					return true; 
				else 
					return false ;
			}*/

	    }
   }


/*  function callres()
  {
	var termsetid = document.term_code_result_header.termsetid.value;
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	search_text = search_text.toUpperCase();
	if(document.term_code_result_header.class_lvl.value==document.term_code_result_header.codelevel.value)
		className = "className";
	else
		className = "";
	if(termsetid!=null)
	{
		parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"";
		document.term_code_result_header.submit();
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}  */

</script>

<html>
<head>
	<%
	//out.println(request.getQueryString());
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




	<STYLE TYPE="text/css">

	A:active { 
		COLOR: black; 
	}

	A:visited { 
		COLOR: black; 
	}
	A:link { 
		COLOR: black; 
	}
	</STYLE>
<script>
//IN072524 Starts
function validatefppcatalog(obj){
	
		
	if(obj.checked)
	{
		document.getElementById("fpp_yn").value = 'Y';
	
	}
	else{
		document.getElementById("fpp_yn").value = 'N';
		
	}
	
}
//IN072524 Ends
</script>
	
</head>
<!-- onMouseDown="CodeArrest()" onMouseDown="CodeArrest()"  onKeyDown="lockKey()-->
<body  STYLE="overflow-y:hidden" onload="FocusFirstElement()" onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >

<%
	

	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	//String orderCatalogIndex=request.getParameter("OrderCatalogIndex");	
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "catalogsBySection" ;
	String bean_name = "eOR.CatalogsBySection";
	//String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  ""; 
	//String readOnly = "" ;
	//String disabled = "" ;
/*	// out.println("add modify");
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
		return ;
	/* Mandatory checks end */
	
	/*	Initialize Function specific start */
	
CatalogsBySection CatalogBean = (CatalogsBySection)getBeanObject( bean_id,  bean_name, 	request ) ;   CatalogBean.setFunctionId(CatalogBean.checkForNull(request.getParameter("function_id")));
CatalogBean.clearAll() ;
CatalogBean.setMode( mode ) ;   
	//ArrayList orderCategory=new ArrayList();
	/* Initialize Function specific end */
	//IN072524 Starts
	Boolean isfppapplicable = false;
	String fpp_yn="";
	Connection connection =  null;
	try{
	connection = ConnectionManager.getConnection(request); 
	
	isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");
	CatalogBean.setIsFPPApplicable(isfppapplicable);
	}catch(Exception e1){
		e1.printStackTrace();
	}finally{
		if(connection!=null) connection.close();
	}
	 //IN072524 ENDS
	%>
		
<form name="CatalogSectionHeader" id="CatalogSectionHeader" method="post" >

<table border="0" id="headerTab" name="headerTab" cellpadding='3' cellspacing='0' width="100%" align="center">
<%try {%>
<tr>
	<td class="label" width="50%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class='fields' width="50%"><select name="order_category" id="order_category"   onChange="return parent.parent.fillComboOptions(this)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=CatalogBean.getComboOptions()%></select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
	 </td>
</tr>
<tr>
<td class="label" width="50%"><fmt:message key="eOR.TickSheet.label" bundle="${or_labels}"/></td>
<td id="tick_sheet_option" class='fields' width="50%"><select name="tick_sheet" id="tick_sheet"  onChange="return parent.parent.fillComboOptions(this);">
<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select>
<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
</tr>	
<tr>
	<td class="label" width="50%"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
	<td id="section_option" class='fields' width="50%"><select name="section" id="section"  onChange="return parent.parent.select(this)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select>	
	<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
 </tr>
 <!-- IN072524 Starts -->
 <%if(isfppapplicable){%>
 <tr>
	<td class="label" width="50%"><fmt:message key="eOR.FPPPATIENT.label" bundle="${or_labels}"/></td>
	<td id="fpp_yn_td" class='fields' width="50%"><input type="checkbox" name="fpp_yn" id="fpp_yn" value="<%=fpp_yn %>" onclick="validatefppcatalog(this)"/></td>
	
 </tr>
 <%}%>
 <!-- IN072524 Ends -->
 <tr>
	<td colspan='2'>
	<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
</tr>
<tr>
	<td colspan='2'>
	<table align='left' cellspacing=0 id="innerCellTab" cellpadding='3' width="30%" border='1' style="display:none">
		<tr>
			<td align="center" id="SelectTab" name="SelectTab" class="clicked" width="15%" height="20" onClick='parent.parent.dispLink("S")'><a href="#"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
			<td align="center" id="AssociateTab" names="AssociateTab" class="normal" width="15%" height="20" onClick='parent.parent.dispLink("A")'><a href="#"><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	</td>
</tr> 

<tr>
	<td colspan="2">
	<table align='left' cellspacing='3' id="alphabet" name="alphabet" cellpadding='3' width='100%' border='0' style="display:none">
	<tr>
		<td><jsp:include page="OrCommonAlphaLink.jsp" flush="true"/></td>
	</tr>
	</table>
	</td>
</tr>

<tr>
	<td colspan="2">
	<table align='left' cellspacing='0' id="searchTxt" name="searchTxt" cellpadding='3' width="30%" border='0' style="display:none">
	<tr>
		<td class='label' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<INPUT TYPE="text" name="search_text" id="search_text" value=""  onKeyPress="return notAllowOtherChar(event)"; maxlength='100' size='40'>
		</td>
        <td class='button'>
			<INPUT TYPE="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="callSearch()">
		</td>    
	</tr>
	</table>
	</td>
</tr>
		
</table>


<!-- <input type="hidden" name="mode" id="mode" value="<%=mode%>"> -->
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="alphabetsHtml" id="alphabetsHtml" value='<%=AlphabetsHtml%>'>
<input type="hidden" name="seq_Nos" id="seq_Nos" value=''>
<input type='hidden' value='1' name='mode' id='mode'>
<input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>
<input type="hidden" name="function_id" id="function_id" value="<%=CatalogBean.getFunctionId()%>">
<input class='fields' type="hidden" name="tabVal" id="tabVal" value="">
<input class='fields' type="hidden" name="searchinglink" id="searchinglink" value="">

<%
		putObjectInBean(bean_id,CatalogBean,request);
 
%>


<%}catch(Exception e){
	System.out.println("here" + e.getMessage());

}%>
</form>
</body>
</html>




