function checkIsValidForProceed()
{
 
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}
function apply()
{   
    if (! (checkIsValidForProceed()) )
    {

        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }               
    
    
    if(window.frames[1].frames[1].document.forms[0])
    {
    window.frames[1].frames[1].document.forms[0].action="../../servlet/eOP.ClinicServiceServlet";
    window.frames[1].frames[1].document.forms[0].target="messageFrame";
    window.frames[1].frames[1].document.forms[0].submit();
    }
    else
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
    
}

var nur_unit_desc="";

function create() 
{
    f_query_add_mod.location.href = "../../eOP/jsp/ClinicMain.jsp?param=create&called_from=2" ;
}

function query()
{
    f_query_add_mod.location.href ="../../eOP/jsp/ClinicServiceQueryCriteria.jsp" ;
}

function reset()
{
     if(f_query_add_mod.location.href.indexOf("ClinicServiceQueryResult.jsp")!=-1)
             return false;
     else
            f_query_add_mod.location.reload() ;
}

function onBlurgetLoc(fac_id,objval,target)
{

        if(target.value == "")
        {
            target.value="";
            document.forms[0].clinic_code1.value="";
            return;
        }

 getLocn(fac_id,objval,target);

}

async function getLocn(fac_id,objval,target)
{
    
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";  

   if(objval!="")   
   {
     
   var index=document.forms[0].clinic_code.options.selectedIndex;
    var care_ind;
      if(index != 0)
          care_ind=careArray[index];
       else
           care_ind="";
     
     document.forms[0].careind.value=care_ind;
   }    
  
   tit=getLabel('Common.Location.label','Common');

   sql ="Select clinic_code code, long_desc description from op_clinic where (care_locn_type_ind='"+care_ind+"') and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+objval+"') and facility_id='"+fac_id+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";    
   
    
                
                argumentArray[0] = sql;
                argumentArray[1] = dataNameArray ;
                argumentArray[2] = dataValueArray ;
                argumentArray[3] = dataTypeArray ;
                argumentArray[4] = "1,2";
                argumentArray[5] = target.value;
                argumentArray[6] = DESC_LINK  ;
                argumentArray[7] = DESC_CODE ;              
                retVal = await CommonLookup( tit, argumentArray );          
                
                
                if(retVal != null && retVal != "" )
                {

                 var ret1=unescape(retVal);
                    arr=ret1.split(",");
                    target.value=arr[1];                    
                document.forms[0].clinic_code1.value=arr[0];
				PopulateValues(target);

          }
}
function onSuccess() {
        window.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
        window.frames[1].frames[0].location.reload();
}

//////////////////
var effStatus= new Array();

var temp='';
function finalSelect(Obj1,Obj2)
{
    var temp2='';
    if(Obj1.checked)
    {
    temp2=Obj1.name+"$"+Obj2.name+"$"+Obj1.value+"$"+Obj2.value
    temp+=temp2+"`"
    
    parent.frames[1].document.forms[0].finalSelectedValues.value=temp;
    }
}

// JS functions used in clinicsearch.jsp

function rem()
        {
            
        document.forms[0].clinic_code2.value="";
        parent.frames[1].location.href="../../eCommon/html/blank.html";
        document.getElementById("tab").style.visibility='hidden';
        
        }

function PopulateResult()
{
    temp='';
    parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
    var clinic_code=document.forms[0].clinic_code.value;
    var clinic_code1=document.forms[0].clinic_code1.value;
    
    var care_indicator=document.forms[0].careind.value;

if(clinic_code1=="")
    {
        var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
        err= err.replace('$',getLabel("Common.Location.label",'Common'));
        alert(err);
        document.forms[0].clinic_code2.focus();
        return false;
    }
    //var dept_code=document.forms[0].dept_code.value;
    var dept_code=document.forms[0].dept_desc.value;
    var called_from=document.forms[0].called_from.value;
    
    if(clinic_code!="" ){
    if (called_from=="1")       
        parent.frames[1].location.href='../../eOP/jsp/AddModifyClinicRoom.jsp?clinic_code='+clinic_code+'&fromSelect=fromSelect';
    
    else
      parent.frames[1].location.href='../../eOP/jsp/AddModifyClinicService.jsp?clinic_type='+clinic_code+'&dept_code='+dept_code+'&clinic_code='+clinic_code1+'&care_indicator='+care_indicator+'&fromSelect=fromSelect';
        
    }

    else
    {
        var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
        err= err.replace('$',getLabel("Common.Location.label","Common"));
        parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err;
        
    }

}
/*
   This function is used for to populate the  type of the clinic, department,
  service and speciality.Based on the clinic these details are displayed.
*/
function PopulateValues(obj)
{
    var called_from=document.forms[0].called_from.value;
    var index=document.forms[0].clinic_code.options.selectedIndex;
    var care_ind;
      if(index != 0)
          care_ind=careArray[index];
       else
           care_ind="";
     
     document.forms[0].careind.value=care_ind;

    if(obj.value!="")
    {
        var clinic_code=document.forms[0].clinic_code.value;
        var clinic_code1=document.forms[0].clinic_code1.value

        document.forms[0].Search.disabled=false;
        var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='clinicTempForm' id='clinicTempForm' method='post' action='../../eOP/jsp/PopulateClinicValues.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='care_ind' id='care_ind' value='"+care_ind+"'><input type='hidden' name='clinic_code1' id='clinic_code1' value='"+clinic_code1+"'></form></body></html>";    
        parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
       parent.parent.frames[2].document.forms[0].submit();
    }
}

/*
    This function is used for search button.By default it was disabled.
   whenever we select a particular clinic it will enable.This should be called
    when the form is loaded.
 */
function ChkClinic()
{
    document.forms[0].Search.disabled=true;
}

function submitPrevNext(from, to){
        document.forms[0].from.value = from;
        document.forms[0].to.value = to; 
        document.forms[0].submit();
    }

    // Onchange of Dept .. clear Result Page...
function clearResultPage()
{
    parent.frames[1].location.href="../../eCommon/html/blank.html";
}