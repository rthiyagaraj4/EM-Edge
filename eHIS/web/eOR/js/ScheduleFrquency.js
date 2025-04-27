/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/01/2012	  IN046042		Nijithas S	 MMS-SCF-0204
																							
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
/**************Global Variable for all function ****************/

var function_id      = ""   ;
var resultGlobal	 = false;
var messageGlobal	 = ""   ;
var durationType	 = ""   ;	 //Monthly,Weekly,Days,Hours,Minutes
var repeatValue		 = ""   ;
var freqLegend		 = ""   ;
var startTimeRound	 = ""   ;	 //TM,FM,QH,H
var startTimeAssign  = ""   ;	 //N,C,P
var flag			 = false;
//var start_date		 = "";
/***************************************************************/

var flagChk          = false; //Only to DiBug

/*************Handle to the Frame's and the form Object ****************/

var doc		= null	;
var formObj	= null ;
var headerDoc	= null ;

/********************Intialise function*************************************/

function intialisation(){
function_id      = "" ;
resultGlobal	 = false;
messageGlobal	 = "" ;
durationType	 = "" ;
repeatValue		 = "" ;
freqLegend		 = "" ;
startTimeRound	 = ""   ;
startTimeAssign  = ""   ;
}

/***********************************************************************/
function assignFrqeuncyGlobal(durationType_P , repeatValue_P , freqLegend_P , start_time_round_p , start_time_assign_p){
getHandle();
//assign Global Values
durationType					= durationType_P ;
formObj.durationType.value		= durationType_P ;

repeatValue						= repeatValue_P ;
formObj.repeat.value			= repeatValue ;

freqLegend						 = freqLegend_P ;
startTimeRound					 = start_time_round_p ;
startTimeAssign					 = start_time_assign_p ;
addOptions(durationType,repeatValue,freqLegend);
}

/**********************fucntion to compare two time format HH:mm************/


function compareTime(time1,time2){//if time1 > time2  true or else false

var tem1 = time1.replace(":",".");
var tem2 = time2.replace(":",".");
return parseFloat(tem1) >= parseFloat(tem2);

}

/********************It shows day selected by chk Box************************/

function showSelected(){

getHandle();
defaultStartDay();


htmlStr = "<b>Times for "

/*for(i = 1; i <= 7 ; i++){
	var day			  = eval("formObj.daySM"+ i );
	var dayDisplayObj = eval("doc.all.dayDisplay" + i);

	if(day.checked == true)//showDaySelect feild is dynamically inserted in the form when days is seleted
	htmlStr += dayDisplayObj.value + "/";
}*/

/*	var indx =  htmlStr.lastIndexOf("/");
	if(parseInt(indx) != -1)
	doc.all.showDaySelect.innerHTML = htmlStr.substring(0,indx);
	else
	doc.all.showDaySelect.innerHTML = "&nbsp;";*/


}
/***********Chk of time for Start_time_assign *************/
function timeChkStart(time1){

	var time = time1.value;
	var	retFlag = true ;

	if(time == "" || time ==null)
	return ;

	getHandle();

	if(!chkTime(time))
		retFlag = false

	if(!retFlag){
		time1.value="";
		time1.focus();
		
		alert(getMessage("INVALID_TIME_FMT","OR"));
		return false ;
	}
	
}
function  appedzero(obj){
	
	 if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
	
}
/******************Check Valid time*************************************/

function timeChk(time1){
var time = time1.value;

var	retFlag = true ;

if(time == "" || time ==null)
return ;

getHandle();


if(durationType == "H" || durationType == "M" ){
	if(!chkTimeLocal(time))
	retFlag = false
}else{//This Validation when duration Type is Day or Week
	if(!chkTime(time))
	retFlag = false
}


if(!retFlag){
	time1.value="";
	time1.focus();

	if(durationType == "H" || durationType == "M") //Plx get Message from eCommom/messages.js ---Odl architexture
	var message  = getMessage("VALID_TIME_SLOTS","AM");
	else
	var message  = getMessage("INVALID_TIME_FMT","OR");

//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	alert(message);
	return false ;
}else{
	roundOf(time1) ;
	var message  = "";
}


}

//**********************Do round off*****************************/

function roundOf(obj){
	var round	= 0 ;
	var time	= obj.value ;

	if(time == "")
		return ;


	var indx	= time.indexOf(":");
	var hrs		= time.substring(0,indx);
	var mins	= time.substring(indx+1,time.length);






	if(startTimeRound == "" || startTimeRound == null)//if no round of
		return ;

	if(startTimeAssign == "" || startTimeAssign == null)//if no round of
		startTimeAssign = "C" ;


	mins = formatMin(mins);
	obj.value = hrs + ":" + mins;


	if(startTimeRound == "FM")
	round = 5;

	if(startTimeRound == "TM")
	round = 10;

	if(startTimeRound == "QH")
	round = 15;

	if(startTimeRound == "H")
	round = 60;

	if(startTimeRound == "M")//Should be assign to 1 but unusal requirement
	round = 5;




 if(parseFloat(mins%round) != 0)  { //i:e value is to be rounded off

		if(startTimeRound == "M")//Change to min----------->>unusal requirement
		round = 1;

		var dif = parseFloat(mins) - parseFloat(mins%round) ;

	if(startTimeRound == "M") //round -off for minute start
		{
			if(startTimeAssign == "N" ){
				mins = dif  + 1 ;
			}


			if(startTimeAssign == "P"){
				mins = dif  - 1;
			}


			if(startTimeAssign == "C" ){
				if(parseFloat(mins%5) < 3  ){
				mins = dif  - 1;
				}else{
				mins = dif  + 1 ;
			    }
		 	}

	}else{//round -off other than minute

				if(startTimeAssign == "N" ){
				mins = dif +  round ;
				}

				if(startTimeAssign == "P")
				mins = dif ;


				if(startTimeAssign == "C" ){

					var chkVal = "";

					if(startTimeRound == "FM")
					chkVal = 3;
					if(startTimeRound == "TM")
					chkVal = 6;
					if(startTimeRound == "QH")
					chkVal = 3;
					if(startTimeRound == "H")
					chkVal = 3;


					if(parseFloat(mins%round) < parseFloat(chkVal)   )
					mins = dif ;
					else
					mins = dif +  round ;

				}

		  }//End of rounding of other than min


   if(mins == 60 ){//if min comes to 60 add hrs

			if(durationType == "H" || durationType == "M"){
			obj.value = "00" + ":" + "59";
			return ;
			}

			obj.value = parseFloat(hrs) + 1 + ":" + "00";

			if(obj.value == "24:00")//if time comes to 24:00 make it to 23:59
			obj.value = "23:59";

	 }else{
			mins = formatMin(mins);
			obj.value = hrs + ":" + mins;
	 }

	}//End of rounding alogoritm

}

/**********************Detail Handle**********************************/

function getHandle()
{
	 doc				 =f_query_add_mod.document ;
	// if(f_query_add_mod_hdr)
	//{
		//if(f_query_add_mod_hdr.document)
		// headerDoc	 =f_query_add_mod_hdr.document ;
	//}
	 formObj	     =doc.scheduleFreqencyAddMod ;
}

/********************On Success*********************************/

function onSuccess(){
getHandle();
mode = formObj.mode.value ;
if(mode == MODE_INSERT){
	intialisation();
	removeOptions();
	formObj.reset();
}else{
f_query_add_mod.document.location.href="../../eAM/jsp/ScheduleFrequencyAddModify.jsp?"+formObj.qry_str.value ;
}
}

/***************************************************************************/

/*called on load of page meant for update mode to chk days already in the dataBase****/
function chkDefIntl(){
	
getHandle();
var durationType = "";
var repeatValue						= "";
var startTimeRound					= "";
var startTimeAssign					= "";
var updateString				= "";
var isSchdApplicable =  "false";
if (formObj.isSchdApplicable != null)
{
	isSchdApplicable = formObj.isSchdApplicable.value;
}
	if (isSchdApplicable == 'true')
	{
		if (formObj.durationType != null)
		{
			durationType		= formObj.durationType.value ;
		}
		
		if (formObj.repeat != null)
		{
			repeatValue			= formObj.repeat.value;
		}

		if (formObj.startTimeAssign != null)
		{
			startTimeRound					= formObj.start_time_round_p.value ;
		}
		if (formObj.startTimeAssign != null)
		{
			startTimeAssign					= formObj.start_time_assign_p.value;
		}
		var loadFlag					= formObj.loadFlag ;

		if (formObj.chkDaysUpdate != null)
		{
			updateString				= formObj.chkDaysUpdate.value ;
		}
		 

		if(updateString == ""){
			defaultStartDay();
			defaultStartTime();
			loadFlag.value			= "NO"; //Loading is over i  update mode
			
		}
showSelected();
		defaultStartDay();
		defaultStartTime();
		loadFlag.value			= "NO"; 
	/*	var arrDays = updateString.split("|");
		for( i=0 ; i<arrDays.length ; i++){//Chk those which  are already in the database
			for(j = 1; j <= 7 ; j++){
				var day = eval("formObj.daySM"+ j );
				 if(arrDays[i] == day.value)
					day.checked = true ;
			}
		}*/

		//Loading is over
		//if(called_from=="apply")	// click the ok button
		//		parent.f_query_close.document.buttonForm.Ok.click()
		
	}

}

