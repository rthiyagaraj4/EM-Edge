var LocalErrors = new String();

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addTerminalDigit.jsp?term_digit_level=" ; 
	//Blank is sent as value to disable checking for existing records and create a new record.

}
function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/TerminalDigitQueryCriteria.jsp";
}

function apply() {
 
  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 


if(f_query_add_mod.document.terminal_level_form.function1.value=="insert")
	{
var check_counter_pri = 1;
var check_counter_sec = 1;
var check_counter_ter = 1;

var status = 1;
var temp5 = f_query_add_mod.document.terminal_level_form.group_count.value;


if (temp5==0)
{
	f_query_add_mod.document.terminal_level_form.group_count.value='';
}
LocalErrors = '';
var temp1 = f_query_add_mod.document.terminal_level_form.level.value; 
var temp2 = f_query_add_mod.document.terminal_level_form.Facility_Name.value;
var temp3 = f_query_add_mod.document.terminal_level_form.mr_section.value;
var positionCount = f_query_add_mod.document.terminal_level_form.terminal_digit_count.value; //Added on 4/11/2005

if (temp1=="")
{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$', getLabel('eMP.Atthelevelof.label','MP'));
	LocalErrors = LocalErrors+msg+' <br>';		
	status = 0;
}
//Added on 4/11/2005 to make the No. of Positions field has mandatory

if (temp1=="F")
{
	if (temp2=="")
	{		
		var msg = getMessage("FCY_NM_NOT_BLANK","SM");
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
        return ;		
    }
}
else if (temp1=="S")
{

	if (temp2=="")
	{		
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel('Common.FacilityName.label','Common'));
		LocalErrors = LocalErrors+msg+' <br>';		
		status = 0;
    }
	if (temp3=="")
	{	
		var msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel('Common.MRSection.label','Common'));
		LocalErrors = LocalErrors+msg+' <br>';		
		status = 0;
	}
}
//alert(f_query_add_mod.document.getElementById("sorttermin").value);
if(f_query_add_mod.document.terminal_level_form.sorttermin.value== ""){
	var msg = getMessage("CAN_NOT_BE_BLANK","common");
	
	msg = msg.replace('$', getLabel('eMP.TerminalDigitBy.label','MP'));
	LocalErrors = LocalErrors+msg+' <br>';	
	status = 0;
}

if (status==0)
{
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	return;
}


if(positionCount == ""){
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$', getLabel('eMP.NoofPositions.label','MP'));
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
}

//End


