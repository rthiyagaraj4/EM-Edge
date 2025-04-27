/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.sfs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eIPAD.HealthObjects.NursingUnit;
import eIPAD.HealthObjects.SFSContext;

/**
 * @author NavyaI
 *
 */
public class SFSDetails {
	public List<SFSUnit> getSFSUnit(SFSContext oSFSContext)
			throws Exception {
		List<SFSUnit> sfsUnitList = new ArrayList<SFSUnit>();
		if (oSFSContext != null && oSFSContext.getRequest() != null) {

			Connection connection = null;
			
			Statement stmt = null;
			ResultSet resultSet = null;

			HttpSession session = oSFSContext.getSession();
			HttpServletRequest request = oSFSContext.getRequest();
			
			/*String SearchBy = "";
			String SearchCriteria = "";
			String SearchText = "";
			String locale = "en";
			StringBuffer sqlStr = new StringBuffer("");
			String sPracId = "";
			String facility_id = "";
			String clinicianId = "";

			
			
			
			
			HttpServletRequest request = oSFSContext.getRequest();
			if (oSFSContext.getSfacility_id() != null  && ! oSFSContext.getSfacility_id().equals("")) {
				facility_id = oSFSContext.getSfacility_id();
				
			}

			if (oSFSContext.getSclinicianId() != null && ! oSFSContext.getSclinicianId().equals("")) {
				clinicianId = oSFSContext.getSclinicianId();
			}
			if (oSFSContext.getsPractionerId() != null && !oSFSContext.getsPractionerId().equals("")) {
				sPracId = oSFSContext.getsPractionerId();
			
			}
			
			sqlStr.append("SELECT locn_code code, DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC('"
					+ facility_id
					+ "',locn_code,'en','1'),'W', IP_GET_DESC.IP_NURSING_UNIT('"
					+ facility_id + "',locn_code,'en','1') ) description");
			sqlStr.append(" FROM ca_pract_by_locn_view  WHERE practitioner_id = '"
					+ clinicianId + "'  AND locn_type     IN ('C','W')  ");

			sqlStr.append("AND facility_id  = '" + facility_id + "'");

			

			if (sPracId != null && !sPracId.equals("")) {
				clinicianId = sPracId;
			}
			

			if ( oSFSContext.getsSearchBy() != null &&  oSFSContext.getsSearchBy() != "") {
				SearchBy = oSFSContext.getsSearchBy();
			}

			if (oSFSContext.getsSearchCriteria() != null && oSFSContext.getsSearchCriteria() != "") {
				SearchCriteria = oSFSContext.getsSearchCriteria();
			}
			if (oSFSContext.getsSearchText() != null && oSFSContext.getsSearchText() != "") {
				SearchText = oSFSContext.getsSearchText();

			}

			if (!SearchBy.equals("") && SearchBy.equals("code") && !SearchText.equals(""))
			{
				
				if (!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
					sqlStr.append(" AND upper(locn_code) like upper('"
							+ SearchText + "%' )");

				if (!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
					sqlStr.append(" AND upper(locn_code) like upper('%"
							+ SearchText + "%' )");

				if (!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
					sqlStr.append(" AND upper(locn_code) like upper('%"
							+ SearchText + "' )");

			}

			if (!SearchBy.equals("") && SearchBy.equals("desc") && !SearchText.equals("")) {

			
				if (!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
					sqlStr.append(" AND UPPER(DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC('"
							+ facility_id
							+ "',locn_code,'en','1'),'W',IP_GET_DESC.IP_NURSING_UNIT('"
							+ facility_id
							+ "',locn_code,'en','1') )) LIKE upper('"
							+ SearchText + "%')");

				if (!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
					sqlStr.append(" AND UPPER(DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC('"
							+ facility_id
							+ "',locn_code,'en','1'),'W',IP_GET_DESC.IP_NURSING_UNIT('"
							+ facility_id
							+ "',locn_code,'en','1') )) LIKE upper('%"
							+ SearchText + "%')");

				if (!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
					sqlStr.append(" AND UPPER(DECODE(locn_type,'C',OP_GET_DESC.OP_CLINIC('"
							+ facility_id
							+ "',locn_code,'en','1'),'W',IP_GET_DESC.IP_NURSING_UNIT('"
							+ facility_id
							+ "',locn_code,'en','1') )) LIKE upper('%"
							+ SearchText + "')");

			}*/
			String queryString = null;
			SFS sfsInst = SFSFactory.getInstance().getSFSInstance(oSFSContext);
			/**
			 * TODO
			 * need to handle null object instance -- there should be an error
			 * message returned to user - Navya to handle this
			 */
			if(sfsInst == null){
				return sfsUnitList;
			}
			
			SFSReturnData returnData = sfsInst.getQuery(oSFSContext);
			/**
			 * TODO
			 * need to handle null object instance -- there should be an error
			 * message returned to user - Navya to handle this
			 */
			if(returnData == null){
				return sfsUnitList;
			}

			queryString = returnData.getQuery();
			/**
			 * Safe check for null or empty string
			 * error message should be returned -- Navya to handle this
			 */
			if(queryString == null || queryString.trim().equals("")){
				return sfsUnitList;
			}
			
			try {
				connection = ConnectionManager.getConnection(request);
				if (connection != null) {
					stmt = connection.createStatement();
				}
				

				if (stmt != null)
					resultSet = stmt.executeQuery(queryString);
				while (resultSet != null && resultSet.next()) {
					SFSUnit sfsUnit = new SFSUnit();
					sfsUnit.setsCode(((resultSet.getString("code") != null) ? resultSet.getString("code") : ""));
					sfsUnit.setsDescription(((resultSet.getString("description") != null) ? resultSet.getString("description") : ""));
					sfsUnitList.add(sfsUnit);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				if (resultSet != null)
					resultSet.close();
				if (stmt != null)
					stmt.close();
				ConnectionManager.returnConnection(connection, request);

			}
		}
		return sfsUnitList;
	}
}
