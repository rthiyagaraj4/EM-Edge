var fv=0;
var prevv=0;
var nextt=0;
var rowperpage=5;
var tempHoldObj= new Array();
var tempHoldVal= new Array();



var head="";
head=head+"<table align=middle border=1 cellpadding=0 cellspacing=0 width='98%'>";
head=head+"<tr><td colspan=3 align='right>Select All Dates <input type='checkbox' name='chkAll' id='chkAll'></td></tr>";
head=head+"<tr><th align='middle'  class='header'><b>Week</th>";
head=head+"<th align='middle' class='header'><font size=2><b>Day</b></font><th class='header' align='middle'><font size=2><b>Holiday</b> </font></th><th class='header' align='middle'><font size=2><b>Select Date</b> </font></th></tr>";		
var tail="</table>";

var strArray=new Array();
var strTem="";

var flg=false;
var finalarr= new Array();
var it=0;

function notify(obj){
	if(obj.checked) vCheckFlag=true;
}
/*To check whether all the checked days are selected or not*/
function sel_all(){
	
	for(var h=0;h<tempHoldVal.length;h++)
	{
		if(document.forms[0].chkAll.checked){
			tempHoldObj[h]=tempHoldVal[h];
			
			if(eval("document.forms[0].chkhlDate"+h))		
				eval("document.forms[0].chkhlDate"+h+".checked=true");			
			
			tempHoldObj[h]="chkhlDate"+h;
				
		}else{
			 if(eval("document.forms[0].chkhlDate"+h))			
				eval("document.forms[0].chkhlDate"+h+".checked=false");
			tempHoldObj[h]='';
		}
		
		
	}
	
}


/*To get the dates selected to declare holiday*/
function Hai(no,obj)
{

	if(obj.checked==true)
	{
		tempHoldObj[no]=obj.name;		
	
	}
	else
	{
		if(tempHoldObj[no]!="")
		{
			tempHoldObj[no]="";
			document.forms[0].chkAll.checked=false;
		}
	}
}

function showMe()
{
	var strDateVal="";
	for(var h=0;h<tempHoldObj.length;h++)
	{

		if(tempHoldObj[h]!="")
			strDateVal=strDateVal +","+ tempHoldVal[h];
		
	}
	strDateVal=strDateVal.substring(1);
	document.forms[0].holiday_Dates.value=strDateVal;
}


/*To prepare the array of particular day*/
function store(Obj,Obj1,val2)
{
	
	flg=true;
	Obj1.push(val2);

	var	t2=Obj.getDate();
	if(t2<10) 
		t2="0"+t2;
	var t3=Obj.getMonth()+1;
	if(t3<10) 
		t3="0"+t3;
	var t4=Obj.getFullYear();		
	Obj1.push(t2+"/"+t3+"/"+t4);	
}

/* To return details of the selected days in weekwise option */
function builtHTML(Obj,strVal,wkDay)
{
	Obj.reverse();
	while (Obj.length>0)
	{
		if(fv%rowperpage==0)
		{
			strTem="";
		}

		var t1;
		var t3;			
		t1=Obj.pop();
		t3=Obj.pop();
		strVal=strVal+"<tr><td align='middle' class='label'>"+t3+"</td><td align='middle' class='label'>"+t1+"</td><td align='middle' class='label'>"+wkDay+"</td><td align='middle' class='label'><input type='checkbox' onclick='Hai("+fv+",this)' name='chkhlDate"+fv+"' id='chkhlDate"+fv+"' value='"+t3+"'></td></tr>";
	
		var sp=new Array();
		sp[0]=t1;
		sp[1]=wkDay;
		sp[2]=t3;
		sp[3]=fv;
		strArray[fv]=sp;
		tempHoldObj[fv]="";
		tempHoldVal[fv]=t3;
		fv=fv+1;
	}
	return strVal;
}