if (f_query_add_mod.document.terminal_level_form.group_count.value!="")
{
	var counter = 0;
	var counter2 = 0;	
	if (f_query_add_mod.document.terminal_level_form.pt1.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt2.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt3.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt4.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt5.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt6.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.pt7.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st1.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st2.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st3.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st4.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st5.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st6.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.st7.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt1.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt2.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt3.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt4.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt5.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt6.value!="") counter = counter +1;
	if (f_query_add_mod.document.terminal_level_form.tt7.value!="") counter = counter +1;
	
	if (counter==0)//At least one should be selected
	{
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
        return ;		
	}
	if (counter>7)//The total number of digits that can be selected cannot be more than 7
	{
		
	
		var msg = getMessage("CANNOT_GREATER","MP");
		msg = msg.replace('#', getLabel('eMP.TotalSelection.label','MP'));
		msg = msg.replace('$',"7");

		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
		counter=0;
        return ;		
	}
	
}
if (f_query_add_mod.document.terminal_level_form.group_count.value!="")
{

var counter1=0;
var p = new Array();
var s = new Array();
var t = new Array();
p[0] = f_query_add_mod.document.terminal_level_form.pt1.value;
p[1] = f_query_add_mod.document.terminal_level_form.pt2.value;
p[2] = f_query_add_mod.document.terminal_level_form.pt3.value;
p[3] = f_query_add_mod.document.terminal_level_form.pt4.value;
p[4] = f_query_add_mod.document.terminal_level_form.pt5.value;
p[5] = f_query_add_mod.document.terminal_level_form.pt6.value;
p[6] = f_query_add_mod.document.terminal_level_form.pt7.value;

s[0] = f_query_add_mod.document.terminal_level_form.st1.value;
s[1] = f_query_add_mod.document.terminal_level_form.st2.value;
s[2] = f_query_add_mod.document.terminal_level_form.st3.value;
s[3] = f_query_add_mod.document.terminal_level_form.st4.value;
s[4] = f_query_add_mod.document.terminal_level_form.st5.value;
s[5] = f_query_add_mod.document.terminal_level_form.st6.value;
s[6] = f_query_add_mod.document.terminal_level_form.st7.value;

t[0] = f_query_add_mod.document.terminal_level_form.tt1.value;
t[1] = f_query_add_mod.document.terminal_level_form.tt2.value;
t[2] = f_query_add_mod.document.terminal_level_form.tt3.value;
t[3] = f_query_add_mod.document.terminal_level_form.tt4.value;
t[4] = f_query_add_mod.document.terminal_level_form.tt5.value;
t[5] = f_query_add_mod.document.terminal_level_form.tt6.value;
t[6] = f_query_add_mod.document.terminal_level_form.tt7.value;



for (var j=0;j<7;j++)
  {
	if(p[j]==0||p[j]=="")
	  {
	  }
	else
	  {
			for (var i=0; i<7 ;i++ )
				{
					if(p[j]==s[i])
						counter1=counter1+1;
					if(p[j]==t[i])
						counter1=counter1+1;
				}			
		
	  }
  }

for (var j=0;j<7;j++)
{
if(p[j]==0||p[j]==""){}		
else
	{
		for (var k=0;k<7 ;k++)
			{
				if(j==k)k++;
				else
				{
				if(p[j]==p[k])
					counter1 = counter1+1;					
				}
			}
	}
}

for (var j=0;j<7;j++)
  {
	if(s[j]==0||s[j]==""){}		
	else
	  {
			for (var i=0; i<7 ;i++ )
				{
					if(s[j]==p[i])
						counter1=counter1+1;
					if(s[j]==t[i])
						counter1=counter1+1;
				}			
	  }
  }

for (var j=0;j<7;j++)
{
if(s[j]==0||s[j]==""){}		
else
	{
		for (var k=0;k<7 ;k++)
			{
				if(j==k)k++;
				else
				{
				if(s[j]==s[k])
					counter1 = counter1+1;
				}
			}
	}
}

for (var j=0;j<7;j++)
  {
	if(t[j]==0||t[j]==""){}
	else
	  {
			for (var i=0; i<7 ;i++ )
				{
					if(t[j]==p[i])
						counter1=counter1+1;
					if(t[j]==s[i])
						counter1=counter1+1;
				}			
	  }
  }
for (var j=0;j<7;j++)
{
if(t[j]==0||t[j]==""){}		
else
	{
		for (var k=0;k<7 ;k++)
			{
				if(j==k)k++;
				else
				{
				if(t[j]==t[k])
					counter1 = counter1+1;
				}
			}
	}
}


if (counter1>0)//Duplicate Terminal Digits
	{

	var msg = getMessage("DUP_NAT_ID","MP");
	msg = msg.replace('#', getLabel('Common.TerminalDigit.label','common'));
	LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
		counter1=0;
        return ;		
	}
}
else
	{ 
		if (f_query_add_mod.document.terminal_level_form.terminal_digit_count.value!="")
		{
	var counter3 = 0;
	var t = new Array();
	t[0] = f_query_add_mod.document.terminal_level_form.terminal_digit1_position.value;
	t[1] = f_query_add_mod.document.terminal_level_form.terminal_digit2_position.value;
	t[2] = f_query_add_mod.document.terminal_level_form.terminal_digit3_position.value;
	t[3] = f_query_add_mod.document.terminal_level_form.terminal_digit4_position.value;
	t[4] = f_query_add_mod.document.terminal_level_form.terminal_digit5_position.value;
	t[5] = f_query_add_mod.document.terminal_level_form.terminal_digit6_position.value;
	t[6] = f_query_add_mod.document.terminal_level_form.terminal_digit7_position.value;

		for (var j=0;j<7;j++)
		{
		if(t[j]==0||t[j]==""){}				
		else
			{
				for (var k=0;k<7 ;k++)
					{
						if(j==k)k++;
						else
						{
						if(t[j]==t[k])
							counter3 = counter3+1;
						}
					}
			}
		}
	if (counter3>0)//Duplicate Terminal Digits
	{
		var msg = getMessage("DUP_NAT_ID","MP");
	    msg = msg.replace('#',getLabel('Common.TerminalDigit.label','common'));
		
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
		counter3=0;
        return ;		
	}



		}// if terminal count chk
	}//end else
	


