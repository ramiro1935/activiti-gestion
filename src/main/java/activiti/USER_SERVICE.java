package activiti;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.activiti.engine.identity.*;

public class USER_SERVICE {

	private static ProcessEngine processEngine;
	private static IdentityService identityService;

	public static long isUser(String id){
		processEngine = ProcessEngineConfiguration
		.createStandaloneProcessEngineConfiguration()
		.setJdbcDriver("com.mysql.jdbc.Driver")
		.setJdbcUrl("jdbc:mysql://192.168.56.100:3306/activiti")
		.setJdbcPassword("root").setJdbcUsername("root")
		.buildProcessEngine();
		identityService = processEngine.getIdentityService();
		return 	identityService.createUserQuery().userId(id).count();
	}
}
