

<html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,com.ehis.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp"%> 
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con =null;
	PreparedStatement pstmt =null;
	java.sql.Statement stmt =null;
	java.sql.Statement stmt1 =null;
	ResultSet rs =null;
	ResultSet rs1 =null;
	java.sql.Statement stmt22=null;
	ResultSet rs22=null;	
	int tindex=0;
	Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	Boolean vatNoApplicable = false; //Added by Mano aganist MMS-DM-CRF-0118.3
	
	Boolean increasedaddressLength=false; //Added for ML-MMOH-CRF-0860.2

	try{
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	con = ConnectionManager.getConnection(request);
	ArrayList retArrList 		= fetchContactAddresses (con,out,"parent.parent.messageFrame",p);
	//ArrayList retArrListLocal 		= fetchContactAddressesLocal (con,out,"parent.parent.messageFrame",p);

	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "GST_CODE");
	
	//Added by Mano aganist MMS-DM-CRF-0118.3
	vatNoApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "VAT_NO");
	
	//Below line added for ML-MMOH-CRF-0860.2
	increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");	

	String site_id 				= (String)retArrList.get(0);
	String contact_col_names[]  = (String[])retArrList.get(1);
	String contact_prompts[] 	= (String[])retArrList.get(2);
	String contact_fields[]       = (String[])retArrList.get(3) ;
	for(int i=0;i<contact_col_names.length; i++){
	}
	for(int i=0;i<contact_prompts.length; i++){
	}
	for(int i=0;i<contact_fields.length; i++){
	}
		//local  addresses
	//String site_idLocal 				= (String)retArrListLocal.get(0);
	//String contact_col_namesLocal[]  = (String[])retArrListLocal.get(1);
	//String contact_promptsLocal[] 	= (String[])retArrListLocal.get(2);
	//String contact_fieldsLocal[]       = (String[])retArrListLocal.get(3) ;
	/*for(int i=0;i<contact_col_namesLocal.length; i++){
		
	}
	for(int i=0;i<contact_promptsLocal.length; i++){
	}
	for(int i=0;i<contact_fieldsLocal.length; i++){
	}*/
	retArrList = null;
	String ws_by_ip_name		= "";
	String change_ws_at_fcy_yn	= "";
    String chkval="";
	String diplay_site="";
	String chek1="N";
	    String sql_site="Select WS_BY_IP_NAME, CHANGE_WS_AT_FCY_YN  from sm_site_param";
	stmt1=con.createStatement();
	rs1=stmt1.executeQuery(sql_site); 
	if(rs1!=null)
	{
		while(rs1.next())
		{
			ws_by_ip_name=rs1.getString("ws_by_ip_name");
			change_ws_at_fcy_yn=rs1.getString("change_ws_at_fcy_yn");
			
		}
	}
	
	
	String disableListYn = "";

	String to_date="";
	String sql_date=" Select to_char(sysdate,'dd/mm/yyyy hh24:mm:ss') from dual";
	if(rs1!=null)rs1.close();
	if(stmt1!=null)stmt1.close();
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql_date);
	if(rs!=null)
	{
		while(rs.next())
		{
			to_date=rs.getString(1);
		}
	}

%>
<%
         String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>



<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eSM/js/facility_param.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function getAddressValues(addr_line1,addr_line2,addr_line3,addr_line4,res_area_code,res_town_code,region_code,addr_postal_code)
{
		var value1=eval('addr_line1')
	    while(value1.indexOf("+")!=-1){
		      value1=value1.replace('+'," ");
		  }
       var addr_line11=	unescape(value1)
	   var value2=eval('addr_line2')
	    while(value2.indexOf("+")!=-1){
		      value2=value2.replace('+'," ");
		  }
		var addr_line21=	unescape(value2)

		var value3=eval('addr_line3')
	    while(value3.indexOf("+")!=-1){
		      value3=value3.replace('+'," ");
		  }
  		var addr_line31=	unescape(value3)

		 var value4=eval('addr_line4')
	    while(value4.indexOf("+")!=-1){
		      value4=value4.replace('+'," ");
		  }
  		var addr_line41= unescape(value4)

		 var value5=eval('res_area_code')
	    while(value5.indexOf("+")!=-1){
		      value5=value5.replace('+'," ");
		  }
		var res_area_code1=	unescape(value5)

		 var value6=eval('res_town_code')
	    while(value6.indexOf("+")!=-1){
		      value6=value6.replace('+'," ");
		  }
  		var res_town_code1=	unescape(value6)

		  		var value7=eval('region_code')
	    while(value7.indexOf("+")!=-1){
		      value7=value7.replace('+'," ");
		  }
  		var region_code1=	unescape(value7)

	  	var value8=eval('addr_postal_code')
	    while(value8.indexOf("+")!=-1){
		      value8=value8.replace('+'," ");
		}
		var addr_postal_code1=	unescape(value8)
		
		if(document.forms[0].addr_line1!=null)
			document.forms[0].addr_line1.value=addr_line11;
		if(document.forms[0].addr_line2!=null)
			document.forms[0].addr_line2.value=addr_line21;
		if(document.forms[0].addr_line3!=null)
			document.forms[0].addr_line3.value=addr_line31;
		if(document.forms[0].addr_line4!=null)
			document.forms[0].addr_line4.value=addr_line41;
		if(document.forms[0].m_town_code!=null)
			document.forms[0].m_town_code.value=res_town_code1;
		if(document.forms[0].m_area_code!=null)
			document.forms[0].m_area_code.value=res_area_code1;
		if(document.forms[0].m_region_code!=null)
			document.forms[0].m_region_code.value=region_code1;
		if(document.forms[0].m_postal_code1!=null)
			document.forms[0].m_postal_code1.value=addr_postal_code1;		
	}
