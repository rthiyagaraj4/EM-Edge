<!DOCTYPE html>
<%@ page import ="ePH.*, ePH.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../js/PrescribingUomDecimal.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css'	href='../../eCommon/html/<%=sStyle%>'></link>
<body class='CONTENT'  onKeyDown='lockKey()' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()'>
	<%
	String strUOMCode = request.getParameter("txt_uomcode");
	String strUOMShortdesc = request.getParameter("txt_uomdesc");
	String strUOMDecimalVal = request.getParameter("txt_decimalvalue");
	String strUOMFractionalVal = request.getParameter("txt_fractionalvalue");
	String strUOMFractionalDesc = request.getParameter("txt_fractionaldesc");
	String classvalue	= "";
	boolean searched	=	 request.getParameter( "searched" ) == null ? false : true  ;
	try {
		HashMap sqlMap = new HashMap();//Common parameters.
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();//The fields are going to be display
		ArrayList chkFields = new ArrayList();//Function Parameters
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_PRES_UOM_DECIMAL_SELECT_ALL"));
		
		displayFields.add( "UOM_CODE" );
		displayFields.add( "UOM_DESC" );
		displayFields.add( "DECIMAL_VALUE" );
		displayFields.add( "FRACT_VALUE" );
		displayFields.add( "FRACT_DESC" );
		displayFields.add( "FRACT_DESC_LOCAL" );
		displayFields.add( "EFF_STATUS" );
		
		chkFields.add(strUOMCode.trim()+ "%");
		chkFields.add(strUOMShortdesc.trim()+ "%");
		chkFields.add(strUOMDecimalVal.trim()+ "%");
		chkFields.add(strUOMFractionalVal.trim()+ "%");
		chkFields.add(strUOMFractionalDesc.trim()+ "%");
		chkFields.add(locale);
		
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
		if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%out.println(result.get(1));%></td><!-- For display the previous/next link -->
			</tr>
			</table>
		
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="ePH.PrescribeUomCode.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="Common.uom.label" bundle="${common_labels}" />&nbsp;<fmt:message	key="Common.description.label" bundle="${common_labels}" /></th>
				<th><fmt:message key="ePH.DecimalValue.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.FractionalValue.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.FractionalDescription.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="ePH.FractionalDescLocal.label" bundle="${ph_labels}"/></th>
				<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			<%
				//Retriving the records from result arraylist
				ArrayList records=new ArrayList();
				String dkVal = "";
				for(int recCount=2; recCount<result.size(); recCount++) 
				{
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
			%>
				<tr>
			<%
					records=(ArrayList) result.get( recCount );
					for(int colCount=0; colCount<records.size(); colCount++)
					{
						if(colCount==0)
						{
							dkVal = (String)records.get( colCount );
			%>
							
							<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get(0)%>','<%=records.get(2)%>')"><%=dkVal%></font>&nbsp;</td>
			<%
						}
						else if(colCount==6 )
						{
							dkVal = (String)records.get( colCount );
			%>
							<td class="<%=classvalue%>" onclick="disableClick(event);" align="center"><%out.println(getImage(dkVal));%>&nbsp;</td>
			<%			}	
						else 
						{		
							dkVal = ((String)records.get( colCount ));
			%>
							
							<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull(dkVal)%>&nbsp;</td>
			<%
							
						}
					}
			%>
			</tr>
		<%
		}
		%>
		</table>
		<%
			out.flush();
		} else{
		%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PrescribingUomDecimalQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
}
%>

</body>
</html>

	

