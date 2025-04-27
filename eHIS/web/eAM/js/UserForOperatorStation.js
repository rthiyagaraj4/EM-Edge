function create() {

	f_query_add_mod.location.href = "../../eAM/jsp/UserForOperatorStation_Form.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/UserForOperatorStationQueryPage.jsp?function=UserForOperationStation";
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

function apply() {
	
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	/*var from_date_gerg =frames[1].convertDate(f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1.value,"DMY",localeName,"en");
	var to_date_gerg =frames[1].convertDate(f_query_add_mod.document.UserForOperationStation_Form.eff_date_to1.value,"DMY",localeName,"en");

	//f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1.value=from_date_gerg;
	//f_query_add_mod.document.UserForOperationStation_Form.eff_date_to1.value=to_date_gerg;

	f_query_add_mod.document.UserForOperationStation_Form.eff_date_from.value=from_date_gerg;
	f_query_add_mod.document.UserForOperationStation_Form.eff_date_to.value=to_date_gerg;
	*/
		

		var fields = new Array (
								f_query_add_mod.document.UserForOperationStation_Form.userid,
								f_query_add_mod.document.UserForOperationStation_Form.facility,
								f_query_add_mod.document.UserForOperationStation_Form.oprstn,
								f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1);
        //alert("fields" +fields);

	var names = new Array  (getLabel("Common.user.label",'Common'), getLabel("Common.facility.label",'Common'),getLabel("Common.operatorstation.label",'Common'),
	getLabel('Common.EffectiveDate.label','Common')+" "+getLabel('Common.from.label','Common'));
	
	//alert("names" +names);

	var transform = new Array (  f_query_add_mod.document.UserForOperationStation_Form,
			             f_query_add_mod.document.UserForOperationStation_Form.eff_date_from,
			             f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1,
				     f_query_add_mod.document.UserForOperationStation_Form.eff_date_to,
				     f_query_add_mod.document.UserForOperationStation_Form.eff_date_to1
				   );

//alert("transform" +transform);

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{   
			//alert("f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)   :"+f_query_add_mod.checkFieldsofMst( fields, names, messageFrame));
			if(DateTrans(transform,messageFrame))
			{   
		         //alert("DateTrans(transform,messageFrame) :"+DateTrans(transform,messageFrame));
				 
				 var fn_status = f_query_add_mod.document.UserForOperationStation_Form.function_name.value;
				 //alert(fn_status);
				 
				 

			}
		}
	
	}
var facId='';

function onSuccess() {
	
		//alert("inside onsuccess");	
		f_query_add_mod.document.UserForOperationStation_Form.reset();
		//f_query_add_mod.location.href = "../../eAM/jsp/UserForOperatorStation_Form.jsp" ;
		 //f_query_add_mod.location.reload();

}

function reset() 
{
/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */

	var function_name = f_query_add_mod.document.forms[0].function_name;
	if(f_query_add_mod.document.forms[0])
	{
		if((function_name != null) && (function_name.value =="modify"))
		{
			if(messageFrame.document.body.innerText.indexOf("Operation Completed Successfully")==-1)
			{
			//	f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();
			}
		}
		else
		{
			//f_query_add_mod.document.forms[0].reset();
			f_query_add_mod.document.location.reload();
		}
	}
      
}

function deleterecord()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.UserForOperationStation_Form.function_name.value!="insert")
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
		f_query_add_mod.document.UserForOperationStation_Form.function_name.value="delete";
		f_query_add_mod.document.UserForOperationStation_Form.function1.value="delete";

		var transform = new Array (  f_query_add_mod.document.UserForOperationStation_Form,
			             f_query_add_mod.document.UserForOperationStation_Form.eff_date_from,
			             f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1,
				     f_query_add_mod.document.UserForOperationStation_Form.eff_date_to,
				     f_query_add_mod.document.UserForOperationStation_Form.eff_date_to1
				   );
		if(f_query_add_mod.DateTransform(transform,messageFrame))
		{
			var fn_status = f_query_add_mod.document.UserForOperationStation_Form.function_name.value ;
		}
		f_query_add_mod.location.href="../../eCommon/html/blank.html"
	return true;
	}
	else
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
	
	else
	{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}



function DateTrans(transform,messageFrame) {
	//alert("messageFrame  :"+messageFrame.location.href);
	var form1 = transform[0];
	var datefrom = transform[1];
	var datefrom1 = transform[2];
	var dateto = transform[3];
	var dateto1 = transform[4];
	if(datefrom1.value=="") {
		datefrom.value="";
	}
	else {
		var tst=datefrom1.value.toString();
		//alert("tst  :"+tst);
		var arr = new Array();
		arr = tst.split("/");
		var strDay = arr[0];
		var strMonth = arr[1];
		var strYear = arr[2];
		var dt= strYear + "-" + strMonth + "-" + strDay;
		//alert("dt"+dt);
		datefrom.value= dt;
		//alert("datefrom.value"+datefrom.value);
	}
	if(dateto1.value=="") {
		//alert("if stat2");
		dateto.value="";
	}
	else{
		var tst1=dateto1.value;
		var arr1 = new Array();
		arr1 = tst1.split("/");
		var strDay1 = arr1[0];
		var strMonth1 = arr1[1];
		var strYear1 = arr1[2];
		var dt1= strYear1 + "-" + strMonth1 + "-" + strDay1;
		//alert("dt1"+dt1)
		dateto.value= dt1;
		//alert("dateto.value"+dateto.value);
	}
	if (f_query_add_mod.DateCompare4(datefrom1,dateto1))
	{ 
         //alert("f_query_add_mod.DateCompare4(datefrom1,dateto1) :"+f_query_add_mod.DateCompare4(datefrom1,dateto1));
		 //alert("f_query_add_mod.document.UserForOperationStation_Form.current.value :"+f_query_add_mod.document.UserForOperationStation_Form.current.value);
		 f_query_add_mod.document.UserForOperationStation_Form.current.value=new Date().toString();
		 var vval=f_query_add_mod.document.UserForOperationStation_Form.eff_date_from1.value;
		 //alert("inside,........");
		 f_query_add_mod.document.UserForOperationStation_Form.action="../../servlet/eAM.UserForOperatorStationServlet";
		 f_query_add_mod.document.UserForOperationStation_Form.target="messageFrame";
		 f_query_add_mod.document.UserForOperationStation_Form.submit();
		 //form.submit();
		return true;
		//form.submit();
	}
}



/*function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
	}
}*/

function DateCompare_from(obj2,obj,Sys_date)
{

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			
			obj.value="";
			return ;
		}
		else
			{
			var obj1=convertDate(obj.value,"DMY",localeName,"en");

			if(obj2 =="from")
			{

			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
			     
				 
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
		}else{
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
		}

}

}

}


/*function DateCompare_to(obj,Sys_date)
{

if(obj.value!="")
		{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		

			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}

}
*/

function DateCompare3(from,to)
{
	

if(from.value!="" && to.value!="" )
		{   
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}

}


function DateCompare4(from,to)
{
	if(from.value!="" && to.value!="" )
		{
			//alert("isBefore(from.value,to.value,'DMY',localeName)"+isBefore(from.value,to.value,'DMY',localeName));	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;

				to.value="";
				to.select();
									
				return false;
			}
			else
				return true;
		}else
	{

return true;
}

}