if (f_query_add_mod.document.terminal_level_form.terminal_digit1_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit1_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 1");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit2_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit2_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 2");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit3_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit3_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 3");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit4_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit4_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 4");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit5_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit5_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 5");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit6_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit6_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 6");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}
if (f_query_add_mod.document.terminal_level_form.terminal_digit7_position.style.visibility=="visible")
{
	if (f_query_add_mod.document.terminal_level_form.terminal_digit7_position.value=="")
	{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$',getLabel('Common.TerminalDigit.label','common')+" 7");
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
}


	if (f_query_add_mod.document.terminal_level_form.sorttermin.value=="PG" )
	{
	if (f_query_add_mod.document.terminal_level_form.group_count.value=="" )
		{
	var msg = getMessage("CAN_NOT_BE_BLANK","Common");
	msg = msg.replace('$', getLabel('eMP.NoofGroups.label','MP'));
	LocalErrors = LocalErrors+msg+' <br>';		
	messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
	status = 0;
    return ;
	}
	}



if(f_query_add_mod.document.terminal_level_form.pt8.checked==false)
	{
		f_query_add_mod.document.terminal_level_form.pt8.value="N";		
		check_counter_pri = 0;
	}
else 
{ 
	var v1 = f_query_add_mod.document.terminal_level_form.pt1.value;
	var v2 = f_query_add_mod.document.terminal_level_form.pt2.value;
	var v3 = f_query_add_mod.document.terminal_level_form.pt3.value;
	var v4 = f_query_add_mod.document.terminal_level_form.pt4.value;
	var v5 = f_query_add_mod.document.terminal_level_form.pt5.value;
	var v6 = f_query_add_mod.document.terminal_level_form.pt6.value;
	var v7 = f_query_add_mod.document.terminal_level_form.pt7.value;
	   if(v1==''&&v2==''&&v3==''&&v4==''&&v5==''&&v6==''&&v7=='')
		{
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");		
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
	    return ;
		}
		else	
	   f_query_add_mod.document.terminal_level_form.pt8.value="Y";
}	

if(f_query_add_mod.document.terminal_level_form.st8.checked==false)
	{
		f_query_add_mod.document.terminal_level_form.st8.value="N";		
		check_counter_sec = 0;
	}
else 
{ 
	var v1 = f_query_add_mod.document.terminal_level_form.st1.value;
	var v2 = f_query_add_mod.document.terminal_level_form.st2.value;
	var v3 = f_query_add_mod.document.terminal_level_form.st3.value;
	var v4 = f_query_add_mod.document.terminal_level_form.st4.value;
	var v5 = f_query_add_mod.document.terminal_level_form.st5.value;
	var v6 = f_query_add_mod.document.terminal_level_form.st6.value;
	var v7 = f_query_add_mod.document.terminal_level_form.st7.value;
	   if(v1==''&&v2==''&&v3==''&&v4==''&&v5==''&&v6==''&&v7=='')
		{
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");		
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
	    return ;
		}
		else	
	  f_query_add_mod.document.terminal_level_form.st8.value="Y";

}		



if(f_query_add_mod.document.terminal_level_form.tt8.checked==false)
	{
		f_query_add_mod.document.terminal_level_form.tt8.value="N";		
		check_counter_ter = 0;
	}
else 
	{ 
	var v1 = f_query_add_mod.document.terminal_level_form.tt1.value;
	var v2 = f_query_add_mod.document.terminal_level_form.tt2.value;
	var v3 = f_query_add_mod.document.terminal_level_form.tt3.value;
	var v4 = f_query_add_mod.document.terminal_level_form.tt4.value;
	var v5 = f_query_add_mod.document.terminal_level_form.tt5.value;
	var v6 = f_query_add_mod.document.terminal_level_form.tt6.value;
	var v7 = f_query_add_mod.document.terminal_level_form.tt7.value;
	   if(v1==''&&v2==''&&v3==''&&v4==''&&v5==''&&v6==''&&v7=='')
		{
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");		
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
	    return ;
		}
		else	
	   f_query_add_mod.document.terminal_level_form.tt8.value="Y";
	}

if (f_query_add_mod.document.terminal_level_form.function1.value=="insert")
{	
	if(f_query_add_mod.document.terminal_level_form.group_count.value!='')
	{
		
		if(check_counter_pri =='0' && check_counter_sec =='0' && check_counter_ter =='0')
		{
			//var msg = "APP-002434 Atleast One checkbox should be selected";		
			var msg = getMessage("ATLEAST_ONE_SELECTED","Common");
			LocalErrors = LocalErrors+msg+' <br>';		
			messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
			status = 0;
			return ;
		}
	}
	f_query_add_mod.document.terminal_level_form.submit() ;
}
else 
	{
		var msg = "";
		LocalErrors = LocalErrors+msg+' <br>';		
		messageFrame.location='../../eCommon/jsp/MstCodeError.jsp?err_num=' + LocalErrors;
		status = 0;
        return ;		

	}
}
/*else
	{
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
	}*/
}



