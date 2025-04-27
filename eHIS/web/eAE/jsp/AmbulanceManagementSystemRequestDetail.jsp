<!DOCTYPE html>
<!-- To display Ambulance Request Details - 4/14/2009 -->

	<div id='bottomLeft' class='Bottom-Inner-Left' style='display:inline'>
    <input type=hidden id='ambTripSheetNo' name='ambTripSheetNo' id='ambTripSheetNo'> 
	<input type=hidden id='ambUom' name='amb_uom' id='amb_uom' value=''> 
	<input type=hidden id='amb_prefix_ind' name='amb_prefix_ind' id='amb_prefix_ind'>
	<table border=0 width="100%" height="95%" cellspacing="0" cellpadding="0" style=''>
	<tr><td colspan=4 class=label>&nbsp;</td></tr>
	<tr id='nocRow'>
		<td class=label width='22%'><fmt:message key="eAE.NatureOfCall.label" bundle="${ae_labels}"/></td>
		<td class=label >
		<div id="nocAutoComplete">
			<input id="nocInput" name="Nature_Of_Call" id="Nature_Of_Call" type="text" class=text-box-mand   maxlength='6' onfocus='assignCurEle(this)' >
			<input id="nocInputCode" name="amb_nature_call_code" id="amb_nature_call_code" type="hidden">
			<div id="nocContainer"></div>
		</div>
		</td>
		<td class=label align='right'><fmt:message key="Common.priority.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=label align='left'>
			<div id="priorityAutoComplete">
				<input id="priorityInput" name="Priority" id="Priority" type="text" class=text-box  onfocus='assignCurEle(this)' >
				<div id="priorityContainer"></div>
			</div>
		</td>
	</tr>
	<tr>
		<td class=label align='left' nowrap><fmt:message key="eAE.PickupLocation.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class=label colspan=3>
			<input type='radio'   name='Pickup_Location' id='Pickup_Location' id='pickUpLocn' value='Y' onClick='clearLocn(this);' checked><fmt:message key="Common.external.label" bundle="${common_labels}"/>
			<input type='radio'   name='Pickup_Location' id='Pickup_Location' id='pickUpLocn' value='N' onClick='getLocn(this);'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class=label>&nbsp;</td>
		<td colspan=3 class=pad >
			<div id="locnAutoComplete">
				<input id="locnInput" name="pickup_locn_desc" id="pickup_locn_desc" type="text"  maxlength='60' value='' class=text-box onblur="insertMapVals();" onKeyPress='return CheckSpecChars(event);' onfocus='assignCurEle(this)'>
				<input name="pickup_locn_code" id="pickup_locn_code" id="locnInputCode" type="hidden" value="">
				<div id="locnContainer"></div>
			</div>
		</td>
	</tr> 
	<tr id='pickUpAddRow' style='display:none'>
		<td class=label align='left'><fmt:message key="Common.Address.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan=3 class=label >
		<textarea  class='text-area' WRAP=PHYSICAL id='pickUpAddress' maxlength='2000'  name='Pickup_Address'  onKeyPress='return CheckSpecChars(event);checkMaxLimit(this,2000)' onBlur="makeValidString(this)" onkeyup='chopText(this,2000)' onchange='chopText(this,2000)' onfocus='assignCurEle(this)'></textarea>
		</td>
	</tr>
	<tr id="trPickUpTime">
		<td class=label align='left'><fmt:message key="eAE.PickupTime.label" bundle="${ae_labels}"/></td>
		<td class=label ><fmt:message key="eAE.Immediate.label" bundle="${ae_labels}"/>&nbsp;&nbsp;<input type='checkbox'  id='immdtly' name='immdtly' id='immdtly' align='ABSBOTTOM' onclick='setPicupTime(this,"pickupTime")'></td><td class=label colspan=2 align='left'><input type='text' class='text-box-nkb' name='Pickup_Time' id='Pickup_Time' id='pickupTime' size='19'maxLength='19' onblur='if(document.getElementById("mode").value!="update") validateDate(this,"true");' value=''><img  class=img align='ABSBOTTOM' src="../../eAE/images/Calendar.gif"  onClick="document.getElementById("Pickup_Time").focus();return showCalendar('Pickup_Time',null,'hh:mm',true);">
	</tr>
	<tr id="trPickUpTimeText" style="display:none">
		<td class=label align='left' ><fmt:message key="eAE.PickupTime.label" bundle="${ae_labels}"/></td>
		<td class=label id="tdPickUpTime" style="font-weight:bold"></td>
	</tr>
	<tr>
		<td class=label align='left' nowrap><fmt:message key="eAE.DroppingLocation.label" bundle="${ae_labels}"/>&nbsp</td>
		<td class=label colspan=3 align='left'>
			<input type='radio' name='Dropping_Locn' id='Dropping_Locn' id='dropLocn' value='Y' checked onClick='clearLocn(this);'><fmt:message key="Common.external.label" bundle="${common_labels}"/> 
			<input type='radio' name='Dropping_Locn' id='Dropping_Locn' id='dropLocn' value='N'onClick='getLocn(this);'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class=label>&nbsp;</td>
		<td colspan=3 class=pad>
		<div id="toLocnAutoComplete">
				<input id="toLocnInput" name='Dropping_Location' id='Dropping_Location' maxlength='60' type="text"  value=''class=text-box onKeyPress='return CheckSpecChars(event);' onfocus='assignCurEle(this)'> 
				<input name="destn_locn_code" id="destn_locn_code" id="toLocnInputCode" type="hidden">
				<div id="toLocnContainer"></div>
			</div>
		</td>
	</tr>
	<tr id='dropAddRow' style='display:none'>
		<td class=label align='left'><fmt:message key="Common.Address.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=label colspan=3 >
		<textarea class='text-area' WRAP=VIRTUAL id='dropAddress' maxlength='2000'  name='Drop_Address'  onKeyPress='return CheckSpecChars(event);checkMaxLimit(this,2000)' onBlur="makeValidString(this)" onkeyup='chopText(this,2000)' onchange='chopText(this,2000)' onfocus='assignCurEle(this)'></textarea>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan=3>
		<table border=0  cellspacing="0" cellpadding="0">
		<tr>
		<td class=label align='right'><input type='text' class='text-box-mand' id='patName' name='Patient_Name' id='Patient_Name' size='30' maxlength='30' value='Unknown' onfocus='if(this.value=="Unknown") this.value="";assignCurEle(this)' onblur='if(this.value=="")this.value="Unknown";'></td>
		<td align='left' id="patSearch" class=label><div class=button onClick='getPatID()' title="Search Patients" >?<div></td>
		<td class=label align='left'>
		<td class=label align='right'>&nbsp;&nbsp;<fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=label align='left'>
			<div id="sexAutoComplete">
				<input id="sexInput" name="Gender" id="Gender" type="text" class=text-box-nkb>
				<div id="sexContainer"></div>
			</div>
		</td>
		<input type= hidden name='patient_id' id='patient_id' value=''> 
		<td class=label align='right'>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class=label><input type='text' class='text-box-nkb' id='patAge' name='Age' id='Age' size='10' maxlength='10' onfocus='assignCurEle(this)'></td>
		<td class=ymd id="YMD" class=label onMouseOver='style.cursor="hand";title="Click to Change to Y/M/D Format"' onClick='switchAgeUOM()'><b>Y</b></td>
		<input type="hidden" id='ageUom' name='age_uom' id='age_uom' value='Y'> 
		</tr>
		</table>
		</td>
	</tr>

	<tr id='escortRow' style='display:none'>
		<td class=label ><fmt:message key="eAE.Escort.label" bundle="${ae_labels}"/></td>
		<td colspan=3 ><div id="escortAutoComplete">
			<input id="escortInput" name='Escort' id='Escort' type="text" class=text-box>
			<input id="escortcInputCode" name="escort_type_code" id="escort_type_code" type="hidden">
			<div id="escortContainer"></div>
		</div>
		</td>
	</tr>
	<tr id='attdByRow' style='display:none'>
	<td class=label ><fmt:message key="eAE.AttendedBy.label" bundle="${ae_labels}"/></td>
		<td colspan=3 class=pad>
			<div id="attdByAutoComplete">
				<input id="attdByInput" name='Attended_By' id='Attended_By' type="text" class=text-box>
				<input id="attdByInputCode" name="amb_case_recorded_by" id="amb_case_recorded_by" type="hidden">
				<div id="attdByContainer"></div>
			</div>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="eAE.RequesterName.label" bundle="${ae_labels}"/></td>
		<td colspan=3><input type='text' class='text-box-mand' id='callerName' name='Requester_Name' id='Requester_Name' size='40' maxlength='60' onfocus='assignCurEle(this);'></td>
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="Common.contact.label" bundle="${common_labels}"/></td>
		<td colspan=3><input type='text' class='text-box' id='requestorphone' name='Contact' id='Contact' size='40' maxlength='30' onKeyPress='return CheckSpecChars(event);' onfocus='assignCurEle(this);'></td>
	</tr>
	<tr> 
		<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class=label colspan=3>
		<textarea class='text-area' wrap=virtual  id='rqstrRemarks' name='Requester_Remarks' maxlength='2000'  onKeyPress='return CheckSpecChars(event);checkMaxLimit(this,2000)' onBlur="makeValidString(this)" onkeyup='chopText(this,2000)' onchange='chopText(this,2000)'  onfocus='assignCurEle(this);'></textarea>
		</td>
	</tr>
	<tr id='gMapRow' style='display:none'>
			<td class=label ><fmt:message key="eAE.GoogleMap.label" bundle="${ae_labels}"/></td>
			<td class=label colspan=3><input type='text' class='text-box' id='mapLocnRegn' name='Google_Map' id='Google_Map' size='50' onfocus='assignCurEle(this)'>
			<span align="left" title= "Print Location Map" onclick = "PrintLocnMap()" onmouseover="style.cursor='hand'">&nbsp;<img align='middle' src='../../eCommon/images/beprint.gif'></img></span></td>
	</tr>
	</table>
	</div>

	<!-- Bottom-Inner-Right -->
	<div id='bottomRight' class='Bottom-Inner-Right' style='display:inline'>
	<table id='bottomRightTab' border=0 width="100%" height="50%" cellspacing="0" cellpadding="0">
	<tr>
		<td class=header width='25%'></td>
		<td class=label  align='Right'>&nbsp;</td>
	</tr>

	<tr>
		<td class=label valign='top'><fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/></td>
		<td valign='top' >
			<div id="ambAutoComplete">
				<input id="ambInput" name='Ambulance' id='Ambulance' type="text" onKeyPress='return CheckSpecChars(event);' class=text-box>
				<input id="ambInputCode" name='amb_vehicle_id' id='amb_vehicle_id' type="hidden">
				<div id="ambContainer"></div>
			</div>
		</td>
	</tr>

	
	<tr>
		<td class=label align='left'><fmt:message key="eAE.Dispatched.label" bundle="${ae_labels}"/></td>
		<td  align='left'><input type='checkbox'  id='ambStartedYn' name='amb_started_yn' id='amb_started_yn' align='ABSBOTTOM' value="" onclick='showActPickUp(this);'></td>
	</tr>

	<tr id='tripStatusRow'  style='display:none'>
	<td class=label align='left'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td align='left' colspan="2" >
	<table border="0" align='left' cellspacing="0" cellpadding="0"> 
	<tr >
		<td  class=label> &nbsp;<div  id="tripStatusAutoComplete1" style='display:none;'>
				<input id="tripStatusInput1"  name='Trip_Status' id='Trip_Status' type="text" class=text-box style="margin-top:-4px;"><div id="tripStatusContainer1"></div>
			</div>
			<div id="tripStatusAutoComplete2" style='display:none;'>
				<input id="tripStatusInput2"  name='Trip_Status' id='Trip_Status' type="text" class=text-box  style="margin-top:-4px;">
				<div id="tripStatusContainer2"></div>
			</div>
		</td>
		<td class=label> 
				&nbsp;<input type='text' class='text-box-nkb' id='tripStatusTime' value='' name='Trip_Status_Time' id='Trip_Status_Time' size='19' maxLength='19' onblur='validateDate(this,"true");' onfocus='assignCurEle(this)'>
				<img  class=img align='ABSBOTTOM' style="cursor:pointer" src="../../eAE/images/Calendar.gif"  onClick="document.getElementById("Trip_Status_Time").focus();return showCalendar('Trip_Status_Time',null,'hh:mm',true);">
				<input id="tripStatusCode" name='trip_status_code' id='trip_status_code' type="hidden">
		</td>
	</tr></table>
	</td>
	</tr>
	
	<tr id="tripStatusText" style="display:none">
	<td class=label align='left' width="30%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class=label id="tdCancelled" style="font-weight:bold;" width="70%"></td>
	</tr>
	
	<tr id='amdTypeRow' style='display:none'>
		<td class=label ><fmt:message key="eAE.AmbulanceServiceType.label" bundle="${ae_labels}"/></td>
		<td >
			<div id="ambTypeAutoComplete">
				<input id="ambTypeInput" name='Ambulance_Type' id='Ambulance_Type' type="text" class=text-box>
				<input id="ambTypeInputCode" name='amb_service_type' id='amb_service_type' type="hidden">
				<div id="ambTypeContainer"></div>
			</div>
		</td>
	</tr>

	<tr id='ambStartMeter' style='display:none'>
		<td class=label ><fmt:message key="eAE.OdometerStart.label" bundle="${ae_labels}"/> &nbsp;</td>
		<td class=label ><input type='text' class='text-box-nkb' id='startMileage' name='Start_Mileage' id='Start_Mileage' maxlength='12' size='10' onfocus='assignCurEle(this)' onKeyPress="return ChkNumberInput(this,event,0)" >&nbsp;<span id='ambStrtMilUom' class=label></span></td>
		<input type=hidden name='facAStrtMilUom' id='facAStrtMilUom' id='facAStrtMilUom' value=''>
		<input type=hidden name='facAStrtMilUomText' id='facAStrtMilUomText' id='facAStrtMilUomText' value=''>
	</tr>
	
	<tr id='ambExpDist' style='display:none'>
		<td class=label align='left'><fmt:message key="eAE.ExpectedDistance.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class=label><input type='text' class='text-box-nkb' id='totalDist' maxlength='12' name='Expected_Distance' id='Expected_Distance' size='10' onfocus='assignCurEle(this)' onKeyPress="return ChkNumberInput(this,event,0)">&nbsp;<span id='totDistUom' class=label></span></td>
	</tr>
	
	<tr id='actualPickupRow' style='display:none'>
		<td class=label ><fmt:message key="eAE.StartDateTime.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td  align='left'> <input type='text' class='text-box-mand-nkb' name='Actual_Pickup_Time' id='Actual_Pickup_Time' id='actualPickupTime' size='19'maxLength='19' onfocus='assignCurEle(this)' onblur='validateDate(this,"true");' readonly>
		<img  class=img align='ABSBOTTOM' id="imgActual_Pickup_Time" style="cursor:pointer" src="../../eAE/images/Calendar.gif"  onClick="document.getElementById("Actual_Pickup_Time").focus();return showCalendar('Actual_Pickup_Time',null,'hh:mm',true);">
		</td>
	</tr>

	<tr id="actualPickupRowText" style="display:none">
		<td class=label align='left'><fmt:message key="eAE.StartDateTime.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class=label id="tdActPickUpTime" style="font-weight:bold"></td>
	</tr>

	<tr id='distCoveredRow' style='display:none'>  
		<td class=label align='left'><fmt:message key="eAE.DistanceCovered.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class=label><input type='text' class='text-box-nkb' id='distCovered' maxlength='12' name='Distance_Covered' id='Distance_Covered' size='10' onfocus='assignCurEle(this)' onKeyPress="return ChkNumberInput(this,event,0)" onblur="calcEndMeter(this,Start_Mileage,End_Mileage,Actual_Drop_Time)">&nbsp;<span id='distCovUom' class=label></span></td>
	</tr>

	<tr id='emRow' style='display:none'>
		<td class=label align='left'><fmt:message key="eAE.OdometerEnd.label" bundle="${ae_labels}"/>&nbsp;</td>
		<td class=label><input type='text' class='text-box-nkb' id='endMileage' maxlength='12' name='End_Mileage' id='End_Mileage' size='10' onfocus='assignCurEle(this)'  onKeyPress="return ChkNumberInput(this,event,0)" onblur="calcDistCoverd(Distance_Covered,Start_Mileage,this,Actual_Drop_Time)">&nbsp;<span id='ambEndMilUom' class=label></span></td>
	</tr>
	
	<tr id='dropTime' style='display:none'>
		<td class=label align='left' ><fmt:message key="Common.EndDateTime.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align='left' ><input type='text' class='text-box-nkb' id='actualDropTime' value='' name='Actual_Drop_Time' id='Actual_Drop_Time' size='19' maxLength='19' onblur='validateDate(this,"true");' onfocus='assignCurEle(this)'>
		<img  class=img align='ABSBOTTOM' style="cursor:pointer" src="../../eAE/images/Calendar.gif"  onClick="document.getElementById("Actual_Drop_Time").focus();return showCalendar('Actual_Drop_Time',null,'hh:mm',true);">
		</td>
	</tr>
	

	<tr>
		<td class=label ><fmt:message key="eAE.DispatchRemarks.label" bundle="${ae_labels}"/></td>
		<td class=label >
		<textarea class='text-area' wrap=virtual  id='dispRemarks' maxlength='2000' name='Dispatch_Remarks'  onKeyPress='return CheckSpecChars(event);checkMaxLimit(this,2000)' onBlur="makeValidString(this)" onkeyup='chopText(this,2000)' onchange='chopText(this,2000)' onfocus='assignCurEle(this)'></textarea>
		</td>
	</tr>
	<tr id='ambResEq' style='display:none'>
		<td class=label><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td align='left' class=label>
		<div id="rsrcAutoComplete">
				<input id="rsrcInput" name='Resource' id='Resource' type="text" class=text-box>
				<input id="rsrcInputCode" type="hidden">
				<div id="rsrcContainer" ></div>
			</div>
		</td>
	</tr>
	</table>
	<input type='hidden' name='rsrc_allocated' id='rsrc_allocated' id='rsrcAllocated' value="">
	<div id="ResDetails" class=Res-Details >
	<table id="rsrcAllocDiv" border=0 width="100%"  cellspacing="0" cellpadding="0" style="display:none">
	</table>
	<table id="rsrcDiv" border=0 width="100%"  cellspacing="0" cellpadding="0">
	</table>
	</div>
	
	<!-- Division to paint the Ambulance image -->

	<div id="ambChartR" name="Req_Amb_Det" class="Bottom-Inner-Right-Corner" valign="top"  style='display:none'> 
	</div>
	</div>

	<div id='bottomDown' class='Bottom-Inner-Down'>
	<div id='recClrBut' align='right' vAlign='middle'><input type="button" id="btnRec" name="btn_record" id="btn_record" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' /><input type="button" name="btn_clear" id="btn_clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' id="btnClear" onclick="closeEntryDiv('ambSatausB')"/>&nbsp;</div>
	</div>