/*Called to display and check the dates for which we want to declare Holiday with proper validation*/
function popul()
{
	fv=0;
	prevv=0;
	nextt=0;
	tempHoldObj= new Array();
	strArray=new Array();
	tempHoldVal=new Array();
	strTem="";
	
	flg=false;
	finalarr=new Array();
	var frm=document.forms[0];
	var from=frm.txtFrom.value;
	var to=frm.txtTo.value;
	

	if(from==''){
		msg=getMessage("FROM_DATE_CANNOT_BE_BLANK","SM");		
		alert(msg)
		frm.txtFrom.focus();
		return;
	}
	if(to==''){
		msg=getMessage("TO_DT_NOT_BLANK","SM");
		alert(msg)
		frm.txtTo.focus();
		return;
	}
/*To Calculate the date Difference*/
	var t2=from.substring(0,2);
	var t3=from.substring(3,5);
	var t4=from.substring(6);
				
	from=t3+"/"+t2+"/"+t4;
	
	t2=to.substring(0,2);
	t3=to.substring(3,5);
	t4=to.substring(6);
				
	to=t3+"/"+t2+"/"+t4;
	
	from=new Date(from);
	to=new Date(to);	
	var from_temp=new Date(from);
	
	
	var frmval=from.valueOf();
	var toval=to.valueOf();
	var diff=((toval-frmval)/(1000*60*60*24));

	if(diff >730){
		//alert('Pls enter a maximum of 2 years range');
		alert(getMessage("HOLIDAY_GREATER_THAN_YEAR","OA"));
		frm.txtTo.focus();
		return;
	}//end
	
	var monarr= new Array() ;
	var tuearr= new Array() ;
	var wedarr= new Array() ;
	var thuarr= new Array() ;
	var friarr= new Array() ;
	var satarr= new Array() ;
	var sunarr= new Array() ;
	var val;
	var val1;
	var val2;

	for(var i=0;i<=diff;i++){
		
		from=new Date(from_temp.setDate(parseInt(from_temp.getDate())+0));			
		
		var temp=new Date(from.setDate(parseInt(from.getDate())+parseInt(i)));
		val2=temp.getDate();
		
		if(temp.getDay()==1){
			if(frm.chk[0].checked){			
				val=val2/7;
					if(0<val && val<=1){
					store(temp,monarr,'1');					
				}						
			}
			
			if(frm.chk[7].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,monarr,'2');		
				}			
			}
			
			if(frm.chk[14].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,monarr,'3');		
				}			
			}
			
			if(frm.chk[21].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,monarr,'4');		
				}			
			}
			
			if(frm.chk[28].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,monarr,'5');		
				}			
			}
			
		}
		
		
		if(temp.getDay()==2){
			if(frm.chk[1].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,tuearr,'1');
				}						
			}
			
			if(frm.chk[8].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,tuearr,'2');
				}			
			}
			
			if(frm.chk[15].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,tuearr,'3');
				}			
			}
			
			if(frm.chk[22].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,tuearr,'4');
				}			
			}
			
			if(frm.chk[29].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,tuearr,'5');
				}			
			}
			
		}
		
		
		if(temp.getDay()==3){
			if(frm.chk[2].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,wedarr,'1');
				}						
			}
			
			if(frm.chk[9].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,wedarr,'2');
				}			
			}
			
			if(frm.chk[16].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,wedarr,'3');
				}			
			}
			
			if(frm.chk[23].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,wedarr,'4');
				}			
			}
			
			if(frm.chk[30].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,wedarr,'5');
				}			
			}
			
		}
		
		
		if(temp.getDay()==4){
			if(frm.chk[3].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,thuarr,'1');
				}						
			}
			
			if(frm.chk[10].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,thuarr,'2');
				}			
			}
			
			if(frm.chk[17].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,thuarr,'3');
				}			
			}
			
			if(frm.chk[24].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,thuarr,'4');
				}			
			}
			
			if(frm.chk[31].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,thuarr,'5');
				}			
			}
			
		}
		
		
		if(temp.getDay()==5){
			if(frm.chk[4].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,friarr,'1');
				}						
			}
			
			if(frm.chk[11].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,friarr,'2');
				}			
			}
			
			if(frm.chk[18].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,friarr,'3');
				}			
			}
			
			if(frm.chk[25].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,friarr,'4');
				}			
			}
			
			if(frm.chk[32].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,friarr,'5');
				}			
			}
			
		}
		
		if(temp.getDay()==6){
			if(frm.chk[5].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,satarr,'1');
				}						
			}
			
			if(frm.chk[12].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,satarr,'2');
				}			
			}
			
			if(frm.chk[19].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,satarr,'3');
				}			
			}
			
			if(frm.chk[26].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,satarr,'4');
				}			
			}
			
			if(frm.chk[33].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,satarr,'5');
				}			
			}
			
		}
		
		
		if(temp.getDay()==0){
			if(frm.chk[6].checked){			
				val=val2/7;
				if(0<val && val<=1){
					store(temp,sunarr,'1');
				}						
			}
			
			if(frm.chk[13].checked){
				val=val2/7;
				if(1<val && val<=2){
					store(temp,sunarr,'2');
				}			
			}
			
			if(frm.chk[20].checked){
				val=val2/7;
				if(2<val && val<=3){
					store(temp,sunarr,'3');
				}			
			}
			
			if(frm.chk[27].checked){
				val=val2/7;
				if(3<val && val<=4){
					store(temp,sunarr,'4');
				}			
			}
			
			if(frm.chk[34].checked){
				val=val2/7;
				if(4<val && val<=5){
					store(temp,sunarr,'5');
				}			
			}			
		}			
	}
	var str="";
	var str1="";
	
	if(flg){

		str1="<table align='center' border=0 cellpadding=0 cellspacing=0 width='90%'><tr><td colspan=3 height=6 class=white ></td></tr>";
		str1=str1+"<tr><td colspan=3 align='right' class='label'>"+getLabel("Common.selectall.label","Common")+"<input type='checkbox' name='chkAll' id='chkAll' onclick='sel_all()'></td></tr></table>";

		str=str+"<table align='center' border=1 cellpadding=0 cellspacing=0 width='90%'>";
		str=str +"<tr><th align='middle'  class='header'><b>"+getLabel("Common.HolidayDate.label","Common")+"</b></th><th align='middle' class='header'><b>"+getLabel("Common.Week.label","Common")+"</b> </th>";
		str=str +"<th align='middle'  class='header'><b>"+getLabel("Common.day.label","Common")+"</b><th align='middle'  class='header'><b>Select Date </b> </th></tr>";
		head =str;
	}	
		
	if (monarr.length >0)
		str=builtHTML(monarr,str,'Monday');
	if (tuearr.length >0)
		str=builtHTML(tuearr,str,'Tuesday');
	if (wedarr.length >0)		
		str=builtHTML(wedarr,str,'Wednesday');
	if (thuarr.length >0)	
		str=builtHTML(thuarr,str,'Thursday');
	if (friarr.length >0)
		str=builtHTML(friarr,str,'Friday');
	if (satarr.length >0)
		str=builtHTML(satarr,str,'Saturday');
	if (sunarr.length >0)
		str=builtHTML(sunarr,str,'Sunday');
		
		
		
		
		
			
	if(flg)
	{
		str=str+"</table>";			
	}
	else
	{
		str="";
		str1="";
	}	
	var	vCheckFlag=false;
	for(var ijk=0;ijk<document.forms[0].chk.length;ijk++){
		if(document.forms[0].chk[ijk].checked)
			vCheckFlag=true;
	}

	if( !vCheckFlag) {
		alert(getMessage("ANY_ONE_CRITERIA","Common"))
	}else{
		if(str==''){
			alert(getMessage("SEL_DYS_NT_AVBL","OA"))
		}
	}


	document.getElementById("yyy").innerHTML=str1;
	YYY();
}

/*To determine the no of rows Displayed */
function YYY()
{
	var ff="";
	var flag=0;
	var ttp="<table  align='center' border=0 cellpadding=0 cellspacing=0 width='90%'><tr><td align=right >";
	var aa="<a href='javascript:moveme(1)' >"+getLabel("Common.previous.label","Common")+"</a>";
	var bb="<a href='javascript:void(0);' class='label'> | </a>";
	var cc="<a  href='javascript:moveme(2)'>"+getLabel("Common.next.label","Common")+"</a>";
	var ttpend="&nbsp;&nbsp;</td></tr></table>"

	var ss=0;
	ss=(prevv*rowperpage);
	nextt=ss+rowperpage;

	if(ss == 0)
	{
		aa="";
	}


	if(nextt >= strArray.length)
	{
		nextt=strArray.length;
		cc="";
	}
	if(aa=="" || cc =="")
	bb="";

	ff=ff+ttp+aa+bb+cc+ttpend;
	ff=ff+head;

	
	for(;ss<nextt;ss++)
	{
		flag=1;
		var ut=new Array();
		ut=strArray[ss];
		
		var checked="";
		
		if(tempHoldObj[ss]!="")
		{
			if(ut[3]==tempHoldObj[ss].substring(9))
			checked="checked";
		}
		
		ff=ff+"<tr><td align='middle' class='label'>"+ut[2]+"</td><td align='middle' class='label'>"+ut[0]+"</td><td align='middle' class='label'>"+ut[1]+"</td><td align='middle' class='label'><input type='checkbox' "+checked+" onclick='Hai("+ut[3]+",this)' name='chkhlDate"+ut[3]+"' id='chkhlDate"+ut[3]+"' value='"+ut[2]+"'></td></tr>";
		
	}
	ff=ff+tail;
	if(flag==0)ff="";
	document.getElementById("xxx").innerHTML=ff;
}


/*To determine the next set of rows to be displayed onclick of Previous */
function moveme(no)
{	
	if(no==1)
	{		
		if(prevv-1>=0)
		{
			prevv=prevv-1;
			YYY();
		}
	}
	else
	{
		if(prevv+1<=(strArray.length-1))
		{
			prevv=prevv+1;
			YYY();
		}
	}	
}

