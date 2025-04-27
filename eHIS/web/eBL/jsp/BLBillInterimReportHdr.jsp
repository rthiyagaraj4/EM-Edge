<!DOCTYPE html>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
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
	String p_module_id		= "BL" ;
	String p_report_id		= "BLR00001" ;
	String p_user_name		= (String) session.getValue( "login_user" );
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
			<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
			<script language='javascript' src='../../eBL/js/BLInterimBillReport.js'></script>
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
					<script>alert(getMessage("BL2205","BL"));</script>
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

			async function nursinglkup(nursing_unit_desc,nursing_unit_code,empty_chk)
		    {			
				if(empty_chk=='Y' && nursing_unit_desc.value=='')
				{
					return false;
				}
				var locale  = document.forms[0].locale.value;		
				var facility_id  = document.forms[0].facility_id.value;		
				//var target			= document.forms[0].from_nursing_unit;
				var retVal			=  new String();
				var dialogTop	= "40";
				var dialogHeight		= "10" ;
				var dialogWidth	= "40" ;
				var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title			= getLabel("Common.nursingUnit.label","COMMON");
				
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
				argArray[5] = nursing_unit_desc.value;				
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;		
				retArray = await CommonLookup( title, argArray );	
                var ret1=unescape(retArray);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}							
//				alert("retArray :"+retArray);
				//retArray=unescape(retArray);
				if(retArray != null && retArray !="")
				{					
					//nursing_unit_code.value=decodeURIComponent(retArray[0]);
					nursing_unit_code.value=arr[0];
					nursing_unit_desc.value=arr[1];								
				}
				else
				{
                    nursing_unit_code.value = arr[0]; 
			        nursing_unit_desc.value = arr[1];  
					//nursing_unit_code.value="";
					//nursing_unit_desc.value="";	
				}
				
			}


			async function payerlkup(clng_evnt)
			{
				
				var target			= document.forms[0].payer;		

				if(clng_evnt == 'B')
				{
					if( target.value == '')
					{	
						target.value = '';
						document.forms[0].payer_code.value= '';
						return;
					}
				}

				var retVal			=  new String();
				var dialogTop	= "40";
				var dialogHeight		= "10" ;
				var dialogWidth	= "40" ;
				var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title			= encodeURIComponent(getLabel("Common.Payer.label","common"));
				var locale  = document.forms[0].locale.value;
				var payable_type=document.forms[0].payer_type.value;

				//if(payable_type=="I")
				//{
					var sql1="select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = '"+locale+"'  and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1"; 

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
					retArray = await CommonLookup( title, argArray );	
                     var ret1=unescape(retArray);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}		
					if(retArray != null && retArray !="")
					{
						document.forms[0].payer_code.value = arr[0];
                        document.forms[0].payer.value = arr[1];
					}
					else
					{
                          document.forms[0].payer_code.value = arr[0];
                          document.forms[0].payer.value = arr[1];
						//document.forms[0].payer.value="";
						//document.forms[0].payer_code.value="";
						//document.forms[0].payer_type.value="";
						//document.forms[0].payer_type.selectedIndex=2;
					}
				//}
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
					//alert("246 BLBillInterimReportHdr.jsp");//lakshmi
					parent.frames[1].document.forms[0].submit_but.disabled=false;					
					parent.frames[1].document.forms[0].compute_bed_charge_flag.value='Y';
					var err="";
					parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err ;
					var from_nursing_unit_code=document.forms[0].from_nursing_unit_code.value;		
					var to_nursing_unit_code=document.forms[0].to_nursing_unit_code.value;	

					var nursing_from_lbl=getLabel("Common.FromNursingUnit.label","BL");
					var nursing_to_lbl=getLabel("Common.ToNursingUnit.label","common");



					if(from_nursing_unit_code!="" && to_nursing_unit_code=="") 
					{
						var msg = getMessage("CAN_NOT_BE_BLANK","common");						
						msg = msg.replace("$", nursing_to_lbl);
						alert(msg);
						document.forms[0].to_nursing_unit_code.value="";
						document.forms[0].from_nursing_unit_code.value="";
						document.forms[0].to_nursing_unit.focus();
						return;
					}
					else if(from_nursing_unit_code=="" && to_nursing_unit_code!="")
					{
						var msg = getMessage("CAN_NOT_BE_BLANK","common");						
						msg = msg.replace("$", nursing_from_lbl);
						alert(msg);
						document.forms[0].from_nursing_unit_code.value="";
						document.forms[0].to_nursing_unit_code.value="";
						document.forms[0].from_nursing_unit.focus();
						return;
					}

					if(from_nursing_unit_code > to_nursing_unit_code)
					{
						alert(getMessage("BL9927","BL"))						
						return false;
					}
					var from_adm_no=document.forms[0].from_adm_no.value;		
					var to_adm_no=document.forms[0].to_adm_no.value;
					var adm_from_lbl=getLabel("eBL.FROM_ADM_NO.label","BL");
					var adm_to_lbl=getLabel("eBL.TO_ADM_NO.label","BL");
					
					if(from_adm_no!="" && to_adm_no=="")
						
					{
						var msg = getMessage("CAN_NOT_BE_BLANK","common");						
						msg = msg.replace("$", adm_to_lbl);
						alert(msg);
						document.forms[0].to_adm_no.focus();

						return;
					}
					else if (from_adm_no=="" && to_adm_no!="")
					{
						var msg = getMessage("CAN_NOT_BE_BLANK","common");						
						msg = msg.replace("$", adm_from_lbl);
						alert(msg);
						document.forms[0].from_adm_no.focus();
						return;
					}
					if(from_adm_no > to_adm_no)
					{						
						alert(getMessage("BL9926","BL"))
						return false;
					}
					
					var payer_code=document.forms[0].payer_code.value;					
					var patient_id=""; //document.forms[0].patient_id.value;
					var payer_type=document.forms[0].payer_type.value;					
					var pay_amt_exce=document.forms[0].pay_amt_exce.value;		
					var no_of_deci=document.forms[0].noofdecimal.value;
					var int_bill_gen_freq='';//document.forms[0].int_bill_gen_freq.value;
					parent.frames[3].location.href='../../eCommon/jsp/process.jsp';	parent.frames[2].location.href='../../eBL/jsp/BLBillInterimReportCurrInPat.jsp?from_nursing_unit_code='+from_nursing_unit_code+"&to_nursing_unit_code="+to_nursing_unit_code+"&from_adm_no="+from_adm_no+"&to_adm_no="+to_adm_no+"&payer_code="+payer_code+"&patient_id="+patient_id+"&payer_type="+payer_type+"&pay_amt_exce="+pay_amt_exce+"&no_of_deci="+no_of_deci+"&int_bill_gen_freq="+int_bill_gen_freq;
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
			async function admnolkp(admissionno,clng_evnt)
				{
					if(clng_evnt == 'B')
					{
						if( admissionno.value == "")
						{
							return;
						}
					}
					var from_nursing_unit=document.forms[0].from_nursing_unit_code.value;
					var to_nursing_unit=document.forms[0].to_nursing_unit_code.value;
					var locale=document.forms[0].locale.value;
					var facility_id=document.forms[0].facility_id.value;
					/*var dialogTop			= "40";
					var dialogHeight		= "10" ;
					var dialogWidth			= "40" ;*/
                     
                    var dialogTop			= "40px"
                    var dialogHeight = "400px" ;
	                var dialogWidth	= "900px" ;
					var features			="dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
					var arguments			= "" ;					
					var title = encodeURIComponent(getLabel("Common.AdmissionNo.label","common"));
					var column_sizes = escape("35%,35%,30%");               			
					var admno = encodeURIComponent(getLabel("Common.AdmissionNo.label","common"));
					var pat_id = encodeURIComponent(getLabel("Common.patientId.label","common"));
					var pat_name= encodeURIComponent(getLabel("Common.PatientName.label","common"));
					var column_descriptions =admno+","+pat_id+","+pat_name;
					//var sql="SELECT episode_id, patient_id, short_name  FROM lov_view WHERE facility_id ='"+facility_id+"'   AND (episode_type = 'I' OR episode_type = 'D')  AND cur_ward_code BETWEEN NVL ('"+from_nursing_unit+"' , '!!') AND NVL ('"+to_nursing_unit+"', '~~') "; 		
//					var sql="SELECT to_char(B.EPISODE_ID) EPISODE_ID,B.PATIENT_ID PATIENT_ID, decode(UPPER('"+locale+"'),'EN', D.short_name, D.short_name_loc_lang) SHORT_NAME FROM IP_OPEN_EPISODE A,  BL_EPISODE_FIN_DTLS B,  IP_EPISODE C,  MP_PATIENT_MAST D WHERE A.PATIENT_ID = B.PATIENT_ID   AND A.PATIENT_ID = C.PATIENT_ID  AND A.PATIENT_ID = D.PATIENT_ID   AND A.OPEN_EPISODE_ID = B.EPISODE_ID    AND A.OPEN_EPISODE_ID = C.EPISODE_ID     AND A.FACILITY_ID = '"+facility_id+"' AND B.OPERATING_FACILITY_ID = A.FACILITY_ID  AND C.FACILITY_ID = A.FACILITY_ID    AND (B.EPISODE_TYPE = 'I' or B.EPISODE_TYPE = 'D')    AND C.CUR_WARD_CODE BETWEEN NVL('"+from_nursing_unit+"','!!!!') AND NVL('"+to_nursing_unit+"','~~~~')     AND NVL(B.DISCHARGE_BILL_GEN_IND,'N') = 'N'";
// Corrected for PE Changes
					var sql="SELECT to_char(B.EPISODE_ID) EPISODE_ID,B.PATIENT_ID PATIENT_ID, decode(UPPER('"+locale+"'),'EN', D.patient_name, D.patient_name_loc_lang) SHORT_NAME FROM IP_OPEN_EPISODE A,  BL_EPISODE_FIN_DTLS B,  MP_PATIENT D WHERE A.PATIENT_ID = B.PATIENT_ID   AND A.PATIENT_ID = D.PATIENT_ID   AND A.OPEN_EPISODE_ID = B.EPISODE_ID   AND A.FACILITY_ID = '"+facility_id+"' AND B.OPERATING_FACILITY_ID = A.FACILITY_ID  AND (B.EPISODE_TYPE = 'I' or B.EPISODE_TYPE = 'D')    AND a.CUR_WARD_CODE BETWEEN NVL('"+from_nursing_unit+"','!!!!') AND NVL('"+to_nursing_unit+"','~~~~')     AND NVL(B.DISCHARGE_BILL_GEN_IND,'N') = 'N'";

					sql=escape(sql);							
					var message='';
					var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(admissionno.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYY";
					retVal= await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
					var arr=new Array();					
					if (retVal != null || retVal!="")
					{
						if(retVal!='undefined' && retVal!=undefined)
						{
							retVal=unescape(retVal);
							
							if(retVal != null && retVal.length>0)
							{
								
								//arr=retVal.split("::");
								arr=retVal.split("^~^");
								admissionno.value=arr[0];						
  							}
						}
					
					else{
						admissionno.value="";
					}
					}
					else{
						admissionno.value="";
					}
				}
			/*	function funComputeBedCharges()
				{					
					alert("Job Submitted For Bed Charge Process");
					parent.frames[2].document.forms[0].submit();	
				
				}*/

	</script>
	</HEAD> 
			<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
			<FORM name='BillSlmtInterimReport' id='BillSlmtInterimReport' method='' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			 <TR>
			    <td class="label" width="25%"><fmt:message key="Common.FromNursingUnit.label" bundle="${common_labels}"/></td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="from_nursing_unit" id="from_nursing_unit" SIZE="30"  MAXLENGTH='30' VALUE="<%=nursing_unit%>" onBlur="nursinglkup(this,document.forms[0].from_nursing_unit_code,'Y')"><input type='button' class='button' name="nursingbut" id="nursingbut" value='?' onClick='nursinglkup(document.forms[0].from_nursing_unit,document.forms[0].from_nursing_unit_code)' >
				<input type= 'hidden' name="from_nursing_unit_code" id="from_nursing_unit_code"  value="<%=nursing_unit_code%>"></td>		
				<td class="label" width="25%"><fmt:message key="Common.ToNursingUnit.label" bundle="${common_labels}"/></td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="to_nursing_unit" id="to_nursing_unit" SIZE="30"  MAXLENGTH='30'	VALUE="<%=nursing_unit%>" onBlur="nursinglkup(this,document.forms[0].to_nursing_unit_code,'Y')"><input type='button' class='button' name="nursingbut" id="nursingbut" value='?' onClick='nursinglkup(document.forms[0].to_nursing_unit,document.forms[0].to_nursing_unit_code)' >
				<input type= 'hidden' name="to_nursing_unit_code" id="to_nursing_unit_code"  value="<%=nursing_unit_code%>">		</td>		
			</tr>
			<tr>	
				<td class="label" width="25%"><fmt:message key="eBL.FROM_ADM_NO.label" bundle="${bl_labels}"/></td>
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="from_adm_no" id="from_adm_no" SIZE="8" maxlength='8' VALUE='' onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))' onBlur="admnolkp(document.forms[0].from_adm_no,'B')" ><input type='button' class='button' name="admbut" id="admbut" value='?' onClick="admnolkp(document.forms[0].from_adm_no,'C')" >
				<td class="label" width="25%"><fmt:message key="eBL.TO_ADM_NO.label" bundle="${bl_labels}"/></td>
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="to_adm_no" id="to_adm_no" SIZE="8" maxlength='8' VALUE='' onBlur="admnolkp(document.forms[0].to_adm_no,'B')" onKeyPress='return(ChkNumberInput(this,event,document.forms[0].noofdecimal.value))'><input type='button' class='button' name="admbut" id="admbut" value='?' onClick="admnolkp(document.forms[0].to_adm_no,'C')">
			
			</TR>
			<TR>
			<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_TYPE.label" bundle="${bl_labels}"/></td>	
				<td  width='25%' class='fields'>
				<select name='payer_type' id='payer_type' onchange='payerDisabled()'>
				<option value='B' ><fmt:message key="eBL.ANY.label" bundle="${bl_labels}"/></option>		
				<option value='P'  ><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
				<option value='I' ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>				
				</select><img src='../../eCommon/images/mandatory.gif'>
				</td>
			<td class="label" width="25%"><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="payer" id="payer" SIZE="30"  MAXLENGTH='40'	 VALUE="<%=payer%>" onBlur="payerlkup('B')"><input type='button' class='button' name="payerdbut" id="payerdbut" value='?' onClick="payerlkup('C')" tabindex='' ><input type= 'hidden' name="payer_code" id="payer_code"  value="<%=payer_code%>"></td>	
			<td class="fields" width="25%"></td>
			</TR>
			<TR>
			<td class="label" width="25%"><fmt:message key="eBL.PAYABLE_AMT_EXCEED.label"  bundle="${bl_labels}"/></td>	
			<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="pay_amt_exce" id="pay_amt_exce" SIZE="15" MAXLENGTH='10' VALUE="<%=pay_amt_exce%>" style='text-align:right' onKeyPress ='return(ChkNumberInput(this,event,2))' onBlur='AmtEcceed(this);put_decimal(this,document.forms[0].noofdecimal.value)'></td>		
			<!-- Modified By Rajesh V -->
			<td class="fields" width="25%"><input type='checkbox' name='dischargeYN' id='dischargeYN' id='dischargeYN' checked>
			&nbsp;<fmt:message key="Common.Detail.label"  bundle="${common_labels}"/></td>
			<!-- Modified By Rajesh V -->
			<td width="25%"  class="label" ><input type='button' class='button' onclick='funRefresh()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  name='search_but' ></td>
			<!--<td width="25%"  class="label" ><input type='button' class='button' onclick='funComputeBedCharges()' value="Submit Bed Charge Process" ></td>			-->

			</TR>
		
		</TABLE>
		<input type= hidden name="locale" id="locale"  value="<%=locale%>">
		<input type= hidden name="facility_id" id="facility_id"  value="<%=p_facility_id %>">		
		<input type= hidden name="patient_id1" id="patient_id1"  value=''>		
		<input type= hidden name="pat_check_flag" id="pat_check_flag"  value=''>	
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='group_by' id='group_by' value="" >
	<!--	<input type= hidden name="payer_type_flag" id="payer_type_flag"  value='<%=payer_type%>'>	-->
		<input type='hidden' name='total_records' id='total_records' value="">
		<input type='hidden' name='log_rep_success_mes' id='log_rep_success_mes' value=''>
		
		<input type="hidden" name="p_report_id" id="p_report_id"    value="<%= p_report_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id"    value="<%= p_module_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	   value="<%= p_user_name %>">
		<input type="hidden" name="L_AMOUNT" id="L_AMOUNT"	   value="">
		<input type="hidden" name="L_FR_EPISODE_ID" id="L_FR_EPISODE_ID"	   value="">
		<input type="hidden" name="L_FR_WARD_CODE" id="L_FR_WARD_CODE"	   value="">
		<input type="hidden" name="L_TO_EPISODE_ID" id="L_TO_EPISODE_ID"	   value="">
		<input type="hidden" name="L_TO_WARD_CODE" id="L_TO_WARD_CODE"	   value="">
		<input type="hidden" name="L_PAYER" id="L_PAYER"	   value="">
		<input type="hidden" name="L_PAY_TYPE" id="L_PAY_TYPE"	   value="">		
		<input type="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID"	   value="<%=p_facility_id %>">
		<input type="hidden" name="L_SERV_CLASS_YN" id="L_SERV_CLASS_YN"	   value="">
		<!-- Hidden Fields Added by Rajesh V -->
		<input type="hidden" name="p_session_id" id="p_session_id"	   value="">
		<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
		<input type="hidden" name="p_pgm_id" id="p_pgm_id"	   value="">
		<!-- Hidden Fields Added by Rajesh V -->
		<!--<input type="hidden" name="P_LANG_ID_LOC" id="P_LANG_ID_LOC"	   value='<%=locale %>'>-->
		
		

		
		
			
	</FORM>
		
	</BODY>
</HTML>

