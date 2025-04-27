<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	 <script language='javascript' src='../../eOT/js/StoresforOperatingRoom.js'></script> 
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="StoresforOperatingRoomDetailForm" id="StoresforOperatingRoomDetailForm">
<%
   
   String facility_name1 = checkForNull(request.getParameter( "facility_name1" )) ;
   String oper_room_code = checkForNull(request.getParameter( "oper_room_code" )) ;
   String store_room_code = checkForNull(request.getParameter( "store_room_code" )) ;
   if(("ALL").equals(facility_name1))facility_name1="";
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
   String empty = "".intern();
   String select_value="Y";
   String dflt_select_value="N";
   String facility_name=empty;
   String facility_id1=empty;
   String facility_id2=empty;
   String store_code=empty;
   String store_code_ot=empty;
   String store_desc=empty;
   String sel=empty;
   String sel1=empty;
   String dflt_sel=empty;
   String select_checked=empty;
   String dflt_select_checked=empty;
   String classValue= empty;
   String store_type=empty;
   String type_desc_value=empty;
   String type_desc=empty;
   String select_flag1 = empty;
   String select_flag2 = empty;
   String select_flag3 = empty;
   String select_flag4 = empty;
   String disable_flag=empty;
   String strsql=empty;
   String db_type_value=empty;
   //String count=empty;
   String count = request.getParameter("count")==null?"":request.getParameter( "count" );
   String default_yn="";
   HashMap store_info = new HashMap();
   HashMap store_info1 = new HashMap();
   String deflt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
  
  String Theatre_Requesting_Consumption_Store =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreRequestingConsumptionStore.Label","ot_labels");
  String Theatre_Issuing_Store=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreIssuingStore.Label","ot_labels");
  
  int start = ( from.equals("") )?1:Integer.parseInt(from);
  int end =  ( to.equals("") )?14:Integer.parseInt(to);
  StringBuffer sbr = new StringBuffer();
  StringBuffer code = new StringBuffer();
  StringBuffer sbr1 = new StringBuffer();
  StringBuffer sbr2 = new StringBuffer();
  StringBuffer sbr3 = new StringBuffer();
  StringBuffer sbr4 = new StringBuffer();
  StringBuffer sbr5 = new StringBuffer();
  Connection conn = null;
  PreparedStatement pstmt = null;
  PreparedStatement pstmt1 = null;
  ResultSet rst=null;
  ResultSet rst1=null;
  String strcount="SELECT COUNT(DEFAULT_YN) FROM OT_STORES_FOR_THEATRE WHERE DEFAULT_YN='Y' AND OPER_ROOM_CODE=?";
  if(("").equals(facility_name1) && ("").equals(store_room_code))
  {
	strsql="select FACILITY_NAME,FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN from (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D  WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'N' SEL,null STORE_TYPE, null DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?))order by FACILITY_NAME,SHORT_DESC";
  }else if("".equals(store_room_code) && !facility_name1.equals("")){

	strsql="select FACILITY_NAME,FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN from (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE  AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC, 'N' SEL, null STORE_TYPE, null DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?))order by FACILITY_NAME,SHORT_DESC";
  } else if(!store_room_code.equals("")){

	strsql="SELECT FACILITY_NAME, FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN FROM (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL, D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C, OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE  AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE=? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC, 'N' SEL, NULL STORE_TYPE, NULL DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE=? AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?)) ORDER BY FACILITY_NAME,SHORT_DESC";

  }
  int maxRecord = 0;
  int i=1;
  int l=1;
    try{
   		conn  = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);

		if(("").equals(facility_name1) && ("").equals(store_room_code))
        {
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,oper_room_code);
		}
		else if("".equals(store_room_code) && !facility_name1.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_name1);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,oper_room_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_name1);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,oper_room_code);
		} else if(!store_room_code.equals(""))
		{
			if(facility_name1.equals("")){
				facility_name1="ALL";
			}
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,facility_name1);
		pstmt.setString(5,store_room_code);
		pstmt.setString(6,locale);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,facility_name1);
		pstmt.setString(9,store_room_code);
		pstmt.setString(10,oper_room_code);
		}
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		pstmt=conn.prepareStatement(strsql);
		if(("").equals(facility_name1) && ("").equals(store_room_code))
        {
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,oper_room_code);
		}
		else if("".equals(store_room_code) && !facility_name1.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_name1);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,oper_room_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_name1);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,oper_room_code);

		} else if(!store_room_code.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,facility_name1);
		pstmt.setString(5,store_room_code);
		pstmt.setString(6,locale);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,facility_name1);
		pstmt.setString(9,store_room_code);
		pstmt.setString(10,oper_room_code);
		}
		rst = pstmt.executeQuery();
        if(("").equals(count))
		{
		pstmt1=conn.prepareStatement(strcount);
		pstmt1.setString(1,oper_room_code);
		//pstmt1.setString(2,facility_name1);
		rst1 = pstmt1.executeQuery();
		while (rst1.next()){
		count=rst1.getString(1);
		}
		}

