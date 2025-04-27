<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesFieldResponse"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="eOR.OrderEntryQueryBean"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import=" eIPAD.chartsummary.clinicalnotes.dao.*"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<% 
String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
String text_type = request.getParameter("text_type")==null?"":request.getParameter("text_type");
String sec_hdg_code=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

if(patientContext!=null){	
	ClinicalNotesBC ClinicalNotesbc = new ClinicalNotesBC();
	ClinicalNotesFieldResponse resClinicalNotes;	
	resClinicalNotes=ClinicalNotesbc.getCannedTextList(patientContext,note_type,sec_hdg_code,service_code,text_type);
	List<ClinicalNotesFieldItem> noteTypeList = resClinicalNotes.getFieldList(); 	
%>
<style>
.vscroller5{
	width: 100%;
	height: auto;
	position: absolute;
	z-index: 1;
}
.cannedTextrow
{
	height: 40px;
	border-bottom: #e1e1e1 1px solid;
	background-color: #f7f7f7;	
}

.cannedTextcode
{
	float:left;
	color:#797b7c;
	font-size: 12px;
	font-family:Arial;
	width: 100%;
	font-weight:bold;
	padding: 2px 10px;
}

.cannedTextdesc
{
	float: left;
	color:#797b7c;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	width: 92%;
	padding: 2px 10px;
	font-family: arial;
	font-size: 12px;
}
.cannedTextselect
{
	position: relative;
	right:17px;
	display: inline-block;
	width: 8px;
	height:17px;
	top:10px;
	left:12px;
}
.cannedTextContent
{
	position: relative;
	width: 100%;
	height:100%;
	overflow: auto;
}
</style>
<script>
$(document).ready(function(){
	assignNoteListContentsScroll()

});



</script>

<div style="display:table;width:100%;height:100%;table-layout: fixed;">
   <div style="display:table-row">
      <div style="display:table-cell;width:100%;height:98%">
         <div id="OrdItemContentsWrap" class="cannedTextContent" >
            <div style="display:block" >
               <%						
                  for(int i=0;i<noteTypeList.size();i++) {
                  	ClinicalNotesFieldItem fieldItem = noteTypeList.get(i);					
			String strDesc=fieldItem.getDesc();
			strDesc=strDesc.replace("<ADDRESS>","");
			strDesc=strDesc.replace("</ADDRESS>","");
                  %>
               <div class="cannedTextrow"  onclick="selectCanText(this)"  >
                  <div style="width: 92%;">
                     <span  class="cannedTextcode" >  <%=fieldItem.getCode()%></span>
                     <span style="display:none" id="CL<%=i%>" class="data"><%=strDesc%></span>
                     <input type="hidden" name="TL<%=i%>" id="TL<%=i%>"  id="TL<%=i%>" value=""/>
                     <script>
                        var temp_text=document.getElementById("CL<%=i%>").innerText;
                        if(temp_text.length>100)
                        	temp_text= temp_text.substring(0, 100);
                        
                        document.getElementById("TL<%=i%>").value=temp_text ;
                     </script> 	
                     <span id="Temp<%=i%>"  class="cannedTextdesc"> <%=fieldItem.getDesc()%> </span>
                     <script>
						//alert(document.getElementById("TL<%=i%>").value )
                        document.getElementById("Temp<%=i%>").innerHTML=document.getElementById("TL<%=i%>").value ;
                     </script>	
                  </div>
                  <div id="CL<%=fieldItem.getCode()%>" class="cannedTextselect"> 
                  </div >
               </div>
               <%} %>	
            </div>
         </div>
      </div>
   </div>
</div>

<%} %>
	

