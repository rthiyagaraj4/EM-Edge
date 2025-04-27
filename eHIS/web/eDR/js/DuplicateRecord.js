
	// this function is called when the duplicate patient id is clicked
		function show_dup(pat1,pat2,title){
		var dialogHeight= "13" ;
		var dialogWidth	= "40" ;
		var dialogTop="30";
		var dialogLeft="100";
		var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes" ;
		window.showModalDialog('../../eDR/jsp/PossibleDuplicateDisplayFrameset.jsp?patient_id1='+pat1+'&patient_id2='+pat2+'&title='+title,arguments,features);
		
		}
		
		var prev=0;// changing the row color
		var i=0;
		function changeRowColor(obj,n)
		{
			
		for(i=0;i<n;i++)
			document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
		for(i=0;i<n;i++)
			obj.cells(i).style.backgroundColor="LIGHTPINK";
		prev	=obj.rowIndex;
		

		}
		// this is called when the question mark is pressed
		function patient_search(file)
		{
		var patient_id = PatientSearch();
		document.location.href="../../eDR/jsp/"+file+".jsp?patient_id="+patient_id;
		}
		
		// this is called when the modal window is closed
		function modal_close(){
		//parent.window.close();
			const dialogTag = parent.parent.document.getElementById('dialog_tag');    
		    dialogTag.close();   
		}

		

function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}
