package cs.school.noza;

import java.util.List;

public interface FetchDataListener  {
	public void onFetchFailure(String msg);
	public void onFetchComplete(List<Application> apps);
}

