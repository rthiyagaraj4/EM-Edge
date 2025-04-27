var currentTab = new String();
var previousTab = new String();
previousTab = "search_tab";
currentTab = "search_tab";

function PatientSearch(hyper_yn) {
    var url     = "../../eMP/jsp/ModelPatientSearch.jsp?Hyper_YN=" + hyper_yn;
    var dialogTop       = "61";
    var dialogHeight    = "34" ;
    var dialogWidth = "50" ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
    var returnval = window.showModalDialog( url, arguments, features ) ;
    return returnval;
	
}

/*********/
function displayToolTip(patient_id)
{
	
    
	patient_id = unescape(patient_id);
	var func =document.forms[0].func_act.value;
    func = func.toUpperCase();	
    if (func=="PATREG" || func=="EMERG" || func=="RPDRG")
    {
        //setTimeout('displayToolTip1()',1000);
        //displayToolTip1(event);
        bodwidth  = parent.parent.frames[1].document.body.offsetWidth;
        bodheight = parent.parent.frames[1].document.body.offsetHeight;
        var x     = event.x;
        var y     = event.y;
        x     = x + (document.getElementById("tooltiplayer").offsetWidth);
        y     = y + (document.getElementById("tooltiplayer").offsetHeight);

        if(x<bodwidth)
            x = event.x;
        else
            x = x - (document.getElementById("tooltiplayer").offsetWidth*2);
        if(y<bodheight)
            y = event.y;
        else
            y = y - (document.getElementById("tooltiplayer").offsetHeight*2);

        y+=document.body.scrollTop;
        x+=document.body.scrollLeft;
        document.getElementById("tooltiplayer").style.posLeft= 18;
        document.getElementById("tooltiplayer").style.posTop = y;
        buildTable(patient_id);
    }
    else
    {
        if (func=="NEWBORN_REG")
        {
            parent.parent.frames[3].checkExpiry(patient_id, '','',"NEWBORN_REG");
        }
        else
        {
            parent.parent.frames[3].checkExpiry(patient_id,'','','');
        }

    }
}

function buildTable(patientid)
{
    var HTMLVal = new String();
    HTMLVal = "<HTML><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetPatientSex.jsp'><input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value=\""+escape(patientid)+"\"></form></BODY></HTML>";
    parent.parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.frames[5].document.form1.submit();
}

function buildTableOptions(patientid)
{
	//alert(parent.frames[2].document.forms[0].sex.value);	
    if (parent.frames[3].frames[0].document.forms[0].sex.value=="F")
    {
        var row      = ("Change Demographics,Register NewBorn,View Mother-Baby Link,Register Visit,Admit Patient");
        var row_disp      = ("ChangeDemographics,RegisterNewBorn,ViewMotherBabyLink,RegisterVisit,AdmitPatient");
    }
    else
    {
        var row      = ("Change Demographics,Register Visit,Admit Patient");
        var row_disp      = ("ChangeDemographics,RegisterVisit,AdmitPatient");
    }
    var rowval   = row.split(",");
    var rowval_disp   = row_disp.split(",");
    var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"

    for( var i=0; i<rowval.length; i++ )
    {
        var colval  = rowval[i];
        var colval_disp  = rowval_disp[i];
        tab_dat     += "<tr>";
        tab_dat     += "<td class = 'ORTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:callMenuFunctions('"+colval_disp+"',\""+escape(patientid)+"\")>"+colval+"</a></td>";       tab_dat     += "</tr>";
    }
    tab_dat     += "</table>";
    parent.frames[3].frames[0].document.getElementById("t").innerHTML = tab_dat;
    parent.frames[3].frames[0].document.getElementById("tooltiplayer").style.visibility='visible' ;
    //displayToolTip1();
}

