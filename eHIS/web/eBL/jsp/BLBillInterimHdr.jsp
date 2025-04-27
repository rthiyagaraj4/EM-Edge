<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet rs1=null; ResultSet rscurr=null;
	PreparedStatement pstmt = null ;
	String locale="";String p_facility_id=""; String pat_check_flag="";
	String nursing_unit="";String payer_type=""; String patient_id1="";
	String payer=""; String pay_amt_exce="0.00"; String  int_bill_gen_freq="";
	int noofdecimal=2; String strPatientId="";//String selected_P="",selected_I="",selected_B="",selected="";
	String nursing_unit_code=""; String payer_code="";
	try{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");
		pat_check_flag=request.getParameter("pat_check_flag");
		if(pat_check_flag==null || pat_check_flag.equals("")) pat_check_flag="";
//		System.out.println("pat_check_flag :"+pat_check_flag);
		if(pat_check_flag.equals("Y"))
		{
			nursing_unit=request.getParameter("nursing_unit");
			if(nursing_unit==null || nursing_unit.equals("")) nursing_unit="";
				nursing_unit_code=request.getParameter("nursing_unit_code");
			if(nursing_unit_code==null || nursing_unit_code.equals("")) nursing_unit_code="";
				payer_type=request.getParameter("payer_type");
			if(payer_type==null || payer_type.equals("")) payer_type="";
				payer=request.getParameter("payer");
			if(payer==null || payer.equals("")) payer="";
				payer_code=request.getParameter("payer_code");
			if(payer_code==null || payer_code.equals("")) payer_code="";
				pay_amt_exce=request.getParameter("pay_amt_exce");
			if(pay_amt_exce==null || pay_amt_exce.equals("")) pay_amt_exce="";
				int_bill_gen_freq=request.getParameter("int_bill_gen_freq");
			if(int_bill_gen_freq==null || int_bill_gen_freq.equals("")) int_bill_gen_freq="";
				patient_id1=request.getParameter("patient_id1");
			if(patient_id1==null || patient_id1.equals("")) patient_id1="";
//			System.out.println("patient_id1 :"+patient_id1);
//			System.out.println("nursing_unit :"+nursing_unit);
//			System.out.println("payer_type :"+payer_type);
			/*if(payer_type.equals("P"))
				{selected_P="SELECTED";	}
				else if(payer_type.equals("I"))
				{selected_I="SELECTED";
				}
				else if(payer_type.equals("B"))
				{	selected_B="SELECTED";	}
		     else
			{selected="";}*/
		}
	  }catch(Exception eX){	
		out.println("Error= "+eX);}
%>
	<HTML>
		<HEAD>
			<TITLE>
			Interim Bill Generation
			</TITLE>	
<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%	
		try{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
			pstmt.close();
			}catch(Exception e) {System.out.println("currency="+e.toString());}
			try{
				pstmt = con.prepareStatement( "SELECT PATIENT_ID FROM IP_OPEN_EPISODE WHERE FACILITY_ID = '"+p_facility_id+"' AND PATIENT_ID='"+patient_id1+"'");
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					strPatientId  =  rs1.getString(1);		
				}
//				System.out.println("strPatientId :" +strPatientId);
				rs1.close();
				pstmt.close();
				if(!strPatientId.equals(patient_id1))
				  {
//					System.out.println("inside patient check");
%>
					<script>alert(getMessage("BL2205","BL"));;</script>
<%
				  }
				}catch(Exception e) {System.out.println("patid="+e.toString());}
				finally{				
					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
					}

