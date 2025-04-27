<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.common.constants.WidgetItems"%>
<%@page import="eIPAD.HealthObjects.PatientContext"%>
<%@page import="eIPAD.chartsummary.common.response.WidgetOrderResponse"%>
<%@page import="eIPAD.chartsummary.common.bc.WidgetOrderBC"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<% String widgetList=request.getParameter("mode")==null?"":request.getParameter("mode");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
WidgetOrderBC bc = new WidgetOrderBC();
WidgetOrderResponse widgetOrderResp = new WidgetOrderResponse();



if(widgetList.equalsIgnoreCase("restore")){
	widgetOrderResp = bc.getDefaultWidgetOrder(patientContext);
	
}else{
	
	 widgetOrderResp = bc.getUserWidgetOrder(patientContext);
}



ArrayList<WidgetItems> allPrefered = new ArrayList();

int activeCount=0;
int InactiveCount=0;

ArrayList<WidgetItems> allPreferncescativeAll =  widgetOrderResp.getActiveWidgets();

activeCount=allPreferncescativeAll.size();



for(int u=0;u<allPreferncescativeAll.size();u++){
	 
	 WidgetItems currentItem = allPreferncescativeAll.get(u); 
	 allPrefered.add(currentItem);
	 
}


ArrayList<WidgetItems> allPreferncesIncativeAll =  widgetOrderResp.getInactiveWidgets();

InactiveCount=allPreferncesIncativeAll.size();


for(int u=0;u<allPreferncesIncativeAll.size();u++){
	 
	 WidgetItems currentItem = allPreferncesIncativeAll.get(u); 
	 allPrefered.add(currentItem);
	 
}



%>
<div class="widgetTableUser">
<div class="mainwidget" >
<div class="widgetBackGroundLayer">
</div>
<div class="widgetListWarpper" id="widgetListWarpper" style="">
<div class="widgetListWarppers" id="widgetListWarppers" style="">
<div class="widgetHeader">


<% if(widgetList.equalsIgnoreCase("Normal")){%>
<div class="widgetHeaderRows">

<div class="widgetHeadercellLable" >
Widget List
</div>
<div class="widgetHeadercellButton" style="text-align:right;">
   <div class="userPrefWidgetButtonTheme" style="float:right;" data-role="none" onclick="CallEditSummary()">
    <img style="height:27px;" src="${path}/eIPAD/images/ModifiedW24x24.png">
   </div>
</div>



</div>


<% }else{%>


<div class="widgetHeaderRows">
    <div class="widgetHeadercellLableEdit" >
     Widget List
    </div>
    <div class="widgetHeadercellButton">
            <div class="userPrefWidgetButtonTheme" style="float:left;" data-role="none" onclick="restoreClick('Edit')">
               <img src="${path}/eIPAD/images/Reload24x24.png" style="height:16px;padding:5px;">
            </div>
			<div style="float:left;width:5px;height:28px;">
			</div>
            <div class="userPrefWidgetButtonTheme" style="float:left;" data-role="none" onclick="confirmUserSummary()">
               <img src="${path}/eIPAD/images/CS_Ok16x16.png" style="height:16px;padding:5px;">
            </div>
			<div style="float:left;width:5px;height:28px;">
			</div>
            <div class="userPrefWidgetButtonTheme" style="float:left;" data-role="none" onclick="closeUserEditSummary()">
               <img src="${path}/eIPAD/images/CS_Close16x16.png" style="height:16px;padding:5px;">
			</div> 
            <div style="clear: both;"></div>			
	</div>
</div>

<%} %>
</div>

<div id="allActiveAndIncative" class="allActiveAndIncative">

<div class="activeList">

<!-- table -->
<div class="MenuList" >

<div class="MenuListItemLable" >
<div class="MenuListItemLableCell" >
ACTIVE WIDGETS
</div>
</div>

