# Use an official OpenJDK 17 image as a base (latest LTS version)
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the application code
COPY . .

# Build the application
RUN mvn clean package -Dmaven.javadoc.skip=true

# Expose the port the application will use
EXPOSE 8082

# Run the command to start the application
CMD ["java", "-jar", "target/blog_app.jar"]