<SCRIPT >

	inputArr = document.getElementsByTagName("input");
	var elemStr="";
	var tempstr = "";
	for (var i = 0, elem; elem = inputArr[i++];)
	{	/* Only text items */
		tempstr += '~'+elem.id+'~';
		if (elem.type=='text' || elem.type=='textarea')
		{	/* With only valid ID names and class name should not have "-nkb" */
			if ( (elem.id != '') && (elem.className.indexOf("-nkb")==-1) )
			elemStr += '~'+elem.id;
		}
	}
	var oPushButtonRec = new YAHOO.widget.Button("btnRec");
	oPushButtonRec.on("click", recordDtl); 
	var oPushButtonClr = new YAHOO.widget.Button("btnClear");
	oPushButtonClr.on("click", clearDtl); 


//-------------------------------Auto Complete---------------------------------------------------
	YAHOO.yuiData.ACJSArray = new function() {
    // Instantiate first JS Array DataSource
    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.sex);

    // Instantiate first AutoComplete
    this.oAutoComp = new YAHOO.widget.AutoComplete('sexInput','sexContainer', this.oACDS);
    this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
    this.oAutoComp.typeAhead = true;
    this.oAutoComp.useShadow = true;
    this.oAutoComp.minQueryLength = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.textboxFocusEvent.subscribe(function(){
        var sInputValue = YAHOO.util.Dom.get('sexInput').value;
        if(sInputValue.length === 0) {
            var oSelf = this;
            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);
        }
    });

    // Instantiate second JS Array DataSource
    this.oACDS2 = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.priority);

    // Instantiate second AutoComplete
    this.oAutoComp = new YAHOO.widget.AutoComplete('priorityInput','priorityContainer', this.oACDS2);
    this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
    this.oAutoComp.typeAhead = true;
    this.oAutoComp.useShadow = true;
    this.oAutoComp.minQueryLength = 0;
	this.oAutoComp.forceSelection = true; 

	this.oAutoComp.textboxFocusEvent.subscribe(function(){
        var sInputValue2 = YAHOO.util.Dom.get('priorityInput').value;
        if(sInputValue2.length === 0) {
            var oSelf2 = this;
            setTimeout(function(){oSelf2.sendQuery(sInputValue2);},0);
        }
    });

	
    // Instantiate 3rd JS Array DataSource
    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.tripStatus1);

    // Instantiate first AutoComplete
    this.oAutoComp = new YAHOO.widget.AutoComplete('tripStatusInput1','tripStatusContainer1', this.oACDS);
    this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
    this.oAutoComp.typeAhead = true;
    this.oAutoComp.useShadow = true;
    this.oAutoComp.minQueryLength = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.textboxFocusEvent.subscribe(function(){
        var sInputValue = YAHOO.util.Dom.get('tripStatusInput1').value;
        if(sInputValue.length === 0) {
            var oSelf = this;
            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);
        }
    });
	//Define the itemSelect handler function: To assign the Escort code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code ;
	if (aArgs[1].innerText=='Cancelled')
		code = 'X';
	else
		code = 'C';
	assignStatusDate();
	document.getElementById('tripStatusCode').value=code; // Assign Code to hidden variable

	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

	
    // Instantiate 4th JS Array DataSource
    this.oACDS = new YAHOO.widget.DS_JSArray(YAHOO.yuiData.StaticList.tripStatus2);

    // Instantiate first AutoComplete
    this.oAutoComp = new YAHOO.widget.AutoComplete('tripStatusInput2','tripStatusContainer2', this.oACDS);
    this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
    this.oAutoComp.typeAhead = true;
    this.oAutoComp.useShadow = true;
    this.oAutoComp.minQueryLength = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.textboxFocusEvent.subscribe(function(){
        var sInputValue = YAHOO.util.Dom.get('tripStatusInput2').value;
        if(sInputValue.length === 0) {
            var oSelf = this;
            setTimeout(function(){oSelf.sendQuery(sInputValue);},0);
        }
    });
	
	//Define the itemSelect handler function: To assign the Escort code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code ;
	if (aArgs[1].innerText=='Cancelled')
		code = 'X';
	else
		code = 'C';
	assignStatusDate();
	document.getElementById('tripStatusCode').value=code; 
	// Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);
};




