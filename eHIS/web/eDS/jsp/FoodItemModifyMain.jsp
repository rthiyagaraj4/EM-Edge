<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%--@page import="eDS.FoodItemModifyServlet,java.util.ArrayList,java.util.HashMap, java.util.LinkedHashMap,java.text.SimpleDateFormat"--%>
<%@page import="java.util.ArrayList,java.util.HashMap, java.util.LinkedHashMap,java.text.SimpleDateFormat"%>
<%@page import="eDS.Common.DlQuery"%>
<%@page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*,eDS.*,eDS.Common.*" %>
<%@page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% String facility_id = (String)session.getAttribute("facility_id");
HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		String Modified_By_Id	=  (String) httpSession.getValue("login_user");
		String Modified_At_Ws_No ="";
		Modified_At_Ws_No=p.getProperty("client_ip_address");


 %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/FooditemModify.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<!--<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>
<style type="text/css">
		@import url(../../eDS/css/skin.css);		
		@import url(../../eDS/css/css2/themes/winxp/skin.css);
		
	.multiselect {
    width:20em;
    height:15em;
    border:solid 1px #c0c0c0;
    overflow:auto;
}
 
.multiselect label {
    display:block;
}
 
.multiselect-on {
    color:#ffffff;
    background-color:#000099;
}
		
</style>		
<body onload=""  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!--<form name="menuAssign_form" id="menuAssign_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.FoodItemModifyServlet" method="post" target="messageFrame">-->
<form name="menuAssign_form" id="menuAssign_form"  onload='FocusFirstElement()'   method="post" target="messageFrame">
	<%
	
	String fetchedMealTypes = "";
	String fetchedDietTypes="";
	
	%>
		
	<body>
	<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="height: 100px;>				
     			<tr>		
				   <td align="left" class="label" colspan="2">
						<fmt:message key="eDS.ExistingItem.Label" bundle="${ds_labels}" />							
						<input type="hidden" name="ExistingFoodItem" id="ExistingFoodItem" value="">
						<input type="text" name="ExistingFoodDesc" id="ExistingFoodDesc" value="" onblur="if(this.value!='')ItemLookup(this);else ExistingFoodItem.value=''"/>
						<input type="button" name="existinglookup" id="existinglookup" value="?" onClick='ItemLookup(document.getElementById("ExistingFoodDesc"));' class="Button"/>
						<img src='../../eCommon/images/mandatory.gif'></img>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  <fmt:message key="eDS.NewItem.Label" bundle="${ds_labels}" />	
                                          <!--Modified against ICN-64263-->				  
					  <input type="hidden" name="NewFoodItem" id="NewFoodItem" value="">
					  <input type="text" name="NewFoodDesc" id="NewFoodDesc" value="" onblur="if(this.value!='')ItemLookupNew(this);else NewFoodItem.value=''"/ >
					  <input type="button" name="newlookup" id="newlookup" value="?" onClick='ItemLookupNew(document.getElementById("NewFoodDesc"));' class="Button"/ >
					  <img name="newitemmandatory" id="newitemmandatory" src='../../eCommon/images/mandatory.gif' ></img>
				  </td>
					
			   
			     <td align="right" colspan="4">
	                 <input style=" margin-right: 40px;" type="button" name="button1" id="button1" value="<fmt:message key="Common.search.label" bundle="${common_labels}" />" class="button" onClick="search()"/>				
			    </td>
	    	</tr>
				
               <tr>
				<td align="left" class="label" colspan="2">
				   <span id="diettypelabel"><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></span>
				   <span id="diettypelink" style="display: none;"><a href="javascript:dietTypeFoodItems('<%=fetchedDietTypes%>');" style="text-decoration:underline"><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></a></span>
				   <input id="dietTypesId" type="button" value="..." onclick="return dietTypeFoodItems('<%=fetchedDietTypes%>');"/>
				   <img id="dietfilter" src='../../eCA/images/filter.gif' style="display: none;"></img>				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   
				     <span id="mealtypelabel"><fmt:message key="eDS.mealType.Label" bundle="${ds_labels}" /></span>
					<span id="mealtypelink" style="display: none;"><a href="javascript:mealTypeSpFoodItems('<%=fetchedMealTypes%>');" style="text-decoration:underline"><fmt:message key="eDS.mealType.Label" bundle="${ds_labels}" /></a></span>
					<input id="mealTypesId" type="button" value="..." onclick="return mealTypeSpFoodItems('<%=fetchedMealTypes%>');"/>
					 <img id="mealfilter" src='../../eCA/images/filter.gif' style="display: none;"></img>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
					<a id="clearFilter" href="javascript:clearFilter()" style="display: none;text-decoration:underline">Clear Filter</a>
				</td>							
			</tr>           

     </table>	
	 
	<script>
 /*jQuery.fn.multiselect = function() {
    $(this).each(function() {
        var checkboxes = $(this).find("input:checkbox");
        checkboxes.each(function() {
            var checkbox = $(this);
            if (checkbox.prop("checked"))
                checkbox.parent().addClass("multiselect-on"); 
            checkbox.click(function() {
                if (checkbox.prop("checked"))
                    checkbox.parent().addClass("multiselect-on");
                else
                    checkbox.parent().removeClass("multiselect-on");
            });
        });
      });
   };
	
	$(function() {
     $(".multiselect").multiselect();
    });*/
	</script>		
	    <input type="hidden" name="language_id" id="language_id" value="<%=locale%>"/>
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"/>
		<input type="hidden" name="Modified_By_Id" id="Modified_By_Id" value="<%=Modified_By_Id%>"/>
		<input type="hidden" name="Modified_At_Ws_No" id="Modified_At_Ws_No" value="<%=Modified_At_Ws_No%>"/>
		<input type="hidden" name="diettype" id="diettype" value=""/>
		<input type="hidden" name="mealtype" id="mealtype" value=""/>
	    <input type="hidden" name="dietcode" id="dietcode" value=""/>
		<input type="hidden" name="mealcode" id="mealcode" value=""/>
		<input type="hidden" id="selectedMenus" value=""/>
		<input type="hidden" id="removedMenus" value=""/>
		<input type="hidden" name="searchexisting_itemcode" id="searchexisting_itemcode" value=""/>
		
   </form>
</body>
</html>


