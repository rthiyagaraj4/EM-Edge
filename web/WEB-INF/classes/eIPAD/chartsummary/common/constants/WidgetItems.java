/**
 * 
 */
package eIPAD.chartsummary.common.constants;

/**
 * @author SaraswathiR
 *
 */
public enum WidgetItems {
	VITALS("VITALS"),
	ALLERGY("ALLERGY"),
	PROCEDURE("PROCEDURE"),
	PROBLEMS("PROBLEMS"),
	NOTES("NOTES"),
	RESULTS("RESULTS"),
	PENDINGORDERS("PENDINGORDERS"),
	MEDICATIONS("MEDICATIONS");
	private String widgetId;
	WidgetItems(String widgetId){
		this.widgetId = widgetId;
	}
	public String getWidgetId(){
		return widgetId;
	}
	
	public static void main(String args[]){
		WidgetItems a[] = WidgetItems.values();
		System.out.println(WidgetItems.values());
		//System.out.println(valueOf(WidgetItems.WID_ALLERGY));
		
	}
	
	/*public static final String WID_VITALS ="VITALS";
	public static final String WID_ALLERGY ="ALLERGY";
	public static final String WID_PROCEDURE ="PROCEDURE";
	public static final String WID_PROBLEMS ="PROBLEMS";
	public static final String WID_NOTES ="NOTES";
	public static final String WID_RESULTS ="RESULTS";
	public static final String WID_PENDINGORDERS ="PENDINGORDERS";
	public static final String WID_MEDICATIONS ="MEDICATIONS";*/
}
