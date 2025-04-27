var lin=""
var s
var parameters  ="";
var NumOfFlds   =0 ;
var ref;
var callpge="";

function LoadMenus1(eid,patient_id,visit_adm_type,locn_code,curr_loc_type,pract_id,p_queue_status,p_patient_class,CARE_LOCN_TYPE_IND,sex,DATE_OF_BIRTH,room_num,p_status,dt,appt_id,p_queue_date,arrival_date,curr_locn,curr_locn_type_desc,VISIT_ADM_TYPE_IND,appt_case_yn,VITAL_SIGNS_DATE_TIME,ARRIVE_DATE_TIME)
{
	
}


async function LoadMenus(eid,patient_id,visit_adm_type,locn_code,curr_loc_type,pract_id,p_queue_status,p_patient_class,CARE_LOCN_TYPE_IND,sex,DATE_OF_BIRTH,room_num,p_status,dt,appt_id,p_queue_date,arrival_date,curr_locn,curr_locn_type_desc,VISIT_ADM_TYPE_IND,appt_case_yn,VITAL_SIGNS_DATE_TIME,ARRIVE_DATE_TIME,multiflag,other_res_class,other_res_code,queue_num,appt_walk_ind,queue_id)
{
   	  
	var xl=event.clientX;
    var yl=100

    var screenH=screen.availHeight
    var screenW=screen.availWidth

    var center=screenW-screenW/2
    xl=center-60
    yl=(screenH/2)-40

    	
	var ref=self.document.location.href
    var secref=ref.substring( (ref.lastIndexOf("/")+1),ref.indexOf("?"))

	var previous_day = 0;
    if(secref=="ManageSPatQueueQueryResult.jsp")
    {
		if(parent.frames[0].document.forms[0].include_prev_visits.value == 'Y')
			previous_day = 1;
		else
			previous_day = 0;
	}

		
    var retVal =    new String();
    var dialogHeight= "60vh" ;
    var dialogWidth = "70vw" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;dialogTop="+yl+";dialogLeft:" +xl;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../eOP/jsp/menuframe.jsp?Encounter_Id="+eid+"&previous_day="+previous_day+"&patient_id="+patient_id+"&visit_adm_type="+visit_adm_type+"&locn_code="+locn_code+"&curr_loc_type="+curr_loc_type+"&pract_id="+pract_id+"&p_queue_status="+p_queue_status+"&p_patient_class="+p_patient_class+"&CARE_LOCN_TYPE_IND="+CARE_LOCN_TYPE_IND+"&sex="+sex+"&DATE_OF_BIRTH="+DATE_OF_BIRTH+"&room_num="+room_num+"&p_status="+p_status+"&dt="+dt+"&appt_id="+appt_id+"&p_queue_date="+p_queue_date+"&arrival_date="+arrival_date+"&curr_locn="+curr_locn+"&curr_locn_type_desc="+curr_locn_type_desc+"&VISIT_ADM_TYPE_IND="+VISIT_ADM_TYPE_IND+"&appt_case_yn="+appt_case_yn+"&VITAL_SIGNS_DATE_TIME="+VITAL_SIGNS_DATE_TIME+"&ARRIVE_DATE_TIME="+ARRIVE_DATE_TIME+"&multiflag="+multiflag+"&other_res_class="+other_res_class+"&other_res_code="+other_res_code+"&queue_num="+queue_num+"&appt_walk_ind="+appt_walk_ind+"&queue_id="+queue_id,arguments,features);

    if(secref=="ManageSPatQueueQueryResult.jsp")
    {
        callpge="ManageSPatResult.jsp?refresh="+refreshparam
    }
    else
        callpge=document.location.href

    if(retVal=="yes")
    {
            setTimeout('refresh()',1000);
    }
}

function refresh()
{
    self.document.location.href=callpge
}

function showmenu(lay)
{
    lay.style.visibility='visible'

    	
	if(NumOfFlds==1)
        parent.window.dialogHeight='1'
    if(NumOfFlds==2)
        parent.window.dialogHeight='3'
    if(NumOfFlds==3)
        parent.window.dialogHeight='4'
    if(NumOfFlds==4)
        parent.window.dialogHeight='5'
    if(NumOfFlds==5)
        parent.window.dialogHeight='6'
    if(NumOfFlds==6)
        parent.window.dialogHeight='7'
    if(NumOfFlds==8)
        parent.window.dialogHeight='9'
}

