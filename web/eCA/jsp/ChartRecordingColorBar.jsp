<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<SCRIPT LANGUAGE="JavaScript">
function clearLayer()
{
	hidePopUp();
}
function showToolTip(obj,objcount,text)
{	
	//alert("objcount:"+objcount);
	if(text.length>15)
	{
		var tab_dat  = "<table class='grid' id='tooltiptable1'  width='' height='10' align='center'>"
		tab_dat   =  tab_dat+"<tr bgcolor='lightyellow' >" ;
		tab_dat    = tab_dat+ "<td class = 'contextMenuItem' style='padding-left:10px;padding-right:10px' >"+text+"</td>" ;
		tab_dat     =tab_dat+ "</tr>" ;		
		tab_dat     =tab_dat+ "</table> ";		
		//document.getElementById("t").innerHTML = tab_dat;	
		document.getElementById("descLink").innerHTML = tab_dat;	
		document.getElementById("descLink").style.top  = obj.offsetTop;
		if(objcount=="5")
		{
			document.getElementById("descLink").style.left  = obj.offsetLeft+37;
		}
		else
		{
			document.getElementById("descLink").style.left  = obj.offsetLeft+80;
		}
		document.getElementById("descLink").style.visibility='visible' ;
	}
	else
	{
		hidePopUp();
	}
}

function hidePopUp()
{
	if(document.getElementById("descLink"))
	document.getElementById("descLink").style.visibility='hidden' ;
}


</SCRIPT>


<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale					=	(String) p.getProperty("LOCALE");
    StringBuffer sblQry		= new StringBuffer();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String deltaValue	= "";
	String legend_type = "";
	//String module_id		=	request.getParameter("module_id")==null?"":request.getParameter("module_id");
%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<STYLE>

	TD.DELTAFAIL{
		background-color:#FFE4E1;
	}

</STYLE>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="button_form" id="button_form">


