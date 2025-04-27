<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,eBL.Common.*,com.ehis.util.*,eBL.*,java.sql.*,blipin.*,java.util.*"  %>
<%/***************Addded for package billing******************/%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='<%=request.getParameter("field7")%>' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	String bed_type="",billing_group="",bed_no="",parent="";
	Connection			con			=	null;
	PreparedStatement	stmt		=	null;
	ResultSet			rs		=	null;
	con					=	ConnectionManager.getConnection(request);
	String result = "",sql="";
	//String result = "",sql="",sql1="";
	String bed_ref="";
	String modified_bed_type_ref = "";
	String reasonForTransfer = "";
	/******************ADDDED FOR PACKAGE BILLING**********************/
	String facility_id			= (String)session.getAttribute("facility_id");
	String patient_id = "";
	String p_episode_id = "";
	String sameblngClassYN = "N";
	String error_text = "";
	String pkg_dtls="";
	String pkg_seq_no="";
	String pkg_code="";
	String pkg_desc="";
	StringTokenizer pkgSt=null;			
	String bl_package_enabled_yn="N";
	/******************END FOR PACKAGE BILLING**********************/
	
	try
	{
		bed_type = request.getParameter("field1");
		billing_group = request.getParameter("field2");
		bed_no = request.getParameter("field3");
		parent = request.getParameter("field4");
		bed_ref = request.getParameter("field5");
		modified_bed_type_ref = request.getParameter("field6");
		reasonForTransfer = checkForNull(request.getParameter("reasonForTransfer"),"");
				
		/******************ADDDED FOR PACKAGE BILLING**********************/	
		try{

			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facility_id+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(bl_package_enabled_yn == null) bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();	
			if(bl_package_enabled_yn.equals("Y"))
			{
				String bean_id		= "PkgAssociateBean" ;
				String bean_name	= "eBL.PkgAssociateBean";
				PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;	
				patient_id = request.getParameter("field8");
				if(parent.equals("Admission"))
				{
				ArrayList  patPackAssociateDtls=(ArrayList)bean.getAssociatedPkgs();	
				if(patPackAssociateDtls!=null && patPackAssociateDtls.size()>0)
				{
					for(int i=0;i<patPackAssociateDtls.size();i++)
					{
						pkg_dtls=(String)patPackAssociateDtls.get(i);
						pkgSt=new StringTokenizer(pkg_dtls,"~~");
						if(pkgSt.hasMoreTokens())
							pkg_code=(String)pkgSt.nextToken();
						else
							pkg_code="";
						if(pkgSt.hasMoreTokens())
						pkg_desc=(String)pkgSt.nextToken();
						else
							pkg_desc="";
						//
						if(pkgSt.hasMoreTokens()){
							if(pkg_seq_no.equals(""))
							{
								pkg_seq_no=(String)pkgSt.nextToken();	
							}
							else{
								pkg_seq_no=pkg_seq_no+"|"+(String)pkgSt.nextToken();	
							}
						}
						else
							pkg_seq_no="";
					}
				}
				if(!pkg_seq_no.equals(""))
				{				
					CallableStatement call_pkg = con.prepareCall("{ call  blpackage.IsBlngClassSameAsPkg_Adm(?,?,?,?,?,?)}");				
					call_pkg.setString(1,facility_id);
					call_pkg.setString(2,patient_id);
					call_pkg.setString(3,bed_type);
					call_pkg.setString(4,pkg_seq_no);	
					call_pkg.registerOutParameter(5,java.sql.Types.VARCHAR);
					call_pkg.registerOutParameter(6,java.sql.Types.VARCHAR);
					call_pkg.execute();	
					sameblngClassYN = call_pkg.getString(5);		
					error_text = call_pkg.getString(6);						
					
					if ( sameblngClassYN == null ) sameblngClassYN = "";
					if ( error_text == null ) error_text = "";
					call_pkg.close();

				}else{
					sameblngClassYN="Y";
				}
				}else if(parent.equals("Transfer"))
				{
					p_episode_id =request.getParameter("field9");			
					String patientid123	= (String)session.getValue("patientid");
					String encounter_id123	= (String)session.getValue("encounter_id");

					try{
					CallableStatement call_pkg1 = con.prepareCall("{ call  blpackage.IsBlngClassSameAsPkg_Trf(?,?,?,?,?,?,?)}");				
					call_pkg1.setString(1,facility_id);
					call_pkg1.setString(2,patientid123);
					call_pkg1.setString(3,bed_type);
					call_pkg1.setString(4,"I");	
					call_pkg1.setString(5,encounter_id123);	
					call_pkg1.registerOutParameter(6,java.sql.Types.VARCHAR);
					call_pkg1.registerOutParameter(7,java.sql.Types.VARCHAR);
					call_pkg1.execute();	
					sameblngClassYN = call_pkg1.getString(6);		
					error_text = call_pkg1.getString(7);						
					
					if ( sameblngClassYN == null ) sameblngClassYN = "";
					if ( error_text == null ) error_text = "";
					call_pkg1.close();
				}catch (Exception e)
				{ 
					

					e.printStackTrace();
				}
				}
		}
		}catch (Exception e)
		{ 
			
			e.printStackTrace();
		}
			
		
	/******************END FOR PACKAGE BILLING**********************/
				
		sql= "select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group+"','"+bed_type+"') from dual";
		result = "";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while(rs.next())
		{
			result = rs.getString(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

	}catch (Exception e)
	{ 
		out.println ("Exception :"+e); 
		e.printStackTrace();
	}
	finally 
	{
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}	

%>
	<script>
	async function callPkgElgibility(sameblngClassYN,val,error_text)
	{		
		if(error_text!="")
		{
			alert(error_text);
			return false;
		}
		var js =  "<%=request.getParameter("field7")%>";
		if(sameblngClassYN=='N')
		{
			/*var dialogTop	= "330";
			var dialogHeight= "10" ; 
			var dialogWidth	= "30" ;	
			var dialogLeft	= "200" ;*/
			var dialogTop	= "300";
			var dialogHeight= "8" ; 
			var dialogWidth	= "30" ;	
			var dialogLeft	= "200" ;
			
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;scrolling=no;valign=center; dialogLeft: "+dialogLeft ; 
				
			var arguments			= "" ;
			var tit				= "Package Eligibility by Billing Class";
			var bed_type = "<%=bed_type%>";
				var billing_group = "<%=billing_group%>";
				var bed_no = "<%=bed_no%>";
				var bed_ref = "<%=bed_ref%>";
				var bed_type_ref = "<%=modified_bed_type_ref%>";	retVal=await window.showModalDialog("../../eBL/jsp/pkgEligibilityByBlngClass.jsp?bed_type="+bed_type+"&billing_group="+billing_group+"&bed_no="+bed_no+"&title="+encodeURIComponent(tit),arguments,features);	
				if(retVal==undefined || retVal=='undefined'){
					retVal='N';	}
			if(retVal != null)
			{
				if(retVal=='Y')
				{
					showModal(val);
				}else{
					if((js == '../js/AdmitPatient.js') ||(js == '../js/AdmitPatient1.js'))
							{
								parent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value='Y';
								parent.frames[0].location.href ='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN';
								eval(bed_ref).onblur();

							}
							else if(js == '../js/EmergencyTransfer.js')
							{
								parent.frames[1].document.forms[0].transfer.disabled=false;
								parent.frames[1].location.reload();						
							}
							else if(js == '../js/ConfirmBedClass.js')
							{
								parent.frames[1].location.reload();
							}
							else if(js == '../js/TransferPatient.js')
							{
								parent.frames[1].location.reload();
							}
							else if(js == '../js/AssignBedDetail.js')
							{
								parent.frames[1].location.reload();
							}
							/*2/23/2009 7067	MF-CRF-0059	IP*/
							else if(js == '../js/PatientEmergencyTransfer.js')
							{
								parent.frames[1].document.forms[0].confirm.disabled=false;
								parent.frames[1].location.reload();
							}
							
						}
			}
		}else{
			showModal(val);}
	}
	async function showModal(val)
	{
		var js =  "<%=request.getParameter("field7")%>";
		if(val == 'Y')
		{
			var dialogTop	= "200";
			var dialogHeight= "600px" ;  
			var dialogWidth	= "1200px" ;	
			var dialogLeft	= "90" ;
			
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;scrolling=no;valign=center; dialogLeft: "+dialogLeft ;
				
			var arguments			= "" ;
			var tit				= "Patient Charging Basis on "+"<%=parent%>";
			var bed_type = "<%=bed_type%>";
			var billing_group = "<%=billing_group%>";
			var bed_no = "<%=bed_no%>";
			var bed_ref = "<%=bed_ref%>";
			var bed_type_ref = "<%=modified_bed_type_ref%>";
			var reasonForTransfer = "<%=reasonForTransfer%>";
			
			//retVal=window.showModalDialog("../../eBL/jsp/BLCheckEligibilityLevel.jsp?bed_type="+bed_type+"&billing_group="+billing_group+"&bed_no="+bed_no+"&title="+encodeURIComponent(tit),arguments,features);
			/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
			var retVal = "";
			var reqRadioBtn = "";
			var remarks	= "";
			/*End*/
			retArr=await window.showModalDialog("../../eBL/jsp/BLCheckEligibilityLevel.jsp?bed_type="+bed_type+"&billing_group="+billing_group+"&bed_no="+bed_no+"&reasonForTransfer="+reasonForTransfer+"&title="+encodeURIComponent(tit),arguments,features);
			
			if(retArr != null)
			{	
				/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
				
				if(retArr.length == '3'){
					retVal		= retArr[0];
					reqRadioBtn	= retArr[1];
					/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start*/
					remarks		= retArr[2];
					var frameRef	= "";	
					if((js == '../js/AdmitPatient.js') ||(js == '../js/AdmitPatient1.js')) {
						frameRef	= parent.frames[1].frames[2].document.AdmitPatient_form;
					}else if(js == '../js/EmergencyTransfer.js' || js == '../js/PatientEmergencyTransfer.js'){
						frameRef	= parent.frames[1].document.forms[0];
					}

					if(frameRef!=""){
						if(frameRef.bl_adm_remarks!=null){
							frameRef.bl_adm_remarks.value = remarks;
						}

						if(frameRef.bl_bed_request!=null){
							frameRef.bl_bed_request.value = reqRadioBtn;
						}
						if(frameRef.bl_bed_type_code!=null){
							frameRef.bl_bed_type_code.value = retVal;
						}
						
					}
					/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End*/
						
											
				}else if (retArr.length == '5')
				{
					retVal = retArr;
				}/*End*/
				if(retVal == 'close' || retVal=='0')
				{	
		
					if((js == '../js/AdmitPatient.js') ||(js == '../js/AdmitPatient1.js'))
					{
						parent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value='Y';
						parent.frames[0].location.href ='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN';
						eval(bed_ref).onblur();

					}
					else if(js == '../js/EmergencyTransfer.js')
					{
						parent.frames[1].document.forms[0].transfer.disabled=false;
						parent.frames[1].location.reload();						
					}
					else if(js == '../js/ConfirmBedClass.js')
					{
						parent.frames[1].location.reload();
					}
					else if(js == '../js/TransferPatient.js')
					{
						parent.frames[1].location.reload();
					}
					else if(js == '../js/AssignBedDetail.js')
					{
						parent.frames[1].location.reload();
					}
					/*2/23/2009 7067	MF-CRF-0059	IP*/
					else if(js == '../js/PatientEmergencyTransfer.js')
					{
						parent.frames[1].document.forms[0].confirm.disabled=false;
						parent.frames[1].location.reload();
					}
					
				}
				else if(retVal != '')
				{
					//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017				
					eval(bed_type_ref).value  = retVal;
					if(js == '../js/EmergencyTransfer.js')
						applyone_em('Y', val, reqRadioBtn);
					else if(js == '../js/ConfirmBedClass.js')
						applyone_confirm('Y', reqRadioBtn);
					/*2/23/2009 7067	MF-CRF-0059	IP*/
					else if(js == '../js/PatientEmergencyTransfer.js')
						applyone_emp('Y', val, reqRadioBtn);
					else
						applyone('Y', val, reqRadioBtn);
				}
				else
				{
					//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017			
					if(js == '../js/EmergencyTransfer.js')
						applyone_em('Y', val, reqRadioBtn);
					else if(js == '../js/ConfirmBedClass.js')
						applyone_confirm('Y', reqRadioBtn);
					/*2/23/2009 7067	MF-CRF-0059	IP*/
					else if(js == '../js/PatientEmergencyTransfer.js')
						applyone_emp('Y', val, reqRadioBtn);
					else
						applyone('Y', val, reqRadioBtn);
				}
			}
			else
			{
				parent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value='Y';
				parent.frames[0].location.href ='../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN';
				eval(bed_ref).onblur();
				
			}
		}
		else if(val == 'N')
		{	
			//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017
			if(js == '../js/EmergencyTransfer.js')
				applyone_em('Y', val, '');
			else if(js == '../js/ConfirmBedClass.js')
				applyone_confirm('Y','');
			/*2/23/2009 7067	MF-CRF-0059	IP*/
			else if(js == '../js/PatientEmergencyTransfer.js')
				applyone_emp('Y', val, '');
			else
				applyone('Y', val, '');
		}
	}
		
</script>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
if(bl_package_enabled_yn.equals("Y"))
{
	out.println("<script>callPkgElgibility('"+sameblngClassYN+"','"+result+"','"+error_text+"');</script>");
}else{
	out.println("<script>showModal('"+result+"');</script>");
}
%>

</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

