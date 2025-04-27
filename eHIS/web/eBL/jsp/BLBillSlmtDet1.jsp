<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%
	String strdfltslmttypecode = "";

	String locale	= (String)session.getAttribute("LOCALE");
	String querystring=(String)request.getQueryString();
//		System.out.println("querystring in BLBillSlmtDet1.jsp:"+querystring);
 %>
<HTML>

<HEAD>


<!--	<TITLE> Bill Settlement Details  11 </TITLE> -->
		<TITLE> <fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> </TITLE>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>

	<script language='javascript'>	

	function dfltslmt()
    {
	var dfltslmt = document.forms[0].dfltslmttypecode.value;	

	var billslmtamt = document.forms[0].billslmtamt.value;	

	if (billslmtamt == null || billslmtamt == 0 || billslmtamt == "")
		return;	
		
	try
	{
		for(i=0;i<document.forms[0].slmttype.options.length;i++)
		{									
			var cashSetValue = document.forms[0].slmttype.options[i].value;
					
			if (cashSetValue == null)
			{
				continue;
			}
			var len = cashSetValue.length;
			var subValue ="";

			if (len >0)
			{
				subValue = cashSetValue.substring(0,len-1);
			}
			if (subValue == dfltslmt)
			{								
				document.forms[0].slmttype.value = cashSetValue;
				calldfltslmt(cashSetValue);
			}
			
									
		}
				
	}
	catch(e)
	{
	}				
   }
   

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	<%
	//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	try{
	String strbilldoctypecode = request.getParameter("billdoctypecode");
	String strbilldocnum = request.getParameter("billdocnum");	
	String strbillpayableamt = request.getParameter("billpayableamt");	
	String strfacilityid = request.getParameter("facilityid");	
	String strpatientid  = request.getParameter("patientid");	
 	String strepisodetype = request.getParameter("episodetype");	
	String strepisodeid = request.getParameter("episodeid");
	String strvisitid = request.getParameter("visitid");		
	String strslmtpayername = request.getParameter("slmtpayername");	
	String struser = request.getParameter("loggeduser");	
	String strslmtidno = request.getParameter("slmtidno");

	String strcashcounter = request.getParameter("cashcounter");
	String strdfltcashbillslmtamt = "";
	String strrcptallowedyn = "";
	String strchangereceiptamtind = "";
	String strrcptallowedynuser = "";
	String strchangereceiptalloweduser = "";
	String strslmtamt = "";
	String strchangeyn	= "N";
	

		
	if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
	{strbilldoctypecode ="";}

	if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
	{strbilldocnum = "";}

	if ( strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
	{strbillpayableamt = "";}

	if ( strfacilityid == null || strfacilityid.equalsIgnoreCase("null")) 
	{strfacilityid = "";}

	if ( strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
	{strpatientid = "";}

	if ( strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
	{strepisodetype = "";}

	if ( strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
	{strepisodeid = "";}

	if ( strvisitid == null || strvisitid.equalsIgnoreCase("null")) strvisitid = "";

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null"))  
	{strslmtpayername = "";}

	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) strslmtidno = "";

	if ( struser == null || struser.equalsIgnoreCase("null")) struser = "";

	if ( strcashcounter == null || strcashcounter.equalsIgnoreCase("null")) 
		strcashcounter ="";

	Connection con				= null;
	PreparedStatement pstmt		= null;

	//unused variable, commented on 09/06/05
	//PreparedStatement pstmt1	= null;
	//Statement stmt1				= null;
	//ResultSet rs4				= null;
	ResultSet rs				= null;
	ResultSet rs2				= null;
	//ResultSet rs3				= null;


	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");			

	String strclientip = p.getProperty("client_ip_address");	

	con	=	ConnectionManager.getConnection(request);
	try
	{				
		pstmt = con.prepareStatement(" select nvl(dflt_cash_bill_slmt_amt,'N') from bl_parameters where operating_facility_id = ? ");
		pstmt.setString(1,strfacilityid);
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strdfltcashbillslmtamt =  rs.getString(1);						
		}
		else
				strdfltcashbillslmtamt = "N";
	}
	catch(Exception e) 
	{ }
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	


	if ( strdfltcashbillslmtamt == null || strdfltcashbillslmtamt.equalsIgnoreCase("null")) 
	   strdfltcashbillslmtamt = "N";


   
   try
	{				
		pstmt = con.prepareStatement(" select slmt_type_code from bl_visit_fin_dtls where operating_facility_id = ? and episode_type = ? and episode_id = ? and visit_id = ? ");
		
		pstmt.setString(1,strfacilityid);
		pstmt.setString(2,strepisodetype);
		pstmt.setString(3,strepisodeid);
		pstmt.setString(4,strvisitid);

		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strdfltslmttypecode =  rs.getString(1);						
		}
		else
		{
			strdfltslmttypecode = "";
		}
	}
	catch(Exception e) 
	{ }
	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	

    if ( strdfltslmttypecode == null || strdfltslmttypecode.equalsIgnoreCase("null")) 
	   strdfltslmttypecode = "";


	try
	{		
		pstmt = con.prepareStatement(" select nvl(op_applicable_ind,'N'),nvl(change_receipt_amt_ind,'N') from  bl_cash_counter where cash_counter_code = ? and operating_facility_id = ? ");
		
		pstmt.setString(1,strcashcounter);
		pstmt.setString(2,strfacilityid);

		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strrcptallowedyn =  rs.getString(1);			
			strchangereceiptamtind =  rs.getString(2);			
		}
		else
		{	strrcptallowedyn = "N";
			strchangereceiptamtind = "N";
		}		
	}

	catch(Exception e) 
	{}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
	}	

	if ( strrcptallowedyn == null || strrcptallowedyn.equalsIgnoreCase("null")) 
	   strrcptallowedyn = "N";

	if (strchangereceiptamtind == null || strchangereceiptamtind.equalsIgnoreCase("null")) 
	   strchangereceiptamtind = "N";

	try
	{		
		pstmt = con.prepareStatement("select nvl(receipt_auth_yn,'N'), nvl(change_receipt_allowed_yn,'N') from bl_users_for_credit_auth where operating_facility_id = ? and credit_auth_user_id = ? ");
		
		pstmt.setString(1,strfacilityid);
		pstmt.setString(2,struser);

		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{
			strrcptallowedynuser =  rs.getString(1);				
			strchangereceiptalloweduser =  rs.getString(2);						
		}
		else
		{
			strrcptallowedynuser = "N";
			strchangereceiptalloweduser = "N";
		}
	}
	catch(Exception e) 
	{}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 	
		//Moved here in Bangalore on 13/10/2005