%>		
	<script>
			function narsinglkup()
		    {
				var locale  = document.forms[0].locale.value;		
				var facility_id  = document.forms[0].facility_id.value;		
				var target			= document.forms[0].nursing_unit;
				var retVal			=  new String();
				var dialogTop	= "40";
				var dialogHeight		= "10" ;
				var dialogWidth	= "40" ;
				var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title			= encodeURIComponent(getLabel("Common.nursingUnit.label",'COMMON'));		
				//var sql1="select g.ward_code ward_code,g.short_desc short_desc from ip_ward_lang_vw g where g.facility_id='"+facility_id+"' and g.ward_code in (select cur_ward_code from ip_episode where facility_id = '"+facility_id+"' and episode_id in (select open_episode_id from ip_open_episode where facility_id = '"+facility_id+"')) and language_id='"+locale+"' and upper(ward_code) like upper(?) and upper(short_desc) like upper(?)  "; 
				//  IP_NURSING_UNIT_LANG_VW
				//var sql1="SELECT DISTINCT G.WARD_CODE code,G.SHORT_DESC description FROM IP_WARD_LANG_VW G, IP_EPISODE H, IP_OPEN_EPISODE I WHERE G.FACILITY_ID ='"+facility_id+"' AND G.FACILITY_ID = H.FACILITY_ID AND G.WARD_CODE = H.CUR_WARD_CODE AND H.FACILITY_ID = I.FACILITY_ID AND H.EPISODE_ID = I.OPEN_EPISODE_ID AND UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') and upper(G.WARD_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1"; 
//				var sql1="SELECT DISTINCT G.NURSING_UNIT_CODE code,G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_EPISODE H, IP_OPEN_EPISODE I WHERE G.FACILITY_ID ='"+facility_id+"' AND G.FACILITY_ID = H.FACILITY_ID AND G.NURSING_UNIT_CODE = H.CUR_WARD_CODE AND H.FACILITY_ID = I.FACILITY_ID AND H.EPISODE_ID = I.OPEN_EPISODE_ID AND UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1"; 
//PE Changes
				var sql1="SELECT DISTINCT G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID ='"+facility_id+"' AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') and upper(G.NURSING_UNIT_CODE) like upper(?) and upper(G.SHORT_DESC) like upper(?) order by 1"; 

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				argArray[0] = sql1;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;		
				retArray = CommonLookup( title, argArray );		
//				alert("retArray :"+retArray);
				if(retArray != null && retArray !="")
				{
					document.forms[0].nursing_unit_code.value=retArray[0];
					document.forms[0].nursing_unit.value=retArray[1];								
				}
				else
				{
					document.forms[0].nursing_unit_code.value="";
					document.forms[0].nursing_unit.value="";		
				}
    		}


			function payerlkup()
			{
				var target			= document.forms[0].payer;		
				var retVal			=  new String();
				var dialogTop	= "40";
				var dialogHeight		= "10" ;
				var dialogWidth	= "40" ;
				var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title			= encodeURIComponent(getLabel("Common.Payer.label",'common'));
				var locale  = document.forms[0].locale.value;
				var payable_type=document.forms[0].payer_type.value;

				if(payable_type=="I")
				{
					var sql1="select  cust_code  code,long_name description from ar_customer_lang_vw where language_id = '"+locale+"'  and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1"; 

					var argArray = new Array();
					var namesArray = new Array();
					var valuesArray = new Array();
					var datatypesArray = new Array();
					argArray[0] = sql1;
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[3] = datatypesArray;
					argArray[4] = "1,2";
					argArray[5] = target.value;
					argArray[6] = DESC_LINK;
					argArray[7] = DESC_CODE;		
					retArray = CommonLookup( title, argArray );		
					if(retArray != null && retArray !="")
					{
						document.forms[0].payer_code.value=retArray[0];
						document.forms[0].payer.value=retArray[1];
					}
					else
					{
						document.forms[0].payer.value="";
						document.forms[0].payer_code.value="";
						document.forms[0].payer_type.value="";
					}
				}
			}

			function payerDisabled()
			{
				var pay_type=document.forms[0].payer_type.value;
				if(pay_type=='P' || pay_type=='B' || pay_type=="")
				{
					document.forms[0].payer.value="";
					document.forms[0].payer.disabled=true;
					document.forms[0].payerdbut.disabled=true;
				}
				else{
					document.forms[0].payer.disabled=false;
					document.forms[0].payerdbut.disabled=false;
//					document.forms[0].payer.focus();
					}

			}

				function funRefresh()
				{
					var err="";
					parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err ;
					var nursing_unit_code=document.forms[0].nursing_unit_code.value;		
//					alert("nursing_unit_code :"+nursing_unit_code);
					var payer_code=document.forms[0].payer_code.value;
//					alert("payer_code :"+payer_code);
					var patient_id=document.forms[0].patient_id.value;
					var payer_type=document.forms[0].payer_type.value;
					var pay_amt_exce=document.forms[0].pay_amt_exce.value;		
					var no_of_deci=document.forms[0].noofdecimal.value;
					var int_bill_gen_freq=document.forms[0].int_bill_gen_freq.value;
					parent.frames[2].location.href='../../eCommon/jsp/process.jsp';	parent.frames[1].location.href='../../eBL/jsp/BLBillInterimCurrInPat.jsp?nursing_unit_code='+nursing_unit_code+"&payer_code="+payer_code+"&patient_id="+patient_id+"&payer_type="+payer_type+"&pay_amt_exce="+pay_amt_exce+"&no_of_deci="+no_of_deci+"&int_bill_gen_freq="+int_bill_gen_freq;
				}
				function getPatID()
				{
				  document.forms[0].patient_id.value="";
				  var pat_id=PatientSearch('','','','','','','','N','N','');
					//alert("pat_id :"+pat_id);
				  if(pat_id!=null)
				  {
					document.forms[0].patient_id1.value=pat_id;	 
					document.forms[0].pat_check_flag.value="Y";
					//alert(document.forms[0].pat_check_flag.value);
					document.forms[0].submit();
				  }else
					{
						document.forms[0].patient_id.value="";	
					}
				}
				function AmtEcceed()
				{	  
					var v_amt=document.forms[0].pay_amt_exce.value;
					if(v_amt=="")
					{
						document.forms[0].pay_amt_exce.value=0;
					}
				}
				function trunc_deci()
				{
					 var int_bill_gen_freq=document.forms[0].int_bill_gen_freq.value;
					 var index=int_bill_gen_freq.indexOf(".");
					 if(index>0)
					{		
						int_bill_gen_freq=int_bill_gen_freq.substring(0,index);
					}
					else if(index==0)
					{
						int_bill_gen_freq=0;
					}		
					document.forms[0].int_bill_gen_freq.value=int_bill_gen_freq;
				}
	</script>
	</HEAD> 
			<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
			<FORM name='BillSlmtInterim' id='BillSlmtInterim' method='post' action='../../eBL/jsp/BLBillInterimHdr.jsp'>
			<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			 <TR>
			    <td class="label" width="25%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="nursing_unit" id="nursing_unit" SIZE="15" VALUE='<%=nursing_unit%>' onBlur='narsinglkup()'><input type='button' class='button' name="nursingbut" id="nursingbut" value='?' onClick='narsinglkup()' tabindex='2'><input type= 'hidden' name="nursing_unit_code" id="nursing_unit_code"  value='<%=nursing_unit_code%>'>		</td>		
				<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_TYPE.label" bundle="${bl_labels}"/></td>	
				<td  width='25%' class='fields'>
				<select name='payer_type' id='payer_type' onchange='payerDisabled()'>
