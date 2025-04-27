

/* below method added by venkatesh.s against the crf  MO-CRF-20074 on 07-Aug-2014*/
function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/PatientSeriesGroupForm.jsp" ; 	
}

function reset(){

   
	if(f_query_add_mod.query_criteria && f_query_add_mod.query_criteria.document.MPPatSerGrpUserCriteria){ 
	//	document.getElementById("PatSerGrpUserID").rows='40,95,*,50';
	  // f_query_add_mod.result_frame.location.href='../../eMP/jsp/PatientSeriesGroupForUserCriteria.jsp';
		 f_query_add_mod.query_criteria.location.href='../../eMP/jsp/PatientSeriesGroupForUserCriteria.jsp';
		f_query_add_mod.result_frame.location.href='../../eCommon/html/blank.html';
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}else{
	        /* below lines modified by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
	     if(f_query_add_mod.document.forms[0]){
	//	document.getElementById("PatSerGrpUserID").rows='42,*,0,50';
		f_query_add_mod.location.href ="../../eMP/jsp/PatientSeriesGroupForUserQueryPage.jsp";}
		/* end  MO-CRF-20074 [IN:043899] */
	}
}

function query() {
	//document.getElementById("PatSerGrpUserID").rows='42,*,0,50';
	f_query_add_mod.location.href ="../../eMP/jsp/PatientSeriesGroupForUserQueryPage.jsp";
}

function PatSerUserLinkResult(){
	if(document.forms[0].pat_ser_grp_code.value!=''){
	  // alert("PatSerUserLinkResult 33= "+ document.forms[0].pat_ser_grp_code.value);
		/* Below line added by venkatesh for if used_name or user_id start with  % symbol  */   
		/* below lines modified by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
	
		parent.result_frame.location.href = '../../eMP/jsp/PatientSeriesGroupForUserResult.jsp?patSerGrpCode='+document.forms[0].pat_ser_grp_code.value+'&searchuser='+encodeURIComponent(document.forms[0].searchuser.value)+'&search_criteria='+document.forms[0].search_criteria.value;
		
		 /* end  MO-CRF-20074 [IN:043899] */
		 
		 /* Below line commented by venkatesh
        parent.result_frame.location.href = '../../eMP/jsp/PatientSeriesGroupForUserResult.jsp?patSerGrpCode='+document.forms[0].pat_ser_grp_code.value+'&searchuser='+document.forms[0].searchuser.value+'&search_criteria='+document.forms[0].search_criteria.value; */
		
	}else{
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace("$",getLabel("eMP.PatientSeries.label","MP"));
		alert(msg);
	}
}
function blockevent(event){       
	 var whichCode = (window.Event) ? event.which : event.keyCode;
    if (whichCode=='13')
	return false ;
}

function AddRemUsers(obj){
	//alert(obj.checked)
}

function apply() {

      
	 
      /* below lines added by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
	  if (! (checkIsValidForProceed()) ){
	   messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	    return false;
	   }
	   /* end  MO-CRF-20074 [IN:043899] */
	
	if(f_query_add_mod.result_frame && f_query_add_mod.result_frame.document.MPPatSerGrpUserResult){ 
		var recStart=f_query_add_mod.result_frame.document.forms[0].recStart.value;
		var recEnd=f_query_add_mod.result_frame.document.forms[0].recEnd.value;
		var recCount=f_query_add_mod.result_frame.document.forms[0].recCount.value;
		var subMitFlag=false;
		var tempUserPatLinkObj;
		var templinkedYNObj;
		for(var count=recStart;count<recCount;count++){
			tempUserPatLinkObj=eval("f_query_add_mod.result_frame.document.forms[0].user_pat_link"+count);
			templinkedYNObj=eval("f_query_add_mod.result_frame.document.forms[0].linkedYN"+count);
			if((tempUserPatLinkObj.checked && templinkedYNObj.value=="N")||(!(tempUserPatLinkObj.checked) && templinkedYNObj.value=="Y")){
				subMitFlag=true;
			}
		}
		if(subMitFlag){
			f_query_add_mod.result_frame.document.forms[0].action="../../servlet/eMP.MPPatSeriesGrpForUsersServlet";
			f_query_add_mod.result_frame.document.forms[0].submit();
		}else{ 
		   /* below lines modified by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
			//if( f_query_add_mod.document.forms[0] && f_query_add_mod.document.forms[0].name=="MPPatSerGrpUserCriteria")  {
			var msg=getMessage('NO_CHANGE_TO_SAVE','common');
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" +msg + "&err_value=0";
			return;  //} 
			/* end  MO-CRF-20074 [IN:043899] */
			/*else { 
			   messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	           return false;} */
		}		
	}else{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
}

/* below method added by venkatesh.s against  MO-CRF-20074 [IN:043899] on 06-Aug-2014 */
/*
function checkIsValidForProceed()
{      
    
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	var url_1=result_frame.location.href;
	url_1 = url_1.toLowerCase();
        
		
	if ( (url.indexOf("Criteria.jsp")==-1) && (url_1.indexOf("blank") > 0 )  ){ 
		return true;
	}else
		return false;
}
*/
function checkIsValidForProceed()
  { 
       
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1))
        return true;
    else
        return false;
  }
/* end  MO-CRF-20074 [IN:043899] */