//		ConnectionManager.returnConnection(con, request);	
	}	

	


	if (strrcptallowedynuser == null || strrcptallowedynuser.equalsIgnoreCase("null")) 
	   strrcptallowedynuser = "N";

	if (strchangereceiptalloweduser == null || strchangereceiptalloweduser.equalsIgnoreCase("null")) 
       strchangereceiptalloweduser = "N";	

	if (strdfltcashbillslmtamt.equals("N") || strrcptallowedyn.equals("N")
        || strrcptallowedynuser.equals("N") )
	{
		strslmtamt = "";
		strchangeyn = "Y";
	}
	else
	{
		strslmtamt = strbillpayableamt;
		if (strchangereceiptalloweduser.equals("N") || strchangereceiptamtind.equals("N"))
			strchangeyn = "N";
		else
			strchangeyn = "Y";	
    }
	
	%>
	
	<script>		
			
			function checkslmtamt()
			{
				var v_billslmtamt = "";			
				var v_billpayableamt = "";

				v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;				
				v_billpayableamt = parent.frames[0].document.forms[0].billpayableamt.value;			

				if ( parseFloat(v_billslmtamt) > parseFloat(v_billpayableamt))
				{
//					alert("Allocated amount is greater than outstanding amount");
					alert(getMessage("BL7085","BL"));
					parent.frames[0].document.forms[0].billslmtamt.select();
					parent.frames[0].d	ocument.forms[0].billslmtamt.focus();
					return false;
				}

				if ( parseFloat(v_billslmtamt) < 0 )
				{
//					alert(" Refund cannot be allowed");
					alert(getMessage("BL9536","BL"));
					parent.frames[0].document.forms[0].billslmtamt.select();
					parent.frames[0].document.forms[0].billslmtamt.focus();
					return false;
				}

				if ( parseFloat(v_billslmtamt) == 0 || v_billslmtamt == "" || v_billslmtamt == null )
				{
					document.forms[0].slmttype.value = "";
					calldfltslmt("");	
				}
			}

			function billslmtprocess()
			{	
				var v_slmttype		= "";
				var v_cashslmtflag	= "";
				var v_instref		= "";
				var v_instdate		= "";
				var v_instremark	= "";
				var v_slmtidno		= "";
				var v_slmtpayername = "";
				var v_billslmtamt = "";	
				var v_slmtapprrefno = "";

				var v_rectype ="";
				var v_ext_acc_facility_id = "";
				var v_ext_acc_code = "";
				var v_ext_acc_dept = "";
				var v_online_approval = "";
				var v_batch_no = "";
				var v_sale_draft_no = "";
				var v_ext_acc_interface_yn = "";

				v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;					
				v_slmttype = parent.frames[0].document.forms[0].slmttype.value;							

				parent.frames[0].document.forms[0].pagecloseind.value = "0";
				
				if (v_billslmtamt == null ) v_billslmtamt ="";
				if (v_slmttype == null ) v_slmttype = "";
	
				if (v_slmttype == "" && parseFloat(v_billslmtamt) > 0)
				{	
//					alert( "Settlement Type cannot be blank");
					alert(getMessage("BL9521","BL"));
					parent.frames[0].document.forms[0].slmttype.focus();
					return false;
				}

				if (v_slmttype != "" && parseFloat(v_billslmtamt) == 0)
				{	
//					alert( "Settlement Type cannot be selected for Zero amount");
					alert(getMessage("BL9522","BL"));
					parent.frames[0].document.forms[0].slmttype.focus();
					return false;
				}
				

				if (v_slmttype != "" &&  v_billslmtamt =="" )
				{	
//					alert( "Settlement Amount cannot be blank");
					alert(getMessage("BL9523","BL"));
					parent.frames[0].document.forms[0].billslmtamt.focus();
					return false;
				}

				var str = parent.frames[0].document.forms[0].slmttype.value;					
				v_cashslmtflag =str.charAt(2);		
				
				if (v_slmttype != "")
				{
					v_ext_acc_interface_yn = parent.frames[1].document.forms[0].ext_acc_interface_yn.value;
					
				}
				
				if (v_ext_acc_interface_yn == "Y" && v_slmttype != "")

				{					
					v_rectype = parent.frames[1].document.forms[0].rectype.value;
					v_ext_acc_facility_id = parent.frames[1].document.forms[0].ext_acc_fac_id.value;
					v_ext_acc_code = parent.frames[1].document.forms[0].acccode.value;
					v_ext_acc_dept = parent.frames[1].document.forms[0].dept.value;
					
					if ( v_rectype == "")
					{
//						alert("Receipt Type cannot be blank");
						alert(getMessage("BL9524","BL"));
						parent.frames[1].document.forms[0].rectype.focus();
						return false;
					}

					if ( v_ext_acc_code == "")
					{
//						alert("Account code cannot be blank");
						alert(getMessage("BL9525","BL"));
						parent.frames[1].document.forms[0].acccode.focus();
						return false;
					}

					if ( v_ext_acc_dept == "")
					{
//						alert("Accounting department cannot be blank");
						alert(getMessage("BL9526","BL"));
						parent.frames[1].document.forms[0].dept.focus();
						return false;
					}
				}				

				if (v_cashslmtflag != "Y" && v_slmttype != "")
				{
						v_instref = parent.frames[1].document.forms[0].instref.value;
						v_instdate = parent.frames[1].document.forms[0].instdate.value;
						v_instremark = parent.frames[1].document.forms[0].instremark.value;
						v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
						v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
						v_slmtapprrefno = parent.frames[1].document.forms[0].apprrefno.value;
						if (parent.frames[1].document.forms[0].onlineapproval.checked)
							v_online_approval = 'Y';
						else
							v_online_approval = 'N';

						v_batch_no = parent.frames[1].document.forms[0].batchno.value;
						v_sale_draft_no = parent.frames[1].document.forms[0].saledraftno.value;

						if ( v_instref == "")
						{
//							alert("Instrument Ref cannot be blank");
							alert(getMessage("BL9527","BL"));
							parent.frames[1].document.forms[0].instref.focus();
							return false;
						}

						if ( v_instdate == "")
						{
//							alert("Instrument Date cannot be blank");
							alert(getMessage("BL9528","BL"));
							parent.frames[1].document.forms[0].instdate.focus();
							return false;
						}

						if (v_instremark == "" && (v_cashslmtflag == "A" || v_cashslmtflag == "B"))
						{
//							alert("Bank/Card Co. Name cannot be blank");
							alert(getMessage("BL9529","BL"));
							parent.frames[1].document.forms[0].instremark.focus();
							return false;
						}

						if (v_slmtapprrefno == "" && v_cashslmtflag == "A")
						{
//							alert("Approval code cannot be blank");
							alert(getMessage("BL9531","BL"));
							parent.frames[1].document.forms[0].apprrefno.focus();
							return false;						
						}				
							
						
						if (v_cashslmtflag == "B" && v_slmtpayername == "")
						{
//							alert("Payer's name cannot be blank");
							alert(getMessage("BL9532","BL"));
							parent.frames[1].document.forms[0].payername.focus();
							return false;
						}

						if (v_cashslmtflag == "B" && v_slmtpayername != "" && v_slmtidno == "")
						{
//							alert("Payer's Ref Id cannot be blank");
							alert(getMessage("BL9533","BL"));
							parent.frames[1].document.forms[0].recrefidno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_online_approval == "Y" && v_batch_no == "")
						{
//							alert("Batch No cannot be blank");
							alert(getMessage("BL9530","BL"));
							parent.frames[1].document.forms[0].batchno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_online_approval == "N" && v_batch_no != "")
						{
//							alert("Online Approved credit card transaction can only have batch number");
							alert(getMessage("BL9534","BL"));
							parent.frames[1].document.forms[0].batchno.focus();
							return false;
						}						

						if (v_cashslmtflag == "A" && v_sale_draft_no == "")
						{
//							alert("Sale Draft No cannot be blank");
							alert(getMessage("BL9535","BL"));
							parent.frames[1].document.forms[0].saledraftno.focus();
							return false;
						}												
					}
					else
						if (v_cashslmtflag == "Y" && v_slmttype != "")
						{
						
						v_slmtidno = parent.frames[1].document.forms[0].recrefidno.value;
						v_slmtpayername = parent.frames[1].document.forms[0].payername.value;
						}			
					
			
							
					parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>&slmtamt='+v_billslmtamt+'&slmttypecode='+v_slmttype.substring(0,2)+'&slmtdocref='+v_instref+'&slmtdocrefdate='+v_instdate+'&slmtdocrefremark='+v_instremark+'&slmtidno='+v_slmtidno+'&slmtpayername='+v_slmtpayername+'&slmtapprrefno='+v_slmtapprrefno+'&onlineapproval='+v_online_approval+'&batchno='+v_batch_no+'&saledraftno='+v_sale_draft_no+'&rectype='+v_rectype+'&extaccfacid='+v_ext_acc_facility_id+'&extacccode='+v_ext_acc_code+'&extaccdept='+v_ext_acc_dept; 
					
			}

			function billslmtprocessclose()
			{				

			if ( parent.frames[0].document.forms[0].pagecloseind.value != "1" )
				{	
				
				parent.frames[2].location.href =  '../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>'; 				

				/*
				var dialogHeight	= "1" ;
				var dialogWidth		= "1" ;
				var dialogTop		= "1";
				var center			= "1";														   
				var status			= "no";
				var features		= "dialogHeight:"  + dialogHeight + 
									  "; dialogWidth:" + dialogWidth + 	
									  "; center: "	   + center + 
									  "; status: "	   + status	+ 
									  "; dialogTop :"  + dialogTop;
				var arguments	= "" ;								

									
				var retVal = 			window.showModalDialog('../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=strfacilityid%>&user=<%=struser%>&patientid=<%=strpatientid%>&episodetype=<%=strepisodetype%>&episodeid=<%=strepisodeid%>&visitid=<%=strvisitid%>',arguments,features); 
				*/

				return;			

				}			
			}



			function calldfltslmt(val)
			{
				var str = val;
				var obj=str.substring(0,2);
				var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;								
											
				if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "")
				{				parent.frames[1].location.href='../../eBL/jsp/BLBillSlmtType.jsp?slmttype='+obj+'&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>';
				}
				else
				{parent.frames[1].location.href='../../eCommon/html/blank.html';
				}	

				if ( v_billslmtamt == "" && str != "")
				{
					parent.frames[0].document.forms[0].slmttype.value = "";
//					alert("Settlement Amount cannot be blank");					
					alert(getMessage("BL9523","BL"));					
					return false;
				}


				}

			function callslmt(Obj)
			{
				var str = Obj.value;
				var obj=str.substring(0,2);
				var v_billslmtamt = parent.frames[0].document.forms[0].billslmtamt.value;								
											
				if (obj.charAt(2) != "Y" && obj != "" && v_billslmtamt != "")
				{				parent.frames[1].location.href='../../eBL/jsp/BLBillSlmtType.jsp?slmttype='+obj+'&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>';
				}
				else
				{parent.frames[1].location.href='../../eCommon/html/blank.html';
				}	

				if ( v_billslmtamt == "" && str != "")
				{
					parent.frames[0].document.forms[0].slmttype.value = "";
//					alert("Settlement Amount cannot be blank");					
					alert(getMessage("BL9523","BL"));					
					return false;
				}


				}
	</script>	   