function reset() {

	
	
if(f_query_add_mod.document.terminal_level_form)
{
f_query_add_mod.document.terminal_level_form.reset() ;	 
if (f_query_add_mod.document.terminal_level_form.function1.value=="insert")
{
f_query_add_mod.document.terminal_level_form.terminal_digit1_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit2_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit3_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit4_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit5_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit6_position.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.terminal_digit7_position.style.visibility="hidden";
if (f_query_add_mod.document.getElementById("div14"))
		  f_query_add_mod.document.getElementById("div14").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div13"))
		  f_query_add_mod.document.getElementById("div13").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div12"))
		  f_query_add_mod.document.getElementById("div12").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div11"))
		  f_query_add_mod.document.getElementById("div11").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div10"))
		  f_query_add_mod.document.getElementById("div10").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div9"))
		  f_query_add_mod.document.getElementById("div9").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div8"))
		  f_query_add_mod.document.getElementById("div8").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div7"))
		  f_query_add_mod.document.getElementById("div7").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div6"))
		  f_query_add_mod.document.getElementById("div6").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div5"))
		  f_query_add_mod.document.getElementById("div5").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div4"))
		  f_query_add_mod.document.getElementById("div4").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div3"))
		  f_query_add_mod.document.getElementById("div3").style.visibility = 'hidden';
if (f_query_add_mod.document.getElementById("div2"))
		  f_query_add_mod.document.getElementById("div2").style.visibility = 'hidden';
f_query_add_mod.document.terminal_level_form.pt1.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt2.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt3.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt4.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt5.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt6.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt7.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.pt8.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st1.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st2.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st3.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st4.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st5.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st6.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st7.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.st8.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt1.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt2.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt3.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt4.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt5.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt6.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt7.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.tt8.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img7.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img6.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img5.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img4.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img3.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img2.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img1.style.visibility="hidden";

	var n = f_query_add_mod.document.forms[0].mr_section.options.length;		
	for(var i=0;i<n;i++)
	{
	f_query_add_mod.document.forms[0].mr_section.remove("mr_section");	
	}
	var tp="";
	var temp = "";
	var temp1="------"+getLabel("Common.defaultSelect.label","Common")+"------";
	var opt=f_query_add_mod.document.createElement("OPTION");		
		opt.text=temp1;
		opt.value=temp;			
	f_query_add_mod.document.forms[0].mr_section.add(opt);	

f_query_add_mod.document.terminal_level_form.mr_section.disabled=true;
f_query_add_mod.document.terminal_level_form.img02.style.visibility="hidden";
f_query_add_mod.document.terminal_level_form.img01.style.visibility="hidden";

f_query_add_mod.document.terminal_level_form.Facility_Name.options[0].selected=true;	
f_query_add_mod.document.terminal_level_form.Facility_Name.disabled=true;

}
else return;
}//end chk for terminal level form
else
	{
	if(f_query_add_mod.document.forms[0])
		{
		f_query_add_mod.document.forms[0].reset();
		}
	}
	if(f_query_add_mod.document.terminal_level_form){
    f_query_add_mod.document.getElementById("pos").style.visibility="hidden"
	f_query_add_mod.document.getElementById("terminal_digit_count").style.visibility="hidden"
	f_query_add_mod.document.getElementById("imgid").style.visibility="hidden"
	f_query_add_mod.document.getElementById("imgid1").style.visibility="hidden"
	f_query_add_mod.document.getElementById("pos1").style.visibility="hidden"
	f_query_add_mod.document.getElementById("group_count").style.visibility="hidden"
	f_query_add_mod.document.getElementById("group_count").value="";
	}
//	f_query_add_mod.document.getElementById("group_count").disabled=true;
	//f_query_add_mod.document.getElementById("terminal_digit_count").focus();
	
}

