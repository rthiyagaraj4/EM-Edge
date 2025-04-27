<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null,	pstmt1	=	null;
	ResultSet			rs		=	null,	rs1		=	null;

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	boolean  flag=true;
	String clinician_type = "", resp_id = "",login_clinician_id = "";
	String clinician_id = "";
	String pract_name="";
	String phys_prov_reln_id = "", phys_prov_reln_name = "",phys_prov_reln="";
	String whereClause = "";
	String patient_id = "", facility_id = "", episode_type = "", episode_id = "", visit_id = "";
	String phys_prov_id = "";
	String modal = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String 	login_user_id		=	(String) session.getValue("login_user");
	out.println("<html><head>");
	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' />");
	out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");
	out.println("<script language='javascript'> var frmref = '';  if('"+modal+"' == 'Y') frmref =parent ; else frmref = top.content.workAreaFrame;");

	try
	{
		//con				=	(Connection) session.getValue("connection");
		con = ConnectionManager.getConnection(request);
		
		facility_id		=	(String)session.getValue("facility_id");
		
		clinician_type	=	request.getParameter("clinician_type");
		clinician_id	=	request.getParameter("clinician_id");
		episode_type	=	request.getParameter("episode_type");
		episode_id		=	request.getParameter("episode_id");
		visit_id		=	request.getParameter("visit_id");
		phys_prov_id	=	request.getParameter("phys_prov_id");
		patient_id		=	request.getParameter("patient_id");

		if(clinician_id==null)		clinician_id	= "";
		if(clinician_type==null)	clinician_type	= "";
		if(episode_type==null)		episode_type	= "";
		if(episode_id==null)		episode_id		= "";
		if(visit_id==null)			visit_id		= "";
		if(phys_prov_id==null)		phys_prov_id	= "";

		login_clinician_id	=	(String)session.getValue("login_user");
		
		
		out.println("var opt=frmref.AssignRelationshipFrame.document.createElement('OPTION'); ");
		String strSele = com.ehis.util.BundleMessage.getBundleMessage(pageContext ,"Common.defaultSelect.label","common_labels");
		out.println("opt.text	=	'-----" +strSele+"----'");
		out.println("opt.value	=	'';");
		out.println("frmref.AssignRelationshipFrame.document.forms[0].relationship.add(opt); ");
		out.println("frmref.AssignRelationshipFrame.document.forms[0].relationship.disabled=false; ");

		//whereClause = request.getParameter("whereClause");
		String bound_count = request.getParameter("boundCount");
		if(bound_count==null) bound_count = "0";
		int boundCount = 0;

		boundCount = Integer.parseInt(bound_count);
		//out.println("<script>alert('boundCount"+boundCount+"')</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		//out.println("<script>alert('whereClause"+whereClause+"')</script>");	
		//out.println("whereClause : "+whereClause);

		//if(rs.next())
		//{
			//resp_id	=	rs.getString("resp_id");
	
			resp_id	=	(String) session.getValue("responsibility_id");

			//out.println("alert('resp_id	:"+resp_id+"');");

			String query_check_duplicate = "select 1 from ca_encntr_pract_reln where patient_id = ? and facility_id = ? and encounter_id = ?  and practitioner_id = ? and nvl(status,'X')!='9' and  sysdate between begin_date_time and nvl(end_date_time, sysdate) ";

//out.println("query_check_duplicate : "+query_check_duplicate);			

			try
			{
				pstmt	=	con.prepareStatement(query_check_duplicate);

				pstmt.setString(1,patient_id);
				pstmt.setString(2,facility_id);
				//pstmt.setString(3,episode_type);
				pstmt.setString(3,episode_id);
				//pstmt.setString(5,visit_id);
				pstmt.setString(4,clinician_id);

				rs	=	pstmt.executeQuery();
			}
			catch(Exception e)
			{
				//out.println("Exception while executing Query!--from AssignRelationshipGetReln.jsp"+e);//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
			}
			if(rs.next())
			{
				out.println("alert(getMessage('ACTIVE_RELN_PRESENT','CA'));");
			}
			else
			{
				//String query_relationship_details = "select pract_reln_id,  pract_reln_name||'/'||decode( LIFETIME_OR_ENCNTR, 'E', 'Encounter', 'L', 'Lifetime') phys_prov_reln_name from ca_pract_reln where direct_yn='Y'  and exists (select pract_reln_id phys_prov_reln_id from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? and a.resp_id =? and pract_reln_id= ca_pract_reln.pract_reln_id and a.resp_id = b.resp_id and CAN_ASSIGN_YN='Y')  and exists (select pract_reln_id  phys_prov_reln_id from ca_pract_reln_for_resp a, sm_resp_for_user b, sm_appl_user c where c.FUNC_ROLE_ID = ? and pract_reln_id= ca_pract_reln.pract_reln_id and c.APPL_USER_ID=b.appl_user_id and a.resp_id = b.resp_id and CAN_HOLD_YN='Y' and rownum=1 )  "+whereClause+" order by phys_prov_reln_name ";

				String query_relationship_details="select pract_reln_id,  pract_reln_name  pract_name, LIFETIME_OR_ENCNTR  phys_prov_reln_name from ca_pract_reln_lang_vw o where EFF_STATUS='E' AND language_id=? and direct_yn='Y' and EFF_STATUS='E' and exists (select pract_reln_id phys_prov_reln_id from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? and a.resp_id =? and pract_reln_id= o.pract_reln_id and a.resp_id = b.resp_id and CAN_ASSIGN_YN='Y')  and exists (select pract_reln_id  phys_prov_reln_id from ca_pract_reln_for_resp a, sm_resp_for_user b, sm_appl_user c where c.FUNC_ROLE_ID = ? and pract_reln_id= o.pract_reln_id and c.APPL_USER_ID=b.appl_user_id and a.resp_id = b.resp_id and CAN_HOLD_YN='Y' and rownum=1 )  "+whereClause+" order by 2 ";
				
				pstmt1	=	con.prepareStatement(query_relationship_details);
				pstmt1.setString(1,locale);
				pstmt1.setString(2,login_user_id);
				pstmt1.setString(3,resp_id);
				pstmt1.setString(4,clinician_id);

				if(boundCount==2)
				{
					pstmt1.setString(4,clinician_id);
					pstmt1.setString(5,login_clinician_id);
				}
				else if(boundCount==4)
				{
					pstmt1.setString(4,clinician_id);
					pstmt1.setString(5,login_clinician_id);
					pstmt1.setString(6,clinician_id);
					pstmt1.setString(7,login_clinician_id);
				}
				
				//out.println(query_relationship_details);
				//out.println("<br>clinician_id		: "+clinician_id);
				//out.println("<br>login_clinician_id	: "+login_clinician_id);


				rs1		=	pstmt1.executeQuery();

				/*if (rs1==null)
				{
					out.println("<script>alert(getMessage('NO_COMMON_RELN','CA'));</script>");
					
				} */
				
				while(rs1.next())
				{   flag=false;
					phys_prov_reln_id		=	rs1.getString("pract_reln_id");
					pract_name=rs1.getString("pract_name");
					phys_prov_reln	=	rs1.getString("phys_prov_reln_name").replace('\'',' ');
					//out.println("alert('"+phys_prov_reln_name+"');");
					if(phys_prov_reln.equals("E"))
						phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
					if(phys_prov_reln.equals("L"))
						phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");

						phys_prov_reln_name=pract_name+"/"+phys_prov_reln_name;
					out.println("var opt=frmref.AssignRelationshipFrame.document.createElement('OPTION'); ");
					out.println("opt.text	=	'"+phys_prov_reln_name+"';");
					out.println("opt.value	=	'"+phys_prov_reln_id+"';");
					out.println("frmref.AssignRelationshipFrame.document.forms[0].relationship.add(opt); ");
					
				}
				out.println("frmref.AssignRelationshipFrame.document.forms[0].resp_id.value = '"+resp_id+"'; ");
			} // end of else
		//} // end of if(rs.next())
		if (flag)
			{
			 out.println("alert(getMessage('NO_COMMON_RELN','CA'));");
			}
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1:"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		out.println("</script></head><body class='MESSAGE' onKeyDown='lockKey()'></body></html>");
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

