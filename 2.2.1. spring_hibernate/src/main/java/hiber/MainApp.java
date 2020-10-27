package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context =
          new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("KIA", 100);
      Car car2 = new Car("LADA", 200);
      Car car3 = new Car("BMW", 300);

      userService.add(new User("User1", "Lastname1", "user1@mail1.ru", car1 ));
      userService.add(new User("User2", "Lastname2", "user1@mail2.ru", car2 ));
      userService.add(new User("User3", "Lastname3", "user1@mail3.ru", car3 ));


      User neededUser = userService.userByCar("LADA", 200);
      System.out.println("\n" + neededUser + "\n");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car_id = "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}