/***********Method to default the start time ***************************/
 function defaultStartDay(){

	getHandle();

	//When Value is Passed during loading of page don't do the logic
	var loadFlag				= formObj.loadFlag ;
	var start_day_assign		= formObj.start_day_assign.value ;
	var today					= formObj.today.value ;//this value of current date as mentioned in the SM_DAY_OF_WEEK

	var todayChkObj				= ""; //eval("formObj.daySM"+ today);

	var ChkFlag					= false;
	var start_time_assign_p		= formObj.start_time_assign_p.value ;
	var durationType			= formObj.durationType.value ;

	var todayDate_obj			= formObj.todayDate	   //DataBase date
	var	todayTime_obj			= formObj.todayTime   //DataBase time


	var start_day_param_obj		= formObj.start_day_param ;	 //date passed through modal window
   	var start_time_param_obj	= formObj.start_time_param ; //time passed through modal window


	if(loadFlag.value == "YES"){   //Loading	--after loading  loadFlag set to No

		if(start_day_assign !=  ""){ //Value passed from bean once page is visited
		return ;

		}else {//when Called for the first time(during load) for a particular frequency code

		 /*This piece of logic is to default start date and time depending upon the
		 passed values**/

		 if(durationType != "W"){

			var start_time_assign_p	   = formObj.start_time_assign_p.value ;
			var noTime				   = parseInt(repeatValue) ;
	 		var shedFreqList		   = new Array();
			var	counter				   = 0 ;

			//	Fill the array with Schedule list
			for(i = 0; i < noTime ; i++)
			{
				//var time = eval("doc.all.time"+ (parseFloat(i)+1) );
				var time = document.getElementById("time" + (parseFloat(i) + 1));
				if(time.value != "")
				 shedFreqList[counter++] = time.value;
			}
			//Default direclt in case of minutes and hrs
			if(durationType == "M" || durationType == "H")
			{
				formObj.start_day_assign.value = start_day_param_obj.value ;
				 return ;
			}

			//i:e only the Case where Duration Type is Day
   			if(shedFreqList.length > 0 )
			{//default Values form DataBase
				//Date passed less than or equals today
				if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == 0 ||  parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == -1)
				{
				//if times passed greater than Scheduled times than default the next day
					if(!compareTime(shedFreqList[shedFreqList.length-1],start_time_param_obj.value))
					{
						formObj.start_day_assign.value = calculateEndDateTime(start_day_param_obj.value,"N","1") ;
					}
					else
					{//Time passed less than todays Date than default the same Day
						formObj.start_day_assign.value = start_day_param_obj.value;
					}

				//Date passed is greater than default todays date
				}else
				{
					 formObj.start_day_assign.value = start_day_param_obj.value ;
				}

			}
			else
			{//No default Values form DataBase
					formObj.start_day_assign.value = start_day_param_obj.value ;
			}

			 return ;
		}

		//Week
		if(durationType == "W")
		{

			var ChkFlagDays = false ;//Whether any record is coming from Database

			/*for(j = 1 ; j <= 7 ; j++)
			{
				var day = eval("formObj.daySM"+ j);
				if(day.checked == true)
				{
					ChkFlagDays = true ;
				}
			}*/

			//if NO Days checked default the same passed value with out validation
			if(!ChkFlagDays)
			{
				formObj.start_day_assign.value =  start_day_param_obj.value ;
				return ;
			}



			/***Check whether date passed is greater than today****/

			if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == 1 )
			{

			  var loadChkFlag = false ;
			  formObj.dummmyDate.value = formObj.todayDate.value ;


			 //Iterate throught all Days  and check whether the start		 day Passed falls within the Checked ones ,if not then default the next checked day......

			 //Iterate form today to the last day of week as specified in sm_day_of_week
			 for(j = parseFloat(today)+1 ; j <= 7 ; j++)
			{
			   //dummmyDate is increased by 1 for every iteration starting from today
			   formObj.dummmyDate.value = calculateEndDateTime(formObj.dummmyDate.value,"N","1") ;

				/*var day = eval("formObj.daySM"+ j );
			   if(day.checked == true){

				 if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == 0 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = start_day_param_obj.value ;
					 return ;
				 }

				  //if the passed date less than day checked than default the date of checked date --i:e next Checked date
				 if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == -1 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = formObj.dummmyDate.value ;
					 return ;
				 }
			  }*///if day checked
		   }//end of for Loop



		  //Iterate form today to the next week's day
		 for(j = 1  ; j <= parseInt(today)-1 ; j++)
		{
			formObj.dummmyDate.value = calculateEndDateTime(formObj.dummmyDate.value,"N","1") ;
		/*	var day = eval("formObj.daySM"+ j );
			if(day.checked == true)
			{
				 if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == 0 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = start_day_param_obj.value ;
					 return ;
			   }

			 	if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == -1 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = formObj.dummmyDate.value ;
					 return ;
			   }
			 }*///if day checked
		  }	//end of for Loop

 }//Date passed greater than todays date


	/***Check whether date passed is equal todays or lesser than date***/

	if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == 0 || parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == -1){

		 loadChkFlag = false ;
		 formObj.dummmyDate.value = formObj.todayDate.value ;

		//Check whether date passed is less than todays date
		if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj))== -1){

		  //Iterate form today to these  week's  first day

		  for(j = (parseFloat(today)-1) ; j >= 1 ;j--){
			formObj.dummmyDate.value = calculateEndDateTime(formObj.dummmyDate.value,"P","1") ;

			/*var day = eval("formObj.daySM"+ j );
			if(day.checked == true){

			 if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == 0 )
			{
						 loadChkFlag = true ;
					 formObj.start_day_assign.value = start_day_param_obj.value ;
					 return ;
				  }

			   }*/
			 }	//end of for Loop

			 /**In case today is checked and time passed is less than today and
			 no previous days are checked then default today date ****/
		/*	 if(todayChkObj.checked == true){
			   formObj.start_day_assign.value = formObj.todayDate.value ;
			   return ;
			 }*/

	    }//End -if time passed is less than today

		 /*Initaise again*/
		 loadChkFlag = false ;
		 formObj.dummmyDate.value = formObj.todayDate.value ;


        //time passed is greater than or equal to current time and passed date is today and today is checked
	/*	if(compareTime(start_time_param_obj.value,todayTime_obj.value)&&
			parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj))==0 &&
			  todayChkObj.checked == true){
			  	formObj.start_day_assign.value = start_day_param_obj.value ;
			}else{ //if time passed is less then current time

			  //Iterate form today to the last day of week as specified in sm_day_of_week
			 for(j = parseFloat(today)+1 ; j <= 7 ; j++){
			   formObj.dummmyDate.value = calculateEndDateTime(formObj.dummmyDate.value,"N","1") ;
			/*   var day = eval("formObj.daySM"+ j );

			   if(day.checked == true){
				  if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == 0 )
				 {
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = start_day_param_obj.value ;
					 return ;
				  }

				  if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == -1 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = formObj.dummmyDate.value ;
					 return ;
				}

			  }//if day checked
		   }//end of for Loop



		  //Iterate form today to the next week's day
		  for(j = 1  ; j <= parseInt(today)-1 ; j++)
		{

			formObj.dummmyDate.value = calculateEndDateTime(formObj.dummmyDate.value,"N","1") ;
		/*	var day = eval("formObj.daySM"+ j );
			if(day.checked == true)
			{
				 if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == 0 )
				{
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = start_day_param_obj.value ;
					 return ;
				  }
				  if(parseFloat(doDateCheckOR(start_day_param_obj,formObj.dummmyDate)) == -1 ){
					 loadChkFlag = true ;
					 formObj.start_day_assign.value = formObj.dummmyDate.value ;
					 return ;
			     }
			 }//if day checked
				}	//end of for Loop
			}*///Else
	  }//end of if -- equal or lesser than today

	}//if duration type is week
  }//Else part of Load
} //end of if Loop for load





/*	if(todayChkObj.checked == true){
	   formObj.start_day_assign.value = formObj.todayDate.value ;
	   return ;
	}*/



	if(start_time_assign_p == "N" || start_time_assign_p == "C"){
		start_time_round = 0 ;
		/*for(j = parseInt(today)+1 ; j <= 7 ; j++){
			++start_time_round ;
			var day = eval("formObj.daySM"+ j );
			if(day.checked == true){
				ChkFlag = true ;
				formObj.start_day_assign.value = calculateEndDateTime(formObj.todayDate.value,start_time_assign_p,start_time_round) ;
				return ;
			}
		}*/


	/* for(j = 1  ; j <= parseInt(today)-1 ; j++){
            ++start_time_round ;
			var day = eval("formObj.daySM"+ j );
			if(day.checked == true){
				ChkFlag = true ;
				formObj.start_day_assign.value = calculateEndDateTime(formObj.todayDate.value,start_time_assign_p,start_time_round) ;
				return ;
		 }
		}*/
		
	}




	if(start_time_assign_p == "P"){
		start_time_round = 0 ;	 ;

	/*	for(j = parseInt(today)-1 ; j >= 1 ; j--){
			++start_time_round	;
			var day = eval("formObj.daySM"+ j );
			if(day.checked == true){
				ChkFlag = true ;
				formObj.start_day_assign.value = calculateEndDateTime(formObj.todayDate.value,start_time_assign_p,start_time_round) ;
				return ;
			}
		 }*/

		start_time_round = 0;
	/*	for(j = parseInt(today)+1 ; j <= 7 ; j++){
			var day = eval("formObj.daySM"+ j );
			++start_time_round	;
			if(day.checked == true){

				ChkFlag = true ;
				formObj.start_day_assign.value = calculateEndDateTime(formObj.todayDate.value,"N",start_time_round) ;
				return ;
			 }
		 }*/

	}
	if(durationType!= "W")
	{
			ChkFlag = true ;
	}
	if(!ChkFlag)
	 {
		  formObj.start_day_assign.value = formObj.todayDate.value ;
	 }
	 if(formObj.start_day_assign.value=="")
	 {
		 formObj.start_day_assign.value = formObj.todayDate.value ;
	 }
}
 /************************************************************************/
 function concantDefaultTime(startTime,ScheduleTime ) {
   var startTimeArr		= 	startTime.split(":") ;
   var scheduleTimeArr	= 	ScheduleTime.split(":") ;
   return 	startTimeArr[0] + ":" +  scheduleTimeArr[1];

 }
