function CheckForSpecCharsforID(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}






function record()
{
	var i=0;
/*while(i<document.FilterSearchForm.elements.length)
	{
       if(document.FilterSearchForm.elements[i].type=='select-one')
		{
             if(document.FilterSearchForm.elements[i].value=='')
			{
alert("XH0001 cannot be blank IN Select Option");
return false;
			}
            else
			{
             i++;
			}

		}
else if(document.FilterSearchForm.elements[i].type=='text')
		{
 if(document.FilterSearchForm.elements[i].value=='')
			{

alert("XH0001 cannot be blank  in text box");
return false;
			}
            else
			{
i++;
//document.forms[0].submit();
			}


//document.forms[0].submit();

		}

i++;
	}*/

document.forms[0].submit();


//document.forms[0].Add.disabled=false;




}

function myClick(e,j)
{

searchElementcodeQuery(e.srcElement.name,j);

}

function addRow(r){
var root = r.parentNode;//the root
var count=document.forms[0].count_fields.value;
var allRows = root.getElementsByTagName('tr');//the rows' collection
var cRow = allRows[0].cloneNode(true)//the clone of the 1st row
var cInp = cRow.getElementsByTagName('input');//the inputs' collection of the 1st row
var k=0;
var h=0;
var currentElement;
for(var i=0;i<cInp.length;i++)
	{//changes the inputs' names (indexes the names)
if(cInp[i].type=="text")
{
	
/*cInp[i].setAttribute('name',"Element_code_Query"+count);






count++;
document.forms[0].count_fields.value=count;*/

currentElement = document.createElement("input");
currentElement.setAttribute("type", "text");
currentElement.setAttribute("name", "Element_code_Query"+count);
currentElement.setAttribute("id", "Element_code_Query"+count);
//currentElement.setAttribute("value", null);
root.appendChild(currentElement);
count++;
document.forms[0].count_fields.value=count;
}
else if(cInp[i].type=="hidden")
{
	
if(cInp[i].id.indexOf("Element_code_Query_id")!=-1)
	{
		k++;
		
currentElement = document.createElement("input");
currentElement.setAttribute("type", "hidden");
currentElement.setAttribute("name", (count-1)+"Element_code_Query_id");
currentElement.setAttribute("id", (count-1)+"Element_code_Query_id");
currentElement.setAttribute("value", document.getElementById(k+"Element_code_Query_id").value);
root.appendChild(currentElement);



	}
else if(cInp[i].name.indexOf("Element_code_Querys")!=-1)
	{
	
cInp[i].setAttribute('name',"Element_code_Querys"+(count-1)+(count-1));
cInp[i].setAttribute('id',"Element_code_Querys"+(count-1)+(count-1));
cInp[i].setAttribute("value",null);


	}
	else if(cInp[i].name.indexOf("leval_number")!=-1)
	{
h++;
currentElement = document.createElement("input");
currentElement.setAttribute("type", "hidden");
currentElement.setAttribute("name", (count-1)+"leval_number");
currentElement.setAttribute("id", (count-1)+"leval_number");
currentElement.setAttribute("value", h);
root.appendChild(currentElement);
	}


}


else if(cInp[i].type=="button")
{


cInp[i].setAttribute('name',(count-1)+"Element_code_Query_idb");
}
}
//alert(document.FilterSearchForm.elements.innerText[0].name);

/*for(i=0; i<document.FilterSearchForm.elements.length; i++)
{
if(document.FilterSearchForm.elements[i].type=="text")
{
var j=0;
var cInp = document.getElementById('Element_code_Query'+j);
//	cInp[i].setAttribute('name',"Element_code_Query"+count);
cInp[j].setAttribute('name',"Element_code_Query"+count);
count++;

	j++;
alert(document.FilterSearchForm.elements[i].name);
}
else if(document.FilterSearchForm.elements[i].type=="hidden")
{
//	alert(document.FilterSearchForm.elements[i].name);
}
}*/

var cSel = cRow.getElementsByTagName('select');


for(var i=0;i<cSel.length;i++)
	{


if(cSel[i].name.indexOf("Filter_subtype_desc_combo")!=-1)
	{
	
	cSel[i].setAttribute('name',(count)+"Filter_subtype_desc_combo");//change the selecet's name



//for(var l=0;l<document.getElementById(i+"Filter_subtype_desc_combo").length;l++)
	//{

//alert(document.getElementById(i+"Filter_subtype_desc_combo").value.length);

//	cSel[i].setAttribute("value", );
		//}
	}
	else if(cSel[i].name.indexOf("Filter_element_desc")!=-1)
	{

	cSel[i].setAttribute('name',(count)+"Filter_element_desc");
	//cSel[i].setAttribute("value", );
	}

	}

root.appendChild(cRow);


//appends the cloned row as a new row

}

/*function addRow()
{
         if (!document.getElementsByTagName) return;
         tabBody=document.getElementsByTagName("TBODY").item(0);
         //row=document.createElement("TR");
		 var allRows = root.getElementsByTagName('tr')
         cell1 = document.createElement("TD");
         cell2 = document.createElement("TD");
         textnode1=document.createTextNode(content);
         textnode2=document.createTextNode(morecontent);
         cell1.appendChild(textnode1);
         cell2.appendChild(textnode2);
         allRows.appendChild(cell1);
         row.appendChild(cell2);
         tabBody.appendChild(row);
       
   
}*/
function hide(element)
{
	
element.value=document.forms[0].element_field.value;


}
function delete1()
{
	
this.document.forms[0].actualmode.value='D';
this.document.forms[0].submit();

}
function recordU()
{

this.document.forms[0].actualmode.value='U';
//document.forms[0].count.value=count;
this.document.forms[0].submit();
}
