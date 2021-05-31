# Sub Library
#### Create
```bash
POST http://localhost:8080/sub-libraries
Content-Type: application/json

{
"name": "Sub Library 2",
"subject": "Subject 2"
}
```

#### Search By Subject
```bash
GET http://localhost:8080/sub-libraries?subject=Subject
Accept: application/json
```

#### Update
```bash
PUT http://localhost:8080/sub-libraries/1
Content-Type: application/json

{
    "name": "Sub Library 2",
    "subject": "Subject 2"
}
```

#### Delete
```bash
DELETE http://localhost:8080/sub-libraries/1
Content-Type: application/json
```

# Book
#### Create
```bash
POST http://localhost:8080/books
Content-Type: application/json

{
    "name": "Book 2",
    "creation": "02/01/2000"
}
```

#### Search By Name
```bash
GET http://localhost:8080/books/name?name=Book
Accept: application/json
```

#### Search By Created Date
```bash
GET http://localhost:8080/books/created-date?date=02/01/2000
Accept: application/json
```

#### Update
```bash
PUT http://localhost:8080/books/1
Content-Type: application/json
{
    "name": "Book 2",
    "creation": "02/01/2000"
}
```

#### Delete
```bash
DELETE http://localhost:8080/books/1
Content-Type: application/json
```

# Author
#### Create
```bash
POST http://localhost:8080/authors
Content-Type: application/json
{
    "name": "Author 1",
    "academicCredentials": "Academic Credentials 1",
    "subLibrary": {
      "id": 1
    },
    "books": [
        {
          "id": 1
        }
    ]
}
```

#### Search By Name
```bash
GET http://localhost:8080/authors?name=Author
Accept: application/json
```

#### Search By Academic Credentials
```bash
GET http://localhost:8080/authors/academicCredentials?academicCredentials=Academic Credentials
Accept: application/json
```
#### Update
```bash
PUT http://localhost:8080/authors/1
Content-Type: application/json
{
    "name": "Author 1",
    "academicCredentials": "Academic Credentials 1",
    "subLibrary": {
      "id": 1
    },
    "books": [
        {
          "id": 1
        }
    ]
}
```

#### Delete
```bash
DELETE http://localhost:8080/authors/1
Content-Type: application/json
```