function clearData()
{                     document.getElementById("div14").style.visibility = 'hidden';
						document.getElementById("div2").style.visibility = 'hidden';
						document.getElementById("div3").style.visibility = 'hidden';
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						document.getElementById("div10").style.visibility = 'hidden';
						document.getElementById("div11").style.visibility = 'hidden';
						document.getElementById("div12").style.visibility = 'hidden';
						document.getElementById("div13").style.visibility = 'hidden';						
					    terminal_level_form.pt1.style.visibility="hidden";
						terminal_level_form.pt1.value="";
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						terminal_level_form.pt8.style.visibility="hidden";
						terminal_level_form.st8.style.visibility="hidden";
						terminal_level_form.tt8.style.visibility="hidden";
                        terminal_level_form.pt8.checked=false
						terminal_level_form.st8.checked=false
						terminal_level_form.tt8.checked=false

 				
	document.getElementById("group_count").value="";
}
function onSuccess(){
		f_query_add_mod.document.location.reload();
}
function chkvalue(obj)
{
	if(obj.value!="")
	{
	if (obj.value<=0) 
		{
			alert(getMessage("VALUE_GREAT_ZERO","MP"));
			document.forms[0].terminal_digit_count.focus();
			document.forms[0].terminal_digit_count.select();
		}
	else if (document.forms[0].terminal_digit_count.value>7)
		{
		      if(document.forms[0].sorttermin.value=="PG")
				alert(getMessage("INV_RANGE","MP"));
				document.forms[0].terminal_digit_count.focus();
				document.forms[0].terminal_digit_count.select();
		}
	}
	else
	{
		if(document.forms[0].group_count.value!="")
		{
		document.forms[0].group_count.focus();
		document.forms[0].group_count.select();
		}
	}

}
function deleterecord() {

	if(f_query_add_mod.document.terminal_level_form.function1.value !="insert") {
		if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
		{
			
		 var t1 = f_query_add_mod.document.terminal_level_form.mr_section.value;
		 var t2 = f_query_add_mod.document.terminal_level_form.Facility_Name.value;
		 var t3 = f_query_add_mod.document.terminal_level_form.level.value;	
/*
		 var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
		 HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../servlet/eMP.TerminalDigitServlet'>";
		 HTMLVal = HTMLVal +"<input name='Facility_Name' id='Facility_Name' type='hidden' value= \""+t2+ "\">";
		 HTMLVal = HTMLVal +"<input name='mr_section' id='mr_section' type='hidden' value= \""+t1+ "\">";
		 HTMLVal = HTMLVal +"<input name='mr_section' id='mr_section' type='hidden' value= \""+t1+ "\">";
		 HTMLVal = HTMLVal +"</form></BODY></HTML>";			 
		 parent.frames[2].document.write(HTMLVal);
		 parent.frames[2].document.form1.submit(); 

*/
			f_query_add_mod.document.terminal_level_form.function1.value="delete";
			f_query_add_mod.document.terminal_level_form.level.disabled=false;
			f_query_add_mod.document.terminal_level_form.Facility_Name.disabled=false;
			f_query_add_mod.document.terminal_level_form.mr_section.disabled=false;	

			
			f_query_add_mod.document.terminal_level_form.submit();
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			return;
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
			parent.frames[1].frames[1].document.location.reload();
			//return false;

		}
	}	
	else 	
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= ";
	} 
}
function chkData(obj)
{
	if(document.forms[0].sorttermin.value=="P")
	{
	   chkdigitcnt(obj)
	}else
	{
	 
	 return ;
	}


	   }