function CheckForSpecChars_local(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function validate_logo(obj)
{
	var logo = obj.value;
 if(logo != "" && logo != null)
  {
	var len = logo.length;

if((logo.charAt(len-4)!=".")||(logo.indexOf(".") != len-4))
 {
	alert(getMessage('INVALID_LOGO_FILE','SM'));
	obj.focus();
	 return false;
 }
 else
if((logo.substring(len-3,len)!="GIF")&&(logo.substring(len-3,len)!="JPG"))
 {
		alert(getMessage('LOGO_FILE_EXTN','SM'));
		obj.focus();
		 return false;
 }
 else 
	 return true;
  }
}

function onkeyPressEvent(e){
			return false;
		}
/*
function callSearch(obj,target)
{
			var retVal =    new String();
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var tit="";	
			 
            if(obj.name=="ra"||target.name=="res_area_code")
	        {
					tit=getLabel("Common.area.label","Common"); 
					sql="Select res_area_code code ,long_Desc description from Mp_res_area where upper(res_area_code) like upper(?) and upper(long_Desc) like upper(?)";
			}
			else if(obj.name=="twn"||target.name=="res_town_code")
	        {
				tit=getLabel("Common.Town.label","Common");
				sql="Select res_town_code code,long_Desc description from Mp_res_town where upper(res_town_code) like upper(?) and upper(long_Desc) like upper(?)";
			}
			else if(obj.name=="reg"||target.name=="region_code")
	        {
			
				tit=getLabel("eMP.State.label","MP"); 
				sql="Select region_code code,long_Desc description from Mp_region where  upper(region_code) like upper(?) and upper(long_Desc) like upper(?)";
			}
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit,argumentArray);
				if(retVal != null && retVal != "" )
                {
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
			        
					
				if(obj.name=="ra"||target.name=="res_area_code")
	             {
				 document.forms[0].res_area_code1.value=arr[0]
				 
				 }else if(obj.name=="twn"||target.name=="res_town_code")
					{
				    document.forms[0].res_town_code1.value=arr[0]
				    }
				 else if(obj.name=="reg"||target.name=="region_code")
				{
				
				document.forms[0].region_code1.value=arr[0]
				}
				}
				else
	            {
	         
			  if(obj.name=="ra"||target.name=="res_area_code")
	             {
				 document.forms[0].res_area_code.value=""
				 				 
				 }else if(obj.name=="twn"||target.name=="res_town_code")
					{
				    document.forms[0].res_town_code.value=""
				   	}
				 else if(obj.name=="reg"||target.name=="region_code")
				{
				
				document.forms[0].region_code.value=""
				
				}
	}
}
*/

async function showOperModule()
{
	 var retVal =    new String();
     var dialogHeight= "28" ;
     var dialogWidth = "40" ;
     var center = "1" ;
	 var dialogTop = "110" ;
     var status="no";
     var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
     var arguments   = "" ;
     retVal = await window.showModalDialog("../jsp/facility_param_oper_module.jsp?step=1&facilityid="+document.forms[0].facility_id.value+"&opermodules="+document.forms[0].operational_modules.value,arguments,features);	

	if(retVal != null)
	{
		if(retVal != "Close")
			document.forms[0].operational_modules.value = retVal;
		else
			document.forms[0].operational_modules.value = "";
	}
	else
		document.forms[0].operational_modules.value = "";
}

function enableDisableButt(Obj)
{
	if(Obj.value == "")		
		document.forms[0].operational_module.disabled = true;
	else
		document.forms[0].operational_module.disabled = false;
}

function ChkNumberInput1(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}


function CheckAlbhabets(obj)
{
	if(obj.value=="A")
	event.returnValue = false;
}
function Checkdisplay(obj)
{
	//alert("initial value"+obj.value);
	if (obj.checked)
	{
		document.forms[0].display_site_name.checked = true;
		document.forms[0].display_site_name.value="Y";
		document.forms[0].display_site_name_yn.value="Y";
	}else
	{
		document.forms[0].display_site_name.checked = false;
        document.forms[0].display_site_name_yn.value="N";
	}
//alert("checked="+obj.value);

}


// below code added to restrict the > and < in the facility field

</script>
<body topmargin="0" onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()' onload='FocusFirstElement()'>
<center>
<%	     
    String codeTextAttribute="";
	String facility_id				= request.getParameter( "facility_id" ) ;
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	String gstin_facility 			= request.getParameter( "gstin_facility" ) ;
	//Added by Mano aganist MMS-DM-CRF-0118.3
	String vat_no                   = request.getParameter( "vat_no" ) ;
	String facility_name 			= request.getParameter( "facility_name" ) ;
	String addr_line1 				= request.getParameter( "addr_line1" ) ;
	String addr_line2 				= request.getParameter( "addr_line2" ) ;
	String addr_line3 				= request.getParameter( "addr_line3" ) ;
	String addr_line4 				= request.getParameter( "addr_line4" ) ;

	String addr_line1_loc_lang 		= request.getParameter( "addr_line1_loc_lang" ) ;
	String addr_line2_loc_lang 		= request.getParameter( "addr_line2_loc_lang" ) ;
	String addr_line3_loc_lang 		= request.getParameter( "addr_line3_loc_lang" ) ;
	String addr_line4_loc_lang		= request.getParameter( "addr_line4_loc_lang" ) ;

	String res_area_code            = request.getParameter( "res_area_code" ) ;
	String res_town_code			= request.getParameter( "res_town_code" ) ;
    String addr_postal_code			= request.getParameter( "addr_postal_code" ) ;
	String region_code				= request.getParameter( "region_code" ) ;
	String country_code				= request.getParameter( "country_code" ) ;
	String tel_no1					= request.getParameter( "tel_no1" ) ;
	String tel_no2					= request.getParameter( "tel_no2" ) ;
	String tel_no3					= request.getParameter( "tel_no3" ) ;
	String tel_no4					= request.getParameter( "tel_no4" ) ;
	String fax_no					= request.getParameter( "fax_no" ) ;
	String email_id					= request.getParameter( "email_id" ) ;
	//String facility_logo			= request.getParameter( "facility_logo" ) ;
	String website_id				= request.getParameter( "website_id" ) ;
	String head_of_facility_name		= request.getParameter( "head_of_facility_name" ) ;
	String head_of_facility_job_title	= request.getParameter( "head_of_facility_job_title" ) ;
	String license_no				= request.getParameter( "license_no" ) ;
	String operation 				= request.getParameter( "operation" ) ;
	String hcare_setting_type_code= request.getParameter( "hcare_setting_type_code" ) ;
	int cntRec = 0;
	String resarea="";
	String region="";
	String restown="";
	String postalcode="";
	String facility_image_file_name="";
	String facilitylevel_code="";
	
if(operation.equalsIgnoreCase( "insert" ) ){
	if(change_ws_at_fcy_yn.equals("N")){
		disableListYn="disabled";
	}

}else{
	if(ws_by_ip_name.equals("I") || ws_by_ip_name.equals("N")){
		disableListYn = "disabled";
	}
}

String field_vals[] = new String[8] ;
String acc_entity_id1 = "";

String q_language_ID="";
String app_server_ip			= request.getParameter( "app_server_ip" ) ;
String sql="";
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

	if ( operation.equalsIgnoreCase( "modify" ) ) {
		codeTextAttribute="readonly";
		 sql = "select acc_entity_id from sm_acc_entity_param_facl where facility_id = ? " ;
		
		pstmt = con.prepareStatement( sql);
		pstmt.setString( 1, facility_id) ;
		rs = pstmt.executeQuery() ;
		if (rs !=null&& rs.next())
			acc_entity_id1 = rs.getString(1);

        if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		sql = "select * from sm_facility_param where facility_id = ? " ;
		
		pstmt = con.prepareStatement( sql ) ;
		pstmt.setString( 1, facility_id ) ;
		rs = pstmt.executeQuery() ;

		if ( rs != null ) rs.next() ;

		//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
		gstin_facility			= rs.getString( "gstin_facility" ) == null ? "":rs.getString( "gstin_facility" );
		
		//Added by Mano aganist MMS-DM-CRF-0118.3
		vat_no                  =rs.getString( "vat_no" ) ==null ? "":rs.getString( "vat_no" );

		facility_name			= rs.getString( "facility_name" ) ;

		addr_line1				= rs.getString( "addr_line1" ) == null ? "":rs.getString( "addr_line1" );
		field_vals[0] = addr_line1 ;
	    addr_line1=java.net.URLEncoder.encode(addr_line1,"UTF-8");

		addr_line2 				= rs.getString( "addr_line2" ) == null ? "":rs.getString( "addr_line2" );
		field_vals[1] = addr_line2 ;
	    addr_line2=java.net.URLEncoder.encode(addr_line2,"UTF-8");

		addr_line3				= rs.getString( "addr_line3" ) == null ? "":rs.getString( "addr_line3" );
		field_vals[2] = addr_line3 ;
	    addr_line3=java.net.URLEncoder.encode(addr_line3,"UTF-8");

		addr_line4 				= rs.getString( "addr_line4" ) == null ? "":rs.getString( "addr_line4" );
		field_vals[3] = addr_line4 ;
  	    addr_line4=java.net.URLEncoder.encode(addr_line4,"UTF-8");

		addr_line1_loc_lang		= rs.getString( "addr_line1_loc_lang" ) == null ? "":rs.getString( "addr_line1_loc_lang" );  		

		addr_line2_loc_lang 	= rs.getString( "addr_line2_loc_lang" ) == null ? "":rs.getString( "addr_line2_loc_lang" );	  

		addr_line3_loc_lang		= rs.getString( "addr_line3_loc_lang" ) == null ? "":rs.getString( "addr_line3_loc_lang" );	   

		addr_line4_loc_lang		= rs.getString( "addr_line4_loc_lang" ) == null ? "":rs.getString( "addr_line4_loc_lang" );   	   

		res_area_code           = rs.getString( "RES_AREA_CODE" )== null ? "":rs.getString( "RES_AREA_CODE" ) ;
		field_vals[4] = res_area_code    ;
        res_town_code			= rs.getString( "RES_town_CODE" )== null ? "":rs.getString( "RES_town_CODE" ) ;
		field_vals[5] = res_town_code;
		region_code			= rs.getString( "REGION_CODE" ) == null ? "":rs.getString( "REGION_CODE" );
		field_vals[6] =region_code	 ;
        addr_postal_code			= rs.getString( "addr_postal_code" ) == null ? "":rs.getString( "addr_postal_code" );
		field_vals[7] = addr_postal_code ;
  		country_code			= rs.getString( "country_code" ) ;
		tel_no1				= rs.getString( "tel_no1" ) ;
		tel_no2				= rs.getString( "tel_no2" ) ;
		tel_no3				= rs.getString( "tel_no3" ) ;
		tel_no4				= rs.getString( "tel_no4" ) ;
		fax_no				= rs.getString( "fax_no" ) ;
		email_id			= rs.getString( "email_id" ) ;
		//facility_logo		= rs.getString( "facility_logo" ) ;
		website_id			= rs.getString( "website_id" ) ;			
		head_of_facility_name	= rs.getString( "head_of_facility_name" ) ;
		head_of_facility_job_title	= rs.getString( "head_of_facility_job_title" ) ;
		license_no				= rs.getString( "license_no" ) ;
		ws_by_ip_name	=	rs.getString("ws_by_ip_name");
		hcare_setting_type_code	= rs.getString( "hcare_setting_type_code" ) ;
		q_language_ID=rs.getString( "language_id" ) ;
        sql = "select acc_entity_id from sm_acc_entity_param_facl where facility_id = ? " ;	
		app_server_ip			= rs.getString( "app_server_ip" ) ;		
		facility_image_file_name= rs.getString( "facility_image_file_name" ) == null ? "":rs.getString( "facility_image_file_name" );
		//diplay_site= rs.getString( "DISPLAY_SITE_NAME_YN" ) == null ? "":rs.getString( "DISPLAY_SITE_NAME_YN" );
		facilitylevel_code= rs.getString( "FACILITY_LEVEL_CODE" ) == null ? "":rs.getString( "FACILITY_LEVEL_CODE" );

	} else 
	{
		app_server_ip			= (String) session.getValue( "app_server_ip" ) ;
	}
	if ( pstmt != null ) pstmt.close() ;
	
	if ( rs != null ) rs.close() ;
     // String sql1="Select long_Desc description from Mp_res_area where res_area_code=?"; 
	  String sql1="Select long_Desc description from mp_res_area_lang_vw where res_area_code=? and language_id ='"+localeName+"'"; 
	    pstmt= con.prepareStatement(sql1) ;
		 pstmt.setString(1,field_vals[4]);
		 rs=pstmt.executeQuery();
	   if(rs.next())
		resarea=rs.getString(1); 		
   	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;

	   //sql1="Select long_desc from Mp_res_town where res_town_code=?"; 
	   sql1="Select long_desc from mp_res_town_lang_vw where res_town_code=? and language_id ='"+localeName+"'"; 
	    pstmt= con.prepareStatement(sql1) ;
		 pstmt.setString(1,field_vals[5]);
		 rs=pstmt.executeQuery();
	   if(rs.next())
		restown=rs.getString(1);

	if ( pstmt != null ) pstmt.close() ;	
	if ( rs != null ) rs.close() ;
	//sql1="Select long_Desc description from Mp_region where region_code=?"; 
	sql1="Select long_Desc description from Mp_region_lang_vw where region_code=? and language_id ='"+localeName+"'"; 
	    pstmt= con.prepareStatement(sql1) ;
		 pstmt.setString(1,field_vals[6]);
		 rs=pstmt.executeQuery();
	   if(rs.next())
		region=rs.getString(1);
	 

	 if ( pstmt != null ) pstmt.close() ;	
	if ( rs != null ) rs.close() ;
	//sql1="Select short_Desc description from mp_postal_code where postal_code=?"; 
	sql1="Select short_Desc description from mp_postal_code_lang_vw where postal_code=? and language_id ='"+localeName+"'"; 
	    pstmt= con.prepareStatement(sql1) ;
		 pstmt.setString(1,field_vals[7]);
		 rs=pstmt.executeQuery();
	   if(rs.next())
		postalcode=rs.getString(1);
	 

	 if ( pstmt != null ) pstmt.close() ;	
	if ( rs != null ) rs.close() ;


	if ( facility_id == null ) 		facility_id = "" ;
	if ( gstin_facility == null ) 	gstin_facility = "" ;
	if (vat_no == null )            vat_no= "" ;
	if ( facility_name == null ) 	facility_name = "" ;
	if ( addr_line1 == null ) 		addr_line1 = "" ;
	if ( addr_line2 == null ) 		addr_line2 = "" ;
	if ( addr_line3 == null ) 		addr_line3 = "" ;
	if ( addr_line4 == null ) 		addr_line4 = "" ;

	if ( addr_line1_loc_lang == null ) 		addr_line1_loc_lang = "" ;
	if ( addr_line2_loc_lang == null ) 		addr_line2_loc_lang = "" ;
	if ( addr_line3_loc_lang == null ) 		addr_line3_loc_lang = "" ;
	if ( addr_line4_loc_lang == null ) 		addr_line4_loc_lang = "" ;

	if ( addr_postal_code == null ) 	addr_postal_code = "" ;
	if ( country_code == null ) 		country_code = "" ;
	if ( tel_no1 == null ) 			tel_no1 = "" ;
	if ( tel_no2 == null ) 			tel_no2 = "" ;
	if ( tel_no3 == null ) 			tel_no3 = "" ;
	if ( tel_no4 == null ) 			tel_no4 = "" ;
	if ( fax_no == null ) 			fax_no = "" ;
	if ( email_id == null ) 		email_id = "" ;
	//if ( facility_logo == null ) 	facility_logo = "" ;
	if ( website_id == null ) 		website_id = "" ;
	if ( head_of_facility_name == null ) head_of_facility_name = "" ;
	if ( head_of_facility_job_title == null ) head_of_facility_job_title = "" ;
	if ( license_no == null ) 		license_no = "" ;
	if ( operation == null ) 		operation = "" ;
	if ( hcare_setting_type_code == null ) 		hcare_setting_type_code = "" ;
	if ( app_server_ip == null )		app_server_ip = "" ;



	diplay_site="";
	//String query="Select DISPLAY_SITE_NAME_YN from sm_facility_param where facility_id='"+facility_id+"'";
	//stmt22=con.createStatement();
	//rs22=stmt22.executeQuery(query);
	if(pstmt!=null)pstmt.close();
	
	String query="Select DISPLAY_SITE_NAME_YN from sm_facility_param where facility_id=?";
	pstmt   = con.prepareStatement(query);
	pstmt.setString	(	1,	facility_id		);
	rs22		 = pstmt.executeQuery();
	if(rs22!=null)
	{
		while(rs22.next())
		{
			
			diplay_site=rs22.getString("DISPLAY_SITE_NAME_YN");
			if(diplay_site.equals("Y"))
			{
				chkval="checked";
				chek1="Y";
				}
			else 
			{
				chkval="";
				chek1="N";
		
			}
		}
	}
%>

<form name="facility_param_form" id="facility_param_form" action="../../servlet/eSM.FacilityParamServlet" enctype='multipart/form-data' method="post" target="messageFrame">
	<input type="hidden" name="function" id="function" value='<%= operation %>' >
	<input type="hidden" name="function_name" id="function_name" value='<%= operation %>' >
	<input type="hidden" name="site_id" id="site_id" value='<%= site_id %>' >
	<input type="hidden" name="to_date" id="to_date" value='<%= to_date %>' >
 <table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td align="center" class="BORDER">
			<table border='0' cellpadding='0' cellspacing='0' width="100%">
	
             <tr  >
	 
					<td class="label" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
					<td class="FIELDS" colspan=3 nowrap>
						<input type="text" name="facility_id" id="facility_id" size="3" maxlength="2" value="<%=facility_id%>" <%=codeTextAttribute%> onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event)" ><img src='../../eCommon/images/mandatory.gif'></img></td></tr>
					
					<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
					<%if(isGSTCodeApplicable)
					{
						String rdonly = "";
						if(gstin_facility!="")
						{rdonly = "readonly";}
						else
						{rdonly = "";}
					%>
					<tr>
					<td class="label"><fmt:message key="Common.GoodsandServicesTaxID.label" bundle="${common_labels}"/></td><td class='fields' colspan=3 ><input type="text" name="gstin_facility" id="gstin_facility" size="20" maxlength="20" value="<%= gstin_facility %>" onKeyPress="return SpCharChkForFacility(event);" onBlur="ZeroChkForFacility(this);" <%=rdonly%>><img src='../../eCommon/images/mandatory.gif'></img></td>
					</tr>
					<%}%>

					<tr >
					<td class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class="FIELDS"><input type="text" name="facility_name" id="facility_name" size="70" maxlength="35" value="<%= facility_name %>" onBlur="makeValidString1(this);" onKeyPress="return CheckForSpecChar1(event)"  ><img src='../../eCommon/images/mandatory.gif'></img></td>
					
					<!--Added by Mano aganist MMS-DM-CRF-0118.3-->
					<%if(vatNoApplicable)
					{
						String rdonly = "";
						if(vat_no!="")
						{rdonly = "readonly";}
						else
						{rdonly = "";}
					%>	
					<td class="label"><fmt:message key="eSM.VatNo.label" bundle="${sm_labels}"/></td>
					<td class="FIELDS"><input type="text" name="vat_no" id="vat_no" size="20" maxlength="50" value="<%=vat_no%>" onKeyPress="return SpCharChkForFacility(event);" 
					<%=rdonly%> ></td>
					<%}%>
					
					
				</tr>		
					
						<tr><td class=label><fmt:message key="eSM.AccountingEntityID.label" bundle="${sm_labels}"/></td>
					<td class="FIELDS">
					<%if (acc_entity_id1.equals("")){%>
					<select name="acc_entity_id" id="acc_entity_id" >
					<%}else{%>
					<input type=hidden name='acc_entity_id' id='acc_entity_id' value="<%=acc_entity_id1%>">
					<select name="acc_entity_id1" id="acc_entity_id1" disabled>
					<%}%>
					<option value =''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
		<%
						try{
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
							pstmt = con.prepareStatement( "select ACCOUNTING_NAME_SHORT,a.acc_entity_id from sm_acc_entity a,sm_acc_entity_param b where  a.acc_entity_id = b.acc_entity_id order by 1" ) ;
							rs = pstmt.executeQuery() ;
							if( rs != null ) {
								while( rs.next() ) {
									String acc_entity_id = rs.getString( "acc_entity_id" ) ;
										
									if ( acc_entity_id.equals( acc_entity_id1 ) )
									{%>
										<option selected value='<%=acc_entity_id%>' >
										<%=rs.getString("ACCOUNTING_NAME_SHORT") %>
									<%}
									else{
									%>
									<option value='<%=acc_entity_id%>' > <%=rs.getString("ACCOUNTING_NAME_SHORT")%>
									<%
								}
							  }
							}
						}catch(Exception e) { //out.println("hcare"+e); 
							e.printStackTrace();
						}
						
					
