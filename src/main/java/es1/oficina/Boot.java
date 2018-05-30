package es1.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);

   }

   @GetMapping("/")
   @ResponseBody
   public String home()
   {
      return "home";
   }
}
