//******************************************************************/
//function onSelectAppliction
//******************************************************************/
function onSelectAppliction()
{
	alert("onSelectAppliction");


//applicationid='+appl;

//this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefElementID.jsp?applicationid='+appl;

this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefElementID.jsp';
parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';

}													 


//********************************************************************************************
//function searchElementID
//*******************************************************************************************

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
}// End of searchElementID

//******************************************************************/
//function callJSPs
//******************************************************************/
/*
function callJSPs(str)
{

	var tab11=document.getElementById("tab1");
	var tabspan1=document.getElementById("tab1_tabspan");
	var tab22=document.getElementById("tab2");
	var tabspan2=document.getElementById("tab2_tabspan");
	var tab33=document.getElementById("tab3");
	var tabspan3=document.getElementById("tab3_tabspan");

	var appl =  this.document.forms[0].application.value;
	var code_yn=this.document.forms[0].code.value;
	
	if (appl == '')
	{
		alert(getMessage('XH1003','XH'));
		return;
	}

	if(str!='tab1'){
	if(code_yn=='Y'){
	if(str=='tab2')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefModuleCodeSetupMain.jsp?application='+appl;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	if(str=='tab3')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='non_table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabClicked';
		tabspan3.className='tabSpanclicked';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetupMain.jsp?application='+appl;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	}
	else{
               alert(getMessage("XH1031","XH"));
	           this.document.forms[0].focus();
	           return false;

	      }
	}

    if(str=='tab1')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='usage';
		tab11.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
		//onPage(0);
      this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetup.jsp?applicationid='+appl;
  	  parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	
}
*/
//***************************************************************************************/
