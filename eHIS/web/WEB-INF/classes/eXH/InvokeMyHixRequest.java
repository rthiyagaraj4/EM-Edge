/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eXH;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Map;

import java.sql.Clob;
import java.io.*;
import java.sql.*;

import webbeans.eCommon.ConnectionManager;

import java.util.*;

import eXH.TransformXMLData;

public class InvokeMyHixRequest implements java.io.Serializable{
	
	boolean isDebugYN = false;  

	/*
	 * Gets the list of Summary Groups 
	 */	
	public StringBuffer processRequest(String paramString) throws Exception 
	{
			StringBuffer responseData = new StringBuffer();
			StringBuffer responseHtml = new StringBuffer();
			String responseTxt="";
			String errorCode="";
			String errorMsg="";
			CallableStatement ostmt = null;
			Connection dbConn = null;

			java.sql.Clob clob;
			
			try
			{
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

					System.out.println("(InvokeMyHixRequest:processRequest) isDebugYN--> "+isDebugYN);
					
					if (isDebugYN)	
						System.out.println("(InvokeMyHixRequest:processRequest) paramString-->"+paramString);					

					dbConn = ConnectionManager.getConnection();					

					ostmt = dbConn.prepareCall("{ CALL XHINTERACTIVE.MYHIXMESSAGEHANDLER(?,?,?,?) }" );
					ostmt.setString(1, paramString);
					ostmt.registerOutParameter(2,java.sql.Types.CLOB);
					ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					ostmt.execute();
					clob = ostmt.getClob(2);
					responseData = new StringBuffer(clobToString(clob));
					errorCode = ostmt.getString(3);
					errorMsg = ostmt.getString(4);					
					
					if (isDebugYN)	
						System.out.println("(InvokeMyHixRequest:processRequest) first set p_response--> "+responseData);

					if (isDebugYN)	
						System.out.println("(InvokeMyHixRequest:processRequest) ErrorCode-->"+errorCode+" ::: ErrorMsg ::: "+errorMsg);

					//errorCode = "S";

					if((errorMsg != null) && (errorMsg.trim().length()>0)) 
					{
						responseTxt=errorMsg;	
					}
					else
					{
						if(errorCode=="S" || "S".equalsIgnoreCase(errorCode))
						{
							 //responseTxt=responseData;
							 //responseData = new StringBuffer(responseData);
							 responseHtml = processResponse(paramString,responseData);
						}
						else
						{
							 //responseTxt = p_response;
							 responseHtml = responseData;
						}
					}
					if (isDebugYN)	
						System.out.println("(InvokeMyHixRequest:processRequest) ResponseHtml "+responseHtml);
	
					if (isDebugYN)	
						System.out.println("(InvokeMyHixRequest:processRequest) ErrorCode "+errorCode+" ::: ErrorMsg ::: "+errorMsg);

			}
			catch(Exception exp)
			{
				System.out.println("(InvokeMyHixRequest:processRequest) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}
			finally
			{			
				XHUtil.closeDBResources(null, ostmt, dbConn);
			}
			return responseHtml;	
	 }

	public StringBuffer processResponse(String paramString, StringBuffer responseData) throws Exception 
	{

		StringBuffer htmlDataBfr = new StringBuffer();
		String responseDataStr = "", htmlDataStr = "";

		//String paramString = "<REQ_ID>SUMREQQ$!^<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<MYHIX_PAT_ID>anilp$!^<FROM_DATE>DFLT_WSNO$!^<TO_DATE>DFLT_WSNO$!^<MYHIX_DOC_ID>CN11$0000000000000311";
		
		String replacedStr = paramString.replace("$!^","^!^");

		String delims = "^!^";
		StringTokenizer st = new StringTokenizer(replacedStr,delims );
		
		String tokenData  = "";
		String reqId = "";

		String clinicalDocumentStr = "</ClinicalDocument>";

		int totalLength = 0;

		while (st.hasMoreElements()) 
		{
			tokenData = st.nextElement().toString();		
			if (tokenData.indexOf("REQ_TYPE") > 0)
			{
				reqId = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				//System.out.println("Request_ID ::: "+reqId);
			}
		}

		String XSLstr = getXSLData(reqId);		

		responseDataStr = responseData.toString();
		
		//responseDataStr = responseDataStr.replaceAll("&amp;","XXX");

		if (reqId.equalsIgnoreCase("RETREQUEST"))
		{
			totalLength = responseDataStr.lastIndexOf( clinicalDocumentStr ) + clinicalDocumentStr.length();

			if (isDebugYN)
				System.out.println(" ::: responseDataStr.length() ::: "+responseDataStr.length()+" ::: totalLength ::: "+totalLength);

			if (responseDataStr.length() > totalLength)
			{
				responseDataStr = responseDataStr.substring(0,totalLength);
			}
		}

		if (isDebugYN)
			System.out.println(" ::: ProcessResponse ::: "+responseDataStr);
		
		if (reqId.equalsIgnoreCase("QRYREQUEST"))
		{
			if (XSLstr.length()>0)
			{
				htmlDataStr = TransformXMLData.getTransformData(responseDataStr, XSLstr);
				htmlDataBfr = new StringBuffer(htmlDataStr);
			}
			else
				htmlDataBfr = MyHixProcessRequestData.prcoessData(responseData);			
		}

		if (reqId.equalsIgnoreCase("RETREQUEST"))
		{
			if (XSLstr.length()>0)
			{
				htmlDataStr = TransformXMLData.getTransformData(responseDataStr, XSLstr);
				htmlDataBfr = new StringBuffer(htmlDataStr);
			}
			else
				htmlDataBfr = responseData;
		}

		return htmlDataBfr;
	}

	public StringBuffer clobToString(Clob data) {
		StringBuffer sb = new StringBuffer();
		try {
				Reader reader = data.getCharacterStream();
				BufferedReader br = new BufferedReader(reader);

				String line;
				while(null != (line = br.readLine())) {
					sb.append(line);
				}
				br.close();
			} catch (SQLException e) {
			   System.out.println(e);
			} catch (IOException e) {
				// handle this exception
			}
			return sb;
	}

	public String getXSLData(String XMLId) throws Exception {

		String clobStr = "";
		
		if(XMLId != null && XMLId != "" )
		{
			Connection connection 		= null;
			PreparedStatement pstmt		= null;
			ResultSet resultSet 		= null;

			StringBuffer sqlStr = new StringBuffer("");

			StringBuffer strOut = null;
			
			
			sqlStr.append(" select xsl_data from XH_XML_FORMAT ");
			sqlStr.append(" where XML_ID = ? ");
				
			try {
				    connection	= ConnectionManager.getConnection() ;
					if(connection != null)
					{
						pstmt = connection.prepareStatement(sqlStr.toString());
					}				
					
					pstmt.setString(1,XMLId);

					if (isDebugYN)
						System.out.println(" ::: InvokeMyHixRequest : getXSLData : SQL ::: "+sqlStr.toString()+" ::: XML_ID :::"+XMLId);

					resultSet = pstmt.executeQuery();
					
					while(resultSet.next()){   
   
						strOut = new StringBuffer();
						String aux;
						try {
							BufferedReader br = new BufferedReader(resultSet.getClob("xsl_data").
							getCharacterStream());
							while ((aux=br.readLine())!=null) {
								strOut.append(aux);
								strOut.append(System.getProperty("line.separator"));
							}
						}catch (Exception e) {
							e.printStackTrace();
						}
						clobStr = strOut.toString();

						if (isDebugYN)
							System.out.println(" ::: InvokeMyHixRequest : getXSLData : clobStr ::: "+clobStr);
					} 					
					
				} catch ( Exception e )	{
					e.printStackTrace() ;
					throw e ;
				} finally {
						 if ( resultSet != null ) resultSet.close() ;	
						 if ( pstmt != null ) pstmt.close() ;						
						 XHUtil.closeDBResources(null, pstmt, connection);

				}

		}
		return clobStr;
	}
	
	
}
