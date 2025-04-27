/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.bc;

import eIPAD.chartsummary.vitals.request.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.daoimpl.*;
import eIPAD.chartsummary.vitals.dao.*;
import java.util.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.vitals.healthobject.*;

public class VitalsBC { 
	private ChartApplicabilityResponse getChartApplicability(VitalsRequest oVitalsReq)
	{
		ChartApplicabilityResponse oChartApplicabilityResponse = null;
		ChartApplicabilityDAO oChartApplicabilityDAO = new ChartApplicabilityDAOImpl();
		oChartApplicabilityResponse = oChartApplicabilityDAO.getChartApplicability(oVitalsReq);
		return oChartApplicabilityResponse;
	}
	public CurrentAndHistoryResponse getDiscreteValues(VitalsRequest oVitalsReq)
	{
		CurrentAndHistoryResponse oCurrentAndHistoryDMResponse = null;
		ChartApplicabilityResponse oChartApplicabilityResponse = null;//getChartApplicability(oVitalsReq);
		boolean bChartConfigured = false;
		if(oVitalsReq != null && oVitalsReq.getChartId() != null && !oVitalsReq.getChartId().equals(""))
		{
			bChartConfigured = true;
		}
		else
		{
			oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		}
		String locale = "en";
		
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(bChartConfigured)
		{
			/*
			if(oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
			{
				oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
				CurrentAndHistoryDAO oCurrentAndHistoryDAO = new CurrentAndHistoryDAOImpl();
				oCurrentAndHistoryDMResponse = oCurrentAndHistoryDAO.getDiscreteValues(oVitalsReq);	
			}
			else
			{
				oCurrentAndHistoryDMResponse = new CurrentAndHistoryResponse();
				ErrorInfo oErrInfo = new ErrorInfo();
				oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
				oCurrentAndHistoryDMResponse.getErrorsList().add(oErrInfo);
				
			}
			*/
			CurrentAndHistoryDAO oCurrentAndHistoryDAO = new CurrentAndHistoryDAOImpl();
			oCurrentAndHistoryDMResponse = oCurrentAndHistoryDAO.getDiscreteValues(oVitalsReq);	
		}
		else 
		{
			if(oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
			{
				oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
				CurrentAndHistoryDAO oCurrentAndHistoryDAO = new CurrentAndHistoryDAOImpl();
				oCurrentAndHistoryDMResponse = oCurrentAndHistoryDAO.getDiscreteValues(oVitalsReq);	
			}
			else
			{
				oCurrentAndHistoryDMResponse = new CurrentAndHistoryResponse();
				ErrorInfo oErrInfo = new ErrorInfo();
				oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
				oCurrentAndHistoryDMResponse.getErrorsList().add(oErrInfo);
				
			}
		}
		
		return oCurrentAndHistoryDMResponse;
	}
	public SparkLineChartResponse getSparkLineChartData(VitalsRequest oVitalsReq)
	{
		SparkLineChartResponse oSparkLineResponse = null;
		ChartApplicabilityResponse oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		String locale = "en";
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
		{
			oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
			SparkLineDAO oSparkLineDAO = new SparkLineDAOImpl();
			oSparkLineResponse = oSparkLineDAO.getData(oVitalsReq);
		}
		else
		{
			oSparkLineResponse = new SparkLineChartResponse();
			ErrorInfo oErrInfo = new ErrorInfo();
			oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
			oSparkLineResponse.getErrorsList().add(oErrInfo);
			
		}
		
		return oSparkLineResponse;
	}
	public LineChartResponse getLineChartData(VitalsRequest oVitalsReq)
	{
		LineChartResponse oLineChartResponse = null;
		ChartApplicabilityResponse oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		String locale = "en";
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
		{
			oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
			LineChartDAO oLineChartDAO = new LineChartDAOImpl();
			oLineChartResponse = oLineChartDAO.getData(oVitalsReq);
		}
		else
		{
			oLineChartResponse = new LineChartResponse();
			ErrorInfo oErrInfo = new ErrorInfo();
			oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
			oLineChartResponse.getErrorsList().add(oErrInfo);
			
		}
		return oLineChartResponse;
	}
	public FlowSheetResponse getFlowSheetValues(VitalsRequest oVitalsReq)
	{
		FlowSheetResponse oFlowSheetResponse = null;
		ChartApplicabilityResponse oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		String locale = "en";
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
		{
			oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
			FlowSheetDAO oFlowSheetDAO = new FlowSheetDAOImpl();
			oFlowSheetResponse = oFlowSheetDAO.getFlowSheetValues(oVitalsReq);
		}
		else
		{
			oFlowSheetResponse = new FlowSheetResponse();
			ErrorInfo oErrInfo = new ErrorInfo();
			oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
			oFlowSheetResponse.getErrorsList().add(oErrInfo);
			
		}
		return oFlowSheetResponse;
		
	}
	
	public VitalsConfigResponse getVitalsConfig(VitalsRequest oVitalsReq)
	{
		VitalsConfigResponse oVitalsConfigResponse = null;
		ChartApplicabilityResponse oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		String locale = "en";
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(oChartApplicabilityResponse != null && oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
		{
			oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
			VitalsConfigDAO oVitalsConfigDAO = new VitalsConfigDAOImpl();
			oVitalsConfigResponse = oVitalsConfigDAO.getVitalsConfig(oVitalsReq);
			if(oVitalsConfigResponse != null)
			{
				oVitalsConfigResponse.setChartId(oChartApplicabilityResponse.getChartId());
			}
		}
		else
		{
			oVitalsConfigResponse = new  VitalsConfigResponse();
			/*ErrorInfo oErrInfo = new ErrorInfo();
			oErrInfo.setErrorType(Errors.NO_CHART_CONFIGURED,locale);
			*/
			//oVitalsConfigResponse.getErrorsList().add(oErrInfo);
			if(oChartApplicabilityResponse != null)
			{
				oVitalsConfigResponse.setErrorsList(oChartApplicabilityResponse.getErrorsList());
			}
			
		}
		return oVitalsConfigResponse;
	}
	
	public VitalsPanelResponse getPanelConfig(VitalsRequest oVitalsReq)
	{
		VitalsPanelResponse oVitalsPanelResponse = new VitalsPanelResponse();
		ChartApplicabilityResponse oChartApplicabilityResponse = getChartApplicability(oVitalsReq);
		String locale = "en";
		if(oVitalsReq != null && oVitalsReq.getPatientContext() != null && !oVitalsReq.getPatientContext().getLocale().equals(""))
		{
			locale = oVitalsReq.getPatientContext().getLocale();
		}
		if(oChartApplicabilityResponse != null && oChartApplicabilityResponse.isSuccessResponse() && !oChartApplicabilityResponse.isEmptyDataResponse())
		{
			oVitalsReq.setChartId(oChartApplicabilityResponse.getChartId());
			PanelConfigDAO oPanelConfigDAO = new PanelConfigDAOImpl();
			oVitalsPanelResponse = oPanelConfigDAO.getPanelConfig(oVitalsReq);
			if(oVitalsPanelResponse != null && oVitalsPanelResponse.isSuccessResponse() && !oVitalsPanelResponse.isEmptyDataResponse())
			{
				NormalcyIndicator oNormalcyIndicator = oVitalsPanelResponse.getNormalcyIndicator();
				oVitalsPanelResponse.setChartId(oVitalsReq.getChartId());
				List<VitalsPanel> vitalsPanelList =  oVitalsPanelResponse.getListVitalsPanel();
				if(oNormalcyIndicator != null && vitalsPanelList != null && vitalsPanelList.size() > 0)
				{
					for(VitalsPanel oVitalsPanel : vitalsPanelList)
					{
						if(oVitalsPanel != null)
						{
							List<VitalsConfig> vitalsConfigList = oVitalsPanel.getVitalsConfigList();
							if(vitalsConfigList != null && vitalsConfigList.size() > 0)
							{
								for(VitalsConfig oVitalsConfig : vitalsConfigList)
								{
									if(oVitalsConfig.getResultType() != null && (oVitalsConfig.getResultType().equals("N") || oVitalsConfig.getResultType().equals("I")))
									{
										oVitalsConfig.setHighStr(oNormalcyIndicator.getHighValueDescription());
										oVitalsConfig.setLowStr(oNormalcyIndicator.getLowValueDescription());
										oVitalsConfig.setCriticalLowStr(oNormalcyIndicator.getCriticalLowDescription());
										//oVitalsConfig.setCriticalHigh(oNormalcyIndicator.getCriticalHighDescription());
										oVitalsConfig.setCriticalHighStr(oNormalcyIndicator.getCriticalHighDescription());
										if(oVitalsConfig.getNumDfltResult() != null && !oVitalsConfig.getNumDfltResult().equals(""))
										{
											String num_dflt_result = oVitalsConfig.getNumDfltResult();
											String normalLow = oVitalsConfig.getNormalLow();
											String normalHigh = oVitalsConfig.getNormalHigh();
											String criticalLow = oVitalsConfig.getCriticalLow();
											String criticalHigh = oVitalsConfig.getCriticalHigh();
											String normalInd = "";
											String highStr = oNormalcyIndicator.getHighValueDescription(); 
											String lowStr = oNormalcyIndicator.getLowValueDescription();
											String cricHighStr = oNormalcyIndicator.getCriticalHighDescription();
											String cricLowStr = oNormalcyIndicator.getCriticalLowDescription();
											
											if(Float.parseFloat(num_dflt_result) != 0)
											{
												
												if((!normalLow.equals("") && Float.parseFloat(normalLow) != 0) && (!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0) && (!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0) &&  (!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0))
												{
													if(Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow) && Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow))
													{
														normalInd = lowStr;
													}
													else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh))
													{
														normalInd = cricHighStr;
													}
													else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow))
													{
														normalInd = cricLowStr;
													}
													else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh) && Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))
													{
														normalInd = highStr;
													}
												}
												else
												{
													if(!normalLow.equals("") && Float.parseFloat(normalLow) != 0)
													{	
														if(!criticalLow.equals("") && Float.parseFloat(criticalLow) != 0)
														{
															if(Float.parseFloat(num_dflt_result) < Float.parseFloat(criticalLow)) 								normalInd = cricLowStr;
															else if((Float.parseFloat(num_dflt_result) >= Float.parseFloat(criticalLow))&&(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)))
																normalInd = lowStr;
														}
														else if(Float.parseFloat(num_dflt_result) < Float.parseFloat(normalLow)) normalInd = lowStr;
													}
		
													if(!normalHigh.equals("") && Float.parseFloat(normalHigh) != 0)
													{	
														if(!criticalHigh.equals("") && Float.parseFloat(criticalHigh) != 0)
														{
															if(Float.parseFloat(num_dflt_result) > Float.parseFloat(criticalHigh)) 
																normalInd = cricHighStr;
															else if((Float.parseFloat(num_dflt_result) <= Float.parseFloat(criticalHigh))&&(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)))
																normalInd = highStr;	
														}
														else if(Float.parseFloat(num_dflt_result) > Float.parseFloat(normalHigh)) normalInd = highStr;					
													}
												}	
											}//if
											if(normalInd == null)
											{
												normalInd = "";
											}
											oVitalsConfig.setNormalIndicator(normalInd);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		else
		{
			if(oChartApplicabilityResponse != null)
			{
				oVitalsPanelResponse.setErrorsList(oChartApplicabilityResponse.getErrorsList());
			}
		}
		return oVitalsPanelResponse;
	}
}