</HEAD>

<BODY	onLoad="dfltslmt();"  onUnload="billslmtprocessclose();" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >

	<FORM name='BillSlmtDetForm' id='BillSlmtDetForm' method='Login'  action=''  scrolling='NO' >
	
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>		 
	<tr>
<!--	<td class="label" width="25%">Bill No</td>	 -->
	<td class="label" width="25%"><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></td>	 
	<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billdoctype" id="billdoctype" SIZE="7" MAXLENGTH="10" 				VALUE='<%=strbilldoctypecode%>'  style='text-align:left'> / <INPUT TYPE="TEXT" 
	READONLY name="billdocnum" id="billdocnum" SIZE="8" MAXLENGTH="10"  VALUE='<%=strbilldocnum%>' style='text-align:right'></td>
<!--	<td class="label" width="25%">Payable Amount</td>	-->
	<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"/></td>	
	<!--
	<td>&nbsp;<INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="8" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'>&nbsp;<INPUT TYPE="button"  class="BUTTON" VALUE="  OK  " onClick='billslmtprocess()'><td> 	
	-->

	<td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billpayableamt" id="billpayableamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strbillpayableamt%>'  style='text-align:right'></td> 	
	</tr>
	<tr>		
<!--	<td class="label" width="25%">Amount Settled</td>	-->
	<td class="label" width="25%"><fmt:message key="eBL.AMT_SETTLED.label" bundle="${bl_labels}"/></td>	

	<% 
	if (strchangeyn.equals("Y"))
	{ 
	%>	
	<td class="fields" width="25%"><INPUT TYPE="TEXT" name="billslmtamt" id="billslmtamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onBlur='return checkslmtamt();'> </td>	
	<% 
	 } 
	 else
	 {
     %>
      <td class="fields" width="25%"><INPUT TYPE="TEXT" READONLY name="billslmtamt" id="billslmtamt" SIZE="15" MAXLENGTH="20" 	VALUE='<%=strslmtamt%>'  style='text-align:right' onBlur='return checkslmtamt();'> </td>	
	 <% 
	  } 
	 %>
