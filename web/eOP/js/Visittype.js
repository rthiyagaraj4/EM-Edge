
function create() {

	f_query_add_mod.location.href = "../../eOP/jsp/addOPVisitType.jsp" ;
    
}

function query() {
	
	f_query_add_mod.location.href ="../../eOP/jsp/queryVisitTypePage.jsp?function=visittype" ;

}


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
	
	var mduration=f_query_add_mod.document.visittype_form.max_appt_duration.value;
	var mslots=f_query_add_mod.document.visittype_form.max_appt_slots.value;
	if(mduration>1400)
	{
		var msg=getMessage('MAX_VALUE_1440','OP');
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	    f_query_add_mod.document.visittype_form.max_appt_duration.value='';
		return;
	}
	if(mduration<0)
	{
		var msg=getMessage('NUM_ALLOWED','SM');
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		f_query_add_mod.document.visittype_form.max_appt_duration.value='';
		return;
	}
    if(mslots<0)
	{
		var msg=getMessage('NUM_ALLOWED','SM');
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		f_query_add_mod.document.visittype_form.max_appt_slots.value='';
		return;
	}
	
	f_query_add_mod.document.visittype_form.scriteria.disabled=false;
	 
	if(f_query_add_mod.document.visittype_form.function_name.value=="insert") {


	 var fields = new Array ( f_query_add_mod.document.visittype_form.visit_type_code,
				  f_query_add_mod.document.visittype_form.long_desc,
				  f_query_add_mod.document.visittype_form.short_desc,
				  f_query_add_mod.document.visittype_form.visit_type_ind);

	 var names  = new Array (getLabel('Common.code.label','Common'),getLabel('Common.longdescription.label','Common'),getLabel('Common.shortdescription.label','Common'),getLabel('Common.INDICATOR.label','Common'));
	 if(f_query_add_mod.document.forms[0].install.value == "Y")
	 {
		fields[4]= f_query_add_mod.document.visittype_form.scriteria;
		names[4]=getLabel("eOP.OrderableCriteria.label","Op");

	}

	var field = new Array ( f_query_add_mod.document.visittype_form.visit_type_code );
    var name  = new Array ( getLabel('Common.code.label','Common') );

}
else if(f_query_add_mod.document.visittype_form.function_name.value=="modify") 
{

	var fields = new Array ( f_query_add_mod.document.visittype_form.visit_type_code,
							  f_query_add_mod.document.visittype_form.long_desc,
							  f_query_add_mod.document.visittype_form.short_desc,
							  f_query_add_mod.document.visittype_form.visit_type_ind
							);

	 var names  = new Array (getLabel('Common.code.label','Common'),
							  getLabel('Common.longdescription.label','Common'),								  getLabel('Common.shortdescription.label','Common'),
								getLabel('Common.INDICATOR.label','Common')			
							);


 var val=f_query_add_mod.document.visittype_form.scriteria.value;

if((f_query_add_mod.document.forms[0].install.value == "Y")&&(val==" " || val==""))
	{
		fields[4]= f_query_add_mod.document.visittype_form.scriteria;
		names[4]=getLabel("eOP.OrderableCriteria.label","Op");

	}
	
 var  field = new Array (f_query_add_mod.document.visittype_form.visit_type_code);
 var name  = new Array (getLabel('Common.code.label','Common')); 
}
var error_page = "../../eCommon/jsp/error.jsp";
	
	if(f_query_add_mod.checkFields(fields,names,messageFrame)) 
	{
		if (f_query_add_mod.SpecialCharCheck(field,name,messageFrame,"M",error_page))
	    {
			if(f_query_add_mod.document.visittype_form.rd_appl_yn)
				if(f_query_add_mod.document.visittype_form.rd_appl_yn.disabled)
				  f_query_add_mod.document.visittype_form.rd_appl_yn.disabled=false;
			f_query_add_mod.document.visittype_form.submit();
		}
	}

}


