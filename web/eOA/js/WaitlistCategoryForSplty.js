function clearData()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;


}
function create()
{
f_query_add_mod.location.href = "../../eOA/jsp/WaitlistCategoryForSplty.jsp" ;
func="insert";

}

function reset()
{	
	
	if(frames[1].document.forms[0]!=null)
{ 
 frames[1].document.location.reload(); 
}else
	{
frames[1].frames[0].document.location.reload();
frames[1].frames[1].location.href='../../eCommon/html/blank.html'
}
}


function query()
{
f_query_add_mod.location.href = "../../eOA/jsp/WaitlistCategoryForSpltyQryCriteria.jsp" ;

}

function apply()
{
	if(frames[1].frames[1].document.forms[0])
	{
	 cnt =frames[1].frames[1].document.forms[0].n.value;
	  var splty="";
	  var splty1="";
	  var flag=true;
  for(i=0;i<cnt;i++)
 {
 if(eval("frames[1].frames[1].document.forms[0].strKey"+i+".checked"))
 {

 splty=eval("frames[1].frames[1].document.forms[0].strKey"+i+".value")
 
 splty1=splty1+splty+"~";

 }else
 {
	  flag=false;
 }
 }
frames[1].frames[1].document.forms[0].final_val.value = splty1;
if(frames[1].frames[1].document.forms[0].final_val.value=="" || frames[1].frames[1].document.forms[0].final_val.value==null)
{
	var msg = getMessage("ATLEAST_ONE_SELECTED","Common");
	frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg ;
}else
{
frames[1].frames[1].document.forms[0].splty.value=splty1;
frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=0" ;
frames[1].frames[1].document.forms[0].submit();
}
}
else
	{
		if(frames[1].frames[0].document.forms[0].waitlist_category_code.value=="null"|| frames[1].frames[0].document.forms[0].waitlist_category_code.value=="")
		{
			var error=getMessage("CAN_NOT_BE_BLANK",'Common');
			error=error.replace('$',getLabel("eOA.WaitlistCategory.label","OA"));
			alert(error);
			frames[1].frames[0].document.forms[0].waitlist_category_desc.focus();
			
			frames[0].document.location.reload(); 
			

		}else {
		frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;

		}
	
	}
}



function onSuccess()
{
 frames[1].frames[0].document.forms[0].waitlist_category_desc.value="";
 frames[1].frames[0].document.forms[0].waitlist_category_code.value="";
 frames[1].frames[1].document.location.href='../../eCommon/html/blank.html'

}

function colectWaitlistCatblur(obj,target_name,target_name1){
	if(target_name.value == ""){
		target_name.value="";
		target_name1.value="";
		parent.frames[1].document.location.href='../../eCommon/html/blank.html'
		return;
	 }else{
		colectWaitlistCat(obj,target_name,target_name1)
	 }
}
	
	
	

	
	

 async function colectWaitlistCat(obj,target,target1)
	{
			targ=target.value;
			
			//targ=eval("parent.frames[2].document.forms[0]."+target).value
			var dialogHeight= "40" ;
			var dialogWidth	= "60" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var retVal =    new String();
			var argumentArray=new Array();
           	var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit= getLabel("eOA.WaitlistCategory.label","OA");	
			sql="select WAITLIST_CATEGORY_CODE code,LONG_DESC description from OA_WAITLIST_CATEGORY where   upper(WAITLIST_CATEGORY_CODE) like upper(?)  and upper(LONG_DESC) like upper(?) and EFF_STATUS = 'E' order by 2";
			argumentArray[0] = sql ;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = targ;
			argumentArray[6] = CODE_LINK ;
			argumentArray[7] = CODE_DESC ;

			
			retVal = await CommonLookup( tit, argumentArray );
			var arr=new Array();
		if(retVal != null && retVal != '' && retVal != "null" )
		{
			var ret1=unescape(retVal);
			 arr=ret1.split(",");
			
	   		target1.value= arr[0];
		    target.value= arr[1];		
		}
		else
		{	
			target1.value= "";
		    target.value= "";		
		}
	}


	function  submitPage()
	{

	 var waitlist_category_code = document.forms[0].waitlist_category_code.value;
	 
	 if (waitlist_category_code=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace('$',getLabel("eOA.WaitlistCategory.label","OA"));
		 alert(error);
		 document.forms[0].waitlist_category_desc.focus();
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=" ;
		 return;
	}
		
		parent.frames[1].location.href = "../../eOA/jsp/WaitlistCategoryForSpltyResult.jsp?waitlist_category_code="+waitlist_category_code;
	
	
	}
function scrollTitle()
{
  var x = document.body.scrollTop;
  if(x == 0){

   document.getElementById("header").style.position='static';
   document.getElementById("header").style.posTop  = 0;

  }else{
	 
		document.getElementById("header").style.position = 'relative';
		document.getElementById("header").style.posTop  = x-2;
 
  }

}

function clear_result()
{
	    parent.frames[1].document.location.href='../../eCommon/html/blank.html'

}
