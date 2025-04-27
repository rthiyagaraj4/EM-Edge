<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

 
<script>

  var alpha = new String();
  function callOnAlphaLink(obj1,obj2){
    document.detailUpperForm.all.searchTxt.style.display = "inline";
	document.detailUpperForm.search_text.value = "";
	if(obj1 == "OTH")
		obj1 = "Others" ;
    alpha = obj1;
	changeAlphaColor(obj2);
	TaskForSelIndx(obj1);
  }


   function notAllowOtherChar(event){	  
	  
	   if((alpha.charAt(1)).toUpperCase()!='T'){
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		  if (whichCode == 13) {
				return false; 
		   }
			key = String.fromCharCode(whichCode);  // Get key value from key code
			var sText = new String();
			sText = document.detailUpperForm.search_text.value;
			   /* if(sText.length==0){ //commented by parul on 02/08/2010 for 23013//not able to enter any alphabet excluding selected one
				if((key.toUpperCase())!=(alpha.charAt(0)).toUpperCase()){
				  return false;
			  }
			}*/
	   }
   }
 //commented by parul on 02/08/2010 for 23013
  /* function callSearch()
   {
	  
	   var sText = new String();
	   sText = document.detailUpperForm.search_text.value;
	   if((alpha.charAt(1)).toUpperCase()!='T'){
		   if((sText.charAt(0)).toUpperCase()==(alpha.charAt(0)).toUpperCase()){
			 if(sText == "OTH")
			 sText = "Others" ;
			 TaskForSelIndx(sText);
		   } else{		 
		//  var message  = "APP		002415 Query caused no records to be retrieved";
	  //  parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			document.detailUpperForm.search_text.value = "";
		//	parent.parent.parent.detailLowerDoc.location.href="../../eCommon/html/blank.html";
		   }
		   sText = "";
		   }else{
				TaskForSelIndx(sText);
		   }
   }*/
	function callSearch() { 
		sText = document.detailUpperForm.search_text.value;
		var searchlink=document.detailUpperForm.searchinglink.value;

		document.detailUpperForm.all.searchTxt.style.display = "inline";
		document.detailUpperForm.search_text.value = "";

		if(searchlink == "OTH"){
			searchlink = "Others" ;
		}
		if (sText==""){
			sText=alpha;
		}else{
			document.detailUpperForm.search_text.value=sText;
		}
	  
		TaskForSelIndx(sText);
	}

</script>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css'></link>
<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
	<STYLE TYPE="text/css">
	A:active {
		COLOR: white;
	}
	A:visited {
		COLOR: white;
	}
	A:link {
		COLOR: white;
	}
	</STYLE>
<%  } %>


</head>
 
<body  STYLE="" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	String treatment_code=checkForNull(request.getParameter("treatment_code"));
	//out.println("treatment_code--in tab->"+treatment_code);
	// String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	// String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  "";
	// String readOnly = "" ;
	// String disabled = "" ;
%>

<form name="detailUpperForm" id="detailUpperForm" method="post" >

<table border=0 id="headerTab" cellpadding=3 cellspacing=0 width='100%' align="center">
<%try {%>

<tr>
	<td colspan='2'>

	<table align='left' cellspacing='3' id="innerCellTab" cellpadding='1' width="30%" border='1' style="">
		<tr>
			<td id="SelectTab" class="clicked" width="15%" height="20" onClick='selectInsert()'><a href="#"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
			<td id="AssociateTab" class="normal" width="15%" height="20" onClick='associated()'><a href="#"><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	</td>
</tr>


<tr>
	<td colspan="2">
	<table align='center' cellspacing='1' id="alphabet" cellpadding='1' width='100%' border='0' style="">
	<tr>
		<td><jsp:include page="MTLinkTab.jsp" flush="true"/></td>
	</tr>
	</table>
	</td>
</tr>

<tr>
	<td colspan="2">
	<table align='center' cellspacing='1' id="searchTxt" cellpadding='1' width="100%" border='0' style="display:none">
	<tr>
		<td class='label'><fmt:message key="Common.Task.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<INPUT TYPE="text" name="search_text" id="search_text" value="" onKeyPress="return notAllowOtherChar(event)"; maxlength='100' size='40' ><INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="callSearch()">
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
<input type='hidden' value='1' name='mode' id='mode'>

<input type="hidden" name="function_id" id="function_id" value="">
<input type="hidden" name="treatment_code" id="treatment_code" value="<%=treatment_code%>" >
<input class='fields' type="hidden" name="searchinglink" id="searchinglink" value="">


<%}catch(Exception e){
	System.out.println("catch--->" + e.getMessage());

}%>
</form>
</body>
</html>



