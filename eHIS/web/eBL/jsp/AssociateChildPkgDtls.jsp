<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgDefBean, eCommon.Common.*,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script> 
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
				
</head>

<script>
	
			$(document).ready(function(){

		 var totalrecords=parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById("totRec").value;
		 totalrecords=totalrecords-1;
		 var fromDate= parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById('from_date').value;
		 
		 
		 var firstDate=$(parent.parent.PkgDefBaseDateMain.baseDateDtl.document).find('#fromDate_'+totalrecords).val();
		 if(fromDate==""||fromDate==null||fromDate=="undefined"||fromDate=="undefined")
			 {
		 fromDate=firstDate;
			 }
	
	$('#from_date').val(fromDate);
	});
	</script>	


<% 
	try
	{
		String dateFormat = "dd/MM/yyyy HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance();
		System.out.println("PkgdefBasePrice 1-->"+sdf.format(c.getTime()));
		String locale			     = (String)session.getAttribute("LOCALE");
		String facilityId		     = (String) session.getValue( "facility_id" ) ;
		String fromDate              ="";
		String copyFrm_pkgCode		=	"" ;
		copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		int  totRec				     = 1;
		HashMap childPackages		 = new HashMap();
		HashMap childPackdtl		 = new HashMap();
		ArrayList dtlsArray	      	 =	new ArrayList();
		ArrayList child_pkgcode	 	 =	new ArrayList();
		ArrayList child_pkgdesc	 	 =	new ArrayList();
		ArrayList child_effFromDate	 =	new ArrayList();
		ArrayList child_effToDate	 =	new ArrayList();
		ArrayList flag	 =	new ArrayList();

															   
		CurrencyFormat cf        = new CurrencyFormat();
		//String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		 fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String fromDateTemp = "";
		String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
	    String	mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		System.out.println("authorized -After bl_rateBasedPkgDefBean-->"+authorized);
		String modifyStatus = "";
		String status = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		String bean_id		     = "bl_PkgDefBean" ;
		String bean_name	     = "eBL.PkgDefBean";
		String flagVal           = "insert";
		PkgDefBean bean		     = (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		
		String childPack_code="", childPack_desc="",childPack_effFrm="", childPack_effTo="";
		String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		System.out.println("PkgdefBasePrice -After PACKAGE_PRICE-->"+sdf.format(c.getTime()));
		
		childPackages	=  (HashMap)bean.getChildPackages();
		//System.out.println("jsadja"+childPackdtl.containsKey(fromDate));
	if(childPackages.containsKey(packageCode))
		{
			childPackdtl	= (HashMap)childPackages.get(packageCode);
			System.out.println("jsadja"+childPackdtl.containsKey(fromDate));
		}
		
		if(mode.equals("modify") && !(childPackdtl.containsKey(fromDate))) {	
	
		bean.setDBValues("CHILD_PACK",packageCode,locale,facilityId,"","",fromDate);//set database values to bean.
		childPackages	=  (HashMap)bean.getChildPackages();
	}
	if(mode.equals("insert") && !copyFrm_pkgCode.equals("")){
			bean.setDBValues("CHILD_PACK",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);//set database values to bean.		
	}
	
	if(childPackages.containsKey(packageCode))
	{
		childPackdtl	= (HashMap)childPackages.get(packageCode);
	}
	
			
		if(childPackdtl.containsKey(fromDate)){
		dtlsArray =(ArrayList)childPackdtl.get(fromDate);
		
				if(childPackages.containsKey(packageCode)){
				if(dtlsArray.size()>0)
				{							   
						child_pkgcode=(ArrayList)dtlsArray.get(0);
						child_pkgdesc=(ArrayList)dtlsArray.get(1);
						child_effFromDate=(ArrayList)dtlsArray.get(2);
						child_effToDate=(ArrayList)dtlsArray.get(3);
						flag=(ArrayList)dtlsArray.get(4);

				}
				
				}
		}
		System.out.println("PkgdefBasePrice -After Assigning-->"+sdf.format(c.getTime()));
		
		//if(totRec ==1 ) flagVal = "insert"; 		
		System.out.println("date format 3-->"+sdf.format(c.getTime()));
		//Karthik added code here MMS-CRF-0023 Starts
		String strChargeLogic="N";
		Connection con= ConnectionManager.getConnection(request);
		PreparedStatement pstmtChrg = con.prepareStatement("select NVL(CHARGE_LOGIC_YN,'N')  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmtChrg.setString(1,facilityId);
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		if( rsChrg != null ) 
		{	
			while( rsChrg.next() )
			{  
				strChargeLogic = rsChrg.getString(1);
				if(strChargeLogic==null){
				strChargeLogic="N";
				}
			}
		}
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close();
		//Karthik added code here MMS-CRF-0023 Ends
		System.out.println("date format 4-->"+sdf.format(c.getTime()));
		if(child_pkgcode.size() >0)
				totRec = child_pkgcode.size();	
			System.out.println("date format 4-->"+totRec);
			
			String table_name="frmChildPackdtls";
			String key="CHILD_PACK";
			System.out.println("flagVal1111111111"+flagVal);
			
				
		
%>		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">	
	<form name='frmChildPackdtls' id='frmChildPackdtls'>
	<!-- <div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px"> -->	
	
	<table  width="100%" cellspacing='0' cellpadding='3' id="ass_child_pack_tbl">	

	<tr>
	<td  class='COLUMNHEADER' width ='' ><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>	
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>	
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>		
	</tr>
	
	<%
		for(int i=0; i<totRec; i++)
	{	
	
	if((child_pkgcode !=null) && child_pkgcode.size()>0)
	{
		childPack_code = (String)(child_pkgcode.get(i)==null?"":child_pkgcode.get(i));
		childPack_desc = (String)(child_pkgdesc.get(i)==null?"":child_pkgdesc.get(i));
		childPack_effFrm = (String)(child_effFromDate.get(i)==null?"":child_effFromDate.get(i));
		childPack_effTo   = (String)(child_effToDate.get(i)==null?"":child_effToDate.get(i));
		flagVal	 = (String)(flag.get(i)==null ? "insert" : flag.get(i));
		System.out.println("PkgdefBasePrice -Before Values-->"+flagVal);
	}
	System.out.println("flagVal-->"+flagVal);
	System.out.println("PkgdefBasePrice -Before Values-->"+sdf.format(c.getTime()));
	if("modify".equals(flagVal)){
				
				status="disabled";
			}
			else{
				
			status="enabled";
			
			}
	%>
	
	<tr >
	<td  class='fields' WIDTH='10%' nowrap><input type='text' name='childPackCode_<%=i%>' id='childPackCode_<%=i%>'  <%=modifyStatus%>  <%=status%> size='3' maxlength="2" onBlur="child_pkgCodeLookup(childPackCode_<%=i%>,childPackDesc_<%=i%>,'<%=i%>');" value="<%=childPack_code%>"> <input type='text' name='childPackDesc_<%=i%>' id='childPackDesc_<%=i%>' <%=modifyStatus%> <%=status%> size='15' maxlength="30" value="<%=childPack_desc%>" onBlur="child_pkgCodeLookup(childPackCode_<%=i%>,childPackDesc_<%=i%>,'<%=i%>');" >	<input type='button' class='button' name='childPack_<%=i%>' id='childPack_<%=i%>' value='?' <%=modifyStatus%> <%=status%> onClick="child_pkgCodeLookup(childPackCode_<%=i%>,childPackDesc_<%=i%>,'<%=i%>');" tabindex='0'  ><img src='../../eCommon/images/mandatory.gif'></td>
	<td  class='fields' width="10%"><input type='text' name='fromDate_<%=i%>' id='fromDate_<%=i%>' <%=modifyStatus%>  <%=status%>  id='fromDate_<%=i%>'size='15' maxlength="20"  value="<%=childPack_effFrm%>" onBlur="childPackdetails(this,'document.getElementById("fromDate_")<%=i%>','','<%=i%>','fromDate');"  ><img id = 'fromDate_img_<%=i%>' name="fromDate_img_<%=i%>"  <%=modifyStatus%> 	<%=status%> src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_<%=i%>','dd/mm/yyyy ');" STYLE="display:inline;"><img src='../../eCommon/images/mandatory.gif'></td>
	<td  class='fields' width="10%"><input type='text' name='toDate_<%=i%>' id='toDate_<%=i%>'  id='toDate_<%=i%>' <%=modifyStatus%>  size='15' maxlength="20"  value="<%=childPack_effTo%>" onBlur="childPackdetails(this,'document.getElementById("fromDate_")<%=i%>','document.getElementById("toDate_")<%=i%>','<%=i%>','toDate');"  ><img id = 'toDate_img_<%=i%>' name="toDate_img_<%=i%>"	<%=modifyStatus%>  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_<%=i%>','dd/mm/yyyy ');" STYLE="display:inline;">
	<input type='hidden' name='flag_<%=i%>' id='flag_<%=i%>' value="<%=flagVal%>" >
	</td>			

	</tr>
	<%} %>
	</table>		
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" />
	<input type='hidden' name='totRec' id='totRec' value="<%=totRec%>" />
	
	<input type='hidden' name='index' id='index' value="0" />
	<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
	<input type='hidden' name='strChargeLogic' id='strChargeLogic' value="<%=strChargeLogic%>" /><!-- Added V06042018-Aravindh/GHL-SCF-1107 -->
	
<script>	
<%
//out.flush();
System.out.println("PkgdefBasePrice -Before updateCurrentForm-->");
System.out.println("PkgdefBasePrice -Before updateCurrentForm-->");

	%>
	
updateCurrentForm("CHILD_PACK","parent.frames[3].frames[0].document.frmChildPackdtls","","parent.parent.frames[0].document.forms[0]",<%=totRec%>);
	
</script>
	<script>alignHeading_BasePrice();</script>
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package Base Price :"+e);
	e.printStackTrace();
}
%>

