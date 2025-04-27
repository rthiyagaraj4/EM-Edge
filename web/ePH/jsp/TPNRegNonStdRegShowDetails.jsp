<!DOCTYPE html>
<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNNonStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>
<%!
public String roundTwoDigits(String a)
{
	try
	{
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
			return a;
			
	}
}

%>

<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//	String patient_id	= request.getParameter("patient_id");
//	String encounter_id	= request.getParameter("encounter_id");
	String patientid=request.getParameter("patient_id");
	String encounterid=request.getParameter("encounter_id");
	String facility_id  = (String) session.getValue("facility_id");
	String bean_id	= "@TPNNonStandardRegimenBean"+patientid+encounterid;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	//String gCode=request.getParameter("gCode");
	String code				  = "";
	String strength			  = "";
	String carbohydrate_value = "";
	String carbo_ener		  = "";
	String lipid_ener		  = "";
	String prot_ener		  = "";
    String display_unit       = "";
	String display_unit1       = "";
	String Ab_w_lit           ="";
	String per_kg_litre       ="";
	String Stremgth_unit	  ="";
	ArrayList Results         =new ArrayList();
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);
	
	//get values for all groups and print it on the screen
	ArrayList groupcodes=new ArrayList();
	ArrayList groupdescs=new ArrayList();

	HashMap generics=new HashMap();

	groupcodes=bean.getStoredGroups();
	groupdescs=bean.getStoredGroupDescs();
	generics=bean.getGenerics();
 
	ArrayList MNEnergies = bean.getMNEnergies();

	if(MNEnergies.size()>0){
		carbo_ener = (String)MNEnergies.get(1);
		lipid_ener = (String)MNEnergies.get(3);
		prot_ener  = (String)MNEnergies.get(5);
	}
     ArrayList regmnDtls						    =   bean.getRegimenDetails();
	 String regimen_code                         =   (String)regmnDtls.get(0);
	 

%>
<!-- <BODY> -->
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="TpnShowDetails" id="TpnShowDetails">
<Table>

<%

for (int i=0;i<groupcodes.size();i++)
{
	int ispresent=0;
	ArrayList gns=(ArrayList)generics.get(groupcodes.get(i));
	
	if(groupcodes.get(i).equals("MN"))
	{
       Ab_w_lit="";
	   Stremgth_unit			             =bean.getenergyunit();
	}
	else
	{
    Results=(ArrayList)bean.getTPNGenerics((String)groupcodes.get(i),patientid,regimen_code);
	if(Results.size()>0)
      Ab_w_lit =(String)Results.get(3);
	 Stremgth_unit	  ="";
	}
	if(groupcodes.get(i).equals("MN"))
		per_kg_litre="";
	else{
	     if(Ab_w_lit.equals("P"))
		    per_kg_litre="/L";
	     else
		    per_kg_litre="/Kg";
	}

	for (int k=0;k<gns.size();k+=8)
		{
			if (!gns.get(k+2).equals("0"))
			{
					ispresent=1;
			}
		}
		if (ispresent==1)
		{
			String header="";
			if(groupcodes.get(i).equals("MN"))
				header="<th >per kg</th>";
			else
				header="<th >Strength</th>";
		%>
			<TR><TH colspan=3><%=groupdescs.get(i)%></TH>	<%=header%><th><fmt:message key="ePH.Energy.label" bundle="${ph_labels}"/> </th></TR>
		<%
		}

		for (int j=0;j<gns.size();j+=8)
		{
			code=(String)gns.get(j);
			strength="";
			if(code.equals("CHO")){
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(carbo_ener)) + "";
			}else if(code.equals("LIPID")){
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(lipid_ener)) + ""; 
			}else if(code.equals("PROTEIN")){ 
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(prot_ener)) + ""; 
			}

			if (!gns.get(j+2).equals("0"))
			{ 
				if(j==0 && code.equals("CHO")){
				carbohydrate_value=(String)gns.get(j+2);
				}
				display_unit	= (String)gns.get(j+3);
				if(display_unit.equals("tmp"))
				  display_unit1   =  "---";
				else
				  display_unit1   =  display_unit.substring((display_unit.indexOf("!"))+1,display_unit.length());
					 
			%>
				<TR>
				<TD width="15%"><%=gns.get(j+1)%></TD>
				<TD width="8%" align="right"><%=gns.get(j+2)%></TD>
				<!-- <TD width="10%"><%=((String)gns.get(j+3)).equals("tmp")?"---":(String)gns.get(j+3)%></TD> -->
				<TD width="8%"><%=display_unit1%></TD>
				<TD width="10%" align="right"><%=gns.get(j+4)%>&nbsp;<%=per_kg_litre%></TD>
				<TD width="10%" align="right"><%=roundTwoDigits(strength)%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,Stremgth_unit))%></TD>
				</TR>
			<%
			}

		}
	%>

<%
}
%>
</tr>

</TABLE>
<input type="hidden" name="bean_id" id="bean_id" value=<%=bean_id%>>
<input type="hidden" name="carbohydrate_value" id="carbohydrate_value" value=<%=carbohydrate_value%>>

</form>
</BODY>
<% putObjectInBean(bean_id,bean,request); %>
</HTML>