function onSuccess(){
	if(f_query_add_mod.result_frame.document.forms[0].prevnext.value=="next"){
		var URL="../../eMP/jsp/PatientSeriesGroupForUserResult.jsp?recStart="+f_query_add_mod.result_frame.document.forms[0].recEnd.value+"&recEnd="+f_query_add_mod.result_frame.document.forms[0].recEnd.value+"&patSerGrpCode="+f_query_add_mod.result_frame.document.forms[0].patSerGrpCode.value+"&searchuser="+f_query_add_mod.result_frame.document.forms[0].searchuser.value+"&search_criteria="+f_query_add_mod.result_frame.document.forms[0].search_criteria.value;
		f_query_add_mod.result_frame.location.href =URL;
	}else if(f_query_add_mod.result_frame.document.forms[0].prevnext.value=="prev"){
		f_query_add_mod.result_frame.document.forms[0].recStart.value=(f_query_add_mod.result_frame.document.forms[0].recStart.value-14);
		f_query_add_mod.result_frame.document.forms[0].recEnd.value=f_query_add_mod.result_frame.document.forms[0].recStart.value;
		var URL="../../eMP/jsp/PatientSeriesGroupForUserResult.jsp?recStart="+f_query_add_mod.result_frame.document.forms[0].recEnd.value+"&recEnd="+f_query_add_mod.result_frame.document.forms[0].recEnd.value+"&patSerGrpCode="+f_query_add_mod.result_frame.document.forms[0].patSerGrpCode.value+"&searchuser="+f_query_add_mod.result_frame.document.forms[0].searchuser.value+"&search_criteria="+f_query_add_mod.result_frame.document.forms[0].search_criteria.value;
		f_query_add_mod.result_frame.location.href =URL;
	}else{ 
		//Modified against INC:43899
		//f_query_add_mod.result_frame.location.reload();
		f_query_add_mod.result_frame.document.forms[0].recEnd.value = f_query_add_mod.result_frame.document.forms[0].recEnd.value-14;
		var URL="../../eMP/jsp/PatientSeriesGroupForUserResult.jsp?recStart="+f_query_add_mod.result_frame.document.forms[0].recStart.value+"&recEnd="+f_query_add_mod.result_frame.document.forms[0].recEnd.value+"&patSerGrpCode="+f_query_add_mod.result_frame.document.forms[0].patSerGrpCode.value+"&searchuser="+f_query_add_mod.result_frame.document.forms[0].searchuser.value+"&search_criteria="+f_query_add_mod.result_frame.document.forms[0].search_criteria.value;
		f_query_add_mod.result_frame.location.href =URL;
	}
}

function submitNext(){
	document.forms[0].prevnext.value="next";
	var recStart=parent.result_frame.document.forms[0].recStart.value;
	var recEnd=parent.result_frame.document.forms[0].recEnd.value;
	var recCount=parent.result_frame.document.forms[0].recCount.value;
	var subMitFlag=false;
	var tempUserPatLinkObj;
	var templinkedYNObj;
	for(var count=recStart;count<recCount;count++){
		tempUserPatLinkObj=eval("parent.result_frame.document.forms[0].user_pat_link"+count);
		templinkedYNObj=eval("parent.result_frame.document.forms[0].linkedYN"+count);
		if((tempUserPatLinkObj.checked && templinkedYNObj.value=="N")||(!(tempUserPatLinkObj.checked) && templinkedYNObj.value=="Y")){
			subMitFlag=true;
		}
	}
	if(subMitFlag && confirm(getMessage('WANT_TO_SAVE','common'))){
		parent.result_frame.document.forms[0].action="../../servlet/eMP.MPPatSeriesGrpForUsersServlet";
		parent.result_frame.document.forms[0].submit();
	}else{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		parent.result_frame.document.forms[0].recStart.value=document.forms[0].recEnd.value;
		parent.result_frame.document.MPPatSerGrpUserResult.target="result_frame";
		parent.result_frame.document.MPPatSerGrpUserResult.submit();	
	}
}
function submitPrev(){
	document.forms[0].prevnext.value="prev";	
	var recStart=parent.result_frame.document.forms[0].recStart.value;
	var recEnd=parent.result_frame.document.forms[0].recEnd.value;
	var recCount=parent.result_frame.document.forms[0].recCount.value;
	var subMitFlag=false;
	var tempUserPatLinkObj;
	var templinkedYNObj;
	for(var count=recStart;count<recCount;count++){
		tempUserPatLinkObj=eval("parent.result_frame.document.forms[0].user_pat_link"+count);
		templinkedYNObj=eval("parent.result_frame.document.forms[0].linkedYN"+count);
		if((tempUserPatLinkObj.checked && templinkedYNObj.value=="N")||(!(tempUserPatLinkObj.checked) && templinkedYNObj.value=="Y")){
			subMitFlag=true;
		}
	}
	if(subMitFlag && confirm(getMessage('WANT_TO_SAVE','common'))){
		parent.result_frame.document.forms[0].action="../../servlet/eMP.MPPatSeriesGrpForUsersServlet";
		parent.result_frame.document.forms[0].submit();
	}else{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		parent.result_frame.document.forms[0].recStart.value=(document.forms[0].recStart.value-14);
		document.forms[0].recEnd.value=document.forms[0].recStart.value;
		parent.result_frame.document.MPPatSerGrpUserResult.target="result_frame";
		parent.result_frame.document.MPPatSerGrpUserResult.submit();
	}
}