<%
conlCon = ConnectionManager.getConnection(request);
try
{
	sblQry.append("SELECT high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR, HIGH_SYMBOL_ICON, LOW_SYMBOL_ICON, ABN_SYMBOL_ICON, CRIT_SYMBOL_ICON, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_SYMBOL_ICON, LEGEND_TYPE FROM cr_clin_event_param_lang_vw where language_id=? ");
	pstmt = conlCon.prepareStatement(sblQry.toString());
	pstmt.setString(1,locale);
	rslRst = pstmt.executeQuery();


	if(rslRst.next())
	{
		legend_type = rslRst.getString("LEGEND_TYPE") == null ? "S" : rslRst.getString("LEGEND_TYPE");

		high_value_desc = rslRst.getString("high_str_desc") == null ? "" : rslRst.getString("high_str_desc");
		high_value_color = rslRst.getString("high_color_code") == null ? "" : rslRst.getString("high_color_code");
		if(legend_type.equals("S"))
			high_value_color = rslRst.getString("HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("HIGH_SYMBOL_ICON");

		mapDescColor.put(high_value_desc,high_value_color);
		listDesc.add(high_value_desc);

		low_value_desc = rslRst.getString("low_str_desc") == null ? "" : rslRst.getString("low_str_desc");
		low_value_color = rslRst.getString("low_color_code") == null ? "" : rslRst.getString("low_color_code");
		if(legend_type.equals("S"))
			low_value_color = rslRst.getString("LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("LOW_SYMBOL_ICON");
	   
		if(!(mapDescColor.containsKey(low_value_desc)))
		{
			mapDescColor.put(low_value_desc,low_value_color);
			listDesc.add(low_value_desc);
		}

		abnml_value_desc = rslRst.getString("abn_str_desc") == null ? "" : rslRst.getString("abn_str_desc");
		abnml_value_color = rslRst.getString("abn_color_code") == null ? "" : rslRst.getString("abn_color_code");
		if(legend_type.equals("S"))
			abnml_value_color = rslRst.getString("ABN_SYMBOL_ICON") == null ? "" : rslRst.getString("ABN_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(abnml_value_desc)))
		{
			mapDescColor.put(abnml_value_desc,abnml_value_color);
			listDesc.add(abnml_value_desc);
		}

		crtcl_value_desc = rslRst.getString("crit_str_desc") == null ? "" : rslRst.getString("crit_str_desc");
		crtcl_value_color = rslRst.getString("crit_color_code") == null ? "" : rslRst.getString("crit_color_code");
		if(legend_type.equals("S"))
			crtcl_value_color = rslRst.getString("CRIT_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_value_desc)))
		{
			mapDescColor.put(crtcl_value_desc,crtcl_value_color);
			listDesc.add(crtcl_value_desc);
		}

		crtcl_high_value_desc = rslRst.getString("crit_high_str_desc") == null ? "" : rslRst.getString("crit_high_str_desc");
		crtcl_high_value_color = rslRst.getString("crit_high_color_code") == null ? "" : rslRst.getString("crit_high_color_code");
		if(legend_type.equals("S"))
			crtcl_high_value_color = rslRst.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_HIGH_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
		{
			mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
			listDesc.add(crtcl_high_value_desc);
		}  

		crtcl_low_value_desc = rslRst.getString("crit_low_str_desc") == null ? "" : rslRst.getString("crit_low_str_desc");
		crtcl_low_value_color = rslRst.getString("crit_low_color_code") == null ? "" : rslRst.getString("crit_low_color_code");
		if(legend_type.equals("S"))
			crtcl_low_value_color = rslRst.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rslRst.getString("CRIT_LOW_SYMBOL_ICON");

		if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
		{
			mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
			listDesc.add(crtcl_low_value_desc);
		}

		deltaValue = rslRst.getString("DELTA_FAIL_STR") == null ? "" : rslRst.getString("DELTA_FAIL_STR");

		out.println("<input type=hidden name='mode' id='mode' value='update'>");
	}
	else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}

%>



<table cellpadding=3 cellspacing=0 width='100%' border='0'>
	<tr>
	<%
		//if(module_id.equals("MC"))
		//{
	%>
		<!--<td width='8%'>&nbsp;</td>-->
	<%
		//}
		//else
		//{
	%>
		<!--<td width='13%'>&nbsp;</td>-->
	<%
		//}
	%>
		<td width='17%' height='100%' >
		<table cellpadding=3 cellspacing=0 width='100%' border=0 >
		<tr>
		<%
		String listValues = "";
		String listValuesdisp = "";
		String mapValues = "";

		for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			if(listValues.length()>15)
				listValuesdisp=listValues.substring(0,16);
			else
				listValuesdisp=listValues;
			mapValues = (String) mapDescColor.get(listValues);
			if(legend_type.equals("S"))
			{
	%>
			<td  onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')" width='15%' nowrap>
				<font style='background:url("../../eCA/images/<%=mapValues%>");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=listValuesdisp%></font>
			</td>
	<%
			}
			else{%>
				<td  onMouseOut='clearLayer()' width='15%' nowrap onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
					<font style='background-color:<%=mapValues%>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;
					<font size=1><%=listValuesdisp%></font>
				</td>
				<%}
		}
		if(legend_type.equals("S"))
		{
	%>
			<td  width='15%' nowrap>
				<font style='background:url("../../eCA/images/NI_Normal.gif");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
		}
		else
		{
	%>
			<td  width='15%' nowrap>
				<font style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></font>
			</td>
	<%
		}
		
		%>
		</tr>
		</table>
		</td>
	</tr>
	</table>
	<div id='descLink' style='position:absolute; visibility:hidden;overflow:overflow' ></div>
	</form>
	
	
<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in ChartRecordingColorBar.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon !=null)ConnectionManager.returnConnection(conlCon,request);
}
%>
</body>
</html>

