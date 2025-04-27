<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>
<%
request.setCharacterEncoding("UTF-8");	
	int arr[] = new int[7];
	int finArr[] = new int[7];
	int fieldLengths[] = new int[7];
	String strArr[] = new String[7];
	String valArr[] = new String[7];
	String fieldNames[] = new String[7];
	Connection con = null;
	PreparedStatement pstmtOrder =  null;
	PreparedStatement pstmtArea = null;
	con = ConnectionManager.getConnection(request);	
	pstmtOrder = con.prepareStatement("select nvl(ADDR_LINE1_PROMPT,'') addr_line1_prompt,addr_line1_order,nvl(ADDR_LINE2_PROMPT,'') addr_line2_prompt,addr_line2_order,nvl(ADDR_LINE3_PROMPT,'') addr_line3_prompt,addr_line3_order,nvl(ADDR_LINE4_PROMPT,'') addr_line4_prompt,addr_line4_order,nvl(RES_AREA_PROMPT,'') res_area_prompt,res_area_order,nvl(RES_TOWN_PROMPT,'') res_town_prompt,res_town_order,nvl(POSTAL_CODE_PROMPT,'') postal_code_prompt,postal_code_order from sm_site_param");
	pstmtArea = con.prepareStatement("Select RES_AREA_CODE,SHORT_DESC from MP_RES_AREA order by SHORT_DESC");
		
	ResultSet rs = pstmtOrder.executeQuery();
	if (rs.next()){
		arr[0] = rs.getInt("addr_line1_order") - 1;
		arr[1] = rs.getInt("addr_line2_order") - 1;
		arr[2] = rs.getInt("addr_line3_order") - 1;
		arr[3] = rs.getInt("addr_line4_order") - 1;
		arr[4] = rs.getInt("res_area_order") - 1;
		arr[5] = rs.getInt("res_town_order") - 1;
		arr[6] = rs.getInt("postal_code_order") - 1;

		strArr[0] = (rs.getString("addr_line1_prompt")==null)?"":rs.getString("addr_line1_prompt");
		strArr[1] = (rs.getString("addr_line2_prompt")==null)?"":rs.getString("addr_line2_prompt");
		strArr[2] = (rs.getString("addr_line3_prompt")==null)?"":rs.getString("addr_line3_prompt");
		strArr[3] = (rs.getString("addr_line4_prompt")==null)?"":rs.getString("addr_line4_prompt");
		strArr[4] = (rs.getString("res_area_prompt")==null)?"":rs.getString("res_area_prompt");
		strArr[5] = (rs.getString("res_town_prompt")==null)?"":rs.getString("res_town_prompt");
		strArr[6] = (rs.getString("postal_code_prompt")==null)?"":rs.getString("postal_code_prompt");	

	}
	ResultSet rsArea = pstmtArea.executeQuery();

	for (int y=0;y<arr.length;y++){
		int j = arr[y];
		finArr[j]=y;
	}

	String addr_line1 = request.getParameter("addr_line1");
	addr_line1 = (addr_line1 == null)?"":addr_line1;
	String addr_line2 = request.getParameter("addr_line2");
	addr_line2 = (addr_line2 == null)?"":addr_line2;
	String addr_line3 = request.getParameter("addr_line3");
	addr_line3 = (addr_line3 == null)?"":addr_line3;
	String addr_line4 = request.getParameter("addr_line4");
	addr_line4 = (addr_line4 == null)?"":addr_line4;
	String res_area = request.getParameter("res_area");
	res_area = (res_area == null)?"":res_area;
	String res_town = request.getParameter("res_town");
	res_town = (res_town == null)?"":res_town;
	String postal_code = request.getParameter("postal_code");
	postal_code = (postal_code == null)?"":postal_code;
	String suffix = request.getParameter("suffix");
	suffix = (suffix == null)?"0":suffix;

	valArr[0] = addr_line1;
	valArr[1] = addr_line2;
	valArr[2] = addr_line3;
	valArr[3] = addr_line4;
	valArr[4] = res_area;
	valArr[5] = res_town;
	valArr[6] = postal_code;

	fieldNames[0] = "addr_line1"+suffix;
	fieldNames[1] = "addr_line2"+suffix;
	fieldNames[2] = "addr_line3"+suffix;
	fieldNames[3] = "addr_line4"+suffix;
	fieldNames[4] = "res_area"+suffix;
	fieldNames[5] = "res_town"+suffix;
	fieldNames[6] = "postal_code"+suffix;

	fieldLengths[0] = 30;
	fieldLengths[1] = 30;
	fieldLengths[2] = 30;
	fieldLengths[3] = 30;
	fieldLengths[4] = -1;
	fieldLengths[5] = -2;
	fieldLengths[6] = 8;
%>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../js/FieldFormatMethods.js' language='javascript'></script>
<script language="JavaScript">
	function populateTown<%=suffix%>(object){

	}
	function searchCode(obj,target)
    {
            var retVal =    new String();
            var dialogHeight= "28" ;
            var dialogWidth = "43" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
            
            //alert(obj.name)
            if(obj.name=="postal_code")
            {
                tit="Postal Code"
                sql="select postal_code, short_desc from mp_postal_code";
                search_code="postal_code";
                search_desc= "short_desc"
            }
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = window.showModalDialog("GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

            if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
    }

</script>
<table width='100%' height='100%' cellpadding='0' cellspacing='0' >
<%
	for (int y=0;y<finArr.length;y++){ 
		int p = finArr[y];
		%>
		<tr>
		<td align=right class='label'><%=strArr[p]%>&nbsp;&nbsp;</td>		
		<td>
			<%
			  if (fieldLengths[p] > 0){
			%>
				<input type="text" name="<%=fieldNames[p]%>" id="<%=fieldNames[p]%>" maxlength="<%=fieldLengths[p]%>" size="<%=fieldLengths[p]%>" value="<%=valArr[p]%>"></input><%=(fieldLengths[p] != 8)?"":"<input type='button' name='postal_code' id='postal_code' value='?' class='button' onclick='searchCode(this,"+fieldNames[p]+")'>"%>
			<%
			}else if (fieldLengths[p] == -1){
			%>
				<select type="select" name="<%=fieldNames[p]%>" id="<%=fieldNames[p]%>" value="<%=valArr[p]%>" onChange="populateTown<%=suffix%>(this)">
					<option value="">--Select--</option>
				<%
					while(rsArea.next()){
					%>
						<option value="<%=rsArea.getString("RES_AREA_CODE")%>"><%=rsArea.getString("SHORT_DESC")%></option>
					<%
					}
				%>
				</select>			  				
			<%
			}else{
			%>
				<select name="<%=fieldNames[p]%>" id="<%=fieldNames[p]%>" value="<%=valArr[p]%>">
					<option value="">--Select--</option>	
				</select>
			<%
			}
			%>
		</td>
		</tr>
	<%}
%>
</table>
<%
	rs.close();
	rsArea.close();
	pstmtArea.close();
	pstmtOrder.close();
	ConnectionManager.returnConnection(con,request);
%> 

