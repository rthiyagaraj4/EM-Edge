<!DOCTYPE html>
<!--
Same as previous version(Formatted)
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
14/12/2011    IN29519     Dinesh T    SKR-SCF-0298, Validation done for the practitioner ids
30/11/2012    IN035422    Chowminya G Ca user cant complete the Blood Unit Consumption details. Error ? Error in practitioner selection?.  
11/02/2013    IN036376    Chowminya G To default the logged in practitioner ?s name in the ?Practitioner Name?
28/02/2013    IN036376.1    Chowminya G To default the logged in practitioner ?s name in the ?Practitioner Name?
-----------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<head>
<title><fmt:message key="eCA.RecordConsumption.label" bundle="${ca_labels}"/></title>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<%  
	String login_user;
	Properties p=null;
	HttpSession httpSession = request.getSession(false);
	p = (Properties)httpSession.getValue("jdbc"); 
	login_user =  p.getProperty("login_user");
	String locale = p.getProperty("LOCALE");
	String patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String specimen_no =  request.getParameter("specimen_no")==null?"":request.getParameter("specimen_no");
	String unit_no =  request.getParameter("unit_no")==null?"":request.getParameter("unit_no");
	String product_desc =  request.getParameter("product_desc")==null?"":request.getParameter("product_desc");
	String facility_id =  request.getParameter("order_facility_id")==null?"":request.getParameter("order_facility_id");
	String product_code =  request.getParameter("product_code")==null?"":request.getParameter("product_code");
	String blood_group =  request.getParameter("blood_group")==null?"":request.getParameter("blood_group");
	String rhesus_code =  request.getParameter("rhesus_code")==null?"":request.getParameter("rhesus_code");
	//String transfuse_pract_id1="";
	//String transfuse_pract_id2="";
	//String reaction_code="";      
	//String remarks="";
	//String check_pract_id="";
	String strVolumeUnits="";
	String current_vol="";
	//String start_date_time="";
	//String end_date_time="";
	String location_code="";
	//String partial_check="";
	//String partial_trans_code="";
	String Issued_date="";
	String Reserved_date="";
	String sys_date="";
	//String classValue	= "gridData";
	String sql = "";
	int    i	= 0;
	String practitioner_name ="";//IN036376
