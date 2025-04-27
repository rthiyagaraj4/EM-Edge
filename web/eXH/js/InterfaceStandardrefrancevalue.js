function  func1(Segment_id,Element_id,Element_Seq,Default_value,Standard_code,element_name,control_elementId)
{
	alert(Element_id);
	mode='U';
	var url="";

url='&Segment_id='+Segment_id+'&Standard_code='+Standard_code+'&Element_id='+Element_id+'&Element_Seq='+Element_Seq+'&Default_value='+Default_value+'&element_name='+element_name+'&Mode='+mode+'&control_elementId='+control_elementId;
parent.frames[2].document.location.href="../../eXH/jsp/InterfacestandardctrlAdd.jsp?"+url;
}
function funSubmit2() 
{
	//var tabletextvalue=document.getElementById(k+"_C/E");
		//var tabletextvalue1=document.getElementById(k+"_EV");
		//	var tabletextvalue2=document.getElementById(k+"_EO");
			//	var tabletextvalue3=document.getElementById(k+"_EV2");
				//	var tabletextvalue4=document.getElementById(k+"_PO");
	//var elTableCells = this.document.ProfileRef.elTableRow.value;
//alert(tabletextvalue.value+"tabletextvalue1.value"+tabletextvalue1.value+"tabletextvalue.value"+tabletextvalue2.value+"tabletextvalue.value"+tabletextvalue3.value+"tabletextvalue.value"+tabletextvalue4.value);
var value='U';
var act="../../eXH/jsp/Protocollinkupdate.jsp?action_type="+value;
	this.document.forms[0].action = act;
  this.document.forms[0].action_type.value='U';
	this.document.forms[0].target='messageFrame';
	this.document.forms[0].submit();
	
	
	//var act="../../servlet/eXH.DataElementCrossRefSearchServlet?application_id="+application_id1+"&element_id="+element_id1;
	//this.document.forms[0].action = act;
  //this.document.forms[0].action_type.value='U';
	//this.document.forms[0].target='messageFrame';
	//this.document.forms[0].submit();
}
