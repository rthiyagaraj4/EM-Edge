<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			   
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>					   
<script language='javascript' src='../../eXF/js/FinanceInterfaceParam.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></Script>
<script language="JavaScript">
function searchFacility(){
            var tdesc="";
            var tcode="";
					   
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.facility.label","common");
			
            var target=this.document.forms[0].facility_name;
            var faclty_id=this.document.forms[0].facility_id; 
           var locale=document.forms[0].locale.value;
		//	sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";
		//sql="SELECT a.facility_id code,b.facility_name description FROM XH_PARAM_FOR_FACILITY a,  SM_FACILITY_PARAM_LANG_VW b WHERE a.facility_id=b.facility_id and UPPER(b.facility_id) LIKE UPPER(?) AND    UPPER(b.facility_name) LIKE UPPER(?) and b.language_id='en'  ORDER BY 1 ";
				 
			sql="SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID AND UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1 ";
/*															   
			if(faclty_id.value!=""){
				dataNameArray[0]	= "FACILITY_ID" ;
				dataValueArray[0]	= faclty_id.value;
				dataTypeArray[0]	= STRING ;					    
			} */
 
			argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
//			argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
//				alert();
                faclty_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                faclty_id.value=tcode;
            }
}// End of searchFacility
function funcheck(obj)																  
{																					  				   
  if(obj.checked==true)
	{
//	  alert("checked");
		obj.value="Y";
	}																				 
	else
	{
	   obj.value="N";
	}
}
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
	function CheckForSpecCharsforNumber(event){
		var strCheck = '0123456789';
	
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;													  
	}
	function checkMonth(obj)
	{
		if(parseInt(obj.value)>12)
	   	{
				   var msg=getMessage("INVALID_VALUE","common");
				  alert(msg.replace("#","Month"));
		}
		
	}

	function checkEnable(obj)
	{
		if(obj.value=='')
		{

			  this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.disabled=true;			 
				 this.document.forms[0].CashBillSearch2.disabled=true;		 
		}
		else
		{
		 this.document.forms[0].Cash_bill_ctrl_main_ac2_desc.disabled=false;			 
		 this.document.forms[0].CashBillSearch2.disabled=false;		 
		}
									 
	}
	function funYearCheck(obj)
	{
		 if(obj.value==''||obj.value==0)
		{
	    }
		else
		{
			if(obj.value.length<=3)
			{
				var ms=getMessage("INVALID_VALUE","common");
				alert(ms.replace('#','Year'));
				 obj.focus();
			}
			 else
			{
				 var d =  new Date(); 											  
				 var year=d.getYear(); 
					 if(parseInt(obj.value)>year)										    
					{
						  var ms=getMessage("XH0084","XH");
						  alert(ms.replace('#','Year'));
						    obj.focus();
					}
			} 
		}

	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<%
Connection con=null;
Statement statemt=null;
ResultSet rset=null;


Statement stmt=null;
ResultSet rs=null;
Statement stmt2=null;
ResultSet rs2=null;
Statement stmt3=null;
ResultSet rs3=null;
Statement stmt4=null;
ResultSet rs4=null;
String iint_to_ext_gl_yn ="";			   
String cash_bill_control_main_ac1="";     
String cash_bill_control_main_ac2="";   
String cash_bill_control_main_ac1_desc="";     
 String cash_bill_control_main_ac2_desc=""; 
 String facility_id="";
String Application_id="";
String pmnt_mm="";
String Application_id_desc="";
String facility_name="";
String pmnt_yyyy="";					   
String process_mode="";
String eneble_yn="N";
String view_enable_yn="";

   ArrayList arraylist3 = ArrayAuditInfo.getArrayAuditInfo(session);

try{
 		con=ConnectionManager.getConnection();
		String sql="SELECT INT_TO_EXT_GL_YN, EXT_GL_APPL_ID, CASH_BILL_CONTROL_MAIN_AC1, CASH_BILL_CONTROL_MAIN_AC2, PMNT_MM, PMNT_YYYY, PROCESS_MODE,VIEW_ENABLE_YN,FACILITY_ID FROM XF_PARAM";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs!=null && rs.next())	 									  
		{
			iint_to_ext_gl_yn=XHDBAdapter.checkNull(rs.getString(1));
			if(iint_to_ext_gl_yn.equals(""))
			{																    
				iint_to_ext_gl_yn="N";
			}
			Application_id=XHDBAdapter.checkNull(rs.getString(2));
			cash_bill_control_main_ac1=XHDBAdapter.checkNull(rs.getString(3));
//					System.out.println("FinanceInterfaceParamSetupMaster.jsp cash_bill_control_main_ac1 : "+cash_bill_control_main_ac1);
			cash_bill_control_main_ac2=XHDBAdapter.checkNull(rs.getString(4));
//					System.out.println("FinanceInterfaceParamSetupMaster.jsp cash_bill_control_main_ac2 : "+cash_bill_control_main_ac2);
			pmnt_mm=XHDBAdapter.checkNull(rs.getInt(5)+"");
			pmnt_yyyy=XHDBAdapter.checkNull(rs.getInt(6)+"");
   			process_mode=XHDBAdapter.checkNull(rs.getString(7));
			view_enable_yn=XHDBAdapter.checkNull(rs.getString(8));
			facility_id=XHDBAdapter.checkNull(rs.getString(9));
			if(view_enable_yn.equals(""))
			{
				view_enable_yn="N";
			}
//			System.out.println("FinanceInterfaceParamSetupMaster.jsp view_enable_yn : "+view_enable_yn.trim());
		}
	if(cash_bill_control_main_ac1.equals(""))
	{
	}
	else
	{
	  eneble_yn="Y";
	}

		    String sql6="SELECT X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and X.FACILITY_ID='"+facility_id+"'  ORDER BY 1";
//		System.out.println("sql6 :"+sql6);
		statemt=con.createStatement();
		rset=statemt.executeQuery(sql6);
		if(rset!=null && rset.next())
		{
			facility_name=rset.getString(1);
		}  

		String sql3="SELECT SHORT_DESC FROM gl_acc_chart WHERE  MAIN_ACC1_CODE='"+cash_bill_control_main_ac1+"' ";
//		System.out.println("sql3"+sql3);
		stmt3=con.createStatement();
		rs3=stmt3.executeQuery(sql3);
		if(rs3!=null && rs3.next())
		{
			cash_bill_control_main_ac1_desc=rs3.getString(1);
//			System.out.println("cash_bill_control_main_ac1_desc : "+cash_bill_control_main_ac1_desc);
		}
		     
			if(facility_id.equals(""))
 		{	
				facility_id=(String)arraylist3.get(2);		   
		}


		
		 



		 String sql5="SELECT SHORT_DESC FROM gl_acc_chart WHERE  MAIN_ACC2_CODE='"+cash_bill_control_main_ac2+"' and MAIN_ACC1_CODE='"+cash_bill_control_main_ac1+"' ";
//		System.out.println("sql5 :"+sql5);
		stmt4=con.createStatement();					   
		rs4=stmt4.executeQuery(sql5);
		if(rs4!=null && rs4.next())
		{								    
			cash_bill_control_main_ac2_desc=rs4.getString(1);
			
		}



		 String sql4="SELECT APPLICATION_NAME FROM xh_application WHERE  APPLICATION_ID='"+Application_id+"' ";
//		System.out.println("sql4"+sql4);
		stmt2=con.createStatement();
		rs2=stmt2.executeQuery(sql4);
		if(rs2!=null && rs2.next())
		{
			Application_id_desc=rs2.getString(1);
		}


		}catch(Exception e)
		{
			out.println("Exception is "+e.toString()); 
		}
		finally{
			try{
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			if(stmt2!=null)stmt2.close();
			if(rs2!=null)rs2.close();
			if(stmt3!=null)stmt3.close();
			if(rs3!=null)rs3.close();
			if(stmt4!=null)stmt4.close();
			if(rs4!=null)rs4.close();
			if(statemt!=null)statemt.close();
			if(rset!=null)rset.close();
		
			 ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{ 
				out.println("Exception is "+e.toString());
			}
		}

        
		
%>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" target='messageFrame' method='post' action='../../servlet/eXF.FinanceAdminInterfaceParamSetupServlet'>
<table border=0 cellspacing=0 cellpadding=3 width='100%' >
<tr>
	<td class=label ><fmt:message key="eXH.Interfacet0ExlGL.Label" bundle="${xh_labels}"/></td>
	<td	><input type=checkbox name='enable_interface' id='enable_interface'  onClick='funcheck(this);' value='<%=iint_to_ext_gl_yn%>' <%=iint_to_ext_gl_yn.equals("Y")?"checked":""%>></td>	 
	<td class=label ><fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="Common.Enable.label" bundle="${common_labels}"/></td>   																				 
	<td align=left><input type=checkbox name='view_enable_yn' id='view_enable_yn' value='<%=view_enable_yn%>'  onClick='funcheck(this);' <%=view_enable_yn.equals("Y")?"checked":""%>></td>
</tr>	
<tr>
	<th align=left colspan=4><fmt:message key="Common.general.label" bundle="${common_labels}"/></th>
	</tr>

<!---<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>--->
<tr>
<td class=label align=right><fmt:message key="eXH.Payment.Label" bundle="${xh_labels}"/> <fmt:message key="Common.month.label" bundle="${common_labels}"/></td>
<td align=left><input type=text name=payment_month value='<%=pmnt_mm%>' maxlength="2" size=15 onKeyPress='return CheckForSpecCharsforNumber(event);' onblur="checkMonth(this)"></td>												  
<td class=label align=right><fmt:message key="eXH.Cash_bill_ctrl_main_ac1.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text name='Cash_bill_ctrl_main_ac1_desc' id='Cash_bill_ctrl_main_ac1_desc' value='<%=cash_bill_control_main_ac1_desc%>' onblur='searchCashbill();checkEnable(this)' size=15  >
<input type="button" class="button" name=CashBillSearch value='?'    onClick="searchCashbill()">
<input type="hidden" name="Cash_bill_ctrl_main_ac1" id="Cash_bill_ctrl_main_ac1" value='<%=cash_bill_control_main_ac1%>'>			 	   						 
</td>	 </tr>


																					   
<tr>
<td class=label align=right><fmt:message key="eXH.Payment.Label" bundle="${xh_labels}"/> <fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
<td align=left><input type=text name=payment_year value='<%=pmnt_yyyy%>' onblur='funYearCheck(this)' maxlength="4" size=15 onKeyPress='return CheckForSpecCharsforNumber(event);'></td>
<td class=label align=right><fmt:message key="eXH.Cash_bill_ctrl_main_ac2.Label" bundle="${xh_labels}"/> </td>
<td align=left>
<input type=text name='Cash_bill_ctrl_main_ac2_desc' id='Cash_bill_ctrl_main_ac2_desc' value='<%=cash_bill_control_main_ac2_desc%>' onblur="searchCashbill2()" size=15 <%=eneble_yn.equals("Y")?"":"disabled"%> >
<input type="button" class="button" name=CashBillSearch2 value='?'   <%=eneble_yn.equals("Y")?"":"disabled"%> onClick="searchCashbill2()" >
<input type="hidden" name="Cash_bill_ctrl_main_ac2" id="Cash_bill_ctrl_main_ac2" value='<%=cash_bill_control_main_ac2%>' >			 	   						 				 
</td>																								   	     
														  					  
</tr>  								   								       
<!---</table>--->
																			  
<!---<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>---->
<th align=left colspan=6><fmt:message key="eXH.DefaultAttributes.Label" bundle="${xh_labels}"/></th>
<tr>
<td class=label align=right><fmt:message key="eXH.ExtGLApplication.Label" bundle="${xh_labels}"/></td>
<td align=left >									  
<input type=text name='Application_type' id='Application_type' value='<%=Application_id_desc%>'  size=20  >
<input type="button" class="button" name=ApplicationSearch value='?'    onClick="searchApplicationID()">
<input type="hidden" name="Application_type_id" id="Application_type_id" value='<%=Application_id%>'></td>
<td class=label align=right><fmt:message key="Common.Process.label" bundle="${common_labels}"/> <fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
<td align=left >
<select name= process_mode >
<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<option value='JOB' <%=process_mode.equals("JOB")?"selected":""%>><fmt:message key="eXH.Job.Label" bundle="${xh_labels}"/></option>
<option value='TASK' <%=process_mode.equals("TASK")?"selected":""%>><fmt:message key="Common.Task.label" bundle="${common_labels}"/></option>
</select>
</td>																		 								  
</tr>
<tr>			  
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>   
<td align=left>
<input type="hidden" name="facility_id" id="facility_id" value="<%=XHDBAdapter.checkNull(facility_id)%>" onBlur="searchFacility()" size='10'>
<input type=text id="facility_name"  name =facility_name size=20 value='<%=XHDBAdapter.checkNull(facility_name)%>'  onBlur="searchFacility()"> <input class="button" type="button"  name=FacilitySearch value='?'    onClick="searchFacility()">
</td>
</tr>			  

</table>																	  
<%---<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<th rowspan=2 align=center width='50%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
	<!---<th colspan=4 align=center><fmt:message key="eXH.Log.Label" bundle="${xh_labels}"/></th>--------->
</tr>
<tr>
	<!---<th align=center width='10%'><fmt:message key="eXH.Audit.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Debug.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></th>----->
</tr>
</table>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
	Statement stmt1=null;
	ResultSet rs1=null;
	String classValue= " ";
	String FACILITY_ID="";
	String FACILITY_NAME="";
	String AUDIT_YN ="";
	String DEBUG_YN="";     
	String OUTBOUND_LOG_YN="";              
	String INBOUND_LOG_YN="";   
	String CHK_OPERATIONAL="";
	int i=0;
	try{
	    String sql1="SELECT X.FACILITY_ID,X.FACILITY_NAME,Y.AUDIT_YN,Y.DEBUG_YN,Y.OUTBOUND_LOG_YN,Y.INBOUND_LOG_YN,Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM_LANG_VW X,XI_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en'AND Z.MODULE_ID='XH' AND     X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID UNION SELECT X.FACILITY_ID,X.FACILITY_NAME,'N','N','N','N',Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM_LANG_VW X,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en' AND Z.MODULE_ID='XH' AND X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID NOT IN (SELECT FACILITY_ID  FROM XH_PARAM_FOR_FACILITY )";
    	stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);
//		 System.out.println("FinanceInterfaceParamSetupMaster.jsp sql1: "+sql1);
		while(rs1.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			FACILITY_ID=rs1.getString(1);
			FACILITY_NAME=rs1.getString(2);
			

			String id_for_audit=FACILITY_ID+"_AUDIT";
			String id_for_debug=FACILITY_ID+"_DEBUG";	
			String id_for_outbound=FACILITY_ID+"_OUTBOUND";
			String id_for_inbound=FACILITY_ID+"_INBOUND";	
			
			%>
			<tr><td class='<%=classValue%>' align=center width='10%'><%=FACILITY_NAME%></td>

			<!---<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_audit%>' id='<%=id_for_audit%>' <%=AUDIT_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=AUDIT_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_debug%>' id='<%=id_for_debug%>' <%=DEBUG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=DEBUG_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_outbound%>' id='<%=id_for_outbound%>' <%=OUTBOUND_LOG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=OUTBOUND_LOG_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_inbound%>' id='<%=id_for_inbound%>' <%=INBOUND_LOG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=INBOUND_LOG_YN.equals("Y")?"Y":"N"%>'></td>--->
			
			</tr>
		<%
			
		i++;
			
		}
			
	}catch(Exception e)
	{
		out.println("Exception is "+e.toString());
	}
	finally{
			try{
			
			if(stmt1!=null)stmt1.close();
			if(rs1!=null)rs1.close();
			
			
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e.toString());
				}
			}
%>																	  
</table>  ----%>


<input type=hidden  name="locale" id="locale" id="locale" value='<%=locale%>'>
</form>
</body>
</html>

