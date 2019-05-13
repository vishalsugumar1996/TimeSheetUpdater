package vishal.experiments.TimeSheetUpdater;

import java.util.List;
import com.taskadapter.redmineapi.Params;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.internal.ResultsWrapper;

public class Issue {
	private ResultsWrapper<com.taskadapter.redmineapi.bean.Issue> result = null;

	private Params getSearchParams() {
		Params searchParams = new Params().add("set_filter", "1")
				.add("f[]", "created_on")
				.add("op[created_on]", "=")
				.add("v[created_on][]", "2019-05-13")
				.add("f[]", "author_id")
				.add("op[author_id]", "=")
				.add("v[author_id][]", "me");
		return searchParams;

	}

	public List<com.taskadapter.redmineapi.bean.Issue> getIssues() {

		try {
			result = TimeSheetUpdater.manager.getIssueManager().getIssues(getSearchParams());
		} catch (RedmineException e) {
			e.printStackTrace();
			return null;
		}

		if(result.hasSomeResults()) {
			List<com.taskadapter.redmineapi.bean.Issue> issues = result.getResults();
			return issues;
		}
		else {
			System.out.println("No issues found for the selected date");
		}
		return null;
		
	}

}