<!-- 	<td width="25%"  class="label" >Settlement Type<input type='hidden' name='Case' id='Case' value='1'></td> -->
 	<td width="25%"  class="label" ><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/><input type='hidden' name='Case' id='Case' value='1'></td>
	<td width="25%" class="fields" ><select name='slmttype' id='slmttype' onChange='callslmt(this)'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
			try {
//					con	=	ConnectionManager.getConnection(request);

					// Cash Counter Check

					CallableStatement call = 
					con.prepareCall("{ call bl_user_check_for_cash_counter (?,?,?,?,?,?,?)}");			
					call.setString(1,strfacilityid);
					call.setString(2,"O");
					call.setString(3,struser);
					call.setString(4,strclientip);

					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					String strscashcountercode	 = call.getString(5);	
					String strshiftid	  	     = call.getString(6);		
					String strsysmessageid		 = call.getString(7);		

					call.close();

					String strerrortext = "";

					if ( strscashcountercode == null ) strscashcountercode = "";
					if ( strshiftid == null ) strshiftid = "";
					if ( strsysmessageid == null ) strsysmessageid = "";


					if (!(strsysmessageid.equals("")))
					{
					try
					{			
						call = 
						con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,strsysmessageid);
						call.execute();				
						strerrortext = call.getString(1);			
						call.close();	
						if ( strerrortext == null ) strerrortext = ""; 
					}
					catch(Exception e)
					{ 
						//out.println(e.toString());
						e.printStackTrace();
					}	
					if ( !(strerrortext.equals("")) )
					{
					%>
					<script>					
						var v_error = '<%=strerrortext%>';
						alert(v_error);				 
					 </script>
					<%
					}		
			      }