/*****Method to default start time Called on Blur of time text boxes******/
function  defaultStartTime(){

	getHandle();


   //When Value is Passed during loading of page don't do the logic
	var loadFlag			   = formObj.loadFlag ;
	var start_time_assign	   = formObj.start_time_assign.value ;
	var todayTime			   = formObj.todayTime.value ;
	var startTimeObj      	   = formObj.start_time_assign;
	var startDayObj      	   = formObj.start_day_assign;
	var ChkFlag				   = false;
	var start_time_assign_p	   = formObj.start_time_assign_p.value ;
	var noTime				   = parseInt(repeatValue) ;
	var  shedFreqList          = new Array();

	var durationType	    	= formObj.durationType.value ;

	var todayDate_obj			= formObj.todayDate	   //DataBase date
	var	todayTime_obj			= formObj.todayTime   //DataBase time
	var start_day_param_obj		= formObj.start_day_param ;	 //date passed through modal window
   	var start_time_param_obj	= formObj.start_time_param ; //time passed through modal window

	var timeDb = "";
    var timetoAssign = "";

	var default_time = "";

	var defaultDayLoad =""; //	{"today","Next"} used for start time assign during load

    var today				= formObj.today.value ;
	var today_obj			= eval("formObj.daySM"+ today ); //check today



	var counter				= 0 ;

	//	Fill the array with Schedule list
	for(i = 0; i < noTime ; i++){
		//var time = eval("doc.all.time"+ (parseFloat(i)+1) );
		var time = document.getElementById("time" + (parseFloat(i) + 1));

		 if(time.value != "")
			 shedFreqList[counter++] = time.value;
	}




	 if(loadFlag.value == "YES"){   //Loading
	  if(start_time_assign !=  ""){	   //Value passed
		return ;
	 }else{//when Called for the first time(during load) for a particular frequency code

	  /*This piece of logic is to default start date and time depending upon the passed values**/

	  if(durationType != "W" ){

	 //Start Day is greater than Passed time i:e Day is increased by one
		if(parseFloat(doDateCheckOR(startDayObj,start_day_param_obj)) == 1 ){
			//Default the first  time
		   if(durationType == "M" || durationType == "H"){
				startTimeObj.value =concantDefaultTime(start_time_param_obj.value,shedFreqList[0])
					
			}else{
				startTimeObj.value = shedFreqList[0];
				
			}

		}else{//Start day defaulted is same as passed Date

			if(shedFreqList.length <= 0){
				default_time = start_time_param_obj.value ;
				
			}else{
				default_time = shedFreqList[0] ;
				
			}
 
			if(durationType == "M" || durationType == "H"){
			//Pass the start time as today time for checking in between	timimgs
			todayTime = start_time_param_obj.value;
			
			}
 
			//Start Date greater than today
			if(parseFloat(doDateCheckOR(startDayObj,todayDate_obj)) == 1 ){
			  	if(durationType == "M" || durationType == "H"){
				 startTimeObj.value =concantDefaultTime(start_time_param_obj.value,default_time);
				
				}else{
				 startTimeObj.value = default_time;
				 
				}
			}else{//Start day  less than or equal to Today

			var  start_time_assign_p_dummmy = start_time_assign_p ;

			//This is only for During Loading of Page we are passing dummy to override the rules of defaultStartTimeUtility()
			if(start_time_assign_p_dummmy == "" || start_time_assign_p_dummmy == null || start_time_assign_p_dummmy == "M" )
			start_time_assign_p_dummmy = "N" ;

			defaultStartTimeUtility(shedFreqList,startTimeObj,start_time_param_obj.value,start_time_assign_p_dummmy,default_time)
			
			}
		}

		 return ;
	 }


	 if(durationType == "W" ){

	   timeDb		= doc.time1.value;
	   timetoAssign = "";

	   if(timeDb == "")
	    timetoAssign = start_time_param_obj.value ;
	   else
		 timetoAssign = timeDb ;

		//Check whether date passed is greater than today
		if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == 1 ){
		    startTimeObj.value  =  timetoAssign ;
			return ;
		}


		//Check whether date passed is equal todays date
/*		if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == 0 ){
		   //time passed is greater than or equal to current time and today is checked then only
			if(compareTime(start_time_param_obj.value,todayTime_obj.value) && today_obj.checked == true ){
			defaultDayLoad = "today" ;
			}else{ //if time passed is less then current time
			defaultDayLoad = "next" ;
			}
		 }*/



		 //Check whether date passed is less todays date
		if(parseFloat(doDateCheckOR(start_day_param_obj,todayDate_obj)) == -1 ){
			defaultDayLoad = "next" ;
		  }




		if(defaultDayLoad != "today" ){
		  default_time = shedFreqList[0] ;
		}else{
    	  default_time = start_time_param_obj.value ;
		}


	     if(shedFreqList.length != 0){
			 defaultStartTimeUtility(shedFreqList,startTimeObj,todayTime,start_time_assign_p,default_time);
		 }else{
			 startTimeObj.value	=  start_time_param_obj.value;
		 }
		return ;
		 /*End of logic to default start and time*/

	 }//if duration type is week
	}//End of else loop if value is not passed from  bean
  }//End of Load Flag




	if(loadFlag.value != "YES"){
		    default_time = shedFreqList[0] ;

				if(durationType == "M" || durationType == "H"){
					//Pass the start time as today time for checking in between	timimgs
					todayTime = start_time_param_obj.value;
				}
	}

	//Check whether start_time_assign date is greater than today
	if(parseFloat(doDateCheckOR(formObj.start_day_assign,todayDate_obj)) == 1 ){
		 if(shedFreqList.length != 0){
		  	if(durationType == "M" || durationType == "H"){
			 startTimeObj.value  = concantDefaultTime(start_time_param_obj.value,shedFreqList[0]);
			}else{
			 if(durationType=="W")
			{
				 startTimeObj.value  =  shedFreqList[0]  ; //assign the first value
			 }
			}

			return ;

		 }else{
		   	return ;
		 }
	}

	defaultStartTimeUtility(shedFreqList,startTimeObj,todayTime,start_time_assign_p,default_time)

}
/*******************************************************************/
function defaultStartTimeUtility(shedFreqList,startTimeObj,todayTime_p ,start_time_assign_p,default_time){

	var start_day_param_obj		= formObj.start_day_param ;	 //date passed through modal window
   	var start_time_param_obj	= formObj.start_time_param ; //time passed through modal window
	var start_time_param		= start_time_param_obj.value ;


	var size = 	shedFreqList.length;


	if(parseFloat(size) <= 0 ){
			 startTimeObj.value = todayTime_p;
			 return ;
	}



	if(durationType == "M" || durationType == "H"){
		 default_time = concantDefaultTime(start_time_param,default_time)	;
	 }

	if(parseFloat(size) <= parseFloat(1) ){
			 startTimeObj.value = default_time;
			 return ;
	}

	if(start_time_assign_p == "M" || start_time_assign_p == "" || start_time_assign_p == null)
	return ;

  	var betweenFlag = false ;
	for ( i =0; i < parseInt(size)-1; i++){

		 var	tem1 = shedFreqList[i];
		 var	tem2 = shedFreqList[i+1];
		  var	time1 = "";
		  var	time2 = "";
		  var	todayTime =	"";

		 if(durationType != "M" && durationType != "H"){
			 time1			= tem1.replace(":",".");
			 time2			= tem2.replace(":",".");
			 todayTime		= todayTime_p.replace(":",".");
		 }else{
		 	 time1			= tem1		;
 		 	 time2			= tem2		;
		 }

	 	//Append with Start time hrs Passed  to entered time(say 16:00 + 00:15)
		if(durationType == "M" || durationType == "H"){

		time1 = concantDefaultTime(start_time_param,time1)	;
		time2 = concantDefaultTime(start_time_param,time2)	;
		time1 = time1.replace(":",".");
		time2 = time2.replace(":",".");


		}

 
		 //iF TIME is Equals today time then default it
		 if(parseFloat(todayTime) == parseFloat(time1)){
					if(durationType == "M" || durationType == "H" ){
					 startTimeObj.value = time1;
					 betweenFlag = true ;
					 return ;
					}

					startTimeObj.value = tem1;
					betweenFlag = true ;
					return ;

		 }

		 //if time is between than default according to the starttime assign

		 if(parseFloat(todayTime) >= parseFloat(time1)  && parseFloat(todayTime) <= parseFloat(time2) ){
 
			if(start_time_assign_p == "N" || start_time_assign_p == "C"){

					if(durationType == "M" || durationType == "H" ){
					 startTimeObj.value = time2;
					 betweenFlag = true ;
					 return ;

					}
 
					startTimeObj.value = tem2;
					betweenFlag = true ;
					return ;
			}

			if(start_time_assign_p == "P"){

					if(durationType == "M" || durationType == "H"){
					 startTimeObj.value = time1;
					 betweenFlag = true ;
					 return ;

					}



					 startTimeObj.value = tem1;
 					 betweenFlag = true ;
 					 return ;
			}


			if(start_time_assign_p == "M")
			return ;

		}

	}

	   	if(betweenFlag) {
				startTimeObj.value = default_time;
		}


}
/*****************CALCULATE TIME AND DATE*********************************/

