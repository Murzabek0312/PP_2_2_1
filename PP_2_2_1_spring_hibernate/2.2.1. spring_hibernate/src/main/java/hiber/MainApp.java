package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Petr","Ivanov","petr@gmail.com");
      User user2 = new User("Anton","Petrov","anton@gmail.com");
      User user3 = new User("Vova","Sidorov","vova@gmail.com");
      Car Mersedes = new Car("Mersedec",550);
      Car BMW = new Car("BMW",350);
      Car Lada = new Car("Lada",2107);
      user1.setCar(Mersedes);
      user2.setCar(BMW);
      user3.setCar(Mersedes);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println("найден юзер: "+ userService.getUserByCar("Mersedec",550));
      context.close();
   }
}
