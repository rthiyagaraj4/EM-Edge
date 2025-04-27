<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");	%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script lanaguage='javascript'>
	function windowClosing()
	{

		//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
		//Added for Dentist Comments
	   	if(document.forms[0].flagForPrint.value == "Y"){
			if((document.forms[0].txtCheck.value).length > 1000){
				alert(getMessage("APP-OH000132",'OH'));
			}

			else{
				var formObj = document.forms[0];
				//var remarks = formObj.txtCheck.value;
				/*var dentist_comments =document.getElementById("remarks_txt").value;
				dentist_comments = encodeURIComponent(dentist_comments);
				dentist_comments = encodeURIComponent(dentist_comments);
				var patient_id = formObj.patient_id.value;
				var chart_num = formObj.chart_num.value;  */
				var dentist_comments =document.getElementById("remarks_txt").value;
				//alert(dentist_comments)
				formObj.dentist_comments.value = encodeURIComponent(dentist_comments);
				
				 var xmlDoc="";
				 var xmlHttp = new XMLHttpRequest();
				 var arrObj = formObj.elements;
				 var frmObjs = new Array()
				 if(formObj.name == null){
					frmObjs = formObj ;
				 }
				 else{
					frmObjs[0] = formObj ;
				 }
				 var xmlStr ="<root><SEARCH ";
				 for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
					formObj = frmObjs[frmCount];
					var arrObj = formObj.elements;
					for(var i=0;i<arrObj.length;i++) {
						val = arrObj[i].value;
						//alert("Name is ::" + arrObj[i].name);
						//alert("Value is ::" + val);
						if(arrObj[i].name != null && arrObj[i].name != ""){
							xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
						}
					}
				}

		//	}
			xmlStr +=" /></root>";
			//alert("xmlStr ::: " + xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//beforePost(xmlStr) ;
			xmlHttp.open("POST", "PrintChartValidation.jsp?func_mode=updateDentistComments", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			//alert(responseText);
			window.close();	
			//return xmlHttp.responseText  ;
				/*var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&remarks="+dentist_comments;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PrintChartValidation.jsp?func_mode=updateDentistComments&"+params,false);
				xmlHttp.send(xmlDoc);
				var update_dentist_comments_retVal = localTrimString(xmlHttp.responseText);	  
				//window.returnValue=update_dentist_comments_retVal; 
				//window.returnValue=remarks;
				window.close();	   
			} */
			}
		}
		//
		else if((document.forms[0].txtCheck.value).length > 200){
			alert(getMessage("APP-OH00014",'OH'));
		}
		else{
			var remarks = document.forms[0].txtCheck.value;
			window.returnValue=remarks;
			window.close();
		}
	}

	function setValue(){
		//var remarks = document.forms[0].txtCheck.value;
		window.returnValue='CL_REM';
		window.close();
	}

	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading
	  return sInString.replace( /\s+$/g, "" );// strip trailing
	}

	function displayRemarks(){
		if(document.forms[0].flagForPrint.value == "Y"){
			var formObj = document.forms[0];
			
			var patient_id = formObj.patient_id.value;
			var chart_num = formObj.chart_num.value;
			var oh_chart_level = formObj.oh_chart_level.value;
			var other_chart_facility_id = formObj.other_chart_facility_id.value;

			var remarks = "";

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getDentistComments&"+params,false);
			xmlHttp.send(xmlDoc);
			var dentist_comments_retVal = localTrimString(xmlHttp.responseText);

			dentist_comments_retVal = trimString(dentist_comments_retVal);
			dentist_comments_retVal = encodeURIComponent(dentist_comments_retVal);
		
			formObj.remarks.value = decodeURIComponent(dentist_comments_retVal);

			// added on 01/03/2010 for DECODE dentistComments 

			//var remarks = trimString(dentist_comments_retVal);
			//formObj.remarks.value = decodeURIComponent(remarks);

			//var res = checkSpl(formObj.remarks.value);
			if(formObj.remarks.value == "null" || formObj.remarks.value == null){
				document.getElementById("remarks_txt").value = "";
			}	
			else{
				document.getElementById("remarks_txt").value = formObj.remarks.value;
			}


			//window.returnValue=update_dentist_comments_retVal; 
			//window.returnValue = remarks;
		}
	}

	function replaceGreaterThan(){
		//var res = checkSpl(obj.value);
		var result_remarks = document.getElementById("remarks_txt").value;
		if(document.forms[0].flagForPrint.value == "Y"){
			document.getElementById("remarks_txt").value = result_remarks.replace(/>/g,""); 
		}
	}
	function checkSpl( val ) {
		var result = "" ;
		var ch = "" ;

		var indVal = 0;
		while ( (indVal = val.indexOf('\n',indVal)) != -1 )
		{
			val = val.replace("\n","\"")
		}

		var spChars = new Array( "<", ">", "&", "\"", "'") ;
		var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;") ;
		for(i=0; i<val.length; i++) {
			for(j=0; j<spChars.length; j++) {
				if ( val.substring(i,i+1) == spChars[j] ) {
					ch = chChars[j] ;
					j=spChars.length ;
				} else {
					ch = val.substring(i,i+1) ;
				}
			}
			result += ch ;
		}
		return result ;
	}  
	//End
	