function calculateEndDateTime(start_date_time,start_time_assign_p,start_time_round){
	if(start_date_time!='' && start_time_assign_p!='')
	{
		var dt 	 		= start_date_time
		var date 		= dt.split(" ");
		datearray 		= date[0].split("/");


		dt = new Date(datearray[2],parseFloat(datearray[1])-1,datearray[0])

		var day 	 = dt.getDate();

		if(start_time_assign_p == "N" || start_time_assign_p == "C")
		day 		 = parseFloat(day) + parseFloat(start_time_round);
		else
		day 		 = parseFloat(day) - parseFloat(start_time_round);

		date		 = dt.setDate(day);
		date		 = new Date(date);



		return buildDate(date);

	}
}

/*************************************************************************/

function buildDate(date){

	var days 	= (date.getDate());

	if (parseFloat(days)<10){
		days='0'+days;
	}

	var month 	= (date.getMonth());
	month       = parseFloat(month) +1 ;
	if (parseFloat(month)<10){

		month='0'+month;
	}

	var minutes 	= (date.getMinutes());
	if (parseFloat(minutes)<10){
		minutes='0'+minutes;
	}

	var hours 	= (date.getHours());
	if (parseFloat(hours)<10){
		hours='0'+hours;
	}

	var dtString 		= days+'/'+month+'/'+date.getYear() ;
	return 	 dtString;
}

/**************************************************************************/

function reset() {
	if(f_query_add_mod.document.forms[0].name == "scheduleFreqencyAddMod"){//add Modify mode
		getHandle();
		formObj.reset();
		if(formObj.mode.value == MODE_INSERT){//insert mode
		removeOptions();
		}else{
		chkCheckedBox();
		}
	}else{
		f_query_add_mod.document.forms[0].reset()//Query Mode

	}
}

/***********************************************************************/

function formatMin(objValO){
	var objVal = "" + objValO ; //this assign to make parseFloat to String

	if(parseFloat(objVal) < 10){
		if( ("" + objVal.length) < 2  )
			return	("0" + objVal);
		else
			return objVal ;
	}else
			return	 objVal ;
}

/*****************************************************************************/

function chkTimeLocal(time1){ //This Cheking Only when duration type is hours and minutes


			var retval=true;


			if( (time1.charAt(time1.length-1) )!=":")
			{
				var time1arr=new Array()
				time1arr=time1.split(":")

				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]

					time1hr=parseFloat(time1hr)
					time1min=parseFloat(time1min)

					if(parseFloat(time1hr) <= 0)
					{
						if(time1min>=60)
						{
								retval=false;

					  	}
					}else{
						retval=false;

						}
				}else{
					retval=false;

					}
			}else{
				retval=false;

			}

			return retval
}
/***************************************************************************/
function doSync(frmObj)
{
	 var xmlDoc="";
	 var xmlHttp = new XMLHttpRequest();
	 var  xmlString = buildXml(frmObj);
	 //xmlDoc.loadXML(xmlString);
	 xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	 xmlHttp.open("POST","../../eOR/jsp/ScheduleFrequeuncySubmit.jsp",false);
	 xmlHttp.send(xmlDoc);
	 return xmlHttp.responseText  ;
}
/****************this methos is called by the Sync jsp in retrun text******/
function syncStatus(flag1)
{
	flag = flag1;
}
/***********************doSync****************************************/
function buildXml(frmObj)
{
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;

	var callFrom = "FORM_SUBMIT";
	var xmlStr ="<root><SEARCH ";
	xmlStr += "callFrom=\""+ callFrom +"\" " ;			

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

		}
	}
	}
    xmlStr +=" /></root>";


	return xmlStr;

}
/********************For PH**************************/
function chkQty(obj,fractallowyn){//Modified by Uma on 7/1/2010 for IN022432
 getHandle();
  var chk_unit		= doc.chk_unit.value;
  var unit_qty		= doc.unit_qty.value;


  //if(obj.value!="") //&& (parseInt(obj.value,10)!=0) && (parseFloat(obj.value)!=0))//Added by Ambiga.M on 3/15/2010 for 20028 only if and else condition
  if(obj.value!="" && (parseFloat(obj.value)!=0))//IN046042
  {
	  if((fractallowyn=="Y")&&(parseFloat(obj.value)!=0)||((fractallowyn=="N")&&(parseInt(obj.value,10)!=0)))//Added by Uma on 7/1/2010 for IN022432
	  {
		  if(chk_unit == "N" || chk_unit == "n")
			  return ;
		 
		  if(parseFloat(obj.value) > parseFloat(unit_qty)){
			  alert(getMessage("DOSE_LIMIT","OR"));
			  obj.focus();
			  return;
		  }

		  var noQty = parseInt(repeatValue) ;
	  }
	  //IN046042 Starts
	  /*else
	  {
		alert(getMessage("SCHD_ENTER_VALID_QTY","OR"));
		obj.focus();
		return;
	  }*/
	  //IN046042 Ends
  }
  else
  {
		alert(getMessage("SCHD_ENTER_VALID_QTY","OR"));
		obj.focus();
		return;
  }
 /* for (i=1;i<=noQty;i++){

		var qty = eval("doc.all.qty"+ i );

		if(qty.value == "" || qty.name == obj.name )
			continue ;


		if(parseFloat(qty.value) == parseFloat(obj.value) ){
		 alert(getMessage("QTY_NOT_EQUAL"));
		 obj.focus();
		 return ;
		}


  }*/
}
/***********************************************************************/
function doClose(){
	window.close();
	
}
/**********************************************************************/

function ok()
{
	getHandle();
	//populateDetail();
	if(f_query_add_mod.document)
	{
		if(f_query_add_mod.document.scheduleFreqencyAddMod)
		{
			if(f_query_add_mod.document.scheduleFreqencyAddMod.isSchdApplicable)
			{
				var isSchdApplicable				= f_query_add_mod.document.scheduleFreqencyAddMod.isSchdApplicable.value;
				var hdr_frequency_code		= f_query_add_mod_hdr.document.getElementById("hdr_frequency_code").value;
				//var hdr_duration_def_value	= f_query_add_mod_hdr.document.getElementById("hdr_duration_def_value").value;
				if(f_query_add_mod_hdr.document.getElementById("hdr_duration_value"))
				var hdr_duration_value			= f_query_add_mod_hdr.document.getElementById("hdr_duration_value").value;
				var hdr_duration_code			= f_query_add_mod_hdr.document.getElementById("hdr_duration_code").value;
				var row_value			= f_query_add_mod.document.getElementById("row_value").value;
				var retArray	= new Array();
					
				if (isSchdApplicable != 'false')
				{
					if(!dateValilate())		
					return;
					//var start_date_time = doc.start_day_param.value  +" " +  doc.all.start_time_param.value;
					var start_date_time = f_query_add_mod.document.getElementById('start_day_param').value  +" " +  f_query_add_mod.document.getElementById('start_time_param').value;
					eval(doSync(formObj));

					/*var catalog_code = doc.all.catalog_code.value;
					var row_value = doc.all.row_value.value;
					if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id)
						bean_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id.value ;
					if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name)
						bean_name 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name.value ;
						var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
						var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
						xmlStr			= "<root><SEARCH " ;
						xmlStr 			+=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_code="+catalog_code+"&row_value="+row_value+"&func_mode=START_DATE", false ) ;
						xmlHttp.send( xmlDoc ) ;
						responseText	= xmlHttp.responseText ;
						eval( responseText ) ;*/
					//retArray[0]	=	doc.all.start_day_param.value  +" " +  doc.all.start_time_param.value;
					retArray[0]	=	f_query_add_mod.document.getElementById('start_day_param').value  +" " +  f_query_add_mod.document.getElementById('start_time_param').value;
					retArray[1]	=	hdr_frequency_code;
					retArray[2]	=	hdr_duration_value;
					retArray[3]	=	hdr_duration_code;
			
			
					if(retArray[0]==null) retArray[0] = "";
					if(retArray[1]==null) retArray[1] = "";
					if(retArray[2]==null) retArray[2] = "";
					if(retArray[3]==null) retArray[3] = "";				
					calculateEndDateTime(start_date_time,hdr_duration_code,hdr_duration_value,row_value,'');	//start_date_time,Duration Code,Duration Value,called_from is null
					
					//window.returnValue =retArray;
					let dialogBody = parent.parent.document.getElementById('dialog-body');
					if(dialogBody==undefined)
					{
						dialogBody = parent.document.getElementById('dialog-body');
					}
					dialogBody.contentWindow.returnValue = retArray;
					doClose()	;
				}
				else
				{
					alert(getMessage("NO_SCHEDULE","OR"));
					return false;
				}
			}
		}
	}
}