function callMenuFunctions(s,patientid)
{    
	if (s=="RegisterNewBorn")
	{
		parent.parent.frames[3].checkExpiry(patientid, '','',"NEWBORN_REG",s);
	}			
	else if(s=="ChangeDemographics")
    {
        parent.parent.frames[3].checkExpiry(patientid,'','','',s);
    }
    else
    {
        callMenu(s,patientid);
    }
}
async function callMenu(s,patientid)
{	 
		
	if(s=="RegisterNewBorn")
    {
        setTimeout("showRegisterNewBorn(\""+patientid+"\")",1000);
    }

    if(s=="ViewMotherBabyLink")
    {
        /*var dialogHeight= "18" ;
        var dialogWidth = "45" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
        var arguments   = "" ;*/
        var dialogHeight= "18" ;
        var dialogWidth = "49.8" ;
        var status = "no";
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;
        var retVal =await window.showModalDialog("../jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid)+"&function_id=PAT_REG",arguments,features);
        if(retVal != null)
        {
            var arr = retVal.split('`');
            if(arr[1] == 'N')
            {
				alert(parent.getMessage("NO_MOTHER_BABY_LINKS"));
            }
        }

    }
    if(s=="RegisterVisit")
    {
        if(parent.parent.frames[3].frames[0].document.result_form.op_install_yn=="N")
            alert(getMessage("OP_NOT_INSTALLED"));
        else
        {

        var dialogHeight= "33.4" ;
        var dialogWidth = "50" ;
        var dialogTop = "65"
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
        var arguments   = "" ;
        var retVal =await window.showModalDialog("../../eOP/jsp/VisitRegistration.jsp?p1="+escape(patientid)+"&function_id=VISIT_REGISTRATION",arguments,features);
        }
    }
    if(s=="ChangeDemographics")
    {
        setTimeout("showChangeDemographics(\""+patientid+"\")",1000);
    }

    if(s=="AdmitPatient")
    {
        if(parent.parent.frames[3].frames[0].document.result_form.ip_install_yn=="N")
            alert(getMessage("IP_NOT_INSTALLED"));
        else
        {
            var dialogHeight= "33.4" ;
            var dialogWidth = "50" ;
			var dialogTop = "65" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
            var arguments   = "" ;
            //var retVal = window.showModalDialog("../../eIP/jsp/AdmitPatient.jsp?patient_id="+escape(patientid)+"&P_call_func=ADMIT",arguments,features);
			var retVal =await window.showModalDialog("../../eIP/jsp/AdmitPatient.jsp?patient_id="+escape(patientid)+"&module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=YNNNN",arguments,features);
        }
    }

} // End of the Function callMenuFunctions

    async function showChangeDemographics(patientid)
    {
		var dialogHeight= "35.5" ;
        var dialogWidth = "50" ;
        var wintop = "61"
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
        var arguments   = "" ;
        var param='../../eMP/jsp/ChangePatientDetails.jsp?step=1&function_id=PAT_REG&function_name=Change Patient Details&access=NYNNN&Patient_ID='+escape(patientid)
        //alert(param);
        //var param="ChangePatientDetails1.jsp?module_id=MP&function_id=PAT_REG&function_name=Change Patient Details&function_type=F&access=NYNNN&Patient_ID="+patientid;
        var retVal = await window.showModalDialog(param,arguments,features);
    }

   async  function showRegisterNewBorn(patientid)
    {        
		var retVal =    new String();
        var dialogHeight= "18" ;
        var dialogWidth = "49.8" ;
        var status = "no";
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;		
		//alert(parent.frames[3].frames[0].document.forms[0].min_age.value);
        if (parent.frames[3].frames[0].document.forms[0].min_age.value!=null)
       {
           if (parseInt(parent.frames[3].frames[0].document.forms[0].age.value) < parseInt(parent.frames[3].frames[0].document.forms[0].min_age.value))
           {
			   alert(getMessage("MOTHER_AGE_PARAM"));
               }
           else
           {
/*             var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+patientid;
               var retVal = window.showModalDialog(param,arguments,features);
*/
                //alert(parent.frames[3].frames[0].document.forms[0].allow_nb_review.value);
				if(parent.frames[3].frames[0].document.forms[0].allow_nb_review.value!="N")
                {
                    var retVal = await window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid),arguments,features);
                    if(retVal != null)
                    {
                        var arr = retVal.split('`');
                        if(arr[1] == 'N')
                        {
                            alert(getMessage("NO_MOTHER_BABY_LINKS"));
                            dialogHeight= "34" ;
                            dialogWidth = "50" ;
                            wintop = "61"
                            features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                            arguments   = "" ;
                            var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                            var retVal =await window.showModalDialog(param,arguments,features);
                        }
                        else if(arr[1] == 'Y')
                        {
                            dialogHeight= "34" ;
                            dialogWidth = "50" ;
                            wintop = "61"
                            features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                            arguments   = "" ;
                            var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                            var retVal = window.showModalDialog(param,arguments,features);
                        }
                    }
                }
                else
               {
                    dialogHeight= "34" ;
                    dialogWidth = "50" ;
                    wintop = "61"
                    features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                    arguments   = "" ;
                    var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                    var retVal =await window.showModalDialog(param,arguments,features);
               }
            }
       }
       else
        {
/*          var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+patientid;
            var retVal = window.showModalDialog(param,arguments,features);
*/
            if(parent.frames[3].frames[0].document.forms[0].allow_nb_review.value!="N")
            {
                var retVal = window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid),arguments,features);
                //alert(retVal);
                if(retVal != null)
                {
                    var arr = retVal.split('`');
                    if(arr[1] == 'N')
                    {
                        alert(getMessage("NO_MOTHER_BABY_LINKS"));
                        dialogHeight= "34" ;
                        dialogWidth = "50" ;
                        wintop = "61"
                        features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                        arguments   = "" ;
                        var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        var retVal =await  window.showModalDialog(param,arguments,features);
                    }
                    else if(arr[1] == 'Y')
                    {
                        dialogHeight= "34" ;
                        dialogWidth = "50" ;
                        wintop = "61"
                        features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                        arguments   = "" ;
                        var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        var retVal =await window.showModalDialog(param,arguments,features);
                    }
                }
            }
            else
            {
                dialogHeight= "34" ;
                dialogWidth = "50" ;
                wintop = "61"
                features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                arguments   = "" ;
                var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                var retVal =await window.showModalDialog(param,arguments,features);
            }
        }
    }
