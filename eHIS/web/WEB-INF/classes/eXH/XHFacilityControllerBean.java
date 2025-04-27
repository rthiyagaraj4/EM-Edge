/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import oracle.jdbc.driver.*;
import oracle.sql.*;

/**
* Bean Class used to represent the XH Facility   
*/
public class XHFacilityControllerBean implements java.io.Serializable
{

	public static String strBeanName = "XH_FACILITY_CROSS_REF";
	private int start = 0;
	private int end = 0;
	private int totalData = 0;
	private int maxRec = 12;
	private TreeMap treemp = new TreeMap();
	private boolean boolNext = false;
	private boolean boolPrevious = false;

	/**
	* Method  to accesss the data which returns string array
	*/

	public String[][] getDatabaseData()
	{

		String str[][] = null;
		String key = "";
		Iterator iterator = null;
		XHFacilityBean xhBean = null;
		String strItm[] = new String[7];
		try
		{
			str = new String[treemp.size()][7];
			iterator = this.enumerate();
			int j=0;
			while(iterator.hasNext())
			{
				key = iterator.next()+"";
				xhBean = this.getCodeDesc(key);
				strItm = xhBean.getDatabaseData();
				str[j] =strItm;
				j++;
			}

		}
		catch(Exception exp)
		{			
			exp.printStackTrace(System.err);
		}
		return(str);
	}

	/**
	* Method  getCodeDesc return bean element XHMasterCodeElements  depending ob the key 
	* @param  String key
	* @return returns object type  XHMasterCodeElements
	*/      

	public XHFacilityBean getCodeDesc(String key)
	{	  
		return((XHFacilityBean)treemp.get(key));
	}

	/**
	* Method to enumerate the keys 
	*/ 
	public Iterator enumerate()
	{
		Set set = treemp.keySet();
		Iterator iterator = set.iterator();
		return iterator;
	}

	/**
	* Method defined to get all the parameter values 
	* @param  HttpServletRequest request
	* @param  Connection conn
	*/