function populatePositionGroup()
{	
		document.getElementById("div14").style.visibility = 'hidden';
		document.getElementById("div2").style.visibility = 'hidden';
		document.getElementById("div3").style.visibility = 'hidden';
		document.getElementById("div4").style.visibility = 'hidden';
		document.getElementById("div5").style.visibility = 'hidden';
		document.getElementById("div6").style.visibility = 'hidden';
		document.getElementById("div7").style.visibility = 'hidden';
		document.getElementById("div8").style.visibility = 'hidden';
		document.getElementById("div9").style.visibility = 'hidden';
		document.getElementById("div10").style.visibility = 'hidden';
		document.getElementById("div11").style.visibility = 'hidden';
		document.getElementById("div12").style.visibility = 'hidden';
		document.getElementById("div13").style.visibility = 'hidden';						
		terminal_level_form.pt1.style.visibility="hidden";
		terminal_level_form.pt1.value="";
		terminal_level_form.pt2.style.visibility="hidden";
		terminal_level_form.pt2.value="";
		terminal_level_form.pt3.style.visibility="hidden";
		terminal_level_form.pt3.value="";
		terminal_level_form.pt4.style.visibility="hidden";
		terminal_level_form.pt4.value="";
		terminal_level_form.pt5.style.visibility="hidden";
		terminal_level_form.pt5.value="";
		terminal_level_form.pt6.style.visibility="hidden";
		terminal_level_form.pt6.value="";
		terminal_level_form.pt7.style.visibility="hidden";
		terminal_level_form.pt7.value="";
		terminal_level_form.st1.style.visibility="hidden";
		terminal_level_form.st1.value="";
		terminal_level_form.st2.style.visibility="hidden";
		terminal_level_form.st2.value="";
		terminal_level_form.st3.style.visibility="hidden";
		terminal_level_form.st3.value="";
		terminal_level_form.st4.style.visibility="hidden";
		terminal_level_form.st4.value="";
		terminal_level_form.st5.style.visibility="hidden";
		terminal_level_form.st5.value="";
		terminal_level_form.st6.style.visibility="hidden";
		terminal_level_form.st6.value="";
		terminal_level_form.st7.style.visibility="hidden";
		terminal_level_form.st7.value="";
		terminal_level_form.tt1.style.visibility="hidden";
		terminal_level_form.tt1.value="";
		terminal_level_form.tt2.style.visibility="hidden";
		terminal_level_form.tt2.value="";
		terminal_level_form.tt3.style.visibility="hidden";				
		terminal_level_form.tt3.value="";
		terminal_level_form.tt4.style.visibility="hidden";
		terminal_level_form.tt4.value="";
		terminal_level_form.tt5.style.visibility="hidden";
		terminal_level_form.tt5.value="";
		terminal_level_form.tt6.style.visibility="hidden";
		terminal_level_form.tt6.value="";
		terminal_level_form.tt7.style.visibility="hidden";
		terminal_level_form.tt7.value="";
		terminal_level_form.pt8.style.visibility="hidden";
		terminal_level_form.st8.style.visibility="hidden";
		terminal_level_form.tt8.style.visibility="hidden";

		terminal_level_form.terminal_digit1_position.style.visibility="hidden";
		terminal_level_form.terminal_digit2_position.style.visibility="hidden";
		terminal_level_form.terminal_digit3_position.style.visibility="hidden";
		terminal_level_form.terminal_digit4_position.style.visibility="hidden";
		terminal_level_form.terminal_digit5_position.style.visibility="hidden";
		terminal_level_form.terminal_digit6_position.style.visibility="hidden";
		terminal_level_form.terminal_digit7_position.style.visibility="hidden";
		terminal_level_form.img7.style.visibility="hidden";
		terminal_level_form.img6.style.visibility="hidden";
		terminal_level_form.img5.style.visibility="hidden";
		terminal_level_form.img4.style.visibility="hidden";
		terminal_level_form.img3.style.visibility="hidden";
		terminal_level_form.img2.style.visibility="hidden";
		terminal_level_form.img1.style.visibility="hidden";
	if(document.getElementById("sorttermin").value=='P')
	{
	document.getElementById("pos").style.visibility="visible"
	document.getElementById("terminal_digit_count").style.visibility="visible"
	document.getElementById("imgid").style.visibility="visible"
	document.getElementById("imgid1").style.visibility="hidden"
	document.getElementById("pos1").style.visibility="visible"
	document.getElementById("group_count").style.visibility="visible"
	document.getElementById("group_count").disabled=true;
	document.getElementById("terminal_digit_count").focus();
	document.getElementById("group_count").value="";
	}
	else if(document.getElementById("sorttermin").value=='PG')
	{
	document.getElementById("imgid1").style.visibility="visible"
	document.getElementById("pos").style.visibility="visible"
	document.getElementById("terminal_digit_count").style.visibility="visible"
	document.getElementById("imgid").style.visibility="visible"
	document.getElementById("pos1").style.visibility="visible"
	document.getElementById("group_count").style.visibility="visible"
	document.getElementById("terminal_digit_count").focus();
	document.getElementById("group_count").disabled=false;
	}else
	{document.getElementById("imgid1").style.visibility="hidden"
		document.getElementById("pos").style.visibility="hidden"
	document.getElementById("terminal_digit_count").style.visibility="hidden"
	document.getElementById("imgid").style.visibility="hidden"
	document.getElementById("pos1").style.visibility="hidden"
	document.getElementById("group_count").style.visibility="hidden"
	}
    
}