function reset() {

	 if(f_query_add_mod.document.location.href.indexOf("queryVisittype.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}


function onSuccess() {

	if(f_query_add_mod.document.visittype_form.function_name.value=="insert")
	{
		f_query_add_mod.visittype_form.visit_type_code.value	  = "" ;
		f_query_add_mod.visittype_form.long_desc.value		  = "" ;
		f_query_add_mod.visittype_form.short_desc.value	  = "" ;
		f_query_add_mod.visittype_form.visit_type_ind.value	  = "" ;
		f_query_add_mod.visittype_form.max_appt_duration.value	  = "" ;
		f_query_add_mod.visittype_form.max_appt_slots.value	  = "" ;
		f_query_add_mod.visittype_form.eff_status.checked	  = true ;
		f_query_add_mod.visittype_form.scriteria.value="";
		f_query_add_mod.visittype_form.scriteria.disabled=false;
		f_query_add_mod.location.reload() ;  // This Line Added for this CRF [Bru-HIMS-CRF-177]
		f_query_add_mod.visittype_form.visit_type_code.focus();
	}
else
		   f_query_add_mod.location.reload() ;
}

// JS functions used in addOPVisitType.jsp


function change() {
      	 if (visittype_form.eff_status.checked == true)
      	 	visittype_form.eff_status.value="E";
      	 else
      		visittype_form.eff_status.value="D";
      	}
function assignValue() {
  if (visittype_form.rd_appl_yn.checked == true)
   	visittype_form.rd_appl_yn.value="Y";
  else
  	visittype_form.rd_appl_yn.value="N";
      	}


function chkMaxApptDuration(obj)
		{
			chkForDecimal(obj);
			chkForNumber(obj);
			chkForMaxValue(obj);
		}

function chkForNumber(obj)
	{
		var val=obj.value;
		var msg="";
		
		if(isNaN(val)){
		msg=getMessage('NUM_ALLOWED','SM');
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
				obj.select();
				obj.focus();
				return false;
			}
		}

function chkForMaxValue(obj)
	{
		if(obj.value > 1440 )
		{
			var msg=getMessage('MAX_VALUE_1440','OP');
			parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
			
			obj.select();
			obj.focus();
			return false;
		}
	}

function chkForDecimal(obj){
			
			var dec = "+.-";
			var j;
			var ch1;
			var objlen = (obj.value).length;
			var i;
			var ch;
			for (j=0; j<dec.length; j++){
				ch1 = dec.charAt(j);
			for( i=0; i < objlen; i++){
				ch = (obj.value).charAt(i);
				if(ch == ch1){
								var msg=getMessage('NUM_ALLOWED','SM');
								parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
								obj.select();
								obj.focus();
								return false;
						   		}
								
								}
				}
    }

function populateCriteria(current,form)
  {
	  var indicator=current.value;
	  var name=current.name;
	 
	  
	  parent.document.f_query_add_mod.document.visittype_form.scriteria.disabled=false;
	     if(name=="visit_type_ind")
	  		  removeitems(form.scriteria);
      
	    if(parent.document.f_query_add_mod.document.visittype_form.install.value=="Y")
	  {
	    var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
         var opt1=parent.document.f_query_add_mod.document.createElement("OPTION");
		 opt.text=getLabel("Common.required.label","Common");
		 opt.value="R";
		 opt1.text=getLabel("Common.notrequired.label","Common");
		 opt1.value="N"
		 parent.document.f_query_add_mod.document.visittype_form.scriteria.add(opt);
         parent.document.f_query_add_mod.document.visittype_form.scriteria.add(opt1);
      
	  }// if not installed then goto else
	  else
	  {
		  parent.document.f_query_add_mod.document.visittype_form.scriteria.disabled=true;
		  var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
          opt.text=getLabel("Common.notapplicable.label","Common");
		  opt.value="";
		  opt.selected=true;
		  parent.document.f_query_add_mod.document.visittype_form.scriteria.add(opt);
	  }
      if(indicator== "")
            removeitems(form.scriteria);  
  }

  // This function is used to remove the items occured more than once
  // in a select box.
function removeitems(obj)
		   {
			var len=obj.length;
			var i=1;
			while(i<len)
			{
				len=obj.length
				obj.remove(i)
			}
       	}		


function selectOrderableCriteria()
	{
	var sercriteria=document.forms[0].hiddenscriteria.value;
	if(sercriteria=='')
		sercriteria=' '; 
	parent.frames[1].document.forms[0].scriteria.value=sercriteria;
    document.forms[0].hiddenscriteria.value=sercriteria;
	}

//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 Started -->
function changeVCvalue() {
 	 if (visittype_form.virtual_consultation.checked == true)
 	 	visittype_form.virtual_consultation.value="E";
 	 else
 		visittype_form.virtual_consultation.value="D";
 	}