<!-- table row -->
<div class="MenuListItem" >

 <div id="sortable-handlers">
 <%

 
 ArrayList<WidgetItems> allPreferncescative =  widgetOrderResp.getActiveWidgets();
 ArrayList<WidgetItems> allPrefernces_idcative =  widgetOrderResp.getActiveWidgets();
 
 
 

 /*
 allPrefernces.add("Latest vitals");
 allPrefernces.add("Allergies");
 allPrefernces.add("Procedure details");
 allPrefernces.add("Active Problem");
 allPrefernces.add("Clinical Notes");
 allPrefernces.add("Results");
 allPrefernces.add("Pending Orders");
 allPrefernces.add("Current Medication");

 
 allPrefernces_id.add("Latestvitals");
 allPrefernces_id.add("Allergies");
 allPrefernces_id.add("Proceduredetails");
 allPrefernces_id.add("ActiveProblem");
 allPrefernces_id.add("ClinicalNotes");
 allPrefernces_id.add("Results");
 allPrefernces_id.add("PendingOrders");
 allPrefernces_id.add("CurrentMedication");
 */
 
 
 for(int u=0;u<allPrefered.size();u++){
	 
	 WidgetItems currentItem = allPrefered.get(u); 
	 
	 String preferncesValue=currentItem.getWidgetId();
	 
	 String prefernces_id=currentItem.getWidgetId();
	 
	 String Style="display:none;";
	 
	
	 
	  String visible="N";
	 if(activeCount>=u+1){
		 
		 Style="";
		 visible="Y";
		 
	 }
	 

	 
 
 
 %>
 
 <% 
String imageSrc="";
 

if(prefernces_id.equalsIgnoreCase(currentItem.VITALS.getWidgetId())){
	imageSrc="Userpref_Latestvitals24x24.png";
	preferncesValue="Latest vitals";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.ALLERGY.getWidgetId())){
	imageSrc="Userpref_Allergies24x24.png";
	preferncesValue="Allergies";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.PROCEDURE.getWidgetId())){
	
	imageSrc="Userpref_Proceduredetails24x24.png";
	preferncesValue="Procedure details";
}else if(prefernces_id.equalsIgnoreCase(currentItem.PROBLEMS.getWidgetId())){
	imageSrc="Userpref_Activeproblems_diagnosis24x24.png";
	preferncesValue="Active Problems & Diagnosis";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.NOTES.getWidgetId())){
	
	imageSrc="Userpref_Clinicalnotes24x24.png";
	preferncesValue="Clinical Notes";
}else if(prefernces_id.equalsIgnoreCase(currentItem.RESULTS.getWidgetId())){
	imageSrc="Userpref_Results24x24.png";
	preferncesValue="Results";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.PENDINGORDERS.getWidgetId())){
	imageSrc="Userpref_Pendingorders24x24.png";
	preferncesValue="Pending Orders";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.MEDICATIONS.getWidgetId())){
	
	imageSrc="Userpref_Currentmedication24x24.png";
	preferncesValue="Current Medication";
}


%>
 
 <% if(widgetList.equalsIgnoreCase("Normal")){%>
 <div class="sortableNormal" style="<%=Style%>" onclick="movetoSelectedWidgets('<%=prefernces_id%>');"  data-usercode=" <%=prefernces_id%> ">
                    <!-- table cell drag icon area -->

<div class="MenuItemTable">
<div class="MenuItemRow">
<div class="MenuItemDragIcon" >
<div class="dynamicImage"> 


<img src="${path}/eIPAD/images/<%=imageSrc%>"> 
</div>

</div>

<!-- table cell lable area -->

<div class="MenuItemlabelIcon" >



<div >
   
  <%= preferncesValue %>  
</div>

</div>

<!-- table cell Count Minus area -->
<% if(!prefernces_id.equalsIgnoreCase("VITALS")){ %>
<div class="MenuItemCountMinus" >

<div style="background-color:#23789e;text-align: center;-webkit-border-radius: 11px;height: 25px;width: 36px;float: right;">
    <div id="countDisplay<%=prefernces_id%>"  class="DisplayStyle">0</div>
</div>

<div style="clear: both;"></div>

</div>
  <% } %>
</div>
        
        </div>
        
                    
</div>
  
 
  
   
<% }else {%>

 <div class="sortable" style="<%=Style%>"  id="<%=prefernces_id%>" data-id="<%=prefernces_id%>" data-visible="<%=visible %>"  data-usercode="<%=prefernces_id%>"> 
                    <!-- table cell drag icon area -->

<div class="MenuItemTableEdit">
<div class="MenuItemRowEdit">
<div class="MenuItemDragIconEdit" >



<div class="dragImageEdit"> 

</div>
<div class="dynamicImageEdit"> 
<img src="${path}/eIPAD/images/<%=imageSrc%>"> 
</div>

</div>

<!-- table cell lable area -->

<div class="MenuItemlabelIconEdit" >



<div >
   
  <%= preferncesValue %>  
</div>

</div>

<!-- table cell Count Minus area -->

<div class="MenuItemCountMinusEdit" >

<div class="userMinusImageEdit" onclick="clickMinus('<%=prefernces_id%>');">
    
               
</div>

<div style="clear: both;"></div>

</div>

</div>
        
        </div>
        
                    
</div>
 <% }%> 

    <% }%>                 
  </div>
                
                



</div>


</div>

</div>

<div class="inactiveList">



<!-- table -->
<div class="MenuList" >

<div class="MenuListItemLable" >

<div class="MenuListItemLableCell" >
INACTIVE WIDGETS
</div>
</div>

<!-- table row -->
<div class="MenuListItem" >

 <div id="sortable-basic-Inactive">
 <%

 
 ArrayList<WidgetItems> allPreferncesIncative =  widgetOrderResp.getInactiveWidgets();
 ArrayList<WidgetItems> allPrefernces_idIncative =  widgetOrderResp.getInactiveWidgets();
 
 /*
 allPrefernces.add("Latest vitals");
 allPrefernces.add("Allergies");
 allPrefernces.add("Procedure details");
 allPrefernces.add("Active Problem");
 allPrefernces.add("Clinical Notes");
 allPrefernces.add("Results");
 allPrefernces.add("Pending Orders");
 allPrefernces.add("Current Medication");
*/

