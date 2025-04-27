function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addPatNumberingForRel.jsp" ;
}

function apply()
{
	

	var pat_series = f_query_add_mod.document.patNumRelation_form.pat_ser_grp_code.value;
	if(pat_series=='')
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMP.PatientSeries.label","MP"));
		//parent.frames[1].frames[0].location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';	
		return false;
	}
	
		var frm=result.document.patnum_altid_result;
		var elem = frm.elements[0].name; 
		var bool1 =true;
		var bool2 =true;

		var maxRecord=result.document.patnum_altid_result.maxRecord1.value;
	
	
	
			for(i=0;i<maxRecord;i++)
			{
						var prefix1 = eval("result.document.patnum_altid_result.prefix1"+i+".value");
						var prefix2 = eval("result.document.patnum_altid_result.prefix2"+i+".value");
						var prefix3 = eval("result.document.patnum_altid_result.prefix3"+i+".value");
						var prefix_or_suffix_length = eval("result.document.patnum_altid_result.prefix_or_suffix_length"+i+".value");
						//var prefix_or_suffix_length = eval("result.document.patnum_altid_result.prefix_or_suffix_length.value");
						var strlength = prefix1+prefix2+prefix3;

						//if(strlength.length>prefix_or_suffix_length-1)
						if(strlength.length>prefix_or_suffix_length)
						{
									bool1 = false;
									i = maxRecord;
						}				
			}
	
			if(bool1)
			{
				result.document.patnum_altid_result.submit();
			}
			else if(!bool1)
			{
				alert(getMessage("LENGTH_NOT_MATCH","MP"));	
				parent.frames[1].frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
	
	
}


function Pass2MsgFrm(num)
{
	
	if(num=="forpatnum")
	 {
			var patser = parent.frames[1].document.getElementById(pat_ser_grp_code).value;
			//var prefix_or_suffix_length = parent.frames[1].document.forms[0].prefix_or_suffix_length.value;

			var HTMLVal = new String();
			//HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/PatientNumberingAltIdRule_Result.jsp?pat_ser_grp_code="+patser+"'><input name='pat_ser_grp_code' id='pat_ser_grp_code' type='hidden' value=' "+document.getElementById("pat_ser_grp_code").value + "'><input name='prefix_or_suffix_length' id='prefix_or_suffix_length' type='hidden' value='"+prefix_or_suffix_length+"'></form></BODY></HTML>";

			HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/PatientNumberingAltIdRule_Result.jsp?pat_ser_grp_code="+patser+"'><input name='pat_ser_grp_code' id='pat_ser_grp_code' type='hidden' value=' "+document.getElementById("pat_ser_grp_code").value + "'></form></BODY></HTML>";

			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.form1.submit();
	 }
}

function populateSeparator()
{

		  //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[0].disabled=false;
		document.forms[0].patient_numbering_using[0].disabled=false;
		 // top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[1].disabled=false;
		  document.forms[0].patient_numbering_using[1].disabled=false;
		  //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[0].checked=false;
		  document.forms[0].patient_numbering_using[0].checked=false;
		  //top.content.frames[1].frames[1].document.forms[0].patient_numbering_using[1].checked=false;
		  document.forms[0].patient_numbering_using[1].checked=false;
		  //var patser = parent.frames[1].document.forms[0].pat_ser_grp_code.value;
		  var patser = parent.frames[1].document.getElementById(pat_ser_grp_code).value;
		  var HTMLVal = new String();
		  HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../jsp/PatNumForRelPopulation.jsp?pat_ser_grp_code="+patser+"'></form></BODY></HTML>";
		  parent.frames[3].document.write(HTMLVal);
		  parent.frames[3].document.form1.submit();

}

function ChkLength(Obj)
{
	if(Obj.value != '') 
	  {
		var num =Obj.value;
		if (num=='2' || num=='3')
		{
			
			var index = Obj.name.substring(23);

			var field ="";
			field = eval("parent.frames[2].document.patnum_altid_result.prefix3"+index);

			var field1 ="";
			field1 = eval("parent.frames[2].document.patnum_altid_result.select"+index);

			field1.checked = false;
		
			
			if(num=='2')
			{
				field.value = "";
				field.disabled=true;
			}
			else
				field.disabled=false;
			
			return;
		}
        else
		{
			alert(getMessage("VALID_NUMBERS","MP"));
			Obj.value='';
			Obj.focus();
		} 
	  }
}


function ChkPrefixLength(obj)
{
	

	var obj_name = obj.name;
	var index = obj_name.substring(6); 

	

	var prefix1 = eval("parent.frames[2].document.patnum_altid_result.prefix1"+index+".value");

	if(prefix1=='')
	{
		
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace("$",getLabel("eMP.RelationShipLevInd.label","MP") +" 1" );
		alert(msg);		
		
		obj.checked = false;
		return false;
	}
	var prefix2 = eval("parent.frames[2].document.patnum_altid_result.prefix2"+index+".value");
	var prefix3 = eval("parent.frames[2].document.patnum_altid_result.prefix3"+index+".value");
	var prefix_or_suffix_length = eval("parent.frames[2].document.patnum_altid_result.prefix_or_suffix_length"+index+".value");
	 //var prefix_or_suffix_length = eval("parent.frames[2].document.patnum_altid_result.prefix_or_suffix_length.value");


	var strlength = prefix1+prefix2+prefix3;

	
		
	//if(strlength.length>prefix_or_suffix_length-1 || strlength.length<prefix_or_suffix_length-1)
	if(strlength.length>prefix_or_suffix_length || strlength.length<prefix_or_suffix_length)
	{
		alert(getMessage("LENGTH_NOT_MATCH","MP"));	
		obj.checked = false;
	}
	else if(obj.disabled==false && obj.checked==true)
	{
		obj.value = "Y";		
	}
	else if(obj.disabled==false && obj.checked==false)
	{
		obj.value = "N";		
	}

	


	
}

function onSuccess()
{
	//var patser = parent.frames[1].frames[1].document.forms[0].pat_ser_grp_code.value;
	var patser = frames[1].document.getElementById(pat_ser_grp_code).value;
	//var prefix_or_suffix_length = parent.frames[1].frames[1].document.forms[0].prefix_or_suffix_length.value;
	var HTMLVal = new String();
	//HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatientNumberingAltIdRule_Result.jsp?pat_ser_grp_code="+patser+"'><input name='pat_ser_grp_code' id='pat_ser_grp_code' type='hidden' value=' "+patser + "'><input name='prefix_or_suffix_length' id='prefix_or_suffix_length' type='hidden' value='"+prefix_or_suffix_length+"'></form></BODY></HTML>";

	HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatientNumberingAltIdRule_Result.jsp?pat_ser_grp_code="+patser+"'><input name='pat_ser_grp_code' id='pat_ser_grp_code' type='hidden' value=' "+patser + "'></form></BODY></HTML>";
	frames[2].document.write(HTMLVal);
	frames[2].document.form1.submit();
}

function unCheckCheckBox(obj)
{
	var index = obj.name.substring(7);
	var field1 ="";
			field1 = eval("parent.frames[2].document.patnum_altid_result.select"+index);

			field1.checked = false;	
}

function reset()
{
	f_query_add_mod.location.href = "../../eMP/jsp/addPatNumberingForRel.jsp" ;
	result.location.href = "../../eCommon/html/blank.html" ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp" ;
}

function query()
{
	f_query_add_mod.location.href = "../../eMP/jsp/addPatNumberingForRel.jsp" ;
	result.location.href = "../../eCommon/html/blank.html" ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp" ;
}

