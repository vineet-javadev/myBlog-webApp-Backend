package com.example.blog_app;

// import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogAppApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file
        // Dotenv dotenv = Dotenv.load();
		SpringApplication.run(BlogAppApplication.class, args);

		System.out.println("\n\nGood to go !\n");
	}

}