/*To display the next set of rows onClick of next*/
function next(inval){
	var k=0;
	var i=parseInt(inval)*5;
	var j=i*2;
	
	if(parseInt(finalarr.length)/5 > 1)
		str=str+"<input type='button' onclick='next(1)' id='button'1 name='button' id='button'1>";
		
	str=str+"<table align=centre border=1 cellpadding=0 cellspacing=0 width='80%'>";
	str=str +"<tr><td align='middle' ><b>Week</b> </td>";
	str=str +"<td align='middle'><b>Day</b></td><td align='middle'><b>Holiday</b> </td><td align='middle'><b>Select Date</b> </td></tr>";
		
	finalarr.reverse();
	while (finalarr.length>0){
			
			
		if (k>i){
			if(k<j){
				str=str+finalarr.pop();
			}
		}
		k=k+1;
			
	}
	
	
	str=str+"</table>";
	document.getElementById("xxx").innerHTML=str;
	
}


/*To check the date Format and display proper message*/
/*function validate_date(obj) {
		var f = document.Holiday_form.sys_date;
		var t = document.Holiday_form.holiday;
		if(!(doDateCheckAlert(f,t))){
			var invaldt = parent.parent.frames[0].getMessage("PREF_FM_DT_VALIDATION","OA");
			alert(invaldt);
			obj.focus();
			return false;
		}
		return true;
}*/

/*For Checking the Holiday Data Range and for Displaying proper Alert when selected Weekwise  */
/*function val_Dt(obj){
	
	var sysDt=document.Holiday_form.sys_date;
	var msg;
	if(obj.value==''){
		if(obj.name=='txtFrom')
			msg=getMessage("FROM_DATE_CANNOT_BE_BLANK","SM");
		else
			msg=getMessage("TO_DT_NOT_BLANK","SM");
		document.getElementById("xxx").innerHTML="&nbsp;";
		document.getElementById("yyy").innerHTML="&nbsp;";
		alert(msg)
		obj.focus();
	}
	
	if(CheckDate(obj)){

		if(obj.name=='txtTo'){
			sysDt=document.Holiday_form.txtFrom;
			if(document.Holiday_form.txtFrom.value !='' && document.Holiday_form.txtTo.value !=''){
				if(!doDateCheckAlert(sysDt,obj)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT","SM");
					alert(msg)
					obj.focus();
				}
			}

		}else{
			if(document.Holiday_form.txtFrom.value !=''){
				if(!doDateCheckAlert(sysDt,obj)){
					msg=getMessage("FROM_DATE_LESS_SYSDATE","SM");
					alert(msg)
					obj.focus();
				}
			}

			if(document.Holiday_form.txtTo.value !=''){
				if(!doDateCheckAlert(obj,document.Holiday_form.txtTo)){
					msg=getMessage("TO_DT_GR_EQ_FM_DT","SM");
					alert(msg)
					document.Holiday_form.txtTo.focus();
				}
			}

		}
		
	}
}*/



/*To put focus on first checkBox, onLoad of Weekwise selection */
function foc(){
	var function_name=document.forms[0].function_name.value
	if(function_name=="insert"){
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;	
	}

	if(document.forms[0].tabvalue.value=="Holiday"){
	parent.f_query_add_mod.document.getElementById("bydate").style.backgroundColor='#00000036';
	parent.f_query_add_mod.document.getElementById("bylocation").style.backgroundColor='white';
	document.getElementById("reason_label").style.display="none";
	document.getElementById('reason_for_holiday').style.visibility="hidden";
	}
}

 
 
 
 function create() { 
	 //parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
	parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.frames[2].document.getElementById("f_query_add_mod").style.height="28vh";
	parent.frames[2].document.getElementById("f_query_add_mod1").style.height="52vh";
	parent.frames[2].document.getElementById("messageFrame").style.height="9vh";

	 f_query_add_mod.location.href = "../../eOA/jsp/addmodifyHoliday.jsp?dw=D&tabvalue=Location" ;   
	frames[2].location.href="../../eCommon/html/blank.html";

}

function query() {
	//parent.frames[2].document.getElementById("holiday").rows="8%,*,2%,8%";
	parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.frames[2].document.getElementById("f_query_add_mod").style.height="82vh";
	parent.frames[2].document.getElementById("f_query_add_mod1").style.height="2vh";
	parent.frames[2].document.getElementById("messageFrame").style.height="8vh";

	f_query_add_mod.location.href ="../../eOA/jsp/HolidayQueryCriteria.jsp" ;
	frames[2].location.href="../../eCommon/html/blank.html";
}

function recall_pg(inVal){
	if(inVal=='D'){
		parent.frames[1].location.href = "../../eOA/jsp/addmodifyHoliday.jsp?dw=D" ;
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
	}else{
		parent.frames[1].location.href = "../../eOA/jsp/addmodifyHoliday.jsp?dw=W" ;
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}

function deleterecord(){
	if(f_query_add_mod.document.Holiday_form){
		if(f_query_add_mod.document.Holiday_form.function_name.value != "insert"){
// Friday, March 12, 2010 19959
		var holiday = f_query_add_mod.document.Holiday_form.holiday.value;
		var holiday_date = f_query_add_mod.document.Holiday_form.holiday_date.value;
		var b_clinic = f_query_add_mod.document.Holiday_form.b_clinic.value;
		var locationType = f_query_add_mod.document.Holiday_form.locationType.value;
		if(frames[1].document.Holiday_form.function_name.value=="modify")
			{
			  f_query_add_mod.document.Holiday_form.function_name.value="delete";
			}

				frames[1].document.Holiday_form.action="../../servlet/eOA.HolidayServlet";
				frames[1].document.Holiday_form.target="messageFrame";
				frames[1].document.Holiday_form.holiday_date.value=frames[1].document.Holiday_form.holiday.value;
				frames[1].document.Holiday_form.b_clinic.value=frames[1].document.Holiday_form.b_clinic.value;
				frames[1].document.Holiday_form.locationType.value=frames[1].document.Holiday_form.locationType.value;
				frames[1].document.Holiday_form.function_name.value=="delete";
				frames[1].document.Holiday_form.submit();

		}else{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
			//parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
				parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8.7vh";
				parent.frames[2].document.getElementById("f_query_add_mod").style.height="28vh";
				parent.frames[2].document.getElementById("f_query_add_mod1").style.height="52vh";
				parent.frames[2].document.getElementById("messageFrame").style.height="9vh";
		}
	}else if(f_query_add_mod.document.HolidayQueryResult){
		if(f_query_add_mod.document.HolidayQueryResult.function_name.value=='delete'){	
			var selValues="";
			var selValues1="";
			len=f_query_add_mod.document.HolidayQueryResult.checkBox.length;
			obj=f_query_add_mod.document.HolidayQueryResult.checkBox;
			Obj=f_query_add_mod.document.HolidayQueryResult;
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=f_query_add_mod.replace(str,i+1,'1') ;
						selValues1=Obj.locnCode[i].value+'$'+Obj.clinicCode[i].value+'$'+Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
					}
				}
			}else if(len==null){
				var str="10000000000000";
				selValues=Obj.locnCode.value+'$'+Obj.clinicCode.value+'$'+Obj.holidayDate.value+'|';
			}
			f_query_add_mod.document.HolidayQueryResult.selectedValues.value=selValues;
			f_query_add_mod.document.HolidayQueryResult.selCheckBoxes.value=str;
			var fromPage=f_query_add_mod.document.HolidayQueryResult.currentPage.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH steps='Holiday' fromPage=\""+fromPage+"\" currSelHolidays=\""+selValues+"\"/></root>";			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			eval(responseText)
			if (result){
				f_query_add_mod.document.HolidayQueryResult.submit();
				//parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
				parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8.8vh";
				parent.frames[2].document.getElementById("f_query_add_mod").style.height="28vh";
				parent.frames[2].document.getElementById("f_query_add_mod1").style.height="52vh";
				parent.frames[2].document.getElementById("messageFrame").style.height="9vh";				
	
			}else{
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				//parent.frames[2].document.getElementById("holiday").rows="8%,*,2%,8%";
					parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8.9vh";
					parent.frames[2].document.getElementById("f_query_add_mod").style.height="82vh";
					parent.frames[2].document.getElementById("f_query_add_mod1").style.height="2vh";
					parent.frames[2].document.getElementById("messageFrame").style.height="8vh";
			}
		}
	}else{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		//parent.frames[2].document.getElementById("holiday").rows="8%,*,2%,8%";
		parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8.10vh";
		parent.frames[2].document.getElementById("f_query_add_mod").style.height="82vh";
		parent.frames[2].document.getElementById("f_query_add_mod1").style.height="2vh";
		parent.frames[2].document.getElementById("messageFrame").style.height="8vh";				
				
	}
}