/*
  allPrefernces_id =new ArrayList();
  
 allPrefernces_id.add("Latestvitals_E");
 allPrefernces_id.add("Allergies_E");
 allPrefernces_id.add("Proceduredetails_E");
 allPrefernces_id.add("ActiveProblem_E");
 allPrefernces_id.add("ClinicalNotes_E");
 allPrefernces_id.add("Results_E");
 allPrefernces_id.add("PendingOrders_E");
 allPrefernces_id.add("CurrentMedication_E");
 */
 int pos=allPrefered.size();
 
 for(int u=0;u<allPrefered.size();u++){
	 
	 //pos=allPrefered.size();
	 
	 WidgetItems currentItem = allPrefered.get(u); 
	 
 String preferncesValue=currentItem.getWidgetId();
 
 String prefernces_id=currentItem.getWidgetId();
 
 String Style="display:none; background:#023c59; opacity:0.7";
 String visible="N";
 
 
 
 pos--;
 
 
 

 
 if(InactiveCount>pos){
	 
	 Style="background:#023c59; opacity:0.7";
	 visible="Y";
 }
 
 
 %>
 <% 
String imageSrc="";

 if(prefernces_id.equalsIgnoreCase(currentItem.VITALS.getWidgetId())){
		imageSrc="Userpref_Latestvitals24x24.png";
		preferncesValue="Latest vitals";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.ALLERGY.getWidgetId())){
		imageSrc="Userpref_Allergies24x24.png";
		preferncesValue="Allergies";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PROCEDURE.getWidgetId())){
		
		imageSrc="Userpref_Proceduredetails24x24.png";
		preferncesValue="Procedure details";
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PROBLEMS.getWidgetId())){
		imageSrc="Userpref_Activeproblems_diagnosis24x24.png";
		preferncesValue="Active Problems & Diagnosis";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.NOTES.getWidgetId())){
		
		imageSrc="Userpref_Clinicalnotes24x24.png";
		preferncesValue="Clinical Notes";
	}else if(prefernces_id.equalsIgnoreCase(currentItem.RESULTS.getWidgetId())){
		imageSrc="Userpref_Results24x24.png";
		preferncesValue="Results";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PENDINGORDERS.getWidgetId())){
		imageSrc="Userpref_Pendingorders24x24.png";
		preferncesValue="Pending Orders";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.MEDICATIONS.getWidgetId())){
		
		imageSrc="Userpref_Currentmedication24x24.png";
		preferncesValue="Current Medication";
	}


%>


 <% if(widgetList.equalsIgnoreCase("Normal")){%>
 <div class="sortableNormal"  style="<%=Style%>"    data-usercode=" <%=prefernces_id%> ">
                    <!-- table cell drag icon area -->

<div class="MenuItemTable">
<div class="MenuItemRow">
<div class="MenuItemDragIcon" >
<div class="dynamicImage"> 


<img src="${path}/eIPAD/images/<%=imageSrc%>"> 
</div>

</div>

<!-- table cell lable area -->

<div class="MenuItemlabelIcon" >



<div >
   
  <%= preferncesValue %>  
</div>

</div>

<!-- table cell Count Minus area -->
<!--

<div class="MenuItemCountMinus" >

<div style="
    position: relative;
    background-color:#23789e;
    text-align: center;
    border-radius: 44%;
    height: 21px;
    width: 38px;
    float: right;
    ">
    
               <div id="countDisplay<%=prefernces_id%>"  class="DisplayStyle">0</div>
               
             
</div>

<div style="clear: both;"></div>

</div>

 -->
</div>
        
        </div>
        
                    
</div>
  
 
  
   
<% }else {%>
 <div class="sortableInactive"   style="<%=Style%>"   id="<%=prefernces_id%>_E" data-id="<%=prefernces_id%>_E"  data-visible="<%=visible %>" data-usercode="<%=prefernces_id%>">
                    <!-- table cell drag icon area -->

<div class="MenuItemTableEdit">
<div class="MenuItemRowEdit">
<div class="MenuItemDragIconEdit" >



<div class="dragImageEdit"> 

</div>
<div class="dynamicImageEdit"> 
<img src="${path}/eIPAD/images/<%=imageSrc%>"> 
</div>

</div>

<!-- table cell lable area -->

<div class="MenuItemlabelIconEdit" >



<div >
   
  <%= preferncesValue %>  
</div>

</div>

<!-- table cell Count Minus area -->

<div class="MenuItemCountMinusEdit" >

<div class="userAddImageEdit" onclick="clickADD('<%=prefernces_id%>_E');">
    
               
</div>

<div style="clear: both;"></div>

</div>

</div>
        
        </div>
        
                    
</div>
 <% }%>
  
  <% }%>
  
   


                    
  </div>
                
                



</div>


</div>

</div>

</div>

<%-- <div class="restore" onclick="restoreClick('<%=widgetList%>');">
<div class="restoreRow">
<div class="restoreicon">
<img src="${path}/eIPAD/images/Userpref_Remove21x21.png"> 
</div>
<div class="restorelable">

restore to default
</div>

</div>
</div> --%>

</div>
</div>
<div class="nonClickableWarpper" id="backGroundWrapper" onclick="closeUserSummary()"style="">

</div>
</div>
