var added_patfile_vol = new Map();
var added_rem_remarks= new Map();

function apply() 
{
	var to_proceed;
	var p_rec_count = 0;
	var doc_or_file = "";
	var cnt=0;
	if(parent.frames[2].frames[3].document.forms[0]) 
	{
		doc_or_file = parent.frames[2].frames[2].document.forms[0].p_maintain_doc_or_file.value;
		var obj = parent.frames[2].frames[3].document.forms[0]
		var p_req_no		 = "";
		var p_file_no		 = "";
		
		
		
		var p_volume_no		 = ""; 
		var p_remarks		 = "";
		var p_cancel_ch;
		var flag="false";
		var remarks="";
		var pat_file_volume="";
		var added_rem_rem_val=parent.frames[2].frames[2].document.forms[0].added_rem_remarks_values.value;
		var  added_rem_rem  =parent.frames[2].frames[2].document.forms[0].added_rem_remarks.value;
		 added_rem_remarks.clear();	
			for(var i = 1;i < obj.reccount.value;i++)
		{
			p_cancel_ch = eval("obj.cancelbox"+i+".checked");
			if (p_cancel_ch==true) 
			{
		   var pat_id=eval("obj.patient_id"+i+".value"); 
		   var pat_file_volume=pat_id+"`"+eval("obj.file"+i+".value")+"`"+eval("obj.volume"+i+".value"); 
	       		    
	       var patarray="";
	       var patfilevol="";
	       var patfilevol_item="";
		   var  patarray_val="";
	   		
		if(added_rem_rem!="" && added_rem_rem_val!="")
		 {  
	     patarray =added_rem_rem.split(",");
	     patarray_val =added_rem_rem_val.split(",");
	 			}
	  for(var j=0;j<=patarray.length;j++)
		{
		  patfilevol=patarray[j];
		  patfilevol_item=patarray_val[j];
		     if(!added_rem_remarks.has(patfilevol) && patfilevol_item!=undefined && patfilevol_item!="")
		   {	
				added_rem_remarks.set(patfilevol,patfilevol_item);
				  }
		  }
			if (added_rem_remarks.has(pat_file_volume))
	          {
	            var tempobj=added_rem_remarks.get(pat_file_volume);
				 	  if(eval('parent.frames[2].frames[3].document.forms[0].rem_recnum_'+i)!=undefined)
				     eval('parent.frames[2].frames[3].document.forms[0].rem_recnum_'+i).value=tempobj;
					}		
				
				
				
				if (p_file_no.length==0)
				{
					p_file_no = eval("obj.file"+i+".value");
					p_volume_no = eval("obj.volume"+i+".value"); 
					p_req_no = eval("obj.req_no"+i+".value");
					p_remarks = eval("obj.rem_recnum_"+i+".value");
				}
				else 
				{
					p_file_no = p_file_no+"`"+eval("obj.file"+i+".value");
					p_volume_no = p_volume_no+"`"+eval("obj.volume"+i+".value");
					p_req_no = p_req_no+"`"+eval("obj.req_no"+i+".value");
					p_remarks = p_remarks+"`"+eval("obj.rem_recnum_"+i+".value");
				}
				p_rec_count++;
			
				remarks=eval("obj.rem_recnum_"+i+".value");	
							
				if(remarks=="")
				{
				flag="true";
				cnt=i;
				}
					}
			}
	
		if(p_rec_count>0)
		{
 			to_proceed = true;
		}
		else
		{
			to_proceed = false;
		}	
		if(to_proceed == true)
		{
			obj.filenos.value		= p_file_no;
			obj.volumenos.value		= p_volume_no;
			obj.req.value			= p_req_no;
			obj.remarks.value		= p_remarks;
			obj.can_locn_code.value = parent.frames[2].frames[1].document.forms[0].hdrec_locn_code.value;
			
			if(flag=="true")
			{
            var fields = new Array ( parent.frames[2].frames[1].document.forms[0].username,eval('parent.frames[2].frames[3].document.forms[0].rem_recnum_'+cnt));
			var names = new Array ( getLabel("Common.name.label","common"),getLabel("Common.remarks.label","common"));
			}else{
			var fields = new Array ( parent.frames[2].frames[1].document.forms[0].username  );
			var names = new Array ( getLabel("Common.name.label","common") );
			}
			if(parent.frames[2].frames[1].checkFields( fields, names,messageFrame))
			{
				if (p_remarks.length>0)
				{
					obj.submit();
				}
				else
				{
					parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
				}
			}
		}
		else if(to_proceed == false)
		{	
			var	messag = "";
			if(doc_or_file =='D')
			{
				messag = getMessage("NO_DOC_FOR_CANCEL","FM");
			}
			else if(doc_or_file =='F')
			{
				messag = getMessage("NO_FILE_FOR_CANCEL","FM");
			}
			parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
		}
	}
	else
	{
		parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";	
	}
}
function selectVals()
{	
	document.getElementById("hdr_tab0").style.display = "" ;
	document.getElementById("hdr_tab").style.display = "" ;

	var obj						= parent.frames[1].document.forms[0];
	var LocnVal					= obj.fslocation.value;
	var file_type_appl_yn		= document.forms[0].file_type_appl_yn.value;
	var maintain_doc_or_file	= document.forms[0].p_maintain_doc_or_file.value;
	var obj					 = parent.frames[1].document.forms[0];
     var ReqDate				 = obj.receivedate.value;
	var patient_id			 = parent.frames[2].document.forms[0].patient_id.value;
	if(LocnVal != "") 
	{
		var recLocnArr	= LocnVal.split("!");
		var LocnCode	= recLocnArr[0];
		var LocnIden	= recLocnArr[1];

		if(maintain_doc_or_file == 'D')
			parent.frames[3].location.href = "../../eFM/jsp/DTCancelRequestDetail.jsp?FSLocation="+LocnCode;
		else if(maintain_doc_or_file == 'F')
		{
		parent.frames[3].location.href = "../../eFM/jsp/FMCancelRequestDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&RecDate="+ReqDate+"&patient_id="+patient_id;
		parent.frames[2].document.forms[0].patient_id.value="";
		if(parent.frames[2].document.forms[0].file_type_code)
		parent.frames[2].document.forms[0].file_type_code.value="";
		//parent.frames[2].document.forms[0].volume_no.value="";
		if(document.getElementById("volno"))
		document.getElementById("volno").innerHTML="<select name=volume_no ><option value=''>-----"+getLabel("Common.defaultSelect.label","common")+"-----</select>";
		parent.frames[2].document.forms[0].patient_id.focus();
		
		}
		parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
		parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
	}
	else 
	{
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
}

function AddFiles()
{
	if(document.getElementById("file_type_code").value !== ''){
		document.getElementById("hdr_tab0").style.display = "" ;
		document.getElementById("hdr_tab").style.display = "" ;		
	}
	var maintain_doc_or_file = document.forms[0].p_maintain_doc_or_file.value;
	var obj					 = parent.frames[1].document.forms[0];
	var p_select_file_no="";
	var pat_filevol=parent.frames[2].document.forms[0].pat_file_vol.value;
  if(maintain_doc_or_file == 'F')
	{
		var patient_id			 = parent.frames[2].document.forms[0].patient_id.value;
		var volume_no			 = parent.frames[2].document.forms[0].volume_no.value;
		var file_type_appl_yn	 = parent.frames[2].document.forms[0].file_type_appl_yn.value;
		var file_no                ="";
		if(parent.frames[2].document.forms[0].file_no)
		{
        file_no=parent.frames[2].document.forms[0].file_no.value;
		}
		if(file_no !="")
	{
		if(volume_no=="")
		{
		volume_no="1";
		}
	}	
		var LocnVal				 = obj.fslocation.value;
		var ReqDate				 = obj.receivedate.value;
		var filelistval		= "";
		var patientlistval	= "";
		var volumelistval	= "";
	    var  p_stored_val= parent.frames[2].document.forms[0].p_stored_val.value;
	if(patient_id=="")
		{
        

		}else
		{
           p_stored_val=p_stored_val+"/"+patient_id+"`"+volume_no;
		 }
		
		if(p_stored_val=="")
		{
        parent.frames[2].document.forms[0].p_stored_val.value = "";
		}else{
     parent.frames[2].document.forms[0].p_stored_val.value =p_stored_val;
		}
		
		
		if(LocnVal != "" )
		{
			var recLocnArr = LocnVal.split("!");
			var LocnCode = recLocnArr[0];
			var LocnIden = recLocnArr[1];
			var chkFields = "";
			var chkValues = "";
             
			if(file_type_appl_yn == 'N')
			{
				if(document.forms[0].file_no!=undefined)
				{
				chkFields = new Array(document.forms[0].patient_id, document.forms[0].file_no);
				chkValues = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));
				}else{
                chkFields = new Array(document.forms[0].patient_id);
				chkValues = new Array(getLabel("Common.patientId.label","common"));
				}
			
			}
			else if(file_type_appl_yn == 'Y')
			{
				if(document.forms[0].patient_file_type!=undefined)
				{
				chkFields = new Array(document.forms[0].patient_id, document.forms[0].patient_file_type);
				chkValues = new Array(getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));
				}else{
                chkFields = new Array(document.forms[0].patient_id);
				chkValues = new Array(getLabel("Common.patientId.label","common"));

				}
			
			}	
			if(checkFields( chkFields, chkValues, parent.messageFrame)) 
			{
				parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
				parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
				
				if(volume_no != "")
				{
					volumelistval =  parent.frames[2].document.forms[0].volumelistvals.value;
					if(volumelistval == "")
					{
						 parent.frames[2].document.forms[0].volumelistvals.value = "'"+volume_no+"'";
					}
					else
					{
						volumelistval += ",'"+volume_no+"'";
						 parent.frames[2].document.forms[0].volumelistvals.value = volumelistval;
					}
				}
				patientlistval =  parent.frames[2].document.forms[0].patientlistvals.value;
				if(patientlistval == "")
				{
					 parent.frames[2].document.forms[0].patientlistvals.value = "'"+patient_id+"'";
				}
				else
				{
					patientlistval += ",'"+patient_id+"'";
					 parent.frames[2].document.forms[0].patientlistvals.value = patientlistval;
				}
				if(file_type_appl_yn == 'N')
				{
					var file_no = parent.frames[2].document.forms[0].file_no.value;
					filelistval =  parent.frames[2].document.forms[0].filelistvals.value;
					if(filelistval == "")
					{
						 parent.frames[2].document.forms[0].filelistvals.value = "'"+file_no+"'";
					}
					else
					{
						filelistval += ",'"+file_no+"'";
						 parent.frames[2].document.forms[0].filelistvals.value = filelistval;
					}
					
						parent.frames[3].location.href = "../../eFM/jsp/FMCancelRequestDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&patient_id="+parent.frames[2].document.forms[0].patientlistvals.value+"&volume_no="+parent.frames[2].document.forms[0].volumelistvals.value+"&fileno="+parent.frames[2].document.forms[0].filelistvals.value+"&RecDate="+ReqDate+"&pat_file_vol="+pat_filevol+"&patient_id1="+patient_id+"&filenum="+file_no+"&volume_no1="+volume_no+"&p_stored_val="+p_stored_val;
				
				}
				else if(file_type_appl_yn == 'Y') 
				{
					var file_type_code = parent.frames[2].document.forms[0].patient_file_type.value;
					var file_faci=""; 
					var arg=file_type_code.split("~")
					file_type_code=arg[0];
					file_faci =arg[1];
					filelistval =  parent.frames[2].document.forms[0].filelistvals.value;
					if(filelistval == "")
					{
						 parent.frames[2].document.forms[0].filelistvals.value = "'"+file_type_code+"'";
					}
					else
					{
						filelistval += ",'"+file_type_code+"'";
						 parent.frames[2].document.forms[0].filelistvals.value = filelistval;
					}
					
				parent.frames[3].location.href = "../../eFM/jsp/FMCancelRequestDetail.jsp?file_type_appl_yn="+file_type_appl_yn+"&FSLocation="+LocnCode+"&patient_id="+parent.frames[2].document.forms[0].patientlistvals.value+"&volume_no="+parent.frames[2].document.forms[0].volumelistvals.value+"&file_type_code="+ parent.frames[2].document.forms[0].filelistvals.value+"&RecDate="+ReqDate+"&pat_file_vol="+pat_filevol+"&patient_id1="+patient_id+"&filetype="+file_type_code+"&volume_no1="+volume_no+"&file_faci="+file_faci+"&p_stored_val="+p_stored_val;
				}
			}
		}
	}
	else if(maintain_doc_or_file == 'D')
	{
		var document_folder_id		= parent.frames[2].document.forms[0].doc_folder_id.value;
		var document_type_code		= parent.frames[2].document.forms[0].doc_type_code.value;
		var file_no					= parent.frames[2].document.forms[0].file_no.value;
		var LocnVal					= obj.fslocation.value;
		var ReqDate					= obj.receivedate.value;
		var documentfolderlistvals	= "";
		var documenttypelistvals	= "";
		var filelistval				= "";
		
		if(LocnVal != "" )
		{
			var recLocnArr = LocnVal.split("!");
			var LocnCode = recLocnArr[0];
			var LocnIden = recLocnArr[1];
			var chkFields = "";
			var chkValues = "";

			chkFields = new Array(document.forms[0].doc_folder_id);
			chkValues = new Array(getLabel("eFM.DocumentFolder.label","FM"));
			
			if(checkFields( chkFields, chkValues, parent.messageFrame)) 
			{
				parent.frames[1].document.forms[0].hdrec_locn_code.value = LocnCode;
				parent.frames[1].document.forms[0].hdrec_locn_iden.value = LocnIden;
				
				filelistval =  parent.frames[2].document.forms[0].filelistvals.value;
				if(filelistval == "")
				{
					 parent.frames[2].document.forms[0].filelistvals.value = "'"+file_no+"'";
				}
				else
				{
					filelistval += ",'"+file_no+"'";
					 parent.frames[2].document.forms[0].filelistvals.value = filelistval;
				}
				documentfolderlistvals =  parent.frames[2].document.forms[0].documentfolderlistvals.value;
				if(documentfolderlistvals == "")
				{
					 parent.frames[2].document.forms[0].documentfolderlistvals.value = "'"+document_folder_id+"'";
				}
				else
				{
					 documentfolderlistvals += ",'"+document_folder_id+"'";
					 parent.frames[2].document.forms[0].documentfolderlistvals.value = documentfolderlistvals;
				}
				documenttypelistvals =  parent.frames[2].document.forms[0].documenttypelistvals.value;
				if(documenttypelistvals == "")
				{
					 parent.frames[2].document.forms[0].documenttypelistvals.value = "'"+document_type_code+"'";
				}
				else
				{
					documenttypelistvals += ",'"+document_type_code+"'";
					 parent.frames[2].document.forms[0].documenttypelistvals.value = documenttypelistvals;
				}
				parent.frames[3].location.href = "../../eFM/jsp/DTCancelRequestDetail.jsp?FSLocation="+LocnCode+"&doc_type_code="+document_type_code+"&pat_file_vol="+pat_filevol+"&doc_folder_id="+ parent.frames[2].document.forms[0].documentfolderlistvals.value+"&fileno="+parent.frames[2].document.forms[0].filelistvals.value+"&RecDate="+ReqDate;
			}
		}
	}
}
function selectValues()
{
	var obj = parent.frames[1].document.forms[0]
	if(obj.fslocation.value == "") 
	{
		var error = getMessage('REC_FS_LOCN_BLANK','FM');
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
	}
	else 
	{
		parent.frames[3].location.href = "../../eFM/jsp/FMCancelRequestDetail.jsp?FSLocation="+parent.frames[1].frames[1].document.forms[0].hdrec_locn_code.value;
	}
}
async function searchUser(target,fac_id) 
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit=getLabel("Common.user.label","common");

	tit=getLabel("Common.user.label","common");
	sql="Select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+fac_id+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();
	if(!(retVal == null))
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].username1.value=arr[0];
		document.forms[0].username.value=arr[1];
	}
}
async function GetRemarks(recnum)
{
	var dialogHeight	= "150px" ;
	var dialogWidth		= "500px" ;
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments		= "" ;
	//var tempobj			= eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum);
	var tempobj1		= eval('parent.frames[3].document.forms[0].p_req_remarks'+recnum);

	var curr_remarks	= "";
  	var file_no = document.getElementById('file' + recnum).value;
	var vol_no = document.getElementById('volume' + recnum).value;
	var pat_id = document.getElementById('patient_id' + recnum).value;

    var pat_file_volume=pat_id+"`"+file_no+"`"+vol_no; 
    var  added_rem_rem  =parent.frames[2].document.forms[0].added_rem_remarks.value;
	var added_rem_rem_val  =parent.frames[2].document.forms[0].added_rem_remarks_values.value;
	var patarray="";
	var patfilevol="";
	var patfilevol_item="";
	var tempobj="";
	var  patarray_val="";
	
	 
	 if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
			}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		     }
		}
	
	if (added_rem_remarks.has(pat_file_volume))
	{
	tempobj=added_rem_remarks.get(pat_file_volume);
	}
	if(tempobj==undefined || tempobj==null) tempobj="";

