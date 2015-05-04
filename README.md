# JsonParser
This application uses the simple-json-1.1.1.jar library from google to read, parse and write the Json. It will parse following formatted Json

<code>
[
{
    "id": 1,
    "name": "University of North Carolina at Chapel Hill",
    "state": "North Carolina",
    "score": 100
  },
  {
    "id": 2,
    "name": "Harvard University",
    "state": "Massachusetts",
    "score": 100
  },
  {
    "id": 3,
    "name": "Vassar College",
    "state": "New York",
    "score": 75
  }
  ]
</code>

to the following format

<code>
[{
	"schools": {
		"1": {
			"id": 1,
			"name": "University of North Carolina at Chapel Hill",
			"state": "North Carolina",
			"score": 100,
		},
		"2": {
			"id": 2,
      "name": "Harvard University",
      "state": "Massachusetts",
      "score": 100
		},
		"3": {
			"id": 3,
      "name": "Vassar College",
      "state": "New York",
      "score": 75
		}
}]
</code>
