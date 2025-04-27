/*
	@ MODULE		:	InPatient Management..(IP)
	@ Function Name	:	BED AVAILIBILITY CHART
	@ Developer		:	Ranjani
	@ Created on	:	2/23/2005
*/

var bodwidth=0;
var bodheight=0;

function buildTable(val)
{
    var reason_for_movement_inline                   =document.getElementById("reason_for_movement_inline").value;
	var rowval = val.split ("<br>");
	var nowrapval = "";
	var txtStyle  = "";
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>";
	for( var i=0; i<rowval.length; i++ )
	{
		if(rowval.length > 8)
		{
			var tempValue = i/2;
			if(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6 || tempValue == 7 || tempValue == 8 || tempValue == 9 || tempValue == 10 )
				tab_dat += "<tr>";
	
			var colval = rowval[i].split("^^");
			
			/*
			if (colval[0] != "Blocked Remarks")
				nowrapval = "nowrap";		
			else
				nowrapval = "";
				
			
			tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>";
			tab_dat += "<td class = 'QUERYDATA' "+nowrapval+"> "+ colval[1] +" </td>";
			*/
			/*IN016793 Thursday, December 10, 2009*/
			/*Modified by Dharma on Dec 2nd 2014 Against IN:052735*/
			//if (colval[0] == "Blocked Remarks" || colval[0] == "Reason for Admission/Booking" )
			
			if (colval[0] == "Blocked Remarks" || colval[0] == "Reason for Admission/Booking" ||  colval[0] == "Reason For Movement ")
			{
			if(reason_for_movement_inline=='true')
				{
				nowrapval = "nowrap";
				txtStyle  = "";
				}
			else
				{
				nowrapval = "";
				txtStyle  = "text-align:justify;word-break:break-all;"
				}
			}
			else
			{
				nowrapval = "nowrap";
				txtStyle  = "";
			}

			tab_dat += "<td class = 'label' nowrap align= 'right' > "+ colval[0] +": </td>"
			tab_dat += "<td class = 'QUERYDATA' style='"+txtStyle+"' "+nowrapval+" > "+ colval[1] +" </td>"
			
			if(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5 || tempValue == 7.5 || tempValue == 8.5)
				tab_dat += "</tr> ";
		}
		else
		{
			var colval = rowval[i].split("^^");
			
			
			/*
			if (colval[0] != "Blocked Remarks")
				nowrapval = "nowrap";
            else
				nowrapval = "";

			tab_dat += "<tr>";
			tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>";
			tab_dat += "<td class = 'QUERYDATA' "+nowrapval+"> "+ colval[1] +" </td>";
			tab_dat += "</tr> 
			*/
			/*IN016793 Thursday, December 10, 2009*/
			/*Modified by Dharma on Dec 2nd 2014 Against IN:052735*/
			//if (colval[0] == "Blocked Remarks" || colval[0] == "Reason for Admission/Booking")
			if (colval[0] == "Blocked Remarks" || colval[0] == "Reason for Admission/Booking" || colval[0] == "Reason For Movement ")
				{
				if(reason_for_movement_inline=='true')
					{
					nowrapval = "nowrap";
					txtStyle  = "";
					}
				else
					{
					nowrapval = "";
					txtStyle  = "text-align:justify;word-break:break-all;"
					}
			}
			else
			{
				nowrapval = "nowrap";
				txtStyle  = "";
			}
			

			tab_dat += "<tr>";
			tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>";
			tab_dat += "<td class = 'QUERYDATA' style='"+txtStyle+"' "+nowrapval+" > "+ colval[1] +" </td>"
			tab_dat += "</tr> ";
		}
	}

	tab_dat += "</table> ";
	if (document.getElementById("t") != null)
		document.getElementById("t").innerHTML = tab_dat;
}


function displayToolTip(val, obj)
{
	 
	if(document.getElementById("tooltiplayer")){ // Code added for IN023629 by Suresh M on 17.09.2010
		val = unescape(val);
		buildTable(val);
		bodwidth = parent.frames[1].document.body.offsetWidth;
		bodheight = parent.frames[1].document.body.offsetHeight;

		/* var x =event.x;
		   var y =event.y; */

		   /*Above commented and below added by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058862]*/
				var x =event.clientX ;
				var y =event.clientY ;

		x = x + (document.getElementById("tooltiplayer").offsetWidth);
		y = y + (document.getElementById("tooltiplayer").offsetHeight);
		
		if(x<bodwidth)
			x =event.clientX; /*Modified by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058862]*/
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth*2);
		
		if(y<bodheight)
			y =event.clientY; /*Modified by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058862]*/
		else if(event.y>bodheight)
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2);
		else
			y = y - (document.getElementById("tooltiplayer").offsetHeight);

		y+=document.body.scrollTop;
		x+=document.body.scrollLeft;
		document.getElementById("tooltiplayer").style.posLeft = x;
		
	/*	if(document.getElementById("tooltiplayer").offsetWidth > 250)
			document.getElementById("tooltiplayer").style.posLeft = 111;
		else
			document.getElementById("tooltiplayer").style.posLeft = 275;  */

			/*Above commented by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058862]*/
		
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible';
	}  
}
			