/*	if(tempobj.value == "")
		curr_remarks	= tempobj1.value;
	else
		curr_remarks	= tempobj.value; */

	if(tempobj == "")
		curr_remarks	= tempobj1.value;
	else
		curr_remarks	=tempobj;
	
	var title1= getLabel("Common.cancel.label","common")+ getLabel("eFM.RequestRemarks.label","FM");
	var retVal	= await window.showModalDialog('../../eFM/jsp/FMShowRemarks.jsp?title='+encodeURIComponent(title1)+'&chkBlank=true&curr_remarks='+encodeURIComponent(curr_remarks),arguments,features);
	
	if(!(retVal == null)) 
	{
	 	
	   tempobj	= unescape(retVal);
	     if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	     patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
			}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		    eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=patfilevol_item; 
			 }
		}
	
	//eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=unescape(retVal);
	
	// pat_file_volume=pat_file_volume;
	 if (!added_rem_remarks.has(pat_file_volume))
		   {	
			added_rem_remarks.set(pat_file_volume,tempobj);
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=tempobj; 
		   }
	if (added_rem_remarks.has(pat_file_volume))
		   {	
		 added_rem_remarks.delete(pat_file_volume);
		 added_rem_remarks.set(pat_file_volume,tempobj);
		eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=tempobj; 		
			  }
	var str=((added_rem_remarks.values()).toArray()).toString();
	var str1=str.replace(",,",",");
	var str2=((added_rem_remarks.keys()).toArray()).toString();
	var str3=str2.replace(",,",",");
	parent.frames[2].document.forms[0].added_rem_remarks.value=str3;
	 parent.frames[2].document.forms[0].added_rem_remarks_values.value=str1;
		
	}
	else if( retVal==undefined || retVal=="undefined")
	{
		//eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value="";
		//tempobj.value = " ";
     
	  tempobj	="" ;
	     if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
		}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol))
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=patfilevol_item; 
		   }
		}
	 
	 pat_file_volume=pat_file_volume;
	 if (!added_rem_remarks.has(pat_file_volume))
		   {	
			if(tempobj!=""){
			added_rem_remarks.set(pat_file_volume,tempobj);
			}
		   eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=""; 
		   }
	 if (added_rem_remarks.has(pat_file_volume))
		   {	
		 
		 added_rem_remarks.delete(pat_file_volume);
		// added_rem_remarks.add(pat_file_volume,tempobj);
		eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=""; 
		}
	 parent.frames[2].document.forms[0].added_rem_remarks.value= Array.from(added_rem_remarks.keys()).toString();
	 parent.frames[2].document.forms[0].added_rem_remarks_values.value=Array.from(added_rem_remarks.values()).toString();
	 added_rem_remarks.clear();
	
		 }
}
function cancelSelection(obj) 
{
   var rowIndex	=	obj.name.substring(9,obj.name.length);
	var file_no = document.getElementById('file' + recnum).value;
	var vol_no = document.getElementById('volume' + recnum).value;
	var pat_id = document.getElementById('patient_id' + recnum).value;

    var pat_file_volume=pat_id+"`"+file_no+"`"+vol_no; 
    var  pat_file_vol    =parent.frames[2].document.forms[0].pat_file_vol.value;
 	var patarray="";
   var patfilevol="";
    if (obj.checked == true) 
	{
		GetRemarks(+rowIndex);
		//eval("document.getElementById('td1"+rowIndex+"')").style.display="none";
		//eval("document.getElementById('td2"+rowIndex+"')").style.display="inline";
		//eval("document.getElementById('td2"+rowIndex+"')").style.visibility="visible";
		document.getElementById('td1' + rowIndex).style.display = "none";
		document.getElementById('td2' + rowIndex).style.display = "inline";
		document.getElementById('td2' + rowIndex).style.visibility = "visible";

	
	      if(pat_file_vol!="")
		  patarray =pat_file_vol.split(",");
				
		   if (!added_patfile_vol.has(pat_file_volume))
		   {	
			added_patfile_vol.set(pat_file_volume,pat_file_volume);
		   }
		
	 for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		 if (!added_patfile_vol.has(patfilevol))
		   {	
			added_patfile_vol.set(patfilevol,patfilevol);
		   }
		}
	
	parent.frames[2].document.forms[0].pat_file_vol.value=((added_patfile_vol.keys()).toArray()).toString();
	}
	else 
	{
		//eval("document.getElementById('td2"+rowIndex+"')").style.display="none";
		//eval("document.getElementById('td1"+rowIndex+"')").style.display="inline";
		//eval("document.getElementById('td1"+rowIndex+"')").style.visibility="visible";
	    document.getElementById('td2' + rowIndex).style.display = "none";
		document.getElementById('td1' + rowIndex).style.display = "inline";
		document.getElementById('td1' + rowIndex).style.visibility = "visible";

		 if(pat_file_vol!="")
		  patarray =pat_file_vol.split(",");
				
	  
	   for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		 if (!added_patfile_vol.has(patfilevol))
		   {	
			added_patfile_vol.set(patfilevol,patfilevol);
		   }
		}
	 if (added_patfile_vol.has(pat_file_volume))
		{
	    added_patfile_vol.delete(pat_file_volume);
		}
		 
	var  added_rem_rem  =parent.frames[2].document.forms[0].added_rem_remarks.value;
	var added_rem_rem_val  =parent.frames[2].document.forms[0].added_rem_remarks_values.value;
	var patarray="";
	var patfilevol="";
	var patfilevol_item="";
	var tempobj="";
	var  patarray_val="";	
	 
	 if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
	   patarray =added_rem_rem.split(",");
	   patarray_val =added_rem_rem_val.split(",");
			}
	for(var i=0;i<=patarray.length;i++)
		{
		  patfilevol=patarray[i];
		  patfilevol_item=patarray_val[i];
		 if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined && patfilevol_item!="")
		   {	
			added_rem_remarks.set(patfilevol,patfilevol_item);
		   
			 eval('parent.frames[3].document.forms[0].rem_recnum_'+recnum).value=patfilevol_item;
			 }
		}
	 
	 if (added_rem_remarks.has(pat_file_volume))
		{
	 	added_rem_remarks.delete(pat_file_volume);
		
		}
		
	 parent.frames[2].document.forms[0].pat_file_vol.value=Array.from(added_patfile_vol.keys()).toString();
	 parent.frames[2].document.forms[0].added_rem_remarks.value=Array.from(added_rem_remarks.keys()).toString();
	 parent.frames[2].document.forms[0].added_rem_remarks_values.value=Array.from(added_rem_remarks.values()).toString();
	
	}
	
}
function PopulateData(objval) 
{
	
	if(objval != '') 
	{
		
		var userSecurity = document.forms[0].userSecurity.value;
		var access_all	 = document.forms[0].access_all.value;
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMCancelRequestPopup.jsp?locn_code="+objval+"&userSecurity="+userSecurity+"&access_all="+access_all+"'></form></body></html>" ;
		parent.frames[4].document.write(HTMLVal) ;
		parent.frames[4].document.GetLocIdentity.submit() ;
		
	}
	else 
	{
		
		var len = parent.frames[1].CancelFilesHeader_form.document.forms[0].fslocation.length;
		for (var i=0; i<=len; i++) 
		{
			parent.frames[1].CancelFilesHeader_form.document.forms[0].fslocation.remove("fslocation");
		}
		var opt	= parent.frames[1].CancelFilesHeader_form.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "----- "+getLabel("Common.defaultSelect.label","common")+" -----";
		parent.frames[1].CancelFilesHeader_form.document.forms[0].fslocation.add(opt);
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
	
}
function showcriteria(ObjVal) 
{
	if(ObjVal == "")
	{	
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
	}
	else 
	{
		parent.frames[2].location.href = "../../eFM/jsp/FMCancelRequestCriteria.jsp";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	}
}
function ClearData() 
{
	var maintain_doc_or_file = document.forms[0].p_maintain_doc_or_file.value;
	parent.frames[2].document.getElementById("hdr_tab0").style.display = 'none';
	parent.frames[2].document.forms[0].volumelistvals.value="";
   parent.frames[2].document.forms[0].patientlistvals.value="";
	parent.frames[2].document.forms[0].filelistvals.value="";
	parent.frames[2].document.forms[0].p_stored_val.value="";
	parent.frames[2].document.forms[0].pat_file_vol.value="";
	parent.frames[2].document.forms[0].added_rem_remarks.value="";
	parent.frames[2].document.forms[0].added_rem_remarks_values.value="";
	parent.frames[2].document.forms[0].pat_file_vol.value="";
    added_rem_remarks.clear();
    added_patfile_vol.clear(); 
	
	if(maintain_doc_or_file == 'D')
		parent.frames[2].document.getElementById("hdr_tab1").style.display = 'none';
	else if(maintain_doc_or_file == 'F')
		parent.frames[2].document.getElementById("hdr_tab").style.display = 'none';
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
}

/******************* js of file FMCancelRequestRemarks.jsp *********************/
function doInit()
{
	var val 	= window.dialogArguments;
	val 		= ""+val+"";
	var index 	= -1;
	if ((val != '')||("undefined" != val))index = val.indexOf("^^^");
	if (index != -1)
	{
		document.getElementById("comments").value = val.substring(0,index);
		index += "^^^".length;
		var bool = val.substring(index,val.length);
		if (bool.toUpperCase() == 'TRUE')
		{
			document.getElementById("comments").readOnly = true;
		}
		document.getElementById("comments").focus();
	}else{
		if ("undefined" == val)document.getElementById("comments").value = '';
		else document.getElementById("comments").value = val;
		document.getElementById("comments").focus();
	}
	if(document.getElementById("comments").value == "")
		document.getElementById("comments").value = "<%=RemarksValue%>";
}

function checklength(){
	if (document.getElementById("comments").value.length > 100) {
	//	alert("APP-SM0045 - Remarks cannot exceed 100 characters");
		var rmarks = getMessage("REMARKS_CANNOT_EXCEED","common");
		rmarks=rmarks.replace('$',getLabel("Common.remarks.label","common"));
		rmarks=rmarks.replace('#',100);
		alert(rmarks);
		document.getElementById("comments").focus();
	}
}

function doClose(RemarksType)
{
	if (RemarksType=='C')
	{
		if (document.getElementById("comments").value.length < 1) {
			//alert("APP-SM0003 - Remarks cannot be blank"); 
			var rmarks1=getMessage("CAN_NOT_BE_BLANK","common");
			rmarks1=rmarks1.replace('$',getLabel("Common.remarks.label","common"));
			document.getElementById("comments").focus();
		}
		else {
			window.returnValue = document.getElementById("comments").value;
			window.close();
		}
	}
	else
	{
		window.close();
	}
}

function checkMaxLimit(obj,maxSize)
{
		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}

function closeWin()
{
	if(document.getElementById("comments").value.length > 0)
		window.returnValue = document.getElementById("comments").value;
	else
		window.returnValue ='';
		window.close();
}
/************************** END js of files FMCancelRequestRemarks.jsp ***************************/

function clearValues() 
{
	parent.frames[2].location.reload();
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
}
function reset() 
{
	parent.frames[2].frames[1].document.location.reload();
	parent.frames[2].frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[2].frames[3].document.location.href="../../eCommon/html/blank.html";
	parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num=";
}
function onSuccess() 
{
	/*parent.frames[1].frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[1].frames[3].location.href = '../../eCommon/html/blank.html';
	parent.frames[1].frames[1].location.href = '../../eFM/jsp/FMCancelRequestHeader.jsp';*/

	parent.frames[2].frames[1].document.location.reload();
	parent.frames[2].frames[2].document.location.href="../../eCommon/html/blank.html";
	parent.frames[2].frames[3].document.location.href="../../eCommon/html/blank.html";
}

function changeCursor(obj) 
{
	obj.style.cursor = "hand" ;
}

async function callPatDetails(Patient_ID) 
{
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}

async function showEncounter(enc,patid,fileno,Patient_Class)
{
	//alert(fileno);
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}

function setDate(Object)    { // function to set either Date of Birth or Day Month Age

       var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        }
    }
	}

