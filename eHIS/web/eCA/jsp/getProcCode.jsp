<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       		Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
19/06/2013    	IN035719		Ramesh G	System displays script error while recording the procedure.This issue is happening only for certain Terminology code.

---------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
Connection con=null;
PreparedStatement stmt = null;
ResultSet rs = null ;
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
	try{
		String p_code   =   request.getParameter("p_code");
		if(p_code ==null)   p_code = "" ;
			p_code          =   p_code.trim();
		String p_scheme =   request.getParameter("p_scheme");
		if(p_scheme == null)p_scheme="";
			p_scheme = p_scheme.trim();
		String validate_dttime =   request.getParameter("validate_dttime");
			validate_dttime = (validate_dttime == null?"N":"Y") ;
		String term_set_id   =   request.getParameter("term_set_id");
		if(term_set_id ==null)   term_set_id = "" ;
			term_set_id          =   term_set_id.trim();
		String term_code   =   request.getParameter("term_code");
		if(term_code ==null)   term_code = "" ;
			term_code          =   term_code.trim();
		if(validate_dttime.equals("Y")){
			String to_dttime = request.getParameter("to_dttime") ;
			GregorianCalendar  cal = new GregorianCalendar ();
			cal.set(Calendar.SECOND,0 ) ; 
			cal.set(Calendar.MILLISECOND,0 ) ; 

			java.util.StringTokenizer toks = new java.util.StringTokenizer(to_dttime," ") ;
			String dt = toks.nextToken() ;
			String tme = toks.nextToken() ;
			
			String[] dtarr = new String[3] ;
			toks = new java.util.StringTokenizer(dt,"/") ;
			dtarr[0] = toks.nextToken() ;
			dtarr[1] = toks.nextToken() ;
			dtarr[2] = toks.nextToken() ;

			
			String tmearr[] = new String[2] ;
			toks = new java.util.StringTokenizer(tme,":") ;
			tmearr[0] = toks.nextToken() ;
			tmearr[1] = toks.nextToken() ;
			
			GregorianCalendar  newcal= new GregorianCalendar () ;
			newcal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dtarr[0]) ) ; 
			newcal.set(Calendar.MONTH,(Integer.parseInt(dtarr[1])-1) ) ; 
			newcal.set(Calendar.YEAR,Integer.parseInt(dtarr[2]) ) ; 
			newcal.set(Calendar.HOUR,Integer.parseInt(tmearr[0]) ) ; 
			newcal.set(Calendar.MINUTE,Integer.parseInt(tmearr[1]) ) ;  
			newcal.set(Calendar.SECOND,0 ) ; 
			newcal.set(Calendar.MILLISECOND,0 ) ; 
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>") ;
			out.println("<body class='message' onKeyDown='lockKey()'>"); //INVALID_PROC_DATE_TIME
			/*out.println(cal) ;
			out.println(newcal) ; */

			if(cal.before(newcal)){
				String s = "<script>"+
				   "alert(top.content.workAreaFrame.frame2.getMessage('INVALID_PROC_DATE_TIME'))\n" +
					"top.content.workAreaFrame.frame2.document.forms[0].date.select()\n"+
					"top.content.workAreaFrame.frame2.document.forms[0].date.focus()\n"+
					"</script>" ;
					
					out.println(s) ;
			}
			out.println("</body></html>") ;
		}else{
			if (!(p_code == null || p_code.equals("null")||p_code.length()==0)){		
				con=ConnectionManager.getConnection(request);
				boolean chkk=false;
				String p_desc ="";
				String p_cause_indicator="";
				String p_record_type="";
				String sql="";
				//out.println("<script language=javascript>alert('  p_scheme = "+p_scheme+"')</script>");
				if (p_scheme.equals("3"))
				{
					sql="Select cpt_code,short_desc from mr_cpt_code where cpt_code = ?";
						
					stmt = con.prepareStatement(sql);
					stmt.setString(1,p_code);
					rs = stmt.executeQuery();
					if (rs.next())
					{
						chkk=true;
						p_desc  = rs.getString("short_desc");
						%>
						<script>
							top.content.workAreaFrame.frame2.document.forms[0].description1.value="<%=p_desc%>";
						</script>
						<%
						//out.println(a1);
						if(rs != null)rs.close();
						if(stmt != null)stmt.close();
					}else{
						out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'>"+
										   "<script>"+
							"top.content.workAreaFrame.frame2.document.forms[0].code.focus();"+
							"top.content.workAreaFrame.frame2.document.forms[0].code.select();"+
							"document.write('OP0017 - Invalid procedure code')"+
							"</script></body><html>");
					}

				}//Here
				else if (p_scheme.equals("4") || p_scheme.equals("6")){
					sql="Select diag_code,short_desc,record_type,cause_indicator from mr_icd_code where record_type='O' and diag_code = ?";

					stmt = con.prepareStatement(sql);
					stmt.setString(1,p_code);
					rs = stmt.executeQuery();
					if(rs!=null){
						if(rs.next())
						{
							chkk=true;
							p_desc  = rs.getString("short_desc");
							p_record_type=rs.getString("record_type");
							p_cause_indicator=rs.getString("cause_indicator");
							%>

									<script>
									top.content.workAreaFrame.frame2.document.forms[0].description.value="<%=p_desc%>";
									top.content.workAreaFrame.frame2.document.forms[0].record_type.value="<%=p_record_type%>";
									top.content.workAreaFrame.frame2.document.forms[0].cause_indicator.value="<%=p_cause_indicator%>";
									top.content.workAreaFrame.frame2.document.forms[0].description1.value="<%=p_desc%>";
									</script>
							<%
									//out.println(a1);
									if(rs != null)rs.close();
									if(stmt != null)stmt.close();
						}
					}

					if(!chkk)
					{
							out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'>"+
							"<script>"+
								"top.content.workAreaFrame.frame2.document.forms[0].description.value='' ;"+
								"top.content.workAreaFrame.frame2.document.forms[0].code.focus();"+
								"top.content.workAreaFrame.frame2.document.forms[0].code.select();"+
								"document.write('OP0017 - Invalid procedure code')"+
								"</script></body><html>");
					}
				}//else ends
			}else if (!(term_set_id.equals("") && term_code.equals(""))){		
				con=ConnectionManager.getConnection(request);
			
				boolean rs_chkk=false;
				String long_desc ="";
				String short_desc="";
			
				String term_code_sql="";

				if (!term_code.equals(""))
				{
					term_code_sql="select term_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";
					stmt = con.prepareStatement(term_code_sql);
					stmt.setString(1,term_set_id);//term_set_id
					stmt.setString(2,term_code);//term_code
					rs = stmt.executeQuery();
					if(rs.next())
					{
						rs_chkk=true;
						//IN035719 starts 
						//short_desc  = rs.getString("short_desc").trim();					
						//long_desc	= rs.getString("long_desc").trim();					
						StringBuffer long_desc_ = new StringBuffer();
						StringBuffer short_desc_ = new StringBuffer();
						String short_desc_arr[] = ((String)rs.getString("short_desc")).split("\n");
						for(int i = 0; i < short_desc_arr.length; i++){
							short_desc_.append((String)(((short_desc_arr[i]).trim()).replaceAll("\n"," ")));
						}							
						String long_desc_arr[] = ((String)rs.getString("long_desc")).split("\n");
						for(int i = 0; i < long_desc_arr.length; i++){
							long_desc_.append((String)(((long_desc_arr[i]).trim()).replaceAll("\n"," ")));								
						}
						short_desc	= short_desc_.toString();
						long_desc	= long_desc_.toString();
						//IN035719 ends
						
						%>
						<script> 
							top.content.workAreaFrame.frame2.document.forms[0].description.value='<%=long_desc%>';
							top.content.workAreaFrame.frame2.document.forms[0].description1.value='<%=short_desc%>';
							</script>
						<%
						//out.println(a1);
					}
					StringBuffer a2 = new StringBuffer();
					a2.append("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script>");
				
					if(long_desc !=null && !long_desc.equals(""))
					{
						a2.append("top.content.workAreaFrame.frame2.document.forms[0].exclamation.style.visibility='visible'"	);
						
					}else{
					a2.append("top.content.workAreaFrame.frame2.document.forms[0].exclamation.style.visibility='hidden'");		
					}
					a2.append("</script></head><body onKeyDown = 'lockKey()' CLASS='MESSAGE'></body></html>");
					out.println(a2.toString());
					
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					if(!rs_chkk)
					{
						%>
							<script>
								top.content.workAreaFrame.frame2.document.forms[0].description.value=""; top.content.workAreaFrame.frame2.document.forms[0].description1.value=""; top.content.workAreaFrame.frame2.document.forms[0].code.focus();
								top.content.workAreaFrame.frame2.document.forms[0].code.select();
								document.write('OP0017 - Invalid procedure code');
							</script>
							<%
					}
				}
			}else{
			 %> <script>
				 top.content.workAreaFrame.frame2.document.forms[0].description1.value="";
				</script>
			<%

			}
        }
        
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
	}catch(Exception e){
            //out.println(e);//common-icn-0181
	    e.printStackTrace();//COMMON-ICN-0181
            out.println("<html><head><link  rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'></body>");
    }finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
 
%>

