<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>


<%! 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
	}
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script language="JavaScript" src="../../eOT/js/ICDPCS.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

<!--Correction  On process - incident SRR20056-SCF-5188 (Incident No:23742)  21/09/2010-->

<style>
OPTION.AUTO {
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			BACKGROUND-COLOR: #00ff66;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
}
OPTION.MANDATORY{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			BACKGROUND-COLOR: #cc0033;
			COLOR:WHITE;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
 OPTION.OPTIONAL{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: X-LARGE ;
			COLOR:BROWN;
			BACKGROUND-COLOR: Gold;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
</STYLE>
<script language='javascript'>
function callPopulateList(flag){} //Added on march 1,2011 by Anitha for satya sai issue

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadOperListItem();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'ICDPCSRecordForm' >


<input type="hidden"  name="params" id="params"  value="<%=request.getQueryString()%>" > 
<%
	String called_from =  CommonBean.checkForNull(request.getParameter("called_from"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));

	String val="",oper_code_val="";
	String disable_flag="Y".equals(surgeon_doc_comp_yn)?"disabled":"";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String SQL = "SELECT A.OPER_LINE_NUM, A.OPER_CODE, B.SHORT_DESC OPER_DESC, A.PROC_CODING_SCHEME, A.PROC_CODE, C.SHORT_DESC PROC_DESC, DECODE(D.PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL','AUTO') COLOR FROM OT_POST_OPER_PROC_DTLS A, OT_OPER_MAST B, MR_TERM_CODE C, OR_ORDER_CATALOG_LANG_VW D WHERE D.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID     = ? AND     A.OPER_NUM = ? AND  A.OPER_CODE	= B.OPER_CODE AND A.PROC_CODING_SCHEME  = C.TERM_SET_ID AND A.PROC_CODE = C.TERM_CODE AND  D.ORDER_CATEGORY = 'OT' AND  B.ORDER_CATALOG_CODE	=  D.ORDER_CATALOG_CODE";

	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
			if(rst !=null)
		{
		while(rst.next()){

			oper_code_val=rst.getString(2);
			val = rst.getString(1)+"::"+rst.getString(2)+"::"+rst.getString(3)+"::"+rst.getString(4)+"::"+rst.getString(5)+"::"+rst.getString(6)+"::"+rst.getString(7);
   
			out.println("<script>loadDBRows('"+val+"');</script>");
        }
		}
			out.println("<script>refresh();</script>");
			out.println("<script>assignLength();</script>");

	}catch(Exception e){
		 System.err.println("Err Msg in ICDPCSRecord.jsp"+e);
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
%>


<table  border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	  <td class='label' align='right' nowrap >
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
	  </td>
	  <td align='left'>
		   <select name='operation' id='operation' onchange="resetCode(this);"></select>
	  </td>
	  <td class='label' align='right' nowrap>
		<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	  </td>
	  <td align='left'>
		  <input type='hidden' name='proc_code' id='proc_code' >
		  <input type='text' name='proc_desc' id='proc_desc' size='25' onblur="if(this.value!='')searchProcCode(proc_code,proc_desc);" ><input type='button' class='button' value='?' name='TermIDLookUp' id='TermIDLookUp' 
		  onClick="searchProcCode(proc_code,proc_desc)"><img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
 <tr> 
	  <td class='label' align='right' nowrap>
		<fmt:message key="eOT.CodingScheme.Label" bundle="${ot_labels}"/>
	  </td>
	  <td align='left'>
		 <input type='text' name='coding_scheme' id='coding_scheme' size='20' readonly> 
	 </td>
<td></td>
	<td class='label' align='right' nowrap colspan="2">
		<input type='button' name='record' id='record' class='button' value='Select' onClick="addRow();" <%=disable_flag%> >
		<input type='button' name='cancel' id='cancel' class='button' value='Cancel' onClick="deleteRow();" <%=disable_flag%> >
	</td>
</tr>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='recId' id='recId' value="">
<input type='hidden' name="old_proc_code" id="old_proc_code" value="">
<input type='hidden' name="oper_num" id="oper_num" value='<%=oper_num%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

