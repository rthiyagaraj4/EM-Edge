function reset()
{
	/*var url=parent.frames[1].frames[1].location.href;

	if(url.indexOf('PatCatOrgMbspQueryCriteria.jsp')!=-1)
		query()
	else if(url.indexOf('PatCatOrgMbspMain.jsp')!=-1)
		create()*/
		main_frame.location.reload();
		sub_frame.location.href = "../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create" ;
		result_frame.location.href = "../../eCommon/html/blank.html" ;


//		if(url.indexOf('PatCatOrgMbspMain.jsp')==-1)
		
}
/*function query() 
{
	tempMainID.rows = '42,*,0,50';
	//tempID.cols = '0%,0%';
	main_frame.location.href = "../../eMP/jsp/PatCatOrgMbspQueryCriteria.jsp?param=query" ;
	sub_frame.location.href = "../../eMP/jsp/PatCatOrgMbspSub.jsp?param=query" ;
	//result_frame.location.href = "../../eCommon/html/blank.html" ;
}*/


function create() 
{
	//tempMainID.rows = '42,30,*,50';
	//tempID.cols = '50%,50%';
	//parent.frames[1].frames[1].location.href = "../../eMP/jsp/PatCatOrgMbspMain.jsp?param=create" ;
	//parent.frames[1].sub_frame.location.href = "../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create" ;

	main_frame.location.href = "../../eMP/jsp/PatCatOrgMbspMain.jsp?param=create" ;
	sub_frame.location.href = "../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create" ;
	result_frame.location.href = "../../eCommon/html/blank.html" ;
}

function validateFields(obj)
{
 if(obj.value=='4')
 {
	var opt  = parent.sub_frame.document.createElement("Option");
	opt.text= getLabel('Common.notapplicable.label','common');
	opt.value="*NA";
	parent.sub_frame.document.forms[0].organization.add(opt);

	var opt  = parent.sub_frame.document.createElement("Option");
	opt.text=getLabel('Common.notapplicable.label','common');
	opt.value="*NA";
	parent.sub_frame.document.forms[0].sub_org.add(opt);

	parent.sub_frame.document.forms[0].organization.value = "*NA";
	parent.sub_frame.document.forms[0].sub_org.value = "*NA";
	parent.sub_frame.document.forms[0].prefix.value = "*ALL";

	parent.sub_frame.document.forms[0].organization.disabled = true;
	parent.sub_frame.document.forms[0].sub_org.disabled = true;
	parent.sub_frame.document.forms[0].prefix.disabled = true;
	parent.sub_frame.document.getElementById("orgimage").style.visibility='hidden';
	parent.sub_frame.document.getElementById("suborgimage").style.visibility='hidden';
	parent.sub_frame.document.getElementById("nprefimage").style.visibility='hidden';
	parent.sub_frame.document.forms[0].relationship.selectedIndex=0;

 }
 else
{
	var len1 = parent.sub_frame.document.forms[0].organization.length;
	var len2 = parent.sub_frame.document.forms[0].sub_org.length;

	if(len1>1)
	parent.sub_frame.document.forms[0].organization.remove(len1-1);

	if(len2>1)
	parent.sub_frame.document.forms[0].sub_org.remove(len2-1);

	parent.sub_frame.document.forms[0].organization.disabled = false;
	parent.sub_frame.document.forms[0].sub_org.disabled = false;
	parent.sub_frame.document.forms[0].prefix.disabled = false;

	parent.sub_frame.document.forms[0].organization.value = "";
	parent.sub_frame.document.forms[0].sub_org.value = "";
	parent.sub_frame.document.forms[0].prefix.value = "";
	parent.sub_frame.document.getElementById("orgimage").style.visibility='visible';
	parent.sub_frame.document.getElementById("suborgimage").style.visibility='visible';
	parent.sub_frame.document.getElementById("nprefimage").style.visibility='visible';
	parent.sub_frame.document.forms[0].relationship.selectedIndex=0;
}
}

