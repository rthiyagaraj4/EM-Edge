/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function codeCheck1(Obj){
	//alert("enter");
var u=Obj;
//alert("repOTCodeCheck 1 ");
 var arr = u.split('::');
if(arr[0]==' '){
		parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
else
//alert("repOTCodeCheck 2 ");
parent.f_query_add_mod.location.href ="../../eOT/jsp/repCommonOTList.jsp?t_id="+arr[0]+"&rep_desc="+arr[1];
}
