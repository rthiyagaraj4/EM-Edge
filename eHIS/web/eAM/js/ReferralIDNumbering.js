function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyReferralIDNumbering.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryReferralIDNumbering.jsp" ;
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
	var year=f_query_add_mod.document.ReferralIDNumbering_form.year_num.value;
	var next1=f_query_add_mod.document.ReferralIDNumbering_form.next_referral_num.value;
	
	if(parseInt(next1)==0)
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage('NEXT_REF_NUMBER_GR_ZERO','AM')
		return;
	}

	var fields = new Array ( f_query_add_mod.document.ReferralIDNumbering_form.year_num,
				f_query_add_mod.document.ReferralIDNumbering_form.next_referral_num);
	var names = new Array ( getLabel("Common.year.label","Common"),getLabel("eAM.NextReferralNumber.label","AM"));

//////////Added by Manish Anand on 01-07-2002////////////////////
	var spFields = new Array ( f_query_add_mod.document.ReferralIDNumbering_form.year_num, f_query_add_mod.document.ReferralIDNumbering_form.next_referral_num);
	var spNames = new Array (getLabel("Common.year.label","Common"),getLabel("eAM.NextReferralNumber.label","AM"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		var b=isValidYr(year,next1);

		if(b==true)
		{
 			f_query_add_mod.document.ReferralIDNumbering_form.submit();
		}
	}
}

function onSuccess() {
	//if(f_query_add_mod.document.ReferralIDNumbering_form.function_name.value=="insert")
	//{
/////////////////Added by Manish Anand on 01-07-2002///////////////
	f_query_add_mod.location.reload();
///////////////////////////////////////////////////////////////////
	/*f_query_add_mod.document.ReferralIDNumbering_form.year_num.value		= "" ;
	f_query_add_mod.document.ReferralIDNumbering_form.next_referral_num.value		= "" ;*/
	//}
}

function reset() {
	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.ReferralIDNumbering_form.reset() ;
		f_query_add_mod.document.location.reload();


}

function isValidYr(y,next1)
{
	var bool
	len=y.length;
	var msg=" " ;

	if(len!=4)
		{
		bool= false;
		msg = getMessage("VALID_YEAR_CHECK","AM");
		//msg=" Enter Valid year"
		}
	else
	{
		y=parseInt(y)
		next1=parseInt(next1)
		var dt=new Date();
		var yr=dt.getYear();

		if(!isNaN(y))
		{
			bool=  true;
			if(y<yr)
			{
			bool= false
			msg=getMessage("YEAR_GR_CURR_YEAR_CHECK","AM");
			//msg=" Year should be Greater than Current Year"
			}
			else
			{
				if(next1<0 || isNaN(next1))
				{
				  bool=false
				}
				else
				 {bool=true;}
			}
		}
		else
		{
		msg=getMessage("VALID_YEAR_CHECK","AM");
		bool=false;
		}
	}
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return bool;
}
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
				//	var errors = "APP-0001 Reached Maximum Integer value";
				var errors = getMessage("AM0126","AM");
					//alert(errors);
					//parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			//alert(objectValue.charAt(maxInt));
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}
	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}
	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}
 
	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}
