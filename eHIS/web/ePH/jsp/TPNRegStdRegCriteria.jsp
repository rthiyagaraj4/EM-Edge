<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/04/2016	IN067051     Devindra							                Enhance TPN Ordering Functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	//String locale = (String) session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimen.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>


</HEAD>
<%!
public ArrayList roundNumbers(int a)
{
	int i=a-a%100;
	int j=i+100;
	ArrayList result=new ArrayList();
	result.add(i+"");
	result.add(j+"");
	return result;
}
%>
<%
	String inval					=request.getParameter("initialValue");
	String cunit					=request.getParameter("cunit")==null?"":request.getParameter("cunit");
	String punit					=request.getParameter("punit")==null?"":request.getParameter("punit");
	String lunit				    =request.getParameter("lunit")==null?"":request.getParameter("lunit");

	String chofval					="";
	String lipidfval				="";
	String proteinfval			="";
	String chotval					="";
	String lipidtval				="";
	String proteintval			="";
	

	String c							=request.getParameter("cho");
	String l							=request.getParameter("lipid");
	String p							=request.getParameter("protein");
	
	String cho_energy =request.getParameter("cho_energy");
	String pro_energy =request.getParameter("pro_energy");
	String lipd_energy =request.getParameter("lipd_energy");
	String cho_qty =request.getParameter("cho_qty");
	String pro_qty =request.getParameter("pro_qty");
	String lipd_qty =request.getParameter("lipd_qty");
    String fluid   =request.getParameter("fluid");
	String fluidunit   =request.getParameter("fluidunit");
	
	String assesMentReqYn = request.getParameter("assesMentReqYn")==null?"Y":request.getParameter("assesMentReqYn"); // Added for ML-MMOH-CRF-1126 - Start
	
	if(!assesMentReqYn.equals("Y")){
		assesMentReqYn= "onLoadAssesmntNtReq";
	}
	else{
		assesMentReqYn= "onLoad";
	}

	//c="1217";
//	l="1217";
//	p="1217";
	

	int remaining=0;
	String toround="";

