/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*************************************************************************
*	ClassName					: AutoCompleteServlet
*	Description				    :
*	Methods						:
*	Exception					:
*	Authors						: 
*	Version						: 1.0
*	Date						: 23-Jun-15
*	Revision History			:
***************************************************************************
*   Version			Date		Name		Remarks
***************************************************************************/
package ePH;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import com.google.gson.Gson;

public class AutoCompleteServlet extends javax.servlet.http.HttpServlet {

	public void init(ServletConfig config) throws ServletException{
			System.err.println("@@AutoCompleteServlet INIT:");
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.err.println("@@AutoCompleteServlet Doget:");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String resData=null;
			System.err.println("@@AutoCompleteServlet GoPost:");
			Gson g=new Gson();
			HashMap hm=new HashMap();
			ArrayList records = getDrugListforAutoComplete(request,response);
			response.setContentType("application/json");
			response.setHeader("Pragma", "no-cache");
			PrintWriter  out = response.getWriter();
			hm.put("data",records);
			resData=g.toJson(hm);		
	System.err.println("===doPost====resData====="+resData);
			out.write(resData);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList getDrugListforAutoComplete(HttpServletRequest request, HttpServletResponse response )throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList records		= new ArrayList();
		//int start				= 0 ; Removed for IN063877
		int end					= 5 ;
		String levent=request.getParameter("Event");
		try {
			if(levent != null && levent.equals("SEARCHDATA")){
				//String patient_id		= request.getParameter("patient_id"); Removed for IN063877
				//String encounter_id		= request.getParameter("encounter_id"); Removed for IN063877
				String practitionerId	= checkForNull(request.getParameter("practitionerId"));
				String resp_id			= checkForNull(request.getParameter("resp_id"));
				String drugText			= checkForNull(request.getParameter("drugText"));
				String patient_class	= checkForNull(request.getParameter("patient_class"));
				String pract_type		= checkForNull(request.getParameter("pract_type"));
				String res_by_service	= checkForNull(request.getParameter("res_by_service"));
				String service_code		= checkForNull(request.getParameter("service_code"));
				//String take_home_medication_yn= checkForNull(request.getParameter("take_home_medication_yn")); Removed for IN063877
				String called_from_verbal_order= checkForNull(request.getParameter("called_from_verbal_order"));
				String default_prev_drug_sel= checkForNull(request.getParameter("default_prev_drug_sel"));
				//String drug_priv_ssn_yn	= checkForNull(request.getParameter("drug_priv_ssn_yn")); Removed for IN063877
				String language_id= checkForNull(request.getParameter("language_id"));
				String iv_prep_yn= checkForNull(request.getParameter("iv_prep_yn"));
				//String generic_name		="%";
				String drug_desc		="";
				//String trade_desc		="%";
				String episode_type= patient_class;
			//	String episode_id="", visit_id=""; Removed for IN063877
				if(episode_type !=null && (!episode_type.equals("")))
					episode_type = episode_type.substring(0,1);

				if(episode_type !=null && episode_type.equals("X"))
					episode_type = "R";
				StringBuffer queryAppend = new StringBuffer();
				String sqlQry ="";
				HashMap hmDrugDtl = null;
				connection = ConnectionManager.getConnection(request);
				drug_desc = drugText+"%";  

			//	String cmp_fld_codes = ""; Removed for IN063877
			//	String cmp_fld_flag  = "Y"; Removed for IN063877
				//queryAppend = "AND snm.DRUG_CODE(+)=B.DRUG_CODE AND snm.EFF_STATUS(+)='E' AND upper(SNM.DRUG_SYNONYM_DESC(+)) LIKE upper(?) AND snm.LANGUAGE_ID(+)=B.LANGUAGE_ID";
		
				if(pract_type.equals("NS")){
					queryAppend.append(" AND B.APPL_TO_VERBAL_ORDER_YN='Y' ");
				}
				if("Y".equals(iv_prep_yn))
					queryAppend.append(" AND DECODE(J.DFLT_IV_ROUTE_CODE,NULL,'X',J.DFLT_IV_ROUTE_CODE) IN (SELECT PRFF.ROUTE_CODE FROM PH_ROUTE_FOR_FORM PRFF WHERE PRFF.FORM_CODE = B.FORM_CODE)  AND ( (B.IV_FLUID_YN='N' AND B.IV_INGREDIENT_YN='Y') OR (B.IV_FLUID_YN='Y' AND B.IV_INGREDIENT_YN='Y') ) " );

				if(res_by_service!=null && res_by_service.equals("Y")){
					queryAppend.append(" AND B.GENERIC_ID IN (SELECT DISTINCT GENERIC_ID FROM PH_GENERIC_NAME_FOR_SERVICE WHERE SERVICE_CODE LIKE DECODE(?,NULL,'%',SERVICE_CODE))" );
				}
				queryAppend.append(" AND B.IN_FORMULARY_YN='Y' " );

				if(called_from_verbal_order.equals("Y")){
					queryAppend.append( " AND B.APPL_TO_VERBAL_ORDER_YN='Y' ");
				}
				sqlQry ="";
				if ("S".equals(default_prev_drug_sel)){
					queryAppend.append(" AND or_get_priv_appl_yn(?,?,'OR',B.DRUG_CODE,?,A.ORDER_TYPE_CODE,'PH') = 'Y' ");
				}
				sqlQry ="SELECT DISTINCT B.DRUG_CODE, f.TRADE_CODE, B.DRUG_DESC || decode(g.short_name, null, '', ' (' || g.short_name || ')' ) drug_name FROM OR_ORDER_CATALOG A, PH_DRUG_LANG_VW B,PH_FORM_LANG_VW C,PH_ROUTE_LANG_VW E, PH_TRADE_NAME_FOR_DRUG F, AM_TRADE_NAME_LANG_VW G, OR_ORDER_CATALOG_BY_PTCL I,PH_PARAM J, PH_DRUG_SYNONYM_lang snm  WHERE B.DRUG_YN='Y'  AND B.DISCONTINUED_YN = 'N' AND A.ORDER_CATEGORY='PH' AND A.EFF_STATUS='E' AND B.DRUG_CODE = A.ORDER_CATALOG_CODE AND C.FORM_CODE = B.FORM_CODE  AND E.ROUTE_CODE = B.ROUTE_CODE AND F.DRUG_CODE(+) = B.DRUG_CODE AND F.TRADE_CODE = G.TRADE_ID(+) AND  UPPER(B.DRUG_DESC) LIKE UPPER(NVL(?,B.DRUG_DESC)) AND  I.PATIENT_CLASS =OR_PATIENT_ORDER_APPLICABLE( ?,A.ORDER_CATALOG_CODE) AND A.ORDER_CATALOG_CODE = I.ORDER_CATALOG_CODE "+queryAppend+" AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = E.LANGUAGE_ID AND F.EFF_STATUS(+) = 'E' AND G.EFF_STATUS(+) = 'E' AND B.LANGUAGE_ID = ?  AND G.LANGUAGE_ID(+) = ?  ORDER BY drug_name";// added E.ROUTE_COLOR for CRF RUT-CRF-0034.1[IN:037389]-end
						
				pstmt = connection.prepareStatement(sqlQry);
						
				int cnt	=	1;
				pstmt.setString(cnt,drug_desc.trim());
				pstmt.setString(++cnt,patient_class);
				if ("S".equals(default_prev_drug_sel)){ 
					pstmt.setString(++cnt,practitionerId);
					pstmt.setString(++cnt,resp_id);
					pstmt.setString(++cnt,default_prev_drug_sel);
				}
				pstmt.setString(++cnt, language_id);
				pstmt.setString(++cnt, language_id);
				if(res_by_service.equals("Y")){
					pstmt.setString(++cnt,service_code);
				}
				int i=0;
				resultSet = pstmt.executeQuery() ;
				while(resultSet!=null && resultSet.next() && i<end){
					hmDrugDtl=new HashMap();
					hmDrugDtl.put("drug_code", checkForNull(resultSet.getString("DRUG_CODE")));
					hmDrugDtl.put("drug_name", checkForNull(resultSet.getString("DRUG_NAME")));
					hmDrugDtl.put("trade_code", checkForNull(resultSet.getString("TRADE_CODE")));
					records.add( hmDrugDtl );
					i++;
				}
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				resultSet.close();
				pstmt.close();
				connection.close();
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;
	}
	private String checkForNull(String inputString){
		if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
			inputString = "";
		return inputString;
	}
}