%>
<script language='javascript'>

	function funBTReactionDetailBlur(obj)
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			document.getElementById('adverse_reaction').style.visibility='hidden';
			return false;			
		}
		else
		{
			funBTReactionDetail();
		}
	} 


	function funBTReactionDetail()
	{
		var target				= document.forms[0].REACTION_DESC;
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		/*
		Added by kishore kumar N on 29/04/2010 for ICN-20903
		*/
		var title				= encodeURIComponent(getLabel("Common.Reaction.label",'COMMON')); 
		var search_text			= document.forms[0].REACTION_DESC.value;
		search_text				= encodeURIComponent(search_text);

		/*
		ends here.
		*/
		var retArray = window.showModalDialog("../../eCA/jsp/TaskListBTReactionMain.jsp?search_text="+search_text+"&title="+title,arguments,features);

		var arr=new Array();

		if (retArray != null && retArray != '' && retArray !='undefined' )
		{
			var retArray = unescape(retArray);
			arr=retArray.split(",");
			document.forms[0].reaction_code.value = arr[0];
			document.forms[0].REACTION_DESC.value = arr[1];

			if(arr[2] == 'Y')
			{
				document.getElementById('adverse_reaction').style.visibility="visible";
				//alert(getMessage("TRANS_INVESTIGATE","CA")); //Added by Archana Dhal related to IN022960
				alert(getBTMessage('BT0218','BT'));//Added by Archana Dhal related to IN023128
			}
			else
			{
				document.getElementById('adverse_reaction').style.visibility="hidden";
			}
		}
		else		
		{
			document.forms[0].reaction_code.value = '';
			document.forms[0].REACTION_DESC.value = '';
		}
	}

	function funBTCheckDetail1Blur(obj,flag)
	{
		if((obj.value) == "null" || (obj.value == ""))
		{
			return false;			
		}
		else
		{
			funBTCheckDetail1(flag);
		}
	}
 
	function funBTCheckDetail1(flag)
	{
		var dialogTop			= "40";
		var dialogHeight		= "10";
		var dialogWidth			= "40";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var target			= '';
		var title;

		if(flag == '1')
		{
			title = getLabel("eCA.TransfusebyPractitioner.label",'CA');
		}
		else if(flag == '2')
		{
			title = getLabel("Common.practitioner.label",'COMMON');
		}
		else
		{
			title = getLabel("eCA.CheckbyPractitioner.label",'CA');
		}

		if(flag=='3')
		{
			target = document.forms[0].Checked_Practioner;
		}
		else
		if(flag=='1')
		{
			target = document.forms[0].Practioner_Name1;
		}
		else
		{
			target = document.forms[0].Practioner_Name2;		 
		}

		var sql;
		var locale      = document.forms[0].locale.value;
		var facilityid      = document.forms[0].facility_id.value;
		sql=escape("select USER_ID code,USERNAME description from SY_USER_LANG_VW where upper(USER_ID) like upper(?) and upper(USERNAME) like upper(?) and FACILITY_ID='"+facilityid+"' and language_id='"+locale+"'"); //--[IN035422]

	//	sql=escape("SELECT A.PRACTITIONER_ID code, A.SHORT_NAME description FROM AM_PRACTITIONER A, AM_PRACT_FOR_FACILITY B WHERE upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) and B.FACILITY_ID = '"+facilityid+"' AND A.PRACTITIONER_ID = B.PRACTITIONER_ID") ;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = CommonLookup( title, argArray );

		var arr=new Array();

		if(retArray == null || retArray == undefined) 
			retArray = '';

		if(retArray != null && retArray !="")
		{
			var retArray=unescape(retArray);

			if(retArray != null)
			{			
				arr=retArray.split(",");

				if(flag=='3')
				{
					document.forms[0].Checked_Practioner.value = arr[1];
					document.forms[0].check_pract_id.value = arr[0];
				}
				else
				if(flag=='1')
				{
					document.forms[0].Practioner_Name1.value = arr[1];
					document.forms[0].transfuse_pract_id1.value = arr[0];
				}
				else
				{
					document.forms[0].Practioner_Name2.value = arr[1];
					document.forms[0].transfuse_pract_id2.value = arr[0];
				} 
			}
			else		
			{
				if(flag=='3')
				{
					document.forms[0].Checked_Practioner.value ='';
					document.forms[0].check_pract_id.value = '';
				}
				else
				if(flag=='1')
				{
					document.forms[0].Practioner_Name1.value = '';
					document.forms[0].transfuse_pract_id1.value = '';
				}
				else
				{
					document.forms[0].Practioner_Name2.value = '';
					document.forms[0].transfuse_pract_id2.value = '';
				}
			}
		}
		/*
		Added by kishore kumar N on 29/04/2010 for ICN-20903
		*/
		else
		{
			target.value = '';
		}
		/*
		ends here.
		*/
	}

	function closeWindow()
    {
		parent.window.close();
	}

	function checkSTDate(objSt,objIS,objRE)
	{
		var locale		= document.forms[0].locale.value;
		
		if(objSt==null||objSt.value=='') 
		{			
			return;
		}
		if(objSt.value !='')
		{
			if(!doDateTimeChk(objSt))
			{
				alert(getMessage("INVALID_DATE_TIME","SM"))
				objSt.focus();
				return false
			}

			if(!(isBeforeNow(objSt.value,"DMYHM",locale) ))
			{
				alert(getMessage("DATE_ST_LT_SYS","CA")); 
				objSt.select();
				objSt.focus();
				return false;
			}

			var obj1=changeDate(objSt.value);
			var obj2=changeDate(objIS.value);
			var obj3=changeDate(objRE.value);


			if(obj1 < obj2 )
			{ 	
				//BT0114,DATE_ST_GT_ISSUE
				alert(getMessage("DATE_ST_GT_ISSUE","CA"));
				objSt.value='';
				return;
			}

			//BT0115,DATE_ST_LT_RESER
			if(obj1 > obj3)       
			{ 
				alert(getMessage("DATE_ST_LT_RESER","CA"));
				objSt.value='';
				return;
			}
		}
	}

	function checkEnDate(objEt,objTR,objRE,objSYS)
	{
		var locale		= document.forms[0].locale.value;

		if(objEt==null||objEt.value=='')
		{	  
			return ;
		}

		if(objEt.value !='')
		{
			if(!doDateTimeChk(objEt))
			{
				alert(getMessage("INVALID_DATE_TIME","SM"))
				objEt.focus();
				return false
			}
			//Date Validation message changed by Archana Dhal related to IN18784
			if(!isBeforeNow(objEt.value,"DMYHM",locale))
			{
				alert(getMessage("DATE_EN_LT_SYS","CA"));
				objEt.select();
				objEt.focus();
				return false;
			}

			var obj1=changeDate(objEt.value);
			var obj2=changeDate(objTR.value);
			var obj3=changeDate(objRE.value);
			var obj4=changeDate(objSYS.value);

			//BT0117,DATE_EN_LT_SYS
			//Commented by Archana Dhal related to IN18784
			/*if(obj1 > obj4 ) {	    
			alert(getMessage("DATE_EN_LT_SYS","CA"));
			objEt.value='';
			return;}*/
			//BT0118,DATE_EN_GT_TRANS

			if(obj1 < obj2)    
			{ 
				alert(getMessage("DATE_EN_GT_TRANS","CA"));
				objEt.value='';
				return;
			}

			//BT0119,DATE_EN_LT_RESER
			if(obj1 > obj3)     
			{  
				alert(getMessage("DATE_EN_LT_RESER","CA"));
				objEt.value='';
				return;
			}	
		}
	}


	function changeDate(objEt)
	{
		var objStr=new Array();
		objStr=objEt.split("/");
		var datVal='';

		if(objStr != null && objStr.length>0)
		{
			datVal+=objStr[1]+"/";
			datVal+=objStr[0]+"/";
			datVal+=objStr[2];
		}
		else	 
			datVal=objEt;

		var dat=new Date(datVal);
		return dat;
	}  

	function funCheck(objChe)
	{
		objFrm=document.forms[0];

		if(objChe.checked == true)
		{	
			objFrm.TRANS_BS.disabled=false;
			objFrm.TRANS_DESC.disabled=false;
			objFrm.partial_check.value='Y';//Added by Archana Dhal related to IN023128 on 8/9/2010.
		}
		else
		{
			objFrm.TRANS_BS.disabled=true;
			objFrm.TRANS_DESC.disabled=true;
			objFrm.partial_check.value='N';//Added by Archana Dhal related to IN023128 on 8/9/2010.
			objFrm.partial_trans_code.value='';
			objFrm.TRANS_DESC.value='';
		} 
	}

	function funBTReasonDetailBlur(obj)
	{
		//var target			= document.forms[0].TRANS_DESC;
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			funBTReasonDetail();
		}
	}

	function funBTReasonDetail()
	{
		var target			= document.forms[0].TRANS_DESC;
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title = getLabel("Common.reason.label",'COMMON');
		var sql ;	
		var obj=document.forms[0];
		//sql=escape("SELECT REASON_CODE REASON_CODE1,SHORT_DESC SHORT_DESC1  FROM RL_REASON_CODE_LANG_VW WHERE REASON_TYPE='BT' AND NVL (STATUS,'X') <> 'S' AND LANGUAGE_ID='"+obj.locale.value+"'");
		sql=escape("Select REASON_CODE code, SHORT_DESC description from RL_REASON_CODE_LANG_VW where upper(REASON_CODE) like upper(?) and SHORT_DESC like upper(?) and REASON_TYPE='BT' AND NVL (STATUS,'X') <> 'S' and language_id = '"+obj.locale.value+"'") ;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;

		retArray = CommonLookup( title, argArray );
		var arr=new Array();

		if(retArray == null) 
			retArray='';

		if (retArray != null || retArray!="")
		{
			var retArray=unescape(retArray);

			if(retArray != null && retArray.length>0)
			{
				arr=retArray.split(",");
				document.forms[0].partial_trans_code.value = arr[0];
				document.forms[0].TRANS_DESC.value = arr[1];
			}
			else		
			{
				document.forms[0].partial_trans_code.value = '';
				document.forms[0].TRANS_DESC.value = '';
			}
		}
	}

	function Apply()
	{
		var fields = new Array (document.forms[0].start_date_time,
		document.forms[0].end_date_time,
		document.forms[0].Checked_Practioner,
		document.forms[0].Practioner_Name1,
		document.forms[0].REACTION_DESC //Added by Archana Dhal on 4/26/2010 related to IN020903. 
		);
		//IN29519,starts
		obj = document.all;
		
		if(obj.transfuse_pract_id1.value != obj.LOGIN_USER.value) 
		{
			if (obj.transfuse_pract_id2.value != null)
			{		
				if(obj.transfuse_pract_id2.value != obj.LOGIN_USER.value)
				{
					alert(getBTMessage('BT0266','BT'));
					return false;
				}
			}
			else
			{
				alert(getBTMessage('BT0266','BT'));
				return false;
			}
		}
		//IN29519,ends

		var names = new Array ( getLabel("Common.startdatetime.label","COMMON"),
		getLabel("Common.EndDateTime.label","COMMON"),
		getLabel("eCA.CheckbyPractitioner.label","CA"),
		getLabel("eCA.TransfusebyPractitioner.label","CA"),
		getLabel("Common.Reaction.label",'COMMON') //Added by Archana Dhal on 4/26/2010 related to IN020903. 
		);

		if(document.forms[0] != null)
		{
			if(checkFieldsofMst( fields, names, parent.messageFrame)) 
			{
				document.forms[0].method ='post'
				document.forms[0].action ='../../servlet/eCA.TaskListBTTransfuseServlet'
				document.forms[0].target='messageFrame'
				document.forms[0].submit();
			}
		}
		else
		{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	    
</head>
<%	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

	try
	{
		con = ConnectionManager.getConnection(request);
		sql="SELECT   NVL (b.current_volume, 0) current_volume, NVL (d.short_desc, '') volume_units, a.storage_loc_code, TO_CHAR (a.ISSUED_DATE, 'dd/mm/yyyy HH24:MI') ISSUED_DATE, TO_CHAR (a.RESERVED_DATE, 'dd/mm/yyyy HH24:MI') RESERVED_DATE FROM bt_unit_request_dtl a, bt_blood_units_mast b, bt_uom_mast_lang_vw d WHERE a.patient_id = ? AND d.language_id = ? AND a.operating_facility_id = ? AND b.unit_no = a.unit_no AND b.product_code = a.product_code and a.PRODUCT_CODE = ?  and a.UNIT_NO = ? and a.SPECIMEN_NO = ? AND NVL (a.unit_status, 'UO') IN ('UI', 'UR') AND NVL (b.volume_units, 'X') = d.uom_code ORDER BY a.issued_date";

		/*
			Added by Kishore kumar N on 05-05-2010, for the Incident 20903
		*/	

		PreparedStatement pst = null;
		ResultSet rs1 = null;
		String descSQL = "SELECT SHORT_DESC PRODUCT_DESC FROM "+
			" BT_PRODUCT_MAST_LANG_VW WHERE PRODUCT_CODE = ? AND "+
		    " LANGUAGE_ID = ?";
		pst = con.prepareStatement(descSQL);
		pst.setString(1, product_code);
		pst.setString(2, locale);
		rs1 = pst.executeQuery();

		if(rs1.next())
		{
			product_desc = rs1.getString("PRODUCT_DESC")==null?"":rs1.getString("PRODUCT_DESC");
		}
		rs1.close();
		pst.close();
		rs1 = null;
		pst = null;
		descSQL = null;
		/*
			ends here.
		*/
		//IN036376 - Start
		//String sql1= "select USER_ID code,USERNAME description from SY_USER_LANG_VW where LANGUAGE_ID = ? and USER_ID = ? ";
		String sql1= "select Appl_user_id code,PRACTITIONER_NAME description from sm_appl_user_vw where LANGUAGE_ID =? and Appl_user_id = ? ";//reopen1[IN036376]
				
		PreparedStatement pst1 = null;
		ResultSet rs11 = null;
		
		pst1 = con.prepareStatement(sql1);
		pst1.setString(1, locale);
		pst1.setString(2, login_user);
		rs11 = pst1.executeQuery();

		if(rs11.next())
		{
			practitioner_name = rs11.getString("description")==null?"":rs11.getString("description");
		}

		rs11.close();
		pst1.close();
		//IN036376 - End
		
%>	
<body>
<form name='CA_UNIT_REQUEST_DTL' id='CA_UNIT_REQUEST_DTL' method='post'   action='' target='messageFrame'> 
<table width='102%'>

	<tr>
		<td class='label' width='25%'><b><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></b></td>
		<td class='fields' width='25%'><%=product_desc%></td>
		<td class='label' width='25%'><b><fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/></b></td>
<%
		if(!(blood_group== null || blood_group.equals("")|| rhesus_code== null ||  rhesus_code.equals("")))
		{
%>
			<td class='fields' width='25%'><%=blood_group%> / <%=rhesus_code%></td>
				
<%	
		}
		else
		{
%>
			<td class='fields' width='25%'><%=blood_group%></td>
<%
		}
%>	 		
	</tr>
	<tr>
		<td class='label' width='25%'><b><fmt:message key="eCA.UnitNo.label" bundle="${ca_labels}"/></b></td><td  class='fields' width='25%'><%=unit_no%></td>

<%
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,locale);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,product_code);
		pstmt.setString(5,unit_no);
		pstmt.setString(6,specimen_no);

		/*out.println("<br> patient_id "+patient_id);
		out.println("<br> locale "+locale);
		out.println("<br> facility_id "+facility_id);
		out.println("<br> product_code "+product_code);
		out.println("<br> unit_no "+unit_no);
		out.println("<br> specimen_no "+specimen_no);*/

		rs = pstmt.executeQuery();
		while(rs!=null && rs.next())
		{
			current_vol			= rs.getString("current_volume")== null   ?  "" : rs.getString("current_volume");
			strVolumeUnits				= rs.getString("volume_units") == null ? "" : rs.getString("volume_units");
			location_code			= rs.getString("storage_loc_code") == null ? "" : rs.getString("storage_loc_code");
			Issued_date = com.ehis.util.DateUtils.convertDate(rs.getString("ISSUED_DATE"),"DMYHM","en",locale);
			Reserved_date = com.ehis.util.DateUtils.convertDate(rs.getString("RESERVED_DATE"),"DMYHM","en",locale);

			sys_date		= com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale);

			i++;
%>
			
			<td class='label' width='25%'><b><fmt:message key="Common.volume.label" bundle="${common_labels}"/></b></td>
<%	
			if(!(current_vol== null || current_vol.equals("")|| strVolumeUnits== null ||  strVolumeUnits.equals("")))
			{
%>
				<td class='fields' width='25%'><%=current_vol%><%=strVolumeUnits%></td>
				
<%
			}
			else
			{
%>
				<td class='fields' width='25%'><%=current_vol%></td>
<%
			}
%>
	</tr>
	<tr>
		<td class='label' width='25%'><b><fmt:message key="Common.StorageLocation.label" bundle="${common_labels}"/></b></td>
		<td class="fields" width='25%'><%=location_code%></td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='fields' width='25%'>&nbsp;</td>
	</tr>
	</table>
<%
		}
		if(i == 0)
		{ 
%>			
			<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();
			</script>
<% 
		}
	}
	catch(Exception e)
	{
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally 
	{
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<table width='102%' height='86%' class="grid">
	<tr>
		<td class='label' colspan='4'> <b><fmt:message key="eCA.TransfusionDtls.label" bundle="${ca_labels}"/></b></td> 
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td><td  class='fields' width='25%'><input type='text' name='start_date_time' id='start_date_time' maxlength='20' size='20' value= "" RECORD_TYPE='S' Onblur='checkSTDate(this,document.forms[0].ISSUED_DATE,document.forms[0].RESERVED_DATE)'> <img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('start_date_time','dd/mm/y','hh:mm:ss');" /><img src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' width='25%'><fmt:message key="Common.EndDateTime.label" bundle="${common_labels}"/></td>
		<td  class='fields' width ='25%'><input type='text' name='end_date_time' id='end_date_time' maxlength='20' size='20' value= "" RECORD_TYPE='S' Onblur='checkEnDate(this,document.forms[0].start_date_time,document.forms[0].RESERVED_DATE,document.forms[0].SYSDATE);' >
		<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('end_date_time','dd/mm/y','hh:mm:ss');" /><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>

	<tr>
		<td class='label' width ='25%'><fmt:message key="eCA.CheckbyPractitioner.label" bundle="${ca_labels}"/></td>
		<td  class='fields' width ='25%'><input type='text' name='Checked_Practioner' id='Checked_Practioner' maxlength='20' size='20' value= "" OnBlur ="funBTCheckDetail1Blur(this,'3')"><input type='button' class='Button' value='?' onClick="funBTCheckDetail1('3')"  name='bs' id='bs'><input type='hidden' name='check_pract_id' id='check_pract_id' value='' RECORD_TYPE='S'><img src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' width ='25%'><fmt:message key="eCA.TransfusebyPractitioner.label" bundle="${ca_labels}"/></td>
		<td  class='fields' width ='25%'><input type='text' name='Practioner_Name1' id='Practioner_Name1' maxlength='20' size='20' value= "" OnBlur ="funBTCheckDetail1Blur(this,'1')"><input type='button' class='Button' value='?' onClick="funBTCheckDetail1('1')"  name='bs' id='bs'><input type='hidden' name='transfuse_pract_id1' id='transfuse_pract_id1' value='' RECORD_TYPE='S'><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>

	<tr>
		<td class='label' width ='25%'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<!--<td  class='fields' width ='25%'><input type='text' name='Practioner_Name2' id='Practioner_Name2' maxlength='20' size='20' value= "" OnBlur ="funBTCheckDetail1Blur(this,'2')"><input type='button' class='Button' value='?' onClick="funBTCheckDetail1('2')"  name='bs' id='bs'><input type='hidden' name='transfuse_pract_id2' id='transfuse_pract_id2' value='' RECORD_TYPE='S'></td>--> 
		<td  class='fields' width ='25%'><input type='text' name='Practioner_Name2' id='Practioner_Name2' maxlength='20' size='20' value= "<%=practitioner_name%>" OnBlur ="funBTCheckDetail1Blur(this,'2')"><input type='button' class='Button' value='?' onClick="funBTCheckDetail1('2')"  name='bs' id='bs'><input type='hidden' name='transfuse_pract_id2' id='transfuse_pract_id2' value='<%=login_user%>' RECORD_TYPE='S'></td> <!-- Modified IN036376 -->
		<td class='label' width ='25%'><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></td>
		<td  class='fields' width ='10%'><input type='text' name='REACTION_DESC' id='REACTION_DESC' maxlength='40' size='30' value= "" OnBlur ="funBTReactionDetailBlur(this)"><input type='button' class='button' value='?'   name='bs' id='bs' onClick="funBTReactionDetail()"><img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='reaction_code' id='reaction_code' value= "" ><div id='adverse_reaction' style='visibility:hidden'>(<fmt:message key="Common.AdverseReaction.label" bundle="${common_labels}"/>)</div></td></td>
	</tr>

	<tr>
		<td class='label' width ='25%' ><fmt:message key="eCA.TransfusionRemarks.label" bundle="${ca_labels}"/></td>
		<td  class='fields' colspan='3'><TEXTAREA NAME="remarks" ROWS="2" COLS="40" RECORD_TYPE='S'></TEXTAREA></td>
	</tr>
	<tr>
		<td class='label' width ='25%'><fmt:message key="eCA.PartialTransfusion.label" bundle="${ca_labels}"/></td>
		<td  class='fields' width ='25%'><input type='checkbox' name='partial_check_box' id='partial_check_box'  align='center' onClick="funCheck(this)"></td><!-- checkbox name is changed from 'partial_check' to 'partial_check_box' related to incident IN023128 on 8/9/2010 by Archana Dhal-->
		<td class='label' width ='25%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td  class='fields' width ='25%'><input type='text' name='TRANS_DESC' id='TRANS_DESC' maxlength='30' size='30' value= "" Onblur="funBTReasonDetailBlur(this)" disabled><input type='button' class='button' value='?' name='TRANS_BS' id='TRANS_BS' onClick="funBTReasonDetail()" disabled><input type='hidden' name='partial_trans_code' id='partial_trans_code' value="" RECORD_TYPE='S'></td>
	</tr>

	<tr>
		<td class ='label' ></td>
		<td class ='label' ></td>
		<td class ='label' ></td>
		<td align='right'>
		<input type='Button' class='button'  name="save" id="save" value= '<%=common_labels.getString("Common.apply.label")%>' OnClick='Apply()'> <input type='Button' class='button'  name="cancel" id="cancel" value= '<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='javascript:closeWindow()'></td>
	</tr>
</table>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='partial_check' id='partial_check' value='N' RECORD_TYPE='S'>
<input type='hidden' name='LOGIN_USER' id='LOGIN_USER' value='<%=login_user%>'>
<input type='hidden' name='specimen_no' id='specimen_no' value='<%=specimen_no%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='unit_no' id='unit_no' value='<%=unit_no%>'>
<input type='hidden' name='product_code' id='product_code' value='<%=product_code%>'>
<input type='hidden' name='current_vol' id='current_vol' value='<%=current_vol%>'>
<input type='hidden' name='location_code' id='location_code' value='<%=location_code%>'>
<input type='hidden' name='blood_group' id='blood_group' value='<%=blood_group%>'>
<input type='hidden' name='rhesus_code' id='rhesus_code' value='<%=rhesus_code%>'>
<input type='hidden' name='strVolumeUnits' id='strVolumeUnits' value='<%=strVolumeUnits%>'>
<input type='hidden' name='ISSUED_DATE' id='ISSUED_DATE' value='<%=Issued_date%>'>
<input type='hidden' name='RESERVED_DATE' id='RESERVED_DATE' value='<%=Reserved_date%>'>
<input type='hidden' name='SYSDATE' id='SYSDATE' value='<%=sys_date%>'>

</form>
</body>
</html>

