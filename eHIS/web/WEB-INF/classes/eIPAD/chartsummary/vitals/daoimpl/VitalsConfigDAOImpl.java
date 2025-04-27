/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.daoimpl;

import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import eIPAD.chartsummary.vitals.healthobject.*;
import eIPAD.chartsummary.vitals.request.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.dao.*; 

public class VitalsConfigDAOImpl extends GenericDAOImpl implements VitalsConfigDAO {
	public VitalsConfigResponse getVitalsConfig(VitalsRequest oVitalsReq)
	{
		VitalsConfigResponse oVitalsConfigResponse = new VitalsConfigResponse();
		Connection connection 		= null;
		PreparedStatement pStmt				= null;
		ResultSet resultSet 		= null;
		String locale = "en";
		String chartId = "";
		StringBuffer sqlStr = new StringBuffer("");
		List<VitalsConfig> listVitalsConfig = new ArrayList<VitalsConfig>();
		ErrorInfo oErrInfo = new ErrorInfo();
		if(oVitalsReq != null && oVitalsReq.getChartId() != null && !oVitalsReq.getChartId().equals("") )
		{
			PatContext oPatContext = oVitalsReq.getPatientContext();
			if(oPatContext != null)
			{
				locale =  checkForNull(oPatContext.getLocale());
				chartId = checkForNull(oVitalsReq.getChartId());
				if(locale.equals(""))
				{
					locale = "en";
				}
				sqlStr.append(" SELECT   a.panel_id section_id, am_get_desc.am_discr_msr (a.panel_id,'" + locale+"', '2') section_desc, a.discr_msr_id discr_msr_id, am_get_desc.am_discr_msr (a.discr_msr_id,'" + locale+"', '2') discr_msr_desc, ");
				sqlStr.append(" b.NUM_DFLT_RESULT Default_Value, b.NUM_UOM Units, discr_msr.result_type result_type, a.panel_disp_order_seq display_order_seq,          a.discr_disp_order_seq order_srl_no, a.default_display_yn,");
				sqlStr.append(" a.summary_type, a.summry_column, a.sum_yn, CA_GET_FORMULA_STRING(a.FORMULA_DEF) formula_def,a.mandatory_yn, num_digits_max, num_digits_min,  num_digits_dec,  MIN_VALUE, MAX_VALUE,ref_range_type,ASSOCIATE_SCORE_YN FROM ca_chart_section_comp a, am_discr_msr discr_msr, AM_DISCR_MSR_REF_RNG_NUM b ");
				//sqlStr.append(" WHERE a.chart_id ='" + chartId + "' AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y' AND  a.discr_msr_id = b.discr_msr_id(+) ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ");
				sqlStr.append(" WHERE a.chart_id ='" + chartId + "' AND discr_msr.discr_msr_id = a.discr_msr_id AND discr_msr.ch_appl_yn = 'Y' AND  a.discr_msr_id = b.discr_msr_id(+)  ");
				if(oVitalsReq.getFilterByEventCode() != null && !oVitalsReq.getFilterByEventCode().equals(""))
				{
					if(oVitalsReq.getFilterByEventCode().indexOf(",") == -1)
					{
						sqlStr.append(" AND a.discr_msr_id = '" + oVitalsReq.getFilterByEventCode() + "' ");
					}
					else
					{
						sqlStr.append(" AND a.discr_msr_id in ( " );
						StringTokenizer st = null;
						st = new StringTokenizer(oVitalsReq.getFilterByEventCode(),",");
						int nTokenCount = 0;
						while (st.hasMoreTokens())
						{
							if(nTokenCount == 0)
							{
								sqlStr.append(" '" +st.nextElement() + "'");
							}
							else
							{
								sqlStr.append(" , '" +st.nextElement() + "'");
							}
							nTokenCount++;
							
						}
						sqlStr.append( " ) ");
					}
				}
				sqlStr.append(" ORDER BY a.panel_disp_order_seq, a.discr_disp_order_seq ");
				try
				{
					connection = createConnection();
					if(connection != null)
					{
						pStmt = connection.prepareStatement(sqlStr.toString());
						
					}
					if(pStmt != null){
						resultSet = pStmt.executeQuery();
					}
					if(resultSet != null)
					{
						while(resultSet.next())
						{
							VitalsConfig oVitalsConfig = new VitalsConfig();
							
							String sectionId = resultSet.getString("section_id");
							String sectionDesc = resultSet.getString("section_desc");
							String discMsrId = resultSet.getString("discr_msr_id");
						    String discMsrDesc = resultSet.getString("discr_msr_desc");
						    String units = resultSet.getString("Units");
						    String defaultValue = resultSet.getString("Default_Value");
							String displayOrderSequence = resultSet.getString("display_order_seq"); 
							String orderSeqNo = resultSet.getString("order_srl_no");
							
							oVitalsConfig.setSectionId(((sectionId != null) ? sectionId  : ""));
							oVitalsConfig.setSectionDesc(((sectionDesc != null) ? sectionDesc  : "")) ;
							oVitalsConfig.setDiscreteMeasureId((( discMsrId != null) ?  discMsrId  : ""));
							oVitalsConfig.setDiscreteMeasureDesc(((discMsrDesc != null ) ? discMsrDesc :""));
							oVitalsConfig.setDefaultValue(((defaultValue != null) ? defaultValue : "" ));
							oVitalsConfig.setUnits(((units != null) ? units : ""));
							oVitalsConfig.setPanelOrderSequence(((displayOrderSequence != null) ? displayOrderSequence : ""));
							oVitalsConfig.setDiscOrderSequence(((orderSeqNo  != null) ? orderSeqNo : ""));
							listVitalsConfig.add(oVitalsConfig);
							
						}
					}
					if(listVitalsConfig != null && listVitalsConfig.size() == 0)
					{
						oErrInfo.setErrorType(Errors.COMMON_EMPTY_DATA, locale);
					}
					oVitalsConfigResponse.setListVitalConfig(listVitalsConfig);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					oErrInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION, locale);
				}
				finally
				{
					int conCloseFailure = closeConnection(connection,pStmt,resultSet);
					if(conCloseFailure > 0)
					{
						//System.out.println("Connection not closed in the method eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl.getNoteDetails");
					}
				}
			}
			else
			{
				oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
			}
		}
		else
		{
			oErrInfo.setErrorType(Errors.COMMON_NULL_REQUEST, locale);
		}
		oVitalsConfigResponse.getErrorsList().add(oErrInfo);
		return oVitalsConfigResponse;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
