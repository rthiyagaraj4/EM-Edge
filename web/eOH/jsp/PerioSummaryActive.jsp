<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE");
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection connection=null;
	CallableStatement cstmt=null;
	PreparedStatement pstmt=null;
	ResultSet rst = null;
	String facility_id = (String)session.getValue("facility_id") ;
	String login_user      = (String) session.getAttribute("login_user");

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );

	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String chart_code =checkForNull(request.getParameter( "chart_code" )) ;
	String chart_num =checkForNull(request.getParameter( "chart_num" )) ;
	String chart_line_num =checkForNull(request.getParameter( "chart_line_num" )) ;
	String component_code =checkForNull(request.getParameter( "component_code" )) ;
	String index_code =checkForNull(request.getParameter( "index_code" )) ;
	String p_index_value="";
	String component_value="";
	String status="";
	String err_msg="";
	String lang_err_msg_id="";
	String index_desc = "" ;
	String[]  index_code_value_arr = null;
	String[]  component_value_arr = null;
	String[]  index_code_arr = null;
	String[] component_arr = null;
	String index_cut_off_value = "" ;
	String cut_off = "" ;
	String component_desc = "" ;
	String ns_tooth_no = "" ;
	String value = "" ;
	String index_display_text = "" ;
	StringBuffer component_display_text = new StringBuffer() ;
	String temp_str = "";
	String sql_string="";
	String tooth_no="";
	String teethwith_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TeethWith.Label","oh_labels");

	%>