%>
<P>
<table align='right'>
<tr>
<%if(maxRecord >14 ){%>
<td>
<%
	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
%>
</td>
<%}%>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3  align='center'>
<td class='COLUMNHEADERCENTER' nowrap > 
	<fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'  nowrap> 
	<fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' nowrap> 
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' nowrap> 
	<fmt:message key="eOT.DefaultStore.Label" bundle="${ot_labels}"/></td>
<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		int k=0;
		while ( rst.next() && i<=end  ){
          
			classValue  = ( i % 2 == 0 )?"gridData":"gridData" ; 

			type_desc_value=empty;
			select_checked=empty;
			select_value="N";
			dflt_select_value="N";
			dflt_select_checked=empty;
			boolean flag_1=false;
			facility_name = checkForNull(rst.getString(1));
			facility_id1= checkForNull(rst.getString(2));
			store_code=checkForNull(rst.getString(3));
			store_desc=checkForNull(rst.getString(4));
			sel=checkForNull(rst.getString(5));
			if(sel.equals("Y")){
			type_desc_value=checkForNull(rst.getString(6));
			}else
			{
				type_desc_value="";
			}
			dflt_select_value=checkForNull(rst.getString(7));
	        disable_flag = ("Y".equals(sel))?"disabled":"";
			if(("R").equals(type_desc_value))
			{
			type_desc_value="R";  
			select_flag1="";
			select_flag2="selected"; 
			select_flag3="";
			}
			else if(("I").equals(type_desc_value))
	        {
			type_desc_value="I" ;
			select_flag1="";
			select_flag2="";
			select_flag3="selected";
			}
			else 
			{
			type_desc_value="";  //default = blank;
			select_flag1="selected"; 
			select_flag2="";
			select_flag3="";
			}
			
			sbr.append("<tr>");
			sbr.append("<td class='"+classValue+"'>"+facility_name+"</td>");
		    sbr.append("<td class='"+classValue+"'>"+store_desc+"</td>");
			//constructing a List Item
			sbr.append("<td class='"+classValue+"'>");
			sbr.append("<select name=type_desc"+i+" id=type_desc"+i+" "+disable_flag+" onChange='valueChanged(this);'>");
			//default select
			sbr.append("<option value='' "+select_flag1+">");
			sbr.append("----------------------");
			sbr.append(deflt);
			sbr.append("----------------------");
			//Theatre_Requesting_Consumption_Store
			sbr.append("</option>");
			sbr.append("<option value='R' "+select_flag2+">");
			sbr.append(Theatre_Requesting_Consumption_Store);
			sbr.append("</option>");
			//Theatre_Issuing_Store
			sbr.append("<option value='I' "+select_flag3+">");
			sbr.append(Theatre_Issuing_Store);
			sbr.append("</option>");
			sbr.append("</td>");	

			
   			if(sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
				   //if(("Y").equals(dflt_select_value)) db_type_value="Y"; else db_type_value="N"; 
				   if(dflt_select_value.equals("Y"))
				   {dflt_select_checked="checked";
				   db_type_value="Y";}else
				   {
					   db_type_value="N"; 
				   }
				   code.append(type_desc_value).append("@@");
				   code.append(select_value).append("@@");
				   code.append(dflt_select_value).append("@@");
				   code.append(facility_id1).append("@@");
				   code.append(store_code).append("@@");
				   code.append("U").append("@@");
				   code.append(db_type_value);
				   sbr.append("<script>pushChkBox('"+i+"','"+code.toString()+"')</script>");
				   code.setLength(0);
				   k++;
			}else{
				select_checked="";
				select_value="N";
			}

			sbr.append("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+" type_desc='"+type_desc_value+"' facility_name='"+facility_id1+"' store_desc='"+store_code+"' select_yn='"+select_value+"' dflt_select_yn='"+dflt_select_value+"' onclick='validateCheckBox(this);'>");
			sbr.append("<td class='" + classValue+"'><input type=checkbox name=dflt_select"+i+" id=dflt_select"+i+" value="+dflt_select_value+" "+dflt_select_checked+" type_desc='"+type_desc_value+"' facility_name='"+facility_id1+"' store_desc='"+store_code+"' select_yn='"+select_value+"' dflt_select_yn='"+dflt_select_value+"' onclick='validateDfltCheckBox(this);'  >");
 
			sbr.append("</td>");
		    sbr.append("</tr>");
			

			if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");
			
			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
			}
		}
			
		
   			i++;
			
		}
  		out.println(checkForNull(sbr.toString()));
  	%>
	
</table>
<% 
   }catch(Exception e){
	e.printStackTrace();
		//out.println("StoresforOperatinRoomDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	 rst.close();
			if(rst1!=null)	 rst1.close();
			if(pstmt!=null)	 pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if(sbr!=null)   sbr.setLength(0);
			//if(code!=null)  code.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>

<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="dflt_sel" id="dflt_sel" value="<%=dflt_select_checked%>" >
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >
<input type="hidden" name="count" id="count" value="<%=count%>" >


<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

