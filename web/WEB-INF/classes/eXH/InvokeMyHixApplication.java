/***************************************************************************************************************
 * Author   :   Sethuraman D.
 * Desc     :	This class is used to invoke the external MYHIX application
 ***************************************************************************************************************/

package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Map;

import java.sql.Clob;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

import java.util.*;

/**
 * Servlet implementation class InvokeMyHixApplication
 */
public class InvokeMyHixApplication extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		StringBuffer responseTxt= new StringBuffer();
		try
		{
			Map<String, String> reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType");
			String paramString=reqParams.get("paramString");
		
			if("InvokeMyHixApplication".equals(callType)) 
			{
					responseTxt=processRequest(reqParams);
					PrintWriter resp = response.getWriter();
					resp.write(responseTxt.toString());
					resp.flush();
					resp.close();
			}
		}
		catch (Exception exp) 
		{
			exp.printStackTrace(System.err);
		}
    }
    
   
	private StringBuffer processRequest(Map<String, String> reqParams) throws Exception 
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
					dbConn = ConnectionManager.getConnection();					

					ostmt = dbConn.prepareCall("{ CALL XHINTERACTIVE.MYHIXMESSAGEHANDLER(?,?,?,?) }" );
					ostmt.setString(1,reqParams.get("paramString"));
					ostmt.registerOutParameter(2,java.sql.Types.CLOB);
					ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
					ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
					ostmt.execute();
					clob = ostmt.getClob(2);
					responseData = new StringBuffer(clobToString(clob));
					errorCode = ostmt.getString(3);
					errorMsg = ostmt.getString(4);
					System.out.println(" ... reqParams.get(paramString) -->"+reqParams.get("paramString"));
					
					System.out.println("(InvokeMyHixApplication:processRequest) first set p_response--> "+responseData);
					System.out.println("(InvokeMyHixApplication:processRequest) errorCode-->"+errorCode);
					System.out.println("(InvokeMyHixApplication:processRequest) errorMsg-->"+errorMsg);
					
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
							 responseHtml = processResponse(reqParams,responseData);
						}
						else
						{
							 //responseTxt = p_response;
							 responseHtml = responseData;
						}
					}
					System.out.println("(InvokeMyHixApplication:processRequest) responseTxt "+responseData);
					System.out.println("(InvokeMyHixApplication:processRequest) errorCode "+errorCode);
					System.out.println("(InvokeMyHixApplication:processRequest) errorMsg "+errorMsg);
			}
			catch(Exception exp)
			{
				System.out.println("(InvokeMyHixApplication:processRequest) Exception at executing procedure");
				exp.printStackTrace(System.err);
			}
			finally
			{			
				XHUtil.closeDBResources(null, ostmt, dbConn);
			}
			return responseHtml;	
	 }

	private StringBuffer processResponse(Map<String, String> reqParams, StringBuffer responseData) throws Exception 
	{
		String paramString = reqParams.get("paramString");

		StringBuffer htmlData = new StringBuffer();

		//String paramString = "<REQ_ID>SUMREQQ$!^<FACILITY_ID>SI$!^<PATIENT_ID>GE00000142$!^<ENCOUNTER_ID>10101985$!^<MYHIX_PAT_ID>anilp$!^<FROM_DATE>DFLT_WSNO$!^<TO_DATE>DFLT_WSNO$!^<MYHIX_DOC_ID>CN11$0000000000000311";
		
		String replacedStr = paramString.replace("$!^","^!^");

		String delims = "^!^";
		StringTokenizer st = new StringTokenizer(replacedStr,delims );
		
		String tokenData  = "";
		String reqId = "";
		while (st.hasMoreElements()) 
		{
			tokenData = st.nextElement().toString();		
			if (tokenData.indexOf("REQ_TYPE") > 0)
			{
				reqId = tokenData.substring(tokenData.indexOf(">") + 1, tokenData.length());
				System.out.println("Request_ID ::: "+reqId);
			}
		}
		
		if (reqId.equalsIgnoreCase("QRYREQUEST"))
		{
			htmlData = MyHixProcessRequestData.prcoessData(responseData);			
		}

		if (reqId.equalsIgnoreCase("RETREQUEST"))
		{
			//htmlData = MyHixProcessResponseData.prcoessData(responseData);
			htmlData = responseData;
		}

		return htmlData;
	}

	private StringBuffer clobToString(Clob data) {
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
}