function callMouseOver(obj)
{
    currClass = obj.className ;	
    obj.className = 'TOOLTIPSELECT';
}
function callOnMouseOut(obj)
{
    obj.className = currClass;
}
function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
}
async function demoGrpDtls(obj)
{
    var dialogHeight= "25" ;
    var dialogWidth = "49" ;
    var dialogTop    = "155";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";scroll='no';title='Demographics Details';status=no";
    var arguments   = "" ;
    var param="Demographics.jsp?patient_id="+escape(obj);
    var retVal = await window.showModalDialog(param,arguments,features);

}

function reset()
{
   var register_button_yn = parent.frames[1].document.forms[0].register_button_yn.value;
   var soundex = parent.frames[1].document.forms[0].soundex_dflt.value;
   var func_act = parent.frames[1].document.forms[0].func_act.value;	
   parent.frames[1].document.forms[0].reset();
   parent.frames[2].location.href = "../../eMP/jsp/SearchToolbar.jsp?register_button_yn="+register_button_yn+"&func_act="+func_act+"";
   //parent.frames[2].location.href = "../../eMP/jsp/SearchToolbar.jsp";
   parent.frames[3].location.href = '../../eCommon/html/blank.html';
   parent.frames[1].document.forms[0].Soundex.value = soundex;
}