	public void getAllParameterValues(HttpServletRequest request,Connection conn)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}

		Iterator iterator = enumerate();
		String strKey = "";
		String strInUse="";
		String protocolLinkID = "";
		String protocolId="";
		XHFacilityBean xhCode = null;
		for (int i=0;i<start;i++)
		{
			iterator.next();
		}
		for(int i=start;i<end;i++)
		{
			if (iterator.hasNext())
			{
				strKey = iterator.next()+"";
			}
			else
			{
				break;
			}

			strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey));			
			protocolLinkID = XHDBAdapter.checkNull(request.getParameter(strKey+"_protocolLinkID"));
			protocolId = XHDBAdapter.checkNull(request.getParameter(strKey+"_protocolID"));
			xhCode = getCodeDesc(strKey); 
			xhCode.setInuse(strInUse);
			xhCode.setProtocolLinkID(protocolLinkID);   
			xhCode.setProtocolID(protocolId); 	       	   
			xhCode.setReportOPDirectory(request.getParameter(strKey+"_reportOPDir"));
		}
	}

	/**
	* Method to add the values into the hashmap 
	*/
	public HashMap getResultSet()
	{
		Iterator iterator = enumerate();
		ArrayList arrRow = null;
		ArrayList temp = null;
		String key = "";
		XHFacilityBean xhCode = null;
		arrRow = new ArrayList();
		HashMap hashmp = new HashMap();
		for(int i=0;i<start;i++)
		{
			iterator.next();
		}
		for(int i=start;i<end;i++)
		{
			if (iterator.hasNext())
			{
				key = iterator.next()+"";
			}
			else
			{
				break;
			}
			xhCode = getCodeDesc(key);
			temp = xhCode.getArrayData();
			arrRow.add(temp);	      
		}
		hashmp.put("qry_result",arrRow);
		hashmp.put("next",new Boolean(boolNext));
		hashmp.put("previous",new Boolean(boolPrevious));
		return(hashmp);
	}

	/**
	* Method to get single bean element 
	* @param  String strBeanName
	* @param  HttpServletRequest request
	* @param  HttpSession session
	*/

	public static XHFacilityControllerBean getBean(String strBeanName, HttpServletRequest request,HttpSession session)
	{
		String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
		XHFacilityControllerBean xhBean = null;
		if(action.equals("S")||action.equals("0"))
		{
			session.removeAttribute(strBeanName); 
			xhBean = new XHFacilityControllerBean();
			session.setAttribute(strBeanName,xhBean); 
		}
		else
		{
			xhBean = (XHFacilityControllerBean) session.getAttribute(strBeanName);
		}
		return(xhBean);
	}

	/**
	* Method to define whether need to access elements or not depending on the action
	* @param  String action
	**/
	private boolean decideParameterValues(String action)
	{
		if ( action.equals("P")||
		action.equals("N")||
		action.equals("R"))
		{
			return(true);
		}
		return false;
	}

	/**
	* Method action to retrive jsp values 
	* @param  HttpServletRequest request
	* @param  Connection conn
	*/
	public void action(HttpServletRequest request,Connection conn)
	{
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
		locale = "en";

		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}

		String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));

		if ((action.equals("S"))||(action.equals("0")))
		{
			this.populateXHCodeDesc(conn,request,locale);
			end = maxRec;
		}
		if (decideParameterValues(action) == true)	getAllParameterValues(request,conn);
		if (action.equals("N"))
		{
			start = start+maxRec;
			end = end+maxRec;
			if(start>=totalData)
			{
				start = start - maxRec;
				end = end-maxRec;
			}
		}
		if (action.equals("P"))
		{
			start = start - maxRec;
			end = end-maxRec;
			if (start<=0)
			{
				start = 0;
				end = maxRec;
			}
		}
		if (totalData>end)
		{
			boolNext =  true;
		}
		else
		{
			boolNext =  false;      
		}
		if (end>maxRec)
		{
			boolPrevious =  true;
		}
		else
		{
			boolPrevious =  false;
		}
	}

	/**
	* Method to populate the  XHFaxcilityInbound Bean 
	* @param  Connection conn
	* @param  HttpServletRequest request
	* @param  String locale
	*/

	public void populateXHCodeDesc(Connection conn,HttpServletRequest request,String locale)
	{
		String mode =request.getParameter("mode");
		String client_id =request.getParameter("client_id");

		String sql = "";

		sql = " SELECT DISTINCT X.APPLICATION_ID,X.APPLICATION_NAME,'N' IN_USE_YN, "+ 
		" Y.PROTOCOL_LINK_ID,Y.PROTOCOL_LINK_NAME,'Y','',Y.PROTOCOL_ID " +
		" FROM XH_APPLICATION_LANG_VW X,XH_PROTOCOL_LINK Y,	SM_FACILITY_PARAM Z,XH_PROTOCOL A "+
		" WHERE X.APPLICATION_ID = Y.APPLICATION_ID "+
		" AND Y.PROTOCOL_ID=A.PROTOCOL_ID AND A.PROTCOL_MODE='O' AND X.LANGUAGE_ID='"+locale+"' AND "+		
		" (Y.APPLICATION_ID,'NULL') NOT IN (SELECT APPLICATION_ID,CLIENT_ID "+  
		" FROM XH_COMM_CLIENT_APPLICATION WHERE COMM_TYPE='O') ORDER BY 2 ";

		if(mode.equalsIgnoreCase("U"))
		{
			sql =  " SELECT X.APPLICATION_ID,X.APPLICATION_NAME,NVL(Y.IN_USE_YN,'N') IN_USE_YN, "+ 
			" A.PROTOCOL_LINK_ID,A.PROTOCOL_LINK_NAME,'N',Y.REPORT_OUTPUT_DIRECTORY,A.PROTOCOL_ID " +
			" FROM XH_APPLICATION_LANG_VW X,XH_COMM_CLIENT_APPLICATION Y,XH_PROTOCOL_LINK A "+ 
			" WHERE X.APPLICATION_ID=Y.APPLICATION_ID"+
			" AND Y.CLIENT_ID='"+client_id+"' AND Y.COMM_TYPE='O' AND X.LANGUAGE_ID='"+locale+"' AND " +
			" Y.PROTOCOL_LINK = A.PROTOCOL_LINK_ID(+) " +
			" UNION " +
			" SELECT X.APPLICATION_ID,X.APPLICATION_NAME,'N' IN_USE_YN, Y.PROTOCOL_LINK_ID,Y.PROTOCOL_LINK_NAME,'Y','',Y.PROTOCOL_ID "+ 
			" FROM XH_APPLICATION_LANG_VW X, XH_PROTOCOL_LINK Y,XH_PROTOCOL A "+
			" WHERE X.APPLICATION_ID = Y.APPLICATION_ID AND Y.PROTOCOL_ID=A.PROTOCOL_ID AND A.PROTCOL_MODE='O'"+ 
			" AND X.LANGUAGE_ID='"+locale+"' AND (Y.APPLICATION_ID,'"+client_id+"') NOT IN " +			
			" (SELECT APPLICATION_ID,CLIENT_ID  FROM XH_COMM_CLIENT_APPLICATION WHERE COMM_TYPE='O') ORDER BY 2";
		}

		PreparedStatement pstmt = null;
		ResultSet rset = null;
	//	System.out.println("SQL STMT "+sql);
		try
		{
			//System.out.println(" sql :"+sql);
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while(rset.next())
			{		  
				treemp.put(rset.getString(1)+""+XHDBAdapter.checkNull(rset.getString(4))+"_OUTBOUND_SELECT",new XHFacilityBean(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8))) ;
			}
			this.totalData = treemp.size();
			if(rset!=null) rset.close();						 
			if(pstmt!=null) pstmt.close();

		}
		catch(Exception exp)
		{
			System.out.println("Error in populatexhcodedesc method of xhfacilitycontrollerbean :"+exp.toString());
			exp.printStackTrace(System.err);
		}
	}
}//end of class
