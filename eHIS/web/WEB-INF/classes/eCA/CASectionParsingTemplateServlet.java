/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
18/01/2013		IN037372		Ramesh G		Oracle 11g Weblogic compilation.
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import java.util.*;
import oracle.sql.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class CASectionParsingTemplateServlet extends HttpServlet 
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	private String getMessage(String locale, String messageId, String moduleId)
		{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
        try
        {
			out	=	response.getWriter() ;
            parseSectionTemplate(request,response, out);
		}
		catch(Exception e)
		{
			//out.println("Exception@Servlet:1 of CASectionTemplateServlet.java --- "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
    }
	private void parseSectionTemplate(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, java.io.IOException
	{
		HttpSession	session	= null;
//		java.util.Properties jdbc_props	= null;
//		String selopt = "";
		String strOpt		="";
		String strSelCode	="";
		String fromCode	="";
		String toCode	="";
		String strQuery	    ="";
		String strSecCode	="";
		String strUpdStat	="";
		String strCleanSql	= "";
		String strSelClbSql = "";
		String strSecType = "";
		java.util.Properties p;

		int nClean			= 0;

		boolean bStatus	    = true;
		
		StringBuffer sbError = new StringBuffer();

		PreparedStatement pstmtSel = null;
		PreparedStatement pstmtCln = null;
		PreparedStatement pstmtSelClob = null;
		CallableStatement csXMLParse = null;

		ResultSet rsSel = null;
		ResultSet rsSelClb = null;

		session =	request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale		= (String) p.getProperty("LOCALE");

		strOpt		= (request.getParameter("select_mode")==null)	?""	:	request.getParameter("select_mode");
		strSelCode	= (request.getParameter("select_code")==null)	?""	:	request.getParameter("select_code");
		fromCode	= (request.getParameter("from_section")==null)	?""	:	request.getParameter("from_section");
		toCode	= (request.getParameter("to_section")==null)	?""	:	request.getParameter("to_section");


		
		
//		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		
		
		Connection			con				=	null;

		strCleanSql = "Update CA_SECTION_HDG SET TEMPLATE_FORMAT = empty_clob(),modified_date=sysdate where SEC_HDG_CODE = ?";
		strSelClbSql = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update "; 

		StringBuffer XMLString = new StringBuffer();
		sbError.append("Exception Encounterd while parsing Section(s) :  ");
	
		try
        {	
			con							=	ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			

			pstmtCln		= con.prepareStatement(strCleanSql);
			pstmtSelClob	= con.prepareStatement(strSelClbSql);
			csXMLParse = con.prepareCall("{call ca_parse_SectionXMLTemplate(?,?)}");
			

			if (strOpt.equals("A") )
			{
				strQuery = "select a.sec_hdg_code, a.SEC_HDG_DESC,NVL(a.TEMPLATE_TYPE,'B') TEMPLATE_TYPE from ca_section_hdg A where A.content_type ='T' and A.template_format is not null  ";
				if (!fromCode.equals(""))
				{
					strQuery = strQuery+" and a.SEC_HDG_DESC >=(select sec_hdg_desc from ca_section_hdg where sec_hdg_code=? ) ";
				}
				if (!toCode.equals(""))
				{
					strQuery = strQuery+" and a.SEC_HDG_DESC <=(select sec_hdg_desc from ca_section_hdg where sec_hdg_code=? ) ";
				}
               strQuery = strQuery + " order by 2";
			}
			else if(strOpt.equals("S"))
				strQuery = "select a.sec_hdg_code, a.SEC_HDG_DESC,nvl(a.TEMPLATE_TYPE,'B') TEMPLATE_TYPE from ca_section_hdg A where A.content_type ='T' AND A.SEC_HDG_CODE = ? and A.template_format is not null order by 2";
			else if(strOpt.equals("N"))
				strQuery = "SELECT A.SEC_HDG_CODE, a.SEC_HDG_DESC,NVL(a.TEMPLATE_TYPE,'B') TEMPLATE_TYPE  FROM CA_SECTION_HDG A WHERE A.SEC_HDG_CODE IN (SELECT nvl(ib.CHILD_SEC_HDG_CODE,ia.SEC_HDG_CODE) FROM CA_NOTE_SECTION IA, CA_SUBSECTION_LINK ib WHERE ia.NOTE_TYPE =?  and ia.sec_hdg_code = ib.HEADER_SEC_HDG_CODE(+) ) AND A.CONTENT_TYPE ='T' and A.template_format is not null order by 2 ";
			else if(strOpt.equals("P"))
				strQuery = "select a.sec_hdg_code, a.SEC_HDG_DESC,NVL(a.TEMPLATE_TYPE,'B') TEMPLATE_TYPE from ca_section_hdg A where A.content_type ='T' AND A.module_id = ?  order by 2";
			
			pstmtSel		= con.prepareStatement(strQuery);
            
			int st=0;
			if(strOpt.equals("N") || strOpt.equals("S")|| strOpt.equals("P") )
				pstmtSel.setString(1,strSelCode);
			else if(strOpt.equals("A"))
			{
				if(!fromCode.equals(""))
				{
					pstmtSel.setString(++st,fromCode);
				}
				if (!toCode.equals(""))
				{
					pstmtSel.setString(++st,toCode);
				}
			}

			rsSel = pstmtSel.executeQuery();
			
			String strSecDesc = "";
			Clob clb = null;

			while (rsSel.next())
			{
				strSecCode =  rsSel.getString(1);
				strSecDesc =  rsSel.getString(2);
				strSecType =  rsSel.getString(3);


				pstmtCln.setString(1,strSecCode);
				nClean = pstmtCln.executeUpdate();

				if (nClean > 0)
				{
					con.commit();
					pstmtCln.clearParameters();
					pstmtSelClob.setString(1,strSecCode);

					rsSelClb = pstmtSelClob.executeQuery();

					if(rsSelClb.next())
						clb = rsSelClb.getClob(1);
				
					if(rsSelClb != null) rsSelClb.close();
					//Web logic Conversion -- [IN037372] Start.
					//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
					BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
					//Web logic Conversion -- [IN037372] End.
					SectionTemplateXMLDefinitionBean objBean = new SectionTemplateXMLDefinitionBean();

					if (strSecType.equals("B") || strSecType.equals(""))
					{
						XMLString=objBean.constructXML(con,strSecCode);
					}else{
						XMLString=objBean.constructTemplateTypeXML(con,strSecCode);
					}
					
					objBean = null;
					
					String removeSplChar=XMLString.toString();
					w.write(removeSplChar,0,removeSplChar.length());
					w.flush();
					w.close();
					pstmtSelClob.clearParameters();
					
					csXMLParse.setString(1,strSecCode);
					csXMLParse.registerOutParameter(2, Types.VARCHAR);
					try
					{
						csXMLParse.execute();
					}
					catch (Exception eSpl)
					{

						sbError.append(strSecCode + "-"+ strSecDesc + ",\n");
					}
					
					strUpdStat	= csXMLParse.getString(2);



					csXMLParse.clearParameters();
					if(strUpdStat == null || strUpdStat.equals("N"))
					{
						out.println("Error For  " + strSecCode + " - " + strSecDesc + " - " + strUpdStat+"\n");
						sbError.append(strSecCode + "-" + strSecDesc + ",\n");
						
						if(bStatus)
							bStatus = false;
					}
					else
						con.commit();
				}

				XMLString.setLength(0);
				strUpdStat = "";
			} 
			
			if (rsSel != null) rsSel.close();
			if (pstmtSel != null) pstmtSel.close();
			if (pstmtCln != null) pstmtCln.close();
			if (pstmtSelClob != null) pstmtSelClob.close();
			if (csXMLParse != null) csXMLParse.close();


			String strErrorMsg = "";
		    String error_value = "";
			
			if(bStatus)
			{
				strErrorMsg = getMessage(locale, "RECORD_INSERTED","CA"); 
				error_value = "1";
			}
			else
			{
				strErrorMsg  =  sbError.toString();
				error_value = "0";
			}

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( strErrorMsg ,"UTF-8") +"&err_value="+error_value);

			}
			catch(Exception e)
			{
				
				
				e.printStackTrace();
			}
		finally
		{
			try
			{
				if(con!=null)	ConnectionManager.returnConnection(con,request);
			}
			catch (Exception eee)
			{}
			//out.println("</body></html>");
		} // end of finally
    } 

} 
