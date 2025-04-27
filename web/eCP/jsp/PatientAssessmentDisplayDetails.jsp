<?xml version='1.0' encoding="UTF-8"?>
<%@page contentType="application/xml" language="java" import="org.w3c.dom.*,java.sql.*, webbeans.eCommon.*"%>
<%
//This file is saved on 18/10/2005.
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<?xml-stylesheet type="text/xsl" href="../html/PatientAssessmentStyle.xsl"?> 
<DOCUMENT FORM-NAME="PatientAssessmentDisplayDetailsForm">
<CSS sStyle="<%=sStyle%>"/>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	Connection con	= null;
	CallableStatement CalStmt =null;
	String accession_num	= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");
	String note_type	= (request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	String facility_id	= (String)session.getAttribute("facility_id")==null?"": (String)session.getAttribute("facility_id");
	if(!accession_num.equals("")){
		StringBuffer contentXML = new StringBuffer();
		//String systemDateTime = ""; 
		//String systemDate = ""; 
		try
		{
			con	= ConnectionManager.getConnection(request);
			CalStmt=con.prepareCall("{call CP_GET_ASSESS_SCORE(?,?,?,?)}");
			CalStmt.setString(1, accession_num);
			CalStmt.setString(2, facility_id);
			CalStmt.setString(3, note_type);
			CalStmt.registerOutParameter(4, Types.CLOB);
			CalStmt.execute();

			Clob clb = CalStmt.getClob(4);

				if(clb!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) {
						contentXML.append(line);
					}
                out.println(contentXML.toString());
				}			
			if(CalStmt!=null) CalStmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	}

%>
</DOCUMENT>	