%>					
					
					</select><img src='../../eCommon/images/mandatory.gif'></img></td>


 <td class=label  nowrap ><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
				<td  class="FIELDS">
				<select name="category_code" id="category_code">
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				<%
					PreparedStatement pstmt_cat=null;
					ResultSet rs_cat=null;
					try{						
						String sc_desc="";
						String cat_code="";
						String sql_cat="Select facility_level_code,short_desc from sm_facility_level where eff_status='E' order by 1";
						pstmt_cat=con.prepareStatement(sql_cat);
						rs_cat=pstmt_cat.executeQuery();
						if(rs_cat!=null){
							while(rs_cat.next()){
								sc_desc=rs_cat.getString(2);
								cat_code=rs_cat.getString(1);
					/* 1*/			if(cat_code.equals(facilitylevel_code)){
									%>
									<option value='<%=cat_code%>' selected><%=sc_desc%></option>
									<%
								}else{
									%>
									<option value='<%=cat_code%>'><%=sc_desc%></option>
									<%
								}
								
							}
						}
					if(rs_cat!=null) rs_cat.close();
					if(pstmt_cat!=null) pstmt_cat.close();	
						
				}catch(Exception e) { //out.println("hcare"+e);
					e.printStackTrace();
				}
				
				%>				
				</select>
										
				
				</td> 

				</tr>
				
				