function hideToolTip()
{
	if(document.getElementById("tooltiplayer")) // Code added for IN023629 by Suresh M on 17.09.2010
		document.getElementById("tooltiplayer").style.visibility='hidden'
}

var val2;
function closeWin(val,val2,val3,val4)
{
	/* 
		Comments Added by Sridhar R...
		Bed Classification		=	Bed Color
		---------------------------------------
		Normal Vacant			= "IP_GreenButton";
		Normal Occupied			= "IP_RedButton";
		Pseudo Occupied			= "IP_LPinkButton";
		Vacant Babies/Pseudo	= "IP_LGreenButton";
		Overridable				= "IP_YellowButton";
		Departed				= "IP_BrownButton";
	*/	
		
		var a=val;

		var a=val.split("^");
		var expected_discharge_date         
		var allow_booking_without_edd_yn	=a[17];
		var allow_booking_with_edd_yn		=a[18];
		var where_con						=a[19];
		var consider_edd_stop_for_boc_yn	=a[20];
		var consider_edd_stop_for_bou_yn    =a[21];
		var consider_edd_stop_for_bnc_yn	=a[22];

		var consider_edd_stop_for_bnu_yn	=a[23];
		var action_for_boc					=a[24];
		var action_for_bou					=a[25];
		var action_for_bnc					=a[26];
		var action_for_bnu					=a[27];
		var bed_status					    =a[28];
		var days_before_status			    =a[29];
		var bed_booking_ref_no			    =a[30];
		var	no_of_record					=a[31];
		var	occupying_patient_id			=a[32];
	    var search_by_beds                   =parent.criteria0.document.forms[0].search_by_beds.value;
	    var from_date                        =parent.criteria0.document.forms[0].from_date.value;
	    var call_func                        =parent.criteria0.document.forms[0].call_func.value;
	    var booking_ref_no                   =parent.criteria0.document.forms[0].bed_booking_ref_no.value;

	    var s=0;

		if(bed_status == 'O')
			expected_discharge_date			=a[16];
		
		if(parent.criteria0.document.forms[0].call_function.value == 'IP_MASTER_CODE_BED'){
			/// In BED FOR NURSING UNIT CODE SETUP, only normal bed [vacant/Occupied] can be selected...
			if(val2 != 'IP_LPinkButton' &&  val2 != 'IP_YellowButton' && val2 != 'IP_BrownButton' && val2 != 'IP_LGreenButton' && val3 == ""){
				parent.window.returnValue = val;
				parent.window.close();
			}
		}
		else if(parent.criteria0.document.forms[0].call_function.value == 'NEW_BORN_REGN'){
			/// Added by Sridhar R on 15 Oct 2004...
			/// for NEW_BORN_REGN function only babies bed shall be selected...
			if(val2 != 'IP_RedButton' && val2 != 'IP_LPinkButton' &&  val2 != 'IP_YellowButton' && val2 != 'IP_BrownButton' && val2 != 'IP_newButton' && val2 != 'IP_violetButton' && val2 != 'IP_PurpleButton' && val2 != 'IP_LpurpleButton'){
				parent.window.returnValue = val;
				parent.window.close();
			}
		}
		else
		{
			if(val3 != 'IP_PurpleButton' && val3 != 'IP_LpurpleButton' && val3 != 'IP_WoodButton' && val3 != 'IP_LWoodButton' ){
				if(val2 != 'IP_RedButton' && val2 != 'IP_BrownButton' && val2 != 'IP_newButton' && val2 != 'IP_LPinkButton' && val2 != 'IP_PurpleButton' && val2 != 'IP_LpurpleButton' && val2 != 'IP_violetButton' && val2 !='IP_RedButton_B'){
					if(parent.criteria0.document.forms[0].wherecondn.value == 'EMERGENCY_TFR_YN' && val2 == "IP_selectableReserveBed"){
						parent.window.returnValue = val;
						parent.window.close();
					}
					else if(val2 != 'IP_selectableReserveBed')
					{
						if(parent.criteria0.document.forms[0].call_func.value == 'ADMIT'){
							parent.location.href = '../jsp/PaintAdmitPatient.jsp?P_call_func=ADMIT&P_retval='+escape(val);
						}
						else if(parent.criteria0.document.forms[0].call_function.value == '' && 	parent.criteria0.document.forms[0].bed_classification.value == 'BB'){
						
						// invalid bed .. cannot be selected...
						}
						else
						{
							// SCR 4020 FDPMG20089CRF0119IP --08/12/2008 	
							if((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN")){
								if(bed_status == 'O'){
									if(allow_booking_without_edd_yn=='N' && ( expected_discharge_date =="" || expected_discharge_date ==" ")){			
										alert(getMessage("BOOK_WTHOT_EDD","IP"));
										return false;					
									}

									if(allow_booking_with_edd_yn=='Y' && expected_discharge_date !=""  && (!isBefore(expected_discharge_date,from_date,"DMYHM","en"))){					
											
											alert(getMessage("BOOK_WITH_EDD","IP"));
											return false;											
									}
								}
						
							}//end of where-con
							
							/**/
							if(call_func != 'QUERY_BED_AVAIL' ){
								/*Wednesday, August 25, 2010 SRR20056-SCF-4477.1 [IN:023217] condition added for selecting a occupied beds without EDD */
								if(occupying_patient_id!="" && bed_status == 'O' && !((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN")))
								{
									alert(getMessage("OCCUPIED_BED","IP"));
									return false;
								}
								/**/
								else if((val3 == 'IP_WoodButton' || days_before_status == 'BOC') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton')){
									if(consider_edd_stop_for_boc_yn == 'Y' && expected_discharge_date != "" && (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
										alert(valid);
										return false ;
									}
									else
									{
										if(action_for_boc == 'W'){
											var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
											valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
											valid = confirm(valid);
											if(valid){
												parent.window.returnValue = val;
												parent.window.close();												
											}
											else
											{
												return false
											}
										}
										else if(action_for_boc == 'S'){
											var valid = getMessage("FUTURE_BOOKING_STOP","IP");
											valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
											alert(valid);
											return false ;
										}
									}
								}
								else if((val3=='IP_LWoodButton' || days_before_status == 'BOU')&& (val2=='IP_GreenButton_B' || val2=='IP_GreenButton') ){
									if(consider_edd_stop_for_bou_yn == 'Y' && expected_discharge_date != "" && (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
										alert(valid);
										return false ;
									}else{
										if(action_for_bou == 'W'){
											var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
											valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
											valid = confirm(valid);
											if(valid){
												parent.window.returnValue = val;
												parent.window.close();												
											}else{
												
												return false;
											}
										}else if(action_for_bou == 'S'){
											var valid = getMessage("FUTURE_BOOKING_STOP","IP");
											valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
											alert(valid);
											return false ;
										}
									}
								}
								else if((val3=='IP_PurpleButton' || days_before_status == 'BNC') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton')){
									if(consider_edd_stop_for_bnc_yn == 'Y' && expected_discharge_date != "" && (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
										alert(valid);
										return false ;
									}else{
										if(action_for_bnc == 'W'){
											var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
											valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
											valid = confirm(valid);
											if(valid){
												parent.window.returnValue = val;
												parent.window.close();												
											}else{
												return false
											}
										}else if(action_for_bnc == 'S'){
											var valid = getMessage("FUTURE_BOOKING_STOP","IP");
											valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
											alert(valid);
											return false ;
										}
									}
								}
								else if((val3 == 'IP_LpurpleButton' || days_before_status == 'BNU') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton')){
									if(consider_edd_stop_for_bnu_yn == 'Y' && expected_discharge_date != "" && (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
										alert(valid);
										return false ;
									}
									else
									{
										if(action_for_bnu == 'W'){
											var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
											valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
											valid = confirm(valid);
											if(valid){
												parent.window.returnValue = val;
												parent.window.close();												
											}else{
												return false
											}
										}
										else if(action_for_bnu == 'S'){
											var valid = getMessage("FUTURE_BOOKING_STOP","IP");
											valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
											alert(valid);
											return false ;
										}
									}
								}
							}
								
							/**/						
							parent.window.returnValue = val;
							parent.window.close();							
						}
					}
				}
			}
			else
			{
				if(call_func != 'QUERY_BED_AVAIL' ){						
				/*Wednesday, August 25, 2010 SRR20056-SCF-4477.1 [IN:023217] condition added for selecting a occupied beds without EDD */
						if(occupying_patient_id!="" && bed_status == 'O' && !((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN")))
						{
							alert(getMessage("OCCUPIED_BED","IP"));
							return false;
						}
						/**/
						else if((val3 == 'IP_WoodButton' || days_before_status == 'BOC') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton') && (booking_ref_no!=bed_booking_ref_no)){
							if(parseInt(no_of_record) > 0 && ((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN"))){
								/*Thursday, June 03, 2010,SRR20056-SCF-4477 [IN:021282]*/
								alert(getMessage("OVERLAP_BLOCK_TIME","IP"));
							}else{
								if(consider_edd_stop_for_boc_yn == 'Y' && expected_discharge_date != "" &&  (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
									var valid = getMessage("FUTURE_BOOKING_STOP","IP");
									valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
									alert(valid);
								}else{
									if(action_for_boc == 'W'){
										var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
										valid = confirm(valid);
										if(valid){
											parent.window.returnValue = val;
											parent.window.close();											
										}else{
											return false
											}
									}else if(action_for_boc == 'S'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedOverridable.label","IP"));
										alert(valid);
									}
								}
							}
						}
						else if((val3=='IP_LWoodButton' || days_before_status == 'BOU') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton') && (booking_ref_no!=bed_booking_ref_no)){
							if(parseInt(no_of_record) > 0 && ((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN"))){
								alert(getMessage("OVERLAP_BLOCK_TIME","IP"));
							}else{
								if(consider_edd_stop_for_bou_yn == 'Y' && expected_discharge_date != "" &&  (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
									var valid = getMessage("FUTURE_BOOKING_STOP","IP");
									valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
									alert(valid);
								}else{
									if(action_for_bou == 'W'){
										var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
										valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
										valid = confirm(valid);
										if(valid){
											parent.window.returnValue = val;
											parent.window.close();
										}else{
											
											return false;
										}
									}else if(action_for_bou == 'S'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.UnConfirmedOverridable.label","IP"));
										alert(valid);
									}
								}
							}
						}
						else if((val3=='IP_PurpleButton' || days_before_status == 'BNC') && (val2=='IP_GreenButton_B' || val2=='IP_GreenButton') && (booking_ref_no!=bed_booking_ref_no)){
							if(parseInt(no_of_record) > 0 && ((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN"))){
								alert(getMessage("OVERLAP_BLOCK_TIME","IP"));
							}else{
								if(consider_edd_stop_for_bnc_yn == 'Y' && expected_discharge_date != "" &&  (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
									
									var valid = getMessage("FUTURE_BOOKING_STOP","IP");
									valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
									alert(valid);
								}else{
									if(action_for_bnc == 'W'){
										var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
										valid = confirm(valid);
										if(valid){
											parent.window.returnValue = val;
											parent.window.close();
										}else{
											return false
										}
									}else if(action_for_bnc == 'S'){
										var valid = getMessage("FUTURE_BOOKING_STOP","IP");
										valid = valid.replace("#",getLabel("eIP.ConfirmedNonOverridable.label","IP"));
										alert(valid);
									}
								}
							}
						}
						else if((val3 == 'IP_LpurpleButton' || days_before_status == 'BNU')&& (val2=='IP_GreenButton_B' || val2=='IP_GreenButton') && (booking_ref_no!=bed_booking_ref_no)){
						if(parseInt(no_of_record) > 0 && ((where_con=="CONFIRM_BOOKING_YN") || (where_con=="REVISE_BOOKING_YN") || (where_con=="CREATE_BOOKING_YN"))){
							alert(getMessage("OVERLAP_BLOCK_TIME","IP"));
						}else{
							if(consider_edd_stop_for_bnu_yn == 'Y' && expected_discharge_date != "" &&  (!isBefore(expected_discharge_date,from_date,"DMYHM","en")) && bed_status == 'O'){
								var valid = getMessage("FUTURE_BOOKING_STOP","IP");
								valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
								alert(valid);
							}else{
								if(action_for_bnu == 'W'){
									var valid = getMessage("FUTURE_BOOKING_PROCD","IP");
									valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
									valid = confirm(valid);
									if(valid){
										parent.window.returnValue = val;
										parent.window.close();
									}else{
										return false
									}
								}
								else if(action_for_bnu == 'S'){
									var valid = getMessage("FUTURE_BOOKING_STOP","IP");
									valid = valid.replace("#",getLabel("eIP.UnConfirmedNonOverridable.label","IP"));
									alert(valid);
								}
							}
						}
					}
				}
				/*IN017016 Wednesday, December 09, 2009*/
				/*Commented by Muthu on 09/03/2010 for Walkthrough
				parent.window.returnValue = val;
							parent.window.close();
				*/
				if(booking_ref_no==bed_booking_ref_no) {
					parent.window.returnValue = val;
					parent.window.close();
				}

				/**/
			}	
		}	
}