// Renamed By Sridhar Reddy on 310809 SRR20056-CRF-0274
function ok1(){
if(!dateValilate())		
	return;
	

getHandle();
//Chk  the Invalid time entry
var noTime = parseInt(repeatValue) ;


var startTime = "";

var prevValidValue  = "";

var module_id		= doc.module_id.value;

//var called_from  	= doc.all.called_from.value;



if(module_id == "PH"){//Only if called from PH
	var totalEnteredValue = 0;
	var max_qty			= doc.max_qty.value	 ;
	var chk_max		    = doc.chk_max.value;

	var allQtySameFlag		= true ;
	var qtyVal				= doc.qty1.value;

	for(i = 1; i<=noTime ; i++){

			//var qty = eval("doc.all.qty"+ i );
			var qty =document.getElementById("qty" + i);


			if(parseFloat(qtyVal) != parseFloat(qty.value))
				allQtySameFlag =  false ;
			if(qty.value == null || qty.value == "" ){
			alert(getMessage("SCH_FREQ_BLANK","OR"));
			//if(called_from=="apply")
			//	maxWindow();
			qty.focus();
			return ;
			}else{
			totalEnteredValue += parseFloat(qty.value);
			}


	}

	 if(noTime == 1){//if only one flag is there no need for check
	  allQtySameFlag = false ;
	 }


	/*	if(allQtySameFlag){
	//	alert(getOrMessage("QTY_VAL_NOT_SAME"));
	//	alert("All Qty Values Cannot be same....");
		return ;
	}
    */

	if(chk_max == "Y" || chk_max == "y")	{
		if(parseFloat(totalEnteredValue)>parseFloat(max_qty) ){
			alert(getMessage("DOSE_LIMIT","OR"));
			//if(called_from=="apply")
			//	maxWindow();
			return
		}
	}

} //End of PH

for(i = 1; i<noTime ; i++){

	/*var time1 = eval("doc.all.time"+ i );
	var time2 = eval("doc.all.time"+ (i+1) );*/
	var time1 =document.getElementById("time" + i);
	var time2 =document.getElementById("time" + (i + 1));

	
	var comp1 =	time1.value ;
	var comp2 =	time2.value ;



	//Logic to give first starting time
	if(startTime == ""){
		if(time1.value != "" )
		   startTime = time1.value ;
		
	}

	/*****Logic to take care if one of entry is not there in Hrs feild*******/
	if(prevValidValue == "" &&	time1.value == ""){

	if(time2.value != "")
		prevValidValue = time2.value ;
	continue ;
	}else{
	   if(time1.value == "")
			 comp1  = prevValidValue ;
	}

	//assign the valid values to the prevValidValue feild
	if((time1.value == "" || time2.value == "") && prevValidValue =="" ) {
		if(time2.value != "")
		prevValidValue = time2.value ;
		else{
		if(time1.value != "")
			prevValidValue = time1.value ;
		}

	continue ;
	}


	//assign the valid values to the prevValidValue feild
	if(time2.value != "")
		prevValidValue = time2.value ;
	else{
		if(time1.value != "")
			prevValidValue = time1.value ;
	}



   if(compareTime(comp1,comp2)){

	   
		var message  = getMessage("INVALID_TIME_ENTRY_FORMAT","AM");
		alert(message);
		//if(called_from=="apply")
		//		maxWindow();
		return ; 
	}

}//Validation of values Entered

 if(startTime == ""){
 	  if(time2 != null){
		if(time2.value != "" )
		   startTime = time2.value ;}
	  else
	       //startTime = eval("doc.all.time1.value" ) ;
	       startTime =document.getElementById("time1").value;
  }


//calculate no of times-field entered
var noTimeEntered	=  0;
var noDayEntered	=  0;

for(i = 1; i <= noTime ; i++){
	//var time = eval("doc.all.time"+ i );
	var time =document.getElementById("time" + i);
	if(time.value != "")
		++noTimeEntered;
}


//calculate no of days field entered
if(durationType == "W"){
	for(i = 1; i <= 7 ; i++){
		//var day = eval("doc.all.daySM"+ i );
		var day =document.getElementById("daySM" + i);

	if(day.checked == true)
		++noDayEntered;
	}
}

if(durationType != "W")
	noDayEntered = 1;

//chk whether no of days field entered is noTime-no of times field==throw err
if((parseInt(noTimeEntered) * parseInt(noDayEntered))!= parseInt(repeatValue)){
	
	var message  = getMessage("INVALID_TIME_DAY_COMB","AM");
	alert(message);
	//if(called_from=="apply")
	//		maxWindow();
	return ;
}
if(module_id == "OR" || module_id == ""){//Only if called from PH

	//Validate the date Entered
	if(!dateValilate())
		
			return;

	//Check time falls with in Scheduled times
	if(!chkTimeFallOnOK()){

		
		return  ;
	}

	//Check start time Validate for Past , future and Visit admin. time
	if(!chkStartTimeOK()){
		
		return  ;
	}

}

eval(doSync(formObj));




window.returnValue =doc.start_day_assign.value  +" " +  doc.start_time_assign.value;


doClose()	;

}


function maxWindow() {
		parent.dialogTop   = "240";
		parent.dialogHeight= "17" ;
 		parent.dialogWidth = "28" ;
}
/*****Order Entry Validation **************/
function chkStartTimeOK(){

	getHandle();

	var startTimeObj      		   = formObj.start_time_assign;
	var startDayObj      		   = formObj.start_day_assign;

	var start_day_time			   = startDayObj.value +  " "  + startTimeObj.value ;


	var visit_adm_date      	   = formObj.visit_adm_date.value;
   	var future_order_date      	   = formObj.future_order_date.value;
	var past_order_date      	   = formObj.past_order_date.value;

	if(doDatetimeCheckAlert(visit_adm_date,start_day_time)){
		alert(getMessage("ADMDATE_LESS_DATE","OR"));
		return false ;
	}else{


		// Entered Date should not be less than Past Ordered Date
		if(doDatetimeCheckAlert(past_order_date,start_day_time)){
			alert(getMessage("SHEDULE_BACK_DATE_TIME","OR"));
			return false ;
		}else if(doDatetimeCheckAlert(start_day_time,future_order_date)){
		// Entered Date should not be greater than future Ordered Date
			alert(getMessage("SHEDULE_FUTURE_DATE_TIME","OR"));
			return false ;
		}else

		return true;
	}
	return true;
}



/*****Method Chks whether the start time falls within the Sched. times*****/
function  chkTimeFallOnOK(){
  getHandle();

	var startTimeObj      	   = formObj.start_time_assign;
	var start_time			   = startTimeObj.value;
	var noTime				   = parseInt(repeatValue) ;
	var valTimeFlag			   = false;

	if(startTimeObj.value == ""){
		alert(getMessage("START_TIME","OR"));
		return false ;
	}

	for(i = 1; i<=noTime ; i++){

		var time2 = eval("doc.all.time"+ i );

		if(time2.value == "")
			continue ;

		var tem1 = start_time.replace(":",".");
		var tem2 = time2.value.replace(":",".");

		if(durationType == "M" || durationType == "H" ){
			 var time_min = tem1.split(".") ;
			 tem1  = "00." +  time_min[1] ;
		}

		if(parseFloat(tem1) == parseFloat(tem2)){ // Repeat times entered should fall on or after the start date and time.
			 valTimeFlag = true ;
			 break ;
		}
	}
		if(!valTimeFlag){
			alert(getMessage("START_DATE_TIME_VALIDATE","OR"));
			return false;
		}else{
			return true ;
		}



 }



/**************Date Validate ********************/

function HMStoSec1(Time) { 

  var A = Time.split(":"); 
 var min = (A[0]*60)+A[1];
  return min;
}

