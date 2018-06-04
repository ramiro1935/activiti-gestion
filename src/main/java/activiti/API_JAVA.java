package activiti;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;

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

public class API_JAVA {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration()
				.setJdbcDriver("com.mysql.jdbc.Driver")
				.setJdbcUrl("jdbc:mysql://192.168.1.199:3306/activiti")
				.setJdbcPassword("root").setJdbcUsername("root")
				.buildProcessEngine();
		
		TaskService taskService = processEngine.getTaskService();
		
		//Obtiene la lista de tareas en donde el grupo 'alumno' es candidato
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("alumno").list();
		
		for(Task task : tasks)
		{
		System.out.println("Tarea disponible para el grupo alumno: " + task.getName());
	    }

		//Obtiene la lista de tareas en donde el usuario 'kermit' estÃ¡ asignado
        List<Task> tasksAs = taskService.createTaskQuery().taskAssignee("kermit").list();
		
		for(Task task : tasksAs)
		{
			System.out.println("Tareas asignadas al usuario kermit: "+task.getName());
			
			/* Vamos a completar una de ellas desde la API*/
			if (task.getName().equals("Contactar Estudiante")){
				System.out.println("Kermit tiene la tarea para completar 'Contactar Estudiante'");
				
				//SI tUVIERA formulario se setea de esta manera:
				/*Map<String, Object> taskVariables = new HashMap<String,Object>();
				taskVariables.put("usuario", "Pedro");
			 
				taskService.complete(task.getId(), taskVariables); */
				
				taskService.complete(task.getId());
				System.out.println("Tarea Completada");
				//taskService.complete(task_kermit.getId());
			}

	    }

		
		//Obtiene las definiciones de modelos cargados de nombre: "RegistrarDatosPersonales"
		List<Task> tasksxInstanceId = taskService.createTaskQuery().processDefinitionKey("RegistrarDatosPersonales").list();
			      //.processInstanceId("67506").list();
		for(Task task : tasksxInstanceId)
		{
		System.out.println("Tareas en espera de Instancias del proceso RegistrarDatosPersonales: " + task.getName());
	    }
		
		
		/*
		RuntimeService runtimeService = processEngine.getRuntimeService();
		List<ProcessInstance> processIn
		stance = runtimeService.processInstanceBusinessKey;
		for(ProcessInstance pinstances : processInstance)
		{
		System.out.println("Instancias de procesos: " + pinstances.getName());
	    }
		*/
		
		
		
    }

}