//	PE Changes				pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id='"+locale+"' and status is null and nvl(cashier_yn,'N') = 'Y' and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where 		operating_facility_id =  '"+ strfacilityid + "' and cash_counter_code = '"+ strscashcountercode + "' and status is null) order by short_desc  " ) ;

					pstmt = con.prepareStatement("Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id=? and status is null and nvl(cashier_yn,'N') = 'Y' and ACC_ENTITY_CODE in (Select acc_entity_id from SM_ACC_ENTITY_PARAM_FACL where facility_id=?) and slmt_type_code in (select slmt_type_code from bl_slmt_cash_counter where operating_facility_id = ? and cash_counter_code =? and status is null) order by short_desc") ;
					
					
					pstmt.setString(1,locale);
					pstmt.setString(2,strfacilityid);
					pstmt.setString(3,strfacilityid);
					pstmt.setString(4,strscashcountercode);
					rs2 = pstmt.executeQuery() ;
					if( rs2 != null ) 
					{
						while( rs2.next() ) 
						{
							String slmt_type_code = rs2.getString( "slmt_type_code" ) ;
							String short_desc = rs2.getString( "short_desc" ) ;
							String cash_slmt_flag=rs2.getString("cash_slmt_flag") ;

							if ( slmt_type_code == null ) slmt_type_code = "";
							if ( short_desc == null ) short_desc ="";
							if ( cash_slmt_flag == null ) cash_slmt_flag = "";

							// defaulting settlement type from visit fin dtls if exist...					    
							
													
								out.println("<option value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");	
							
						}
					}
				 }
				catch(Exception e) 
					{
						//out.println(e.toString());
						e.printStackTrace();	
					}

				finally 
					{
						if (rs2 != null)   rs2.close();
						if (pstmt != null) pstmt.close();		 	
						//Moved here in Bangalore on 13/10/2005
						ConnectionManager.returnConnection(con, request);	
					}

					

	}catch(Exception e)
	{System.out.println("Exception in main detl="+e);}

			%>			
				</select></td>
				<!-- <td class="label"> </td> -->
			</tr>
<!--
			<tr>		
				<td width="" class="label"></td>
				<td width="" class="label"></td>
				<td width="" class="label"></td>
				<td width="" class="label"></td>
				<td width="" class="label"></td>
			</tr>
-->
		</table> 
		<INPUT TYPE="HIDDEN" name="pagecloseind" id="pagecloseind"   SIZE="50" MAXLENGTH="100" 	VALUE="0">		
		<INPUT TYPE="HIDDEN" name="dfltslmttypecode" id="dfltslmttypecode" SIZE="50" MAXLENGTH="100" 	VALUE='<%=strdfltslmttypecode%>' >	 
	</FORM>	
	<INPUT TYPE="HIDDEN" name="slmtdate" id="slmtdate"	   SIZE="20" MAXLENGTH="20" 	VALUE=""> 
	<INPUT TYPE="HIDDEN" name="slmtdocrefdesc" id="slmtdocrefdesc" SIZE="50" MAXLENGTH="100"	VALUE="">	
	<INPUT TYPE="HIDDEN" name="slmtdocref" id="slmtdocref"	   SIZE="50" MAXLENGTH="100" 	VALUE="">	 
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	
</BODY>
</HTML>