//	out.println("c is"+c+":l is"+l+":p is "+p);	
	if ((c!=null)&&(!c.equals("")))
	{
		/* int cho							=Math.round(new Float(c).floatValue());
		int lipid							=Math.round(new Float(l).floatValue());
		int protein						=Math.round(new Float(p).floatValue());  commented for ML-MMOH-CRF-1266 [IN:068728] */
		int cho							=0; //ML-MMOH-CRF-1266 [IN:068728] - Start
		int lipid						=0;
		int protein						=0;
		try{
		   cho							=Math.round(new Float(c).floatValue());
		   lipid						=Math.round(new Float(l).floatValue());
		   protein						=Math.round(new Float(p).floatValue());
		}
		catch(Exception e){
			e.printStackTrace();
			cho							=-1;
			lipid						=-1;
			protein						=-1;
			c="0";
			l="0";
			p="0";
			cunit = "Milli"+cunit;
			punit = "Milli"+punit;
			lunit = "Milli"+lunit;
		} //ML-MMOH-CRF-1266 [IN:068728] - End
		int from							=0;
		int to								=0;
		String tmp						="";
		int temp							=0;
		int start							=0;
		int stop							=0;
		lipidfval							=l+"";
		lipidtval							=l+"";
		chofval							=c+"";
		chotval							=c+"";
		proteinfval						=p+"";
		proteintval						=p+"";
		ArrayList getRounded		=new ArrayList();


		
		//Calculating range for Carbohydrates
		temp	=cho%100;
		if (temp!=0)
		{
			if (cho<0)
			{
					chofval="0";
					chotval="100";
			}
			else
			{
				tmp=cho+"";
				if (tmp.length()>=3 )
				{
					if (tmp.length()==3)
					{
						start=1;
						stop=3;
					}
					else
					{
						start=tmp.length()-2;
						stop=tmp.length();
					}
					toround=tmp.substring(start,stop);
					if (toround!=null && !toround.equals(""))		
					{
						remaining		=cho-Integer.parseInt(toround);
						getRounded	=roundNumbers(Integer.parseInt(toround));
						from				=remaining+Integer.parseInt((String)getRounded.get(0));
						to					=remaining+Integer.parseInt((String)getRounded.get(1));
					}
				}
				else
				{
					//means less than 3 and so directly
					from=0;
					to=100;

				}
				
				chofval							=from+"";
				chotval							=to+"";
			}

		}


		//Calculating range for Proteins
		temp	=protein%100;
		if (temp!=0)
		{
			if (protein<0)
			{
					proteinfval="0";
					proteintval="100";
			}
			else
			{
				tmp=protein+"";
				if (tmp.length()>=3 )
				{
					if (tmp.length()==3)
					{
						start=1;
						stop=3;
					}
					else
					{
						start=tmp.length()-2;
						stop=tmp.length();
					}
					toround=tmp.substring(start,stop);
					if (toround!=null && !toround.equals(""))		
					{
						remaining		=protein-Integer.parseInt(toround);
						getRounded	=roundNumbers(Integer.parseInt(toround));
						from				=remaining+Integer.parseInt((String)getRounded.get(0));
						to					=remaining+Integer.parseInt((String)getRounded.get(1));
					}
				}
				else
				{
					//means less than 3 and so directly
					from=0;
					to=100;

				}
				
				proteinfval							=from+"";
				proteintval							=to+"";
			}

		}

		//Calculating range for lipids
		temp	=lipid%100;
		if (temp!=0)
		{
			if (lipid<0)
			{
					lipidfval="0";
					lipidtval="100";
			}
			else
			{
				tmp=lipid+"";
				if (tmp.length()>=3 )
				{
					if (tmp.length()==3)
					{
						start=1;
						stop=3;
					}
					else
					{
						start=tmp.length()-2;
						stop=tmp.length();
					}
					toround=tmp.substring(start,stop);
					if (toround!=null && !toround.equals(""))		
					{
						remaining=lipid-Integer.parseInt(toround);
						getRounded=roundNumbers(Integer.parseInt(toround));
						from								=remaining+Integer.parseInt((String)getRounded.get(0));
						to									=remaining+Integer.parseInt((String)getRounded.get(1));
					}
				}
				else
				{
					//means less than 3 and so directly
					from=0;
					to=100;

				}
				
				lipidfval							=from+"";
				lipidtval							=to+"";
			}

		}
	

	}//if values are specified from assessment bean

	
	
	//String bean_id	= "TPNStandardRegimenBean";
	//String bean_name	 = "ePH.TPNStandardRegimenBean";

//	TPNStandardRegimenBean bean = (TPNStandardRegimenBean)mh.getBeanObject( bean_id, request, bean_name ) ;

%>
<script language = "JavaScript">
function loadValues(fromWhere)
{
   if(fromWhere == 'onLoadAssesmntNtReq') // Added for ML-MMOH-CRF-1126 - Start
	{
		document.StdRegLookupCriteria.bsdOnAssmntValues.checked = false;
		document.StdRegLookupCriteria.CHO_PER.value = '10';
		document.StdRegLookupCriteria.PROTEIN_PER.value = '10';
		document.StdRegLookupCriteria.LIPID_PER.value = '10';
	} // Added for ML-MMOH-CRF-1126 - End
	
   else if(fromWhere == 'onLoad')
	{
		document.StdRegLookupCriteria.bsdOnAssmntValues.checked = true;
	}
	if(document.StdRegLookupCriteria.bsdOnAssmntValues.checked == true)
	{
		
		document.StdRegLookupCriteria.chofrom.value = '<%=chofval%>';
		document.StdRegLookupCriteria.choto.value = '<%=chotval%>';
		document.StdRegLookupCriteria.CHO.value = '<%=c%>';
		document.StdRegLookupCriteria.proteinfrom.value = '<%=proteinfval%>';
		document.StdRegLookupCriteria.proteinto.value = '<%=proteintval%>';
		document.StdRegLookupCriteria.PROTEIN.value = '<%=p%>';
		document.StdRegLookupCriteria.lipidfrom.value = '<%=lipidfval%>';
		document.StdRegLookupCriteria.lipidto.value = '<%=lipidtval%>';
		document.StdRegLookupCriteria.LIPID.value = '<%=l%>';
		document.StdRegLookupCriteria.CHO_PER.value = '10';
		document.StdRegLookupCriteria.PROTEIN_PER.value = '10';
		document.StdRegLookupCriteria.LIPID_PER.value = '10';
	}
}

</script>


