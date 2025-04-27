function query() {
    query_criteria_frame.location.href ="../../eOP/jsp/QPVmain.jsp" ;
}

function reset() {
query_criteria_frame.frames[0].document.forms[0].reset();
}

function clearqry() {
    parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp";
    parent.frames[0].document.query_criteria_form.txtpatid.value="";
    parent.frames[0].document.query_criteria_form.txtmrn.value="";
    parent.frames[0].document.query_criteria_form.txtenctid.value="";
    parent.frames[0].document.query_criteria_form.txtdtfrm.value="";
    parent.frames[0].document.query_criteria_form.txtdtto.value="";
    parent.frames[0].document.query_criteria_form.opservice.value="";
    parent.frames[0].document.query_criteria_form.oplocation.value="";
    parent.frames[0].document.query_criteria_form.oppract.value="";
    parent.frames[1].location.href="../../eCommon/html/blank.html";

}

/*function chkfld(){
    if(!CheckDate(parent.frames[0].document.query_criteria_form.txtdtfrm)) return false;
    if(!CheckDate(parent.frames[0].document.query_criteria_form.txtdtto)) return false;
    if(!doDateCheckAlert(parent.frames[0].document.query_criteria_form.txtdtfrm,parent.frames[0].document.query_criteria_form.txtdtto)) 
	{
		var error = query_criteria_form.getMessage('TO_DT_GR_EQ_FM_DT','SM');
		alert(err);
        return false;
    }

    var patid=parent.frames[0].document.query_criteria_form.txtpatid.value;
    var mrnno=parent.frames[0].document.query_criteria_form.txtmrn.value;
    var enctid=parent.frames[0].document.query_criteria_form.txtenctid.value;
    var dtfrm=parent.frames[0].document.query_criteria_form.txtdtfrm.value;
    var dtto=parent.frames[0].document.query_criteria_form.txtdtto.value;
    var serv=parent.frames[0].document.query_criteria_form.opservice.value;
    var loc=parent.frames[0].document.query_criteria_form.oplocation.value;
    var pract=parent.frames[0].document.query_criteria_form.oppract.value;

    var returnarray=loc.split("|");
    var locid=returnarray[0];
    returnarray=pract.split("|");
    var practid=returnarray[0];

    if( (patid == "") && (mrnno == "") && (enctid == "") ) {
        var msg=getMessage('PAT_MRN_ENC_BLANK','OP');
        parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;        
        return false;

    }

    var qrystr="blnk=N&patid="+patid+"&mrnno="+mrnno+"&enctid="+enctid+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+locid+"&pract="+practid+"&srch=Y";
    parent.frames[1].location.href="../../eOP/jsp/QPVresult.jsp?"+qrystr;
   
    //parent.frames[1].frames[1].location.href="/eCIS/op/jsp/QPVtab.jsp?"+qrystr;
}*/

function populateClinic(serv_code) {
    HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/QPVrepopClinic.jsp?serv_code="+serv_code+"'></form></BODY></HTML>";
    parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.frames[2].document.form1.submit();
}
function populatePract(practlist) {
    var strpractyn="";
    var strpracttype="";
    var strclncode="";
    var strFldArray = new Array();

    if (practlist.length != 0) {
        strFldArray = practlist.split("|");
        strclncode = strFldArray[0];
        strpractyn = strFldArray[1];
        strpracttype = strFldArray[2];
    }
    HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/QPVrepopPract.jsp?cln_code="+strclncode+"&pract_yn="+strpractyn+"&pract_type="+strpracttype+"'></form></BODY></HTML>";
    parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.frames[2].document.form1.submit();
}

async function patqry() {
    var pat_id=await PatientSearch();
    if(pat_id == null) pat_id = "";
    parent.frames[0].document.query_criteria_form.txtpatid.value=pat_id;
}
async function patvisit() {
    var retVal;
    var dialogHeight= "33vh" ;
    var dialogWidth = "50vw" ;
    var dialogTop = "80" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../eOP/jsp/PaintSearchVisit.jsp",arguments,features);
    if(retVal != null){
        if(retVal == "close")
        retVal="|";
        returnarray=retVal.split("|");

        var j1=returnarray[1];
        var j2=returnarray[0];
        parent.frames[0].document.query_criteria_form.txtenctid.value=j2;
    }
}
function dispvisit(params,service_code) {
	var arr = service_code.split('$');
	var fr_epi_id = arr[2];
	var to_epi_id = "";
	if (arr[3]!=null)
		to_epi_id = arr[3];
	var episode_status = arr[1];
	service_code = arr[0];
    parent.parent.frames[0].document.getElementById("visit_tab").src = '../../eOP/images/Visits.gif';
    parent.parent.frames[0].document.getElementById("episode_tab").src = '../../eOP/images/Episodes_click.gif';	
    var source="../../eOP/jsp/QPVvisits.jsp?"+params+"&service_code="+service_code+"&episode_status="+episode_status+"&fr_epi_id="+fr_epi_id+"&to_epi_id="+to_epi_id;
    parent.parent.frames[1].location.href=source;
}
function dispnotes(episode_id) {
    parent.frames[1].location.href="../../eOP/jsp/QPVepisodenotes.jsp?episode_id="+episode_id;
}