function apply()
{
	var url = main_frame.location.href;
	if  ( (url.indexOf('blank.html')!=-1))
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
	}
	else
	{
				sub_frame.document.forms[0].organization_hid.value = sub_frame.document.forms[0].organization.value;
				sub_frame.document.forms[0].sub_org_hid.value = sub_frame.document.forms[0].sub_org.value;
				sub_frame.document.forms[0].prefix_hid.value = sub_frame.document.forms[0].prefix.value;
				sub_frame.document.forms[0].cat_value.value = frames[1].document.forms[0].category.value;




	var fields = new Array(
				sub_frame.document.forms[0].membership,
				sub_frame.document.forms[0].organization,
	 	     	sub_frame.document.forms[0].sub_org,
				sub_frame.document.forms[0].prefix,
				sub_frame.document.forms[0].relationship
			      );

	var names = new Array (	getLabel('eMP.membership.label','MP'),
				getLabel('Common.Organization.label','Common'),
				getLabel('eMP.suborgn.label','MP'),
				getLabel('Common.name.label','common')+" "+ getLabel('eMP.prefix.label','MP'),
				getLabel('Common.relationship.label','common')
			      )

	if(sub_frame.checkFieldsofMst( fields, names,messageFrame))
	{
		sub_frame.document.forms[0].submit();
	}

//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	}
}

function onSuccess()
{
	//parent.frames[1].main_frame.location.href = "../../eMP/jsp/PatCatOrgMbspMain.jsp?param=create" ;
	sub_frame.location.href = "../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create&mode=insert&from=success";
	result_frame.location.reload();
		//href = "../../eCommon/html/blank.html" ;
}

function generateSubOrg(orgddd,subid,flag,condition)
{
	var HTMLVal = new String();
	var org = document.forms[0].organization.value;
	var org_value=document.forms[0].organization;
	var family_org_sub_id_code_up=subid;
	

	if(org_value.value=="")
	{
		var n=parent.sub_frame.document.forms[0].sub_org.length;

		for(var i=0;i<n;i++)
		{
			parent.sub_frame.document.forms[0].sub_org.remove(0);
		}
		var tp =" --------- "+getLabel("Common.defaultSelect.label","Common")+" ---------- "
		var opt=parent.sub_frame.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.sub_frame.document.forms[0].sub_org.add(opt);
	}
	else
	if(org_value.value=="*ALL")
	{
		var n=parent.sub_frame.document.forms[0].sub_org.length;

		for(var i=0;i<n;i++)
		{
			parent.sub_frame.document.forms[0].sub_org.remove(0);
		}
		var tp =" --------- "+getLabel("Common.defaultSelect.label","Common")+" ---------- "
		var opt=parent.sub_frame.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.sub_frame.document.forms[0].sub_org.add(opt);

		var opt1=parent.sub_frame.document.createElement("OPTION");
		opt1.text=getLabel('Common.all.label','common');
		opt1.value="*ALL";
		parent.sub_frame.document.forms[0].sub_org.add(opt1);
		if(condition=='NORMAL'){
			
          document.forms[0].sub_org.value='*ALL'
		 
		}
		

	}
	else
	if(org_value !="")
	{
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatCatOrgMbspValidation.jsp'><input type='hidden' name='organization' id='organization' value='"+org+"'><input type='hidden' name='param' id='param' value='"+flag+"'><input type='hidden' name='subid' id='subid' value='"+subid+"'></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();

		if(family_org_sub_id_code_up=='*ALL'){
		
			document.forms[0].sub_org.selectedIndex=0
		}
	}
	
	
}

function displayresult()
{
	var category		= document.forms[0].category.value
	var membership		= document.forms[0].membership.value
	var organization	= document.forms[0].organization.value
	var sub_org			= document.forms[0].sub_org.value
	var prefix			= document.forms[0].prefix.value
	var relationship	= document.forms[0].relationship.value


	parent.frames[1].location.href = 	"../../eMP/jsp/PatCatOrgMbspDtls.jsp?param=QUERY&category="+category+"&membership="+membership+"&organization="+organization+"&sub_org="+sub_org+"&prefix="+prefix+"&relationship="+relationship;
}


