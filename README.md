Recruitment Coding Assignment
=============================

Instructions
------------

Given the MoMa artist and artwork datasets provided in this repo* you are to create one of the following small applications.

*- The data comes from here https://github.com/MuseumofModernArt/collection

* Write your solution preferably in JavaScript, Typescript, Java, Kotlin. If you are more comfortable in some other language, check with us
  first.
* Deliver a runnable solution that includes only source code, test code, build scripts and instructions. Please no IDE or build artefacts.
* Solutions can be server-side, client-side, or a combination of both.
* Only use dependencies if you can defend what value they bring to the problem at hand
* Tell us about any problems you had or assumptions you had to make to get the job done.
* A working solution is better than a pretty solution

### Minimum Installation

* Latest version of NodeJs
* access to the internet for downloading dependencies

Provided
--------

* Copies of the `Artist.json` and `Artwork.json` files
* A script to load the data into an instance of pouchDb
* life-cycle scripts (in `package.json`) to start/stop/load the data

### Life-cycle actions

To start everything

```shell
npm install  ## only run this command once
npm start
```

Start will unpack the zip file, start the server, and load the data. Note that there are ~15k artists and ~130k artworks getting loaded by
default.

You can limit the amount of data loaded. For example running the command below (after having run `start`) will load the first 300 artists
and only the artworks by those artists.

```shell
npm run load-data -- --max-artists=300
```

You can run this command without restarting the database process. Note that `load-data` will remove all data in the `artists` and `artworks`
database before loading the data.

Use the following command to stop everything:

```shell
npm run destroy
```

This will stop the server and delete ALL temporary files (unpacked json files, database files).

If you only want to stop the database thenuse the following command:

```shell
npm run stop

```

And use this command to restart the database

```shell
npm run start-db

```

### Accessing the Data

The database is an instance of PouchDB (which is a Javascript implementation of CouchDB).

Accessing documents by id:
```shell
curl -H "Accept: application/json" \
http://localhost:5984/artists/1 
```

Finding by property:
```shell
curl -X POST \
-H "Accept: application/json" \
-H "Content-Type: application/json" \
-d '{"selector": {"DisplayName": {"$eq": "Pablo Picasso"}}}' \
http://localhost:5984/artists/_find 
```

Composing Complex searches:
```shell
curl -X POST \
-H "Accept: application/json" \
-H "Content-Type: application/json" \ 
-d '{ "selector": { "$and": [ {"Title": {"$regex": ".*Peace.*"}}, {"Date": {"$in": ["1955", "1956"]}}, {"ConstituentID": {"$elemMatch": {"$eq": 4609}}} ] } }' \
http://localhost:5984/artworks/_find
```

Here is the JSON document from above:
```json
{
    "selector": {
        "$and": [
            {"Title": {"$regex": ".*Peace.*"}},
            {"Date": {"$in": ["1955", "1956"]}},
            {"ConstituentID": {"$elemMatch": {"$eq": 4609}}}
        ]
    }
}
```

The Task
-----
Below are three assignments. Implement **ONLY ONE** of them. They can all be implemented as a pure backend or a pure frontend solution. Your
approach will depend on the role you are applying for.

### Search

Create a simple application (web or command-line based) that will do a full text search through either of the data sets.

### Visualization

Create

### Report

Process one of the two files to produce a report


How We Evaluate
---------------

* We want to see how you approach software development
* We want to see how you solve problems
* We will likely use this coding assignment as a discussion piece in later parts of the interview process
