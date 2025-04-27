/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id 	= "" ;
var result 			= false;
var message 		= "" ;
var flag 			= "" ;
var globalFlag      = false;

var currClass 		= "";
var search_frames	= "";	// Global Variable used to set the value in the bean(It will be set in the OrderEntryResultMain.jsp. the frame name will be set, whether it is group/atomic/etc

var check_box_val	= new Array(); //Global Variable, used to keep track of the code selected(order wise)