function LoadResultPage(obj)
{
	if(obj.value!="")
	{
	parent.sub_frame.document.forms[0].Clear.disabled = false;
	//parent.sub_frame.document.forms[0].Record.disabled = false;

	parent.sub_frame.document.forms[0].membership.disabled = false;
	parent.sub_frame.document.forms[0].organization.disabled = false;
	parent.sub_frame.document.forms[0].sub_org.disabled = false;
	parent.sub_frame.document.forms[0].prefix.disabled = false;
	parent.sub_frame.document.forms[0].relationship.disabled = false;


     parent.sub_frame.document.forms[0].membership.selectedIndex = 0
	parent.sub_frame.document.forms[0].organization.selectedIndex = 0
	parent.sub_frame.document.forms[0].sub_org.selectedIndex = 0
	parent.sub_frame.document.forms[0].prefix.selectedIndex = 0
	parent.sub_frame.document.forms[0].relationship.selectedIndex = 0

	 parent.sub_frame.document.getElementById("orgimage").style.visibility='visible';
	parent.sub_frame.document.getElementById("suborgimage").style.visibility='visible';
	parent.sub_frame.document.getElementById("nprefimage").style.visibility='visible';
   
	parent.sub_frame.document.forms[0].cat_value.value = obj.value;

	var category = obj.value;
	//parent.sub_frame.location.href="../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create";
	parent.result_frame.location.href = 	"../../eMP/jsp/PatCatOrgMbspDtls.jsp?param=CREATE&category="+category ;
	}
	else
	if(obj.value=="")
	{
		parent.sub_frame.document.forms[0].membership.disabled = true;
		parent.sub_frame.document.forms[0].organization.disabled = true;
		parent.sub_frame.document.forms[0].sub_org.disabled = true;
		parent.sub_frame.document.forms[0].prefix.disabled = true;
		parent.sub_frame.document.forms[0].relationship.disabled = true;

		parent.sub_frame.document.forms[0].membership.value = "";
		parent.sub_frame.document.forms[0].organization.value = "";
		parent.sub_frame.document.forms[0].sub_org.value = "";
		parent.sub_frame.document.forms[0].prefix.value = "";
		parent.sub_frame.document.forms[0].relationship.value = "";

		parent.sub_frame.document.forms[0].Clear.disabled = true;
		//parent.sub_frame.document.forms[0].Record.disabled = true;

		parent.sub_frame.document.forms[0].cat_value.value = obj.value;

		parent.result_frame.location.href = "../../eCommon/html/blank.html" ;
	}
}

function LoadResultPage_query(obj)
{
	
    document.forms[0].membership.selectedIndex = 0
	document.forms[0].organization.selectedIndex = 0
	document.forms[0].sub_org.selectedIndex = 0
	document.forms[0].prefix.selectedIndex = 0
	document.forms[0].relationship.selectedIndex = 0
		var n=document.forms[0].sub_org.length;

		for(var i=0;i<n;i++)
		{
			document.forms[0].sub_org.remove(0);
		}
		var tp =" ----- "+getLabel("Common.defaultSelect.label","Common")+" ------ "
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.forms[0].sub_org.add(opt);
		

	
}

function clearvalues1(obj)
{
	document.forms[0].organization.selectedIndex = 0
	document.forms[0].sub_org.selectedIndex = 0
	document.forms[0].prefix.selectedIndex = 0
	document.forms[0].relationship.selectedIndex = 0
		var n=document.forms[0].sub_org.length;

		for(var i=0;i<n;i++)
		{
			document.forms[0].sub_org.remove(0);
		}
		var tp =" ----- "+getLabel("Common.defaultSelect.label","Common")+" ------ "
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.forms[0].sub_org.add(opt);

}

function validate_query()
{
	var opt  = parent.sub_frame.document.createElement("Option");
	opt.text=getLabel('Common.notapplicable.label','common');
	opt.value="*NA";
	parent.sub_frame.document.forms[0].organization.add(opt);

	var opt  = parent.sub_frame.document.createElement("Option");
	opt.text=getLabel('Common.notapplicable.label','common');
	opt.value="*NA";
	parent.sub_frame.document.forms[0].sub_org.add(opt);

	parent.sub_frame.document.forms[0].organization.value = "*NA";
	parent.sub_frame.document.forms[0].sub_org.value = "*NA";
	parent.sub_frame.document.getElementById("orgimage").style.visibility='hidden';
	parent.sub_frame.document.getElementById("suborgimage").style.visibility='hidden';
	parent.sub_frame.document.getElementById("nprefimage").style.visibility='hidden';
}