function CheckIdLen(Obj)
{
	if(Obj.value!="")
	{
		if(parseInt(Obj.value) <= 0)
		{
			alert(getMessage("VALUE_GREAT_ZERO","MP"));
			Obj.focus();
			Obj.select();
			return;
		}
	}
	if (CheckNum(Obj)==true)
	{
		if(Obj.value!="")
		{
			if(parseInt(Obj.value) > parseInt(terminal_level_form.patient_id_length.value))
			{
				alert(getMessage("PATID_GREATER","MP"));
				Obj.focus();
				Obj.select();
			}
		}
	}
}
function enable_select()
{
	if (document.forms[0].level.value=="F")
	{
		//for MR section
		var n = document.forms[0].mr_section.options.length;		
		for(var i=0;i<n;i++)
		{
		document.forms[0].mr_section.remove("mr_section");	
		}
		var tp="";
		var temp = "";
		var temp1="------"+getLabel("Common.defaultSelect.label","Common") +"------";
		var opt=document.createElement("OPTION");		
		opt.text=temp1;
		opt.value=temp;			
		document.forms[0].mr_section.add(opt);		
		//end for mr section
		
		document.forms[0].mr_section.options[0].selected=true;							
		document.forms[0].mr_section.disabled=true;
		document.forms[0].Facility_Name.options[0].selected=true;	
		document.forms[0].Facility_Name.disabled=false;
		document.forms[0].img01.style.visibility="visible";
		document.forms[0].img02.style.visibility="hidden";
	}
	else if (document.forms[0].level.value=="S")
	{	
		document.forms[0].Facility_Name.options[0].selected=true;
		document.forms[0].Facility_Name.disabled=false;
		document.forms[0].mr_section.disabled=false;
		document.forms[0].img01.style.visibility="visible";
		document.forms[0].img02.style.visibility="visible";
	}	
	else
	{
	var n = document.forms[0].mr_section.options.length;		
	for(var i=0;i<n;i++)
	{
	document.forms[0].mr_section.remove("mr_section");	
	}
	var tp="";
		var temp = "";
		var temp1="------"+getLabel("Common.defaultSelect.label","Common") +"------";
		var opt=document.createElement("OPTION");		
		opt.text=temp1;
		opt.value=temp;			
		document.forms[0].mr_section.add(opt);		
		
		document.forms[0].mr_section.options[0].selected=true;						
		document.forms[0].mr_section.disabled=true;
		document.forms[0].Facility_Name.options[0].selected=true;						
		document.forms[0].Facility_Name.disabled=true;
		document.forms[0].img01.style.visibility="hidden";
		document.forms[0].img02.style.visibility="hidden";
	}
}
/*
function enable_mr()
{
	document.forms[0].classcode.value = document.forms[0].Facility_Name.value;
	if (document.forms[0].Facility_Name.value!="")
		document.forms[0].mr_section.disabled=true;
	else 
		document.forms[0].mr_section.disabled=true;

}
*/
function getMRSection(obj)
{
	if (document.forms[0].level.value=="S")
	{
		var sStyle = document.forms[0].sStyle.value;
		var facility = obj.value;
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
		 HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eMP/jsp/getMRSection.jsp'>";
		 HTMLVal = HTMLVal +"<input name='facility' id='facility' type='hidden' value= \""+facility+ "\">";
		 HTMLVal = HTMLVal +"</form></BODY></HTML>";		
		 parent.frames[2].document.write(HTMLVal);
		 parent.frames[2].document.form1.submit(); 
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


function chkgrouplength(Obj)
{	
	if(parseInt(Obj.value) > 3)
		{   
			//Obj.value = '';			
		
			alert(getMessage("INV_RANGE","MP"));							
			Obj.focus();			
			return false;

		}	
	else if(((parseInt(Obj.value) > 0) && (parseInt(Obj.value)<4))||Obj.value=="")
		{
		chkdigitcnt(Obj)
		}
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

