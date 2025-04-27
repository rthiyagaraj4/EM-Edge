<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<%
String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
String curr_section_type = (request.getParameter("child_section_type") == null) ? "" : request.getParameter("child_section_type");

%>

 
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sample Page</title>
<link rel="stylesheet" href="kendo.common.min.css" />
    <link rel="stylesheet" href="kendo.default.min.css" />
    <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
    <script src="kendo.all.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class="mbody">   -->

<form id="CNSectionTemplateForm" name="CNSectionTemplateForm" id="CNSectionTemplateForm" method="post" action="" class="mform row">                               
	<div id="NoteSectBodyWrapper" style="position: absolute;z-index: 1;width: 100%;height: 100%;overflow: hidden;">
	   <div style="position: absolute;z-index: 1;width: 100%;">
	      <c:import url="/eIPAD/jsp/xsl/RecClinicalNotesTemplateRecordingView.xsl" var="MCN_xsltTemplate" />
	      <c:import url="/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplateXML.jsp?<%=request.getQueryString()%>" var="MCN_TemplateXML" />
	      <c:choose>
	      <c:when test="${fn:trim(MCN_TemplateXML) != ''}">
		  <x:transform doc="${MCN_TemplateXML}" xslt="${MCN_xsltTemplate}" />
	      </c:when>
	      <c:otherwise>
		<div style="position: absolute;z-index: 1;width: 100%; padding-top: 20px; text-align:center; color:#a3a3a3;">
		 	Empty section template configured. No fields available to display
		 	</div> 
	      </c:otherwise>
	      </c:choose>
	   </div>
	</div>
	<input type="hidden" id="section_code" name="section_code" id="section_code" value="<%=curr_sec_hdg_code%>"/>      
	<input type="hidden" id="child_section_code" name="child_section_code" id="child_section_code" value="<%=curr_child_sec_hdg_code%>"/>    
	<input type="hidden" id="child_section_type" name="child_section_type" id="child_section_type" value="<%=curr_section_type%>"/>                    
</form>

<script>

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

var clinicalNotesSectBodyScroll;
function assignclinicalNotesSectBodyScroll() {
	clinicalNotesSectBodyScroll = new IScroll('#NoteSectBodyWrapper', { 
		scrollX: true, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: false,
		useTransition: false,
		bindToWrapper: true,
		preventDefaultException: {tagName:/.*/},
		onBeforeScrollStart: function (e) {
var target = e.target;
while (target.nodeType != 1) target = target.parentNode;
if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
e.preventDefault();		
	}});
	clinicalNotesSectBodyScroll.refresh();
}
var clinicalNotesMatrixScroll;
function assignMatrixScroll(){
  var getMatID;

  $("table[data-matrix]").each( function (index, value) {

	    getMatID =$(this).attr('data-matrix');	
	     

	    clinicalNotesMatrixScroll = new IScroll("#"+getMatID, { 
	   	scrollX: true, 
	   	scrollbars: false,
	   	interactiveScrollbars: true,
	   	click: true,
	   	useTransition: false,
	   	bindToWrapper: true
	   });

  });

}



var clinicalNotesGridScroll;
function assignGridScroll(){
 
  $("div[id~='gridScroll']").each(function (i, el) {
         var gridID = $(this).find("table").attr("id");
	     console.log("gridID::", gridID);
	
		clinicalNotesGridScroll = new IScroll("#"+gridID, { 
	   	  scrollX: true, 
	   	  scrollbars: false,
	   	  interactiveScrollbars: true,
	   	  click: true,
	   	  useTransition: false,
	   	  bindToWrapper: true,
		  preventDefaultException: {tagName:/.*/},
		onBeforeScrollStart: function (e) {
var target = e.target;
while (target.nodeType != 1) target = target.parentNode;
if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
e.preventDefault();		
	}
	    });
		 
		 
     });

  
  

  
}



//To be revisited on later point of time.
$(document).ready(function(){
	
	setTimeout(function(){
		assignclinicalNotesSectBodyScroll()
	},500);
    
	assignMatrixScroll();
	assignGridScroll();
	
});
	
	
</script>
               

<!-- </body>
</html> -->

