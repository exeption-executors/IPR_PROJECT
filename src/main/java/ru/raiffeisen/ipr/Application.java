package ru.raiffeisen.ipr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PlanService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories()
@EntityScan()
//@ComponentScan(basePackages = "ru.raiffeisen.ipr")
public class Application {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        /**-------- Operation with ClientService --------**/

        ClientService clientService = context.getBean(ClientService.class);

        /** CreateClient function **/
//        clientService.deleteClientByEmail("123@mail.ru");
//        clientService.insertClient("Mark", "Bryzgalov","marik33409@mail.ru", "passss", false);
//        clientService.insertClient("Andrey", "Levkin", "Andrey@mail.ru", "anrewpass", false);
//        clientService.insertClient("Evgeny", "Davidov", "evgen@mail.ru","evgenpass",false);

        /** FindClientByName function **/
//        Client client = clientService.findByName("Andrey");
//        System.out.println("ID Клиента: "+ client.getId() +" Почта клиента: " + client.getEmail());

        /** DeleteClientByEmail function **/
//        clientService.deleteClientByEmail("Andrey@mail.ru");

        /** GetListOfAllClients function **/
//        List<Client> clients = clientService.getAll();
//        for (int i = 0; i < clients.size(); i++) {
//            System.out.println(clients.get(i).getName()+ " " + clients.get(i).getSurname() + " " + clients.get(i).getEmail());
//        }

        /** DeleteClientById function **/
//        clientService.deleteClientById(1l);

        /** FindClientByEmail function **/
//        Client client = clientService.findByEmail("marik33409@mail.ru");
//        System.out.println(client.getName() + " " + client.getSurname());

        /** EditClientInformation function **/
//        clientService.updateClient("Andrew", "Levkin",
//                "andrew@mail.ru", "newpass",false, (3l));
/**----------- Operation with PlanService ---------**/

        PlanService planService = context.getBean(PlanService.class);

        /** CreatePlan function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateStart = dateFormat.parse("17/07/1989");
//        Date dateEnd = dateFormat.parse("20/03/2020");
//        planService.createPlan(1l, new java.sql.Date(dateStart.getTime()), new java.sql.Date(dateEnd.getTime()));

        /** DeletePlanById function **/
        //        planService.deletePlanById(1l);

        /** EditPlanInformation function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateStart = dateFormat.parse("11/11/1111");
//        Date dateEnd = dateFormat.parse("22/22/2222");
//        planService.updatePlan(new java.sql.Date(dateStart.getTime()),new java.sql.Date(dateEnd.getTime()),4l);

        /** CreateSection function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateSectionEnd = dateFormat.parse("15/15/1515");
//        planService.createSection(4l, new java.sql.Date(dateSectionEnd.getTime()), "Cover code by test", "High");

        /** DeleteSectionById function **/
//        planService.deleteSectionById(2l);

        /** EditSectionInformation function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateSectionEnd = dateFormat.parse("15/15/1515");
//        planService.updateSection(new java.sql.Date(dateSectionEnd.getTime()), "Refactoring", "Low", 3l);

        /** CreateTaskList function **/
//        planService.createTaskList(3l,true, "Рассмешить Марка");

        /** DeleteTaskListById **/
//        planService.deleteTaskList(1l);

        /** EditTaskList function **/
//        planService.updateTaskList(false, "Заствить Марка работать", 2l);

        /** TestTestTest **/
    }
}
