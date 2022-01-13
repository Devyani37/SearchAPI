# Search App

It is a Springboot based API service. Provides search functionality to find Artist and Artwork based on various search parameters.

## Prerequisites

- Java 11
- Maven 3

## How to run

- Make sure database is up and running. Follow instruction as given on [Recruitment Coding Assignment readme](../README.md).
- Valiate database is running at http://localhost:5984.
- Go under `SearchApp` folder.
- Run `mvn clean package` to generate an executable jar file. This command will first compile the code and then execute tests.
- Run generated executable jar as `java -jar target/SearchApp-0.0.1-SNAPSHOT.jar`. This will start the SearchApp on `localhost` port `8080`.

## How to Search for Artist and Artwork

### Artist

Artist serach is available at http://localhost:8080/artists. This is a `HTTP GET` api which takes multiple query parameters.

Supported query params are:

- id
- name
- nationality
- gender
- beginYear
- endYear
- wikiQID

An example Artist search request with artist `ConstituentID` looks like as http://localhost:8080/artists?id=10

```bash
curl --location --request GET 'http://localhost:8080/artists?id=10'
```

An example Artist search request with `Nationality` and `Gender` looks like as http://localhost:8080/artists?nationality=American&gender=Female

```bash
curl --location --request GET 'http://localhost:8080/artists?nationality=American&gender=Female'
```

Please note all query params can also be used all at once to search for any Artist. The only requirement is that at least one query parameter must be provided.

### Artwork

Artwork serach is available at http://localhost:8080/artworks. This is a `HTTP GET` api which takes multiple query parameters.

Supported query params are:

- title
- artist
- constituentId
- artistsBio
- nationality
- beginDate
- endDate
- gender
- medium
- creditLine
- accessionNumber
- classification
- objectId

An example Artwork search request with artwork `objectId` looks like as http://localhost:8080/artworks?objectId=5

```bash
curl --location --request GET 'http://localhost:8080/artworks?objectId=5'
```

An example Artwork search request with `Title` and `Artist` looks like as http://localhost:8080/artworks?title=Manhattan&artist=Bernard Tschumi

```bash
curl --location --request GET 'http://localhost:8080/artworks?title=Manhattan&artist=Bernard%20Tschumi'
```

Please note all query params can also be used all at once to search for any Artwork. The only requirement is that at least one query parameter must be provided.

Search APIs also valdiates input data and returns appropriate response e.g `HTTP 400 BAD REQUEST` or  `HTTP 404 NOT FOUND`.

## How to run Tests

Code contains unit and integration tests. They can be executed as `mvn clean test` or via IDE e.g. `IntelliJ`.
