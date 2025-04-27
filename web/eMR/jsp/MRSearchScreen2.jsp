<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<%@ page import="java.sql.*, java.text.*, webbeans.eCommon.* " %>
		<%
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs		 = null;
			//String fac_id    	= (String) session.getValue( "facility_id" ) ;
			String searchcode=request.getParameter("Search_Code");
			String sql="";
			String auth=request.getParameter("p_auth_yn");


			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
			String p_code_indicator =(request.getParameter("p_code_indicator")==null)?"":request.getParameter("p_code_indicator");
			String step =(request.getParameter("step")==null)?"":request.getParameter("step");
			String defn_levels =(request.getParameter("defn_levels")==null)?"":request.getParameter("defn_levels");	
			String term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");	
			String term_code =(request.getParameter("term_code")==null)?"":request.getParameter("term_code");	
			StringBuffer nb = new StringBuffer();


		
			
		%>
		
		<script>
			var prev=0
			function  change_row_color(obj)
			{
					document.getElementById("t").rows[prev].cells[0].style.backgroundColor=obj.bgColor
					obj.cells[0].style.backgroundColor="#d3d3d3"
					prev	=obj.rowIndex
			}
			//function loadOtherFrames(fromcode,tocode,step)
			function loadOtherFrames(code,term_set_id,defn_levels,step,desc,select_yn,oldstep)
			{
				parent.frames[3].location.href='../../eCommon/html/blank.html'

				//parent.frames[2].location.href='MRSearchScreen3.jsp?step='+step+'p_auth_yn=<%=auth%>&From_Diag='+fromcode+'&To_Diag='+tocode +'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>'; 
				while(desc.indexOf(";")!=-1){
					desc=desc.replace(";" ,' ');
				}
				while(desc.indexOf("|")!=-1){
					desc=desc.replace("|" ,"'");
				}
				while(desc.indexOf("$")!=-1){
					desc=desc.replace('$' ,'"');
				}
				parent.parent.frames[1].document.forms[0].elements[0].value=desc+", "+code;
				parent.parent.frames[1].document.forms[0].elements[2].value=code;
				parent.parent.frames[1].document.forms[0].term_set_id.value=term_set_id;

				if(defn_levels==oldstep)
				{
				}
				else
					{
						parent.frames[2].location.href='MRSearchScreen3.jsp?term_set_id='+term_set_id+'&defn_levels='+defn_levels+'&term_code='+code+'&step='+step+'&p_auth_yn=<%=auth%>&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>'; 
					}
				if(select_yn=='Y')
					parent.parent.frames[1].document.forms[0].elements[1].disabled=false;
				else
					parent.parent.frames[1].document.forms[0].elements[1].disabled=true;				
			}

			function loadOtherFramesICD10(fromcode,tocode)
			{
				parent.frames[3].location.href='../../eCommon/html/blank.html'
				parent.frames[2].location.href='MRSearchScreen3.jsp?term_set_id=<%=term_set_id%>&p_auth_yn=<%=auth%>&From_Diag='+fromcode+'&To_Diag='+tocode +'&Sex=<%=sex%>&Dob=<%=dob%>&p_code_indicator=<%=p_code_indicator%>'; 				
				parent.parent.frames[1].document.forms[0].elements[1].disabled=true
			}
		</script>
	</head>
	
	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=1 cellpadding=2 width='100%' id='t'  border=0 name='t' id='t'>
		<%
			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select  long_desc, from_diag_code, to_diag_code from mr_icd10_subchapter where chapter_code='"+searchcode+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);

*/				
				/*if(term_set_id.equals("ICD10"))
					sql="select  long_desc, from_diag_code, to_diag_code from mr_icd10_subchapter where chapter_code='"+searchcode+"'";
				else*/
					//sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and term_code like '"+term_code+"%' order by  long_desc";
						/*
							The following query was modified for IN023648.
							Modified On:10/5/2010
						*/
//					sql="select  term_code,long_desc , select_yn from mr_term_code where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y' order by  long_desc";
					sql="select  term_code,long_desc , select_yn from mr_d_"+term_set_id+"_lang_vw where term_set_id = '"+term_set_id+"' and code_level='"+step+"' and part_term_code = '"+term_code+"' and diagnosis_yn = 'Y' and language_id='"+locale+"' order by  long_desc";
				
				stmt=con.prepareStatement(sql);
				//stmt.setString(1,searchcode);
				rs=stmt.executeQuery();
				if(rs!=null){
					String s="";
					while(rs.next()){	
						s=rs.getString("long_desc");
						if(s!=null){
							s=s.replace(' ', ';');
							s=s.replaceAll("'", "|");
							s=s.replace('"', '$');
							
						}
								//Handle url special character
								/*String vr_Statement =s;
								char[] newstr = vr_Statement.toCharArray();
								for(int i=0; i<newstr.length;i++){
									if (Character.isLetter(newstr[i])||Character.isDigit(newstr[i])){
										nb.append(newstr[i]);
									}
								}
								String sv = nb.toString();
								nb.setLength(0);*/
						%>
					<tr  onclick='change_row_color(this)'>
					<td>
						<a href='javascript:loadOtherFrames("<%=rs.getString("term_code")%>","<%=term_set_id%>","<%=defn_levels%>","<%=Integer.parseInt(step)+1%>","<%=s%>","<%=rs.getString("select_yn")%>","<%=Integer.parseInt(step)%>")'><font size=1><%=rs.getString("long_desc")%><a><br>
						
					</td>
					</tr>
			<%	}
						//if (s.equals("") && !term_set_id.equals("ICD10"))
						if (s.equals(""))
						{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
							//out.println("<script>parent.parent.frames[1].document.forms[0].elements(1).disabled=false;</script>");
						}
				
				}
			
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
			}
			catch(Exception e){e.printStackTrace();}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);

			}
		%>
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

