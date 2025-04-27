<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onLoad="transferctrl();"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<%
	Connection con = null;

	PreparedStatement pstmt = null;
		ResultSet rs = null;	

	request.setCharacterEncoding("UTF-8");
	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");	
	String locale	= (String)session.getAttribute("LOCALE");
    	
	String strfacilityid = request.getParameter("facility_id");
	String user = request.getParameter("login_user");
	String CashCounterCode = request.getParameter("strCashCounterCode");
//	System.out.println("CashCounterCode Val:"+CashCounterCode);
	String shiftstartingat="";
	String obamt="";
	String strerrorlevel	  = "";		
	String strsysmessageid	  = "";		
	String strerrortext		  = "";
	int noofdecimal = 2;
	try{
			con	=	ConnectionManager.getConnection(request);

			con.setAutoCommit(false);
			CallableStatement call = 
					con.prepareCall("{ call bl_cash_counter_check.get_shift_details (?,?,?,?,?,?,?)}");	
					call.setString(1,strfacilityid);
					call.setString(2,CashCounterCode);
					call.setString(3,user);

					call.registerOutParameter(4,java.sql.Types.VARCHAR);
					call.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call.registerOutParameter(6,java.sql.Types.VARCHAR);	
					call.registerOutParameter(7,java.sql.Types.VARCHAR);	

					call.execute();									

					shiftstartingat	 = call.getString(4);	
					strsysmessageid	     = call.getString(5);		
					strerrorlevel		 = call.getString(6);		
					strerrortext		 = call.getString(7);		

					call.close();
					
					
					if ( shiftstartingat == null ) shiftstartingat = "";
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";
//					System.out.println("shiftstartingat val"+shiftstartingat);
//					System.out.println("strerrorlevel val"+strerrorlevel);
//					System.out.println("strsysmessageid"+strsysmessageid);
//					System.out.println("strerrortext"+strerrortext);

					
		 if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
			{
			 
				 
			 if (strerrorlevel.equals("10") && !strerrortext.equals(""))
			{
		%>
	 <script>	
	   var strerrortext  = '<%=strerrortext%>';
       alert(strerrortext);
	 </script>
	<%
			}
   if(!strsysmessageid.equals(""))
    {
   %>
	  <script>
    	  alert(getMessage('<%=strsysmessageid%>','BL'));
	  </script>
    <%
	 }
	}



					try
						{		
							pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
							
							rs = pstmt.executeQuery();	
							if ( rs.next() && rs != null ) 
								noofdecimal  =  rs.getInt(1);			
						}
						catch(Exception e) {System.out.println("4="+e.toString());}

						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 		
						}	


				CallableStatement call1 =	
					con.prepareCall("{ call bl_cash_counter_check.cash_counter_ob_amt_dflt (?,?,?,?,?,?)}");	
					call1.setString(1,strfacilityid);
					call1.setString(2,CashCounterCode);
					call1.registerOutParameter(3,java.sql.Types.VARCHAR);
					call1.registerOutParameter(4,java.sql.Types.VARCHAR);	
					call1.registerOutParameter(5,java.sql.Types.VARCHAR);	
					call1.registerOutParameter(6,java.sql.Types.VARCHAR);	

					call1.execute();									

					obamt					 = call1.getString(3);	

					
					CurrencyFormat cf = new CurrencyFormat();
					obamt = cf.formatCurrency(obamt, noofdecimal);	

					strsysmessageid	     = call1.getString(4);		
					strerrorlevel		 = call1.getString(5);		
					strerrortext		 = call1.getString(6);				
		
					call1.close();
					if ( obamt == null ) obamt = "";
					if ( strerrorlevel == null ) strerrorlevel = "";
					if ( strsysmessageid == null ) strsysmessageid ="";
					if ( strerrortext == null ) strerrortext ="";

					

			if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
			{
			 if (strerrorlevel.equals("10") && !strerrortext.equals(""))
			{
				%>
				<script>	
						var strerrortext =  '<%=strerrortext%>';
						alert(strerrortext);
				</script>
				<%
			}
			if(!strsysmessageid.equals(""))
			{
				%>
				<script>
						   alert(2);
    				alert(getMessage('<%=strsysmessageid%>','BL'));
				</script>
				<%
			}
			}



		}
	catch(Exception e) 
					{
						con.rollback();
						//out.println(e);
						e.printStackTrace();
					}

	finally 
					{
						
						ConnectionManager.returnConnection(con, request);	
					}

	%>
	<INPUT TYPE="HIDDEN" name="strfacilityid" id="strfacilityid"	   SIZE="50" MAXLENGTH="100" 	VALUE="<%=strfacilityid %>">
	<INPUT TYPE="HIDDEN" name="user" id="user"	   SIZE="50" MAXLENGTH="100" 	VALUE="<%=user %>">
	<INPUT TYPE="HIDDEN" name="CashCounterCode" id="CashCounterCode"	   SIZE="50" MAXLENGTH="100" 	VALUE="<%=CashCounterCode %>">
	<INPUT TYPE="HIDDEN" name="shiftstartingat" id="shiftstartingat"	   SIZE="50" MAXLENGTH="100" 	VALUE="<%=shiftstartingat %>">
	<INPUT TYPE="HIDDEN" name="obamt" id="obamt"	   SIZE="50" MAXLENGTH="100" 	VALUE="<%=obamt %>">
	
	<%
	if (CashCounterCode.equals(""))
	{
	%>
		<script>
			  parent.frames[1].document.menu_form.cashcounter.value="";
			  parent.frames[1].document.menu_form.shift_started_at.value="";
 			  parent.frames[1].document.menu_form.opening_balance.value="";
		</script>
	<%
	}
	else
	{
	%>
		<script>

			var facilityid1=document.forms[0].strfacilityid.value;
			var user1=document.forms[0].user.value;
			var CashCounterCode1=document.forms[0].CashCounterCode.value;
			var shiftstartingat1=document.forms[0].shiftstartingat.value;
			var obamt1=document.forms[0].obamt.value;
		
			function transferctrl()
			{
				//com.ehis.util.DateUtils.convertDate(shiftstartingat,"DMYHM","en",locale)
				parent.frames[1].document.menu_form.cashcounter.value="<%=CashCounterCode %>";
				parent.frames[1].document.menu_form.shift_started_at.value="<%=com.ehis.util.DateUtils.convertDate(shiftstartingat,"DMYHM","en",locale)%>";
				parent.frames[1].document.menu_form.opening_balance.value="<%=obamt %>";
			}
	</script>
	<%
	}
	%>
</form>	 
</body>
</html>



		

