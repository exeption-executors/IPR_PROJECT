package application;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import repository.ClientRepository;
import service.ClientService;
import service.PlanService;
import service.impl.ClientServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"entity"})
@ComponentScan(basePackages = "service")
public class Application {
    public static void main(String[] args)throws ParseException {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        /**-------- Operation with ClientService --------**/

//        ClientService clientService = context.getBean(ClientService.class);

        /** CreateClient function **/
//        clientService.insertClient("Mark", "Bryzgalov","marik33409@mail.ru", false);
//        clientService.insertClient("Andrey", "Levkin", "Andrey@mail.ru", false);
//        clientService.insertClient("Evgeny", "Davidov", "evgen@mail.ru",false);

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
//        clientService.deleteClientById((long) 1);

        /** FindClientByEmail function **/
//        Client client = clientService.findByEmail("marik33409@mail.ru");
//        System.out.println(client.getName() + " " + client.getSurname());

        /** EditClientInformation function **/
//        clientService.updateClient("Andrew", "Levkin",
//                "andrew@mail.ru", false, (long)2);

        /**----------- Operation with PlanService ---------**/

        PlanService planService = context.getBean(PlanService.class);

        /** CreatePlan function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateStart = dateFormat.parse("17/07/1989");
//        Date dateEnd = dateFormat.parse("20/03/2020");
//        planService.createPlan(5L, new java.sql.Date(dateStart.getTime()), new java.sql.Date(dateEnd.getTime()));

        /** DeletePlanById function **/
/*        planService.deletePlanById((long)2);*/

        /** EditPlanInformation function **/
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateStart = dateFormat.parse("11/11/1111");
//        Date dateEnd = dateFormat.parse("22/22/2222");
//        planService.updatePlan(new java.sql.Date(dateStart.getTime()),new java.sql.Date(dateEnd.getTime()),5l);
    }
}
