<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* ,com.ehis.util.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    String locale =((String)session.getAttribute("LOCALE"));
%>
<html>

<head>
	<link type="text/css" rel="stylesheet" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

	<script language="JavaScript">
	<!--
			function closeWindow(val)
			{
				parent.window.close();
				parent.window.returnValue=val+'`'+'N';
			}
			
			async function ViewBirthRegister(pat_id,outcome)
			{				
				var url		= "../../eMP/jsp/NewbornViewBirthRegister.jsp?Patient_ID="+pat_id;
				var dialogTop	= "10px";//65
				var dialogHeight= "100vh" ; //42
				var dialogWidth	= "100vw" ;	//72
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no;scroll:yes" ;
				var returnval = await window.showModalDialog1( url, arguments, features ) ;	
				return returnval;
			}
			
			async function ViewOutcome(pat_id)
			{
				var url		= "../../eMR/jsp/DeathDiagnosisDtls.jsp?Patient_ID="+pat_id;
				var dialogTop	= "210";
				var dialogHeight= "15" ; 
				var dialogWidth	= "49.8" ;
				var arguments	= "" ;
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
				var returnval = await window.showModalDialog( url, arguments, features ) ;	
				return returnval;
			}
			
	//-->
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body onKeyDown = 'lockKey()'>
<form name="f" id="f">
<%
		Connection con = null;
		
		String accessRights = request.getParameter("accessRights");
		if( accessRights == null) accessRights="";

		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String motherid = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		String birth_date="";
		String birth_time="";
	try{
		con = ConnectionManager.getConnection(request);

		String sql = " select /*+index(b mp_patient_pk)*/ to_char(a.TIME_OF_BIRTH,'dd/mm/yyyy') birth_date, to_char(a.TIME_OF_BIRTH,'hh24:mi') birth_time,  a.OUTCOME, a.NB_SEX, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, a.PATIENT_ID, a.WEIGHT, a.WEIGHT_UNIT, a.OUTCOME, AM_GET_DESC.AM_PRACTITIONER(a.attend_physician_id,'"+locale+"','1') practitioner_name from mp_birth_register a, mp_patient b where a.MOTHER_PATIENT_ID='"+motherid+"' and a.patient_id = b.patient_id order by a.time_of_birth";

		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		int i=0;
		String classValue = "";
		String patientid ="";
		String birth_weight = "";
		String outcome = "";
		
		Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
		
		if(rset!=null && rset.next())
		{	%>		
			<table border=1 cellpadding=0 cellspacing=0 width='100%'>
				<tr><td class='COLUMNHEADER'>&nbsp;</td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.patientId.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.PatientName.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.birthDate.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.time.label' bundle='${common_labels}'/></B></td>
		            <td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.gender.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='eMP.BirthWeight.label' bundle='${mp_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.outcome.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.practitioner.label' bundle='${common_labels}'/></B></td>
				</tr>
			<%
			do
			{
				i++;

				if(i%2 == 0) 
					classValue="QRYEVEN";
				else
					classValue = "QRYODD";

				patientid = rset.getString(6);
				outcome=rset.getString(3)==null?"":rset.getString(3);
				out.println("<tr>");
				out.println("<td  class='"+classValue+"'><a href=\"javascript:ViewBirthRegister('"+patientid+"','"+outcome+"')\">+</a></td>");
				out.println("<td  class='"+classValue+"'>"+rset.getString(6)+"</td>");
				out.println("<td  class='"+classValue+"'>"+rset.getString(5)+"</td>");			
				//out.println("<td  class='"+classValue+"'>"+rset.getString(1)+"</td>");
				birth_date=rset.getString(1) == null?"":rset.getString(1);
				birth_time=rset.getString(2) == null?"&nbsp;":rset.getString(2);				
				birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);
				if(birth_date == "") {birth_date="&nbsp;";}
				out.println("<td  class='"+classValue+"'>"+birth_date+"</td>");
				out.println("<td  class='"+classValue+"'>"+birth_time+"</td>");
				String gender=rset.getString(4)==null?"":rset.getString(4);
				//out.println("<td  class='"+classValue+"'>"+rset.getString(4)+"</td>");
				     if(gender.toUpperCase().equals("M"))
	             {%>
	                  <td class='"+classValue+"''><fmt:message key="Common.male.label" bundle="${common_labels}"/></td> 
	           <%}else if(gender.toUpperCase().equals("F"))
	                    {%>
	                  <td class='"+classValue+"'><fmt:message key="Common.female.label" bundle="${common_labels}"/></td> 
	                  <%}else if(gender.toUpperCase().equals("U"))
	                    {%>
	                   <td class='"+classValue+"'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></td>
	  <%}
				
				birth_weight = rset.getString(7)==null?"":rset.getString(7);
				String weight_unit=rset.getString(8)==null?"":rset.getString(8);
				if(weight_unit.toUpperCase().equals("K"))
                {
				weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				}
				else if(weight_unit.toUpperCase().equals("L"))
                {
			   weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				}
				if(!birth_weight.equals(""))
				out.println("<td  class='"+classValue+"'>"+birth_weight+" "+weight_unit+"&nbsp;</td>");
				else
				out.println("<td  class='"+classValue+"'>"+birth_weight+"&nbsp;</td>");
				
				if(outcome.equals("L"))
				{
					if(isLabelChangeApplicable){
				out.println("<td  class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Alive.label","mp_labels")+"</td>");//Modified by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
					}else{
					out.println("<td  class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Live.label","mp_labels")+"</td>");
					}
				}else if(outcome.equals("S")){
				out.println("<td  class='"+classValue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBorn.option.label","mp_labels")+"</td>");
				}
				
			//	out.println("<td  class='"+classValue+"'>"+rset.getString(3)+"</td>");
				
					
					out.println("<td  class='"+classValue+"'>"+(rset.getString(10)==null?" " :rset.getString(10))+"&nbsp;</td></tr>");
			}while(rset.next());
			out.println("</table>");
		}
		else
		{
			out.println("<script>closeWindow('"+motherid+"');</script>");
		}
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

