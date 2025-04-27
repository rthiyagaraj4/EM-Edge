/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           		?				?				created
31/10/2014	  IN032369		Karthi L			?				?				System displays bsp; in Result linked New Born details note.
24/05/2016	  IN055439		Karthi L										MO_CRF_20102
09/05/2017	IN064173		Krishna Gowtham 09/05/2017		Ramesh G		Alpha - CA-Record Clinical Note System displays HTML Tags in Long Text Component 
																			when New Born Result is linked.
---------------------------------------------------------------------------------------------------------------
*/

var order_arr = new Array();
function scrollTitle()
{
	/*var y = document.RecClinicalNotesLinkBornResultForm.document.body.scrollTop;

	if(y == 0)
	{
		document.RecClinicalNotesLinkBornResultForm.document.getElementById("divDataTitle").style.position = 'static';
		document.RecClinicalNotesLinkBornResultForm.document.getElementById("divDataTitle").style.posTop = 0;
	}
	else
	{
		document.RecClinicalNotesLinkBornResultForm.document.getElementById("divDataTitle").style.position = 'relative';
		document.RecClinicalNotesLinkBornResultForm.document.getElementById("divDataTitle").style.posTop = y-2;
	}*/
}

function loadResult(obj)
{
	var qs = parent.RecClinicalNotesLinkBornEnctrFrame.document.RecClinicalNotesLinkBornEnctrForm.qs.value;
	parent.RecClinicalNotesLinkBornMainFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkBirthDetailsMain.jsp?mother_encounter_id="+obj.value+"&"+qs;
	parent.RecClinicalNotesLinkBornSelectButtonsFrame.location.href = parent.RecClinicalNotesLinkBornSelectButtonsFrame.location.href;
}