YAHOO.namespace("yuiData.DynamicList.NOC"); 
YAHOO.yuiData.DynamicList.NOC.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["ae_amb_nature","short_desc","amb_nature_Code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=ae_amb_nature";
 
    // Instantiate AutoComplete
	var nocInput = document.getElementById('nocInput');
	var nocContainer = document.getElementById('nocContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(nocInput,nocContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 20;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 
	this.oAutoComp.autoHighlight  = true; 
	this.oAutoComp.useIFrame    = true; 
    this.oAutoComp.animVert  = true;

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the NOC code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('nocInputCode').value=code; // Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);


	/*var typedItemHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var oData = aArgs[2];		// sPrefill <String>  The prefill string. 
	alert('aArgs[1] '+aArgs[1]);
	alert('aArgs[2] '+aArgs[2]);
	//document.getElementById('nocInput').value=aArgs[1]+oData; // Assign Code to hidden variable
	};
	this.oAutoComp.typeAheadEvent.subscribe(typedItemHandler);
	*/

	var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('nocInput').focus(); // Assign Code to hidden variable
	};
	//this.oAutoComp.selectionEnforceEvent.subscribe(refocus);

};

YAHOO.namespace("yuiData.DynamicList.Escort"); 
YAHOO.yuiData.DynamicList.Escort.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["am_escort_type","short_desc","escort_type_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=am_escort_type";
	
    // Instantiate AutoComplete
	var escortInput = document.getElementById('escortInput');
	var escortContainer = document.getElementById('escortContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(escortInput,escortContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 10;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 

	
    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
   //Define the itemSelect handler function: To assign the Escort code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
		    
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('escortcInputCode').value=code; 
		
	// Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

	var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('escortInput').focus(); // Assign Code to hidden variable
	};
	//this.oAutoComp.selectionEnforceEvent.subscribe(refocus); Mahesh commented
	
};