<!-- <BODY onload = "loadValues('onLoad')"> -->
<BODY onload = "loadValues('<%=assesMentReqYn%>')" onMouseDown="" onKeyDown="lockKey()"> <!--  assesMentReqYn  Added for ML-MMOH-CRF-1126 -->
	<FORM name="StdRegLookupCriteria" id="StdRegLookupCriteria">
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="left" BORDER="0">
		<tr>
		<td colspan=2 align=left>
		<Table cellspacing=0 cellpadding=0 border="0">
		<tr>
		<Td   class="label" align="right" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></Td>	
		<td colspan=4>&nbsp;&nbsp;<input type=text name="name" id="name" maxlength=30 size="15" value="<%=inval%>">
		<select name="searchpos" id="searchpos" id="searchpos">
				<option value="sw"><fmt:message key="ePH.StartWith.label" bundle="${ph_labels}"/></option>
				<option value="ct"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option> 
			</select></td>
		<Td   class="label" align="left" nowrap><fmt:message key="ePH.BasedonAssessmentValues.label" bundle="${ph_labels}"/> </Td>
	<%    if(assesMentReqYn.equals("onLoadAssesmntNtReq")){ // if else added for ML-MMOH-CRF-1126 - Start
	%>
		<Td   class="label" align="left" ><input type="checkbox" id="bsdOnAssmntValues" name="bsdOnAssmntValues" id="bsdOnAssmntValues" value="N" onclick="basedOnAssmntValuesSet(this);loadValues('onclick');"></Td>
		<%} else{ %>
		<Td   class="label" align="left" ><input type="checkbox" id="bsdOnAssmntValues" name="bsdOnAssmntValues" id="bsdOnAssmntValues" value="Y" onclick="basedOnAssmntValuesSet(this);loadValues('onclick');"></Td>
		<%} // if else added for ML-MMOH-CRF-1126 - End %>
		<Td   class="label" align="left"   nowrap>&nbsp;<fmt:message key="Common.display.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;  <input type="textbox" name="displayRecords" id="displayRecords" size="3" maxlength="2" value="5" onKeyPress="return allowValidNumber(this,event,2,0);" onBlur="displyRange(this);" > &nbsp;&nbsp; <fmt:message key="ePH.Records.label" bundle="${ph_labels}"/></Td>
		<!-- <Td   class="label" align="left" ></Td>
		<Td   class="label" align="left" ></Td>    -->
		</tr>
		<!-- onBlur="CheckNum(this)" -->
		<tr>
		<Td   class="label" align="right" ><fmt:message key="ePH.CHOBetween.label" bundle="${ph_labels}"/></Td> 
		<Td   >&nbsp;&nbsp;<input type=text name="chofrom" id="chofrom" maxlength=5 size=5 	class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}"></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=cunit%></B></Td> 
		<Td   class="label" align="center" width="10%" >&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>&nbsp;</Td>   
		<Td   >&nbsp;<input type=text name="choto" id="choto" maxlength=5 size=5 	class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}" ></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=cunit%></B> </Td> 
		<Td   class="label" align="right" ><fmt:message key="ePH.CHO.label" bundle="${ph_labels}"/></Td> 
		<Td   class="label" align="right" >&nbsp;<input type=text name="CHO" id="CHO" maxlength=5 size=5 class="number" readonly >&nbsp;<B><%=cunit%></B> </Td> 
		<Td   class="label" align="right" nowrap>&nbsp;&nbsp;+/-&nbsp;<input type="textbox" name="CHO_PER" id="CHO_PER" size="5" maxlength="3" onKeyPress="return allowValidNumber(this,event,3,0);" onBlur="checkConsRange(this);" >&nbsp;</Td>
 		</tr>

		<tr>
		<Td   class="label" align="right" ><fmt:message key="ePH.ProteinBetween.label" bundle="${ph_labels}"/></Td> 
		<Td   >&nbsp;&nbsp;<input type=text name="proteinfrom" id="proteinfrom" maxlength=5 size=5 class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}"></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=punit%> </B></Td> 
		<Td   class="label" align="center" width="10%" >&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>&nbsp;</Td> 
		<Td   >&nbsp;<input type=text name="proteinto" id="proteinto" maxlength=5 size=5 		class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}"></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=punit%></B> </Td> 
			<Td   class="label" align="right" ><fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/></Td> 
			<Td   class="label" align="right" >&nbsp;<input type=text name="PROTEIN" id="PROTEIN" maxlength=5 size=5 class="number" readonly >&nbsp;<B><%=punit%> </B></Td> 
			<Td   class="label" align="right" >&nbsp;&nbsp;+/-&nbsp;<input type="textbox" name="PROTEIN_PER" id="PROTEIN_PER" size="5" maxlength="3"  onKeyPress="return allowValidNumber(this,event,3,0);" onBlur="checkConsRange(this);" >&nbsp;</Td>
		</tr>
		<tr>
		<Td   class="label" align="right" ><fmt:message key="ePH.LipidBetween.label" bundle="${ph_labels}"/></Td> 
		<Td    >&nbsp;&nbsp;<input type=text name="lipidfrom" id="lipidfrom" 		class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}"  maxlength=5 size=5></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=lunit%></B> </Td> 
		<Td   class="label" align="center" width="10%" >&nbsp;<fmt:message key="Common.and.label" bundle="${common_labels}"/>&nbsp;</Td> 
		<Td    >&nbsp;<input type=text class="number" onBlur="CheckPositiveNumber(this);if(this.value==0){this.value=''}" name="lipidto" id="lipidto" maxlength=5 size=5></Td> 
		<Td   class="label" align="right" >&nbsp;<B><%=lunit%> </B></Td>
		<Td   class="label" align="right" > <fmt:message key="Common.Lipid.label" bundle="${common_labels}"/></Td>
		<Td   class="label" align="right" >&nbsp;<input type=text name="LIPID" id="LIPID" maxlength=5 size=5 class="number" readonly >&nbsp;<B><%=lunit%></B> </Td>
		<Td   class="label" align="right" >&nbsp;&nbsp;+/-&nbsp;<input type="textbox" name="LIPID_PER" id="LIPID_PER" size="5" maxlength="3" onKeyPress="return allowValidNumber(this,event,3,0);" onBlur="checkConsRange(this);" ></Td></tr>
		<tr><td class="label" align="right"><fmt:message key="ePH.EmulsionType.label" bundle="${ph_labels}"/></td>
		<Td colspan="8"  class="label" align="right" >&nbsp;<SELECT name="eml_type" id="eml_type" id="eml_type" >  
				    <OPTION value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="M" ><fmt:message key="ePH.MCT.label" bundle="${ph_labels}"/></OPTION>
				    <OPTION value="L"><fmt:message key="ePH.LCT.label" bundle="${ph_labels}"/></OPTION>
				    <OPTION value="B"><fmt:message key="ePH.MixtureofMCTandLCT.label" bundle="${ph_labels}"/></OPTION>
		</SELECT>
		</td>
		</tr>

		</Table>
		</td>
		</tr>
		<tr>
		<td width="50%">&nbsp;</td>
		<Td colspan="1" align="middle">
			<input type="button" class="button" value="Search" onClick="showLookupResult(document.StdRegLookupCriteria)">
			<input type="button"  class="button" value="Additional Criteria" onClick="showAdditionalCriteria()">
			<input type="button" class="button" value="Cancel" onClick="closeWindow()">
			<input type="reset" class="button" value="Clear" onClick="unCheck()">

			<input type="hidden" name="cho_energy" id="cho_energy" value="<%=cho_energy%>">
			<input type="hidden" name="pro_energy" id="pro_energy" value="<%=pro_energy%>">
			<input type="hidden" name="lipd_energy" id="lipd_energy" value="<%=lipd_energy%>">
			<input type="hidden" name="cho_qty" id="cho_qty" value="<%=cho_qty%>">
			<input type="hidden" name="pro_qty" id="pro_qty" value="<%=pro_qty%>">
			<input type="hidden" name="lipd_qty" id="lipd_qty" value="<%=lipd_qty%>">
			<input type="hidden" name="fluid" id="fluid" value="<%=fluid%>">
			<input type="hidden" name="fluidunit" id="fluidunit" value="<%=fluidunit%>">
			<input type="hidden" name="unit" id="unit" value="<%=punit%>">
			</Td>
		</TR>
		</TABLE>
	</FORM>

	<script>//populateAddSearch(StdRegLookupAddlCriteria)</script> 
</body>

