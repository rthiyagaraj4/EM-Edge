<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale = checkForNull((String)session.getAttribute("LOCALE")); 

		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		Connection con=null; 
		PreparedStatement pstmt 	= null;
		Statement stmt 	= null;
		ResultSet rs		 	= null;
		StringBuffer sql= new StringBuffer();
		StringBuffer sql_count= new StringBuffer();
		StringBuffer nb = new StringBuffer();
		String auth=(request.getParameter("p_auth_yn")==null)?"":request.getParameter("p_auth_yn");
		String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
		String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		String p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
		String step =(request.getParameter("step")==null)?"":request.getParameter("step");
		String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
		String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");
		String term_set_id="";
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		String exceds_chapdef_limit ="N";
		if(title.equals("ICD10 Code List")){
			term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
		}else{
			term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
		}
		%>
		<script>
		var prev=0
		function  change_row_color(obj){
			document.getElementById['t'].rows(prev).cells[0].style.backgroundColor=obj.bgColor
			obj.cells(0).style.backgroundColor="#d3d3d3"
			prev	=obj.rowIndex
		}
		function loadOtherFrame(code,term_set_id,defn_levels,step,desc,select_yn,oldstep){
			while(desc.indexOf(";")!=-1)
			desc=desc.replace(";" ,' ');
			parent.parent.frames[1].document.forms[0].elements[0].value=desc+", "+code;
			parent.parent.frames[1].document.forms[0].elements[2].value=code;
			parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;
			if(defn_levels==oldstep){
			}else{
				parent.frames[1].location.href='MRSearchScreen2.jsp?term_set_id='+term_set_id+'&defn_levels='+defn_levels+'&term_code='+code+'&step='+step+'&p_auth_yn=<%=auth%>&Search_Code='+code+'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
			}
			parent.frames[2].location.href='../../eCommon/html/blank.html'
			parent.frames[3].location.href='../../eCommon/html/blank.html' 
			if(select_yn=='Y'){
				parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
			}else{
				parent.parent.frames[1].document.forms[0].elements[1].disabled=true;
			}
		}
		function loadOtherFrameICD10(code){
			parent.frames[1].location.href='MRSearchScreen2.jsp?term_set_id=<%=term_set_id%>&p_auth_yn=<%=auth%>&Search_Code='+code+'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>';
			parent.frames[2].location.href='../../eCommon/html/blank.html'
			parent.frames[3].location.href='../../eCommon/html/blank.html' 
			parent.parent.frames[1].document.forms[0].elements(1).disabled=true
		}
		</script>
	</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<table cellspacing = 1 cellpadding = 2 width = '100%' id = 't'  border = 0 name = 't'>
					<%
					try{
						con = ConnectionManager.getConnection(request);
						/*
							The following query was modified for IN023648.
							Modified On:10/5/2010
						*/
//						sql.append("select term_code, long_desc, select_yn from mr_term_code where term_set_id =? and code_level=? and term_code !='*OTH' and diagnosis_yn = 'Y'");
						sql.append("select term_code, long_desc, select_yn from mr_d_"+term_set_id+"_lang_vw where term_set_id =? and code_level=? and term_code !='*OTH' and diagnosis_yn = 'Y' and language_id='"+locale+"'");
						//	sql.append("select term_code, long_desc, select_yn from mr_term_code where term_set_id = '"+p_diag_scheme_desc+"' and code_level='"+step+"'");
						if(!term_code.equals("")){
							sql.append(" and part_term_code =?");
						}
						sql.append(" order by long_desc ");
						//stmt=con.prepareStatement(sql_count.toString());
						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString(1,term_set_id);
						pstmt.setString(2,step);
						if(!term_code.equals("")){
							pstmt.setString(3,term_code);
						}
						rs		 =	pstmt.executeQuery();
						int maxRecords=0;
						if(rs!=null){
							String s="";
							while(rs.next()){	
								s=rs.getString("long_desc");
								if(s!=null){
									s=s.replace(' ', ';');
								}
								//Handle url special character
								String vr_Statement =s;
								char[] newstr = vr_Statement.toCharArray();
								for(int i=0; i<newstr.length;i++){
									if (Character.isLetter(newstr[i])||(Character.isDigit(newstr[i]))){
										nb.append(newstr[i]);
									}
								}
								String sv = nb.toString();
								nb.setLength(0);
								%>
								<tr  onclick='change_row_color(this)'>
									<td>
										<a href="javascript:loadOtherFrame('<%=rs.getString("term_code")%>','<%=term_set_id%>','<%=defn_levels%>','<%=Integer.parseInt(step)+1%>','<%=sv%>','<%=rs.getString("select_yn")%>','<%=Integer.parseInt(step)%>')" ><font size=1><%=rs.getString("long_desc")%><a><br>	
									</td>
								</tr>
								<%
								maxRecords++;
								if(maxRecords>=2000){
									exceds_chapdef_limit ="Y";
									break;
								}
							}
							//if (s.equals("") && !term_set_id.equals("ICD10"))
							if (maxRecords==0){
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
							//out.println("<script>parent.parent.frames[1].document.forms[0].elements(1).disabled=false;</script>");
							}
						}
						if(exceds_chapdef_limit.equals("Y")){
						out.println("<script>alert(getMessage('CHP_DEF_ERR','MR'))</script>");
						out.println("<script>document.getElementById('t').style.display='none'</script>");
						}
						if(rs!=null)	rs.close();
						if(stmt!=null)	stmt.close();
					}catch(Exception e){
						e.printStackTrace();
					}
					finally{
						if(con!=null)ConnectionManager.returnConnection(con, request);
					}
					%>
			</table>
	</body>
</html>
<%!
public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

