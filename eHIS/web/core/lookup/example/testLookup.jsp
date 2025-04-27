<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
			argArray[2] = valuesArray;<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="/framework/html/Tag.text"%>

<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/DynaLookup.js'></script>
	
	   <script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<ibaHTML:html locale="true">

<script>
		function showLookup(val){
			var argArray = new Array();
			var namesArray = new Array("effStatus");
			var valuesArray = new Array("E");
			var datatypesArray = new Array();
			argArray[0] = "countryLookupQuery";
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			
			//Display Order
			argArray[3] = DESC_CODE;
//BAHRAIN
			// Link Description
			argArray[4] = DESC_LINK;
			argArray[5] = "";
			 	
			alert(Lookup("Title",argArray))
		}
</script>
<body>
	<form>
		<ibaHTML:text property="queryId" value="" />
		
		<ibaHTML:text property="queryId" value="" style="direction:rtl"/>
		<input type="button" name="click" id="click" value="?" onClick="showLookup(this.value)" />
	</form>
</body>
</ibaHTML:html>

