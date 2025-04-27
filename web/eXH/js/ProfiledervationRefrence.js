function searchElementID(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Element " ;
            var target=this.document.forms[0].element_desc;
            var element_id=this.document.forms[0].element_id;
			sql="SELECT ELEMENT_ID code,ELEMENT_NAME description FROM XH_ELEMENT_CROSSREF "+
                    "   WHERE UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
/*
			sql="select B.ELEMENT_ID,B.ELEMENT_NAME from xh_appl_derivation_rules A, "+
					"xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID and B.IN_USE_YN='Y' " +
					"AND UPPER(B.ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "UPPER(B.ELEMENT_NAME) LIKE UPPER(?) "+
                    "ORDER BY 1 ";
					"union " +
				"select ELEMENT_ID,ELEMENT_NAME from xh_element_crossref where ELEMENT_ID not in (select ELEMENT_ID from xh_appl_derivation_rules) "+
					"AND UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "ORDER BY 1 ";; 
*/
//	 alert("sql : "+sql);

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                element_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                element_id.value=tcode;
            }
}


function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	this.document.forms[0].target=''
	funSubmit();
}
function funSubmit()
{
	var act = '../../eXH/jsp/ProfileRefElementID1.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}

function searchProfileID(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Element " ;
            var target=this.document.forms[0].Profile_name;
            var Profile_id=this.document.forms[0].Profile_id;
			sql="SELECT PROFILE_ID code,SHORT_DESC description FROM XH_STANDARD_PROFILE "+
                    "   WHERE UPPER(PROFILE_ID) LIKE UPPER(?) AND "+ 
                    "           UPPER(SHORT_DESC) LIKE UPPER(?) "+
                    "           ORDER BY 1 ";
/*
			sql="select B.ELEMENT_ID,B.ELEMENT_NAME from xh_appl_derivation_rules A, "+
					"xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID and B.IN_USE_YN='Y' " +
					"AND UPPER(B.ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "UPPER(B.ELEMENT_NAME) LIKE UPPER(?) "+
                    "ORDER BY 1 ";
					"union " +
				"select ELEMENT_ID,ELEMENT_NAME from xh_element_crossref where ELEMENT_ID not in (select ELEMENT_ID from xh_appl_derivation_rules) "+
					"AND UPPER(ELEMENT_ID) LIKE UPPER(?) AND "+ 
                    "UPPER(ELEMENT_NAME) LIKE UPPER(?) "+
                    "ORDER BY 1 ";; 
*/
//	 alert("sql : "+sql);

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                this.document.forms[0].Profile_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                this.document.forms[0].Profile_id.value=tcode;
            }
}
/****************************Reset********************************************/
function reset()
{
	   // alert(window.f_query_add_mod.document.forms[0].name); 
		 
        if(window.f_query_add_mod.document.forms[0])
    {
		
	 window.f_query_add_mod.document.forms[0].reset();
	 //window.bodyframe.
	}

 
}

/****************************Apply********************************************/


function apply()
{
//var Searchvalue_set=this.window.bodyframe.applmenubar.document.application_element_setup_form.Action_code.value;
var action_Type=this.window.f_query_add_mod.document.application_element_setup_form.Action_code.value;
//var element_id =this.window.bodyframe.applmenubar.document.application_element_setup_form.element_desc.value;
if(action_Type=='U')
	{
	this.window.f_query_add_mod_detail.funSubmit2();
	}
else
	{
	}

window.commontoolbarFrame.document.location.reload();
 //window.f_query_add_mod.document.forms[0].reset();
 // window.f_query_add_mod_detail.document.forms[0].reset();
}
function funAdd(Action1)
{
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	document.forms[0].Action_code.value=Action1;
	var application_id=this.document.forms[0].Profile_id.value;
	var element_id= escape(this.document.forms[0].element_id.value);
var fields = new Array (  document.forms[0].Profile_name,
					     document.forms[0].element_desc				     
					   );


var names = new Array ( 
						getLabel("Common.Profile.label","common"),
						getLabel("Common.Element.label","common"));
if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{
	//parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?<%=params%>";
	}
	else
	{



this.parent.f_query_add_mod_detail.document.location.href="../../eXH/jsp/ProfileRefElementIDAddModify.jsp?application_id="+application_id+"&element_id="+element_id;
 //parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';

	

	}
	parent.commontoolbarFrame.document.location.reload();
}
function funSearch(Action)
{
document.forms[0].Action_code.value=Action;
var application_id=this.document.forms[0].Profile_id.value;
	var element_id= escape(this.document.forms[0].element_id.value);




	//this.document.forms[0].element_desc.value
//alert(document.forms[0].Action_code.value);
	//this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefBasicElement.jsp';
this.parent.f_query_add_mod_detail.document.location.href="../../eXH/jsp/ProfileRefElementID1.jsp?application_id="+application_id+"&element_id="+element_id;
    parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
 /*   this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/DataElementCrossRefElementID.jsp';
	this.document.forms[0].target='elementIDframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
*/
}
