function create() 
{
	relnshp_lvl_crtra.location.href = "../../eMP/jsp/RelationshipLevelCriteria.jsp?mode=insert";
	relnshp_lvl_add_mod.location.href = "../../eCommon/html/blank.html";
	relnshp_lvl_res.location.href = "../../eCommon/html/blank.html";	
}

function checkIsValidForProceed()
{
 var url = relnshp_lvl_res.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}

function reset() {

	 relnshp_lvl_crtra.document.location.reload();
	 relnshp_lvl_add_mod.location.href = "../../eCommon/html/blank.html";
	 relnshp_lvl_res.location.href = "../../eCommon/html/blank.html";
}

function onSuccess() {
	relnshp_lvl_crtra.location.reload();
	relnshp_lvl_res.document.location.href = "../../eCommon/html/blank.html";
	relnshp_lvl_add_mod.document.location.href = "../../eCommon/html/blank.html";
}

function apply()
{
	/*if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }*/

			if(relnshp_lvl_crtra.document.forms[0])
			{
				if(relnshp_lvl_crtra.document.reln_crtra_form.relationship_desc.value=="")
				{
					var errors1=getMessage("CAN_NOT_BE_BLANK","Common");
					errors1=errors1.replace('$',getLabel("Common.relationship.label","Common"));
					frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+ errors1;
					return;
				}
			
				if(relnshp_lvl_crtra.document.reln_crtra_form.linked_relationship_desc)
				{
					if(relnshp_lvl_crtra.document.reln_crtra_form.linked_relationship_desc.value=="")
					{
						var errors1=getMessage("CAN_NOT_BE_BLANK","Common");
						errors1=errors1.replace('$',getLabel("eMP.LinkedRelnshp.label","mp"));
						frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+ errors1;
						return;
					}
				}
			}
			else
			{
				frames[0].document.location.reload();
				return;
			}

			if(!frames[2].document.forms[0])
			{
					var relationship_lev=frames[3].document.forms[0].relationship_level.value;
					if(relationship_lev=='1') 
					{
						fields = new Array ( frames[3].document.forms[0].relationship_level_code,frames[3].document.forms[0].relationship_level_desc);
						names = new Array(getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
					}
					else if(relationship_lev=='2')
					{
						fields = new Array (frames[3].document.forms[0].relationship_level_code,frames[3].document.forms[0].relationship_level_desc,
							frames[3].document.forms[0].linked_relnship_level_desc);

						names = new Array(getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("eMP.LinkedRelnshpLevel.label","MP"));
					}
					checkFields(fields,names,messageFrame);
			}

			if(frames[2].document.forms[0])
			{
				rec_cnt = frames[2].document.forms[0].rec_cnt.value;
				relationship_level = frames[2].document.forms[0].relationship_level.value;	

				var save_flag = false;

				for(i=0;i<rec_cnt;i++)
				{	
					if(eval("frames[2].document.forms[0].insert_chk"+i))
					{			
						if(eval("frames[2].document.forms[0].insert_chk"+i).checked==true)
						{
							chk_flag = frames[2].document.forms[0].checked_flag.value;

							if(chk_flag=='')
								chk_flag = i+"~"+"Y|";
							else
								chk_flag = chk_flag +i+"~"+"Y|";

							frames[2].document.forms[0].checked_flag.value = chk_flag;

							save_flag = true;
						}
						else if( eval("frames[2].document.forms[0].insert_chk"+i).checked == false )
						{
							chk_flag = frames[2].document.forms[0].checked_flag.value;

							if(chk_flag=='')
								chk_flag = i+"~"+"N|";
							else
								chk_flag = chk_flag +i+"~"+"N|";

							frames[2].document.forms[0].checked_flag.value = chk_flag;
						}
					}

					if(relationship_level == "1")
						i=i+2;
					else if(relationship_level == "2")
						i=i+4;
				  }	
				
	
			if(save_flag == true)
			{
				frames[2].document.relnshiplvl_result_form.submit();
			}
			else {
				var err = getMessage('NO_CHANGE_TO_SAVE','COMMON');
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err+'&err_value=0';
			}	
		} else {
			var err = getMessage('NO_CHANGE_TO_SAVE','COMMON');
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err+'&err_value=0';
		}
	
}

function chkValue(obj,pos)
{
	
	if(obj.checked==true)
	{
		obj.value='Y';		
	}
	else if(obj.checked==false)
	{
		obj.value='N';		
	}			
}
function onblurgetRelation(obj,target)
{
   if(target.value=="" && obj.name=="linked_relationship_code"){
		 parent.frames[2].location.href= "../../eCommon/html/blank.html";
		 //parent.frames[3].document.location.reload();
		 parent.frames[3].document.forms[0].relationship_level_code.value="";
		 parent.frames[3].document.forms[0].relationship_level_desc.value="";
		 parent.frames[3].document.forms[0].linked_relnship_level_desc.value="";
		 parent.frames[3].document.forms[0].linked_relnship_level_code.value= '';
		 obj.value="";
		 target.value="";
   }
   else if(target.value=="" && obj.name=="relationship_code"){
	       parent.frames[1].document.getElementById("relnlabel").innerHTML="";
		   parent.frames[1].document.getElementById("relntext").innerHTML="";
           parent.frames[2].location.href= "../../eCommon/html/blank.html";
		   parent.frames[3].location.href= "../../eCommon/html/blank.html";
   }
   else
	   getRelation(obj,target);
}

async function getRelation(obj,target)
{		
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var tit="";	
	var sql= "";
	var linked_relationship_code = "";
	

	if(parent.frames[1].document.forms[0].linked_relationship_code)	
	{
		linked_relationship_code = parent.frames[1].document.forms[0].linked_relationship_code.value;
	}

	if(target.name == 'relationship_desc')
	{
		tit=getLabel("Common.relationship.label","common");

		sql="select relationship_code code,short_desc description from mp_relationship where upper(relationship_code) like upper(?) and upper(short_desc) like upper(?) and relationship_level > 0 and eff_status='E' order by 2";

	}
	else if(target.name == 'linked_relnship_level_desc')
	{
		tit=getLabel("eMP.LinkedRelnshpLevel.label","mp");

		sql="Select RELATIONSHIP_LEVEL_CODE code, RELATIONSHIP_LEVEL_DESC description from MP_RELATIONSHIP_LEVEL where RELATIONSHIP_CODE='"+linked_relationship_code+"' AND ASSOCIATED_RELATIONSHIP_CODE IS NULL AND RELATIONSHIP_LEVEL_CODE2 IS NULL and  upper(RELATIONSHIP_LEVEL_CODE) like upper(?) and upper(RELATIONSHIP_LEVEL_DESC) like upper(?) order by 2";

	}
	else if(target.name == 'linked_relationship_desc')
	{
		
		tit=getLabel("eMP.LinkedRelnshp.label","mp");

		sql="Select relationship_code code,short_desc description from mp_relationship where RELATIONSHIP_LEVEL=1 and upper(RELATIONSHIP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) and eff_status='E' order by 2";		
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );	
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		if(target.name == 'relationship_desc')
		{
			document.forms[0].relationship_code.value= arr[0];
			populateRelation();		
		}
		else if(target.name == 'linked_relnship_level_desc')
		{
			document.forms[0].linked_relnship_level_code.value= arr[0];
		}
		else if(target.name == 'linked_relationship_desc')
		{
			document.forms[0].linked_relationship_code.value= arr[0];	
			
			var relationship_code=document.forms[0].relationship_code.value;
			parent.frames[3].location.href = "../../eMP/jsp/RelationshipLevelAddModify.jsp?relationship_code="+relationship_code+"&mode=update"+"&linked_relationship_code="+arr[0]+"&linked_relationship_desc="+arr[1];

			loadResultPage();
		}		
	}
	else
	{        
		target.value='';

		if(target.name == 'relationship_desc')
		{
			document.forms[0].relationship_code.value= '';	
		   parent.frames[1].document.getElementById("relnlabel").innerHTML="";
		   parent.frames[1].document.getElementById("relntext").innerHTML="";
           parent.frames[2].location.href= "../../eCommon/html/blank.html";
		   parent.frames[3].location.href= "../../eCommon/html/blank.html";
		}
		else if(target.name == 'linked_relnship_level_desc')
		{
			document.forms[0].linked_relnship_level_code.value= '';
		}
		else if(target.name == 'linked_relationship_desc')
		{
			document.forms[0].linked_relationship_code.value= '';
	        parent.frames[2].location.href= "../../eCommon/html/blank.html";
			parent.frames[3].document.forms[0].relationship_level_code.value="";
		    parent.frames[3].document.forms[0].relationship_level_desc.value="";
		    parent.frames[3].document.forms[0].linked_relnship_level_desc.value="";
			parent.frames[3].document.forms[0].linked_relnship_level_code.value= '';
		}		
	}
	
}

