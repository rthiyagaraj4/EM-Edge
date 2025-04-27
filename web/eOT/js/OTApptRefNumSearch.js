/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function returnPatientDetails(rownum,appt_date,appt_ref_num,order_id){
	var formObj = document.responsibility_form;
	var returnValue = appt_date+"##"+appt_ref_num+"##"+order_id;
	window.returnValue = returnValue;
	window.close();
}
function lockKey(){
    if(event.keyCode == 93)
        alert(getMessage("APP-OT0084","OT"));
}
