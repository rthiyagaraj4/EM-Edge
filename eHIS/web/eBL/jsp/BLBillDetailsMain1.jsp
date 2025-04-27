<!DOCTYPE html>
<%@ page import="java.sql.*,java.net.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<TITLE><fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></TITLE>
	<!--
	<LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs =null, rs1 = null;
	String strfacilityid	=  ""; 

	//unused variable, commented on 09/06/05
	//String strloggeduser	=  "";
	String strblngrule   = "N";
	int		noofdecimal = 2;
	request.setCharacterEncoding("UTF-8");
	try{	// Added in Bangalore on 13/10/2005	
	con					=	ConnectionManager.getConnection(request);
	strfacilityid		=  (String) session.getValue("facility_id");
	//strloggeduser		=  (String) session.getValue("login_user");

	String strinsind		   = request.getParameter("insind");		
	String strbaseqty	       = request.getParameter("baseqty");
	String strbasechargeamt    = request.getParameter("basechargeamt");
	String strbaserate		   = request.getParameter("baserate");
	String strgrosschargeamt   = request.getParameter("grosschargeamt");
	String strdiscountper	   = request.getParameter("discountper");
	String strdiscountamt      = request.getParameter("discountamt");
	String strdaytypecode      = request.getParameter("daytypecode");
	String strdaytypedesc      = request.getParameter("daytypedesc");
	String strtimetypecode     = request.getParameter("timetypecode");
	String strtimetypedesc     = request.getParameter("timetypedesc");
	String straddlfactor       = request.getParameter("addlfactor");	

	String strpatgrosschargeamt = request.getParameter("patgrosschargeamt");	
	String strpatdiscamt = request.getParameter("patdiscamt");	
	String strpatnetamt = request.getParameter("patnetamt");	
	String strcustgrosschargeamt = request.getParameter("custgrosschargeamt");	
	String strcustdiscamt = request.getParameter("custdiscamt");	
	String strcustnetamt = request.getParameter("custnetamt");	

	String strordercatalogcode = request.getParameter("ordercatalogcode");	
	String strordercatalogdesc = request.getParameter("ordercatalogdesc");	
	String strblngservcode = request.getParameter("blngservcode");	
	String strblngservdesc = request.getParameter("blngservdesc");	
	String strnetchargeamt = request.getParameter("netchargeamt");

	String strotherserviceamt = request.getParameter("otherserviceamt");
	String strbilledamt = request.getParameter("billedamt");
	String strunbilledamt = request.getParameter("unbilledamt");
	String strpaidamt = request.getParameter("paidamt");
	String stroutstamt = request.getParameter("outstamt");

	String strpatotherserviceamt = request.getParameter("patotherserviceamt");
	String strpatbilledamt = request.getParameter("patbilledamt");
	String strpatunbilledamt = request.getParameter("patunbilledamt");
	String strpatpaidamt = request.getParameter("patpaidamt");
	String strpatoutstamt = request.getParameter("patoutstamt");

	String strcustotherserviceamt = request.getParameter("custotherserviceamt");
	String strcustbilledamt = request.getParameter("custbilledamt");
	String strcustunbilledamt = request.getParameter("custunbilledamt");
	String strcustpaidamt = request.getParameter("custpaidamt");
	String strcustoutstamt = request.getParameter("custoutstamt");

	if (strinsind == null)  strinsind = "";
	if (strbaseqty == null) 	strbaseqty = "";
	if (strbasechargeamt == null)  strbasechargeamt = "";
	if (strbaserate == null ) strbaserate = "";
	if (strgrosschargeamt == null ) strgrosschargeamt = "";
	if (strdiscountper == null ) strdiscountper = "";
	if (strdiscountper == null) strdiscountper = "";
	if (strdiscountamt == null ) strdiscountamt = "";
	if (strdaytypecode==null) strdaytypecode = "";
	if (strdaytypedesc==null) strdaytypedesc="";
	if (strtimetypecode == null ) strtimetypecode = "";
	if ( strtimetypedesc == null ) strtimetypedesc ="";
	if ( straddlfactor == null ) straddlfactor ="";
	if ( strpatgrosschargeamt == null ) strpatgrosschargeamt ="";	
	if ( strpatdiscamt == null ) strpatdiscamt = "";
	if ( strpatdiscamt == null ) strpatdiscamt ="";
	if ( strpatnetamt == null ) strpatnetamt ="";
	if (strcustgrosschargeamt == null ) strcustgrosschargeamt = "";
	if ( strcustgrosschargeamt == null ) strcustgrosschargeamt ="";
	if ( strcustdiscamt  == null ) strcustdiscamt = "";
	if ( strcustnetamt == null ) strcustnetamt = "";


	if ( strordercatalogcode == null ) strordercatalogcode = "";
	if ( strordercatalogdesc == null) strordercatalogdesc ="";
	if ( strblngservcode == null ) strblngservcode = "";
	if ( strblngservdesc == null ) strblngservdesc = "";	
	if ( strnetchargeamt == null ) strnetchargeamt = "";

	if ( strotherserviceamt == null ) strotherserviceamt = "";
	if ( strbilledamt == null ) strbilledamt = "";
	if ( strunbilledamt == null ) strunbilledamt = "";
	if ( strpaidamt == null ) strpaidamt = "";
	if ( stroutstamt == null ) stroutstamt = "";

	if ( strpatotherserviceamt == null ) strpatotherserviceamt = "";
	if ( strpatbilledamt == null ) strpatbilledamt = "";
	if ( strpatunbilledamt == null ) strpatunbilledamt = "";
	if ( strpatpaidamt == null ) strpatpaidamt = "";
	if ( strpatoutstamt == null ) strpatoutstamt = "";

	if ( strcustotherserviceamt == null ) strcustotherserviceamt = "";
	if ( strcustbilledamt == null ) strcustbilledamt = "";
	if ( strcustunbilledamt == null ) strcustunbilledamt = "";
	if ( strcustpaidamt == null ) strcustpaidamt = "";
	if ( strcustoutstamt == null ) strcustoutstamt = "";



	if (strinsind == null || strinsind == ""  )
		strinsind = "Y";

    if (strbaseqty == null || strbaseqty == ""  )
		strbaseqty = "1.00";

	if (straddlfactor == null || straddlfactor == ""  )
		straddlfactor = "1.0000";	

    if (strdaytypecode == null)
		strdaytypecode = "";

    if (strdaytypedesc == null)
		strdaytypedesc = "";

    if (strtimetypecode == null)
		strtimetypecode = "";

    if (strtimetypedesc == null)
		strtimetypedesc = "";

	try
	{		
  		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from sm_acc_entity_param");
		
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
			noofdecimal  =  rs.getInt(1);			
	}
	catch(Exception e) {out.println(e.toString());}

	finally 
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 		
	}	


	try
	{		
  		pstmt = con.prepareStatement( " select nvl(blng_class_pricing_rule,'N') from bl_parameters where operating_facility_id = '"+strfacilityid+"'");
		
		rs1 = pstmt.executeQuery();	
		if ( rs1.next() && rs1 != null ) 
			strblngrule  =  rs1.getString(1);			
	}
	catch(Exception e) {out.println(e.toString());}

	finally 
	{
		if (rs1 != null)   rs1.close();
		if (pstmt != null) pstmt.close();		 		
	}	

	if ( strblngrule == null ) strblngrule = "";

	
	CurrencyFormat cf = new CurrencyFormat();
	
	strbaserate		  = cf.formatCurrency(strbaserate, noofdecimal);	
	strbasechargeamt  = cf.formatCurrency(strbasechargeamt, noofdecimal);	
	strgrosschargeamt = cf.formatCurrency(strgrosschargeamt, noofdecimal);		
	strdiscountamt    = cf.formatCurrency(strdiscountamt, noofdecimal);	
	strbaseqty        = cf.formatCurrency(strbaseqty,2);	
    strdiscountper    = cf.formatCurrency(strdiscountper,2);	
	straddlfactor     = cf.formatCurrency(straddlfactor,4);	

	strotherserviceamt = cf.formatCurrency(strotherserviceamt, noofdecimal);		
	strbilledamt = cf.formatCurrency(strbilledamt, noofdecimal);		
	strunbilledamt = cf.formatCurrency(strunbilledamt, noofdecimal);		
	strpaidamt = cf.formatCurrency(strpaidamt, noofdecimal);		
	stroutstamt = cf.formatCurrency(stroutstamt, noofdecimal);		
	
	strnetchargeamt		  = cf.formatCurrency(strnetchargeamt, noofdecimal);	

	if (strinsind.equals("Y"))
		{
			strpatgrosschargeamt    = cf.formatCurrency(strpatgrosschargeamt, noofdecimal);	
			strpatdiscamt			= cf.formatCurrency(strpatdiscamt, noofdecimal);	
			strpatnetamt			= cf.formatCurrency(strpatnetamt, noofdecimal);	

			strcustgrosschargeamt   = cf.formatCurrency(strcustgrosschargeamt, noofdecimal);	
			strcustdiscamt			= cf.formatCurrency(strcustdiscamt, noofdecimal);	
			strcustnetamt			= cf.formatCurrency(strcustnetamt, noofdecimal);	

			strpatotherserviceamt	= cf.formatCurrency(strpatotherserviceamt, noofdecimal);	
			strpatbilledamt			= cf.formatCurrency(strpatbilledamt, noofdecimal);	
			strpatunbilledamt			= cf.formatCurrency(strpatunbilledamt, noofdecimal);	
			strpatpaidamt			= cf.formatCurrency(strpatpaidamt, noofdecimal);	
			strpatoutstamt			= cf.formatCurrency(strpatoutstamt, noofdecimal);	

			strcustotherserviceamt			= cf.formatCurrency(strcustotherserviceamt, noofdecimal);	
			strcustbilledamt			= cf.formatCurrency(strcustbilledamt, noofdecimal);	
			strcustunbilledamt			= cf.formatCurrency(strcustunbilledamt, noofdecimal);	
			strcustpaidamt			= cf.formatCurrency(strcustpaidamt, noofdecimal);	
			strcustoutstamt			= cf.formatCurrency(strcustoutstamt, noofdecimal);	

		}
	%>		
 	
	<iframe SRC= "../../eBL/jsp/BLBillDetails.jsp?insind=<%=strinsind%>&baseqty=<%=strbaseqty%>&basechargeamt=<%=strbasechargeamt%>&baserate=<%=strbaserate%>&grosschargeamt=<%=strgrosschargeamt%>&discountper=<%=strdiscountper%>&discountamt=<%=strdiscountamt%>&daytypecode=<%=strdaytypecode%>&daytypedesc=<%=strdaytypedesc%>&timetypecode=<%=strtimetypecode%>&timetypedesc=<%=strtimetypedesc%>&addlfactor=<%=straddlfactor%>&patgrosschargeamt=<%=strpatgrosschargeamt%>&patdiscamt=<%=strpatdiscamt%>&patnetamt=<%=strpatnetamt%>&custgrosschargeamt=<%=strcustgrosschargeamt%>&custdiscamt=<%=strcustdiscamt%>&custnetamt=<%=strcustnetamt%>&ordercatalogcode=<%=strordercatalogcode%>&ordercatalogdesc=<%=java.net.URLEncoder.encode(strordercatalogdesc)%>&blngservcode=<%=strblngservcode%>&blngservdesc=<%=java.net.URLEncoder.encode(strblngservdesc)%>&blngrule=<%=strblngrule%>&netchargeamt=<%=strnetchargeamt%>&otherserviceamt=<%=strotherserviceamt%>&billedamt=<%=strbilledamt%>&unbilledamt=<%=strunbilledamt%>&paidamt=<%=strpaidamt%>&outstamt=<%=stroutstamt%>&patotherserviceamt=<%=strpatotherserviceamt%>&patbilledamt=<%=strpatbilledamt%>&patunbilledamt=<%=strpatunbilledamt%>&patpaidamt=<%=strpatpaidamt%>&patoutstamt=<%=strpatoutstamt%>&custotherserviceamt=<%=strcustotherserviceamt%>&custbilledamt=<%=strcustbilledamt%>&custunbilledamt=<%=strcustunbilledamt%>&custpaidamt=<%=strcustpaidamt%>&custoutstamt=<%=strcustoutstamt%>" NAME="TabFrame" noresize scrolling="NO" style="height:15vh;width:100vw"></iframe>
	<iframe SRC="../../eCommon/html/blank.html"	name="ValidationFrame" id="ValidationFrame" noresize scrolling="NO" style="height:0vh;width:100vw"></iframe>	
	<%	
	// commented in Bangalore on 13/10/2005
	//ConnectionManager.returnConnection(con, request);			
	}catch(Exception e){
		out.println(e.toString());
	}finally{  // Added in Bangalore on 13/10/2005
		if(con!=null){
			ConnectionManager.returnConnection(con, request);		
		}
	}
	%>
</HTML>

