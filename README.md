# QuizAppAPIs

A simple RESTful Quiz Application built using Spring Boot. The app allows users to answer random questions in a quiz session, submit their answers, and receive a summary of their performance. Questions can also be added dynamically.

## Features
- Add new quiz questions.
- Start a quiz session for a user.
- Fetch random questions during the quiz.
- Submit answers for validation.
- Get a summary of the quiz session.

---

## API Endpoints

### 1. Add a Question
- **URL**: `/postquestion`
- **Method**: `POST`
- **Body Example**:
  - question: "What is the capital of France?"
  - optionA: "Madrid"
  - optionB: "Berlin"
  - optionC: "Paris"
  - optionD: "Rome"
  - correctAnswer: "C"

---

### 2. Start a Quiz
- **URL**: `/start`
- **Method**: `POST`
- **Query Parameters**:
  - `userId` (String): The ID of the user starting the quiz.

---

### 3. Fetch a Random Question
- **URL**: `/question`
- **Method**: `GET`
- **Query Parameters**:
  - `sessionId` (Long): The session ID of the ongoing quiz.

---

### 4. Submit an Answer
- **URL**: `/answer`
- **Method**: `POST`
- **Query Parameters**:
  - `sessionId` (Long): The ID of the quiz session.
  - `questionId` (Long): The ID of the question.
  - `answer` (String): The selected answer (e.g., A, B, etc.).

---

### 5. Get Quiz Summary
- **URL**: `/summary`
- **Method**: `GET`
- **Query Parameters**:
  - `sessionId` (Long): The session ID of the completed quiz.

---

## Technologies Used
- Java 17
- Spring Boot 3.x
- Hibernate (JPA)
- H2 Database (in-memory, configurable)
- Maven
- Postman (for API testing)

---

## Setup Instructions

### Prerequisites
- Java 17 or later
- Maven 3.4
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Postman (for API testing)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/quiz-application.git
   cd quiz-application

## Testing the Application

### Using Postman
Open Postman and create a new collection.

Example URLs to test the application using Postman:

1. **Add a Question**  
   `http://localhost:9000/postquestion`  
   - Method: POST  
   - Body Example:  
     ```json
     {
       "question": "What is the capital of France?",
       "optionA": "Madrid",
       "optionB": "Berlin",
       "optionC": "Paris",
       "optionD": "Rome",
       "correctAnswer": "C"
     }
     ```

2. **Start a Quiz**  
   `http://localhost:9000/start?userId=12345`  
   - Method: POST  

3. **Fetch a Random Question**  
   `http://localhost:9000/question?sessionId=1`  
   - Method: GET  

4. **Submit an Answer**  
   `http://localhost:9000/answer?sessionId=1&questionId=1&answer=C`  
   - Method: POST  

5. **Get Quiz Summary**  
   `http://localhost:9000/summary?sessionId=1`  
   - Method: GET
   - **Example**:
  ```json
  {
    "totalQuestions": 2,
    "correctAnswers": 2,
    "incorrectAnswers": 0,
    "answeredQuestionIds": [2, 1]
  }