async function callRegVisitModal()
{
	
	var retVal =  new String();
	var dialogTop= "56";
	var dialogHeight= "34" ;
	var dialogWidth = "50" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "";                    
	var func_act = parent.frames[2].document.getElementById("func_act").value;
	var dr_function_id = parent.frames[2].document.getElementById("dr_function_id").value;
	var function_id = '';
	
	if(func_act == "Visitreg")
		function_id = 'VISIT_REGISTRATION';
	if(func_act == "ProcdReg")
		function_id = 'PROCD_REGISTRATION';
	if(func_act == "DuplicateRegistration")
		function_id = func_act;
	if (parent.frames[1].document.forms[0].apply_oth_name)
		if (parent.frames[1].document.forms[0].apply_oth_name.checked)
			apply_oth_name="Y";
		else
			apply_oth_name="N"; 
		
	if(parent.frames[1].document.Patient_Search_Form.First_Name)
	{
		var FirstName=parent.frames[1].document.Patient_Search_Form.First_Name.value;
	}   
	if(parent.frames[1].document.Patient_Search_Form.Second_Name)
	{
		var SecondName=parent.frames[1].document.Patient_Search_Form.Second_Name.value;   
	}                              
	 if(parent.frames[1].document.Patient_Search_Form.Third_Name)
	 {
		var ThirdName=parent.frames[1].document.Patient_Search_Form.Third_Name.value; 
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Family_Name)
	 {
		 var FamilyName=parent.frames[1].document.Patient_Search_Form.Family_Name.value;  
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No)
	  {
		  var AltIdNo=parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value; 
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.National_Id_No)
	 {
		   var NationalIdNo=parent.frames[1].document.Patient_Search_Form.National_Id_No.value;   
		
	 }
	if(parent.frames[1].document.Patient_Search_Form.MRN)
	{
		var MRN=parent.frames[1].document.Patient_Search_Form.MRN.value;  
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Dob)
	 {
		var Dob=parent.frames[1].document.Patient_Search_Form.Dob.value;  
		
	 }
	  if(parent.frames[1].document.Patient_Search_Form.Sex)
	  {
		var Sex=parent.frames[1].document.Patient_Search_Form.Sex.value;  
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Area)
	 {
		var Area=parent.frames[1].document.Patient_Search_Form.Area.value;    
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.OldFileNo)
	 {
		var OldFileNo=parent.frames[1].document.Patient_Search_Form.OldFileNo.value;  
		
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Family_No)
	 {
		//alert(Patient_Search_Form.Family_No.value);
		var FamilyNo=parent.frames[1].document.Patient_Search_Form.Family_No.value;   
 
	 }
	 if(func_act=="DuplicateRegistration")
	 {
		retVal =await window.showModalDialog("../../eMP/jsp/PatientRegistrationMain.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id="+function_id+"&function_name=Register%20Patient&function_type=F&access=YYYNN&func_act="+func_act+"&First_Name="+escape(FirstName)+"&Second_Name="+escape(SecondName)+"&Third_Name="+escape(ThirdName)+"&Family_Name="+(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&MRN="+escape(MRN)+"&Dob="+Dob+"&Sex="+Sex+"&Area="+escape(Area)+"&dr_function_id="+dr_function_id+"&Family_No="+escape(FamilyNo)+"&OldFileNo="+escape(OldFileNo),arguments,features);
	}
	else
	{
		retVal =await window.showModalDialog("../../eMP/jsp/PatientRegistrationMain.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id="+function_id+"&function_name=Register%20Patient&function_type=F&access=YYYNN&func_act=Visitreg&First_Name="+escape(FirstName)+"&Second_Name="+escape(SecondName)+"&Third_Name="+escape(ThirdName)+"&Family_Name="+(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&MRN="+escape(MRN)+"&Dob="+Dob+"&Sex="+Sex+"&Area="+escape(Area)+"&Family_No="+escape(FamilyNo)+"&OldFileNo="+escape(OldFileNo),arguments,features);
	}

	if(retVal)
	{
		if( retVal != null || retVal.length != 0)
			parent.close();
		window.setTimeout(parent.returnValue=retVal,300);
	}    
}
                       
function passValues(func_act)
{

	var desc;
    if(func_act=='EMERG')
		desc='../../eMP/jsp/PaintEmergRegn.jsp?';
    else if(func_act=='RPDRG')
		desc='../../eMP/jsp/PaintRapidRegn.jsp?';
    else
		desc='../../eMP/jsp/PatRegLoad.jsp?';                             

	if (parent.frames[1].document.forms[0].apply_oth_name)
		if (parent.frames[1].document.forms[0].apply_oth_name.checked)
			desc+="apply_oth_name=Y&";
		else
			desc+="apply_oth_name=N&";

	 if(parent.frames[1].document.Patient_Search_Form.First_Name)
	 {
		 var FirstName=parent.frames[1].document.Patient_Search_Form.First_Name.value;
		 desc+="First_Name="+escape(FirstName)+"&";
	 }   
	 if(parent.frames[1].document.Patient_Search_Form.Second_Name)
	 {
		var SecondName=parent.frames[1].document.Patient_Search_Form.Second_Name.value;   
		desc+="Second_Name="+escape(SecondName)+"&";
	 }                              
	 if(parent.frames[1].document.Patient_Search_Form.Third_Name)
	 {
		var ThirdName=parent.frames[1].document.Patient_Search_Form.Third_Name.value; 
		desc+="Third_Name="+escape(ThirdName)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Family_Name)
	 {
		 var FamilyName=parent.frames[1].document.Patient_Search_Form.Family_Name.value;  
		 desc+="Family_Name="+escape(FamilyName)+"&";
	 }

	 if(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No)
	 {
		  var AltIdNo=parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value; 
		  desc+="Alt_Id_No="+escape(AltIdNo)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Alt_Id2_No)
	 {
		  var AltId2No=parent.frames[1].document.Patient_Search_Form.Alt_Id2_No.value; 
		  desc+="Alt_Id2_No="+escape(AltId2No)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Alt_Id3_No)
	 {
		  var AltId3No=parent.frames[1].document.Patient_Search_Form.Alt_Id3_No.value; 
		  desc+="Alt_Id3_No="+escape(AltId3No)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Alt_Id4_No)
	 {
		  var AltId4No=parent.frames[1].document.Patient_Search_Form.Alt_Id4_No.value; 
		  desc+="Alt_Id4_No="+escape(AltId4No)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.National_Id_No)
	 {
	   var NationalIdNo=parent.frames[1].document.Patient_Search_Form.National_Id_No.value;   
		desc+="National_Id_No="+escape(NationalIdNo)+"&";
	 }
	if(parent.frames[1].document.Patient_Search_Form.MRN)
	{
		var MRN=parent.frames[1].document.Patient_Search_Form.MRN.value;  
		desc+="MRN="+escape(MRN)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Dob)
	 {
		var Dob=parent.frames[1].document.Patient_Search_Form.Dob.value;  
		desc+="Dob="+Dob+"&";
	 }
	  if(parent.frames[1].document.Patient_Search_Form.Sex)
	  {
		var Sex=parent.frames[1].document.Patient_Search_Form.Sex.value;  
		 desc+="Sex="+Sex+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Area)
	 {
		var Area=parent.frames[1].document.Patient_Search_Form.Area.value;    
		desc+="Area="+escape(Area)+"&";
	 }
	 if(parent.frames[1].document.Patient_Search_Form.Family_No)
	 {
		//alert(parent.frames[1].document.Patient_Search_Form.Family_No.value);
		var FamilyNo=parent.frames[1].document.Patient_Search_Form.Family_No.value;                 
		 desc+="Family_No="+escape(FamilyNo)+"&";
	 }
	if(parent.frames[1].document.Patient_Search_Form.OldFileNo)
	 {
		var OldFileNo=parent.frames[1].document.Patient_Search_Form.OldFileNo.value;  
		 desc+="OldFileNo="+escape(OldFileNo);
	 }
	 parent.close();                                      
	 parent.returnValue=desc;
}
            
async function passValuesforEmer()
{
	var retVal =  new String();
	var dialogTop= "56";
	var dialogHeight= "34" ;
	var dialogWidth = "50" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "N";
	if (parent.frames[1].document.forms[0].apply_oth_name)
		if (parent.frames[1].document.forms[0].apply_oth_name.checked)
			apply_oth_name="Y";
        else
			apply_oth_name="N"; 

	if(parent.frames[1].document.Patient_Search_Form.First_Name)
	{
		var FirstName=parent.frames[1].document.Patient_Search_Form.First_Name.value;
	}   
	if(parent.frames[1].document.Patient_Search_Form.Second_Name)
	{
		var SecondName=parent.frames[1].document.Patient_Search_Form.Second_Name.value;   							
	}                              
	if(parent.frames[1].document.Patient_Search_Form.Third_Name)
	{
		 var ThirdName=parent.frames[1].document.Patient_Search_Form.Third_Name.value; 							
	}
	if(parent.frames[1].document.Patient_Search_Form.Family_Name)
	{
		 var FamilyName=parent.frames[1].document.Patient_Search_Form.Family_Name.value;  
	}
	if(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No)
	{
		var AltIdNo=parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value; 								
	}
	if(parent.frames[1].document.Patient_Search_Form.National_Id_No)
	{
		var NationalIdNo=parent.frames[1].document.Patient_Search_Form.National_Id_No.value;   								
	}
	if(parent.frames[1].document.Patient_Search_Form.Dob)
	{
		var Dob=parent.frames[1].document.Patient_Search_Form.Dob.value;  
	}
	if(parent.frames[1].document.Patient_Search_Form.Sex)
	{
		var Sex=parent.frames[1].document.Patient_Search_Form.Sex.value;  
	}
	if(parent.frames[1].document.Patient_Search_Form.Family_No)
	{
		var FamilyNo=parent.frames[1].document.Patient_Search_Form.Family_No.value;   
	}
	var flag="Y";						 
	/*retVal = window.showModalDialog("../../eMP/jsp/EmergRegn.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN&func_act=Visitreg&called_from=AE",arguments,features);*/
	
	retVal =await window.showModalDialog("../../eMP/jsp/EmergRegn.jsp?emerg_reg="+flag+"&apply_oth_name="+apply_oth_name+"&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN&func_act=Visitreg&First_Name="+escape(FirstName)+"&Second_Name="+escape(SecondName)+"&Third_Name="+escape(ThirdName)+"&Family_Name="+escape(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+escape(FamilyNo),arguments,features);
	
	/*retVal = window.showModalDialog("../../eMP/jsp/EmergRegn.jsp",arguments,features);*/
	if(retVal)
	{
		
		if( retVal != null || retVal.length != 0)
			parent.close();
			window.setTimeout(parent.returnValue=retVal,300);
	}							 
}

function ChangeCase(obj)
{
	var pat_id = obj.value;
	pat_id = pat_id.toUpperCase();				
	obj.value = pat_id;
}

function moveFocustoAddl()
{
	//if(event.keyCode == 9){
		//parent.frames[1].document.getElementById("additional_tab1").focus();	
		//tab_click('additional_tab');
		tab_click('search_tab');
		if (parent.frames[1].document.Patient_Search_Form.Patient_Id.disabled==false)
			parent.frames[1].document.Patient_Search_Form.Patient_Id.focus();
		//parent.frames[1].document.Patient_Search_Form.MRN.focus();
	//}
}

function moveFocustoGeneral(obj)
{                               
					
	if (obj.name=='active_yn') 
	{
		if ((parent.frames[1].document.getElementById("addl_field4").type=='hidden') &&                                        (document.getElementById("addl_field5").type=='hidden'))
		{
			//tab_click('search_tab');
			tab_click('additional_tab');
			//parent.frames[1].document.Patient_Search_Form.Patient_Id.focus();
			if (parent.frames[1].document.Patient_Search_Form.MRN.disabled==false)
				parent.frames[1].document.Patient_Search_Form.MRN.focus();
		}
	}
	else
	{                   
		if (obj.name == 'addl_field5')
		{
			//tab_click('search_tab');
			//parent.frames[1].document.Patient_Search_Form.Patient_Id.focus();
			tab_click('additional_tab');
			if (parent.frames[1].document.Patient_Search_Form.MRN.disabled==false)
				parent.frames[1].document.Patient_Search_Form.MRN.focus();
		}
		else
		{                       
			if (parent.frames[1].document.getElementById("addl_field5").type=='hidden')
			{
				//tab_click('search_tab');
				//parent.frames[1].document.Patient_Search_Form.Patient_Id.focus();
				tab_click('additional_tab');
				if (parent.frames[1].document.Patient_Search_Form.MRN.disabled==false)
					parent.frames[1].document.Patient_Search_Form.MRN.focus();
			}
		}
	}
}

function enableSuffix()
{
	if (trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value)) {
		parent.frames[1].document.Patient_Search_Form.newborn_suffix.disabled=false;
	}
	else
	{
		parent.frames[1].document.Patient_Search_Form.newborn_suffix.value = "";
		parent.frames[1].document.Patient_Search_Form.newborn_suffix.disabled=true;
	}
}

function enableRegister()
{
	if(parent.frames[2].document.search_toolbar.register)	{
		 if(parent.frames[2].document.search_toolbar.register && flag==true) {
			  parent.frames[2].document.search_toolbar.register.disabled=false;
		 } else
			  parent.frames[2].document.search_toolbar.register.disabled=true;
	}

	if(parent.frames[2].document.search_toolbar.register1){
		 if(parent.frames[2].document.search_toolbar.register1 && flag==true){
			  parent.frames[2].document.search_toolbar.register1.disabled=false;
		 }else
			  parent.frames[2].document.search_toolbar.register1.disabled=true;
	}
}


function formatFlds(obj)
{
	if( obj.checked )
	{
		if(parent.frames[1].document.forms[0].First_Name)
		{
			parent.frames[1].document.forms[0].First_Name.value='';
			parent.frames[1].document.forms[0].First_Name.style.textAlign = "right";
			parent.frames[1].document.forms[0].First_Name.className = 'othlangtext'
			parent.frames[1].document.forms[0].First_Name.onfocus = new Function('loadArabic()');
			parent.frames[1].document.forms[0].First_Name.onblur = new Function('loadEnglish()');
		}
		if(parent.frames[1].document.forms[0].Second_Name)
		{
			parent.frames[1].document.forms[0].Second_Name.value='';
			parent.frames[1].document.forms[0].Second_Name.style.textAlign = "right";
			parent.frames[1].document.forms[0].Second_Name.className = 'othlangtext'
			parent.frames[1].document.forms[0].Second_Name.onfocus = new Function('loadArabic()');
			parent.frames[1].document.forms[0].Second_Name.onblur = new Function('loadEnglish()');
		}
		if(parent.frames[1].document.forms[0].Third_Name)
		{
			parent.frames[1].document.forms[0].Third_Name.value='';
			parent.frames[1].document.forms[0].Third_Name.style.textAlign = "right";
			parent.frames[1].document.forms[0].Third_Name.className = 'othlangtext'
			parent.frames[1].document.forms[0].Third_Name.onfocus = new Function('loadArabic()');
			parent.frames[1].document.forms[0].Third_Name.onblur = new Function('loadEnglish()');
		}
		if(parent.frames[1].document.forms[0].Family_Name)
		{
			parent.frames[1].document.forms[0].Family_Name.value='';
			parent.frames[1].document.forms[0].Family_Name.style.textAlign = "right";
			parent.frames[1].document.forms[0].Family_Name.className = 'othlangtext'
			parent.frames[1].document.forms[0].Family_Name.onfocus = new Function('loadArabic()');
			parent.frames[1].document.forms[0].Family_Name.onblur = new Function('loadEnglish()');
		}
	}
	else
	{
		if(parent.frames[1].document.forms[0].First_Name)
		{
			parent.frames[1].document.forms[0].First_Name.value='';
			parent.frames[1].document.forms[0].First_Name.style.textAlign = "left";
			parent.frames[1].document.forms[0].First_Name.className = ''
			parent.frames[1].document.forms[0].First_Name.onfocus = new Function('callEmpty()');
			parent.frames[1].document.forms[0].First_Name.onblur = new Function('makeValidQueryCriteria(this)');
		}
		if(parent.frames[1].document.forms[0].Second_Name)
		{
			parent.frames[1].document.forms[0].Second_Name.value='';
			parent.frames[1].document.forms[0].Second_Name.style.textAlign = "left";
			parent.frames[1].document.forms[0].Second_Name.className = ''
			parent.frames[1].document.forms[0].Second_Name.onfocus = new Function('callEmpty()');
			parent.frames[1].document.forms[0].Second_Name.onblur = new Function('makeValidQueryCriteria(this)');
		}
		if(parent.frames[1].document.forms[0].Third_Name)
		{
			parent.frames[1].document.forms[0].Third_Name.value='';
			parent.frames[1].document.forms[0].Third_Name.style.textAlign = "left";
			parent.frames[1].document.forms[0].Third_Name.className = ''
			parent.frames[1].document.forms[0].Third_Name.onfocus = new Function('callEmpty()');
			parent.frames[1].document.forms[0].Third_Name.onblur = new Function('makeValidQueryCriteria(this)');
		}
		if(parent.frames[1].document.forms[0].Family_Name)
		{
			parent.frames[1].document.forms[0].Family_Name.value='';
			parent.frames[1].document.forms[0].Family_Name.style.textAlign = "left";
			parent.frames[1].document.forms[0].Family_Name.className = ''
			parent.frames[1].document.forms[0].Family_Name.onfocus = new Function('callEmpty()');
			parent.frames[1].document.forms[0].Family_Name.onblur = new Function('makeValidQueryCriteria(this)');

		}
	}
}
function callEmpty() {}

async function UnbindEJB(){
	var dialogTop= "0";
	var dialogHeight= "0" ;
	var dialogWidth = "0" ;
	var dialogLeft = "780";
	var center = "no";
	var status = "no";
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop +"; center:" + center +"; dialogLeft:" + dialogLeft +"; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retval =await window.showModalDialog("../../eMP/jsp/UnBindEJB.jsp",arguments,features);    
}

function tab_click(objName)
{
	// FIRST CHANGE THE CURRENT SELECTED TAB
	if (parent.frames[1].document.forms[0].Patient_Id.disabled==false && parent.frames[1].document.forms[0].MRN.disabled==false)
	{
		changeTab(objName);

		if (objName == 'search_tab' || objName == 'search_tab1')
		  moveToTab(1);
		else if (objName == 'additional_tab' || objName == 'additional_tab1')
		  moveToTab(2);
	}
}

function changeTab(TabName) 
{
// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
  if (currentTab == 'search_tab' || currentTab == 'search_tab1')
  {
	parent.frames[1].document.getElementById("search_tab").src = '../../eCommon/images/General_click.gif';
	parent.frames[1].document.getElementById("search_tab1").src = '../../eCommon/images/General_click.gif';
  }
  else if (currentTab == 'additional_tab' || currentTab == 'additional_tab1')
  {
	parent.frames[1].document.getElementById("additional_tab").src = '../../eCommon/images/LAdditional.gif';
	parent.frames[1].document.getElementById("additional_tab1").src = '../../eCommon/images/LAdditional.gif';
  }
  // CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

  if (TabName == 'search_tab' || TabName == 'search_tab1')
  {
	parent.frames[1].document.getElementById("search_tab").src = '../../eCommon/images/General.gif';
	parent.frames[1].document.getElementById("search_tab1").src = '../../eCommon/images/General.gif';	
	parent.frames[1].document.forms[0].Patient_Id.focus();
  }
  else if (TabName == 'additional_tab' || TabName == 'additional_tab1')
  {
	parent.frames[1].document.getElementById("additional_tab").src = '../../eCommon/images/Additional.gif';
	parent.frames[1].document.getElementById("additional_tab1").src = '../../eCommon/images/Additional.gif';
	parent.frames[1].document.forms[0].MRN.focus();
  }
  // FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
  previousTab = currentTab;
  currentTab = TabName;    
}    

function DefaultSelect(sndx) 
{
	if(sndx=="") parent.frames[1].document.Patient_Search_Form.Soundex.value="";
	if(sndx=="E") parent.frames[1].document.Patient_Search_Form.Soundex.value="E";
	if(sndx=="G") parent.frames[1].document.Patient_Search_Form.Soundex.value="G";
}

function MoveFocus(num) 
{
	if(num == 1) {
		if( trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value)==false) parent.frames[1].document.Patient_Search_Form.National_Id_No.focus();
	}
	else if(num == 3) {
		if( trimCheck(parent.frames[1].document.Patient_Search_Form.Contact_No.value)==false ) {
			parent.frames[1].document.Patient_Search_Form.Mode.item(0).selected = true;
			parent.frames[1].document.Patient_Search_Form.Mode.disabled=true;
		}
		else {
			parent.frames[1].document.Patient_Search_Form.Mode.item(0).selected = true;
			parent.frames[1].document.Patient_Search_Form.Mode.disabled=false;
		}
	}
	else {
		if( (trimCheck(parent.frames[1].document.Patient_Search_Form.Patient_Id.value)))
		{
			parent.frames[1].document.Patient_Search_Form.Patient_Id.focus();
		}
			if(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No != null)
				if( (trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.value))) parent.frames[1].document.Patient_Search_Form.Alt_Id1_No.focus();
			if(parent.frames[1].document.Patient_Search_Form.Alt_Id2_No != null)
				if( (trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id2_No.value))) parent.frames[1].document.Patient_Search_Form.Alt_Id2_No.focus();
			if(parent.frames[1].document.Patient_Search_Form.Alt_Id3_No != null)
				if( (trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id3_No.value))) parent.frames[1].document.Patient_Search_Form.Alt_Id3_No.focus();
			if(parent.frames[1].document.Patient_Search_Form.Alt_Id4_No != null)
				if( (trimCheck(parent.frames[1].document.Patient_Search_Form.Alt_Id4_No.value))) parent.frames[1].document.Patient_Search_Form.Alt_Id4_No.focus();
			if((parent.frames[1].document.Patient_Search_Form.National_Id_No)&& (trimCheck(parent.frames[1].document.Patient_Search_Form.National_Id_No.value))) parent.frames[1].document.Patient_Search_Form.National_Id_No.focus();
	}
}

function callDummy(){}

