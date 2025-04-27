  //saved on 26/10/2005
var result		= false ;
var message		= "" ;
var flag		= "" ;
var mode=0;

var firstTime=true;
var pageNum=1;
var totalRows=0;
// contains the number of records per page
var pageSize=10;


function query(){
	mode=3;
	ConsGroupModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGroupQueryResult.jsp?function_id=Reconstituent Fluid for drug" ;
}
//ML-MMOH-CRF-1126 start
function create(gcode){
	mode=1;
	ConsGroupModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGroupCreate.jsp?gcode="+gcode+"&mode="+mode;
}
//ML-MMOH-CRF-1126 end
function apply()
{
		//Nothing to validate..directly call insert method
		url=ConsGroupModifyQueryFrame.location.href;
		if (url.indexOf("Modify")!=-1)
		{
				var frmobj =ConsGroupModifyQueryFrame.document.FrmTPNConsGroup;
				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

				//check for mandatory field
				var fields=new Array();
				fields[0]=ConsGroupModifyQueryFrame.document.FrmTPNConsGroup.gName;

				var names=new Array();
				names[0]=getLabel("ePH.ConstituentGroupName.label","PH");

						
				var blankObj 	= null ;
				blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;

				if(blankObject==null) 
				{
					eval(formApply(frmobj, PH_CONTROLLER) ) ;
					//alert(formApply(frmobj, PH_CONTROLLER) ) ;
					if (result){
							onSuccess(frmobj);
					}
				}
				else
				{
					blankObject.focus() ;
				}

		} else if(url.indexOf("Create")!=-1){ //ML-MMOH-CRF-1126 start

			var frmobj =ConsGroupModifyQueryFrame.document.FrmTPNConsGroupCreate;
			var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;

			//check for mandatory field
			var fields=new Array();
			fields[0]=ConsGroupModifyQueryFrame.document.FrmTPNConsGroupCreate.gCode;

			var names=new Array();
			names[0]=getLabel("ePH.ConstituentGroupCode.label","PH");
			
			var blankObject 	= null ;
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			
			if (blankObject!=null){
				blankObject.focus() ;
				return;
			}
			
			fields[1]=ConsGroupModifyQueryFrame.document.FrmTPNConsGroupCreate.gName;
			names[0]=getLabel("ePH.ConstituentGroupName.label","PH");
			
			var blankObject 	= null ;
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			
			if (blankObject!=null){
				blankObject.focus() ;
				return;
			}
			fields[2]=ConsGroupModifyQueryFrame.document.FrmTPNConsGroupCreate.srlno;
			names[0]=getLabel("ePH.DisplaySerialNo.label","PH");
			
			var blankObject 	= null ;
			blankObject  = getBlankField( fields, names, messageFrame, errorPage) ;
			
			if (blankObject!=null){
				blankObject.focus() ;
				return;
			} 
			else 
			    {
		              eval(formApply(frmobj, PH_CONTROLLER) ) ;
				     //alert(formApply(frmobj, PH_CONTROLLER) ) ;
				     if (result){
						onSuccess(frmobj);
				  }
			}
	
	
		}//ML-MMOH-CRF-1126 end
		else
		{
			//this.commontoolbarFrame.location.reload();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}

}
function modifyGroup(gcode)
{
		mode=2;
		parent.ConsGroupModifyQueryFrame.location.href="../../ePH/jsp/PHTPNConsGroupModify.jsp?gcode="+gcode+"&mode="+mode ;
}
function onSuccess(frmobj)
{
			//alert("THIS IS THE MESSGE"+message);
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		

}
function reset()
{
		url=ConsGroupModifyQueryFrame.location.href;
		if (url.indexOf("Modify")!=-1)
		{
				var frmobj =ConsGroupModifyQueryFrame.document.FrmTPNConsGroup;
				var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
				frmobj.reset();
			

		}else if(url.indexOf("Create")!=-1){ //Added for ML-MMOH-CRF-1126 start
			var frmobj =ConsGroupModifyQueryFrame.document.FrmTPNConsGroupCreate;
			var errorPage	= "../../eCommon/jsp/MstCodeError.jsp" ;
			frmobj.reset();

		} //Added for ML-MMOH-CRF-1126 end
		else
		{
			//this.commontoolbarFrame.location.reload();
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
		
	

}


function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}
// ML-MMOH-CRF-1126 start
function enableDisable(obj){
	if(obj.checked==true)
		document.FrmTPNConsGroup.eff_status.value="E";
	else 
		document.FrmTPNConsGroup.eff_status.value="D";
}
 //ML-MMOH-CRF-1126 end
function startWithAlphabets(which) { // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	fldval = which.value.substr(0,1);
	fldval = fldval.replace(/^\s+/,""); // strip leading spaces
	if (fldval!="" && !/[a-zA-Z][a-zA-Z0-9]*/.test(fldval)) { // only alphanumeric and space allowed	
	alert(getMessage("START_WITH_ALPHABETS","PH"));
	which.value = "";
	which.focus();
	return false;
	}
} // Added for ML-MMOH-CRF-1266 [IN:068728] - End