function loadResultPage()
{
	var linked_relationship_code = "";
	var linked_relationship_desc = "";
	var relationship_level = "";

	var relationship_code=document.forms[0].relationship_code.value;
	
	if(parent.frames[3].document.forms[0].relationship_level)
		relationship_level=parent.frames[3].document.forms[0].relationship_level.value;
	

	if(document.forms[0].linked_relationship_code)
	{
		linked_relationship_code = document.forms[0].linked_relationship_code.value;	
		linked_relationship_desc = document.forms[0].linked_relationship_desc.value;	
	}

	parent.frames[2].location.href ="../../eMP/jsp/RelationshipLevelResults.jsp?relationship_code="+relationship_code+"&linked_relationship_code="+linked_relationship_code+"&mode=update"+"&relationship_level="+relationship_level+"&linked_relationship_desc="+linked_relationship_desc;

}

function populateRelation()
{
	
	var relationship_code=document.forms[0].relationship_code.value;
	
	parent.frames[3].location.href = "../../eMP/jsp/RelationshipLevelAddModify.jsp?relationship_code="+relationship_code+"&mode=update";	
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
	parent.frames[4].location.href ="../../eCommon/jsp/error.jsp";
}

function addPanel()
{

	var linked_relationship_desc = "";
	var linked_relationship_code = "";
	var linked_relnship_level_code = "";
	var linked_relnship_level_desc = "";
	var fields = "";
	var names = "";

	var relationship_code=document.forms[0].relationship_code.value;	
    var relationship_level_code= document.forms[0].relationship_level_code.value;
	var relationship_level_desc= document.forms[0].relationship_level_desc.value;
	var relationship_level=document.forms[0].relationship_level.value;	
  
	if(parent.frames[1].document.forms[0].linked_relationship_desc)
	{
	  linked_relationship_desc=parent.frames[1].document.forms[0].linked_relationship_desc.value;	
	  linked_relationship_code=parent.frames[1].document.forms[0].linked_relationship_code.value;	
	}

    if(document.forms[0].linked_relnship_level_code)
	{		
		linked_relnship_level_code= document.forms[0].linked_relnship_level_code.value;
		linked_relnship_level_desc= document.forms[0].linked_relnship_level_desc.value;
	}	

	messageFrame = parent.frames[4];
	
    if(relationship_level=='1') 
	{
		fields = new Array ( document.forms[0].relationship_level_code,document.forms[0].relationship_level_desc);
		names = new Array(getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
	}
	else if(relationship_level=='2')
	{
		fields = new Array (document.forms[0].relationship_level_code,document.forms[0].relationship_level_desc,
			document.forms[0].linked_relnship_level_code);

		names = new Array(getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("eMP.LinkedRelnshpLevel.label","MP"));
	}
	    
	if(checkFields(fields,names,messageFrame)) 
	{		
		if(parent.frames[1].document.forms[0].linked_relationship_desc)
			linked_relationship_desc=parent.frames[1].document.forms[0].linked_relationship_desc.value;
		parent.frames[2].location.href="../../eMP/jsp/RelationshipLevelResults.jsp?relationship_code="+relationship_code+"&relationship_level_code="+relationship_level_code+"&relationship_level_desc="+relationship_level_desc+"&linked_relnship_level_code="+linked_relnship_level_code+"&relationship_level="+relationship_level+"&mode=add&linked_relnship_level_desc="+linked_relnship_level_desc+"&linked_relationship_desc="+linked_relationship_desc+"&linked_relationship_code="+linked_relationship_code;	

		clearFields();	
	}
	else 
	{
		return false;
	}
}


function clearFields()
{
	var relationship_code=document.forms[0].relationship_code.value;

	var linked_relationship_code = "";
	var linked_relationship_desc = "";

	if(parent.frames[1].document.forms[0].linked_relationship_code)
	{
		linked_relationship_code = parent.frames[1].document.forms[0].linked_relationship_code.value;
		linked_relationship_desc = parent.frames[1].document.forms[0].linked_relationship_desc.value;
	}

	parent.frames[3].location.href = "../../eMP/jsp/RelationshipLevelAddModify.jsp?relationship_code="+relationship_code+"&mode=add"+"&linked_relationship_code="+linked_relationship_code+"&linked_relationship_desc="+linked_relationship_desc;

	//messageFrame.location.href='../../eCommon/jsp/error.jsp';
	
}
function modify()
{
	var linked_relationship_desc = "";
	var linked_relationship_code = "";
	var linked_relnship_level_code = "";
	var linked_relnship_level_desc = "";

	var fields = "";
	var names = "";

	var relationship_level_code= document.forms[0].relationship_level_code.value;
	var relationship_level_desc= document.forms[0].relationship_level_desc.value;
	var relationship_level=document.forms[0].relationship_level.value;
	var relationship_code=document.forms[0].relationship_code.value;	

	if(parent.frames[1].document.forms[0].linked_relationship_desc)
	{
		linked_relationship_desc=parent.frames[1].document.forms[0].linked_relationship_desc.value;		
		linked_relationship_code=parent.frames[1].document.forms[0].linked_relationship_code.value;		
	}

    if(document.forms[0].linked_relnship_level_code)
	{		
		linked_relnship_level_code= document.forms[0].linked_relnship_level_code.value;
		linked_relnship_level_desc= document.forms[0].linked_relnship_level_desc.value;
	}		

	messageFrame = parent.frames[4];
	
    if(relationship_level=='1') 
	{
		fields = new Array ( document.forms[0].relationship_level_code,document.forms[0].relationship_level_desc);
		names = new Array(getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
	}
	else if(relationship_level=='2')
	{
		fields = new Array (document.forms[0].relationship_level_code,document.forms[0].relationship_level_desc,
			document.forms[0].linked_relnship_level_code);

		names = new Array(getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("eMP.LinkedRelnshpLevel.label","MP"));
	}
	    
	if(checkFields(fields,names,messageFrame)) 
	{		
		if(parent.frames[1].document.forms[0].linked_relationship_desc)
			linked_relationship_desc=parent.frames[1].document.forms[0].linked_relationship_desc.value;
		if(parent.frames[3].document.forms[0].srno)
			var srno=parent.frames[3].document.forms[0].srno.value;	
		
		parent.frames[2].location.href="../../eMP/jsp/RelationshipLevelResults.jsp?relationship_code="+relationship_code+"&relationship_level_code="+relationship_level_code+"&relationship_level_desc="+relationship_level_desc+"&linked_relnship_level_code="+linked_relnship_level_code+"&relationship_level="+relationship_level+"&mode=modify&linked_relnship_level_desc="+linked_relnship_level_desc+"&linked_relationship_desc="+linked_relationship_desc+"&srno="+srno+"&linked_relationship_code="+linked_relationship_code;	

		clearFields();

	}
	else 
	{
		return false;
	}
	
}
