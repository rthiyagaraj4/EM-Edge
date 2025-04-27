<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad = "document.getElementById('search_text').focus()">
<form name="RecClinicalNotesChiefComplaintCriteriaForm" id="RecClinicalNotesChiefComplaintCriteriaForm">
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		 function CallDescFrame()
		 {
			var listval=document.getElementById("search_criteria");
			var listvalInd;
			for(var j=0; j<listval.options.length; j++)
			{
				if(listval.options[j].selected)
					listvalInd=listval.options[j].value;
			}
			var txtbox=document.getElementById("search_text").value;
			var radio="";
			if (document.RecClinicalNotesChiefComplaintCriteriaForm.order[0].checked)
			radio=document.RecClinicalNotesChiefComplaintCriteriaForm.order[0].value;
			else if (document.RecClinicalNotesChiefComplaintCriteriaForm.order[1].checked)
			radio=document.RecClinicalNotesChiefComplaintCriteriaForm.order[1].value;
			else
			radio=document.RecClinicalNotesChiefComplaintCriteriaForm.order[2].value;
			parent.frames[1].location.href='../../eCA/jsp/RecClinicalNotesChiefComplaintDetail.jsp?<%=request.getQueryString()%>&search_criteria='+listvalInd+'&radio='+radio+'&search_text='+escape(txtbox)
		 }
		 function valtext(comp)
		 {
			 parent.frames[1].document.location.href="../../eCommon/html/blank.html"
			 var txt=comp.value
			 var radvalue="";
             var len = document.RecClinicalNotesChiefComplaintCriteriaForm.order.length;
			
			 for(i=0;i<len;i++)
			 {
				 if(document.RecClinicalNotesChiefComplaintCriteriaForm.order[i].checked)
    			 radvalue= document.RecClinicalNotesChiefComplaintCriteriaForm.order[i].value
									
			 }
					
			 if (radvalue == "OL" && (comp.value=="" || comp.value==null))
			  alert(getMessage("SEARCH_TEXT_BLANK","Common"));	
			 else
				CallDescFrame(this);
		}

		function changeMan(Obj)
		{
         
		 if(Obj.value =="OL")
		 document.RecClinicalNotesChiefComplaintCriteriaForm.MandatoryText.style.display='inline'	 
		 else
         document.RecClinicalNotesChiefComplaintCriteriaForm.MandatoryText.style.display='none' 


		}


		</script>


</head>


<table align='center'  border="0" width=100% cellspacing='0' cellpadding='3'>
	
	<tr>
	  <!-- <td class='label'  ></td> -->
		<td   colspan=3  class="label"><fmt:message key="Common.Scope.label" bundle="${common_labels}"/>   
		<input type="radio" name="order" id="order" value="CE" onClick="changeMan(this)" checked><fmt:message key="Common.CurrentEncounter.label" bundle="${common_labels}"/>
		<input type="radio" name="order" id="order" value="AE" onClick="changeMan(this)"> <fmt:message key="eCA.AcrossEncounter.label" bundle="${ca_labels}"/> 
		<input type="radio" name="order" id="order" value="OL" onClick="changeMan(this)"><fmt:message key="Common.open.label" bundle="${common_labels}"/><fmt:message key="Common.List.label" bundle="${common_labels}"/> 
		</td>
	</tr>
	
	
	<tr>
		<!-- <td>&nbsp;&nbsp;</td> -->
		<td class='label' ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
			<input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text" value='' width=30% align="left" size='40' maxlength='70' >
			<img id="MandatoryText" style="display:none" src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td class='label'>
			<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
			<select name="search_criteria" id="search_criteria">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
		</td>
		<td ><input type="button" width='20%' align="left" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="valtext(search_text); " class='button' >		
		</td>
	</tr>
</table>
<BR>
<BR>
</form>
</body>
</html>