function  dateValilate(){

	/**
	   Note : start_time_assign_p notation coresponds to "N" , "C" , "P"
			  start_time_assign notation coresponds to Current time 12:12
	  **/
	getHandle();


	var todayTime			= formObj.todayTime.value ;
	var todayDate			= formObj.todayDate
	var startTimeAssignObj 	= formObj.start_time_assign_p;
	var startDate	      	= formObj.start_day_assign;
	var today				= formObj.today.value ;
	var dummmyDate			= formObj.dummmyDate ;
	var repeat			= formObj.repeat.value ;
	var durationType = formObj.durationType.value;



	var validFlag           = false ;

	if(startDate.value == ""){
		alert(getMessage("START_DATE","OR"))
		return false ;
	}
	var n = 0;
	
/*	if(durationType != "W")
		return true ;*/

	var arr = new Array();	
	
	for (var j = 1;j<=parseInt(repeat) ;j++ )
	{		
		var time = eval("formObj.time"+j);
		if (time != null)
		{
			if (time.value =="")
			{			
				arr[n] = "Repeat "+j;	
				n++;
			}		
		}			
	}

	if (arr.length > 0)
	{
		var msg = getMessage("TIME_BLANK","OR");
		var msg1="";
		for (var m=0;m< arr.length;m++)
		{	
			msg1 +=msg.replace("$",arr[m])+"\n";
		}
		   alert(msg1);
		    return false;		
	}

	for (var i = 1;i<=parseInt(repeat) ;i++ )
	{
		if (durationType == "W" || durationType == "L")
		{
			var day = eval("formObj.admin_day"+i);
		}else{
			var day = "0";
		}
		var time = eval("formObj.time"+i);
		for (var k = i+1;k<=repeat ;k++ )
		{
			if (durationType == "W" || durationType == "L")
			{
				var day1 =  eval("formObj.admin_day"+k);
			}else{
				var day1 = "0";
			}			
			var time1 =  eval("formObj.time"+k);
			
			if (day.value == day1.value)
			{			
				if (time != null && time1 != null)
				{
					var time2 = HMStoSec1(time.value);
					var time3 = HMStoSec1(time1.value);
					var diff = time2 - time3;
					if (diff >= 0 )
					{
						arr[n] = "Repeat "+i+" and "+"Repeat "+ k;
						n++;
					}	
				}										
			}			
		}
	}	

	if (arr.length > 0)
	{
		var msg = getMessage("ORDER_SCHEDULE_TIME","OR");
		var msg1="";
		for (var m=0;m< arr.length;m++)
		{	
			msg1 +=msg.replace("$",arr[m])+"\n";
		}
		   alert(msg1);
		    return false;
	}
	
/*	//IF start time assign is next
	if ((startTimeAssignObj.value == "N")||(startTimeAssignObj.value == "C")){

	   var start_time_round =0;	   
		
		 /*  if( doDateCheckOR(startDate,todayDate) == "0"){			  
		    return true;
			}		

      for(j = parseInt(today)+1 ; j <= 7 ; j++){
			++start_time_round ;
			
				dummmyDate.value = calculateEndDateTime(formObj.todayDate.value,startTimeAssignObj.value,start_time_round) ;
		/*		if( doDateCheckOR(startDate,dummmyDate) == "0"){
				 validFlag = true ;
		       }
			   dummmyDate.value = "";
	        
	   }

	   for(j = 1  ; j <= parseInt(today)-1 ; j++){
            ++start_time_round ;			
				dummmyDate.value = calculateEndDateTime(formObj.todayDate.value,startTimeAssignObj.value,start_time_round) ;
			/*	if( doDateCheckOR(startDate,dummmyDate) == "0"){
				 validFlag = true ;
		       }
			   dummmyDate.value = ""		   
	   }

	 } //End of IF start time assign is next

*/	//validFlag = true;
/*	 if(!validFlag){		 
		    return false;
	  }*/

	  return true ;

}

  function callCheckDate(obj,catcode)
  {
	  CheckDate(obj);
	  setValue("start_day_assign"+catcode,obj.value);
  }

  function callStoreTime(obj,catcode)
  {
	  setValue("start_time_assign"+catcode,obj.value);
  }


function storetime(id,obj,catcode,freqcode)
{
	setValue("time"+id+catcode+freqcode,obj.value);
}

/**************************************************************************/

/**
Reference Pattern for Frame's and form Object For ScheduleFrequency
--------------------------------------------------------------------
{Classes-->	1)ScheduleFrequencyCompBean.java
			2)SceduleFreqeuncyInterface.java }
Menu
	|
	ScheduleFrequency.jsp---->ScheduleFrequency.js===>>>TEMP-ScheduleFrequeuncySubmit.jsp(Called to submit the value)
		|	|
		|------Frame=f_query_add_mod/jsp=ScheduleFrequencyAddModifyUtility.jsp
		|				|
		|------Frame=close/ScheduleFrequencyButtons
		|

**/
//Modified by Ambiga.M on 2/4/2010	for 18855 occurrences of "en" (in this method) are replaced with locale to handle thai language --in plusDate(),getDayOfWeekAsShortText(),isBefore()
function changeScheduleDates(obj,index)
{
	var totalDuration = "";
	var weekName = "";
	var dispalySchd = "";
	var objVal ="";
	var formObj = document.scheduleFreqencyAddMod;
	var locale = formObj.localeName.value;
	var durationType = formObj.durationType.value;
	if(durationType=="D")
		 objVal = 1;
	else
		 objVal = obj.value;
	var timeObj = eval("document.scheduleFreqencyAddMod.time"+index);
	var colID = eval("document.getElementById('dispalySchedule')"+index);
	var repeat = eval("document.getElementById('repeat')"+index);	
	var timeVal = timeObj.value;
	var duration = formObj.pr_duration.value;
	var pr_duration_type = formObj.pr_duration_type.value;
	
	var start_day_param = formObj.start_day_param.value;
	var start_time_param = formObj.start_time_param.value;
	var Interval_value = formObj.Interval_value.value;
	var start_day_time_param = start_day_param+" "+start_time_param;
	
	var currentDate = plusDate(start_day_param, "DMY", locale, objVal-1, 'd');
	var dayName = getDayOfWeekAsShortText(currentDate, "DMY", locale);

	var current_date_time = currentDate+" "+timeVal;	
	
	
	var dateSytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #000000;font-weight:normal;	text-align:left;	padding-left:10px;padding-right:10px;vertical-align:middle;'";
	var daySytle = "style='height:18px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;color: #990000;font-weight:bold;	text-align:center;padding-left:10px;padding-right:10px;vertical-align:middle;'";
	var endDate = "";
	
	
	if (durationType.toUpperCase() == "L")
	{ 
		if(pr_duration_type.toUpperCase() == "Y")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (365*duration), "d");
			totalDuration = (duration * 12)/Interval_value;
		}else
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale,  (30*duration), "d");
			totalDuration = (duration)/Interval_value;		
		}
	}else if (durationType.toUpperCase() == "W")
	{
		if(pr_duration_type.toUpperCase() == "Y")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (365*duration), "d");
			totalDuration = (duration * 52)/Interval_value;
		}else if(pr_duration_type.toUpperCase() == "L")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (30*duration), "d");
			totalDuration = (duration * 4)/Interval_value;
		}else 
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (7*duration), "d");
			totalDuration = (duration)/Interval_value;
		}
	}else if (durationType.toUpperCase() == "D")
	{
		if(pr_duration_type.toUpperCase() == "Y")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (duration*365), "d");
			totalDuration = (duration * 365)/Interval_value;
		}else if(pr_duration_type.toUpperCase() == "L")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (duration*30), "d");
			totalDuration = (duration * 30)/Interval_value;	
		}else if(pr_duration_type.toUpperCase() == "W")
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, (duration*7), "d");
			totalDuration = (duration * 7)/Interval_value;	
		}else 
		{
			endDate = plusDate(start_day_time_param, "DMYHM", locale, duration, "d");
			totalDuration = (duration)/Interval_value;	
		}
	}

	endDate = minusDate(endDate,"DMYHM",locale, 1,"m");
	
	if (totalDuration > 5 )
	{
		if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
		{		
			dispalySchd = currentDate+" "+dayName;					
		}else{
			currentDate = plusDate(start_day_param, "DMY", locale, 1, "d");			
			dayName = getDayOfWeekAsShortText(currentDate, "DMY", locale);
			dispalySchd = currentDate+" "+dayName;	
		}
		
	}else{				
		if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale) )
		{
			dispalySchd = "<tr><td "+dateSytle+">"+currentDate+"</td>";	
			weekName = "<tr><td "+daySytle+">"+dayName+"</td>";						
		}else{
			if (durationType.toUpperCase() == "D")
			{
				currentDate = plusDate(start_day_param, "DMY", locale, 1, "d");
				dayName = getDayOfWeekAsShortText(currentDate, "DMY", locale);		
				dispalySchd = "<tr><td "+dateSytle+">"+currentDate+"</td>";	
				weekName = "<tr><td "+daySytle+">"+dayName+"</td>";						
			}
		}
	}  
	
	for (var i = 0;i<totalDuration ;i++ )
	{
		if (durationType.toUpperCase() == "L")
		{
			currentDate = plusDate(currentDate, "DMY", locale, 30*Interval_value, 'd');
			dayName = getDayOfWeekAsShortText( currentDate, "DMY", locale);
			current_date_time = currentDate+" "+timeVal;
			if (isBefore(current_date_time, endDate, "DMYHM",locale))
			{
				
				if (totalDuration > 5 )
				{
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						if (dispalySchd != "")						
							dispalySchd += "`~"+currentDate+" "+dayName;		
						else
							dispalySchd = "`~"+currentDate+" "+dayName;		
						
					}
				}else
				{						
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						dispalySchd += "<td "+dateSytle+">"+currentDate+"</td>";	
						weekName += "<td "+daySytle+">"+dayName+"</td>";
					}
				}
			}
		}else if (durationType.toUpperCase() == "W")
		{
			currentDate = plusDate(currentDate, "DMY", locale, 7*Interval_value, 'd');
			dayName = getDayOfWeekAsShortText( currentDate, "DMY", locale);
			current_date_time = currentDate+" "+timeVal;
			if (isBefore(current_date_time, endDate, "DMYHM",locale))
			{				
				if (totalDuration > 5 )
				{					
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						if (dispalySchd != "")						
							dispalySchd += "`~"+currentDate+" "+dayName;		
						else
							dispalySchd = "`~"+currentDate+" "+dayName;				
					}
				}else
				{						
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						dispalySchd += "<td "+dateSytle+">"+currentDate+"</td>";	
						weekName += "<td "+daySytle+">"+dayName+"</td>";
					}
				}			
			}
		}else if (durationType.toUpperCase() == "D")
		{			
			currentDate = plusDate(currentDate, "DMY", locale, 1*Interval_value, 'd');		
			dayName = getDayOfWeekAsShortText( currentDate, "DMY", locale);
			current_date_time = currentDate+" "+timeVal;			
			if (isBefore(current_date_time, endDate, "DMYHM",locale))
			{   					
				if (totalDuration > 5 )
				{
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						if (dispalySchd != "")						
							dispalySchd += "`~"+currentDate+" "+dayName;		
						else
							dispalySchd = "`~"+currentDate+" "+dayName;				
					}
				}else
				{													
					if (isAfter(current_date_time,start_day_time_param, "DMYHM", locale))
					{
						dispalySchd += "<td "+dateSytle+">"+currentDate+"</td>";	
						weekName += "<td "+daySytle+">"+dayName+"</td>";
					}
				}
			}
		}
	}
	if (totalDuration <= 5)
	{
		dispalySchd += "</tr>";
		weekName += "</tr>";
	}
	
	if (totalDuration > 5 )
	{
		 var bean_id_caller  = formObj.bean_id_caller.value;
		 var bean_name_caller = formObj.bean_name_caller.value;
		 var xmlDoc="";
		 var xmlHttp = new XMLHttpRequest();
		 var callFrom = "SCHEDULE_DATES";
		 var xmlStr ="<root><SEARCH ";
		 xmlStr += "callFrom=\""+ callFrom +"\" " ;					 
		 xmlStr += "bean_id_caller=\""+ bean_id_caller +"\" " ;					 
		 xmlStr += "bean_name_caller=\""+ bean_name_caller +"\" " ;					 
		 xmlStr += "schedule_dates=\""+ dispalySchd +"\" " ;				
		 xmlStr += "repeat=\""+ repeat.value +"\" " ;				
		 xmlStr +=" /></root>" ;				
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		 xmlHttp.open("POST","../../eOR/jsp/ScheduleFrequeuncySubmit.jsp",false);
		 xmlHttp.send(xmlDoc);		
		 var responseText=xmlHttp.responseText;
		 eval(responseText);
		 colID.innerHTML = "";
		colID.innerHTML = "<a href='#' onclick='showScheduleDates(\""+bean_id_caller+"\",\""+bean_name_caller+"\",\""+index+"\");'>Schedule</a>"
	}else{		
		colID.innerHTML = "";
		colID.innerHTML = "<table class='gridComponentHolder'>"+dispalySchd+" "+weekName+"</table>";
	}

}
async function showScheduleDates(bean_id,bean_name,repeat)
{	
	var retVal;
 	var dialogTop   = "10";
 	var dialogHeight= "90vh" ;
 	var dialogWidth = "90vw" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=auto; status=no';
 	var arguments	= "";

 	qryString = "bean_id="+bean_id+"&bean_name="+bean_name+"&repeat="+repeat;
 	
	retVal 			= await window.showModalDialog("../../eOR/jsp/ViewScheduleDates.jsp?"+qryString,arguments,features);

}

