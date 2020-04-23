import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public MergingMeetingTimes{

/** Meeting class ************************************************************/
  public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
/*****************************************************************************/
/** Solution *****************************************************************/
	public static List<Meeting> Solution(List<Meeting> meetingTimes){

		if(meetingTimes == null)
			return null;

		List<Meeting> result = new LinkedList<>();

/** Solution 1 using boolean[] ***********************************************/
		boolean[] time = new[48];
		Arrays.fill(time, false);

		for(int i=0; i < meetingTimes.size(); i++){
			int begTime = meetingTimes.get(i).getStartTime();
			int endTime = meetingTimes.get(i).getEndTime();

			Arrays.fill(time, begTime, endTime+1, true)
		}

		for(int i=0; i < time.size(); ){
			if(time[i] == true){
				int begIndex = i;
				int endIndex = i;
				i++;
				while(time[i]==true){
					endIndex++;
					i++;
				}
				result.add(new Meeting(begIndex, endIndex));
			}
			i++;
		}
/*****************************************************************************/
/** Solution 2  **************************************************************/
		List<Meeting> sortedList = new LinkeList<>();
		for(Meeting tempMeeting : meetingTimes){
			sortedList.add(new Meeting(tempMeeting.getStartTime(), tempMeeting.getEndTime()));
		}

	/** Anonymous inner class implements Comparator interface **/
		Collections.sort(sortedList, new Comparator<Meeting>){
			@Override
			public int compare(Meeting m1, Meeting m2){
				return m1.getStartTime() - m2.getEndTime();
			}
		}):

		result.add(sortedList.get(0));

		for(Meeting currentMeeting : sortedList){
			Meeting lastMeeting = result.get(result.size()-1);

			/** if current meeting overlaps with the last meeting,
			use later end time of both **/
			if(currentMeeting.getStartTime() <= lastMeeting.getEndTime()){
				lastMeeting.setEndTime(Math.max(lastMeeting.getEndTime(), currentMeeting.getEndTime()));

			}
			else
				result.add(currentMeeting);
		}

/*****************************************************************************/
		return result;
	}
/*****************************************************************************/
	public static void main(String[] args){

	}
}
