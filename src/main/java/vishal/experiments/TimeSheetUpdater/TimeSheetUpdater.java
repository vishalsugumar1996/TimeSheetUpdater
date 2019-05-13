package vishal.experiments.TimeSheetUpdater;

import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.internal.Transport;

/**
 * Hello world!
 *
 */
public class TimeSheetUpdater 
{
	static RedmineManager manager;
	static Transport transport;
	public static void main( String[] args )
	{
		String uri = "https://agile.sysvine.com";
		String apiAccessKey = "dedec61747ff75fefc3c318207e39d65bcd847d1";
		manager = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
		manager.setObjectsPerPage(100);
		transport = manager.getTransport();
		TimeUpdater updater = new TimeUpdater();
		try {
			updater.createTimeEnteries();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
