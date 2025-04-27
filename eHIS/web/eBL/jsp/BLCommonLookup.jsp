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
<script type="text/javascript" src='../../eBL/js/BLCommonLookup.js'></script>
<script>
function resetLookupForm(){
	document.getElementById('searchText').value = "";
	document.getElementById('searchBy').selectedIndex = 0;
	document.getElementById('searchCriteria').selectedIndex = 0;
	
	/*if(document.getElementById('called_for').value == "PKG_DTLS_LKUP")
	{
		$('#pkgLkupResult').empty();
	}else{
		$('#popup-results').empty();
	}*/
	
	if($('#called_for').val() =='PAT_ID_LKUP'){
		$('#popup-results').empty();
	}
	
	if(($('#called_for').val()=='PAT_ID_LKUP' && $('#searchMainScreenVal').val()!='') || $('#called_for').val()!='PAT_ID_LKUP'){
    		 $('#modifyFinancialDetails').find('#Srch').click();
    }
}
</script>
</head>
<%
	String queryString=request.getQueryString();
	String title = request.getParameter("title");
	request.setCharacterEncoding("UTF-8");
	String column_names = "";
	String called_for = request.getParameter("called_for");
	String column_descriptions = request.getParameter("column_descriptions");
	String column_sizes = request.getParameter("column_sizes");
	String searchMainScreenVal = request.getParameter("searchMainScreenVal");
	String strWhereColumnType = request.getParameter("strWhereColumnType");
	String strWhereColumn = request.getParameter("strWhereColumn");
	String searchFieldID = request.getParameter("searchFieldID");
	if(searchFieldID==null) searchFieldID="";
	String facility_id=request.getParameter("facility_id");
	String paramForQuery = request.getQueryString();
	String srch_by_index = request.getParameter("srch_by_clmn_index");
	if(srch_by_index == null) srch_by_index="1";
	int srch_by_clmn_index = Integer.parseInt(srch_by_index);
	String col_show_hide = request.getParameter("col_show_hide");
	if(col_show_hide == null) col_show_hide=""; 
	String searchOpt=request.getParameter("searchOpt");
	if(searchOpt == null) searchOpt=""; 
	
	System.err.println("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&searchFieldID="+searchFieldID);
%>
<body>
	<div class="lookupContainer" >
    	<div id="headerDiv" class="lookup-headercontainer" style="background-color: #00A0DD;">
			<div class="lookup-title"><%=title %></div>
			<% if(called_for.equals("PKG_DTLS_LKUP")){ %>
			<input type="Button" class="icon-button" value="X" onclick="closePkgPopup()" >
			<%} else{ %>
			<input type="Button" class="icon-button" id='closeLookup' value="X" onclick="closePopup()" >
			<%} %>
			<!-- <div class="buttoncontainer">
				<span class="close-btn" onclick="closePopup()">X</span>
			</div> -->
		</div>
		<div id="searchDiv" class="lookup-subcontainer">
			<div class="col-11">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label-select">Search By</label>
						<select class="inputselect" id="searchBy" name="searchBy">
						
						<%if(called_for.equals("PAT_ID_LKUP")){%>
							<option class="label-select" selected value='PI'>Patient ID</option>
							<option class="label-select"  value='PN'>Patient Name</option>
						<%}else if(called_for.equals("ENC_ID_LKUP")){ %>
							<option class="label-select" selected value='EI'>Encounter ID</option>
							<option class="label-select"  value='PI'>Patient ID</option>						    
						<%}else if(called_for.equals("PKG_DTLS_LKUP")){%>
						   <option class="label-select" selected value='PC'>Package Code</option>
						   <option class="label-select"  value='PD'>Package Desc</option>
						   <option class="label-select"  value='PS'>Package SEQ</option>
						<%}else{%>
							<option class="label-select" id='description' value='desc'>Description</option>
							<option class="label-select" id='code' value='code'>Code</option>						    
					    <%}
						//selected %>
						 </select>
				</div>
			</div>
			<div class="col-11">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label-select">Search Criteria</label>
					<select class="inputselect" id="searchCriteria">
						<option class="label-select"  value="S">Starts with</option>
						<option class="label-select"  value="E">Ends with</option>
						<option class="label-select"  value="C">Contains</option>
					</select>
				</div>
			</div>
			<div class="col-11">
				<div class="input-wrapper inputLargeContainer">
					<label  class="label">Search Text</label>
					<input type="text" class="input" id="searchText" autocomplete="off" value='<%=searchMainScreenVal%>'>
				</div>
			</div>
			
		</div>
		<br>
		<div class="buttoncontainer" >
				<input type="Button" class="btn btn-primary"  id="Srch" value="Search" onClick="search();">
				<input type="Button" class="btn btn-primary"  value="Reset" onclick="resetLookupForm()" >&nbsp;&nbsp;
		</div>
    	<div id="resultDiv" class="lookup-subcontainer">
    	<%if(called_for.equals("PKG_DTLS_LKUP")){ %>
			<div class="table" id="pkgLkupResult" contenteditable="false">
			</div>
			<%}else{ %>
    		<div class="table" id="popup-results" contenteditable="false" style="display: none">
			</div>
			<%} %>
    	</div>
    </div>
   
    <input type="hidden" id="column_descriptions"  value="<%=column_descriptions %>">
    <input type="hidden" id="strWhereColumn" value="<%= strWhereColumn%>"/>
    <input type="hidden" id="strWhereColumnType" value="<%= strWhereColumnType%>"/>
    <input type="hidden" id="searchMainScreenVal" value="<%=searchMainScreenVal %>"/>
    <input type="hidden" id="called_for" value="<%=called_for%>" />
    <input type="hidden" id="searchFieldID" value="<%=searchFieldID %>" /> 
    <input type="hidden" id="paramForQuery" value="<%=paramForQuery %>"/>
    <input type="hidden" id="searchOpt" name='searchOpt' value="<%=searchOpt%>"/>
</body>
 <script type="text/javascript">
/*  $(document).ready(function(){
	 if(document.getElementById('searchOpt').value != "")
		document.getElementById('searchBy').value = document.getElementById('searchOpt').value;
	 if(($('#called_for').val()=='PAT_ID_LKUP' && $('#searchMainScreenVal').val()!='') || $('#called_for').val()!='PAT_ID_LKUP'){
		$('#modifyFinancialDetails').find('#Srch').click();
		// const myTimeout = setTimeout( $('#modifyFinancialDetails').find('#Srch').click(), 100000);
	 }
  }); */
 //var v=setTimeout(onloadfunc ,10000);
     
  	
     $('#closeLookup').click(function() {
	    	var searchFieldID=$('#searchFieldID').val();
	    	if(searchFieldID!=''){
	    		var srchArr=searchFieldID.split(',');
	    		if(srchArr.length>0){
	    			 document.getElementById(array[0]).value = '';
					 document.getElementById(array[1]).value = '';
	    		}
	    	}
	    });
</script>
</html>