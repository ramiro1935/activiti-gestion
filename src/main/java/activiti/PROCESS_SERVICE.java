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
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.activiti.engine.identity.*;

public class PROCESS_SERVICE {

	private static ProcessEngine processEngine;
	private static IdentityService identityService;

	public void activitiConnection() {
		processEngine = ProcessEngineConfiguration
			.createStandaloneProcessEngineConfiguration()
			.setJdbcDriver("com.mysql.jdbc.Driver")
			.setJdbcUrl("jdbc:mysql://mail.evelia.unrc.edu.ar:3306/activiti")
			.setJdbcPassword("tetra10").setJdbcUsername("activiti")
			.buildProcessEngine();
			identityService = processEngine.getIdentityService();
		Authentication.setAuthenticatedUserId("kermit");
	}


	public void initProcess(String fecha, String items, String monto){
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance	processInstance = runtimeService.startProcessInstanceByKey("process_con_ciclo");
		System.out.println("identificador de la instancia: "+processInstance);
		
		runtimeService.setVariable(processInstance.getId(),"fecha",fecha);
		runtimeService.setVariable(processInstance.getId(),"items",items);
		runtimeService.setVariable(processInstance.getId(),"monto",monto);				
	}
}