<!--  hcare type from here -->			
				<tr>
				<td class=label nowrap ><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
				<td class="FIELDS" ><select name=hcare_setting_type_code id=hcare_setting_type_code>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
					java.sql.Statement stmt_hcare=null;
					ResultSet rs_hcare=null;
					try{						
						String chkTable="select count(1) from all_tables where table_name='AM_HCARE_SETTING_TYPE'";
						stmt_hcare = con.createStatement();
						rs_hcare = stmt_hcare.executeQuery(chkTable);
						if (rs_hcare.next())
							cntRec = rs_hcare.getInt(1);
										
						if (cntRec > 0)
						{
							String id="";
							String dat="";
							String sel="";
							String sql_hcare=" Select hcare_setting_type_code,short_desc from am_hcare_setting_type where eff_status='E' order by 2";
							if(rs_hcare!=null) rs_hcare.close();
							if(stmt_hcare!=null) stmt_hcare.close();
							
							
							stmt_hcare=con.createStatement();
							rs_hcare=stmt_hcare.executeQuery(sql_hcare);
							if(rs_hcare!=null)
							{
								while(rs_hcare.next())
								{
									id=rs_hcare.getString(1);
									dat=rs_hcare.getString(2);
									if(id.equals(hcare_setting_type_code)) sel="selected";%>	
									<option value='<%=id%>'  <%=sel%>><%=dat%></option>
									<%
									sel="";
								}
							}
						}
						if(rs_hcare!=null) rs_hcare.close();
						if(stmt_hcare!=null) stmt_hcare.close();
				}catch(Exception e) { //out.println("hcare"+e);
					e.printStackTrace();
				}
				
				%>
				<input type='hidden' name='cntRec' id='cntRec' value="<%=cntRec%>">
				</select><%if (cntRec > 0)
						{%><img src='../../eCommon/images/mandatory.gif'></img><%}%>
			 <td class=label  nowrap ><fmt:message key="Common.LocalLanguage.label" bundle="${common_labels}"/></td>
				<td class="FIELDS">
				<select name="language_id" id="language_id">
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				<%
					PreparedStatement pstmt_langId=null;
					ResultSet rs_langId=null;
					try{						
						String idlang="";
						String datlang="";
						String sql_langId="Select short_name,language_id from sm_language where eff_status='E' order by 1";
						pstmt_langId=con.prepareStatement(sql_langId);
						rs_langId=pstmt_langId.executeQuery();
						if(rs_langId!=null){
							while(rs_langId.next()){
								idlang=rs_langId.getString(2);
								datlang=rs_langId.getString(1);
								if(idlang.equals(q_language_ID)){
									%>
									<option value='<%=idlang%>' selected><%=datlang%></option>
									<%
								}else{
									%>
									<option value='<%=idlang%>'><%=datlang%></option>
									<%
								}
								
							}
						}
					if(rs_langId!=null) rs_langId.close();
					if(pstmt_langId!=null) pstmt_langId.close();	
						
				}catch(Exception e) {// out.println("hcare"+e);
					e.printStackTrace();
				}
				
				%>				
				</select>
										
				
				</td> 
				</tr>
			<tr ><td class="COLUMNHEADER" colspan='2'><b><fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/></b></td><td class="COLUMNHEADER" colspan='2'><b><fmt:message key="Common.LocalLanguage.label" bundle="${common_labels}"/></b></td></tr>
				<tr>
				</tr>				

				
		<%
				StringBuffer sb2 = new StringBuffer() ;
				StringBuffer sb12 = new StringBuffer() ;
				StringBuffer sba2 = new StringBuffer() ;
				StringBuffer sbar2 = new StringBuffer();
				StringBuffer fieldVal2 = new StringBuffer("");
                    for(int i=0;i<contact_col_names.length; i++)
                            {
                                  String  val = contact_fields[i] ;
								  sb2.append(val);
                                   int j=0 ;
								   int j1 = 0;
                                   String old_val = "" ;
                                   String new_val = "" ;
                                     
                                     if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt"))
                                     {
                                        old_val = "r_addr_line1" ;
                                        new_val = "addr_line1" ;
										     
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        old_val = "r_addr_line2" ;
                                        new_val = "addr_line2" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
                                        old_val = "r_addr_line3" ;
                                        new_val = "addr_line3" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        old_val = "r_addr_line4" ;
                                        new_val = "addr_line4" ;
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("res_town_prompt"))
                                     {
                                        old_val = "r_town_code" ;
                                        new_val = "m_town_code" ;
									 }//Added by kumar on 13/03/2003 for region 
									 else if(contact_col_names[i].equalsIgnoreCase("region_prompt"))
                                     {
                                        old_val = "r_region_code" ;
                                        new_val = "m_region_code" ;
                                     }
									 else if(contact_col_names[i].equalsIgnoreCase("res_area_prompt"))
                                     {
                                        old_val = "r_area_code" ;
                                        new_val = "m_area_code" ;
                                     }                                     
                                     else if(contact_col_names[i].equalsIgnoreCase("postal_code_prompt"))
                                     {
                                        old_val = "r_postal_code" ;
                                        new_val = "m_postal_code" ;
                                     }
									 
									out.println("<td class='label'  >"+contact_prompts[i]+"</td>") ;	
                                    while(val.indexOf(old_val) != -1)
                                    {
                                        j = val.indexOf(old_val,j) ;
                                        sb2 = sb2.replace(j,(j+old_val.length()),new_val);
                                        val = sb2.toString();
                                    }
             // Newly added
			if(contact_col_names[i].equalsIgnoreCase("res_town_prompt")) {
				sba2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sba2 = sba2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sba2.toString();
				}
			}
			if(contact_col_names[i].equalsIgnoreCase("res_area_prompt")) {
				j1 = 0;
				sbar2.append(val);
				while(val.indexOf("r_postal_code") != -1) {
					j1 = val.indexOf("r_postal_code",j1) ;
					sbar2 = sbar2.replace(j1,(j1+"r_postal_code".length()),"m_postal_code");
					val = sbar2.toString();
				}
			}
								   sb12.append(val);
									for(int z=0;z<val.length();z++)
									{
										String tempVal=sb12.substring(z,z+1);
										if(tempVal.equals("@"))
										{
											fieldVal2.append(++tindex);
										}
										else
										{
											fieldVal2.append(tempVal);
										}
									}
                                    val = fieldVal2.toString();
									
							/*Below line added for ML-MMOH-CRF-0860.2*/
							if(increasedaddressLength){
								if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) {
									out.println("<td class='fields' ><input type='text' name='addr_line1' id='addr_line1' maxlength='30' size='25' value='"+addr_line1+"' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
								}else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt")) {
									out.println("<td class='fields' ><input type='text' name='addr_line2' id='addr_line2' maxlength='30' size='25' value='"+addr_line2+"' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
								}else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt")) {
									out.println("<td class='fields' ><input type='text' name='addr_line3' id='addr_line3' maxlength='30' size='25' value='"+addr_line3+"' tabIndex='1' onBlur='makeValidString(this)'></td>");							   							  
								}else{
								    out.println("<td class='fields'>"+val) ;									
						            out.println("</td>");
								}									
							}else{									
                                out.println("<td class='fields'>"+val) ;									
						        out.println("</td>");
							}
							//End ML-MMOH-CRF-0860.2
						   

									 if(contact_col_names[i].equalsIgnoreCase("addr_line1_prompt")) 
									 {
										out.println("<td class='fields' colspan='2'><input type='text' name='addr_line1_loc_lang' id='addr_line1_loc_lang' maxlength='30' size='25' value='"+addr_line1_loc_lang+"' tabIndex='1' onBlur='makeValidString(this)'></td>");								
									 }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line2_prompt"))
                                     {
                                        out.println("<td class='fields' colspan='2'><input type='text' name='addr_line2_loc_lang' id='addr_line2_loc_lang' maxlength='30' size='25' value='"+addr_line2_loc_lang+"' tabIndex='1' onBlur='makeValidString(this)'></td>");
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line3_prompt"))
                                     {
										out.println("<td class='fields' colspan='2'><input type='text' name='addr_line3_loc_lang' id='addr_line3_loc_lang' maxlength='30' size='25' value='"+addr_line3_loc_lang+"' tabIndex='1' onBlur='makeValidString(this)'></td>");
                                     }
                                     else if(contact_col_names[i].equalsIgnoreCase("addr_line4_prompt"))
                                     {
                                        out.println("<td class='fields' colspan='2'><input type='text' name='addr_line4_loc_lang' id='addr_line4_loc_lang' maxlength='30' size='25' value='"+addr_line4_loc_lang+"' tabIndex='1' onBlur='makeValidString(this)'></td>");
                                     }
									 else {
										out.println("<td class='label'  colspan='2'>&nbsp;</td>");
									 }
						   
						   out.println("</tr>") ;
						   sb12.delete(0,sb12.length());
						   fieldVal2.delete(0,fieldVal2.length());
						   sb2.delete(0,sb2.length());
						   sba2.delete(0,sba2.length());
						   sbar2.delete(0,sbar2.length());
                            } 
                             
							if ( operation.equalsIgnoreCase( "modify" ) ) {
								 
								%>
									<!-- <script>getAddressValues('<%=addr_line1%>','<%=addr_line2%>','<%=addr_line3%>','<%=addr_line4%>','<%=res_area_code%>','<%=res_town_code%>','<%=region_code%>','<%=addr_postal_code%>')</script>	 -->
									<script>getAddressValues("<%=addr_line1%>","<%=addr_line2%>","<%=addr_line3%>","<%=addr_line4%>","<%=resarea%>","<%=restown%>","<%=region%>","<%=postalcode%>")</script>


								<%
							}
				%>
					</tr>
					<tr>
					<td class=label ><fmt:message key="Common.country.label" bundle="${common_labels}"/></td>
					<td colspan=3 class="FIELDS">
						<select name="country_code" id="country_code">
						<option value =''>------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------
		<%
						//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
						//String currentDate = dateFormat.format( new java.util.Date() ) ;
						try{
											
						int table_count =0;
						String sql_table=" select count(1) from all_tables where table_name='MP_COUNTRY' ";
						if(rs!=null)rs.close();
						java.sql.Statement stmt_table=con.createStatement();
						rs = stmt_table.executeQuery(sql_table);
						if(rs!=null)
							{
							while(rs.next())
								{
									table_count=rs.getInt(1);
								}
							}
						if(rs!=null)rs.close();
						if(stmt_table!=null)  stmt_table.close();
						if(pstmt!=null)pstmt.close();
						if(table_count>0)
						{
							pstmt = con.prepareStatement( "select country_code, long_name from mp_country where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by long_Name" ) ;
							rs = pstmt.executeQuery() ;

							if( rs != null ) {
								while( rs.next() ) {
									String countryCode = rs.getString( "country_code" ) ;
									String countryName = rs.getString( "long_name" ) ;

									if ( countryCode.equals( country_code ) )
									{%>
									<option selected value='<%=countryCode %>' ><%=countryName%> 
									<%}
									else{
									%>
									<option value='<%=countryCode%>' ><%=countryName%>
									<%}
								}
							  }
						}
						if ( rs != null ) rs.close() ;
						if ( pstmt != null ) pstmt.close() ;						
			
		%>
						</select>
					</td>

				</tr>
				<tr >
					<td class="label"><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></td>
					<td colspan=3 class="FIELDS"><input type="text" name="tel_no1" id="tel_no1" size="20" maxlength="20"  onBlur="makeValidString(this);" value="<%= tel_no1 %>"><input type="text" name="tel_no2" id="tel_no2" size="21" maxlength="20" value="<%= tel_no2 %>" onBlur="makeValidString(this);"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan=3 class="FIELDS"><input type="text" name="tel_no3" id="tel_no3" size="20" maxlength="20" value="<%= tel_no3 %>" onBlur="makeValidString(this);"><input type="text" name="tel_no4" id="tel_no4" size="21" maxlength="20" value="<%= tel_no4 %>" onBlur="makeValidString(this);"></td>
				</tr>

				<tr >
					<td class="label"><fmt:message key="Common.fax.label" bundle="${common_labels}"/></td>
					<td colspan=3 class="FIELDS"><input type="text" name="fax_no" id="fax_no" size="20" maxlength="20" value="<%= fax_no %>" onBlur="makeValidString(this);"></td>
					<td></td>
						<tr>
					<td class="label" ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
				<td colspan=3 class="FIELDS"><input type="text" name="email_id" id="email_id" size="50" maxlength="50" value="<%= email_id %>" onBlur="makeValidString(this);"></td>
				     <td></td>           						
				</tr>

				<tr >
					<td class="label"><fmt:message key="Common.URL.label" bundle="${common_labels}"/></td>
					<td colspan=3 class="FIELDS"><input type="text" name="website_id" id="website_id" size="45" maxlength="50" value="<%= website_id %>" onBlur="makeValidString(this);"></td>
				</tr>

				<tr >
					<td class="label" nowrap><fmt:message key="eSM.ApplicationServerIPAddress.label" bundle="${sm_labels}"/></td>
					
					<td class="FIELDS" nowrap ><input type="text" name="app_server_ip" id="app_server_ip" size="15" maxlength="15" value="<%=app_server_ip%>" onBlur="makeValidString(this);"  onKeyPress='return(ChkNumberInput1(this,event,2))'>
					<td class=label><fmt:message key="eSM.DisplaySiteName.label" bundle="${sm_labels}"/></td><td class='FIELDS'>
					
	                <input type='checkbox' name='display_site_name' id='display_site_name' value='<%=chek1%>' <%=chkval%> onClick="Checkdisplay(this);">
					<input type='hidden' name='display_site_name_yn' id='display_site_name_yn' value='<%=chek1%>'>
					</td>


	
	           <tr ><td class='COLUMNHEADER' colspan=4><b><fmt:message key="eSM.HeadoftheUnit.label" bundle="${sm_labels}"/></b></td></tr>
	            <tr>
					<td class=label nowrap ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class="FIELDS" >
							<input type="text" name="head_of_facility_name" id="head_of_facility_name" size="48" maxlength="35" value="<%= head_of_facility_name %>" onBlur="makeValidString(this);">
					</td> 
		</tr>
		<tr>
				<td class=label nowrap ><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
				<td  class="FIELDS">
						<input type="text" name="head_of_facility_job_title" id="head_of_facility_job_title" size="30" maxlength="30" value="<%= head_of_facility_job_title %>" onBlur="makeValidString(this);"></td>
				<td class=label nowrap ><fmt:message key="eSM.LicenseNo.label" bundle="${sm_labels}"/></td>
				<td  class="FIELDS">
						<input type="text" name="license_no" id="license_no" size="15" maxlength="15" value="<%= license_no %>" onBlur="makeValidString(this);"></td>
			</tr>
		<tr ><td class='COLUMNHEADER' colspan=4><b><fmt:message key="eSM.Logo.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></b></td></tr>
				<tr>
					<td class="label" ><fmt:message key="eSM.FacImgFileName.label" bundle="${sm_labels}"/></td>
					<td class="FIELDS" colspan=2>
					<input type="FIELDS" name="fac_logo_file_name" id="fac_logo_file_name" readonly maxlength='40' size='40' value="<%=facility_image_file_name%>"></td>				
					<td></td>					
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Logo.label" bundle="${sm_labels}"/></td>
					<td class="FIELDS" colspan=2>
					<!--<input type="file" name="fac_logo_url" id="fac_logo_url" maxlength='40' size='40' onchange="fac_logo_check()"></td>-->
					<input type="file" name="fac_logo_url" id="fac_logo_url" maxlength='40' id="fac_logo_id" size='40' onkeypress="return onkeyPressEvent(event);" onchange="fac_logo_check();" ></td>
					<td></td>					
				</tr>
		  </table>
		</td>
	</tr>
 </table>
 <%
 %>
<input type="hidden" name="operational_modules" id="operational_modules" value="">

<input type='hidden' name='m_town' id='m_town' value='<%=res_town_code%>'>
<input type='hidden' name='m_area' id='m_area' value='<%=res_area_code %>'>
<input type='hidden' name='m_region' id='m_region' value='<%=region_code%>'>
<input type='hidden' name='m_postal_code' id='m_postal_code' value='<%=addr_postal_code%>'>
<input type='hidden' name='fac_logo_name_flag' id='fac_logo_name_flag' value=''>

<INPUT TYPE="hidden" name="town_code" id="town_code">
<INPUT TYPE="hidden" name="area_code" id="area_code">
<INPUT TYPE="hidden" name="region_code" id="region_code">
<INPUT TYPE="hidden" name="postal_code" id="postal_code">

<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
<input type="hidden" name="isGSTCodeApplicable" id="isGSTCodeApplicable" value="<%=isGSTCodeApplicable%>">

</form>

</center>
</body>
<%
	
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			
		}catch(Exception e){//out.println(e);
			e.printStackTrace();
		}
			finally { 
	ConnectionManager.returnConnection(con,request);
}

%>
</html>