<title>
<fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/>
</title>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form >
<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'>
<%
	try{
		connection=ConnectionManager.getConnection(request);

       /*OH_CALCULATE_SUMMARY(P_FACILITY_ID, P_PATIENT_ID, P_ENCOUNTER_ID, P_PATIENT_CLASS, P_CHART_NUM, P_CHART_CODE, P_CHART_LINE_NUM, P_CLOSING_CHART_YN, P_USER_ID, P_WS_NO, P_INDEX_VALUE, P_COMPONENT_VALUE, P_STATUS, P_ERR_MSG, P_LANG_ERR_MSG_ID)*/

		cstmt=connection.prepareCall("{call OH_CALCULATE_SUMMARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id);  //P_FACILITY_ID
		cstmt.setString(2,patient_id); //P_PATIENT_ID
		cstmt.setString(3,encounter_id); //P_ENCOUNTER_ID
		cstmt.setString(4,patient_class);  //P_PATIENT_CLASS
		cstmt.setString(5,chart_num);  //P_CHART_NUM
		cstmt.setString(6,chart_code);  //P_CHART_CODE
		cstmt.setString(7,chart_line_num); //P_CHART_LINE_NUM
		cstmt.setString(8,"N");                   //P_CLOSING_CHART_YN
		cstmt.setString(9,login_user);       //P_USER_ID
		cstmt.setString(10,client_ip_address); //P_WS_NO

		//cstmt.registerOutParameter(11,Types.VARCHAR);	//P_INDEX_VALUE
		cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);	//P_INDEX_VALUE
		cstmt.registerOutParameter(12,Types.VARCHAR);	//P_COMPONENT_VALUE
		cstmt.registerOutParameter(13,Types.VARCHAR);	//P_STATUS
		cstmt.registerOutParameter(14,Types.VARCHAR);	//P_ERR_MSG
		cstmt.registerOutParameter(15,Types.VARCHAR);	//P_LANG_ERR_MSG_ID
		cstmt.execute();
		p_index_value 		= checkForNull(cstmt.getString(11),"");
		component_value 	= checkForNull(cstmt.getString(12),"");
		status		        = checkForNull(cstmt.getString(13),"");
		err_msg		        = checkForNull(cstmt.getString(14),"");
		lang_err_msg_id		= checkForNull(cstmt.getString(15),"");
		HashMap map = new HashMap();
		ArrayList index_code_list = new ArrayList();	
		//p_index_value="BLDIND~12!PLQIND~7!DEBIND~1";
		/*
			P_INDEX_VALUE will have the index values like below
			<INDEX_CODE>$<INDEX_VALUE>!
			Ex:  BLDIND$12!PLQIND$7!DEBIND$1
		*/
		///// For Indexes
		if(p_index_value!=null && !p_index_value.equals("")){
				//Split the Index_values for Index_codes
				index_code_value_arr = p_index_value.split("!");
				for(int i=0;i<index_code_value_arr.length;i++){
					temp_str = index_code_value_arr[i];
					index_code_arr = temp_str.split("~");
					map.put(index_code_arr[0] ,index_code_arr[1]);
					index_code_list.add(index_code_arr[0]);
				}
				StringBuffer index_append_qry= new StringBuffer();
				index_append_qry.append("SELECT INDEX_CODE, INDEX_DESC, INDEX_CUT_OFF_VALUE FROM OH_INDEXES WHERE INDEX_CODE IN (");
				for(int j=0;j<index_code_list.size();j++){
					if(j==0)
						index_append_qry.append("?");
					else
						index_append_qry.append(",?");
				}
				index_append_qry.append(")");
				pstmt=connection.prepareStatement(index_append_qry.toString());
				for(int j=0;j<index_code_list.size();j++){
					pstmt.setString(j+1,(String)index_code_list.get(j));
				}
				rst=pstmt.executeQuery();
				while(rst!= null && rst.next()){
					index_code = rst.getString("INDEX_CODE");
					value = (String)map.get(index_code);
					index_desc = rst.getString("INDEX_DESC");
					index_cut_off_value = rst.getString("INDEX_CUT_OFF_VALUE");
					//index_display_text = index_desc+" "+value; //commented on 210108 by parul ("%" was not coming for BLDIND and PLQIND )
					//added 210108 by parul for  SCR#6149 
				    if(index_cut_off_value!=null && !index_cut_off_value.equals("null") && !index_cut_off_value.equals("")){
				      if(index_code.equals("BLDIND") || index_code.equals("PLQIND") ||  index_code.equals("CALIND")|| index_code.equals("OHIIND") || index_code.equals("DEBIND")){
					//	if(index_code.equals("BLDIND") || index_code.equals("PLQIND")){
					         index_display_text = index_desc+" ("+index_cut_off_value+"%)";
						}else{
							index_display_text = index_desc+"("+index_cut_off_value+")";
					    }
				   }else{

				           index_display_text = index_desc;
			       }
				   //end 
				%>
						<tr>
							<td class="label" width='30%'></td>
							<td class="label" width='70%' style='text-align:left'>
								<!-- <%=index_display_text%> -->
								<%=index_display_text%> <%=value%><!--  added 210108 by parul for  SCR#6149  -->

							</td>
						</tr>
				<%
			     }
			  %>
						<tr></tr>
						<tr></tr>
						<tr></tr>
			<%
		}
// End of Code for Indexes

		sql_string="SELECT TOOTH_NO,NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM=? ORDER BY TOOTH_NO";
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		pstmt=connection.prepareStatement(sql_string);
		pstmt.setString(1,tooth_numbering_system);
		rst=pstmt.executeQuery();
		HashMap tooth_map=new HashMap();
		while(rst.next()){
			tooth_no	= rst.getString("TOOTH_NO");
			ns_tooth_no	= rst.getString("NS_TOOTH_NO");
			tooth_map.put(tooth_no,ns_tooth_no);
		}
///// For Components
		//Split the Index_values for Index_codes
		/*<COMPONENT_CODE$TOOTH_NUM#TOOTH_NUM!
		   Ex: MOBL$11#12!MITH$3#17!*/
        ArrayList component_code_list = new ArrayList();
		//component_value=" MOBL~11#12!MITH~3#17!";
	//	map.clear();
		if(component_value!=null && !component_value.equals("")){
			component_value_arr = component_value.split("!");
			for(int i=0;i<component_value_arr.length;i++){
				temp_str = component_value_arr[i];
				component_arr = temp_str.split("~");
				map.put(component_arr[0] ,component_arr[1]);
				component_code_list.add(component_arr[0]);
			}
			StringBuffer component_append_qry= new StringBuffer();
			component_append_qry.append("SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, CUT_OFF FROM OH_PERDONTAL_CHRT_COMP_LANG_VW WHERE LANGUAGE_ID = ? AND COMPONENT_CODE IN (");
			for(int j=0;j<component_code_list.size();j++){
				if(j==0)
					component_append_qry.append("?");
				else
					component_append_qry.append(",?");
			}
			component_append_qry.append(") ORDER BY COMPONENT_CODE");
			pstmt=connection.prepareStatement(component_append_qry.toString());
			pstmt.setString(1,locale);
			for(int j=0;j<component_code_list.size();j++){
				pstmt.setString(j+2,(String)component_code_list.get(j));
			}
			rst=pstmt.executeQuery();
			String[] tooth_value_arr = null;
		//	String cutt_off = "";

			while(rst!= null && rst.next()){
				component_display_text.setLength(0);
				component_code = rst.getString("COMPONENT_CODE");
				component_desc = rst.getString("COMPONENT_SHORT_DESC_USER_DEF");
				//value = (String)map.get(component_desc);
				cut_off = rst.getString("CUT_OFF");
				value = (String)map.get(component_code);
				//index_cut_off_value = rst.getString("INDEX_CUT_OFF_VALUE");

				if(!component_code.equals("MITH") && !component_code.equals("FOI") && !component_code.equals("LOC") && !component_code.equals("BOP") && !component_code.equals("PLA") && !component_code.equals("SUP")){
					if(cut_off!=null && !cut_off.equals("null") && !cut_off.equals("")){
						component_display_text.append(teethwith_legend);
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" >= (");
						component_display_text.append(cut_off);
						component_display_text.append(")mm :   ");
					}else{
						component_display_text.append(teethwith_legend);
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" :   ");
					}
				}else{ //Legend for Missing tooth   //else part added by parul on 221008 for scr#6149 
				     if(cut_off!=null && !cut_off.equals("null") && !cut_off.equals("")){
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" : ");
					}else{
						component_display_text.append(component_desc);
						component_display_text.append(" : ");
					}
				}
				tooth_value_arr = value.split("#");
				int z=0;
				for(int k=0;k<tooth_value_arr.length;k++){
					if(z==0){
						component_display_text.append((String)tooth_map.get(tooth_value_arr[k]));
					}else{
						component_display_text.append(",");
						component_display_text.append((String)tooth_map.get(tooth_value_arr[k]));
					}
					z++;

				}
		   %>
					<tr>
						<td class="label" width='10%'></td>
						<td class="label" width='90%' style='text-align:left'>
							<%=component_display_text.toString()%>
						</td>
					</tr>
			<%
			}
		}
// End of Code for Components
 %>

</table>
</form>
</body>
</html>
<%
	}catch ( Exception e ) {
	        e.printStackTrace() ;
	}finally {
		try{
            if(cstmt!=null) cstmt.close();
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null)
				ConnectionManager.returnConnection(connection,request);
        }catch(Exception es){es.printStackTrace();}
    }
%>


