function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addPatientNumberingDetail.jsp" ;
	frames[2].document.location.href = "../../eCommon/html/blank.html";
}
function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}
function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/queryPagePatientNumberDetail.jsp?function=religion" ;
	document.getElementById('f_query_add_mod').style.height = '60vh';
	document.getElementById('result_det').style.height = '25vh';
	
	frames[2].document.location.href = "../../eCommon/html/blank.html";
}
function apply() 
{ 

		
	  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.patnumdetail_form && f_query_add_mod.document.patnumdetail_form.gen_pid_using_alt_id1_rule_yn.value == "Y" )
		//if(f_query_add_mod.document.patnumdetail_form_result.gen_pid_using_alt_id1_rule_yn.value == "Y" )
	{
		
		var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;	
		var used_status = f_query_add_mod.document.patnumdetail_form.used_status.value;
		
		if(used_status == 'N' && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
		{			
			var errors1=f_query_add_mod.getMessage("VALID_PAT_SER_GRP","MP");
			frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
			return;
		}
		else
		{
			//alert("insert");
		var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;	
		if (mode=="insert" && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
		{
			f_query_add_mod.document.patnumdetail_form.submit();
		}

		else if (mode=="modify")
		{
			f_query_add_mod.document.patnumdetail_form.submit();
		}
		else
		{
			f_query_add_mod.document.patnumdetail_form.submit();
		}
	
	}
	}
	else
	{

		
		if(f_query_add_mod.document.patnumdetail_form && f_query_add_mod.document.patnumdetail_form.site_or_facility_id.value=="")
		{
			var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;	
				var used_status = f_query_add_mod.document.patnumdetail_form.used_status.value;

				
				if(used_status == 'N' && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
				{
					var errors1=f_query_add_mod.getMessage("VALID_PAT_SER_GRP","MP");
					frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
					return;
				}


				if (mode=="insert" && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
					{

						f_query_add_mod.document.patnumdetail_form.submit();
					}

					else if (mode=="modify")
					{
						f_query_add_mod.document.patnumdetail_form.submit();
					}
					else
					{
						f_query_add_mod.document.patnumdetail_form.submit();
					}


				}

				

		var fields = new Array ( f_query_add_mod.document.patnumdetail_form && f_query_add_mod.document.patnumdetail_form.pat_ser_grp_code,
				 f_query_add_mod.document.patnumdetail_form.site_or_facility_id,
				 f_query_add_mod.document.patnumdetail_form.start_srl_no,
				 f_query_add_mod.document.patnumdetail_form.max_srl_no);
		var names = new Array ( f_query_add_mod.getLabel('eMP.PatientSeries.label','MP'),
					f_query_add_mod.getLabel('eMP.SiteFacility.label','MP'),
					f_query_add_mod.getLabel('Common.StartSerialNo.label','common'),
					f_query_add_mod.getLabel('Common.maxserialno.label','common'));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			obj=f_query_add_mod.document.patnumdetail_form.start_srl_no;
			obj1=f_query_add_mod.document.patnumdetail_form.max_srl_no;
			if(obj.value.indexOf('.') !=-1)
			{
				var errors1=f_query_add_mod.getMessage("INVALID_INTEGER","SM");
				frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
				return;
			}
			if(obj1.value.indexOf('.') !=-1)
			{
				var errors1=f_query_add_mod.getMessage("INVALID_INTEGER","SM");
				frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
				return;
			}
			var val=parseInt(obj.value,10);
			var val1=parseInt(obj1.value,10);
			if(val >= val1)
			{
				
					var errors1=frames[1].getMessage("MAX_SERIAL_GR_START","SM");
					frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
					return;
			}
			else
			{
				var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;	
				var used_status = f_query_add_mod.document.patnumdetail_form.used_status.value;
			


				/*  Commented the below lines for Brunei to add multi facility for the patient series on 21.12.2011 by Suresh M
				if(used_status == 'N' && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
				{
					var errors1=f_query_add_mod.getMessage("VALID_PAT_SER_GRP","MP");
					frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ errors1 +"&err_value=0";
					return;
				}
						
				else
				{    */
					var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;	
					if (mode=="insert" && f_query_add_mod.document.patnumdetail_form.readonly_flag.value!="Y")
					{

						var rangeval = f_query_add_mod.document.patnumdetail_form.start_srl_no.value;
						var maxrangeval = 
						f_query_add_mod.document.patnumdetail_form.max_srl_no.value;
						var pat_ser_grp_code = f_query_add_mod.document.patnumdetail_form.pat_ser_grp_code.value;
						var site_or_facility_id = f_query_add_mod.document.patnumdetail_form.site_or_facility_id.value; 
						var HTMLVal = new String();
						HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatientNumbRangeCheck.jsp'><input type='hidden' name='rangeval' id='rangeval' value='"+rangeval+"'>"+"<input type='hidden' name='maxrangeval' id='maxrangeval' value='"+maxrangeval+"'>"+ "<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value='"+pat_ser_grp_code+"'>"+ "<input type='hidden' name='site_or_facility_id' id='site_or_facility_id' value='"+site_or_facility_id+"'>"+	"</form></BODY></HTML>";	
						frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
						frames[3].document.form1.submit();
					}

					else if (mode=="modify")
					{
						f_query_add_mod.document.patnumdetail_form.submit();
					}
					else
					{
						f_query_add_mod.document.patnumdetail_form.submit();
					}
		//	}//end else for used status check
		}
	}
  }
}


function rangecheck()
{
	f_query_add_mod.document.patnumdetail_form.submit();
}



function onSuccess(obj) {

	if(obj=="true")
	{
	var error_id="";
	error_id=f_query_add_mod.getMessage("RECORD_INSERTED","SM");

	frames[3].document.location.href="../../eHIS/eCommon/jsp/MstCodeError.jsp?err_num="+ error_id +"&err_value=0";

/*	f_query_add_mod.document.patnumdetail_form.pat_ser_grp_code.value	= "" ;
	f_query_add_mod.document.patnumdetail_form.site_or_facility_id.value		= "" ;
	f_query_add_mod.document.patnumdetail_form.start_srl_no.value	= "" ;
	f_query_add_mod.document.patnumdetail_form.max_srl_no.value		= "" ;
	f_query_add_mod.document.patnumdetail_form.mr_section_code.value	= "" ;
	f_query_add_mod.document.patnumdetail_form.create_file_at_regn_yn.checked	= "false" ;
	f_query_add_mod.document.patnumdetail_form.reset();*/
	var mode = 	f_query_add_mod.document.patnumdetail_form.function_name.value;		
	if (mode=="insert")
	{
		//frames[1].location.reload();
		frames[1].document.location.href = "../../eHIS/eMP/jsp/addPatientNumberingDetail.jsp" ;
		frames[2].document.location.href = "../../eHIS/eCommon/html/blank.html";
	}else
		{
		frames[1].document.location.reload(); ;
		frames[2].document.location.reload();;
		}
	}else if(obj=="false")
	{
	var error_id="";
	//error_id=f_query_add_mod.getMessage("RECORD_INSERTED","SM");
	error_id="Transaction Failed";

	frames[3].document.location.href="../../eHIS/eCommon/jsp/MstCodeError.jsp?err_num="+ error_id +"&err_value=0";
	frames[1].document.location.href = "../../eHIS/eMP/jsp/addPatientNumberingDetail.jsp" ;
	frames[2].document.location.href = "../../eHIS/eCommon/html/blank.html";

	}

}


function reset() 
{
	if(f_query_add_mod.document.forms[0].name == "patnumdetail_form")
	{

		
		if(f_query_add_mod.document.patnumdetail_form.function_name.value =="insert")
		{
			var n=f_query_add_mod.document.patnumdetail_form.site_or_facility_id.options.length;
			for(var i=0;i<n;i++)
			{
				f_query_add_mod.document.patnumdetail_form.site_or_facility_id.remove("site_or_facility_id");
			}


			var tp ="   ----- "+f_query_add_mod.getLabel("Common.defaultSelect.label","Common")+" -----   ";
			var opt=f_query_add_mod.document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			f_query_add_mod.document.patnumdetail_form.site_or_facility_id.add(opt);
		

		
			var k=	f_query_add_mod.document.patnumdetail_form.mr_section_code.options.length;
		
			for(var j=0;j<k;j++)
			{
				f_query_add_mod.document.patnumdetail_form.mr_section_code.remove("mr_section_code");
			}
		

		
		
		var opt1=f_query_add_mod.document.createElement("OPTION");
		opt1.text=tp;
		opt1.value="";
		
		f_query_add_mod.document.patnumdetail_form.mr_section_code.add(opt1);

		frames[2].document.location.href = "../../eCommon/html/blank.html";
	
	 }
	//f_query_add_mod.document.patnumdetail_form.site_or_facility_id.item(0).element="selecyeed";
		f_query_add_mod.document.patnumdetail_form.reset() ;
		//f_query_add_mod.document.patnumdetail_form.site_or_facility_id.item(0).selected= true;

	}
	else
		f_query_add_mod.document.forms[0].reset() ;
		//f_query_add_mod.location.href ="../../eMP/jsp/queryPagePatientNumberDetail.jsp?function=religion" ;
}
function func()
	{
		var name;
		name=document.patnumdetail_form.facility_id1.value;

		document.patnumdetail_form.max_srl_no.value='<%=str%>';
	}

/*	function CheckNum(Obj)
	{
		var n=Obj.value;
		if(isNaN(n))
		{
			alert("Enter a Number");
			Obj.focus();
		}


	}*/

/*	function checkval(val,val2,Obj)
	{
		var nam=parseInt(val,10);
		var nam1=parseInt(val2,10);

		if (nam>=nam1)
		{
			alert("Max Srl No must be greater than Start Srl No");
			//document.patnumdetail_form.max_srl_no.focus();
			Obj.focus();
		}

	}
	*/
function Pass2MsgFrm(num){
	
	
	var sStyle = document.forms[0].sStyle.value;
		if(num=="forpatnum")
			 {
				if(parent.frames[1].document.getElementById('pat_ser_grp_code').value=='')
				 {
					parent.frames[1].document.getElementById('start_srl_no').readOnly = true;
					parent.frames[1].document.getElementById('max_srl_no').readOnly = true;
					parent.frames[1].document.getElementById('start_srl_no').value="";
					parent.frames[1].document.getElementById('max_srl_no').value="";
					parent.document.frames[2].location.href ="../../eCommon/html/blank.html";
				 }
				 else if(parent.frames[1].document.getElementById('pat_ser_grp_code').value!='')
				 {
					parent.frames[1].document.getElementById('start_srl_no').readOnly = false;
					parent.frames[1].document.getElementById('max_srl_no').readOnly = false;
				 }
				//var n=parent.frames[1].document.forms[0].site_or_facility_id.options.length;
				var n=parent.frames[1].document.getElementById('site_or_facility_id').options.length;
				for(var i=0;i<n;i++)
				{
					//parent.frames[1].document.forms[0].site_or_facility_id.remove("site_or_facility_id");
					parent.frames[1].document.getElementById('site_or_facility_id').remove("site_or_facility_id");
				}

				var n=parent.frames[1].document.getElementById('mr_section_code').options.length;
				for(var i=0;i<n;i++)
				{
					parent.frames[1].document.getElementById('mr_section_code').remove("mr_section_code");
				}

				var tp ="  ----- "+parent.f_query_add_mod.getLabel("Common.defaultSelect.label","Common")+" -----   ";
				
				var opt=parent.frames[1].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[1].document.getElementById('mr_section_code').add(opt);
				
				var patser = parent.frames[1].document.getElementById('pat_ser_grp_code').value;
				if (patser=="")				
				 {
					tp ="   -----  "+parent.f_query_add_mod.getLabel("Common.defaultSelect.label","Common")+" -----   ";
					var opt1=parent.frames[1].document.createElement("OPTION");
					opt1.text=tp;
					opt1.value="";
					//parent.frames[1].document.forms[0].site_or_facility_id.add(opt1);
					parent.frames[1].document.getElementById('site_or_facility_id').add(opt1);
				 }
				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/PatDetails.jsp?Chksrc=" + num + "'><input name='Common_Text' id='Common_Text' type='hidden' value=' "+document.getElementById('pat_ser_grp_code').value + "'></form></BODY></HTML>";
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();

				

				 }

			else if(num=="formrsect")
			 {
				var n=parent.frames[1].document.getElementById('mr_section_code').options.length;
				for(var i=0;i<n;i++)
				{
					parent.frames[1].document.getElementById('mr_section_code').remove("mr_section_code");
				}

				var HTMLVal = new String();
				HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/PatDetails.jsp?Chksrc=" + num + "'><input name='Common_Text' id='Common_Text' type='hidden' value=' "+document.getElementById("site_or_facility_id").value + "'><input name='Common_Text1' id='Common_Text1' type='hidden' value=' "+document.getElementById("pat_ser_grp_code").value + "'></form></BODY></HTML>";
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();
			 }

			}

function CheckMrn(){

			if(document.patnumdetail_form.mr_section_code.value != null)
			{
				document.patnumdetail_form.create_file_at_regn_yn.disabled= false;
			}
			if(document.patnumdetail_form.mr_section_code.value == "")
			{

				document.patnumdetail_form.create_file_at_regn_yn.disabled= true;
			}
}
function chkgroup(Obj)
{	
	if(Obj.value!="")
	{
		if(parseInt(Obj.value) <= 0)
		{
			alert(getMessage("VALUE_GREAT_ZERO","MP"));			
			Obj.select();
			return false;
		}		
	}	
}


var temp="";
var temp1="";


function result_value(Obj,i)
{
	var arr = new Array();
	var arr1 = new Array();
	var n=i;
	if(Obj.checked)
	{
	arr = Obj.value.split("$");

	var selIn = eval(document.getElementById('mr_section'+n)).options.selectedIndex;
	var valIs=  eval(document.getElementById('mr_section'+n)).options[selIn].value;

	arr[2]=valIs;

	arr[3]="E";

	if(arr[2]=="")
	{
		alert(getMessage("MR_SECTION_SELECTED","MP"));		
		Obj.checked=false;
	}else
		{
		
	Obj.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+arr[3]+"~"
	 temp+=Obj.value;

	parent.f_query_add_mod.document.forms[0].result_value.value=temp;
		}
	

	}
	else
	{
	arr = Obj.value.split("$");

	var selIn = eval(document.getElementById('mr_section'+n)).options.selectedIndex;
	var valIs=  eval(document.getElementById('mr_section'+n)).options[selIn].value;

	arr[2]=valIs;

	arr[3]="D";

			
	 Obj.value=arr[0]+"$"+arr[1]+"$"+arr[2]+"$"+arr[3]+"~"
	 temp+=Obj.value;

	 parent.f_query_add_mod.document.forms[0].result_value.value=temp;
		
	

	}

}




function finalvalue()
{
var del=frames[1].document.getElementById('result_value_del').value;
var res=frames[1].document.getElementById('result_value').value;
var arr = new Array();
var arr1 = new Array();

arr = del.split("~~");

var len= arr.length;

arr1= res.split("~");

 return;
}


/*
function scrollTitle()
{

  var x = document.body.scrollTop;
  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
  document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
  
  }else{

	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-3;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-3;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-3;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-3;
	
  }

}
*/


function loadpage()
{
	
	parent.document.getElementById('f_query_add_mod').style.height = '40vh';
	parent.document.getElementById('result_det').style.height = '45vh';
	var pat_no_ctrl=document.getElementById('pat_no_ctrl').value;
	var pat_ser_grp_code=document.getElementById('pat_ser_grp_code_hid').value;
	//var site_or_facility_id=document.forms[0].site_or_facility_id.value;
	var site_or_facility_id=document.getElementById('site_or_facility_id').value;
	
	if((pat_no_ctrl=="Z") || (site_or_facility_id==""))
	{	
	//parent.document.frames[2].location.href = "../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code="+pat_ser_grp_code;
	parent.document.result.location.href = "../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code="+pat_ser_grp_code;
	}

}

function clearchk(i)
{
	var n=i;

	eval(document.getElementById('select')+n).checked=false;

}

function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

