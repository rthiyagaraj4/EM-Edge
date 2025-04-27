//********************************************************************************
var result1    =   false;
var message1   =   "";
var flag1      =   "";
var INT     = "Integer" ;
var LONG    = "Long"    ;
var FLOAT   = "Float"   ;
var DOUBLE  = "Double"  ;
var STRING  = "String"  ;
var CODE_LINK       = "1"   ;
var DESC_LINK       = "2"   ;
var CODE_DESC_LINK  = "1,2" ;
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;
var radioval    = "D"         ;
var firstCodeVal = "" ;
var firstDescVal = "" ; 
//********************************************************************************
function getTypeValue(val)
{
	var element1 = 'filterelement';
	var element2 = 'filterelement_sub';
	var element3 = 'filterelement_sub1';
	var element4 = 'filterelement_sub2';
	
	var objtyp = eval('this.document.forms[0].'+element1+'_type');
	var objsubtyp = eval('this.document.forms[0].'+element2+'_type');
	var objsub1typ = eval('this.document.forms[0].'+element3+'_type');
	var objsub2typ = eval('this.document.forms[0].'+element4+'_type');

	var objval = eval('this.document.forms[0].'+element1+'_value');
	var objsubval = eval('this.document.forms[0].'+element2+'_value');
	var objsub1val = eval('this.document.forms[0].'+element3+'_value');
	var objsub2val = eval('this.document.forms[0].'+element4+'_value');
	
	if (objtyp.value==val)
	{
		return(objval.value);
	}
	if (objsubtyp.value==val)
	{
		return(objsubval.value);
	}
	if (objsub1typ.value==val)
	{
		return(objsub1val.value);
	}
	if (objsub2typ.value==val)
	{
		return(objsub2val.value);
    }

}
//********************************************************************************
function getSQL(ftype)
{
	var sql = '';
	var facid =  this.document.forms[0].facilityid.value;
	if (ftype.value == 'C')
	{
		sql = "SELECT LONG_DESC description, CLINIC_CODE code FROM OP_CLINIC "+
			" WHERE FACILITY_ID = '"+facid+"' AND "+
			"  CLINIC_TYPE = 'C' AND	 EFF_STATUS ='E' "+
			" AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?) "+
			" ORDER BY 1 ";
	}
	if (ftype.value == 'U')
	{
		sql = "SELECT LONG_DESC description, CLINIC_CODE code FROM OP_CLINIC "+
			" WHERE FACILITY_ID = '"+facid+"' AND "+
			" CLINIC_TYPE = 'C' AND	 EFF_STATUS ='E' "+
			" AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?) "+
			" ORDER BY 1 ";
	}
	if (ftype.value == 'W')
	{
		sql = "SELECT LONG_DESC description, NURSING_UNIT_CODE code FROM IP_NURSING_UNIT "+
			" WHERE FACILITY_ID = '"+facid+"' AND "+
			" NURSING_UNIT_CODE not in  " +
			" ( select NURSING_UNIT_CODE from IP_DC_UNIT_FOR_NURS_UNIT ) "+
			" AND EFF_STATUS ='E'  "+
			" AND UPPER(LONG_DESC) LIKE upper(?) AND UPPER(NURSING_UNIT_CODE) LIKE upper(?) "+
			" ORDER BY 1 ";

	}

	if (ftype.value == 'D')
	{
		sql = "SELECT LONG_DESC description, NURSING_UNIT_CODE code FROM IP_NURSING_UNIT "+
			" WHERE FACILITY_ID = '"+facid+"' AND "+
			" NURSING_UNIT_CODE  in  " +
			" ( select NURSING_UNIT_CODE from IP_DC_UNIT_FOR_NURS_UNIT ) "+
			" AND EFF_STATUS ='E' "+
			" AND UPPER(LONG_DESC) LIKE upper(?) AND UPPER(NURSING_UNIT_CODE) LIKE upper(?) "+
			" ORDER BY 1 ";

	}
	if (ftype.value == 'O')
	{
		sql = " SELECT LONG_DESC description, order_category code  "+
				" FROM OR_ORDER_CATEGORY  "+
				" WHERE UPPER(LONG_DESC) LIKE upper(?) AND "+
				" upper(order_category) LIKE upper(?) "+
				"  ORDER BY 1 ";
	}
	if (ftype.value == 'P')
	{
		sql = " SELECT LONG_DESC description, PATIENT_TYPE code FROM AM_PATIENT_TYPE "+
				" WHERE EFF_STATUS = 'E' "+
				" AND UPPER(LONG_DESC) LIKE upper(?) AND "+
				" upper(PATIENT_TYPE) LIKE upper(?) "+
				" ORDER BY 1  ";
	}
	if (ftype.value == 'R')
	{
		sql = 	" SELECT SHORT_DESC description, REFERRAL_CODE CODE FROM  AM_REFERRAL  "+
				" WHERE EFF_STATUS ='E' "+
				" AND UPPER(LONG_DESC) LIKE (?) AND "+
				" upper(REFERRAL_CODE) LIKE upper(?) "+
				" ORDER BY 1 "; 
	}
	if (ftype.value == 'M')
	{
		sql = " SELECT  room_no description, room_no code from ip_nursing_unit_room "+
			" WHERE FACILITY_ID = '"+facid+"'"+
			" AND nursing_unit_code = '"+getTypeValue('W')+"' "+
			" AND UPPER(room_no) like (?) AND (1=1 OR room_no like ?) "+
			" ORDER BY 1 ";
	}
	if (ftype.value == 'A')
	{
		sql = " SELECT short_desc description, treatment_area_code code from AE_TMT_AREA_FOR_CLINIC  "+
		" WHERE FACILITY_ID = '" +facid+"' "+
		" AND clinic_code = '"+getTypeValue('C')+"' "+
		" AND UPPER(short_desc) LIKE upper(?) AND "+
		" upper(treatment_area_code) LIKE upper(?) "+ 
		" ORDER BY 1 ";
	}
	if (ftype.value == 'T')
	{
		sql =	" SELECT SHORT_DESC description, ORDER_TYPE_CODE code FROM  OR_ORDER_TYPE "+
			" WHERE ORDER_CATEGORY = '"+getTypeValue('O')+"' "+
			" AND EFF_STATUS ='E' "+
			" AND UPPER(SHORT_DESC) LIKE upper(?) "+
			" AND UPPER(ORDER_TYPE_CODE) LIKE upper(?) "+
			" ORDER BY 1 ";

	}

	
	if (ftype.value == '*')
	{
		sql ="NULL"; 

	}

	return(sql);

}

//*****************************************************************************/
function lookup(buttobjt)
{

    var butt = buttobjt.name;
	var objtyp = eval('this.document.forms[0].'+butt+'_type');
	var objval = eval('this.document.forms[0].'+butt+'_value');
	var objdes = eval('this.document.forms[0].'+butt+'_desc');	
	
	var obj  = objval;
	var target = objdes;

	var tcode = objval.value;
	if(objdes.value!=' ') objdes.value='';
	var tdesc = objdes.value;


	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Filtering Codes" ;
	
	var sql= getSQL(objtyp);
	
    //alert(target.value);
    if(sql!='NULL'){
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}
	else
	{
		target.value=tdesc;
		obj.value=tcode;
	}
	}
}
//********************************************************************************************/
