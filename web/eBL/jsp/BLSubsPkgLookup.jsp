<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------

*/
%>
<%@page import="org.jaxen.util.FollowingAxisIterator"%>
<%@page import="javax.swing.plaf.metal.MetalIconFactory.FolderIcon16"%>
<%@page import="eCommon.XSSRequestWrapper"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<head>
<script type="text/javascript" src='../../eBL/js/BLModifyFinancialDetails.js'></script>
</head>
<%String queryString=request.getQueryString();
String title = request.getParameter("title");
request.setCharacterEncoding("UTF-8"); 
String called_for=request.getParameter("called_for");

String column_descriptions = request.getParameter("column_descriptions");
String column_sizes = request.getParameter("column_sizes");
String searchMainScreenVal = request.getParameter("searchMainScreenVal");
String strWhereColumnType = request.getParameter("strWhereColumnType");
String strWhereColumn = request.getParameter("strWhereColumn");
String searchFieldID = request.getParameter("searchFieldID");
String facility_id=request.getParameter("facility_id");
String seqNoString=request.getParameter("seqNoString");
String paramForQuery = request.getQueryString();

%>
<body>
	<div>
	<div class="lookupContainer" >
    	<div id="headerDiv" class="lookup-headercontainer" style="background-color: #00A0DD;">
			<div class="lookup-title"><%=title %></div>
			<input type="Button" class="icon-button" value="X" onclick="closePkgPopup()" >
			<!-- <div class="buttoncontainer">
				<span class="close-btn" onclick="closePopup()">X</span>
			</div> -->
		</div>
		<div id="searchDiv" class="lookup-subcontainer">
			<div>
				<input type="text" class="gridInputs"  id="searchText" placeholder='Find...' value='<%=searchMainScreenVal%>'>
				<button class="gridSerachIcon" type="button" id="pkgsrch"  onclick="searchPkg()" >
					<span class="mdi mdi-magnify"></span>
				</button>
			</div> 
		</div>
		<br>
		<div id="resultDiv" class="lookup-subcontainer">
    		<div class="table" id="pkgLkupResult" contenteditable="false">
    			
    		</div>
		</div>
		<div align="right">
			<input type="Button" class="btn btn-primary" value="OK" onclick="loadSelectedpackages()">
			<input type="Button" class="btn btn-primary" value="Cancel" onclick="closePkgPopup();" >
		</div>
    </div>
   </div>
</body>
    <input type="hidden" id="columndescriptions"  value="<%=column_descriptions %>">
    <input type="hidden" id="strWhereColmn" value="<%= strWhereColumn%>"/>
    <input type="hidden" id="strWhereColnTyp" value="<%= strWhereColumnType%>"/>
    <input type="hidden" id="searchText" value="<%=searchMainScreenVal %>"/>
    <input type="hidden" id="calledfor" value="<%=called_for%>" />
    <input type="hidden" id="searchField" value="<%=searchFieldID %>" /> 
    <input type="hidden" id="paramForQry" value="<%=paramForQuery %>"/>
     <input type="hidden" id="seqNoString" value="<%=seqNoString %>"/>
    <input type="hidden" id="facility" value="<%=facility_id %>"/> 
 <script type="text/javascript">
     $(document).ready(function(){
    	$('#modifyFinancialDetails').find('#pkgsrch').click()
    }); 
</script>
</html>