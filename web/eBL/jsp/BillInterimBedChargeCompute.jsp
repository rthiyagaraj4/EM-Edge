<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet rs1=null; ResultSet rs3=null;ResultSet rs2=null;
	PreparedStatement pstmt = null ;
	String locale="",p_facility_id="";
	String strBedChrDate="",strDays="";
	String strSysdate="";
try{	
		HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		con	=	ConnectionManager.getConnection(request);
		locale	= (String)session.getAttribute("LOCALE");
		p_facility_id = (String)httpSession.getValue("facility_id");

			try{
					pstmt = con.prepareStatement("SELECT to_char(FROM_TIME_BED_BLNG,'DD/MM/YYYY') FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID ='"+p_facility_id+"' ");

					rs1 = pstmt.executeQuery();	
					while(rs1.next())
					{
						strBedChrDate  =  rs1.getString(1);		
					}
					if ( strBedChrDate== null || strBedChrDate.equalsIgnoreCase("null")){
							strBedChrDate="";}
//					System.out.println("strBedChrDate :" +strBedChrDate);
				rs1.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("bed computation="+e.toString());}

				try{
					pstmt = con.prepareStatement("SELECT to_char(sysdate,'dd/mm/yyyy') FROM dual ");

					rs2 = pstmt.executeQuery();	
					while(rs2.next())
					{
						strSysdate =  rs2.getString(1);		
					}
					if ( strSysdate== null || strSysdate.equalsIgnoreCase("null")){
							strSysdate="";}
//					System.out.println("strSysdate :" +strSysdate);
				rs2.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("strSysdate="+e.toString());}

				try{
					pstmt = con.prepareStatement("select floor(to_date('"+strSysdate+"' ,'dd/mm/yyyy')- to_date('"+strBedChrDate+"','dd/mm/yyyy')) from dual ");

					rs3 = pstmt.executeQuery();	
					while(rs3.next())
					{
						strDays =  rs3.getString(1);		
					}
					if ( strDays== null || strDays.equalsIgnoreCase("null")){
							strDays="";}
					
//					System.out.println("strDays :" +strDays);
				rs3.close();
				pstmt.close();
				}catch(Exception e) {System.out.println("strDays="+e.toString());}

				
%>
<HTML>
	<HEAD>
	<%
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



			<script>
				function funComputeBedCharges()
				{						
					if(document.forms[0].compute_bed_charge_flag.value=='')
					{
						alert("no records to submit");
						return false;
					}
					//parent.frames[2].document.forms[0].bed_chr_date.value=document.forms[0].bed_chr_date.value;
					//alert("Job Submitted For Bed Charge Process");
					alert(getMessage("BL9928","BL"))
					parent.frames[2].document.forms[0].submit();	
				
				}

			</script>
    </HEAD> 
			<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	      					  onSelect="codeArrestThruSelect();">
			<FORM name='BillSlmtInterimReportBedComp' id='BillSlmtInterimReportBedComp' method='post' action='../../eBL/jsp/BillInterimBedChargeCompute.jsp'>
			<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<!-- <TR>
			 <td class="label" width="25%">Bed Charge Computed upto Date</td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="bed_chr_date" id="bed_chr_date" SIZE="15" MAXLENGTH='10' VALUE='<%=strBedChrDate%>' readonly ></td>
				<td class="label" width="25%">No of days to run</td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="int_bill_gen_freq" id="int_bill_gen_freq" SIZE="15" MAXLENGTH='10' VALUE='<%=strDays%>' ></td>
			</tr>-->
			<TR>	
			<td class="label" width="25%"></td>
			<td class="label" width="25%"></td>
			<td class="fields" width="25%"></td> 
			<td width="25%"  class="label" ><input type='button' class='button' disabled onclick='funComputeBedCharges()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SUBMIT_BED_CHARGE_PROCESS.label","bl_labels")%>" name='submit_but'></td>			
			<td class="fields" width="25%"></td>
			</TR>
			</TABLE>
			<input type= hidden name="compute_bed_charge_flag" id="compute_bed_charge_flag"  value=''>
			</FORM>
	<%
		}catch(Exception e){}
			finally{				
					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
					}	
		
	%>

	</BODY>
</HTML>

