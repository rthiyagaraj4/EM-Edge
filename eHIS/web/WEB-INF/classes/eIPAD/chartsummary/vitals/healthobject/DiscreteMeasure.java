/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import eIPAD.chartsummary.common.constants.LocalizationConstants;

public class DiscreteMeasure implements java.io.Serializable {

	/**
	 * This class holds the attributes required for a discrete. 
	 */
	private static final long serialVersionUID = 1L;
	protected String eventCode;
	protected String eventDescription;
	protected String normalLow;
	protected String normalHigh;
	protected String UOM;
	protected String eventGroupDesc;
	protected String histRecType;
	protected String criticalHigh;
	protected String criticalLow;
	protected DiscreteValue currentDiscreteValue;
	
	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}
	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}
	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	/**
	 * @return the normalLow
	 */
	public String getNormalLow() {
		return normalLow;
	}
	/**
	 * @param normalLow the normalLow to set
	 */
	public void setNormalLow(String normalLow) {
		this.normalLow = normalLow;
	}
	/**
	 * @return the normalHigh
	 */
	public String getNormalHigh() {
		return normalHigh;
	}
	/**
	 * @param normalHigh the normalHigh to set
	 */
	public void setNormalHigh(String normalHigh) {
		this.normalHigh = normalHigh;
	}
	/**
	 * @return the uOM
	 */
	public String getUOM() {
		return UOM;
	}
	/**
	 * @param uOM the uOM to set
	 */
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	/**
	 * @return the eventGroupDesc
	 */
	public String getEventGroupDesc() {
		return eventGroupDesc;
	}
	/**
	 * @param eventGroupDesc the eventGroupDesc to set
	 */
	public void setEventGroupDesc(String eventGroupDesc) {
		this.eventGroupDesc = eventGroupDesc;
	}
	/**
	 * @return the histRecType
	 */
	public String getHistRecType() {
		return histRecType;
	}
	/**
	 * @param histRecType the histRecType to set
	 */
	public void setHistRecType(String histRecType) {
		this.histRecType = histRecType;
	}
	/**
	 * @return the currentDiscreteValue
	 */
	public DiscreteValue getCurrentDiscreteValue() {
		return currentDiscreteValue;
	}
	/**
	 * @param currentDiscreteValue the currentDiscreteValue to set
	 */
	public void setCurrentDiscreteValue(DiscreteValue currentDiscreteValue) {
		this.currentDiscreteValue = currentDiscreteValue;
	}
	/**
	 * @Override
	 * Implementing equals because this object will be added to a map in the dao
	 */
	public boolean equals(Object obj) {
		if(obj != null)
		{
			if(obj instanceof String)
			{
				String EventCode = (String)obj;
				if(EventCode.equals(this.eventCode))
				{
					return true;
				}
				else
				{
					return false;
				}
						
			}
			if(obj instanceof DiscreteMeasure)
			{
				DiscreteMeasure oDiscreteMeasure = (DiscreteMeasure)obj;
				if(oDiscreteMeasure.eventCode.equals(this.eventCode))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
		
	}
	
	public int hashCode() {
		return this.eventCode.hashCode();
	}
	/**
	 * @return the criticalHigh
	 */
	public String getCriticalHigh() {
		return criticalHigh;
	}
	/**
	 * @param criticalHigh the criticalHigh to set
	 */
	public void setCriticalHigh(String criticalHigh) {
		this.criticalHigh = criticalHigh;
	}
	/**
	 * @return the criticalLow
	 */
	public String getCriticalLow() {
		return criticalLow;
	}
	/**
	 * @param criticalLow the criticalLow to set
	 */
	public void setCriticalLow(String criticalLow) {
		this.criticalLow = criticalLow;
	}
	public NormalcyIndicator getNormalcyIndicator(DiscreteValue oDiscreteValue,String legendType)
	{
		NormalcyIndicator oNormalcyIndicator = new NormalcyIndicator();
		oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NODATA_ICON);
		try
		{
			if(oDiscreteValue != null && legendType != null)
			{
				if(legendType.equals(""))
				{
					legendType = "S";
				}
				if(oDiscreteValue.getColorCellIndicator() != null && !oDiscreteValue.getColorCellIndicator().equals("") && !oDiscreteValue.getColorCellIndicator().equalsIgnoreCase("NONE"))
				{
					oNormalcyIndicator.setLegendType(legendType);
					oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
					oNormalcyIndicator.setSymbolIndicator(oDiscreteValue.getSymbolLegend());
					oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
				}
				else
				{
					if(oDiscreteValue.getNormalIndicator() != null && oDiscreteValue.getNormalIndicator().equals(".") )
					{
						oNormalcyIndicator.setLegendType(legendType);
						oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
						oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NORMAL_ICON);
						oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
					}
					else if(this.normalLow != null && !this.normalLow.equals("") && this.normalHigh != null && !this.normalHigh.equals(""))
					{
						if(oDiscreteValue.getResultNumber() > 0)
						{
							if(oDiscreteValue.getResultNumber() >= Double.parseDouble(this.normalLow.trim()) && oDiscreteValue.getResultNumber() <= Double.parseDouble(this.normalHigh.trim()))
							{
								oNormalcyIndicator.setLegendType(legendType);
								oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
								oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NORMAL_ICON);
								oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
							}
						}
					}
					else if(this.normalLow != null && !this.normalLow.equals("") && this.normalHigh != null && this.normalHigh.equals(""))
					{
						if(oDiscreteValue.getResultNumber() > 0)
						{
							if(oDiscreteValue.getResultNumber() >= Double.parseDouble(this.normalLow.trim()))
							{
								oNormalcyIndicator.setLegendType(legendType);
								oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
								oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NORMAL_ICON);
								oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
							}
						}
					}
					else if(this.normalLow != null && this.normalLow.equals("") && this.normalHigh != null && !this.normalHigh.equals(""))
					{
						if(oDiscreteValue.getResultNumber() > 0)
						{
							if(oDiscreteValue.getResultNumber() <= Double.parseDouble(this.normalHigh.trim()))
							{
								oNormalcyIndicator.setLegendType(legendType);
								oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
								oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NORMAL_ICON);
								oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
							}
						}
					}
					else
					{
						oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NODATA_ICON);
						oNormalcyIndicator.setNormalcyIndicator(oDiscreteValue.getNormalIndicator());
						oNormalcyIndicator.setLegendType(legendType);
						oNormalcyIndicator.setColorCellIndicator(oDiscreteValue.getColorCellIndicator());
						
					}
					
				}
				
			}
			else
			{
				oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NODATA_ICON);
			}
		}
		catch(Exception e)
		{
			oNormalcyIndicator.setSymbolIndicator(LocalizationConstants.NODATA_ICON);
		}
		finally
		{
			
		}
		return oNormalcyIndicator;
	}
	
	
}
