package vishal.experiments.TimeSheetUpdater;

import java.util.List;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.TimeEntry;

public class TimeUpdater {
	private TimeEntry timeUpdateManager;

	public void createTimeEnteries() {
		timeUpdateManager = new TimeEntry(TimeSheetUpdater.transport);
		Issue issueObj = new Issue();
		List<com.taskadapter.redmineapi.bean.Issue> Issues = issueObj.getIssues();
		if(Issues!=null) {
			for(com.taskadapter.redmineapi.bean.Issue issue:Issues) {
				float hours = getHours(Issues.size());
				try {
					timeUpdateManager
					.setIssueId(issue.getId()).setActivityId(12).setComment("Testing").setHours(hours).create();
					System.out.println("Updated "+hours+" hours for"+" ticket:- #"+issue.getId()+" - "+issue.getSubject()+"\n");
				} catch (RedmineException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	private float getHours(int totalIssues) {
		float totalTicketsCreated = totalIssues;
		float hoursPerTicket = (float) (9.00/totalTicketsCreated);
		return hoursPerTicket;
	}

}
