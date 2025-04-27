var codeArr = new Array();

function loadDefaultPage()
{
	var from = 0;
	var to = 1;
	var totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value - 1);
	if(totalIndex == 0)
		totalIndex = 1;
	var displstart = 1;
	parent.prevnextframe.document.forms[0].label_cap.value = displstart + " of " + totalIndex;
	parent.prevnextframe.document.forms[0].CurIndex.value = 0;
	populateData(from,to)
}

function populateData(from_code, to_code)
{
	
var queryString	= parent.prevnextframe.document.forms[0].queryString.value;
var age_spec_ind_val	= parent.prevnextframe.document.forms[0].age_spec_ind_val.value;
var from_val = codeArr[from_code];
var to_val = codeArr[to_code];
parent.frames[2].location.href="SearchicdcodeQueryResult.jsp?"+queryString+"&from_code="+from_val+"&to_code="+to_val+"&age_spec_ind_val="+age_spec_ind_val;
}

function loadPrevNext(obj)
{
	var NxtBtn		= parent.prevnextframe.document.forms[0].next;
	var PrvBtn		= parent.prevnextframe.document.forms[0].prev;

	var curindex = eval(parent.prevnextframe.document.forms[0].CurIndex.value);
	var totalIndex = eval(parent.prevnextframe.document.forms[0].totalIndex.value) -1;

	var fromindex = 0;
	var toindex = 0;

	var displstart	= 1;
	var displend = totalIndex ; 

	if(obj.name == "next")
	{
		if(curindex < totalIndex)
		{
			curindex++;
			fromindex = curindex;
			toindex = eval(curindex) + 1;

		if((curindex+1) == (totalIndex) ) 
			NxtBtn.disabled = true;
	//	else
			PrvBtn.disabled = false;

		displstart	= eval(curindex) +1;
		}
	}
	else if(obj.name == "prev")
	{
		if(curindex > 0)
		{

			toindex = curindex;
			fromindex = eval(curindex) - 1;
			curindex--;

		if((curindex ) == 0 ) 
				PrvBtn.disabled = true;
//		else
				NxtBtn.disabled = false;

			 displstart	= eval(curindex) + 1;
		}
	}

	parent.prevnextframe.document.forms[0].label_cap.value = displstart + " of " + displend;
	parent.prevnextframe.document.forms[0].CurIndex.value = curindex;
	populateData(fromindex,toindex);
	
}