//function setFrequencyCode(key, obj)
//{
	//var value=obj.value;
	//setValue(key,value);
//}

/*Added by Uma on 11/26/2009 for IN003477*/
function setFrequency(obj,i,catalog_code,facility_id,val)
{
	document.scheduleFreqencyAddModHeader.hdr_duration_code.value="";
	document.scheduleFreqencyAddModHeader.hdr_frequency_val.value="";
	document.scheduleFreqencyAddModHeader.hdr_freq_nature.value="";
	document.scheduleFreqencyAddModHeader.hdr_repeat_value.value="";

	removeSchedule(i, catalog_code); // To remove the Schedule Frequency

 	if(obj.value!='')
	{
		//if(val=="onChange")
			//parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value="1";

		var bean_id = "";
		var bean_name = "";
		if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id)
			bean_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id.value ;
		if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name)
			bean_name 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name.value ;
		var patient_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.patient_id.value ;
		var encounter_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.encounter_id.value ;
		var hdr_duration_type 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_type.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr			= "<root><SEARCH " ;
		//xmlStr 			+= name+"=\""+ value +"\" " ;
		xmlStr 			+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&hdr_duration_type="+hdr_duration_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=SCHDDURATIONVALUES", false ) ;
		//xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?hdr_duration_type="+hdr_duration_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=SCHDDURATIONVALUES", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;

		var value = obj.value.split("~~");
		if(value[0]==null) value[0] = "";
		if(value[1]==null) value[1] = "";
		if(value[2]==null) value[2] = "";if(value[3]==null) value[3] = "";if(value[5]==null) value[5] = "N";//Schedule_yn
		if(value[6]==null) value[6] = "F"; //freq_nature
		if(value[1] == "" && parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.order_category.value=="PH" ){
			value[0] ="ONCE" ;
			value[1] ="D" ;
			value[2] ="1" ;
			parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value="1";
		}
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_frequency_val.value=value[0];
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.value=value[1];
		if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code)
		{
			if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.options)
			{
				var len=parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.options.length;
				if(len>1)
				{
					for(var durlen=0;durlen<(len-1);durlen++)
					{
									
						if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.options(durlen).value!='')
						{		
							if(trimString(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.options(durlen).value)==trimString(value[1]))
							{
								parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.options(durlen).selected=true;
								durlen=len;
							}
						}
					}
				}
			}
		}
		//eval("document.placeOrderForm.duration_code"+i+".value=value[1]");
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_def_value.value=value[2];
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_repeat_value.value=value[3];
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_freq_nature.value= value[6];
 		if(value[0]==null || value[0]=="" || value[1]== null || value[1]=="")
		{
			//eval("document.placeOrderForm.duration_value"+i+".value=''");
			parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.readOnly=true;
		}
		else
			parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.readOnly=false;

		//	eval("<a href="javascript:DisplaySchedule('Schedule<%=records[0]%>','<%=i%>','<%=bean.getLoginFacilityId()%>')" title='Schedule'>Schd</a>
		if(value[5]=="Y")
		{
			//eval("document.getElementById("schedule_yn")"+i+".value = value[5]");
			//eval("document.getElementById("schedule")"+i+".innerHTML = \"<a class='gridLink' href=javascript:DisplaySchedule('"+catalog_code+"','Schedule"+catalog_code+"','"+i+"','"+facility_id+"','')  title='Schedule Frequency'><font size='1'>'"+getLabel("eOR.Schd.label","OR")+"'</font></a><img src='../../eCommon/images/mandatory.gif'></img>\" ");
		}
		else
		{
			//eval("document.getElementById("schedule")"+i+".innerHTML=\"&nbsp;\"");
			//eval("document.getElementById("schedule_yn")"+i+".value = value[5]");
		}
		// If start_date_time, duration_code and duration_value is not null it should calculate the end_date_time
		start_date_time = parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_start_date_time.value;
		duration_code	=parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.value;
		duration_value = parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value;
		//calculateEndDateTime(start_date_time,duration_code,duration_value,i,'');	//start_date_time,Duration Code,Duration Value,called_from is null
	}
	else
	{
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value="";
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_repeat_value.value="";
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.readOnly=true;
		//eval("document.getElementById("schedule")"+i+".innerHTML=\"&nbsp;\"");
		//eval("document.getElementById("schedule_yn")"+i+".value = 'N'");
	}
	populateDetail();
}

function removeSchedule(i, catalog_code)
{ // to remove the schedule frequency set
// Call the dynamic jsp to remove the value (Schedule Frequency) from the bean.
	var bean_id = "";
	var bean_name = "";
	if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id)
		 bean_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id.value ;
	if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name)
	 bean_name 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name.value ;
	var patient_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.patient_id.value ;
	var encounter_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.encounter_id.value ;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	//xmlStr 			+= name+"=\""+ value +"\" " ;
	xmlStr 			+=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_code="+catalog_code+"&row_value="+i+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=REMOVE_SCHEDULE", false ) ;
	//xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?catalog_code="+catalog_code+"&row_value="+i+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=REMOVE_SCHEDULE", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
} // end of removeSchedule

 function checkMaxValue(obj,max_durn_value,chk_for_max_durn_action,prompt_msg,soft_stop_yn,row_value,catcode)
 {
 	if(obj.value!="")
 	{
 		if(obj.value==0)
 		{	
 			alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","COMMON"));
 			obj.focus();
 		}
 		else
 		{
 			if(max_durn_value !='' && max_durn_value !='0')
 			{
 				if(parseInt(obj.value) > parseInt(max_durn_value))
 				{
 					if(chk_for_max_durn_action=="R")
 					{
 						alert(unescape(prompt_msg)); 
 						obj.focus();
 					}
 					else
 					{
						
 						alert(unescape(prompt_msg));
 					}
 				}
 			}
 			// Calculation for the End Date and Time
		 	var start_date_time 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_start_date_time.value;
		 	var duration_code 		=parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.value;
		 	var duration_value 		= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value;
			//calculateEndDateTime(start_date_time,duration_code,duration_value,row_value,'');	//start_date_time,Duration Code,Duration Value,called_from is null
 		}
 	} // End of obj.value!=""
 	else
 	{
		//eval("parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.end_date_time"+row_value+".value=''");
 		//var frequency_val = eval("document.placeOrderForm.frequency_val"+row_value+".value")
 		//if(soft_stop_yn!="Y" && frequency_val!="")
 		//{alert(getOrMessage("DURATION_CANNOT_BE_BLANK"));}
 	}
	populateDetail();
 }