function Add(obj,j)
{
	var demoObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.demoChkBox"+j);
	var clinicObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.clinicalChkBox"+j);
	var vaccineObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vaccineChkBox"+j);
	var apgarObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.apgarChkBox"+j);
	var babyObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j);

	if(obj.checked == true)
	{
		parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled = false;
	
		if((obj.name).indexOf("M") != -1)
		{
			var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
			var checkall = false;
			for(u=0;u<(mcount);u++)
			{
				var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.motherChkBox.checked = true;
		}
		else if((obj.name).indexOf("F") != -1)
		{
			var fcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fcount.value;
			var checkall = false;
			for(u=0;u<(fcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fatherChkBox.checked = true;
		}
		else if((obj.name).indexOf("D") != -1)
		{
			var bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
			var checkall = false;
			for(u=0;u<(bdcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.demoChkBox"+j+".checked = true");
			
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else if((obj.name).indexOf("C") != -1)
		{
			var bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
			var checkall = false;
			for(u=0;u<(bccount);u++)
			{
				var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.clinicalChkBox"+j+".checked = true");
			
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else if((obj.name).indexOf("V") != -1)
		{
			var vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
			var checkall = false;
			for(u=0;u<(vcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vaccineChkBox"+j+".checked = true");

			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else if((obj.name).indexOf("A") != -1)
		{
			var bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
			var checkall = false;
			for(u=0;u<(bacount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
				if(obj.checked == true)
					checkall = true;
				else
				{
					checkall = false;
					return false;
				}
			}
			if(checkall)
				eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.apgarChkBox"+j+".checked = true");

			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
	}
}

function remove(obj,j)
{
	if(obj.checked == false)
	{
		if((obj.name).indexOf("M") != -1)
			parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.motherChkBox.checked = false;
		else if((obj.name).indexOf("F") != -1)
			parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fatherChkBox.checked = false;
		else if((obj.name).indexOf("D") != -1)
		{
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.demoChkBox"+j+".checked = false");
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
		}
		else if((obj.name).indexOf("C") != -1)
		{
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.clinicalChkBox"+j+".checked = false");
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
		}
		else if((obj.name).indexOf("V") != -1)
		{
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vaccineChkBox"+j+".checked = false");
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
		}
		else if((obj.name).indexOf("A") != -1)
		{
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.apgarChkBox"+j+".checked = false");
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
		}
		disableSelect();
	}
}

var html		= "";
var text		= "";
var textlink	= "";
var htmlbab		= "";
var textbab		= "";
var textlinkbab = "";
String.prototype.replaceAll=function(s1, s2) {return this.split(s1).join(s2)}
function tableFormation()
{
	var mother_encounter_id = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mother_encounter_id.value;
	var mother_yn = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mother_yn.value;

	var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
	var bcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bcount.value;
	var fcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fcount.value;

	var count		= 0;
	var cat			= "";
	var htmlmother	= "";
	var textmother	= "";
	var textlinkmother = "";

	var htmlfather	= "";
	var textfather	= "";
	var textlinkfather = "";

	var htmltemp1	= "";
	var texttemp1	= "";
	var textlinktemp1 = "";
	var labelobj = "";

	for(u=0;u<(mcount);u++)
	{
		obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
		labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LM"+u);
		  
		if(obj.checked == true)
		{
		   var mumval = obj.value; 
		   var mumlabel = labelobj.value; 
           htmlmother+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%' nowrap><font size=2>&nbsp;"+mumval+"</font></td></tr>";
		   textmother+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
		   textlinkmother+=mumlabel+": "+mumval+"\n";
           count++;  
		}
	}

	if(htmlmother != "")
	{
		htmlmother = "<table border='1' cellpadding='0' cellspacing='0' width='100%'><tr><td align=center colspan=2><font size=2><b>Mother Details</b></font></td></tr>"+htmlmother+"</table><br>";
		textmother = "<font size=2><b>Mother Details</b></font><br>"+textmother;
		textlinkmother = "Mother Details\n"+textlinkmother;
	}

	for(u=0;u<(fcount);u++)
	{
		obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
		labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LF"+u);
		  
		if(obj.checked == true)
		{
		   var mumval = obj.value; 
		   var mumlabel = labelobj.value; 
           htmlfather+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%' ><font size=2>&nbsp;"+mumval+"</font></td></tr>";
		   textfather+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
		   textlinkfather+=mumlabel+": "+mumval+"\n";
           count++;  
		}
	}

	if(htmlfather != "")
	{
		htmlfather = "<table border='1' cellpadding='0' cellspacing='0' width='100%'><tr><td align=center colspan=2><font size=2><b>Father Details</b></font></td></tr>"+htmlfather+"</table><br>";
		textfather = "<font size=2><b>Father Details</b></font><br>"+textfather;
		textlinkfather = "Father Details\n"+textlinkfather;
	}

	var babycount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babycount.value;
	var bdcount = "";
	var bccount = "";
	var bacount = "";
	
	var htmlbab1 = "";
	var textbab1 = "";
	var textlinkbab1 = "";

	var htmlbab2 = "";
	var textbab2 = "";
	var textlinkbab2 = "";
	
	for(var j=1;j<=babycount;j++)
	{
		htmlbab = "";
		textbab = "";
		textlinkbab = "";

		labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LB"+j);
		var babyname = labelobj.value;
		babyname = babyname.replaceAll("~","'");
		
		if(babycount == 1)
		{
			var babyname1 = babyname;
			babyname = babyname.replace(/ /g,"&nbsp;");	
			var pos =  babyname.indexOf("&nbsp;",50);		
			// below if condition is added for IN032369, when the babyname is coming with space and it count is more than 50 char. 
			if(pos != -1) { // added for IN032369
			babyname = babyname.substring(0, pos) + " " + babyname.substring(pos + 6);
			pos =  babyname.lastIndexOf("/");
			babyname = babyname.substring(0, pos+1) + " " + babyname.substring(pos+7);
			} // added for IN032369
			htmlbab1 = "<table  border='1'  cellpadding='0' width='100%' cellspacing='0'><tr><td align=center colspan=2><font size=2><b>Baby Details ("+babyname+")</b></font></td></tr>";

			textbab1 = "<font size=2><b>Baby Details ("+babyname1+")</b></font><br>";
			textlinkbab1 = "Baby Details ("+babyname1+")\n";
		}
		else
		{			
			var babyname1 = babyname;
			babyname = babyname.replace(/ /g,"&nbsp;");		
			var pos =  babyname.indexOf("&nbsp;",50);
			if(pos != -1) { // added for IN032369
				babyname = babyname.substring(0, pos) + " " + babyname.substring(pos + 6);
				pos =  babyname.lastIndexOf("/");
				babyname = babyname.substring(0, pos+1) + " " + babyname.substring(pos+7);
			} // added for IN032369
			htmlbab1 = "<table  border='1'  cellpadding='3' width='100%' cellspacing='0'><tr><td  colspan=2 align=center><font size=2><b>Baby"+j+" Details ("+babyname+")</b></font></td></tr>";
			
			textbab1 = "<font size=2><b>Baby"+j+" Details ("+babyname1+")</b></font><br>";
			textlinkbab1 = "Baby"+j+" Details ("+babyname1+")\n";
		}		
		bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
		htmltemp1 = "";
		texttemp1 = "";
		textlinktemp1 = "";
		for(u=0;u<(bdcount);u++)
		{
			obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
			labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LD"+j+""+u);
			  
			if(obj.checked == true)
			{
			   var mumval = obj.value; 
			   var mumlabel = labelobj.value; 
			   htmltemp1+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%' nowrap><font size=2>&nbsp;"+mumval+"</font></td></tr>";
			   texttemp1+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
			   textlinktemp1+=mumlabel+": "+mumval+"\n";
			   count++;  
			}
		}

		if(htmltemp1 != "")
		{
			htmlbab = "<tr><td align=left colspan=2><font size=2><b>Demographical Details</b></font></td></tr>"+htmltemp1;
			textbab = "<font size=2><b>Demographical Details</b></font><br>"+texttemp1;
			textlinkbab = "Demographical Details\n"+textlinktemp1;
		}
		
		bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
		htmltemp1 = "";
		texttemp1 = "";
		textlinktemp1 = "";

		for(u=0;u<(bccount);u++)
		{
			obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
			labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LC"+j+""+u);
			  
			if(obj.checked == true)
			{
			   var mumval = obj.value; 
			   var mumlabel = labelobj.value; 
			   htmltemp1+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%' nowrap><font size=2>&nbsp;"+mumval+"</font></td></tr>";
			   texttemp1+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
			   textlinktemp1+=mumlabel+": "+mumval+"\n";
			   count++;  
			}
		}

		if(htmltemp1 != "")
		{
			htmlbab = htmlbab+"<tr><td align=left colspan=2><font size=2><b>Clinical Details</b></font></td></tr>"+htmltemp1;
			textbab = textbab+"<font size=2><b>Clinical Details</b></font><br>"+texttemp1;
			textlinkbab = textlinkbab+"Clinical Details\n"+textlinktemp1;
		}

		vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
		htmltemp1 = "";
		texttemp1 = "";
		textlinktemp1 = "";

		for(u=0;u<(vcount);u++)
		{
			obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
			labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LV"+j+""+u);
			  
			if(obj.checked == true)
			{
			   var mumval = obj.value; 			   
			  
			   var mumlabel = labelobj.value; 
			   htmltemp1+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%'><font size=2>&nbsp;"+mumval+"</font></td></tr>";
			   texttemp1+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
			   textlinktemp1+=mumlabel+": "+mumval +"\n";
			   count++;  
			}
		}

		if(htmltemp1 != "")
		{
			htmlbab = htmlbab+"<tr><td align=left colspan=2><font size=2><b>Vaccination Details</b></font></td></tr>"+htmltemp1;
			textbab = textbab+"<font size=2><b>Vaccination Details</b></font><br>"+texttemp1;
			textlinkbab = textlinkbab+"Vaccination Details\n"+textlinktemp1;
		}
			
		bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
		htmltemp1 = "";
		texttemp1 = "";
		textlinktemp1 = "";

		for(u=0;u<(bacount);u++)
		{
			obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
			labelobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LA"+j+""+u);
			  
			if(obj.checked == true)
			{
			   var mumval = obj.value; 
			   var mumlabel = labelobj.value; 
			   htmltemp1+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+mumlabel+"</b></td><td class=label align=left width='60%' nowrap><font size=2>&nbsp;"+mumval+"</font></td></tr>";
			   texttemp1+="<font size=2><b>"+mumlabel+": </b>"+mumval+"</font><br>";
			   textlinktemp1+=mumlabel+": "+mumval+"\n";
			   count++;  
			}
		}
		if(htmltemp1 != "")
		{
			htmlbab = htmlbab+"<tr><td align=left colspan=2><font size=2><b>Apgar Score</b></font></td></tr>"+htmltemp1;
			textbab = textbab+"<font size=2><b>Apgar Score</b></font><br>"+texttemp1;
			textlinkbab = textlinkbab+"Apgar Score\n"+textlinktemp1;
		}
		if(htmlbab != "")
		{
			htmlbab1 = htmlbab1 + htmlbab + "</table><br>";
			textbab1 = textbab1 + textbab;
			textlinkbab1 = textlinkbab1 + textlinkbab;
		}
		else
		{
			htmlbab1 = "";
			textbab1 = "";
			textlinkbab1 = "";
		}
		if(htmlbab1 != '')
		{
			htmlbab2 = htmlbab2 + htmlbab1;
			textbab2 = textbab2 + textbab1;
			textlinkbab2 = textlinkbab2 + textlinkbab1;
		}
	}
	
	var order = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.order.value;
	var order_arr = new Array();
	order_arr =	order.split("~");

	if(order_arr.length > 1)
	{
		for(var c=0;c<order_arr.length;c++)
		{
			if(order_arr[c] == 'MOTHERDETAIL')
			{
				html = html + htmlmother;
				text = text+textmother;
				textlink = textlink+textlinkmother;
			}
			else if(order_arr[c] == 'FATHERDETAIL')
			{
				html = html + htmlfather;
				text = text + textfather;
				textlink = textlink + textlinkfather;
			}
			else if(order_arr[c] == 'BABYDETAIL')
			{
				html = html + htmlbab2;
				text = text + textbab2;
				textlink = textlink + textlinkbab2;
			}
		}
	}
	else
	{
		html = htmlmother + htmlfather + htmlbab2;
		text = textmother + textfather + textbab2;
		textlink = textlinkmother + textlinkfather + textlinkbab2;
	}
	if(html != '')
	{
		if(mother_yn == 'Y')
		{
			html = "<b>Encounter ID: "+mother_encounter_id+"</b>" + html;
			text = "<b>Encounter ID: "+mother_encounter_id+"</b><br>" + text;
			textlink = "Encounter ID: "+mother_encounter_id+"\n" + textlink;
		}
		else
		{
			html = "<b>Mother Encounter ID: "+mother_encounter_id+"</b>" + html;
			text = "<b>Mother Encounter ID: "+mother_encounter_id+"</b><br>" + text;
			textlink = "Mother Encounter ID: "+mother_encounter_id+"\n" + textlink;
		}
	}

	if(html == '' || text != '' || textlink != '')
		parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= true;

	/*for(u=0;u<(bcount);u++)
	{
		var obj = new Array(); obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.B"+u);
		var labelbabobj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LB"+u);
		
		if(obj.checked == true )
		{
			var objBaby = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.LBI"+u);
			var babval = obj.value; 
			var bablabel = labelbabobj.value; 
			if (objBaby.value != "")
			{
				if(objBaby.value != prevobj.value )
				{
					if (noofbirths>1)
					{
						htmlbab+="<tr><td class=label align=center nowrap colspan=2><font size=2><b>Baby"+objBaby.value+" Detail</b></font></td></tr>";
						textbab+="<br><br><font size=2><b>Baby"+objBaby.value+" Detail</b></font><br>";
					}
					else
					{
						htmlbab+="<tr><td class=label align=center nowrap colspan=2><font size=2><b>Baby Detail</b></font></td></tr>";
						textbab+="<br><br><font size=2><b>Baby Detail</b></font><br>";
					}

					textlinkbab+="Baby Detail\n";
					prevobj = objBaby;
				}
				htmlbab+="<tr><td class=label align=left width='40%' nowrap><font size=2><b>"+bablabel+"</b></td><td class=label align=left width='60%' nowrap><font size=2>&nbsp;"+babval+"</font></td></tr>";
		   
				textbab+="<font size=2><b>"+bablabel+":</b>"+babval+"</font><br>";
				textlinkbab+=bablabel+":"+babval+"\n";
			}
			count++; 
		}
	}
	if(htmlbab != "")
	{
		htmlbab+="</table>";
		html = html+htmltemp+htmlbab;
		text = text+texttemp+textbab;
		textlink = textlink+textlinktemp+textlinkbab;
	}*/
	
}

function perform(obj,j)
{
	var objname = obj.name;
	if(objname.indexOf(j) != -1)
		objname = objname.substring(0,objname.indexOf(j));

	var demoObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.demoChkBox"+j);
	var clinicObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.clinicalChkBox"+j);
	var vaccineObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vaccineChkBox"+j);
	var apgarObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.apgarChkBox"+j);
	var babyObj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j);

	if(objname == 'motherChkBox')
	{
		var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(mcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
				obj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(mcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
				obj.checked = false;
			}
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == 'fatherChkBox')
	{
		var fcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fcount.value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(fcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
				obj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(fcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
				obj.checked = false;
			}
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == "babyChkBox")
	{
		var bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
		var bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
		var bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
		var vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
		
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			demoObj.checked = true;
			clinicObj.checked = true;
			vaccineObj.checked = true;
			apgarObj.checked = true;

			for(u=0;u<(vcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
				obj.checked = true;
			}
			for(u=0;u<(bdcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
				obj.checked = true;
			}
			for(u=0;u<(bccount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
				obj.checked = true;
			}
			for(u=0;u<(bacount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
				obj.checked = true;
			}
		}
		else
		{
			demoObj.checked = false;
			clinicObj.checked = false;
			vaccineObj.checked = false;
			apgarObj.checked = false;

			for(u=0;u<(vcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
				obj.checked = false;
			}
			for(u=0;u<(bdcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
				obj.checked = false;
			}
			for(u=0;u<(bccount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
				obj.checked = false;
			}
			for(u=0;u<(bacount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
				obj.checked = false;
			}
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == "demoChkBox")
	{
		var bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(bdcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
				obj.checked = true;
			}
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(bdcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
				obj.checked = false;
			}
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == "clinicalChkBox")
	{
		var bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(bccount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
				obj.checked = true;
			}
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(bccount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
				obj.checked = false;
			}
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == "vaccineChkBox")
	{
		var vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(vcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
				obj.checked = true;
			}
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(vcount);u++)
			{
				var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
				obj.checked = false;
			}
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	else if(objname == "apgarChkBox")
	{
		var bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
		if(obj.checked == true)
		{
			parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

			for(u=0;u<(bacount);u++)
			{
				var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
				obj.checked = true;
			}
			if((demoObj.checked == true) && (clinicObj.checked == true) && (vaccineObj.checked == true) && (apgarObj.checked == true))
			{
				babyObj.checked = true;
			}
		}
		else
		{
			for(u=0;u<(bacount);u++)
			{
				var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
				obj.checked = false;
			}
			eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
			html = "";
			text = "";
			textlink = "";
			disableSelect();
		}
	}
	/*var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
	var bcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bcount.value;

	if(obj.checked == true)
	{
		parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= false;

		for(u=0;u<(mcount);u++)
		{
			var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
			obj.checked = true;
		}
		for(u=0;u<(bcount);u++)
		{
			var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.B"+u);
			obj.checked = true;
		}

	}
	else
	{
		parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled= true;

		for(u=0;u<(mcount);u++)
		{
			var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
			obj.checked = false;
		}
		for(u=0;u<(bcount);u++)
		{
			var obj=eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.B"+u);
			obj.checked = false;
		}
		html = "";
		text = "";
		textlink = "";
	}*/
}

function returnDataApprove()
{
	var dispResLinkHYMLYN = parent.RecClinicalNotesLinkBornEnctrFrame.document.forms[0].dispResLinkHYMLYN.value; //IN064173
    tableFormation();
	//  MO_CRF_20102[IN055439] - Start
	/* IN064173 start
	if(document.getElementById("chkt").checked) {
		parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value = 'TEXTLINK';
	}
	*/
	//  MO_CRF_20102[IN055439] - End
	if(dispResLinkHYMLYN == "Y")
	{
		if(parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value='HTML';
		}
		else
		{
			parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value='TEXTLINK';
		}
	}
	else
	{
		if(parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.chkl.checked) 
		{
			parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value='';
		}
		else
		{
			parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value='TEXT';
		}
	}
	//IN064173 Ends
	var return_format = parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value;
	var returnValue = '';
	if(return_format == "TEXTLINK")
	{
		returnValue = text;
	}
	else if(return_format == "TEXT")
	{
		returnValue = textlink;
	}
	else
	{
		returnValue = html;
	}
	if(returnValue == '')
		alert(getMessage('MIN_ONE_ITEM_SEL_REQ','CA'));
	else
	{		
		parent.window.returnValue = returnValue;
		parent.window.close();	
	}
}

function chgretn(Obj)
{
	if(Obj.value == 't')
		parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value = 'TEXTLINK';
	else
		parent.RecClinicalNotesLinkBornMainFrame.document.forms[0].return_format.value = '';
}

function clearFormApprove()
{
	parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled = true;
	if(parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.motherChkBox != null)
		parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.motherChkBox.checked = false;
	if(parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fatherChkBox != null)
		parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fatherChkBox.checked = false;
	
	var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
	var fcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fcount.value;

    for(u=0;u<(mcount);u++)
	{
		var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
		obj.checked = false;
	}
	for(u=0;u<(fcount);u++)
	{
		var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
		obj.checked = false;
	}

	var babycount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babycount.value;
	
	for(var j=1;j<=(babycount);j++)
	{
		eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babyChkBox"+j+".checked = false");
		eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.demoChkBox"+j+".checked = false");
		eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.clinicalChkBox"+j+".checked = false");
		eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vaccineChkBox"+j+".checked = false");
		eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.apgarChkBox"+j+".checked = false");

		var bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
		for(u=0;u<(bdcount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
			obj.checked = false;
		}

		var bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
		for(u=0;u<(bccount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
			obj.checked = false;
		}
		
		var vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
		for(u=0;u<(vcount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
			obj.checked = false;
		}

		var bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
		for(u=0;u<(bacount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
			obj.checked = false;
		}
	}
}

function disableSelect()
{
	var checked = false;
	
	var mcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.mcount.value;
	for(u=0;u<(mcount);u++)
	{
		var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.M"+u);
		if(obj.checked == true)
		{
			return true;
		}
		else
			checked = false;
	}

	var fcount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.fcount.value;
	for(u=0;u<(fcount);u++)
	{
		var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.F"+u);
		if(obj.checked == true)
		{
			return true;
		}
		else
			checked = false;
	}

	var babycount = parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.babycount.value;
	for(var j=1;j<=(babycount);j++)
	{
		var bdcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bdcount"+j).value;
		for(u=0;u<(bdcount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.D"+j+""+u);
			if(obj.checked == true)
			{
				return true;
			}
			else
				checked = false;
		}

		var bccount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bccount"+j).value;
		for(u=0;u<(bccount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.C"+j+""+u);
			if(obj.checked == true)
			{
				return true;
			}
			else
				checked = false;
		}
		
		var vcount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.vcount"+j).value;
		for(u=0;u<(vcount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.V"+j+""+u);
			if(obj.checked == true)
			{
				return true;
			}
			else
				checked = false;
		}

		var bacount = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.bacount"+j).value;
		for(u=0;u<(bacount);u++)
		{
			var obj = eval("parent.RecClinicalNotesLinkBornMainFrame.document.RecClinicalNotesLinkBornResultForm.A"+j+""+u);
			if(obj.checked == true)
			{
				return true;
			}
			else
				checked = false;
		}
	}
	if(checked == false)
	{
		parent.RecClinicalNotesLinkBornSelectButtonsFrame.document.RecClinicalNotesLinkBornSelectButtonsForm.select.disabled = true;
	}
}