YAHOO.namespace("yuiData.DynamicList.attdBy"); 
YAHOO.yuiData.DynamicList.attdBy.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["sm_appl_user","appl_user_name","appl_user_id"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "appl_user_name";
    this.oACDS.scriptQueryAppend = "table=sm_appl_user";
 
    // Instantiate AutoComplete
	var attdByInput = document.getElementById('attdByInput');
	var attdByContainer = document.getElementById('attdByContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(attdByInput,attdByContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 6;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
	//Define the itemSelect handler function: To assign the AttdBy code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('attdByInputCode').value=code; // Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

/*	var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('attdByInput').focus(); // Assign Code to hidden variable
	};
	this.oAutoComp.selectionEnforceEvent.subscribe(refocus);
	*/
};

YAHOO.namespace("yuiData.DynamicList.Locn"); 
YAHOO.yuiData.DynamicList.Locn.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["mp_res_town","short_desc","res_town_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=mp_res_town";
 
    // Instantiate AutoComplete
	var locnInput = document.getElementById('locnInput');
	var locnContainer = document.getElementById('locnContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(locnInput,locnContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 10;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	//this.oAutoComp.forceSelection = true; 
	this.oAutoComp.autoHighlight  = true; 
	this.oAutoComp.useIFrame    = true; 
    this.oAutoComp.animVert  = true;



    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
   //Define the itemSelect handler function: To assign the Locn code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('locnInputCode').value=trimString(code,"\\n"); // Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);
};

YAHOO.namespace("yuiData.DynamicList.toLocn"); 
YAHOO.yuiData.DynamicList.toLocn.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["mp_res_town","short_desc","res_town_code"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "short_desc";
    this.oACDS.scriptQueryAppend = "table=mp_res_town";
 
    // Instantiate AutoComplete
	var toLocnInput = document.getElementById('toLocnInput');
	var toLocnContainer = document.getElementById('toLocnContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(toLocnInput,toLocnContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 7;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	//this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the NOC code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('tolocnInputCode').value=trimString(code);// Assign Code to hidden variable
	};//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);};

YAHOO.namespace("yuiData.DynamicList.AMB"); 
YAHOO.yuiData.DynamicList.AMB.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["ae_amb_vehicle","amb_vehicle_name","amb_vehicle_id"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam  = "amb_vehicle_name";
    this.oACDS.scriptQueryAppend = "table=ae_amb_vehicle";
 
    // Instantiate AutoComplete
	var ambInput = document.getElementById('ambInput');
	var ambContainer = document.getElementById('ambContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(ambInput,ambContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 10;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the Ambulance code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('ambInputCode').value=code; // Assign Code to hidden variable
	drawVehicle();
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

	/*var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('ambInput').focus(); // Assign Code to hidden variable
	};
	this.oAutoComp.selectionEnforceEvent.subscribe(refocus);*/
 };

YAHOO.namespace("yuiData.DynamicList.AmbType"); 
YAHOO.yuiData.DynamicList.AmbType.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["ae_amb_service_type","long_desc","amb_service_type"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam  = "long_desc";
    this.oACDS.scriptQueryAppend = "table=ae_amb_service_type";

    // Instantiate AutoComplete
	var ambTypeInput = document.getElementById('ambTypeInput');
	var ambTypeContainer = document.getElementById('ambTypeContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(ambTypeInput,ambTypeContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	this.oAutoComp.maxResultsDisplayed = 10;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div class='text-box'><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 
	//Define the itemSelect handler function: To assign the Ambulance code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
				      
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var code = oData[1];
	document.getElementById('ambTypeInputCode').value=code; // Assign Code to hidden variable
	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

/*	var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('ambTypeInput').focus(); // Assign Code to hidden variable
	};
	this.oAutoComp.selectionEnforceEvent.subscribe(refocus);*/
 };


YAHOO.namespace("yuiData.DynamicList.Resource"); 
YAHOO.yuiData.DynamicList.Resource.ACJson = new function(){
    this.oACDS = new YAHOO.widget.DS_XHR("AMBGetJSON.jsp", ["am_resource","resource_desc","resource_id"]);
	this.oACDS.responseType = YAHOO.widget.DS_XHR.TYPE_JSON; 
    this.oACDS.queryMatchContains = true;
	this.oACDS.scriptQueryParam = "resource_desc";
    this.oACDS.scriptQueryAppend = "table=am_resource";
 
    // Instantiate AutoComplete
	var rsrcInput = document.getElementById('rsrcInput');
	var rsrcContainer = document.getElementById('rsrcContainer');
    this.oAutoComp = new YAHOO.widget.AutoComplete(rsrcInput,rsrcContainer, this.oACDS);
    this.oAutoComp.useShadow = true;
	this.oAutoComp.minQueryLength = 1;
	//this.oAutoComp.queryDelay  = 1;
	this.oAutoComp.maxResultsDisplayed = 5;
	this.oAutoComp.connTimeout = 3000;
	this.oAutoComp.typeAhead = true;
	this.oAutoComp.maxCacheEntries = 0;
	this.oAutoComp.forceSelection = true; 

    this.oAutoComp.formatResult = function(oResultItem, sQuery){
		 var sValue = oResultItem[0];  
		 var sKey = oResultItem[1];  // Has the Code 
		 var aMarkup = ["<div><span class='text-box'>",sValue,"</span></div>"];
		 return (aMarkup.join(""));
	};


	this.oAutoComp.doBeforeExpandContainer = function(oTextbox, oContainer, sQuery, aResults) {
        var pos = YAHOO.util.Dom.getXY(oTextbox);
        pos[1] += YAHOO.util.Dom.get(oTextbox).offsetHeight + 2;
        YAHOO.util.Dom.setXY(oContainer,pos);
        return true;
    };
 	


   //Define the itemSelect handler function: To assign the Resource code to hidden variable
	var itemSelectHandler = function(sType, aArgs) {
	YAHOO.log(sType); // this is a string representing the event;
	
	var oACInstance = aArgs[0]; // Current AutoComplete instance
	var elListItem = aArgs[1];  // the <li> element selected in the suggestion container
	var oData = aArgs[2];		// object literal of data for the result, Code and description
	var data = oData[1].split('~');// The position is appended to the Resource code
	var code=data[0];
	var position = data[1];
	var positionVal = data[2];
	if (position=='') 
	{
		position='&nbsp';
	}

	document.getElementById('rsrcInputCode').value=code; // Assign Code to hidden variable
	/**
	   If already the resource is listed, skip from adding in to list.
	  */
		if (rsrcIdSelected.indexOf('`'+code+'~') == -1 )
		{
			var rowvar = document.getElementById("rsrcDiv").insertRow();
			//rowvar.id = "trRowId"+rowNumber+noOfRows.value
			var cellvar = rowvar.insertCell();
			cellvar.className=	"label"
			cellvar.width='5%';
			cellvar.insertAdjacentHTML("BeforeEnd","<input type='checkbox' id='rsrcChk"+rowNumber+"' checked value='"+code+"~"+positionVal+"' onclick='changeVal(this);'>");
			cellvar = rowvar.insertCell();
			cellvar.className=	"label";
			cellvar.width='30%';
			cellvar.noWrap=true;
			cellvar.insertAdjacentHTML("BeforeEnd",elListItem.innerText);
			cellvar = rowvar.insertCell();
			cellvar.className=	"label"
			cellvar.insertAdjacentHTML("BeforeEnd",position);
			rowNumber++;
			rsrcIdSelected = rsrcIdSelected+code+'~'+positionVal+'`';
			document.getElementById("rsrcAllocated").value = rsrcIdSelected;
		};
		rsrcInput.value='';
		if (rsrcIdSelected!='')
		document.getElementById('ambInput').className='text-box-mand';

	};
	//subscribe the handler to the event
	this.oAutoComp.itemSelectEvent.subscribe(itemSelectHandler);

	/*var refocus = function(sType, aArgs) {
		YAHOO.log(sType); // this is a string representing the event;
		var oACInstance = aArgs[0]; // Current AutoComplete instance
		document.getElementById('rsrcInput').focus(); // Assign Code to hidden variable
	};
	this.oAutoComp.selectionEnforceEvent.subscribe(refocus);
	*/
};
 

function switchAgeUOM(){
	var curVal = document.getElementById('YMD').innerText;
	var newVal = '';
	switch (curVal)
	{
		case 'Y' : newVal ='M'; break;
		case 'M' : newVal ='D'; break;
		case 'D' : newVal ='Y'; break;
	}
	document.getElementById('YMD').innerHTML = '<b>'+newVal+'</b>';
	document.getElementById('ageUom').value = newVal;
}

function changeVal(obj)
{
	if (obj.checked==true)
	{
		document.getElementById("rsrcAllocated").value= document.getElementById("rsrcAllocated").value+obj.value+"`";
	}
	else
	{
		val = document.getElementById("rsrcAllocated").value;
		document.getElementById("rsrcAllocated").value= val.replace(obj.value+"`","")
  	}

}

function PrintLocnMap() {
var mapLocnRegn = document.getElementById('mapLocnRegn').value;
//mapLocnRegn='India,Karnataka,Bangalore';
var mapWindow = window.open("http://maps.google.com/maps?f=d&hl=en&saddr="+mapLocnRegn+",+,+++&daddr=,++++&ie=UTF8&om=1&z=16&z=16&pw=2","mapWindow","toolbar=1,resizable=1,scrollbars=1,width="+(window.screen.availWidth-50)+",height="+(window.screen.availHeight-50)+"\"");
}

</SCRIPT>


