<!DOCTYPE html>
<%--
	FileName	: addModifyRoom.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/Room.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

     var sStyle='<%=sStyle%>';
function chkRoomStatus(mode)
{
	if(mode == "Modify")
	{
		if(room_form.Room_Count.value > 0)
		{
			alert(getMessage("ROOM_ATTACHED_TO_NU","IP"));
			room_form.eff_status.checked = true ;
			return;
		}
	}
}

function CheckForNumbers(event){
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForSpecNumber(event){
    var strCheck = '&<>';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


/* Added for No of Min & Max Bed on 06/02/04 by Sridhar */
// func to check the MIN value of bed
function CheckMinString(fromobj) {
	if(fromobj.value!="") {
        if(fromobj.value >= 1) {
            return true;
        }
        else 
		{
            alert(getMessage("INVALID_MAX_NUMBER","AM"));
			fromobj.focus();
			return false;
        }
	}
}


function change(){
	
  	if (room_form.resident_stay_yn.value != 'N')
     {
			//room_form.resident_stay_yn.value="Y";
      	 	room_form.privacy_level.disabled=false;
      	 	room_form.inf_disease_yn.disabled=true;
//BED
			room_form.max_bed.disabled = false;
			document.getElementById('nob_img').style.visibility = 'Visible';

 	}
   	else if (room_form.resident_stay_yn.value == 'N')
	{
      		// room_form.resident_stay_yn.checked = false;
      		// room_form.resident_stay_yn.value="N";
      		 room_form.inf_disease_yn.checked=false;
      		 room_form.inf_disease_yn.disabled=true;
      		 room_form.privacy_level.disabled=true;
			document.getElementById('nob_img').style.visibility = 'Hidden';
//BED
			room_form.max_bed.value = "";
			room_form.max_bed.disabled = true;
	}

      	if (room_form.resident_stay_yn.value=='N') 
      		{
      			parent.f_query_mod.document.getElementById("privacy_level").options[0].selected=true;
				room_form.privacy_level.value="";
      			room_form.inf_disease_yn.disabled=true;

      		}
      	}

function Change1()
{
	if (room_form.eff_status.checked == true)
	{
	 	room_form.eff_status.value="E";
	}
	else
      	room_form.eff_status.value="D";
}


function privacy(){
 	if (room_form.privacy_level.value=="F")

 		room_form.inf_disease_yn.disabled=false;

 	else
 		room_form.inf_disease_yn.disabled=true;
 		room_form.inf_disease_yn.checked=false;
 	}


function privacy1(){
 	if (room_form.privacy_level.value=="F")
 			room_form.inf_disease_yn.disabled=false;
  else
 		 room_form.inf_disease_yn.disabled=true;
 		 room_form.inf_disease_yn.checked=false;
 	}



function Click(obj){
 	if (obj.checked==true)
 	   {
 	 	room_form.inf_disease_yn.value="Y";
 		room_form.rad_implant_patients_yn.value="Y";
 		room_form.smoking_yn.value="Y";
 	   }
 	 else
 	   {
 	 	room_form.inf_disease_yn.value="N";
	 	room_form.rad_implant_patients_yn.value="N";
 		room_form.smoking_yn.value="N";
 	   }
 	}

function PopulateBuilding(Obj)
{
	if(Obj.value !='')
	{
			var HTMLVal = new String();
			HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAM/jsp/RoomPopulate.jsp'> "+
					 " <input name='fieldName' id='fieldName' type='hidden' value='fromFac'><input name='operating_facilityID' id='operating_facilityID' type='hidden' value='"+Obj.value+"'></form></BODY></HTML>";
			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.dum_form.submit();
	}
	else
	{
		var n=document.getElementById('bldng_code').options.length;
		for(var i=0;i<n;i++)
		{
			document.getElementById('bldng_code').remove("bldng_code");
		}

		var n1=document.getElementById('floor_code').options.length;
		for(var i1=0;i1<n1;i1++)
		{
			document.getElementById('floor_code').remove("floor_code");
		}

		
		var tp ='-----'+getLabel("Common.defaultSelect.label","Common")+'-----';
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.getElementById('bldng_code').add(opt);
		var tp1 ='-----'+getLabel("Common.defaultSelect.label","Common")+'-----';
		var opt1=document.createElement("OPTION");
		opt1.text=tp1;
		opt1.value="";
		document.getElementById('floor_code').add(opt1);
	}
}

function checkMaximumBed(totalBed)
{
	//if ((Math.abs(totalBed)) < (Math.abs(document.forms[0].maximum_bed.value)))
	var bed_count=document.forms[0].bed_count.value
	if ((Math.abs(totalBed)) < (Math.abs(document.forms[0].maximum_bed.value)) && bed_count!=0 )
	{
		//var error = getIPMessage("DATE1_LT_DATE2");
		var error = getMessage("DATE1_LT_DATE2","IP");
		
		error = error.replace("$",getLabel("eAM.NumberofBedsAllowed.label","AM"));
		error = error.replace("#", Math.abs(document.forms[0].maximum_bed.value));
		alert(error);
		document.forms[0].max_bed.select();
	}
}

</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement();" >
<%	
	
	String facility_name=request.getParameter("facility_name");
		if(facility_name == null) facility_name="";
	String operating_facility_id=request.getParameter("operating_facility_id");
		if(operating_facility_id == null) operating_facility_id="";

	String disbld				= "";
	String  chkFlag				= ""; 
	String longdesc				="";
	String shortdesc			="";
	String telnum				="";
	String bldngcode			="";
	String floorcode			="";
	String floorcode1			="";
	String floordesc1			="";
	String extnum				="";
	String roomnum				="";
	String residentstayyn		="";
	String roomtype				="";
	String effstatus			="";
	String smokingyn			="";
	String privacylevel			="";
	String radimplantpatientsyn	="";
	String codeTextAttribute	="";
	String infdiseaseyn			="";
	String checkBoxAttribute	="";
	String eventFunctionForCase	="";
   	String oxygen				="";
   	String suction				="";
   	String vitalsign			="";
   	String infusionpump			="";
   	String ivpump				="";
   	String eeg					="";
   	String ecg					="";
   	String ventilator			="";
   	String ckVal1				="";
   	String ckVal2				="";
   	String ckVal3				="";
   	String ckVal4				="";
   	String ckVal5				="";
   	String ckVal6				="";
   	String ckVal7				="";
   	String ckVal8				="";
   	String ckValinf				="";
   	String ckValres				="";
   	String ckValsmk				="";
   	String ckValrad				="";
   	String Valpriv				="";
  	String fbldngcode1			="";
	String fbldngdesc1			="";
   	String fnval				="";

long Room_Count = 0;
long bed_count = 0;
Statement codestmt = null;
ResultSet coderset = null;

Statement bdcntstmt = null;
ResultSet bdcntrset = null;

String minbed				="";
String maxbed				="";

   	boolean newSpeciality		=false;
   	String sql					="";
	
	ResultSet rset=null;
	ResultSet rset1=null;
	ResultSet rset2=null;
	ResultSet rset6=null;
	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt  = conn.createStatement();
	PreparedStatement pstmt = null;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String fid=p.getProperty( "login_user" ) ;
	
	String facilityid = (String) session.getValue( "facility_id" ) ;

	String facilityId = request.getParameter("facilityId");
	
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 

	try{
	fnval=request.getParameter("source");	
	roomnum=request.getParameter("room_num");	
	if (roomnum==null){
			roomnum="";
			longdesc="";
			shortdesc="";
			roomtype="";
			telnum="";
			bldngcode=".";
			floorcode="";
			effstatus="E";
			privacylevel="N";
			smokingyn="N";
			oxygen="";
			suction="";
			vitalsign="";
			infusionpump="";
			ivpump="";
			eeg="";
			ecg="";
			ventilator="";
   			extnum="";
			infdiseaseyn="N";
			radimplantpatientsyn="";
			codeTextAttribute="";
			checkBoxAttribute="CHECKED";
			newSpeciality=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";

		}
	else{
	checkBoxAttribute="CHECKED";
	effstatus=request.getParameter("eff_status");
	if(effstatus == null) effstatus="";
	
			stmt= conn.createStatement();
			sql="select NURSING_UNIT_CODE, room_num,room_type,resident_stay_yn,long_desc,short_desc,bldng_code,floor_code,tel_num,ext_num,privacy_level,inf_disease_yn,eff_status,smoking_yn,rad_implant_patients_yn,eqpt_type_1,eqpt_type_2,eqpt_type_3,eqpt_type_4,eqpt_type_5,eqpt_type_6,eqpt_type_7,eqpt_type_8,no_of_beds_min,no_of_beds_max from am_facility_room where operating_facility_id=? and room_num=?";
			//rset=stmt.executeQuery(sql);
			
			pstmt   = conn.prepareStatement(sql);
			pstmt.setString	(	1,	operating_facility_id		);
			pstmt.setString	(	2,	roomnum		);
			rset		 = pstmt.executeQuery();
			if(rset!=null){
			while(rset.next()){
			roomnum=rset.getString("room_num");
			shortdesc=rset.getString("short_desc");
			longdesc=rset.getString("long_desc");
			roomtype=rset.getString("room_type");
			bldngcode=rset.getString("bldng_code");
			floorcode=rset.getString("floor_code");
			telnum=rset.getString("tel_num");
			extnum=rset.getString("ext_num");
			
			if(telnum==null) telnum="";
			if(extnum==null) extnum="";

/// ADDED FOR ENABLE/DISABLE EFF STATUS Validation....... by SRIDHAR
	String CodeSql = "SELECT count(*) as Room_Count from IP_NURSING_UNIT_ROOM where room_no=? and facility_id=?";
	
	//codestmt=conn.createStatement();
	//coderset = codestmt.executeQuery(CodeSql);
	pstmt   = conn.prepareStatement(CodeSql);
	pstmt.setString	(	1,	roomnum		);
	pstmt.setString	(	2,	facilityId		);
	coderset		 = pstmt.executeQuery();
	   
	coderset.next();
	Room_Count = coderset.getInt("Room_Count");
    if(coderset!=null)coderset.close();
	if(codestmt!=null)codestmt.close();
	if(pstmt!=null)pstmt.close();
	/*5/26/2009 IN010880*/
	String sqlbd_cnt = "Select count(*) as bed_count from ip_nursing_unit_bed where room_no=? and facility_id =? ";
	//bdcntstmt=conn.createStatement();
	//bdcntrset=bdcntstmt.executeQuery(sqlbd_cnt);
	pstmt   = conn.prepareStatement(sqlbd_cnt);
	pstmt.setString	(	1,	roomnum		);
	pstmt.setString	(	2,	facilityId		);
	bdcntrset		 = pstmt.executeQuery();
	
	bdcntrset.next();
	bed_count = bdcntrset.getInt("bed_count");
	if(bdcntrset!=null)bdcntrset.close();
	if(bdcntstmt!=null)bdcntstmt.close();
	/**/
			minbed=rset.getString("no_of_beds_min");
			if(minbed==null) minbed="";
			maxbed=rset.getString("no_of_beds_max");

			if(maxbed==null) maxbed="";

			if(maxbed.equals(""))
				disbld = "disabled";
			else
				disbld = "";

			privacylevel=rset.getString("privacy_level");
						
				if (privacylevel!= null)
				{
					if(privacylevel.equals("F"))
						Valpriv=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels");
					else if (privacylevel.equals("P"))
						Valpriv=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels");
					else if (privacylevel.equals("S"))
						Valpriv=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels");
					else if (privacylevel.equals("W"))
						Valpriv=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels");
					else if (privacylevel.equals("N"))
						Valpriv="";
					else if (privacylevel.equals("null"))
						Valpriv="";
					else 
						{
						Valpriv="";	
						}
				}


			residentstayyn=rset.getString("resident_stay_yn");
			if( residentstayyn != null)
			{
					if(residentstayyn.equals("N"))
					{
						ckValres="UNCHECKED";
					}
					else
						ckValres="CHECKED";
				}
			else{
					ckValres="UNCHECKED";
			} 

			infdiseaseyn=rset.getString("inf_disease_yn");
			
			if( infdiseaseyn != null)
				{
					if(infdiseaseyn.equals("N"))
						ckValinf="UNCHECKED";
					else
						ckValinf="CHECKED";
			}
			else{
			ckValinf="UNCHECKED";
			} 

			smokingyn=rset.getString("smoking_yn");
			if( smokingyn != null)
			   {
					if(smokingyn.equals("N"))
						ckValsmk="UNCHECKED";
					else
						ckValsmk="CHECKED";
			}
			else
			ckValsmk="UNCHECKED";
					
			radimplantpatientsyn=rset.getString("rad_implant_patients_yn");
			if(radimplantpatientsyn == null || radimplantpatientsyn.equals("null"))
				radimplantpatientsyn = "N";
				if(radimplantpatientsyn.equals("N"))
					ckValrad="UNCHECKED";
				else
					ckValrad="CHECKED";

			oxygen=rset.getString("eqpt_type_1");
			if( oxygen != null)
				{
					if(!oxygen.equals("OXY"))
						ckVal1="UNCHECKED";
					else
						ckVal1="CHECKED";
				}
			else
			ckVal1="UNCHECKED";

			suction=rset.getString("eqpt_type_2");
			if( suction != null)
				{
					if(!suction.equals("SUC"))
						 ckVal2="UNCHECKED";
					else
						 ckVal2="CHECKED";
			}
			else
			ckVal2="UNCHECKED";
			
			vitalsign=rset.getString("eqpt_type_3");
			if( vitalsign != null)
				{
					if(!vitalsign.equals("VIT"))
						ckVal3="UNCHECKED";
					else
						ckVal3="CHECKED";
				}
			else
			ckVal3="UNCHECKED";
			
			infusionpump=rset.getString("eqpt_type_4");
			if( infusionpump != null)
			{
					if(!infusionpump.equals("INF"))
						ckVal4="UNCHECKED";
					else
						ckVal4="CHECKED";
			}
			 else
			 ckVal4="UNCHECKED";

		 	ivpump=rset.getString("eqpt_type_5");
			if( ivpump == null) ivpump="";
			if(ivpump != null) 
			{
					if(!ivpump.equals("IVP"))
						ckVal5="UNCHECKED";
					else
						ckVal5="CHECKED";
			}
			else
			ckVal5="UNCHECKED";
			
			eeg=rset.getString("eqpt_type_6");
			if( eeg!= null)
			{
					if(!eeg.equals("EEG"))
						ckVal6="UNCHECKED";
					else
						ckVal6="CHECKED";
			}
			else
			ckVal6="UNCHECKED";

			ecg=rset.getString("eqpt_type_7");
			if( ecg != null)
			{
					if(!ecg.equals("ECG"))
						ckVal7="UNCHECKED";
					else
		   				ckVal7="CHECKED";
		   	}
		   	else
		   	 ckVal7="UNCHECKED";
				
						
			ventilator=rset.getString("eqpt_type_8");
			if( ventilator == null) ventilator="";
					if( ventilator != null)
					{
							if(!ventilator.equals("VEN"))
								ckVal8="UNCHECKED";
							else
								ckVal8="CHECKED";
					}
					else
						ckVal8="UNCHECKED";
			effstatus=rset.getString("eff_status");
			
				if(effstatus.equals("D"))
				{
					checkBoxAttribute="";
				}
				else
				{
					
		 		}
		}
		if (rset != null ) rset.close();
		if (stmt!=null) stmt.close();//while
	}//if
}
if(rset!=null)rset.close();

%>
<form name='room_form' id='room_form' action='../../servlet/eAM.RoomServlet' method='post' target='messageFrame'>

<center>
<BR><BR>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
	<td class="BORDER" width="100%">
	   <table border='0' cellpadding='0'cellspacing='1' width='100%'>

		<tr>
		<td   width="30%"  class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td width="30%"   class="field" nowrap>
		<% if (fnval==null) { %> 
		&nbsp;<select name='facility' id='facility'  onChange='PopulateBuilding(this)' >
		<option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
    				       <%
    				    		String ID="",dat="",en="";
    				    		if(rset!=null)rset.close();
								if(stmt!=null) stmt.close();
								stmt=conn.createStatement();
    				    		rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+fid+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("Operating_facility_id");
    				    			ID=rset.getString("facility_id");
    				    			if(ID.equals(facilityId))
    				    			  en="selected";
    				    			else
    				    			    en="";
    				    			out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");

    				    		   }
    				    		   }
									if(rset!=null) rset.close();
    				    		   %>
						  </select>
					<% } else { 
						out.println("&nbsp;<input type='text' readOnly name='facility_name' id='facility_name' size='60' value=\""+facility_name+"\">");
						out.println("<input type='hidden' name='facility' id='facility' value='"+operating_facility_id+"'>");
					 } %> 
						  <img src='../../eCommon/images/mandatory.gif' align='center'></img></tr></td>
						  
				</tr>
				<tr>
<% 				if (fnval==null)/*IF THE VALUE IS INSERT*/
				     {
%>					<td  width="30%"  class="label"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			      <td width="30%" class="field">&nbsp;<input type="text"  name="room_num" id="room_num" value="<%=roomnum%>"  onKeyPress="return CheckForSpecChars(event)"  size='10' maxlength='10' <%=codeTextAttribute%><%=eventFunctionForCase%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></tr></td>

<%            }
			    else
			        {
%>       	     	<td width="30%" class="label"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			        	<td  width="30%"  class="field">&nbsp;<input type="text" name="room_num" id="room_num" onKeyPress="return CheckForSpecChars(event)"   value="<%=roomnum%>"  size='10'maxlength='10' <%=codeTextAttribute%><%=eventFunctionForCase%>  readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' ></img></tr></td>
<%
			        }				
					


     if (fnval == null)
      {
%>			<td  width="25%" class="label"><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
				<td width="20%"   class="field">&nbsp;<select name="bldng_code" id="bldng_code" onChange='PopulateFloorList()'>
	  		<OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
			stmt=conn.createStatement();
			 // rset2 = stmt.executeQuery( "select bldng_code,short_desc from am_bldng where eff_status='E'and operating_facility_id ='"+facilityId+"' order by short_desc");
			 String sqlStm1 = "select bldng_code,short_desc from am_bldng where eff_status='E'and operating_facility_id =? order by short_desc";
					  
				pstmt   = conn.prepareStatement(sqlStm1);
				pstmt.setString	(	1,	facilityId		);
				rset2		 = pstmt.executeQuery();

while( rset2.next() )
					   {
					     fbldngcode1 = rset2.getString( "bldng_code" ) ;
					     fbldngdesc1 = rset2.getString( "short_desc" ) ;

					     if (bldngcode==null || bldngcode.equals("null") ||bldngcode.equals(""))
							      	out.println( "<option value='" + fbldngcode1 + "' >" + fbldngdesc1 ) ;
							 else
							    {
							     if(bldngcode.equals(fbldngcode1))
							        out.println( "<option value='"  + fbldngcode1 + "' selected>" + fbldngdesc1 ) ;
							      else
							         out.println( "<option value='" + fbldngcode1 + "' >" + fbldngdesc1 ) ;
									}
					   }
					 %>  </select></td></tr>
			<%}	
			
			else if (fnval.equals("Modify") && (effstatus.equalsIgnoreCase("D")))
			{

%>
				<td width="25%"  class="label"><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
				<td width="20%"  class="field">

<%
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
stmt=conn.createStatement();
	     	//rset6 = stmt.executeQuery( "select bldng_code,short_desc from am_bldng where bldng_code ='"+bldngcode+"' and operating_facility_id ='"+operating_facility_id+"' order by short_desc");
			
			String sqlStm2 ="select bldng_code,short_desc from am_bldng where bldng_code =? and operating_facility_id =? order by short_desc";
			pstmt   = conn.prepareStatement(sqlStm2);
			pstmt.setString	(	1,	bldngcode		);
			pstmt.setString	(	2,	operating_facility_id		);
			rset6		 = pstmt.executeQuery();

	     	String bld1="";
				String bld2="";

	      while (rset6.next())
	  		 {

						fbldngcode1 = rset6.getString( "bldng_code" ) ;
						fbldngdesc1 = rset6.getString( "short_desc" ) ;

						if(bldngcode.equals(fbldngcode1 ))
							{
									bld1=fbldngcode1 ;
									bld2=fbldngdesc1 ;
							}
				 }
						  if (bldngcode==null || bldngcode.equals("null") ||bldngcode.equals(""))
						  {
						   		 out.println( "&nbsp;<input type='text' value='"+ fbldngdesc1+"' readOnly></td></tr>");
						  }
						  else
						  {
						   	  {
										out.println("<input type='hidden' name='bldng_code' id='bldng_code' value='" + bld1 + "' >") ;
	  		  					out.println("&nbsp;<input type='text'  name='bldng_short_desc' id='bldng_short_desc' value='"+bld2+"' size='15'maxlength='15' readonly></td></tr>") ;
	        			  }
      		    }
			 }

			else if (fnval.equals("Modify") && (effstatus.equalsIgnoreCase("E")))

			{

%>			<td width="25%"  class="label"><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
				<td  width="20%"  class="field">&nbsp;<select name="bldng_code" id="bldng_code" onChange='PopulateFloorList()'>
		 		<OPTION VALUE=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%
				if(rset2!=null)rset2.close();		
if(stmt!=null) stmt.close();
if(pstmt!=null) pstmt.close();
stmt=conn.createStatement();
			//	rset2 = stmt.executeQuery("select bldng_code,short_desc from am_bldng where eff_status ='E' and operating_facility_id ='"+operating_facility_id+"' order by short_desc");
			String sqlStm3="select bldng_code,short_desc from am_bldng where eff_status ='E' and operating_facility_id =? order by short_desc";
				
				pstmt   = conn.prepareStatement(sqlStm3);
				pstmt.setString	(	1,	operating_facility_id		);
				rset2		 = pstmt.executeQuery();

					while( rset2.next() )
					   {
					     fbldngcode1 = rset2.getString( "bldng_code" ) ;
					     fbldngdesc1 = rset2.getString( "short_desc" ) ;

					     if (bldngcode==null || bldngcode.equals("null") ||bldngcode.equals(""))
							      	out.println( "<option value='" + fbldngcode1 + "' >" + fbldngdesc1 ) ;
							 else
							    {
							     if(bldngcode.equals(fbldngcode1))
							        out.println( "<option value='"  + fbldngcode1 + "' selected>" + fbldngdesc1 ) ;
							      else
							         out.println( "<option value='" + fbldngcode1 + "' >" + fbldngdesc1 ) ;
									}
					   }
			}
%>				</select></td>

				</tr>

				<tr>

<%
if(rset2!=null)rset2.close();				  
if (fnval==null)
				   {
%>
			        	<td width="30%"class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			        	<td width="30%"   class="field">&nbsp;<input type="text" onBlur="makeValidString(this)"  name="long_desc" id="long_desc" value="<%=longdesc%>" size='30'maxlength='30' ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
<%
			     }
			    else
			     { if(effstatus.equals("D")) chkFlag="readOnly"; 
%>
					<td width="30%"  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			    <td  width="30%"  class="field">&nbsp;<input type="text" name="long_desc" id="long_desc" onBlur='makeValidString(this)' value="<%=longdesc%>" size='30'maxlength='30' <%=chkFlag%> ><img src='../../eCommon/images/mandatory.gif' align="center"></img></td>
<%
			     }


			    if(fnval==null)/*IF the Mode is INSERT*/
			    {
%>
					<td width="25%"  class="label"><fmt:message key="Common.floor.label" bundle="${common_labels}"/></td>
					<td width="20%"  class="field">&nbsp;<select name="floor_code" id="floor_code">
		      <OPTION VALUE=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%

				   if(rset2!=null)rset2.close();
				   if(stmt!=null) stmt.close();
				   if(pstmt!=null) pstmt.close();
stmt=conn.createStatement();
					//rset2 = stmt.executeQuery( "select floor_code,short_desc from am_bldng_floor where bldng_code='"+bldngcode+"'and operating_facility_id ='"+operating_facility_id+"' and EFF_STATUS ='E' ");
					String sqlStm4="select floor_code,short_desc from am_bldng_floor where bldng_code=?and operating_facility_id =? and EFF_STATUS ='E' ";
					
					pstmt   = conn.prepareStatement(sqlStm4);
					pstmt.setString	(	1,	bldngcode		);
					pstmt.setString	(	2,	operating_facility_id		);
					rset2		 = pstmt.executeQuery();
					
						 while( rset2.next() )
							 {
							     floorcode1=(rset2.getString("floor_code")==null)?"":rset2.getString("floor_code");
							     floordesc1=(rset2.getString("short_desc")==null)?"":rset2.getString("short_desc");

							    if (floorcode==null || floorcode.equals("null") ||floorcode.equals(""))
							   	// out.println( "<option value='' >select" ) ;
							   	out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
							    else
							    {
							    if(floorcode.equals(floorcode1)  )
							     	 out.println( "<option value='" + floorcode1 + "' selected>" + floordesc1 ) ;
							     else
							     	out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
							    }
							 }
					}

				else if (fnval.equals("Modify") && (effstatus.equalsIgnoreCase("D")))
				  {
%>
				<td width="25%" class="label"><fmt:message key="Common.floor.label" bundle="${common_labels}"/></td>
				<td width="20%"   class="field">&nbsp;<select name="floor_code" id="floor_code" disabled>
			 	<OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%
				if(rset2!=null) rset2.close();
				if(stmt!=null) stmt.close();
				if(pstmt!=null) pstmt.close();
stmt=conn.createStatement();
                //  rset2 = stmt.executeQuery( "select floor_code,short_desc from am_bldng_floor where bldng_code='"+bldngcode+"'and operating_facility_id ='"+operating_facility_id+"' and EFF_STATUS='E'");
				  
				  String sqlStm5="select floor_code,short_desc from am_bldng_floor where bldng_code=? and operating_facility_id =? and EFF_STATUS='E'";
					pstmt   = conn.prepareStatement(sqlStm5);
					pstmt.setString	(	1,	bldngcode		);
					pstmt.setString	(	2,	operating_facility_id		);
					rset2		 = pstmt.executeQuery();
				   while( rset2.next() )
				   {
				      floorcode1=rset2.getString("floor_code");
				      floordesc1=rset2.getString("short_desc");

				      if (floorcode==null || floorcode.equals("null") ||floorcode.equals(""))
						 out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
						else
						    {
						    if (floorcode.equals(floorcode1))
						    	 out.println( "<option value='" + floorcode1 + "' selected>" + floordesc1 ) ;
						    else
							   out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
							    }
				   }
				}


       		else if (fnval.equals("Modify") && (effstatus.equalsIgnoreCase("E")))
         	{
%>
				<td width="25%"  class="label"><fmt:message key="Common.floor.label" bundle="${common_labels}"/></td>
				<td width="20%"  class="field">&nbsp;<select name="floor_code" id="floor_code">
			 	<OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
<%             
				 if(rset2!=null) rset2.close();
if(stmt!=null) stmt.close();
stmt=conn.createStatement();
                //rset2 = stmt.executeQuery( "select floor_code,short_desc from am_bldng_floor where bldng_code='"+bldngcode+"'and operating_facility_id ='"+operating_facility_id+"' and EFF_STATUS='E'");
				
				String sqlStm6="select floor_code,short_desc from am_bldng_floor where bldng_code=?and operating_facility_id =? and EFF_STATUS='E'";
				pstmt   = conn.prepareStatement(sqlStm6);
				pstmt.setString	(	1,	bldngcode		);
				pstmt.setString	(	2,	operating_facility_id		);
				rset2		 = pstmt.executeQuery();
				   while( rset2.next() )
				   {
				      floorcode1=rset2.getString("floor_code");
				      floordesc1=rset2.getString("short_desc");

				      if (floorcode==null || floorcode.equals("null") ||floorcode.equals(""))
											 out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
							else
							    {
								    if (floorcode.equals(floorcode1))
								     	 out.println( "<option value='" + floorcode1 + "' selected>" + floordesc1 ) ;
								    else
										   out.println( "<option value='" + floorcode1 + "' >" + floordesc1 ) ;
							    }
				   }
				}
%>    			</select></TD></tr>

 

<% //	out.println("here 1");	
	if (fnval==null)
			    {	
%>
			   <tr>	<td  width="30%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td  width="30%"   class="field">&nbsp;<input type="text" onBlur='makeValidString(this)' name="short_desc" id="short_desc" value="<%=shortdesc%>"size='15'maxlength='15' ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
<%
				  }
				else
				  { if(effstatus.equals("D")) chkFlag="readOnly"; 

%>				<td  width="30%"  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td  width="30%"   class="field">&nbsp;<input type="text" name="short_desc" id="short_desc" onBlur='makeValidString(this)' value="<%=shortdesc%>"size='15'maxlength='15' <%=chkFlag%> ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
<%
				  }
%>
  </tr>

  <tr>

<%
     if (fnval==null)
       {
%>			     <td  width="30%"  class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				     <td  width="30%"  class="field">&nbsp;<select name="locn_type" id="locn_type">
				      <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>

<%
	if(stmt!=null) stmt.close();
stmt=conn.createStatement();
		   rset1 = stmt.executeQuery( "select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind in ('R')) order by short_desc");
		   if( rset1 != null )
				 {
				  while( rset1.next() )
					 {
				     String faccode1 = rset1.getString( "locn_type" ) ;
				     String facdesc1 = rset1.getString( "short_desc" ) ;

				     //if ( faccode1.equals( faccode1 ) )
	//				     out.println( "<option selected value=\"" + faccode1 + "\"> "+ facdesc1);
	//			     else
					     out.println( "<option value=\"" + faccode1 + "\" >" + facdesc1 ) ;
					 }
			  }
%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
<%
			 }
		  else if(fnval.equals("Modify"))
		   {
			  
		     if(effstatus.equals("E"))
		      {

%>
		    		<td  width="30%"  class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		    		<td  width="30%"   class="field">&nbsp;<select name="locn_type" id="locn_type"><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>

<%
	if(stmt!=null) stmt.close();
stmt=conn.createStatement();
	rset1 = stmt.executeQuery( "select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('R')  order by short_desc");
					if( rset1 != null )
					{							
						while( rset1.next() )
						{
							String faccode1 = rset1.getString( "locn_type" ) ;
							String facdesc1 = rset1.getString( "short_desc" ) ;
							if ( roomtype.equals(faccode1) )
								out.println( "<option value='" + faccode1 + "' selected > "+ facdesc1);
							else
								out.println( "<option value='" + faccode1 + "' >" + facdesc1 ) ;
						}
					}
%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>

<%				      	 }
 					else
 					 {
%>
					<td  width="30%"  class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				  <td  width="30%"  class="field">
<%if(stmt!=null) stmt.close();
stmt=conn.createStatement();		  
	rset1 = stmt.executeQuery( "select locn_type,short_desc from am_care_locn_type where  locn_type='"+roomtype+"'");
					String faccode1 ="";
					String facdesc1="";
					if( rset1 != null )
					 {
								 while( rset1.next() )
								 {
							      faccode1 = rset1.getString( "locn_type" ) ;
					  	      facdesc1 = rset1.getString( "short_desc" ) ;
								 }
					}

					out.println("&nbsp;<input type='text' name='locn_type_desc' id='locn_type_desc' value=\""+facdesc1+"\" size='15'maxlength='15'  readonly><input type='hidden' name='locn_type' id='locn_type' value='"+faccode1+"' size='15'maxlength='15'  readonly></td>");
%>
<%				}
		 }
%>
<%
			
				if (fnval==null)
				  {
%>
			   	<td  width="25%"  class="label"><fmt:message key="eAM.ResidentStay.label" bundle="${am_labels}"/></td>
					<td  width="20%"   class="field">&nbsp;<select name='resident_stay_yn' id='resident_stay_yn' onchange ='change();'>
						<option value='N'>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
						<option value='Y'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
						</select></td>
<%
				 }
				 else
				 { 
				 
					 if(effstatus.equals("E"))
				    {
%>
					<td  width="25%"  class="label"><fmt:message key="eAM.ResidentStay.label" bundle="${am_labels}"/></td>
					<td  width="20%"   class="field">&nbsp;<select name='resident_stay_yn' id='resident_stay_yn' onchange ='change();' disabled>
						<option value='N'>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<option value='Y'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
						<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
						</select></td>

<%
	if(residentstayyn.equals("N")){%><script>
	room_form.resident_stay_yn.options[0].selected = true;
	/*4/29/2009 IP-ICN-IN010235_RoomCubicle*/
	room_form.resident_stay_yn.disabled = false;
	/**/
	</script>
	<%}
	else if(residentstayyn.equals("Y"))%><script>
	room_form.resident_stay_yn.options[1].selected = true;</script><%
	else if(residentstayyn.equals("D"))%><script>
	room_form.resident_stay_yn.options[2].selected = true;</script><%
				    }
				 else
				    {

%>				        <td  width="25%" class="label"><fmt:message key="eAM.ResidentStay.label" bundle="${am_labels}"/></td>
					<td  width="20%"   class="field">&nbsp;<select name='resident_stay_yn' id='resident_stay_yn' disabled>
						<option value='N'>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----
						<option value='Y'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
						<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
						</select></td>
	<%
	if(residentstayyn.equals("N")){%><script>
	room_form.resident_stay_yn.options[0].selected = true;
	/*4/29/2009 IP-ICN-IN010235_RoomCubicle*/
	room_form.resident_stay_yn.disabled = false;
	/**/
	</script><%}
	else if(residentstayyn.equals("Y"))%><script>
	room_form.resident_stay_yn.options[1].selected = true;</script><%
	else if(residentstayyn.equals("D"))%><script>
	room_form.resident_stay_yn.options[2].selected = true;</script>
<%				    }
				}
%>
			        </tr>
				<tr>
<%			  if (fnval==null)
                                {
%>
					<td  width="30%"  class="label"><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
					<td  width="30%"   class="field">&nbsp;<input type="text" onKeyPress='return CheckForSpecNumber(event)' onBlur='makeValidString(this)'  name="tel_num" id="tel_num" value="<%=telnum%>" size='18'maxlength='18' ></td>

					<td  width="25%"   class="label"><fmt:message key="Common.Ext.label" bundle="${common_labels}"/></td>
					<td  width="20%"  class="field">&nbsp;<input type="text" onKeyPress='return CheckForSpecNumber(event)' onBlur='makeValidString(this)'  name="ext_num" id="ext_num" value="<%=extnum%>" size='6'maxlength='6' ></td>

<%
				 }
			   else
			   	 { if(effstatus.equals("D")) chkFlag="readOnly"; 
%>					<td width="30%" class="label"><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
					<td width="30%"   class="field">&nbsp;<input type="text" onKeyPress='return CheckForSpecNumber(event)' onBlur='makeValidString(this)' name="tel_num" id="tel_num" value="<%=telnum%>" size='18'maxlength='18' <%=chkFlag%> ></td>

					<td width="25%"   class="label"><fmt:message key="Common.Ext.label" bundle="${common_labels}"/></td>
					<td width="20%"   class="field">&nbsp;<input type="text" name="ext_num" id="ext_num" onBlur='makeValidString(this)' onKeyPress='return CheckForSpecNumber(event)' value="<%=extnum%>" size='6'maxlength='6' <%=chkFlag%> ></td>
<%				  }

%>
				</tr>
				<tr>
						<td  width='30%'  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td width='30%'  class='field'>
						<input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="chkRoomStatus('<%=fnval%>');Change1();"></td>

    			</tr>
		</table>
	</td>
  </tr>

   <tr><td nowrap class="EMPTY"></td></tr>
   <th align='left'  colspan='4'><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></th>
 <!-- CHARACTERISTICS ---->
<%
 if (fnval==null)
 {
%>
<!-- CHARACTERISTICS INSERT---->
  <tr>
  	<td class="BORDER" width="100%">
  	   <table border='0' cellpadding='0'cellspacing='0' width='100%'>

  				<tr>
  							<td  width="30%"  class="label"><fmt:message key="Common.RoomCubicleStatus.label" bundle="${common_labels}"/></td>
  			       	<td width="30%"   class="field">&nbsp;<select name="privacy_level" id="privacy_level" disabled onChange="privacy();">
		      			<OPTION VALUE=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</OPTION>
		      			<option value='F'><fmt:message key="Common.Isolation.label" bundle="${common_labels}"/></option>
		      			<option value='P'><fmt:message key="Common.PrivateRoom.label" bundle="${common_labels}"/></option>
		      			<option value='S'><fmt:message key="Common.SemiPrivateRoom.label" bundle="${common_labels}"/></option>
		      			<option value='W'><fmt:message key="Common.RoomCubicle.label" bundle="${common_labels}"/></option>
		    			</select>


 								<td  width="25%"  class="label"><fmt:message key="Common.InfectiousDisease.label" bundle="${common_labels}"/></td>
  				     	<td width="20%"   class="field"><input type="checkbox" name="inf_disease_yn" id="inf_disease_yn" value="<%=infdiseaseyn%>" size='1'maxlength='1' onClick="Click(this)" <%=ckValinf%> disabled> </tr></td>
  				</tr>
  				<tr></tr>
<!-- bed Main -->
<!--/****** Added No Of Beds Max on 05/02/04 by Sridhar for Emal Enhancement *********/-->


 <tr>
  			       	<td  width="30%"  class="label"><fmt:message key="eAM.NoofBeds.label" bundle="${am_labels}"/></td>
  			       	<td  width="30%"  colspan=3 class="field"><!-- <input type="text" name="min_bed" id="min_bed" value="" size='3' maxlength='3' onKeyPress='return allowValidNumber(this,event,3,0)' onBlur="CheckMinString(this)">&nbsp;&nbsp;Max&nbsp;&nbsp;&nbsp; -->

					&nbsp;<input type="text" name="max_bed" id="max_bed" value="" size='3' maxlength='3' onKeyPress='return CheckForNumbers(event)' onBlur="CheckMinString(this)" Disabled><img src='../../eCommon/images/mandatory.gif' align='center' name="nob_img" id="nob_img" style="visibility:Hidden"></img></td>
  				</tr> 
				<!--***************** End of addition for No of beds max  ******************* -->
				<!-- bed -->
  				<tr>
  			       	<td  width="30%" class="label"><fmt:message key="eAM.UsablebyRadiationImplantPatients.label" bundle="${am_labels}"/></td>
  			       	<td  width="30%"  class="field"><input type="checkbox" name="rad_implant_patients_yn" id="rad_implant_patients_yn" value="<%=radimplantpatientsyn%>" size='1' maxlength='1' onClick="Click(this)"></td>

  							<td  width="25%" class="label"><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/></td>
  							<td  width="20%"   class="field"><input type="checkbox" name="smoking_yn" id="smoking_yn" value="<%=smokingyn%>" size='1'maxlength='1' onClick="Click(this)" ></td>
  				</tr>

      			</tr>

  		</table>
  	</td>
  </tr>

<%
   }
    else
   {
     if(effstatus.equals("E"))  /*CHARACTERISTICS ENABLED DATA*/
       {

%>
  <!-- CHARACTERISTICS MODIFY---->
   <tr>
      <!--If the value is Modify then do the foll changes for the recs with eff_status=Enabled-->

    <td  class="BORDER" width="100%">
    	<table border='0' cellpadding='3'cellspacing='0' width='100%'>
    	<tr>

    				<td nowrap width="30%"  class="label"><fmt:message key="Common.RoomCubicleStatus.label" bundle="${common_labels}"/></td>
    				<td nowrap width="30%"   class="field">&nbsp;<select name="privacy_level" id="privacy_level"  onChange="privacy1();">

<%
	if (!(privacylevel==null) && !(privacylevel.equals("null")) && !(privacylevel.equals("")))
 			     {
		      		
					 String ward_select="";
					 String priv_select="";
					 String iso_select="";
					 String semi_select="";

					 if (Valpriv.equals("Room/Cubicle"))
		      		 {
						ward_select="selected";
						out.println("<option value=''>---- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						out.println("<option value='F' "+iso_select+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
		      		 	out.println("<option value='P' "+priv_select+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
		      		 	out.println("<option value='S' "+semi_select+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
		      			out.println("<OPTION VALUE='"+privacylevel+"' "+ward_select+" >"+Valpriv+"</option>");

		      		 }
		      		 else if (Valpriv.equals("Isolation"))
		      		 {
						out.println("<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						out.println("<option value='F' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
						out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
		      		 	out.println("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
						out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");
						
		      		 }
		      		 else if (Valpriv.equals("Semi Private Room"))
		      		 {
						out.println("<option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
						out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
		      		 	out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
						out.println("<OPTION VALUE='"+privacylevel+"' selected>"+Valpriv+"</option>");
						out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");
		      		 	
		      		 }
		      		 else if (Valpriv.equals("Private Room"))
		      		 {
						out.println("<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
						out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
						out.println("<OPTION VALUE='"+privacylevel+"' selected>"+Valpriv+"</option>");	
						out.println("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
		      		 	out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");
		      		 	
		      		 }
		      	  else if (Valpriv.equals(""))
		      		 {
								out.println("<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");				
				   				out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
								out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
			      			 	out.println("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
								out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");

		      	     }
				else 
		      		 {
								out.println("<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
				   				out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
								out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
			      			 	out.println("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
								out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");

		      	     }

		      	 }
				 else 
		      		 {
								out.println("<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----");
				   				out.println("<option value='F'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+"</option>");
								out.println("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrivateRoom.label","common_labels")+"</option>");
			      			 	out.println("<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SemiPrivateRoom.label","common_labels")+"</option>");
								out.println("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+"</option>");
		      	     }
%>
		    		</select>
		        </td>
		    		<td  width="25%"  class="label"><fmt:message key="Common.InfectiousDisease.label" bundle="${common_labels}"/></td>
  				<td  width="20%"   class="field"><input type="checkbox" name="inf_disease_yn" id="inf_disease_yn" value="<%=infdiseaseyn%>" size='1'maxlength='1' onClick="Click(this)" disabled> </tr></td>

    				</tr>
    				<tr></tr>
<!-- bed -->
 <tr>
				   	<td width="30%"  class="label"><fmt:message key="eAM.NoofBeds.label" bundle="${am_labels}"/></td>
  			       	<td width="30%" colspan=3 class="field">&nbsp;<input <%=disbld%> type="text" name="max_bed" value="<%=maxbed%>" size='3' maxlength='3' onKeyPress='return CheckForNumbers(event)' onBlur="checkMaximumBed(this.value);CheckMinString(this)"><img src='../../eCommon/images/mandatory.gif' align='center' name="nob_img" id="nob_img" style="visibility:Hidden"></img></td>
</tr> 

<%
   if (ckValres.equalsIgnoreCase("CHECKED"))
		out.println("<script>document.forms[0].max_bed.disabled=false;document.getElementById('nob_img').style.visibility = 'Visible'</script>");
   else
		out.println("<script>document.getElementById('nob_img').style.visibility = 'Hidden';document.forms[0].max_bed.disabled=true;</script>");
%>
    				<tr>
	  			  	<td width="30%"  class="label" ><fmt:message key="eAM.UsablebyRadiationImplantPatients.label" bundle="${am_labels}"/></td>
    			   	<td width="30%"   class="field"><input type="checkbox" name="rad_implant_patients_yn" id="rad_implant_patients_yn" value="<%=radimplantpatientsyn%>" size='1' maxlength='1' <%=ckValrad%> onClick="Click(this)"></td>

    					<td width="25%"  class="label"><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/></td>
    					<td width="20%"   class="field"><input type="checkbox" name="smoking_yn" id="smoking_yn" value="<%=smokingyn%>" size='1'maxlength='1'  <%=ckValsmk%> onClick="Click(this)"></td>
    				</tr>

       		</tr>

    		</table>
    	</td>
  </tr>

<%
      }
     else if(effstatus.equals("D"))
      {
%>
     <tr>
          <!--If the value is Modify then do the foll changes for the recs with eff_status=DISABLED-->

         	<td nowrap class="BORDER" width="100%">
         	<table border='0' cellpadding='3'cellspacing='0' width='100%'>

         		<tr>
         		  <%  if (Valpriv.equals("----Select----"))
         		  		{
											Valpriv="";
						}
         		  %>
         			<td width="30%" class="label"><fmt:message key="eAM.PrivacyLevel.label" bundle="${am_labels}"/></td>
       			      <td width="30%"   class="field">
     		      		<input type='text' name='privacy_level1' id='privacy_level1' value="<%=Valpriv%>" onBlur='makeValidString(this)'  size='20'maxlength='20'  readonly>
     		      		<input type='hidden' name='privacy_level' id='privacy_level' value='<%=privacylevel%>' >
     		      		</select>

     		    	<td width="25%"  class="label"><fmt:message key="Common.InfectiousDisease.label" bundle="${common_labels}"/></td>
       				<td width="20%"  class="field"><input type="checkbox" name="inf_disease_yn" id="inf_disease_yn" value="<%=infdiseaseyn%>" size='1'maxlength='1'  disabled <%=ckValinf%>> </tr></td>

         		</tr>

<!-- bed -->
<tr>
  			       	 <td width="30%"  class="label"><fmt:message key="eAM.NoofBeds.label" bundle="${am_labels}"/></td>
  			       	<td width="30%" colspan=3 class="field"><input type="text" name="max_bed" id="max_bed" value="<%=maxbed%>" size='3' maxlength='3' onKeyPress='return CheckForNumbers(event)' disabled></td>
</tr> 
<!-- bed -->
         		<tr>
         		  <td width="30%"  class="label" nowrap><fmt:message key="eAM.UsablebyRadiationImplantPatients.label" bundle="${am_labels}"/></td>
         		  <td width="30%"   class="field"><input type="checkbox" name="rad_implant_patients_yn" id="rad_implant_patients_yn" value="<%=radimplantpatientsyn%>" size='1' maxlength='1' <%=ckValrad%>  disabled></td>

         		  <td  width="25%"  class="label"><fmt:message key="Common.Smoking.label" bundle="${common_labels}"/></td>
         		  <td  width="20%"   class="field"><input type="checkbox" name="smoking_yn" id="smoking_yn" value="<%=smokingyn%>" size='1'maxlength='1'  <%=ckValsmk%>  disabled></td>
         		</tr>

     			</tr>

    		 </table>
   			 </td>
 		 </tr>
<%

     }

    }
%>
  <tr><td nowrap class="EMPTY"></td></tr>


  <tr><th align=left colspan='4'><fmt:message key="eAM.AvailableEquipment.label" bundle="${am_labels}"/></th></tr>

<!-- EQUIPMENTS ---->

<%
 if (fnval==null)
 {
%>
  <tr>
  	<td nowrap class="BORDER" width="100%">
  	   <table border='0' cellpadding='0'cellspacing='0' width='100%'>
  				<tr>

  					<td  width="30%"  class="label"><fmt:message key="eAM.Oxygen.label" bundle="${am_labels}"/></td>
  			        	<td  width="30%"   class="field">&nbsp;<input type="checkbox" name="oxygen" id="oxygen" value="oxygen"  size='1' maxlength='1' onClick="PopulateEquipment(this)"></tr></td>

  					<td width="25%"  class="label"><fmt:message key="eAM.IVPump.label" bundle="${am_labels}"/></td>
  			        	<td width="20%"   class="field">&nbsp;<input type="checkbox" name="ivpump" id="ivpump" value="ivpump"  size='1' maxlength='1' onClick="PopulateEquipment(this)"></tr></td>
  				</tr>
  				<tr></tr>
  				<tr>
  			        	<td width="30%"  class="label"><fmt:message key="eAM.Suction.label" bundle="${am_labels}"/></td>
  			        	<td width="30%"   class="field">&nbsp;<input type="checkbox" name="suction" id="suction" value="suction" size='1' maxlength='1' onClick="PopulateEquipment(this)"></td>


  					<td width="25%"  class="label"><fmt:message key="eAM.ElectroEncephelogram.label" bundle="${am_labels}"/></td>
  					<td width="20%"  class="field">&nbsp;<input type="checkbox" name="eeg" id="eeg" value="eeg" size='1' maxlength='1' onClick="PopulateEquipment(this)" ></td>

  			  </tr>
  			  <tr>
				   	<td  width="30%"  class="label"><fmt:message key="Common.VitalSigns.label" bundle="${common_labels}"/></td>
				   	<td  width="30%"   class="field">&nbsp;<input type="checkbox" name="vitalsign" id="vitalsign" value="vitalsign" size='1' maxlength='1' onClick="PopulateEquipment(this)"></td>


					  <td width="25%"  class="label"><fmt:message key="eAM.ElectroCardiogram.label" bundle="${am_labels}"/></td>
					  <td width="20%"   class="field">&nbsp;<input type="checkbox" name="ecg" id="ecg" value="ecg" size='1' maxlength='1'  onClick="PopulateEquipment(this)"></td>
				  </tr>

  			  <tr>
				   	<td width="30%" class="label"><fmt:message key="eAM.InfusionPump.label" bundle="${am_labels}"/></td>
				   	<td width="30%"   class="field">&nbsp;<input type="checkbox" name="infusionpump" id="infusionpump" value="infusionpump" size='1' maxlength='1' onClick="PopulateEquipment(this)" ></td>


				  	<td  width="25%"  class="label"><fmt:message key="eAM.Ventilator.label" bundle="${am_labels}"/></td>
				  	<td width="20%"   class="field">&nbsp;<input type="checkbox" name="ventilator" id="ventilator" value="ventilator" size='1' maxlength='1' onClick="PopulateEquipment(this)" ></td>
  			  </tr>
  		</table>
  	</td>
  </tr>
  <%
  }
  else
  {
    if(effstatus.equals("E"))
    {
   %>
  <tr>
    	<td  class="BORDER" width="100%">
    	   <table border='0' cellpadding='0'cellspacing='0' width='100%'>
    				<tr>
    					<td  width="30%"  class="label"><fmt:message key="eAM.Oxygen.label" bundle="${am_labels}"/></td>
    			    <td width="30%"   class="field">&nbsp;<input type="checkbox" name="oxygen" id="oxygen" value="<%=oxygen%>"  size='1' maxlength='1' <%=ckVal1%> onClick="PopulateEquipment(this)" value='modify' readonly></tr></td>

    					<td width="25%"  class="label"><fmt:message key="eAM.IVPump.label" bundle="${am_labels}"/></td>
    			    <td  width="20%"  class="field">&nbsp;<input type="checkbox" name="ivpump" id="ivpump" value="<%=ivpump%>"  size='1' maxlength='1' <%=ckVal5%> onClick="PopulateEquipment(this)"></tr></td>
    				</tr>
    				<tr></tr>
    				<tr>
    			    <td width="30%"  class="label"><fmt:message key="eAM.Suction.label" bundle="${am_labels}"/></td>
    			    <td width="30%"   class="field">&nbsp;<input type="checkbox" name="suction" id="suction" value="<%=suction%>" size='1' maxlength='1' <%=ckVal2%> onClick="PopulateEquipment(this)"></td>

    					<td width="25%"  class="label"><fmt:message key="eAM.ElectroEncephelogram.label" bundle="${am_labels}"/></td>
    					<td  width="20%"  class="field">&nbsp;<input type="checkbox" name="eeg" id="eeg" value="<%=eeg%>" size='1' maxlength='1'<%=ckVal6%>  onClick="PopulateEquipment(this)"></td>

    			  </tr>
    			  <tr>
  				   	<td  width="30%"  class="label"><fmt:message key="Common.VitalSigns.label" bundle="${common_labels}"/></td>
  				   	<td width="30%"  class="field">&nbsp;<input type="checkbox" name="vitalsign" id="vitalsign" value="<%=vitalsign%>" size='1' maxlength='1' <%=ckVal3%> onClick="PopulateEquipment(this)"></td>

  				  	<td  width="25%"  class="label"><fmt:message key="eAM.ElectroCardiogram.label" bundle="${am_labels}"/></td>
  						<td  width="20%"   class="field">&nbsp;<input type="checkbox" name="ecg" id="ecg" value="<%=ecg%>" size='1' maxlength='1'  <%=ckVal7%> onClick="PopulateEquipment(this)"></td>
  				  </tr>

    			  <tr>
  				   	<td  width="30%" class="label"><fmt:message key="eAM.InfusionPump.label" bundle="${am_labels}"/></td>
  				   	<td  width="30%"  class="field">&nbsp;<input type="checkbox" name="infusionpump" id="infusionpump" value="<%=infusionpump%>" size='1' maxlength='1' <%=ckVal4%>  onClick="PopulateEquipment(this)"></td>

  				   	<td  width="25%" class="label"><fmt:message key="eAM.Ventilator.label" bundle="${am_labels}"/></td>
  				  	<td  width="20%"  class="field">&nbsp;<input type="checkbox" name="ventilator" id="ventilator" value="<%=ventilator%>" size='1' maxlength='1' <%=ckVal8%> onClick="PopulateEquipment(this)" ></td>
  				  </tr>

    		</table>
    	</td>
    </tr>

  <%
   }

  else if(effstatus.equals("D")){

  %>


  <tr>
      	<td  class="BORDER" width="100%">
      	   <table border='0' cellpadding='0'cellspacing='0' width='100%'>
      			<tr>
      					<td  width="30%"  class="label"><fmt:message key="eAM.Oxygen.label" bundle="${am_labels}"/></td>
      			   	<td  width="30%"   class="field">&nbsp;<input type="checkbox" name="oxygen" id="oxygen" value="<%=oxygen%>"  size='1' maxlength='1' <%=ckVal1%> onClick="PopulateEquipment(this)" value='modify' disabled></tr></td>

   					<td  width="25%"  class="label"><fmt:message key="eAM.IVPump.label" bundle="${am_labels}"/></td>
     			   	<td  width="20%"   class="field">&nbsp;<input type="checkbox" name="ivpump" id="ivpump" value="<%=ivpump%>"  size='1' maxlength='1' <%=ckVal5%> onClick="PopulateEquipment(this)" disabled></tr></td>
      				</tr>
      				<tr></tr>

      			<tr>
      			        	<td  width="30%" class="label"><fmt:message key="eAM.Suction.label" bundle="${am_labels}"/></td>
      			        	<td  width="30%"  class="field">&nbsp;<input type="checkbox" name="suction" id="suction" value="<%=suction%>" size='1' maxlength='1' <%=ckVal2%> onClick="PopulateEquipment(this)" disabled></td>


      					<td  width="25%"  class="label"><fmt:message key="eAM.ElectroEncephelogram.label" bundle="${am_labels}"/></td>
      					<td  width="20%"   class="field">&nbsp;<input type="checkbox" name="eeg" id="eeg" value="<%=eeg%>" size='1' maxlength='1'<%=ckVal6%>  onClick="PopulateEquipment(this)" disabled></td>

      			        </tr>
      			        <tr>
    				       	<td  width="30%"  class="label"><fmt:message key="Common.VitalSigns.label" bundle="${common_labels}"/></td>
    				       	<td  width="30%"   class="field">&nbsp;<input type="checkbox" name="vitalsign" id="vitalsign" value="<%=vitalsign%>" size='1' maxlength='1' <%=ckVal3%> onClick="PopulateEquipment(this)" disabled></td>


    					<td  width="25%"  class="label"><fmt:message key="eAM.ElectroCardiogram.label" bundle="${am_labels}"/></td>
    					<td  width="20%"   class="field">&nbsp;<input type="checkbox" name="ecg" id="ecg" value="<%=ecg%>" size='1' maxlength='1'  <%=ckVal7%> onClick="PopulateEquipment(this)" disabled></td>

      			        </tr>

      			        <tr>
    				       	<td  width="30%" class="label"><fmt:message key="eAM.InfusionPump.label" bundle="${am_labels}"/></td>
    				       	<td  width="30%"   class="field">&nbsp;<input type="checkbox" name="infusionpump" id="infusionpump" value="<%=infusionpump%>" size='1' maxlength='1' <%=ckVal4%>  onClick="PopulateEquipment(this)" disabled></td>


    				  	<td  width="25%"  class="label"><fmt:message key="eAM.Ventilator.label" bundle="${am_labels}"/></td>
    				  	<td  width="20%"   class="field">&nbsp;<input type="checkbox" name="ventilator" id="ventilator" value="<%=ventilator%>" size='1' maxlength='1' <%=ckVal8%> onClick="PopulateEquipment(this)" disabled ></td>

      			        </tr>
      		</table>
      	</td>
    </tr>
  <%
      }
   }
  %>
</table>
<%
	if(effstatus!=null && effstatus.equals("E"))
	{
		if(Valpriv !=null && Valpriv.equals("Isolation"))
		{
			if(infdiseaseyn !=null && infdiseaseyn.equals("Y"))
				{
					%>
					<script>
					document.forms[0].inf_disease_yn.disabled=false;
					document.forms[0].inf_disease_yn.checked=true;
					</script>
					<%
				}
				else
				{
					%>
					<script>
					document.forms[0].inf_disease_yn.disabled=false;
					document.forms[0].inf_disease_yn.checked=false;
					</script>
					<%
				}
			}
			
	}

if(residentstayyn.equals("N"))
{
out.println("<script>document.forms[0].privacy_level.disabled=true</script>");
}

}catch(Exception e)
	{
		//out.println("here123  "+ e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if(rset!=null) rset.close();
		if(rset1!=null) rset1.close();
		if(rset2!=null) rset2.close();
		if(rset6!=null) rset6.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(conn,request);

	
	}
	if(newSpeciality){
%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>
      	<!-- <script>PopulateBuilding(document.forms[0].facility)</script> -->

<%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>

      	<input type='hidden' name='eff_date_from' id='eff_date_from' >
      	<input type='hidden' name='eff_date_to' id='eff_date_to' >
		<input type='hidden' name='source' id='source' value="<%=fnval%>">

		
		<input type='hidden' name='Room_Count' id='Room_Count' value="<%=Room_Count%>">
		<input type='hidden' name='maximum_bed' id='maximum_bed' value="<%=maxbed%>">
		<input type='hidden' name='maxi_bed' id='maxi_bed' value="<%=maxbed%>">
		<input type='hidden' name='flor_code' id='flor_code' value="">
		<input type='hidden' name='bed_count' id='bed_count' value="<%=bed_count%>">
		

</center>
</form>
</body>
</html>

