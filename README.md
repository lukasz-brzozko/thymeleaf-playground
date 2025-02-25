# Thymeleaf Playground

This is a simple Thymeleaf playground using Spring Boot.

https://github.com/user-attachments/assets/e185f666-e374-45bb-bac8-87e5b040c237

## Prerequisites

- Docker
- Docker Compose

## Running the Project

1. **Clone the repository:**

   ```sh
   git clone https://github.com/lukasz-brzozko/thymeleaf-playground.git
   cd thymeleaf-playground
   ```

2. **Build and run the project using Docker Compose:**

   ```sh
   docker-compose up --build
   ```

   If the image was built already:

   ```sh
   docker-compose up
   ```

3. **Access the application:**

   Open your web browser and navigate to [http://localhost:8080](http://localhost:8080).

## Project Structure

- `Dockerfile`: Defines the Docker image for the application.
- `docker-compose.yml`: Defines the Docker services for the application.
- `pom.xml`: Maven configuration file.
- `ThymeleafPlaygroundApplication.java`: Main application file.
- `application.properties`: Application properties file.
- `index.html`: Thymeleaf template file.

## Endpoints

### POST /render

Renders a Thymeleaf template with the provided variables.

#### Example Request

```sh
curl -X POST http://localhost:8080/render \
  -H "Content-Type: application/json" \
  -d '{
        "template": "<tr th:if=\"${customer.anonymous}\"><td>Hi, [(${customer.name})]</td></tr>",
        "variables": {
          "customer": {
            "anonymous": true,
            "name": "Mike"
          }
        }
      }'
```

## License

This project is licensed under the MIT License.