<!--
				<option value='' >-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>		
-->
				<option value='P'  ><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
				<option value='I' ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
				<option value='B' SELECTED><fmt:message key="eBL.ANY.label" bundle="${bl_labels}"/></option>
				</select>
				</td>
				<td class="fields" width="25%"></td>
			</TR>
			<TR>
			<td class="label" width="25%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>	
    		<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="15" VALUE='<%=strPatientId%>' readonly onBlur=""><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'></td>
			<td class="label" width="25%"><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="payer" id="payer" SIZE="15" VALUE='<%=payer%>' onBlur="payerlkup()"><input type='button' class='button' name="payerdbut" id="payerdbut" value='?' onClick="payerlkup()" tabindex='2' DISABLED><input type= 'hidden' name="payer_code" id="payer_code"  value='<%=payer_code%>'></td>	
			<td class="fields" width="25%"></td>
			</TR>
			<TR>
			<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT_EXCEED.label"  bundle="${bl_labels}"/></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="pay_amt_exce" id="pay_amt_exce" SIZE="15" MAXLENGTH='10' VALUE='<%=pay_amt_exce%>' style='text-align:right' onKeyPress ='return(ChkNumberInput(this,event,2))' onBlur='AmtEcceed(this);put_decimal(this,document.forms[0].noofdecimal.value)'></td>
			<td class="label" width="25%"><fmt:message key="eBL.NOT_GENERATED_FOR_DAYS.label"  bundle="${bl_labels}"/></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="int_bill_gen_freq" id="int_bill_gen_freq" SIZE="15" MAXLENGTH='5' VALUE='<%=int_bill_gen_freq%>' style='text-align:right' onKeyPress='return(ChkNumberInput(this,event,2))' onBlur='trunc_deci()'></td>	
			<td class="fields" width="25%"></td>
			</TR>
			<TR>	
			<td class="label" width="25%"></td>
			<td class="label" width="25%"></td>
			<td class="label" width="25%"></td>
			<td width="25%"  class="label" ><input type='button' class='button' onclick='funRefresh()' name='search_but' id='search_but'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" ></td>
			<td class="fields" width="25%"></td>
			</TR>
		</TABLE>
		<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
		<input type= 'hidden' name="facility_id" id="facility_id"  value='<%=p_facility_id %>'>		
		<input type= 'hidden' name="patient_id1" id="patient_id1"  value=''>		
		<input type= 'hidden' name="pat_check_flag" id="pat_check_flag"  value=''>	
		<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>' >
<%
	if(pat_check_flag.equals("Y"))
	{
%>
		<input type= 'hidden' name="payer_type_flag" id="payer_type_flag"  value='<%=payer_type%>'>	
<%
	}
%>
		<input type='hidden' name='total_records' id='total_records' value=''>
	</FORM>
<%
	if(pat_check_flag.equals("Y"))
	{
%>
		<script>

			var payer_type_flag=document.forms[0].payer_type_flag.value;
			if(payer_type_flag=="P")
			{
				document.forms[0].payer_type.selectedIndex=0;
			}
			else if(payer_type_flag=="I")
			{
				document.forms[0].payer_type.selectedIndex=1;
			}
			else if (payer_type_flag=="B")
			{
				document.forms[0].payer_type.selectedIndex=2;
			}
			else
			{
				document.forms[0].payer_type.selectedIndex=2;
			}
		</script>
<%
	}
%>
	</BODY>
</HTML>

