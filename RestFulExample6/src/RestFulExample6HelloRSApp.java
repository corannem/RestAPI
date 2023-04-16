
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("/RestfulExample6HelloAction")
public class RestFulExample6HelloRSApp extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(RestfulExample6HelloAction.class);
		return set;
	}
}
