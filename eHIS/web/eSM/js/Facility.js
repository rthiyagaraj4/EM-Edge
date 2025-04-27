// -----------------------------------------------------------------
// Some commonly used Array and variables
//Array that will hold the Facility values after the HTML Page is loaded.

//var FacilityListVal = new Array(); 
//var FacilityListLabels = new Array(); 

var uniqueRecordId = new Number();
var recordCount = new Number(); 
recordCount = 5;
uniqueRecordId = 5;

var currentElement ;

// ----------------------------------------------------------------
// function to check for null in Responsibility Id 

function checkForRespId()	{
	if ( parent.resp_info.document.resp_form.resp_id.value == null || parent.resp_info.document.resp_form.resp_id.value =='')
	{
		alert(getMessage('RESP_NOT_ENTERED','SM'));
		return new Boolean(false);
	}
	else { return new Boolean(true); }
}

// ----------------------------------------------------------------
// Function to include details records in master form

function appendFacilityInfo()	{
var frm = parent.resp_info.resp_form;
var errString = new String();
var errorPresent = new Boolean(false);
var firstList = new String();
var secondList = new String();
var i = new Number();
var f_id = new String();
var r_id = new String();

firstList = "<select name='facility_id_info' id='facility_id_info' multiple>";
secondList = "<select name='facility_rmrk_info' id='facility_rmrk_info' multiple>";

for (i=1;i<facility_table.rows.length;i++)
{
var vl = new String();
vl = facility_table.rows(i).id;
vl = vl.substr(2,vl.length);
f_id = "f"+vl;
r_id = "r"+vl;
faciVal = document.all(f_id).value;
if ( document.all(f_id).value != null && document.all(f_id).value != '')
	{
	firstList= firstList+"<option value='"+document.all(f_id).value+"'>"+document.all(f_id).options.item(document.all(f_id).selectedIndex).text+"</option>"  
	secondList= secondList+"<option value='"+document.all(r_id).value+"'>Remark</option>"  
	}
else 
	{
	errString = errString + getLabel("Common.record.label","Common")+i+' :'+getMessage('SELECT_VALID_FCY','SM')+ ' <br>';
	errorPresent = true;
	}
}

if ( errorPresent == true )
	{
		return errString;
	}
else if (errorPresent == false )
	{
		fristList=firstList+"</select>";
		secondList=secondList+"</select>";
		frm.insertAdjacentHTML("BeforeEnd",firstList);
		frm.insertAdjacentHTML("BeforeEnd",secondList);
		selectAll();
		return 'false';
	}
} //End of the function


// ----------------------------------------------------------------
//funtion to select all values of the list
function selectAll()	{ 
	var i = new Number();
	var a=parent.resp_info.document.resp_form.facility_id_info;
	var b=parent.resp_info.document.resp_form.facility_rmrk_info;
	for ( i=0;i<a.length && i<b.length;i++)
		{
			a.options[i].selected=true;
			b.options[i].selected=true;
		}
}








































// ----------------------------------------------------------------
/*  Function to get and keep the Facility information in an Array for future insert of new records.

function collectFacilityDetails()	{
// it loads the FacilityList into 2 arrays for future insert. To avoid redoing it when refocus is happended , array length is checked before loading the array. Say ALT+TAB and came back makes REFOCUS.
	if ( FacilityListVal.length <= 0 )
	{
	var a = document.getElementById("f1");
	for ( var i=0;i<a.length;i++)
		{
		FacilityListVal[i] = a.options.item(i).value; 
		FacilityListLabels[i] = a.options.item(i).text;
		}
	}
}
*/
// ----------------------------------------------------------------
// Function to display context sensitive menu 

function showMenu(obj) {
    //this function will position and display a nested div that acts like a menu
		currentElement = obj;
		whichDiv=event.target;
    menu1.style.posLeft=event.clientX+document.body.scrollLeft;
    menu1.style.posTop=event.clientY+document.body.scrollTop;
    menu1.style.display="";
    menu1.setCapture();
  }

// ----------------------------------------------------------------
// Function to highlight the current menu 

  function toggleMenu() {   
     //as the mouse moves over the menuItems, highlight them
    el=event.target;
    if (el.className=="menuItem") {
       el.className="highlightItem";
    } else if (el.className=="highlightItem") {
       el.className="menuItem";
    }
  }

// ----------------------------------------------------------------
// Function to respond to click of a menu item

  function clickMenu() {
     //when the custom menu is visible (and capturing events),
     //this handler runs after a click event.  if one of the
     //menu items is clicked, it takes appropriate action.  
     //otherwise, it just hides the menu.
     menu1.style.display="none";
     el=event.target;
     if (el.id=="mnuInsert") {
				createRecord();
     } else if (el.id=="mnuUpdate") {
				updateRecord();
     } else if (el.id=="mnuDelete") {
				deleteRecord();
     } else if (el.id=="mnuClear") {
				clearRecord();
     }
     menu1.releaseCapture();
  }
  
// ----------------------------------------------------------------
// Function that will create a new record

  function createRecord()	{
		// f1 indicates the name of the First Facility List
		var facility_temp = document.getElementById("facility_id_temp"); 
		var myRow = document.getElementById("item")("facility_table").insertRow();
		var myCol = myRow.insertCell();
		recordCount = recordCount+1;
		uniqueRecordId = uniqueRecordId + 1;
		var myTag = "<select name='f"+uniqueRecordId+"' id='f"+uniqueRecordId+"'>";
		myRow.id = 'tr'+uniqueRecordId;
		for ( var i=0;i<facility_temp.length;i++)
			{
			myTag = myTag + "<option value='"+facility_temp.options[i].value+"'>" + facility_temp.options[i].text + "</option>";
			}
		myTag = myTag+"</select>";
		myCol.insertAdjacentHTML("AfterBegin",myTag);
		var myCol = myRow.insertCell();
		myTag = "<textarea rows='1' cols='60' name='r"+uniqueRecordId+"' oncontextmenu='showMenu(this);return false;'></textarea>";
		myCol.insertAdjacentHTML("AfterBegin",myTag);
  }
 
// ----------------------------------------------------------------
// Function to delete the mouse clicked record

  function deleteRecord()	{
  	if ( recordCount == 1) 
  		alert(getMessage('CANNOT_DEL_LAST_REC','SM'));   
  	else 
  	{
		var eleToSearch = currentElement;
		var nm = currentElement.name;
		eleToSearch = nm.substr(1,nm.length);
		eleToSearch = "tr"+eleToSearch;
		for ( var i=1;i<facility_table.rows.length;i++)
		{
		if ( facility_table.rows(i).id == eleToSearch )
			{
			document.getElementById("facility_table").deleteRow(i);
			recordCount = recordCount-1;
			break;
			}		
		}
  	}  //for loop end
  }
  
// ----------------------------------------------------------------
// Function to update the mouse clicked record

  function updateRecord()	{
  	alert(getMessage("RECORD_MODIFIED",'SM'));
  }
  function clearRecord()	{
		if ( document.getElementById("operation").value == "insert" )
		{
		var faci_id = currentElement.name;
		faci_id = "f"+faci_id.substr(1,faci_id.length);
		currentElement.value='';
		document.getElementById("item")(faci_id).selectedIndex = 0;
		}
		else if ( document.getElementById("operation").value == "modify" )
		{  

		} 
 }
 
// ----------------------------------------------------------------
// Function to test

function test()	{
	for ( var i=1;i<facility_table.rows.length;i++)
	{
		alert(facility_table.rows(i).id);
		//document.write(document.all('f1').value+"xdxfd");
		//alert(facility_table.rows(i).value);
 	}
}