function clearSchdDurationList( docObj,form_name,row ) 
{
	if(eval(form_name+".hdr_duration_code").options)
	{
		var len = eval(docObj+".scheduleFreqencyAddModHeader.hdr_duration_code.options.length") ;
		for(var i=0;i<len;i++)
		{
			eval(docObj+".scheduleFreqencyAddModHeader.hdr_duration_code.remove(\"atc_class_l2_code\")") ;
		}
		var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval(docObj+".scheduleFreqencyAddModHeader.hdr_duration_code.add(opt)") ;
	}
} // End of clearOrderList

// To add in the List box
function addSchdDurationList(form_name,code,value,row) 
{
	if(eval(form_name+".hdr_duration_code").options)
	{
		var element 	= document.createElement('OPTION') ;
		element.value = trimString(code);
		element.text 	=trimString(value);
		form_name = eval(form_name+".hdr_duration_code");
		form_name.add(element);
	}
}

function chkDurationType(obj,catalog_code)
{
	var bean_id = "";
	var bean_name = "";
	if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id)
	  bean_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_id.value ;
	if(parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name)
	  bean_name 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.bean_name.value ;
	var durn_type = obj.value;
	var patient_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.patient_id.value ;
	var encounter_id 	= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.encounter_id.value ;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	//xmlStr 			+= name+"=\""+ value +"\" " ;
	xmlStr 			+=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&catalog_code="+catalog_code+"&durn_type="+durn_type+"&row_value="+i+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=REMOVE_FREQUENCY", false ) ;
	//xmlHttp.open( "POST", "ScheduleFrequencyValidate.jsp?catalog_code="+catalog_code+"&durn_type="+durn_type+"&row_value="+i+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&func_mode=REMOVE_FREQUENCY", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText	= xmlHttp.responseText ;
	eval( responseText ) ;
}

function clearSchdDurationType( docObj,form_name,row ) 
{
	if(eval(form_name+".hdr_duration_code").options)
	{
		var len = eval(docObj+".scheduleFreqencyAddModHeader.hdr_frequency_code.options.length") ;
		for(var i=0;i<len;i++)
		{
			eval(docObj+".scheduleFreqencyAddModHeader.hdr_frequency_code.remove(\"atc_class_l2_code\")") ;
		}
		var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval(docObj+".scheduleFreqencyAddModHeader.hdr_frequency_code.add(opt)") ;
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value = "";
		parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_def_value.value ="";
	}
} // End of clearOrderList

// To add in the List box
function addSchdDurationTypeList(form_name,code,value,row) 
{
	if(eval(form_name+".hdr_frequency_code").options)
	{
		var element 	= document.createElement('OPTION') ;
		element.value =trimString(code);
		element.text 	=trimString(value);
		form_name = eval(form_name+".hdr_frequency_code");
		form_name.add(element);
	}
}

function populateDetail(obj)
{
	var qry_str					= parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.qry_str.value;
	var interval_durn_type  = parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_type.value;
	var pr_duration_type  = parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_code.value;
	var hdr_frequency_code  = parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_frequency_code.value;
	var hdr_duration_value  =parent.f_query_add_mod_hdr.document.scheduleFreqencyAddModHeader.hdr_duration_value.value;
	var called_from="header";
	var value = hdr_frequency_code.split("~~");
	if(value[0]==null) value[0] = "";
	qry_str +="&schd_from="+called_from;
	qry_str += "&hdr_interval_durn_type="+interval_durn_type;
	qry_str +="&hdr_pr_duration_type="+pr_duration_type;
	qry_str +="&hdr_freq_code="+value[0];	
	qry_str +="&hdr_duration_value="+hdr_duration_value;	
	parent.f_query_add_mod.location.href="../../eOR/jsp/FrequencyAddModifyUtility.jsp?"+qry_str ;
}

function pasteSchdDetails()
{
	var repeat_value = parent.f_query_add_mod.scheduleFreqencyAddMod.repeat.value;
	var chkedindex = new Array();
	var chkedtot = 0;
	var pasteDetails = true;
	for(x=1; x<=parseInt(repeat_value,10); x++)
	{	
		if(eval("parent.f_query_add_mod.scheduleFreqencyAddMod.chk"+x))
		{
			if(eval("parent.f_query_add_mod.scheduleFreqencyAddMod.chk"+x).checked==true)
			{
				chkedindex[chkedtot] = x;
				chkedtot++;				
			}
		}
	}
	if((chkedindex.length)>0)
	{
		for(z=0;z<(chkedindex.length);z++)
		{
			if(z>0)
			{
				if((chkedindex[z]-1) != chkedindex[z-1])
				{
					pasteDetails = false;
					alert(getMessage("CONSECUTIVE_RECORDS_ONLY","OR"));
					return false;
				}
			}
		}
	}
	if(pasteDetails)
	{
		if((chkedindex.length)>0)
		{
			var arrpos = 0;
			for(chk=(parseInt(chkedindex[0],10)+(parseInt((chkedindex.length),10))); chk<=parseInt(repeat_value,10); chk++)
			{
				if(eval("parent.f_query_add_mod.scheduleFreqencyAddMod.qty"+chk))
				{
					eval("parent.f_query_add_mod.scheduleFreqencyAddMod.qty"+chk).value = eval("parent.f_query_add_mod.scheduleFreqencyAddMod.qty"+chkedindex[arrpos]).value;
					eval("parent.f_query_add_mod.scheduleFreqencyAddMod.time"+chk).value = eval("parent.f_query_add_mod.scheduleFreqencyAddMod.time"+chkedindex[arrpos]).value;
					arrpos++;
					if(arrpos==(chkedindex.length))
					{
						arrpos = 0;
					}
				}
			}
		}
	}
}
/*Ends Here IN003477 By Uma*/

function changeStartDate(start_date,start_time)
{
	if(start_date!=null && start_date.length>0)
	{
		doc.start_day_param.value  = start_date;
		doc.start_time_param.value = "00:00";
	}
}

// This JS Function is used to Validate the Frequency Quantity Value
//in the Frequency Set up in CIS
//Issue No:27384 by Maheshwaran.K as on 21/06/2011
function allowValidFreqNumber(fld, e, maxInt, deci)
{
	var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	//Modified by Maheshwaran.K as on 11/06/2011
	//Field Value is checked,if the space exists , it is eliminated and concatenated
	var fld_value_js="";
	var sequence = "1234567890.";
	for (i=0; i<fld.value.length; i++)   
		{
		if(sequence.indexOf(fld.value.charAt(i))!=-1)
			{
			//If the Dot Character already exists in the Field and Pressed Character is Dot,
			//then it wil not allow any modification in the field value,the same value exists in the field
			//Issue No:27384 by Maheshwaran.K as on 21/06/2011
			if((fld_value_js.indexOf('.')!=-1)&&(String.fromCharCode(whichCode)=='.'))
				{
				fld_value_js=fld.value;
				break;
				}
			else
				{
				fld_value_js=fld_value_js+""+fld.value.charAt(i);
				}
			}
		}
	//If the Dot Character is the Starting Character in the field,
	//then the Zero is added before the Dot Character
	//Issue No:27384 by Maheshwaran.K as on 21/06/2011
	if(fld.value==".")
		{
		if((fld_value_js.indexOf('.')!=-1)&&(String.fromCharCode(whichCode)=='.'))
			{
			}
		else
			{
			fld_value_js="0.";
			}
		}
	fld.value=fld_value_js;
	//End - Maheshwaran.K
	var count=fld.value.length;//ok
    var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
			{
            var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
				{
				if(whichCode!=46)
					{
					fld.value = fld.value+".";
					//alert("APP-0001 Reached Maximum Integer value");
					//return false;
					}
				}
			}
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
					{
					//Modified by Maheshwaran.K as on 10/06/2011
					//Directly the Typed value is set in the Text Field
                   //fld.value = objectValue.substring(0,maxInt)+".";
					fld.value=String.fromCharCode(whichCode);
					//End
                    return false;
					}
			
			}
		}
    }
	
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	     var strCheck = '.0123456789-';
	//alert("keycode == "+e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0; 
	for(var i=0;i<fldvalue.length;i++)
		{
        if(fldvalue.charAt(i)=='.') pointCount++;
		}
	//Issue No:27384 by Maheshwaran.K as on 21/06/2011
	//Dot Character is checked,while selecting and deleting the Content
	//then press the Dot Character,it allows the Dot Character
	if (pointCount>0 && whichCode == 46) 
		{
		if(document.selection.createRange().text.indexOf('.')!=-1)
			{
			return true;
			}
		else
			{
			return false;
			}
		}
	//End- Maheshwaran.K
    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
		{
		if(fldValue.indexOf(key) != 1 )
		return false
		}
    return true;
}

//The functions named "CheckNumbers(textObj)","formatNumber(textObj)" have been added by Dinesh T for the Incident 27384
//Starts 
function checkNumbers(textObj) 
{ 
	var ValidChars = /^[0-9]*.?[0-9]*$/; 
	var pasteData = window.clipboardData.getData("Text"); 
	pasteData = trimString(pasteData);
	
	if(ValidChars.test(pasteData))
	{
		textObj.value = pasteData;
	}
	else 
		return false; 
} 

function formatNumber(textObj)
{
   if(trimString(textObj.value).indexOf('.') == 0)
		textObj.value = "0"+trimString(textObj.value);
}
//Ends
