/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.healthobject;

/**
 * @author psenthil
 *
 */
public class DateDetailsTimeRange extends NoteDetailsTimeRange{
	public NotesData getDescription()
	{
		NotesData oNotesData = new NotesData();
		oNotesData.setDescription(this.getEventDate());
		oNotesData.setServiceCode(this.getServiceCode());
		oNotesData.setPerformedBy(this.getPerformedBy());
		oNotesData.setStatus(this.getStatus());
		oNotesData.setPrimarySpec(this.getPrimarySpec());
		oNotesData.setEventTime(this.getEventTime());
		oNotesData.setActionType(this.getActionType());
		return oNotesData;
	}

}