/*
	function replaceQuote(){
	   var formObj = document.forms[0];
	   var str = formObj.remarks.value;
	   var repStr = str.replace(/\'/g,"#"); //s.replace(/\./g, "!"); 
	}
	*/

	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<% 
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
		if(remarks.equals("undefined") ){
			remarks = "";
		}
		String readOnly="";
		String disabled="";
		String readOnlyYN=checkForNull(request.getParameter("readOnlyYN"));
		if(readOnlyYN.equals("Y")){	   
			readOnly="readOnly";
			disabled = "disabled";
		}
		//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
		String flagForPrint = request.getParameter("flagForPrint"); //Dentist Comments
		String patient_id = request.getParameter("patient_id"); 
		String chart_num = request.getParameter("chart_num"); 
		String oh_chart_level = request.getParameter("oh_chart_level"); 
		String other_chart_facility_id = request.getParameter("other_chart_facility_id"); 
		String asOnDate = request.getParameter("asOnDate"); 
		String dentist_comments = request.getParameter("dentist_comments"); 
		//
		//remarks = remarks.replace(">","GRATERSIGN");
		//remarks = remarks.replace("<","LESSERSIGN");
		//StringBuffer comments = new StringBuffer();
		
		//comments.append(checkForNull(request.getParameter("remarks")));
		
	 %>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="displayRemarks()">
<form>
<table  cellspacing='0'>
<tr>
	<td>
		<!-- <textarea name='txtCheck' rows='5' cols='67' <%=readOnly%>  onblur='return replaceGreaterThan(this)' onBlur="makeValidString(this)" id='remarks_txt'><%=remarks%> </textarea> -->
		<textarea name='txtCheck' rows='5' cols='67' <%=readOnly%>  onBlur="makeValidString(this)" id='remarks_txt'><%=remarks%> </textarea>
	</td>
</tr>
<tr>
	<td class='MESSAGE' align='center'>
		<!-- <input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='replaceGreaterThan();windowClosing();' <%=disabled%>> -->
		<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowClosing();' <%=disabled%>>
		<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="setValue()">
		
</td>
</tr>
</table>
	<!--Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	Added for Dentist Comments-->
  <input type="hidden" name='flagForPrint' id='flagForPrint' value="<%=flagForPrint%>" >
  <input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>" >
  <input type="hidden" name='chart_num' id='chart_num' value="<%=chart_num%>" >
  <input type="hidden" name='oh_chart_level' id='oh_chart_level' value="<%=oh_chart_level%>" >
  <input type="hidden" name='other_chart_facility_id' id='other_chart_facility_id' value="<%=other_chart_facility_id%>" >
  <input type="hidden" name='remarks' id='remarks' value="<%=remarks%>" > 
  <input type="hidden" name='dentist_comments' id='dentist_comments' value="<%=dentist_comments%>" > 
  <input type="hidden" name='asOnDate' id='asOnDate' value="<%=asOnDate%>" > 
   <!-- -->
</form>
</body>
</HTML>