async function callFunction(s)
{
	if(s=="Arrived")
    {
        var dialogHeight= "38vh" ;
        var dialogWidth = "50vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
        var arguments   = "" ;
		       
		var retVal = await window.showModalDialog("../../eOP/jsp/CallPatArrival.jsp"+parameters,arguments,features);

        if (retVal=="ok")
        {
            window.close();
        }
    }

    if(s=="Current Location")
    {
        var dialogHeight= "37vh" ;
        var dialogWidth = "50vw" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
        var arguments   = "" ;

        var param="../../eOP/jsp/CallLocation.jsp"+parameters;
       
        var retVal = await window.showModalDialog(param,arguments,features);

    }

        if(s=="Start Consultation")
        {
            var dialogHeight= "35vh" ;
            var dialogWidth = "50vw" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
            var arguments   = "" ;

            var retVal = await window.showModalDialog("../../eOP/jsp/CallConsStart.jsp"+parameters+"&test=test",arguments,features);
        }

        if(s=="Departed")
        {
            var dialogHeight= "38vh" ;
            var dialogWidth = "50vw" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
            var arguments   = "" ;

            var retVal = await window.showModalDialog("../../eOP/jsp/ConsPatDeparted.jsp"+parameters,arguments,features);
        }

        if(s=="Record Vital Signs")
        {
			var param = parameters.split("&p");
			var patient_id = param[1];
			var encounter_id = param[2];
			var patient_class = param[11];

			patient_id = patient_id.substr(2,patient_id.length);
			encounter_id = encounter_id.substr(2,encounter_id.length);
			patient_class = patient_class.substr(3,patient_class.length);

			var retVal =    new String();
			var dialogHeight= "24vh" ;
			var dialogWidth = "50vw" ;
			var status = "no";
			var scroll = "no";
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
			var arguments   = "" ;         
			
			var visit_id = "1";
			var eidval ="episode_id="+encounter_id+"&episode_type=O&visit_id="+visit_id+"&patient_id="+patient_id+"&patient_class="+patient_class+"&module_id=OP";
			retVal = await window.showModalDialog("../../eCA/jsp/DisDataCharting.jsp?"+eidval,arguments,features);
        }

        if(s=="Revert to Check-in")
        {
            var dialogHeight= "38vh" ;
			var dialogWidth = "50vw" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
			var arguments   = "" ;
		
			var retVal = await window.showModalDialog("../../eOP/jsp/CallPatArrival.jsp"+parameters+"&revert_to_check_in=Y",arguments,features);

			if (retVal=="ok")
			{
				window.close();
			}
        }

		if(s=="Check out")
        {
			
            var dialogHeight= "22vh" ;
            var dialogWidth = "50vw" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
            var arguments   = "" ;

            var retVal = await window.showModalDialog("../../eOP/jsp/PatCheckoutCall.jsp"+parameters,arguments,features);
        }

        if(s=="Assign Practitioner" || s=="Re-Assign Practitioner")
        {
            var dialogHeight= "22vh" ;
            var dialogWidth = "50vw" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
            var arguments   = "" ;

            var retVal = await window.showModalDialog("../../eOP/jsp/CallAssign.jsp"+parameters,arguments,features);
        }

        if(s=="Lab Invest")
        {
            var url = "/eCIS/demo/laboratory/PaintLab.jsp"+parameters
            var dialogHeight    = "30vh" ;
            var dialogWidth = "45vw" ;
            var arguments   = "" ;
            var status = "no";
            var scroll = "yes";
            var dialogTop = "60";
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
            var reportURL   = await window.showModalDialog( url, arguments, features ) ;
        }
        if(s=="Rad Invest")
        {
                var url = '/eCIS/demo/Radialogy_files/RadialogyMain.jsp'+parameters
                var dialogHeight    = "30vh" ;
                var dialogWidth = "45vw" ;
                var arguments   = "" ;
                var status = "no";
                var scroll = "yes";
                var dialogTop = "60";
                var dialogLeft = "50";
                var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; dialogLeft:"+ dialogLeft + ";status:"+ status + "; scroll:"+ scroll;
                var reportURL   = await window.showModalDialog( url, arguments, features ) ;
        }
}

function func1(){}
function hidemenu()
{
    //document.getElementById("menu").style.visibility='hidden'
}

function createMenu(arr,lay)
{
        
		var inde=lay.all(0).rows.length
        
        var delval=0
    while(delval!=inde)
    {
        lay.all(0).deleteRow(delval)
        inde=lay.all(0).rows.length
    }

    for (var rowlen=0;rowlen<arr.length-1;rowlen++)
    {
            lay.all(0).insertRow(rowlen);
            lay.all(0).insertRow(rowlen).style.fontSize=1;
            lay.all(0).rows[rowlen].insertCell[0];
            lay.all(0).rows[rowlen].insertCell[0].innerHTML=arr[rowlen].link("javascript:callMeth('"+arr[rowlen]+"')" )
            NumOfFlds++;
    }
}

function callMeth(s)
{
        //document.getElementById("menu").style.visibility='hidden'
        
        callFunction(s)
            if(s!="RecordVitalSigns")
            parent.window.returnValue="yes"
            parent.window.close()
}