function apply(){

	var scheduleFalg;
	var location_type;
	if(frames[1].document.Holiday_form){
		location_type=frames[1].document.Holiday_form.locationType.value;
	}
	if(frames[1].document.forms[0].name !="query_form"){//when clinics are selected
		if(frames[2].document.forms[0]){
			if(frames[2].document.forms[0].function_name.value=="insert"){
				//Holiday for slected new clinics
				frames[2].document.Holiday_result.action="../../servlet/eOA.HolidayServlet";
				frames[2].document.Holiday_result.target="messageFrame";
				frames[2].document.Holiday_result.submit();
			}else if(frames[2].document.forms[0].function_name.value=="insertlocntype"){
				//Holiday For selected existing clinics
				frames[2].document.Holiday_result2_FORM.action="../../servlet/eOA.HolidayServlet";
				frames[2].document.Holiday_result2_FORM.target="messageFrame";
				frames[2].document.Holiday_result2_FORM.submit();
			}
		}else if(frames[1].document.Holiday_form && frames[1].document.Holiday_form.function_name.value=="modify"){
			var flag=true;
			if(frames[1].document.Holiday_form.reason_for_holiday.value!=""){
				flag=true;
			}else{
				flag=false;
				var error=getMessage("REASON_FOR_HOLIDAY","OA");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			if(flag){
				frames[1].document.Holiday_form.action="../../servlet/eOA.HolidayServlet";
				frames[1].document.Holiday_form.target="messageFrame";
				frames[1].document.Holiday_form.holiday.value=frames[1].document.Holiday_form.holdate.value;
				frames[1].document.Holiday_form.submit();
			}
		}else{
			if(frames[1].document.Holiday_form && frames[1].document.forms[0].tabvalue.value=="Location"){
				//Holiday For all existing clinics 
				f_query_add_mod.document.Holiday_form.fromdate.value=f_query_add_mod.document.Holiday_form.holiday.value
				f_query_add_mod.document.Holiday_form.todate.value=f_query_add_mod.document.Holiday_form.holiday_end.value
				var location_type=frames[1].document.Holiday_form.locationType.value;
				frames[1].document.forms[0].function_name.value="insertlocntype";
				var fields=new Array();
				var names = new Array ();
				fields[0]=frames[1].document.Holiday_form.holiday;
				fields[1]= frames[1].document.Holiday_form.locationType;
				fields[2]=frames[1].document.Holiday_form.reason_for_holiday;
				names = new Array (getLabel("Common.fromdate.label","Common"),
									getLabel("Common.locationtype.label","Common"),
									getLabel("Common.ReasonForHoliday.label","Common"));
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
				if(frames[1].checkFields( fields, names, messageFrame)){
					if(frames[1].document.Holiday_form.b_clinic.value=="*A"){
						var locn_type=frames[1].document.Holiday_form.locationType.value;
						var holiday_from=frames[1].document.Holiday_form.holiday.value;
						var holiday_end=frames[1].document.Holiday_form.holiday_end.value;
						if(holiday_end==""){
							holiday_end=holiday_from;
						}
						//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
						//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
						var xmlHttp = new XMLHttpRequest();
						xmlStr	="<root><SEARCH " ;
						xmlStr += "locn_type='"+locn_type+"' holiday_from='"+holiday_from+"' holiday_end='"+holiday_end+"' steps='HolidayExistClinics'";
						xmlStr +=" /></root>" ;
						var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText;
						responseText = trimString(responseText);
						scheduleFalg=eval(responseText);
						if(!scheduleFalg){
							alert(getMessage("SCH_EXISTS_BETWEEN_DATE_RANGE","OA"));
							messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
							return false;
						}else{
							frames[1].document.forms[0].action="../../servlet/eOA.HolidayServlet?location_type="+location_type;
							frames[1].document.forms[0].target="messageFrame";
							frames[1].document.forms[0].submit();
						}						
					}else{
						var msg=getMessage("NO_RECORD_INSERTION", "OA");
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
						return false;
					}
				}else{
				}
			}else if(frames[1].document.Holiday_form && frames[1].document.forms[0].tabvalue.value=="Holiday"){
				//Holiday for all new clinics
				frames[1].document.forms[0].function_name.value="insert";
				var fields=new Array();
				var names = new Array ();
				if(frames[1].document.Holiday_form.b_clinic.value=="*A"){
					fields[0]=frames[1].document.Holiday_form.locationType;
					fields[1]= frames[1].document.Holiday_form.b_clinic;
					fields[2]= frames[1].document.Holiday_form.holiday;
					fields[3]= frames[1].document.Holiday_form.holiday_end;
					fields[4]= frames[1].document.Holiday_form.reason_for_holiday;
					names = new Array(	getLabel("Common.locationtype.label","Common"),
										getLabel("Common.Location.label","Common"),
										getLabel("Common.fromdate.label","Common"),
										getLabel("Common.todate.label","Common"),
										getLabel("Common.ReasonForHoliday.label","Common"));
				}else{
					fields[0]=frames[1].document.Holiday_form.locationType;
					fields[1]= frames[1].document.Holiday_form.holiday;
					names = new Array (	getLabel("Common.locationtype.label","Common"),
										getLabel("Common.fromdate.label","Common")
						);
				}
				frames[1].document.forms[0].action="../../servlet/eOA.HolidayServlet";
				frames[1].document.forms[0].target="messageFrame";
				if(frames[1].checkFields( fields, names, messageFrame)){
					if(frames[1].document.Holiday_form.b_clinic.value!=""){
						if(frames[1].document.Holiday_form.b_clinic.value=="*A"){
							//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
							//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
							var xmlHttp = new XMLHttpRequest();
							var locn_type=frames[1].document.Holiday_form.locationType.value;
							var holiday_from=frames[1].document.Holiday_form.holiday.value;
							var holiday_end=frames[1].document.Holiday_form.holiday_end.value;
							xmlStr	="<root><SEARCH " ;
							xmlStr += "locn_type='"+locn_type+"' holiday_from='"+holiday_from+"' holiday_end='"+holiday_end+"' steps='HolidayNewClinics'";
							xmlStr +=" /></root>" ;
							var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText;
							responseText = trimString(responseText);
							scheduleFalg=eval(responseText);
							if(!scheduleFalg){
								alert(getMessage("SCH_EXISTS_BETWEEN_DATE_RANGE","OA"));
								messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
								return false;
							}
							frames[1].document.forms[0].action="../../servlet/eOA.HolidayServlet";
							frames[1].document.forms[0].target="messageFrame";
							frames[1].document.forms[0].submit();
						}else{
							var msg=getMessage("NO_RECORD_INSERTION", "OA");
							messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
							return false;
						}
					}else{
						/*var error=getMessage("CAN_NOT_BE_BLANK","Common");
						error=error.replace("$",getLabel("Common.Location.label","Common"));
						alert(error);*/
						var msg=getMessage("NO_RECORD_INSERTION", "OA");
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
						return false;
					}
				}else{
				}
			}else{
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
	}else{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}

var flag;
function onSuccess() {
	if (flag)
	{
	}
	else
	{
		if(f_query_add_mod.document.forms[0].function_name)
		{
		if(f_query_add_mod.document.forms[0].function_name.value=='delete')
		{
			//parent.frames[2].document.getElementById("holiday").rows="8%,*,2%,8%";
				parent.frames[2].document.getElementById("commontoolbarFrame").style.height="8.11vh";
				parent.frames[2].document.getElementById("f_query_add_mod").style.height="28vh";
				parent.frames[2].document.getElementById("f_query_add_mod1").style.height="52vh";
				parent.frames[2].document.getElementById("messageFrame").style.height="9vh";
			f_query_add_mod.document.location.href = "../../eOA/jsp/HolidayQueryCriteria.jsp" ;
		}else{
		f_query_add_mod.document.location.href = "../../eOA/jsp/addmodifyHoliday.jsp" ;
		}
		}else
			f_query_add_mod.document.location.href = "../../eOA/jsp/addmodifyHoliday.jsp" ;

	}	
}

function onSuccess1()
{
	
	parent.frames[1].location.reload();

}

function prevnextsubmission(flag1,clinic_code,clinic_desc,holiday_date,locn_type,orderCols,prevnextsub){
	if(prevnextsub=="Y"){
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg)
		//parent.document.getElementById("holiday").rows="8%,*,0%,8%";
			parent.document.getElementById("commontoolbarFrame").style.height="8.12vh";
			parent.document.getElementById("f_query_add_mod").style.height="28vh";
			parent.document.getElementById("f_query_add_mod1").style.height="52vh";
			parent.document.getElementById("messageFrame").style.height="9vh";
		//parent.f_query_add_mod.location.href="../../eCommon/html/blank.html";
		//parent.f_query_add_mo1.location.href="../../eCommon/html/blank.html";
		parent.f_query_add_mod.location.href ="../eOA/jsp/HolidayQueryResult.jsp?clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&holiday_date="+holiday_date+"&locn_type="+locn_type+"&orderCols="+orderCols;
		//parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num="+msg;
	}else{
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg);
		//parent.document.getElementById("holiday").rows="8%,*,2%,8%";
		parent.document.getElementById("commontoolbarFrame").style.height="8.1vh";
		parent.document.getElementById("f_query_add_mod").style.height="55vh";
		parent.document.getElementById("f_query_add_mod1").style.height="26vh";
		parent.document.getElementById("messageFrame").style.height="8vh";
		parent.f_query_add_mod.location.href ="../eOA/jsp/HolidayQueryCriteria.jsp" ;
		parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num=";
		//frames[2].location.href="../../eCommon/html/blank.html";
	}
}

function onSuccesslocn()
{
	
	//parent.frames[1].location.reload();
	parent.frames[2].location.href="../eCommon/html/blank.html";
}

function reset() {

  f_query_add_mod.document.forms[0].reset() ;
  if(frames[2].document.forms[0])
  {
	frames[2].location.href="../../eCommon/html/blank.html";
  }

}

function Date_Transform (transform,messageFrame) {
		dateset = transform[0];
		dateset1 = transform[1];
		if(dateset1.value=="") {
			dateset.value="";
		}
		else {
			var tst=dateset1.value;
			var arr = new Array();
			arr = tst.split("/");
			var strDay = arr[0];
			var strMonth = arr[1];
			var strYear = arr[2];
			var dt= strYear + "-" + strMonth + "-" + strDay;
			dateset.value= dt;
		}

	}

function clear_All(){
		document.getElementById("xxx").innerHTML='&nbsp;';
		document.getElementById("yyy").innerHTML='&nbsp;';
		parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
}


function populateClinic_locn(obj,from){
		if(obj.value==null||obj.value==""){
		document.forms[0].b_clinic.value="";
    	document.forms[0].b_loc_val.value="";
    	document.forms[0].holiday_end.value="";
		document.forms[0].b_loc_val.disabled=true;
		document.forms[0].b_loc_search.disabled=true;
		document.getElementById('mand_to_date').style.visibility="hidden";
		/* Added By Dharma on 11th March 2015 against HSA-CRF-0184 [IN:049544] Start*/
		document.forms[0].holiday_end.disabled=true;
		document.forms[0].to_date_val.disabled=true;
		/* Added By Dharma on 11th March 2015 against HSA-CRF-0184 [IN:049544] End*/


	}else{
		document.forms[0].b_clinic.value="";
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc_val.disabled=false;
		document.forms[0].b_loc_search.disabled=false;
		document.getElementById('mand_to_date').style.visibility="hidden";
		/* Added By Dharma on 11th March 2015 against HSA-CRF-0184 [IN:049544] Start*/
		document.forms[0].holiday_end.value="";
		document.forms[0].holiday_end.disabled=true;
		document.forms[0].to_date_val.disabled=true;
		/* Added By Dharma on 11th March 2015 against HSA-CRF-0184 [IN:049544] End*/

		


	}
	/*if (obj.value!=''){
	//document.forms[0].selAll.disabled=false;
	//document.forms[0].selAll.checked=false;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+obj.value+"\"  steps='holiday_val' from=\""+from+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	}else{
    Obj=document.forms[0].b_clinic;
	while (Obj.options.length >0)
	{Obj.remove(Obj.options[0]);
	document.forms[0].mand_to_date.style.visibility="hidden";
	}
	opt=document.createElement('OPTION');
	opt.value='';
	opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
	Obj.add(opt);
	if(document.forms[0].b_clinic.selectedIndex==0){
	var opt1=document.createElement('OPTION');
	 opt1.value='A';
	opt1.text="*All";
	Obj.add(opt1);
	}
	
	}*/
	parent.frames[2].location.href="../../eCommon/html/blank.html";

}

function populateClinic_date(obj,from){
		if(obj.value==null||obj.value==""){
		document.forms[0].b_clinic.value="";
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc_val.disabled=true;
		document.forms[0].b_loc_search.disabled=true;
	}else{
		document.forms[0].b_clinic.value="";
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc_val.disabled=false;
		document.forms[0].b_loc_search.disabled=false;
	}
	/*if (obj.value!=''){
	//document.forms[0].selAll.disabled=false;
	//document.forms[0].selAll.checked=false;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+obj.value+"\" steps='holiday_val_date' from=\""+from+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	}else{
    Obj=document.forms[0].b_clinic;
	while (Obj.options.length >0)
	{Obj.remove(Obj.options[0]);
	}
	opt=document.createElement('OPTION');
	opt.value='';
	opt.text='----'+getLabel("Common.defaultSelect.label","Common")+'----';
	Obj.add(opt);
	if(document.forms[0].b_clinic.selectedIndex==0){
	var opt1=document.createElement('OPTION');
	 opt1.value='A';
	opt1.text="*All";
	Obj.add(opt1);
	}
	//document.forms[0].selAll.checked=false;
	//document.forms[0].selAll.disabled=true;
	//Obj.size=1;
	}*/
	parent.frames[2].location.href="../../eCommon/html/blank.html";

}
function clearvalue(obj){
	if(obj.value =="*A")
	{
		document.getElementById('Select').style.visibility='hidden';
		document.getElementById('Cancel').style.visibility='hidden';
		if(document.forms[0].tabvalue.value=="Holiday"){
		document.forms[0].reason_for_holiday.value="";
		document.getElementById("reason_label").style.display="Inline";
		document.getElementById('reason_for_holiday').style.visibility="visible";
		document.getElementById('mand_reason').style.visibility="visible";
		}
	}else
	{
		document.getElementById('Select').style.visibility='visible';
		document.getElementById('Cancel').style.visibility='visible';
		if(document.forms[0].tabvalue.value=="Holiday"){
		document.forms[0].reason_for_holiday.value="";
		document.getElementById("reason_label").style.display="none";
		document.getElementById('reason_for_holiday').style.visibility="hidden";
		document.getElementById('mand_reason').style.visibility="hidden";
		}
	}
parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function qryModify(locn_type,cliniccode,holiday_date,reason,holiday,clinicDesc,facilityId){
	parent.frames[1].location.href="../../eOA/jsp/addmodifyHoliday.jsp?holiday_date="+holiday_date+"&hday="+holiday+"&facility_id="+facilityId+"&locn_type="+locn_type+"&cliniccode="+cliniccode+"&clinicDesc="+clinicDesc; 
	
}

function replace(str,pos,chr){
var len= str.length;
return(str.substr(0,parseInt(pos))+chr+str.substr(parseInt(pos)+1,len));
}

function replaceStr(str,start,end,str1){
var len =str.length;
return(str.substr(0,parseInt(start))+str1+str.substr(parseInt(end)+1,len))
}

function checkBoxOnClick(obj,i){
if (obj.checked==false){
	document.getElementById("selectall").checked=false;
}


}

function builtURL(url){
	var selValues="";
	var selValues1="";
	len=document.getElementById("checkBox").length;
	obj=document.getElementById("checkBox");
	obj1=document.getElementById("selectall");
	if (obj1.checked){
	var str="111111111111111";
	}else{
	var str="000000000000000";
	}
    for (i=0;i<len;i++){
     if (obj[i].checked){ 
     
	if (!obj1.checked) str=replace(str,i+1,'1') ;
	selValues1= document.getElementById("locnCode")[i].value+'$'+document.getElementById("clinicCode")[i].value+'$'+document.getElementById("holidayDate")[i].value+'|';
	selValues+=selValues1;

	 }
	}
	document.getElementById("selCheckBoxes").value=str;
	this.location.href=url+str+'&selHolidays='+selValues;
}

function ClearMsg(){
	
	//document.getElementById("show_prev_next").style.visibility='hidden';
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function selectAll_S(obj){
	len=document.getElementById("checkBox").length;
	if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				document.getElementById("checkBox")[i].checked=true;
			}
		}else{
			for (i=0;i<len;i++){
				document.getElementById("checkBox")[i].checked=false;
			}
		}
	}else{
		if (obj.checked){
			document.getElementById("checkBox").checked=true;
		}else{
			document.getElementById("checkBox").checked=false;
		}
	}
}

function selectAll(obj){
	
	var clinic=document.forms[0].b_clinic;
	var i=0;
	var len=clinic.options.length;
	if (obj.checked){
		while (i<len){ 
			clinic.options[i].selected=true;
			i+=1;
		}
		selectedValues(document.forms[0].b_clinic);
	}else{
		while (i<len){ 
			clinic.options[i].selected=false;
			i+=1;
		}
	}
}

//Holiday for new location
function Holiday_search(obj){

	//document.getElementById("holiday").rows="8%,28%,*,8%";
	
	parent.document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.document.getElementById("f_query_add_mod").style.height="32vh";
	parent.document.getElementById("f_query_add_mod1").style.height="52vh";
	parent.document.getElementById("messageFrame").style.height="9vh";
	self.location.href= "../../eOA/jsp/addmodifyHoliday.jsp?dw=D&tabvalue=Holiday" ; 
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

//Existing Holiday
function Location_search(obj){
	//parent.document.getElementById("holiday").rows="8%,28%,*,8%";
	
	parent.document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.document.getElementById("f_query_add_mod").style.height="28vh";
	parent.document.getElementById("f_query_add_mod1").style.height="52vh";
	parent.document.getElementById("messageFrame").style.height="9vh";
	self.location.href= "../../eOA/jsp/addmodifyHoliday.jsp?dw=D&tabvalue=Location" ;   
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}

function refresh_result()
{
parent.frames[2].location.href="../../eCommon/html/blank.html";
}
var currClass = '';

function  call_result()//Holiday For Existing Location
{
var fields=new Array();
var names = new Array ();
var holiday_date_from;
var holiday_date_to;
var location_type;
var clinic_code;
var reason_for_holiday;
	if (parent.f_query_add_mod.document.Holiday_form)
	{
		
			fields[0]=parent.f_query_add_mod.document.Holiday_form.holiday;
			fields[1]= parent.f_query_add_mod.document.Holiday_form.locationType;
			fields[2]=parent.f_query_add_mod.document.Holiday_form.reason_for_holiday;
			names = new Array (getLabel("Common.fromdate.label","Common"),
								getLabel("Common.Location.label","Common"),
								getLabel("Common.ReasonForHoliday.label","Common"));
				
		
	
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";

	if(parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
		{
		
		holiday_date_from=parent.f_query_add_mod.document.Holiday_form.holiday.value;
		holiday_date_to=parent.f_query_add_mod.document.Holiday_form.holiday_end.value;
		if(holiday_date_to =="") holiday_date_to=holiday_date_from;
		reason_for_holiday=parent.f_query_add_mod.document.Holiday_form.reason_for_holiday.value;
		location_type=parent.f_query_add_mod.document.Holiday_form.locationType.value;
		clinic_code=parent.f_query_add_mod.document.Holiday_form.b_clinic.value;
		var clinic_code1="";
		if(clinic_code !="")	
			{
		clinic_code=clinic_code.split("$");
	 clinic_code1=clinic_code[1];
			}else
			{
				clinic_code1="";
			}
		var flagSelect="true";
		//document.getElementById("holiday").rows="8%,28%,*,8%";
		parent.document.getElementById("commontoolbarFrame").style.height="8.3vh";
		parent.document.getElementById("f_query_add_mod").style.height="28vh";
		parent.document.getElementById("f_query_add_mod1").style.height="52vh";
		parent.document.getElementById("messageFrame").style.height="9vh";			

		//parent.frames[1].document.forms[0].target="";
parent.frames[2].document.location.href="../../eOA/jsp/addmodifyHolidayResult.jsp?holiday_date_from="+holiday_date_from+"&holiday_date_to="+holiday_date_to+"&location_type="+location_type+"&reason_for_holiday="+reason_for_holiday+"&flagSelect="+flagSelect+"&clinic_code="+clinic_code1;
	
		}else
		{
		}
	}else
	{
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}


function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	
	var from_date=document.forms[0].holiday_date_from.value;
	var to_date=document.forms[0].holiday_date_to.value;

	from_date=convertDate(from_date,"DMY","en",localeName);
	to_date=convertDate(to_date,"DMY","en",localeName);
	document.Holiday_result2_FORM.action='../../eOA/jsp/addmodifyHolidayResult.jsp?holiday_date_from='+from_date+'&holiday_date_to='+to_date;
	document.Holiday_result2_FORM.target="f_query_add_mod1";
	parent.f_query_add_mod1.document.Holiday_result2_FORM.submit();
	
}

function call_result_date(){//Holiday For New Location
	var fields=new Array();
	var names = new Array ();
	var holiday_date;
	var holiday_end_date;
	var location_type;
	var clinic_code;
	if (parent.f_query_add_mod.document.Holiday_form){
		
		//fields[1]=parent.f_query_add_mod.document.Holiday_form.b_clinic;
		
		if(parent.f_query_add_mod.document.Holiday_form.b_clinic.value !=""){
			fields[0]= parent.f_query_add_mod.document.Holiday_form.locationType;
			fields[1]=holiday_date_from=parent.f_query_add_mod.document.Holiday_form.holiday;
			fields[2]=holiday_date_from=parent.f_query_add_mod.document.Holiday_form.holiday_end;
			names = new Array (	getLabel("Common.locationtype.label","Common"),
								getLabel("Common.fromdate.label","Common"),
								getLabel("Common.todate.label","Common"));
		}else{
			fields[0]= parent.f_query_add_mod.document.Holiday_form.locationType;			
			fields[1]=holiday_date_from=parent.f_query_add_mod.document.Holiday_form.holiday;
			names = new Array (	getLabel("Common.locationtype.label","Common"),
									getLabel("Common.fromdate.label","Common"));
		}
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		if(parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame)){
			location_type=parent.f_query_add_mod.document.Holiday_form.locationType.value;
			clinic_code=parent.f_query_add_mod.document.Holiday_form.b_clinic.value;
			holiday_date=parent.f_query_add_mod.document.Holiday_form.holiday.value;
			holiday_end_date=parent.f_query_add_mod.document.Holiday_form.holiday_end.value;
			if(holiday_end_date=="") holiday_end_date=holiday_date;
			var clinic_code1="";
			if(clinic_code !=""){
				clinic_code=clinic_code.split("$");
				 clinic_code1=clinic_code[1];
			}
			var flagSelect="true";
			//document.getElementById("holiday").rows="8%,28%,*,8%";
			parent.document.getElementById("commontoolbarFrame").style.height="8.4vh";
			parent.document.getElementById("f_query_add_mod").style.height="32vh";
			parent.document.getElementById("f_query_add_mod1").style.height="52vh";
			parent.document.getElementById("messageFrame").style.height="9vh";			
			document.forms[0].target="f_query_add_mod1";
			parent.frames[2].document.location.href="../../eOA/jsp/AddModifyHolidayResultBydate.jsp?location_type="+location_type+"&clinic_code="+clinic_code1+"&flagSelect="+flagSelect+"&holiday_date="+holiday_date+"&holiday_end_date="+holiday_end_date;
		}else{
		}
	}else{
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}

function change_val(obj,val,obj2)
{
	

var action_on_holiday_schedule=parent.f_query_add_mod.document.Holiday_form.action_on_holiday_schedule.value;//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 


	if(obj.checked)
	{
		obj.value = "Y";
			var reason=eval("document.forms[0].reason_for_holiday"+val).value;
			eval(document.getElementById("removeCode"+val)).value="N";
	if(reason=="")
		{
		var error=getMessage("REASON_FOR_HOLIDAY","OA");
			alert(error);
			obj.checked=false;
		}else
		{
			/*holiday_date=eval("document.forms[0].holiday_date"+val).value;
			var holiday_date1=convertDate(holiday_date,"DMY",localeName,"en");

			var clinic_code1=parent.frames[1].document.forms[0].b_clinic.value;
			var	locationType="";
			clinic_code1=clinic_code1.split("$");
			var clinic_code =clinic_code1[1];
			locationType=clinic_code1[0];
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH  holiday_date=\""+holiday_date1+"\" location=\""+locationType+"\" clinics=\""+clinic_code+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","GetHoliday.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			eval(responseText) */
				if(obj2=="S")
			{
				if(action_on_holiday_schedule=='W')//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
				{
				var error = parent.f_query_add_mod1.getMessage('SCH_EXIST_HOLIDAY_NOT_ALLOWED','OA');
				if(window.confirm(error)){ 
				
				obj.checked=true;
				}
				else
					obj.checked=false;
				}else
				{
					//eval("document.forms[0].reason_for_holiday"+val).value=""
					var restrict =getMessage('CANCEL_THE_SCHEDULE','OA');//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
					alert(restrict) 
					obj.checked=false;
					eval("document.forms[0].reason_for_holiday"+val).value="";
														
				}

				
				
			}else
			{
			}
		}

	}
	else
	{
		obj.value = "N";
		eval(document.getElementById("removeCode"+val)).value="Y";
	}
}
function change_val1(obj,val,obj2)
{
	var action_on_holiday_schedule=parent.f_query_add_mod.document.Holiday_form.action_on_holiday_schedule.value;//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 

	if(obj.checked)
	{
			obj.value = "Y";
			if(obj2=="S")
			{
				
				if(eval("document.forms[0].reason_for_holiday"+val))
				{
				eval("document.forms[0].reason_for_holiday"+val).value="";
				}
				if(action_on_holiday_schedule=='W')//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
				{
				var error = parent.f_query_add_mod1.getMessage('SCH_EXIST_HOLIDAY_NOT_ALLOWED','OA');
				if(window.confirm(error)){ 
				
				obj.checked=true;
				
				}
				else
					obj.checked=false;
				}else
				{
					var restrict =getMessage('CANCEL_THE_SCHEDULE','OA');//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
					alert(restrict) 
					obj.checked=false;
					
				}
			}else
			{
			}
	}else
	{
		obj.value = "N";
	}
}
function chk_value_reason(obj1,obj2)
{
	var reason=eval("document.forms[0].reason_for_holiday"+obj2).value;
	
	if(reason =="")
	{
  //alert("document.forms[0].select_yn"+obj2);
		if(eval("document.forms[0].select_yn"+obj2).checked ==true)
		{
		eval("document.forms[0].select_yn"+obj2).checked=false;
		}
	}
}

function submitPrevNext1(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
//   alert(document.forms[0].from.value);
  //   alert(document.forms[0].to.value);
	document.forms[0].action='../../eOA/jsp/AddModifyHolidayResultBydate.jsp';
	document.forms[0].target="f_query_add_mod1";
	parent.frames[2].document.forms[0].submit();

/*	{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	
	var from_date=document.forms[0].holiday_end_date.value;
	var to_date=document.forms[0].holiday_date.value;

	from_date=convertDate(from_date,"DMY","en",localeName);
	to_date=convertDate(to_date,"DMY","en",localeName);
	document.Holiday_result.action='../../eOA/jsp/AddModifyHolidayResultBydate.jsp?holiday_end_date='+from_date+'&holiday_date='+to_date;
	document.Holiday_result.target="f_query_add_mod1";
	parent.f_query_add_mod1.document.Holiday_result.submit();
	
}*/

}

function chk_mand(obj)
{
	if(obj.value !="")
	{
		document.forms[0].holiday_end.disabled=false;
		document.forms[0].to_date_val.disabled=false;
		document.getElementById('mand_to_date').style.visibility="visible";
	}else
	{
		document.forms[0].holiday_end.disabled=true;
		document.forms[0].holiday_end.value="";
		document.forms[0].to_date_val.disabled=true;
		document.getElementById('mand_to_date').style.visibility="hidden";
	}
}


/******Date******/

function validate_date_from(from)
{
	var sys=document.Holiday_form.sys_date;

	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		var obj1=convertDate(from.value,"DMY",localeName,"en");

		if(isBefore(sys.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();	
				return false;
			}
			else
				return true;

		}
}



function validate_date_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}

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
}

function compare_from(from,to)
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



function year_check(from,to)
{
	if(from.value!="" && to.value!="")
	{
	var year_count=yearsBetween(from.value,to.value,'DMY',localeName);
	
		
	if(year_count >= 1)
				{
					
						var error = getMessage('HOLIDAY_GREATER_THAN_YEAR','OA');	
						alert(error);
						document.Holiday_form.holiday_end.value="";
						document.Holiday_form.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
					tosubmit=true;
				}

}

}


function month_Check1()
{

			var strDate = document.Holiday_form.holiday.value;
			var end_date=document.Holiday_form.holiday_end.value;
			var tosubmit=true;

			var fromarray1; var toarray1;
			var fromdate1 = end_date ;
			var todate1   = strDate ;
			if(fromdate1.length > 0 && todate1.length > 0 ) 
			{

				var strDate1=convertDate(strDate,"DMY",localeName,"en");
				var end_date1=convertDate(end_date,"DMY",localeName,"en");


				fromarray1 = strDate1.split("/");
				toarray1 = end_date1.split("/");
					
				var fromdt = new Date((parseInt(fromarray1[2])),(parseInt(fromarray1[1])+1),fromarray1[0]);
				var todt   = new Date(toarray1[2],toarray1[1],toarray1[0]);


				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH steps='Holiday_date' strDate=\""+strDate1+"\" end_date=\""+end_date1+"\"/></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ServerSide.jsp",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
					responseText = trimString(responseText);
				eval(responseText); 
				if(flag=="0")	
				{
						var error = getMessage('SCH_GREATER_THAN_MONTH','OA');	
						alert(error);
						document.Holiday_form.holiday_end.value="";
						document.Holiday_form.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
				tosubmit=true;
				}

			}
	

}

async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].locationType.value;
	var care_locn_ind=document.forms[0].locationType.value;
	var tab_Selected=document.forms[0].tabvalue.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=HOLIDAY&tab_Selected="+tab_Selected,arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var care_locn_type_ind=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		if(clinic_code=='*A'){
			document.forms[0].b_clinic.value='*A';
		}else{
		document.forms[0].b_clinic.value=care_locn_type_ind+"$"+clinic_code;
		}

		if(tab_Selected=='Location'){
		clearvalue(document.forms[0].b_clinic);
		}else if(tab_Selected=='Holiday'){
			chk_mand(document.forms[0].b_clinic);
			clearvalue(document.forms[0].b_clinic);
		}
		
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_clinic.value="";
		if(tab_Selected=='Location'){
			if(document.forms[0].mand_to_date){
				document.getElementById('mand_to_date').style.visibility="hidden";
			}
			clearvalue(document.forms[0].b_clinic);
		}else if(tab_Selected=='Holiday'){
			chk_mand(document.forms[0].b_clinic);
			clearvalue(document.forms[0].b_clinic);
		}
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		document.forms[0].b_clinic.value="";
		var tab_Selected=document.forms[0].tabvalue.value;
		if(tab_Selected=='Location'){
		clearvalue(document.forms[0].b_clinic);
		}else if(tab_Selected=='Holiday'){
			chk_mand(document.forms[0].b_clinic);
			clearvalue(document.forms[0].b_clinic);
		}
	}else{
	open_loc_lookup()
	}
}









